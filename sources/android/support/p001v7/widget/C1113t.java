package android.support.p001v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.p000v4.widget.C0709n;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.widget.ImageView;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.t */
/* compiled from: AppCompatImageHelper */
public class C1113t {

    /* renamed from: a */
    private final ImageView f3694a;

    /* renamed from: b */
    private C1106qb f3695b;

    /* renamed from: c */
    private C1106qb f3696c;

    /* renamed from: d */
    private C1106qb f3697d;

    public C1113t(ImageView view) {
        this.f3694a = view;
    }

    /* renamed from: a */
    public void mo8665a(AttributeSet attrs, int defStyleAttr) {
        C1112sb a = C1112sb.m5456a(this.f3694a.getContext(), attrs, C0793R.styleable.AppCompatImageView, defStyleAttr, 0);
        try {
            Drawable drawable = this.f3694a.getDrawable();
            if (drawable == null) {
                int id = a.mo8659g(C0793R.styleable.AppCompatImageView_srcCompat, -1);
                if (id != -1) {
                    drawable = C1282b.m6000b(this.f3694a.getContext(), id);
                    if (drawable != null) {
                        this.f3694a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                C1052ea.m5229b(drawable);
            }
            if (a.mo8660g(C0793R.styleable.AppCompatImageView_tint)) {
                C0709n.m3334a(this.f3694a, a.mo8645a(C0793R.styleable.AppCompatImageView_tint));
            }
            if (a.mo8660g(C0793R.styleable.AppCompatImageView_tintMode)) {
                C0709n.m3335a(this.f3694a, C1052ea.m5227a(a.mo8653d(C0793R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a.mo8647a();
        }
    }

    /* renamed from: a */
    public void mo8662a(int resId) {
        if (resId != 0) {
            Drawable d = C1282b.m6000b(this.f3694a.getContext(), resId);
            if (d != null) {
                C1052ea.m5229b(d);
            }
            this.f3694a.setImageDrawable(d);
        } else {
            this.f3694a.setImageDrawable(null);
        }
        mo8661a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8668d() {
        Drawable background = this.f3694a.getBackground();
        if (VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8663a(ColorStateList tint) {
        if (this.f3696c == null) {
            this.f3696c = new C1106qb();
        }
        C1106qb qbVar = this.f3696c;
        qbVar.f3684a = tint;
        qbVar.f3687d = true;
        mo8661a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ColorStateList mo8666b() {
        C1106qb qbVar = this.f3696c;
        if (qbVar != null) {
            return qbVar.f3684a;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8664a(Mode tintMode) {
        if (this.f3696c == null) {
            this.f3696c = new C1106qb();
        }
        C1106qb qbVar = this.f3696c;
        qbVar.f3685b = tintMode;
        qbVar.f3686c = true;
        mo8661a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Mode mo8667c() {
        C1106qb qbVar = this.f3696c;
        if (qbVar != null) {
            return qbVar.f3685b;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8661a() {
        Drawable imageViewDrawable = this.f3694a.getDrawable();
        if (imageViewDrawable != null) {
            C1052ea.m5229b(imageViewDrawable);
        }
        if (imageViewDrawable != null && (!m5476e() || !m5475a(imageViewDrawable))) {
            C1106qb qbVar = this.f3696c;
            if (qbVar != null) {
                C1096p.m5423a(imageViewDrawable, qbVar, this.f3694a.getDrawableState());
            } else {
                C1106qb qbVar2 = this.f3695b;
                if (qbVar2 != null) {
                    C1096p.m5423a(imageViewDrawable, qbVar2, this.f3694a.getDrawableState());
                }
            }
        }
    }

    /* renamed from: e */
    private boolean m5476e() {
        int sdk = VERSION.SDK_INT;
        boolean z = true;
        if (sdk <= 21) {
            return sdk == 21;
        }
        if (this.f3695b == null) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m5475a(Drawable imageSource) {
        if (this.f3697d == null) {
            this.f3697d = new C1106qb();
        }
        C1106qb info = this.f3697d;
        info.mo8625a();
        ColorStateList tintList = C0709n.m3333a(this.f3694a);
        if (tintList != null) {
            info.f3687d = true;
            info.f3684a = tintList;
        }
        Mode mode = C0709n.m3336b(this.f3694a);
        if (mode != null) {
            info.f3686c = true;
            info.f3685b = mode;
        }
        if (!info.f3687d && !info.f3686c) {
            return false;
        }
        C1096p.m5423a(imageSource, info, this.f3694a.getDrawableState());
        return true;
    }
}
