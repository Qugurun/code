package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

public final class zzy extends zza
  implements zzw
{
  zzy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
  }

  public final int getFillColor()
    throws RemoteException
  {
    Parcel localParcel = zza(12, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final List getHoles()
    throws RemoteException
  {
    Parcel localParcel = zza(6, zza());
    ArrayList localArrayList = zzc.zzb(localParcel);
    localParcel.recycle();
    return localArrayList;
  }

  public final String getId()
    throws RemoteException
  {
    Parcel localParcel = zza(2, zza());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final List<LatLng> getPoints()
    throws RemoteException
  {
    Parcel localParcel = zza(4, zza());
    ArrayList localArrayList = localParcel.createTypedArrayList(LatLng.CREATOR);
    localParcel.recycle();
    return localArrayList;
  }

  public final int getStrokeColor()
    throws RemoteException
  {
    Parcel localParcel = zza(10, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final int getStrokeJointType()
    throws RemoteException
  {
    Parcel localParcel = zza(24, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final List<PatternItem> getStrokePattern()
    throws RemoteException
  {
    Parcel localParcel = zza(26, zza());
    ArrayList localArrayList = localParcel.createTypedArrayList(PatternItem.CREATOR);
    localParcel.recycle();
    return localArrayList;
  }

  public final float getStrokeWidth()
    throws RemoteException
  {
    Parcel localParcel = zza(8, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final float getZIndex()
    throws RemoteException
  {
    Parcel localParcel = zza(14, zza());
    float f = localParcel.readFloat();
    localParcel.recycle();
    return f;
  }

  public final boolean isClickable()
    throws RemoteException
  {
    Parcel localParcel = zza(22, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isGeodesic()
    throws RemoteException
  {
    Parcel localParcel = zza(18, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final boolean isVisible()
    throws RemoteException
  {
    Parcel localParcel = zza(16, zza());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void remove()
    throws RemoteException
  {
    zzb(1, zza());
  }

  public final void setClickable(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(21, localParcel);
  }

  public final void setFillColor(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeInt(paramInt);
    zzb(11, localParcel);
  }

  public final void setGeodesic(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(17, localParcel);
  }

  public final void setHoles(List paramList)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeList(paramList);
    zzb(5, localParcel);
  }

  public final void setPoints(List<LatLng> paramList)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeTypedList(paramList);
    zzb(3, localParcel);
  }

  public final void setStrokeColor(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeInt(paramInt);
    zzb(9, localParcel);
  }

  public final void setStrokeJointType(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeInt(paramInt);
    zzb(23, localParcel);
  }

  public final void setStrokePattern(List<PatternItem> paramList)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeTypedList(paramList);
    zzb(25, localParcel);
  }

  public final void setStrokeWidth(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(7, localParcel);
  }

  public final void setVisible(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.writeBoolean(localParcel, paramBoolean);
    zzb(15, localParcel);
  }

  public final void setZIndex(float paramFloat)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeFloat(paramFloat);
    zzb(13, localParcel);
  }

  public final boolean zzb(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramzzw);
    Parcel localParcel2 = zza(19, localParcel1);
    boolean bool = zzc.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }

  public final void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzc.zza(localParcel, paramIObjectWrapper);
    zzb(27, localParcel);
  }

  public final int zzj()
    throws RemoteException
  {
    Parcel localParcel = zza(20, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final IObjectWrapper zzk()
    throws RemoteException
  {
    Parcel localParcel = zza(28, zza());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzy
 * JD-Core Version:    0.6.2
 */