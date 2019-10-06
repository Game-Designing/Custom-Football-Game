package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.ResultActions;

/* renamed from: com.mopub.nativeads.oa */
/* compiled from: NativeClickHandler */
class C11629oa implements ResultActions {

    /* renamed from: a */
    final /* synthetic */ View f36205a;

    /* renamed from: b */
    final /* synthetic */ C11663zb f36206b;

    /* renamed from: c */
    final /* synthetic */ NativeClickHandler f36207c;

    C11629oa(NativeClickHandler this$0, View view, C11663zb zbVar) {
        this.f36207c = this$0;
        this.f36205a = view;
        this.f36206b = zbVar;
    }

    public void urlHandlingSucceeded(String url, UrlAction urlAction) {
        m38458a();
        this.f36207c.f35929c = false;
    }

    public void urlHandlingFailed(String url, UrlAction lastFailedUrlAction) {
        m38458a();
        this.f36207c.f35929c = false;
    }

    /* renamed from: a */
    private void m38458a() {
        if (this.f36205a != null) {
            this.f36206b.mo38195a();
        }
    }
}
