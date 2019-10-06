package com.adyen.p081ui.views;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* renamed from: com.adyen.ui.views.e */
/* compiled from: CVCDialog */
class C5643e implements OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C5644f f9561a;

    C5643e(C5644f this$0) {
        this.f9561a = this$0;
    }

    public void onDismiss(DialogInterface dialog) {
        if (this.f9561a.f9566e.getWindow() != null) {
            this.f9561a.f9566e.getWindow().setSoftInputMode(3);
        }
    }
}
