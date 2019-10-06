package com.braintreepayments.cardform.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: com.braintreepayments.cardform.view.e */
/* compiled from: ExpirationDateDialog */
class C5904e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f10315a;

    /* renamed from: b */
    final /* synthetic */ C5906g f10316b;

    C5904e(C5906g this$0, View view) {
        this.f10316b = this$0;
        this.f10315a = view;
    }

    public void run() {
        ((InputMethodManager) this.f10316b.getContext().getSystemService("input_method")).showSoftInput(this.f10315a, 0);
    }
}
