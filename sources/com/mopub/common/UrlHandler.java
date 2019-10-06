package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.util.EnumSet;
import java.util.Iterator;

public class UrlHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final ResultActions f34356a = new C11233I();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final MoPubSchemeListener f34357b = new C11234J();

    /* renamed from: c */
    private EnumSet<UrlAction> f34358c;

    /* renamed from: d */
    private ResultActions f34359d;

    /* renamed from: e */
    private MoPubSchemeListener f34360e;

    /* renamed from: f */
    private String f34361f;

    /* renamed from: g */
    private boolean f34362g;

    /* renamed from: h */
    private boolean f34363h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f34364i;

    public static class Builder {

        /* renamed from: a */
        private EnumSet<UrlAction> f34365a = EnumSet.of(UrlAction.NOOP);

        /* renamed from: b */
        private ResultActions f34366b = UrlHandler.f34356a;

        /* renamed from: c */
        private MoPubSchemeListener f34367c = UrlHandler.f34357b;

        /* renamed from: d */
        private boolean f34368d = false;

        /* renamed from: e */
        private String f34369e;

        public Builder withSupportedUrlActions(UrlAction first, UrlAction... others) {
            this.f34365a = EnumSet.of(first, others);
            return this;
        }

        public Builder withSupportedUrlActions(EnumSet<UrlAction> supportedUrlActions) {
            this.f34365a = EnumSet.copyOf(supportedUrlActions);
            return this;
        }

        public Builder withResultActions(ResultActions resultActions) {
            this.f34366b = resultActions;
            return this;
        }

        public Builder withMoPubSchemeListener(MoPubSchemeListener moPubSchemeListener) {
            this.f34367c = moPubSchemeListener;
            return this;
        }

        public Builder withoutMoPubBrowser() {
            this.f34368d = true;
            return this;
        }

        public Builder withDspCreativeId(String creativeId) {
            this.f34369e = creativeId;
            return this;
        }

        public UrlHandler build() {
            UrlHandler urlHandler = new UrlHandler(this.f34365a, this.f34366b, this.f34367c, this.f34368d, this.f34369e, null);
            return urlHandler;
        }
    }

    public interface MoPubSchemeListener {
        void onClose();

        void onCrash();

        void onFailLoad();

        void onFinishLoad();
    }

    public interface ResultActions {
        void urlHandlingFailed(String str, UrlAction urlAction);

        void urlHandlingSucceeded(String str, UrlAction urlAction);
    }

    /* synthetic */ UrlHandler(EnumSet x0, ResultActions x1, MoPubSchemeListener x2, boolean x3, String x4, C11233I x5) {
        this(x0, x1, x2, x3, x4);
    }

    private UrlHandler(EnumSet<UrlAction> supportedUrlActions, ResultActions resultActions, MoPubSchemeListener moPubSchemeListener, boolean skipShowMoPubBrowser, String dspCreativeId) {
        this.f34358c = EnumSet.copyOf(supportedUrlActions);
        this.f34359d = resultActions;
        this.f34360e = moPubSchemeListener;
        this.f34362g = skipShowMoPubBrowser;
        this.f34361f = dspCreativeId;
        this.f34363h = false;
        this.f34364i = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public MoPubSchemeListener mo36603c() {
        return this.f34360e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo36604d() {
        return this.f34362g;
    }

    public void handleUrl(Context context, String destinationUrl) {
        Preconditions.checkNotNull(context);
        handleUrl(context, destinationUrl, true);
    }

    public void handleUrl(Context context, String destinationUrl, boolean fromUserInteraction) {
        Preconditions.checkNotNull(context);
        handleUrl(context, destinationUrl, fromUserInteraction, null);
    }

    public void handleUrl(Context context, String destinationUrl, boolean fromUserInteraction, Iterable<String> trackingUrls) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(destinationUrl)) {
            m37046a(destinationUrl, null, "Attempted to handle empty url.", null);
            return;
        }
        C11235K k = new C11235K(this, context, fromUserInteraction, trackingUrls, destinationUrl);
        UrlResolutionTask.getResolvedUrl(destinationUrl, k);
        this.f34364i = true;
    }

    public boolean handleResolvedUrl(Context context, String url, boolean fromUserInteraction, Iterable<String> trackingUrls) {
        String str = url;
        if (TextUtils.isEmpty(url)) {
            m37046a(str, null, "Attempted to handle empty url.", null);
            return false;
        }
        UrlAction lastFailedUrlAction = UrlAction.NOOP;
        Uri destinationUri = Uri.parse(url);
        Iterator it = this.f34358c.iterator();
        UrlAction lastFailedUrlAction2 = lastFailedUrlAction;
        while (it.hasNext()) {
            UrlAction urlAction = (UrlAction) it.next();
            if (urlAction.shouldTryHandlingUrl(destinationUri)) {
                try {
                    urlAction.handleUrl(this, context, destinationUri, fromUserInteraction, this.f34361f);
                    if (this.f34363h || this.f34364i) {
                        Context context2 = context;
                        Iterable<String> iterable = trackingUrls;
                    } else if (UrlAction.IGNORE_ABOUT_SCHEME.equals(urlAction)) {
                        Context context3 = context;
                        Iterable<String> iterable2 = trackingUrls;
                    } else if (!UrlAction.HANDLE_MOPUB_SCHEME.equals(urlAction)) {
                        try {
                            TrackingRequest.makeTrackingHttpRequest(trackingUrls, context);
                            this.f34359d.urlHandlingSucceeded(destinationUri.toString(), urlAction);
                            this.f34363h = true;
                        } catch (IntentNotResolvableException e) {
                            e = e;
                        }
                    } else {
                        Context context4 = context;
                        Iterable<String> iterable3 = trackingUrls;
                    }
                    return true;
                } catch (IntentNotResolvableException e2) {
                    e = e2;
                    Context context5 = context;
                    Iterable<String> iterable4 = trackingUrls;
                    MoPubLog.log(SdkLogEvent.ERROR, e.getMessage(), e);
                    lastFailedUrlAction2 = urlAction;
                }
            } else {
                Context context6 = context;
                Iterable<String> iterable5 = trackingUrls;
            }
        }
        Context context7 = context;
        Iterable<String> iterable6 = trackingUrls;
        StringBuilder sb = new StringBuilder();
        sb.append("Link ignored. Unable to handle url: ");
        sb.append(str);
        m37046a(str, lastFailedUrlAction2, sb.toString(), null);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37046a(String url, UrlAction urlAction, String message, Throwable throwable) {
        Preconditions.checkNotNull(message);
        if (urlAction == null) {
            urlAction = UrlAction.NOOP;
        }
        MoPubLog.log(SdkLogEvent.ERROR, message, throwable);
        this.f34359d.urlHandlingFailed(url, urlAction);
    }
}
