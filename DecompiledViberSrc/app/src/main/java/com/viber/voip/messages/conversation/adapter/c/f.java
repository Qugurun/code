package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.widget.AvatarWithInitialsView;

public class f
  implements com.viber.voip.ui.g.f
{
  public final TextView a;
  public final TextView b;
  public final TextView c;
  public final View d;
  public final View e;
  public final TextView f;
  public final View g;
  public final View h;
  public final View i;
  public final AvatarWithInitialsView j;
  public final ImageView k;

  public f(View paramView)
  {
    this.j = ((AvatarWithInitialsView)paramView.findViewById(R.id.avatarView));
    this.a = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.b = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.c = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.d = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.e = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.f = ((TextView)paramView.findViewById(R.id.textMessageView));
    this.h = paramView.findViewById(R.id.selectionView);
    this.g = paramView.findViewById(R.id.headersSpace);
    this.i = paramView.findViewById(R.id.balloonView);
    this.k = ((ImageView)paramView.findViewById(R.id.adminIndicatorView));
  }

  public View a()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.f
 * JD-Core Version:    0.6.2
 */