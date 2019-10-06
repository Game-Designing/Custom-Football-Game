package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.e */
final class C10047e implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f30627a;

    /* renamed from: b */
    private final /* synthetic */ C10046d f30628b;

    C10047e(C10046d dVar, Task task) {
        this.f30628b = dVar;
        this.f30627a = task;
    }

    public final void run() {
        synchronized (this.f30628b.f30625b) {
            if (this.f30628b.f30626c != null) {
                this.f30628b.f30626c.onSuccess(this.f30627a.mo33177b());
            }
        }
    }
}
