package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class w extends a
{
  public w a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public x a(x paramx, int paramInt)
  {
    int i = a(14);
    if (i != 0)
      return paramx.a(b(e(i) + paramInt * 4), this.b);
    return null;
  }

  public String b()
  {
    int i = a(4);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public long c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public int d()
  {
    int i = a(8);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public int e()
  {
    int i = a(10);
    if (i != 0)
      return d(i);
    return 0;
  }

  public long f(int paramInt)
  {
    int i = a(10);
    if (i != 0)
      return this.b.getLong(e(i) + paramInt * 8);
    return 0L;
  }

  public boolean f()
  {
    int i = a(12);
    boolean bool = false;
    if (i != 0)
    {
      int j = this.b.get(i + this.a);
      bool = false;
      if (j != 0)
        bool = true;
    }
    return bool;
  }

  public int g()
  {
    int i = a(14);
    if (i != 0)
      return d(i);
    return 0;
  }

  public x g(int paramInt)
  {
    return a(new x(), paramInt);
  }

  public String h()
  {
    int i = a(16);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String i()
  {
    int i = a(18);
    if (i != 0)
      return c(i + this.a);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.w
 * JD-Core Version:    0.6.2
 */