package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;

public final class Common
{

  @KeepForSdk
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Common.API", zapg, CLIENT_KEY);

  @KeepForSdk
  public static final Api.ClientKey<zai> CLIENT_KEY = new Api.ClientKey();
  private static final Api.AbstractClientBuilder<zai, Api.ApiOptions.NoOptions> zapg = new zab();
  public static final zac zaph = new zad();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.service.Common
 * JD-Core Version:    0.6.2
 */