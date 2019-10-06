package com.braintreepayments.cardform.view;

import android.app.Activity;

/* renamed from: com.braintreepayments.cardform.view.d */
/* compiled from: ExpirationDateDialog */
class C5903d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5906g f10314a;

    C5903d(C5906g this$0) {
        this.f10314a = this$0;
    }

    public void run() {
        Activity ownerActivity = this.f10314a.getOwnerActivity();
        if (this.f10314a.f10324f.isFocused() && ownerActivity != null && !ownerActivity.isFinishing()) {
            C5903d.super.show();
        }
    }
}
