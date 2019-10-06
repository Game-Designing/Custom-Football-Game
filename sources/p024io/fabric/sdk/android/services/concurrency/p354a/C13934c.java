package p024io.fabric.sdk.android.services.concurrency.p354a;

/* renamed from: io.fabric.sdk.android.services.concurrency.a.c */
/* compiled from: ExponentialBackoff */
public class C13934c implements C13932a {

    /* renamed from: a */
    private final long f42264a;

    /* renamed from: b */
    private final int f42265b;

    public C13934c(long baseTimeMillis, int power) {
        this.f42264a = baseTimeMillis;
        this.f42265b = power;
    }

    /* renamed from: a */
    public long mo19343a(int retries) {
        double d = (double) this.f42264a;
        double pow = Math.pow((double) this.f42265b, (double) retries);
        Double.isNaN(d);
        return (long) (d * pow);
    }
}
