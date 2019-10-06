package com.inmobi.ads;

public final class InMobiAdRequestStatus {

    /* renamed from: a */
    private StatusCode f31267a;

    /* renamed from: b */
    private String f31268b;

    /* renamed from: com.inmobi.ads.InMobiAdRequestStatus$1 */
    static /* synthetic */ class C103051 {

        /* renamed from: a */
        static final /* synthetic */ int[] f31269a = new int[StatusCode.values().length];

        static {
            try {
                f31269a[StatusCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f31269a[StatusCode.NETWORK_UNREACHABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f31269a[StatusCode.REQUEST_INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f31269a[StatusCode.REQUEST_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f31269a[StatusCode.REQUEST_TIMED_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f31269a[StatusCode.SERVER_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f31269a[StatusCode.NO_FILL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f31269a[StatusCode.AD_ACTIVE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f31269a[StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f31269a[StatusCode.AD_NO_LONGER_AVAILABLE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f31269a[StatusCode.MISSING_REQUIRED_DEPENDENCIES.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f31269a[StatusCode.REPETITIVE_LOAD.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f31269a[StatusCode.GDPR_COMPLIANCE_ENFORCED.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f31269a[StatusCode.GET_SIGNALS_NOT_CALLED_FOR_LOAD_WITH_RESPONSE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f31269a[StatusCode.GET_SIGNALS_CALLED_WHILE_LOADING.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f31269a[StatusCode.FETCHING_SIGNALS_STATE_ERROR.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f31269a[StatusCode.LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f31269a[StatusCode.LOAD_CALLED_AFTER_GET_SIGNALS.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f31269a[StatusCode.INVALID_RESPONSE_IN_LOAD.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f31269a[StatusCode.MONETIZATION_DISABLED.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
        }
    }

    public enum StatusCode {
        NO_ERROR,
        NETWORK_UNREACHABLE,
        NO_FILL,
        REQUEST_INVALID,
        REQUEST_PENDING,
        REQUEST_TIMED_OUT,
        INTERNAL_ERROR,
        SERVER_ERROR,
        AD_ACTIVE,
        EARLY_REFRESH_REQUEST,
        AD_NO_LONGER_AVAILABLE,
        MISSING_REQUIRED_DEPENDENCIES,
        REPETITIVE_LOAD,
        GDPR_COMPLIANCE_ENFORCED,
        LOAD_CALLED_AFTER_GET_SIGNALS,
        GET_SIGNALS_NOT_CALLED_FOR_LOAD_WITH_RESPONSE,
        GET_SIGNALS_CALLED_WHILE_LOADING,
        FETCHING_SIGNALS_STATE_ERROR,
        LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING,
        INVALID_RESPONSE_IN_LOAD,
        MONETIZATION_DISABLED
    }

    public InMobiAdRequestStatus(StatusCode statusCode) {
        this.f31267a = statusCode;
        switch (C103051.f31269a[this.f31267a.ordinal()]) {
            case 1:
                this.f31268b = "The InMobi SDK encountered an internal error.";
                return;
            case 2:
                this.f31268b = "The Internet is unreachable. Please check your Internet connection.";
                return;
            case 3:
                this.f31268b = "An invalid ad request was sent and was rejected by the Ad Network. Please validate the ad request and try again";
                return;
            case 4:
                this.f31268b = "The SDK is pending response to a previous ad request. Please wait for the previous ad request to complete before requesting for another ad.";
                return;
            case 5:
                this.f31268b = "The Ad Request timed out waiting for a response from the network. This can be caused due to a bad network connection. Please try again after a few minutes.";
                return;
            case 6:
                this.f31268b = "The Ad Server encountered an error when processing the ad request. This may be a transient issue. Please try again in a few minutes";
                return;
            case 7:
                this.f31268b = "Ad request successful but no ad served.";
                return;
            case 8:
                this.f31268b = "The Ad Request could not be submitted as the user is viewing another Ad.";
                return;
            case 9:
                this.f31268b = "The Ad Request cannot be done so frequently. Please wait for some time before loading another ad.";
                return;
            case 10:
                this.f31268b = "An ad is no longer available. Please call load() to fetch a fresh ad.";
                return;
            case 11:
                this.f31268b = "The SDK rejected the ad request as one or more required dependencies could not be found. Please ensure you have included the required dependencies.";
                return;
            case 12:
                this.f31268b = "The SDK rejected the ad load request. Multiple load() call on the same object is not allowed if the previous ad request was successful.";
                return;
            case 13:
                this.f31268b = "Network Request dropped as current request is not GDPR compliant.";
                return;
            case 14:
                this.f31268b = "getSignals() must be called before calling load(response).";
                return;
            case 15:
                this.f31268b = "An ad load is already in progress, getSignals() call in this state is not allowed.";
                return;
            case 16:
                this.f31268b = "One getSignals request is already been processed, please wait for the result and try again.";
                return;
            case 17:
                this.f31268b = "An ad load is already in progress, load(response) call in this state is not allowed.";
                return;
            case 18:
                this.f31268b = "The load() API cannot be called once the getSignals(Bundle) has been called. Call load(byte[]) to render ad, if getSignals(Bundle) was called.";
                return;
            case 19:
                this.f31268b = "Null or empty response as parameter is not allowed in load(response).";
                return;
            case 20:
                this.f31268b = "The Ad Request is terminated because monetization is disabled.";
                break;
        }
    }

    public final InMobiAdRequestStatus setCustomMessage(String str) {
        if (str != null) {
            this.f31268b = str;
        }
        return this;
    }

    public final StatusCode getStatusCode() {
        return this.f31267a;
    }

    public final String getMessage() {
        return this.f31268b;
    }
}
