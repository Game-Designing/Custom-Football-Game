package p026rx.p390c.p391a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p392b.C14772c;

/* renamed from: rx.c.a.ob */
/* compiled from: OperatorToObservableSortedList */
class C14702ob extends C14980ia<T> {

    /* renamed from: a */
    List<T> f43754a = new ArrayList(this.f43758e.f43765c);

    /* renamed from: b */
    boolean f43755b;

    /* renamed from: c */
    final /* synthetic */ C14772c f43756c;

    /* renamed from: d */
    final /* synthetic */ C14980ia f43757d;

    /* renamed from: e */
    final /* synthetic */ C14705pb f43758e;

    C14702ob(C14705pb pbVar, C14772c cVar, C14980ia iaVar) {
        this.f43758e = pbVar;
        this.f43756c = cVar;
        this.f43757d = iaVar;
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    public void onCompleted() {
        if (!this.f43755b) {
            this.f43755b = true;
            List<T> a = this.f43754a;
            this.f43754a = null;
            try {
                Collections.sort(a, this.f43758e.f43764b);
                this.f43756c.mo45916a(a);
            } catch (Throwable e) {
                C14927a.m46672a(e, (C0125T<?>) this);
            }
        }
    }

    public void onError(Throwable e) {
        this.f43757d.onError(e);
    }

    public void onNext(T value) {
        if (!this.f43755b) {
            this.f43754a.add(value);
        }
    }
}
