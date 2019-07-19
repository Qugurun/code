package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.compat.R.styleable;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 500;
  public static final int FETCH_STRATEGY_ASYNC = 1;
  public static final int FETCH_STRATEGY_BLOCKING = 0;
  public static final int INFINITE_TIMEOUT_VALUE = -1;
  private static final int ITALIC = 1;
  private static final int NORMAL_WEIGHT = 400;

  private static int getType(TypedArray paramTypedArray, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramTypedArray.getType(paramInt);
    TypedValue localTypedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, localTypedValue);
    return localTypedValue.type;
  }

  public static FamilyResourceEntry parse(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    int i;
    do
      i = paramXmlPullParser.next();
    while ((i != 2) && (i != 1));
    if (i != 2)
      throw new XmlPullParserException("No start tag found");
    return readFamilies(paramXmlPullParser, paramResources);
  }

  public static List<List<byte[]>> readCerts(Resources paramResources, int paramInt)
  {
    if (paramInt == 0)
      return Collections.emptyList();
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    while (true)
    {
      int j;
      try
      {
        if (localTypedArray.length() == 0)
        {
          List localList = Collections.emptyList();
          return localList;
        }
        ArrayList localArrayList = new ArrayList();
        int i = getType(localTypedArray, 0);
        j = 0;
        if (i == 1)
        {
          if (j < localTypedArray.length())
          {
            int k = localTypedArray.getResourceId(j, 0);
            if (k == 0)
              break label131;
            localArrayList.add(toByteArrayList(paramResources.getStringArray(k)));
            break label131;
          }
        }
        else
          localArrayList.add(toByteArrayList(paramResources.getStringArray(paramInt)));
        return localArrayList;
      }
      finally
      {
        localTypedArray.recycle();
      }
      label131: j++;
    }
  }

  private static FamilyResourceEntry readFamilies(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family"))
      return readFamily(paramXmlPullParser, paramResources);
    skip(paramXmlPullParser);
    return null;
  }

  private static FamilyResourceEntry readFamily(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamily);
    String str1 = localTypedArray.getString(R.styleable.FontFamily_fontProviderAuthority);
    String str2 = localTypedArray.getString(R.styleable.FontFamily_fontProviderPackage);
    String str3 = localTypedArray.getString(R.styleable.FontFamily_fontProviderQuery);
    int i = localTypedArray.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
    int j = localTypedArray.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
    int k = localTypedArray.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
    localTypedArray.recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3)
        skip(paramXmlPullParser);
      return new ProviderResourceEntry(new FontRequest(str1, str2, str3, readCerts(paramResources, i)), j, k);
    }
    ArrayList localArrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3)
      if (paramXmlPullParser.getEventType() == 2)
        if (paramXmlPullParser.getName().equals("font"))
          localArrayList.add(readFont(paramXmlPullParser, paramResources));
        else
          skip(paramXmlPullParser);
    if (localArrayList.isEmpty())
      return null;
    return new FontFamilyFilesResourceEntry((FontFileResourceEntry[])localArrayList.toArray(new FontFileResourceEntry[localArrayList.size()]));
  }

  private static FontFileResourceEntry readFont(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    int i = 1;
    TypedArray localTypedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
    int j;
    int k;
    int m;
    label55: label66: int n;
    label81: int i1;
    label96: String str1;
    int i2;
    if (localTypedArray.hasValue(R.styleable.FontFamilyFont_fontWeight))
    {
      j = R.styleable.FontFamilyFont_fontWeight;
      k = localTypedArray.getInt(j, 400);
      if (!localTypedArray.hasValue(R.styleable.FontFamilyFont_fontStyle))
        break label174;
      m = R.styleable.FontFamilyFont_fontStyle;
      if (i != localTypedArray.getInt(m, 0))
        break label182;
      if (!localTypedArray.hasValue(R.styleable.FontFamilyFont_ttcIndex))
        break label187;
      n = R.styleable.FontFamilyFont_ttcIndex;
      if (!localTypedArray.hasValue(R.styleable.FontFamilyFont_fontVariationSettings))
        break label195;
      i1 = R.styleable.FontFamilyFont_fontVariationSettings;
      str1 = localTypedArray.getString(i1);
      i2 = localTypedArray.getInt(n, 0);
      if (!localTypedArray.hasValue(R.styleable.FontFamilyFont_font))
        break label203;
    }
    int i4;
    String str2;
    label174: label182: label187: label195: label203: for (int i3 = R.styleable.FontFamilyFont_font; ; i3 = R.styleable.FontFamilyFont_android_font)
    {
      i4 = localTypedArray.getResourceId(i3, 0);
      str2 = localTypedArray.getString(i3);
      localTypedArray.recycle();
      while (paramXmlPullParser.next() != 3)
        skip(paramXmlPullParser);
      j = R.styleable.FontFamilyFont_android_fontWeight;
      break;
      m = R.styleable.FontFamilyFont_android_fontStyle;
      break label55;
      i = 0;
      break label66;
      n = R.styleable.FontFamilyFont_android_ttcIndex;
      break label81;
      i1 = R.styleable.FontFamilyFont_android_fontVariationSettings;
      break label96;
    }
    return new FontFileResourceEntry(str2, k, i, str1, i2, i4);
  }

  private static void skip(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = 1;
    while (i > 0)
      switch (paramXmlPullParser.next())
      {
      default:
        break;
      case 2:
        i++;
        break;
      case 3:
        i--;
      }
  }

  private static List<byte[]> toByteArrayList(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(Base64.decode(paramArrayOfString[j], 0));
    return localArrayList;
  }

  public static abstract interface FamilyResourceEntry
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface FetchStrategy
  {
  }

  public static final class FontFamilyFilesResourceEntry
    implements FontResourcesParserCompat.FamilyResourceEntry
  {
    private final FontResourcesParserCompat.FontFileResourceEntry[] mEntries;

    public FontFamilyFilesResourceEntry(FontResourcesParserCompat.FontFileResourceEntry[] paramArrayOfFontFileResourceEntry)
    {
      this.mEntries = paramArrayOfFontFileResourceEntry;
    }

    public FontResourcesParserCompat.FontFileResourceEntry[] getEntries()
    {
      return this.mEntries;
    }
  }

  public static final class FontFileResourceEntry
  {
    private final String mFileName;
    private boolean mItalic;
    private int mResourceId;
    private int mTtcIndex;
    private String mVariationSettings;
    private int mWeight;

    public FontFileResourceEntry(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2, int paramInt3)
    {
      this.mFileName = paramString1;
      this.mWeight = paramInt1;
      this.mItalic = paramBoolean;
      this.mVariationSettings = paramString2;
      this.mTtcIndex = paramInt2;
      this.mResourceId = paramInt3;
    }

    public String getFileName()
    {
      return this.mFileName;
    }

    public int getResourceId()
    {
      return this.mResourceId;
    }

    public int getTtcIndex()
    {
      return this.mTtcIndex;
    }

    public String getVariationSettings()
    {
      return this.mVariationSettings;
    }

    public int getWeight()
    {
      return this.mWeight;
    }

    public boolean isItalic()
    {
      return this.mItalic;
    }
  }

  public static final class ProviderResourceEntry
    implements FontResourcesParserCompat.FamilyResourceEntry
  {
    private final FontRequest mRequest;
    private final int mStrategy;
    private final int mTimeoutMs;

    public ProviderResourceEntry(FontRequest paramFontRequest, int paramInt1, int paramInt2)
    {
      this.mRequest = paramFontRequest;
      this.mStrategy = paramInt1;
      this.mTimeoutMs = paramInt2;
    }

    public int getFetchStrategy()
    {
      return this.mStrategy;
    }

    public FontRequest getRequest()
    {
      return this.mRequest;
    }

    public int getTimeout()
    {
      return this.mTimeoutMs;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.FontResourcesParserCompat
 * JD-Core Version:    0.6.2
 */