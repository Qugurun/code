package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzgg
  implements BaseImplementation.ResultHolder<Status>
{
  private final TaskCompletionSource<Boolean> zzes;

  zzgg(TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    this.zzes = paramTaskCompletionSource;
  }

  public final void setFailedResult(Status paramStatus)
  {
    this.zzes.setException(new ApiException(paramStatus));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgg
 * JD-Core Version:    0.6.2
 */