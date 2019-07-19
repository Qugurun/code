package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;
import javax.annotation.Nullable;

public class LayoutShadowNode extends ReactShadowNodeImpl
{
  private final MutableYogaValue mTempYogaValue = new MutableYogaValue(null);

  private int maybeTransformLeftRightToStartEnd(int paramInt)
  {
    if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext()))
      return paramInt;
    switch (paramInt)
    {
    case 1:
    default:
      return paramInt;
    case 0:
      return 4;
    case 2:
    }
    return 5;
  }

  @ReactProp(name="alignContent")
  public void setAlignContent(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setAlignContent(YogaAlign.FLEX_START);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3005871:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case -1881872635:
    case -1720785339:
    case 441309761:
    case 1937124468:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for alignContent: " + paramString);
        if (paramString.equals("auto"))
        {
          i = 0;
          continue;
          if (paramString.equals("flex-start"))
          {
            i = 1;
            continue;
            if (paramString.equals("center"))
            {
              i = 2;
              continue;
              if (paramString.equals("flex-end"))
              {
                i = 3;
                continue;
                if (paramString.equals("stretch"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("baseline"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("space-between"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("space-around"))
                        i = 7;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    setAlignContent(YogaAlign.AUTO);
    return;
    setAlignContent(YogaAlign.FLEX_START);
    return;
    setAlignContent(YogaAlign.CENTER);
    return;
    setAlignContent(YogaAlign.FLEX_END);
    return;
    setAlignContent(YogaAlign.STRETCH);
    return;
    setAlignContent(YogaAlign.BASELINE);
    return;
    setAlignContent(YogaAlign.SPACE_BETWEEN);
    return;
    setAlignContent(YogaAlign.SPACE_AROUND);
  }

  @ReactProp(name="alignItems")
  public void setAlignItems(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setAlignItems(YogaAlign.STRETCH);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3005871:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case -1881872635:
    case -1720785339:
    case 441309761:
    case 1937124468:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for alignItems: " + paramString);
        if (paramString.equals("auto"))
        {
          i = 0;
          continue;
          if (paramString.equals("flex-start"))
          {
            i = 1;
            continue;
            if (paramString.equals("center"))
            {
              i = 2;
              continue;
              if (paramString.equals("flex-end"))
              {
                i = 3;
                continue;
                if (paramString.equals("stretch"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("baseline"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("space-between"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("space-around"))
                        i = 7;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    setAlignItems(YogaAlign.AUTO);
    return;
    setAlignItems(YogaAlign.FLEX_START);
    return;
    setAlignItems(YogaAlign.CENTER);
    return;
    setAlignItems(YogaAlign.FLEX_END);
    return;
    setAlignItems(YogaAlign.STRETCH);
    return;
    setAlignItems(YogaAlign.BASELINE);
    return;
    setAlignItems(YogaAlign.SPACE_BETWEEN);
    return;
    setAlignItems(YogaAlign.SPACE_AROUND);
  }

  @ReactProp(name="alignSelf")
  public void setAlignSelf(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setAlignSelf(YogaAlign.AUTO);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3005871:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case -1881872635:
    case -1720785339:
    case 441309761:
    case 1937124468:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for alignSelf: " + paramString);
        if (paramString.equals("auto"))
        {
          i = 0;
          continue;
          if (paramString.equals("flex-start"))
          {
            i = 1;
            continue;
            if (paramString.equals("center"))
            {
              i = 2;
              continue;
              if (paramString.equals("flex-end"))
              {
                i = 3;
                continue;
                if (paramString.equals("stretch"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("baseline"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("space-between"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("space-around"))
                        i = 7;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    setAlignSelf(YogaAlign.AUTO);
    return;
    setAlignSelf(YogaAlign.FLEX_START);
    return;
    setAlignSelf(YogaAlign.CENTER);
    return;
    setAlignSelf(YogaAlign.FLEX_END);
    return;
    setAlignSelf(YogaAlign.STRETCH);
    return;
    setAlignSelf(YogaAlign.BASELINE);
    return;
    setAlignSelf(YogaAlign.SPACE_BETWEEN);
    return;
    setAlignSelf(YogaAlign.SPACE_AROUND);
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="aspectRatio")
  public void setAspectRatio(float paramFloat)
  {
    setStyleAspectRatio(paramFloat);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
  public void setBorderWidths(int paramInt, float paramFloat)
  {
    if (isVirtual())
      return;
    setBorder(maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[paramInt]), PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(name="display")
  public void setDisplay(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setDisplay(YogaDisplay.FLEX);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3145721:
    case 3387192:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for display: " + paramString);
        if (paramString.equals("flex"))
        {
          i = 0;
          continue;
          if (paramString.equals("none"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    setDisplay(YogaDisplay.FLEX);
    return;
    setDisplay(YogaDisplay.NONE);
  }

  @ReactProp(defaultFloat=0.0F, name="flex")
  public void setFlex(float paramFloat)
  {
    if (isVirtual())
      return;
    super.setFlex(paramFloat);
  }

  @ReactProp(name="flexBasis")
  public void setFlexBasis(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setFlexBasis(this.mTempYogaValue.value);
      continue;
      setFlexBasisAuto();
      continue;
      setFlexBasisPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="flexDirection")
  public void setFlexDirection(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setFlexDirection(YogaFlexDirection.COLUMN);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1354837162:
    case 1272730475:
    case 113114:
    case -1448970769:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for flexDirection: " + paramString);
        if (paramString.equals("column"))
        {
          i = 0;
          continue;
          if (paramString.equals("column-reverse"))
          {
            i = 1;
            continue;
            if (paramString.equals("row"))
            {
              i = 2;
              continue;
              if (paramString.equals("row-reverse"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    setFlexDirection(YogaFlexDirection.COLUMN);
    return;
    setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
    return;
    setFlexDirection(YogaFlexDirection.ROW);
    return;
    setFlexDirection(YogaFlexDirection.ROW_REVERSE);
  }

  @ReactProp(defaultFloat=0.0F, name="flexGrow")
  public void setFlexGrow(float paramFloat)
  {
    if (isVirtual())
      return;
    super.setFlexGrow(paramFloat);
  }

  @ReactProp(defaultFloat=0.0F, name="flexShrink")
  public void setFlexShrink(float paramFloat)
  {
    if (isVirtual())
      return;
    super.setFlexShrink(paramFloat);
  }

  @ReactProp(name="flexWrap")
  public void setFlexWrap(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setFlexWrap(YogaWrap.NO_WRAP);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1039592053:
    case 3657802:
    case -749527969:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for flexWrap: " + paramString);
        if (paramString.equals("nowrap"))
        {
          i = 0;
          continue;
          if (paramString.equals("wrap"))
          {
            i = 1;
            continue;
            if (paramString.equals("wrap-reverse"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    setFlexWrap(YogaWrap.NO_WRAP);
    return;
    setFlexWrap(YogaWrap.WRAP);
    return;
    setFlexWrap(YogaWrap.WRAP_REVERSE);
  }

  @ReactProp(name="height")
  public void setHeight(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleHeight(this.mTempYogaValue.value);
      continue;
      setStyleHeightAuto();
      continue;
      setStyleHeightPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="justifyContent")
  public void setJustifyContent(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setJustifyContent(YogaJustify.FLEX_START);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case 441309761:
    case 1937124468:
    case 2055030478:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for justifyContent: " + paramString);
        if (paramString.equals("flex-start"))
        {
          i = 0;
          continue;
          if (paramString.equals("center"))
          {
            i = 1;
            continue;
            if (paramString.equals("flex-end"))
            {
              i = 2;
              continue;
              if (paramString.equals("space-between"))
              {
                i = 3;
                continue;
                if (paramString.equals("space-around"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("space-evenly"))
                    i = 5;
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    setJustifyContent(YogaJustify.FLEX_START);
    return;
    setJustifyContent(YogaJustify.CENTER);
    return;
    setJustifyContent(YogaJustify.FLEX_END);
    return;
    setJustifyContent(YogaJustify.SPACE_BETWEEN);
    return;
    setJustifyContent(YogaJustify.SPACE_AROUND);
    return;
    setJustifyContent(YogaJustify.SPACE_EVENLY);
  }

  @ReactPropGroup(names={"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
  public void setMargins(int paramInt, Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    int i = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt]);
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setMargin(i, this.mTempYogaValue.value);
      continue;
      setMarginAuto(i);
      continue;
      setMarginPercent(i, this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="maxHeight")
  public void setMaxHeight(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMaxHeight(this.mTempYogaValue.value);
      continue;
      setStyleMaxHeightPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="maxWidth")
  public void setMaxWidth(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMaxWidth(this.mTempYogaValue.value);
      continue;
      setStyleMaxWidthPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="minHeight")
  public void setMinHeight(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMinHeight(this.mTempYogaValue.value);
      continue;
      setStyleMinHeightPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="minWidth")
  public void setMinWidth(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMinWidth(this.mTempYogaValue.value);
      continue;
      setStyleMinWidthPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="overflow")
  public void setOverflow(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setOverflow(YogaOverflow.VISIBLE);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 466743410:
    case -1217487446:
    case -907680051:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for overflow: " + paramString);
        if (paramString.equals("visible"))
        {
          i = 0;
          continue;
          if (paramString.equals("hidden"))
          {
            i = 1;
            continue;
            if (paramString.equals("scroll"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    setOverflow(YogaOverflow.VISIBLE);
    return;
    setOverflow(YogaOverflow.HIDDEN);
    return;
    setOverflow(YogaOverflow.SCROLL);
  }

  @ReactPropGroup(names={"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
  public void setPaddings(int paramInt, Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    int i = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt]);
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setPadding(i, this.mTempYogaValue.value);
      continue;
      setPaddingPercent(i, this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="position")
  public void setPosition(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setPositionType(YogaPositionType.RELATIVE);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -554435892:
    case 1728122231:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for position: " + paramString);
        if (paramString.equals("relative"))
        {
          i = 0;
          continue;
          if (paramString.equals("absolute"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    setPositionType(YogaPositionType.RELATIVE);
    return;
    setPositionType(YogaPositionType.ABSOLUTE);
  }

  @ReactPropGroup(names={"start", "end", "left", "right", "top", "bottom"})
  public void setPositionValues(int paramInt, Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    int i = maybeTransformLeftRightToStartEnd(new int[] { 4, 5, 0, 2, 1, 3 }[paramInt]);
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setPosition(i, this.mTempYogaValue.value);
      continue;
      setPositionPercent(i, this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="onLayout")
  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    super.setShouldNotifyOnLayout(paramBoolean);
  }

  @ReactProp(name="width")
  public void setWidth(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleWidth(this.mTempYogaValue.value);
      continue;
      setStyleWidthAuto();
      continue;
      setStyleWidthPercent(this.mTempYogaValue.value);
    }
  }

  private static class MutableYogaValue
  {
    YogaUnit unit;
    float value;

    private MutableYogaValue()
    {
    }

    private MutableYogaValue(MutableYogaValue paramMutableYogaValue)
    {
      this.value = paramMutableYogaValue.value;
      this.unit = paramMutableYogaValue.unit;
    }

    void setFromDynamic(Dynamic paramDynamic)
    {
      if (paramDynamic.isNull())
      {
        this.unit = YogaUnit.UNDEFINED;
        this.value = (0.0F / 0.0F);
        return;
      }
      if (paramDynamic.getType() == ReadableType.String)
      {
        String str = paramDynamic.asString();
        if (str.equals("auto"))
        {
          this.unit = YogaUnit.AUTO;
          this.value = (0.0F / 0.0F);
          return;
        }
        if (str.endsWith("%"))
        {
          this.unit = YogaUnit.PERCENT;
          this.value = Float.parseFloat(str.substring(0, -1 + str.length()));
          return;
        }
        throw new IllegalArgumentException("Unknown value: " + str);
      }
      this.unit = YogaUnit.POINT;
      this.value = PixelUtil.toPixelFromDIP(paramDynamic.asDouble());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.LayoutShadowNode
 * JD-Core Version:    0.6.2
 */