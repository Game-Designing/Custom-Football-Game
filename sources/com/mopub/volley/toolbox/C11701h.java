package com.mopub.volley.toolbox;

import android.os.Looper;

/* renamed from: com.mopub.volley.toolbox.h */
/* compiled from: Threads */
final class C11701h {
    /* renamed from: a */
    static void m38679a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }
}
