package p019d.p022i.p296a.p305c;

import android.view.View;
import android.view.View.OnLongClickListener;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p027b.C0131o;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.c.k */
/* compiled from: ViewLongClickOnSubscribe */
final class C13044k implements C0122a<Void> {

    /* renamed from: a */
    final View f40022a;

    /* renamed from: b */
    final C0131o<Boolean> f40023b;

    C13044k(View view, C0131o<Boolean> handled) {
        this.f40022a = view;
        this.f40023b = handled;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Void> subscriber) {
        C14521b.verifyMainThread();
        OnLongClickListener listener = new C13042i(this, subscriber);
        subscriber.add(new C13043j(this));
        this.f40022a.setOnLongClickListener(listener);
    }
}
