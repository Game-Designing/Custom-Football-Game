package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import java.util.Map;

public class VastVideoViewController extends BaseVideoViewController {
    public static final int WEBVIEW_PADDING = 16;

    /* renamed from: A */
    private boolean f35072A;

    /* renamed from: B */
    private int f35073B = -1;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f35074C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f35075D;

    /* renamed from: E */
    private boolean f35076E = false;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f35077F = false;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f35078G = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f35079H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public boolean f35080I = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final VastVideoConfig f35081e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final VastVideoView f35082f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ExternalViewabilitySessionManager f35083g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public VastVideoGradientStripWidget f35084h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public VastVideoGradientStripWidget f35085i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ImageView f35086j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public VastVideoProgressBarWidget f35087k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public VastVideoRadialCountdownWidget f35088l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public VastVideoCtaButtonWidget f35089m;

    /* renamed from: n */
    private VastVideoCloseButtonWidget f35090n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public VastCompanionAdConfig f35091o;

    /* renamed from: p */
    private final C11302Ca f35092p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final View f35093q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final View f35094r;

    /* renamed from: s */
    private final Map<String, VastCompanionAdConfig> f35095s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public View f35096t;

    /* renamed from: u */
    private final View f35097u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final View f35098v;

    /* renamed from: w */
    private final VastVideoViewProgressRunnable f35099w;

    /* renamed from: x */
    private final VastVideoViewCountdownRunnable f35100x;

    /* renamed from: y */
    private final OnTouchListener f35101y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f35102z = 5000;

    /* JADX WARNING: type inference failed for: r2v17, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    VastVideoViewController(android.app.Activity r17, android.os.Bundle r18, android.os.Bundle r19, long r20, com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener r22) throws java.lang.IllegalStateException {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            java.lang.Long r0 = java.lang.Long.valueOf(r20)
            r11 = r22
            r8.<init>(r9, r0, r11)
            r0 = 5000(0x1388, float:7.006E-42)
            r8.f35102z = r0
            r0 = 0
            r8.f35076E = r0
            r8.f35077F = r0
            r8.f35078G = r0
            r8.f35080I = r0
            r1 = -1
            r8.f35073B = r1
            r2 = 0
            if (r10 == 0) goto L_0x002b
            java.lang.String r3 = "resumed_vast_config"
            java.io.Serializable r2 = r10.getSerializable(r3)
            r12 = r2
            goto L_0x002c
        L_0x002b:
            r12 = r2
        L_0x002c:
            java.lang.String r2 = "vast_video_config"
            r13 = r18
            java.io.Serializable r14 = r13.getSerializable(r2)
            if (r12 == 0) goto L_0x0049
            boolean r2 = r12 instanceof com.mopub.mobileads.VastVideoConfig
            if (r2 == 0) goto L_0x0049
            r2 = r12
            com.mopub.mobileads.VastVideoConfig r2 = (com.mopub.mobileads.VastVideoConfig) r2
            r8.f35081e = r2
            java.lang.String r2 = "current_position"
            int r1 = r10.getInt(r2, r1)
            r8.f35073B = r1
            goto L_0x0054
        L_0x0049:
            if (r14 == 0) goto L_0x013c
            boolean r1 = r14 instanceof com.mopub.mobileads.VastVideoConfig
            if (r1 == 0) goto L_0x013c
            r1 = r14
            com.mopub.mobileads.VastVideoConfig r1 = (com.mopub.mobileads.VastVideoConfig) r1
            r8.f35081e = r1
        L_0x0054:
            com.mopub.mobileads.VastVideoConfig r1 = r8.f35081e
            java.lang.String r1 = r1.getDiskMediaFileUrl()
            if (r1 == 0) goto L_0x0134
            com.mopub.mobileads.VastVideoConfig r1 = r8.f35081e
            android.content.res.Resources r2 = r17.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.orientation
            com.mopub.mobileads.VastCompanionAdConfig r1 = r1.getVastCompanionAd(r2)
            r8.f35091o = r1
            com.mopub.mobileads.VastVideoConfig r1 = r8.f35081e
            java.util.Map r1 = r1.getSocialActionsCompanionAds()
            r8.f35095s = r1
            com.mopub.mobileads.VastVideoConfig r1 = r8.f35081e
            com.mopub.mobileads.Ca r1 = r1.getVastIconConfig()
            r8.f35092p = r1
            com.mopub.mobileads.Pa r1 = new com.mopub.mobileads.Pa
            r1.<init>(r8, r9)
            r8.f35101y = r1
            android.view.ViewGroup r1 = r16.getLayout()
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1.setBackgroundColor(r2)
            r1 = 4
            r8.m37608a(r9, r1)
            com.mopub.mobileads.VastVideoView r0 = r8.m37623e(r9, r0)
            r8.f35082f = r0
            com.mopub.mobileads.VastVideoView r0 = r8.f35082f
            r0.requestFocus()
            com.mopub.common.ExternalViewabilitySessionManager r0 = new com.mopub.common.ExternalViewabilitySessionManager
            r0.<init>(r9)
            r8.f35083g = r0
            com.mopub.common.ExternalViewabilitySessionManager r0 = r8.f35083g
            com.mopub.mobileads.VastVideoView r2 = r8.f35082f
            com.mopub.mobileads.VastVideoConfig r3 = r8.f35081e
            r0.createVideoSession(r9, r2, r3)
            com.mopub.common.ExternalViewabilitySessionManager r0 = r8.f35083g
            android.widget.ImageView r2 = r8.f35086j
            r0.registerVideoObstruction(r2)
            com.mopub.mobileads.VastVideoConfig r0 = r8.f35081e
            r2 = 2
            com.mopub.mobileads.VastCompanionAdConfig r0 = r0.getVastCompanionAd(r2)
            android.view.View r0 = r8.mo37362a(r9, r0, r1)
            r8.f35093q = r0
            com.mopub.mobileads.VastVideoConfig r0 = r8.f35081e
            r2 = 1
            com.mopub.mobileads.VastCompanionAdConfig r0 = r0.getVastCompanionAd(r2)
            android.view.View r0 = r8.mo37362a(r9, r0, r1)
            r8.f35094r = r0
            r16.m37616c(r17)
            r8.m37617c(r9, r1)
            r16.m37607a(r17)
            r8.m37619d(r9, r1)
            com.mopub.mobileads.Ca r0 = r8.f35092p
            android.view.View r0 = r8.mo37361a(r9, r0, r1)
            r8.f35098v = r0
            android.view.View r0 = r8.f35098v
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
            com.mopub.mobileads.Qa r1 = new com.mopub.mobileads.Qa
            r1.<init>(r8, r9)
            r0.addOnGlobalLayoutListener(r1)
            r16.m37612b(r17)
            r0 = 1108869120(0x42180000, float:38.0)
            int r15 = com.mopub.common.util.Dips.dipsToIntPixels(r0, r9)
            java.util.Map<java.lang.String, com.mopub.mobileads.VastCompanionAdConfig> r0 = r8.f35095s
            java.lang.String r1 = "socialActions"
            java.lang.Object r0 = r0.get(r1)
            r2 = r0
            com.mopub.mobileads.VastCompanionAdConfig r2 = (com.mopub.mobileads.VastCompanionAdConfig) r2
            r4 = 6
            com.mopub.mobileads.VastVideoCtaButtonWidget r5 = r8.f35089m
            r6 = 4
            r7 = 16
            r0 = r16
            r1 = r17
            r3 = r15
            android.view.View r0 = r0.mo37363a(r1, r2, r3, r4, r5, r6, r7)
            r8.f35097u = r0
            r0 = 8
            r8.m37613b(r9, r0)
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            com.mopub.mobileads.VastVideoViewProgressRunnable r1 = new com.mopub.mobileads.VastVideoViewProgressRunnable
            com.mopub.mobileads.VastVideoConfig r2 = r8.f35081e
            r1.<init>(r8, r2, r0)
            r8.f35099w = r1
            com.mopub.mobileads.VastVideoViewCountdownRunnable r1 = new com.mopub.mobileads.VastVideoViewCountdownRunnable
            r1.<init>(r8, r0)
            r8.f35100x = r1
            return
        L_0x0134:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "VastVideoConfig does not have a video disk path"
            r0.<init>(r1)
            throw r0
        L_0x013c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "VastVideoConfig is invalid"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastVideoViewController.<init>(android.app.Activity, android.os.Bundle, android.os.Bundle, long, com.mopub.mobileads.BaseVideoViewController$BaseVideoViewControllerListener):void");
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public View mo37360a(Activity activity) {
        return mo37363a(activity, (VastCompanionAdConfig) this.f35095s.get(VastXmlManagerAggregator.ADS_BY_AD_SLOT_ID), this.f35098v.getHeight(), 1, this.f35098v, 0, 6);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public VideoView mo36932c() {
        return this.f35082f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo36934e() {
        super.mo36934e();
        int i = C11338Oa.f34889a[this.f35081e.getCustomForceOrientation().ordinal()];
        if (i == 1) {
            mo36923a().onSetRequestedOrientation(1);
        } else if (i == 2) {
            mo36923a().onSetRequestedOrientation(6);
        } else if (i == 3 || i != 4) {
        }
        this.f35081e.handleImpression(mo36929b(), mo37366i());
        mo36927a(IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo36938h() {
        m37639r();
        int i = this.f35073B;
        if (i > 0) {
            this.f35083g.recordVideoEvent(VideoEvent.AD_PLAYING, i);
            this.f35082f.seekTo(this.f35073B);
        } else {
            this.f35083g.recordVideoEvent(VideoEvent.AD_LOADED, mo37366i());
        }
        if (!this.f35074C) {
            this.f35082f.start();
        }
        if (this.f35073B != -1) {
            this.f35081e.handleResume(mo36929b(), this.f35073B);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo36936g() {
        m37641s();
        this.f35073B = mo37366i();
        this.f35082f.pause();
        if (!this.f35074C && !this.f35080I) {
            this.f35083g.recordVideoEvent(VideoEvent.AD_PAUSED, mo37366i());
            this.f35081e.handlePause(mo36929b(), this.f35073B);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo36935f() {
        m37641s();
        this.f35083g.recordVideoEvent(VideoEvent.AD_STOPPED, mo37366i());
        this.f35083g.endVideoSession();
        mo36927a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        this.f35082f.onDestroy();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36926a(Bundle outState) {
        outState.putInt("current_position", this.f35073B);
        outState.putSerializable("resumed_vast_config", this.f35081e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36925a(Configuration newConfig) {
        int orientation = mo36929b().getResources().getConfiguration().orientation;
        this.f35091o = this.f35081e.getVastCompanionAd(orientation);
        if (this.f35093q.getVisibility() == 0 || this.f35094r.getVisibility() == 0) {
            if (orientation == 1) {
                this.f35093q.setVisibility(4);
                this.f35094r.setVisibility(0);
            } else {
                this.f35094r.setVisibility(4);
                this.f35093q.setVisibility(0);
            }
            VastCompanionAdConfig vastCompanionAdConfig = this.f35091o;
            if (vastCompanionAdConfig != null) {
                vastCompanionAdConfig.mo37209a(mo36929b(), this.f35079H);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo36933d() {
        if (!this.f35074C) {
            this.f35083g.recordVideoEvent(VideoEvent.AD_SKIPPED, mo37366i());
        }
    }

    public boolean backButtonEnabled() {
        return this.f35072A;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36924a(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == -1) {
            mo36923a().onFinish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m37634p() {
        int videoDuration = mo37367j();
        if (this.f35081e.isRewardedVideo()) {
            this.f35102z = videoDuration;
            return;
        }
        if (videoDuration < 16000) {
            this.f35102z = videoDuration;
        }
        Integer skipOffsetMillis = this.f35081e.getSkipOffsetMillis(videoDuration);
        if (skipOffsetMillis != null) {
            this.f35102z = skipOffsetMillis.intValue();
            this.f35076E = true;
        }
    }

    /* renamed from: e */
    private VastVideoView m37623e(Context context, int initialVisibility) {
        if (this.f35081e.getDiskMediaFileUrl() != null) {
            VastVideoView videoView = new VastVideoView(context);
            videoView.setId((int) Utils.generateUniqueId());
            videoView.setOnPreparedListener(new C11345Ra(this, videoView));
            videoView.setOnTouchListener(this.f35101y);
            videoView.setOnCompletionListener(new C11348Sa(this, videoView, context));
            videoView.setOnErrorListener(new C11350Ta(this));
            videoView.setVideoPath(this.f35081e.getDiskMediaFileUrl());
            videoView.setVisibility(initialVisibility);
            return videoView;
        }
        throw new IllegalStateException("VastVideoConfig does not have a video disk path");
    }

    /* renamed from: c */
    private void m37616c(Context context) {
        VastVideoGradientStripWidget vastVideoGradientStripWidget = new VastVideoGradientStripWidget(context, Orientation.TOP_BOTTOM, this.f35081e.getCustomForceOrientation(), this.f35091o != null, 0, 6, getLayout().getId());
        this.f35084h = vastVideoGradientStripWidget;
        getLayout().addView(this.f35084h);
        this.f35083g.registerVideoObstruction(this.f35084h);
    }

    /* renamed from: a */
    private void m37607a(Context context) {
        VastVideoGradientStripWidget vastVideoGradientStripWidget = new VastVideoGradientStripWidget(context, Orientation.BOTTOM_TOP, this.f35081e.getCustomForceOrientation(), this.f35091o != null, 8, 2, this.f35087k.getId());
        this.f35085i = vastVideoGradientStripWidget;
        getLayout().addView(this.f35085i);
        this.f35083g.registerVideoObstruction(this.f35085i);
    }

    /* renamed from: c */
    private void m37617c(Context context, int initialVisibility) {
        this.f35087k = new VastVideoProgressBarWidget(context);
        this.f35087k.setAnchorId(this.f35082f.getId());
        this.f35087k.setVisibility(initialVisibility);
        getLayout().addView(this.f35087k);
        this.f35083g.registerVideoObstruction(this.f35087k);
    }

    /* renamed from: d */
    private void m37619d(Context context, int initialVisibility) {
        this.f35088l = new VastVideoRadialCountdownWidget(context);
        this.f35088l.setVisibility(initialVisibility);
        getLayout().addView(this.f35088l);
        this.f35083g.registerVideoObstruction(this.f35088l);
    }

    /* renamed from: b */
    private void m37612b(Context context) {
        this.f35089m = new VastVideoCtaButtonWidget(context, this.f35082f.getId(), this.f35091o != null, true ^ TextUtils.isEmpty(this.f35081e.getClickThroughUrl()));
        getLayout().addView(this.f35089m);
        this.f35083g.registerVideoObstruction(this.f35089m);
        this.f35089m.setOnTouchListener(this.f35101y);
        String customCtaText = this.f35081e.getCustomCtaText();
        if (customCtaText != null) {
            this.f35089m.mo37337a(customCtaText);
        }
    }

    /* renamed from: b */
    private void m37613b(Context context, int initialVisibility) {
        this.f35090n = new VastVideoCloseButtonWidget(context);
        this.f35090n.setVisibility(initialVisibility);
        getLayout().addView(this.f35090n);
        this.f35083g.registerVideoObstruction(this.f35090n);
        this.f35090n.setOnTouchListenerToContent(new C11352Ua(this));
        String customSkipText = this.f35081e.getCustomSkipText();
        if (customSkipText != null) {
            this.f35090n.mo37259b(customSkipText);
        }
        String customCloseIconUrl = this.f35081e.getCustomCloseIconUrl();
        if (customCloseIconUrl != null) {
            this.f35090n.mo37258a(customCloseIconUrl);
        }
    }

    /* renamed from: a */
    private void m37608a(Context context, int initialVisibility) {
        this.f35086j = new ImageView(context);
        this.f35086j.setVisibility(initialVisibility);
        getLayout().addView(this.f35086j, new LayoutParams(-1, -1));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public View mo37362a(Context context, VastCompanionAdConfig vastCompanionAdConfig, int initialVisibility) {
        Preconditions.checkNotNull(context);
        if (vastCompanionAdConfig == null) {
            View emptyView = new View(context);
            emptyView.setVisibility(4);
            return emptyView;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        getLayout().addView(relativeLayout, new LayoutParams(-1, -1));
        this.f35083g.registerVideoObstruction(relativeLayout);
        C11372Ya companionView = m37606a(context, vastCompanionAdConfig);
        companionView.setVisibility(initialVisibility);
        LayoutParams companionAdLayout = new LayoutParams(Dips.dipsToIntPixels((float) (vastCompanionAdConfig.getWidth() + 16), context), Dips.dipsToIntPixels((float) (vastCompanionAdConfig.getHeight() + 16), context));
        companionAdLayout.addRule(13, -1);
        relativeLayout.addView(companionView, companionAdLayout);
        this.f35083g.registerVideoObstruction(companionView);
        return companionView;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public View mo37363a(Context context, VastCompanionAdConfig vastCompanionAdConfig, int anchorHeight, int layoutVerb, View anchorView, int initialVisibility, int leftMarginDips) {
        Context context2 = context;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(anchorView);
        if (vastCompanionAdConfig == null) {
            View emptyView = new View(context);
            emptyView.setVisibility(4);
            return emptyView;
        }
        this.f35078G = true;
        this.f35089m.setHasSocialActions(this.f35078G);
        C11372Ya companionView = m37606a(context, vastCompanionAdConfig);
        int width = Dips.dipsToIntPixels((float) vastCompanionAdConfig.getWidth(), context);
        int height = Dips.dipsToIntPixels((float) vastCompanionAdConfig.getHeight(), context);
        int offset = (anchorHeight - height) / 2;
        int leftMargin = Dips.dipsToIntPixels((float) leftMarginDips, context);
        LayoutParams companionAdLayout = new LayoutParams(width, height);
        companionAdLayout.addRule(layoutVerb, anchorView.getId());
        companionAdLayout.addRule(6, anchorView.getId());
        companionAdLayout.setMargins(leftMargin, offset, 0, 0);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(16);
        relativeLayout.addView(companionView, new LayoutParams(-2, -2));
        this.f35083g.registerVideoObstruction(companionView);
        getLayout().addView(relativeLayout, companionAdLayout);
        this.f35083g.registerVideoObstruction(relativeLayout);
        companionView.setVisibility(initialVisibility);
        return companionView;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public View mo37361a(Context context, C11302Ca vastIconConfig, int initialVisibility) {
        Preconditions.checkNotNull(context);
        if (vastIconConfig == null) {
            return new View(context);
        }
        C11372Ya iconView = C11372Ya.m37735a(context, vastIconConfig.mo36954e());
        iconView.mo37432a((C11373a) new C11357Va(this, vastIconConfig, context));
        iconView.setWebViewClient(new C11367Wa(this, vastIconConfig));
        iconView.setVisibility(initialVisibility);
        LayoutParams layoutParams = new LayoutParams(Dips.asIntPixels((float) vastIconConfig.mo36955f(), context), Dips.asIntPixels((float) vastIconConfig.mo36952c(), context));
        layoutParams.setMargins(Dips.dipsToIntPixels(12.0f, context), Dips.dipsToIntPixels(12.0f, context), 0, 0);
        getLayout().addView(iconView, layoutParams);
        this.f35083g.registerVideoObstruction(iconView);
        return iconView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public int mo37367j() {
        return this.f35082f.getDuration();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public int mo37366i() {
        return this.f35082f.getCurrentPosition();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo37369l() {
        this.f35072A = true;
        this.f35088l.setVisibility(8);
        this.f35090n.setVisibility(0);
        this.f35089m.mo37338b();
        this.f35097u.setVisibility(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo37370m() {
        return !this.f35072A && mo37366i() >= this.f35102z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public void mo37371n() {
        if (this.f35077F) {
            this.f35088l.updateCountdownProgress(this.f35102z, mo37366i());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public void mo37372o() {
        this.f35087k.updateProgress(mo37366i());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public String mo37368k() {
        VastVideoConfig vastVideoConfig = this.f35081e;
        if (vastVideoConfig == null) {
            return null;
        }
        return vastVideoConfig.getNetworkMediaFileUrl();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37364a(int currentPosition) {
        C11302Ca ca = this.f35092p;
        if (ca != null && currentPosition >= ca.mo36953d()) {
            this.f35098v.setVisibility(0);
            this.f35092p.mo36949a(mo36929b(), currentPosition, mo37368k());
            if (this.f35092p.mo36951b() != null && currentPosition >= this.f35092p.mo36953d() + this.f35092p.mo36951b().intValue()) {
                this.f35098v.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37365b(String enumValue) {
        this.f35083g.recordVideoEvent((VideoEvent) Enum.valueOf(VideoEvent.class, enumValue), mo37366i());
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public boolean m37637q() {
        return this.f35072A;
    }

    /* renamed from: r */
    private void m37639r() {
        this.f35099w.startRepeating(50);
        this.f35100x.startRepeating(250);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m37641s() {
        this.f35099w.stop();
        this.f35100x.stop();
    }

    /* renamed from: a */
    private C11372Ya m37606a(Context context, VastCompanionAdConfig vastCompanionAdConfig) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastCompanionAdConfig);
        C11372Ya companionView = C11372Ya.m37735a(context, vastCompanionAdConfig.getVastResource());
        companionView.mo37432a((C11373a) new C11370Xa(this, vastCompanionAdConfig, context));
        companionView.setWebViewClient(new C11336Na(this, vastCompanionAdConfig, context));
        return companionView;
    }
}
