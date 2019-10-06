package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.dd */
final class C9378dd implements Executor {

    /* renamed from: a */
    private final Handler f22175a = new zzaxa(Looper.getMainLooper());

    C9378dd() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzk.zzlg();
                zzaxi.m26112a(zzk.zzlk().mo30165a(), th);
                throw th;
            }
        } else {
            this.f22175a.post(runnable);
        }
    }
}
