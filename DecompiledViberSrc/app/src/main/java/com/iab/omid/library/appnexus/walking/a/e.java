package com.iab.omid.library.appnexus.walking.a;

import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public class e extends a
{
  public e(b.b paramb, HashSet<String> paramHashSet, JSONObject paramJSONObject, double paramDouble)
  {
    super(paramb, paramHashSet, paramJSONObject, paramDouble);
  }

  private void b(String paramString)
  {
    com.iab.omid.library.appnexus.b.a locala = com.iab.omid.library.appnexus.b.a.a();
    if (locala != null)
    {
      Iterator localIterator = locala.b().iterator();
      while (localIterator.hasNext())
      {
        com.iab.omid.library.appnexus.adsession.a locala1 = (com.iab.omid.library.appnexus.adsession.a)localIterator.next();
        if (this.a.contains(locala1.getAdSessionId()))
          locala1.getAdSessionStatePublisher().b(paramString, this.c);
      }
    }
  }

  protected String a(Object[] paramArrayOfObject)
  {
    return this.b.toString();
  }

  protected void a(String paramString)
  {
    b(paramString);
    super.a(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.walking.a.e
 * JD-Core Version:    0.6.2
 */