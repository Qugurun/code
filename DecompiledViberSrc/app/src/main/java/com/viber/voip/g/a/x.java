package com.viber.voip.g.a;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.d.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class x
  implements d<c>
{
  private final Provider<g> a;

  public x(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static c a(g paramg)
  {
    return (c)h.a(r.b(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static x a(Provider<g> paramProvider)
  {
    return new x(paramProvider);
  }

  public c a()
  {
    return (c)h.a(r.b((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.x
 * JD-Core Version:    0.6.2
 */