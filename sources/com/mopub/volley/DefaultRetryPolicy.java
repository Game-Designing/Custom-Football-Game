package com.mopub.volley;

public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;

    /* renamed from: a */
    private int f36417a;

    /* renamed from: b */
    private int f36418b;

    /* renamed from: c */
    private final int f36419c;

    /* renamed from: d */
    private final float f36420d;

    public DefaultRetryPolicy() {
        this(DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public DefaultRetryPolicy(int initialTimeoutMs, int maxNumRetries, float backoffMultiplier) {
        this.f36417a = initialTimeoutMs;
        this.f36419c = maxNumRetries;
        this.f36420d = backoffMultiplier;
    }

    public int getCurrentTimeout() {
        return this.f36417a;
    }

    public int getCurrentRetryCount() {
        return this.f36418b;
    }

    public float getBackoffMultiplier() {
        return this.f36420d;
    }

    public void retry(VolleyError error) throws VolleyError {
        this.f36418b++;
        int i = this.f36417a;
        this.f36417a = i + ((int) (((float) i) * this.f36420d));
        if (!mo38357a()) {
            throw error;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo38357a() {
        return this.f36418b <= this.f36419c;
    }
}
