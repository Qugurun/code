package android.support.design.widget;

import android.content.Context;
import android.support.design.R.attr;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class TextInputEditText extends AppCompatEditText
{
  public TextInputEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }

  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private CharSequence getHintFromLayout()
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if (localTextInputLayout != null)
      return localTextInputLayout.getHint();
    return null;
  }

  private TextInputLayout getTextInputLayout()
  {
    for (ViewParent localViewParent = getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent())
      if ((localViewParent instanceof TextInputLayout))
        return (TextInputLayout)localViewParent;
    return null;
  }

  public CharSequence getHint()
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (localTextInputLayout.isProvidingHint()))
      return localTextInputLayout.getHint();
    return super.getHint();
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && (paramEditorInfo.hintText == null))
      paramEditorInfo.hintText = getHintFromLayout();
    return localInputConnection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.TextInputEditText
 * JD-Core Version:    0.6.2
 */