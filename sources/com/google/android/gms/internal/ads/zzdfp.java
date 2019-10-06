package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdfp extends zzdob<zzdfp, zza> implements zzdpm {
    private static volatile zzdpv<zzdfp> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfp zzgsq = new zzdfp();
    private zzdgw zzgsp;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdfp, zza> implements zzdpm {
        private zza() {
            super(zzdfp.zzgsq);
        }

        /* synthetic */ zza(C9862zn znVar) {
            this();
        }
    }

    private zzdfp() {
    }

    /* renamed from: l */
    public final zzdgw mo31432l() {
        zzdgw zzdgw = this.zzgsp;
        return zzdgw == null ? zzdgw.m29443n() : zzdgw;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9862zn.f23749a[i - 1]) {
            case 1:
                return new zzdfp();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgsq, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzgsp"});
            case 4:
                return zzgsq;
            case 5:
                zzdpv<zzdfp> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfp.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgsq);
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

    /* renamed from: m */
    public static zzdfp m29329m() {
        return zzgsq;
    }

    static {
        zzdob.m29887a(zzdfp.class, zzgsq);
    }
}
