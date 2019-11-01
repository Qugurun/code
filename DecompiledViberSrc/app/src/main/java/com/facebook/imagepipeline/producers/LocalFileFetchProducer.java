package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalFileFetchProducer extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalFileFetchProducer";

  public LocalFileFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
  }

  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    return getEncodedImage(new FileInputStream(paramImageRequest.getSourceFile().toString()), (int)paramImageRequest.getSourceFile().length());
  }

  protected String getProducerName()
  {
    return "LocalFileFetchProducer";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalFileFetchProducer
 * JD-Core Version:    0.6.2
 */