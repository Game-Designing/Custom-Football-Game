package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.F */
/* compiled from: UrlAction */
class C11229F extends UrlAction {
    C11229F(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        Preconditions.checkNotNull(uri);
        if ("mopubshare".equalsIgnoreCase(uri.getScheme())) {
            if ("tweet".equalsIgnoreCase(uri.getHost())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        String str = "Share via";
        StringBuilder sb = new StringBuilder();
        sb.append("Could not handle share tweet intent with URI ");
        sb.append(uri);
        String errorMessage = sb.toString();
        try {
            Intents.launchIntentForUserClick(context, Intent.createChooser(Intents.intentForShareTweet(uri), "Share via"), errorMessage);
        } catch (UrlParseException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(errorMessage);
            sb2.append("\n\t");
            sb2.append(e.getMessage());
            throw new IntentNotResolvableException(sb2.toString());
        }
    }
}
