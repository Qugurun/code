package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbmr
  implements zzdth<Set<zzbuy<zzbrv>>>
{
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzbmm> zzfgl;
  private final zzdtt<JSONObject> zzfgm;

  private zzbmr(zzdtt<zzbmm> paramzzdtt, zzdtt<Executor> paramzzdtt1, zzdtt<JSONObject> paramzzdtt2)
  {
    this.zzfgl = paramzzdtt;
    this.zzfgg = paramzzdtt1;
    this.zzfgm = paramzzdtt2;
  }

  public static zzbmr zzb(zzdtt<zzbmm> paramzzdtt, zzdtt<Executor> paramzzdtt1, zzdtt<JSONObject> paramzzdtt2)
  {
    return new zzbmr(paramzzdtt, paramzzdtt1, paramzzdtt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmr
 * JD-Core Version:    0.6.2
 */