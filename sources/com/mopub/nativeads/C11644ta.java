package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;

/* renamed from: com.mopub.nativeads.ta */
/* compiled from: NativeRendererHelper */
class C11644ta implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f36237a;

    /* renamed from: b */
    final /* synthetic */ String f36238b;

    C11644ta(Context context, String str) {
        this.f36237a = context;
        this.f36238b = str;
    }

    public void onClick(View v) {
        new Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).build().handleUrl(this.f36237a, this.f36238b);
    }
}
