package com.yandex.mobile.ads.mediation.interstitial;

import com.yandex.mobile.ads.impl.au;

final class c
  implements au<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener>
{
  private MediatedInterstitialAdapter a;

  final MediatedInterstitialAdapter a()
  {
    return this.a;
  }

  final boolean b()
  {
    return (this.a != null) && (this.a.isLoaded());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.interstitial.c
 * JD-Core Version:    0.6.2
 */