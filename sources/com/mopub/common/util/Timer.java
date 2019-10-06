package com.mopub.common.util;

import java.util.concurrent.TimeUnit;

public class Timer {

    /* renamed from: a */
    private long f34608a;

    /* renamed from: b */
    private long f34609b;

    /* renamed from: c */
    private C11288a f34610c = C11288a.STOPPED;

    /* renamed from: com.mopub.common.util.Timer$a */
    private enum C11288a {
        STARTED,
        STOPPED
    }

    public void start() {
        this.f34609b = System.nanoTime();
        this.f34610c = C11288a.STARTED;
    }

    public void stop() {
        if (this.f34610c == C11288a.STARTED) {
            this.f34610c = C11288a.STOPPED;
            this.f34608a = System.nanoTime();
            return;
        }
        throw new IllegalStateException("EventTimer was not started.");
    }

    public long getTime() {
        long endTime;
        if (this.f34610c == C11288a.STARTED) {
            endTime = System.nanoTime();
        } else {
            endTime = this.f34608a;
        }
        return TimeUnit.MILLISECONDS.convert(endTime - this.f34609b, TimeUnit.NANOSECONDS);
    }
}
