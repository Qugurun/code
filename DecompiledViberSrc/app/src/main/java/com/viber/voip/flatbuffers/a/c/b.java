package com.viber.voip.flatbuffers.a.c;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class b extends a
{
  public b a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public int b()
  {
    int i = a(4);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public int c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public int d()
  {
    int i = a(8);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public String e()
  {
    int i = a(10);
    if (i != 0)
      return c(i + this.a);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.c.b
 * JD-Core Version:    0.6.2
 */