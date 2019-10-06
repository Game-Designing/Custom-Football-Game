package p026rx;

import p026rx.Single.C0124a;

/* renamed from: rx.ca */
/* compiled from: Single */
class C14903ca implements C0124a<T> {

    /* renamed from: a */
    final /* synthetic */ Throwable f44209a;

    C14903ca(Throwable th) {
        this.f44209a = th;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> te) {
        te.onError(this.f44209a);
    }
}
