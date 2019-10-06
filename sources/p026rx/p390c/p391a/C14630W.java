package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14980ia;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;
import p026rx.p029i.C14978f;
import p026rx.p398d.C14908d;

/* renamed from: rx.c.a.W */
/* compiled from: OnSubscribeRefCount */
public final class C14630W<T> implements C0122a<T> {

    /* renamed from: a */
    private final C14908d<? extends T> f43576a;

    /* renamed from: b */
    volatile C0136c f43577b = new C0136c();

    /* renamed from: c */
    final AtomicInteger f43578c = new AtomicInteger(0);

    /* renamed from: d */
    final ReentrantLock f43579d = new ReentrantLock();

    public C14630W(C14908d<? extends T> source) {
        this.f43576a = source;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> subscriber) {
        this.f43579d.lock();
        if (this.f43578c.incrementAndGet() == 1) {
            AtomicBoolean writeLocked = new AtomicBoolean(true);
            try {
                this.f43576a.mo45763d(m46273a(subscriber, writeLocked));
            } finally {
                if (writeLocked.get()) {
                    this.f43579d.unlock();
                }
            }
        } else {
            try {
                mo45797a(subscriber, this.f43577b);
            } finally {
                this.f43579d.unlock();
            }
        }
    }

    /* renamed from: a */
    private C0129b<C0137ja> m46273a(C14980ia<? super T> subscriber, AtomicBoolean writeLocked) {
        return new C14624T(this, subscriber, writeLocked);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo45797a(C14980ia<? super T> subscriber, C0136c currentBase) {
        subscriber.add(m46274a(currentBase));
        this.f43576a.mo3640b((C14980ia<? super T>) new C14626U<Object>(this, subscriber, subscriber, currentBase));
    }

    /* renamed from: a */
    private C0137ja m46274a(C0136c current) {
        return C14978f.m46781a(new C14628V(this, current));
    }
}
