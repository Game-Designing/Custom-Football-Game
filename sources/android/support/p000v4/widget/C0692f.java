package android.support.p000v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.p039b.C0611b;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import p002b.p003c.p053g.p061f.C1272p;

/* renamed from: android.support.v4.widget.f */
/* compiled from: CircularProgressDrawable */
public class C0692f extends Drawable implements Animatable {

    /* renamed from: a */
    private static final Interpolator f2021a = new LinearInterpolator();

    /* renamed from: b */
    private static final Interpolator f2022b = new C0611b();

    /* renamed from: c */
    private static final int[] f2023c = {-16777216};

    /* renamed from: d */
    private final C0693a f2024d = new C0693a();

    /* renamed from: e */
    private float f2025e;

    /* renamed from: f */
    private Resources f2026f;

    /* renamed from: g */
    private Animator f2027g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f2028h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f2029i;

    /* renamed from: android.support.v4.widget.f$a */
    /* compiled from: CircularProgressDrawable */
    private static class C0693a {

        /* renamed from: a */
        final RectF f2030a = new RectF();

        /* renamed from: b */
        final Paint f2031b = new Paint();

        /* renamed from: c */
        final Paint f2032c = new Paint();

        /* renamed from: d */
        final Paint f2033d = new Paint();

        /* renamed from: e */
        float f2034e = 0.0f;

        /* renamed from: f */
        float f2035f = 0.0f;

        /* renamed from: g */
        float f2036g = 0.0f;

        /* renamed from: h */
        float f2037h = 5.0f;

        /* renamed from: i */
        int[] f2038i;

        /* renamed from: j */
        int f2039j;

        /* renamed from: k */
        float f2040k;

        /* renamed from: l */
        float f2041l;

        /* renamed from: m */
        float f2042m;

        /* renamed from: n */
        boolean f2043n;

        /* renamed from: o */
        Path f2044o;

        /* renamed from: p */
        float f2045p = 1.0f;

        /* renamed from: q */
        float f2046q;

        /* renamed from: r */
        int f2047r;

        /* renamed from: s */
        int f2048s;

        /* renamed from: t */
        int f2049t = 255;

        /* renamed from: u */
        int f2050u;

        C0693a() {
            this.f2031b.setStrokeCap(Cap.SQUARE);
            this.f2031b.setAntiAlias(true);
            this.f2031b.setStyle(Style.STROKE);
            this.f2032c.setStyle(Style.FILL);
            this.f2032c.setAntiAlias(true);
            this.f2033d.setColor(0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5952a(float width, float height) {
            this.f2047r = (int) width;
            this.f2048s = (int) height;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5955a(Canvas c, Rect bounds) {
            float arcRadius;
            RectF arcBounds = this.f2030a;
            float f = this.f2046q;
            float arcRadius2 = (this.f2037h / 2.0f) + f;
            if (f <= 0.0f) {
                arcRadius = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) this.f2047r) * this.f2045p) / 2.0f, this.f2037h / 2.0f);
            } else {
                arcRadius = arcRadius2;
            }
            arcBounds.set(((float) bounds.centerX()) - arcRadius, ((float) bounds.centerY()) - arcRadius, ((float) bounds.centerX()) + arcRadius, ((float) bounds.centerY()) + arcRadius);
            float f2 = this.f2034e;
            float f3 = this.f2036g;
            float startAngle = (f2 + f3) * 360.0f;
            float sweepAngle = ((this.f2035f + f3) * 360.0f) - startAngle;
            this.f2031b.setColor(this.f2050u);
            this.f2031b.setAlpha(this.f2049t);
            float inset = this.f2037h / 2.0f;
            arcBounds.inset(inset, inset);
            c.drawCircle(arcBounds.centerX(), arcBounds.centerY(), arcBounds.width() / 2.0f, this.f2033d);
            arcBounds.inset(-inset, -inset);
            c.drawArc(arcBounds, startAngle, sweepAngle, false, this.f2031b);
            mo5954a(c, startAngle, sweepAngle, arcBounds);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5954a(Canvas c, float startAngle, float sweepAngle, RectF bounds) {
            if (this.f2043n) {
                Path path = this.f2044o;
                if (path == null) {
                    this.f2044o = new Path();
                    this.f2044o.setFillType(FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float centerRadius = Math.min(bounds.width(), bounds.height()) / 2.0f;
                float inset = (((float) this.f2047r) * this.f2045p) / 2.0f;
                this.f2044o.moveTo(0.0f, 0.0f);
                this.f2044o.lineTo(((float) this.f2047r) * this.f2045p, 0.0f);
                Path path2 = this.f2044o;
                float f = (float) this.f2047r;
                float f2 = this.f2045p;
                path2.lineTo((f * f2) / 2.0f, ((float) this.f2048s) * f2);
                this.f2044o.offset((bounds.centerX() + centerRadius) - inset, bounds.centerY() + (this.f2037h / 2.0f));
                this.f2044o.close();
                this.f2032c.setColor(this.f2050u);
                this.f2032c.setAlpha(this.f2049t);
                c.save();
                c.rotate(startAngle + sweepAngle, bounds.centerX(), bounds.centerY());
                c.drawPath(this.f2044o, this.f2032c);
                c.restore();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5958a(int[] colors) {
            this.f2038i = colors;
            mo5964c(0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5961b(int color) {
            this.f2050u = color;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5964c(int index) {
            this.f2039j = index;
            this.f2050u = this.f2038i[this.f2039j];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public int mo5962c() {
            return this.f2038i[mo5965d()];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo5965d() {
            return (this.f2039j + 1) % this.f2038i.length;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: j */
        public void mo5974j() {
            mo5964c(mo5965d());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5956a(ColorFilter filter) {
            this.f2031b.setColorFilter(filter);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5953a(int alpha) {
            this.f2049t = alpha;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo5950a() {
            return this.f2049t;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo5970f(float strokeWidth) {
            this.f2037h = strokeWidth;
            this.f2031b.setStrokeWidth(strokeWidth);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo5968e(float startTrim) {
            this.f2034e = startTrim;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public float mo5967e() {
            return this.f2034e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: i */
        public float mo5973i() {
            return this.f2040k;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public float mo5971g() {
            return this.f2041l;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public int mo5969f() {
            return this.f2038i[this.f2039j];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5963c(float endTrim) {
            this.f2035f = endTrim;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public float mo5959b() {
            return this.f2035f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo5966d(float rotation) {
            this.f2036g = rotation;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5960b(float centerRadius) {
            this.f2046q = centerRadius;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5957a(boolean show) {
            if (this.f2043n != show) {
                this.f2043n = show;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5951a(float scale) {
            if (scale != this.f2045p) {
                this.f2045p = scale;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public float mo5972h() {
            return this.f2042m;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: l */
        public void mo5976l() {
            this.f2040k = this.f2034e;
            this.f2041l = this.f2035f;
            this.f2042m = this.f2036g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: k */
        public void mo5975k() {
            this.f2040k = 0.0f;
            this.f2041l = 0.0f;
            this.f2042m = 0.0f;
            mo5968e(0.0f);
            mo5963c(0.0f);
            mo5966d(0.0f);
        }
    }

    public C0692f(Context context) {
        C1272p.m5959a(context);
        this.f2026f = context.getResources();
        this.f2024d.mo5958a(f2023c);
        mo5941c(2.5f);
        m3266a();
    }

    /* renamed from: a */
    private void m3267a(float centerRadius, float strokeWidth, float arrowWidth, float arrowHeight) {
        C0693a ring = this.f2024d;
        float screenDensity = this.f2026f.getDisplayMetrics().density;
        ring.mo5970f(strokeWidth * screenDensity);
        ring.mo5960b(centerRadius * screenDensity);
        ring.mo5964c(0);
        ring.mo5952a(arrowWidth * screenDensity, arrowHeight * screenDensity);
    }

    /* renamed from: a */
    public void mo5937a(int size) {
        if (size == 0) {
            m3267a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m3267a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* renamed from: c */
    public void mo5941c(float strokeWidth) {
        this.f2024d.mo5970f(strokeWidth);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5938a(boolean show) {
        this.f2024d.mo5957a(show);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5935a(float scale) {
        this.f2024d.mo5951a(scale);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5936a(float start, float end) {
        this.f2024d.mo5968e(start);
        this.f2024d.mo5963c(end);
        invalidateSelf();
    }

    /* renamed from: b */
    public void mo5940b(float rotation) {
        this.f2024d.mo5966d(rotation);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5939a(int... colors) {
        this.f2024d.mo5958a(colors);
        this.f2024d.mo5964c(0);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f2025e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f2024d.mo5955a(canvas, bounds);
        canvas.restore();
    }

    public void setAlpha(int alpha) {
        this.f2024d.mo5953a(alpha);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f2024d.mo5950a();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2024d.mo5956a(colorFilter);
        invalidateSelf();
    }

    /* renamed from: d */
    private void m3275d(float rotation) {
        this.f2025e = rotation;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f2027g.isRunning();
    }

    public void start() {
        this.f2027g.cancel();
        this.f2024d.mo5976l();
        if (this.f2024d.mo5959b() != this.f2024d.mo5967e()) {
            this.f2029i = true;
            this.f2027g.setDuration(666);
            this.f2027g.start();
            return;
        }
        this.f2024d.mo5964c(0);
        this.f2024d.mo5975k();
        this.f2027g.setDuration(1332);
        this.f2027g.start();
    }

    public void stop() {
        this.f2027g.cancel();
        m3275d(0.0f);
        this.f2024d.mo5957a(false);
        this.f2024d.mo5964c(0);
        this.f2024d.mo5975k();
        invalidateSelf();
    }

    /* renamed from: a */
    private int m3265a(float fraction, int startValue, int endValue) {
        int startA = (startValue >> 24) & 255;
        int startR = (startValue >> 16) & 255;
        int startG = (startValue >> 8) & 255;
        int startB = startValue & 255;
        return ((((int) (((float) (((endValue >> 24) & 255) - startA)) * fraction)) + startA) << 24) | ((((int) (((float) (((endValue >> 16) & 255) - startR)) * fraction)) + startR) << 16) | ((((int) (((float) (((endValue >> 8) & 255) - startG)) * fraction)) + startG) << 8) | (((int) (((float) ((endValue & 255) - startB)) * fraction)) + startB);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3273b(float interpolatedTime, C0693a ring) {
        if (interpolatedTime > 0.75f) {
            ring.mo5961b(m3265a((interpolatedTime - 0.75f) / 0.25f, ring.mo5969f(), ring.mo5962c()));
        } else {
            ring.mo5961b(ring.mo5969f());
        }
    }

    /* renamed from: a */
    private void m3268a(float interpolatedTime, C0693a ring) {
        m3273b(interpolatedTime, ring);
        float targetRotation = (float) (Math.floor((double) (ring.mo5972h() / 0.8f)) + 1.0d);
        ring.mo5968e(ring.mo5973i() + (((ring.mo5971g() - 0.01f) - ring.mo5973i()) * interpolatedTime));
        ring.mo5963c(ring.mo5971g());
        ring.mo5966d(ring.mo5972h() + ((targetRotation - ring.mo5972h()) * interpolatedTime));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3269a(float interpolatedTime, C0693a ring, boolean lastFrame) {
        float startTrim;
        float scaledTime;
        if (this.f2029i) {
            m3268a(interpolatedTime, ring);
        } else if (interpolatedTime != 1.0f || lastFrame) {
            float startingRotation = ring.mo5972h();
            if (interpolatedTime < 0.5f) {
                float scaledTime2 = interpolatedTime / 0.5f;
                float startTrim2 = ring.mo5973i();
                scaledTime = startTrim2;
                startTrim = (f2022b.getInterpolation(scaledTime2) * 0.79f) + 0.01f + startTrim2;
            } else {
                startTrim = ring.mo5973i() + 0.79f;
                scaledTime = startTrim - (((1.0f - f2022b.getInterpolation((interpolatedTime - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float rotation = (0.20999998f * interpolatedTime) + startingRotation;
            float groupRotation = (this.f2028h + interpolatedTime) * 216.0f;
            ring.mo5968e(scaledTime);
            ring.mo5963c(startTrim);
            ring.mo5966d(rotation);
            m3275d(groupRotation);
        }
    }

    /* renamed from: a */
    private void m3266a() {
        C0693a ring = this.f2024d;
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        animator.addUpdateListener(new C0690d(this, ring));
        animator.setRepeatCount(-1);
        animator.setRepeatMode(1);
        animator.setInterpolator(f2021a);
        animator.addListener(new C0691e(this, ring));
        this.f2027g = animator;
    }
}
