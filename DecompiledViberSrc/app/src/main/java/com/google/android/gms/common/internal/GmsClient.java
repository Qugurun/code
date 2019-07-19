package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;

@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T>
  implements Api.Client, GmsClientEventManager.GmsClientEventState
{
  private final Set<Scope> mScopes;
  private final ClientSettings zaes;
  private final Account zax;

  @KeepForSdk
  @VisibleForTesting
  protected GmsClient(Context paramContext, Handler paramHandler, int paramInt, ClientSettings paramClientSettings)
  {
    this(paramContext, paramHandler, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, null, null);
  }

  @VisibleForTesting
  protected GmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramHandler, paramGmsClientSupervisor, paramGoogleApiAvailability, paramInt, zaa(paramConnectionCallbacks), zaa(paramOnConnectionFailedListener));
    this.zaes = ((ClientSettings)Preconditions.checkNotNull(paramClientSettings));
    this.zax = paramClientSettings.getAccount();
    this.mScopes = zaa(paramClientSettings.getAllRequestedScopes());
  }

  @KeepForSdk
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, null, null);
  }

  @KeepForSdk
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, (GoogleApiClient.ConnectionCallbacks)Preconditions.checkNotNull(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)Preconditions.checkNotNull(paramOnConnectionFailedListener));
  }

  @VisibleForTesting
  protected GmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramGmsClientSupervisor, paramGoogleApiAvailability, paramInt, zaa(paramConnectionCallbacks), zaa(paramOnConnectionFailedListener), paramClientSettings.getRealClientClassName());
    this.zaes = paramClientSettings;
    this.zax = paramClientSettings.getAccount();
    this.mScopes = zaa(paramClientSettings.getAllRequestedScopes());
  }

  private static BaseGmsClient.BaseConnectionCallbacks zaa(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    if (paramConnectionCallbacks == null)
      return null;
    return new zaf(paramConnectionCallbacks);
  }

  private static BaseGmsClient.BaseOnConnectionFailedListener zaa(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramOnConnectionFailedListener == null)
      return null;
    return new zag(paramOnConnectionFailedListener);
  }

  private final Set<Scope> zaa(Set<Scope> paramSet)
  {
    Set localSet = validateScopes(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
      if (!paramSet.contains((Scope)localIterator.next()))
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
    return localSet;
  }

  public final Account getAccount()
  {
    return this.zax;
  }

  @KeepForSdk
  protected final ClientSettings getClientSettings()
  {
    return this.zaes;
  }

  public int getMinApkVersion()
  {
    return super.getMinApkVersion();
  }

  @KeepForSdk
  public Feature[] getRequiredFeatures()
  {
    return new Feature[0];
  }

  protected final Set<Scope> getScopes()
  {
    return this.mScopes;
  }

  @KeepForSdk
  protected Set<Scope> validateScopes(Set<Scope> paramSet)
  {
    return paramSet;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsClient
 * JD-Core Version:    0.6.2
 */