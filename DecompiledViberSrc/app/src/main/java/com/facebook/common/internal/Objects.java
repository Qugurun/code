package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Objects
{
  @CheckReturnValue
  public static boolean equal(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static <T> T firstNonNull(@Nullable T paramT1, @Nullable T paramT2)
  {
    if (paramT1 != null)
      return paramT1;
    return Preconditions.checkNotNull(paramT2);
  }

  public static int hashCode(@Nullable Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }

  private static String simpleName(Class<?> paramClass)
  {
    String str = paramClass.getName().replaceAll("\\$[0-9]+", "\\$");
    int i = str.lastIndexOf('$');
    if (i == -1)
      i = str.lastIndexOf('.');
    return str.substring(i + 1);
  }

  public static ToStringHelper toStringHelper(Class<?> paramClass)
  {
    return new ToStringHelper(simpleName(paramClass), null);
  }

  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(simpleName(paramObject.getClass()), null);
  }

  public static ToStringHelper toStringHelper(String paramString)
  {
    return new ToStringHelper(paramString, null);
  }

  public static final class ToStringHelper
  {
    private final String className;
    private ValueHolder holderHead = new ValueHolder(null);
    private ValueHolder holderTail = this.holderHead;
    private boolean omitNullValues = false;

    private ToStringHelper(String paramString)
    {
      this.className = ((String)Preconditions.checkNotNull(paramString));
    }

    private ValueHolder addHolder()
    {
      ValueHolder localValueHolder = new ValueHolder(null);
      this.holderTail.next = localValueHolder;
      this.holderTail = localValueHolder;
      return localValueHolder;
    }

    private ToStringHelper addHolder(@Nullable Object paramObject)
    {
      addHolder().value = paramObject;
      return this;
    }

    private ToStringHelper addHolder(String paramString, @Nullable Object paramObject)
    {
      ValueHolder localValueHolder = addHolder();
      localValueHolder.value = paramObject;
      localValueHolder.name = ((String)Preconditions.checkNotNull(paramString));
      return this;
    }

    public ToStringHelper add(String paramString, char paramChar)
    {
      return addHolder(paramString, String.valueOf(paramChar));
    }

    public ToStringHelper add(String paramString, double paramDouble)
    {
      return addHolder(paramString, String.valueOf(paramDouble));
    }

    public ToStringHelper add(String paramString, float paramFloat)
    {
      return addHolder(paramString, String.valueOf(paramFloat));
    }

    public ToStringHelper add(String paramString, int paramInt)
    {
      return addHolder(paramString, String.valueOf(paramInt));
    }

    public ToStringHelper add(String paramString, long paramLong)
    {
      return addHolder(paramString, String.valueOf(paramLong));
    }

    public ToStringHelper add(String paramString, @Nullable Object paramObject)
    {
      return addHolder(paramString, paramObject);
    }

    public ToStringHelper add(String paramString, boolean paramBoolean)
    {
      return addHolder(paramString, String.valueOf(paramBoolean));
    }

    public ToStringHelper addValue(char paramChar)
    {
      return addHolder(String.valueOf(paramChar));
    }

    public ToStringHelper addValue(double paramDouble)
    {
      return addHolder(String.valueOf(paramDouble));
    }

    public ToStringHelper addValue(float paramFloat)
    {
      return addHolder(String.valueOf(paramFloat));
    }

    public ToStringHelper addValue(int paramInt)
    {
      return addHolder(String.valueOf(paramInt));
    }

    public ToStringHelper addValue(long paramLong)
    {
      return addHolder(String.valueOf(paramLong));
    }

    public ToStringHelper addValue(@Nullable Object paramObject)
    {
      return addHolder(paramObject);
    }

    public ToStringHelper addValue(boolean paramBoolean)
    {
      return addHolder(String.valueOf(paramBoolean));
    }

    public ToStringHelper omitNullValues()
    {
      this.omitNullValues = true;
      return this;
    }

    public String toString()
    {
      boolean bool = this.omitNullValues;
      StringBuilder localStringBuilder = new StringBuilder(32).append(this.className).append('{');
      ValueHolder localValueHolder1 = this.holderHead.next;
      String str = "";
      for (ValueHolder localValueHolder2 = localValueHolder1; localValueHolder2 != null; localValueHolder2 = localValueHolder2.next)
        if ((!bool) || (localValueHolder2.value != null))
        {
          localStringBuilder.append(str);
          str = ", ";
          if (localValueHolder2.name != null)
            localStringBuilder.append(localValueHolder2.name).append('=');
          localStringBuilder.append(localValueHolder2.value);
        }
      return '}';
    }

    private static final class ValueHolder
    {

      @Nullable
      String name;
      ValueHolder next;

      @Nullable
      Object value;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.Objects
 * JD-Core Version:    0.6.2
 */