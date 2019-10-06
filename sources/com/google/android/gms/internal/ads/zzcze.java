package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzcze<E, V> implements zzbbh<V> {

    /* renamed from: a */
    private final E f27669a;

    /* renamed from: b */
    private final String f27670b;

    /* renamed from: c */
    private final zzbbh<V> f27671c;

    public zzcze(E e, String str, zzbbh<V> zzbbh) {
        this.f27669a = e;
        this.f27670b = str;
        this.f27671c = zzbbh;
    }

    /* renamed from: a */
    public final void mo28811a(Runnable runnable, Executor executor) {
        this.f27671c.mo28811a(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.f27671c.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.f27671c.get();
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f27671c.get(j, timeUnit);
    }

    public final boolean isCancelled() {
        return this.f27671c.isCancelled();
    }

    public final boolean isDone() {
        return this.f27671c.isDone();
    }

    /* renamed from: a */
    public final E mo31309a() {
        return this.f27669a;
    }

    /* renamed from: b */
    public final String mo31310b() {
        return this.f27670b;
    }

    public final String toString() {
        String str = this.f27670b;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }
}
