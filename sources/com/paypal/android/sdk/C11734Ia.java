package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: com.paypal.android.sdk.Ia */
final class C11734Ia implements Executor {
    private C11734Ia() {
    }

    /* synthetic */ C11734Ia(byte b) {
        this();
    }

    public final void execute(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
