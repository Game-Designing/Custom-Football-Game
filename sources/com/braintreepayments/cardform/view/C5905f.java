package com.braintreepayments.cardform.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: com.braintreepayments.cardform.view.f */
/* compiled from: ExpirationDateDialog */
class C5905f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f10317a;

    /* renamed from: b */
    final /* synthetic */ C5906g f10318b;

    C5905f(C5906g this$0, View view) {
        this.f10318b = this$0;
        this.f10317a = view;
    }

    public void run() {
        ((InputMethodManager) this.f10318b.getContext().getSystemService("input_method")).showSoftInput(this.f10317a, 0);
    }
}
