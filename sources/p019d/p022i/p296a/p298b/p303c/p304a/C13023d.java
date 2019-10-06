package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0988n;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.b.c.a.d */
/* compiled from: RecyclerViewScrollEventOnSubscribe */
final class C13023d implements C0122a<C13020a> {

    /* renamed from: a */
    final RecyclerView f39999a;

    public C13023d(RecyclerView recyclerView) {
        this.f39999a = recyclerView;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C13020a> subscriber) {
        C14521b.verifyMainThread();
        C0988n listener = new C13021b(this, subscriber);
        subscriber.add(new C13022c(this, listener));
        this.f39999a.mo7530a(listener);
    }
}
