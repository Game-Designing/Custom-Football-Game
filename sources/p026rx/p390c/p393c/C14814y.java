package p026rx.p390c.p393c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0125T;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.C14503O;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p029i.C14978f;
import p026rx.p390c.p391a.C14652d;
import p026rx.p399e.C14915e;
import rx.Completable;
import rx.Observable;
import rx.Observer;
import rx.internal.operators.BufferUntilSubscriber;
import rx.internal.schedulers.SchedulerWhen.ScheduledAction;
import rx.subjects.PublishSubject;

/* renamed from: rx.c.c.y */
/* compiled from: SchedulerWhen */
public class C14814y extends C0126V implements C0137ja {

    /* renamed from: a */
    static final C0137ja f44063a = new C14813x();

    /* renamed from: b */
    static final C0137ja f44064b = C14978f.m46782b();

    /* renamed from: c */
    private final C0126V f44065c;

    /* renamed from: d */
    private final C0125T<C0120S<C0117M>> f44066d;

    /* renamed from: e */
    private final C0137ja f44067e;

    /* renamed from: rx.c.c.y$a */
    /* compiled from: SchedulerWhen */
    static class C14815a extends C14818d {

        /* renamed from: a */
        private final C0128a f44068a;

        /* renamed from: b */
        private final long f44069b;

        /* renamed from: c */
        private final TimeUnit f44070c;

        public C14815a(C0128a action, long delayTime, TimeUnit unit) {
            this.f44068a = action;
            this.f44069b = delayTime;
            this.f44070c = unit;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C0137ja mo45946a(C0127a actualWorker, C14503O actionCompletable) {
            return actualWorker.mo3709a(new C14817c(this.f44068a, actionCompletable), this.f44069b, this.f44070c);
        }
    }

    /* renamed from: rx.c.c.y$b */
    /* compiled from: SchedulerWhen */
    static class C14816b extends C14818d {

        /* renamed from: a */
        private final C0128a f44071a;

        public C14816b(C0128a action) {
            this.f44071a = action;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C0137ja mo45946a(C0127a actualWorker, C14503O actionCompletable) {
            return actualWorker.mo3707a(new C14817c(this.f44071a, actionCompletable));
        }
    }

    /* renamed from: rx.c.c.y$c */
    /* compiled from: SchedulerWhen */
    static class C14817c implements C0128a {

        /* renamed from: a */
        private C14503O f44072a;

        /* renamed from: b */
        private C0128a f44073b;

        public C14817c(C0128a action, C14503O actionCompletable) {
            this.f44073b = action;
            this.f44072a = actionCompletable;
        }

        public void call() {
            try {
                this.f44073b.call();
            } finally {
                this.f44072a.onCompleted();
            }
        }
    }

    /* renamed from: rx.c.c.y$d */
    /* compiled from: SchedulerWhen */
    static abstract class C14818d extends AtomicReference<C0137ja> implements C0137ja {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract C0137ja mo45946a(C0127a aVar, C14503O o);

        public C14818d() {
            super(C14814y.f44063a);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m46480b(C0127a actualWorker, C14503O actionCompletable) {
            C0137ja oldState = (C0137ja) get();
            if (oldState != C14814y.f44064b && oldState == C14814y.f44063a) {
                C0137ja newState = mo45946a(actualWorker, actionCompletable);
                if (!compareAndSet(C14814y.f44063a, newState)) {
                    newState.unsubscribe();
                }
            }
        }

        public boolean isUnsubscribed() {
            return ((C0137ja) get()).isUnsubscribed();
        }

        public void unsubscribe() {
            C0137ja oldState;
            C0137ja newState = C14814y.f44064b;
            do {
                oldState = (C0137ja) get();
                if (oldState == C14814y.f44064b) {
                    return;
                }
            } while (!compareAndSet(oldState, newState));
            if (oldState != C14814y.f44063a) {
                oldState.unsubscribe();
            }
        }
    }

    public C14814y(C0132p<C0120S<C0120S<C0117M>>, C0117M> combine, C0126V actualScheduler) {
        this.f44065c = actualScheduler;
        PublishSubject<Observable<Completable>> workerSubject = C14963c.m46753p();
        this.f44066d = new C14915e(workerSubject);
        this.f44067e = ((C0117M) combine.call(workerSubject.mo3654e())).mo3603e();
    }

    public void unsubscribe() {
        this.f44067e.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.f44067e.isUnsubscribed();
    }

    public C0127a createWorker() {
        C0127a actualWorker = this.f44065c.createWorker();
        BufferUntilSubscriber<ScheduledAction> actionSubject = C14652d.m46293p();
        Observer<ScheduledAction> actionObserver = new C14915e<>(actionSubject);
        Observable<Completable> actions = actionSubject.mo3669j(new C14811v(this, actualWorker));
        C0127a worker = new C14812w(this, actualWorker, actionObserver);
        this.f44066d.onNext(actions);
        return worker;
    }
}
