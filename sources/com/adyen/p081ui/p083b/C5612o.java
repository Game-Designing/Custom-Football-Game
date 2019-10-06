package com.adyen.p081ui.p083b;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListView;

/* renamed from: com.adyen.ui.b.o */
/* compiled from: PaymentMethodSelectionFragment */
class C5612o implements OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ListView f9492a;

    /* renamed from: b */
    final /* synthetic */ C5614q f9493b;

    C5612o(C5614q this$0, ListView listView) {
        this.f9493b = this$0;
        this.f9492a = listView;
    }

    public void onGlobalLayout() {
        this.f9492a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.f9493b.m9899a(this.f9492a, true);
    }
}
