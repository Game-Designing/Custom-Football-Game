package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdfv extends zzdob<zzdfv, zza> implements zzdpm {
    private static volatile zzdpv<zzdfv> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfv zzgsy = new zzdfv();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f27972a;
    private zzdfx zzgsx;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdfv, zza> implements zzdpm {
        private zza() {
            super(zzdfv.zzgsy);
        }

        /* renamed from: a */
        public final zza mo31440a(int i) {
            mo31614j();
            ((zzdfv) this.f28067b).m29348b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31441a(zzdfx zzdfx) {
            mo31614j();
            ((zzdfv) this.f28067b).m29347a(zzdfx);
            return this;
        }

        /* renamed from: a */
        public final zza mo31442a(zzdmr zzdmr) {
            mo31614j();
            ((zzdfv) this.f28067b).m29349b(zzdmr);
            return this;
        }

        /* synthetic */ zza(C8795Cn cn) {
            this();
        }
    }

    private zzdfv() {
    }

    /* renamed from: l */
    public final int mo31437l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29348b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: n */
    public final zzdfx mo31439n() {
        zzdfx zzdfx = this.zzgsx;
        return zzdfx == null ? zzdfx.m29369q() : zzdfx;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29347a(zzdfx zzdfx) {
        if (zzdfx != null) {
            this.zzgsx = zzdfx;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: m */
    public final zzdmr mo31438m() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29349b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdfv m29343a(zzdmr zzdmr) throws zzdok {
        return (zzdfv) zzdob.m29878a(zzgsy, zzdmr);
    }

    /* renamed from: o */
    public static zza m29350o() {
        return (zza) zzgsy.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8795Cn.f20561a[i - 1]) {
            case 1:
                return new zzdfv();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgsy, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgsx", "zzgqs"});
            case 4:
                return zzgsy;
            case 5:
                zzdpv<zzdfv> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfv.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgsy);
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
        zzdob.m29887a(zzdfv.class, zzgsy);
    }
}
