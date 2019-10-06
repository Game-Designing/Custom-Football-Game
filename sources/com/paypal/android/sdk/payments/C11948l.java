package com.paypal.android.sdk.payments;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.paypal.android.sdk.payments.l */
final class C11948l implements TextWatcher {

    /* renamed from: a */
    private /* synthetic */ LoginActivity f37574a;

    C11948l(LoginActivity loginActivity) {
        this.f37574a = loginActivity;
    }

    public final void afterTextChanged(Editable editable) {
        this.f37574a.m39286h();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
