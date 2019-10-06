package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S.C0122a;
import p026rx.C14508U;
import p026rx.C14980ia;
import rx.Subscriber;

/* renamed from: rx.c.a.H */
/* compiled from: OnSubscribeRange */
public final class C14583H implements C0122a<Integer> {

    /* renamed from: a */
    private final int f43443a;

    /* renamed from: b */
    private final int f43444b;

    /* renamed from: rx.c.a.H$a */
    /* compiled from: OnSubscribeRange */
    static final class C14584a extends AtomicLong implements C14508U {

        /* renamed from: a */
        private final C14980ia<? super Integer> f43445a;

        /* renamed from: b */
        private final int f43446b;

        /* renamed from: c */
        private long f43447c;

        C14584a(C14980ia<? super Integer> childSubscriber, int startIndex, int endIndex) {
            this.f43445a = childSubscriber;
            this.f43447c = (long) startIndex;
            this.f43446b = endIndex;
        }

        public void request(long requestedAmount) {
            if (get() != Long.MAX_VALUE) {
                if (requestedAmount == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    mo45759a();
                } else if (requestedAmount > 0 && C14640a.m46283a((AtomicLong) this, requestedAmount) == 0) {
                    mo45760a(requestedAmount);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45760a(long requestedAmount) {
            long emitted = 0;
            long endIndex = ((long) this.f43446b) + 1;
            long index = this.f43447c;
            Subscriber<? super Integer> childSubscriber = this.f43445a;
            while (true) {
                if (emitted == requestedAmount || index == endIndex) {
                    if (!childSubscriber.isUnsubscribed()) {
                        if (index == endIndex) {
                            childSubscriber.onCompleted();
                            return;
                        }
                        requestedAmount = get();
                        if (requestedAmount == emitted) {
                            this.f43447c = index;
                            requestedAmount = addAndGet(-emitted);
                            if (requestedAmount != 0) {
                                emitted = 0;
                            } else {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        return;
                    }
                } else if (!childSubscriber.isUnsubscribed()) {
                    childSubscriber.onNext(Integer.valueOf((int) index));
                    index++;
                    emitted++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45759a() {
            long endIndex = ((long) this.f43446b) + 1;
            Subscriber<? super Integer> childSubscriber = this.f43445a;
            long index = this.f43447c;
            while (index != endIndex) {
                if (!childSubscriber.isUnsubscribed()) {
                    childSubscriber.onNext(Integer.valueOf((int) index));
                    index++;
                } else {
                    return;
                }
            }
            if (!childSubscriber.isUnsubscribed()) {
                childSubscriber.onCompleted();
            }
        }
    }

    public C14583H(int start, int end) {
        this.f43443a = start;
        this.f43444b = end;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Integer> childSubscriber) {
        childSubscriber.setProducer(new C14584a(childSubscriber, this.f43443a, this.f43444b));
    }
}
