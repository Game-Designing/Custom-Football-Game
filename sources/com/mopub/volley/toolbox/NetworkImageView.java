package com.mopub.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;

public class NetworkImageView extends ImageView {

    /* renamed from: a */
    private String f36535a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f36536b;

    /* renamed from: c */
    Bitmap f36537c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f36538d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Bitmap f36539e;

    /* renamed from: f */
    private ImageLoader f36540f;

    /* renamed from: g */
    private ImageContainer f36541g;

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setImageUrl(String url, ImageLoader imageLoader) {
        C11701h.m38679a();
        this.f36535a = url;
        this.f36540f = imageLoader;
        mo38472a(false);
    }

    public void setDefaultImageResId(int defaultImage) {
        this.f36537c = null;
        this.f36536b = defaultImage;
    }

    public void setDefaultImageBitmap(Bitmap defaultImage) {
        this.f36536b = 0;
        this.f36537c = defaultImage;
    }

    public void setErrorImageResId(int errorImage) {
        this.f36539e = null;
        this.f36538d = errorImage;
    }

    public void setErrorImageBitmap(Bitmap errorImage) {
        this.f36538d = 0;
        this.f36539e = errorImage;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo38472a(boolean isInLayoutPass) {
        boolean wrapHeight;
        boolean wrapWidth;
        int width = getWidth();
        int height = getHeight();
        ScaleType scaleType = getScaleType();
        boolean z = true;
        int maxHeight = 0;
        if (getLayoutParams() != null) {
            wrapWidth = getLayoutParams().width == -2;
            wrapHeight = getLayoutParams().height == -2;
        } else {
            wrapWidth = false;
            wrapHeight = false;
        }
        if (!wrapWidth || !wrapHeight) {
            z = false;
        }
        boolean isFullyWrapContent = z;
        if (width != 0 || height != 0 || isFullyWrapContent) {
            if (TextUtils.isEmpty(this.f36535a)) {
                ImageContainer imageContainer = this.f36541g;
                if (imageContainer != null) {
                    imageContainer.cancelRequest();
                    this.f36541g = null;
                }
                m38670a();
                return;
            }
            ImageContainer imageContainer2 = this.f36541g;
            if (!(imageContainer2 == null || imageContainer2.getRequestUrl() == null)) {
                if (!this.f36541g.getRequestUrl().equals(this.f36535a)) {
                    this.f36541g.cancelRequest();
                    m38670a();
                } else {
                    return;
                }
            }
            int maxWidth = wrapWidth ? 0 : width;
            if (!wrapHeight) {
                maxHeight = height;
            }
            this.f36541g = this.f36540f.get(this.f36535a, new C11700g(this, isInLayoutPass), maxWidth, maxHeight, scaleType);
        }
    }

    /* renamed from: a */
    private void m38670a() {
        int i = this.f36536b;
        if (i != 0) {
            setImageResource(i);
            return;
        }
        Bitmap bitmap = this.f36537c;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        } else {
            setImageBitmap(null);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mo38472a(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ImageContainer imageContainer = this.f36541g;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap(null);
            this.f36541g = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
