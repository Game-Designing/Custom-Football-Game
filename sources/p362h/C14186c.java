package p362h;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: h.c */
/* compiled from: AsyncTimeout */
public class C14186c extends C14182D {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static C14186c head;
    private boolean inQueue;
    private C14186c next;
    private long timeoutAt;

    /* renamed from: h.c$a */
    /* compiled from: AsyncTimeout */
    private static final class C14187a extends Thread {
        C14187a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<h.c> r0 = p362h.C14186c.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x001c }
                h.c r1 = p362h.C14186c.awaitTimeout()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                h.c r2 = p362h.C14186c.head     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r2 = 0
                p362h.C14186c.head = r2     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x001c }
                goto L_0x001d
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x001c }
            L_0x001c:
                r0 = move-exception
            L_0x001d:
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: p362h.C14186c.C14187a.run():void");
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void scheduleTimeout(C14186c node, long timeoutNanos, boolean hasDeadline) {
        synchronized (C14186c.class) {
            if (head == null) {
                head = new C14186c();
                new C14187a().start();
            }
            long now = System.nanoTime();
            if (timeoutNanos != 0 && hasDeadline) {
                node.timeoutAt = Math.min(timeoutNanos, node.deadlineNanoTime() - now) + now;
            } else if (timeoutNanos != 0) {
                node.timeoutAt = now + timeoutNanos;
            } else if (hasDeadline) {
                node.timeoutAt = node.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = node.remainingNanos(now);
            C14186c prev = head;
            while (true) {
                if (prev.next == null) {
                    break;
                } else if (remainingNanos < prev.next.remainingNanos(now)) {
                    break;
                } else {
                    prev = prev.next;
                }
            }
            node.next = prev.next;
            prev.next = node;
            if (prev == head) {
                C14186c.class.notify();
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(C14186c node) {
        synchronized (C14186c.class) {
            for (C14186c prev = head; prev != null; prev = prev.next) {
                if (prev.next == node) {
                    prev.next = node.next;
                    node.next = null;
                    return false;
                }
            }
            return true;
        }
    }

    private long remainingNanos(long now) {
        return this.timeoutAt - now;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    public final C14179A sink(C14179A sink) {
        return new C14184a(this, sink);
    }

    public final C14180B source(C14180B source) {
        return new C14185b(this, source);
    }

    /* access modifiers changed from: 0000 */
    public final void exit(boolean throwOnTimeout) throws IOException {
        if (exit() && throwOnTimeout) {
            throw newTimeoutException(null);
        }
    }

    /* access modifiers changed from: 0000 */
    public final IOException exit(IOException cause) throws IOException {
        if (!exit()) {
            return cause;
        }
        return newTimeoutException(cause);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException cause) {
        InterruptedIOException e = new InterruptedIOException("timeout");
        if (cause != null) {
            e.initCause(cause);
        }
        return e;
    }

    static C14186c awaitTimeout() throws InterruptedException {
        C14186c node = head.next;
        C14186c cVar = null;
        if (node == null) {
            long startNanos = System.nanoTime();
            C14186c.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next == null && System.nanoTime() - startNanos >= IDLE_TIMEOUT_NANOS) {
                cVar = head;
            }
            return cVar;
        }
        long waitNanos = node.remainingNanos(System.nanoTime());
        if (waitNanos > 0) {
            long waitMillis = waitNanos / 1000000;
            C14186c.class.wait(waitMillis, (int) (waitNanos - (1000000 * waitMillis)));
            return null;
        }
        head.next = node.next;
        node.next = null;
        return node;
    }
}
