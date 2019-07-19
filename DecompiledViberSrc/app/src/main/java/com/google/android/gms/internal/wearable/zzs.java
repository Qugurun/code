package com.google.android.gms.internal.wearable;

import java.io.IOException;

public final class zzs extends IOException
{
  public zzs(String paramString)
  {
    super(paramString);
  }

  static zzs zzu()
  {
    return new zzs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }

  static zzs zzv()
  {
    return new zzs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }

  static zzs zzw()
  {
    return new zzs("CodedInputStream encountered a malformed varint.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzs
 * JD-Core Version:    0.6.2
 */