package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;

public abstract class RepeatingHandlerRunnable implements Runnable {

    /* renamed from: a */
    protected final Handler f34910a;

    /* renamed from: b */
    private volatile boolean f34911b;

    /* renamed from: c */
    protected volatile long f34912c;

    public abstract void doWork();

    public RepeatingHandlerRunnable(Handler handler) {
        Preconditions.checkNotNull(handler);
        this.f34910a = handler;
    }

    public void run() {
        if (this.f34911b) {
            doWork();
            this.f34910a.postDelayed(this, this.f34912c);
        }
    }

    public void startRepeating(long intervalMillis) {
        Preconditions.checkArgument(intervalMillis > 0, "intervalMillis must be greater than 0. Saw: %d", Long.valueOf(intervalMillis));
        this.f34912c = intervalMillis;
        if (!this.f34911b) {
            this.f34911b = true;
            this.f34910a.post(this);
        }
    }

    public void stop() {
        this.f34911b = false;
    }

    @Deprecated
    @VisibleForTesting
    public boolean isRunning() {
        return this.f34911b;
    }
}
