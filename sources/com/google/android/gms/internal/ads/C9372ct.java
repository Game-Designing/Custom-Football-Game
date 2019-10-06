package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

/* renamed from: com.google.android.gms.internal.ads.ct */
final class C9372ct implements Callback, FrameCallback {

    /* renamed from: a */
    private static final C9372ct f22167a = new C9372ct();

    /* renamed from: b */
    public volatile long f22168b;

    /* renamed from: c */
    private final Handler f22169c;

    /* renamed from: d */
    private final HandlerThread f22170d = new HandlerThread("ChoreographerOwner:Handler");

    /* renamed from: e */
    private Choreographer f22171e;

    /* renamed from: f */
    private int f22172f;

    /* renamed from: a */
    public static C9372ct m23514a() {
        return f22167a;
    }

    private C9372ct() {
        this.f22170d.start();
        this.f22169c = new Handler(this.f22170d.getLooper(), this);
        this.f22169c.sendEmptyMessage(0);
    }

    /* renamed from: b */
    public final void mo28903b() {
        this.f22169c.sendEmptyMessage(1);
    }

    /* renamed from: c */
    public final void mo28904c() {
        this.f22169c.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.f22168b = j;
        this.f22171e.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.f22171e = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            this.f22172f++;
            if (this.f22172f == 1) {
                this.f22171e.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.f22172f--;
            if (this.f22172f == 0) {
                this.f22171e.removeFrameCallback(this);
                this.f22168b = 0;
            }
            return true;
        }
    }
}
