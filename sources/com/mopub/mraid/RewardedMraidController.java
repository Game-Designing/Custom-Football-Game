package com.mopub.mraid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.IntentActions;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.BaseBroadcastReceiver;
import com.mopub.mobileads.RewardedMraidCountdownRunnable;
import com.mopub.mobileads.VastVideoRadialCountdownWidget;

public class RewardedMraidController extends MraidController {
    public static final int DEFAULT_PLAYABLE_DURATION_FOR_CLOSE_BUTTON_SECONDS = 30;
    public static final boolean DEFAULT_PLAYABLE_SHOULD_REWARD_ON_CLICK = false;
    public static final int MILLIS_IN_SECOND = 1000;

    /* renamed from: A */
    private CloseableLayout f35545A;

    /* renamed from: B */
    private VastVideoRadialCountdownWidget f35546B;

    /* renamed from: C */
    private RewardedMraidCountdownRunnable f35547C;

    /* renamed from: D */
    private final int f35548D;

    /* renamed from: E */
    private final long f35549E;

    /* renamed from: F */
    private int f35550F;

    /* renamed from: G */
    private boolean f35551G;

    /* renamed from: H */
    private boolean f35552H;

    /* renamed from: I */
    private boolean f35553I;

    @VisibleForTesting
    public RewardedMraidController(Context context, AdReport adReport, PlacementType placementType, int rewardedDurationInSeconds, long broadcastIdentifier) {
        super(context, adReport, placementType);
        int rewardedDurationInMillis = rewardedDurationInSeconds * 1000;
        if (rewardedDurationInMillis < 0 || rewardedDurationInMillis > 30000) {
            this.f35548D = 30000;
        } else {
            this.f35548D = rewardedDurationInMillis;
        }
        this.f35549E = broadcastIdentifier;
    }

    public void create(Context context, CloseableLayout closeableLayout) {
        this.f35545A = closeableLayout;
        this.f35545A.setCloseAlwaysInteractable(false);
        this.f35545A.setCloseVisible(false);
        m38075a(context, 4);
        this.f35546B.calibrateAndMakeVisible(this.f35548D);
        this.f35552H = true;
        this.f35547C = new RewardedMraidCountdownRunnable(this, new Handler(Looper.getMainLooper()));
    }

    public void pause() {
        m38077o();
        super.pause(false);
    }

    public void resume() {
        super.resume();
        m38076n();
    }

    public void destroy() {
        m38077o();
        super.destroy();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37643a(boolean useCustomClose) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37651c() {
        if (this.f35551G) {
            super.mo37651c();
        }
    }

    public boolean backButtonEnabled() {
        return this.f35551G;
    }

    public boolean isPlayableCloseable() {
        return !this.f35551G && this.f35550F >= this.f35548D;
    }

    public void showPlayableCloseButton() {
        this.f35551G = true;
        this.f35546B.setVisibility(8);
        this.f35545A.setCloseVisible(true);
        if (!this.f35553I) {
            BaseBroadcastReceiver.broadcastAction(getContext(), this.f35549E, IntentActions.ACTION_REWARDED_PLAYABLE_COMPLETE);
            this.f35553I = true;
        }
    }

    public void updateCountdown(int currentElapsedTimeMillis) {
        this.f35550F = currentElapsedTimeMillis;
        if (this.f35552H) {
            this.f35546B.updateCountdownProgress(this.f35548D, this.f35550F);
        }
    }

    /* renamed from: n */
    private void m38076n() {
        this.f35547C.startRepeating(250);
    }

    /* renamed from: o */
    private void m38077o() {
        this.f35547C.stop();
    }

    /* renamed from: a */
    private void m38075a(Context context, int initialVisibility) {
        this.f35546B = new VastVideoRadialCountdownWidget(context);
        this.f35546B.setVisibility(initialVisibility);
        MarginLayoutParams lp = (MarginLayoutParams) this.f35546B.getLayoutParams();
        LayoutParams widgetLayoutParams = new LayoutParams(lp.width + lp.leftMargin + lp.rightMargin, lp.height + lp.topMargin + lp.bottomMargin);
        widgetLayoutParams.gravity = 53;
        this.f35545A.addView(this.f35546B, widgetLayoutParams);
    }

    @Deprecated
    @VisibleForTesting
    public int getShowCloseButtonDelay() {
        return this.f35548D;
    }

    @Deprecated
    @VisibleForTesting
    public VastVideoRadialCountdownWidget getRadialCountdownWidget() {
        return this.f35546B;
    }

    @Deprecated
    @VisibleForTesting
    public RewardedMraidCountdownRunnable getCountdownRunnable() {
        return this.f35547C;
    }

    @Deprecated
    @VisibleForTesting
    public boolean isCalibrationDone() {
        return this.f35552H;
    }

    @Deprecated
    @VisibleForTesting
    public boolean isShowCloseButtonEventFired() {
        return this.f35551G;
    }

    @Deprecated
    @VisibleForTesting
    public boolean isRewarded() {
        return this.f35553I;
    }
}
