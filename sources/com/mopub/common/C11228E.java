package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.E */
/* compiled from: UrlAction */
class C11228E extends UrlAction {
    C11228E(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        String scheme = uri.getScheme();
        return Constants.HTTP.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        if (!urlHandler.mo36604d()) {
            Intents.showMoPubBrowserForUrl(context, uri, creativeId);
        }
    }
}
