package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.util.List;

/* 'enum' access flag removed */
/* renamed from: com.mopub.common.G */
/* compiled from: UrlAction */
class C11230G extends UrlAction {
    C11230G(String str, int i, boolean requiresUserInteraction) {
        super(str, i, requiresUserInteraction, null);
    }

    public boolean shouldTryHandlingUrl(Uri uri) {
        return "deeplink+".equalsIgnoreCase(uri.getScheme());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36396a(Context context, Uri uri, UrlHandler urlHandler, String creativeId) throws IntentNotResolvableException {
        if ("navigate".equalsIgnoreCase(uri.getHost())) {
            try {
                String primaryUrl = uri.getQueryParameter("primaryUrl");
                List<String> primaryTrackingUrls = uri.getQueryParameters("primaryTrackingUrl");
                String fallbackUrl = uri.getQueryParameter("fallbackUrl");
                List<String> fallbackTrackingUrls = uri.getQueryParameters("fallbackTrackingUrl");
                if (primaryUrl != null) {
                    Uri primaryUri = Uri.parse(primaryUrl);
                    if (!shouldTryHandlingUrl(primaryUri)) {
                        try {
                            Intents.launchApplicationUrl(context, primaryUri);
                            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) primaryTrackingUrls, context);
                        } catch (IntentNotResolvableException e) {
                            if (fallbackUrl == null) {
                                throw new IntentNotResolvableException("Unable to handle 'primaryUrl' for Deeplink+ and 'fallbackUrl' was missing.");
                            } else if (!shouldTryHandlingUrl(Uri.parse(fallbackUrl))) {
                                urlHandler.handleUrl(context, fallbackUrl, true, fallbackTrackingUrls);
                            } else {
                                throw new IntentNotResolvableException("Deeplink+ URL had another Deeplink+ URL as the 'fallbackUrl'.");
                            }
                        }
                    } else {
                        throw new IntentNotResolvableException("Deeplink+ had another Deeplink+ as the 'primaryUrl'.");
                    }
                } else {
                    throw new IntentNotResolvableException("Deeplink+ did not have 'primaryUrl' query param.");
                }
            } catch (UnsupportedOperationException e2) {
                throw new IntentNotResolvableException("Deeplink+ URL was not a hierarchical URI.");
            }
        } else {
            throw new IntentNotResolvableException("Deeplink+ URL did not have 'navigate' as the host.");
        }
    }
}
