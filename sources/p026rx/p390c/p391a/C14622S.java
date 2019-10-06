package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14506Q;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p028h.C0134b;
import p026rx.p028h.C14967e;
import p026rx.p029i.C14977e;
import p026rx.p390c.p392b.C14771b;
import p026rx.p399e.C14920i;
import p026rx.schedulers.Schedulers;

/* renamed from: rx.c.a.S */
/* compiled from: OnSubscribeRedo */
public final class C14622S<T> implements C0122a<T> {

    /* renamed from: a */
    static final C0132p<C0120S<? extends C14506Q<?>>, C0120S<?>> f43553a = new C14592J();

    /* renamed from: b */
    final C0120S<T> f43554b;

    /* renamed from: c */
    private final C0132p<? super C0120S<? extends C14506Q<?>>, ? extends C0120S<?>> f43555c;

    /* renamed from: d */
    final boolean f43556d;

    /* renamed from: e */
    final boolean f43557e;

    /* renamed from: f */
    private final C0126V f43558f;

    /* renamed from: a */
    public static <T> C0120S<T> m46268a(C0120S<T> source) {
        return m46269a(source, f43553a);
    }

    /* renamed from: a */
    public static <T> C0120S<T> m46269a(C0120S<T> source, C0132p<? super C0120S<? extends C14506Q<?>>, ? extends C0120S<?>> notificationHandler) {
        C14622S s = new C14622S(source, notificationHandler, true, false, Schedulers.trampoline());
        return C0120S.m648b((C0122a<T>) s);
    }

    private C14622S(C0120S<T> source, C0132p<? super C0120S<? extends C14506Q<?>>, ? extends C0120S<?>> f, boolean stopOnComplete, boolean stopOnError, C0126V scheduler) {
        this.f43554b = source;
        this.f43555c = f;
        this.f43556d = stopOnComplete;
        this.f43557e = stopOnError;
        this.f43558f = scheduler;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        C14980ia<? super T> iaVar = child;
        AtomicBoolean resumeBoundary = new AtomicBoolean(true);
        AtomicLong consumerCapacity = new AtomicLong();
        C0127a worker = this.f43558f.createWorker();
        iaVar.add(worker);
        C14977e sourceSubscriptions = new C14977e();
        iaVar.add(sourceSubscriptions);
        C14967e o = C0134b.m768p().mo3711o();
        C14980ia a = C14920i.m46651a();
        o.mo3627a(a);
        C14771b arbiter = new C14771b();
        C14601L l = new C14601L(this, child, o, arbiter, consumerCapacity, sourceSubscriptions);
        C0120S s = (C0120S) this.f43555c.call(o.mo3613a((C0123b<? extends R, ? super T>) new C14608N<Object,Object>(this)));
        C14980ia iaVar2 = a;
        C14977e eVar = sourceSubscriptions;
        C0127a worker2 = worker;
        C0120S s2 = s;
        C14980ia<? super T> iaVar3 = iaVar;
        C14612P p = new C14612P(this, s, child, consumerCapacity, worker2, l, resumeBoundary);
        worker2.mo3707a(p);
        C14614Q q = new C14614Q(this, consumerCapacity, arbiter, resumeBoundary, worker2, l);
        iaVar3.setProducer(q);
    }
}
