package com.google.android.gms.internal.ads;

public final class zzwl {

    public static final class zza extends zzdob<zza, C15015zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zza zzbxn = new zza();
        private static volatile zzdpv<zza> zzdv;

        /* renamed from: com.google.android.gms.internal.ads.zzwl$zza$zza reason: collision with other inner class name */
        public static final class C15015zza extends com.google.android.gms.internal.ads.zzdob.zza<zza, C15015zza> implements zzdpm {
            private C15015zza() {
                super(zza.zzbxn);
            }

            /* synthetic */ C15015zza(C9011Mt mt) {
                this();
            }
        }

        public enum zzb implements zzdoe {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
            AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
            AD_FAILED_TO_LOAD_TIMEOUT(102),
            AD_FAILED_TO_LOAD_CANCELLED(103),
            AD_FAILED_TO_LOAD_NO_ERROR(104),
            AD_FAILED_TO_LOAD_NOT_FOUND(105),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(1006),
            REQUEST_FAILED_TO_RENDER(1007),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001),
            ANDROID_WEBVIEW_CRASH(10002),
            OFFLINE_UPLOAD(10003);
            

            /* renamed from: M */
            private static final zzdof<zzb> f29578M = null;

            /* renamed from: O */
            private final int f29606O;

            /* renamed from: d */
            public final int mo30728d() {
                return this.f29606O;
            }

            private zzb(int i) {
                this.f29606O = i;
            }

            static {
                f29578M = new C9032Nt();
            }
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Object mo30637a(int i, Object obj, Object obj2) {
            switch (C9011Mt.f21497a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C15015zza(null);
                case 3:
                    return zzdob.m29885a((zzdpk) zzbxn, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbxn;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new com.google.android.gms.internal.ads.zzdob.zzb<>(zzbxn);
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
            zzdob.m29887a(zza.class, zzbxn);
        }
    }
}
