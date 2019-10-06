package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdfx extends zzdob<zzdfx, zza> implements zzdpm {
    private static volatile zzdpv<zzdfx> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfx zzgsz = new zzdfx();
    private int zzgqk;
    private zzdmr zzgsh;
    private zzdmr zzgsi;
    private zzdft zzgsr;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdfx, zza> implements zzdpm {
        private zza() {
            super(zzdfx.zzgsz);
        }

        /* renamed from: a */
        public final zza mo31447a(int i) {
            mo31614j();
            ((zzdfx) this.f28067b).m29364b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31448a(zzdft zzdft) {
            mo31614j();
            ((zzdfx) this.f28067b).m29360a(zzdft);
            return this;
        }

        /* renamed from: a */
        public final zza mo31449a(zzdmr zzdmr) {
            mo31614j();
            ((zzdfx) this.f28067b).m29366b(zzdmr);
            return this;
        }

        /* renamed from: b */
        public final zza mo31450b(zzdmr zzdmr) {
            mo31614j();
            ((zzdfx) this.f28067b).m29367c(zzdmr);
            return this;
        }

        /* synthetic */ zza(C8816Dn dn) {
            this();
        }
    }

    private zzdfx() {
        zzdmr zzdmr = zzdmr.f27972a;
        this.zzgsh = zzdmr;
        this.zzgsi = zzdmr;
    }

    /* renamed from: l */
    public final int mo31443l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29364b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: o */
    public final zzdft mo31446o() {
        zzdft zzdft = this.zzgsr;
        return zzdft == null ? zzdft.m29337o() : zzdft;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29360a(zzdft zzdft) {
        if (zzdft != null) {
            this.zzgsr = zzdft;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: m */
    public final zzdmr mo31444m() {
        return this.zzgsh;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29366b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgsh = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: n */
    public final zzdmr mo31445n() {
        return this.zzgsi;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m29367c(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgsi = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdfx m29359a(zzdmr zzdmr) throws zzdok {
        return (zzdfx) zzdob.m29878a(zzgsz, zzdmr);
    }

    /* renamed from: p */
    public static zza m29368p() {
        return (zza) zzgsz.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8816Dn.f20755a[i - 1]) {
            case 1:
                return new zzdfx();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgsz, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzgqk", "zzgsr", "zzgsh", "zzgsi"});
            case 4:
                return zzgsz;
            case 5:
                zzdpv<zzdfx> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfx.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgsz);
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

    /* renamed from: q */
    public static zzdfx m29369q() {
        return zzgsz;
    }

    static {
        zzdob.m29887a(zzdfx.class, zzgsz);
    }
}
