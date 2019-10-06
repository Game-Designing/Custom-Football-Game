package com.mopub.nativeads;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.mopub.nativeads.Aa */
/* compiled from: NativeVideoViewController */
class C11511Aa implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f35588a;

    C11511Aa(NativeVideoViewController this$0) {
        this.f35588a = this$0;
    }

    public void onClick(View v) {
        this.f35588a.f35997h.setPlayWhenReady(false);
        NativeVideoViewController nativeVideoViewController = this.f35588a;
        nativeVideoViewController.f35998i = nativeVideoViewController.f35996g.getTextureView().getBitmap();
        this.f35588a.f35997h.handleCtaClick((Activity) this.f35588a.mo36929b());
    }
}
