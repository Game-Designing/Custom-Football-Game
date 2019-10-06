package p026rx.p387a.p388a;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: rx.a.a.a */
/* compiled from: RxAndroidPlugins */
public final class C14519a {

    /* renamed from: a */
    private static final C14519a f43335a = new C14519a();

    /* renamed from: b */
    private final AtomicReference<C14520b> f43336b = new AtomicReference<>();

    /* renamed from: a */
    public static C14519a m46165a() {
        return f43335a;
    }

    C14519a() {
    }

    /* renamed from: b */
    public C14520b mo45716b() {
        if (this.f43336b.get() == null) {
            this.f43336b.compareAndSet(null, C14520b.m46167a());
        }
        return (C14520b) this.f43336b.get();
    }
}
