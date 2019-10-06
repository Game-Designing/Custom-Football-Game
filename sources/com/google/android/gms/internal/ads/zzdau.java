package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdau extends zzdob<zzdau, zza> implements zzdpm {
    private static volatile zzdpv<zzdau> zzdv;
    /* access modifiers changed from: private */
    public static final zzdau zzgoq = new zzdau();
    private int zzdj;
    private String zzdk;
    private int zzgon;
    private String zzgoo;
    private zzdap zzgop;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdau, zza> implements zzdpm {
        private zza() {
            super(zzdau.zzgoq);
        }

        /* renamed from: a */
        public final zza mo31355a(zzb zzb) {
            mo31614j();
            ((zzdau) this.f28067b).m29106a(zzb);
            return this;
        }

        /* renamed from: a */
        public final zza mo31356a(String str) {
            mo31614j();
            ((zzdau) this.f28067b).m29110a(str);
            return this;
        }

        /* renamed from: a */
        public final zza mo31354a(com.google.android.gms.internal.ads.zzdap.zzb zzb) {
            mo31614j();
            ((zzdau) this.f28067b).m29105a(zzb);
            return this;
        }

        /* synthetic */ zza(C9004Mm mm) {
            this();
        }
    }

    public enum zzb implements zzdoe {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        

        /* renamed from: c */
        private static final zzdof<zzb> f27753c = null;

        /* renamed from: e */
        private final int f27755e;

        /* renamed from: d */
        public final int mo30728d() {
            return this.f27755e;
        }

        /* renamed from: a */
        public static zzb m29117a(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        /* renamed from: e */
        public static zzdog m29118e() {
            return C9046Om.f21548a;
        }

        private zzb(int i) {
            this.f27755e = i;
        }

        static {
            f27753c = new C9025Nm();
        }
    }

    private zzdau() {
        String str = "";
        this.zzdk = str;
        this.zzgoo = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29106a(zzb zzb2) {
        if (zzb2 != null) {
            this.zzdj |= 1;
            this.zzgon = zzb2.mo30728d();
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29110a(String str) {
        if (str != null) {
            this.zzdj |= 2;
            this.zzdk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29105a(com.google.android.gms.internal.ads.zzdap.zzb zzb2) {
        this.zzgop = (zzdap) zzb2.mo31612g();
        this.zzdj |= 8;
    }

    /* renamed from: l */
    public static zza m29111l() {
        return (zza) zzgoq.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9004Mm.f21484a[i - 1]) {
            case 1:
                return new zzdau();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgoq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003", new Object[]{"zzdj", "zzgon", zzb.m29118e(), "zzdk", "zzgoo", "zzgop"});
            case 4:
                return zzgoq;
            case 5:
                zzdpv<zzdau> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdau.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzgoq);
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
        zzdob.m29887a(zzdau.class, zzgoq);
    }
}
