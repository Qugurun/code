package com.viber.voip.backup.d.a;

import com.viber.voip.backup.d.a.a.c.a;
import java.util.List;

public class g extends c
{
  public g(b paramb)
  {
    super(paramb);
  }

  public List<com.viber.voip.backup.d.a.a.c> a()
  {
    List localList = super.a();
    localList.add(new c.a().a(" AND ", "(conversations.flags & 1)", Integer.valueOf(0)).b());
    return localList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.a.g
 * JD-Core Version:    0.6.2
 */