package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.support.v7.b.a.c;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DrawableUtils
{
  public static final Rect INSETS_NONE = new Rect();
  private static final String TAG = "DrawableUtils";
  private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
  private static Class<?> sInsetsClazz;

  static
  {
    if (Build.VERSION.SDK_INT >= 18);
    try
    {
      sInsetsClazz = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
  }

  public static boolean canSafelyMutateDrawable(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof InsetDrawable)))
      return false;
    if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof GradientDrawable)))
      return false;
    if ((Build.VERSION.SDK_INT < 17) && ((paramDrawable instanceof LayerDrawable)))
      return false;
    if ((paramDrawable instanceof DrawableContainer))
    {
      Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
      if ((localConstantState instanceof DrawableContainer.DrawableContainerState))
      {
        Drawable[] arrayOfDrawable = ((DrawableContainer.DrawableContainerState)localConstantState).getChildren();
        int i = arrayOfDrawable.length;
        for (int j = 0; j < i; j++)
          if (!canSafelyMutateDrawable(arrayOfDrawable[j]))
            return false;
      }
    }
    else
    {
      if ((paramDrawable instanceof WrappedDrawable))
        return canSafelyMutateDrawable(((WrappedDrawable)paramDrawable).getWrappedDrawable());
      if ((paramDrawable instanceof c))
        return canSafelyMutateDrawable(((c)paramDrawable).getWrappedDrawable());
      if ((paramDrawable instanceof ScaleDrawable))
        return canSafelyMutateDrawable(((ScaleDrawable)paramDrawable).getDrawable());
    }
    return true;
  }

  static void fixDrawable(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
      fixVectorDrawableTinting(paramDrawable);
  }

  private static void fixVectorDrawableTinting(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt == null) || (arrayOfInt.length == 0))
      paramDrawable.setState(ThemeUtils.CHECKED_STATE_SET);
    while (true)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      paramDrawable.setState(ThemeUtils.EMPTY_STATE_SET);
    }
  }

  public static Rect getOpticalBounds(Drawable paramDrawable)
  {
    if (sInsetsClazz != null);
    while (true)
    {
      Object localObject;
      int j;
      Field localField;
      int k;
      try
      {
        Drawable localDrawable = DrawableCompat.unwrap(paramDrawable);
        localObject = localDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(localDrawable, new Object[0]);
        if (localObject != null)
        {
          localRect = new Rect();
          Field[] arrayOfField = sInsetsClazz.getFields();
          int i = arrayOfField.length;
          j = 0;
          if (j >= i)
            break label227;
          localField = arrayOfField[j];
          String str = localField.getName();
          k = -1;
          switch (str.hashCode())
          {
          case 3317767:
            if (!str.equals("left"))
              break;
            k = 0;
            break;
          case 115029:
            if (!str.equals("top"))
              break;
            k = 1;
            break;
          case 108511772:
            if (!str.equals("right"))
              break;
            k = 2;
            break;
          case -1383228885:
            if (!str.equals("bottom"))
              break;
            k = 3;
            break;
            localRect.left = localField.getInt(localObject);
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }
      Rect localRect = INSETS_NONE;
      label227: return localRect;
      localRect.top = localField.getInt(localObject);
      break label304;
      localRect.right = localField.getInt(localObject);
      break label304;
      localRect.bottom = localField.getInt(localObject);
      break label304;
      switch (k)
      {
      case 0:
      case 1:
      case 2:
      case 3:
      }
      label304: j++;
    }
  }

  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4:
    case 6:
    case 7:
    case 8:
    case 10:
    case 11:
    case 12:
    case 13:
    default:
      return paramMode;
    case 3:
      return PorterDuff.Mode.SRC_OVER;
    case 5:
      return PorterDuff.Mode.SRC_IN;
    case 9:
      return PorterDuff.Mode.SRC_ATOP;
    case 14:
      return PorterDuff.Mode.MULTIPLY;
    case 15:
      return PorterDuff.Mode.SCREEN;
    case 16:
    }
    return PorterDuff.Mode.ADD;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.DrawableUtils
 * JD-Core Version:    0.6.2
 */