package com.viber.voip.s.a;

import com.viber.voip.s.a;

public class c extends ai
{
  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(768).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM blockednumbers LEFT OUTER JOIN vibernumbers ON (vibernumbers.member_id=blockednumbers.canonized_number)");
    if ((paramString1 != null) && (!paramString1.isEmpty()))
      localStringBuilder.append(" WHERE ").append(paramString1);
    localStringBuilder.append(" GROUP BY blockednumbers.canonized_number ");
    if ((paramString4 != null) && (!paramString4.isEmpty()))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.c
 * JD-Core Version:    0.6.2
 */