package p019d.p143b.p144a.p147c;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: d.b.a.c.Vb */
class C7119Vb implements UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ C7116Ub f13395a;

    C7119Vb(C7116Ub ub) {
        this.f13395a = ub;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f13395a.f13390b.f13369c.mo22917b("TaskManager", "Caught unhandled exception", th);
    }
}
