package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdap extends zzdob<zzdap, zzb> implements zzdpm {
    private static volatile zzdpv<zzdap> zzdv;
    private static final zzdoi<Integer, zza> zzgof = new C8920Im();
    /* access modifiers changed from: private */
    public static final zzdap zzgoj = new zzdap();
    private int zzdj;
    private zzdoh zzgoe = zzdob.m29888j();
    private String zzgog;
    private String zzgoh;
    private String zzgoi;

    public enum zza implements zzdoe {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        

        /* renamed from: c */
        private static final zzdof<zza> f27748c = null;

        /* renamed from: e */
        private final int f27750e;

        /* renamed from: d */
        public final int mo30728d() {
            return this.f27750e;
        }

        /* renamed from: a */
        public static zza m29100a(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        /* renamed from: e */
        public static zzdog m29101e() {
            return C8983Lm.f21437a;
        }

        private zza(int i) {
            this.f27750e = i;
        }

        static {
            f27748c = new C8962Km();
        }
    }

    public static final class zzb extends com.google.android.gms.internal.ads.zzdob.zza<zzdap, zzb> implements zzdpm {
        private zzb() {
            super(zzdap.zzgoj);
        }

        /* renamed from: a */
        public final zzb mo31352a(zza zza) {
            mo31614j();
            ((zzdap) this.f28067b).m29093a(zza);
            return this;
        }

        /* renamed from: a */
        public final zzb mo31353a(String str) {
            mo31614j();
            ((zzdap) this.f28067b).m29096a(str);
            return this;
        }

        /* synthetic */ zzb(C8920Im im) {
            this();
        }
    }

    private zzdap() {
        String str = "";
        this.zzgog = str;
        this.zzgoh = str;
        this.zzgoi = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29093a(zza zza2) {
        if (zza2 != null) {
            if (!this.zzgoe.mo29067t()) {
                zzdoh zzdoh = this.zzgoe;
                int size = zzdoh.size();
                this.zzgoe = zzdoh.mo28618c(size == 0 ? 10 : size << 1);
            }
            this.zzgoe.mo28619d(zza2.mo30728d());
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29096a(String str) {
        if (str != null) {
            this.zzdj |= 1;
            this.zzgog = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: l */
    public static zzb m29097l() {
        return (zzb) zzgoj.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8941Jm.f21361a[i - 1]) {
            case 1:
                return new zzdap();
            case 2:
                return new zzb(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgoj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002", new Object[]{"zzdj", "zzgoe", zza.m29101e(), "zzgog", "zzgoh", "zzgoi"});
            case 4:
                return zzgoj;
            case 5:
                zzdpv<zzdap> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdap.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzgoj);
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
        zzdob.m29887a(zzdap.class, zzgoj);
    }
}
