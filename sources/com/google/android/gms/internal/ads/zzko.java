package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Process;

public final class zzko extends HandlerThread {

    /* renamed from: a */
    private final int f28746a = -16;

    public zzko(String str, int i) {
        super(str);
    }

    public final void run() {
        Process.setThreadPriority(this.f28746a);
        super.run();
    }
}
