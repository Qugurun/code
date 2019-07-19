package android.support.v4.view.animation;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class PathInterpolatorCompat
{
  public static Interpolator create(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return new PathInterpolator(paramFloat1, paramFloat2);
    return new PathInterpolatorApi14(paramFloat1, paramFloat2);
  }

  public static Interpolator create(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return new PathInterpolator(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return new PathInterpolatorApi14(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public static Interpolator create(Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return new PathInterpolator(paramPath);
    return new PathInterpolatorApi14(paramPath);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.animation.PathInterpolatorCompat
 * JD-Core Version:    0.6.2
 */