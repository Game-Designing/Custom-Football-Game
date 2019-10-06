package com.mopub.mraid;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;

public class MraidVideoViewController extends BaseVideoViewController {

    /* renamed from: e */
    private final VideoView f35539e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ImageButton f35540f;

    /* renamed from: g */
    private int f35541g;

    /* renamed from: h */
    private int f35542h;

    public MraidVideoViewController(Context context, Bundle intentExtras, Bundle savedInstanceState, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(context, null, baseVideoViewControllerListener);
        this.f35539e = new VideoView(context);
        this.f35539e.setOnCompletionListener(new C11474D(this));
        this.f35539e.setOnErrorListener(new C11475E(this));
        this.f35539e.setVideoPath(intentExtras.getString("video_url"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo36934e() {
        super.mo36934e();
        this.f35542h = Dips.asIntPixels(50.0f, mo36929b());
        this.f35541g = Dips.asIntPixels(8.0f, mo36929b());
        m38063i();
        this.f35540f.setVisibility(8);
        this.f35539e.start();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public VideoView mo36932c() {
        return this.f35539e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo36935f() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo36936g() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo36938h() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36926a(Bundle outState) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36925a(Configuration newConfig) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo36933d() {
    }

    /* renamed from: i */
    private void m38063i() {
        this.f35540f = new ImageButton(mo36929b());
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{-16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(mo36929b()));
        states.addState(new int[]{16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(mo36929b()));
        this.f35540f.setImageDrawable(states);
        this.f35540f.setBackgroundDrawable(null);
        this.f35540f.setOnClickListener(new C11476F(this));
        int i = this.f35542h;
        LayoutParams buttonLayout = new LayoutParams(i, i);
        buttonLayout.addRule(11);
        int i2 = this.f35541g;
        buttonLayout.setMargins(i2, 0, i2, 0);
        getLayout().addView(this.f35540f, buttonLayout);
    }
}
