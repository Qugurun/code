package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class ox
{
  protected static final Comparator<byte[]> a = new Comparator()
  {
  };
  private List<byte[]> b = new LinkedList();
  private List<byte[]> c = new ArrayList(64);
  private int d = 0;
  private final int e;

  public ox(int paramInt)
  {
    this.e = paramInt;
  }

  private void a()
  {
    try
    {
      if (this.d > this.e)
      {
        byte[] arrayOfByte = (byte[])this.b.remove(0);
        this.c.remove(arrayOfByte);
        this.d -= arrayOfByte.length;
      }
    }
    finally
    {
    }
  }

  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null);
    try
    {
      int i = paramArrayOfByte.length;
      int j = this.e;
      if (i > j);
      while (true)
      {
        return;
        this.b.add(paramArrayOfByte);
        int k = Collections.binarySearch(this.c, paramArrayOfByte, a);
        if (k < 0)
          k = -1 + -k;
        this.c.add(k, paramArrayOfByte);
        this.d += paramArrayOfByte.length;
        a();
      }
    }
    finally
    {
    }
  }

  public final byte[] a(int paramInt)
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte;
      if (i < this.c.size())
      {
        arrayOfByte = (byte[])this.c.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.d -= arrayOfByte.length;
          this.c.remove(i);
          this.b.remove(arrayOfByte);
        }
      }
      while (true)
      {
        return arrayOfByte;
        i++;
        break;
        arrayOfByte = new byte[paramInt];
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ox
 * JD-Core Version:    0.6.2
 */