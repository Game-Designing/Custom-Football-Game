package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzddt extends zzdob<zzddt, zza> implements zzdpm {
    private static volatile zzdpv<zzddt> zzdv;
    /* access modifiers changed from: private */
    public static final zzddt zzgqq = new zzddt();
    private zzded zzgqo;
    private zzdgn zzgqp;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzddt, zza> implements zzdpm {
        private zza() {
            super(zzddt.zzgqq);
        }

        /* synthetic */ zza(C9630on onVar) {
            this();
        }
    }

    private zzddt() {
    }

    /* renamed from: l */
    public final zzded mo31401l() {
        zzded zzded = this.zzgqo;
        return zzded == null ? zzded.m29255n() : zzded;
    }

    /* renamed from: m */
    public final zzdgn mo31402m() {
        zzdgn zzdgn = this.zzgqp;
        return zzdgn == null ? zzdgn.m29413n() : zzdgn;
    }

    /* renamed from: a */
    public static zzddt m29229a(zzdmr zzdmr) throws zzdok {
        return (zzddt) zzdob.m29878a(zzgqq, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9630on.f22845a[i - 1]) {
            case 1:
                return new zzddt();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgqq, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzgqo", "zzgqp"});
            case 4:
                return zzgqq;
            case 5:
                zzdpv<zzddt> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzddt.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgqq);
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
        zzdob.m29887a(zzddt.class, zzgqq);
    }
}
