package p024io.fabric.sdk.android.services.concurrency.p354a;

/* renamed from: io.fabric.sdk.android.services.concurrency.a.e */
/* compiled from: RetryState */
public class C13936e {

    /* renamed from: a */
    private final int f42266a;

    /* renamed from: b */
    private final C13932a f42267b;

    /* renamed from: c */
    private final C13935d f42268c;

    public C13936e(C13932a backoff, C13935d retryPolicy) {
        this(0, backoff, retryPolicy);
    }

    public C13936e(int retryCount, C13932a backoff, C13935d retryPolicy) {
        this.f42266a = retryCount;
        this.f42267b = backoff;
        this.f42268c = retryPolicy;
    }

    /* renamed from: a */
    public long mo43367a() {
        return this.f42267b.mo19343a(this.f42266a);
    }

    /* renamed from: c */
    public C13936e mo43369c() {
        return new C13936e(this.f42266a + 1, this.f42267b, this.f42268c);
    }

    /* renamed from: b */
    public C13936e mo43368b() {
        return new C13936e(this.f42267b, this.f42268c);
    }
}
