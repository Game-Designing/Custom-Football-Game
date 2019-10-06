package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

@zzard
public final class zzazg {

    /* renamed from: a */
    private HandlerThread f25013a = null;

    /* renamed from: b */
    private Handler f25014b = null;

    /* renamed from: c */
    private int f25015c = 0;

    /* renamed from: d */
    private final Object f25016d = new Object();

    /* renamed from: b */
    public final Looper mo30298b() {
        Looper looper;
        synchronized (this.f25016d) {
            if (this.f25015c != 0) {
                Preconditions.m21858a(this.f25013a, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f25013a == null) {
                zzawz.m26003f("Starting the looper thread.");
                this.f25013a = new HandlerThread("LooperProvider");
                this.f25013a.start();
                this.f25014b = new zzdbh(this.f25013a.getLooper());
                zzawz.m26003f("Looper thread started.");
            } else {
                zzawz.m26003f("Resuming the looper thread");
                this.f25016d.notifyAll();
            }
            this.f25015c++;
            looper = this.f25013a.getLooper();
        }
        return looper;
    }

    /* renamed from: a */
    public final Handler mo30297a() {
        return this.f25014b;
    }
}
