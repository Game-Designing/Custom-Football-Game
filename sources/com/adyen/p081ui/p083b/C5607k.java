package com.adyen.p081ui.p083b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import p019d.p135a.p136a.p139c.p140a.C6881c.C6882a;

/* renamed from: com.adyen.ui.b.k */
/* compiled from: IssuerSelectionFragment */
class C5607k implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C5608l f9483a;

    C5607k(C5608l this$0) {
        this.f9483a = this$0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        this.f9483a.f9485b.mo17723a(((C6882a) this.f9483a.f9486c.get(i)).mo22315a());
    }
}
