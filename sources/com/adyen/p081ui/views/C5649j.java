package com.adyen.p081ui.views;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.adyen.ui.views.j */
/* compiled from: CardHolderEditText */
class C5649j implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CardHolderEditText f9570a;

    C5649j(CardHolderEditText this$0) {
        this.f9570a = this$0;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        if (this.f9570a.f9534a != null) {
            this.f9570a.f9534a.mo17782a(this.f9570a, !s.toString().isEmpty());
        }
    }
}
