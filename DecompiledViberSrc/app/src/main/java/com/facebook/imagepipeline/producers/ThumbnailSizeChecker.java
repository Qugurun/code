package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;

public final class ThumbnailSizeChecker
{
  public static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.333333F;
  private static final int ROTATED_90_DEGREES_CLOCKWISE = 90;
  private static final int ROTATED_90_DEGREES_COUNTER_CLOCKWISE = 270;

  public static int getAcceptableSize(int paramInt)
  {
    return (int)(1.333333F * paramInt);
  }

  public static boolean isImageBigEnough(int paramInt1, int paramInt2, ResizeOptions paramResizeOptions)
  {
    if (paramResizeOptions == null)
      if ((getAcceptableSize(paramInt1) < 2048.0F) || (getAcceptableSize(paramInt2) < 2048));
    while ((getAcceptableSize(paramInt1) >= paramResizeOptions.width) && (getAcceptableSize(paramInt2) >= paramResizeOptions.height))
    {
      return true;
      return false;
    }
    return false;
  }

  public static boolean isImageBigEnough(EncodedImage paramEncodedImage, ResizeOptions paramResizeOptions)
  {
    if (paramEncodedImage == null)
      return false;
    switch (paramEncodedImage.getRotationAngle())
    {
    default:
      return isImageBigEnough(paramEncodedImage.getWidth(), paramEncodedImage.getHeight(), paramResizeOptions);
    case 90:
    case 270:
    }
    return isImageBigEnough(paramEncodedImage.getHeight(), paramEncodedImage.getWidth(), paramResizeOptions);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThumbnailSizeChecker
 * JD-Core Version:    0.6.2
 */