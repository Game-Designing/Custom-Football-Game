package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.exceptions.IntentNotResolvableException;

public enum UrlAction {
    HANDLE_MOPUB_SCHEME(false),
    HANDLE_PHONE_SCHEME(true),
    OPEN_NATIVE_BROWSER(true),
    OPEN_APP_MARKET(true),
    OPEN_IN_APP_BROWSER(true),
    HANDLE_SHARE_TWEET(true),
    FOLLOW_DEEP_LINK_WITH_FALLBACK(true),
    FOLLOW_DEEP_LINK(true),
    NOOP(false);
    

    /* renamed from: b */
    private final boolean f34355b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException;

    public abstract boolean shouldTryHandlingUrl(Uri uri);

    public void handleUrl(UrlHandler urlHandler, Context context, Uri destinationUri, boolean fromUserInteraction, String creativeId) throws IntentNotResolvableException {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Ad event URL: ");
        sb.append(destinationUri);
        MoPubLog.log(sdkLogEvent, sb.toString());
        if (!this.f34355b || fromUserInteraction) {
            mo36396a(context, destinationUri, urlHandler, creativeId);
            return;
        }
        throw new IntentNotResolvableException("Attempted to handle action without user interaction.");
    }

    private UrlAction(boolean requiresUserInteraction) {
        this.f34355b = requiresUserInteraction;
    }
}
