package p019d.p022i.p296a.p298b.p301b.p302a;

import android.support.p000v4.widget.NestedScrollView;
import android.support.p000v4.widget.NestedScrollView.C0681b;
import p019d.p022i.p296a.p305c.C13045l;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.b.b.a.c */
/* compiled from: NestedScrollViewScrollChangeEventOnSubscribe */
final class C13014c implements C0122a<C13045l> {

    /* renamed from: a */
    final NestedScrollView f39988a;

    C13014c(NestedScrollView view) {
        this.f39988a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C13045l> subscriber) {
        C14521b.verifyMainThread();
        C0681b listener = new C13012a(this, subscriber);
        subscriber.add(new C13013b(this));
        this.f39988a.setOnScrollChangeListener(listener);
    }
}
