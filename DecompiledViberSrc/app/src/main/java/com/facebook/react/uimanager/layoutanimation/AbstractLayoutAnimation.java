package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Map;
import javax.annotation.Nullable;

abstract class AbstractLayoutAnimation
{
  private static final Map<InterpolatorType, BaseInterpolator> INTERPOLATOR = MapBuilder.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator());
  private static final boolean SLOWDOWN_ANIMATION_MODE;

  @Nullable
  protected AnimatedPropertyType mAnimatedProperty;
  private int mDelayMs;
  protected int mDurationMs;

  @Nullable
  private Interpolator mInterpolator;

  private static Interpolator getInterpolator(InterpolatorType paramInterpolatorType, ReadableMap paramReadableMap)
  {
    if (paramInterpolatorType.equals(InterpolatorType.SPRING));
    for (Object localObject = new SimpleSpringInterpolator(SimpleSpringInterpolator.getSpringDamping(paramReadableMap)); localObject == null; localObject = (Interpolator)INTERPOLATOR.get(paramInterpolatorType))
      throw new IllegalArgumentException("Missing interpolator for type : " + paramInterpolatorType);
    return localObject;
  }

  @Nullable
  public final Animation createAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Animation localAnimation;
    if (!isValid())
      localAnimation = null;
    do
    {
      return localAnimation;
      localAnimation = createAnimationImpl(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (localAnimation == null);
    localAnimation.setDuration(1 * this.mDurationMs);
    localAnimation.setStartOffset(1 * this.mDelayMs);
    localAnimation.setInterpolator(this.mInterpolator);
    return localAnimation;
  }

  @Nullable
  abstract Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public void initializeFromConfig(ReadableMap paramReadableMap, int paramInt)
  {
    AnimatedPropertyType localAnimatedPropertyType;
    if (paramReadableMap.hasKey("property"))
    {
      localAnimatedPropertyType = AnimatedPropertyType.fromString(paramReadableMap.getString("property"));
      this.mAnimatedProperty = localAnimatedPropertyType;
      if (paramReadableMap.hasKey("duration"))
        paramInt = paramReadableMap.getInt("duration");
      this.mDurationMs = paramInt;
      if (!paramReadableMap.hasKey("delay"))
        break label106;
    }
    label106: for (int i = paramReadableMap.getInt("delay"); ; i = 0)
    {
      this.mDelayMs = i;
      if (paramReadableMap.hasKey("type"))
        break label112;
      throw new IllegalArgumentException("Missing interpolation type.");
      localAnimatedPropertyType = null;
      break;
    }
    label112: this.mInterpolator = getInterpolator(InterpolatorType.fromString(paramReadableMap.getString("type")), paramReadableMap);
    if (!isValid())
      throw new IllegalViewOperationException("Invalid layout animation : " + paramReadableMap);
  }

  abstract boolean isValid();

  public void reset()
  {
    this.mAnimatedProperty = null;
    this.mDurationMs = 0;
    this.mDelayMs = 0;
    this.mInterpolator = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
 * JD-Core Version:    0.6.2
 */