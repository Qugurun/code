package org.simpleframework.xml;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ElementArray
{
  public abstract boolean data();

  public abstract boolean empty();

  public abstract String entry();

  public abstract String name();

  public abstract boolean required();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.ElementArray
 * JD-Core Version:    0.6.2
 */