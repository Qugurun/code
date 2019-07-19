package com.facebook.common.logging;

public abstract interface LoggingDelegate
{
  public abstract void d(String paramString1, String paramString2);

  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract void e(String paramString1, String paramString2);

  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract int getMinimumLoggingLevel();

  public abstract void i(String paramString1, String paramString2);

  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract boolean isLoggable(int paramInt);

  public abstract void log(int paramInt, String paramString1, String paramString2);

  public abstract void setMinimumLoggingLevel(int paramInt);

  public abstract void v(String paramString1, String paramString2);

  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract void w(String paramString1, String paramString2);

  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract void wtf(String paramString1, String paramString2);

  public abstract void wtf(String paramString1, String paramString2, Throwable paramThrowable);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.logging.LoggingDelegate
 * JD-Core Version:    0.6.2
 */