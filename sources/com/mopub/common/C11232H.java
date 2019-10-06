package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.net.URISyntaxException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.H */
/* compiled from: UrlAction */
class C11232H extends UrlAction {
    C11232H(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return !TextUtils.isEmpty(uri.getScheme());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        if (Constants.INTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
            try {
                Intents.launchApplicationIntent(context, Intent.parseUri(uri.toString(), 1));
            } catch (URISyntaxException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Intent uri had invalid syntax: ");
                sb.append(uri.toString());
                throw new IntentNotResolvableException(sb.toString());
            }
        } else {
            Intents.launchApplicationUrl(context, uri);
        }
    }
}
