package org.simpleframework.xml.stream;

import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class NodeWriter
{
  private final Set active;
  private final OutputStack stack;
  private final boolean verbose;
  private final Formatter writer;

  public NodeWriter(Writer paramWriter)
  {
    this(paramWriter, new Format());
  }

  public NodeWriter(Writer paramWriter, Format paramFormat)
  {
    this(paramWriter, paramFormat, false);
  }

  private NodeWriter(Writer paramWriter, Format paramFormat, boolean paramBoolean)
  {
    this.writer = new Formatter(paramWriter, paramFormat);
    this.active = new HashSet();
    this.stack = new OutputStack(this.active);
    this.verbose = paramBoolean;
  }

  private void writeAttributes(OutputNode paramOutputNode)
    throws Exception
  {
    NodeMap localNodeMap = paramOutputNode.getAttributes();
    Iterator localIterator = localNodeMap.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      OutputNode localOutputNode = (OutputNode)localNodeMap.get(str1);
      String str2 = localOutputNode.getValue();
      String str3 = localOutputNode.getPrefix(this.verbose);
      this.writer.writeAttribute(str1, str2, str3);
    }
    this.active.remove(paramOutputNode);
  }

  private void writeComment(OutputNode paramOutputNode)
    throws Exception
  {
    String str = paramOutputNode.getComment();
    if (str != null)
      this.writer.writeComment(str);
  }

  private void writeEnd(OutputNode paramOutputNode)
    throws Exception
  {
    String str1 = paramOutputNode.getName();
    String str2 = paramOutputNode.getPrefix(this.verbose);
    if (paramOutputNode.getValue() != null)
      writeValue(paramOutputNode);
    if (str1 != null)
    {
      this.writer.writeEnd(str1, str2);
      this.writer.flush();
    }
  }

  private void writeName(OutputNode paramOutputNode)
    throws Exception
  {
    String str1 = paramOutputNode.getPrefix(this.verbose);
    String str2 = paramOutputNode.getName();
    if (str2 != null)
      this.writer.writeStart(str2, str1);
  }

  private void writeNamespaces(OutputNode paramOutputNode)
    throws Exception
  {
    NamespaceMap localNamespaceMap = paramOutputNode.getNamespaces();
    Iterator localIterator = localNamespaceMap.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = localNamespaceMap.getPrefix(str1);
      this.writer.writeNamespace(str1, str2);
    }
  }

  private OutputNode writeStart(OutputNode paramOutputNode, String paramString)
    throws Exception
  {
    OutputElement localOutputElement = new OutputElement(paramOutputNode, this, paramString);
    if (paramString == null)
      throw new NodeException("Can not have a null name");
    return this.stack.push(localOutputElement);
  }

  private void writeStart(OutputNode paramOutputNode)
    throws Exception
  {
    writeComment(paramOutputNode);
    writeName(paramOutputNode);
    writeAttributes(paramOutputNode);
    writeNamespaces(paramOutputNode);
  }

  private void writeValue(OutputNode paramOutputNode)
    throws Exception
  {
    Mode localMode1 = paramOutputNode.getMode();
    String str = paramOutputNode.getValue();
    Iterator localIterator;
    if (str != null)
      localIterator = this.stack.iterator();
    OutputNode localOutputNode;
    for (Mode localMode2 = localMode1; ; localMode2 = localOutputNode.getMode())
      if (localIterator.hasNext())
      {
        localOutputNode = (OutputNode)localIterator.next();
        if (localMode2 == Mode.INHERIT);
      }
      else
      {
        this.writer.writeText(str, localMode2);
        paramOutputNode.setValue(null);
        return;
      }
  }

  public void commit(OutputNode paramOutputNode)
    throws Exception
  {
    if (this.stack.contains(paramOutputNode))
    {
      OutputNode localOutputNode = this.stack.top();
      if (!isCommitted(localOutputNode))
        writeStart(localOutputNode);
      while (this.stack.top() != paramOutputNode)
        writeEnd(this.stack.pop());
      writeEnd(paramOutputNode);
      this.stack.pop();
    }
  }

  public boolean isCommitted(OutputNode paramOutputNode)
  {
    return !this.active.contains(paramOutputNode);
  }

  public boolean isRoot(OutputNode paramOutputNode)
  {
    return this.stack.bottom() == paramOutputNode;
  }

  public void remove(OutputNode paramOutputNode)
    throws Exception
  {
    if (this.stack.top() != paramOutputNode)
      throw new NodeException("Cannot remove node");
    this.stack.pop();
  }

  public OutputNode writeElement(OutputNode paramOutputNode, String paramString)
    throws Exception
  {
    if (this.stack.isEmpty())
      return writeStart(paramOutputNode, paramString);
    if (this.stack.contains(paramOutputNode))
    {
      OutputNode localOutputNode = this.stack.top();
      if (!isCommitted(localOutputNode))
        writeStart(localOutputNode);
      while (this.stack.top() != paramOutputNode)
        writeEnd(this.stack.pop());
      if (!this.stack.isEmpty())
        writeValue(paramOutputNode);
      return writeStart(paramOutputNode, paramString);
    }
    return null;
  }

  public OutputNode writeRoot()
    throws Exception
  {
    OutputDocument localOutputDocument = new OutputDocument(this, this.stack);
    if (this.stack.isEmpty())
      this.writer.writeProlog();
    return localOutputDocument;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeWriter
 * JD-Core Version:    0.6.2
 */