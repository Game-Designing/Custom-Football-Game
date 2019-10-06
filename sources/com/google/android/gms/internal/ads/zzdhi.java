package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdhi extends zzdob<zzdhi, zza> implements zzdpm {
    private static volatile zzdpv<zzdhi> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhi zzgvm = new zzdhi();
    private int zzgqk;
    private zzdhk zzgvl;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdhi, zza> implements zzdpm {
        private zza() {
            super(zzdhi.zzgvm);
        }

        /* renamed from: a */
        public final zza mo31508a(int i) {
            mo31614j();
            ((zzdhi) this.f28067b).m29536b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31509a(zzdhk zzdhk) {
            mo31614j();
            ((zzdhi) this.f28067b).m29535a(zzdhk);
            return this;
        }

        /* synthetic */ zza(C9176Un un) {
            this();
        }
    }

    private zzdhi() {
    }

    /* renamed from: l */
    public final int mo31506l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29536b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: m */
    public final zzdhk mo31507m() {
        zzdhk zzdhk = this.zzgvl;
        return zzdhk == null ? zzdhk.m29545n() : zzdhk;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29535a(zzdhk zzdhk) {
        if (zzdhk != null) {
            this.zzgvl = zzdhk;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdhi m29532a(zzdmr zzdmr) throws zzdok {
        return (zzdhi) zzdob.m29878a(zzgvm, zzdmr);
    }

    /* renamed from: n */
    public static zza m29537n() {
        return (zza) zzgvm.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9176Un.f21821a[i - 1]) {
            case 1:
                return new zzdhi();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgvm, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgqk", "zzgvl"});
            case 4:
                return zzgvm;
            case 5:
                zzdpv<zzdhi> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhi.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgvm);
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
        zzdob.m29887a(zzdhi.class, zzgvm);
    }
}
