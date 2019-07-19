package android.support.v4.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

public class ShortcutInfoCompat
{
  ComponentName mActivity;
  Context mContext;
  CharSequence mDisabledMessage;
  IconCompat mIcon;
  String mId;
  Intent[] mIntents;
  boolean mIsAlwaysBadged;
  CharSequence mLabel;
  CharSequence mLongLabel;

  Intent addToIntent(Intent paramIntent)
  {
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[(-1 + this.mIntents.length)]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
    Object localObject;
    PackageManager localPackageManager;
    if (this.mIcon != null)
    {
      boolean bool = this.mIsAlwaysBadged;
      localObject = null;
      if (bool)
      {
        localPackageManager = this.mContext.getPackageManager();
        ComponentName localComponentName = this.mActivity;
        localObject = null;
        if (localComponentName == null);
      }
    }
    try
    {
      Drawable localDrawable = localPackageManager.getActivityIcon(this.mActivity);
      localObject = localDrawable;
      if (localObject == null)
        localObject = this.mContext.getApplicationInfo().loadIcon(localPackageManager);
      this.mIcon.addToShortcutIntent(paramIntent, (Drawable)localObject, this.mContext);
      return paramIntent;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localObject = null;
    }
  }

  public ComponentName getActivity()
  {
    return this.mActivity;
  }

  public CharSequence getDisabledMessage()
  {
    return this.mDisabledMessage;
  }

  public String getId()
  {
    return this.mId;
  }

  public Intent getIntent()
  {
    return this.mIntents[(-1 + this.mIntents.length)];
  }

  public Intent[] getIntents()
  {
    return (Intent[])Arrays.copyOf(this.mIntents, this.mIntents.length);
  }

  public CharSequence getLongLabel()
  {
    return this.mLongLabel;
  }

  public CharSequence getShortLabel()
  {
    return this.mLabel;
  }

  public ShortcutInfo toShortcutInfo()
  {
    ShortcutInfo.Builder localBuilder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
    if (this.mIcon != null)
      localBuilder.setIcon(this.mIcon.toIcon());
    if (!TextUtils.isEmpty(this.mLongLabel))
      localBuilder.setLongLabel(this.mLongLabel);
    if (!TextUtils.isEmpty(this.mDisabledMessage))
      localBuilder.setDisabledMessage(this.mDisabledMessage);
    if (this.mActivity != null)
      localBuilder.setActivity(this.mActivity);
    return localBuilder.build();
  }

  public static class Builder
  {
    private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();

    public Builder(Context paramContext, String paramString)
    {
      this.mInfo.mContext = paramContext;
      this.mInfo.mId = paramString;
    }

    public ShortcutInfoCompat build()
    {
      if (TextUtils.isEmpty(this.mInfo.mLabel))
        throw new IllegalArgumentException("Shortcut must have a non-empty label");
      if ((this.mInfo.mIntents == null) || (this.mInfo.mIntents.length == 0))
        throw new IllegalArgumentException("Shortcut must have an intent");
      return this.mInfo;
    }

    public Builder setActivity(ComponentName paramComponentName)
    {
      this.mInfo.mActivity = paramComponentName;
      return this;
    }

    public Builder setAlwaysBadged()
    {
      this.mInfo.mIsAlwaysBadged = true;
      return this;
    }

    public Builder setDisabledMessage(CharSequence paramCharSequence)
    {
      this.mInfo.mDisabledMessage = paramCharSequence;
      return this;
    }

    public Builder setIcon(IconCompat paramIconCompat)
    {
      this.mInfo.mIcon = paramIconCompat;
      return this;
    }

    public Builder setIntent(Intent paramIntent)
    {
      return setIntents(new Intent[] { paramIntent });
    }

    public Builder setIntents(Intent[] paramArrayOfIntent)
    {
      this.mInfo.mIntents = paramArrayOfIntent;
      return this;
    }

    public Builder setLongLabel(CharSequence paramCharSequence)
    {
      this.mInfo.mLongLabel = paramCharSequence;
      return this;
    }

    public Builder setShortLabel(CharSequence paramCharSequence)
    {
      this.mInfo.mLabel = paramCharSequence;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.pm.ShortcutInfoCompat
 * JD-Core Version:    0.6.2
 */