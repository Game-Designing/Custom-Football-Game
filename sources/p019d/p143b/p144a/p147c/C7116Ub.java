package p019d.p143b.p144a.p147c;

import java.util.concurrent.ThreadFactory;

/* renamed from: d.b.a.c.Ub */
class C7116Ub implements ThreadFactory {

    /* renamed from: a */
    private final String f13389a;

    /* renamed from: b */
    final /* synthetic */ C7110Sb f13390b;

    public C7116Ub(C7110Sb sb, String str) {
        this.f13390b = sb;
        this.f13389a = str;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinSdk:");
        sb.append(this.f13389a);
        sb.append(":");
        sb.append(C7209sc.m15483b(this.f13390b.f13368b.mo23079x()));
        Thread thread = new Thread(runnable, sb.toString());
        thread.setDaemon(true);
        thread.setPriority(10);
        thread.setUncaughtExceptionHandler(new C7119Vb(this));
        return thread;
    }
}
