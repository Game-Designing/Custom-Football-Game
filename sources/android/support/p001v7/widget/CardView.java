package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import p002b.p003c.p062h.p063a.C1276a;
import p002b.p003c.p062h.p063a.C1277b;
import p002b.p003c.p062h.p063a.C1279d;
import p002b.p003c.p062h.p063a.C1280e;

/* renamed from: android.support.v7.widget.CardView */
public class CardView extends FrameLayout {

    /* renamed from: a */
    private static final int[] f2930a = {16842801};

    /* renamed from: b */
    private static final C0967Q f2931b;

    /* renamed from: c */
    private boolean f2932c;

    /* renamed from: d */
    private boolean f2933d;

    /* renamed from: e */
    int f2934e;

    /* renamed from: f */
    int f2935f;

    /* renamed from: g */
    final Rect f2936g;

    /* renamed from: h */
    final Rect f2937h;

    /* renamed from: i */
    private final C0965P f2938i;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f2931b = new C0958M();
        } else if (i >= 17) {
            f2931b = new C0952L();
        } else {
            f2931b = new C0962O();
        }
        f2931b.mo7348a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attrs) {
        this(context, attrs, C1276a.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
        ColorStateList backgroundColor;
        float maxElevation;
        int i;
        super(context, attrs, defStyleAttr);
        this.f2936g = new Rect();
        this.f2937h = new Rect();
        this.f2938i = new C0947J(this);
        TypedArray a = context.obtainStyledAttributes(attrs, C1280e.CardView, defStyleAttr, C1279d.CardView);
        if (a.hasValue(C1280e.CardView_cardBackgroundColor)) {
            backgroundColor = a.getColorStateList(C1280e.CardView_cardBackgroundColor);
        } else {
            TypedArray aa = getContext().obtainStyledAttributes(f2930a);
            int themeColorBackground = aa.getColor(0, 0);
            aa.recycle();
            float[] hsv = new float[3];
            Color.colorToHSV(themeColorBackground, hsv);
            if (hsv[2] > 0.5f) {
                i = getResources().getColor(C1277b.cardview_light_background);
            } else {
                i = getResources().getColor(C1277b.cardview_dark_background);
            }
            backgroundColor = ColorStateList.valueOf(i);
        }
        float radius = a.getDimension(C1280e.CardView_cardCornerRadius, 0.0f);
        float elevation = a.getDimension(C1280e.CardView_cardElevation, 0.0f);
        float maxElevation2 = a.getDimension(C1280e.CardView_cardMaxElevation, 0.0f);
        this.f2932c = a.getBoolean(C1280e.CardView_cardUseCompatPadding, false);
        this.f2933d = a.getBoolean(C1280e.CardView_cardPreventCornerOverlap, true);
        int defaultPadding = a.getDimensionPixelSize(C1280e.CardView_contentPadding, 0);
        this.f2936g.left = a.getDimensionPixelSize(C1280e.CardView_contentPaddingLeft, defaultPadding);
        this.f2936g.top = a.getDimensionPixelSize(C1280e.CardView_contentPaddingTop, defaultPadding);
        this.f2936g.right = a.getDimensionPixelSize(C1280e.CardView_contentPaddingRight, defaultPadding);
        this.f2936g.bottom = a.getDimensionPixelSize(C1280e.CardView_contentPaddingBottom, defaultPadding);
        if (elevation > maxElevation2) {
            maxElevation = elevation;
        } else {
            maxElevation = maxElevation2;
        }
        this.f2934e = a.getDimensionPixelSize(C1280e.CardView_android_minWidth, 0);
        this.f2935f = a.getDimensionPixelSize(C1280e.CardView_android_minHeight, 0);
        a.recycle();
        f2931b.mo7417a(this.f2938i, context, backgroundColor, radius, elevation, maxElevation);
    }

    public void setPadding(int left, int top, int right, int bottom) {
    }

    public void setPaddingRelative(int start, int top, int end, int bottom) {
    }

    public boolean getUseCompatPadding() {
        return this.f2932c;
    }

    public void setUseCompatPadding(boolean useCompatPadding) {
        if (this.f2932c != useCompatPadding) {
            this.f2932c = useCompatPadding;
            f2931b.mo7427h(this.f2938i);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!(f2931b instanceof C0958M)) {
            int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            if (widthMode == Integer.MIN_VALUE || widthMode == 1073741824) {
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2931b.mo7421c(this.f2938i)), MeasureSpec.getSize(widthMeasureSpec)), widthMode);
            }
            int minWidth = MeasureSpec.getMode(heightMeasureSpec);
            if (minWidth == Integer.MIN_VALUE || minWidth == 1073741824) {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2931b.mo7415a(this.f2938i)), MeasureSpec.getSize(heightMeasureSpec)), minWidth);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setMinimumWidth(int minWidth) {
        this.f2934e = minWidth;
        super.setMinimumWidth(minWidth);
    }

    public void setMinimumHeight(int minHeight) {
        this.f2935f = minHeight;
        super.setMinimumHeight(minHeight);
    }

    public void setCardBackgroundColor(int color) {
        f2931b.mo7418a(this.f2938i, ColorStateList.valueOf(color));
    }

    public void setCardBackgroundColor(ColorStateList color) {
        f2931b.mo7418a(this.f2938i, color);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2931b.mo7425f(this.f2938i);
    }

    public int getContentPaddingLeft() {
        return this.f2936g.left;
    }

    public int getContentPaddingRight() {
        return this.f2936g.right;
    }

    public int getContentPaddingTop() {
        return this.f2936g.top;
    }

    public int getContentPaddingBottom() {
        return this.f2936g.bottom;
    }

    public void setRadius(float radius) {
        f2931b.mo7422c(this.f2938i, radius);
    }

    public float getRadius() {
        return f2931b.mo7426g(this.f2938i);
    }

    public void setCardElevation(float elevation) {
        f2931b.mo7416a(this.f2938i, elevation);
    }

    public float getCardElevation() {
        return f2931b.mo7424e(this.f2938i);
    }

    public void setMaxCardElevation(float maxElevation) {
        f2931b.mo7420b(this.f2938i, maxElevation);
    }

    public float getMaxCardElevation() {
        return f2931b.mo7423d(this.f2938i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2933d;
    }

    public void setPreventCornerOverlap(boolean preventCornerOverlap) {
        if (preventCornerOverlap != this.f2933d) {
            this.f2933d = preventCornerOverlap;
            f2931b.mo7419b(this.f2938i);
        }
    }
}
