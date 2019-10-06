package p026rx.p390c.p395e;

import java.util.concurrent.atomic.AtomicLong;
import p026rx.C14508U;

/* renamed from: rx.c.e.c */
/* compiled from: BackpressureDrainManager */
public final class C14866c extends AtomicLong implements C14508U {

    /* renamed from: a */
    boolean f44147a;

    /* renamed from: b */
    volatile boolean f44148b;

    /* renamed from: c */
    Throwable f44149c;

    /* renamed from: d */
    final C14867a f44150d;

    /* renamed from: rx.c.e.c$a */
    /* compiled from: BackpressureDrainManager */
    public interface C14867a {
        /* renamed from: a */
        void mo45737a(Throwable th);

        boolean accept(Object obj);

        Object peek();

        Object poll();
    }

    public C14866c(C14867a actual) {
        this.f44150d = actual;
    }

    /* renamed from: b */
    public void mo46075b() {
        this.f44148b = true;
        mo46073a();
    }

    /* renamed from: a */
    public void mo46074a(Throwable error) {
        if (!this.f44148b) {
            this.f44149c = error;
            this.f44148b = true;
            mo46073a();
        }
    }

    public void request(long n) {
        long r;
        boolean mayDrain;
        long u;
        if (n != 0) {
            do {
                r = get();
                mayDrain = r == 0;
                if (r == Long.MAX_VALUE) {
                    break;
                } else if (n == Long.MAX_VALUE) {
                    u = n;
                    mayDrain = true;
                } else if (r > Long.MAX_VALUE - n) {
                    u = Long.MAX_VALUE;
                } else {
                    u = r + n;
                }
            } while (!compareAndSet(r, u));
            if (mayDrain) {
                mo46073a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x00b1, code lost:
        r4 = r4 - 1;
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x00b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x00ba, code lost:
        if (0 == 0) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x00bc, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        r1.f44147a = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x00c4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r4 = get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r7 = r1.f44150d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
        if (r4 > 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        if (r3 == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        if (r3 == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
        if (r7.peek() != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        r7.mo45737a(r1.f44149c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        if (1 != 0) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.f44147a = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0039, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x003c, code lost:
        if (r4 != 0) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r11 = r7.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0043, code lost:
        if (r11 != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0046, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r3 = r1.f44148b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x004e, code lost:
        if (r7.peek() == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0050, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0052, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x005e, code lost:
        if (get() != Long.MAX_VALUE) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0060, code lost:
        if (r11 != false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0062, code lost:
        if (r3 != false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0064, code lost:
        r1.f44147a = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0067, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0068, code lost:
        if (1 != 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006a, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.f44147a = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x006d, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0073, code lost:
        r4 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r4 = addAndGet((long) (-r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0082, code lost:
        if (r4 == 0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0084, code lost:
        if (r11 != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0086, code lost:
        if (r3 == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0088, code lost:
        if (r11 == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x008b, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x008d, code lost:
        r1.f44147a = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0090, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0091, code lost:
        if (1 != 0) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0093, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r1.f44147a = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0096, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x009b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00a3, code lost:
        if (r7.accept(r11) == false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00a6, code lost:
        if (1 != 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00a8, code lost:
        monitor-enter(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        r1.f44147a = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x00ab, code lost:
        monitor-exit(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x00b0, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo46073a() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            r2 = 0
            boolean r0 = r1.f44147a     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x000a
            monitor-exit(r17)     // Catch:{ all -> 0x00c8 }
            return
        L_0x000a:
            r0 = 1
            r1.f44147a = r0     // Catch:{ all -> 0x00c8 }
            boolean r3 = r1.f44148b     // Catch:{ all -> 0x00c8 }
            monitor-exit(r17)     // Catch:{ all -> 0x00c5 }
            long r4 = r17.get()
            r6 = 0
            rx.c.e.c$a r7 = r1.f44150d     // Catch:{ all -> 0x00b9 }
        L_0x0017:
            r8 = 0
        L_0x0018:
            r9 = 0
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0020
            if (r3 == 0) goto L_0x0046
        L_0x0020:
            if (r3 == 0) goto L_0x003f
            java.lang.Object r11 = r7.peek()     // Catch:{ all -> 0x00b9 }
            if (r11 != 0) goto L_0x003a
            r6 = 1
            java.lang.Throwable r0 = r1.f44149c     // Catch:{ all -> 0x00b9 }
            r9 = r0
            r7.mo45737a(r9)     // Catch:{ all -> 0x00b9 }
            if (r6 != 0) goto L_0x0039
            monitor-enter(r17)
            r1.f44147a = r2     // Catch:{ all -> 0x0036 }
            monitor-exit(r17)     // Catch:{ all -> 0x0036 }
            goto L_0x0039
        L_0x0036:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0036 }
            throw r0
        L_0x0039:
            return
        L_0x003a:
            int r12 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x003f
            goto L_0x0046
        L_0x003f:
            java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x00b9 }
            if (r11 != 0) goto L_0x009f
        L_0x0046:
            monitor-enter(r17)     // Catch:{ all -> 0x00b9 }
            boolean r11 = r1.f44148b     // Catch:{ all -> 0x009c }
            r3 = r11
            java.lang.Object r11 = r7.peek()     // Catch:{ all -> 0x009c }
            if (r11 == 0) goto L_0x0052
            r11 = 1
            goto L_0x0053
        L_0x0052:
            r11 = 0
        L_0x0053:
            long r12 = r17.get()     // Catch:{ all -> 0x009c }
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x0079
            if (r11 != 0) goto L_0x0073
            if (r3 != 0) goto L_0x0073
            r6 = 1
            r1.f44147a = r2     // Catch:{ all -> 0x009c }
            monitor-exit(r17)     // Catch:{ all -> 0x009c }
            if (r6 != 0) goto L_0x0072
            monitor-enter(r17)
            r1.f44147a = r2     // Catch:{ all -> 0x006f }
            monitor-exit(r17)     // Catch:{ all -> 0x006f }
            goto L_0x0072
        L_0x006f:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x006f }
            throw r0
        L_0x0072:
            return
        L_0x0073:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x008b
        L_0x0079:
            int r12 = -r8
            long r12 = (long) r12
            long r12 = r1.addAndGet(r12)     // Catch:{ all -> 0x009c }
            r4 = r12
            int r12 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x0086
            if (r11 != 0) goto L_0x008b
        L_0x0086:
            if (r3 == 0) goto L_0x008d
            if (r11 == 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            monitor-exit(r17)     // Catch:{ all -> 0x009c }
            goto L_0x0017
        L_0x008d:
            r6 = 1
            r1.f44147a = r2     // Catch:{ all -> 0x009c }
            monitor-exit(r17)     // Catch:{ all -> 0x009c }
            if (r6 != 0) goto L_0x009b
            monitor-enter(r17)
            r1.f44147a = r2     // Catch:{ all -> 0x0098 }
            monitor-exit(r17)     // Catch:{ all -> 0x0098 }
            goto L_0x009b
        L_0x0098:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0098 }
            throw r0
        L_0x009b:
            return
        L_0x009c:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x009c }
            throw r0     // Catch:{ all -> 0x00b9 }
        L_0x009f:
            boolean r9 = r7.accept(r11)     // Catch:{ all -> 0x00b9 }
            if (r9 == 0) goto L_0x00b1
            r6 = 1
            if (r6 != 0) goto L_0x00b0
            monitor-enter(r17)
            r1.f44147a = r2     // Catch:{ all -> 0x00ad }
            monitor-exit(r17)     // Catch:{ all -> 0x00ad }
            goto L_0x00b0
        L_0x00ad:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x00ad }
            throw r0
        L_0x00b0:
            return
        L_0x00b1:
            r9 = 1
            long r4 = r4 - r9
            int r8 = r8 + 1
            goto L_0x0018
        L_0x00b9:
            r0 = move-exception
            if (r6 != 0) goto L_0x00c4
            monitor-enter(r17)
            r1.f44147a = r2     // Catch:{ all -> 0x00c1 }
            monitor-exit(r17)     // Catch:{ all -> 0x00c1 }
            goto L_0x00c4
        L_0x00c1:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x00c1 }
            throw r0
        L_0x00c4:
            throw r0
        L_0x00c5:
            r0 = move-exception
            r2 = r3
            goto L_0x00c9
        L_0x00c8:
            r0 = move-exception
        L_0x00c9:
            monitor-exit(r17)     // Catch:{ all -> 0x00cb }
            throw r0
        L_0x00cb:
            r0 = move-exception
            goto L_0x00c9
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p395e.C14866c.mo46073a():void");
    }
}
