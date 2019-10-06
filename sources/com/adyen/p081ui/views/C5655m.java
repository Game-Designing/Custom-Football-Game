package com.adyen.p081ui.views;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.adyen.ui.views.m */
/* compiled from: CreditCardEditText */
class C5655m implements InputFilter {

    /* renamed from: a */
    final /* synthetic */ CreditCardEditText f9588a;

    C5655m(CreditCardEditText this$0) {
        this.f9588a = this$0;
    }

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        char[] charArray;
        for (char c : source.toString().toCharArray()) {
            if (!Character.isDigit(c) && !Character.isWhitespace(c)) {
                return "";
            }
        }
        return source;
    }
}
