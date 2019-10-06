package com.crashlytics.android.p124a;

import java.util.Random;
import p024io.fabric.sdk.android.services.concurrency.p354a.C13932a;

/* renamed from: com.crashlytics.android.a.D */
/* compiled from: RandomBackoff */
class C6362D implements C13932a {

    /* renamed from: a */
    final C13932a f11344a;

    /* renamed from: b */
    final Random f11345b;

    /* renamed from: c */
    final double f11346c;

    public C6362D(C13932a backoff, double jitterPercent) {
        this(backoff, jitterPercent, new Random());
    }

    public C6362D(C13932a backoff, double jitterPercent, Random random) {
        if (jitterPercent < 0.0d || jitterPercent > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (backoff == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random != null) {
            this.f11344a = backoff;
            this.f11346c = jitterPercent;
            this.f11345b = random;
        } else {
            throw new NullPointerException("random must not be null");
        }
    }

    /* renamed from: a */
    public long mo19343a(int retries) {
        double a = mo19342a();
        double a2 = (double) this.f11344a.mo19343a(retries);
        Double.isNaN(a2);
        return (long) (a * a2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public double mo19342a() {
        double d = this.f11346c;
        double minJitter = 1.0d - d;
        return (((d + 1.0d) - minJitter) * this.f11345b.nextDouble()) + minJitter;
    }
}
