package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: com.flurry.sdk.Wb */
public final class C7472Wb<V> extends FutureTask<V> {

    /* renamed from: a */
    private final WeakReference<Callable<V>> f14717a = new WeakReference<>(null);

    /* renamed from: b */
    private final WeakReference<Runnable> f14718b;

    public C7472Wb(Runnable runnable, V v) {
        super(runnable, v);
        this.f14718b = new WeakReference<>(runnable);
    }

    /* renamed from: a */
    public final Runnable mo23915a() {
        return (Runnable) this.f14718b.get();
    }
}
