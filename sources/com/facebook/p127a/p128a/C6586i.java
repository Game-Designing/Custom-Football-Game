package com.facebook.p127a.p128a;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.facebook.a.a.i */
/* compiled from: ViewIndexer */
class C6586i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TimerTask f11961a;

    /* renamed from: b */
    final /* synthetic */ C6589l f11962b;

    C6586i(C6589l this$0, TimerTask timerTask) {
        this.f11962b = this$0;
        this.f11961a = timerTask;
    }

    public void run() {
        try {
            if (this.f11962b.f11969e != null) {
                this.f11962b.f11969e.cancel();
            }
            this.f11962b.f11970f = null;
            this.f11962b.f11969e = new Timer();
            this.f11962b.f11969e.scheduleAtFixedRate(this.f11961a, 0, 1000);
        } catch (Exception e) {
            Log.e(C6589l.f11965a, "Error scheduling indexing job", e);
        }
    }
}
