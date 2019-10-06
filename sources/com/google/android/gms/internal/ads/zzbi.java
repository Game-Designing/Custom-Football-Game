package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zzb;
import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzbi {

    public static final class zza extends zzdob<zza, C15003zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zza zzdu = new zza();
        private static volatile zzdpv<zza> zzdv;
        private int zzdj;
        private String zzdk;
        private long zzdl;
        private String zzdm;
        private String zzdn;
        private String zzdo;
        private long zzdp;
        private long zzdq;
        private String zzdr;
        private long zzds;
        private String zzdt;

        /* renamed from: com.google.android.gms.internal.ads.zzbi$zza$zza reason: collision with other inner class name */
        public static final class C15003zza extends com.google.android.gms.internal.ads.zzdob.zza<zza, C15003zza> implements zzdpm {
            private C15003zza() {
                super(zza.zzdu);
            }

            /* renamed from: a */
            public final C15003zza mo30639a(String str) {
                mo31614j();
                ((zza) this.f28067b).m26972a(str);
                return this;
            }

            /* renamed from: a */
            public final C15003zza mo30638a(long j) {
                mo31614j();
                ((zza) this.f28067b).m26969a(j);
                return this;
            }

            /* renamed from: b */
            public final C15003zza mo30640b(String str) {
                mo31614j();
                ((zza) this.f28067b).m26974b(str);
                return this;
            }

            /* renamed from: c */
            public final C15003zza mo30641c(String str) {
                mo31614j();
                ((zza) this.f28067b).m26976c(str);
                return this;
            }

            /* synthetic */ C15003zza(C9622of ofVar) {
                this();
            }
        }

        private zza() {
            String str = "";
            this.zzdk = str;
            this.zzdm = str;
            this.zzdn = str;
            this.zzdo = str;
            this.zzdr = str;
            this.zzdt = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m26972a(String str) {
            if (str != null) {
                this.zzdj |= 1;
                this.zzdk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m26969a(long j) {
            this.zzdj |= 2;
            this.zzdl = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final void m26974b(String str) {
            if (str != null) {
                this.zzdj |= 4;
                this.zzdm = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public final void m26976c(String str) {
            if (str != null) {
                this.zzdj |= 8;
                this.zzdn = str;
                return;
            }
            throw new NullPointerException();
        }

        /* renamed from: l */
        public static C15003zza m26977l() {
            return (C15003zza) zzdu.mo30637a(zze.f28074e, null, null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            switch (C9622of.f22837a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C15003zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzdu, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\b\u0007\t\u0002\b\n\b\t", new Object[]{"zzdj", "zzdk", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt"});
                case 4:
                    return zzdu;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzb<>(zzdu);
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
            zzdob.m29887a(zza.class, zzdu);
        }
    }
}
