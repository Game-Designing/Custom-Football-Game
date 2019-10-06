package com.fyber.inneractive.sdk.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.fyber.inneractive.sdk.p180ui.IAcloseButton;
import com.fyber.inneractive.sdk.p180ui.IArichMediaVideoViewCore;
import com.fyber.inneractive.sdk.p180ui.IArichMediaVideoViewCore.BaseVideoViewListener;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mopub.common.AdType;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class InneractiveRichMediaVideoPlayerActivityCore extends Activity implements BaseVideoViewListener {
    public static final String VIDEO_URL = "video_url";

    /* renamed from: a */
    private View f15178a;

    /* renamed from: b */
    private LayoutParams f15179b;

    /* renamed from: c */
    private VideoView f15180c;
    protected RelativeLayout mLayout;

    public static boolean startRichMediaIntent(Context context, String str) {
        Intent intent = new Intent(context, InneractiveRichMediaVideoPlayerActivityCore.class);
        intent.setFlags(268435456);
        intent.putExtra("videoview_classname", AdType.MRAID);
        intent.putExtra("video_url", str);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            IAlog.m18021b("Activity InneractiveRichMediaVideoPlayerActivity was not found. Did you declare it in your AndroidManifest.xml?");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void initWindowFeatures() {
        requestWindowFeature(1);
        getWindow().addFlags(Opcodes.ACC_ABSTRACT);
        getWindow().addFlags(128);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        VideoView videoView;
        initWindowFeatures();
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        this.mLayout = new RelativeLayout(this);
        this.mLayout.setContentDescription("IAInterstitialView");
        this.f15179b = new LayoutParams(-2, -2);
        this.f15179b.addRule(13);
        if (AdType.MRAID.equals(getIntent().getStringExtra("videoview_classname"))) {
            videoView = new IArichMediaVideoViewCore(this, getIntent(), this);
        } else {
            finish();
            videoView = new VideoView(this) {
            };
        }
        this.f15180c = videoView;
        if (this.f15180c != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mLayout.addView(this.f15180c, layoutParams);
            setContentView(this.mLayout);
            int b = C8006j.m18072b(35);
            this.f15178a = new IAcloseButton(this, b);
            this.f15178a.setContentDescription("IAInterstitialButtonClose");
            LayoutParams layoutParams2 = new LayoutParams(b, b);
            layoutParams2.addRule(10);
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = C8006j.m18072b(10);
            layoutParams2.topMargin = C8006j.m18072b(10);
            this.mLayout.addView(this.f15178a, layoutParams2);
            concealInterstitialCloseBtn();
        } else {
            IAlog.m18023d("Internal error. Failed opening interstitial activity");
            finish();
        }
        this.f15180c.start();
    }

    /* access modifiers changed from: protected */
    public void concealInterstitialCloseBtn() {
        this.f15178a.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m16891a() {
        this.f15178a.setVisibility(0);
    }

    public void onDisplayCloseButton() {
        m16891a();
    }

    public void onVideoError(boolean z) {
        IAlog.m18021b("Error: video can not be played.");
        m16891a();
        if (z) {
            finish();
        }
    }

    public void onVideoCompleted(boolean z) {
        m16891a();
        if (z) {
            finish();
        }
    }

    public void onVideoClicked() {
    }
}
