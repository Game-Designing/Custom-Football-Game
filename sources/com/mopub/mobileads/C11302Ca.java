package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.mopub.mobileads.Ca */
/* compiled from: VastIconConfig */
class C11302Ca implements Serializable {

    /* renamed from: a */
    private final int f34708a;

    /* renamed from: b */
    private final int f34709b;

    /* renamed from: c */
    private final int f34710c;

    /* renamed from: d */
    private final Integer f34711d;

    /* renamed from: e */
    private final C11321Ja f34712e;

    /* renamed from: f */
    private final List<VastTracker> f34713f;

    /* renamed from: g */
    private final String f34714g;

    /* renamed from: h */
    private final List<VastTracker> f34715h;

    C11302Ca(int width, int height, Integer offsetMS, Integer durationMS, C11321Ja vastResource, List<VastTracker> clickTrackingUris, String clickThroughUri, List<VastTracker> viewTrackingUris) {
        Preconditions.checkNotNull(vastResource);
        Preconditions.checkNotNull(clickTrackingUris);
        Preconditions.checkNotNull(viewTrackingUris);
        this.f34708a = width;
        this.f34709b = height;
        this.f34710c = offsetMS == null ? 0 : offsetMS.intValue();
        this.f34711d = durationMS;
        this.f34712e = vastResource;
        this.f34713f = clickTrackingUris;
        this.f34714g = clickThroughUri;
        this.f34715h = viewTrackingUris;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo36955f() {
        return this.f34708a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo36952c() {
        return this.f34709b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo36953d() {
        return this.f34710c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Integer mo36951b() {
        return this.f34711d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C11321Ja mo36954e() {
        return this.f34712e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<VastTracker> mo36948a() {
        return this.f34713f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36949a(Context context, int contentPlayHead, String assetUri) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(assetUri);
        TrackingRequest.makeVastTrackingHttpRequest(this.f34715h, null, Integer.valueOf(contentPlayHead), assetUri, context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36950a(Context context, String webViewClickThroughUri, String dspCreativeId) {
        Preconditions.checkNotNull(context);
        String correctClickThroughUri = this.f34712e.getCorrectClickThroughUrl(this.f34714g, webViewClickThroughUri);
        if (!TextUtils.isEmpty(correctClickThroughUri)) {
            new Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER).withResultActions(new C11300Ba(this, dspCreativeId, context)).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUri);
        }
    }
}
