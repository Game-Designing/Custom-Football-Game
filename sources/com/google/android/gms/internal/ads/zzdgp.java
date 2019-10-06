package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdgp extends zzdob<zzdgp, zza> implements zzdpm {
    private static volatile zzdpv<zzdgp> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgp zzgty = new zzdgp();
    private int zzgtw;
    private int zzgtx;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdgp, zza> implements zzdpm {
        private zza() {
            super(zzdgp.zzgty);
        }

        /* synthetic */ zza(C8963Kn kn) {
            this();
        }
    }

    private zzdgp() {
    }

    /* renamed from: l */
    public final zzdgj mo31462l() {
        zzdgj a = zzdgj.m29393a(this.zzgtw);
        return a == null ? zzdgj.UNRECOGNIZED : a;
    }

    /* renamed from: m */
    public final int mo31463m() {
        return this.zzgtx;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8963Kn.f21408a[i - 1]) {
            case 1:
                return new zzdgp();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgty, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzgtw", "zzgtx"});
            case 4:
                return zzgty;
            case 5:
                zzdpv<zzdgp> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgp.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgty);
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
    public static zzdgp m29418n() {
        return zzgty;
    }

    static {
        zzdob.m29887a(zzdgp.class, zzgty);
    }
}
