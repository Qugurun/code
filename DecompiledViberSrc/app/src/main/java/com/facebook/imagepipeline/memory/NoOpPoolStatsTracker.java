package com.facebook.imagepipeline.memory;

public class NoOpPoolStatsTracker
  implements PoolStatsTracker
{
  private static NoOpPoolStatsTracker sInstance = null;

  public static NoOpPoolStatsTracker getInstance()
  {
    try
    {
      if (sInstance == null)
        sInstance = new NoOpPoolStatsTracker();
      NoOpPoolStatsTracker localNoOpPoolStatsTracker = sInstance;
      return localNoOpPoolStatsTracker;
    }
    finally
    {
    }
  }

  public void onAlloc(int paramInt)
  {
  }

  public void onFree(int paramInt)
  {
  }

  public void onHardCapReached()
  {
  }

  public void onSoftCapReached()
  {
  }

  public void onValueRelease(int paramInt)
  {
  }

  public void onValueReuse(int paramInt)
  {
  }

  public void setBasePool(BasePool paramBasePool)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NoOpPoolStatsTracker
 * JD-Core Version:    0.6.2
 */