package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public abstract interface IMediaControllerCallback extends IInterface
{
  public abstract void onCaptioningEnabledChanged(boolean paramBoolean)
    throws RemoteException;

  public abstract void onEvent(String paramString, Bundle paramBundle)
    throws RemoteException;

  public abstract void onExtrasChanged(Bundle paramBundle)
    throws RemoteException;

  public abstract void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
    throws RemoteException;

  public abstract void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat)
    throws RemoteException;

  public abstract void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
    throws RemoteException;

  public abstract void onQueueTitleChanged(CharSequence paramCharSequence)
    throws RemoteException;

  public abstract void onRepeatModeChanged(int paramInt)
    throws RemoteException;

  public abstract void onSessionDestroyed()
    throws RemoteException;

  public abstract void onSessionReady()
    throws RemoteException;

  public abstract void onShuffleModeChanged(int paramInt)
    throws RemoteException;

  public abstract void onShuffleModeChangedRemoved(boolean paramBoolean)
    throws RemoteException;

  public abstract void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IMediaControllerCallback
  {
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
    static final int TRANSACTION_onCaptioningEnabledChanged = 11;
    static final int TRANSACTION_onEvent = 1;
    static final int TRANSACTION_onExtrasChanged = 7;
    static final int TRANSACTION_onMetadataChanged = 4;
    static final int TRANSACTION_onPlaybackStateChanged = 3;
    static final int TRANSACTION_onQueueChanged = 5;
    static final int TRANSACTION_onQueueTitleChanged = 6;
    static final int TRANSACTION_onRepeatModeChanged = 9;
    static final int TRANSACTION_onSessionDestroyed = 2;
    static final int TRANSACTION_onSessionReady = 13;
    static final int TRANSACTION_onShuffleModeChanged = 12;
    static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
    static final int TRANSACTION_onVolumeInfoChanged = 8;

    public Stub()
    {
      attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
    }

    public static IMediaControllerCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
      if ((localIInterface != null) && ((localIInterface instanceof IMediaControllerCallback)))
        return (IMediaControllerCallback)localIInterface;
      return new Proxy(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
        return true;
      case 1:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        String str = paramParcel1.readString();
        int i2 = paramParcel1.readInt();
        Bundle localBundle2 = null;
        if (i2 != 0)
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        onEvent(str, localBundle2);
        return true;
      case 2:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        onSessionDestroyed();
        return true;
      case 3:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        int i1 = paramParcel1.readInt();
        PlaybackStateCompat localPlaybackStateCompat = null;
        if (i1 != 0)
          localPlaybackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(paramParcel1);
        onPlaybackStateChanged(localPlaybackStateCompat);
        return true;
      case 4:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        int n = paramParcel1.readInt();
        MediaMetadataCompat localMediaMetadataCompat = null;
        if (n != 0)
          localMediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(paramParcel1);
        onMetadataChanged(localMediaMetadataCompat);
        return true;
      case 5:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        onQueueChanged(paramParcel1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
        return true;
      case 6:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        int m = paramParcel1.readInt();
        CharSequence localCharSequence = null;
        if (m != 0)
          localCharSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel1);
        onQueueTitleChanged(localCharSequence);
        return true;
      case 7:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        int k = paramParcel1.readInt();
        Bundle localBundle1 = null;
        if (k != 0)
          localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        onExtrasChanged(localBundle1);
        return true;
      case 8:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        int j = paramParcel1.readInt();
        ParcelableVolumeInfo localParcelableVolumeInfo = null;
        if (j != 0)
          localParcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(paramParcel1);
        onVolumeInfoChanged(localParcelableVolumeInfo);
        return true;
      case 9:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        onRepeatModeChanged(paramParcel1.readInt());
        return true;
      case 10:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (paramParcel1.readInt() != 0);
        for (boolean bool2 = true; ; bool2 = false)
        {
          onShuffleModeChangedRemoved(bool2);
          return true;
        }
      case 11:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        int i = paramParcel1.readInt();
        boolean bool1 = false;
        if (i != 0)
          bool1 = true;
        onCaptioningEnabledChanged(bool1);
        return true;
      case 12:
        paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        onShuffleModeChanged(paramParcel1.readInt());
        return true;
      case 13:
      }
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      onSessionReady();
      return true;
    }

    private static class Proxy
      implements IMediaControllerCallback
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.mRemote;
      }

      public String getInterfaceDescriptor()
      {
        return "android.support.v4.media.session.IMediaControllerCallback";
      }

      public void onCaptioningEnabledChanged(boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (paramBoolean);
          while (true)
          {
            localParcel.writeInt(i);
            this.mRemote.transact(11, localParcel, null, 1);
            return;
            i = 0;
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onEvent(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          localParcel.writeString(paramString);
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.mRemote.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onExtrasChanged(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.mRemote.transact(7, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (paramMediaMetadataCompat != null)
          {
            localParcel.writeInt(1);
            paramMediaMetadataCompat.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.mRemote.transact(4, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (paramPlaybackStateCompat != null)
          {
            localParcel.writeInt(1);
            paramPlaybackStateCompat.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.mRemote.transact(3, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          localParcel.writeTypedList(paramList);
          this.mRemote.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onQueueTitleChanged(CharSequence paramCharSequence)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (paramCharSequence != null)
          {
            localParcel.writeInt(1);
            TextUtils.writeToParcel(paramCharSequence, localParcel, 0);
          }
          while (true)
          {
            this.mRemote.transact(6, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onRepeatModeChanged(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(9, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onSessionDestroyed()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onSessionReady()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          this.mRemote.transact(13, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onShuffleModeChanged(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(12, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onShuffleModeChangedRemoved(boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (paramBoolean);
          while (true)
          {
            localParcel.writeInt(i);
            this.mRemote.transact(10, localParcel, null, 1);
            return;
            i = 0;
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }

      public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcelableVolumeInfo != null)
          {
            localParcel.writeInt(1);
            paramParcelableVolumeInfo.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.mRemote.transact(8, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.IMediaControllerCallback
 * JD-Core Version:    0.6.2
 */