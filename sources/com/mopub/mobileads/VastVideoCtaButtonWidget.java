package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CtaButtonDrawable;

public class VastVideoCtaButtonWidget extends ImageView {

    /* renamed from: a */
    private CtaButtonDrawable f35048a;

    /* renamed from: b */
    private final LayoutParams f35049b;

    /* renamed from: c */
    private final LayoutParams f35050c;

    /* renamed from: d */
    private boolean f35051d;

    /* renamed from: e */
    private boolean f35052e;

    /* renamed from: f */
    private boolean f35053f;

    /* renamed from: g */
    private boolean f35054g;

    /* renamed from: h */
    private boolean f35055h = false;

    public VastVideoCtaButtonWidget(Context context, int videoViewId, boolean hasCompanionAd, boolean hasClickthroughUrl) {
        super(context);
        this.f35053f = hasCompanionAd;
        this.f35054g = hasClickthroughUrl;
        setId((int) Utils.generateUniqueId());
        int width = Dips.dipsToIntPixels(150.0f, context);
        int height = Dips.dipsToIntPixels(38.0f, context);
        int margin = Dips.dipsToIntPixels(16.0f, context);
        this.f35048a = new CtaButtonDrawable(context);
        setImageDrawable(this.f35048a);
        this.f35049b = new LayoutParams(width, height);
        this.f35049b.setMargins(margin, margin, margin, margin);
        this.f35049b.addRule(8, videoViewId);
        this.f35049b.addRule(7, videoViewId);
        this.f35050c = new LayoutParams(width, height);
        this.f35050c.setMargins(margin, margin, margin, margin);
        this.f35050c.addRule(12);
        this.f35050c.addRule(11);
        m37596c();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        m37596c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37337a(String customCtaText) {
        this.f35048a.setCtaText(customCtaText);
    }

    /* access modifiers changed from: 0000 */
    public void setHasSocialActions(boolean hasSocialActions) {
        this.f35055h = hasSocialActions;
    }

    /* access modifiers changed from: 0000 */
    public boolean getHasSocialActions() {
        return this.f35055h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37338b() {
        this.f35051d = true;
        m37596c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37336a() {
        this.f35051d = true;
        this.f35052e = true;
        m37596c();
    }

    /* renamed from: c */
    private void m37596c() {
        if (!this.f35054g) {
            setVisibility(8);
        } else if (!this.f35051d) {
            setVisibility(4);
        } else if (!this.f35052e || !this.f35053f || this.f35055h) {
            int currentOrientation = getResources().getConfiguration().orientation;
            if (currentOrientation == 0) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Screen orientation undefined: CTA button widget defaulting to portrait layout");
                setLayoutParams(this.f35050c);
            } else if (currentOrientation == 1) {
                setLayoutParams(this.f35050c);
            } else if (currentOrientation == 2) {
                setLayoutParams(this.f35049b);
            } else if (currentOrientation != 3) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Unrecognized screen orientation: CTA button widget defaulting to portrait layout");
                setLayoutParams(this.f35050c);
            } else {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Screen orientation is deprecated ORIENTATION_SQUARE: CTA button widget defaulting to portrait layout");
                setLayoutParams(this.f35050c);
            }
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public String getCtaText() {
        return this.f35048a.getCtaText();
    }
}
