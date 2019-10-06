package p026rx.p390c.p391a;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0137ja;
import p026rx.C14972ha;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.p027b.C14545u;
import p026rx.p029i.C0136c;

/* renamed from: rx.c.a.Ib */
/* compiled from: SingleOperatorZip */
class C14591Ib implements C0124a<R> {

    /* renamed from: a */
    final /* synthetic */ Single[] f43469a;

    /* renamed from: b */
    final /* synthetic */ C14545u f43470b;

    C14591Ib(Single[] singleArr, C14545u uVar) {
        this.f43469a = singleArr;
        this.f43470b = uVar;
    }

    /* renamed from: a */
    public void call(C14972ha<? super R> subscriber) {
        Single[] singleArr = this.f43469a;
        if (singleArr.length == 0) {
            subscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
            return;
        }
        AtomicInteger wip = new AtomicInteger(singleArr.length);
        AtomicBoolean once = new AtomicBoolean();
        Object[] values = new Object[this.f43469a.length];
        C0136c compositeSubscription = new C0136c();
        subscriber.mo46195b(compositeSubscription);
        for (int i = 0; i < this.f43469a.length && !compositeSubscription.isUnsubscribed() && !once.get(); i++) {
            C14586Hb hb = new C14586Hb(this, values, i, wip, subscriber, once);
            compositeSubscription.mo3713a((C0137ja) hb);
            if (compositeSubscription.isUnsubscribed() || once.get()) {
                break;
            }
            this.f43469a[i].mo3691a((C14972ha<? super T>) hb);
        }
    }
}
