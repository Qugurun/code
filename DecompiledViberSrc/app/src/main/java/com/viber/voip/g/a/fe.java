package com.viber.voip.g.a;

import com.viber.voip.ap.a;
import com.viber.voip.api.a.a.a;
import com.viber.voip.util.http.OkHttpClientFactory;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fe
  implements d<a>
{
  private final Provider<OkHttpClientFactory> a;
  private final Provider<ap.a> b;

  public fe(Provider<OkHttpClientFactory> paramProvider, Provider<ap.a> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static fe a(Provider<OkHttpClientFactory> paramProvider, Provider<ap.a> paramProvider1)
  {
    return new fe(paramProvider, paramProvider1);
  }

  public a a()
  {
    return (a)h.a(fd.b((OkHttpClientFactory)this.a.get(), (ap.a)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fe
 * JD-Core Version:    0.6.2
 */