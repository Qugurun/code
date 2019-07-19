package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzuv extends IOException
{
  private zzvv zzbzf = null;

  public zzuv(String paramString)
  {
    super(paramString);
  }

  static zzuv zzwq()
  {
    return new zzuv("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }

  static zzuv zzwr()
  {
    return new zzuv("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }

  static zzuv zzws()
  {
    return new zzuv("CodedInputStream encountered a malformed varint.");
  }

  static zzuv zzwt()
  {
    return new zzuv("Protocol message end-group tag did not match expected tag.");
  }

  static zzuw zzwu()
  {
    return new zzuw("Protocol message tag had invalid wire type.");
  }

  static zzuv zzwv()
  {
    return new zzuv("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }

  static zzuv zzww()
  {
    return new zzuv("Failed to parse the message.");
  }

  static zzuv zzwx()
  {
    return new zzuv("Protocol message had invalid UTF-8.");
  }

  public final zzuv zzg(zzvv paramzzvv)
  {
    this.zzbzf = paramzzvv;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzuv
 * JD-Core Version:    0.6.2
 */