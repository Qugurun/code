package org.greenrobot.eventbus;

final class PendingPostQueue
{
  private PendingPost head;
  private PendingPost tail;

  void enqueue(PendingPost paramPendingPost)
  {
    if (paramPendingPost == null)
      try
      {
        throw new NullPointerException("null cannot be enqueued");
      }
      finally
      {
      }
    if (this.tail != null)
    {
      this.tail.next = paramPendingPost;
      this.tail = paramPendingPost;
    }
    while (true)
    {
      notifyAll();
      return;
      if (this.head != null)
        break;
      this.tail = paramPendingPost;
      this.head = paramPendingPost;
    }
    throw new IllegalStateException("Head present, but no tail");
  }

  PendingPost poll()
  {
    try
    {
      PendingPost localPendingPost = this.head;
      if (this.head != null)
      {
        this.head = this.head.next;
        if (this.head == null)
          this.tail = null;
      }
      return localPendingPost;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  PendingPost poll(int paramInt)
    throws InterruptedException
  {
    try
    {
      if (this.head == null)
        wait(paramInt);
      PendingPost localPendingPost = poll();
      return localPendingPost;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.PendingPostQueue
 * JD-Core Version:    0.6.2
 */