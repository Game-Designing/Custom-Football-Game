package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0988n;
import p026rx.C14980ia;

/* renamed from: d.i.a.b.c.a.b */
/* compiled from: RecyclerViewScrollEventOnSubscribe */
class C13021b extends C0988n {

    /* renamed from: a */
    final /* synthetic */ C14980ia f39995a;

    /* renamed from: b */
    final /* synthetic */ C13023d f39996b;

    C13021b(C13023d this$0, C14980ia iaVar) {
        this.f39996b = this$0;
        this.f39995a = iaVar;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (!this.f39995a.isUnsubscribed()) {
            this.f39995a.onNext(C13020a.m42480a(recyclerView, dx, dy));
        }
    }
}
