package com.bumptech.glide.load.engine.p122c;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;

/* renamed from: com.bumptech.glide.load.engine.c.a */
/* compiled from: GlideExecutor */
class C6294a extends Thread {

    /* renamed from: a */
    final /* synthetic */ C6296a f11141a;

    C6294a(C6296a this$0, Runnable arg0, String arg1) {
        this.f11141a = this$0;
        super(arg0, arg1);
    }

    public void run() {
        Process.setThreadPriority(9);
        if (this.f11141a.f11147c) {
            StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable t) {
            this.f11141a.f11146b.mo19224a(t);
        }
    }
}
