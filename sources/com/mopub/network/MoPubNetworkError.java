package com.mopub.network;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class MoPubNetworkError extends VolleyError {

    /* renamed from: b */
    private final Reason f36353b;

    /* renamed from: c */
    private final Integer f36354c;

    public enum Reason {
        WARMING_UP,
        NO_FILL,
        BAD_HEADER_DATA,
        BAD_BODY,
        TRACKING_FAILURE,
        UNSPECIFIED
    }

    public MoPubNetworkError(Reason reason) {
        this.f36353b = reason;
        this.f36354c = null;
    }

    public MoPubNetworkError(NetworkResponse networkResponse, Reason reason) {
        super(networkResponse);
        this.f36353b = reason;
        this.f36354c = null;
    }

    public MoPubNetworkError(Throwable cause, Reason reason) {
        super(cause);
        this.f36353b = reason;
        this.f36354c = null;
    }

    public MoPubNetworkError(String message, Reason reason) {
        this(message, reason, (Integer) null);
    }

    public MoPubNetworkError(String message, Throwable cause, Reason reason) {
        super(message, cause);
        this.f36353b = reason;
        this.f36354c = null;
    }

    public MoPubNetworkError(String message, Reason reason, Integer refreshTimeMillis) {
        super(message);
        this.f36353b = reason;
        this.f36354c = refreshTimeMillis;
    }

    public Reason getReason() {
        return this.f36353b;
    }

    public Integer getRefreshTimeMillis() {
        return this.f36354c;
    }
}
