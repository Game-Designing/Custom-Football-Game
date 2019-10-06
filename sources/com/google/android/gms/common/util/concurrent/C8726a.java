package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* renamed from: com.google.android.gms.common.util.concurrent.a */
final class C8726a implements Runnable {

    /* renamed from: a */
    private final Runnable f20322a;

    /* renamed from: b */
    private final int f20323b;

    public C8726a(Runnable runnable, int i) {
        this.f20322a = runnable;
        this.f20323b = i;
    }

    public final void run() {
        Process.setThreadPriority(this.f20323b);
        this.f20322a.run();
    }
}
