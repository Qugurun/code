package com.google.firebase.iid;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class c
{
  public static KeyPair a()
  {
    try
    {
      KeyPairGenerator localKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
      localKeyPairGenerator.initialize(2048);
      KeyPair localKeyPair = localKeyPairGenerator.generateKeyPair();
      return localKeyPair;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.c
 * JD-Core Version:    0.6.2
 */