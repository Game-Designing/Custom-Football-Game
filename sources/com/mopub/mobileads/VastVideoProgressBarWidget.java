package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.ProgressBarDrawable;

public class VastVideoProgressBarWidget extends ImageView {

    /* renamed from: a */
    private ProgressBarDrawable f35066a;

    /* renamed from: b */
    private final int f35067b;

    public VastVideoProgressBarWidget(Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.f35066a = new ProgressBarDrawable(context);
        setImageDrawable(this.f35066a);
        this.f35067b = Dips.dipsToIntPixels(4.0f, context);
    }

    public void setAnchorId(int anchorId) {
        LayoutParams layoutParams = new LayoutParams(-1, this.f35067b);
        layoutParams.addRule(8, anchorId);
        setLayoutParams(layoutParams);
    }

    public void calibrateAndMakeVisible(int duration, int skipOffset) {
        this.f35066a.setDurationAndSkipOffset(duration, skipOffset);
        setVisibility(0);
    }

    public void updateProgress(int progress) {
        this.f35066a.setProgress(progress);
    }

    public void reset() {
        this.f35066a.reset();
        this.f35066a.setProgress(0);
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public ProgressBarDrawable getImageViewDrawable() {
        return this.f35066a;
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public void setImageViewDrawable(ProgressBarDrawable drawable) {
        this.f35066a = drawable;
    }
}
