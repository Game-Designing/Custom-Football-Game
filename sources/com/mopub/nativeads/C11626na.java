package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.mopub.nativeads.na */
/* compiled from: NativeClickHandler */
class C11626na implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ClickInterface f36198a;

    /* renamed from: b */
    final /* synthetic */ NativeClickHandler f36199b;

    C11626na(NativeClickHandler this$0, ClickInterface clickInterface) {
        this.f36199b = this$0;
        this.f36198a = clickInterface;
    }

    public void onClick(View v) {
        this.f36198a.handleClick(v);
    }
}
