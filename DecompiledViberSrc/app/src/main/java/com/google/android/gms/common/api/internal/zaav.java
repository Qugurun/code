package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public final class zaav
  implements zabd
{
  private final zabe zafs;

  public zaav(zabe paramzabe)
  {
    this.zafs = paramzabe;
  }

  public final void begin()
  {
    Iterator localIterator = this.zafs.zagy.values().iterator();
    while (localIterator.hasNext())
      ((Api.Client)localIterator.next()).disconnect();
    this.zafs.zaed.zagz = Collections.emptySet();
  }

  public final void connect()
  {
    this.zafs.zaaz();
  }

  public final boolean disconnect()
  {
    return true;
  }

  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    this.zafs.zaed.zafb.add(paramT);
    return paramT;
  }

  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }

  public final void onConnected(Bundle paramBundle)
  {
  }

  public final void onConnectionSuspended(int paramInt)
  {
  }

  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaav
 * JD-Core Version:    0.6.2
 */