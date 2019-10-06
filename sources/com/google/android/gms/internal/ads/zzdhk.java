package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdhk extends zzdob<zzdhk, zza> implements zzdpm {
    private static volatile zzdpv<zzdhk> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhk zzgvp = new zzdhk();
    private String zzgvn = "";
    private zzdgw zzgvo;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdhk, zza> implements zzdpm {
        private zza() {
            super(zzdhk.zzgvp);
        }

        /* synthetic */ zza(C9197Vn vn) {
            this();
        }
    }

    private zzdhk() {
    }

    /* renamed from: l */
    public final String mo31510l() {
        return this.zzgvn;
    }

    /* renamed from: m */
    public final zzdgw mo31511m() {
        zzdgw zzdgw = this.zzgvo;
        return zzdgw == null ? zzdgw.m29443n() : zzdgw;
    }

    /* renamed from: a */
    public static zzdhk m29544a(zzdmr zzdmr) throws zzdok {
        return (zzdhk) zzdob.m29878a(zzgvp, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9197Vn.f21861a[i - 1]) {
            case 1:
                return new zzdhk();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgvp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzgvn", "zzgvo"});
            case 4:
                return zzgvp;
            case 5:
                zzdpv<zzdhk> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhk.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgvp);
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
    public static zzdhk m29545n() {
        return zzgvp;
    }

    static {
        zzdob.m29887a(zzdhk.class, zzgvp);
    }
}
