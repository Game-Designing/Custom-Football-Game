package p026rx.p390c.p393c;

import java.util.concurrent.ThreadFactory;

/* renamed from: rx.c.c.a */
/* compiled from: CachedThreadScheduler */
class C14778a implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ ThreadFactory f43967a;

    /* renamed from: b */
    final /* synthetic */ C14781a f43968b;

    C14778a(C14781a aVar, ThreadFactory threadFactory) {
        this.f43968b = aVar;
        this.f43967a = threadFactory;
    }

    public Thread newThread(Runnable r) {
        Thread thread = this.f43967a.newThread(r);
        StringBuilder sb = new StringBuilder();
        sb.append(thread.getName());
        sb.append(" (Evictor)");
        thread.setName(sb.toString());
        return thread;
    }
}
