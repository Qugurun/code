package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class CrashUtils
{
  private static final String[] zzge = { "android.", "com.android.", "dalvik.", "java.", "javax." };
  private static DropBoxManager zzgf = null;
  private static boolean zzgg = false;
  private static int zzgh = -1;

  @GuardedBy("CrashUtils.class")
  private static int zzgi = 0;

  @GuardedBy("CrashUtils.class")
  private static int zzgj = 0;

  @KeepForSdk
  public static boolean addDynamiteErrorToDropBox(Context paramContext, Throwable paramThrowable)
  {
    return zza(paramContext, paramThrowable, 536870912);
  }

  private static boolean zza(Context paramContext, Throwable paramThrowable, int paramInt)
  {
    try
    {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramThrowable);
      return false;
    }
    catch (Exception localException)
    {
      Log.e("CrashUtils", "Error adding exception to DropBox!", localException);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.CrashUtils
 * JD-Core Version:    0.6.2
 */