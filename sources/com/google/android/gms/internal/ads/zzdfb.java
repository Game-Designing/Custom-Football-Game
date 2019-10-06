package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdfb extends zzdob<zzdfb, zza> implements zzdpm {
    private static volatile zzdpv<zzdfb> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfb zzgrs = new zzdfb();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f27972a;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdfb, zza> implements zzdpm {
        private zza() {
            super(zzdfb.zzgrs);
        }

        /* renamed from: a */
        public final zza mo31430a(int i) {
            mo31614j();
            ((zzdfb) this.f28067b).m29318b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31431a(zzdmr zzdmr) {
            mo31614j();
            ((zzdfb) this.f28067b).m29319b(zzdmr);
            return this;
        }

        /* synthetic */ zza(C9820xn xnVar) {
            this();
        }
    }

    private zzdfb() {
    }

    /* renamed from: l */
    public final int mo31428l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29318b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: m */
    public final zzdmr mo31429m() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29319b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdfb m29315a(zzdmr zzdmr) throws zzdok {
        return (zzdfb) zzdob.m29878a(zzgrs, zzdmr);
    }

    /* renamed from: n */
    public static zza m29320n() {
        return (zza) zzgrs.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9820xn.f23476a[i - 1]) {
            case 1:
                return new zzdfb();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgrs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgrs;
            case 5:
                zzdpv<zzdfb> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfb.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgrs);
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
        zzdob.m29887a(zzdfb.class, zzgrs);
    }
}
