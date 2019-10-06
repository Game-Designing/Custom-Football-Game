package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdgl extends zzdob<zzdgl, zza> implements zzdpm {
    private static volatile zzdpv<zzdgl> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgl zzgtu = new zzdgl();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f27972a;
    private zzdgp zzgtt;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdgl, zza> implements zzdpm {
        private zza() {
            super(zzdgl.zzgtu);
        }

        /* renamed from: a */
        public final zza mo31457a(int i) {
            mo31614j();
            ((zzdgl) this.f28067b).m29400b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31458a(zzdgp zzdgp) {
            mo31614j();
            ((zzdgl) this.f28067b).m29399a(zzdgp);
            return this;
        }

        /* renamed from: a */
        public final zza mo31459a(zzdmr zzdmr) {
            mo31614j();
            ((zzdgl) this.f28067b).m29401b(zzdmr);
            return this;
        }

        /* synthetic */ zza(C8921In in) {
            this();
        }
    }

    private zzdgl() {
    }

    /* renamed from: l */
    public final int mo31454l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29400b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: n */
    public final zzdgp mo31456n() {
        zzdgp zzdgp = this.zzgtt;
        return zzdgp == null ? zzdgp.m29418n() : zzdgp;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29399a(zzdgp zzdgp) {
        if (zzdgp != null) {
            this.zzgtt = zzdgp;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: m */
    public final zzdmr mo31455m() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29401b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdgl m29395a(zzdmr zzdmr) throws zzdok {
        return (zzdgl) zzdob.m29878a(zzgtu, zzdmr);
    }

    /* renamed from: o */
    public static zza m29402o() {
        return (zza) zzgtu.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8921In.f21263a[i - 1]) {
            case 1:
                return new zzdgl();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgtu, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgtt", "zzgqs"});
            case 4:
                return zzgtu;
            case 5:
                zzdpv<zzdgl> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgl.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgtu);
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
    public static zzdgl m29403p() {
        return zzgtu;
    }

    static {
        zzdob.m29887a(zzdgl.class, zzgtu);
    }
}
