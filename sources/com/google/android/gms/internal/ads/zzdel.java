package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdel extends zzdob<zzdel, zza> implements zzdpm {
    private static volatile zzdpv<zzdel> zzdv;
    /* access modifiers changed from: private */
    public static final zzdel zzgrj = new zzdel();
    private int zzgre;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdel, zza> implements zzdpm {
        private zza() {
            super(zzdel.zzgrj);
        }

        /* synthetic */ zza(C9757un unVar) {
            this();
        }
    }

    private zzdel() {
    }

    /* renamed from: l */
    public final int mo31422l() {
        return this.zzgre;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9757un.f23228a[i - 1]) {
            case 1:
                return new zzdel();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgrj, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgre"});
            case 4:
                return zzgrj;
            case 5:
                zzdpv<zzdel> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdel.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgrj);
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

    /* renamed from: m */
    public static zzdel m29285m() {
        return zzgrj;
    }

    static {
        zzdob.m29887a(zzdel.class, zzgrj);
    }
}
