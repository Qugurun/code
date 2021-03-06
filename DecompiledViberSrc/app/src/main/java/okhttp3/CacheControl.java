package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;

public final class CacheControl
{
  public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(2147483647, TimeUnit.SECONDS).build();
  public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

  @Nullable
  String headerValue;
  private final boolean immutable;
  private final boolean isPrivate;
  private final boolean isPublic;
  private final int maxAgeSeconds;
  private final int maxStaleSeconds;
  private final int minFreshSeconds;
  private final boolean mustRevalidate;
  private final boolean noCache;
  private final boolean noStore;
  private final boolean noTransform;
  private final boolean onlyIfCached;
  private final int sMaxAgeSeconds;

  CacheControl(Builder paramBuilder)
  {
    this.noCache = paramBuilder.noCache;
    this.noStore = paramBuilder.noStore;
    this.maxAgeSeconds = paramBuilder.maxAgeSeconds;
    this.sMaxAgeSeconds = -1;
    this.isPrivate = false;
    this.isPublic = false;
    this.mustRevalidate = false;
    this.maxStaleSeconds = paramBuilder.maxStaleSeconds;
    this.minFreshSeconds = paramBuilder.minFreshSeconds;
    this.onlyIfCached = paramBuilder.onlyIfCached;
    this.noTransform = paramBuilder.noTransform;
    this.immutable = paramBuilder.immutable;
  }

  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, @Nullable String paramString)
  {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPrivate = paramBoolean3;
    this.isPublic = paramBoolean4;
    this.mustRevalidate = paramBoolean5;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean6;
    this.noTransform = paramBoolean7;
    this.immutable = paramBoolean8;
    this.headerValue = paramString;
  }

  private String headerValue()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.noCache)
      localStringBuilder.append("no-cache, ");
    if (this.noStore)
      localStringBuilder.append("no-store, ");
    if (this.maxAgeSeconds != -1)
      localStringBuilder.append("max-age=").append(this.maxAgeSeconds).append(", ");
    if (this.sMaxAgeSeconds != -1)
      localStringBuilder.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
    if (this.isPrivate)
      localStringBuilder.append("private, ");
    if (this.isPublic)
      localStringBuilder.append("public, ");
    if (this.mustRevalidate)
      localStringBuilder.append("must-revalidate, ");
    if (this.maxStaleSeconds != -1)
      localStringBuilder.append("max-stale=").append(this.maxStaleSeconds).append(", ");
    if (this.minFreshSeconds != -1)
      localStringBuilder.append("min-fresh=").append(this.minFreshSeconds).append(", ");
    if (this.onlyIfCached)
      localStringBuilder.append("only-if-cached, ");
    if (this.noTransform)
      localStringBuilder.append("no-transform, ");
    if (this.immutable)
      localStringBuilder.append("immutable, ");
    if (localStringBuilder.length() == 0)
      return "";
    localStringBuilder.delete(-2 + localStringBuilder.length(), localStringBuilder.length());
    return localStringBuilder.toString();
  }

  public static CacheControl parse(Headers paramHeaders)
  {
    boolean bool1 = false;
    int i = -1;
    int j = -1;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    int k = -1;
    int m = -1;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    int n = 1;
    int i1 = paramHeaders.size();
    int i2 = 0;
    Object localObject1 = null;
    boolean bool9;
    for (boolean bool8 = false; i2 < i1; bool8 = bool9)
    {
      String str1 = paramHeaders.name(i2);
      String str2 = paramHeaders.value(i2);
      int i3;
      if (str1.equalsIgnoreCase("Cache-Control"))
        if (localObject1 != null)
        {
          n = 0;
          bool9 = bool8;
          i3 = 0;
        }
      label323: 
      while (true)
        label96: if (i3 < str2.length())
        {
          int i4 = HttpHeaders.skipUntil(str2, i3, "=,;");
          String str3 = str2.substring(i3, i4).trim();
          Object localObject3;
          if ((i4 == str2.length()) || (str2.charAt(i4) == ',') || (str2.charAt(i4) == ';'))
          {
            i3 = i4 + 1;
            localObject3 = null;
          }
          while (true)
          {
            if (!"no-cache".equalsIgnoreCase(str3))
              break label323;
            bool9 = true;
            break label96;
            localObject1 = str2;
            break;
            if (!str1.equalsIgnoreCase("Pragma"))
              break label517;
            n = 0;
            break;
            int i5 = HttpHeaders.skipWhitespace(str2, i4 + 1);
            if ((i5 < str2.length()) && (str2.charAt(i5) == '"'))
            {
              int i7 = i5 + 1;
              int i8 = HttpHeaders.skipUntil(str2, i7, "\"");
              String str5 = str2.substring(i7, i8);
              i3 = i8 + 1;
              localObject3 = str5;
            }
            else
            {
              int i6 = HttpHeaders.skipUntil(str2, i5, ",;");
              String str4 = str2.substring(i5, i6).trim();
              i3 = i6;
              localObject3 = str4;
            }
          }
          if ("no-store".equalsIgnoreCase(str3))
          {
            bool1 = true;
          }
          else if ("max-age".equalsIgnoreCase(str3))
          {
            i = HttpHeaders.parseSeconds(localObject3, -1);
          }
          else if ("s-maxage".equalsIgnoreCase(str3))
          {
            j = HttpHeaders.parseSeconds(localObject3, -1);
          }
          else if ("private".equalsIgnoreCase(str3))
          {
            bool2 = true;
          }
          else if ("public".equalsIgnoreCase(str3))
          {
            bool3 = true;
          }
          else if ("must-revalidate".equalsIgnoreCase(str3))
          {
            bool4 = true;
          }
          else if ("max-stale".equalsIgnoreCase(str3))
          {
            k = HttpHeaders.parseSeconds(localObject3, 2147483647);
          }
          else if ("min-fresh".equalsIgnoreCase(str3))
          {
            m = HttpHeaders.parseSeconds(localObject3, -1);
          }
          else if ("only-if-cached".equalsIgnoreCase(str3))
          {
            bool5 = true;
          }
          else if ("no-transform".equalsIgnoreCase(str3))
          {
            bool6 = true;
          }
          else if ("immutable".equalsIgnoreCase(str3))
          {
            bool7 = true;
            continue;
            bool9 = bool8;
          }
        }
      label517: i2++;
    }
    if (n == 0);
    for (Object localObject2 = null; ; localObject2 = localObject1)
      return new CacheControl(bool8, bool1, i, j, bool2, bool3, bool4, k, m, bool5, bool6, bool7, (String)localObject2);
  }

  public boolean immutable()
  {
    return this.immutable;
  }

  public boolean isPrivate()
  {
    return this.isPrivate;
  }

  public boolean isPublic()
  {
    return this.isPublic;
  }

  public int maxAgeSeconds()
  {
    return this.maxAgeSeconds;
  }

  public int maxStaleSeconds()
  {
    return this.maxStaleSeconds;
  }

  public int minFreshSeconds()
  {
    return this.minFreshSeconds;
  }

  public boolean mustRevalidate()
  {
    return this.mustRevalidate;
  }

  public boolean noCache()
  {
    return this.noCache;
  }

  public boolean noStore()
  {
    return this.noStore;
  }

  public boolean noTransform()
  {
    return this.noTransform;
  }

  public boolean onlyIfCached()
  {
    return this.onlyIfCached;
  }

  public int sMaxAgeSeconds()
  {
    return this.sMaxAgeSeconds;
  }

  public String toString()
  {
    String str1 = this.headerValue;
    if (str1 != null)
      return str1;
    String str2 = headerValue();
    this.headerValue = str2;
    return str2;
  }

  public static final class Builder
  {
    boolean immutable;
    int maxAgeSeconds = -1;
    int maxStaleSeconds = -1;
    int minFreshSeconds = -1;
    boolean noCache;
    boolean noStore;
    boolean noTransform;
    boolean onlyIfCached;

    public CacheControl build()
    {
      return new CacheControl(this);
    }

    public Builder immutable()
    {
      this.immutable = true;
      return this;
    }

    public Builder maxAge(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0)
        throw new IllegalArgumentException("maxAge < 0: " + paramInt);
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L);
      for (int i = 2147483647; ; i = (int)l)
      {
        this.maxAgeSeconds = i;
        return this;
      }
    }

    public Builder maxStale(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0)
        throw new IllegalArgumentException("maxStale < 0: " + paramInt);
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L);
      for (int i = 2147483647; ; i = (int)l)
      {
        this.maxStaleSeconds = i;
        return this;
      }
    }

    public Builder minFresh(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0)
        throw new IllegalArgumentException("minFresh < 0: " + paramInt);
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L);
      for (int i = 2147483647; ; i = (int)l)
      {
        this.minFreshSeconds = i;
        return this;
      }
    }

    public Builder noCache()
    {
      this.noCache = true;
      return this;
    }

    public Builder noStore()
    {
      this.noStore = true;
      return this;
    }

    public Builder noTransform()
    {
      this.noTransform = true;
      return this;
    }

    public Builder onlyIfCached()
    {
      this.onlyIfCached = true;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.CacheControl
 * JD-Core Version:    0.6.2
 */