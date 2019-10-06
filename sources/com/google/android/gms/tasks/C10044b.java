package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.b */
final class C10044b<TResult> implements C10048f<TResult> {

    /* renamed from: a */
    private final Executor f30619a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f30620b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnCompleteListener<TResult> f30621c;

    public C10044b(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f30619a = executor;
        this.f30621c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo33186a(Task<TResult> task) {
        synchronized (this.f30620b) {
            if (this.f30621c != null) {
                this.f30619a.execute(new C10045c(this, task));
            }
        }
    }
}
