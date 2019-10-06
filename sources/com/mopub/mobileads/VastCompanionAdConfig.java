package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

public class VastCompanionAdConfig implements Serializable {

    /* renamed from: a */
    private final int f34976a;

    /* renamed from: b */
    private final int f34977b;

    /* renamed from: c */
    private final C11321Ja f34978c;

    /* renamed from: d */
    private final String f34979d;

    /* renamed from: e */
    private final List<VastTracker> f34980e;

    /* renamed from: f */
    private final List<VastTracker> f34981f;

    public VastCompanionAdConfig(int width, int height, C11321Ja vastResource, String clickThroughUrl, List<VastTracker> clickTrackers, List<VastTracker> creativeViewTrackers) {
        Preconditions.checkNotNull(vastResource);
        Preconditions.checkNotNull(clickTrackers, "clickTrackers cannot be null");
        Preconditions.checkNotNull(creativeViewTrackers, "creativeViewTrackers cannot be null");
        this.f34976a = width;
        this.f34977b = height;
        this.f34978c = vastResource;
        this.f34979d = clickThroughUrl;
        this.f34980e = clickTrackers;
        this.f34981f = creativeViewTrackers;
    }

    public void addClickTrackers(List<VastTracker> clickTrackers) {
        Preconditions.checkNotNull(clickTrackers, "clickTrackers cannot be null");
        this.f34980e.addAll(clickTrackers);
    }

    public void addCreativeViewTrackers(List<VastTracker> creativeViewTrackers) {
        Preconditions.checkNotNull(creativeViewTrackers, "creativeViewTrackers cannot be null");
        this.f34981f.addAll(creativeViewTrackers);
    }

    public int getWidth() {
        return this.f34976a;
    }

    public int getHeight() {
        return this.f34977b;
    }

    public C11321Ja getVastResource() {
        return this.f34978c;
    }

    public String getClickThroughUrl() {
        return this.f34979d;
    }

    public List<VastTracker> getClickTrackers() {
        return this.f34980e;
    }

    public List<VastTracker> getCreativeViewTrackers() {
        return this.f34981f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37209a(Context context, int contentPlayHead) {
        Preconditions.checkNotNull(context);
        TrackingRequest.makeVastTrackingHttpRequest(this.f34981f, null, Integer.valueOf(contentPlayHead), null, context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37210a(Context context, int requestCode, String webViewClickThroughUrl, String dspCreativeId) {
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(context instanceof Activity, "context must be an activity");
        String correctClickThroughUrl = this.f34978c.getCorrectClickThroughUrl(this.f34979d, webViewClickThroughUrl);
        if (!TextUtils.isEmpty(correctClickThroughUrl)) {
            new Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new C11470za(this, dspCreativeId, context, requestCode)).withDspCreativeId(dspCreativeId).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
        }
    }
}
