package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.kr */
final class C9546kr implements Executor {

    /* renamed from: a */
    private final /* synthetic */ Handler f22694a;

    C9546kr(zzi zzi, Handler handler) {
        this.f22694a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f22694a.post(runnable);
    }
}
