package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.w */
abstract class C8683w {

    /* renamed from: a */
    private final zabd f19780a;

    protected C8683w(zabd zabd) {
        this.f19780a = zabd;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo27570a();

    /* renamed from: a */
    public final void mo27578a(zabe zabe) {
        zabe.f19839a.lock();
        try {
            if (zabe.f19849k == this.f19780a) {
                mo27570a();
                zabe.f19839a.unlock();
            }
        } finally {
            zabe.f19839a.unlock();
        }
    }
}
