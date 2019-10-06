package com.adyen.p081ui.views;

import android.support.p000v4.content.C0510b;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.adyen.p081ui.C5572a;

/* renamed from: com.adyen.ui.views.n */
/* compiled from: CreditCardEditText */
class C5656n implements OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ CreditCardEditText f9589a;

    C5656n(CreditCardEditText this$0) {
        this.f9589a = this$0;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            CreditCardEditText creditCardEditText = this.f9589a;
            creditCardEditText.setTextColor(C0510b.m2564a(creditCardEditText.getContext(), C5572a.black_text));
            return;
        }
        CreditCardEditText creditCardEditText2 = this.f9589a;
        if (!creditCardEditText2.m9947b(creditCardEditText2.getCCNumber())) {
            CreditCardEditText creditCardEditText3 = this.f9589a;
            creditCardEditText3.setTextColor(C0510b.m2564a(creditCardEditText3.getContext(), C5572a.red_invalid_input_highlight));
        }
    }
}
