package com.mopub.network;

import com.mopub.volley.VolleyError;

public abstract class BackoffPolicy {

    /* renamed from: a */
    protected int f36346a;

    /* renamed from: b */
    protected int f36347b;

    /* renamed from: c */
    protected int f36348c;

    public abstract void backoff(VolleyError volleyError) throws VolleyError;

    public int getBackoffMs() {
        return this.f36346a;
    }

    public int getRetryCount() {
        return this.f36347b;
    }

    public boolean hasAttemptRemaining() {
        return this.f36347b < this.f36348c;
    }
}
