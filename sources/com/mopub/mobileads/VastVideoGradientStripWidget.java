package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants.GradientStrip;

public class VastVideoGradientStripWidget extends ImageView {

    /* renamed from: a */
    ForceOrientation f35056a;

    /* renamed from: b */
    private int f35057b;

    /* renamed from: c */
    private boolean f35058c;

    /* renamed from: d */
    private boolean f35059d;

    public VastVideoGradientStripWidget(Context context, Orientation gradientOrientation, ForceOrientation forceOrientation, boolean hasCompanionAd, int visibilityForCompanionAd, int layoutVerb, int layoutAnchor) {
        super(context);
        this.f35056a = forceOrientation;
        this.f35057b = visibilityForCompanionAd;
        this.f35058c = hasCompanionAd;
        setImageDrawable(new GradientDrawable(gradientOrientation, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR}));
        LayoutParams layoutParams = new LayoutParams(-1, Dips.dipsToIntPixels(72.0f, context));
        layoutParams.addRule(layoutVerb, layoutAnchor);
        setLayoutParams(layoutParams);
        m37600b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37343a() {
        this.f35059d = true;
        m37600b();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        m37600b();
    }

    /* renamed from: b */
    private void m37600b() {
        if (this.f35059d) {
            if (this.f35058c) {
                setVisibility(this.f35057b);
            } else {
                setVisibility(8);
            }
            return;
        }
        ForceOrientation forceOrientation = this.f35056a;
        if (forceOrientation == ForceOrientation.FORCE_PORTRAIT) {
            setVisibility(4);
        } else if (forceOrientation == ForceOrientation.FORCE_LANDSCAPE) {
            setVisibility(0);
        } else {
            int currentOrientation = getResources().getConfiguration().orientation;
            if (currentOrientation == 0) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Screen orientation undefined: do not show gradient strip widget");
                setVisibility(4);
            } else if (currentOrientation == 1) {
                setVisibility(4);
            } else if (currentOrientation == 2) {
                setVisibility(0);
            } else if (currentOrientation != 3) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Unrecognized screen orientation: do not show gradient strip widget");
                setVisibility(4);
            } else {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Screen orientation is deprecated ORIENTATION_SQUARE: do not show gradient strip widget");
                setVisibility(4);
            }
        }
    }
}
