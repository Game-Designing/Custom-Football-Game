package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p053g.p054a.p055a.C1200a;

/* renamed from: android.support.design.widget.L */
/* compiled from: FloatingActionButtonLollipop */
class C0257L extends C0251K {

    /* renamed from: t */
    private InsetDrawable f1002t;

    /* renamed from: android.support.design.widget.L$a */
    /* compiled from: FloatingActionButtonLollipop */
    static class C0258a extends GradientDrawable {
        C0258a() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    C0257L(C0299ja view, C0263P shadowViewDelegate) {
        super(view, shadowViewDelegate);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4506a(ColorStateList backgroundTint, Mode backgroundTintMode, int rippleColor, int borderWidth) {
        Drawable rippleContent;
        this.f985j = C1200a.m5741i(mo4500a());
        C1200a.m5726a(this.f985j, backgroundTint);
        if (backgroundTintMode != null) {
            C1200a.m5729a(this.f985j, backgroundTintMode);
        }
        if (borderWidth > 0) {
            this.f987l = mo4501a(borderWidth, backgroundTint);
            rippleContent = new LayerDrawable(new Drawable[]{this.f987l, this.f985j});
        } else {
            this.f987l = null;
            rippleContent = this.f985j;
        }
        this.f986k = new RippleDrawable(ColorStateList.valueOf(rippleColor), rippleContent, null);
        Drawable drawable = this.f986k;
        this.f988m = drawable;
        this.f992q.mo4489a(drawable);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4504a(int rippleColor) {
        Drawable drawable = this.f986k;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ColorStateList.valueOf(rippleColor));
        } else {
            super.mo4504a(rippleColor);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4503a(float elevation, float pressedTranslationZ) {
        float f = elevation;
        float f2 = pressedTranslationZ;
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            AnimatorSet set = new AnimatorSet();
            String str = "elevation";
            set.play(ObjectAnimator.ofFloat(this.f991p, str, new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f991p, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            set.setInterpolator(C0251K.f976a);
            stateListAnimator.addState(C0251K.f977b, set);
            AnimatorSet set2 = new AnimatorSet();
            set2.play(ObjectAnimator.ofFloat(this.f991p, str, new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f991p, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            set2.setInterpolator(C0251K.f976a);
            stateListAnimator.addState(C0251K.f978c, set2);
            AnimatorSet set3 = new AnimatorSet();
            List<Animator> animators = new ArrayList<>();
            animators.add(ObjectAnimator.ofFloat(this.f991p, str, new float[]{f}).setDuration(0));
            int i = VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                C0299ja jaVar = this.f991p;
                animators.add(ObjectAnimator.ofFloat(jaVar, View.TRANSLATION_Z, new float[]{jaVar.getTranslationZ()}).setDuration(100));
            }
            animators.add(ObjectAnimator.ofFloat(this.f991p, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            set3.playSequentially((Animator[]) animators.toArray(new ObjectAnimator[0]));
            set3.setInterpolator(C0251K.f976a);
            stateListAnimator.addState(C0251K.f979d, set3);
            AnimatorSet set4 = new AnimatorSet();
            set4.play(ObjectAnimator.ofFloat(this.f991p, str, new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f991p, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            set4.setInterpolator(C0251K.f976a);
            stateListAnimator.addState(C0251K.f980e, set4);
            this.f991p.setStateListAnimator(stateListAnimator);
        } else if (this.f991p.isEnabled()) {
            this.f991p.setElevation(f);
            if (this.f991p.isFocused() || this.f991p.isPressed()) {
                this.f991p.setTranslationZ(f2);
            } else {
                this.f991p.setTranslationZ(0.0f);
            }
        } else {
            this.f991p.setElevation(0.0f);
            this.f991p.setTranslationZ(0.0f);
        }
        if (this.f992q.mo4490a()) {
            mo4526n();
        }
    }

    /* renamed from: c */
    public float mo4515c() {
        return this.f991p.getElevation();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo4522j() {
        mo4526n();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4513b(Rect padding) {
        if (this.f992q.mo4490a()) {
            InsetDrawable insetDrawable = new InsetDrawable(this.f986k, padding.left, padding.top, padding.right, padding.bottom);
            this.f1002t = insetDrawable;
            this.f992q.mo4489a(this.f1002t);
            return;
        }
        this.f992q.mo4489a(this.f986k);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4510a(int[] state) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo4518f() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo4525m() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public C0320y mo4519g() {
        return new C0321z();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public GradientDrawable mo4520h() {
        return new C0258a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4508a(Rect rect) {
        if (this.f992q.mo4490a()) {
            float radius = this.f992q.mo4491b();
            float maxShadowSize = mo4515c() + this.f990o;
            int hPadding = (int) Math.ceil((double) C0262O.m1608a(maxShadowSize, radius, false));
            int vPadding = (int) Math.ceil((double) C0262O.m1611b(maxShadowSize, radius, false));
            rect.set(hPadding, vPadding, hPadding, vPadding);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
