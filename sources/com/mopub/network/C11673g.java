package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.MoPubError;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mopub.network.g */
/* compiled from: ContentDownloadAnalytics */
class C11673g {

    /* renamed from: a */
    Long f36393a = null;

    /* renamed from: b */
    private AdResponse f36394b;

    /* renamed from: com.mopub.network.g$a */
    /* compiled from: ContentDownloadAnalytics */
    enum C11674a {
        AD_LOADED("ad_loaded"),
        MISSING_ADAPTER("missing_adapter"),
        TIMEOUT("timeout"),
        INVALID_DATA("invalid_data");
        
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final String f36396b;

        private C11674a(String loadResult) {
            this.f36396b = loadResult;
        }
    }

    C11673g(AdResponse adResponse) {
        Preconditions.checkNotNull(adResponse);
        this.f36394b = adResponse;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo38335b(Context context) {
        if (context != null) {
            String url = this.f36394b.getBeforeLoadUrl();
            if (!TextUtils.isEmpty(url)) {
                this.f36393a = Long.valueOf(SystemClock.uptimeMillis());
                TrackingRequest.makeTrackingHttpRequest(url, context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38334a(Context context, MoPubError errorCode) {
        if (context != null && this.f36393a != null) {
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) m38564a(this.f36394b.getAfterLoadUrls(), m38563a(errorCode).f36396b), context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38333a(Context context) {
        if (context != null && this.f36393a != null) {
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) m38564a(this.f36394b.getAfterLoadSuccessUrls(), C11674a.AD_LOADED.f36396b), context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo38336b(Context context, MoPubError errorCode) {
        if (context != null && this.f36393a != null) {
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) m38564a(this.f36394b.getAfterLoadFailUrls(), m38563a(errorCode).f36396b), context);
        }
    }

    /* renamed from: a */
    private List<String> m38564a(List<String> urls, String loadResult) {
        if (urls == null || urls.isEmpty() || this.f36393a == null) {
            return null;
        }
        List<String> newUrls = new ArrayList<>();
        for (String url : urls) {
            String str = "%%LOAD_RESULT%%";
            newUrls.add(url.replace("%%LOAD_DURATION_MS%%", String.valueOf(SystemClock.uptimeMillis() - this.f36393a.longValue())).replace(str, Uri.encode(loadResult)));
        }
        return newUrls;
    }

    /* renamed from: a */
    private C11674a m38563a(MoPubError errorCode) {
        if (errorCode == null) {
            return C11674a.AD_LOADED;
        }
        int intCode = errorCode.getIntCode();
        if (intCode == 0) {
            return C11674a.AD_LOADED;
        }
        if (intCode == 1) {
            return C11674a.MISSING_ADAPTER;
        }
        if (intCode != 2) {
            return C11674a.INVALID_DATA;
        }
        return C11674a.TIMEOUT;
    }
}
