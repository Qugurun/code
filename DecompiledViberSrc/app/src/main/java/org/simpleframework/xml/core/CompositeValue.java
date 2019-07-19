package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeValue
  implements Converter
{
  private final Context context;
  private final Entry entry;
  private final Traverser root;
  private final Style style;
  private final Type type;

  public CompositeValue(Context paramContext, Entry paramEntry, Type paramType)
    throws Exception
  {
    this.root = new Traverser(paramContext);
    this.style = paramContext.getStyle();
    this.context = paramContext;
    this.entry = paramEntry;
    this.type = paramType;
  }

  private boolean validate(InputNode paramInputNode, String paramString)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getNext(this.style.getElement(paramString));
    Class localClass = this.type.getType();
    if (localInputNode == null);
    while (localInputNode.isEmpty())
      return true;
    return this.root.validate(localInputNode, localClass);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getNext();
    Class localClass = this.type.getType();
    if (localInputNode == null);
    while (localInputNode.isEmpty())
      return null;
    return this.root.read(localInputNode, localClass);
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    if (paramObject != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = this.entry;
      throw new PersistenceException("Can not read value of %s for %s", arrayOfObject);
    }
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getValue();
    if (str == null)
      str = this.context.getName(localClass);
    return validate(paramInputNode, str);
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str1 = this.entry.getValue();
    if (str1 == null)
      str1 = this.context.getName(localClass);
    String str2 = this.style.getElement(str1);
    this.root.write(paramOutputNode, paramObject, localClass, str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeValue
 * JD-Core Version:    0.6.2
 */