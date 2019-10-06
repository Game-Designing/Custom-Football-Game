package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdet extends zzdob<zzdet, zza> implements zzdpm {
    private static volatile zzdpv<zzdet> zzdv;
    /* access modifiers changed from: private */
    public static final zzdet zzgro = new zzdet();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f27972a;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdet, zza> implements zzdpm {
        private zza() {
            super(zzdet.zzgro);
        }

        /* renamed from: a */
        public final zza mo31425a(int i) {
            mo31614j();
            ((zzdet) this.f28067b).m29292b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31426a(zzdmr zzdmr) {
            mo31614j();
            ((zzdet) this.f28067b).m29293b(zzdmr);
            return this;
        }

        /* synthetic */ zza(C9778vn vnVar) {
            this();
        }
    }

    private zzdet() {
    }

    /* renamed from: l */
    public final int mo31423l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29292b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: m */
    public final zzdmr mo31424m() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29293b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdet m29289a(zzdmr zzdmr) throws zzdok {
        return (zzdet) zzdob.m29878a(zzgro, zzdmr);
    }

    /* renamed from: n */
    public static zza m29294n() {
        return (zza) zzgro.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9778vn.f23339a[i - 1]) {
            case 1:
                return new zzdet();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgro, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgro;
            case 5:
                zzdpv<zzdet> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdet.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgro);
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
        zzdob.m29887a(zzdet.class, zzgro);
    }
}
