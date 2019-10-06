package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdft extends zzdob<zzdft, zza> implements zzdpm {
    private static volatile zzdpv<zzdft> zzdv;
    /* access modifiers changed from: private */
    public static final zzdft zzgsw = new zzdft();
    private zzdfz zzgst;
    private zzdfp zzgsu;
    private int zzgsv;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdft, zza> implements zzdpm {
        private zza() {
            super(zzdft.zzgsw);
        }

        /* synthetic */ zza(C8774Bn bn) {
            this();
        }
    }

    private zzdft() {
    }

    /* renamed from: l */
    public final zzdfz mo31434l() {
        zzdfz zzdfz = this.zzgst;
        return zzdfz == null ? zzdfz.m29380o() : zzdfz;
    }

    /* renamed from: m */
    public final zzdfp mo31435m() {
        zzdfp zzdfp = this.zzgsu;
        return zzdfp == null ? zzdfp.m29329m() : zzdfp;
    }

    /* renamed from: n */
    public final zzdfd mo31436n() {
        zzdfd a = zzdfd.m29327a(this.zzgsv);
        return a == null ? zzdfd.UNRECOGNIZED : a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8774Bn.f20521a[i - 1]) {
            case 1:
                return new zzdft();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgsw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzgst", "zzgsu", "zzgsv"});
            case 4:
                return zzgsw;
            case 5:
                zzdpv<zzdft> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdft.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgsw);
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

    /* renamed from: o */
    public static zzdft m29337o() {
        return zzgsw;
    }

    static {
        zzdob.m29887a(zzdft.class, zzgsw);
    }
}
