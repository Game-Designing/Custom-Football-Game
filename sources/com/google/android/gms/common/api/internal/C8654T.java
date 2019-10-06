package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.T */
final class C8654T implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C8653S f19730a;

    C8654T(C8653S s) {
        this.f19730a = s;
    }

    public final void run() {
        this.f19730a.f19727m.lock();
        try {
            this.f19730a.m21371f();
        } finally {
            this.f19730a.f19727m.unlock();
        }
    }
}
