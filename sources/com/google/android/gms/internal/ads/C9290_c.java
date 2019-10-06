package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzard
/* renamed from: com.google.android.gms.internal.ads._c */
final class C9290_c<T> implements zzbbh<T> {

    /* renamed from: a */
    private final T f22040a;

    /* renamed from: b */
    private final C9312ad f22041b = new C9312ad();

    C9290_c(T t) {
        this.f22040a = t;
        this.f22041b.mo28847a();
    }

    public final T get() {
        return this.f22040a;
    }

    public final T get(long j, TimeUnit timeUnit) {
        return this.f22040a;
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
        this.f22041b.mo28848a(runnable, executor);
    }
}
