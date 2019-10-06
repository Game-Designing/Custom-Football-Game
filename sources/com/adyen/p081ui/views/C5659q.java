package com.adyen.p081ui.views;

import android.support.p000v4.content.C0510b;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.adyen.p081ui.C5572a;

/* renamed from: com.adyen.ui.views.q */
/* compiled from: ExpiryDateEditText */
class C5659q implements OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ExpiryDateEditText f9592a;

    C5659q(ExpiryDateEditText this$0) {
        this.f9592a = this$0;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            ExpiryDateEditText expiryDateEditText = this.f9592a;
            expiryDateEditText.setTextColor(C0510b.m2564a(expiryDateEditText.getContext(), C5572a.black_text));
            return;
        }
        ExpiryDateEditText expiryDateEditText2 = this.f9592a;
        if (!expiryDateEditText2.m9957a(expiryDateEditText2.getText().toString())) {
            ExpiryDateEditText expiryDateEditText3 = this.f9592a;
            expiryDateEditText3.setTextColor(C0510b.m2564a(expiryDateEditText3.getContext(), C5572a.red_invalid_input_highlight));
        }
    }
}
