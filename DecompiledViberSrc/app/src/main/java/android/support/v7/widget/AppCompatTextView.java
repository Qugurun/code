package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.text.PrecomputedTextCompat;
import android.support.v4.text.PrecomputedTextCompat.Params;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView
  implements TintableBackgroundView, AutoSizeableTextView
{
  private final AppCompatBackgroundHelper mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
  private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
  private final AppCompatTextHelper mTextHelper;

  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }

  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper = new AppCompatTextHelper(this);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper.applyCompoundDrawablesTints();
  }

  private void consumeTextFutureAndSetBlocking()
  {
    if (this.mPrecomputedTextFuture != null);
    try
    {
      Future localFuture = this.mPrecomputedTextFuture;
      this.mPrecomputedTextFuture = null;
      TextViewCompat.setPrecomputedText(this, (PrecomputedTextCompat)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    catch (ExecutionException localExecutionException)
    {
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.applySupportBackgroundTint();
    if (this.mTextHelper != null)
      this.mTextHelper.applyCompoundDrawablesTints();
  }

  public int getAutoSizeMaxTextSize()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeMaxTextSize();
    if (this.mTextHelper != null)
      return this.mTextHelper.getAutoSizeMaxTextSize();
    return -1;
  }

  public int getAutoSizeMinTextSize()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeMinTextSize();
    if (this.mTextHelper != null)
      return this.mTextHelper.getAutoSizeMinTextSize();
    return -1;
  }

  public int getAutoSizeStepGranularity()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeStepGranularity();
    if (this.mTextHelper != null)
      return this.mTextHelper.getAutoSizeStepGranularity();
    return -1;
  }

  public int[] getAutoSizeTextAvailableSizes()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeTextAvailableSizes();
    if (this.mTextHelper != null)
      return this.mTextHelper.getAutoSizeTextAvailableSizes();
    return new int[0];
  }

  public int getAutoSizeTextType()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
    {
      if (super.getAutoSizeTextType() == 1)
        return 1;
      return 0;
    }
    if (this.mTextHelper != null)
      return this.mTextHelper.getAutoSizeTextType();
    return 0;
  }

  public int getFirstBaselineToTopHeight()
  {
    return TextViewCompat.getFirstBaselineToTopHeight(this);
  }

  public int getLastBaselineToBottomHeight()
  {
    return TextViewCompat.getLastBaselineToBottomHeight(this);
  }

  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.mBackgroundTintHelper != null)
      return this.mBackgroundTintHelper.getSupportBackgroundTintList();
    return null;
  }

  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.mBackgroundTintHelper != null)
      return this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    return null;
  }

  public CharSequence getText()
  {
    consumeTextFutureAndSetBlocking();
    return super.getText();
  }

  public PrecomputedTextCompat.Params getTextMetricsParamsCompat()
  {
    return TextViewCompat.getTextMetricsParams(this);
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null)
      this.mTextHelper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    consumeTextFutureAndSetBlocking();
    super.onMeasure(paramInt1, paramInt2);
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.mTextHelper != null) && (!PLATFORM_SUPPORTS_AUTOSIZE) && (this.mTextHelper.isAutoSizeEnabled()))
      this.mTextHelper.autoSizeText();
  }

  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    while (this.mTextHelper == null)
      return;
    this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    while (this.mTextHelper == null)
      return;
    this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }

  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    while (this.mTextHelper == null)
      return;
    this.mTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundDrawable(paramDrawable);
  }

  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt);
  }

  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, paramCallback));
  }

  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    TextViewCompat.setFirstBaselineToTopHeight(this, paramInt);
  }

  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    TextViewCompat.setLastBaselineToBottomHeight(this, paramInt);
  }

  public void setLineHeight(int paramInt)
  {
    TextViewCompat.setLineHeight(this, paramInt);
  }

  public void setPrecomputedText(PrecomputedTextCompat paramPrecomputedTextCompat)
  {
    TextViewCompat.setPrecomputedText(this, paramPrecomputedTextCompat);
  }

  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
  }

  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
  }

  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null)
      this.mTextHelper.onSetTextAppearance(paramContext, paramInt);
  }

  public void setTextFuture(Future<PrecomputedTextCompat> paramFuture)
  {
    this.mPrecomputedTextFuture = paramFuture;
    requestLayout();
  }

  public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params paramParams)
  {
    TextViewCompat.setTextMetricsParams(this, paramParams);
  }

  public void setTextSize(int paramInt, float paramFloat)
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      super.setTextSize(paramInt, paramFloat);
    while (this.mTextHelper == null)
      return;
    this.mTextHelper.setTextSize(paramInt, paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.6.2
 */