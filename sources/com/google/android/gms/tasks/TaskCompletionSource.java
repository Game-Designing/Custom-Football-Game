package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult> {

    /* renamed from: a */
    private final C10051i<TResult> f30614a = new C10051i<>();

    /* renamed from: a */
    public void mo33182a(TResult tresult) {
        this.f30614a.mo33194a(tresult);
    }

    /* renamed from: b */
    public boolean mo33184b(TResult tresult) {
        return this.f30614a.mo33196b(tresult);
    }

    /* renamed from: a */
    public void mo33181a(Exception exc) {
        this.f30614a.mo33193a(exc);
    }

    /* renamed from: b */
    public boolean mo33183b(Exception exc) {
        return this.f30614a.mo33195b(exc);
    }

    /* renamed from: a */
    public Task<TResult> mo33180a() {
        return this.f30614a;
    }
}
