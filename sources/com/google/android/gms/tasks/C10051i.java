package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.i */
final class C10051i<TResult> extends Task<TResult> {

    /* renamed from: a */
    private final Object f30632a = new Object();

    /* renamed from: b */
    private final C10049g<TResult> f30633b = new C10049g<>();

    /* renamed from: c */
    private boolean f30634c;

    /* renamed from: d */
    private volatile boolean f30635d;

    /* renamed from: e */
    private TResult f30636e;

    /* renamed from: f */
    private Exception f30637f;

    C10051i() {
    }

    /* renamed from: c */
    public final boolean mo33178c() {
        boolean z;
        synchronized (this.f30632a) {
            z = this.f30634c;
        }
        return z;
    }

    /* renamed from: d */
    public final boolean mo33179d() {
        boolean z;
        synchronized (this.f30632a) {
            z = this.f30634c && !this.f30635d && this.f30637f == null;
        }
        return z;
    }

    /* renamed from: b */
    public final TResult mo33177b() {
        TResult tresult;
        synchronized (this.f30632a) {
            m32796e();
            m32798g();
            if (this.f30637f == null) {
                tresult = this.f30636e;
            } else {
                throw new RuntimeExecutionException(this.f30637f);
            }
        }
        return tresult;
    }

    /* renamed from: a */
    public final Exception mo33176a() {
        Exception exc;
        synchronized (this.f30632a) {
            exc = this.f30637f;
        }
        return exc;
    }

    /* renamed from: a */
    public final Task<TResult> mo33174a(OnSuccessListener<? super TResult> onSuccessListener) {
        return mo33192a(TaskExecutors.f30615a, onSuccessListener);
    }

    /* renamed from: a */
    public final Task<TResult> mo33192a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f30633b.mo33190a((C10048f<TResult>) new C10046d<TResult>(executor, onSuccessListener));
        m32799h();
        return this;
    }

    /* renamed from: a */
    public final Task<TResult> mo33173a(OnCompleteListener<TResult> onCompleteListener) {
        return mo33175a(TaskExecutors.f30615a, onCompleteListener);
    }

    /* renamed from: a */
    public final Task<TResult> mo33175a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f30633b.mo33190a((C10048f<TResult>) new C10044b<TResult>(executor, onCompleteListener));
        m32799h();
        return this;
    }

    /* renamed from: a */
    public final void mo33194a(TResult tresult) {
        synchronized (this.f30632a) {
            m32797f();
            this.f30634c = true;
            this.f30636e = tresult;
        }
        this.f30633b.mo33189a((Task<TResult>) this);
    }

    /* renamed from: b */
    public final boolean mo33196b(TResult tresult) {
        synchronized (this.f30632a) {
            if (this.f30634c) {
                return false;
            }
            this.f30634c = true;
            this.f30636e = tresult;
            this.f30633b.mo33189a((Task<TResult>) this);
            return true;
        }
    }

    /* renamed from: a */
    public final void mo33193a(Exception exc) {
        Preconditions.m21858a(exc, (Object) "Exception must not be null");
        synchronized (this.f30632a) {
            m32797f();
            this.f30634c = true;
            this.f30637f = exc;
        }
        this.f30633b.mo33189a((Task<TResult>) this);
    }

    /* renamed from: b */
    public final boolean mo33195b(Exception exc) {
        Preconditions.m21858a(exc, (Object) "Exception must not be null");
        synchronized (this.f30632a) {
            if (this.f30634c) {
                return false;
            }
            this.f30634c = true;
            this.f30637f = exc;
            this.f30633b.mo33189a((Task<TResult>) this);
            return true;
        }
    }

    /* renamed from: e */
    private final void m32796e() {
        Preconditions.m21868b(this.f30634c, "Task is not yet complete");
    }

    /* renamed from: f */
    private final void m32797f() {
        Preconditions.m21868b(!this.f30634c, "Task is already complete");
    }

    /* renamed from: g */
    private final void m32798g() {
        if (this.f30635d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    /* renamed from: h */
    private final void m32799h() {
        synchronized (this.f30632a) {
            if (this.f30634c) {
                this.f30633b.mo33189a((Task<TResult>) this);
            }
        }
    }
}
