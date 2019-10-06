package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: com.mopub.nativeads.K */
/* compiled from: MoPubAdAdapter */
class C11539K implements OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ OnItemSelectedListener f35758a;

    /* renamed from: b */
    final /* synthetic */ MoPubAdAdapter f35759b;

    C11539K(MoPubAdAdapter this$0, OnItemSelectedListener onItemSelectedListener) {
        this.f35759b = this$0;
        this.f35758a = onItemSelectedListener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if (!this.f35759b.isAd(position)) {
            this.f35758a.onItemSelected(adapterView, view, this.f35759b.f35816c.getOriginalPosition(position), id);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f35758a.onNothingSelected(adapterView);
    }
}
