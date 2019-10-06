package com.adyen.p081ui.views;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.inputmethod.InputMethodManager;

/* renamed from: com.adyen.ui.views.d */
/* compiled from: CVCDialog */
class C5642d implements OnShowListener {

    /* renamed from: a */
    final /* synthetic */ CVCEditText f9559a;

    /* renamed from: b */
    final /* synthetic */ C5644f f9560b;

    C5642d(C5644f this$0, CVCEditText cVCEditText) {
        this.f9560b = this$0;
        this.f9559a = cVCEditText;
    }

    public void onShow(DialogInterface dialog) {
        ((InputMethodManager) this.f9560b.getContext().getSystemService("input_method")).showSoftInput(this.f9559a, 2);
        this.f9559a.requestFocus();
    }
}
