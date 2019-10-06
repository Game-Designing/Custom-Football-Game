package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.widget.CoordinatorLayout.C0004c;
import android.support.design.widget.CoordinatorLayout.C0237b;
import android.support.design.widget.CoordinatorLayout.C0239e;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0679I;
import android.support.p001v7.widget.C1113t;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.List;
import p002b.p003c.p050d.C1170d;
import p002b.p003c.p050d.C1176j;
import p002b.p003c.p050d.C1177k;

@C0004c(Behavior.class)
public class FloatingActionButton extends C0299ja {

    /* renamed from: b */
    private ColorStateList f949b;

    /* renamed from: c */
    private Mode f950c;

    /* renamed from: d */
    private int f951d;

    /* renamed from: e */
    private int f952e;

    /* renamed from: f */
    private int f953f;

    /* renamed from: g */
    private int f954g;

    /* renamed from: h */
    int f955h;

    /* renamed from: i */
    private int f956i;

    /* renamed from: j */
    boolean f957j;

    /* renamed from: k */
    final Rect f958k;

    /* renamed from: l */
    private final Rect f959l;

    /* renamed from: m */
    private C1113t f960m;

    /* renamed from: n */
    private C0251K f961n;

    public static class Behavior extends C0237b<FloatingActionButton> {

        /* renamed from: a */
        private Rect f962a;

        /* renamed from: b */
        private C0245a f963b;

        /* renamed from: c */
        private boolean f964c;

        public Behavior() {
            this.f964c = true;
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, C1177k.FloatingActionButton_Behavior_Layout);
            this.f964c = a.getBoolean(C1177k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            a.recycle();
        }

        /* renamed from: a */
        public void mo4418a(C0239e lp) {
            if (lp.f934h == 0) {
                lp.f934h = 80;
            }
        }

        /* renamed from: a */
        public boolean mo4246b(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                m1517a(parent, (AppBarLayout) dependency, child);
            } else if (m1518a(dependency)) {
                m1520b(dependency, child);
            }
            return false;
        }

        /* renamed from: a */
        private static boolean m1518a(View view) {
            LayoutParams lp = view.getLayoutParams();
            if (lp instanceof C0239e) {
                return ((C0239e) lp).mo4442d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* renamed from: a */
        private boolean m1519a(View dependency, FloatingActionButton child) {
            C0239e lp = (C0239e) child.getLayoutParams();
            if (this.f964c && lp.mo4441c() == dependency.getId() && child.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        private boolean m1517a(CoordinatorLayout parent, AppBarLayout appBarLayout, FloatingActionButton child) {
            if (!m1519a((View) appBarLayout, child)) {
                return false;
            }
            if (this.f962a == null) {
                this.f962a = new Rect();
            }
            Rect rect = this.f962a;
            C0679I.m3163a((ViewGroup) parent, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                child.mo4453a(this.f963b, false);
            } else {
                child.mo4455b(this.f963b, false);
            }
            return true;
        }

        /* renamed from: b */
        private boolean m1520b(View bottomSheet, FloatingActionButton child) {
            if (!m1519a(bottomSheet, child)) {
                return false;
            }
            if (bottomSheet.getTop() < (child.getHeight() / 2) + ((C0239e) child.getLayoutParams()).topMargin) {
                child.mo4453a(this.f963b, false);
            } else {
                child.mo4455b(this.f963b, false);
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo4226a(CoordinatorLayout parent, FloatingActionButton child, int layoutDirection) {
            List<View> dependencies = parent.mo4368b((View) child);
            int count = dependencies.size();
            for (int i = 0; i < count; i++) {
                View dependency = (View) dependencies.get(i);
                if (!(dependency instanceof AppBarLayout)) {
                    if (m1518a(dependency) && m1520b(dependency, child)) {
                        break;
                    }
                } else if (m1517a(parent, (AppBarLayout) dependency, child)) {
                    break;
                }
            }
            parent.mo4375c((View) child, layoutDirection);
            m1516a(parent, child);
            return true;
        }

        /* renamed from: a */
        public boolean mo4423a(CoordinatorLayout parent, FloatingActionButton child, Rect rect) {
            Rect shadowPadding = child.f958k;
            rect.set(child.getLeft() + shadowPadding.left, child.getTop() + shadowPadding.top, child.getRight() - shadowPadding.right, child.getBottom() - shadowPadding.bottom);
            return true;
        }

        /* renamed from: a */
        private void m1516a(CoordinatorLayout parent, FloatingActionButton fab) {
            Rect padding = fab.f958k;
            if (padding != null && padding.centerX() > 0 && padding.centerY() > 0) {
                C0239e lp = (C0239e) fab.getLayoutParams();
                int offsetTB = 0;
                int offsetLR = 0;
                if (fab.getRight() >= parent.getWidth() - lp.rightMargin) {
                    offsetLR = padding.right;
                } else if (fab.getLeft() <= lp.leftMargin) {
                    offsetLR = -padding.left;
                }
                if (fab.getBottom() >= parent.getHeight() - lp.bottomMargin) {
                    offsetTB = padding.bottom;
                } else if (fab.getTop() <= lp.topMargin) {
                    offsetTB = -padding.top;
                }
                if (offsetTB != 0) {
                    C0646w.m2965b((View) fab, offsetTB);
                }
                if (offsetLR != 0) {
                    C0646w.m2948a((View) fab, offsetLR);
                }
            }
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$a */
    public static abstract class C0245a {
        /* renamed from: a */
        public abstract void mo4486a(FloatingActionButton floatingActionButton);

        /* renamed from: b */
        public abstract void mo4487b(FloatingActionButton floatingActionButton);
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$b */
    private class C0246b implements C0263P {
        C0246b() {
        }

        /* renamed from: b */
        public float mo4491b() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        /* renamed from: a */
        public void mo4488a(int left, int top, int right, int bottom) {
            FloatingActionButton.this.f958k.set(left, top, right, bottom);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            int i = floatingActionButton.f955h;
            floatingActionButton.setPadding(left + i, top + i, right + i, i + bottom);
        }

        /* renamed from: a */
        public void mo4489a(Drawable background) {
            FloatingActionButton.super.setBackgroundDrawable(background);
        }

        /* renamed from: a */
        public boolean mo4490a() {
            return FloatingActionButton.this.f957j;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f958k = new Rect();
        this.f959l = new Rect();
        C0289ea.m1678a(context);
        TypedArray a = context.obtainStyledAttributes(attrs, C1177k.FloatingActionButton, defStyleAttr, C1176j.Widget_Design_FloatingActionButton);
        this.f949b = a.getColorStateList(C1177k.FloatingActionButton_backgroundTint);
        this.f950c = C0295ha.m1689a(a.getInt(C1177k.FloatingActionButton_backgroundTintMode, -1), null);
        this.f952e = a.getColor(C1177k.FloatingActionButton_rippleColor, 0);
        this.f953f = a.getInt(C1177k.FloatingActionButton_fabSize, -1);
        this.f954g = a.getDimensionPixelSize(C1177k.FloatingActionButton_fabCustomSize, 0);
        this.f951d = a.getDimensionPixelSize(C1177k.FloatingActionButton_borderWidth, 0);
        float elevation = a.getDimension(C1177k.FloatingActionButton_elevation, 0.0f);
        float pressedTranslationZ = a.getDimension(C1177k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f957j = a.getBoolean(C1177k.FloatingActionButton_useCompatPadding, false);
        a.recycle();
        this.f960m = new C1113t(this);
        this.f960m.mo8665a(attrs, defStyleAttr);
        this.f956i = (int) getResources().getDimension(C1170d.design_fab_image_size);
        getImpl().mo4506a(this.f949b, this.f950c, this.f952e, this.f951d);
        getImpl().mo4502a(elevation);
        getImpl().mo4512b(pressedTranslationZ);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int preferredSize = getSizeDimension();
        this.f955h = (preferredSize - this.f956i) / 2;
        getImpl().mo4526n();
        int d = Math.min(m1509a(preferredSize, widthMeasureSpec), m1509a(preferredSize, heightMeasureSpec));
        Rect rect = this.f958k;
        setMeasuredDimension(rect.left + d + rect.right, rect.top + d + rect.bottom);
    }

    public int getRippleColor() {
        return this.f952e;
    }

    public void setRippleColor(int color) {
        if (this.f952e != color) {
            this.f952e = color;
            getImpl().mo4504a(color);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f949b;
    }

    public void setBackgroundTintList(ColorStateList tint) {
        if (this.f949b != tint) {
            this.f949b = tint;
            getImpl().mo4505a(tint);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.f950c;
    }

    public void setBackgroundTintMode(Mode tintMode) {
        if (this.f950c != tintMode) {
            this.f950c = tintMode;
            getImpl().mo4507a(tintMode);
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int resid) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int color) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int resId) {
        this.f960m.mo8662a(resId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4455b(C0245a listener, boolean fromUser) {
        getImpl().mo4514b(m1510a(listener), fromUser);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4453a(C0245a listener, boolean fromUser) {
        getImpl().mo4509a(m1510a(listener), fromUser);
    }

    public void setUseCompatPadding(boolean useCompatPadding) {
        if (this.f957j != useCompatPadding) {
            this.f957j = useCompatPadding;
            getImpl().mo4522j();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f957j;
    }

    public void setSize(int size) {
        if (size != this.f953f) {
            this.f953f = size;
            requestLayout();
        }
    }

    public int getSize() {
        return this.f953f;
    }

    /* renamed from: a */
    private C0254c m1510a(C0245a listener) {
        if (listener == null) {
            return null;
        }
        return new C0247G(this, listener);
    }

    public void setCustomSize(int size) {
        if (size >= 0) {
            this.f954g = size;
            return;
        }
        throw new IllegalArgumentException("Custom size should be non-negative.");
    }

    public int getCustomSize() {
        return this.f954g;
    }

    /* access modifiers changed from: 0000 */
    public int getSizeDimension() {
        return m1508a(this.f953f);
    }

    /* renamed from: a */
    private int m1508a(int size) {
        int i;
        Resources res = getResources();
        int i2 = this.f954g;
        if (i2 != 0) {
            return i2;
        }
        if (size == -1) {
            if (Math.max(res.getConfiguration().screenWidthDp, res.getConfiguration().screenHeightDp) < 470) {
                i = m1508a(1);
            } else {
                i = m1508a(0);
            }
            return i;
        } else if (size != 1) {
            return res.getDimensionPixelSize(C1170d.design_fab_size_normal);
        } else {
            return res.getDimensionPixelSize(C1170d.design_fab_size_mini);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().mo4521i();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().mo4523k();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo4510a(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo4518f();
    }

    /* renamed from: a */
    public boolean mo4454a(Rect rect) {
        if (!C0646w.m2987u(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        int i = rect.left;
        Rect rect2 = this.f958k;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
        return true;
    }

    public Drawable getContentBackground() {
        return getImpl().mo4511b();
    }

    /* renamed from: a */
    private static int m1509a(int desiredSize, int measureSpec) {
        int result = desiredSize;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(desiredSize, specSize);
        }
        if (specMode == 0) {
            return desiredSize;
        }
        if (specMode != 1073741824) {
            return result;
        }
        return specSize;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0 && mo4454a(this.f959l) && !this.f959l.contains((int) ev.getX(), (int) ev.getY())) {
            return false;
        }
        return super.onTouchEvent(ev);
    }

    public float getCompatElevation() {
        return getImpl().mo4515c();
    }

    public void setCompatElevation(float elevation) {
        getImpl().mo4502a(elevation);
    }

    private C0251K getImpl() {
        if (this.f961n == null) {
            this.f961n = m1511a();
        }
        return this.f961n;
    }

    /* renamed from: a */
    private C0251K m1511a() {
        if (VERSION.SDK_INT >= 21) {
            return new C0257L(this, new C0246b());
        }
        return new C0251K(this, new C0246b());
    }
}
