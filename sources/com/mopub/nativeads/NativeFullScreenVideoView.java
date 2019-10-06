package com.mopub.nativeads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CtaButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.mobileads.resource.DrawableConstants.GradientStrip;

public class NativeFullScreenVideoView extends RelativeLayout {
    @VisibleForTesting

    /* renamed from: a */
    Mode f35932a;

    /* renamed from: b */
    private int f35933b;

    /* renamed from: c */
    private final ImageView f35934c;

    /* renamed from: d */
    private final TextureView f35935d;

    /* renamed from: e */
    private final ProgressBar f35936e;

    /* renamed from: f */
    private final ImageView f35937f;

    /* renamed from: g */
    private final ImageView f35938g;

    /* renamed from: h */
    private final VastVideoProgressBarWidget f35939h;

    /* renamed from: i */
    private final View f35940i;

    /* renamed from: j */
    private final ImageView f35941j;

    /* renamed from: k */
    private final ImageView f35942k;

    /* renamed from: l */
    private final ImageView f35943l;

    /* renamed from: m */
    private final ImageView f35944m;
    @VisibleForTesting

    /* renamed from: n */
    final int f35945n;
    @VisibleForTesting

    /* renamed from: o */
    final int f35946o;
    @VisibleForTesting

    /* renamed from: p */
    final int f35947p;
    @VisibleForTesting

    /* renamed from: q */
    final int f35948q;
    @VisibleForTesting

    /* renamed from: r */
    final int f35949r;
    @VisibleForTesting

    /* renamed from: s */
    final int f35950s;
    @VisibleForTesting

    /* renamed from: t */
    final int f35951t;
    @VisibleForTesting

    /* renamed from: u */
    final int f35952u;

    public enum Mode {
        LOADING,
        PLAYING,
        PAUSED,
        FINISHED
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.NativeFullScreenVideoView$a */
    static class C11554a extends Drawable {

        /* renamed from: a */
        private final RectF f35954a;

        /* renamed from: b */
        private final Paint f35955b;
        @VisibleForTesting

        /* renamed from: c */
        final int f35956c;

        C11554a(Context context) {
            this(context, new RectF(), new Paint());
        }

        C11554a(Context context, RectF rectF, Paint paint) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(rectF);
            Preconditions.checkNotNull(paint);
            this.f35954a = rectF;
            this.f35955b = paint;
            this.f35955b.setColor(CtaButton.BACKGROUND_COLOR);
            this.f35955b.setAlpha(128);
            this.f35955b.setAntiAlias(true);
            this.f35956c = Dips.asIntPixels(5.0f, context);
        }

        public void draw(Canvas canvas) {
            this.f35954a.set(getBounds());
            RectF rectF = this.f35954a;
            int i = this.f35956c;
            canvas.drawRoundRect(rectF, (float) i, (float) i, this.f35955b);
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }

        public int getOpacity() {
            return 0;
        }
    }

    public NativeFullScreenVideoView(Context context, int orientation, String ctaText) {
        Context context2 = context;
        this(context, orientation, ctaText, new ImageView(context2), new TextureView(context2), new ProgressBar(context2), new ImageView(context2), new ImageView(context2), new VastVideoProgressBarWidget(context2), new View(context2), new ImageView(context2), new ImageView(context2), new ImageView(context2), new ImageView(context2));
    }

    @VisibleForTesting
    NativeFullScreenVideoView(Context context, int orientation, String ctaText, ImageView cachedImageView, TextureView videoTexture, ProgressBar loadingSpinner, ImageView bottomGradient, ImageView topGradient, VastVideoProgressBarWidget videoProgress, View overlay, ImageView playButton, ImageView privacyInformationIcon, ImageView ctaButton, ImageView closeControl) {
        Context context2 = context;
        super(context);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(cachedImageView);
        Preconditions.checkNotNull(videoTexture);
        Preconditions.checkNotNull(loadingSpinner);
        Preconditions.checkNotNull(bottomGradient);
        Preconditions.checkNotNull(topGradient);
        Preconditions.checkNotNull(videoProgress);
        Preconditions.checkNotNull(overlay);
        Preconditions.checkNotNull(playButton);
        Preconditions.checkNotNull(privacyInformationIcon);
        Preconditions.checkNotNull(ctaButton);
        Preconditions.checkNotNull(closeControl);
        this.f35933b = orientation;
        this.f35932a = Mode.LOADING;
        this.f35945n = Dips.asIntPixels(200.0f, context2);
        this.f35946o = Dips.asIntPixels(42.0f, context2);
        this.f35947p = Dips.asIntPixels(10.0f, context2);
        this.f35948q = Dips.asIntPixels(50.0f, context2);
        this.f35949r = Dips.asIntPixels(8.0f, context2);
        this.f35950s = Dips.asIntPixels(44.0f, context2);
        this.f35951t = Dips.asIntPixels(50.0f, context2);
        this.f35952u = Dips.asIntPixels(45.0f, context2);
        LayoutParams videoTextureLayoutParams = new LayoutParams(-1, -1);
        videoTextureLayoutParams.addRule(13);
        this.f35935d = videoTexture;
        this.f35935d.setId((int) Utils.generateUniqueId());
        this.f35935d.setLayoutParams(videoTextureLayoutParams);
        addView(this.f35935d);
        this.f35934c = cachedImageView;
        this.f35934c.setId((int) Utils.generateUniqueId());
        this.f35934c.setLayoutParams(videoTextureLayoutParams);
        this.f35934c.setBackgroundColor(0);
        addView(this.f35934c);
        int i = this.f35951t;
        LayoutParams spinnerParams = new LayoutParams(i, i);
        spinnerParams.addRule(13);
        this.f35936e = loadingSpinner;
        this.f35936e.setId((int) Utils.generateUniqueId());
        this.f35936e.setBackground(new C11554a(context2));
        this.f35936e.setLayoutParams(spinnerParams);
        this.f35936e.setIndeterminate(true);
        addView(this.f35936e);
        LayoutParams bottomGradientParams = new LayoutParams(-1, this.f35952u);
        bottomGradientParams.addRule(8, this.f35935d.getId());
        this.f35937f = bottomGradient;
        this.f35937f.setId((int) Utils.generateUniqueId());
        this.f35937f.setLayoutParams(bottomGradientParams);
        GradientDrawable bottomGradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR});
        this.f35937f.setImageDrawable(bottomGradientDrawable);
        addView(this.f35937f);
        LayoutParams topGradientParams = new LayoutParams(-1, this.f35952u);
        topGradientParams.addRule(10);
        this.f35938g = topGradient;
        this.f35938g.setId((int) Utils.generateUniqueId());
        this.f35938g.setLayoutParams(topGradientParams);
        GradientDrawable topGradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{GradientStrip.START_COLOR, GradientStrip.END_COLOR});
        this.f35938g.setImageDrawable(topGradientDrawable);
        addView(this.f35938g);
        this.f35939h = videoProgress;
        this.f35939h.setId((int) Utils.generateUniqueId());
        this.f35939h.setAnchorId(this.f35935d.getId());
        this.f35939h.calibrateAndMakeVisible(1000, 0);
        addView(this.f35939h);
        LayoutParams overlayParams = new LayoutParams(-1, -1);
        overlayParams.addRule(13);
        this.f35940i = overlay;
        LayoutParams layoutParams = videoTextureLayoutParams;
        this.f35940i.setId((int) Utils.generateUniqueId());
        this.f35940i.setLayoutParams(overlayParams);
        this.f35940i.setBackgroundColor(DrawableConstants.TRANSPARENT_GRAY);
        addView(this.f35940i);
        int i2 = this.f35951t;
        LayoutParams playButtonParams = new LayoutParams(i2, i2);
        playButtonParams.addRule(13);
        this.f35941j = playButton;
        GradientDrawable gradientDrawable = topGradientDrawable;
        this.f35941j.setId((int) Utils.generateUniqueId());
        this.f35941j.setLayoutParams(playButtonParams);
        this.f35941j.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(context2));
        addView(this.f35941j);
        this.f35942k = privacyInformationIcon;
        LayoutParams layoutParams2 = playButtonParams;
        this.f35942k.setId((int) Utils.generateUniqueId());
        ImageView imageView = this.f35942k;
        int i3 = this.f35949r;
        GradientDrawable gradientDrawable2 = bottomGradientDrawable;
        imageView.setPadding(i3, i3, i3 * 2, i3 * 2);
        addView(this.f35942k);
        CtaButtonDrawable ctaDrawable = new CtaButtonDrawable(context2);
        if (!TextUtils.isEmpty(ctaText)) {
            ctaDrawable.setCtaText(ctaText);
        } else {
            String str = ctaText;
        }
        this.f35943l = ctaButton;
        this.f35943l.setId((int) Utils.generateUniqueId());
        this.f35943l.setImageDrawable(ctaDrawable);
        addView(this.f35943l);
        this.f35944m = closeControl;
        CtaButtonDrawable ctaButtonDrawable = ctaDrawable;
        this.f35944m.setId((int) Utils.generateUniqueId());
        this.f35944m.setImageDrawable(new CloseButtonDrawable());
        ImageView imageView2 = this.f35944m;
        int i4 = this.f35949r;
        imageView2.setPadding(i4 * 3, i4, i4, i4 * 3);
        addView(this.f35944m);
        m38314c();
    }

    public void resetProgress() {
        this.f35939h.reset();
    }

    public void setMode(Mode mode) {
        Preconditions.checkNotNull(mode);
        if (this.f35932a != mode) {
            this.f35932a = mode;
            m38314c();
        }
    }

    public TextureView getTextureView() {
        return this.f35935d;
    }

    public void setOrientation(int orientation) {
        if (this.f35933b != orientation) {
            this.f35933b = orientation;
            m38314c();
        }
    }

    public void setSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        this.f35935d.setSurfaceTextureListener(surfaceTextureListener);
        SurfaceTexture surfaceTexture = this.f35935d.getSurfaceTexture();
        if (surfaceTexture != null && surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, this.f35935d.getWidth(), this.f35935d.getHeight());
        }
    }

    public void setCloseControlListener(OnClickListener closeControlListener) {
        this.f35944m.setOnClickListener(closeControlListener);
    }

    public void setPrivacyInformationClickListener(OnClickListener privacyInformationListener) {
        this.f35942k.setOnClickListener(privacyInformationListener);
    }

    public void setPrivacyInformationIconImageUrl(String privacyInformationIconImageUrl) {
        if (TextUtils.isEmpty(privacyInformationIconImageUrl)) {
            ImageView imageView = this.f35942k;
            imageView.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(imageView.getContext()));
            return;
        }
        NativeImageHelper.loadImageView(privacyInformationIconImageUrl, this.f35942k);
    }

    public void setCtaClickListener(OnClickListener ctaListener) {
        this.f35943l.setOnClickListener(ctaListener);
    }

    public void setPlayControlClickListener(OnClickListener playControlListener) {
        this.f35941j.setOnClickListener(playControlListener);
        this.f35940i.setOnClickListener(playControlListener);
    }

    public void updateProgress(int progressPercentage) {
        this.f35939h.updateProgress(progressPercentage);
    }

    public void setCachedVideoFrame(Bitmap cachedVideoFrame) {
        this.f35934c.setImageBitmap(cachedVideoFrame);
    }

    /* renamed from: c */
    private void m38314c() {
        int i = C11635qa.f36220a[this.f35932a.ordinal()];
        if (i == 1) {
            setCachedImageVisibility(0);
            setLoadingSpinnerVisibility(0);
            setVideoProgressVisibility(4);
            setPlayButtonVisibility(4);
        } else if (i == 2) {
            setCachedImageVisibility(4);
            setLoadingSpinnerVisibility(4);
            setVideoProgressVisibility(0);
            setPlayButtonVisibility(4);
        } else if (i == 3) {
            setCachedImageVisibility(4);
            setLoadingSpinnerVisibility(4);
            setVideoProgressVisibility(0);
            setPlayButtonVisibility(0);
        } else if (i == 4) {
            setCachedImageVisibility(0);
            setLoadingSpinnerVisibility(4);
            setVideoProgressVisibility(4);
            setPlayButtonVisibility(0);
        }
        m38313b();
        m38312a();
    }

    private void setCachedImageVisibility(int visibility) {
        this.f35934c.setVisibility(visibility);
    }

    private void setLoadingSpinnerVisibility(int visibility) {
        this.f35936e.setVisibility(visibility);
    }

    private void setVideoProgressVisibility(int visibility) {
        this.f35939h.setVisibility(visibility);
    }

    private void setPlayButtonVisibility(int visibility) {
        this.f35941j.setVisibility(visibility);
        this.f35940i.setVisibility(visibility);
    }

    /* renamed from: b */
    private void m38313b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        ViewGroup.LayoutParams layoutParams = this.f35935d.getLayoutParams();
        int newWidth = Dips.dipsToIntPixels((float) configuration.screenWidthDp, getContext());
        if (newWidth != layoutParams.width) {
            layoutParams.width = newWidth;
        }
        int newHeight = Dips.dipsToIntPixels((((float) configuration.screenWidthDp) * 9.0f) / 16.0f, getContext());
        if (newHeight != layoutParams.height) {
            layoutParams.height = newHeight;
        }
    }

    /* renamed from: a */
    private void m38312a() {
        LayoutParams ctaParams = new LayoutParams(this.f35945n, this.f35946o);
        int i = this.f35947p;
        ctaParams.setMargins(i, i, i, i);
        int i2 = this.f35950s;
        LayoutParams privacyInformationIconParams = new LayoutParams(i2, i2);
        int i3 = this.f35948q;
        LayoutParams closeParams = new LayoutParams(i3, i3);
        int i4 = this.f35933b;
        if (i4 == 1) {
            ctaParams.addRule(3, this.f35935d.getId());
            ctaParams.addRule(14);
            privacyInformationIconParams.addRule(10);
            privacyInformationIconParams.addRule(9);
            closeParams.addRule(10);
            closeParams.addRule(11);
        } else if (i4 == 2) {
            ctaParams.addRule(2, this.f35939h.getId());
            ctaParams.addRule(11);
            privacyInformationIconParams.addRule(6, this.f35935d.getId());
            privacyInformationIconParams.addRule(5, this.f35935d.getId());
            closeParams.addRule(6, this.f35935d.getId());
            closeParams.addRule(7, this.f35935d.getId());
        }
        this.f35943l.setLayoutParams(ctaParams);
        this.f35942k.setLayoutParams(privacyInformationIconParams);
        this.f35944m.setLayoutParams(closeParams);
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public ImageView getCtaButton() {
        return this.f35943l;
    }
}
