package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.RadialCountdownDrawable;

public class VastVideoRadialCountdownWidget extends ImageView {

    /* renamed from: a */
    private RadialCountdownDrawable f35068a;

    /* renamed from: b */
    private int f35069b;

    public VastVideoRadialCountdownWidget(Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        int sideLength = Dips.dipsToIntPixels(45.0f, context);
        int topMargin = Dips.dipsToIntPixels(16.0f, context);
        int rightMargin = Dips.dipsToIntPixels(16.0f, context);
        int padding = Dips.dipsToIntPixels(5.0f, context);
        this.f35068a = new RadialCountdownDrawable(context);
        setImageDrawable(this.f35068a);
        setPadding(padding, padding, padding, padding);
        LayoutParams layoutParams = new LayoutParams(sideLength, sideLength);
        layoutParams.setMargins(0, topMargin, rightMargin, 0);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    public void calibrateAndMakeVisible(int initialCountdownMilliseconds) {
        this.f35068a.setInitialCountdown(initialCountdownMilliseconds);
        setVisibility(0);
    }

    public void updateCountdownProgress(int initialCountdownMilliseconds, int currentProgressMilliseconds) {
        if (currentProgressMilliseconds < this.f35069b) {
            return;
        }
        if (initialCountdownMilliseconds - currentProgressMilliseconds < 0) {
            setVisibility(8);
            return;
        }
        this.f35068a.updateCountdownProgress(currentProgressMilliseconds);
        this.f35069b = currentProgressMilliseconds;
    }

    @Deprecated
    @VisibleForTesting
    public RadialCountdownDrawable getImageViewDrawable() {
        return this.f35068a;
    }

    @Deprecated
    @VisibleForTesting
    public void setImageViewDrawable(RadialCountdownDrawable drawable) {
        this.f35068a = drawable;
    }
}
