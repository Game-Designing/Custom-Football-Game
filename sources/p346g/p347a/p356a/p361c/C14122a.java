package p346g.p347a.p356a.p361c;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: g.a.a.c.a */
/* compiled from: NamedThreadFactory */
public class C14122a implements ThreadFactory {

    /* renamed from: a */
    private final ThreadFactory f42925a = Executors.defaultThreadFactory();

    /* renamed from: b */
    private final String f42926b;

    public C14122a(String namePrefix) {
        this.f42926b = namePrefix;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = this.f42925a.newThread(runnable);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42926b);
        sb.append(' ');
        sb.append(thread.getName());
        thread.setName(sb.toString());
        return thread;
    }
}
