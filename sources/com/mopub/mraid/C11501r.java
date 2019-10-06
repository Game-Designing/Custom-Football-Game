package com.mopub.mraid;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: com.mopub.mraid.r */
/* compiled from: MraidController */
class C11501r implements OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ View f35580a;

    /* renamed from: b */
    final /* synthetic */ C11502s f35581b;

    C11501r(C11502s this$1, View view) {
        this.f35581b = this$1;
        this.f35580a = view;
    }

    public boolean onPreDraw() {
        this.f35580a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f35581b.f35582a.m38028b();
        return true;
    }
}
