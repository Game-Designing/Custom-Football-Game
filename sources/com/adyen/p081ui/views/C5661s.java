package com.adyen.p081ui.views;

import android.text.Editable;
import android.text.TextWatcher;
import com.adyen.utils.Iban;

/* renamed from: com.adyen.ui.views.s */
/* compiled from: IBANEditText */
class C5661s implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ IBANEditText f9594a;

    C5661s(IBANEditText this$0) {
        this.f9594a = this$0;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        if (this.f9594a.f9551a != null) {
            String str = "";
            String str2 = " ";
            if (s.toString().replaceAll(str2, str).length() > 2) {
                this.f9594a.f9551a.mo17782a(this.f9594a, Iban.validate(s.toString().replaceAll(str2, str)));
                return;
            }
            this.f9594a.f9551a.mo17782a(this.f9594a, false);
        }
    }
}
