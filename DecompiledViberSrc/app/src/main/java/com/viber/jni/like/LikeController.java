package com.viber.jni.like;

public abstract interface LikeController
{
  public abstract boolean handleGetPublicGroupLikes(int paramInt1, long paramLong, int paramInt2, int paramInt3);

  public abstract boolean handleGroupMessageLikeAck(long paramLong);

  public abstract void handleSendSyncMessageLikeAck(long paramLong);

  public abstract boolean handleSyncMessageLikeAck(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.like.LikeController
 * JD-Core Version:    0.6.2
 */