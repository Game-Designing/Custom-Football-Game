package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.exceptions.IntentNotResolvableException;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.y */
/* compiled from: UrlAction */
class C11294y extends UrlAction {
    C11294y(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
    }
}
