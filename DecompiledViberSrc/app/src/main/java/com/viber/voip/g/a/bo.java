package com.viber.voip.g.a;

import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.n;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bo
  implements d<n>
{
  private final Provider<g> a;

  public bo(Provider<g> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bo a(Provider<g> paramProvider)
  {
    return new bo(paramProvider);
  }

  public n a()
  {
    return (n)h.a(bk.a((g)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bo
 * JD-Core Version:    0.6.2
 */