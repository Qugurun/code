package com.adsnative.c;

public class h
{
  public static Double a(Object paramObject)
    throws ClassCastException
  {
    if ((paramObject instanceof Number))
      return Double.valueOf(((Number)paramObject).doubleValue());
    if ((paramObject instanceof String))
      try
      {
        Double localDouble = Double.valueOf((String)paramObject);
        return localDouble;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ClassCastException("Unable to parse " + paramObject + " as double.");
      }
    throw new ClassCastException("Unable to parse " + paramObject + " as double.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.h
 * JD-Core Version:    0.6.2
 */