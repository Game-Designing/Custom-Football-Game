package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.exceptions.IntentNotResolvableException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.A */
/* compiled from: UrlAction */
class C11216A extends UrlAction {
    C11216A(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return "about".equalsIgnoreCase(uri.getScheme());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        MoPubLog.log(SdkLogEvent.CUSTOM, "Link to about page ignored.");
    }
}
