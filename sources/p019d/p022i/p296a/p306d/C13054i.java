package p019d.p022i.p296a.p306d;

import android.text.TextWatcher;
import android.widget.TextView;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.d.i */
/* compiled from: TextViewAfterTextChangeEventOnSubscribe */
final class C13054i implements C0122a<C13051f> {

    /* renamed from: a */
    final TextView f40037a;

    C13054i(TextView view) {
        this.f40037a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super C13051f> subscriber) {
        C14521b.verifyMainThread();
        TextWatcher watcher = new C13052g(this, subscriber);
        subscriber.add(new C13053h(this, watcher));
        this.f40037a.addTextChangedListener(watcher);
        TextView textView = this.f40037a;
        subscriber.onNext(C13051f.m42505a(textView, textView.getEditableText()));
    }
}
