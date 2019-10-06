package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdej extends zzdob<zzdej, zza> implements zzdpm {
    private static volatile zzdpv<zzdej> zzdv;
    /* access modifiers changed from: private */
    public static final zzdej zzgri = new zzdej();
    private int zzgqu;
    private zzdel zzgrg;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdej, zza> implements zzdpm {
        private zza() {
            super(zzdej.zzgri);
        }

        /* synthetic */ zza(C9736tn tnVar) {
            this();
        }
    }

    private zzdej() {
    }

    /* renamed from: m */
    public final zzdel mo31421m() {
        zzdel zzdel = this.zzgrg;
        return zzdel == null ? zzdel.m29285m() : zzdel;
    }

    /* renamed from: l */
    public final int mo31420l() {
        return this.zzgqu;
    }

    /* renamed from: a */
    public static zzdej m29280a(zzdmr zzdmr) throws zzdok {
        return (zzdej) zzdob.m29878a(zzgri, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9736tn.f23029a[i - 1]) {
            case 1:
                return new zzdej();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgri, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgrg", "zzgqu"});
            case 4:
                return zzgri;
            case 5:
                zzdpv<zzdej> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdej.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgri);
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
        zzdob.m29887a(zzdej.class, zzgri);
    }
}
