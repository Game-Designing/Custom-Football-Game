package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0646w;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;
import p002b.p003c.p050d.C1169c;
import p002b.p003c.p053g.p054a.p055a.C1200a;

/* renamed from: android.support.design.widget.K */
/* compiled from: FloatingActionButtonImpl */
class C0251K {

    /* renamed from: a */
    static final Interpolator f976a = C0280a.f1076c;

    /* renamed from: b */
    static final int[] f977b = {16842919, 16842910};

    /* renamed from: c */
    static final int[] f978c = {16842908, 16842910};

    /* renamed from: d */
    static final int[] f979d = {16842910};

    /* renamed from: e */
    static final int[] f980e = new int[0];

    /* renamed from: f */
    int f981f = 0;

    /* renamed from: g */
    private final C0274V f982g;

    /* renamed from: h */
    C0262O f983h;

    /* renamed from: i */
    private float f984i;

    /* renamed from: j */
    Drawable f985j;

    /* renamed from: k */
    Drawable f986k;

    /* renamed from: l */
    C0320y f987l;

    /* renamed from: m */
    Drawable f988m;

    /* renamed from: n */
    float f989n;

    /* renamed from: o */
    float f990o;

    /* renamed from: p */
    final C0299ja f991p;

    /* renamed from: q */
    final C0263P f992q;

    /* renamed from: r */
    private final Rect f993r = new Rect();

    /* renamed from: s */
    private OnPreDrawListener f994s;

    /* renamed from: android.support.design.widget.K$a */
    /* compiled from: FloatingActionButtonImpl */
    private class C0252a extends C0256e {
        C0252a() {
            super(C0251K.this, null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public float mo4527a() {
            return 0.0f;
        }
    }

    /* renamed from: android.support.design.widget.K$b */
    /* compiled from: FloatingActionButtonImpl */
    private class C0253b extends C0256e {
        C0253b() {
            super(C0251K.this, null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public float mo4527a() {
            C0251K k = C0251K.this;
            return k.f989n + k.f990o;
        }
    }

    /* renamed from: android.support.design.widget.K$c */
    /* compiled from: FloatingActionButtonImpl */
    interface C0254c {
        /* renamed from: a */
        void mo4492a();

        /* renamed from: b */
        void mo4493b();
    }

    /* renamed from: android.support.design.widget.K$d */
    /* compiled from: FloatingActionButtonImpl */
    private class C0255d extends C0256e {
        C0255d() {
            super(C0251K.this, null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public float mo4527a() {
            return C0251K.this.f989n;
        }
    }

    /* renamed from: android.support.design.widget.K$e */
    /* compiled from: FloatingActionButtonImpl */
    private abstract class C0256e extends AnimatorListenerAdapter implements AnimatorUpdateListener {

        /* renamed from: a */
        private boolean f998a;

        /* renamed from: b */
        private float f999b;

        /* renamed from: c */
        private float f1000c;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract float mo4527a();

        private C0256e() {
        }

        /* synthetic */ C0256e(C0251K x0, C0248H x1) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator animator) {
            if (!this.f998a) {
                this.f999b = C0251K.this.f983h.mo4543b();
                this.f1000c = mo4527a();
                this.f998a = true;
            }
            C0262O o = C0251K.this.f983h;
            float f = this.f999b;
            o.mo4544b(f + ((this.f1000c - f) * animator.getAnimatedFraction()));
        }

        public void onAnimationEnd(Animator animator) {
            C0251K.this.f983h.mo4544b(this.f1000c);
            this.f998a = false;
        }
    }

    C0251K(C0299ja view, C0263P shadowViewDelegate) {
        this.f991p = view;
        this.f992q = shadowViewDelegate;
        this.f982g = new C0274V();
        this.f982g.mo4630a(f977b, m1536a((C0256e) new C0253b()));
        this.f982g.mo4630a(f978c, m1536a((C0256e) new C0253b()));
        this.f982g.mo4630a(f979d, m1536a((C0256e) new C0255d()));
        this.f982g.mo4630a(f980e, m1536a((C0256e) new C0252a()));
        this.f984i = this.f991p.getRotation();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4506a(ColorStateList backgroundTint, Mode backgroundTintMode, int rippleColor, int borderWidth) {
        Drawable[] layers;
        this.f985j = C1200a.m5741i(mo4500a());
        C1200a.m5726a(this.f985j, backgroundTint);
        if (backgroundTintMode != null) {
            C1200a.m5729a(this.f985j, backgroundTintMode);
        }
        this.f986k = C1200a.m5741i(mo4500a());
        C1200a.m5726a(this.f986k, m1537b(rippleColor));
        if (borderWidth > 0) {
            this.f987l = mo4501a(borderWidth, backgroundTint);
            layers = new Drawable[]{this.f987l, this.f985j, this.f986k};
        } else {
            this.f987l = null;
            layers = new Drawable[]{this.f985j, this.f986k};
        }
        this.f988m = new LayerDrawable(layers);
        Context context = this.f991p.getContext();
        Drawable drawable = this.f988m;
        float b = this.f992q.mo4491b();
        float f = this.f989n;
        C0262O o = new C0262O(context, drawable, b, f, f + this.f990o);
        this.f983h = o;
        this.f983h.mo4542a(false);
        this.f992q.mo4489a(this.f983h);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4505a(ColorStateList tint) {
        Drawable drawable = this.f985j;
        if (drawable != null) {
            C1200a.m5726a(drawable, tint);
        }
        C0320y yVar = this.f987l;
        if (yVar != null) {
            yVar.mo4710a(tint);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4507a(Mode tintMode) {
        Drawable drawable = this.f985j;
        if (drawable != null) {
            C1200a.m5729a(drawable, tintMode);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4504a(int rippleColor) {
        Drawable drawable = this.f986k;
        if (drawable != null) {
            C1200a.m5726a(drawable, m1537b(rippleColor));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo4502a(float elevation) {
        if (this.f989n != elevation) {
            this.f989n = elevation;
            mo4503a(elevation, this.f990o);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo4515c() {
        return this.f989n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo4512b(float translationZ) {
        if (this.f990o != translationZ) {
            this.f990o = translationZ;
            mo4503a(this.f989n, translationZ);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4503a(float elevation, float pressedTranslationZ) {
        C0262O o = this.f983h;
        if (o != null) {
            o.mo4541a(elevation, this.f990o + elevation);
            mo4526n();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4510a(int[] state) {
        this.f982g.mo4629a(state);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo4518f() {
        this.f982g.mo4628a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4509a(C0254c listener, boolean fromUser) {
        if (!mo4516d()) {
            this.f991p.animate().cancel();
            if (m1539p()) {
                this.f981f = 1;
                this.f991p.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0280a.f1076c).setListener(new C0248H(this, fromUser, listener));
            } else {
                this.f991p.mo4666a(fromUser ? 8 : 4, fromUser);
                if (listener != null) {
                    listener.mo4493b();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4514b(C0254c listener, boolean fromUser) {
        if (!mo4517e()) {
            this.f991p.animate().cancel();
            if (m1539p()) {
                this.f981f = 2;
                if (this.f991p.getVisibility() != 0) {
                    this.f991p.setAlpha(0.0f);
                    this.f991p.setScaleY(0.0f);
                    this.f991p.setScaleX(0.0f);
                }
                this.f991p.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0280a.f1077d).setListener(new C0249I(this, fromUser, listener));
            } else {
                this.f991p.mo4666a(0, fromUser);
                this.f991p.setAlpha(1.0f);
                this.f991p.setScaleY(1.0f);
                this.f991p.setScaleX(1.0f);
                if (listener != null) {
                    listener.mo4492a();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Drawable mo4511b() {
        return this.f988m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo4522j() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final void mo4526n() {
        Rect rect = this.f993r;
        mo4508a(rect);
        mo4513b(rect);
        this.f992q.mo4488a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4508a(Rect rect) {
        this.f983h.getPadding(rect);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4513b(Rect padding) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo4521i() {
        if (mo4525m()) {
            m1538o();
            this.f991p.getViewTreeObserver().addOnPreDrawListener(this.f994s);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo4523k() {
        if (this.f994s != null) {
            this.f991p.getViewTreeObserver().removeOnPreDrawListener(this.f994s);
            this.f994s = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo4525m() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0320y mo4501a(int borderWidth, ColorStateList backgroundTint) {
        Context context = this.f991p.getContext();
        C0320y borderDrawable = mo4519g();
        borderDrawable.mo4709a(C0510b.m2564a(context, C1169c.design_fab_stroke_top_outer_color), C0510b.m2564a(context, C1169c.design_fab_stroke_top_inner_color), C0510b.m2564a(context, C1169c.design_fab_stroke_end_inner_color), C0510b.m2564a(context, C1169c.design_fab_stroke_end_outer_color));
        borderDrawable.mo4708a((float) borderWidth);
        borderDrawable.mo4710a(backgroundTint);
        return borderDrawable;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public C0320y mo4519g() {
        return new C0320y();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo4524l() {
        float rotation = this.f991p.getRotation();
        if (this.f984i != rotation) {
            this.f984i = rotation;
            m1540q();
        }
    }

    /* renamed from: o */
    private void m1538o() {
        if (this.f994s == null) {
            this.f994s = new C0250J(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public GradientDrawable mo4500a() {
        GradientDrawable d = mo4520h();
        d.setShape(1);
        d.setColor(-1);
        return d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public GradientDrawable mo4520h() {
        return new GradientDrawable();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo4517e() {
        boolean z = false;
        if (this.f991p.getVisibility() != 0) {
            if (this.f981f == 2) {
                z = true;
            }
            return z;
        }
        if (this.f981f != 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo4516d() {
        boolean z = false;
        if (this.f991p.getVisibility() == 0) {
            if (this.f981f == 1) {
                z = true;
            }
            return z;
        }
        if (this.f981f != 2) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private ValueAnimator m1536a(C0256e impl) {
        ValueAnimator animator = new ValueAnimator();
        animator.setInterpolator(f976a);
        animator.setDuration(100);
        animator.addListener(impl);
        animator.addUpdateListener(impl);
        animator.setFloatValues(new float[]{0.0f, 1.0f});
        return animator;
    }

    /* renamed from: b */
    private static ColorStateList m1537b(int selectedColor) {
        int[][] states = new int[3][];
        int[] colors = new int[3];
        states[0] = f978c;
        colors[0] = selectedColor;
        int i = 0 + 1;
        states[i] = f977b;
        colors[i] = selectedColor;
        int i2 = i + 1;
        states[i2] = new int[0];
        colors[i2] = 0;
        int i3 = i2 + 1;
        return new ColorStateList(states, colors);
    }

    /* renamed from: p */
    private boolean m1539p() {
        return C0646w.m2987u(this.f991p) && !this.f991p.isInEditMode();
    }

    /* renamed from: q */
    private void m1540q() {
        if (VERSION.SDK_INT == 19) {
            if (this.f984i % 90.0f != 0.0f) {
                if (this.f991p.getLayerType() != 1) {
                    this.f991p.setLayerType(1, null);
                }
            } else if (this.f991p.getLayerType() != 0) {
                this.f991p.setLayerType(0, null);
            }
        }
        C0262O o = this.f983h;
        if (o != null) {
            o.mo4540a(-this.f984i);
        }
        C0320y yVar = this.f987l;
        if (yVar != null) {
            yVar.mo4711b(-this.f984i);
        }
    }
}
