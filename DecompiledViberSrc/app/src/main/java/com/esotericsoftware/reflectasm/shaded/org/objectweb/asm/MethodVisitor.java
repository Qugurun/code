package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

public abstract class MethodVisitor
{
  protected final int api;
  protected MethodVisitor mv;

  public MethodVisitor(int paramInt)
  {
    this(paramInt, null);
  }

  public MethodVisitor(int paramInt, MethodVisitor paramMethodVisitor)
  {
    this.api = paramInt;
    this.mv = paramMethodVisitor;
  }

  public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    if (this.mv != null)
      return this.mv.visitAnnotation(paramString, paramBoolean);
    return null;
  }

  public AnnotationVisitor visitAnnotationDefault()
  {
    if (this.mv != null)
      return this.mv.visitAnnotationDefault();
    return null;
  }

  public void visitAttribute(Attribute paramAttribute)
  {
    if (this.mv != null)
      this.mv.visitAttribute(paramAttribute);
  }

  public void visitCode()
  {
    if (this.mv != null)
      this.mv.visitCode();
  }

  public void visitEnd()
  {
    if (this.mv != null)
      this.mv.visitEnd();
  }

  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (this.mv != null)
      this.mv.visitFieldInsn(paramInt, paramString1, paramString2, paramString3);
  }

  public void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2)
  {
    if (this.mv != null)
      this.mv.visitFrame(paramInt1, paramInt2, paramArrayOfObject1, paramInt3, paramArrayOfObject2);
  }

  public void visitIincInsn(int paramInt1, int paramInt2)
  {
    if (this.mv != null)
      this.mv.visitIincInsn(paramInt1, paramInt2);
  }

  public void visitInsn(int paramInt)
  {
    if (this.mv != null)
      this.mv.visitInsn(paramInt);
  }

  public void visitIntInsn(int paramInt1, int paramInt2)
  {
    if (this.mv != null)
      this.mv.visitIntInsn(paramInt1, paramInt2);
  }

  public void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object[] paramArrayOfObject)
  {
    if (this.mv != null)
      this.mv.visitInvokeDynamicInsn(paramString1, paramString2, paramHandle, paramArrayOfObject);
  }

  public void visitJumpInsn(int paramInt, Label paramLabel)
  {
    if (this.mv != null)
      this.mv.visitJumpInsn(paramInt, paramLabel);
  }

  public void visitLabel(Label paramLabel)
  {
    if (this.mv != null)
      this.mv.visitLabel(paramLabel);
  }

  public void visitLdcInsn(Object paramObject)
  {
    if (this.mv != null)
      this.mv.visitLdcInsn(paramObject);
  }

  public void visitLineNumber(int paramInt, Label paramLabel)
  {
    if (this.mv != null)
      this.mv.visitLineNumber(paramInt, paramLabel);
  }

  public void visitLocalVariable(String paramString1, String paramString2, String paramString3, Label paramLabel1, Label paramLabel2, int paramInt)
  {
    if (this.mv != null)
      this.mv.visitLocalVariable(paramString1, paramString2, paramString3, paramLabel1, paramLabel2, paramInt);
  }

  public void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfInt, Label[] paramArrayOfLabel)
  {
    if (this.mv != null)
      this.mv.visitLookupSwitchInsn(paramLabel, paramArrayOfInt, paramArrayOfLabel);
  }

  public void visitMaxs(int paramInt1, int paramInt2)
  {
    if (this.mv != null)
      this.mv.visitMaxs(paramInt1, paramInt2);
  }

  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (this.mv != null)
      this.mv.visitMethodInsn(paramInt, paramString1, paramString2, paramString3);
  }

  public void visitMultiANewArrayInsn(String paramString, int paramInt)
  {
    if (this.mv != null)
      this.mv.visitMultiANewArrayInsn(paramString, paramInt);
  }

  public AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.mv != null)
      return this.mv.visitParameterAnnotation(paramInt, paramString, paramBoolean);
    return null;
  }

  public void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label[] paramArrayOfLabel)
  {
    if (this.mv != null)
      this.mv.visitTableSwitchInsn(paramInt1, paramInt2, paramLabel, paramArrayOfLabel);
  }

  public void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, String paramString)
  {
    if (this.mv != null)
      this.mv.visitTryCatchBlock(paramLabel1, paramLabel2, paramLabel3, paramString);
  }

  public void visitTypeInsn(int paramInt, String paramString)
  {
    if (this.mv != null)
      this.mv.visitTypeInsn(paramInt, paramString);
  }

  public void visitVarInsn(int paramInt1, int paramInt2)
  {
    if (this.mv != null)
      this.mv.visitVarInsn(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.MethodVisitor
 * JD-Core Version:    0.6.2
 */