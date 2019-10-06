package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzard
public class zzbbr<T> implements zzbbh<T> {

    /* renamed from: a */
    private final Object f25069a = new Object();

    /* renamed from: b */
    private T f25070b;

    /* renamed from: c */
    private Throwable f25071c;

    /* renamed from: d */
    private boolean f25072d;

    /* renamed from: e */
    private boolean f25073e;

    /* renamed from: f */
    private final C9312ad f25074f = new C9312ad();

    /* renamed from: a */
    public final void mo28811a(Runnable runnable, Executor executor) {
        this.f25074f.mo28848a(runnable, executor);
    }

    /* renamed from: b */
    public final void mo30338b(T t) {
        synchronized (this.f25069a) {
            if (!this.f25073e) {
                if (mo30336a()) {
                    zzk.zzlk().mo30170b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                    return;
                }
                this.f25072d = true;
                this.f25070b = t;
                this.f25069a.notifyAll();
                this.f25074f.mo28847a();
            }
        }
    }

    /* renamed from: a */
    public final void mo30337a(Throwable th) {
        synchronized (this.f25069a) {
            if (!this.f25073e) {
                if (mo30336a()) {
                    zzk.zzlk().mo30170b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                    return;
                }
                this.f25071c = th;
                this.f25069a.notifyAll();
                this.f25074f.mo28847a();
            }
        }
    }

    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.f25069a) {
            while (!mo30336a()) {
                this.f25069a.wait();
            }
            if (this.f25071c != null) {
                throw new ExecutionException(this.f25071c);
            } else if (!this.f25073e) {
                t = this.f25070b;
            } else {
                throw new CancellationException("SettableFuture was cancelled.");
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.f25069a) {
            long millis = timeUnit.toMillis(j);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = millis + currentTimeMillis;
            while (!mo30336a() && currentTimeMillis < j2) {
                this.f25069a.wait(j2 - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
            if (this.f25073e) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else if (this.f25071c != null) {
                throw new ExecutionException(this.f25071c);
            } else if (this.f25072d) {
                t = this.f25070b;
            } else {
                throw new TimeoutException("SettableFuture timed out.");
            }
        }
        return t;
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f25069a) {
            if (mo30336a()) {
                return false;
            }
            this.f25073e = true;
            this.f25072d = true;
            this.f25069a.notifyAll();
            this.f25074f.mo28847a();
            return true;
        }
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f25069a) {
            z = this.f25073e;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.f25069a) {
            a = mo30336a();
        }
        return a;
    }

    /* renamed from: a */
    private final boolean mo30336a() {
        return this.f25071c != null || this.f25072d;
    }
}
