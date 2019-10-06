package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzdha extends zzdob<zzdha, zza> implements zzdpm {
    private static volatile zzdpv<zzdha> zzdv;
    /* access modifiers changed from: private */
    public static final zzdha zzguz = new zzdha();
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzguy = zzdob.m29889k();

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdha, zza> implements zzdpm {
        private zza() {
            super(zzdha.zzguz);
        }

        /* synthetic */ zza(C9089Qn qn) {
            this();
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzgvd = new zzb();
        private int zzguq;
        private zzdgr zzgva;
        private int zzgvb;
        private int zzgvc;

        public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvd);
            }

            /* synthetic */ zza(C9089Qn qn) {
                this();
            }
        }

        private zzb() {
        }

        /* renamed from: m */
        public final boolean mo31491m() {
            return this.zzgva != null;
        }

        /* renamed from: n */
        public final zzdgr mo31492n() {
            zzdgr zzdgr = this.zzgva;
            return zzdgr == null ? zzdgr.m29430p() : zzdgr;
        }

        /* renamed from: o */
        public final zzdgu mo31493o() {
            zzdgu a = zzdgu.m29441a(this.zzgvb);
            return a == null ? zzdgu.UNRECOGNIZED : a;
        }

        /* renamed from: p */
        public final int mo31494p() {
            return this.zzgvc;
        }

        /* renamed from: l */
        public final zzdhm mo31490l() {
            zzdhm a = zzdhm.m29550a(this.zzguq);
            return a == null ? zzdhm.UNRECOGNIZED : a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            switch (C9089Qn.f21622a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzgvd, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgva", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvd;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzgvd);
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
            zzdob.m29887a(zzb.class, zzgvd);
        }
    }

    private zzdha() {
    }

    /* renamed from: l */
    public final int mo31487l() {
        return this.zzgux;
    }

    /* renamed from: m */
    public final List<zzb> mo31488m() {
        return this.zzguy;
    }

    /* renamed from: n */
    public final int mo31489n() {
        return this.zzguy.size();
    }

    /* renamed from: a */
    public static zzdha m29478a(byte[] bArr) throws zzdok {
        return (zzdha) zzdob.m29881a(zzguz, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9089Qn.f21622a[i - 1]) {
            case 1:
                return new zzdha();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzguz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzguy", zzb.class});
            case 4:
                return zzguz;
            case 5:
                zzdpv<zzdha> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdha.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzguz);
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
        zzdob.m29887a(zzdha.class, zzguz);
    }
}
