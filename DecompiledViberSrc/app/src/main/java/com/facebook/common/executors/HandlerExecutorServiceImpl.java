package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class HandlerExecutorServiceImpl extends AbstractExecutorService
  implements HandlerExecutorService
{
  private final Handler mHandler;

  public HandlerExecutorServiceImpl(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }

  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    throw new UnsupportedOperationException();
  }

  public void execute(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }

  public boolean isHandlerThread()
  {
    return Thread.currentThread() == this.mHandler.getLooper().getThread();
  }

  public boolean isShutdown()
  {
    return false;
  }

  public boolean isTerminated()
  {
    return false;
  }

  protected <T> ScheduledFutureImpl<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new ScheduledFutureImpl(this.mHandler, paramRunnable, paramT);
  }

  protected <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> paramCallable)
  {
    return new ScheduledFutureImpl(this.mHandler, paramCallable);
  }

  public void quit()
  {
    this.mHandler.getLooper().quit();
  }

  public ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    ScheduledFutureImpl localScheduledFutureImpl = newTaskFor(paramRunnable, null);
    this.mHandler.postDelayed(localScheduledFutureImpl, paramTimeUnit.toMillis(paramLong));
    return localScheduledFutureImpl;
  }

  public <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    ScheduledFutureImpl localScheduledFutureImpl = newTaskFor(paramCallable);
    this.mHandler.postDelayed(localScheduledFutureImpl, paramTimeUnit.toMillis(paramLong));
    return localScheduledFutureImpl;
  }

  public ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }

  public List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }

  public ScheduledFuture<?> submit(Runnable paramRunnable)
  {
    return submit(paramRunnable, (Void)null);
  }

  public <T> ScheduledFuture<T> submit(Runnable paramRunnable, @Nullable T paramT)
  {
    if (paramRunnable == null)
      throw new NullPointerException();
    ScheduledFutureImpl localScheduledFutureImpl = newTaskFor(paramRunnable, paramT);
    execute(localScheduledFutureImpl);
    return localScheduledFutureImpl;
  }

  public <T> ScheduledFuture<T> submit(Callable<T> paramCallable)
  {
    if (paramCallable == null)
      throw new NullPointerException();
    ScheduledFutureImpl localScheduledFutureImpl = newTaskFor(paramCallable);
    execute(localScheduledFutureImpl);
    return localScheduledFutureImpl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.HandlerExecutorServiceImpl
 * JD-Core Version:    0.6.2
 */