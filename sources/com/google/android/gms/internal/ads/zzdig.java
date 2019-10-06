package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdig extends zzdob<zzdig, zza> implements zzdpm {
    private static volatile zzdpv<zzdig> zzdv;
    /* access modifiers changed from: private */
    public static final zzdig zzgwz = new zzdig();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f27972a;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdig, zza> implements zzdpm {
        private zza() {
            super(zzdig.zzgwz);
        }

        /* renamed from: a */
        public final zza mo31517a(int i) {
            mo31614j();
            ((zzdig) this.f28067b).m29565b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31518a(zzdmr zzdmr) {
            mo31614j();
            ((zzdig) this.f28067b).m29566b(zzdmr);
            return this;
        }

        /* synthetic */ zza(C9260Yn yn) {
            this();
        }
    }

    private zzdig() {
    }

    /* renamed from: l */
    public final int mo31515l() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29565b(int i) {
        this.zzgqk = i;
    }

    /* renamed from: m */
    public final zzdmr mo31516m() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29566b(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static zzdig m29562a(zzdmr zzdmr) throws zzdok {
        return (zzdig) zzdob.m29878a(zzgwz, zzdmr);
    }

    /* renamed from: n */
    public static zza m29567n() {
        return (zza) zzgwz.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9260Yn.f21998a[i - 1]) {
            case 1:
                return new zzdig();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgwz, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgwz;
            case 5:
                zzdpv<zzdig> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdig.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgwz);
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
        zzdob.m29887a(zzdig.class, zzgwz);
    }
}
