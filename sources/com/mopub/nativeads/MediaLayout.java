package com.mopub.nativeads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.DrawableConstants.GradientStrip;

public class MediaLayout extends RelativeLayout {

    /* renamed from: a */
    private volatile Mode f35778a;

    /* renamed from: b */
    private MuteState f35779b;

    /* renamed from: c */
    private ImageView f35780c;

    /* renamed from: d */
    private TextureView f35781d;

    /* renamed from: e */
    private ProgressBar f35782e;

    /* renamed from: f */
    private ImageView f35783f;

    /* renamed from: g */
    private ImageView f35784g;

    /* renamed from: h */
    private ImageView f35785h;

    /* renamed from: i */
    private VastVideoProgressBarWidget f35786i;

    /* renamed from: j */
    private ImageView f35787j;

    /* renamed from: k */
    private View f35788k;

    /* renamed from: l */
    private Drawable f35789l;

    /* renamed from: m */
    private Drawable f35790m;

    /* renamed from: n */
    private boolean f35791n;

    /* renamed from: o */
    private final int f35792o;

    /* renamed from: p */
    private final int f35793p;

    /* renamed from: q */
    private final int f35794q;

    /* renamed from: r */
    private final int f35795r;

    public enum Mode {
        IMAGE,
        PLAYING,
        LOADING,
        BUFFERING,
        PAUSED,
        FINISHED
    }

    public enum MuteState {
        MUTED,
        UNMUTED
    }

    public MediaLayout(Context context) {
        this(context, null);
    }

    public MediaLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MediaLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f35778a = Mode.IMAGE;
        Preconditions.checkNotNull(context);
        this.f35779b = MuteState.MUTED;
        LayoutParams params = new LayoutParams(-1, -1);
        params.addRule(13);
        this.f35780c = new ImageView(context);
        this.f35780c.setLayoutParams(params);
        this.f35780c.setScaleType(ScaleType.CENTER_CROP);
        addView(this.f35780c);
        this.f35792o = Dips.asIntPixels(40.0f, context);
        this.f35793p = Dips.asIntPixels(35.0f, context);
        this.f35794q = Dips.asIntPixels(36.0f, context);
        this.f35795r = Dips.asIntPixels(10.0f, context);
    }

    public void setSurfaceTextureListener(SurfaceTextureListener stl) {
        TextureView textureView = this.f35781d;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(stl);
            SurfaceTexture st = this.f35781d.getSurfaceTexture();
            if (st != null && stl != null) {
                stl.onSurfaceTextureAvailable(st, this.f35781d.getWidth(), this.f35781d.getHeight());
            }
        }
    }

    public void initForVideo() {
        if (!this.f35791n) {
            LayoutParams videoTextureLayoutParams = new LayoutParams(-1, -1);
            videoTextureLayoutParams.addRule(13);
            this.f35781d = new TextureView(getContext());
            this.f35781d.setLayoutParams(videoTextureLayoutParams);
            this.f35781d.setId((int) Utils.generateUniqueId());
            addView(this.f35781d);
            this.f35780c.bringToFront();
            int i = this.f35792o;
            LayoutParams loadingSpinnerParams = new LayoutParams(i, i);
            loadingSpinnerParams.addRule(10);
            loadingSpinnerParams.addRule(11);
            this.f35782e = new ProgressBar(getContext());
            this.f35782e.setLayoutParams(loadingSpinnerParams);
            ProgressBar progressBar = this.f35782e;
            int i2 = this.f35795r;
            progressBar.setPadding(0, i2, i2, 0);
            this.f35782e.setIndeterminate(true);
            addView(this.f35782e);
            LayoutParams bottomGradientParams = new LayoutParams(-1, this.f35793p);
            bottomGradientParams.addRule(8, this.f35781d.getId());
            this.f35784g = new ImageView(getContext());
            this.f35784g.setLayoutParams(bottomGradientParams);
            this.f35784g.setImageDrawable(new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR}));
            addView(this.f35784g);
            LayoutParams topGradientParams = new LayoutParams(-1, this.f35793p);
            topGradientParams.addRule(6, this.f35781d.getId());
            this.f35785h = new ImageView(getContext());
            this.f35785h.setLayoutParams(topGradientParams);
            this.f35785h.setImageDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR}));
            addView(this.f35785h);
            this.f35786i = new VastVideoProgressBarWidget(getContext());
            this.f35786i.setAnchorId(this.f35781d.getId());
            this.f35786i.calibrateAndMakeVisible(1000, 0);
            addView(this.f35786i);
            this.f35789l = Drawables.NATIVE_MUTED.createDrawable(getContext());
            this.f35790m = Drawables.NATIVE_UNMUTED.createDrawable(getContext());
            int i3 = this.f35794q;
            LayoutParams muteControlParams = new LayoutParams(i3, i3);
            muteControlParams.addRule(9);
            muteControlParams.addRule(2, this.f35786i.getId());
            this.f35787j = new ImageView(getContext());
            this.f35787j.setLayoutParams(muteControlParams);
            this.f35787j.setScaleType(ScaleType.CENTER_INSIDE);
            ImageView imageView = this.f35787j;
            int i4 = this.f35795r;
            imageView.setPadding(i4, i4, i4, i4);
            this.f35787j.setImageDrawable(this.f35789l);
            addView(this.f35787j);
            LayoutParams overlayParams = new LayoutParams(-1, -1);
            overlayParams.addRule(13);
            this.f35788k = new View(getContext());
            this.f35788k.setLayoutParams(overlayParams);
            this.f35788k.setBackgroundColor(0);
            addView(this.f35788k);
            int i5 = this.f35792o;
            LayoutParams playButtonParams = new LayoutParams(i5, i5);
            playButtonParams.addRule(13);
            this.f35783f = new ImageView(getContext());
            this.f35783f.setLayoutParams(playButtonParams);
            this.f35783f.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(getContext()));
            addView(this.f35783f);
            this.f35791n = true;
            m38200a();
        }
    }

    public void reset() {
        setMode(Mode.IMAGE);
        setPlayButtonClickListener(null);
        setMuteControlClickListener(null);
        setVideoClickListener(null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int finalWidth;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int measWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measHeight = MeasureSpec.getSize(heightMeasureSpec);
        int curWidth = getMeasuredWidth();
        int curHeight = getMeasuredHeight();
        if (widthMode == 1073741824) {
            finalWidth = measWidth;
        } else if (widthMode == Integer.MIN_VALUE) {
            finalWidth = Math.min(measWidth, curWidth);
        } else {
            finalWidth = curWidth;
        }
        int finalHeight = (int) (((float) finalWidth) * 0.5625f);
        if (heightMode == 1073741824 && measHeight < finalHeight) {
            finalHeight = measHeight;
            finalWidth = (int) (((float) finalHeight) * 1.7777778f);
        }
        if (Math.abs(finalHeight - curHeight) >= 2 || Math.abs(finalWidth - curWidth) >= 2) {
            MoPubLog.log(SdkLogEvent.CUSTOM, String.format("Resetting mediaLayout size to w: %d h: %d", new Object[]{Integer.valueOf(finalWidth), Integer.valueOf(finalHeight)}));
            getLayoutParams().width = finalWidth;
            getLayoutParams().height = finalHeight;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setMainImageDrawable(Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        this.f35780c.setImageDrawable(drawable);
    }

    public void resetProgress() {
        VastVideoProgressBarWidget vastVideoProgressBarWidget = this.f35786i;
        if (vastVideoProgressBarWidget != null) {
            vastVideoProgressBarWidget.reset();
        }
    }

    public void updateProgress(int progressTenthPercentage) {
        VastVideoProgressBarWidget vastVideoProgressBarWidget = this.f35786i;
        if (vastVideoProgressBarWidget != null) {
            vastVideoProgressBarWidget.updateProgress(progressTenthPercentage);
        }
    }

    public TextureView getTextureView() {
        return this.f35781d;
    }

    public void setMode(Mode mode) {
        Preconditions.checkNotNull(mode);
        this.f35778a = mode;
        post(new C11514B(this));
    }

    public ImageView getMainImageView() {
        return this.f35780c;
    }

    public void setMuteControlClickListener(OnClickListener muteControlListener) {
        ImageView imageView = this.f35787j;
        if (imageView != null) {
            imageView.setOnClickListener(muteControlListener);
        }
    }

    public void setPlayButtonClickListener(OnClickListener playButtonListener) {
        if (this.f35783f != null) {
            View view = this.f35788k;
            if (view != null) {
                view.setOnClickListener(playButtonListener);
                this.f35783f.setOnClickListener(playButtonListener);
            }
        }
    }

    public void setVideoClickListener(OnClickListener videoClickListener) {
        TextureView textureView = this.f35781d;
        if (textureView != null) {
            textureView.setOnClickListener(videoClickListener);
        }
    }

    public void setMuteState(MuteState muteState) {
        Preconditions.checkNotNull(muteState);
        if (muteState != this.f35779b) {
            this.f35779b = muteState;
            if (this.f35787j != null) {
                if (C11517C.f35621a[this.f35779b.ordinal()] != 1) {
                    this.f35787j.setImageDrawable(this.f35790m);
                } else {
                    this.f35787j.setImageDrawable(this.f35789l);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38200a() {
        switch (C11517C.f35622b[this.f35778a.ordinal()]) {
            case 1:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case 2:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(4);
                return;
            case 3:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(0);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(4);
                break;
            case 4:
                break;
            case 5:
                setMainImageVisibility(4);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(0);
                setPlayButtonVisibility(0);
                return;
            case 6:
                setMainImageVisibility(0);
                setLoadingSpinnerVisibility(4);
                setVideoControlVisibility(4);
                setPlayButtonVisibility(0);
                return;
            default:
                return;
        }
        setMainImageVisibility(4);
        setLoadingSpinnerVisibility(4);
        setVideoControlVisibility(0);
        setPlayButtonVisibility(4);
    }

    private void setMainImageVisibility(int visibility) {
        this.f35780c.setVisibility(visibility);
    }

    private void setLoadingSpinnerVisibility(int visibility) {
        ProgressBar progressBar = this.f35782e;
        if (progressBar != null) {
            progressBar.setVisibility(visibility);
        }
        ImageView imageView = this.f35785h;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
    }

    private void setVideoControlVisibility(int visibility) {
        ImageView imageView = this.f35784g;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
        VastVideoProgressBarWidget vastVideoProgressBarWidget = this.f35786i;
        if (vastVideoProgressBarWidget != null) {
            vastVideoProgressBarWidget.setVisibility(visibility);
        }
        ImageView imageView2 = this.f35787j;
        if (imageView2 != null) {
            imageView2.setVisibility(visibility);
        }
    }

    private void setPlayButtonVisibility(int visibility) {
        ImageView imageView = this.f35783f;
        if (imageView != null && this.f35788k != null) {
            imageView.setVisibility(visibility);
            this.f35788k.setVisibility(visibility);
        }
    }
}
