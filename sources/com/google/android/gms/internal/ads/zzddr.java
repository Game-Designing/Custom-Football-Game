package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzddr extends zzdob<zzddr, zza> implements zzdpm {
    private static volatile zzdpv<zzddr> zzdv;
    /* access modifiers changed from: private */
    public static final zzddr zzgqn = new zzddr();
    private int zzgqk;
    private zzdeb zzgql;
    private zzdgl zzgqm;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzddr, zza> implements zzdpm {
        private zza() {
            super(zzddr.zzgqn);
        }

        /* renamed from: a */
        public final zza mo31398a(int i) {
            mo31614j();
            ((zzddr) this.f28067b).m29219b(i);
            return this;
        }

        /* renamed from: a */
        public final zza mo31399a(zzdeb zzdeb) {
            mo31614j();
            ((zzddr) this.f28067b).m29217a(zzdeb);
            return this;
        }

        /* renamed from: a */
        public final zza mo31400a(zzdgl zzdgl) {
            mo31614j();
            ((zzddr) this.f28067b).m29218a(zzdgl);
            return this;
        }

        /* synthetic */ zza(C9608nn nnVar) {
            this();
        }
    }

    private zzddr() {
    }

    /* renamed from: l */
    public final int mo31395l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29219b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: m */
    public final zzdeb mo31396m() {
        zzdeb zzdeb = this.zzgql;
        return zzdeb == null ? zzdeb.m29245p() : zzdeb;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29217a(zzdeb zzdeb) {
        if (zzdeb != null) {
            this.zzgql = zzdeb;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: n */
    public final zzdgl mo31397n() {
        zzdgl zzdgl = this.zzgqm;
        return zzdgl == null ? zzdgl.m29403p() : zzdgl;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29218a(zzdgl zzdgl) {
        if (zzdgl != null) {
            this.zzgqm = zzdgl;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzddr m29213a(zzdmr zzdmr) throws zzdok {
        return (zzddr) zzdob.m29878a(zzgqn, zzdmr);
    }

    /* renamed from: o */
    public static zza m29220o() {
        return (zza) zzgqn.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9608nn.f22811a[i - 1]) {
            case 1:
                return new zzddr();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgqn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzgqk", "zzgql", "zzgqm"});
            case 4:
                return zzgqn;
            case 5:
                zzdpv<zzddr> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzddr.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgqn);
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
        zzdob.m29887a(zzddr.class, zzgqn);
    }
}
