package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;

@Deprecated
public abstract interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends f, SERVER_PARAMETERS extends e> extends b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS>
{
  public abstract View getBannerView();

  public abstract void requestBannerAd(c paramc, Activity paramActivity, SERVER_PARAMETERS paramSERVER_PARAMETERS, com.google.ads.b paramb, a parama, ADDITIONAL_PARAMETERS paramADDITIONAL_PARAMETERS);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationBannerAdapter
 * JD-Core Version:    0.6.2
 */