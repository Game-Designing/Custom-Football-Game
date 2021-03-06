package p362h;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: h.D */
/* compiled from: Timeout */
public class C14182D {
    public static final C14182D NONE = new C14181C();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public C14182D timeout(long timeout, TimeUnit unit) {
        if (timeout < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(timeout);
            throw new IllegalArgumentException(sb.toString());
        } else if (unit != null) {
            this.timeoutNanos = unit.toNanos(timeout);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public C14182D deadlineNanoTime(long deadlineNanoTime2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = deadlineNanoTime2;
        return this;
    }

    public final C14182D deadline(long duration, TimeUnit unit) {
        if (duration <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("duration <= 0: ");
            sb.append(duration);
            throw new IllegalArgumentException(sb.toString());
        } else if (unit != null) {
            return deadlineNanoTime(System.nanoTime() + unit.toNanos(duration));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public C14182D clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public C14182D clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public final void waitUntilNotified(Object monitor) throws InterruptedIOException {
        long deadlineNanos;
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long start = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    deadlineNanos = Math.min(timeoutNanos2, deadlineNanoTime() - start);
                } else if (hasDeadline2) {
                    deadlineNanos = deadlineNanoTime() - start;
                } else {
                    deadlineNanos = timeoutNanos2;
                }
                long elapsedNanos = 0;
                if (deadlineNanos > 0) {
                    long waitMillis = deadlineNanos / 1000000;
                    Long.signum(waitMillis);
                    monitor.wait(waitMillis, (int) (deadlineNanos - (1000000 * waitMillis)));
                    elapsedNanos = System.nanoTime() - start;
                }
                if (elapsedNanos >= deadlineNanos) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            monitor.wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException("interrupted");
        }
    }
}
