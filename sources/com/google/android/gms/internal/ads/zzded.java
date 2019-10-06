package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzded extends zzdob<zzded, zza> implements zzdpm {
    private static volatile zzdpv<zzded> zzdv;
    /* access modifiers changed from: private */
    public static final zzded zzgrd = new zzded();
    private int zzgqu;
    private zzdef zzgrb;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzded, zza> implements zzdpm {
        private zza() {
            super(zzded.zzgrd);
        }

        /* synthetic */ zza(C9673qn qnVar) {
            this();
        }
    }

    private zzded() {
    }

    /* renamed from: m */
    public final zzdef mo31412m() {
        zzdef zzdef = this.zzgrb;
        return zzdef == null ? zzdef.m29260m() : zzdef;
    }

    /* renamed from: l */
    public final int mo31411l() {
        return this.zzgqu;
    }

    /* renamed from: a */
    public static zzded m29254a(zzdmr zzdmr) throws zzdok {
        return (zzded) zzdob.m29878a(zzgrd, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9673qn.f22908a[i - 1]) {
            case 1:
                return new zzded();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgrd, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgrb", "zzgqu"});
            case 4:
                return zzgrd;
            case 5:
                zzdpv<zzded> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzded.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgrd);
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

    /* renamed from: n */
    public static zzded m29255n() {
        return zzgrd;
    }

    static {
        zzdob.m29887a(zzded.class, zzgrd);
    }
}
