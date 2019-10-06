package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdhc extends zzdob<zzdhc, zza> implements zzdpm {
    private static volatile zzdpv<zzdhc> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhc zzgvf = new zzdhc();
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzgve = zzdob.m29889k();

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdhc, zza> implements zzdpm {
        private zza() {
            super(zzdhc.zzgvf);
        }

        /* renamed from: a */
        public final zza mo31495a(int i) {
            mo31614j();
            ((zzdhc) this.f28067b).m29494b(i);
            return this;
        }

        /* renamed from: a */
        public final zza mo31496a(zzb zzb) {
            mo31614j();
            ((zzdhc) this.f28067b).m29491a(zzb);
            return this;
        }

        /* synthetic */ zza(C9109Rn rn) {
            this();
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzgvg = new zzb();
        private String zzgtz = "";
        private int zzguq;
        private int zzgvb;
        private int zzgvc;

        public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvg);
            }

            /* renamed from: a */
            public final zza mo31500a(String str) {
                mo31614j();
                ((zzb) this.f28067b).m29506a(str);
                return this;
            }

            /* renamed from: a */
            public final zza mo31498a(zzdgu zzdgu) {
                mo31614j();
                ((zzb) this.f28067b).m29500a(zzdgu);
                return this;
            }

            /* renamed from: a */
            public final zza mo31497a(int i) {
                mo31614j();
                ((zzb) this.f28067b).m29507b(i);
                return this;
            }

            /* renamed from: a */
            public final zza mo31499a(zzdhm zzdhm) {
                mo31614j();
                ((zzb) this.f28067b).m29505a(zzdhm);
                return this;
            }

            /* synthetic */ zza(C9109Rn rn) {
                this();
            }
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m29506a(String str) {
            if (str != null) {
                this.zzgtz = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m29500a(zzdgu zzdgu) {
            if (zzdgu != null) {
                this.zzgvb = zzdgu.mo30728d();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final void m29507b(int i) {
            this.zzgvc = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m29505a(zzdhm zzdhm) {
            if (zzdhm != null) {
                this.zzguq = zzdhm.mo30728d();
                return;
            }
            throw new NullPointerException();
        }

        /* renamed from: l */
        public static zza m29508l() {
            return (zza) zzgvg.mo30637a(zze.f28074e, null, null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            switch (C9109Rn.f21670a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzgvg, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgtz", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvg;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzgvg);
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
            zzdob.m29887a(zzb.class, zzgvg);
        }
    }

    private zzdhc() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29494b(int i) {
        this.zzgux = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29491a(zzb zzb2) {
        if (zzb2 != null) {
            if (!this.zzgve.mo29067t()) {
                zzdoj<zzb> zzdoj = this.zzgve;
                int size = zzdoj.size();
                this.zzgve = zzdoj.mo28270b(size == 0 ? 10 : size << 1);
            }
            this.zzgve.add(zzb2);
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: l */
    public static zza m29495l() {
        return (zza) zzgvf.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C9109Rn.f21670a[i - 1]) {
            case 1:
                return new zzdhc();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzgvf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzgve", zzb.class});
            case 4:
                return zzgvf;
            case 5:
                zzdpv<zzdhc> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhc.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzgvf);
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
        zzdob.m29887a(zzdhc.class, zzgvf);
    }
}
