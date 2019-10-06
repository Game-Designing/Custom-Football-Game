package p019d.p022i.p296a.p305c;

import android.view.View;
import android.view.View.OnClickListener;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.c.d */
/* compiled from: ViewClickOnSubscribe */
final class C13037d implements C0122a<Void> {

    /* renamed from: a */
    final View f40013a;

    C13037d(View view) {
        this.f40013a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Void> subscriber) {
        C14521b.verifyMainThread();
        OnClickListener listener = new C13035b(this, subscriber);
        subscriber.add(new C13036c(this));
        this.f40013a.setOnClickListener(listener);
    }
}
