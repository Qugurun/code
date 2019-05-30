package mqms.ncp.navercorp.com.testrecordscreencfr;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "test_cfr";

    // for video record
    private long videoStartTime = 0;
    //    public static boolean recordThreadExit = false;
    private MediaCodec videoEncoder;
    private MediaMuxer videoMuxer;
//    private boolean videoMuxerStart = false;
    private Thread videoEncodeThread;
    //    private MediaFormat videoFormat;
//    private int videoEncodeColor;
    private String videoMediaFormatType = MediaFormat.MIMETYPE_VIDEO_AVC;
    private int videoTrackIndex = 0;
    private final int REQUEST_CODE_SCREEN_CAPTURE = 1;
//    private static boolean needRecord = false;
    private boolean recording = false;
    private boolean recordByMediaCodec = true;

    private MediaProjection mediaProjection = null;
    private VirtualDisplay virtualDisplay = null;
    private MediaRecorder mediaRecorder = null;
    private static final String recordVideoFileFullPath = "/sdcard/mqms/tmp/testRecordVideo/testcfr.mp4";

    private int screenCaptureResultCode = 0;
    private Intent screenCaptureData = null;

    @BindView(R.id.btn_test1)
    Button btnTest1;
    @BindView(R.id.btn_test2)
    Button btnTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), REQUEST_CODE_SCREEN_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCREEN_CAPTURE && RESULT_OK == resultCode) {
            Log.d(TAG, "onActivityResult(), screenCaptureResultCode=" + screenCaptureResultCode + ", screenCaptureData=" + screenCaptureData);
            screenCaptureResultCode = resultCode;
            screenCaptureData = data;
        }
    }

    boolean btnProcessing = false;
    @OnClick({R.id.btn_test1, R.id.btn_test2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_test1:
                btnTestClick();
                break;
            case R.id.btn_test2:
                btnTest2Click();
                break;
        }
    }

    private void btnTestClick() {
        if (!btnProcessing) {
            btnProcessing = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(2000);
//                                recordingStartStop();
//                                Thread.sleep(5000);
                        recordingStartStop();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    btnProcessing = false;
                }
            }).start();
        }
    }

    private void recordingStartStop() {
        if (!recording) {
            // start record
            if (recordByMediaCodec) {
                startRecordScreenByMediaCodec();
            } else {
                startRecordScreenByMediaRecorder();
            }
//            recording = true;
        } else {
            // stop record
            if (recordByMediaCodec) {
                stopRecordScreenByMediaCodec();
            } else {
                stopRecordScreenByMediaRecorder();
            }
//            recording = false;
        }
    }

    private void btnTest2Click() {

    }

    public void startRecordScreenByMediaRecorder() {
        WindowManager wm = (WindowManager) MainActivity.this.getSystemService(ContextWrapper.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null == mediaRecorder) {
                mediaRecorder = new MediaRecorder();
            }
            // init media recorder
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.SURFACE);
//                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(recordVideoFileFullPath);
            mediaRecorder.setVideoEncodingBitRate(5 * displayMetrics.widthPixels * displayMetrics.heightPixels);
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
            mediaRecorder.setVideoSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
            mediaRecorder.setVideoFrameRate(60);
            mediaRecorder.setCaptureRate(60);
//                mediaRecorder.setOrientationHint(90);
            try {
                mediaRecorder.prepare();

                MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)MainActivity.this.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
                if (null != mediaProjectionManager) {
                    Log.d(TAG, "startRecordScreenByMediaRecorder(), screenCaptureResultCode=" + screenCaptureResultCode + ", screenCaptureData=" + screenCaptureData);
                    mediaProjection = mediaProjectionManager.getMediaProjection(screenCaptureResultCode, screenCaptureData);
                    if (null != mediaProjection) {
                        virtualDisplay = mediaProjection.createVirtualDisplay("test_vfr",
                                displayMetrics.widthPixels,
                                displayMetrics.heightPixels,
                                displayMetrics.densityDpi,
                                DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC,
                                mediaRecorder.getSurface(), null, null);
                        Log.d(TAG, "startRecordScreenByMediaRecorder(), start record");
                        mediaRecorder.start();
                        recording = true;
                    } else {
                        Log.e(TAG, "startRecordScreenByMediaRecorder(), create MediaProjection failed");
                    }
                } else {
                    Log.e(TAG, "startRecordScreenByMediaRecorder(), get mediaProjectionManager failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "startRecordScreenByMediaRecorder(), MediaRecorder prepare exception, info:" + e.getMessage());
                stopRecordScreenByMediaRecorder();
            }
        } else {
            Log.e(TAG, "startRecordScreenByMediaRecorder(), android version is less than 21, do not record screen");
        }
    }

    private void stopRecordScreenByMediaCodec() {
//        try {
//            videoEncodeThread.join(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        releaseMediaProjection();
        recording = false;
    }

    private void releaseMediaProjection() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != virtualDisplay) {
                virtualDisplay.release();
                virtualDisplay = null;
            }

            if (null != mediaProjection) {
                mediaProjection.stop();
                mediaProjection = null;
            }
        }
    }

    public void stopRecordScreenByMediaRecorder() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != mediaRecorder) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
            }
        }
        releaseMediaProjection();
        recording = false;
    }

    private SurfaceTexture intermediateSurfaceTexture;
    private Surface intermediateSurface;
    private Surface videoEncoderSurface;

    public void initIntermediateSurface() {
        if (null == intermediateSurface) {
            if (null == intermediateSurfaceTexture) {
                intermediateSurfaceTexture = new SurfaceTexture(111, false);
                intermediateSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                    @Override
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        Log.d(TAG, "onFrameAvailable(), entry");
                    }
                });
            }
            intermediateSurface = new Surface(intermediateSurfaceTexture);
        }
    }

    public void initVirtualDisplay() {
        initIntermediateSurface();

        WindowManager wm = (WindowManager) MainActivity.this.getSystemService(ContextWrapper.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)MainActivity.this.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
                if (null != mediaProjectionManager) {
                    Log.d(TAG, "initVirtualDisplay(), screenCaptureResultCode=" + screenCaptureResultCode + ", screenCaptureData=" + screenCaptureData);
                    mediaProjection = mediaProjectionManager.getMediaProjection(screenCaptureResultCode, screenCaptureData);
                    if (null != mediaProjection) {
                        virtualDisplay = mediaProjection.createVirtualDisplay("test_vfr",
//                                displayMetrics.widthPixels,
////                                displayMetrics.heightPixels,
                                720,
                                1280,
                                displayMetrics.densityDpi,
                                DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC,
//                                intermediateSurface,
                                videoEncoderSurface,
                                null, null);
                        Log.d(TAG, "initVirtualDisplay(), start record");
                        recording = true;
                    } else {
                        Log.e(TAG, "initVirtualDisplay(), create MediaProjection failed");
                    }
                } else {
                    Log.e(TAG, "initVirtualDisplay(), get mediaProjectionManager failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "initVirtualDisplay(), MediaRecorder prepare exception, info:" + e.getMessage());
                stopRecordScreenByMediaRecorder();
            }
        } else {
            Log.e(TAG, "initVirtualDisplay(), android version is less than 21, do not record screen");
        }
    }

    public String startRecordScreenByMediaCodec() {
        String result = "success";

        // start record camera data
        result = initMediaEncode();

        // create record video MediaMuxer
        result = initMediaMuxer();

        initVirtualDisplay();

        // start media encodeVideoFrame thread
        startVideoEncodeThread();

        // start write video thread
        startWriteFrameThread();

        return result;
    }

    private String initMediaMuxer() {
        String result = "success";

        try {
//            String playVideoFilePath = startPlayVideoReq.getPlayVideoFullPath();
//            String recordVideoFileFullPath = startPlayVideoReq.getRecordVideoFullPath();
            File recordVideoFile = new File(recordVideoFileFullPath);
            if (recordVideoFile.exists()) {
                recordVideoFile.delete();
            }
            videoMuxer = new MediaMuxer(recordVideoFileFullPath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4);
//            videoMuxer.setOrientationHint(90);
        } catch (IOException e) {
            result = "create media muxer failed, info:" + e.getMessage();
            Log.e(TAG, "initMediaMuxer(), create media muxer failed");
            e.printStackTrace();
        }

        return result;
    }

    private void startVideoEncodeThread() {
        videoEncodeThread = new Thread(new Runnable() {
            @Override
            public void run() {
//                long threadStartTime = System.currentTimeMillis();
//                while (!WaterMarkUtils.startPlayingVideo && System.currentTimeMillis() - threadStartTime < (5 * 60 * 1000)) {
//                    // wait start playing video or 5 minutes
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                // start playing video
//                if (System.currentTimeMillis() - threadStartTime < (5 * 60 * 1000)) {
//                    videoStartTime = System.currentTimeMillis();
                videoEncoder.start();

                while (recording) {
                    encodeVideoFrame();
                }

                videoEncoderSurface.release();
                videoEncoder.stop();
                videoEncoder.release();
//                if (videoMuxerStart) {
//                    videoMuxer.stop();
//                }
                videoMuxer.release();

                videoEncoder = null;
                videoMuxer = null;
//                }
            }
        });
        videoEncodeThread.start();
    }

    private String initMediaEncode() {
        String result = "success";

        try {
            // samsung s8 supported input color format:
            // 0x7f420888 -> COLOR_FormatYUV420Flexible
            // 0x13 -> COLOR_FormatYUV420Planar
            // 0x15 -> COLOR_FormatYUV420SemiPlanar
            // 0x7f000011 -> ????????????????????
            // 0x10 -> COLOR_Format32bitARGB8888
            // 0x7F00A000 -> COLOR_Format32bitABGR8888
            // 0x7f000789 -> COLOR_FormatSurface
            // 0x7f000012 -> ????????????????????

            videoEncoder = MediaCodec.createEncoderByType(videoMediaFormatType);
            // get supported color format
            int colorFormat = 0;
            MediaCodecInfo.CodecCapabilities capabilities = videoEncoder.getCodecInfo().getCapabilitiesForType(videoMediaFormatType);
            for (int i = 0; i < capabilities.colorFormats.length; i++) {
                // record video with COLOR_FormatYUV420Planar, I420
                if (capabilities.colorFormats[i] == MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar) {
                    // 录制视频，media codec的输入数据设置为yuv420p(I420),opencv中处理完成后可以直接转换为该格式
                    colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar;
                    break;
                }
            }
            if (0 == colorFormat) {
                Log.e(TAG, "media codec do not support yuv420p(I420), need support yuv420sp(NV12)");
            }

            MediaFormat inputMediaFormat = MediaFormat.createVideoFormat(videoMediaFormatType, 720, 1280);
            inputMediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 6000 * 1024);
            inputMediaFormat.setFloat(MediaFormat.KEY_FRAME_RATE, 30);
//            inputMediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, colorFormat);
            inputMediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface);
            inputMediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 1);

            videoEncoder.configure(inputMediaFormat, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
            videoEncoderSurface = videoEncoder.createInputSurface();

            // init encoder listener
//            initVideoEncoderListener();

        } catch (IOException e) {
            result = "create media codec failed, info:" + e.getMessage();
            Log.e(TAG, "initMediaEncode(), create media codec failed, info:" + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private void initVideoEncoderListener() {
        // set input/output listener
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            videoEncoder.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() {
                @Override
                public void onFrameRendered(@androidx.annotation.NonNull MediaCodec codec, long presentationTimeUs, long nanoTime) {
                    Log.d(TAG, "onFrameRendered(), entry, presentationTimeUs=" + presentationTimeUs);
                }
            }, null);
        }
//        videoEncoder.setCallback(new MediaCodec.Callback() {
//            @Override
//            public void onInputBufferAvailable(@androidx.annotation.NonNull MediaCodec codec, int index) {
//                Log.d(TAG, "videoEncoder.Callback().onInputBufferAvailable(), entry, index=" + index);
//            }
//
//            @Override
//            public void onOutputBufferAvailable(@androidx.annotation.NonNull MediaCodec codec, int index, @androidx.annotation.NonNull MediaCodec.BufferInfo info) {
//                Log.d(TAG, "videoEncoder.Callback().onOutputBufferAvailable(), entry, index=" + index + ", bufferInfo =" + info);
//            }
//
//            @Override
//            public void onError(@androidx.annotation.NonNull MediaCodec codec, @androidx.annotation.NonNull MediaCodec.CodecException e) {
//                Log.d(TAG, "videoEncoder.Callback().onError(), entry, info:" + e.getMessage());
//            }
//
//            @Override
//            public void onOutputFormatChanged(@androidx.annotation.NonNull MediaCodec codec, @androidx.annotation.NonNull MediaFormat format) {
//                Log.d(TAG, "videoEncoder.Callback().onOutputFormatChanged(), entry, format=" + format);
//            }
//        });
    }

    MediaCodec.BufferInfo lastFrameBufferInfo = null;
    ByteBuffer lastFrameData = null;
    final Object lastFrameDataSync = new Object();
    long lastFrameTimestamp = 0;

    private void startWriteFrameThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lastFrameData = null;
                lastFrameBufferInfo = null;
                Log.d(TAG, "startWriteFrameThread(), entry");
                while (recording) {
                    if (null != videoMuxer && null != lastFrameData) {
                        if (lastFrameTimestamp != lastFrameBufferInfo.presentationTimeUs) {
//                            if (0 == lastFrameTimestamp) {
                                lastFrameTimestamp = lastFrameBufferInfo.presentationTimeUs;
//                            } else {
//                                lastFrameTimestamp += 20000;
//                            }

                            Log.d(TAG, "startWriteFrameThread(), write a sample data, lastFrameBufferInfo.presentationTimeUs=" + lastFrameBufferInfo.presentationTimeUs / 1000);
                            synchronized (lastFrameDataSync) {
                                lastFrameBufferInfo.presentationTimeUs = lastFrameTimestamp;
                                videoMuxer.writeSampleData(videoTrackIndex, lastFrameData, lastFrameBufferInfo);
                                lastFrameTimestamp = lastFrameBufferInfo.presentationTimeUs;
                            }
                        }
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d(TAG, "startWriteFrameThread(), exit");
            }
        }).start();
    }
    private void encodeVideoFrame() {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 20000);
        switch (outputIndex) {
            case MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED:
                Log.d(TAG, "encodeVideoFrame(), INFO_OUTPUT_BUFFERS_CHANGED");
                break;
            case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                MediaFormat outputFormat = videoEncoder.getOutputFormat();
                videoTrackIndex = videoMuxer.addTrack(outputFormat);
                videoMuxer.start();
                Log.d(TAG, "encodeVideoFrame(), videoMuxer.start()");
                break;
            case MediaCodec.INFO_TRY_AGAIN_LATER:
//                Log.d(TAG, "encodeVideoFrame(), dequeueOutputBuffer timed out!");
                break;
            default:
                ByteBuffer outputBuffer;
                while (outputIndex >= 0) {
//                    outputBuffer = videoEncoder.getOutputBuffer(outputIndex);
//                    videoMuxer.writeSampleData(videoTrackIndex, outputBuffer, bufferInfo);
//                    videoEncoder.releaseOutputBuffer(outputIndex, false);
//                    outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 50000);
//
//                    String logInfo = String.format(Locale.getDefault(),", bufferInfo.flags=%d, bufferInfo.offset=%d, bufferInfo.size=%d, bufferInfo.presentationTimeUs=%d",
//                            bufferInfo.flags, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
//                    Log.d(TAG, "encodeVideoFrame(), write a sample video data " + logInfo);



                    /////////////////////////////////////////////////////////////////////////////
                    outputBuffer = videoEncoder.getOutputBuffer(outputIndex);
//                    videoMuxer.writeSampleData(videoTrackIndex, outputBuffer, bufferInfo);



                    String logInfo = String.format(Locale.getDefault(),", bufferInfo.flags=%d, bufferInfo.offset=%d, bufferInfo.size=%d, bufferInfo.presentationTimeUs=%d",
                            bufferInfo.flags, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
                    Log.d(TAG, "encodeVideoFrame(), write a sample video data " + logInfo);

                    if (bufferInfo.flags != MediaCodec.BUFFER_FLAG_CODEC_CONFIG) {
                        Log.d(TAG, "encodeVideoFrame(), record latest frame data, presentationTimeUs=" + bufferInfo.presentationTimeUs / 1000);
//                        lastFrameData = ByteBuffer.allocate(outputBuffer.capacity());
                        synchronized (lastFrameDataSync) {
                            lastFrameBufferInfo = bufferInfo;
//                            lastFrameData = outputBuffer;
                            lastFrameData = ByteBuffer.allocate(outputBuffer.capacity());
                            lastFrameData.put(outputBuffer);
                            lastFrameData.flip();
//                            Log.d(TAG, "encodeVideoFrame(), record latest frame data, lastFrameData=" + ((Object)lastFrameData).hashCode());
                        }
                    }




                    videoEncoder.releaseOutputBuffer(outputIndex, false);
                    outputIndex = videoEncoder.dequeueOutputBuffer(bufferInfo, 50000);

                    /////////////////////////////////////////////////////////////////////////////
                }
                break;
        }
    }

}