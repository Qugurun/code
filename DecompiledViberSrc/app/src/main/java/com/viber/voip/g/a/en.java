package com.viber.voip.g.a;

import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class en
  implements d<m>
{
  private final Provider<g> a;

  public en(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static en a(Provider<g> paramProvider)
  {
    return new en(paramProvider);
  }

  public static m a(g paramg)
  {
    return (m)h.a(em.a(paramg), "Cannot return null from a non-@Nullable @Provides method");
  }

  public m a()
  {
    return (m)h.a(em.a((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.en
 * JD-Core Version:    0.6.2
 */