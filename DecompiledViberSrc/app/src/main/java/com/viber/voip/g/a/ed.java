package com.viber.voip.g.a;

import com.viber.voip.ap.a;
import dagger.a.d;
import dagger.a.h;

public final class ed
  implements d<ap.a>
{
  private static final ed a = new ed();

  public static ed b()
  {
    return a;
  }

  public ap.a a()
  {
    return (ap.a)h.a(ec.c(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ed
 * JD-Core Version:    0.6.2
 */