package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.UrlHandler.MoPubSchemeListener;
import com.mopub.exceptions.IntentNotResolvableException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.z */
/* compiled from: UrlAction */
class C11295z extends UrlAction {
    C11295z(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return BuildConfig.SDK_NAME.equalsIgnoreCase(uri.getScheme());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        String host = uri.getHost();
        MoPubSchemeListener moPubSchemeListener = urlHandler.mo36603c();
        if ("finishLoad".equalsIgnoreCase(host)) {
            moPubSchemeListener.onFinishLoad();
        } else if ("close".equalsIgnoreCase(host)) {
            moPubSchemeListener.onClose();
        } else if ("failLoad".equalsIgnoreCase(host)) {
            moPubSchemeListener.onFailLoad();
        } else if ("crash".equals(host)) {
            moPubSchemeListener.onCrash();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not handle MoPub Scheme url: ");
            sb.append(uri);
            throw new IntentNotResolvableException(sb.toString());
        }
    }
}
