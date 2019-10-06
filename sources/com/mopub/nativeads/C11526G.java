package com.mopub.nativeads;

import android.database.DataSetObserver;

/* renamed from: com.mopub.nativeads.G */
/* compiled from: MoPubAdAdapter */
class C11526G extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ MoPubAdAdapter f35643a;

    C11526G(MoPubAdAdapter this$0) {
        this.f35643a = this$0;
    }

    public void onChanged() {
        this.f35643a.f35816c.setItemCount(this.f35643a.f35815b.getCount());
        this.f35643a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f35643a.notifyDataSetInvalidated();
    }
}
