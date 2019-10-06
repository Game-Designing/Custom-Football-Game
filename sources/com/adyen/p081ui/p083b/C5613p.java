package com.adyen.p081ui.p083b;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListView;

/* renamed from: com.adyen.ui.b.p */
/* compiled from: PaymentMethodSelectionFragment */
class C5613p implements OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ListView f9494a;

    /* renamed from: b */
    final /* synthetic */ C5614q f9495b;

    C5613p(C5614q this$0, ListView listView) {
        this.f9495b = this$0;
        this.f9494a = listView;
    }

    public void onGlobalLayout() {
        this.f9494a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.f9495b.m9899a(this.f9494a, false);
    }
}
