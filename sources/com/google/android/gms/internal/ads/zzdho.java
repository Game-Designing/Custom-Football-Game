package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;
import java.util.List;

public final class zzdho extends zzdob<zzdho, zza> implements zzdpm {
    private static volatile zzdpv<zzdho> zzdv;
    /* access modifiers changed from: private */
    public static final zzdho zzgvz = new zzdho();
    private int zzdj;
    private String zzgvx = "";
    private zzdoj<zzdgy> zzgvy = zzdob.m29889k();

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdho, zza> implements zzdpm {
        private zza() {
            super(zzdho.zzgvz);
        }

        /* renamed from: a */
        public final zza mo31514a(String str) {
            mo31614j();
            ((zzdho) this.f28067b).m29555a(str);
            return this;
        }

        /* renamed from: a */
        public final zza mo31513a(zzdgy zzdgy) {
            mo31614j();
            ((zzdho) this.f28067b).m29552a(zzdgy);
            return this;
        }

        /* synthetic */ zza(C9239Xn xn) {
            this();
        }
    }

    private zzdho() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29555a(String str) {
        if (str != null) {
            this.zzgvx = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: l */
    public final List<zzdgy> mo31512l() {
        return this.zzgvy;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29552a(zzdgy zzdgy) {
        if (zzdgy != null) {
            if (!this.zzgvy.mo29067t()) {
                zzdoj<zzdgy> zzdoj = this.zzgvy;
                int size = zzdoj.size();
                this.zzgvy = zzdoj.mo28270b(size == 0 ? 10 : size << 1);
            }
            this.zzgvy.add(zzdgy);
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: m */
    public static zza m29556m() {
        return (zza) zzgvz.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9239Xn.f21929a[i - 1]) {
            case 1:
                return new zzdho();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgvz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzdj", "zzgvx", "zzgvy", zzdgy.class});
            case 4:
                return zzgvz;
            case 5:
                zzdpv<zzdho> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdho.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzgvz);
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
        zzdob.m29887a(zzdho.class, zzgvz);
    }
}
