package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdhe extends zzdob<zzdhe, zza> implements zzdpm {
    private static volatile zzdpv<zzdhe> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhe zzgvi = new zzdhe();
    private int zzgqk;
    private zzdhg zzgvh;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdhe, zza> implements zzdpm {
        private zza() {
            super(zzdhe.zzgvi);
        }

        /* renamed from: a */
        public final zza mo31503a(int i) {
            mo31614j();
            ((zzdhe) this.f28067b).m29519b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31504a(zzdhg zzdhg) {
            mo31614j();
            ((zzdhe) this.f28067b).m29518a(zzdhg);
            return this;
        }

        /* synthetic */ zza(C9130Sn sn) {
            this();
        }
    }

    private zzdhe() {
    }

    /* renamed from: l */
    public final int mo31501l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29519b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: m */
    public final zzdhg mo31502m() {
        zzdhg zzdhg = this.zzgvh;
        return zzdhg == null ? zzdhg.m29528m() : zzdhg;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29518a(zzdhg zzdhg) {
        if (zzdhg != null) {
            this.zzgvh = zzdhg;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdhe m29515a(zzdmr zzdmr) throws zzdok {
        return (zzdhe) zzdob.m29878a(zzgvi, zzdmr);
    }

    /* renamed from: n */
    public static zza m29520n() {
        return (zza) zzgvi.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9130Sn.f21711a[i - 1]) {
            case 1:
                return new zzdhe();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgvi, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgqk", "zzgvh"});
            case 4:
                return zzgvi;
            case 5:
                zzdpv<zzdhe> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhe.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgvi);
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
        zzdob.m29887a(zzdhe.class, zzgvi);
    }
}
