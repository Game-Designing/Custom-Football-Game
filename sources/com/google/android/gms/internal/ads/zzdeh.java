package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdeh extends zzdob<zzdeh, zza> implements zzdpm {
    private static volatile zzdpv<zzdeh> zzdv;
    /* access modifiers changed from: private */
    public static final zzdeh zzgrh = new zzdeh();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f27972a;
    private zzdel zzgrg;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdeh, zza> implements zzdpm {
        private zza() {
            super(zzdeh.zzgrh);
        }

        /* renamed from: a */
        public final zza mo31417a(int i) {
            mo31614j();
            ((zzdeh) this.f28067b).m29269b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31418a(zzdel zzdel) {
            mo31614j();
            ((zzdeh) this.f28067b).m29268a(zzdel);
            return this;
        }

        /* renamed from: a */
        public final zza mo31419a(zzdmr zzdmr) {
            mo31614j();
            ((zzdeh) this.f28067b).m29270b(zzdmr);
            return this;
        }

        /* synthetic */ zza(C9715sn snVar) {
            this();
        }
    }

    private zzdeh() {
    }

    /* renamed from: l */
    public final int mo31414l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29269b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: n */
    public final zzdel mo31416n() {
        zzdel zzdel = this.zzgrg;
        return zzdel == null ? zzdel.m29285m() : zzdel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29268a(zzdel zzdel) {
        if (zzdel != null) {
            this.zzgrg = zzdel;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: m */
    public final zzdmr mo31415m() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29270b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdeh m29264a(zzdmr zzdmr) throws zzdok {
        return (zzdeh) zzdob.m29878a(zzgrh, zzdmr);
    }

    /* renamed from: o */
    public static zza m29271o() {
        return (zza) zzgrh.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9715sn.f22965a[i - 1]) {
            case 1:
                return new zzdeh();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgrh, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgrg", "zzgqs"});
            case 4:
                return zzgrh;
            case 5:
                zzdpv<zzdeh> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdeh.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgrh);
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
        zzdob.m29887a(zzdeh.class, zzgrh);
    }
}
