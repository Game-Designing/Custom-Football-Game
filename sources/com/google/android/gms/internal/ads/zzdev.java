package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;

public final class zzdev extends zzdob<zzdev, zza> implements zzdpm {
    private static volatile zzdpv<zzdev> zzdv;
    /* access modifiers changed from: private */
    public static final zzdev zzgrp = new zzdev();
    private int zzgqu;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdev, zza> implements zzdpm {
        private zza() {
            super(zzdev.zzgrp);
        }

        /* synthetic */ zza(C9799wn wnVar) {
            this();
        }
    }

    private zzdev() {
    }

    /* renamed from: l */
    public final int mo31427l() {
        return this.zzgqu;
    }

    /* renamed from: a */
    public static zzdev m29301a(zzdmr zzdmr) throws zzdok {
        return (zzdev) zzdob.m29878a(zzgrp, zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9799wn.f23417a[i - 1]) {
            case 1:
                return new zzdev();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgrp, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\u000b", new Object[]{"zzgqu"});
            case 4:
                return zzgrp;
            case 5:
                zzdpv<zzdev> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdev.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgrp);
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
        zzdob.m29887a(zzdev.class, zzgrp);
    }
}
