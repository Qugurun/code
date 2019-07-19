package com.google.android.gms.tasks;

public abstract interface Continuation<TResult, TContinuationResult>
{
  public abstract TContinuationResult then(Task<TResult> paramTask)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.Continuation
 * JD-Core Version:    0.6.2
 */