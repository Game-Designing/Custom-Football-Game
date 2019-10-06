package com.paypal.android.sdk.payments;

import android.text.style.URLSpan;
import android.view.View;

/* renamed from: com.paypal.android.sdk.payments.eb */
final class C11929eb extends URLSpan {

    /* renamed from: a */
    private C11920ca f37545a;

    C11929eb(URLSpan uRLSpan, C11920ca caVar) {
        super(uRLSpan.getURL());
        this.f37545a = caVar;
    }

    public final void onClick(View view) {
        this.f37545a.mo39084a();
        super.onClick(view);
    }
}
