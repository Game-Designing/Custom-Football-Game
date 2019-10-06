package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdef extends zzdob<zzdef, zza> implements zzdpm {
    private static volatile zzdpv<zzdef> zzdv;
    /* access modifiers changed from: private */
    public static final zzdef zzgrf = new zzdef();
    private int zzgre;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdef, zza> implements zzdpm {
        private zza() {
            super(zzdef.zzgrf);
        }

        /* synthetic */ zza(C9694rn rnVar) {
            this();
        }
    }

    private zzdef() {
    }

    /* renamed from: l */
    public final int mo31413l() {
        return this.zzgre;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9694rn.f22943a[i - 1]) {
            case 1:
                return new zzdef();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgrf, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgre"});
            case 4:
                return zzgrf;
            case 5:
                zzdpv<zzdef> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdef.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgrf);
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
    public static zzdef m29260m() {
        return zzgrf;
    }

    static {
        zzdob.m29887a(zzdef.class, zzgrf);
    }
}
