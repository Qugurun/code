package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator="ProxyResponseCreator")
public class ProxyResponse extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();
  public static final int STATUS_CODE_NO_CONNECTION = -1;

  @SafeParcelable.Field(id=5)
  public final byte[] body;

  @SafeParcelable.Field(id=1)
  public final int googlePlayServicesStatusCode;

  @SafeParcelable.Field(id=2)
  public final PendingIntent recoveryAction;

  @SafeParcelable.Field(id=3)
  public final int statusCode;

  @SafeParcelable.VersionField(id=1000)
  private final int versionCode;

  @SafeParcelable.Field(id=4)
  private final Bundle zzby;

  @SafeParcelable.Constructor
  ProxyResponse(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) int paramInt2, @SafeParcelable.Param(id=2) PendingIntent paramPendingIntent, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) Bundle paramBundle, @SafeParcelable.Param(id=5) byte[] paramArrayOfByte)
  {
    this.versionCode = paramInt1;
    this.googlePlayServicesStatusCode = paramInt2;
    this.statusCode = paramInt3;
    this.zzby = paramBundle;
    this.body = paramArrayOfByte;
    this.recoveryAction = paramPendingIntent;
  }

  public ProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramPendingIntent, paramInt2, paramBundle, paramArrayOfByte);
  }

  private ProxyResponse(int paramInt, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, 0, null, paramInt, paramBundle, paramArrayOfByte);
  }

  public ProxyResponse(int paramInt, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this(paramInt, zza(paramMap), paramArrayOfByte);
  }

  public static ProxyResponse createErrorProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    return new ProxyResponse(1, paramInt1, paramPendingIntent, paramInt2, zza(paramMap), paramArrayOfByte);
  }

  private static Bundle zza(Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    if (paramMap == null)
      return localBundle;
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localBundle;
  }

  public Map<String, String> getHeaders()
  {
    if (this.zzby == null)
      return Collections.emptyMap();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzby.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, this.zzby.getString(str));
    }
    return localHashMap;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.googlePlayServicesStatusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.recoveryAction, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.statusCode);
    SafeParcelWriter.writeBundle(paramParcel, 4, this.zzby, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, this.body, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyResponse
 * JD-Core Version:    0.6.2
 */