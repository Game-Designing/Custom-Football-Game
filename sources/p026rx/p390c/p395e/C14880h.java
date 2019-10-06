package p026rx.p390c.p395e;

import java.io.PrintStream;
import java.util.Queue;
import p026rx.C0137ja;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p390c.p391a.C14689m;
import p026rx.p390c.p395e.p396a.C14828e;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14851l;
import p026rx.p390c.p395e.p397b.C14859t;

/* renamed from: rx.c.e.h */
/* compiled from: RxRingBuffer */
public class C14880h implements C0137ja {

    /* renamed from: a */
    public static final int f44165a;

    /* renamed from: b */
    private Queue<Object> f44166b;

    /* renamed from: c */
    private final int f44167c;

    /* renamed from: d */
    public volatile Object f44168d;

    static {
        int defaultSize = 128;
        if (C14879g.m46596b()) {
            defaultSize = 16;
        }
        String sizeFromProperty = System.getProperty("rx.ring-buffer.size");
        if (sizeFromProperty != null) {
            try {
                defaultSize = Integer.parseInt(sizeFromProperty);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to set 'rx.buffer.size' with value ");
                sb.append(sizeFromProperty);
                sb.append(" => ");
                sb.append(e.getMessage());
                printStream.println(sb.toString());
            }
        }
        f44165a = defaultSize;
    }

    /* renamed from: b */
    public static C14880h m46599b() {
        if (C14839G.m46555a()) {
            return new C14880h(false, f44165a);
        }
        return new C14880h();
    }

    /* renamed from: a */
    public static C14880h m46598a() {
        if (C14839G.m46555a()) {
            return new C14880h(true, f44165a);
        }
        return new C14880h();
    }

    private C14880h(Queue<Object> queue, int size) {
        this.f44166b = queue;
        this.f44167c = size;
    }

    private C14880h(boolean spmc, int size) {
        this.f44166b = spmc ? new C14851l<>(size) : new C14859t<>(size);
        this.f44167c = size;
    }

    /* renamed from: g */
    public synchronized void mo46089g() {
    }

    public void unsubscribe() {
        mo46089g();
    }

    C14880h() {
        this((Queue<Object>) new C14828e<Object>(f44165a), f44165a);
    }

    /* renamed from: c */
    public void mo46084c(Object o) throws MissingBackpressureException {
        boolean iae = false;
        boolean mbe = false;
        synchronized (this) {
            Queue<Object> q = this.f44166b;
            if (q != null) {
                mbe = !q.offer(C14689m.m46326d(o));
            } else {
                iae = true;
            }
        }
        if (iae) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (mbe) {
            throw new MissingBackpressureException();
        }
    }

    /* renamed from: d */
    public void mo46086d() {
        if (this.f44168d == null) {
            this.f44168d = C14689m.m46320a();
        }
    }

    /* renamed from: c */
    public boolean mo46085c() {
        Queue<Object> q = this.f44166b;
        return q == null || q.isEmpty();
    }

    /* renamed from: f */
    public Object mo46088f() {
        Object o;
        synchronized (this) {
            try {
                Queue<Object> q = this.f44166b;
                if (q == null) {
                    return null;
                }
                Object o2 = q.poll();
                try {
                    Object ts = this.f44168d;
                    if (o2 == null && ts != null && q.peek() == null) {
                        Object o3 = ts;
                        this.f44168d = null;
                        o = o3;
                    } else {
                        o = o2;
                    }
                    return o;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        return r0;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo46087e() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.util.Queue<java.lang.Object> r1 = r4.f44166b     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0008
            monitor-exit(r4)     // Catch:{ all -> 0x001b }
            return r0
        L_0x0008:
            java.lang.Object r0 = r1.peek()     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r4.f44168d     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0019
            if (r2 == 0) goto L_0x0019
            java.lang.Object r3 = r1.peek()     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0019
            r0 = r2
        L_0x0019:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            return r0
        L_0x001b:
            r1 = move-exception
        L_0x001c:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            throw r1
        L_0x001e:
            r1 = move-exception
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p395e.C14880h.mo46087e():java.lang.Object");
    }

    /* renamed from: b */
    public boolean mo46083b(Object o) {
        return C14689m.m46325c(o);
    }

    /* renamed from: a */
    public Object mo46082a(Object o) {
        return C14689m.m46324b(o);
    }

    public boolean isUnsubscribed() {
        return this.f44166b == null;
    }
}
