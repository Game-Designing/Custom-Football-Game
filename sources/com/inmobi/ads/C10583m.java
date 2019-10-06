package com.inmobi.ads;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.inmobi.ads.m */
/* compiled from: AnimationController */
final class C10583m {

    /* renamed from: com.inmobi.ads.m$a */
    /* compiled from: AnimationController */
    static class C10584a extends Animation {

        /* renamed from: a */
        private final float f32238a = 0.0f;

        /* renamed from: b */
        private final float f32239b = 90.0f;

        /* renamed from: c */
        private final float f32240c;

        /* renamed from: d */
        private final float f32241d;

        /* renamed from: e */
        private final float f32242e;

        /* renamed from: f */
        private final boolean f32243f;

        /* renamed from: g */
        private Camera f32244g;

        public C10584a(float f, float f2) {
            this.f32240c = f;
            this.f32241d = f2;
            this.f32242e = 0.0f;
            this.f32243f = true;
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.f32244g = new Camera();
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.f32238a;
            float f3 = f2 + ((this.f32239b - f2) * f);
            float f4 = this.f32240c;
            float f5 = this.f32241d;
            Camera camera = this.f32244g;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.f32243f) {
                camera.translate(0.0f, 0.0f, this.f32242e * f);
            } else {
                camera.translate(0.0f, 0.0f, this.f32242e * (1.0f - f));
            }
            camera.rotateX(f3);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
    }

    /* renamed from: com.inmobi.ads.m$b */
    /* compiled from: AnimationController */
    static class C10585b extends Animation {

        /* renamed from: a */
        private final float f32245a = 0.0f;

        /* renamed from: b */
        private final float f32246b = 90.0f;

        /* renamed from: c */
        private final float f32247c;

        /* renamed from: d */
        private final float f32248d;

        /* renamed from: e */
        private final float f32249e;

        /* renamed from: f */
        private final boolean f32250f;

        /* renamed from: g */
        private Camera f32251g;

        public C10585b(float f, float f2) {
            this.f32247c = f;
            this.f32248d = f2;
            this.f32249e = 0.0f;
            this.f32250f = true;
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.f32251g = new Camera();
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.f32245a;
            float f3 = f2 + ((this.f32246b - f2) * f);
            float f4 = this.f32247c;
            float f5 = this.f32248d;
            Camera camera = this.f32251g;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.f32250f) {
                camera.translate(0.0f, 0.0f, this.f32249e * f);
            } else {
                camera.translate(0.0f, 0.0f, this.f32249e * (1.0f - f));
            }
            camera.rotateY(f3);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
    }
}
