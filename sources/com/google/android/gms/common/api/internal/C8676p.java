package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.p */
abstract class C8676p implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zaak f19768a;

    private C8676p(zaak zaak) {
        this.f19768a = zaak;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo27572a();

    public void run() {
        this.f19768a.f19792b.lock();
        try {
            if (!Thread.interrupted()) {
                mo27572a();
                this.f19768a.f19792b.unlock();
            }
        } catch (RuntimeException e) {
            this.f19768a.f19791a.mo27607a(e);
        } finally {
            this.f19768a.f19792b.unlock();
        }
    }

    /* synthetic */ C8676p(zaak zaak, C8667g gVar) {
        this(zaak);
    }
}
