package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.e;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public class t extends q<aa>
{
  public t(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramContext, 6, c.e.a, aa.a, paramLoaderManager, parama, parama1, paramEventBus);
  }

  protected aa a(Cursor paramCursor)
  {
    return new aa(this.f);
  }

  protected aa a(MessageEntity paramMessageEntity)
  {
    return new aa(paramMessageEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.t
 * JD-Core Version:    0.6.2
 */