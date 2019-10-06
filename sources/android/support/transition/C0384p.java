package android.support.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0646w;
import android.util.Property;
import android.view.View;

/* renamed from: android.support.transition.p */
/* compiled from: ChangeBounds */
public class C0384p extends C0334M {

    /* renamed from: K */
    private static final String[] f1271K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: L */
    private static final Property<Drawable, PointF> f1272L = new C0366g(PointF.class, "boundsOrigin");

    /* renamed from: M */
    private static final Property<C0385a, PointF> f1273M;

    /* renamed from: N */
    private static final Property<C0385a, PointF> f1274N;

    /* renamed from: O */
    private static final Property<View, PointF> f1275O;

    /* renamed from: P */
    private static final Property<View, PointF> f1276P;

    /* renamed from: Q */
    private static final Property<View, PointF> f1277Q = new C0376l(PointF.class, "position");

    /* renamed from: R */
    private static C0329H f1278R = new C0329H();

    /* renamed from: S */
    private int[] f1279S = new int[2];

    /* renamed from: T */
    private boolean f1280T = false;

    /* renamed from: U */
    private boolean f1281U = false;

    /* renamed from: android.support.transition.p$a */
    /* compiled from: ChangeBounds */
    private static class C0385a {

        /* renamed from: a */
        private int f1282a;

        /* renamed from: b */
        private int f1283b;

        /* renamed from: c */
        private int f1284c;

        /* renamed from: d */
        private int f1285d;

        /* renamed from: e */
        private View f1286e;

        /* renamed from: f */
        private int f1287f;

        /* renamed from: g */
        private int f1288g;

        C0385a(View view) {
            this.f1286e = view;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4869b(PointF topLeft) {
            this.f1282a = Math.round(topLeft.x);
            this.f1283b = Math.round(topLeft.y);
            this.f1287f++;
            if (this.f1287f == this.f1288g) {
                m1972a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4868a(PointF bottomRight) {
            this.f1284c = Math.round(bottomRight.x);
            this.f1285d = Math.round(bottomRight.y);
            this.f1288g++;
            if (this.f1287f == this.f1288g) {
                m1972a();
            }
        }

        /* renamed from: a */
        private void m1972a() {
            C0375ka.m1933a(this.f1286e, this.f1282a, this.f1283b, this.f1284c, this.f1285d);
            this.f1287f = 0;
            this.f1288g = 0;
        }
    }

    static {
        String str = "topLeft";
        f1273M = new C0368h(PointF.class, str);
        String str2 = "bottomRight";
        f1274N = new C0370i(PointF.class, str2);
        f1275O = new C0372j(PointF.class, str2);
        f1276P = new C0374k(PointF.class, str);
    }

    /* renamed from: p */
    public String[] mo4780p() {
        return f1271K;
    }

    /* renamed from: d */
    private void m1967d(C0347V values) {
        View view = values.f1215b;
        if (C0646w.m2987u(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            values.f1214a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            values.f1214a.put("android:changeBounds:parent", values.f1215b.getParent());
            if (this.f1281U) {
                values.f1215b.getLocationInWindow(this.f1279S);
                values.f1214a.put("android:changeBounds:windowX", Integer.valueOf(this.f1279S[0]));
                values.f1214a.put("android:changeBounds:windowY", Integer.valueOf(this.f1279S[1]));
            }
            if (this.f1280T) {
                values.f1214a.put("android:changeBounds:clip", C0646w.m2969d(view));
            }
        }
    }

    /* renamed from: c */
    public void mo4154c(C0347V transitionValues) {
        m1967d(transitionValues);
    }

    /* renamed from: a */
    public void mo4153a(C0347V transitionValues) {
        m1967d(transitionValues);
    }

    /* renamed from: a */
    private boolean m1966a(View startParent, View endParent) {
        if (!this.f1281U) {
            return true;
        }
        boolean z = true;
        C0347V endValues = mo4752a(startParent, true);
        if (endValues == null) {
            if (startParent != endParent) {
                z = false;
            }
            return z;
        }
        if (endParent != endValues.f1215b) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r0v27, types: [android.animation.Animator] */
    /* JADX WARNING: type inference failed for: r0v28, types: [android.animation.Animator] */
    /* JADX WARNING: type inference failed for: r0v33, types: [android.animation.ObjectAnimator] */
    /* JADX WARNING: type inference failed for: r0v36, types: [android.animation.ObjectAnimator] */
    /* JADX WARNING: type inference failed for: r14v13 */
    /* JADX WARNING: type inference failed for: r0v38 */
    /* JADX WARNING: type inference failed for: r0v41, types: [android.animation.ObjectAnimator] */
    /* JADX WARNING: type inference failed for: r0v43 */
    /* JADX WARNING: type inference failed for: r0v44 */
    /* JADX WARNING: type inference failed for: r0v45 */
    /* JADX WARNING: type inference failed for: r0v46 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator mo4152a(android.view.ViewGroup r39, android.support.transition.C0347V r40, android.support.transition.C0347V r41) {
        /*
            r38 = this;
            r8 = r38
            r9 = r40
            r10 = r41
            if (r9 == 0) goto L_0x03be
            if (r10 != 0) goto L_0x0011
            r15 = r39
            r12 = r10
            r0 = 0
            r10 = r8
            goto L_0x03c3
        L_0x0011:
            java.util.Map<java.lang.String, java.lang.Object> r11 = r9.f1214a
            java.util.Map<java.lang.String, java.lang.Object> r12 = r10.f1214a
            java.lang.String r1 = "android:changeBounds:parent"
            java.lang.Object r2 = r11.get(r1)
            r13 = r2
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            java.lang.Object r1 = r12.get(r1)
            r14 = r1
            android.view.ViewGroup r14 = (android.view.ViewGroup) r14
            if (r13 == 0) goto L_0x03b0
            if (r14 != 0) goto L_0x0037
            r15 = r39
            r18 = r11
            r19 = r12
            r20 = r13
            r21 = r14
            r12 = r10
            r10 = r8
            goto L_0x03bc
        L_0x0037:
            android.view.View r15 = r10.f1215b
            boolean r1 = r8.m1966a(r13, r14)
            if (r1 == 0) goto L_0x02e7
            java.util.Map<java.lang.String, java.lang.Object> r1 = r9.f1214a
            java.lang.String r3 = "android:changeBounds:bounds"
            java.lang.Object r1 = r1.get(r3)
            r6 = r1
            android.graphics.Rect r6 = (android.graphics.Rect) r6
            java.util.Map<java.lang.String, java.lang.Object> r1 = r10.f1214a
            java.lang.Object r1 = r1.get(r3)
            r5 = r1
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            int r4 = r6.left
            int r1 = r5.left
            int r3 = r6.top
            int r7 = r5.top
            int r2 = r6.right
            r18 = r11
            int r11 = r5.right
            r19 = r12
            int r12 = r6.bottom
            r20 = r13
            int r13 = r5.bottom
            r21 = r14
            int r14 = r2 - r4
            r22 = r6
            int r6 = r12 - r3
            r23 = r5
            int r5 = r11 - r1
            int r0 = r13 - r7
            r25 = r15
            java.util.Map<java.lang.String, java.lang.Object> r15 = r9.f1214a
            java.lang.String r9 = "android:changeBounds:clip"
            java.lang.Object r15 = r15.get(r9)
            android.graphics.Rect r15 = (android.graphics.Rect) r15
            java.util.Map<java.lang.String, java.lang.Object> r8 = r10.f1214a
            java.lang.Object r8 = r8.get(r9)
            android.graphics.Rect r8 = (android.graphics.Rect) r8
            r9 = 0
            if (r14 == 0) goto L_0x0090
            if (r6 != 0) goto L_0x0094
        L_0x0090:
            if (r5 == 0) goto L_0x00a0
            if (r0 == 0) goto L_0x00a0
        L_0x0094:
            if (r4 != r1) goto L_0x0098
            if (r3 == r7) goto L_0x009a
        L_0x0098:
            int r9 = r9 + 1
        L_0x009a:
            if (r2 != r11) goto L_0x009e
            if (r12 == r13) goto L_0x00a0
        L_0x009e:
            int r9 = r9 + 1
        L_0x00a0:
            if (r15 == 0) goto L_0x00a8
            boolean r26 = r15.equals(r8)
            if (r26 == 0) goto L_0x00ac
        L_0x00a8:
            if (r15 != 0) goto L_0x00ae
            if (r8 == 0) goto L_0x00ae
        L_0x00ac:
            int r9 = r9 + 1
        L_0x00ae:
            if (r9 <= 0) goto L_0x02c2
            r10 = r38
            r26 = r15
            boolean r15 = r10.f1280T
            r27 = r8
            r8 = 2
            if (r15 != 0) goto L_0x01d4
            r15 = r25
            android.support.transition.C0375ka.m1933a(r15, r4, r3, r2, r12)
            if (r9 != r8) goto L_0x0167
            if (r14 != r5) goto L_0x00fa
            if (r6 != r0) goto L_0x00fa
            android.support.transition.A r8 = r38.mo4774h()
            r25 = r9
            float r9 = (float) r4
            r28 = r0
            float r0 = (float) r3
            r29 = r6
            float r6 = (float) r1
            r30 = r5
            float r5 = (float) r7
            android.graphics.Path r0 = r8.mo4721a(r9, r0, r6, r5)
            android.util.Property<android.view.View, android.graphics.PointF> r5 = f1277Q
            android.animation.ObjectAnimator r0 = android.support.transition.C0402w.m2018a(r15, r5, r0)
            r33 = r1
            r17 = r2
            r16 = r7
            r37 = r11
            r34 = r14
            r8 = r15
            r32 = r28
            r36 = r29
            r35 = r30
            r11 = 1
            r30 = r3
            r28 = r4
            r29 = r12
            goto L_0x02a8
        L_0x00fa:
            r28 = r0
            r30 = r5
            r29 = r6
            r25 = r9
            android.support.transition.p$a r0 = new android.support.transition.p$a
            r0.<init>(r15)
            android.support.transition.A r5 = r38.mo4774h()
            float r6 = (float) r4
            float r9 = (float) r3
            float r8 = (float) r1
            r31 = r14
            float r14 = (float) r7
            android.graphics.Path r5 = r5.mo4721a(r6, r9, r8, r14)
            android.util.Property<android.support.transition.p$a, android.graphics.PointF> r6 = f1273M
            android.animation.ObjectAnimator r6 = android.support.transition.C0402w.m2018a(r0, r6, r5)
            android.support.transition.A r8 = r38.mo4774h()
            float r9 = (float) r2
            float r14 = (float) r12
            r32 = r5
            float r5 = (float) r11
            r33 = r15
            float r15 = (float) r13
            android.graphics.Path r5 = r8.mo4721a(r9, r14, r5, r15)
            android.util.Property<android.support.transition.p$a, android.graphics.PointF> r8 = f1274N
            android.animation.ObjectAnimator r8 = android.support.transition.C0402w.m2018a(r0, r8, r5)
            android.animation.AnimatorSet r9 = new android.animation.AnimatorSet
            r9.<init>()
            r14 = 2
            android.animation.Animator[] r14 = new android.animation.Animator[r14]
            r15 = 0
            r14[r15] = r6
            r15 = 1
            r14[r15] = r8
            r9.playTogether(r14)
            r14 = r9
            android.support.transition.m r15 = new android.support.transition.m
            r15.<init>(r10, r0)
            r9.addListener(r15)
            r17 = r2
            r16 = r7
            r37 = r11
            r0 = r14
            r32 = r28
            r36 = r29
            r35 = r30
            r34 = r31
            r8 = r33
            r11 = 1
            r33 = r1
            r30 = r3
            r28 = r4
            r29 = r12
            goto L_0x02a8
        L_0x0167:
            r28 = r0
            r30 = r5
            r29 = r6
            r25 = r9
            r31 = r14
            r33 = r15
            if (r4 != r1) goto L_0x01a7
            if (r3 == r7) goto L_0x017a
            r8 = r33
            goto L_0x01a9
        L_0x017a:
            android.support.transition.A r0 = r38.mo4774h()
            float r5 = (float) r2
            float r6 = (float) r12
            float r8 = (float) r11
            float r9 = (float) r13
            android.graphics.Path r0 = r0.mo4721a(r5, r6, r8, r9)
            android.util.Property<android.view.View, android.graphics.PointF> r5 = f1275O
            r8 = r33
            android.animation.ObjectAnimator r0 = android.support.transition.C0402w.m2018a(r8, r5, r0)
            r33 = r1
            r17 = r2
            r16 = r7
            r37 = r11
            r32 = r28
            r36 = r29
            r35 = r30
            r34 = r31
            r11 = 1
            r30 = r3
            r28 = r4
            r29 = r12
            goto L_0x02a8
        L_0x01a7:
            r8 = r33
        L_0x01a9:
            android.support.transition.A r0 = r38.mo4774h()
            float r5 = (float) r4
            float r6 = (float) r3
            float r9 = (float) r1
            float r14 = (float) r7
            android.graphics.Path r0 = r0.mo4721a(r5, r6, r9, r14)
            android.util.Property<android.view.View, android.graphics.PointF> r5 = f1276P
            android.animation.ObjectAnimator r0 = android.support.transition.C0402w.m2018a(r8, r5, r0)
            r33 = r1
            r17 = r2
            r16 = r7
            r37 = r11
            r32 = r28
            r36 = r29
            r35 = r30
            r34 = r31
            r11 = 1
            r30 = r3
            r28 = r4
            r29 = r12
            goto L_0x02a8
        L_0x01d4:
            r28 = r0
            r30 = r5
            r29 = r6
            r31 = r14
            r8 = r25
            r25 = r9
            r9 = r31
            int r14 = java.lang.Math.max(r9, r5)
            int r15 = java.lang.Math.max(r6, r0)
            r28 = r2
            int r2 = r4 + r14
            r29 = r12
            int r12 = r3 + r15
            android.support.transition.C0375ka.m1933a(r8, r4, r3, r2, r12)
            r2 = 0
            if (r4 != r1) goto L_0x0204
            if (r3 == r7) goto L_0x01fc
            goto L_0x0204
        L_0x01fc:
            r33 = r1
            r12 = r2
            r32 = r3
            r31 = r4
            goto L_0x021f
        L_0x0204:
            android.support.transition.A r12 = r38.mo4774h()
            r30 = r2
            float r2 = (float) r4
            r31 = r4
            float r4 = (float) r3
            r32 = r3
            float r3 = (float) r1
            r33 = r1
            float r1 = (float) r7
            android.graphics.Path r1 = r12.mo4721a(r2, r4, r3, r1)
            android.util.Property<android.view.View, android.graphics.PointF> r2 = f1277Q
            android.animation.ObjectAnimator r2 = android.support.transition.C0402w.m2018a(r8, r2, r1)
            r12 = r2
        L_0x021f:
            r30 = r32
            r3 = r27
            if (r26 != 0) goto L_0x022d
            android.graphics.Rect r1 = new android.graphics.Rect
            r2 = 0
            r1.<init>(r2, r2, r9, r6)
            r4 = r1
            goto L_0x0230
        L_0x022d:
            r2 = 0
            r4 = r26
        L_0x0230:
            if (r27 != 0) goto L_0x0239
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>(r2, r2, r5, r0)
            r2 = r1
            goto L_0x023b
        L_0x0239:
            r2 = r27
        L_0x023b:
            r1 = 0
            boolean r26 = r4.equals(r2)
            if (r26 != 0) goto L_0x0287
            android.support.p000v4.view.C0646w.m2953a(r8, r4)
            r32 = r0
            android.support.transition.H r0 = f1278R
            r26 = r1
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r17 = 0
            r1[r17] = r4
            r16 = 1
            r1[r16] = r2
            r17 = r2
            java.lang.String r2 = "clipBounds"
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofObject(r8, r2, r0, r1)
            android.support.transition.n r1 = new android.support.transition.n
            r0 = r1
            r34 = r9
            r9 = r1
            r1 = r38
            r24 = r14
            r27 = r17
            r17 = r28
            r14 = r2
            r2 = r8
            r28 = r31
            r31 = r4
            r4 = r33
            r35 = r5
            r5 = r7
            r36 = r6
            r6 = r11
            r16 = r7
            r37 = r11
            r11 = 1
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r14.addListener(r9)
            goto L_0x02a2
        L_0x0287:
            r32 = r0
            r26 = r1
            r27 = r2
            r35 = r5
            r36 = r6
            r16 = r7
            r34 = r9
            r37 = r11
            r24 = r14
            r17 = r28
            r28 = r31
            r11 = 1
            r31 = r4
            r14 = r26
        L_0x02a2:
            android.animation.Animator r0 = android.support.transition.C0346U.m1866a(r12, r14)
            r26 = r31
        L_0x02a8:
            android.view.ViewParent r1 = r8.getParent()
            boolean r1 = r1 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x02c1
            android.view.ViewParent r1 = r8.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            android.support.transition.C0353aa.m1882a(r1, r11)
            android.support.transition.o r2 = new android.support.transition.o
            r2.<init>(r10, r1)
            r10.mo4750a(r2)
        L_0x02c1:
            return r0
        L_0x02c2:
            r10 = r38
            r32 = r0
            r33 = r1
            r17 = r2
            r30 = r3
            r28 = r4
            r35 = r5
            r36 = r6
            r16 = r7
            r27 = r8
            r37 = r11
            r29 = r12
            r34 = r14
            r26 = r15
            r8 = r25
            r25 = r9
            r6 = r40
            r12 = r41
            goto L_0x032f
        L_0x02e7:
            r10 = r8
            r18 = r11
            r19 = r12
            r20 = r13
            r21 = r14
            r8 = r15
            r11 = 1
            r6 = r40
            java.util.Map<java.lang.String, java.lang.Object> r0 = r6.f1214a
            java.lang.String r1 = "android:changeBounds:windowX"
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r7 = r0.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r0 = r6.f1214a
            java.lang.String r2 = "android:changeBounds:windowY"
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r9 = r0.intValue()
            r12 = r41
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f1214a
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r13 = r0.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f1214a
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r14 = r0.intValue()
            if (r7 != r13) goto L_0x0331
            if (r9 == r14) goto L_0x032f
            goto L_0x0331
        L_0x032f:
            r0 = 0
            return r0
        L_0x0331:
            int[] r0 = r10.f1279S
            r15 = r39
            r15.getLocationInWindow(r0)
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r5)
            r4 = r0
            r8.draw(r4)
            android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable
            r0.<init>(r5)
            r3 = r0
            float r16 = android.support.transition.C0375ka.m1937c(r8)
            r0 = 0
            android.support.transition.C0375ka.m1931a(r8, r0)
            android.support.transition.ha r0 = android.support.transition.C0375ka.m1935b(r39)
            r0.mo4803a(r3)
            android.support.transition.A r0 = r38.mo4774h()
            int[] r1 = r10.f1279S
            r2 = 0
            r17 = r1[r2]
            int r2 = r7 - r17
            float r2 = (float) r2
            r17 = r1[r11]
            int r11 = r9 - r17
            float r11 = (float) r11
            r17 = 0
            r22 = r1[r17]
            r24 = r4
            int r4 = r13 - r22
            float r4 = (float) r4
            r22 = r5
            r5 = 1
            r1 = r1[r5]
            int r1 = r14 - r1
            float r1 = (float) r1
            android.graphics.Path r11 = r0.mo4721a(r2, r11, r4, r1)
            android.util.Property<android.graphics.drawable.Drawable, android.graphics.PointF> r0 = f1272L
            android.animation.PropertyValuesHolder r23 = android.support.transition.C0324C.m1740a(r0, r11)
            android.animation.PropertyValuesHolder[] r0 = new android.animation.PropertyValuesHolder[r5]
            r1 = 0
            r0[r1] = r23
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r3, r0)
            android.support.transition.f r4 = new android.support.transition.f
            r0 = r4
            r1 = r38
            r2 = r39
            r17 = r3
            r6 = r4
            r4 = r8
            r25 = r7
            r7 = r5
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            r7.addListener(r6)
            return r7
        L_0x03b0:
            r15 = r39
            r18 = r11
            r19 = r12
            r20 = r13
            r21 = r14
            r12 = r10
            r10 = r8
        L_0x03bc:
            r0 = 0
            return r0
        L_0x03be:
            r15 = r39
            r12 = r10
            r0 = 0
            r10 = r8
        L_0x03c3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.C0384p.mo4152a(android.view.ViewGroup, android.support.transition.V, android.support.transition.V):android.animation.Animator");
    }
}
