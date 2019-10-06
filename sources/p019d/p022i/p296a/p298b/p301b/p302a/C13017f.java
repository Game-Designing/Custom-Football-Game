package p019d.p022i.p296a.p298b.p301b.p302a;

import android.support.p000v4.widget.SwipeRefreshLayout.C0683b;
import p026rx.C14980ia;

/* renamed from: d.i.a.b.b.a.f */
/* compiled from: SwipeRefreshLayoutRefreshOnSubscribe */
class C13017f implements C0683b {

    /* renamed from: a */
    final /* synthetic */ C14980ia f39989a;

    /* renamed from: b */
    final /* synthetic */ C13019h f39990b;

    C13017f(C13019h this$0, C14980ia iaVar) {
        this.f39990b = this$0;
        this.f39989a = iaVar;
    }

    /* renamed from: a */
    public void mo5894a() {
        if (!this.f39989a.isUnsubscribed()) {
            this.f39989a.onNext(null);
        }
    }
}
