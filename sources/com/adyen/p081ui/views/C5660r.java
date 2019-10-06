package com.adyen.p081ui.views;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.adyen.ui.views.r */
/* compiled from: IBANEditText */
class C5660r implements InputFilter {

    /* renamed from: a */
    final /* synthetic */ IBANEditText f9593a;

    C5660r(IBANEditText this$0) {
        this.f9593a = this$0;
    }

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        char[] charArray;
        for (char c : source.toString().toCharArray()) {
            if (!Character.isDigit(c) && !Character.isWhitespace(c) && !Character.isLetter(c)) {
                return "";
            }
        }
        return source;
    }
}
