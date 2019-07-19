package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class NativeAppCallContentProvider extends ContentProvider
{
  private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.NativeAppCallContentProvider";
  private static final String TAG = NativeAppCallContentProvider.class.getName();
  private final AttachmentDataSource dataSource;

  public NativeAppCallContentProvider()
  {
    this(new NativeAppCallAttachmentStore());
  }

  NativeAppCallContentProvider(AttachmentDataSource paramAttachmentDataSource)
  {
    this.dataSource = paramAttachmentDataSource;
  }

  public static String getAttachmentUrl(String paramString1, UUID paramUUID, String paramString2)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = "content://com.facebook.app.NativeAppCallContentProvider";
    arrayOfObject[1] = paramString1;
    arrayOfObject[2] = paramUUID.toString();
    arrayOfObject[3] = paramString2;
    return String.format("%s%s/%s/%s", arrayOfObject);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  public String getType(Uri paramUri)
  {
    return null;
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }

  public boolean onCreate()
  {
    return true;
  }

  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    Pair localPair = parseCallIdAndAttachmentName(paramUri);
    if (localPair == null)
      throw new FileNotFoundException();
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.open(this.dataSource.openAttachment((UUID)localPair.first, (String)localPair.second), 268435456);
      return localParcelFileDescriptor;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e(TAG, "Got unexpected exception:" + localFileNotFoundException);
      throw localFileNotFoundException;
    }
  }

  Pair<UUID, String> parseCallIdAndAttachmentName(Uri paramUri)
  {
    try
    {
      String[] arrayOfString = paramUri.getPath().substring(1).split("/");
      String str1 = arrayOfString[0];
      String str2 = arrayOfString[1];
      Pair localPair = new Pair(UUID.fromString(str1), str2);
      return localPair;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  static abstract interface AttachmentDataSource
  {
    public abstract File openAttachment(UUID paramUUID, String paramString)
      throws FileNotFoundException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.NativeAppCallContentProvider
 * JD-Core Version:    0.6.2
 */