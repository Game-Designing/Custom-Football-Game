package p019d.p022i.p296a.p298b.p301b.p302a;

import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p000v4.widget.SwipeRefreshLayout.C0683b;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.b.b.a.h */
/* compiled from: SwipeRefreshLayoutRefreshOnSubscribe */
final class C13019h implements C0122a<Void> {

    /* renamed from: a */
    final SwipeRefreshLayout f39992a;

    C13019h(SwipeRefreshLayout view) {
        this.f39992a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Void> subscriber) {
        C14521b.verifyMainThread();
        C0683b listener = new C13017f(this, subscriber);
        subscriber.add(new C13018g(this));
        this.f39992a.setOnRefreshListener(listener);
    }
}
