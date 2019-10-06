package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.MoPub.BrowserAgent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.C */
/* compiled from: UrlAction */
class C11219C extends UrlAction {
    C11219C(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        String scheme = uri.getScheme();
        if (!Constants.HTTP.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            return "mopubnativebrowser".equalsIgnoreCase(scheme);
        }
        return MoPub.getBrowserAgent() == BrowserAgent.NATIVE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to load mopub native browser url: ");
        sb.append(uri);
        String errorMessage = sb.toString();
        try {
            Intents.launchIntentForUserClick(context, Intents.intentForNativeBrowserScheme(uri), errorMessage);
        } catch (UrlParseException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(errorMessage);
            sb2.append("\n\t");
            sb2.append(e.getMessage());
            throw new IntentNotResolvableException(sb2.toString());
        }
    }
}
