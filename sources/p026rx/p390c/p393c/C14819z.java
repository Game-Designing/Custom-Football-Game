package p026rx.p390c.p393c;

import p026rx.C0126V.C0127a;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;

/* renamed from: rx.c.c.z */
/* compiled from: SleepingAction */
class C14819z implements C0128a {

    /* renamed from: a */
    private final C0128a f44074a;

    /* renamed from: b */
    private final C0127a f44075b;

    /* renamed from: c */
    private final long f44076c;

    public C14819z(C0128a underlying, C0127a scheduler, long execTime) {
        this.f44074a = underlying;
        this.f44075b = scheduler;
        this.f44076c = execTime;
    }

    public void call() {
        if (!this.f44075b.isUnsubscribed()) {
            long delay = this.f44076c - this.f44075b.mo3710b();
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    C14927a.m46677b(e);
                    throw null;
                }
            }
            if (!this.f44075b.isUnsubscribed()) {
                this.f44074a.call();
            }
        }
    }
}
