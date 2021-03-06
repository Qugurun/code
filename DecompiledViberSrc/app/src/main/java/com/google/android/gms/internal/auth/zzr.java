package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzr extends GmsClient<zzc>
{
  public zzr(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 120, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  public final int getMinApkVersion()
  {
    return 12451000;
  }

  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.account.IWorkAccountService";
  }

  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.account.workaccount.START";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzr
 * JD-Core Version:    0.6.2
 */