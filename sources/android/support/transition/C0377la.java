package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.transition.la */
/* compiled from: ViewUtilsApi14 */
class C0377la implements C0388qa {
    C0377la() {
    }

    /* renamed from: b */
    public C0369ha mo4861b(View view) {
        return C0364fa.m1901c(view);
    }

    /* renamed from: e */
    public C0401va mo4865e(View view) {
        return new C0397ta(view.getWindowToken());
    }

    /* renamed from: a */
    public void mo4858a(View view, float alpha) {
        Float savedAlpha = (Float) view.getTag(C0328G.save_non_transition_alpha);
        if (savedAlpha != null) {
            view.setAlpha(savedAlpha.floatValue() * alpha);
        } else {
            view.setAlpha(alpha);
        }
    }

    /* renamed from: d */
    public float mo4864d(View view) {
        Float savedAlpha = (Float) view.getTag(C0328G.save_non_transition_alpha);
        if (savedAlpha != null) {
            return view.getAlpha() / savedAlpha.floatValue();
        }
        return view.getAlpha();
    }

    /* renamed from: a */
    public void mo4857a(View view) {
        if (view.getTag(C0328G.save_non_transition_alpha) == null) {
            view.setTag(C0328G.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    /* renamed from: c */
    public void mo4863c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(C0328G.save_non_transition_alpha, null);
        }
    }

    /* renamed from: b */
    public void mo4862b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View vp = (View) parent;
            mo4862b(vp, matrix);
            matrix.preTranslate((float) (-vp.getScrollX()), (float) (-vp.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix vm = view.getMatrix();
        if (!vm.isIdentity()) {
            matrix.preConcat(vm);
        }
    }

    /* renamed from: a */
    public void mo4860a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View vp = (View) parent;
            mo4860a(vp, matrix);
            matrix.postTranslate((float) vp.getScrollX(), (float) vp.getScrollY());
        }
        matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix vm = view.getMatrix();
        if (!vm.isIdentity()) {
            Matrix inverted = new Matrix();
            if (vm.invert(inverted)) {
                matrix.postConcat(inverted);
            }
        }
    }

    /* renamed from: a */
    public void mo4859a(View v, int left, int top, int right, int bottom) {
        v.setLeft(left);
        v.setTop(top);
        v.setRight(right);
        v.setBottom(bottom);
    }
}
