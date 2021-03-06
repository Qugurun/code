package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementArrayLabel extends TemplateLabel
{
  private boolean data;
  private Decorator decorator;
  private Introspector detail;
  private String entry;
  private Format format;
  private ElementArray label;
  private String name;
  private Expression path;
  private boolean required;
  private Class type;

  public ElementArrayLabel(Contact paramContact, ElementArray paramElementArray, Format paramFormat)
  {
    this.detail = new Introspector(paramContact, this, paramFormat);
    this.decorator = new Qualifier(paramContact);
    this.required = paramElementArray.required();
    this.type = paramContact.getType();
    this.entry = paramElementArray.entry();
    this.data = paramElementArray.data();
    this.name = paramElementArray.name();
    this.format = paramFormat;
    this.label = paramElementArray;
  }

  private Converter getConverter(Context paramContext, String paramString)
    throws Exception
  {
    Type localType = getDependent();
    Contact localContact = getContact();
    if (!paramContext.isPrimitive(localType))
      return new CompositeArray(paramContext, localContact, localType, paramString);
    return new PrimitiveArray(paramContext, localContact, localType, paramString);
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public Contact getContact()
  {
    return this.detail.getContact();
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    Contact localContact = getContact();
    String str = getEntry();
    if (!this.type.isArray())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.type;
      arrayOfObject[1] = localContact;
      throw new InstantiationException("Type is not an array %s for %s", arrayOfObject);
    }
    return getConverter(paramContext, str);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public Type getDependent()
  {
    Class localClass = this.type.getComponentType();
    if (localClass == null)
      return new ClassType(this.type);
    return new ClassType(localClass);
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    ArrayFactory localArrayFactory = new ArrayFactory(paramContext, new ClassType(this.type));
    if (!this.label.empty())
      return localArrayFactory.getInstance();
    return null;
  }

  public String getEntry()
    throws Exception
  {
    Style localStyle = this.format.getStyle();
    if (this.detail.isEmpty(this.entry))
      this.entry = this.detail.getEntry();
    return localStyle.getElement(this.entry);
  }

  public Expression getExpression()
    throws Exception
  {
    if (this.path == null)
      this.path = this.detail.getExpression();
    return this.path;
  }

  public String getName()
    throws Exception
  {
    return this.format.getStyle().getElement(this.detail.getName());
  }

  public String getOverride()
  {
    return this.name;
  }

  public String getPath()
    throws Exception
  {
    return getExpression().getElement(getName());
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isData()
  {
    return this.data;
  }

  public boolean isRequired()
  {
    return this.required;
  }

  public String toString()
  {
    return this.detail.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ElementArrayLabel
 * JD-Core Version:    0.6.2
 */