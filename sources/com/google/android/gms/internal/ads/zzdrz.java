package com.google.android.gms.internal.ads;

public final class zzdrz {

    public static final class zza extends zzdob<zza, C15008zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzhoq = new zza();
        private int zzdj;
        private int zzhoj;
        private zzb zzhok;
        private zzdmr zzhol;
        private zzdmr zzhom;
        private boolean zzhon;
        private boolean zzhoo;
        private byte zzhop = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zza reason: collision with other inner class name */
        public static final class C15008zza extends com.google.android.gms.internal.ads.zzdob.zza<zza, C15008zza> implements zzdpm {
            private C15008zza() {
                super(zza.zzhoq);
            }

            /* synthetic */ C15008zza(C9501iq iqVar) {
                this();
            }
        }

        public static final class zzb extends zzdob<zzb, C15009zza> implements zzdpm {
            private static volatile zzdpv<zzb> zzdv;
            /* access modifiers changed from: private */
            public static final zzb zzhov = new zzb();
            private int zzdj;
            private String zzhor;
            private String zzhos;
            private String zzhot;
            private int zzhou;

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zzb$zza reason: collision with other inner class name */
            public static final class C15009zza extends com.google.android.gms.internal.ads.zzdob.zza<zzb, C15009zza> implements zzdpm {
                private C15009zza() {
                    super(zzb.zzhov);
                }

                /* synthetic */ C15009zza(C9501iq iqVar) {
                    this();
                }
            }

            private zzb() {
                String str = "";
                this.zzhor = str;
                this.zzhos = str;
                this.zzhot = str;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C15009zza(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhov, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzdj", "zzhor", "zzhos", "zzhot", "zzhou"});
                    case 4:
                        return zzhov;
                    case 5:
                        zzdpv<zzb> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzb.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhov);
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
                zzdob.m29887a(zzb.class, zzhov);
            }
        }

        public enum zzc implements zzdoe {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            

            /* renamed from: f */
            private static final zzdof<zzc> f28184f = null;

            /* renamed from: h */
            private final int f28186h;

            /* renamed from: d */
            public final int mo30728d() {
                return this.f28186h;
            }

            /* renamed from: a */
            public static zzc m30031a(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            /* renamed from: e */
            public static zzdog m30032e() {
                return C9545kq.f22693a;
            }

            private zzc(int i) {
                this.f28186h = i;
            }

            static {
                f28184f = new C9523jq();
            }
        }

        private zza() {
            zzdmr zzdmr = zzdmr.f27972a;
            this.zzhol = zzdmr;
            this.zzhom = zzdmr;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (C9501iq.f22571a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C15008zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzhoq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzdj", "zzhoj", zzc.m30032e(), "zzhok", "zzhol", "zzhom", "zzhon", "zzhoo"});
                case 4:
                    return zzhoq;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhoq);
                                zzdv = zzdpv;
                            }
                        }
                    }
                    return zzdpv;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzhop = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.m29887a(zza.class, zzhoq);
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzhpr = new zzb();
        private int zzbzi;
        private int zzdj;
        private zzdmr zzhol;
        private byte zzhop = 2;
        private String zzhos;
        private int zzhpc;
        private String zzhpd;
        private String zzhpe;
        private C15010zzb zzhpf;
        private zzdoj<zzh> zzhpg;
        private String zzhph;
        private zzf zzhpi;
        private boolean zzhpj;
        private zzdoj<String> zzhpk;
        private String zzhpl;
        private boolean zzhpm;
        private boolean zzhpn;
        private zzi zzhpo;
        private zzdoj<String> zzhpp;
        private zzdoj<String> zzhpq;

        public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzhpr);
            }

            /* synthetic */ zza(C9501iq iqVar) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb reason: collision with other inner class name */
        public static final class C15010zzb extends zzdob<C15010zzb, zza> implements zzdpm {
            private static volatile zzdpv<C15010zzb> zzdv;
            /* access modifiers changed from: private */
            public static final C15010zzb zzhpt = new C15010zzb();
            private int zzdj;
            private String zzhps = "";

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb$zza */
            public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<C15010zzb, zza> implements zzdpm {
                private zza() {
                    super(C15010zzb.zzhpt);
                }

                /* synthetic */ zza(C9501iq iqVar) {
                    this();
                }
            }

            private C15010zzb() {
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new C15010zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhpt, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdj", "zzhps"});
                    case 4:
                        return zzhpt;
                    case 5:
                        zzdpv<C15010zzb> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (C15010zzb.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhpt);
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
                zzdob.m29887a(C15010zzb.class, zzhpt);
            }
        }

        public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
            private static volatile zzdpv<zzc> zzdv;
            /* access modifiers changed from: private */
            public static final zzc zzhpv = new zzc();
            private int zzdj;
            private zzdmr zzgua;
            private byte zzhop = 2;
            private zzdmr zzhpu;

            public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzc, zza> implements zzdpm {
                private zza() {
                    super(zzc.zzhpv);
                }

                /* synthetic */ zza(C9501iq iqVar) {
                    this();
                }
            }

            private zzc() {
                zzdmr zzdmr = zzdmr.f27972a;
                this.zzhpu = zzdmr;
                this.zzgua = zzdmr;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhpv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzdj", "zzhpu", "zzgua"});
                    case 4:
                        return zzhpv;
                    case 5:
                        zzdpv<zzc> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzc.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhpv);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.m29887a(zzc.class, zzhpv);
            }
        }

        public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
            private static volatile zzdpv<zzd> zzdv;
            /* access modifiers changed from: private */
            public static final zzd zzhqb = new zzd();
            private int zzdj;
            private byte zzhop = 2;
            private C15011zzb zzhpw;
            private zzdoj<zzc> zzhpx = zzdob.m29889k();
            private zzdmr zzhpy;
            private zzdmr zzhpz;
            private int zzhqa;

            public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzd, zza> implements zzdpm {
                private zza() {
                    super(zzd.zzhqb);
                }

                /* synthetic */ zza(C9501iq iqVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb reason: collision with other inner class name */
            public static final class C15011zzb extends zzdob<C15011zzb, zza> implements zzdpm {
                private static volatile zzdpv<C15011zzb> zzdv;
                /* access modifiers changed from: private */
                public static final C15011zzb zzhqf = new C15011zzb();
                private int zzdj;
                private zzdmr zzhqc;
                private zzdmr zzhqd;
                private zzdmr zzhqe;

                /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb$zza */
                public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<C15011zzb, zza> implements zzdpm {
                    private zza() {
                        super(C15011zzb.zzhqf);
                    }

                    /* synthetic */ zza(C9501iq iqVar) {
                        this();
                    }
                }

                private C15011zzb() {
                    zzdmr zzdmr = zzdmr.f27972a;
                    this.zzhqc = zzdmr;
                    this.zzhqd = zzdmr;
                    this.zzhqe = zzdmr;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public final Object mo30637a(int i, Object obj, Object obj2) {
                    switch (C9501iq.f22571a[i - 1]) {
                        case 1:
                            return new C15011zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zzdob.m29885a((zzdpk) zzhqf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqc", "zzhqd", "zzhqe"});
                        case 4:
                            return zzhqf;
                        case 5:
                            zzdpv<C15011zzb> zzdpv = zzdv;
                            if (zzdpv == null) {
                                synchronized (C15011zzb.class) {
                                    zzdpv = zzdv;
                                    if (zzdpv == null) {
                                        zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhqf);
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
                    zzdob.m29887a(C15011zzb.class, zzhqf);
                }
            }

            private zzd() {
                zzdmr zzdmr = zzdmr.f27972a;
                this.zzhpy = zzdmr;
                this.zzhpz = zzdmr;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhqb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzdj", "zzhpw", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa"});
                    case 4:
                        return zzhqb;
                    case 5:
                        zzdpv<zzd> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzd.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhqb);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.m29887a(zzd.class, zzhqb);
            }
        }

        public static final class zze extends zzdob<zze, zza> implements zzdpm {
            private static volatile zzdpv<zze> zzdv;
            /* access modifiers changed from: private */
            public static final zze zzhqi = new zze();
            private int zzdj;
            private byte zzhop = 2;
            private zzdoj<zzc> zzhpx = zzdob.m29889k();
            private zzdmr zzhpy;
            private zzdmr zzhpz;
            private int zzhqa;
            private C15012zzb zzhqg;
            private zzdmr zzhqh;

            public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zze, zza> implements zzdpm {
                private zza() {
                    super(zze.zzhqi);
                }

                /* synthetic */ zza(C9501iq iqVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb reason: collision with other inner class name */
            public static final class C15012zzb extends zzdob<C15012zzb, zza> implements zzdpm {
                private static volatile zzdpv<C15012zzb> zzdv;
                /* access modifiers changed from: private */
                public static final C15012zzb zzhql = new C15012zzb();
                private int zzdj;
                private zzdmr zzhqe;
                private int zzhqj;
                private zzdmr zzhqk;

                /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb$zza */
                public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<C15012zzb, zza> implements zzdpm {
                    private zza() {
                        super(C15012zzb.zzhql);
                    }

                    /* synthetic */ zza(C9501iq iqVar) {
                        this();
                    }
                }

                private C15012zzb() {
                    zzdmr zzdmr = zzdmr.f27972a;
                    this.zzhqk = zzdmr;
                    this.zzhqe = zzdmr;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public final Object mo30637a(int i, Object obj, Object obj2) {
                    switch (C9501iq.f22571a[i - 1]) {
                        case 1:
                            return new C15012zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zzdob.m29885a((zzdpk) zzhql, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqj", "zzhqk", "zzhqe"});
                        case 4:
                            return zzhql;
                        case 5:
                            zzdpv<C15012zzb> zzdpv = zzdv;
                            if (zzdpv == null) {
                                synchronized (C15012zzb.class) {
                                    zzdpv = zzdv;
                                    if (zzdpv == null) {
                                        zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhql);
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
                    zzdob.m29887a(C15012zzb.class, zzhql);
                }
            }

            private zze() {
                zzdmr zzdmr = zzdmr.f27972a;
                this.zzhpy = zzdmr;
                this.zzhpz = zzdmr;
                this.zzhqh = zzdmr;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhqi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzdj", "zzhqg", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa", "zzhqh"});
                    case 4:
                        return zzhqi;
                    case 5:
                        zzdpv<zze> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zze.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhqi);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.m29887a(zze.class, zzhqi);
            }
        }

        public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
            private static volatile zzdpv<zzf> zzdv;
            /* access modifiers changed from: private */
            public static final zzf zzhqo = new zzf();
            private int zzbzi;
            private int zzdj;
            private String zzhqm = "";
            private zzdmr zzhqn = zzdmr.f27972a;

            public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzf, zza> implements zzdpm {
                private zza() {
                    super(zzf.zzhqo);
                }

                /* synthetic */ zza(C9501iq iqVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzf$zzb reason: collision with other inner class name */
            public enum C15013zzb implements zzdoe {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                

                /* renamed from: c */
                private static final zzdof<C15013zzb> f28189c = null;

                /* renamed from: e */
                private final int f28191e;

                /* renamed from: d */
                public final int mo30728d() {
                    return this.f28191e;
                }

                /* renamed from: a */
                public static C15013zzb m30050a(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                /* renamed from: e */
                public static zzdog m30051e() {
                    return C9589mq.f22788a;
                }

                private C15013zzb(int i) {
                    this.f28191e = i;
                }

                static {
                    f28189c = new C9567lq();
                }
            }

            private zzf() {
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhqo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzbzi", C15013zzb.m30051e(), "zzhqm", "zzhqn"});
                    case 4:
                        return zzhqo;
                    case 5:
                        zzdpv<zzf> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzf.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhqo);
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
                zzdob.m29887a(zzf.class, zzhqo);
            }
        }

        public enum zzg implements zzdoe {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            

            /* renamed from: k */
            private static final zzdof<zzg> f28202k = null;

            /* renamed from: m */
            private final int f28204m;

            /* renamed from: d */
            public final int mo30728d() {
                return this.f28204m;
            }

            /* renamed from: a */
            public static zzg m30053a(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            /* renamed from: e */
            public static zzdog m30054e() {
                return C9633oq.f22850a;
            }

            private zzg(int i) {
                this.f28204m = i;
            }

            static {
                f28202k = new C9611nq();
            }
        }

        public static final class zzh extends zzdob<zzh, C15014zzb> implements zzdpm {
            private static volatile zzdpv<zzh> zzdv;
            /* access modifiers changed from: private */
            public static final zzh zzhrl = new zzh();
            private int zzdj;
            private byte zzhop = 2;
            private String zzhos;
            private int zzhrd;
            private zzd zzhre;
            private zze zzhrf;
            private int zzhrg;
            private zzdoh zzhrh;
            private String zzhri;
            private int zzhrj;
            private zzdoj<String> zzhrk;

            public enum zza implements zzdoe {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                

                /* renamed from: e */
                private static final zzdof<zza> f28209e = null;

                /* renamed from: g */
                private final int f28211g;

                /* renamed from: d */
                public final int mo30728d() {
                    return this.f28211g;
                }

                /* renamed from: a */
                public static zza m30058a(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                /* renamed from: e */
                public static zzdog m30059e() {
                    return C9676qq.f22914a;
                }

                private zza(int i) {
                    this.f28211g = i;
                }

                static {
                    f28209e = new C9655pq();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzh$zzb reason: collision with other inner class name */
            public static final class C15014zzb extends com.google.android.gms.internal.ads.zzdob.zza<zzh, C15014zzb> implements zzdpm {
                private C15014zzb() {
                    super(zzh.zzhrl);
                }

                /* synthetic */ C15014zzb(C9501iq iqVar) {
                    this();
                }
            }

            private zzh() {
                String str = "";
                this.zzhos = str;
                this.zzhrh = zzdob.m29888j();
                this.zzhri = str;
                this.zzhrk = zzdob.m29889k();
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C15014zzb(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhrl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzdj", "zzhrd", "zzhos", "zzhre", "zzhrf", "zzhrg", "zzhrh", "zzhri", "zzhrj", zza.m30059e(), "zzhrk"});
                    case 4:
                        return zzhrl;
                    case 5:
                        zzdpv<zzh> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzh.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhrl);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.m29887a(zzh.class, zzhrl);
            }
        }

        public static final class zzi extends zzdob<zzi, zza> implements zzdpm {
            private static volatile zzdpv<zzi> zzdv;
            /* access modifiers changed from: private */
            public static final zzi zzhru = new zzi();
            private int zzdj;
            private String zzhrr = "";
            private long zzhrs;
            private boolean zzhrt;

            public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzi, zza> implements zzdpm {
                private zza() {
                    super(zzi.zzhru);
                }

                /* synthetic */ zza(C9501iq iqVar) {
                    this();
                }
            }

            private zzi() {
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final Object mo30637a(int i, Object obj, Object obj2) {
                switch (C9501iq.f22571a[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzdob.m29885a((zzdpk) zzhru, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzdj", "zzhrr", "zzhrs", "zzhrt"});
                    case 4:
                        return zzhru;
                    case 5:
                        zzdpv<zzi> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzi.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhru);
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
                zzdob.m29887a(zzi.class, zzhru);
            }
        }

        private zzb() {
            String str = "";
            this.zzhos = str;
            this.zzhpd = str;
            this.zzhpe = str;
            this.zzhpg = zzdob.m29889k();
            this.zzhph = str;
            this.zzhpk = zzdob.m29889k();
            this.zzhpl = str;
            this.zzhol = zzdmr.f27972a;
            this.zzhpp = zzdob.m29889k();
            this.zzhpq = zzdob.m29889k();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (C9501iq.f22571a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzhpr, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzdj", "zzhos", "zzhpd", "zzhpe", "zzhpg", zzh.class, "zzhpj", "zzhpk", "zzhpl", "zzhpm", "zzhpn", "zzbzi", zzg.m30054e(), "zzhpc", zzc.m30032e(), "zzhpf", "zzhph", "zzhpi", "zzhol", "zzhpo", "zzhpp", "zzhpq"});
                case 4:
                    return zzhpr;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzhpr);
                                zzdv = zzdpv;
                            }
                        }
                    }
                    return zzdpv;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzhop = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.m29887a(zzb.class, zzhpr);
        }
    }
}
