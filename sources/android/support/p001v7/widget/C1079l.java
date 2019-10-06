package android.support.p001v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v7.widget.l */
/* compiled from: AppCompatBackgroundHelper */
class C1079l {

    /* renamed from: a */
    private final View f3580a;

    /* renamed from: b */
    private final C1096p f3581b;

    /* renamed from: c */
    private int f3582c = -1;

    /* renamed from: d */
    private C1106qb f3583d;

    /* renamed from: e */
    private C1106qb f3584e;

    /* renamed from: f */
    private C1106qb f3585f;

    C1079l(View view) {
        this.f3580a = view;
        this.f3581b = C1096p.m5420a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8511a(AttributeSet attrs, int defStyleAttr) {
        C1112sb a = C1112sb.m5456a(this.f3580a.getContext(), attrs, C0793R.styleable.ViewBackgroundHelper, defStyleAttr, 0);
        try {
            if (a.mo8660g(C0793R.styleable.ViewBackgroundHelper_android_background)) {
                this.f3582c = a.mo8659g(C0793R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList tint = this.f3581b.mo8569b(this.f3580a.getContext(), this.f3582c);
                if (tint != null) {
                    mo8508a(tint);
                }
            }
            if (a.mo8660g(C0793R.styleable.ViewBackgroundHelper_backgroundTint)) {
                C0646w.m2951a(this.f3580a, a.mo8645a(C0793R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a.mo8660g(C0793R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                C0646w.m2952a(this.f3580a, C1052ea.m5227a(a.mo8653d(C0793R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a.mo8647a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8507a(int resId) {
        this.f3582c = resId;
        C1096p pVar = this.f3581b;
        mo8508a(pVar != null ? pVar.mo8569b(this.f3580a.getContext(), resId) : null);
        mo8506a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8510a(Drawable background) {
        this.f3582c = -1;
        mo8508a((ColorStateList) null);
        mo8506a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8513b(ColorStateList tint) {
        if (this.f3584e == null) {
            this.f3584e = new C1106qb();
        }
        C1106qb qbVar = this.f3584e;
        qbVar.f3684a = tint;
        qbVar.f3687d = true;
        mo8506a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ColorStateList mo8512b() {
        C1106qb qbVar = this.f3584e;
        if (qbVar != null) {
            return qbVar.f3684a;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8509a(Mode tintMode) {
        if (this.f3584e == null) {
            this.f3584e = new C1106qb();
        }
        C1106qb qbVar = this.f3584e;
        qbVar.f3685b = tintMode;
        qbVar.f3686c = true;
        mo8506a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Mode mo8514c() {
        C1106qb qbVar = this.f3584e;
        if (qbVar != null) {
            return qbVar.f3685b;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8506a() {
        Drawable background = this.f3580a.getBackground();
        if (background != null && (!m5342d() || !m5341b(background))) {
            C1106qb qbVar = this.f3584e;
            if (qbVar != null) {
                C1096p.m5423a(background, qbVar, this.f3580a.getDrawableState());
            } else {
                C1106qb qbVar2 = this.f3583d;
                if (qbVar2 != null) {
                    C1096p.m5423a(background, qbVar2, this.f3580a.getDrawableState());
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8508a(ColorStateList tint) {
        if (tint != null) {
            if (this.f3583d == null) {
                this.f3583d = new C1106qb();
            }
            C1106qb qbVar = this.f3583d;
            qbVar.f3684a = tint;
            qbVar.f3687d = true;
        } else {
            this.f3583d = null;
        }
        mo8506a();
    }

    /* renamed from: d */
    private boolean m5342d() {
        int sdk = VERSION.SDK_INT;
        boolean z = true;
        if (sdk <= 21) {
            return sdk == 21;
        }
        if (this.f3583d == null) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m5341b(Drawable background) {
        if (this.f3585f == null) {
            this.f3585f = new C1106qb();
        }
        C1106qb info = this.f3585f;
        info.mo8625a();
        ColorStateList tintList = C0646w.m2962b(this.f3580a);
        if (tintList != null) {
            info.f3687d = true;
            info.f3684a = tintList;
        }
        Mode mode = C0646w.m2967c(this.f3580a);
        if (mode != null) {
            info.f3686c = true;
            info.f3685b = mode;
        }
        if (!info.f3687d && !info.f3686c) {
            return false;
        }
        C1096p.m5423a(background, info, this.f3580a.getDrawableState());
        return true;
    }
}
