package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.InputStream;
import sun.misc.Unsafe;

public final class UnsafeInput extends Input
{
  private boolean varIntsEnabled = false;

  public UnsafeInput()
  {
  }

  public UnsafeInput(int paramInt)
  {
    super(paramInt);
  }

  public UnsafeInput(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public UnsafeInput(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt);
  }

  public UnsafeInput(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }

  public UnsafeInput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte, paramInt1, paramInt2);
  }

  private final void readBytes(Object paramObject, long paramLong1, long paramLong2, int paramInt)
    throws KryoException
  {
    int i = Math.min(this.limit - this.position, paramInt);
    while (true)
    {
      UnsafeUtil.unsafe().copyMemory(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramObject, paramLong1 + paramLong2, i);
      this.position = (i + this.position);
      paramInt -= i;
      if (paramInt == 0)
        return;
      paramLong2 += i;
      int j = this.capacity;
      i = Math.min(paramInt, j);
      require(i);
    }
  }

  public boolean getVarIntsEnabled()
  {
    return this.varIntsEnabled;
  }

  public final void readBytes(Object paramObject, long paramLong1, long paramLong2)
    throws KryoException
  {
    if (paramObject.getClass().isArray())
    {
      readBytes(paramObject, 0L, paramLong1, (int)paramLong2);
      return;
    }
    throw new KryoException("Only bulk reads of arrays is supported");
  }

  public final char[] readChars(int paramInt)
    throws KryoException
  {
    int i = paramInt << 1;
    char[] arrayOfChar = new char[paramInt];
    readBytes(arrayOfChar, UnsafeUtil.charArrayBaseOffset, 0L, i);
    return arrayOfChar;
  }

  public double readDouble()
    throws KryoException
  {
    require(8);
    double d = UnsafeUtil.unsafe().getDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
    this.position = (8 + this.position);
    return d;
  }

  public final double[] readDoubles(int paramInt)
    throws KryoException
  {
    int i = paramInt << 3;
    double[] arrayOfDouble = new double[paramInt];
    readBytes(arrayOfDouble, UnsafeUtil.doubleArrayBaseOffset, 0L, i);
    return arrayOfDouble;
  }

  public float readFloat()
    throws KryoException
  {
    require(4);
    float f = UnsafeUtil.unsafe().getFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
    this.position = (4 + this.position);
    return f;
  }

  public final float[] readFloats(int paramInt)
    throws KryoException
  {
    int i = paramInt << 2;
    float[] arrayOfFloat = new float[paramInt];
    readBytes(arrayOfFloat, UnsafeUtil.floatArrayBaseOffset, 0L, i);
    return arrayOfFloat;
  }

  public int readInt()
    throws KryoException
  {
    require(4);
    int i = UnsafeUtil.unsafe().getInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
    this.position = (4 + this.position);
    return i;
  }

  public int readInt(boolean paramBoolean)
    throws KryoException
  {
    if (!this.varIntsEnabled)
      return readInt();
    return super.readInt(paramBoolean);
  }

  public final int[] readInts(int paramInt)
    throws KryoException
  {
    int i = paramInt << 2;
    int[] arrayOfInt = new int[paramInt];
    readBytes(arrayOfInt, UnsafeUtil.intArrayBaseOffset, 0L, i);
    return arrayOfInt;
  }

  public final int[] readInts(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    if (!this.varIntsEnabled)
    {
      int i = paramInt << 2;
      int[] arrayOfInt = new int[paramInt];
      readBytes(arrayOfInt, UnsafeUtil.intArrayBaseOffset, 0L, i);
      return arrayOfInt;
    }
    return super.readInts(paramInt, paramBoolean);
  }

  public long readLong()
    throws KryoException
  {
    require(8);
    long l = UnsafeUtil.unsafe().getLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
    this.position = (8 + this.position);
    return l;
  }

  public long readLong(boolean paramBoolean)
    throws KryoException
  {
    if (!this.varIntsEnabled)
      return readLong();
    return super.readLong(paramBoolean);
  }

  public final long[] readLongs(int paramInt)
    throws KryoException
  {
    int i = paramInt << 3;
    long[] arrayOfLong = new long[paramInt];
    readBytes(arrayOfLong, UnsafeUtil.longArrayBaseOffset, 0L, i);
    return arrayOfLong;
  }

  public final long[] readLongs(int paramInt, boolean paramBoolean)
    throws KryoException
  {
    if (!this.varIntsEnabled)
    {
      int i = paramInt << 3;
      long[] arrayOfLong = new long[paramInt];
      readBytes(arrayOfLong, UnsafeUtil.longArrayBaseOffset, 0L, i);
      return arrayOfLong;
    }
    return super.readLongs(paramInt, paramBoolean);
  }

  public short readShort()
    throws KryoException
  {
    require(2);
    short s = UnsafeUtil.unsafe().getShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
    this.position = (2 + this.position);
    return s;
  }

  public final short[] readShorts(int paramInt)
    throws KryoException
  {
    int i = paramInt << 1;
    short[] arrayOfShort = new short[paramInt];
    readBytes(arrayOfShort, UnsafeUtil.shortArrayBaseOffset, 0L, i);
    return arrayOfShort;
  }

  public void setVarIntsEnabled(boolean paramBoolean)
  {
    this.varIntsEnabled = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.UnsafeInput
 * JD-Core Version:    0.6.2
 */