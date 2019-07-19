package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class TaskUtil
{
  @KeepForSdk
  public static void setResultOrApiException(Status paramStatus, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    setResultOrApiException(paramStatus, null, paramTaskCompletionSource);
  }

  @KeepForSdk
  public static <TResult> void setResultOrApiException(Status paramStatus, TResult paramTResult, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    if (paramStatus.isSuccess())
    {
      paramTaskCompletionSource.setResult(paramTResult);
      return;
    }
    paramTaskCompletionSource.setException(new ApiException(paramStatus));
  }

  @Deprecated
  @KeepForSdk
  public static Task<Void> toVoidTaskThatFailsOnFalse(Task<Boolean> paramTask)
  {
    return paramTask.continueWith(new zacl());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.TaskUtil
 * JD-Core Version:    0.6.2
 */