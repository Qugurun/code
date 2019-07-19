package com.mopub.volley.toolbox;

import com.mopub.volley.AuthFailureError;

public abstract interface Authenticator
{
  public abstract String getAuthToken()
    throws AuthFailureError;

  public abstract void invalidateAuthToken(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.Authenticator
 * JD-Core Version:    0.6.2
 */