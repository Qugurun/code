package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@SafeParcelable.Class(creator="AccountChangeEventsResponseCreator")
public class AccountChangeEventsResponse extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();

  @SafeParcelable.VersionField(id=1)
  private final int zze;

  @SafeParcelable.Field(id=2)
  private final List<AccountChangeEvent> zzl;

  @SafeParcelable.Constructor
  AccountChangeEventsResponse(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) List<AccountChangeEvent> paramList)
  {
    this.zze = paramInt;
    this.zzl = ((List)Preconditions.checkNotNull(paramList));
  }

  public AccountChangeEventsResponse(List<AccountChangeEvent> paramList)
  {
    this.zze = 1;
    this.zzl = ((List)Preconditions.checkNotNull(paramList));
  }

  public List<AccountChangeEvent> getEvents()
  {
    return this.zzl;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zze);
    SafeParcelWriter.writeTypedList(paramParcel, 2, this.zzl, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsResponse
 * JD-Core Version:    0.6.2
 */