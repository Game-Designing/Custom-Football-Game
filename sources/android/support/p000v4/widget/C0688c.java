package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0646w;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.c */
/* compiled from: CircleImageView */
class C0688c extends ImageView {

    /* renamed from: a */
    private AnimationListener f2012a;

    /* renamed from: b */
    int f2013b;

    /* renamed from: android.support.v4.widget.c$a */
    /* compiled from: CircleImageView */
    private class C0689a extends OvalShape {

        /* renamed from: a */
        private RadialGradient f2014a;

        /* renamed from: b */
        private Paint f2015b = new Paint();

        C0689a(int shadowRadius) {
            C0688c.this.f2013b = shadowRadius;
            m3262a((int) rect().width());
        }

        /* access modifiers changed from: protected */
        public void onResize(float width, float height) {
            super.onResize(width, height);
            m3262a((int) width);
        }

        public void draw(Canvas canvas, Paint paint) {
            int viewWidth = C0688c.this.getWidth();
            int viewHeight = C0688c.this.getHeight();
            canvas.drawCircle((float) (viewWidth / 2), (float) (viewHeight / 2), (float) (viewWidth / 2), this.f2015b);
            canvas.drawCircle((float) (viewWidth / 2), (float) (viewHeight / 2), (float) ((viewWidth / 2) - C0688c.this.f2013b), paint);
        }

        /* renamed from: a */
        private void m3262a(int diameter) {
            RadialGradient radialGradient = new RadialGradient((float) (diameter / 2), (float) (diameter / 2), (float) C0688c.this.f2013b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f2014a = radialGradient;
            this.f2015b.setShader(this.f2014a);
        }
    }

    C0688c(Context context, int color) {
        ShapeDrawable circle;
        super(context);
        float density = getContext().getResources().getDisplayMetrics().density;
        int shadowYOffset = (int) (1.75f * density);
        int shadowXOffset = (int) (0.0f * density);
        this.f2013b = (int) (3.5f * density);
        if (m3260a()) {
            circle = new ShapeDrawable(new OvalShape());
            C0646w.m2964b((View) this, 4.0f * density);
        } else {
            ShapeDrawable circle2 = new ShapeDrawable(new C0689a(this.f2013b));
            setLayerType(1, circle2.getPaint());
            circle2.getPaint().setShadowLayer((float) this.f2013b, (float) shadowXOffset, (float) shadowYOffset, 503316480);
            int padding = this.f2013b;
            setPadding(padding, padding, padding, padding);
            circle = circle2;
        }
        circle.getPaint().setColor(color);
        C0646w.m2954a((View) this, (Drawable) circle);
    }

    /* renamed from: a */
    private boolean m3260a() {
        return VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!m3260a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f2013b * 2), getMeasuredHeight() + (this.f2013b * 2));
        }
    }

    /* renamed from: a */
    public void mo5923a(AnimationListener listener) {
        this.f2012a = listener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        AnimationListener animationListener = this.f2012a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        AnimationListener animationListener = this.f2012a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int color) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(color);
        }
    }
}
