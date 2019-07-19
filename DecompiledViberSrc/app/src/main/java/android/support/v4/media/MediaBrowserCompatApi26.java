package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

class MediaBrowserCompatApi26
{
  static Object createSubscriptionCallback(SubscriptionCallback paramSubscriptionCallback)
  {
    return new SubscriptionCallbackProxy(paramSubscriptionCallback);
  }

  public static void subscribe(Object paramObject1, String paramString, Bundle paramBundle, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).subscribe(paramString, paramBundle, (MediaBrowser.SubscriptionCallback)paramObject2);
  }

  public static void unsubscribe(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).unsubscribe(paramString, (MediaBrowser.SubscriptionCallback)paramObject2);
  }

  static abstract interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback
  {
    public abstract void onChildrenLoaded(String paramString, List<?> paramList, Bundle paramBundle);

    public abstract void onError(String paramString, Bundle paramBundle);
  }

  static class SubscriptionCallbackProxy<T extends MediaBrowserCompatApi26.SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T>
  {
    SubscriptionCallbackProxy(T paramT)
    {
      super();
    }

    public void onChildrenLoaded(String paramString, List<MediaBrowser.MediaItem> paramList, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaBrowserCompatApi26.SubscriptionCallback)this.mSubscriptionCallback).onChildrenLoaded(paramString, paramList, paramBundle);
    }

    public void onError(String paramString, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaBrowserCompatApi26.SubscriptionCallback)this.mSubscriptionCallback).onError(paramString, paramBundle);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompatApi26
 * JD-Core Version:    0.6.2
 */