package com.google.android.gms.dynamite;

import android.content.Context;

final class zzc
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.zzb zza(Context paramContext, String paramString, DynamiteModule.VersionPolicy.zza paramzza)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.zzb localzzb = new DynamiteModule.VersionPolicy.zzb();
    localzzb.zziq = paramzza.getLocalVersion(paramContext, paramString);
    if (localzzb.zziq != 0)
      localzzb.zzis = -1;
    do
    {
      return localzzb;
      localzzb.zzir = paramzza.zza(paramContext, paramString, true);
    }
    while (localzzb.zzir == 0);
    localzzb.zzis = 1;
    return localzzb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamite.zzc
 * JD-Core Version:    0.6.2
 */