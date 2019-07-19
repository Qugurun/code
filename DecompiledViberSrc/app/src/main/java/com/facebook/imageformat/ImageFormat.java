package com.facebook.imageformat;

import javax.annotation.Nullable;

public class ImageFormat
{
  public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
  private final String mFileExtension;
  private final String mName;

  public ImageFormat(String paramString1, @Nullable String paramString2)
  {
    this.mName = paramString1;
    this.mFileExtension = paramString2;
  }

  @Nullable
  public String getFileExtension()
  {
    return this.mFileExtension;
  }

  public String getName()
  {
    return this.mName;
  }

  public String toString()
  {
    return getName();
  }

  public static abstract interface FormatChecker
  {
    @Nullable
    public abstract ImageFormat determineFormat(byte[] paramArrayOfByte, int paramInt);

    public abstract int getHeaderSize();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imageformat.ImageFormat
 * JD-Core Version:    0.6.2
 */