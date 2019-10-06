package com.google.android.exoplayer2.util;

/* renamed from: com.google.android.exoplayer2.util.i */
/* compiled from: ConditionVariable */
public final class C8519i {

    /* renamed from: a */
    private boolean f18816a;

    /* renamed from: c */
    public synchronized boolean mo26079c() {
        if (this.f18816a) {
            return false;
        }
        this.f18816a = true;
        notifyAll();
        return true;
    }

    /* renamed from: b */
    public synchronized boolean mo26078b() {
        boolean wasOpen;
        wasOpen = this.f18816a;
        this.f18816a = false;
        return wasOpen;
    }

    /* renamed from: a */
    public synchronized void mo26077a() throws InterruptedException {
        while (!this.f18816a) {
            wait();
        }
    }
}
