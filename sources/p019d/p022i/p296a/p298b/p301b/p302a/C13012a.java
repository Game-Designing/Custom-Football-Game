package p019d.p022i.p296a.p298b.p301b.p302a;

import android.support.p000v4.widget.NestedScrollView;
import android.support.p000v4.widget.NestedScrollView.C0681b;
import p019d.p022i.p296a.p305c.C13045l;
import p026rx.C14980ia;

/* renamed from: d.i.a.b.b.a.a */
/* compiled from: NestedScrollViewScrollChangeEventOnSubscribe */
class C13012a implements C0681b {

    /* renamed from: a */
    final /* synthetic */ C14980ia f39985a;

    /* renamed from: b */
    final /* synthetic */ C13014c f39986b;

    C13012a(C13014c this$0, C14980ia iaVar) {
        this.f39986b = this$0;
        this.f39985a = iaVar;
    }

    /* renamed from: a */
    public void mo5855a(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (!this.f39985a.isUnsubscribed()) {
            this.f39985a.onNext(C13045l.m42497a(this.f39986b.f39988a, scrollX, scrollY, oldScrollX, oldScrollY));
        }
    }
}
