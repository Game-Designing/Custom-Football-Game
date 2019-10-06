package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.network.AdLoader;
import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.SingleImpression;
import com.mopub.network.TrackingRequest;
import java.util.Collections;
import java.util.List;

/* renamed from: com.mopub.mobileads.b */
/* compiled from: AdLoaderRewardedVideo */
class C11383b extends AdLoader {

    /* renamed from: m */
    private boolean f35217m = false;

    /* renamed from: n */
    private boolean f35218n = false;

    C11383b(String url, AdFormat adFormat, String adUnitId, Context context, Listener listener) {
        super(url, adFormat, adUnitId, context, listener);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<String> mo37449b() {
        AdResponse adResponse = this.f36281g;
        if (adResponse != null) {
            return adResponse.getImpressionTrackingUrls();
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo37447a() {
        AdResponse adResponse = this.f36281g;
        if (adResponse != null) {
            return adResponse.getClickTrackingUrl();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public AdResponse mo37451c() {
        return this.f36281g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37450b(Context context) {
        Preconditions.checkNotNull(context);
        if (this.f36281g != null && !this.f35217m) {
            this.f35217m = true;
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) mo37449b(), context);
            new SingleImpression(this.f36281g.getAdUnitId(), this.f36281g.getImpressionData()).sendImpression();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37448a(Context context) {
        Preconditions.checkNotNull(context);
        if (this.f36281g != null && !this.f35218n) {
            this.f35218n = true;
            TrackingRequest.makeTrackingHttpRequest(mo37447a(), context);
        }
    }
}
