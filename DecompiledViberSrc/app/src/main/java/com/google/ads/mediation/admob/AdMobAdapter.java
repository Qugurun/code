package com.google.ads.mediation.admob;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;

@Keep
public final class AdMobAdapter extends AbstractAdViewAdapter
{
  public static final String NEW_BUNDLE = "_newBundle";

  protected final Bundle zza(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 != null);
    while (true)
    {
      if (paramBundle1.getBoolean("_newBundle"))
        paramBundle1 = new Bundle(paramBundle1);
      paramBundle1.putInt("gw", 1);
      paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
      if (!TextUtils.isEmpty(paramBundle2.getString("adJson")))
        paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
      paramBundle1.putBoolean("_noRefresh", true);
      return paramBundle1;
      paramBundle1 = new Bundle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.admob.AdMobAdapter
 * JD-Core Version:    0.6.2
 */