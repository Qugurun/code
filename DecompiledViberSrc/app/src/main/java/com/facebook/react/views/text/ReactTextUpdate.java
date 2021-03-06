package com.facebook.react.views.text;

import android.text.Spannable;

public class ReactTextUpdate
{
  private final boolean mContainsImages;
  private final int mJsEventCounter;
  private final int mJustificationMode;
  private final float mPaddingBottom;
  private final float mPaddingLeft;
  private final float mPaddingRight;
  private final float mPaddingTop;
  private final Spannable mText;
  private final int mTextAlign;
  private final int mTextBreakStrategy;

  @Deprecated
  public ReactTextUpdate(Spannable paramSpannable, int paramInt1, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this(paramSpannable, paramInt1, paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt2, 1, 0);
  }

  public ReactTextUpdate(Spannable paramSpannable, int paramInt1, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mText = paramSpannable;
    this.mJsEventCounter = paramInt1;
    this.mContainsImages = paramBoolean;
    this.mPaddingLeft = paramFloat1;
    this.mPaddingTop = paramFloat2;
    this.mPaddingRight = paramFloat3;
    this.mPaddingBottom = paramFloat4;
    this.mTextAlign = paramInt2;
    this.mTextBreakStrategy = paramInt3;
    this.mJustificationMode = paramInt4;
  }

  public boolean containsImages()
  {
    return this.mContainsImages;
  }

  public int getJsEventCounter()
  {
    return this.mJsEventCounter;
  }

  public int getJustificationMode()
  {
    return this.mJustificationMode;
  }

  public float getPaddingBottom()
  {
    return this.mPaddingBottom;
  }

  public float getPaddingLeft()
  {
    return this.mPaddingLeft;
  }

  public float getPaddingRight()
  {
    return this.mPaddingRight;
  }

  public float getPaddingTop()
  {
    return this.mPaddingTop;
  }

  public Spannable getText()
  {
    return this.mText;
  }

  public int getTextAlign()
  {
    return this.mTextAlign;
  }

  public int getTextBreakStrategy()
  {
    return this.mTextBreakStrategy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextUpdate
 * JD-Core Version:    0.6.2
 */