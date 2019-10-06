package p019d.p022i.p296a.p306d;

import android.text.TextWatcher;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.d.h */
/* compiled from: TextViewAfterTextChangeEventOnSubscribe */
class C13053h extends C14521b {

    /* renamed from: a */
    final /* synthetic */ TextWatcher f40035a;

    /* renamed from: b */
    final /* synthetic */ C13054i f40036b;

    C13053h(C13054i this$0, TextWatcher textWatcher) {
        this.f40036b = this$0;
        this.f40035a = textWatcher;
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribe() {
        this.f40036b.f40037a.removeTextChangedListener(this.f40035a);
    }
}
