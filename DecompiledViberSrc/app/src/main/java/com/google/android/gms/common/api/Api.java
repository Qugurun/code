package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final AbstractClientBuilder<?, O> zaau;
  private final zaa<?, O> zaav;
  private final ClientKey<?> zaaw;
  private final zab<?> zaax;

  public <C extends Client> Api(String paramString, AbstractClientBuilder<C, O> paramAbstractClientBuilder, ClientKey<C> paramClientKey)
  {
    Preconditions.checkNotNull(paramAbstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
    Preconditions.checkNotNull(paramClientKey, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.zaau = paramAbstractClientBuilder;
    this.zaav = null;
    this.zaaw = paramClientKey;
    this.zaax = null;
  }

  public final AnyClientKey<?> getClientKey()
  {
    if (this.zaaw != null)
      return this.zaaw;
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }

  public final String getName()
  {
    return this.mName;
  }

  public final BaseClientBuilder<?, O> zah()
  {
    return this.zaau;
  }

  public final AbstractClientBuilder<?, O> zai()
  {
    if (this.zaau != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.zaau;
    }
  }

  @KeepForSdk
  @VisibleForTesting
  public static abstract class AbstractClientBuilder<T extends Api.Client, O> extends Api.BaseClientBuilder<T, O>
  {
    @KeepForSdk
    public abstract T buildClient(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  }

  @KeepForSdk
  public static abstract interface AnyClient
  {
  }

  @KeepForSdk
  public static class AnyClientKey<C extends Api.AnyClient>
  {
  }

  public static abstract interface ApiOptions
  {
    public static abstract interface HasAccountOptions extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {
      public abstract Account getAccount();
    }

    public static abstract interface HasGoogleSignInAccountOptions extends Api.ApiOptions.HasOptions
    {
      public abstract GoogleSignInAccount getGoogleSignInAccount();
    }

    public static abstract interface HasOptions extends Api.ApiOptions
    {
    }

    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {
    }

    public static abstract interface NotRequiredOptions extends Api.ApiOptions
    {
    }

    public static abstract interface Optional extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {
    }
  }

  @KeepForSdk
  @VisibleForTesting
  public static class BaseClientBuilder<T extends Api.AnyClient, O>
  {

    @KeepForSdk
    public static final int API_PRIORITY_GAMES = 1;

    @KeepForSdk
    public static final int API_PRIORITY_OTHER = 2147483647;

    @KeepForSdk
    public static final int API_PRIORITY_PLUS = 2;

    @KeepForSdk
    public List<Scope> getImpliedScopes(O paramO)
    {
      return Collections.emptyList();
    }

    @KeepForSdk
    public int getPriority()
    {
      return 2147483647;
    }
  }

  @KeepForSdk
  public static abstract interface Client extends Api.AnyClient
  {
    @KeepForSdk
    public abstract void connect(BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks);

    @KeepForSdk
    public abstract void disconnect();

    @KeepForSdk
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

    @KeepForSdk
    public abstract Feature[] getAvailableFeatures();

    @KeepForSdk
    public abstract String getEndpointPackageName();

    @KeepForSdk
    public abstract int getMinApkVersion();

    @KeepForSdk
    public abstract void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet);

    @KeepForSdk
    public abstract Feature[] getRequiredFeatures();

    @KeepForSdk
    public abstract IBinder getServiceBrokerBinder();

    @KeepForSdk
    public abstract Intent getSignInIntent();

    @KeepForSdk
    public abstract boolean isConnected();

    @KeepForSdk
    public abstract boolean isConnecting();

    @KeepForSdk
    public abstract void onUserSignOut(BaseGmsClient.SignOutCallbacks paramSignOutCallbacks);

    @KeepForSdk
    public abstract boolean providesSignIn();

    @KeepForSdk
    public abstract boolean requiresAccount();

    @KeepForSdk
    public abstract boolean requiresGooglePlayServices();

    @KeepForSdk
    public abstract boolean requiresSignIn();
  }

  @KeepForSdk
  @VisibleForTesting
  public static final class ClientKey<C extends Api.Client> extends Api.AnyClientKey<C>
  {
  }

  public static abstract interface SimpleClient<T extends IInterface> extends Api.AnyClient
  {
    public abstract T createServiceInterface(IBinder paramIBinder);

    public abstract Context getContext();

    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    public abstract void setState(int paramInt, T paramT);
  }

  @VisibleForTesting
  public static class zaa<T extends Api.SimpleClient, O> extends Api.BaseClientBuilder<T, O>
  {
  }

  @VisibleForTesting
  public static final class zab<C extends Api.SimpleClient> extends Api.AnyClientKey<C>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Api
 * JD-Core Version:    0.6.2
 */