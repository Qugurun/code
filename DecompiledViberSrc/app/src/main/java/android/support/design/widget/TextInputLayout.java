package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R.attr;
import android.support.design.R.color;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.string;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.j;
import android.support.design.internal.k;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintTypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class TextInputLayout extends LinearLayout
{
  public static final int BOX_BACKGROUND_FILLED = 1;
  public static final int BOX_BACKGROUND_NONE = 0;
  public static final int BOX_BACKGROUND_OUTLINE = 2;
  private static final int INVALID_MAX_LENGTH = -1;
  private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
  private static final String LOG_TAG = "TextInputLayout";
  private ValueAnimator animator;
  private GradientDrawable boxBackground;
  private int boxBackgroundColor;
  private int boxBackgroundMode;
  private final int boxBottomOffsetPx;
  private final int boxCollapsedPaddingTopPx;
  private float boxCornerRadiusBottomEnd;
  private float boxCornerRadiusBottomStart;
  private float boxCornerRadiusTopEnd;
  private float boxCornerRadiusTopStart;
  private final int boxLabelCutoutPaddingPx;
  private int boxStrokeColor;
  private final int boxStrokeWidthDefaultPx;
  private final int boxStrokeWidthFocusedPx;
  private int boxStrokeWidthPx;
  final CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
  boolean counterEnabled;
  private int counterMaxLength;
  private final int counterOverflowTextAppearance;
  private boolean counterOverflowed;
  private final int counterTextAppearance;
  private TextView counterView;
  private ColorStateList defaultHintTextColor;
  private final int defaultStrokeColor;
  private final int disabledColor;
  EditText editText;
  private Drawable editTextOriginalDrawable;
  private int focusedStrokeColor;
  private ColorStateList focusedTextColor;
  private boolean hasPasswordToggleTintList;
  private boolean hasPasswordToggleTintMode;
  private boolean hasReconstructedEditTextBackground;
  private CharSequence hint;
  private boolean hintAnimationEnabled;
  private boolean hintEnabled;
  private boolean hintExpanded;
  private final int hoveredStrokeColor;
  private boolean inDrawableStateChanged;
  private final IndicatorViewController indicatorViewController = new IndicatorViewController(this);
  private final FrameLayout inputFrame;
  private boolean isProvidingHint;
  private Drawable originalEditTextEndDrawable;
  private CharSequence originalHint;
  private CharSequence passwordToggleContentDesc;
  private Drawable passwordToggleDrawable;
  private Drawable passwordToggleDummyDrawable;
  private boolean passwordToggleEnabled;
  private ColorStateList passwordToggleTintList;
  private PorterDuff.Mode passwordToggleTintMode;
  private CheckableImageButton passwordToggleView;
  private boolean passwordToggledVisible;
  private boolean restoringSavedState;
  private final Rect tmpRect = new Rect();
  private final RectF tmpRectF = new RectF();
  private Typeface typeface;

  public TextInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.textInputStyle);
  }

  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.inputFrame = new FrameLayout(paramContext);
    this.inputFrame.setAddStatesFromChildren(true);
    addView(this.inputFrame);
    this.collapsingTextHelper.setTextSizeInterpolator(android.support.design.a.a.a);
    this.collapsingTextHelper.setPositionInterpolator(android.support.design.a.a.a);
    this.collapsingTextHelper.setCollapsedTextGravity(8388659);
    TintTypedArray localTintTypedArray = j.b(paramContext, paramAttributeSet, R.styleable.TextInputLayout, paramInt, R.style.Widget_Design_TextInputLayout, new int[0]);
    this.hintEnabled = localTintTypedArray.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
    setHint(localTintTypedArray.getText(R.styleable.TextInputLayout_android_hint));
    this.hintAnimationEnabled = localTintTypedArray.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
    this.boxBottomOffsetPx = paramContext.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_bottom_offset);
    this.boxLabelCutoutPaddingPx = paramContext.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
    this.boxCollapsedPaddingTopPx = localTintTypedArray.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
    this.boxCornerRadiusTopStart = localTintTypedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, 0.0F);
    this.boxCornerRadiusTopEnd = localTintTypedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, 0.0F);
    this.boxCornerRadiusBottomEnd = localTintTypedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, 0.0F);
    this.boxCornerRadiusBottomStart = localTintTypedArray.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, 0.0F);
    this.boxBackgroundColor = localTintTypedArray.getColor(R.styleable.TextInputLayout_boxBackgroundColor, 0);
    this.focusedStrokeColor = localTintTypedArray.getColor(R.styleable.TextInputLayout_boxStrokeColor, 0);
    this.boxStrokeWidthDefaultPx = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default);
    this.boxStrokeWidthFocusedPx = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused);
    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
    setBoxBackgroundMode(localTintTypedArray.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
    if (localTintTypedArray.hasValue(R.styleable.TextInputLayout_android_textColorHint))
    {
      ColorStateList localColorStateList = localTintTypedArray.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
      this.focusedTextColor = localColorStateList;
      this.defaultHintTextColor = localColorStateList;
    }
    this.defaultStrokeColor = ContextCompat.getColor(paramContext, R.color.mtrl_textinput_default_box_stroke_color);
    this.disabledColor = ContextCompat.getColor(paramContext, R.color.mtrl_textinput_disabled_color);
    this.hoveredStrokeColor = ContextCompat.getColor(paramContext, R.color.mtrl_textinput_hovered_box_stroke_color);
    if (localTintTypedArray.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1)
      setHintTextAppearance(localTintTypedArray.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    int i = localTintTypedArray.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = localTintTypedArray.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
    int j = localTintTypedArray.getResourceId(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
    boolean bool2 = localTintTypedArray.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, false);
    CharSequence localCharSequence = localTintTypedArray.getText(R.styleable.TextInputLayout_helperText);
    boolean bool3 = localTintTypedArray.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(localTintTypedArray.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
    this.counterTextAppearance = localTintTypedArray.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
    this.counterOverflowTextAppearance = localTintTypedArray.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
    this.passwordToggleEnabled = localTintTypedArray.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false);
    this.passwordToggleDrawable = localTintTypedArray.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
    this.passwordToggleContentDesc = localTintTypedArray.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
    if (localTintTypedArray.hasValue(R.styleable.TextInputLayout_passwordToggleTint))
    {
      this.hasPasswordToggleTintList = true;
      this.passwordToggleTintList = localTintTypedArray.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
    }
    if (localTintTypedArray.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode))
    {
      this.hasPasswordToggleTintMode = true;
      this.passwordToggleTintMode = k.a(localTintTypedArray.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
    }
    localTintTypedArray.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(localCharSequence);
    setHelperTextTextAppearance(j);
    setErrorEnabled(bool1);
    setErrorTextAppearance(i);
    setCounterEnabled(bool3);
    applyPasswordToggleTint();
    ViewCompat.setImportantForAccessibility(this, 2);
  }

  private void applyBoxAttributes()
  {
    if (this.boxBackground == null)
      return;
    setBoxAttributes();
    if ((this.editText != null) && (this.boxBackgroundMode == 2))
    {
      if (this.editText.getBackground() != null)
        this.editTextOriginalDrawable = this.editText.getBackground();
      ViewCompat.setBackground(this.editText, null);
    }
    if ((this.editText != null) && (this.boxBackgroundMode == 1) && (this.editTextOriginalDrawable != null))
      ViewCompat.setBackground(this.editText, this.editTextOriginalDrawable);
    if ((this.boxStrokeWidthPx > -1) && (this.boxStrokeColor != 0))
      this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
    this.boxBackground.setCornerRadii(getCornerRadiiAsArray());
    this.boxBackground.setColor(this.boxBackgroundColor);
    invalidate();
  }

  private void applyCutoutPadding(RectF paramRectF)
  {
    paramRectF.left -= this.boxLabelCutoutPaddingPx;
    paramRectF.top -= this.boxLabelCutoutPaddingPx;
    paramRectF.right += this.boxLabelCutoutPaddingPx;
    paramRectF.bottom += this.boxLabelCutoutPaddingPx;
  }

  private void applyPasswordToggleTint()
  {
    if ((this.passwordToggleDrawable != null) && ((this.hasPasswordToggleTintList) || (this.hasPasswordToggleTintMode)))
    {
      this.passwordToggleDrawable = DrawableCompat.wrap(this.passwordToggleDrawable).mutate();
      if (this.hasPasswordToggleTintList)
        DrawableCompat.setTintList(this.passwordToggleDrawable, this.passwordToggleTintList);
      if (this.hasPasswordToggleTintMode)
        DrawableCompat.setTintMode(this.passwordToggleDrawable, this.passwordToggleTintMode);
      if ((this.passwordToggleView != null) && (this.passwordToggleView.getDrawable() != this.passwordToggleDrawable))
        this.passwordToggleView.setImageDrawable(this.passwordToggleDrawable);
    }
  }

  private void assignBoxBackgroundByMode()
  {
    if (this.boxBackgroundMode == 0)
      this.boxBackground = null;
    do
    {
      return;
      if ((this.boxBackgroundMode == 2) && (this.hintEnabled) && (!(this.boxBackground instanceof CutoutDrawable)))
      {
        this.boxBackground = new CutoutDrawable();
        return;
      }
    }
    while ((this.boxBackground instanceof GradientDrawable));
    this.boxBackground = new GradientDrawable();
  }

  private int calculateBoxBackgroundTop()
  {
    if (this.editText == null)
      return 0;
    switch (this.boxBackgroundMode)
    {
    default:
      return 0;
    case 1:
      return this.editText.getTop();
    case 2:
    }
    return this.editText.getTop() + calculateLabelMarginTop();
  }

  private int calculateCollapsedTextTopBounds()
  {
    switch (this.boxBackgroundMode)
    {
    default:
      return getPaddingTop();
    case 2:
      return getBoxBackground().getBounds().top - calculateLabelMarginTop();
    case 1:
    }
    return getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
  }

  private int calculateLabelMarginTop()
  {
    if (!this.hintEnabled)
      return 0;
    switch (this.boxBackgroundMode)
    {
    default:
      return 0;
    case 0:
    case 1:
      return (int)this.collapsingTextHelper.getCollapsedTextHeight();
    case 2:
    }
    return (int)(this.collapsingTextHelper.getCollapsedTextHeight() / 2.0F);
  }

  private void closeCutout()
  {
    if (cutoutEnabled())
      ((CutoutDrawable)this.boxBackground).removeCutout();
  }

  private void collapseHint(boolean paramBoolean)
  {
    if ((this.animator != null) && (this.animator.isRunning()))
      this.animator.cancel();
    if ((paramBoolean) && (this.hintAnimationEnabled))
      animateToExpansionFraction(1.0F);
    while (true)
    {
      this.hintExpanded = false;
      if (cutoutEnabled())
        openCutout();
      return;
      this.collapsingTextHelper.setExpansionFraction(1.0F);
    }
  }

  private boolean cutoutEnabled()
  {
    return (this.hintEnabled) && (!TextUtils.isEmpty(this.hint)) && ((this.boxBackground instanceof CutoutDrawable));
  }

  private void ensureBackgroundDrawableStateWorkaround()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22));
    Drawable localDrawable2;
    do
    {
      Drawable localDrawable1;
      do
      {
        return;
        localDrawable1 = this.editText.getBackground();
      }
      while ((localDrawable1 == null) || (this.hasReconstructedEditTextBackground));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer))
        this.hasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
    }
    while (this.hasReconstructedEditTextBackground);
    ViewCompat.setBackground(this.editText, localDrawable2);
    this.hasReconstructedEditTextBackground = true;
    onApplyBoxBackgroundMode();
  }

  private void expandHint(boolean paramBoolean)
  {
    if ((this.animator != null) && (this.animator.isRunning()))
      this.animator.cancel();
    if ((paramBoolean) && (this.hintAnimationEnabled))
      animateToExpansionFraction(0.0F);
    while (true)
    {
      if ((cutoutEnabled()) && (((CutoutDrawable)this.boxBackground).hasCutout()))
        closeCutout();
      this.hintExpanded = true;
      return;
      this.collapsingTextHelper.setExpansionFraction(0.0F);
    }
  }

  private Drawable getBoxBackground()
  {
    if ((this.boxBackgroundMode == 1) || (this.boxBackgroundMode == 2))
      return this.boxBackground;
    throw new IllegalStateException();
  }

  private float[] getCornerRadiiAsArray()
  {
    if (!k.a(this))
    {
      float[] arrayOfFloat2 = new float[8];
      arrayOfFloat2[0] = this.boxCornerRadiusTopStart;
      arrayOfFloat2[1] = this.boxCornerRadiusTopStart;
      arrayOfFloat2[2] = this.boxCornerRadiusTopEnd;
      arrayOfFloat2[3] = this.boxCornerRadiusTopEnd;
      arrayOfFloat2[4] = this.boxCornerRadiusBottomEnd;
      arrayOfFloat2[5] = this.boxCornerRadiusBottomEnd;
      arrayOfFloat2[6] = this.boxCornerRadiusBottomStart;
      arrayOfFloat2[7] = this.boxCornerRadiusBottomStart;
      return arrayOfFloat2;
    }
    float[] arrayOfFloat1 = new float[8];
    arrayOfFloat1[0] = this.boxCornerRadiusTopEnd;
    arrayOfFloat1[1] = this.boxCornerRadiusTopEnd;
    arrayOfFloat1[2] = this.boxCornerRadiusTopStart;
    arrayOfFloat1[3] = this.boxCornerRadiusTopStart;
    arrayOfFloat1[4] = this.boxCornerRadiusBottomStart;
    arrayOfFloat1[5] = this.boxCornerRadiusBottomStart;
    arrayOfFloat1[6] = this.boxCornerRadiusBottomEnd;
    arrayOfFloat1[7] = this.boxCornerRadiusBottomEnd;
    return arrayOfFloat1;
  }

  private boolean hasPasswordTransformation()
  {
    return (this.editText != null) && ((this.editText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }

  private void onApplyBoxBackgroundMode()
  {
    assignBoxBackgroundByMode();
    if (this.boxBackgroundMode != 0)
      updateInputLayoutMargins();
    updateTextInputBoxBounds();
  }

  private void openCutout()
  {
    if (!cutoutEnabled())
      return;
    RectF localRectF = this.tmpRectF;
    this.collapsingTextHelper.getCollapsedTextActualBounds(localRectF);
    applyCutoutPadding(localRectF);
    ((CutoutDrawable)this.boxBackground).setCutout(localRectF);
  }

  private static void recursiveSetEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = paramViewGroup.getChildAt(j);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup))
        recursiveSetEnabled((ViewGroup)localView, paramBoolean);
    }
  }

  private void setBoxAttributes()
  {
    switch (this.boxBackgroundMode)
    {
    default:
    case 1:
    case 2:
    }
    do
    {
      return;
      this.boxStrokeWidthPx = 0;
      return;
    }
    while (this.focusedStrokeColor != 0);
    this.focusedStrokeColor = this.focusedTextColor.getColorForState(getDrawableState(), this.focusedTextColor.getDefaultColor());
  }

  private void setEditText(EditText paramEditText)
  {
    if (this.editText != null)
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    if (!(paramEditText instanceof TextInputEditText))
      Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
    this.editText = paramEditText;
    onApplyBoxBackgroundMode();
    setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
    if (!hasPasswordTransformation())
      this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
    this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
    int i = this.editText.getGravity();
    this.collapsingTextHelper.setCollapsedTextGravity(0x30 | i & 0xFFFFFF8F);
    this.collapsingTextHelper.setExpandedTextGravity(i);
    this.editText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!TextInputLayout.this.restoringSavedState);
        for (boolean bool = true; ; bool = false)
        {
          localTextInputLayout.updateLabelState(bool);
          if (TextInputLayout.this.counterEnabled)
            TextInputLayout.this.updateCounter(paramAnonymousEditable.length());
          return;
        }
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }
    });
    if (this.defaultHintTextColor == null)
      this.defaultHintTextColor = this.editText.getHintTextColors();
    if (this.hintEnabled)
    {
      if (TextUtils.isEmpty(this.hint))
      {
        this.originalHint = this.editText.getHint();
        setHint(this.originalHint);
        this.editText.setHint(null);
      }
      this.isProvidingHint = true;
    }
    if (this.counterView != null)
      updateCounter(this.editText.getText().length());
    this.indicatorViewController.adjustIndicatorPadding();
    updatePasswordToggleView();
    updateLabelState(false, true);
  }

  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.hint))
    {
      this.hint = paramCharSequence;
      this.collapsingTextHelper.setText(paramCharSequence);
      if (!this.hintExpanded)
        openCutout();
    }
  }

  private boolean shouldShowPasswordIcon()
  {
    return (this.passwordToggleEnabled) && ((hasPasswordTransformation()) || (this.passwordToggledVisible));
  }

  private void updateEditTextBackgroundBounds()
  {
    if (this.editText == null);
    Drawable localDrawable;
    Rect localRect2;
    do
    {
      do
      {
        return;
        localDrawable = this.editText.getBackground();
      }
      while (localDrawable == null);
      if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(localDrawable))
        localDrawable = localDrawable.mutate();
      Rect localRect1 = new Rect();
      DescendantOffsetUtils.getDescendantRect(this, this.editText, localRect1);
      localRect2 = localDrawable.getBounds();
    }
    while (localRect2.left == localRect2.right);
    Rect localRect3 = new Rect();
    localDrawable.getPadding(localRect3);
    int i = localRect2.left - localRect3.left;
    int j = localRect2.right + 2 * localRect3.right;
    localDrawable.setBounds(i, localRect2.top, j, this.editText.getBottom());
  }

  private void updateInputLayoutMargins()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.inputFrame.getLayoutParams();
    int i = calculateLabelMarginTop();
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.inputFrame.requestLayout();
    }
  }

  private void updateLabelState(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    boolean bool1 = isEnabled();
    int j;
    label48: boolean bool2;
    if ((this.editText != null) && (!TextUtils.isEmpty(this.editText.getText())))
    {
      j = i;
      if ((this.editText == null) || (!this.editText.hasFocus()))
        break label163;
      bool2 = this.indicatorViewController.errorShouldBeShown();
      if (this.defaultHintTextColor != null)
      {
        this.collapsingTextHelper.setCollapsedTextColor(this.defaultHintTextColor);
        this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
      }
      if (bool1)
        break label168;
      this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.disabledColor));
      this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.disabledColor));
      label119: if ((j == 0) && ((!isEnabled()) || ((i == 0) && (!bool2))))
        break label246;
      if ((paramBoolean2) || (this.hintExpanded))
        collapseHint(paramBoolean1);
    }
    label163: label168: label246: 
    while ((!paramBoolean2) && (this.hintExpanded))
    {
      return;
      j = 0;
      break;
      i = 0;
      break label48;
      if (bool2)
      {
        this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        break label119;
      }
      if ((this.counterOverflowed) && (this.counterView != null))
      {
        this.collapsingTextHelper.setCollapsedTextColor(this.counterView.getTextColors());
        break label119;
      }
      if ((i == 0) || (this.focusedTextColor == null))
        break label119;
      this.collapsingTextHelper.setCollapsedTextColor(this.focusedTextColor);
      break label119;
    }
    expandHint(paramBoolean1);
  }

  private void updatePasswordToggleView()
  {
    if (this.editText == null);
    Drawable[] arrayOfDrawable1;
    do
    {
      do
      {
        return;
        if (shouldShowPasswordIcon())
        {
          if (this.passwordToggleView == null)
          {
            this.passwordToggleView = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, this.inputFrame, false));
            this.passwordToggleView.setImageDrawable(this.passwordToggleDrawable);
            this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
            this.inputFrame.addView(this.passwordToggleView);
            this.passwordToggleView.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymousView)
              {
                TextInputLayout.this.passwordVisibilityToggleRequested(false);
              }
            });
          }
          if ((this.editText != null) && (ViewCompat.getMinimumHeight(this.editText) <= 0))
            this.editText.setMinimumHeight(ViewCompat.getMinimumHeight(this.passwordToggleView));
          this.passwordToggleView.setVisibility(0);
          this.passwordToggleView.setChecked(this.passwordToggledVisible);
          if (this.passwordToggleDummyDrawable == null)
            this.passwordToggleDummyDrawable = new ColorDrawable();
          this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
          Drawable[] arrayOfDrawable2 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
          if (arrayOfDrawable2[2] != this.passwordToggleDummyDrawable)
            this.originalEditTextEndDrawable = arrayOfDrawable2[2];
          TextViewCompat.setCompoundDrawablesRelative(this.editText, arrayOfDrawable2[0], arrayOfDrawable2[1], this.passwordToggleDummyDrawable, arrayOfDrawable2[3]);
          this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
          return;
        }
        if ((this.passwordToggleView != null) && (this.passwordToggleView.getVisibility() == 0))
          this.passwordToggleView.setVisibility(8);
      }
      while (this.passwordToggleDummyDrawable == null);
      arrayOfDrawable1 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
    }
    while (arrayOfDrawable1[2] != this.passwordToggleDummyDrawable);
    TextViewCompat.setCompoundDrawablesRelative(this.editText, arrayOfDrawable1[0], arrayOfDrawable1[1], this.originalEditTextEndDrawable, arrayOfDrawable1[3]);
    this.passwordToggleDummyDrawable = null;
  }

  private void updateTextInputBoxBounds()
  {
    if ((this.boxBackgroundMode == 0) || (this.boxBackground == null) || (this.editText == null) || (getRight() == 0))
      return;
    int i = this.editText.getLeft();
    int j = calculateBoxBackgroundTop();
    int k = this.editText.getRight();
    int m = this.editText.getBottom() + this.boxBottomOffsetPx;
    if (this.boxBackgroundMode == 2)
    {
      i += this.boxStrokeWidthFocusedPx / 2;
      j -= this.boxStrokeWidthFocusedPx / 2;
      k -= this.boxStrokeWidthFocusedPx / 2;
      m += this.boxStrokeWidthFocusedPx / 2;
    }
    this.boxBackground.setBounds(i, j, k, m);
    applyBoxAttributes();
    updateEditTextBackgroundBounds();
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (0x10 | 0xFFFFFF8F & localLayoutParams.gravity);
      this.inputFrame.addView(paramView, localLayoutParams);
      this.inputFrame.setLayoutParams(paramLayoutParams);
      updateInputLayoutMargins();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  void animateToExpansionFraction(float paramFloat)
  {
    if (this.collapsingTextHelper.getExpansionFraction() == paramFloat)
      return;
    if (this.animator == null)
    {
      this.animator = new ValueAnimator();
      this.animator.setInterpolator(android.support.design.a.a.b);
      this.animator.setDuration(167L);
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      });
    }
    ValueAnimator localValueAnimator = this.animator;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.collapsingTextHelper.getExpansionFraction();
    arrayOfFloat[1] = paramFloat;
    localValueAnimator.setFloatValues(arrayOfFloat);
    this.animator.start();
  }

  boolean cutoutIsOpen()
  {
    return (cutoutEnabled()) && (((CutoutDrawable)this.boxBackground).hasCutout());
  }

  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if ((this.originalHint == null) || (this.editText == null))
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    boolean bool = this.isProvidingHint;
    this.isProvidingHint = false;
    CharSequence localCharSequence = this.editText.getHint();
    this.editText.setHint(this.originalHint);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.editText.setHint(localCharSequence);
      this.isProvidingHint = bool;
    }
  }

  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.restoringSavedState = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.restoringSavedState = false;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.boxBackground != null)
      this.boxBackground.draw(paramCanvas);
    super.draw(paramCanvas);
    if (this.hintEnabled)
      this.collapsingTextHelper.draw(paramCanvas);
  }

  protected void drawableStateChanged()
  {
    boolean bool1 = true;
    if (this.inDrawableStateChanged)
      return;
    this.inDrawableStateChanged = bool1;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((ViewCompat.isLaidOut(this)) && (isEnabled()))
    {
      updateLabelState(bool1);
      updateEditTextBackground();
      updateTextInputBoxBounds();
      updateTextInputBoxState();
      if (this.collapsingTextHelper == null)
        break label92;
    }
    label92: for (boolean bool2 = false | this.collapsingTextHelper.setState(arrayOfInt); ; bool2 = false)
    {
      if (bool2)
        invalidate();
      this.inDrawableStateChanged = false;
      return;
      bool1 = false;
      break;
    }
  }

  public int getBoxBackgroundColor()
  {
    return this.boxBackgroundColor;
  }

  public float getBoxCornerRadiusBottomEnd()
  {
    return this.boxCornerRadiusBottomEnd;
  }

  public float getBoxCornerRadiusBottomStart()
  {
    return this.boxCornerRadiusBottomStart;
  }

  public float getBoxCornerRadiusTopEnd()
  {
    return this.boxCornerRadiusTopEnd;
  }

  public float getBoxCornerRadiusTopStart()
  {
    return this.boxCornerRadiusTopStart;
  }

  public int getBoxStrokeColor()
  {
    return this.focusedStrokeColor;
  }

  public int getCounterMaxLength()
  {
    return this.counterMaxLength;
  }

  CharSequence getCounterOverflowDescription()
  {
    if ((this.counterEnabled) && (this.counterOverflowed) && (this.counterView != null))
      return this.counterView.getContentDescription();
    return null;
  }

  public ColorStateList getDefaultHintTextColor()
  {
    return this.defaultHintTextColor;
  }

  public EditText getEditText()
  {
    return this.editText;
  }

  public CharSequence getError()
  {
    if (this.indicatorViewController.isErrorEnabled())
      return this.indicatorViewController.getErrorText();
    return null;
  }

  public int getErrorCurrentTextColors()
  {
    return this.indicatorViewController.getErrorViewCurrentTextColor();
  }

  final int getErrorTextCurrentColor()
  {
    return this.indicatorViewController.getErrorViewCurrentTextColor();
  }

  public CharSequence getHelperText()
  {
    if (this.indicatorViewController.isHelperTextEnabled())
      return this.indicatorViewController.getHelperText();
    return null;
  }

  public int getHelperTextCurrentTextColor()
  {
    return this.indicatorViewController.getHelperTextViewCurrentTextColor();
  }

  public CharSequence getHint()
  {
    if (this.hintEnabled)
      return this.hint;
    return null;
  }

  final float getHintCollapsedTextHeight()
  {
    return this.collapsingTextHelper.getCollapsedTextHeight();
  }

  final int getHintCurrentCollapsedTextColor()
  {
    return this.collapsingTextHelper.getCurrentCollapsedTextColor();
  }

  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.passwordToggleContentDesc;
  }

  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.passwordToggleDrawable;
  }

  public Typeface getTypeface()
  {
    return this.typeface;
  }

  public boolean isCounterEnabled()
  {
    return this.counterEnabled;
  }

  public boolean isErrorEnabled()
  {
    return this.indicatorViewController.isErrorEnabled();
  }

  final boolean isHelperTextDisplayed()
  {
    return this.indicatorViewController.helperTextIsDisplayed();
  }

  public boolean isHelperTextEnabled()
  {
    return this.indicatorViewController.isHelperTextEnabled();
  }

  public boolean isHintAnimationEnabled()
  {
    return this.hintAnimationEnabled;
  }

  public boolean isHintEnabled()
  {
    return this.hintEnabled;
  }

  final boolean isHintExpanded()
  {
    return this.hintExpanded;
  }

  public boolean isPasswordVisibilityToggleEnabled()
  {
    return this.passwordToggleEnabled;
  }

  boolean isProvidingHint()
  {
    return this.isProvidingHint;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.boxBackground != null)
      updateTextInputBoxBounds();
    if ((this.hintEnabled) && (this.editText != null))
    {
      Rect localRect = this.tmpRect;
      DescendantOffsetUtils.getDescendantRect(this, this.editText, localRect);
      int i = localRect.left + this.editText.getCompoundPaddingLeft();
      int j = localRect.right - this.editText.getCompoundPaddingRight();
      int k = calculateCollapsedTextTopBounds();
      this.collapsingTextHelper.setExpandedBounds(i, localRect.top + this.editText.getCompoundPaddingTop(), j, localRect.bottom - this.editText.getCompoundPaddingBottom());
      this.collapsingTextHelper.setCollapsedBounds(i, k, j, paramInt4 - paramInt2 - getPaddingBottom());
      this.collapsingTextHelper.recalculate();
      if ((cutoutEnabled()) && (!this.hintExpanded))
        openCutout();
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    updatePasswordToggleView();
    super.onMeasure(paramInt1, paramInt2);
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    setError(localSavedState.error);
    if (localSavedState.isPasswordToggledVisible)
      passwordVisibilityToggleRequested(true);
    requestLayout();
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.indicatorViewController.errorShouldBeShown())
      localSavedState.error = getError();
    localSavedState.isPasswordToggledVisible = this.passwordToggledVisible;
    return localSavedState;
  }

  public void passwordVisibilityToggleRequested(boolean paramBoolean)
  {
    int i;
    if (this.passwordToggleEnabled)
    {
      i = this.editText.getSelectionEnd();
      if (!hasPasswordTransformation())
        break label66;
      this.editText.setTransformationMethod(null);
    }
    for (this.passwordToggledVisible = true; ; this.passwordToggledVisible = false)
    {
      this.passwordToggleView.setChecked(this.passwordToggledVisible);
      if (paramBoolean)
        this.passwordToggleView.jumpDrawablesToCurrentState();
      this.editText.setSelection(i);
      return;
      label66: this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }

  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.boxBackgroundColor != paramInt)
    {
      this.boxBackgroundColor = paramInt;
      applyBoxAttributes();
    }
  }

  public void setBoxBackgroundColorResource(int paramInt)
  {
    setBoxBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }

  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.boxBackgroundMode)
      return;
    this.boxBackgroundMode = paramInt;
    onApplyBoxBackgroundMode();
  }

  public void setBoxCornerRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.boxCornerRadiusTopStart != paramFloat1) || (this.boxCornerRadiusTopEnd != paramFloat2) || (this.boxCornerRadiusBottomEnd != paramFloat4) || (this.boxCornerRadiusBottomStart != paramFloat3))
    {
      this.boxCornerRadiusTopStart = paramFloat1;
      this.boxCornerRadiusTopEnd = paramFloat2;
      this.boxCornerRadiusBottomEnd = paramFloat4;
      this.boxCornerRadiusBottomStart = paramFloat3;
      applyBoxAttributes();
    }
  }

  public void setBoxCornerRadiiResources(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBoxCornerRadii(getContext().getResources().getDimension(paramInt1), getContext().getResources().getDimension(paramInt2), getContext().getResources().getDimension(paramInt3), getContext().getResources().getDimension(paramInt4));
  }

  public void setBoxStrokeColor(int paramInt)
  {
    if (this.focusedStrokeColor != paramInt)
    {
      this.focusedStrokeColor = paramInt;
      updateTextInputBoxState();
    }
  }

  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.counterEnabled != paramBoolean)
    {
      if (!paramBoolean)
        break label124;
      this.counterView = new AppCompatTextView(getContext());
      this.counterView.setId(R.id.textinput_counter);
      if (this.typeface != null)
        this.counterView.setTypeface(this.typeface);
      this.counterView.setMaxLines(1);
      setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterTextAppearance);
      this.indicatorViewController.addIndicator(this.counterView, 2);
      if (this.editText != null)
        break label105;
      updateCounter(0);
    }
    while (true)
    {
      this.counterEnabled = paramBoolean;
      return;
      label105: updateCounter(this.editText.getText().length());
      continue;
      label124: this.indicatorViewController.removeIndicator(this.counterView, 2);
      this.counterView = null;
    }
  }

  public void setCounterMaxLength(int paramInt)
  {
    if (this.counterMaxLength != paramInt)
    {
      if (paramInt <= 0)
        break label39;
      this.counterMaxLength = paramInt;
      if (this.counterEnabled)
        if (this.editText != null)
          break label47;
    }
    label39: label47: for (int i = 0; ; i = this.editText.getText().length())
    {
      updateCounter(i);
      return;
      this.counterMaxLength = -1;
      break;
    }
  }

  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.defaultHintTextColor = paramColorStateList;
    this.focusedTextColor = paramColorStateList;
    if (this.editText != null)
      updateLabelState(false);
  }

  public void setEnabled(boolean paramBoolean)
  {
    recursiveSetEnabled(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }

  public void setError(CharSequence paramCharSequence)
  {
    if (!this.indicatorViewController.isErrorEnabled())
    {
      if (TextUtils.isEmpty(paramCharSequence))
        return;
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.indicatorViewController.showError(paramCharSequence);
      return;
    }
    this.indicatorViewController.hideError();
  }

  public void setErrorEnabled(boolean paramBoolean)
  {
    this.indicatorViewController.setErrorEnabled(paramBoolean);
  }

  public void setErrorTextAppearance(int paramInt)
  {
    this.indicatorViewController.setErrorTextAppearance(paramInt);
  }

  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    this.indicatorViewController.setErrorViewTextColor(paramColorStateList);
  }

  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (isHelperTextEnabled())
        setHelperTextEnabled(false);
      return;
    }
    if (!isHelperTextEnabled())
      setHelperTextEnabled(true);
    this.indicatorViewController.showHelper(paramCharSequence);
  }

  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    this.indicatorViewController.setHelperTextViewTextColor(paramColorStateList);
  }

  public void setHelperTextEnabled(boolean paramBoolean)
  {
    this.indicatorViewController.setHelperTextEnabled(paramBoolean);
  }

  public void setHelperTextTextAppearance(int paramInt)
  {
    this.indicatorViewController.setHelperTextAppearance(paramInt);
  }

  public void setHint(CharSequence paramCharSequence)
  {
    if (this.hintEnabled)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }

  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.hintAnimationEnabled = paramBoolean;
  }

  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.hintEnabled)
    {
      this.hintEnabled = paramBoolean;
      if (this.hintEnabled)
        break label76;
      this.isProvidingHint = false;
      if ((!TextUtils.isEmpty(this.hint)) && (TextUtils.isEmpty(this.editText.getHint())))
        this.editText.setHint(this.hint);
      setHintInternal(null);
    }
    while (true)
    {
      if (this.editText != null)
        updateInputLayoutMargins();
      return;
      label76: CharSequence localCharSequence = this.editText.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.hint))
          setHint(localCharSequence);
        this.editText.setHint(null);
      }
      this.isProvidingHint = true;
    }
  }

  public void setHintTextAppearance(int paramInt)
  {
    this.collapsingTextHelper.setCollapsedTextAppearance(paramInt);
    this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
    if (this.editText != null)
    {
      updateLabelState(false);
      updateInputLayoutMargins();
    }
  }

  public void setPasswordVisibilityToggleContentDescription(int paramInt)
  {
    if (paramInt != 0);
    for (CharSequence localCharSequence = getResources().getText(paramInt); ; localCharSequence = null)
    {
      setPasswordVisibilityToggleContentDescription(localCharSequence);
      return;
    }
  }

  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence)
  {
    this.passwordToggleContentDesc = paramCharSequence;
    if (this.passwordToggleView != null)
      this.passwordToggleView.setContentDescription(paramCharSequence);
  }

  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    if (paramInt != 0);
    for (Drawable localDrawable = android.support.v7.a.a.a.b(getContext(), paramInt); ; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      return;
    }
  }

  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    this.passwordToggleDrawable = paramDrawable;
    if (this.passwordToggleView != null)
      this.passwordToggleView.setImageDrawable(paramDrawable);
  }

  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.passwordToggleEnabled != paramBoolean)
    {
      this.passwordToggleEnabled = paramBoolean;
      if ((!paramBoolean) && (this.passwordToggledVisible) && (this.editText != null))
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.passwordToggledVisible = false;
      updatePasswordToggleView();
    }
  }

  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.passwordToggleTintList = paramColorStateList;
    this.hasPasswordToggleTintList = true;
    applyPasswordToggleTint();
  }

  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.passwordToggleTintMode = paramMode;
    this.hasPasswordToggleTintMode = true;
    applyPasswordToggleTint();
  }

  void setTextAppearanceCompatWithErrorFallback(TextView paramTextView, int paramInt)
  {
    int i = 1;
    try
    {
      TextViewCompat.setTextAppearance(paramTextView, paramInt);
      if (Build.VERSION.SDK_INT >= 23)
      {
        int j = paramTextView.getTextColors().getDefaultColor();
        if (j == -65281)
        {
          if (i != 0)
          {
            TextViewCompat.setTextAppearance(paramTextView, R.style.TextAppearance_AppCompat_Caption);
            paramTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
          }
          return;
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        continue;
        i = 0;
      }
    }
  }

  public void setTextInputAccessibilityDelegate(AccessibilityDelegate paramAccessibilityDelegate)
  {
    if (this.editText != null)
      ViewCompat.setAccessibilityDelegate(this.editText, paramAccessibilityDelegate);
  }

  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.typeface)
    {
      this.typeface = paramTypeface;
      this.collapsingTextHelper.setTypefaces(paramTypeface);
      this.indicatorViewController.setTypefaces(paramTypeface);
      if (this.counterView != null)
        this.counterView.setTypeface(paramTypeface);
    }
  }

  void updateCounter(int paramInt)
  {
    boolean bool1 = this.counterOverflowed;
    if (this.counterMaxLength == -1)
    {
      this.counterView.setText(String.valueOf(paramInt));
      this.counterView.setContentDescription(null);
      this.counterOverflowed = false;
      if ((this.editText != null) && (bool1 != this.counterOverflowed))
      {
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
      }
      return;
    }
    if (ViewCompat.getAccessibilityLiveRegion(this.counterView) == 1)
      ViewCompat.setAccessibilityLiveRegion(this.counterView, 0);
    boolean bool2;
    label95: TextView localTextView3;
    if (paramInt > this.counterMaxLength)
    {
      bool2 = true;
      this.counterOverflowed = bool2;
      if (bool1 != this.counterOverflowed)
      {
        localTextView3 = this.counterView;
        if (!this.counterOverflowed)
          break label270;
      }
    }
    label270: for (int k = this.counterOverflowTextAppearance; ; k = this.counterTextAppearance)
    {
      setTextAppearanceCompatWithErrorFallback(localTextView3, k);
      if (this.counterOverflowed)
        ViewCompat.setAccessibilityLiveRegion(this.counterView, 1);
      TextView localTextView1 = this.counterView;
      Context localContext1 = getContext();
      int i = R.string.character_counter_pattern;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(paramInt);
      arrayOfObject1[1] = Integer.valueOf(this.counterMaxLength);
      localTextView1.setText(localContext1.getString(i, arrayOfObject1));
      TextView localTextView2 = this.counterView;
      Context localContext2 = getContext();
      int j = R.string.character_counter_content_description;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(paramInt);
      arrayOfObject2[1] = Integer.valueOf(this.counterMaxLength);
      localTextView2.setContentDescription(localContext2.getString(j, arrayOfObject2));
      break;
      bool2 = false;
      break label95;
    }
  }

  void updateEditTextBackground()
  {
    if (this.editText == null);
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = this.editText.getBackground();
    }
    while (localDrawable == null);
    ensureBackgroundDrawableStateWorkaround();
    if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(localDrawable))
      localDrawable = localDrawable.mutate();
    if (this.indicatorViewController.errorShouldBeShown())
    {
      localDrawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.counterOverflowed) && (this.counterView != null))
    {
      localDrawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.counterView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    DrawableCompat.clearColorFilter(localDrawable);
    this.editText.refreshDrawableState();
  }

  void updateLabelState(boolean paramBoolean)
  {
    updateLabelState(paramBoolean, false);
  }

  void updateTextInputBoxState()
  {
    int i = 1;
    if ((this.boxBackground == null) || (this.boxBackgroundMode == 0))
      return;
    int j;
    if ((this.editText != null) && (this.editText.hasFocus()))
    {
      j = i;
      label36: if ((this.editText == null) || (!this.editText.isHovered()))
        break label109;
      label53: if (this.boxBackgroundMode != 2)
        break label112;
      if (isEnabled())
        break label114;
      this.boxStrokeColor = this.disabledColor;
      label76: if (((i == 0) && (j == 0)) || (!isEnabled()))
        break label207;
    }
    label207: for (this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx; ; this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx)
    {
      applyBoxAttributes();
      return;
      j = 0;
      break label36;
      label109: i = 0;
      break label53;
      label112: break;
      label114: if (this.indicatorViewController.errorShouldBeShown())
      {
        this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
        break label76;
      }
      if ((this.counterOverflowed) && (this.counterView != null))
      {
        this.boxStrokeColor = this.counterView.getCurrentTextColor();
        break label76;
      }
      if (j != 0)
      {
        this.boxStrokeColor = this.focusedStrokeColor;
        break label76;
      }
      if (i != 0)
      {
        this.boxStrokeColor = this.hoveredStrokeColor;
        break label76;
      }
      this.boxStrokeColor = this.defaultStrokeColor;
      break label76;
    }
  }

  public static class AccessibilityDelegate extends AccessibilityDelegateCompat
  {
    private final TextInputLayout layout;

    public AccessibilityDelegate(TextInputLayout paramTextInputLayout)
    {
      this.layout = paramTextInputLayout;
    }

    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      EditText localEditText = this.layout.getEditText();
      Editable localEditable;
      CharSequence localCharSequence1;
      CharSequence localCharSequence2;
      CharSequence localCharSequence3;
      int i;
      label62: int j;
      label73: int k;
      label84: int m;
      if (localEditText != null)
      {
        localEditable = localEditText.getText();
        localCharSequence1 = this.layout.getHint();
        localCharSequence2 = this.layout.getError();
        localCharSequence3 = this.layout.getCounterOverflowDescription();
        if (TextUtils.isEmpty(localEditable))
          break label179;
        i = 1;
        if (TextUtils.isEmpty(localCharSequence1))
          break label185;
        j = 1;
        if (TextUtils.isEmpty(localCharSequence2))
          break label191;
        k = 1;
        if ((k == 0) && (TextUtils.isEmpty(localCharSequence3)))
          break label197;
        m = 1;
        label100: if (i == 0)
          break label203;
        paramAccessibilityNodeInfoCompat.setText(localEditable);
        label111: if (j != 0)
        {
          paramAccessibilityNodeInfoCompat.setHintText(localCharSequence1);
          boolean bool = false;
          if (i == 0)
          {
            bool = false;
            if (j != 0)
              bool = true;
          }
          paramAccessibilityNodeInfoCompat.setShowingHintText(bool);
        }
        if (m != 0)
          if (k == 0)
            break label217;
      }
      label179: label185: label191: label197: label203: label217: for (CharSequence localCharSequence4 = localCharSequence2; ; localCharSequence4 = localCharSequence3)
      {
        paramAccessibilityNodeInfoCompat.setError(localCharSequence4);
        paramAccessibilityNodeInfoCompat.setContentInvalid(true);
        return;
        localEditable = null;
        break;
        i = 0;
        break label62;
        j = 0;
        break label73;
        k = 0;
        break label84;
        m = 0;
        break label100;
        if (j == 0)
          break label111;
        paramAccessibilityNodeInfoCompat.setText(localCharSequence1);
        break label111;
      }
    }

    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      EditText localEditText = this.layout.getEditText();
      if (localEditText != null);
      for (Object localObject = localEditText.getText(); ; localObject = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject))
          localObject = this.layout.getHint();
        if (!TextUtils.isEmpty((CharSequence)localObject))
          paramAccessibilityEvent.getText().add(localObject);
        return;
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BoxBackgroundMode
  {
  }

  static class SavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public TextInputLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new TextInputLayout.SavedState(paramAnonymousParcel, null);
      }

      public TextInputLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new TextInputLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public TextInputLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new TextInputLayout.SavedState[paramAnonymousInt];
      }
    };
    CharSequence error;
    boolean isPasswordToggledVisible;

    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.error = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      if (paramParcel.readInt() == 1);
      for (boolean bool = true; ; bool = false)
      {
        this.isPasswordToggledVisible = bool;
        return;
      }
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.error, paramParcel, paramInt);
      if (this.isPasswordToggledVisible);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * JD-Core Version:    0.6.2
 */