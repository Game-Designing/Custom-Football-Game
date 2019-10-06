package com.mopub.nativeads;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;

/* renamed from: com.mopub.nativeads.Ba */
/* compiled from: NativeVideoViewController */
class C11515Ba implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f35614a;

    C11515Ba(NativeVideoViewController this$0) {
        this.f35614a = this$0;
    }

    public void onClick(View v) {
        this.f35614a.f35997h.setPlayWhenReady(false);
        NativeVideoViewController nativeVideoViewController = this.f35614a;
        nativeVideoViewController.f35998i = nativeVideoViewController.f35996g.getTextureView().getBitmap();
        String url = this.f35614a.f35995f.getPrivacyInformationIconClickthroughUrl();
        if (TextUtils.isEmpty(url)) {
            url = "https://www.mopub.com/optout/";
        }
        new Builder().withSupportedUrlActions(UrlAction.OPEN_IN_APP_BROWSER, new UrlAction[0]).build().handleUrl(this.f35614a.mo36929b(), url);
    }
}
