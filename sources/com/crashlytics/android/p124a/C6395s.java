package com.crashlytics.android.p124a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.s */
/* compiled from: BackgroundManager */
class C6395s {

    /* renamed from: a */
    private final ScheduledExecutorService f11436a;

    /* renamed from: b */
    private final List<C6396a> f11437b = new ArrayList();

    /* renamed from: c */
    private volatile boolean f11438c = true;

    /* renamed from: d */
    final AtomicReference<ScheduledFuture<?>> f11439d = new AtomicReference<>();

    /* renamed from: e */
    boolean f11440e = true;

    /* renamed from: com.crashlytics.android.a.s$a */
    /* compiled from: BackgroundManager */
    public interface C6396a {
        /* renamed from: a */
        void mo19352a();
    }

    public C6395s(ScheduledExecutorService executorService) {
        this.f11436a = executorService;
    }

    /* renamed from: a */
    public void mo19418a(boolean flushOnBackground) {
        this.f11438c = flushOnBackground;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12388c() {
        for (C6396a listener : this.f11437b) {
            listener.mo19352a();
        }
    }

    /* renamed from: a */
    public void mo19417a(C6396a listener) {
        this.f11437b.add(listener);
    }

    /* renamed from: b */
    public void mo19419b() {
        this.f11440e = false;
        ScheduledFuture backgroundFuture = (ScheduledFuture) this.f11439d.getAndSet(null);
        if (backgroundFuture != null) {
            backgroundFuture.cancel(false);
        }
    }

    /* renamed from: a */
    public void mo19416a() {
        if (this.f11438c && !this.f11440e) {
            this.f11440e = true;
            try {
                this.f11439d.compareAndSet(null, this.f11436a.schedule(new C6394r(this), 5000, TimeUnit.MILLISECONDS));
            } catch (RejectedExecutionException e) {
                C13920f.m44245e().mo43327c("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
