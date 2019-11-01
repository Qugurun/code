package com.facebook.react.animation;

import android.view.View;

public class ScaleXAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater
{
  public ScaleXAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }

  public ScaleXAnimationPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }

  protected float getProperty(View paramView)
  {
    return paramView.getScaleX();
  }

  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.ScaleXAnimationPropertyUpdater
 * JD-Core Version:    0.6.2
 */