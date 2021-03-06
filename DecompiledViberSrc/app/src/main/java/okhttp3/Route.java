package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import javax.annotation.Nullable;

public final class Route
{
  final Address address;
  final InetSocketAddress inetSocketAddress;
  final Proxy proxy;

  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramAddress == null)
      throw new NullPointerException("address == null");
    if (paramProxy == null)
      throw new NullPointerException("proxy == null");
    if (paramInetSocketAddress == null)
      throw new NullPointerException("inetSocketAddress == null");
    this.address = paramAddress;
    this.proxy = paramProxy;
    this.inetSocketAddress = paramInetSocketAddress;
  }

  public Address address()
  {
    return this.address;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Route)) && (((Route)paramObject).address.equals(this.address)) && (((Route)paramObject).proxy.equals(this.proxy)) && (((Route)paramObject).inetSocketAddress.equals(this.inetSocketAddress));
  }

  public int hashCode()
  {
    return 31 * (31 * (527 + this.address.hashCode()) + this.proxy.hashCode()) + this.inetSocketAddress.hashCode();
  }

  public Proxy proxy()
  {
    return this.proxy;
  }

  public boolean requiresTunnel()
  {
    return (this.address.sslSocketFactory != null) && (this.proxy.type() == Proxy.Type.HTTP);
  }

  public InetSocketAddress socketAddress()
  {
    return this.inetSocketAddress;
  }

  public String toString()
  {
    return "Route{" + this.inetSocketAddress + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Route
 * JD-Core Version:    0.6.2
 */