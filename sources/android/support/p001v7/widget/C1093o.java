package android.support.p001v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.widget.C0694g;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.o */
/* compiled from: AppCompatCompoundButtonHelper */
class C1093o {

    /* renamed from: a */
    private final CompoundButton f3645a;

    /* renamed from: b */
    private ColorStateList f3646b = null;

    /* renamed from: c */
    private Mode f3647c = null;

    /* renamed from: d */
    private boolean f3648d = false;

    /* renamed from: e */
    private boolean f3649e = false;

    /* renamed from: f */
    private boolean f3650f;

    C1093o(CompoundButton view) {
        this.f3645a = view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8556a(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = this.f3645a.getContext().obtainStyledAttributes(attrs, C0793R.styleable.CompoundButton, defStyleAttr, 0);
        try {
            if (a.hasValue(C0793R.styleable.CompoundButton_android_button)) {
                int resourceId = a.getResourceId(C0793R.styleable.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f3645a.setButtonDrawable(C1282b.m6000b(this.f3645a.getContext(), resourceId));
                }
            }
            if (a.hasValue(C0793R.styleable.CompoundButton_buttonTint)) {
                C0694g.m3311a(this.f3645a, a.getColorStateList(C0793R.styleable.CompoundButton_buttonTint));
            }
            if (a.hasValue(C0793R.styleable.CompoundButton_buttonTintMode)) {
                C0694g.m3312a(this.f3645a, C1052ea.m5227a(a.getInt(C0793R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            a.recycle();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8554a(ColorStateList tint) {
        this.f3646b = tint;
        this.f3648d = true;
        mo8553a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ColorStateList mo8557b() {
        return this.f3646b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8555a(Mode tintMode) {
        this.f3647c = tintMode;
        this.f3649e = true;
        mo8553a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Mode mo8558c() {
        return this.f3647c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8559d() {
        if (this.f3650f) {
            this.f3650f = false;
            return;
        }
        this.f3650f = true;
        mo8553a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8553a() {
        Drawable buttonDrawable = C0694g.m3310a(this.f3645a);
        if (buttonDrawable == null) {
            return;
        }
        if (this.f3648d || this.f3649e) {
            Drawable buttonDrawable2 = C1200a.m5741i(buttonDrawable).mutate();
            if (this.f3648d) {
                C1200a.m5726a(buttonDrawable2, this.f3646b);
            }
            if (this.f3649e) {
                C1200a.m5729a(buttonDrawable2, this.f3647c);
            }
            if (buttonDrawable2.isStateful()) {
                buttonDrawable2.setState(this.f3645a.getDrawableState());
            }
            this.f3645a.setButtonDrawable(buttonDrawable2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo8552a(int superValue) {
        if (VERSION.SDK_INT >= 17) {
            return superValue;
        }
        Drawable buttonDrawable = C0694g.m3310a(this.f3645a);
        if (buttonDrawable != null) {
            return superValue + buttonDrawable.getIntrinsicWidth();
        }
        return superValue;
    }
}
