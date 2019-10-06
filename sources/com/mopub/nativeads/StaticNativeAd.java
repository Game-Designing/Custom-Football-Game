package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import java.util.HashMap;
import java.util.Map;

public abstract class StaticNativeAd extends BaseNativeAd implements ImpressionInterface, ClickInterface {

    /* renamed from: e */
    private String f36048e;

    /* renamed from: f */
    private String f36049f;

    /* renamed from: g */
    private String f36050g;

    /* renamed from: h */
    private String f36051h;

    /* renamed from: i */
    private String f36052i;

    /* renamed from: j */
    private String f36053j;

    /* renamed from: k */
    private Double f36054k;

    /* renamed from: l */
    private String f36055l;

    /* renamed from: m */
    private String f36056m;

    /* renamed from: n */
    private boolean f36057n;

    /* renamed from: o */
    private int f36058o = 1000;

    /* renamed from: p */
    private int f36059p = 50;

    /* renamed from: q */
    private Integer f36060q = null;

    /* renamed from: r */
    private final Map<String, Object> f36061r = new HashMap();

    public final String getTitle() {
        return this.f36052i;
    }

    public final String getText() {
        return this.f36053j;
    }

    public final String getMainImageUrl() {
        return this.f36048e;
    }

    public final String getIconImageUrl() {
        return this.f36049f;
    }

    public final String getCallToAction() {
        return this.f36051h;
    }

    public final Double getStarRating() {
        return this.f36054k;
    }

    public final String getPrivacyInformationIconClickThroughUrl() {
        return this.f36055l;
    }

    public String getPrivacyInformationIconImageUrl() {
        return this.f36056m;
    }

    public final Object getExtra(String key) {
        if (!NoThrow.checkNotNull(key, "getExtra key is not allowed to be null")) {
            return null;
        }
        return this.f36061r.get(key);
    }

    public final Map<String, Object> getExtras() {
        return new HashMap(this.f36061r);
    }

    public final String getClickDestinationUrl() {
        return this.f36050g;
    }

    public final void setMainImageUrl(String mainImageUrl) {
        this.f36048e = mainImageUrl;
    }

    public final void setIconImageUrl(String iconImageUrl) {
        this.f36049f = iconImageUrl;
    }

    public final void setClickDestinationUrl(String clickDestinationUrl) {
        this.f36050g = clickDestinationUrl;
    }

    public final void setCallToAction(String callToAction) {
        this.f36051h = callToAction;
    }

    public final void setTitle(String title) {
        this.f36052i = title;
    }

    public final void setText(String text) {
        this.f36053j = text;
    }

    public final void setStarRating(Double starRating) {
        if (starRating == null) {
            this.f36054k = null;
        } else if (starRating.doubleValue() < 0.0d || starRating.doubleValue() > 5.0d) {
            AdLogEvent adLogEvent = AdLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring attempt to set invalid star rating (");
            sb.append(starRating);
            sb.append("). Must be between ");
            sb.append(0.0d);
            sb.append(" and ");
            sb.append(5.0d);
            sb.append(".");
            MoPubLog.log(adLogEvent, sb.toString());
        } else {
            this.f36054k = starRating;
        }
    }

    public final void setPrivacyInformationIconClickThroughUrl(String privacyInformationIconClickThroughUrl) {
        this.f36055l = privacyInformationIconClickThroughUrl;
    }

    public final void setPrivacyInformationIconImageUrl(String privacyInformationIconImageUrl) {
        this.f36056m = privacyInformationIconImageUrl;
    }

    public final void addExtra(String key, Object value) {
        if (NoThrow.checkNotNull(key, "addExtra key is not allowed to be null")) {
            this.f36061r.put(key, value);
        }
    }

    public final void setImpressionMinTimeViewed(int impressionMinTimeViewed) {
        if (impressionMinTimeViewed > 0) {
            this.f36058o = impressionMinTimeViewed;
            return;
        }
        AdLogEvent adLogEvent = AdLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Ignoring non-positive impressionMinTimeViewed: ");
        sb.append(impressionMinTimeViewed);
        MoPubLog.log(adLogEvent, sb.toString());
    }

    public final void setImpressionMinPercentageViewed(int impressionMinPercentageViewed) {
        if (impressionMinPercentageViewed < 0 || impressionMinPercentageViewed > 100) {
            AdLogEvent adLogEvent = AdLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring impressionMinTimeViewed that's not a percent [0, 100]: ");
            sb.append(impressionMinPercentageViewed);
            MoPubLog.log(adLogEvent, sb.toString());
            return;
        }
        this.f36059p = impressionMinPercentageViewed;
    }

    public final void setImpressionMinVisiblePx(Integer impressionMinVisiblePx) {
        if (impressionMinVisiblePx == null || impressionMinVisiblePx.intValue() <= 0) {
            AdLogEvent adLogEvent = AdLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring null or non-positive impressionMinVisiblePx: ");
            sb.append(impressionMinVisiblePx);
            MoPubLog.log(adLogEvent, sb.toString());
            return;
        }
        this.f36060q = impressionMinVisiblePx;
    }

    public void prepare(View view) {
    }

    public void clear(View view) {
    }

    public void destroy() {
        invalidate();
    }

    public void recordImpression(View view) {
    }

    public final int getImpressionMinPercentageViewed() {
        return this.f36059p;
    }

    public final int getImpressionMinTimeViewed() {
        return this.f36058o;
    }

    public final Integer getImpressionMinVisiblePx() {
        return this.f36060q;
    }

    public final boolean isImpressionRecorded() {
        return this.f36057n;
    }

    public final void setImpressionRecorded() {
        this.f36057n = true;
    }

    public void handleClick(View view) {
    }
}
