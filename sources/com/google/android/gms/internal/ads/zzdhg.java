package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdhg extends zzdob<zzdhg, zza> implements zzdpm {
    private static volatile zzdpv<zzdhg> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhg zzgvk = new zzdhg();
    private String zzgvj = "";

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdhg, zza> implements zzdpm {
        private zza() {
            super(zzdhg.zzgvk);
        }

        /* synthetic */ zza(C9155Tn tn) {
            this();
        }
    }

    private zzdhg() {
    }

    /* renamed from: l */
    public final String mo31505l() {
        return this.zzgvj;
    }

    /* renamed from: a */
    public static zzdhg m29527a(zzdmr zzdmr) throws zzdok {
        return (zzdhg) zzdob.m29878a(zzgvk, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9155Tn.f21779a[i - 1]) {
            case 1:
                return new zzdhg();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgvk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzgvj"});
            case 4:
                return zzgvk;
            case 5:
                zzdpv<zzdhg> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhg.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgvk);
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
    public static zzdhg m29528m() {
        return zzgvk;
    }

    static {
        zzdob.m29887a(zzdhg.class, zzgvk);
    }
}
