package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0623f;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.widget.C1112sb;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p053g.p058c.C1226a;
import p002b.p003c.p053g.p060e.C1244c;

/* renamed from: android.support.design.widget.A */
/* compiled from: CollapsingTextHelper */
final class C0224A {

    /* renamed from: a */
    private static final boolean f768a = (VERSION.SDK_INT < 18);

    /* renamed from: b */
    private static final Paint f769b = null;

    /* renamed from: A */
    private boolean f770A;

    /* renamed from: B */
    private Bitmap f771B;

    /* renamed from: C */
    private Paint f772C;

    /* renamed from: D */
    private float f773D;

    /* renamed from: E */
    private float f774E;

    /* renamed from: F */
    private float f775F;

    /* renamed from: G */
    private float f776G;

    /* renamed from: H */
    private int[] f777H;

    /* renamed from: I */
    private boolean f778I;

    /* renamed from: J */
    private final TextPaint f779J;

    /* renamed from: K */
    private Interpolator f780K;

    /* renamed from: L */
    private Interpolator f781L;

    /* renamed from: M */
    private float f782M;

    /* renamed from: N */
    private float f783N;

    /* renamed from: O */
    private float f784O;

    /* renamed from: P */
    private int f785P;

    /* renamed from: Q */
    private float f786Q;

    /* renamed from: R */
    private float f787R;

    /* renamed from: S */
    private float f788S;

    /* renamed from: T */
    private int f789T;

    /* renamed from: c */
    private final View f790c;

    /* renamed from: d */
    private boolean f791d;

    /* renamed from: e */
    private float f792e;

    /* renamed from: f */
    private final Rect f793f;

    /* renamed from: g */
    private final Rect f794g;

    /* renamed from: h */
    private final RectF f795h;

    /* renamed from: i */
    private int f796i = 16;

    /* renamed from: j */
    private int f797j = 16;

    /* renamed from: k */
    private float f798k = 15.0f;

    /* renamed from: l */
    private float f799l = 15.0f;

    /* renamed from: m */
    private ColorStateList f800m;

    /* renamed from: n */
    private ColorStateList f801n;

    /* renamed from: o */
    private float f802o;

    /* renamed from: p */
    private float f803p;

    /* renamed from: q */
    private float f804q;

    /* renamed from: r */
    private float f805r;

    /* renamed from: s */
    private float f806s;

    /* renamed from: t */
    private float f807t;

    /* renamed from: u */
    private Typeface f808u;

    /* renamed from: v */
    private Typeface f809v;

    /* renamed from: w */
    private Typeface f810w;

    /* renamed from: x */
    private CharSequence f811x;

    /* renamed from: y */
    private CharSequence f812y;

    /* renamed from: z */
    private boolean f813z;

    static {
        Paint paint = f769b;
        if (paint != null) {
            paint.setAntiAlias(true);
            f769b.setColor(-65281);
        }
    }

    public C0224A(View view) {
        this.f790c = view;
        this.f779J = new TextPaint(Opcodes.LOR);
        this.f794g = new Rect();
        this.f793f = new Rect();
        this.f795h = new RectF();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4171b(Interpolator interpolator) {
        this.f781L = interpolator;
        mo4183k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4162a(Interpolator interpolator) {
        this.f780K = interpolator;
        mo4183k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4156a(float textSize) {
        if (this.f798k != textSize) {
            this.f798k = textSize;
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4159a(ColorStateList textColor) {
        if (this.f801n != textColor) {
            this.f801n = textColor;
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4169b(ColorStateList textColor) {
        if (this.f800m != textColor) {
            this.f800m = textColor;
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4168b(int left, int top, int right, int bottom) {
        if (!m1254a(this.f793f, left, top, right, bottom)) {
            this.f793f.set(left, top, right, bottom);
            this.f778I = true;
            mo4182j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4158a(int left, int top, int right, int bottom) {
        if (!m1254a(this.f794g, left, top, right, bottom)) {
            this.f794g.set(left, top, right, bottom);
            this.f778I = true;
            mo4182j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo4182j() {
        this.f791d = this.f794g.width() > 0 && this.f794g.height() > 0 && this.f793f.width() > 0 && this.f793f.height() > 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4176d(int gravity) {
        if (this.f796i != gravity) {
            this.f796i = gravity;
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo4177e() {
        return this.f796i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4167b(int gravity) {
        if (this.f797j != gravity) {
            this.f797j = gravity;
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo4165b() {
        return this.f797j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4157a(int resId) {
        C1112sb a = C1112sb.m5454a(this.f790c.getContext(), resId, C0793R.styleable.TextAppearance);
        if (a.mo8660g(C0793R.styleable.TextAppearance_android_textColor)) {
            this.f801n = a.mo8645a(C0793R.styleable.TextAppearance_android_textColor);
        }
        if (a.mo8660g(C0793R.styleable.TextAppearance_android_textSize)) {
            this.f799l = (float) a.mo8651c(C0793R.styleable.TextAppearance_android_textSize, (int) this.f799l);
        }
        this.f785P = a.mo8653d(C0793R.styleable.TextAppearance_android_shadowColor, 0);
        this.f783N = a.mo8643a(C0793R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f784O = a.mo8643a(C0793R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f782M = a.mo8643a(C0793R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a.mo8647a();
        if (VERSION.SDK_INT >= 16) {
            this.f808u = m1259e(resId);
        }
        mo4183k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4173c(int resId) {
        C1112sb a = C1112sb.m5454a(this.f790c.getContext(), resId, C0793R.styleable.TextAppearance);
        if (a.mo8660g(C0793R.styleable.TextAppearance_android_textColor)) {
            this.f800m = a.mo8645a(C0793R.styleable.TextAppearance_android_textColor);
        }
        if (a.mo8660g(C0793R.styleable.TextAppearance_android_textSize)) {
            this.f798k = (float) a.mo8651c(C0793R.styleable.TextAppearance_android_textSize, (int) this.f798k);
        }
        this.f789T = a.mo8653d(C0793R.styleable.TextAppearance_android_shadowColor, 0);
        this.f787R = a.mo8643a(C0793R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f788S = a.mo8643a(C0793R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f786Q = a.mo8643a(C0793R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a.mo8647a();
        if (VERSION.SDK_INT >= 16) {
            this.f809v = m1259e(resId);
        }
        mo4183k();
    }

    /* renamed from: e */
    private Typeface m1259e(int resId) {
        TypedArray a = this.f790c.getContext().obtainStyledAttributes(resId, new int[]{16843692});
        try {
            String family = a.getString(0);
            if (family != null) {
                return Typeface.create(family, 0);
            }
            a.recycle();
            return null;
        } finally {
            a.recycle();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4161a(Typeface typeface) {
        if (m1255a(this.f808u, typeface)) {
            this.f808u = typeface;
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4170b(Typeface typeface) {
        if (m1255a(this.f809v, typeface)) {
            this.f809v = typeface;
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4174c(Typeface typeface) {
        this.f809v = typeface;
        this.f808u = typeface;
        mo4183k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Typeface mo4175d() {
        Typeface typeface = this.f808u;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Typeface mo4178f() {
        Typeface typeface = this.f809v;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4166b(float fraction) {
        float fraction2 = C1226a.m5822a(fraction, 0.0f, 1.0f);
        if (fraction2 != this.f792e) {
            this.f792e = fraction2;
            m1263m();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo4164a(int[] state) {
        this.f777H = state;
        if (!mo4181i()) {
            return false;
        }
        mo4183k();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final boolean mo4181i() {
        ColorStateList colorStateList = this.f801n;
        if (colorStateList == null || !colorStateList.isStateful()) {
            ColorStateList colorStateList2 = this.f800m;
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public float mo4179g() {
        return this.f792e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo4172c() {
        return this.f799l;
    }

    /* renamed from: m */
    private void m1263m() {
        m1257c(this.f792e);
    }

    /* renamed from: c */
    private void m1257c(float fraction) {
        m1260e(fraction);
        this.f806s = m1251a(this.f804q, this.f805r, fraction, this.f780K);
        this.f807t = m1251a(this.f802o, this.f803p, fraction, this.f780K);
        m1261f(m1251a(this.f798k, this.f799l, fraction, this.f781L));
        if (this.f801n != this.f800m) {
            this.f779J.setColor(m1252a(m1267q(), m1266p(), fraction));
        } else {
            this.f779J.setColor(m1266p());
        }
        this.f779J.setShadowLayer(m1251a(this.f786Q, this.f782M, fraction, (Interpolator) null), m1251a(this.f787R, this.f783N, fraction, (Interpolator) null), m1251a(this.f788S, this.f784O, fraction, (Interpolator) null), m1252a(this.f789T, this.f785P, fraction));
        C0646w.m2990x(this.f790c);
    }

    /* renamed from: q */
    private int m1267q() {
        int[] iArr = this.f777H;
        if (iArr != null) {
            return this.f800m.getColorForState(iArr, 0);
        }
        return this.f800m.getDefaultColor();
    }

    /* renamed from: p */
    private int m1266p() {
        int[] iArr = this.f777H;
        if (iArr != null) {
            return this.f801n.getColorForState(iArr, 0);
        }
        return this.f801n.getDefaultColor();
    }

    /* renamed from: l */
    private void m1262l() {
        float currentTextSize = this.f776G;
        m1258d(this.f799l);
        CharSequence charSequence = this.f812y;
        float f = 0.0f;
        float width = charSequence != null ? this.f779J.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int collapsedAbsGravity = C0623f.m2881a(this.f797j, this.f813z ? 1 : 0);
        int i = collapsedAbsGravity & 112;
        if (i == 48) {
            this.f803p = ((float) this.f794g.top) - this.f779J.ascent();
        } else if (i != 80) {
            this.f803p = ((float) this.f794g.centerY()) + (((this.f779J.descent() - this.f779J.ascent()) / 2.0f) - this.f779J.descent());
        } else {
            this.f803p = (float) this.f794g.bottom;
        }
        int i2 = collapsedAbsGravity & 8388615;
        if (i2 == 1) {
            this.f805r = ((float) this.f794g.centerX()) - (width / 2.0f);
        } else if (i2 != 5) {
            this.f805r = (float) this.f794g.left;
        } else {
            this.f805r = ((float) this.f794g.right) - width;
        }
        m1258d(this.f798k);
        CharSequence charSequence2 = this.f812y;
        if (charSequence2 != null) {
            f = this.f779J.measureText(charSequence2, 0, charSequence2.length());
        }
        float width2 = f;
        int expandedAbsGravity = C0623f.m2881a(this.f796i, this.f813z ? 1 : 0);
        int i3 = expandedAbsGravity & 112;
        if (i3 == 48) {
            this.f802o = ((float) this.f793f.top) - this.f779J.ascent();
        } else if (i3 != 80) {
            this.f802o = ((float) this.f793f.centerY()) + (((this.f779J.descent() - this.f779J.ascent()) / 2.0f) - this.f779J.descent());
        } else {
            this.f802o = (float) this.f793f.bottom;
        }
        int i4 = expandedAbsGravity & 8388615;
        if (i4 == 1) {
            this.f804q = ((float) this.f793f.centerX()) - (width2 / 2.0f);
        } else if (i4 != 5) {
            this.f804q = (float) this.f793f.left;
        } else {
            this.f804q = ((float) this.f793f.right) - width2;
        }
        m1264n();
        m1261f(currentTextSize);
    }

    /* renamed from: e */
    private void m1260e(float fraction) {
        this.f795h.left = m1251a((float) this.f793f.left, (float) this.f794g.left, fraction, this.f780K);
        this.f795h.top = m1251a(this.f802o, this.f803p, fraction, this.f780K);
        this.f795h.right = m1251a((float) this.f793f.right, (float) this.f794g.right, fraction, this.f780K);
        this.f795h.bottom = m1251a((float) this.f793f.bottom, (float) this.f794g.bottom, fraction, this.f780K);
    }

    /* renamed from: a */
    public void mo4160a(Canvas canvas) {
        float ascent;
        float y;
        int saveCount = canvas.save();
        if (this.f812y != null && this.f791d) {
            float x = this.f806s;
            float y2 = this.f807t;
            boolean drawTexture = this.f770A && this.f771B != null;
            if (drawTexture) {
                float f = this.f773D;
                float f2 = this.f775F;
                ascent = f * f2;
                float f3 = this.f774E * f2;
            } else {
                ascent = this.f779J.ascent() * this.f775F;
                float descent = this.f775F * this.f779J.descent();
            }
            if (drawTexture) {
                y = y2 + ascent;
            } else {
                y = y2;
            }
            float y3 = this.f775F;
            if (y3 != 1.0f) {
                canvas.scale(y3, y3, x, y);
            }
            if (drawTexture) {
                canvas.drawBitmap(this.f771B, x, y, this.f772C);
            } else {
                CharSequence charSequence = this.f812y;
                canvas.drawText(charSequence, 0, charSequence.length(), x, y, this.f779J);
            }
        }
        canvas.restoreToCount(saveCount);
    }

    /* renamed from: b */
    private boolean m1256b(CharSequence text) {
        boolean z = true;
        if (C0646w.m2974h(this.f790c) != 1) {
            z = false;
        }
        return (z ? C1244c.f4012d : C1244c.f4011c).isRtl(text, 0, text.length());
    }

    /* renamed from: f */
    private void m1261f(float textSize) {
        m1258d(textSize);
        this.f770A = f768a && this.f775F != 1.0f;
        if (this.f770A) {
            m1265o();
        }
        C0646w.m2990x(this.f790c);
    }

    /* renamed from: a */
    private boolean m1255a(Typeface first, Typeface second) {
        return (first != null && !first.equals(second)) || (first == null && second != null);
    }

    /* renamed from: d */
    private void m1258d(float textSize) {
        float textSizeRatio;
        float newTextSize;
        if (this.f811x != null) {
            float collapsedWidth = (float) this.f794g.width();
            float expandedWidth = (float) this.f793f.width();
            boolean updateDrawText = false;
            if (m1253a(textSize, this.f799l)) {
                newTextSize = this.f799l;
                this.f775F = 1.0f;
                if (m1255a(this.f810w, this.f808u)) {
                    this.f810w = this.f808u;
                    updateDrawText = true;
                }
                textSizeRatio = collapsedWidth;
            } else {
                newTextSize = this.f798k;
                if (m1255a(this.f810w, this.f809v)) {
                    this.f810w = this.f809v;
                    updateDrawText = true;
                }
                if (m1253a(textSize, this.f798k)) {
                    this.f775F = 1.0f;
                } else {
                    this.f775F = textSize / this.f798k;
                }
                float textSizeRatio2 = this.f799l / this.f798k;
                if (expandedWidth * textSizeRatio2 > collapsedWidth) {
                    textSizeRatio = Math.min(collapsedWidth / textSizeRatio2, expandedWidth);
                } else {
                    textSizeRatio = expandedWidth;
                }
            }
            boolean z = true;
            if (textSizeRatio > 0.0f) {
                updateDrawText = this.f776G != newTextSize || this.f778I || updateDrawText;
                this.f776G = newTextSize;
                this.f778I = false;
            }
            if (this.f812y == null || updateDrawText) {
                this.f779J.setTextSize(this.f776G);
                this.f779J.setTypeface(this.f810w);
                TextPaint textPaint = this.f779J;
                if (this.f775F == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence title = TextUtils.ellipsize(this.f811x, this.f779J, textSizeRatio, TruncateAt.END);
                if (!TextUtils.equals(title, this.f812y)) {
                    this.f812y = title;
                    this.f813z = m1256b(this.f812y);
                }
            }
        }
    }

    /* renamed from: o */
    private void m1265o() {
        if (this.f771B == null && !this.f793f.isEmpty() && !TextUtils.isEmpty(this.f812y)) {
            m1257c(0.0f);
            this.f773D = this.f779J.ascent();
            this.f774E = this.f779J.descent();
            TextPaint textPaint = this.f779J;
            CharSequence charSequence = this.f812y;
            int w = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int h = Math.round(this.f774E - this.f773D);
            if (w > 0 && h > 0) {
                this.f771B = Bitmap.createBitmap(w, h, Config.ARGB_8888);
                Canvas c = new Canvas(this.f771B);
                CharSequence charSequence2 = this.f812y;
                c.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) h) - this.f779J.descent(), this.f779J);
                if (this.f772C == null) {
                    this.f772C = new Paint(3);
                }
            }
        }
    }

    /* renamed from: k */
    public void mo4183k() {
        if (this.f790c.getHeight() > 0 && this.f790c.getWidth() > 0) {
            m1262l();
            m1263m();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4163a(CharSequence text) {
        if (text == null || !text.equals(this.f811x)) {
            this.f811x = text;
            this.f812y = null;
            m1264n();
            mo4183k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public CharSequence mo4180h() {
        return this.f811x;
    }

    /* renamed from: n */
    private void m1264n() {
        Bitmap bitmap = this.f771B;
        if (bitmap != null) {
            bitmap.recycle();
            this.f771B = null;
        }
    }

    /* renamed from: a */
    private static boolean m1253a(float value, float targetValue) {
        return Math.abs(value - targetValue) < 0.001f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ColorStateList mo4155a() {
        return this.f801n;
    }

    /* renamed from: a */
    private static int m1252a(int color1, int color2, float ratio) {
        float inverseRatio = 1.0f - ratio;
        return Color.argb((int) ((((float) Color.alpha(color1)) * inverseRatio) + (((float) Color.alpha(color2)) * ratio)), (int) ((((float) Color.red(color1)) * inverseRatio) + (((float) Color.red(color2)) * ratio)), (int) ((((float) Color.green(color1)) * inverseRatio) + (((float) Color.green(color2)) * ratio)), (int) ((((float) Color.blue(color1)) * inverseRatio) + (((float) Color.blue(color2)) * ratio)));
    }

    /* renamed from: a */
    private static float m1251a(float startValue, float endValue, float fraction, Interpolator interpolator) {
        if (interpolator != null) {
            fraction = interpolator.getInterpolation(fraction);
        }
        return C0280a.m1676a(startValue, endValue, fraction);
    }

    /* renamed from: a */
    private static boolean m1254a(Rect r, int left, int top, int right, int bottom) {
        return r.left == left && r.top == top && r.right == right && r.bottom == bottom;
    }
}
