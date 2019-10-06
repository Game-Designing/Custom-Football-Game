package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdgn extends zzdob<zzdgn, zza> implements zzdpm {
    private static volatile zzdpv<zzdgn> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgn zzgtv = new zzdgn();
    private int zzgqu;
    private zzdgp zzgtt;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdgn, zza> implements zzdpm {
        private zza() {
            super(zzdgn.zzgtv);
        }

        /* synthetic */ zza(C8942Jn jn) {
            this();
        }
    }

    private zzdgn() {
    }

    /* renamed from: m */
    public final zzdgp mo31461m() {
        zzdgp zzdgp = this.zzgtt;
        return zzdgp == null ? zzdgp.m29418n() : zzdgp;
    }

    /* renamed from: l */
    public final int mo31460l() {
        return this.zzgqu;
    }

    /* renamed from: a */
    public static zzdgn m29412a(zzdmr zzdmr) throws zzdok {
        return (zzdgn) zzdob.m29878a(zzgtv, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8942Jn.f21362a[i - 1]) {
            case 1:
                return new zzdgn();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgtv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgtt", "zzgqu"});
            case 4:
                return zzgtv;
            case 5:
                zzdpv<zzdgn> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgn.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgtv);
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

    /* renamed from: n */
    public static zzdgn m29413n() {
        return zzgtv;
    }

    static {
        zzdob.m29887a(zzdgn.class, zzgtv);
    }
}
