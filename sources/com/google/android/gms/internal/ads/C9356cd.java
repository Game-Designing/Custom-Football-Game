package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

@zzard
/* renamed from: com.google.android.gms.internal.ads.cd */
final class C9356cd<V> extends FutureTask<V> implements zzbbh<V> {

    /* renamed from: a */
    private final C9312ad f22152a = new C9312ad();

    C9356cd(Callable<V> callable) {
        super(callable);
    }

    C9356cd(Runnable runnable, V v) {
        super(runnable, v);
    }

    /* renamed from: a */
    public final void mo28811a(Runnable runnable, Executor executor) {
        this.f22152a.mo28848a(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public final void done() {
        this.f22152a.mo28847a();
    }
}
