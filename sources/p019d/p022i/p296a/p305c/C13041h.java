package p019d.p022i.p296a.p305c;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.c.h */
/* compiled from: ViewFocusChangeOnSubscribe */
final class C13041h implements C0122a<Boolean> {

    /* renamed from: a */
    final View f40018a;

    C13041h(View view) {
        this.f40018a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Boolean> subscriber) {
        C14521b.verifyMainThread();
        OnFocusChangeListener listener = new C13039f(this, subscriber);
        subscriber.add(new C13040g(this));
        this.f40018a.setOnFocusChangeListener(listener);
        subscriber.onNext(Boolean.valueOf(this.f40018a.hasFocus()));
    }
}
