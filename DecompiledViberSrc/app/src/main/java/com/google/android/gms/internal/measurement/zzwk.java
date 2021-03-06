package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

abstract interface zzwk
{
  public abstract int getTag();

  public abstract double readDouble()
    throws IOException;

  public abstract float readFloat()
    throws IOException;

  public abstract String readString()
    throws IOException;

  public abstract void readStringList(List<String> paramList)
    throws IOException;

  public abstract <T> T zza(zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException;

  public abstract <T> void zza(List<T> paramList, zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException;

  public abstract <K, V> void zza(Map<K, V> paramMap, zzvo<K, V> paramzzvo, zzub paramzzub)
    throws IOException;

  @Deprecated
  public abstract <T> T zzb(zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException;

  @Deprecated
  public abstract <T> void zzb(List<T> paramList, zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException;

  public abstract void zzi(List<Double> paramList)
    throws IOException;

  public abstract void zzj(List<Float> paramList)
    throws IOException;

  public abstract void zzk(List<Long> paramList)
    throws IOException;

  public abstract void zzl(List<Long> paramList)
    throws IOException;

  public abstract void zzm(List<Integer> paramList)
    throws IOException;

  public abstract void zzn(List<Long> paramList)
    throws IOException;

  public abstract void zzo(List<Integer> paramList)
    throws IOException;

  public abstract void zzp(List<Boolean> paramList)
    throws IOException;

  public abstract void zzq(List<String> paramList)
    throws IOException;

  public abstract void zzr(List<zzte> paramList)
    throws IOException;

  public abstract void zzs(List<Integer> paramList)
    throws IOException;

  public abstract void zzt(List<Integer> paramList)
    throws IOException;

  public abstract void zzu(List<Integer> paramList)
    throws IOException;

  public abstract long zzuk()
    throws IOException;

  public abstract long zzul()
    throws IOException;

  public abstract int zzum()
    throws IOException;

  public abstract long zzun()
    throws IOException;

  public abstract int zzuo()
    throws IOException;

  public abstract boolean zzup()
    throws IOException;

  public abstract String zzuq()
    throws IOException;

  public abstract zzte zzur()
    throws IOException;

  public abstract int zzus()
    throws IOException;

  public abstract int zzut()
    throws IOException;

  public abstract int zzuu()
    throws IOException;

  public abstract long zzuv()
    throws IOException;

  public abstract int zzuw()
    throws IOException;

  public abstract long zzux()
    throws IOException;

  public abstract void zzv(List<Long> paramList)
    throws IOException;

  public abstract int zzvh()
    throws IOException;

  public abstract boolean zzvi()
    throws IOException;

  public abstract void zzw(List<Integer> paramList)
    throws IOException;

  public abstract void zzx(List<Long> paramList)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwk
 * JD-Core Version:    0.6.2
 */