package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
{
  private static final Pattern a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
  private static final Pattern b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
  private static final Pattern c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
  private static final Map<String, Integer> d = new HashMap();

  static
  {
    d.put("aliceblue", Integer.valueOf(-984833));
    d.put("antiquewhite", Integer.valueOf(-332841));
    d.put("aqua", Integer.valueOf(-16711681));
    d.put("aquamarine", Integer.valueOf(-8388652));
    d.put("azure", Integer.valueOf(-983041));
    d.put("beige", Integer.valueOf(-657956));
    d.put("bisque", Integer.valueOf(-6972));
    d.put("black", Integer.valueOf(-16777216));
    d.put("blanchedalmond", Integer.valueOf(-5171));
    d.put("blue", Integer.valueOf(-16776961));
    d.put("blueviolet", Integer.valueOf(-7722014));
    d.put("brown", Integer.valueOf(-5952982));
    d.put("burlywood", Integer.valueOf(-2180985));
    d.put("cadetblue", Integer.valueOf(-10510688));
    d.put("chartreuse", Integer.valueOf(-8388864));
    d.put("chocolate", Integer.valueOf(-2987746));
    d.put("coral", Integer.valueOf(-32944));
    d.put("cornflowerblue", Integer.valueOf(-10185235));
    d.put("cornsilk", Integer.valueOf(-1828));
    d.put("crimson", Integer.valueOf(-2354116));
    d.put("cyan", Integer.valueOf(-16711681));
    d.put("darkblue", Integer.valueOf(-16777077));
    d.put("darkcyan", Integer.valueOf(-16741493));
    d.put("darkgoldenrod", Integer.valueOf(-4684277));
    d.put("darkgray", Integer.valueOf(-5658199));
    d.put("darkgreen", Integer.valueOf(-16751616));
    d.put("darkgrey", Integer.valueOf(-5658199));
    d.put("darkkhaki", Integer.valueOf(-4343957));
    d.put("darkmagenta", Integer.valueOf(-7667573));
    d.put("darkolivegreen", Integer.valueOf(-11179217));
    d.put("darkorange", Integer.valueOf(-29696));
    d.put("darkorchid", Integer.valueOf(-6737204));
    d.put("darkred", Integer.valueOf(-7667712));
    d.put("darksalmon", Integer.valueOf(-1468806));
    d.put("darkseagreen", Integer.valueOf(-7357297));
    d.put("darkslateblue", Integer.valueOf(-12042869));
    d.put("darkslategray", Integer.valueOf(-13676721));
    d.put("darkslategrey", Integer.valueOf(-13676721));
    d.put("darkturquoise", Integer.valueOf(-16724271));
    d.put("darkviolet", Integer.valueOf(-7077677));
    d.put("deeppink", Integer.valueOf(-60269));
    d.put("deepskyblue", Integer.valueOf(-16728065));
    d.put("dimgray", Integer.valueOf(-9868951));
    d.put("dimgrey", Integer.valueOf(-9868951));
    d.put("dodgerblue", Integer.valueOf(-14774017));
    d.put("firebrick", Integer.valueOf(-5103070));
    d.put("floralwhite", Integer.valueOf(-1296));
    d.put("forestgreen", Integer.valueOf(-14513374));
    d.put("fuchsia", Integer.valueOf(-65281));
    d.put("gainsboro", Integer.valueOf(-2302756));
    d.put("ghostwhite", Integer.valueOf(-460545));
    d.put("gold", Integer.valueOf(-10496));
    d.put("goldenrod", Integer.valueOf(-2448096));
    d.put("gray", Integer.valueOf(-8355712));
    d.put("green", Integer.valueOf(-16744448));
    d.put("greenyellow", Integer.valueOf(-5374161));
    d.put("grey", Integer.valueOf(-8355712));
    d.put("honeydew", Integer.valueOf(-983056));
    d.put("hotpink", Integer.valueOf(-38476));
    d.put("indianred", Integer.valueOf(-3318692));
    d.put("indigo", Integer.valueOf(-11861886));
    d.put("ivory", Integer.valueOf(-16));
    d.put("khaki", Integer.valueOf(-989556));
    d.put("lavender", Integer.valueOf(-1644806));
    d.put("lavenderblush", Integer.valueOf(-3851));
    d.put("lawngreen", Integer.valueOf(-8586240));
    d.put("lemonchiffon", Integer.valueOf(-1331));
    d.put("lightblue", Integer.valueOf(-5383962));
    d.put("lightcoral", Integer.valueOf(-1015680));
    d.put("lightcyan", Integer.valueOf(-2031617));
    d.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    d.put("lightgray", Integer.valueOf(-2894893));
    d.put("lightgreen", Integer.valueOf(-7278960));
    d.put("lightgrey", Integer.valueOf(-2894893));
    d.put("lightpink", Integer.valueOf(-18751));
    d.put("lightsalmon", Integer.valueOf(-24454));
    d.put("lightseagreen", Integer.valueOf(-14634326));
    d.put("lightskyblue", Integer.valueOf(-7876870));
    d.put("lightslategray", Integer.valueOf(-8943463));
    d.put("lightslategrey", Integer.valueOf(-8943463));
    d.put("lightsteelblue", Integer.valueOf(-5192482));
    d.put("lightyellow", Integer.valueOf(-32));
    d.put("lime", Integer.valueOf(-16711936));
    d.put("limegreen", Integer.valueOf(-13447886));
    d.put("linen", Integer.valueOf(-331546));
    d.put("magenta", Integer.valueOf(-65281));
    d.put("maroon", Integer.valueOf(-8388608));
    d.put("mediumaquamarine", Integer.valueOf(-10039894));
    d.put("mediumblue", Integer.valueOf(-16777011));
    d.put("mediumorchid", Integer.valueOf(-4565549));
    d.put("mediumpurple", Integer.valueOf(-7114533));
    d.put("mediumseagreen", Integer.valueOf(-12799119));
    d.put("mediumslateblue", Integer.valueOf(-8689426));
    d.put("mediumspringgreen", Integer.valueOf(-16713062));
    d.put("mediumturquoise", Integer.valueOf(-12004916));
    d.put("mediumvioletred", Integer.valueOf(-3730043));
    d.put("midnightblue", Integer.valueOf(-15132304));
    d.put("mintcream", Integer.valueOf(-655366));
    d.put("mistyrose", Integer.valueOf(-6943));
    d.put("moccasin", Integer.valueOf(-6987));
    d.put("navajowhite", Integer.valueOf(-8531));
    d.put("navy", Integer.valueOf(-16777088));
    d.put("oldlace", Integer.valueOf(-133658));
    d.put("olive", Integer.valueOf(-8355840));
    d.put("olivedrab", Integer.valueOf(-9728477));
    d.put("orange", Integer.valueOf(-23296));
    d.put("orangered", Integer.valueOf(-47872));
    d.put("orchid", Integer.valueOf(-2461482));
    d.put("palegoldenrod", Integer.valueOf(-1120086));
    d.put("palegreen", Integer.valueOf(-6751336));
    d.put("paleturquoise", Integer.valueOf(-5247250));
    d.put("palevioletred", Integer.valueOf(-2396013));
    d.put("papayawhip", Integer.valueOf(-4139));
    d.put("peachpuff", Integer.valueOf(-9543));
    d.put("peru", Integer.valueOf(-3308225));
    d.put("pink", Integer.valueOf(-16181));
    d.put("plum", Integer.valueOf(-2252579));
    d.put("powderblue", Integer.valueOf(-5185306));
    d.put("purple", Integer.valueOf(-8388480));
    d.put("rebeccapurple", Integer.valueOf(-10079335));
    d.put("red", Integer.valueOf(-65536));
    d.put("rosybrown", Integer.valueOf(-4419697));
    d.put("royalblue", Integer.valueOf(-12490271));
    d.put("saddlebrown", Integer.valueOf(-7650029));
    d.put("salmon", Integer.valueOf(-360334));
    d.put("sandybrown", Integer.valueOf(-744352));
    d.put("seagreen", Integer.valueOf(-13726889));
    d.put("seashell", Integer.valueOf(-2578));
    d.put("sienna", Integer.valueOf(-6270419));
    d.put("silver", Integer.valueOf(-4144960));
    d.put("skyblue", Integer.valueOf(-7876885));
    d.put("slateblue", Integer.valueOf(-9807155));
    d.put("slategray", Integer.valueOf(-9404272));
    d.put("slategrey", Integer.valueOf(-9404272));
    d.put("snow", Integer.valueOf(-1286));
    d.put("springgreen", Integer.valueOf(-16711809));
    d.put("steelblue", Integer.valueOf(-12156236));
    d.put("tan", Integer.valueOf(-2968436));
    d.put("teal", Integer.valueOf(-16744320));
    d.put("thistle", Integer.valueOf(-2572328));
    d.put("tomato", Integer.valueOf(-40121));
    d.put("transparent", Integer.valueOf(0));
    d.put("turquoise", Integer.valueOf(-12525360));
    d.put("violet", Integer.valueOf(-1146130));
    d.put("wheat", Integer.valueOf(-663885));
    d.put("white", Integer.valueOf(-1));
    d.put("whitesmoke", Integer.valueOf(-657931));
    d.put("yellow", Integer.valueOf(-256));
    d.put("yellowgreen", Integer.valueOf(-6632142));
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(255, paramInt1, paramInt2, paramInt3);
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt4 | (paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8);
  }

  public static int a(String paramString)
  {
    return a(paramString, false);
  }

  private static int a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString));
    String str;
    int j;
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      str = paramString.replace(" ", "");
      if (str.charAt(0) != '#')
        break label100;
      j = (int)Long.parseLong(str.substring(1), 16);
      if (str.length() != 7)
        break;
      return j | 0xFF000000;
    }
    if (str.length() == 9)
      return (j & 0xFF) << 24 | j >>> 8;
    throw new IllegalArgumentException();
    label100: if (str.startsWith("rgba"))
    {
      Pattern localPattern;
      Matcher localMatcher2;
      if (paramBoolean)
      {
        localPattern = c;
        localMatcher2 = localPattern.matcher(str);
        if (!localMatcher2.matches())
          break label310;
        if (!paramBoolean)
          break label202;
      }
      for (int i = (int)(255.0F * Float.parseFloat(localMatcher2.group(4))); ; i = Integer.parseInt(localMatcher2.group(4), 10))
      {
        return a(i, Integer.parseInt(localMatcher2.group(1), 10), Integer.parseInt(localMatcher2.group(2), 10), Integer.parseInt(localMatcher2.group(3), 10));
        localPattern = b;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      Matcher localMatcher1 = a.matcher(str);
      if (localMatcher1.matches())
        return a(Integer.parseInt(localMatcher1.group(1), 10), Integer.parseInt(localMatcher1.group(2), 10), Integer.parseInt(localMatcher1.group(3), 10));
    }
    else
    {
      Integer localInteger = (Integer)d.get(ag.d(str));
      if (localInteger != null)
        return localInteger.intValue();
    }
    label202: throw new IllegalArgumentException();
  }

  public static int b(String paramString)
  {
    return a(paramString, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.d
 * JD-Core Version:    0.6.2
 */