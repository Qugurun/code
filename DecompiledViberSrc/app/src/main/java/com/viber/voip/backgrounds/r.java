package com.viber.voip.backgrounds;

import android.net.Uri;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.bu;
import com.viber.voip.util.dv;

public class r
  implements q
{
  private Uri a;

  public r(Uri paramUri)
  {
    this.a = paramUri;
  }

  public Uri a()
  {
    return this.a;
  }

  public Uri a(boolean paramBoolean)
  {
    if (this.a == null)
      return null;
    String str = bu.a(this.a.getPath());
    if (paramBoolean);
    for (dv localdv = dv.M; ; localdv = dv.L)
      return localdv.a(ViberApplication.getApplication(), str + "_cr", false);
  }

  public boolean b()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.r
 * JD-Core Version:    0.6.2
 */