package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzard
/* renamed from: com.google.android.gms.internal.ads.Zc */
final class C9270Zc<T> implements zzbbh<T> {

    /* renamed from: a */
    private final Throwable f22016a;

    /* renamed from: b */
    private final C9312ad f22017b = new C9312ad();

    C9270Zc(Throwable th) {
        this.f22016a = th;
        this.f22017b.mo28847a();
    }

    public final T get() throws ExecutionException {
        throw new ExecutionException(this.f22016a);
    }

    public final T get(long j, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.f22016a);
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    /* renamed from: a */
    public final void mo28811a(Runnable runnable, Executor executor) {
        this.f22017b.mo28848a(runnable, executor);
    }
}
