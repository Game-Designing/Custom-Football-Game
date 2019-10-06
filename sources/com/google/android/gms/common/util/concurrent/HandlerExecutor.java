package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zze;
import java.util.concurrent.Executor;

@KeepForSdk
public class HandlerExecutor implements Executor {

    /* renamed from: a */
    private final Handler f20315a;

    @KeepForSdk
    public HandlerExecutor(Looper looper) {
        this.f20315a = new zze(looper);
    }

    public void execute(Runnable runnable) {
        this.f20315a.post(runnable);
    }
}
