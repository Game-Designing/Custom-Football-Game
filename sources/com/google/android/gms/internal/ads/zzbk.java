package com.google.android.gms.internal.ads;

public final class zzbk {

    public static final class zza extends zzdob<zza, C15004zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzdy = new zza();
        private int zzdj;
        private zzb zzdw;
        private zzc zzdx;

        /* renamed from: com.google.android.gms.internal.ads.zzbk$zza$zza reason: collision with other inner class name */
        public static final class C15004zza extends com.google.android.gms.internal.ads.zzdob.zza<zza, C15004zza> implements zzdpm {
            private C15004zza() {
                super(zza.zzdy);
            }

            /* synthetic */ C15004zza(C8955Kf kf) {
                this();
            }
        }

        private zza() {
        }

        /* renamed from: l */
        public final boolean mo30710l() {
            return (this.zzdj & 1) == 1;
        }

        /* renamed from: m */
        public final zzb mo30711m() {
            zzb zzb = this.zzdw;
            return zzb == null ? zzb.m27132l() : zzb;
        }

        /* renamed from: n */
        public final boolean mo30712n() {
            return (this.zzdj & 2) == 2;
        }

        /* renamed from: o */
        public final zzc mo30713o() {
            zzc zzc = this.zzdx;
            return zzc == null ? zzc.m27136n() : zzc;
        }

        /* renamed from: a */
        public static zza m27125a(byte[] bArr, zzdno zzdno) throws zzdok {
            return (zza) zzdob.m29883a(zzdy, bArr, zzdno);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            switch (C8955Kf.f21394a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C15004zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzdy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzdw", "zzdx"});
                case 4:
                    return zzdy;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzdy);
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
            zzdob.m29887a(zza.class, zzdy);
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzea = new zzb();
        private int zzdj;
        private int zzdz = 2;

        public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzea);
            }

            /* synthetic */ zza(C8955Kf kf) {
                this();
            }
        }

        private zzb() {
        }

        /* renamed from: n */
        public final zzbm mo30714n() {
            zzbm a = zzbm.m27237a(this.zzdz);
            return a == null ? zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD : a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            switch (C8955Kf.f21394a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzea, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b\f\u0000", new Object[]{"zzdj", "zzdz", zzbm.m27238e()});
                case 4:
                    return zzea;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzea);
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

        /* renamed from: l */
        public static zzb m27132l() {
            return zzea;
        }

        static {
            zzdob.m29887a(zzb.class, zzea);
        }
    }

    public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
        private static volatile zzdpv<zzc> zzdv;
        /* access modifiers changed from: private */
        public static final zzc zzep = new zzc();
        private int zzdj;
        private String zzej;
        private String zzek;
        private String zzel;
        private String zzem;
        private String zzen;
        private String zzeo;

        public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzep);
            }

            /* synthetic */ zza(C8955Kf kf) {
                this();
            }
        }

        private zzc() {
            String str = "";
            this.zzej = str;
            this.zzek = str;
            this.zzel = str;
            this.zzem = str;
            this.zzen = str;
            this.zzeo = str;
        }

        /* renamed from: l */
        public final String mo30715l() {
            return this.zzej;
        }

        /* renamed from: m */
        public final String mo30716m() {
            return this.zzeo;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            switch (C8955Kf.f21394a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzep, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005", new Object[]{"zzdj", "zzej", "zzek", "zzel", "zzem", "zzen", "zzeo"});
                case 4:
                    return zzep;
                case 5:
                    zzdpv<zzc> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzc.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzep);
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
        public static zzc m27136n() {
            return zzep;
        }

        static {
            zzdob.m29887a(zzc.class, zzep);
        }
    }
}
