package p019d.p022i.p296a.p306d;

import android.text.Editable;
import android.text.TextWatcher;
import p026rx.C14980ia;

/* renamed from: d.i.a.d.g */
/* compiled from: TextViewAfterTextChangeEventOnSubscribe */
class C13052g implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40033a;

    /* renamed from: b */
    final /* synthetic */ C13054i f40034b;

    C13052g(C13054i this$0, C14980ia iaVar) {
        this.f40034b = this$0;
        this.f40033a = iaVar;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        if (!this.f40033a.isUnsubscribed()) {
            this.f40033a.onNext(C13051f.m42505a(this.f40034b.f40037a, s));
        }
    }
}
