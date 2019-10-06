package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p000v4.view.C0646w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.widget.ContentFrameLayout */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a */
    private TypedValue f2940a;

    /* renamed from: b */
    private TypedValue f2941b;

    /* renamed from: c */
    private TypedValue f2942c;

    /* renamed from: d */
    private TypedValue f2943d;

    /* renamed from: e */
    private TypedValue f2944e;

    /* renamed from: f */
    private TypedValue f2945f;

    /* renamed from: g */
    private final Rect f2946g;

    /* renamed from: h */
    private C0921a f2947h;

    /* renamed from: android.support.v7.widget.ContentFrameLayout$a */
    public interface C0921a {
        /* renamed from: a */
        void mo6275a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f2946g = new Rect();
    }

    /* renamed from: a */
    public void mo7174a(Rect insets) {
        fitSystemWindows(insets);
    }

    public void setAttachListener(C0921a attachListener) {
        this.f2947h = attachListener;
    }

    /* renamed from: a */
    public void mo7173a(int left, int top, int right, int bottom) {
        this.f2946g.set(left, top, right, bottom);
        if (C0646w.m2987u(this)) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        boolean isPortrait = metrics.widthPixels < metrics.heightPixels;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        boolean fixedWidth = false;
        if (widthMode == Integer.MIN_VALUE) {
            TypedValue tvw = isPortrait ? this.f2943d : this.f2942c;
            if (tvw != null) {
                int i = tvw.type;
                if (i != 0) {
                    int w = 0;
                    if (i == 5) {
                        w = (int) tvw.getDimension(metrics);
                    } else if (i == 6) {
                        int i2 = metrics.widthPixels;
                        w = (int) tvw.getFraction((float) i2, (float) i2);
                    }
                    if (w > 0) {
                        Rect rect = this.f2946g;
                        widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(w - (rect.left + rect.right), MeasureSpec.getSize(widthMeasureSpec)), 1073741824);
                        fixedWidth = true;
                    }
                }
            }
        }
        if (heightMode == Integer.MIN_VALUE) {
            TypedValue tvh = isPortrait ? this.f2944e : this.f2945f;
            if (tvh != null) {
                int i3 = tvh.type;
                if (i3 != 0) {
                    int h = 0;
                    if (i3 == 5) {
                        h = (int) tvh.getDimension(metrics);
                    } else if (i3 == 6) {
                        int i4 = metrics.heightPixels;
                        h = (int) tvh.getFraction((float) i4, (float) i4);
                    }
                    if (h > 0) {
                        Rect rect2 = this.f2946g;
                        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(h - (rect2.top + rect2.bottom), MeasureSpec.getSize(heightMeasureSpec)), 1073741824);
                    }
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        boolean measure = false;
        int widthMeasureSpec2 = MeasureSpec.makeMeasureSpec(width, 1073741824);
        if (!fixedWidth && widthMode == Integer.MIN_VALUE) {
            TypedValue tv = isPortrait ? this.f2941b : this.f2940a;
            if (tv != null) {
                int i5 = tv.type;
                if (i5 != 0) {
                    int min = 0;
                    if (i5 == 5) {
                        min = (int) tv.getDimension(metrics);
                    } else if (i5 == 6) {
                        int i6 = metrics.widthPixels;
                        min = (int) tv.getFraction((float) i6, (float) i6);
                    }
                    if (min > 0) {
                        Rect rect3 = this.f2946g;
                        min -= rect3.left + rect3.right;
                    }
                    if (width < min) {
                        widthMeasureSpec2 = MeasureSpec.makeMeasureSpec(min, 1073741824);
                        measure = true;
                    }
                }
            }
        }
        if (measure) {
            super.onMeasure(widthMeasureSpec2, heightMeasureSpec);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2940a == null) {
            this.f2940a = new TypedValue();
        }
        return this.f2940a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2941b == null) {
            this.f2941b = new TypedValue();
        }
        return this.f2941b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2942c == null) {
            this.f2942c = new TypedValue();
        }
        return this.f2942c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2943d == null) {
            this.f2943d = new TypedValue();
        }
        return this.f2943d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2944e == null) {
            this.f2944e = new TypedValue();
        }
        return this.f2944e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2945f == null) {
            this.f2945f = new TypedValue();
        }
        return this.f2945f;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0921a aVar = this.f2947h;
        if (aVar != null) {
            aVar.mo6275a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0921a aVar = this.f2947h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }
}
