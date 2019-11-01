package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzanf extends zzfn
  implements zzane
{
  public zzanf()
  {
    super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 17:
    case 18:
    default:
      return false;
    case 2:
      String str4 = getHeadline();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str4);
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 19:
    case 20:
    case 21:
    case 22:
    }
    while (true)
    {
      return true;
      List localList = getImages();
      paramParcel2.writeNoException();
      paramParcel2.writeList(localList);
      continue;
      String str3 = getBody();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      continue;
      zzaeh localzzaeh = zzrl();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaeh);
      continue;
      String str2 = getCallToAction();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      continue;
      String str1 = getAdvertiser();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      continue;
      recordImpression();
      paramParcel2.writeNoException();
      continue;
      zzt(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zzu(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      boolean bool2 = getOverrideImpressionRecording();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool2);
      continue;
      boolean bool1 = getOverrideClickHandling();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool1);
      continue;
      Bundle localBundle = getExtras();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      zzv(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      IObjectWrapper localIObjectWrapper3 = zzso();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper3);
      continue;
      zzaap localzzaap = getVideoController();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaap);
      continue;
      zzadz localzzadz = zzrj();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzadz);
      continue;
      IObjectWrapper localIObjectWrapper2 = zzsp();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper2);
      continue;
      IObjectWrapper localIObjectWrapper1 = zzrk();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper1);
      continue;
      zzc(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanf
 * JD-Core Version:    0.6.2
 */