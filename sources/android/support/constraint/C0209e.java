package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout.C0166a;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.constraint.e */
/* compiled from: Constraints */
public class C0209e extends ViewGroup {

    /* renamed from: a */
    C0207d f690a;

    /* renamed from: android.support.constraint.e$a */
    /* compiled from: Constraints */
    public static class C0210a extends C0166a {

        /* renamed from: na */
        public float f691na = 1.0f;

        /* renamed from: oa */
        public boolean f692oa = false;

        /* renamed from: pa */
        public float f693pa = 0.0f;

        /* renamed from: qa */
        public float f694qa = 0.0f;

        /* renamed from: ra */
        public float f695ra = 0.0f;

        /* renamed from: sa */
        public float f696sa = 0.0f;

        /* renamed from: ta */
        public float f697ta = 1.0f;

        /* renamed from: ua */
        public float f698ua = 1.0f;

        /* renamed from: va */
        public float f699va = 0.0f;

        /* renamed from: wa */
        public float f700wa = 0.0f;

        /* renamed from: xa */
        public float f701xa = 0.0f;

        /* renamed from: ya */
        public float f702ya = 0.0f;

        /* renamed from: za */
        public float f703za = 0.0f;

        public C0210a(int width, int height) {
            super(width, height);
        }

        public C0210a(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, C0214i.ConstraintSet);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == C0214i.ConstraintSet_android_alpha) {
                    this.f691na = a.getFloat(attr, this.f691na);
                } else if (attr == C0214i.ConstraintSet_android_elevation) {
                    this.f693pa = a.getFloat(attr, this.f693pa);
                    this.f692oa = true;
                } else if (attr == C0214i.ConstraintSet_android_rotationX) {
                    this.f695ra = a.getFloat(attr, this.f695ra);
                } else if (attr == C0214i.ConstraintSet_android_rotationY) {
                    this.f696sa = a.getFloat(attr, this.f696sa);
                } else if (attr == C0214i.ConstraintSet_android_rotation) {
                    this.f694qa = a.getFloat(attr, this.f694qa);
                } else if (attr == C0214i.ConstraintSet_android_scaleX) {
                    this.f697ta = a.getFloat(attr, this.f697ta);
                } else if (attr == C0214i.ConstraintSet_android_scaleY) {
                    this.f698ua = a.getFloat(attr, this.f698ua);
                } else if (attr == C0214i.ConstraintSet_android_transformPivotX) {
                    this.f699va = a.getFloat(attr, this.f699va);
                } else if (attr == C0214i.ConstraintSet_android_transformPivotY) {
                    this.f700wa = a.getFloat(attr, this.f700wa);
                } else if (attr == C0214i.ConstraintSet_android_translationX) {
                    this.f701xa = a.getFloat(attr, this.f701xa);
                } else if (attr == C0214i.ConstraintSet_android_translationY) {
                    this.f702ya = a.getFloat(attr, this.f702ya);
                } else if (attr == C0214i.ConstraintSet_android_translationZ) {
                    this.f701xa = a.getFloat(attr, this.f703za);
                }
            }
        }
    }

    public C0210a generateLayoutParams(AttributeSet attrs) {
        return new C0210a(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public C0210a generateDefaultLayoutParams() {
        return new C0210a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams p) {
        return new C0166a(p);
    }

    public C0207d getConstraintSet() {
        if (this.f690a == null) {
            this.f690a = new C0207d();
        }
        this.f690a.mo4049a(this);
        return this.f690a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
    }
}
