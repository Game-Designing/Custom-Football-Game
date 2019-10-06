package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14980ia;
import p026rx.p027b.C0129b;
import p026rx.p398d.C14908d;
import p026rx.p399e.C14920i;

/* renamed from: rx.c.a.n */
/* compiled from: OnSubscribeAutoConnect */
public final class C14695n<T> extends AtomicInteger implements C0122a<T> {

    /* renamed from: a */
    final C14908d<? extends T> f43724a;

    /* renamed from: b */
    final int f43725b;

    /* renamed from: c */
    final C0129b<? super C0137ja> f43726c;

    public C14695n(C14908d<? extends T> source, int numberOfSubscribers, C0129b<? super C0137ja> connection) {
        if (numberOfSubscribers > 0) {
            this.f43724a = source;
            this.f43725b = numberOfSubscribers;
            this.f43726c = connection;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        this.f43724a.mo3640b(C14920i.m46653a(child));
        if (incrementAndGet() == this.f43725b) {
            this.f43724a.mo45763d(this.f43726c);
        }
    }
}
