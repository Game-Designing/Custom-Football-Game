package p362h;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: h.m */
/* compiled from: ForwardingTimeout */
public class C14198m extends C14182D {

    /* renamed from: a */
    private C14182D f43086a;

    public C14198m(C14182D delegate) {
        if (delegate != null) {
            this.f43086a = delegate;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final C14182D mo44294a() {
        return this.f43086a;
    }

    /* renamed from: a */
    public final C14198m mo44295a(C14182D delegate) {
        if (delegate != null) {
            this.f43086a = delegate;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public C14182D timeout(long timeout, TimeUnit unit) {
        return this.f43086a.timeout(timeout, unit);
    }

    public long timeoutNanos() {
        return this.f43086a.timeoutNanos();
    }

    public boolean hasDeadline() {
        return this.f43086a.hasDeadline();
    }

    public long deadlineNanoTime() {
        return this.f43086a.deadlineNanoTime();
    }

    public C14182D deadlineNanoTime(long deadlineNanoTime) {
        return this.f43086a.deadlineNanoTime(deadlineNanoTime);
    }

    public C14182D clearTimeout() {
        return this.f43086a.clearTimeout();
    }

    public C14182D clearDeadline() {
        return this.f43086a.clearDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f43086a.throwIfReached();
    }
}
