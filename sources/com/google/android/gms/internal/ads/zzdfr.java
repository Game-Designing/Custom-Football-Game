package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdfr extends zzdob<zzdfr, zza> implements zzdpm {
    private static volatile zzdpv<zzdfr> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfr zzgss = new zzdfr();
    private zzdft zzgsr;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdfr, zza> implements zzdpm {
        private zza() {
            super(zzdfr.zzgss);
        }

        /* synthetic */ zza(C8753An an) {
            this();
        }
    }

    private zzdfr() {
    }

    /* renamed from: l */
    public final zzdft mo31433l() {
        zzdft zzdft = this.zzgsr;
        return zzdft == null ? zzdft.m29337o() : zzdft;
    }

    /* renamed from: a */
    public static zzdfr m29333a(zzdmr zzdmr) throws zzdok {
        return (zzdfr) zzdob.m29878a(zzgss, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8753An.f20463a[i - 1]) {
            case 1:
                return new zzdfr();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgss, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzgsr"});
            case 4:
                return zzgss;
            case 5:
                zzdpv<zzdfr> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfr.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgss);
                            zzdv = zzdpv;
                        }
                    }
                }
                return zzdpv;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzdob.m29887a(zzdfr.class, zzgss);
    }
}
