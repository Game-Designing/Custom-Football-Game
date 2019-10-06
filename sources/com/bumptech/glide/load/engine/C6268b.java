package com.bumptech.glide.load.engine;

import android.os.Process;

/* renamed from: com.bumptech.glide.load.engine.b */
/* compiled from: ActiveResources */
class C6268b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6291c f11095a;

    C6268b(C6291c this$0) {
        this.f11095a = this$0;
    }

    public void run() {
        Process.setThreadPriority(10);
        this.f11095a.mo19200a();
    }
}
