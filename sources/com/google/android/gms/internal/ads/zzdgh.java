package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdgh extends zzdob<zzdgh, zza> implements zzdpm {
    private static volatile zzdpv<zzdgh> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgh zzgtm = new zzdgh();

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdgh, zza> implements zzdpm {
        private zza() {
            super(zzdgh.zzgtm);
        }

        /* synthetic */ zza(C8879Gn gn) {
            this();
        }
    }

    private zzdgh() {
    }

    /* renamed from: a */
    public static zzdgh m29390a(zzdmr zzdmr) throws zzdok {
        return (zzdgh) zzdob.m29878a(zzgtm, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8879Gn.f21076a[i - 1]) {
            case 1:
                return new zzdgh();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgtm, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzgtm;
            case 5:
                zzdpv<zzdgh> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgh.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgtm);
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
        zzdob.m29887a(zzdgh.class, zzgtm);
    }
}
