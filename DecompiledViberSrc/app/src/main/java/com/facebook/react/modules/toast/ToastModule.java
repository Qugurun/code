package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name="ToastAndroid")
public class ToastModule extends ReactContextBaseJavaModule
{
  private static final String DURATION_LONG_KEY = "LONG";
  private static final String DURATION_SHORT_KEY = "SHORT";
  private static final String GRAVITY_BOTTOM_KEY = "BOTTOM";
  private static final String GRAVITY_CENTER = "CENTER";
  private static final String GRAVITY_TOP_KEY = "TOP";
  public static final String NAME = "ToastAndroid";

  public ToastModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    localHashMap.put("SHORT", Integer.valueOf(0));
    localHashMap.put("LONG", Integer.valueOf(1));
    localHashMap.put("TOP", Integer.valueOf(49));
    localHashMap.put("BOTTOM", Integer.valueOf(81));
    localHashMap.put("CENTER", Integer.valueOf(17));
    return localHashMap;
  }

  public String getName()
  {
    return "ToastAndroid";
  }

  @ReactMethod
  public void show(final String paramString, final int paramInt)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(ToastModule.this.getReactApplicationContext(), paramString, paramInt).show();
      }
    });
  }

  @ReactMethod
  public void showWithGravity(final String paramString, final int paramInt1, final int paramInt2)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast localToast = Toast.makeText(ToastModule.this.getReactApplicationContext(), paramString, paramInt1);
        localToast.setGravity(paramInt2, 0, 0);
        localToast.show();
      }
    });
  }

  @ReactMethod
  public void showWithGravityAndOffset(final String paramString, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast localToast = Toast.makeText(ToastModule.this.getReactApplicationContext(), paramString, paramInt1);
        localToast.setGravity(paramInt2, paramInt3, paramInt4);
        localToast.show();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.toast.ToastModule
 * JD-Core Version:    0.6.2
 */