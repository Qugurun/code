package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, CloseableReference<CloseableImage>>
{
  private final CacheKeyFactory mCacheKeyFactory;

  public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory paramCacheKeyFactory, Producer paramProducer)
  {
    super(paramProducer);
    this.mCacheKeyFactory = paramCacheKeyFactory;
  }

  public CloseableReference<CloseableImage> cloneOrNull(CloseableReference<CloseableImage> paramCloseableReference)
  {
    return CloseableReference.cloneOrNull(paramCloseableReference);
  }

  protected Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext paramProducerContext)
  {
    return Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(paramProducerContext.getImageRequest(), paramProducerContext.getCallerContext()), paramProducerContext.getLowestPermittedRequestLevel());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer
 * JD-Core Version:    0.6.2
 */