package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="SignInRequestCreator")
public final class zah extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zah> CREATOR = new zai();

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @SafeParcelable.Field(getter="getResolveAccountRequest", id=2)
  private final ResolveAccountRequest zasa;

  @SafeParcelable.Constructor
  zah(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) ResolveAccountRequest paramResolveAccountRequest)
  {
    this.zale = paramInt;
    this.zasa = paramResolveAccountRequest;
  }

  public zah(ResolveAccountRequest paramResolveAccountRequest)
  {
    this(1, paramResolveAccountRequest);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zasa, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zah
 * JD-Core Version:    0.6.2
 */