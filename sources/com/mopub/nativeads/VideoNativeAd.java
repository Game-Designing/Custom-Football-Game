package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.nativeads.NativeVideoController.Listener;
import java.util.HashMap;
import java.util.Map;

public abstract class VideoNativeAd extends BaseNativeAd implements Listener {

    /* renamed from: e */
    private String f36071e;

    /* renamed from: f */
    private String f36072f;

    /* renamed from: g */
    private String f36073g;

    /* renamed from: h */
    private String f36074h;

    /* renamed from: i */
    private String f36075i;

    /* renamed from: j */
    private String f36076j;

    /* renamed from: k */
    private String f36077k;

    /* renamed from: l */
    private String f36078l;

    /* renamed from: m */
    private String f36079m;

    /* renamed from: n */
    private final Map<String, Object> f36080n = new HashMap();

    public String getTitle() {
        return this.f36075i;
    }

    public String getText() {
        return this.f36076j;
    }

    public String getMainImageUrl() {
        return this.f36071e;
    }

    public String getIconImageUrl() {
        return this.f36072f;
    }

    public String getClickDestinationUrl() {
        return this.f36073g;
    }

    public String getVastVideo() {
        return this.f36079m;
    }

    public String getCallToAction() {
        return this.f36074h;
    }

    public String getPrivacyInformationIconClickThroughUrl() {
        return this.f36077k;
    }

    public String getPrivacyInformationIconImageUrl() {
        return this.f36078l;
    }

    public final Object getExtra(String key) {
        if (!NoThrow.checkNotNull(key, "getExtra key is not allowed to be null")) {
            return null;
        }
        return this.f36080n.get(key);
    }

    public final Map<String, Object> getExtras() {
        return this.f36080n;
    }

    public void setTitle(String title) {
        this.f36075i = title;
    }

    public void setText(String text) {
        this.f36076j = text;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.f36071e = mainImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.f36072f = iconImageUrl;
    }

    public void setClickDestinationUrl(String clickDestinationUrl) {
        this.f36073g = clickDestinationUrl;
    }

    public void setVastVideo(String vastVideo) {
        this.f36079m = vastVideo;
    }

    public void setCallToAction(String callToAction) {
        this.f36074h = callToAction;
    }

    public void setPrivacyInformationIconClickThroughUrl(String privacyInformationIconClickThroughUrl) {
        this.f36077k = privacyInformationIconClickThroughUrl;
    }

    public void setPrivacyInformationIconImageUrl(String privacyInformationIconImageUrl) {
        this.f36078l = privacyInformationIconImageUrl;
    }

    public final void addExtra(String key, Object value) {
        if (NoThrow.checkNotNull(key, "addExtra key is not allowed to be null")) {
            this.f36080n.put(key, value);
        }
    }

    public void prepare(View view) {
    }

    public void clear(View view) {
    }

    public void destroy() {
    }

    public void render(MediaLayout mediaLayout) {
    }
}
