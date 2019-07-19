package com.facebook.react.views.text;

import android.text.TextUtils.TruncateAt;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import javax.annotation.Nullable;

public abstract class ReactTextAnchorViewManager<T extends View, C extends ReactBaseTextShadowNode> extends BaseViewManager<T, C>
{
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactTextView paramReactTextView, int paramInt, Integer paramInteger)
  {
    float f1 = (0.0F / 0.0F);
    float f2;
    if (paramInteger == null)
    {
      f2 = f1;
      if (paramInteger != null)
        break label43;
    }
    while (true)
    {
      paramReactTextView.setBorderColor(SPACING_TYPES[paramInt], f2, f1);
      return;
      f2 = 0xFFFFFF & paramInteger.intValue();
      break;
      label43: f1 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactTextView paramReactTextView, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactTextView.setBorderRadius(paramFloat);
      return;
    }
    paramReactTextView.setBorderRadius(paramFloat, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactTextView paramReactTextView, @Nullable String paramString)
  {
    paramReactTextView.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactTextView paramReactTextView, int paramInt, float paramFloat)
  {
    if (!YogaConstants.isUndefined(paramFloat))
      paramFloat = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactTextView.setBorderWidth(SPACING_TYPES[paramInt], paramFloat);
  }

  @ReactProp(defaultBoolean=false, name="disabled")
  public void setDisabled(ReactTextView paramReactTextView, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      paramReactTextView.setEnabled(bool);
      return;
    }
  }

  @ReactProp(name="ellipsizeMode")
  public void setEllipsizeMode(ReactTextView paramReactTextView, @Nullable String paramString)
  {
    if ((paramString == null) || (paramString.equals("tail")))
    {
      paramReactTextView.setEllipsizeLocation(TextUtils.TruncateAt.END);
      return;
    }
    if (paramString.equals("head"))
    {
      paramReactTextView.setEllipsizeLocation(TextUtils.TruncateAt.START);
      return;
    }
    if (paramString.equals("middle"))
    {
      paramReactTextView.setEllipsizeLocation(TextUtils.TruncateAt.MIDDLE);
      return;
    }
    if (paramString.equals("clip"))
    {
      paramReactTextView.setEllipsizeLocation(null);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid ellipsizeMode: " + paramString);
  }

  @ReactProp(defaultBoolean=true, name="includeFontPadding")
  public void setIncludeFontPadding(ReactTextView paramReactTextView, boolean paramBoolean)
  {
    paramReactTextView.setIncludeFontPadding(paramBoolean);
  }

  @ReactProp(defaultInt=2147483647, name="numberOfLines")
  public void setNumberOfLines(ReactTextView paramReactTextView, int paramInt)
  {
    paramReactTextView.setNumberOfLines(paramInt);
  }

  @ReactProp(name="selectable")
  public void setSelectable(ReactTextView paramReactTextView, boolean paramBoolean)
  {
    paramReactTextView.setTextIsSelectable(paramBoolean);
  }

  @ReactProp(customType="Color", name="selectionColor")
  public void setSelectionColor(ReactTextView paramReactTextView, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactTextView.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(paramReactTextView.getContext()));
      return;
    }
    paramReactTextView.setHighlightColor(paramInteger.intValue());
  }

  @ReactProp(name="textAlignVertical")
  public void setTextAlignVertical(ReactTextView paramReactTextView, @Nullable String paramString)
  {
    if ((paramString == null) || ("auto".equals(paramString)))
    {
      paramReactTextView.setGravityVertical(0);
      return;
    }
    if ("top".equals(paramString))
    {
      paramReactTextView.setGravityVertical(48);
      return;
    }
    if ("bottom".equals(paramString))
    {
      paramReactTextView.setGravityVertical(80);
      return;
    }
    if ("center".equals(paramString))
    {
      paramReactTextView.setGravityVertical(16);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextAnchorViewManager
 * JD-Core Version:    0.6.2
 */