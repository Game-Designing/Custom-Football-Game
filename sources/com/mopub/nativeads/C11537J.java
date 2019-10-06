package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

/* renamed from: com.mopub.nativeads.J */
/* compiled from: MoPubAdAdapter */
class C11537J implements OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ OnItemLongClickListener f35755a;

    /* renamed from: b */
    final /* synthetic */ MoPubAdAdapter f35756b;

    C11537J(MoPubAdAdapter this$0, OnItemLongClickListener onItemLongClickListener) {
        this.f35756b = this$0;
        this.f35755a = onItemLongClickListener;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (!this.f35756b.isAd(position)) {
            if (!this.f35755a.onItemLongClick(adapterView, view, this.f35756b.f35816c.getOriginalPosition(position), id)) {
                return false;
            }
        }
        return true;
    }
}
