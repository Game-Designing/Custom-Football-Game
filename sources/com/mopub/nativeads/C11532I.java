package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: com.mopub.nativeads.I */
/* compiled from: MoPubAdAdapter */
class C11532I implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ OnItemClickListener f35679a;

    /* renamed from: b */
    final /* synthetic */ MoPubAdAdapter f35680b;

    C11532I(MoPubAdAdapter this$0, OnItemClickListener onItemClickListener) {
        this.f35680b = this$0;
        this.f35679a = onItemClickListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (!this.f35680b.f35816c.isAd(position)) {
            this.f35679a.onItemClick(adapterView, view, this.f35680b.f35816c.getOriginalPosition(position), id);
        }
    }
}
