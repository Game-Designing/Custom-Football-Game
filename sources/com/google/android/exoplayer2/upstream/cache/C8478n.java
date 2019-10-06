package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;

/* renamed from: com.google.android.exoplayer2.upstream.cache.n */
/* compiled from: SimpleCache */
class C8478n extends Thread {

    /* renamed from: a */
    final /* synthetic */ ConditionVariable f18697a;

    /* renamed from: b */
    final /* synthetic */ C8479o f18698b;

    C8478n(C8479o this$0, String x0, ConditionVariable conditionVariable) {
        this.f18698b = this$0;
        this.f18697a = conditionVariable;
        super(x0);
    }

    public void run() {
        synchronized (this.f18698b) {
            this.f18697a.open();
            this.f18698b.m20289b();
            this.f18698b.f18702d.mo25958a();
        }
    }
}
