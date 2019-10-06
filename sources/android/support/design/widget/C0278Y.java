package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: android.support.design.widget.Y */
/* compiled from: TextInputLayout */
class C0278Y implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ TextInputLayout f1072a;

    C0278Y(TextInputLayout this$0) {
        this.f1072a = this$0;
    }

    public void afterTextChanged(Editable s) {
        TextInputLayout textInputLayout = this.f1072a;
        textInputLayout.updateLabelState(!textInputLayout.mRestoringSavedState);
        TextInputLayout textInputLayout2 = this.f1072a;
        if (textInputLayout2.mCounterEnabled) {
            textInputLayout2.updateCounter(s.length());
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}
