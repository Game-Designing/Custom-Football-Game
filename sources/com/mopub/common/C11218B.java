package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.B */
/* compiled from: UrlAction */
class C11218B extends UrlAction {
    C11218B(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        String scheme = uri.getScheme();
        return "tel".equalsIgnoreCase(scheme) || "voicemail".equalsIgnoreCase(scheme) || "sms".equalsIgnoreCase(scheme) || "mailto".equalsIgnoreCase(scheme) || "geo".equalsIgnoreCase(scheme) || "google.streetview".equalsIgnoreCase(scheme);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        StringBuilder sb = new StringBuilder();
        sb.append("Could not handle intent with URI: ");
        sb.append(uri);
        sb.append("\n\tIs this intent supported on your phone?");
        Intents.launchActionViewIntent(context, uri, sb.toString());
    }
}
