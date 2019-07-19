package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameMetricsAggregator
{
  public static final int ANIMATION_DURATION = 256;
  public static final int ANIMATION_INDEX = 8;
  public static final int COMMAND_DURATION = 32;
  public static final int COMMAND_INDEX = 5;
  private static final boolean DBG = false;
  public static final int DELAY_DURATION = 128;
  public static final int DELAY_INDEX = 7;
  public static final int DRAW_DURATION = 8;
  public static final int DRAW_INDEX = 3;
  public static final int EVERY_DURATION = 511;
  public static final int INPUT_DURATION = 2;
  public static final int INPUT_INDEX = 1;
  private static final int LAST_INDEX = 8;
  public static final int LAYOUT_MEASURE_DURATION = 4;
  public static final int LAYOUT_MEASURE_INDEX = 2;
  public static final int SWAP_DURATION = 64;
  public static final int SWAP_INDEX = 6;
  public static final int SYNC_DURATION = 16;
  public static final int SYNC_INDEX = 4;
  private static final String TAG = "FrameMetrics";
  public static final int TOTAL_DURATION = 1;
  public static final int TOTAL_INDEX;
  private FrameMetricsBaseImpl mInstance;

  public FrameMetricsAggregator()
  {
    this(1);
  }

  public FrameMetricsAggregator(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mInstance = new FrameMetricsApi24Impl(paramInt);
      return;
    }
    this.mInstance = new FrameMetricsBaseImpl();
  }

  public void add(Activity paramActivity)
  {
    this.mInstance.add(paramActivity);
  }

  public SparseIntArray[] getMetrics()
  {
    return this.mInstance.getMetrics();
  }

  public SparseIntArray[] remove(Activity paramActivity)
  {
    return this.mInstance.remove(paramActivity);
  }

  public SparseIntArray[] reset()
  {
    return this.mInstance.reset();
  }

  public SparseIntArray[] stop()
  {
    return this.mInstance.stop();
  }

  private static class FrameMetricsApi24Impl extends FrameMetricsAggregator.FrameMetricsBaseImpl
  {
    private static final int NANOS_PER_MS = 1000000;
    private static final int NANOS_ROUNDING_VALUE = 500000;
    private static Handler sHandler = null;
    private static HandlerThread sHandlerThread = null;
    private ArrayList<WeakReference<Activity>> mActivities = new ArrayList();
    Window.OnFrameMetricsAvailableListener mListener = new Window.OnFrameMetricsAvailableListener()
    {
      public void onFrameMetricsAvailable(Window paramAnonymousWindow, FrameMetrics paramAnonymousFrameMetrics, int paramAnonymousInt)
      {
        if ((0x1 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[0], paramAnonymousFrameMetrics.getMetric(8));
        if ((0x2 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[1], paramAnonymousFrameMetrics.getMetric(1));
        if ((0x4 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[2], paramAnonymousFrameMetrics.getMetric(3));
        if ((0x8 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[3], paramAnonymousFrameMetrics.getMetric(4));
        if ((0x10 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[4], paramAnonymousFrameMetrics.getMetric(5));
        if ((0x40 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[6], paramAnonymousFrameMetrics.getMetric(7));
        if ((0x20 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[5], paramAnonymousFrameMetrics.getMetric(6));
        if ((0x80 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[7], paramAnonymousFrameMetrics.getMetric(0));
        if ((0x100 & FrameMetricsAggregator.FrameMetricsApi24Impl.this.mTrackingFlags) != 0)
          FrameMetricsAggregator.FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsAggregator.FrameMetricsApi24Impl.this.mMetrics[8], paramAnonymousFrameMetrics.getMetric(2));
      }
    };
    SparseIntArray[] mMetrics = new SparseIntArray[9];
    int mTrackingFlags;

    FrameMetricsApi24Impl(int paramInt)
    {
      this.mTrackingFlags = paramInt;
    }

    public void add(Activity paramActivity)
    {
      if (sHandlerThread == null)
      {
        sHandlerThread = new HandlerThread("FrameMetricsAggregator");
        sHandlerThread.start();
        sHandler = new Handler(sHandlerThread.getLooper());
      }
      for (int i = 0; i <= 8; i++)
        if ((this.mMetrics[i] == null) && ((this.mTrackingFlags & 1 << i) != 0))
          this.mMetrics[i] = new SparseIntArray();
      paramActivity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
      this.mActivities.add(new WeakReference(paramActivity));
    }

    void addDurationItem(SparseIntArray paramSparseIntArray, long paramLong)
    {
      if (paramSparseIntArray != null)
      {
        int i = (int)((500000L + paramLong) / 1000000L);
        if (paramLong >= 0L)
          paramSparseIntArray.put(i, 1 + paramSparseIntArray.get(i));
      }
    }

    public SparseIntArray[] getMetrics()
    {
      return this.mMetrics;
    }

    public SparseIntArray[] remove(Activity paramActivity)
    {
      Iterator localIterator = this.mActivities.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramActivity)
          this.mActivities.remove(localWeakReference);
      }
      paramActivity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
      return this.mMetrics;
    }

    public SparseIntArray[] reset()
    {
      SparseIntArray[] arrayOfSparseIntArray = this.mMetrics;
      this.mMetrics = new SparseIntArray[9];
      return arrayOfSparseIntArray;
    }

    public SparseIntArray[] stop()
    {
      for (int i = -1 + this.mActivities.size(); i >= 0; i--)
      {
        WeakReference localWeakReference = (WeakReference)this.mActivities.get(i);
        Activity localActivity = (Activity)localWeakReference.get();
        if (localWeakReference.get() != null)
        {
          localActivity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
          this.mActivities.remove(i);
        }
      }
      return this.mMetrics;
    }
  }

  private static class FrameMetricsBaseImpl
  {
    public void add(Activity paramActivity)
    {
    }

    public SparseIntArray[] getMetrics()
    {
      return null;
    }

    public SparseIntArray[] remove(Activity paramActivity)
    {
      return null;
    }

    public SparseIntArray[] reset()
    {
      return null;
    }

    public SparseIntArray[] stop()
    {
      return null;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface MetricType
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FrameMetricsAggregator
 * JD-Core Version:    0.6.2
 */