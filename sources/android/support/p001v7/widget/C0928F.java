package android.support.p001v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.widget.C0687b;
import android.support.p001v7.appcompat.C0793R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.F */
/* compiled from: AppCompatTextHelper */
class C0928F {

    /* renamed from: a */
    final TextView f2970a;

    /* renamed from: b */
    private C1106qb f2971b;

    /* renamed from: c */
    private C1106qb f2972c;

    /* renamed from: d */
    private C1106qb f2973d;

    /* renamed from: e */
    private C1106qb f2974e;

    /* renamed from: f */
    private final C0944I f2975f;

    /* renamed from: g */
    private int f2976g = 0;

    /* renamed from: h */
    private Typeface f2977h;

    /* renamed from: i */
    private boolean f2978i;

    /* renamed from: a */
    static C0928F m4444a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new C0931G(textView);
        }
        return new C0928F(textView);
    }

    C0928F(TextView view) {
        this.f2970a = view;
        this.f2975f = new C0944I(this.f2970a);
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo7202a(AttributeSet attrs, int defStyleAttr) {
        AttributeSet attributeSet = attrs;
        int i = defStyleAttr;
        Context context = this.f2970a.getContext();
        C1096p drawableManager = C1096p.m5420a();
        C1112sb a = C1112sb.m5456a(context, attributeSet, C0793R.styleable.AppCompatTextHelper, i, 0);
        int ap = a.mo8659g(C0793R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a.mo8660g(C0793R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f2971b = m4445a(context, drawableManager, a.mo8659g(C0793R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a.mo8660g(C0793R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f2972c = m4445a(context, drawableManager, a.mo8659g(C0793R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a.mo8660g(C0793R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f2973d = m4445a(context, drawableManager, a.mo8659g(C0793R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a.mo8660g(C0793R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f2974e = m4445a(context, drawableManager, a.mo8659g(C0793R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a.mo8647a();
        boolean hasPwdTm = this.f2970a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean allCaps = false;
        boolean allCapsSet = false;
        ColorStateList textColor = null;
        ColorStateList textColorHint = null;
        ColorStateList textColorLink = null;
        if (ap != -1) {
            C1112sb a2 = C1112sb.m5454a(context, ap, C0793R.styleable.TextAppearance);
            if (!hasPwdTm && a2.mo8660g(C0793R.styleable.TextAppearance_textAllCaps)) {
                allCaps = a2.mo8648a(C0793R.styleable.TextAppearance_textAllCaps, false);
                allCapsSet = true;
            }
            m4446a(context, a2);
            if (VERSION.SDK_INT < 23) {
                if (a2.mo8660g(C0793R.styleable.TextAppearance_android_textColor)) {
                    textColor = a2.mo8645a(C0793R.styleable.TextAppearance_android_textColor);
                }
                if (a2.mo8660g(C0793R.styleable.TextAppearance_android_textColorHint)) {
                    textColorHint = a2.mo8645a(C0793R.styleable.TextAppearance_android_textColorHint);
                }
                if (a2.mo8660g(C0793R.styleable.TextAppearance_android_textColorLink)) {
                    textColorLink = a2.mo8645a(C0793R.styleable.TextAppearance_android_textColorLink);
                }
            }
            a2.mo8647a();
        }
        C1112sb a3 = C1112sb.m5456a(context, attributeSet, C0793R.styleable.TextAppearance, i, 0);
        if (!hasPwdTm && a3.mo8660g(C0793R.styleable.TextAppearance_textAllCaps)) {
            allCapsSet = true;
            allCaps = a3.mo8648a(C0793R.styleable.TextAppearance_textAllCaps, false);
        }
        if (VERSION.SDK_INT < 23) {
            if (a3.mo8660g(C0793R.styleable.TextAppearance_android_textColor)) {
                textColor = a3.mo8645a(C0793R.styleable.TextAppearance_android_textColor);
            }
            if (a3.mo8660g(C0793R.styleable.TextAppearance_android_textColorHint)) {
                textColorHint = a3.mo8645a(C0793R.styleable.TextAppearance_android_textColorHint);
            }
            if (a3.mo8660g(C0793R.styleable.TextAppearance_android_textColorLink)) {
                textColorLink = a3.mo8645a(C0793R.styleable.TextAppearance_android_textColorLink);
            }
        }
        m4446a(context, a3);
        a3.mo8647a();
        if (textColor != null) {
            this.f2970a.setTextColor(textColor);
        }
        if (textColorHint != null) {
            this.f2970a.setHintTextColor(textColorHint);
        }
        if (textColorLink != null) {
            this.f2970a.setLinkTextColor(textColorLink);
        }
        if (!hasPwdTm && allCapsSet) {
            mo7203a(allCaps);
        }
        Typeface typeface = this.f2977h;
        if (typeface != null) {
            this.f2970a.setTypeface(typeface, this.f2976g);
        }
        this.f2975f.mo7329a(attributeSet, i);
        if (!C0687b.f2011a) {
        } else if (this.f2975f.mo7335f() != 0) {
            int[] autoSizeTextSizesInPx = this.f2975f.mo7334e();
            if (autoSizeTextSizesInPx.length <= 0) {
            } else if (((float) this.f2970a.getAutoSizeStepGranularity()) != -1.0f) {
                Context context2 = context;
                this.f2970a.setAutoSizeTextTypeUniformWithConfiguration(this.f2975f.mo7332c(), this.f2975f.mo7331b(), this.f2975f.mo7333d(), 0);
            } else {
                this.f2970a.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextSizesInPx, 0);
            }
        }
    }

    /* renamed from: a */
    private void m4446a(Context context, C1112sb a) {
        this.f2976g = a.mo8653d(C0793R.styleable.TextAppearance_android_textStyle, this.f2976g);
        boolean z = false;
        if (a.mo8660g(C0793R.styleable.TextAppearance_android_fontFamily) || a.mo8660g(C0793R.styleable.TextAppearance_fontFamily)) {
            this.f2977h = null;
            int fontFamilyId = a.mo8660g(C0793R.styleable.TextAppearance_fontFamily) ? C0793R.styleable.TextAppearance_fontFamily : C0793R.styleable.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.f2977h = a.mo8646a(fontFamilyId, this.f2976g, new C0925E(this, new WeakReference<>(this.f2970a)));
                    if (this.f2977h == null) {
                        z = true;
                    }
                    this.f2978i = z;
                } catch (NotFoundException | UnsupportedOperationException e) {
                }
            }
            if (this.f2977h == null) {
                String fontFamilyName = a.mo8654d(fontFamilyId);
                if (fontFamilyName != null) {
                    this.f2977h = Typeface.create(fontFamilyName, this.f2976g);
                }
            }
            return;
        }
        if (a.mo8660g(C0793R.styleable.TextAppearance_android_typeface)) {
            this.f2978i = false;
            int typefaceIndex = a.mo8653d(C0793R.styleable.TextAppearance_android_typeface, 1);
            if (typefaceIndex == 1) {
                this.f2977h = Typeface.SANS_SERIF;
            } else if (typefaceIndex == 2) {
                this.f2977h = Typeface.SERIF;
            } else if (typefaceIndex == 3) {
                this.f2977h = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4448a(WeakReference<TextView> textViewWeak, Typeface typeface) {
        if (this.f2978i) {
            this.f2977h = typeface;
            TextView textView = (TextView) textViewWeak.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f2976g);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7200a(Context context, int resId) {
        C1112sb a = C1112sb.m5454a(context, resId, C0793R.styleable.TextAppearance);
        if (a.mo8660g(C0793R.styleable.TextAppearance_textAllCaps)) {
            mo7203a(a.mo8648a(C0793R.styleable.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.mo8660g(C0793R.styleable.TextAppearance_android_textColor)) {
            ColorStateList textColor = a.mo8645a(C0793R.styleable.TextAppearance_android_textColor);
            if (textColor != null) {
                this.f2970a.setTextColor(textColor);
            }
        }
        m4446a(context, a);
        a.mo8647a();
        Typeface typeface = this.f2977h;
        if (typeface != null) {
            this.f2970a.setTypeface(typeface, this.f2976g);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7203a(boolean allCaps) {
        this.f2970a.setAllCaps(allCaps);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7196a() {
        if (this.f2971b != null || this.f2972c != null || this.f2973d != null || this.f2974e != null) {
            Drawable[] compoundDrawables = this.f2970a.getCompoundDrawables();
            mo7201a(compoundDrawables[0], this.f2971b);
            mo7201a(compoundDrawables[1], this.f2972c);
            mo7201a(compoundDrawables[2], this.f2973d);
            mo7201a(compoundDrawables[3], this.f2974e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo7201a(Drawable drawable, C1106qb info) {
        if (drawable != null && info != null) {
            C1096p.m5423a(drawable, info, this.f2970a.getDrawableState());
        }
    }

    /* renamed from: a */
    protected static C1106qb m4445a(Context context, C1096p drawableManager, int drawableId) {
        ColorStateList tintList = drawableManager.mo8569b(context, drawableId);
        if (tintList == null) {
            return null;
        }
        C1106qb tintInfo = new C1106qb();
        tintInfo.f3687d = true;
        tintInfo.f3684a = tintList;
        return tintInfo;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7204a(boolean changed, int left, int top, int right, int bottom) {
        if (!C0687b.f2011a) {
            mo7206b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7198a(int unit, float size) {
        if (!C0687b.f2011a && !mo7212h()) {
            m4449b(unit, size);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7206b() {
        this.f2975f.mo7325a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo7212h() {
        return this.f2975f.mo7336g();
    }

    /* renamed from: b */
    private void m4449b(int unit, float size) {
        this.f2975f.mo7327a(unit, size);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7197a(int autoSizeTextType) {
        this.f2975f.mo7326a(autoSizeTextType);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7199a(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) throws IllegalArgumentException {
        this.f2975f.mo7328a(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7205a(int[] presetSizes, int unit) throws IllegalArgumentException {
        this.f2975f.mo7330a(presetSizes, unit);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo7211g() {
        return this.f2975f.mo7335f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo7209e() {
        return this.f2975f.mo7333d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo7208d() {
        return this.f2975f.mo7332c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo7207c() {
        return this.f2975f.mo7331b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int[] mo7210f() {
        return this.f2975f.mo7334e();
    }
}
