package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.c */
final class C10045c implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f30622a;

    /* renamed from: b */
    private final /* synthetic */ C10044b f30623b;

    C10045c(C10044b bVar, Task task) {
        this.f30623b = bVar;
        this.f30622a = task;
    }

    public final void run() {
        synchronized (this.f30623b.f30620b) {
            if (this.f30623b.f30621c != null) {
                this.f30623b.f30621c.mo10072a(this.f30622a);
            }
        }
    }
}
