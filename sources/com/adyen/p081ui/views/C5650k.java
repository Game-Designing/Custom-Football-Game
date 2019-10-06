package com.adyen.p081ui.views;

import android.graphics.drawable.Drawable;

/* renamed from: com.adyen.ui.views.k */
/* compiled from: CheckoutCheckBox */
class C5650k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Drawable f9571a;

    /* renamed from: b */
    final /* synthetic */ CheckoutCheckBox f9572b;

    C5650k(CheckoutCheckBox this$0, Drawable drawable) {
        this.f9572b = this$0;
        this.f9571a = drawable;
    }

    public void run() {
        this.f9571a.setState(new int[0]);
    }
}
