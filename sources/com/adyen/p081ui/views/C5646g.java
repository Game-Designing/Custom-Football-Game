package com.adyen.p081ui.views;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.adyen.ui.views.g */
/* compiled from: CVCEditText */
class C5646g implements InputFilter {

    /* renamed from: a */
    final /* synthetic */ CVCEditText f9567a;

    C5646g(CVCEditText this$0) {
        this.f9567a = this$0;
    }

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (!source.toString().matches(".*\\d.*")) {
            return "";
        }
        return source;
    }
}
