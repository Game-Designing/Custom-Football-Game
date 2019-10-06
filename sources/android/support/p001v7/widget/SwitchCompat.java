package android.support.p001v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p062h.p064b.p065a.C1282b;
import p002b.p003c.p062h.p069e.C1288a;

/* renamed from: android.support.v7.widget.SwitchCompat */
public class SwitchCompat extends CompoundButton {

    /* renamed from: a */
    private static final Property<SwitchCompat, Float> f3333a = new C1087mb(Float.class, "thumbPos");

    /* renamed from: b */
    private static final int[] f3334b = {16842912};

    /* renamed from: A */
    private int f3335A;

    /* renamed from: B */
    private int f3336B;

    /* renamed from: C */
    private int f3337C;

    /* renamed from: D */
    private int f3338D;

    /* renamed from: E */
    private int f3339E;

    /* renamed from: F */
    private int f3340F;

    /* renamed from: G */
    private int f3341G;

    /* renamed from: H */
    private final TextPaint f3342H;

    /* renamed from: I */
    private ColorStateList f3343I;

    /* renamed from: J */
    private Layout f3344J;

    /* renamed from: K */
    private Layout f3345K;

    /* renamed from: L */
    private TransformationMethod f3346L;

    /* renamed from: M */
    ObjectAnimator f3347M;

    /* renamed from: N */
    private final Rect f3348N;

    /* renamed from: c */
    private Drawable f3349c;

    /* renamed from: d */
    private ColorStateList f3350d;

    /* renamed from: e */
    private Mode f3351e;

    /* renamed from: f */
    private boolean f3352f;

    /* renamed from: g */
    private boolean f3353g;

    /* renamed from: h */
    private Drawable f3354h;

    /* renamed from: i */
    private ColorStateList f3355i;

    /* renamed from: j */
    private Mode f3356j;

    /* renamed from: k */
    private boolean f3357k;

    /* renamed from: l */
    private boolean f3358l;

    /* renamed from: m */
    private int f3359m;

    /* renamed from: n */
    private int f3360n;

    /* renamed from: o */
    private int f3361o;

    /* renamed from: p */
    private boolean f3362p;

    /* renamed from: q */
    private CharSequence f3363q;

    /* renamed from: r */
    private CharSequence f3364r;

    /* renamed from: s */
    private boolean f3365s;

    /* renamed from: t */
    private int f3366t;

    /* renamed from: u */
    private int f3367u;

    /* renamed from: v */
    private float f3368v;

    /* renamed from: w */
    private float f3369w;

    /* renamed from: x */
    private VelocityTracker f3370x;

    /* renamed from: y */
    private int f3371y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public float f3372z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3350d = null;
        this.f3351e = null;
        this.f3352f = false;
        this.f3353g = false;
        this.f3355i = null;
        this.f3356j = null;
        this.f3357k = false;
        this.f3358l = false;
        this.f3370x = VelocityTracker.obtain();
        this.f3348N = new Rect();
        this.f3342H = new TextPaint(1);
        Resources res = getResources();
        this.f3342H.density = res.getDisplayMetrics().density;
        C1112sb a = C1112sb.m5456a(context, attrs, C0793R.styleable.SwitchCompat, defStyleAttr, 0);
        this.f3349c = a.mo8650b(C0793R.styleable.SwitchCompat_android_thumb);
        Drawable drawable = this.f3349c;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f3354h = a.mo8650b(C0793R.styleable.SwitchCompat_track);
        Drawable drawable2 = this.f3354h;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.f3363q = a.mo8656e(C0793R.styleable.SwitchCompat_android_textOn);
        this.f3364r = a.mo8656e(C0793R.styleable.SwitchCompat_android_textOff);
        this.f3365s = a.mo8648a(C0793R.styleable.SwitchCompat_showText, true);
        this.f3359m = a.mo8651c(C0793R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f3360n = a.mo8651c(C0793R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f3361o = a.mo8651c(C0793R.styleable.SwitchCompat_switchPadding, 0);
        this.f3362p = a.mo8648a(C0793R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList thumbTintList = a.mo8645a(C0793R.styleable.SwitchCompat_thumbTint);
        if (thumbTintList != null) {
            this.f3350d = thumbTintList;
            this.f3352f = true;
        }
        Mode thumbTintMode = C1052ea.m5227a(a.mo8653d(C0793R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f3351e != thumbTintMode) {
            this.f3351e = thumbTintMode;
            this.f3353g = true;
        }
        if (this.f3352f || this.f3353g) {
            m5109a();
        }
        ColorStateList trackTintList = a.mo8645a(C0793R.styleable.SwitchCompat_trackTint);
        if (trackTintList != null) {
            this.f3355i = trackTintList;
            this.f3357k = true;
        }
        Mode trackTintMode = C1052ea.m5227a(a.mo8653d(C0793R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f3356j != trackTintMode) {
            this.f3356j = trackTintMode;
            this.f3358l = true;
        }
        if (this.f3357k || this.f3358l) {
            m5114b();
        }
        int appearance = a.mo8659g(C0793R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (appearance != 0) {
            mo8184a(context, appearance);
        }
        a.mo8647a();
        ViewConfiguration config = ViewConfiguration.get(context);
        this.f3367u = config.getScaledTouchSlop();
        this.f3371y = config.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    /* renamed from: a */
    public void mo8184a(Context context, int resid) {
        C1112sb appearance = C1112sb.m5454a(context, resid, C0793R.styleable.TextAppearance);
        ColorStateList colors = appearance.mo8645a(C0793R.styleable.TextAppearance_android_textColor);
        if (colors != null) {
            this.f3343I = colors;
        } else {
            this.f3343I = getTextColors();
        }
        int ts = appearance.mo8651c(C0793R.styleable.TextAppearance_android_textSize, 0);
        if (!(ts == 0 || ((float) ts) == this.f3342H.getTextSize())) {
            this.f3342H.setTextSize((float) ts);
            requestLayout();
        }
        m5110a(appearance.mo8653d(C0793R.styleable.TextAppearance_android_typeface, -1), appearance.mo8653d(C0793R.styleable.TextAppearance_android_textStyle, -1));
        if (appearance.mo8648a(C0793R.styleable.TextAppearance_textAllCaps, false)) {
            this.f3346L = new C1288a(getContext());
        } else {
            this.f3346L = null;
        }
        appearance.mo8647a();
    }

    /* renamed from: a */
    private void m5110a(int typefaceIndex, int styleIndex) {
        Typeface tf = null;
        if (typefaceIndex == 1) {
            tf = Typeface.SANS_SERIF;
        } else if (typefaceIndex == 2) {
            tf = Typeface.SERIF;
        } else if (typefaceIndex == 3) {
            tf = Typeface.MONOSPACE;
        }
        mo8185a(tf, styleIndex);
    }

    /* renamed from: a */
    public void mo8185a(Typeface tf, int style) {
        Typeface tf2;
        float f = 0.0f;
        boolean z = false;
        if (style > 0) {
            if (tf == null) {
                tf2 = Typeface.defaultFromStyle(style);
            } else {
                tf2 = Typeface.create(tf, style);
            }
            setSwitchTypeface(tf2);
            int need = ((tf2 != null ? tf2.getStyle() : 0) ^ -1) & style;
            TextPaint textPaint = this.f3342H;
            if ((need & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.f3342H;
            if ((need & 2) != 0) {
                f = -0.25f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.f3342H.setFakeBoldText(false);
        this.f3342H.setTextSkewX(0.0f);
        setSwitchTypeface(tf);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f3342H.getTypeface() != null && !this.f3342H.getTypeface().equals(typeface)) || (this.f3342H.getTypeface() == null && typeface != null)) {
            this.f3342H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int pixels) {
        this.f3361o = pixels;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f3361o;
    }

    public void setSwitchMinWidth(int pixels) {
        this.f3360n = pixels;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f3360n;
    }

    public void setThumbTextPadding(int pixels) {
        this.f3359m = pixels;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f3359m;
    }

    public void setTrackDrawable(Drawable track) {
        Drawable drawable = this.f3354h;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f3354h = track;
        if (track != null) {
            track.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int resId) {
        setTrackDrawable(C1282b.m6000b(getContext(), resId));
    }

    public Drawable getTrackDrawable() {
        return this.f3354h;
    }

    public void setTrackTintList(ColorStateList tint) {
        this.f3355i = tint;
        this.f3357k = true;
        m5114b();
    }

    public ColorStateList getTrackTintList() {
        return this.f3355i;
    }

    public void setTrackTintMode(Mode tintMode) {
        this.f3356j = tintMode;
        this.f3358l = true;
        m5114b();
    }

    public Mode getTrackTintMode() {
        return this.f3356j;
    }

    /* renamed from: b */
    private void m5114b() {
        if (this.f3354h == null) {
            return;
        }
        if (this.f3357k || this.f3358l) {
            this.f3354h = this.f3354h.mutate();
            if (this.f3357k) {
                C1200a.m5726a(this.f3354h, this.f3355i);
            }
            if (this.f3358l) {
                C1200a.m5729a(this.f3354h, this.f3356j);
            }
            if (this.f3354h.isStateful()) {
                this.f3354h.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable thumb) {
        Drawable drawable = this.f3349c;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f3349c = thumb;
        if (thumb != null) {
            thumb.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int resId) {
        setThumbDrawable(C1282b.m6000b(getContext(), resId));
    }

    public Drawable getThumbDrawable() {
        return this.f3349c;
    }

    public void setThumbTintList(ColorStateList tint) {
        this.f3350d = tint;
        this.f3352f = true;
        m5109a();
    }

    public ColorStateList getThumbTintList() {
        return this.f3350d;
    }

    public void setThumbTintMode(Mode tintMode) {
        this.f3351e = tintMode;
        this.f3353g = true;
        m5109a();
    }

    public Mode getThumbTintMode() {
        return this.f3351e;
    }

    /* renamed from: a */
    private void m5109a() {
        if (this.f3349c == null) {
            return;
        }
        if (this.f3352f || this.f3353g) {
            this.f3349c = this.f3349c.mutate();
            if (this.f3352f) {
                C1200a.m5726a(this.f3349c, this.f3350d);
            }
            if (this.f3353g) {
                C1200a.m5729a(this.f3349c, this.f3351e);
            }
            if (this.f3349c.isStateful()) {
                this.f3349c.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean splitTrack) {
        this.f3362p = splitTrack;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f3362p;
    }

    public CharSequence getTextOn() {
        return this.f3363q;
    }

    public void setTextOn(CharSequence textOn) {
        this.f3363q = textOn;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f3364r;
    }

    public void setTextOff(CharSequence textOff) {
        this.f3364r = textOff;
        requestLayout();
    }

    public void setShowText(boolean showText) {
        if (this.f3365s != showText) {
            this.f3365s = showText;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f3365s;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int thumbHeight;
        int thumbWidth;
        int maxTextWidth;
        int trackHeight;
        if (this.f3365s) {
            if (this.f3344J == null) {
                this.f3344J = m5108a(this.f3363q);
            }
            if (this.f3345K == null) {
                this.f3345K = m5108a(this.f3364r);
            }
        }
        Rect padding = this.f3348N;
        Drawable drawable = this.f3349c;
        if (drawable != null) {
            drawable.getPadding(padding);
            thumbWidth = (this.f3349c.getIntrinsicWidth() - padding.left) - padding.right;
            thumbHeight = this.f3349c.getIntrinsicHeight();
        } else {
            thumbWidth = 0;
            thumbHeight = 0;
        }
        if (this.f3365s) {
            maxTextWidth = Math.max(this.f3344J.getWidth(), this.f3345K.getWidth()) + (this.f3359m * 2);
        } else {
            maxTextWidth = 0;
        }
        this.f3337C = Math.max(maxTextWidth, thumbWidth);
        Drawable drawable2 = this.f3354h;
        if (drawable2 != null) {
            drawable2.getPadding(padding);
            trackHeight = this.f3354h.getIntrinsicHeight();
        } else {
            padding.setEmpty();
            trackHeight = 0;
        }
        int paddingLeft = padding.left;
        int paddingRight = padding.right;
        Drawable drawable3 = this.f3349c;
        if (drawable3 != null) {
            Rect inset = C1052ea.m5230c(drawable3);
            paddingLeft = Math.max(paddingLeft, inset.left);
            paddingRight = Math.max(paddingRight, inset.right);
        }
        int switchWidth = Math.max(this.f3360n, (this.f3337C * 2) + paddingLeft + paddingRight);
        int switchHeight = Math.max(trackHeight, thumbHeight);
        this.f3335A = switchWidth;
        this.f3336B = switchHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredHeight() < switchHeight) {
            setMeasuredDimension(getMeasuredWidthAndState(), switchHeight);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        CharSequence text = isChecked() ? this.f3363q : this.f3364r;
        if (text != null) {
            event.getText().add(text);
        }
    }

    /* renamed from: a */
    private Layout m5108a(CharSequence text) {
        TransformationMethod transformationMethod = this.f3346L;
        CharSequence transformed = transformationMethod != null ? transformationMethod.getTransformation(text, this) : text;
        TextPaint textPaint = this.f3342H;
        StaticLayout staticLayout = new StaticLayout(transformed, textPaint, transformed != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformed, textPaint)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        return staticLayout;
    }

    /* renamed from: a */
    private boolean m5113a(float x, float y) {
        boolean z = false;
        if (this.f3349c == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f3349c.getPadding(this.f3348N);
        int i = this.f3339E;
        int i2 = this.f3367u;
        int thumbTop = i - i2;
        int thumbLeft = (this.f3338D + thumbOffset) - i2;
        int i3 = this.f3337C + thumbLeft;
        Rect rect = this.f3348N;
        int thumbRight = i3 + rect.left + rect.right + i2;
        int thumbBottom = this.f3341G + i2;
        if (x > ((float) thumbLeft) && x < ((float) thumbRight) && y > ((float) thumbTop) && y < ((float) thumbBottom)) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            android.view.VelocityTracker r0 = r9.f3370x
            r0.addMovement(r10)
            int r0 = r10.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x00a1
            r2 = 2
            if (r0 == r1) goto L_0x008d
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008d
            goto L_0x00bb
        L_0x0016:
            int r3 = r9.f3366t
            if (r3 == 0) goto L_0x008b
            if (r3 == r1) goto L_0x0057
            if (r3 == r2) goto L_0x001f
            goto L_0x008c
        L_0x001f:
            float r2 = r10.getX()
            int r3 = r9.getThumbScrollRange()
            float r4 = r9.f3368v
            float r4 = r2 - r4
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            if (r3 == 0) goto L_0x0034
            float r7 = (float) r3
            float r7 = r4 / r7
            goto L_0x003d
        L_0x0034:
            int r7 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x003b
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x003b:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003d:
            boolean r8 = android.support.p001v7.widget.C0946Ib.m4565a(r9)
            if (r8 == 0) goto L_0x0044
            float r7 = -r7
        L_0x0044:
            float r8 = r9.f3372z
            float r8 = r8 + r7
            float r5 = m5106a(r8, r6, r5)
            float r6 = r9.f3372z
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0056
            r9.f3368v = r2
            r9.setThumbPosition(r5)
        L_0x0056:
            return r1
        L_0x0057:
            float r3 = r10.getX()
            float r4 = r10.getY()
            float r5 = r9.f3368v
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r9.f3367u
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x007d
            float r5 = r9.f3369w
            float r5 = r4 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r9.f3367u
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x008c
        L_0x007d:
            r9.f3366t = r2
            android.view.ViewParent r2 = r9.getParent()
            r2.requestDisallowInterceptTouchEvent(r1)
            r9.f3368v = r3
            r9.f3369w = r4
            return r1
        L_0x008b:
        L_0x008c:
            goto L_0x00bb
        L_0x008d:
            int r3 = r9.f3366t
            if (r3 != r2) goto L_0x0098
            r9.m5115b(r10)
            super.onTouchEvent(r10)
            return r1
        L_0x0098:
            r1 = 0
            r9.f3366t = r1
            android.view.VelocityTracker r1 = r9.f3370x
            r1.clear()
            goto L_0x00bb
        L_0x00a1:
            float r2 = r10.getX()
            float r3 = r10.getY()
            boolean r4 = r9.isEnabled()
            if (r4 == 0) goto L_0x00bb
            boolean r4 = r9.m5113a(r2, r3)
            if (r4 == 0) goto L_0x00bb
            r9.f3366t = r1
            r9.f3368v = r2
            r9.f3369w = r3
        L_0x00bb:
            boolean r1 = super.onTouchEvent(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m5111a(MotionEvent ev) {
        MotionEvent cancel = MotionEvent.obtain(ev);
        cancel.setAction(3);
        super.onTouchEvent(cancel);
        cancel.recycle();
    }

    /* renamed from: b */
    private void m5115b(MotionEvent ev) {
        this.f3366t = 0;
        boolean newState = true;
        boolean commitChange = ev.getAction() == 1 && isEnabled();
        boolean oldState = isChecked();
        if (commitChange) {
            this.f3370x.computeCurrentVelocity(1000);
            float xvel = this.f3370x.getXVelocity();
            if (Math.abs(xvel) <= ((float) this.f3371y)) {
                newState = getTargetCheckedState();
            } else if (!C0946Ib.m4565a(this) ? xvel <= 0.0f : xvel >= 0.0f) {
                newState = false;
            }
        } else {
            newState = oldState;
        }
        if (newState != oldState) {
            playSoundEffect(0);
        }
        setChecked(newState);
        m5111a(ev);
    }

    /* renamed from: a */
    private void m5112a(boolean newCheckedState) {
        this.f3347M = ObjectAnimator.ofFloat(this, f3333a, new float[]{newCheckedState ? 1.0f : 0.0f});
        this.f3347M.setDuration(250);
        if (VERSION.SDK_INT >= 18) {
            this.f3347M.setAutoCancel(true);
        }
        this.f3347M.start();
    }

    /* renamed from: c */
    private void m5116c() {
        ObjectAnimator objectAnimator = this.f3347M;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.f3372z > 0.5f;
    }

    /* access modifiers changed from: 0000 */
    public void setThumbPosition(float position) {
        this.f3372z = position;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean checked) {
        super.setChecked(checked);
        boolean checked2 = isChecked();
        if (getWindowToken() == null || !C0646w.m2987u(this)) {
            m5116c();
            setThumbPosition(checked2 ? 1.0f : 0.0f);
            return;
        }
        m5112a(checked2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int switchRight;
        int switchLeft;
        int switchBottom;
        int switchTop;
        super.onLayout(changed, left, top, right, bottom);
        int opticalInsetLeft = 0;
        int opticalInsetRight = 0;
        if (this.f3349c != null) {
            Rect trackPadding = this.f3348N;
            Drawable drawable = this.f3354h;
            if (drawable != null) {
                drawable.getPadding(trackPadding);
            } else {
                trackPadding.setEmpty();
            }
            Rect insets = C1052ea.m5230c(this.f3349c);
            opticalInsetLeft = Math.max(0, insets.left - trackPadding.left);
            opticalInsetRight = Math.max(0, insets.right - trackPadding.right);
        }
        if (C0946Ib.m4565a(this)) {
            switchLeft = getPaddingLeft() + opticalInsetLeft;
            switchRight = ((this.f3335A + switchLeft) - opticalInsetLeft) - opticalInsetRight;
        } else {
            switchRight = (getWidth() - getPaddingRight()) - opticalInsetRight;
            switchLeft = (switchRight - this.f3335A) + opticalInsetLeft + opticalInsetRight;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            int i = this.f3336B;
            switchBottom = paddingTop - (i / 2);
            switchTop = switchBottom + i;
        } else if (gravity != 80) {
            int switchTop2 = getPaddingTop();
            switchBottom = switchTop2;
            switchTop = this.f3336B + switchTop2;
        } else {
            switchTop = getHeight() - getPaddingBottom();
            switchBottom = switchTop - this.f3336B;
        }
        this.f3338D = switchLeft;
        this.f3339E = switchBottom;
        this.f3341G = switchTop;
        this.f3340F = switchRight;
    }

    public void draw(Canvas c) {
        Rect thumbInsets;
        Rect padding = this.f3348N;
        int switchLeft = this.f3338D;
        int switchTop = this.f3339E;
        int switchRight = this.f3340F;
        int switchBottom = this.f3341G;
        int thumbInitialLeft = getThumbOffset() + switchLeft;
        Drawable drawable = this.f3349c;
        if (drawable != null) {
            thumbInsets = C1052ea.m5230c(drawable);
        } else {
            thumbInsets = C1052ea.f3502a;
        }
        Drawable drawable2 = this.f3354h;
        if (drawable2 != null) {
            drawable2.getPadding(padding);
            int i = padding.left;
            thumbInitialLeft += i;
            int trackLeft = switchLeft;
            int trackTop = switchTop;
            int trackRight = switchRight;
            int trackBottom = switchBottom;
            if (thumbInsets != null) {
                int i2 = thumbInsets.left;
                if (i2 > i) {
                    trackLeft += i2 - i;
                }
                int i3 = thumbInsets.top;
                int i4 = padding.top;
                if (i3 > i4) {
                    trackTop += i3 - i4;
                }
                int i5 = thumbInsets.right;
                int i6 = padding.right;
                if (i5 > i6) {
                    trackRight -= i5 - i6;
                }
                int i7 = thumbInsets.bottom;
                int i8 = padding.bottom;
                if (i7 > i8) {
                    trackBottom -= i7 - i8;
                }
            }
            this.f3354h.setBounds(trackLeft, trackTop, trackRight, trackBottom);
        }
        Drawable drawable3 = this.f3349c;
        if (drawable3 != null) {
            drawable3.getPadding(padding);
            int thumbLeft = thumbInitialLeft - padding.left;
            int thumbRight = this.f3337C + thumbInitialLeft + padding.right;
            this.f3349c.setBounds(thumbLeft, switchTop, thumbRight, switchBottom);
            Drawable background = getBackground();
            if (background != null) {
                C1200a.m5725a(background, thumbLeft, switchTop, thumbRight, switchBottom);
            }
        }
        super.draw(c);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int cX;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        Rect padding = this.f3348N;
        Drawable trackDrawable = this.f3354h;
        if (trackDrawable != null) {
            trackDrawable.getPadding(padding);
        } else {
            padding.setEmpty();
        }
        int switchInnerTop = padding.top + this.f3339E;
        int switchInnerBottom = this.f3341G - padding.bottom;
        Drawable thumbDrawable = this.f3349c;
        if (trackDrawable != null) {
            if (!this.f3362p || thumbDrawable == null) {
                trackDrawable.draw(canvas2);
            } else {
                Rect insets = C1052ea.m5230c(thumbDrawable);
                thumbDrawable.copyBounds(padding);
                padding.left += insets.left;
                padding.right -= insets.right;
                int saveCount = canvas.save();
                canvas2.clipRect(padding, Op.DIFFERENCE);
                trackDrawable.draw(canvas2);
                canvas2.restoreToCount(saveCount);
            }
        }
        int saveCount2 = canvas.save();
        if (thumbDrawable != null) {
            thumbDrawable.draw(canvas2);
        }
        Layout switchText = getTargetCheckedState() ? this.f3344J : this.f3345K;
        if (switchText != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f3343I;
            if (colorStateList != null) {
                this.f3342H.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f3342H.drawableState = drawableState;
            if (thumbDrawable != null) {
                Rect bounds = thumbDrawable.getBounds();
                cX = bounds.left + bounds.right;
            } else {
                cX = getWidth();
            }
            canvas2.translate((float) ((cX / 2) - (switchText.getWidth() / 2)), (float) (((switchInnerTop + switchInnerBottom) / 2) - (switchText.getHeight() / 2)));
            switchText.draw(canvas2);
        }
        canvas2.restoreToCount(saveCount2);
    }

    public int getCompoundPaddingLeft() {
        if (!C0946Ib.m4565a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int padding = super.getCompoundPaddingLeft() + this.f3335A;
        if (!TextUtils.isEmpty(getText())) {
            padding += this.f3361o;
        }
        return padding;
    }

    public int getCompoundPaddingRight() {
        if (C0946Ib.m4565a(this)) {
            return super.getCompoundPaddingRight();
        }
        int padding = super.getCompoundPaddingRight() + this.f3335A;
        if (!TextUtils.isEmpty(getText())) {
            padding += this.f3361o;
        }
        return padding;
    }

    private int getThumbOffset() {
        float thumbPosition;
        if (C0946Ib.m4565a(this)) {
            thumbPosition = 1.0f - this.f3372z;
        } else {
            thumbPosition = this.f3372z;
        }
        return (int) ((((float) getThumbScrollRange()) * thumbPosition) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect insets;
        Drawable drawable = this.f3354h;
        if (drawable == null) {
            return 0;
        }
        Rect padding = this.f3348N;
        drawable.getPadding(padding);
        Drawable drawable2 = this.f3349c;
        if (drawable2 != null) {
            insets = C1052ea.m5230c(drawable2);
        } else {
            insets = C1052ea.f3502a;
        }
        return ((((this.f3335A - this.f3337C) - padding.left) - padding.right) - insets.left) - insets.right;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(drawableState, f3334b);
        }
        return drawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable thumbDrawable = this.f3349c;
        if (thumbDrawable != null && thumbDrawable.isStateful()) {
            changed = false | thumbDrawable.setState(state);
        }
        Drawable trackDrawable = this.f3354h;
        if (trackDrawable != null && trackDrawable.isStateful()) {
            changed |= trackDrawable.setState(state);
        }
        if (changed) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float x, float y) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(x, y);
        }
        Drawable drawable = this.f3349c;
        if (drawable != null) {
            C1200a.m5724a(drawable, x, y);
        }
        Drawable drawable2 = this.f3354h;
        if (drawable2 != null) {
            C1200a.m5724a(drawable2, x, y);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f3349c || who == this.f3354h;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3349c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f3354h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f3347M;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f3347M.end();
            this.f3347M = null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.Switch");
        CharSequence switchText = isChecked() ? this.f3363q : this.f3364r;
        if (!TextUtils.isEmpty(switchText)) {
            CharSequence oldText = info.getText();
            if (TextUtils.isEmpty(oldText)) {
                info.setText(switchText);
                return;
            }
            StringBuilder newText = new StringBuilder();
            newText.append(oldText);
            newText.append(' ');
            newText.append(switchText);
            info.setText(newText);
        }
    }

    /* renamed from: a */
    private static float m5106a(float amount, float low, float high) {
        if (amount < low) {
            return low;
        }
        return amount > high ? high : amount;
    }
}
