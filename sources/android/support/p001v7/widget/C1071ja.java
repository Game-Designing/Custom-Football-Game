package android.support.p001v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0987m;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.MotionEvent;

/* renamed from: android.support.v7.widget.ja */
/* compiled from: FastScroller */
class C1071ja extends C0980h implements C0987m {

    /* renamed from: a */
    private static final int[] f3543a = {16842919};

    /* renamed from: b */
    private static final int[] f3544b = new int[0];

    /* renamed from: A */
    private final int[] f3545A = new int[2];
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final ValueAnimator f3546B = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f3547C = 0;

    /* renamed from: D */
    private final Runnable f3548D = new C1063ha(this);

    /* renamed from: E */
    private final C0988n f3549E = new C1066ia(this);

    /* renamed from: c */
    private final int f3550c;

    /* renamed from: d */
    private final int f3551d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final StateListDrawable f3552e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Drawable f3553f;

    /* renamed from: g */
    private final int f3554g;

    /* renamed from: h */
    private final int f3555h;

    /* renamed from: i */
    private final StateListDrawable f3556i;

    /* renamed from: j */
    private final Drawable f3557j;

    /* renamed from: k */
    private final int f3558k;

    /* renamed from: l */
    private final int f3559l;

    /* renamed from: m */
    int f3560m;

    /* renamed from: n */
    int f3561n;

    /* renamed from: o */
    float f3562o;

    /* renamed from: p */
    int f3563p;

    /* renamed from: q */
    int f3564q;

    /* renamed from: r */
    float f3565r;

    /* renamed from: s */
    private int f3566s = 0;

    /* renamed from: t */
    private int f3567t = 0;

    /* renamed from: u */
    private RecyclerView f3568u;

    /* renamed from: v */
    private boolean f3569v = false;

    /* renamed from: w */
    private boolean f3570w = false;

    /* renamed from: x */
    private int f3571x = 0;

    /* renamed from: y */
    private int f3572y = 0;

    /* renamed from: z */
    private final int[] f3573z = new int[2];

    /* renamed from: android.support.v7.widget.ja$a */
    /* compiled from: FastScroller */
    private class C1072a extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f3574a;

        private C1072a() {
            this.f3574a = false;
        }

        /* synthetic */ C1072a(C1071ja x0, C1063ha x1) {
            this();
        }

        public void onAnimationEnd(Animator animation) {
            if (this.f3574a) {
                this.f3574a = false;
                return;
            }
            if (((Float) C1071ja.this.f3546B.getAnimatedValue()).floatValue() == 0.0f) {
                C1071ja.this.f3547C = 0;
                C1071ja.this.m5324c(0);
            } else {
                C1071ja.this.f3547C = 2;
                C1071ja.this.m5329g();
            }
        }

        public void onAnimationCancel(Animator animation) {
            this.f3574a = true;
        }
    }

    /* renamed from: android.support.v7.widget.ja$b */
    /* compiled from: FastScroller */
    private class C1073b implements AnimatorUpdateListener {
        private C1073b() {
        }

        /* synthetic */ C1073b(C1071ja x0, C1063ha x1) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int alpha = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C1071ja.this.f3552e.setAlpha(alpha);
            C1071ja.this.f3553f.setAlpha(alpha);
            C1071ja.this.m5329g();
        }
    }

    C1071ja(RecyclerView recyclerView, StateListDrawable verticalThumbDrawable, Drawable verticalTrackDrawable, StateListDrawable horizontalThumbDrawable, Drawable horizontalTrackDrawable, int defaultWidth, int scrollbarMinimumRange, int margin) {
        this.f3552e = verticalThumbDrawable;
        this.f3553f = verticalTrackDrawable;
        this.f3556i = horizontalThumbDrawable;
        this.f3557j = horizontalTrackDrawable;
        this.f3554g = Math.max(defaultWidth, verticalThumbDrawable.getIntrinsicWidth());
        this.f3555h = Math.max(defaultWidth, verticalTrackDrawable.getIntrinsicWidth());
        this.f3558k = Math.max(defaultWidth, horizontalThumbDrawable.getIntrinsicWidth());
        this.f3559l = Math.max(defaultWidth, horizontalTrackDrawable.getIntrinsicWidth());
        this.f3550c = scrollbarMinimumRange;
        this.f3551d = margin;
        this.f3552e.setAlpha(255);
        this.f3553f.setAlpha(255);
        this.f3546B.addListener(new C1072a(this, null));
        this.f3546B.addUpdateListener(new C1073b(this, null));
        mo8491a(recyclerView);
    }

    /* renamed from: a */
    public void mo8491a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3568u;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                m5323c();
            }
            this.f3568u = recyclerView;
            if (this.f3568u != null) {
                m5330h();
            }
        }
    }

    /* renamed from: h */
    private void m5330h() {
        this.f3568u.mo7527a((C0980h) this);
        this.f3568u.mo7529a((C0987m) this);
        this.f3568u.mo7530a(this.f3549E);
    }

    /* renamed from: c */
    private void m5323c() {
        this.f3568u.mo7547b((C0980h) this);
        this.f3568u.mo7548b((C0987m) this);
        this.f3568u.mo7549b(this.f3549E);
        m5316b();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m5329g() {
        this.f3568u.invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5324c(int state) {
        if (state == 2 && this.f3571x != 2) {
            this.f3552e.setState(f3543a);
            m5316b();
        }
        if (state == 0) {
            m5329g();
        } else {
            mo8488a();
        }
        if (this.f3571x == 2 && state != 2) {
            this.f3552e.setState(f3544b);
            m5318b(1200);
        } else if (state == 1) {
            m5318b(1500);
        }
        this.f3571x = state;
    }

    /* renamed from: f */
    private boolean m5328f() {
        return C0646w.m2974h(this.f3568u) == 1;
    }

    /* renamed from: a */
    public void mo8488a() {
        int i = this.f3547C;
        if (i != 0) {
            if (i == 3) {
                this.f3546B.cancel();
            } else {
                return;
            }
        }
        this.f3547C = 1;
        ValueAnimator valueAnimator = this.f3546B;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f3546B.setDuration(500);
        this.f3546B.setStartDelay(0);
        this.f3546B.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8489a(int duration) {
        int i = this.f3547C;
        if (i == 1) {
            this.f3546B.cancel();
        } else if (i != 2) {
            return;
        }
        this.f3547C = 3;
        ValueAnimator valueAnimator = this.f3546B;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f3546B.setDuration((long) duration);
        this.f3546B.start();
    }

    /* renamed from: b */
    private void m5316b() {
        this.f3568u.removeCallbacks(this.f3548D);
    }

    /* renamed from: b */
    private void m5318b(int delay) {
        m5316b();
        this.f3568u.postDelayed(this.f3548D, (long) delay);
    }

    public void onDrawOver(Canvas canvas, RecyclerView parent, C0997t state) {
        if (this.f3566s == this.f3568u.getWidth() && this.f3567t == this.f3568u.getHeight()) {
            if (this.f3547C != 0) {
                if (this.f3569v) {
                    m5319b(canvas);
                }
                if (this.f3570w) {
                    m5315a(canvas);
                }
            }
            return;
        }
        this.f3566s = this.f3568u.getWidth();
        this.f3567t = this.f3568u.getHeight();
        m5324c(0);
    }

    /* renamed from: b */
    private void m5319b(Canvas canvas) {
        int viewWidth = this.f3566s;
        int i = this.f3554g;
        int left = viewWidth - i;
        int i2 = this.f3561n;
        int i3 = this.f3560m;
        int top = i2 - (i3 / 2);
        this.f3552e.setBounds(0, 0, i, i3);
        this.f3553f.setBounds(0, 0, this.f3555h, this.f3567t);
        if (m5328f()) {
            this.f3553f.draw(canvas);
            canvas.translate((float) this.f3554g, (float) top);
            canvas.scale(-1.0f, 1.0f);
            this.f3552e.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f3554g), (float) (-top));
            return;
        }
        canvas.translate((float) left, 0.0f);
        this.f3553f.draw(canvas);
        canvas.translate(0.0f, (float) top);
        this.f3552e.draw(canvas);
        canvas.translate((float) (-left), (float) (-top));
    }

    /* renamed from: a */
    private void m5315a(Canvas canvas) {
        int viewHeight = this.f3567t;
        int i = this.f3558k;
        int top = viewHeight - i;
        int i2 = this.f3564q;
        int i3 = this.f3563p;
        int left = i2 - (i3 / 2);
        this.f3556i.setBounds(0, 0, i3, i);
        this.f3557j.setBounds(0, 0, this.f3566s, this.f3559l);
        canvas.translate(0.0f, (float) top);
        this.f3557j.draw(canvas);
        canvas.translate((float) left, 0.0f);
        this.f3556i.draw(canvas);
        canvas.translate((float) (-left), (float) (-top));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8490a(int offsetX, int offsetY) {
        int verticalContentLength = this.f3568u.computeVerticalScrollRange();
        int verticalVisibleLength = this.f3567t;
        this.f3569v = verticalContentLength - verticalVisibleLength > 0 && this.f3567t >= this.f3550c;
        int horizontalContentLength = this.f3568u.computeHorizontalScrollRange();
        int horizontalVisibleLength = this.f3566s;
        this.f3570w = horizontalContentLength - horizontalVisibleLength > 0 && this.f3566s >= this.f3550c;
        if (this.f3569v || this.f3570w) {
            if (this.f3569v) {
                this.f3561n = (int) ((((float) verticalVisibleLength) * (((float) offsetY) + (((float) verticalVisibleLength) / 2.0f))) / ((float) verticalContentLength));
                this.f3560m = Math.min(verticalVisibleLength, (verticalVisibleLength * verticalVisibleLength) / verticalContentLength);
            }
            if (this.f3570w) {
                this.f3564q = (int) ((((float) horizontalVisibleLength) * (((float) offsetX) + (((float) horizontalVisibleLength) / 2.0f))) / ((float) horizontalContentLength));
                this.f3563p = Math.min(horizontalVisibleLength, (horizontalVisibleLength * horizontalVisibleLength) / horizontalContentLength);
            }
            int i = this.f3571x;
            if (i == 0 || i == 1) {
                m5324c(1);
            }
            return;
        }
        if (this.f3571x != 0) {
            m5324c(0);
        }
    }

    /* renamed from: b */
    public boolean mo7873b(RecyclerView recyclerView, MotionEvent ev) {
        int i = this.f3571x;
        if (i == 1) {
            boolean insideVerticalThumb = mo8493b(ev.getX(), ev.getY());
            boolean insideHorizontalThumb = mo8492a(ev.getX(), ev.getY());
            if (ev.getAction() != 0 || (!insideVerticalThumb && !insideHorizontalThumb)) {
                return false;
            }
            if (insideHorizontalThumb) {
                this.f3572y = 1;
                this.f3565r = (float) ((int) ev.getX());
            } else if (insideVerticalThumb) {
                this.f3572y = 2;
                this.f3562o = (float) ((int) ev.getY());
            }
            m5324c(2);
            return true;
        } else if (i == 2) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public void mo7871a(RecyclerView recyclerView, MotionEvent me) {
        if (this.f3571x != 0) {
            if (me.getAction() == 0) {
                boolean insideVerticalThumb = mo8493b(me.getX(), me.getY());
                boolean insideHorizontalThumb = mo8492a(me.getX(), me.getY());
                if (insideVerticalThumb || insideHorizontalThumb) {
                    if (insideHorizontalThumb) {
                        this.f3572y = 1;
                        this.f3565r = (float) ((int) me.getX());
                    } else if (insideVerticalThumb) {
                        this.f3572y = 2;
                        this.f3562o = (float) ((int) me.getY());
                    }
                    m5324c(2);
                }
            } else if (me.getAction() == 1 && this.f3571x == 2) {
                this.f3562o = 0.0f;
                this.f3565r = 0.0f;
                m5324c(1);
                this.f3572y = 0;
            } else if (me.getAction() == 2 && this.f3571x == 2) {
                mo8488a();
                if (this.f3572y == 1) {
                    m5314a(me.getX());
                }
                if (this.f3572y == 2) {
                    m5317b(me.getY());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo7872a(boolean disallowIntercept) {
    }

    /* renamed from: b */
    private void m5317b(float y) {
        int[] scrollbarRange = m5327e();
        float y2 = Math.max((float) scrollbarRange[0], Math.min((float) scrollbarRange[1], y));
        if (Math.abs(((float) this.f3561n) - y2) >= 2.0f) {
            int scrollingBy = m5311a(this.f3562o, y2, scrollbarRange, this.f3568u.computeVerticalScrollRange(), this.f3568u.computeVerticalScrollOffset(), this.f3567t);
            if (scrollingBy != 0) {
                this.f3568u.scrollBy(0, scrollingBy);
            }
            this.f3562o = y2;
        }
    }

    /* renamed from: a */
    private void m5314a(float x) {
        int[] scrollbarRange = m5326d();
        float x2 = Math.max((float) scrollbarRange[0], Math.min((float) scrollbarRange[1], x));
        if (Math.abs(((float) this.f3564q) - x2) >= 2.0f) {
            int scrollingBy = m5311a(this.f3565r, x2, scrollbarRange, this.f3568u.computeHorizontalScrollRange(), this.f3568u.computeHorizontalScrollOffset(), this.f3566s);
            if (scrollingBy != 0) {
                this.f3568u.scrollBy(scrollingBy, 0);
            }
            this.f3565r = x2;
        }
    }

    /* renamed from: a */
    private int m5311a(float oldDragPos, float newDragPos, int[] scrollbarRange, int scrollRange, int scrollOffset, int viewLength) {
        int scrollbarLength = scrollbarRange[1] - scrollbarRange[0];
        if (scrollbarLength == 0) {
            return 0;
        }
        int totalPossibleOffset = scrollRange - viewLength;
        int scrollingBy = (int) (((float) totalPossibleOffset) * ((newDragPos - oldDragPos) / ((float) scrollbarLength)));
        int absoluteOffset = scrollOffset + scrollingBy;
        if (absoluteOffset >= totalPossibleOffset || absoluteOffset < 0) {
            return 0;
        }
        return scrollingBy;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8493b(float x, float y) {
        if (!m5328f() ? x >= ((float) (this.f3566s - this.f3554g)) : x <= ((float) (this.f3554g / 2))) {
            int i = this.f3561n;
            int i2 = this.f3560m;
            if (y >= ((float) (i - (i2 / 2))) && y <= ((float) (i + (i2 / 2)))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8492a(float x, float y) {
        if (y >= ((float) (this.f3567t - this.f3558k))) {
            int i = this.f3564q;
            int i2 = this.f3563p;
            if (x >= ((float) (i - (i2 / 2))) && x <= ((float) (i + (i2 / 2)))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private int[] m5327e() {
        int[] iArr = this.f3573z;
        int i = this.f3551d;
        iArr[0] = i;
        iArr[1] = this.f3567t - i;
        return iArr;
    }

    /* renamed from: d */
    private int[] m5326d() {
        int[] iArr = this.f3545A;
        int i = this.f3551d;
        iArr[0] = i;
        iArr[1] = this.f3566s - i;
        return iArr;
    }
}
