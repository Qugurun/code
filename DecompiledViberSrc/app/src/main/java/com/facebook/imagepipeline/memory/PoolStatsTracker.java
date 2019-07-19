package com.facebook.imagepipeline.memory;

public abstract interface PoolStatsTracker
{
  public static final String BUCKETS_USED_PREFIX = "buckets_used_";
  public static final String FREE_BYTES = "free_bytes";
  public static final String FREE_COUNT = "free_count";
  public static final String HARD_CAP = "hard_cap";
  public static final String SOFT_CAP = "soft_cap";
  public static final String USED_BYTES = "used_bytes";
  public static final String USED_COUNT = "used_count";

  public abstract void onAlloc(int paramInt);

  public abstract void onFree(int paramInt);

  public abstract void onHardCapReached();

  public abstract void onSoftCapReached();

  public abstract void onValueRelease(int paramInt);

  public abstract void onValueReuse(int paramInt);

  public abstract void setBasePool(BasePool paramBasePool);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.PoolStatsTracker
 * JD-Core Version:    0.6.2
 */