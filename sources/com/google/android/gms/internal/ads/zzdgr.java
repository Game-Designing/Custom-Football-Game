package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;

public final class zzdgr extends zzdob<zzdgr, zza> implements zzdpm {
    private static volatile zzdpv<zzdgr> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgr zzguc = new zzdgr();
    private String zzgtz = "";
    private zzdmr zzgua = zzdmr.f27972a;
    private int zzgub;

    public static final class zza extends com.google.android.gms.internal.ads.zzdob.zza<zzdgr, zza> implements zzdpm {
        private zza() {
            super(zzdgr.zzguc);
        }

        /* renamed from: a */
        public final zza mo31469a(String str) {
            mo31614j();
            ((zzdgr) this.f28067b).m29428a(str);
            return this;
        }

        /* renamed from: a */
        public final zza mo31468a(zzdmr zzdmr) {
            mo31614j();
            ((zzdgr) this.f28067b).m29427a(zzdmr);
            return this;
        }

        /* renamed from: a */
        public final zza mo31467a(zzb zzb) {
            mo31614j();
            ((zzdgr) this.f28067b).m29423a(zzb);
            return this;
        }

        /* synthetic */ zza(C8984Ln ln) {
            this();
        }
    }

    public enum zzb implements zzdoe {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        

        /* renamed from: g */
        private static final zzdof<zzb> f27866g = null;

        /* renamed from: i */
        private final int f27868i;

        /* renamed from: d */
        public final int mo30728d() {
            if (this != UNRECOGNIZED) {
                return this.f27868i;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        /* renamed from: a */
        public static zzb m29439a(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        private zzb(int i) {
            this.f27868i = i;
        }

        static {
            f27866g = new C9005Mn();
        }
    }

    private zzdgr() {
    }

    /* renamed from: l */
    public final String mo31464l() {
        return this.zzgtz;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29428a(String str) {
        if (str != null) {
            this.zzgtz = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: m */
    public final zzdmr mo31465m() {
        return this.zzgua;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29427a(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgua = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: n */
    public final zzb mo31466n() {
        zzb a = zzb.m29439a(this.zzgub);
        return a == null ? zzb.UNRECOGNIZED : a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29423a(zzb zzb2) {
        if (zzb2 != null) {
            this.zzgub = zzb2.mo30728d();
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: o */
    public static zza m29429o() {
        return (zza) zzguc.mo30637a(zze.f28074e, null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo30637a(int i, Object obj, Object obj2) {
        switch (C8984Ln.f21438a[i - 1]) {
            case 1:
                return new zzdgr();
            case 2:
                return new zza(null);
            case 3:
                return zzdob.m29885a((zzdpk) zzguc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgtz", "zzgua", "zzgub"});
            case 4:
                return zzguc;
            case 5:
                zzdpv<zzdgr> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgr.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzguc);
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

    /* renamed from: p */
    public static zzdgr m29430p() {
        return zzguc;
    }

    static {
        zzdob.m29887a(zzdgr.class, zzguc);
    }
}
