package p002b.p041a.p042a.p043a;

import java.util.concurrent.Executor;

/* renamed from: b.a.a.a.c */
/* compiled from: ArchTaskExecutor */
public class C1143c extends C1145e {

    /* renamed from: a */
    private static volatile C1143c f3792a;

    /* renamed from: b */
    private static final Executor f3793b = new C1141a();

    /* renamed from: c */
    private static final Executor f3794c = new C1142b();

    /* renamed from: d */
    private C1145e f3795d = this.f3796e;

    /* renamed from: e */
    private C1145e f3796e = new C1144d();

    private C1143c() {
    }

    /* renamed from: b */
    public static C1143c m5601b() {
        if (f3792a != null) {
            return f3792a;
        }
        synchronized (C1143c.class) {
            if (f3792a == null) {
                f3792a = new C1143c();
            }
        }
        return f3792a;
    }

    /* renamed from: a */
    public void mo8747a(Runnable runnable) {
        this.f3795d.mo8747a(runnable);
    }

    /* renamed from: b */
    public void mo8749b(Runnable runnable) {
        this.f3795d.mo8749b(runnable);
    }

    /* renamed from: a */
    public boolean mo8748a() {
        return this.f3795d.mo8748a();
    }
}
