package p019d.p022i.p296a.p306d;

import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.d.m */
/* compiled from: TextViewEditorActionEventOnSubscribe */
final class C13058m implements C0122a<C13055j> {

    /* renamed from: a */
    final TextView f40043a;

    /* renamed from: b */
    final C0132p<? super C13055j, Boolean> f40044b;

    C13058m(TextView view, C0132p<? super C13055j, Boolean> handled) {
        this.f40043a = view;
        this.f40044b = handled;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C13055j> subscriber) {
        C14521b.verifyMainThread();
        OnEditorActionListener listener = new C13056k(this, subscriber);
        subscriber.add(new C13057l(this));
        this.f40043a.setOnEditorActionListener(listener);
    }
}
