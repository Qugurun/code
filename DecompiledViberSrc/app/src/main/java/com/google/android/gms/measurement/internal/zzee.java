package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzee
  implements Runnable
{
  zzee(zzeb paramzzeb, zzk paramzzk)
  {
  }

  public final void run()
  {
    zzaj localzzaj = zzeb.zzd(this.zzasl);
    if (localzzaj == null)
    {
      this.zzasl.zzgt().zzjg().zzby("Failed to reset data on the service; null service");
      return;
    }
    try
    {
      localzzaj.zzd(this.zzaqn);
      zzeb.zze(this.zzasl);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        this.zzasl.zzgt().zzjg().zzg("Failed to reset data on the service", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzee
 * JD-Core Version:    0.6.2
 */