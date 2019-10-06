package com.inmobi.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class NativeVideoWrapper extends RelativeLayout {

    /* renamed from: b */
    private static final String f31437b = NativeVideoWrapper.class.getSimpleName();

    /* renamed from: a */
    NativeVideoView f31438a = new NativeVideoView(getContext());

    /* renamed from: c */
    private ImageView f31439c;

    /* renamed from: d */
    private ProgressBar f31440d;

    /* renamed from: e */
    private NativeVideoController f31441e;

    /* renamed from: f */
    private C10452bg f31442f;

    public NativeVideoWrapper(Context context) {
        super(context);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.f31438a, layoutParams);
        this.f31439c = new ImageView(getContext());
        this.f31439c.setScaleType(ScaleType.FIT_XY);
        this.f31439c.setVisibility(8);
        addView(this.f31439c, layoutParams);
        this.f31440d = new ProgressBar(getContext());
        this.f31440d.setVisibility(8);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.f31440d, layoutParams2);
        this.f31441e = new NativeVideoController(getContext());
        LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        layoutParams3.addRule(13);
        this.f31438a.setMediaController(this.f31441e);
        addView(this.f31441e, layoutParams3);
    }

    public void setPosterImage(Bitmap bitmap) {
        this.f31439c.setImageBitmap(bitmap);
    }

    public NativeVideoView getVideoView() {
        return this.f31438a;
    }

    public ImageView getPoster() {
        return this.f31439c;
    }

    public ProgressBar getProgressBar() {
        return this.f31440d;
    }

    public NativeVideoController getVideoController() {
        return this.f31441e;
    }

    public void setVideoEventListener(C10452bg bgVar) {
        this.f31442f = bgVar;
    }
}
