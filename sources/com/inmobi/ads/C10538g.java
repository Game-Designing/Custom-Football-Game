package com.inmobi.ads;

import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;

/* renamed from: com.inmobi.ads.g */
/* compiled from: AdNetworkResponse */
public final class C10538g {

    /* renamed from: a */
    C10677d f32129a;

    /* renamed from: b */
    InMobiAdRequestStatus f32130b;

    /* renamed from: c */
    C10537f f32131c;

    /* renamed from: com.inmobi.ads.g$1 */
    /* compiled from: AdNetworkResponse */
    static /* synthetic */ class C105391 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32132a = new int[ErrorCode.values().length];

        static {
            try {
                f32132a[ErrorCode.NETWORK_UNAVAILABLE_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f32132a[ErrorCode.BAD_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f32132a[ErrorCode.HTTP_GATEWAY_TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f32132a[ErrorCode.HTTP_INTERNAL_SERVER_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f32132a[ErrorCode.HTTP_NOT_IMPLEMENTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f32132a[ErrorCode.HTTP_BAD_GATEWAY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f32132a[ErrorCode.HTTP_SERVER_NOT_AVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f32132a[ErrorCode.HTTP_VERSION_NOT_SUPPORTED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f32132a[ErrorCode.GDPR_COMPLIANCE_ENFORCED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public C10538g(C10537f fVar, C10677d dVar) {
        this.f32131c = fVar;
        this.f32129a = dVar;
        NetworkError networkError = this.f32129a.f32591b;
        if (networkError != null) {
            switch (C105391.f32132a[networkError.f32552a.ordinal()]) {
                case 1:
                    this.f32130b = new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE);
                    return;
                case 2:
                    this.f32130b = new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID);
                    String str = this.f32129a.f32591b.f32553b;
                    if (str != null) {
                        this.f32130b.setCustomMessage(str);
                        return;
                    }
                    break;
                case 3:
                    this.f32130b = new InMobiAdRequestStatus(StatusCode.REQUEST_TIMED_OUT);
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    this.f32130b = new InMobiAdRequestStatus(StatusCode.SERVER_ERROR);
                    return;
                case 9:
                    this.f32130b = new InMobiAdRequestStatus(StatusCode.GDPR_COMPLIANCE_ENFORCED);
                    return;
                default:
                    this.f32130b = new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR);
                    break;
            }
        }
    }
}
