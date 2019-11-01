package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerSlideEvent extends Event<DrawerSlideEvent>
{
  public static final String EVENT_NAME = "topDrawerSlide";
  private final float mOffset;

  public DrawerSlideEvent(int paramInt, float paramFloat)
  {
    super(paramInt);
    this.mOffset = paramFloat;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putDouble("offset", getOffset());
    return localWritableMap;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "topDrawerSlide";
  }

  public float getOffset()
  {
    return this.mOffset;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.drawer.events.DrawerSlideEvent
 * JD-Core Version:    0.6.2
 */