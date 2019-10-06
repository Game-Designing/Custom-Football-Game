package p026rx.p390c.p393c;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0137ja;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0128a;
import p026rx.p029i.C0136c;
import p026rx.p390c.p395e.C14899t;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.c.s */
/* compiled from: ScheduledAction */
public final class C14805s extends AtomicReference<Thread> implements Runnable, C0137ja {

    /* renamed from: a */
    final C14899t f44047a;

    /* renamed from: b */
    final C0128a f44048b;

    /* renamed from: rx.c.c.s$a */
    /* compiled from: ScheduledAction */
    final class C14806a implements C0137ja {

        /* renamed from: a */
        private final Future<?> f44049a;

        C14806a(Future<?> f) {
            this.f44049a = f;
        }

        public void unsubscribe() {
            if (C14805s.this.get() != Thread.currentThread()) {
                this.f44049a.cancel(true);
            } else {
                this.f44049a.cancel(false);
            }
        }

        public boolean isUnsubscribed() {
            return this.f44049a.isCancelled();
        }
    }

    /* renamed from: rx.c.c.s$b */
    /* compiled from: ScheduledAction */
    static final class C14807b extends AtomicBoolean implements C0137ja {

        /* renamed from: a */
        final C14805s f44051a;

        /* renamed from: b */
        final C14899t f44052b;

        public C14807b(C14805s s, C14899t parent) {
            this.f44051a = s;
            this.f44052b = parent;
        }

        public boolean isUnsubscribed() {
            return this.f44051a.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f44052b.mo46108b(this.f44051a);
            }
        }
    }

    /* renamed from: rx.c.c.s$c */
    /* compiled from: ScheduledAction */
    static final class C14808c extends AtomicBoolean implements C0137ja {

        /* renamed from: a */
        final C14805s f44053a;

        /* renamed from: b */
        final C0136c f44054b;

        public C14808c(C14805s s, C0136c parent) {
            this.f44053a = s;
            this.f44054b = parent;
        }

        public boolean isUnsubscribed() {
            return this.f44053a.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f44054b.mo3714b(this.f44053a);
            }
        }
    }

    public C14805s(C0128a action) {
        this.f44048b = action;
        this.f44047a = new C14899t();
    }

    public C14805s(C0128a action, C0136c parent) {
        this.f44048b = action;
        this.f44047a = new C14899t((C0137ja) new C14808c(this, parent));
    }

    public C14805s(C0128a action, C14899t parent) {
        this.f44048b = action;
        this.f44047a = new C14899t((C0137ja) new C14807b(this, parent));
    }

    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.f44048b.call();
        } catch (OnErrorNotImplementedException e) {
            mo45939a((Throwable) new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
        } catch (Throwable th) {
            unsubscribe();
            throw th;
        }
        unsubscribe();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo45939a(Throwable ie) {
        C14948s.m46719b(ie);
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, ie);
    }

    public boolean isUnsubscribed() {
        return this.f44047a.isUnsubscribed();
    }

    public void unsubscribe() {
        if (!this.f44047a.isUnsubscribed()) {
            this.f44047a.unsubscribe();
        }
    }

    /* renamed from: a */
    public void mo45942a(C0137ja s) {
        this.f44047a.mo46107a(s);
    }

    /* renamed from: a */
    public void mo45940a(Future<?> f) {
        this.f44047a.mo46107a((C0137ja) new C14806a(f));
    }

    /* renamed from: a */
    public void mo45941a(C0136c parent) {
        this.f44047a.mo46107a((C0137ja) new C14808c(this, parent));
    }
}
