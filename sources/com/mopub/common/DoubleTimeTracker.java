package com.mopub.common;

import android.os.SystemClock;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class DoubleTimeTracker {

    /* renamed from: a */
    private volatile C11226a f34314a;

    /* renamed from: b */
    private long f34315b;

    /* renamed from: c */
    private long f34316c;

    /* renamed from: d */
    private final Clock f34317d;

    public interface Clock {
        long elapsedRealTime();
    }

    /* renamed from: com.mopub.common.DoubleTimeTracker$a */
    private enum C11226a {
        STARTED,
        PAUSED
    }

    /* renamed from: com.mopub.common.DoubleTimeTracker$b */
    private static class C11227b implements Clock {
        private C11227b() {
        }

        public long elapsedRealTime() {
            return SystemClock.elapsedRealtime();
        }
    }

    public DoubleTimeTracker() {
        this(new C11227b());
    }

    @VisibleForTesting
    public DoubleTimeTracker(Clock clock) {
        this.f34317d = clock;
        this.f34314a = C11226a.PAUSED;
    }

    public synchronized void start() {
        if (this.f34314a == C11226a.STARTED) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "DoubleTimeTracker already started.");
            return;
        }
        this.f34314a = C11226a.STARTED;
        this.f34315b = this.f34317d.elapsedRealTime();
    }

    public synchronized void pause() {
        if (this.f34314a == C11226a.PAUSED) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "DoubleTimeTracker already paused.");
            return;
        }
        this.f34316c += m37004a();
        this.f34315b = 0;
        this.f34314a = C11226a.PAUSED;
    }

    public synchronized double getInterval() {
        return (double) (this.f34316c + m37004a());
    }

    /* renamed from: a */
    private synchronized long m37004a() {
        if (this.f34314a == C11226a.PAUSED) {
            return 0;
        }
        return this.f34317d.elapsedRealTime() - this.f34315b;
    }
}
