package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzfd extends zzea.zzb
{
  zzfd(zzea.zze paramzze, Activity paramActivity)
  {
    super(paramzze.zzadv);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzafa.zzadv).onActivityDestroyed(ObjectWrapper.wrap(this.val$activity), this.zzaev);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfd
 * JD-Core Version:    0.6.2
 */