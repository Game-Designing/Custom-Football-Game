package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdeb extends zzdob<zzdeb, zza> implements zzdpm {
    private static volatile zzdpv<zzdeb> zzdv;
    /* access modifiers changed from: private */
    public static final zzdeb zzgrc = new zzdeb();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f27972a;
    private zzdef zzgrb;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdeb, zza> implements zzdpm {
        private zza() {
            super(zzdeb.zzgrc);
        }

        /* renamed from: a */
        public final zza mo31408a(int i) {
            mo31614j();
            ((zzdeb) this.f28067b).m29242b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31409a(zzdef zzdef) {
            mo31614j();
            ((zzdeb) this.f28067b).m29241a(zzdef);
            return this;
        }

        /* renamed from: a */
        public final zza mo31410a(zzdmr zzdmr) {
            mo31614j();
            ((zzdeb) this.f28067b).m29243b(zzdmr);
            return this;
        }

        /* synthetic */ zza(C9652pn pnVar) {
            this();
        }
    }

    private zzdeb() {
    }

    /* renamed from: l */
    public final int mo31405l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29242b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: n */
    public final zzdef mo31407n() {
        zzdef zzdef = this.zzgrb;
        return zzdef == null ? zzdef.m29260m() : zzdef;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29241a(zzdef zzdef) {
        if (zzdef != null) {
            this.zzgrb = zzdef;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: m */
    public final zzdmr mo31406m() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29243b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdeb m29237a(zzdmr zzdmr) throws zzdok {
        return (zzdeb) zzdob.m29878a(zzgrc, zzdmr);
    }

    /* renamed from: o */
    public static zza m29244o() {
        return (zza) zzgrc.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9652pn.f22875a[i - 1]) {
            case 1:
                return new zzdeb();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgrc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgrb", "zzgqs"});
            case 4:
                return zzgrc;
            case 5:
                zzdpv<zzdeb> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdeb.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgrc);
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

    /* renamed from: p */
    public static zzdeb m29245p() {
        return zzgrc;
    }

    static {
        zzdob.m29887a(zzdeb.class, zzgrc);
    }
}
