package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;

public abstract interface FileCache extends DiskTrimmable
{
  public abstract void clearAll();

  public abstract long clearOldEntries(long paramLong);

  public abstract long getCount();

  public abstract DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException;

  public abstract BinaryResource getResource(CacheKey paramCacheKey);

  public abstract long getSize();

  public abstract boolean hasKey(CacheKey paramCacheKey);

  public abstract boolean hasKeySync(CacheKey paramCacheKey);

  public abstract BinaryResource insert(CacheKey paramCacheKey, WriterCallback paramWriterCallback)
    throws IOException;

  public abstract boolean isEnabled();

  public abstract boolean probe(CacheKey paramCacheKey);

  public abstract void remove(CacheKey paramCacheKey);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.FileCache
 * JD-Core Version:    0.6.2
 */