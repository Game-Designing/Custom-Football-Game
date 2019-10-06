package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdfz extends zzdob<zzdfz, zza> implements zzdpm {
    private static volatile zzdpv<zzdfz> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfz zzgtc = new zzdfz();
    private int zzgqy;
    private int zzgta;
    private zzdmr zzgtb = zzdmr.f27972a;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdfz, zza> implements zzdpm {
        private zza() {
            super(zzdfz.zzgtc);
        }

        /* synthetic */ zza(C8837En en) {
            this();
        }
    }

    private zzdfz() {
    }

    /* renamed from: m */
    public final zzdgf mo31452m() {
        zzdgf a = zzdgf.m29388a(this.zzgta);
        return a == null ? zzdgf.UNRECOGNIZED : a;
    }

    /* renamed from: l */
    public final zzdgj mo31451l() {
        zzdgj a = zzdgj.m29393a(this.zzgqy);
        return a == null ? zzdgj.UNRECOGNIZED : a;
    }

    /* renamed from: n */
    public final zzdmr mo31453n() {
        return this.zzgtb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8837En.f20840a[i - 1]) {
            case 1:
                return new zzdfz();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgtc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzgta", "zzgqy", "zzgtb"});
            case 4:
                return zzgtc;
            case 5:
                zzdpv<zzdfz> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfz.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgtc);
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
    public static zzdfz m29380o() {
        return zzgtc;
    }

    static {
        zzdob.m29887a(zzdfz.class, zzgtc);
    }
}
