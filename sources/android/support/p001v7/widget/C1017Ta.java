package android.support.p001v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: android.support.v7.widget.Ta */
/* compiled from: SearchView */
class C1017Ta implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ SearchView f3373a;

    C1017Ta(SearchView this$0) {
        this.f3373a = this$0;
    }

    public void beforeTextChanged(CharSequence s, int start, int before, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int after) {
        this.f3373a.onTextChanged(s);
    }

    public void afterTextChanged(Editable s) {
    }
}
