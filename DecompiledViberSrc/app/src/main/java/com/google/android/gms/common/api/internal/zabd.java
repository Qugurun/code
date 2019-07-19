package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;

public abstract interface zabd
{
  public abstract void begin();

  public abstract void connect();

  public abstract boolean disconnect();

  public abstract <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT);

  public abstract <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT);

  public abstract void onConnected(Bundle paramBundle);

  public abstract void onConnectionSuspended(int paramInt);

  public abstract void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zabd
 * JD-Core Version:    0.6.2
 */