package twitter4j;

import java.io.Serializable;

public abstract interface HashtagEntity extends Serializable, TweetEntity
{
  public abstract int getEnd();

  public abstract int getStart();

  public abstract String getText();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.HashtagEntity
 * JD-Core Version:    0.6.2
 */