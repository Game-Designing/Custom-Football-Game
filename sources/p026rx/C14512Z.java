package p026rx;

import p026rx.C0126V.C0127a;
import p026rx.Single.C0124a;

/* renamed from: rx.Z */
/* compiled from: Single */
class C14512Z implements C0124a<T> {

    /* renamed from: a */
    final /* synthetic */ C0126V f43325a;

    /* renamed from: b */
    final /* synthetic */ Single f43326b;

    C14512Z(Single single, C0126V v) {
        this.f43326b = single;
        this.f43325a = v;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> t) {
        C0127a w = this.f43325a.createWorker();
        t.mo46195b(w);
        w.mo3707a(new C14511Y(this, t, w));
    }
}
