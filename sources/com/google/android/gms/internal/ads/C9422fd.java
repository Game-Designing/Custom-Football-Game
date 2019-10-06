package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.ads.fd */
final class C9422fd extends zzbak {

    /* renamed from: a */
    private final Executor f22284a;

    private C9422fd(Executor executor) {
        this.f22284a = executor;
    }

    public final void execute(Runnable runnable) {
        this.f22284a.execute(runnable);
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final boolean isTerminated() {
        return false;
    }

    public final boolean isShutdown() {
        return false;
    }

    public final List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ C9422fd(Executor executor, C9378dd ddVar) {
        this(executor);
    }
}
