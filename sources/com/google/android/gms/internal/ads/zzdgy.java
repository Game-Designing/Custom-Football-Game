package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdgy extends zzdob<zzdgy, zza> implements zzdpm {
    private static volatile zzdpv<zzdgy> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgy zzguw = new zzdgy();
    private String zzgtz;
    private String zzgus;
    private int zzgut;
    private boolean zzguu;
    private String zzguv;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdgy, zza> implements zzdpm {
        private zza() {
            super(zzdgy.zzguw);
        }

        /* renamed from: a */
        public final zza mo31478a(String str) {
            mo31614j();
            ((zzdgy) this.f28067b).m29455b(str);
            return this;
        }

        /* renamed from: b */
        public final zza mo31480b(String str) {
            mo31614j();
            ((zzdgy) this.f28067b).m29451a(str);
            return this;
        }

        /* renamed from: a */
        public final zza mo31477a(int i) {
            mo31614j();
            ((zzdgy) this.f28067b).m29453b(0);
            return this;
        }

        /* renamed from: a */
        public final zza mo31479a(boolean z) {
            mo31614j();
            ((zzdgy) this.f28067b).m29452a(true);
            return this;
        }

        /* renamed from: c */
        public final zza mo31481c(String str) {
            mo31614j();
            ((zzdgy) this.f28067b).m29457c(str);
            return this;
        }

        /* synthetic */ zza(C9068Pn pn) {
            this();
        }
    }

    private zzdgy() {
        String str = "";
        this.zzgus = str;
        this.zzgtz = str;
        this.zzguv = str;
    }

    /* renamed from: m */
    public final String mo31473m() {
        return this.zzgus;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29455b(String str) {
        if (str != null) {
            this.zzgus = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: l */
    public final String mo31472l() {
        return this.zzgtz;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29451a(String str) {
        if (str != null) {
            this.zzgtz = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: n */
    public final int mo31474n() {
        return this.zzgut;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29453b(int i) {
        this.zzgut = i;
    }

    /* renamed from: o */
    public final boolean mo31475o() {
        return this.zzguu;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29452a(boolean z) {
        this.zzguu = z;
    }

    /* renamed from: p */
    public final String mo31476p() {
        return this.zzguv;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m29457c(String str) {
        if (str != null) {
            this.zzguv = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: q */
    public static zza m29458q() {
        return (zza) zzguw.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9068Pn.f21591a[i - 1]) {
            case 1:
                return new zzdgy();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzguw, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzgus", "zzgtz", "zzgut", "zzguu", "zzguv"});
            case 4:
                return zzguw;
            case 5:
                zzdpv<zzdgy> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgy.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzb<>(zzguw);
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
        zzdob.m29887a(zzdgy.class, zzguw);
    }
}
