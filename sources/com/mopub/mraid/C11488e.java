package com.mopub.mraid;

import com.mopub.mraid.MraidBridge.MraidWebView.OnVisibilityChangedListener;

/* renamed from: com.mopub.mraid.e */
/* compiled from: MraidBridge */
class C11488e implements OnVisibilityChangedListener {

    /* renamed from: a */
    final /* synthetic */ MraidBridge f35565a;

    C11488e(MraidBridge this$0) {
        this.f35565a = this$0;
    }

    public void onVisibilityChanged(boolean isVisible) {
        if (this.f35565a.f35485d != null) {
            this.f35565a.f35485d.onVisibilityChanged(isVisible);
        }
    }
}
