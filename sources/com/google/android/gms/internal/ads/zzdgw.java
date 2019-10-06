package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdgw extends zzdob<zzdgw, zza> implements zzdpm {
    private static volatile zzdpv<zzdgw> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgw zzgur = new zzdgw();
    private String zzgtz = "";
    private zzdmr zzgua = zzdmr.f27972a;
    private int zzguq;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdgw, zza> implements zzdpm {
        private zza() {
            super(zzdgw.zzgur);
        }

        /* synthetic */ zza(C9047On on) {
            this();
        }
    }

    private zzdgw() {
    }

    /* renamed from: l */
    public final String mo31470l() {
        return this.zzgtz;
    }

    /* renamed from: m */
    public final zzdmr mo31471m() {
        return this.zzgua;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9047On.f21549a[i - 1]) {
            case 1:
                return new zzdgw();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgur, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgtz", "zzgua", "zzguq"});
            case 4:
                return zzgur;
            case 5:
                zzdpv<zzdgw> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgw.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgur);
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
    public static zzdgw m29443n() {
        return zzgur;
    }

    static {
        zzdob.m29887a(zzdgw.class, zzgur);
    }
}
