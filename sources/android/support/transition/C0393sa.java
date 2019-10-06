package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.transition.C0334M.C0337c;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.sa */
/* compiled from: Visibility */
public abstract class C0393sa extends C0334M {

    /* renamed from: K */
    private static final String[] f1300K = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: L */
    private int f1301L = 3;

    /* renamed from: android.support.transition.sa$a */
    /* compiled from: Visibility */
    private static class C0394a extends AnimatorListenerAdapter implements C0337c, C0355a {

        /* renamed from: a */
        private final View f1302a;

        /* renamed from: b */
        private final int f1303b;

        /* renamed from: c */
        private final ViewGroup f1304c;

        /* renamed from: d */
        private final boolean f1305d;

        /* renamed from: e */
        private boolean f1306e;

        /* renamed from: f */
        boolean f1307f = false;

        C0394a(View view, int finalVisibility, boolean suppressLayout) {
            this.f1302a = view;
            this.f1303b = finalVisibility;
            this.f1304c = (ViewGroup) view.getParent();
            this.f1305d = suppressLayout;
            m2005a(true);
        }

        public void onAnimationPause(Animator animation) {
            if (!this.f1307f) {
                C0375ka.m1932a(this.f1302a, this.f1303b);
            }
        }

        public void onAnimationResume(Animator animation) {
            if (!this.f1307f) {
                C0375ka.m1932a(this.f1302a, 0);
            }
        }

        public void onAnimationCancel(Animator animation) {
            this.f1307f = true;
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationStart(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            m2004a();
        }

        /* renamed from: c */
        public void mo4786c(C0334M transition) {
        }

        /* renamed from: d */
        public void mo4787d(C0334M transition) {
            m2004a();
            transition.mo4764b((C0337c) this);
        }

        /* renamed from: b */
        public void mo4785b(C0334M transition) {
            m2005a(false);
        }

        /* renamed from: a */
        public void mo4784a(C0334M transition) {
            m2005a(true);
        }

        /* renamed from: a */
        private void m2004a() {
            if (!this.f1307f) {
                C0375ka.m1932a(this.f1302a, this.f1303b);
                ViewGroup viewGroup = this.f1304c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m2005a(false);
        }

        /* renamed from: a */
        private void m2005a(boolean suppress) {
            if (this.f1305d && this.f1306e != suppress) {
                ViewGroup viewGroup = this.f1304c;
                if (viewGroup != null) {
                    this.f1306e = suppress;
                    C0353aa.m1882a(viewGroup, suppress);
                }
            }
        }
    }

    /* renamed from: android.support.transition.sa$b */
    /* compiled from: Visibility */
    private static class C0395b {

        /* renamed from: a */
        boolean f1308a;

        /* renamed from: b */
        boolean f1309b;

        /* renamed from: c */
        int f1310c;

        /* renamed from: d */
        int f1311d;

        /* renamed from: e */
        ViewGroup f1312e;

        /* renamed from: f */
        ViewGroup f1313f;

        private C0395b() {
        }

        /* synthetic */ C0395b(C0391ra x0) {
            this();
        }
    }

    /* renamed from: a */
    public abstract Animator mo4870a(ViewGroup viewGroup, View view, C0347V v, C0347V v2);

    /* renamed from: b */
    public abstract Animator mo4871b(ViewGroup viewGroup, View view, C0347V v, C0347V v2);

    /* renamed from: a */
    public void mo4876a(int mode) {
        if ((mode & -4) == 0) {
            this.f1301L = mode;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    /* renamed from: p */
    public String[] mo4780p() {
        return f1300K;
    }

    /* renamed from: d */
    private void m1993d(C0347V transitionValues) {
        String str = "android:visibility:visibility";
        transitionValues.f1214a.put(str, Integer.valueOf(transitionValues.f1215b.getVisibility()));
        transitionValues.f1214a.put("android:visibility:parent", transitionValues.f1215b.getParent());
        int[] loc = new int[2];
        transitionValues.f1215b.getLocationOnScreen(loc);
        transitionValues.f1214a.put("android:visibility:screenLocation", loc);
    }

    /* renamed from: c */
    public void mo4154c(C0347V transitionValues) {
        m1993d(transitionValues);
    }

    /* renamed from: a */
    public void mo4153a(C0347V transitionValues) {
        m1993d(transitionValues);
    }

    /* renamed from: b */
    private C0395b m1992b(C0347V startValues, C0347V endValues) {
        C0395b visInfo = new C0395b(null);
        visInfo.f1308a = false;
        visInfo.f1309b = false;
        String str = "android:visibility:parent";
        String str2 = "android:visibility:visibility";
        if (startValues == null || !startValues.f1214a.containsKey(str2)) {
            visInfo.f1310c = -1;
            visInfo.f1312e = null;
        } else {
            visInfo.f1310c = ((Integer) startValues.f1214a.get(str2)).intValue();
            visInfo.f1312e = (ViewGroup) startValues.f1214a.get(str);
        }
        if (endValues == null || !endValues.f1214a.containsKey(str2)) {
            visInfo.f1311d = -1;
            visInfo.f1313f = null;
        } else {
            visInfo.f1311d = ((Integer) endValues.f1214a.get(str2)).intValue();
            visInfo.f1313f = (ViewGroup) endValues.f1214a.get(str);
        }
        if (startValues == null || endValues == null) {
            if (startValues == null && visInfo.f1311d == 0) {
                visInfo.f1309b = true;
                visInfo.f1308a = true;
            } else if (endValues == null && visInfo.f1310c == 0) {
                visInfo.f1309b = false;
                visInfo.f1308a = true;
            }
        } else if (visInfo.f1310c == visInfo.f1311d && visInfo.f1312e == visInfo.f1313f) {
            return visInfo;
        } else {
            int i = visInfo.f1310c;
            int i2 = visInfo.f1311d;
            if (i != i2) {
                if (i == 0) {
                    visInfo.f1309b = false;
                    visInfo.f1308a = true;
                } else if (i2 == 0) {
                    visInfo.f1309b = true;
                    visInfo.f1308a = true;
                }
            } else if (visInfo.f1313f == null) {
                visInfo.f1309b = false;
                visInfo.f1308a = true;
            } else if (visInfo.f1312e == null) {
                visInfo.f1309b = true;
                visInfo.f1308a = true;
            }
        }
        return visInfo;
    }

    /* renamed from: a */
    public Animator mo4152a(ViewGroup sceneRoot, C0347V startValues, C0347V endValues) {
        C0395b visInfo = m1992b(startValues, endValues);
        if (!visInfo.f1308a || (visInfo.f1312e == null && visInfo.f1313f == null)) {
            return null;
        }
        if (visInfo.f1309b) {
            return mo4875a(sceneRoot, startValues, visInfo.f1310c, endValues, visInfo.f1311d);
        }
        return mo4877b(sceneRoot, startValues, visInfo.f1310c, endValues, visInfo.f1311d);
    }

    /* renamed from: a */
    public Animator mo4875a(ViewGroup sceneRoot, C0347V startValues, int startVisibility, C0347V endValues, int endVisibility) {
        if ((this.f1301L & 1) != 1 || endValues == null) {
            return null;
        }
        if (startValues == null) {
            View endParent = (View) endValues.f1215b.getParent();
            if (m1992b(mo4752a(endParent, false), mo4765b(endParent, false)).f1308a) {
                return null;
            }
        }
        return mo4870a(sceneRoot, endValues.f1215b, startValues, endValues);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0105  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator mo4877b(android.view.ViewGroup r20, android.support.transition.C0347V r21, int r22, android.support.transition.C0347V r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            int r4 = r0.f1301L
            r5 = 2
            r4 = r4 & r5
            r6 = 0
            if (r4 == r5) goto L_0x0010
            return r6
        L_0x0010:
            if (r2 == 0) goto L_0x0015
            android.view.View r4 = r2.f1215b
            goto L_0x0016
        L_0x0015:
            r4 = r6
        L_0x0016:
            if (r3 == 0) goto L_0x001b
            android.view.View r7 = r3.f1215b
            goto L_0x001c
        L_0x001b:
            r7 = r6
        L_0x001c:
            r8 = 0
            r9 = 0
            r10 = 1
            if (r7 == 0) goto L_0x0037
            android.view.ViewParent r11 = r7.getParent()
            if (r11 != 0) goto L_0x002a
            r12 = r24
            goto L_0x0039
        L_0x002a:
            r11 = 4
            r12 = r24
            if (r12 != r11) goto L_0x0031
            r9 = r7
            goto L_0x0085
        L_0x0031:
            if (r4 != r7) goto L_0x0035
            r9 = r7
            goto L_0x0085
        L_0x0035:
            r8 = r4
            goto L_0x0085
        L_0x0037:
            r12 = r24
        L_0x0039:
            if (r7 == 0) goto L_0x003d
            r8 = r7
            goto L_0x0085
        L_0x003d:
            if (r4 == 0) goto L_0x0085
            android.view.ViewParent r11 = r4.getParent()
            if (r11 != 0) goto L_0x0047
            r8 = r4
            goto L_0x0085
        L_0x0047:
            android.view.ViewParent r11 = r4.getParent()
            boolean r11 = r11 instanceof android.view.View
            if (r11 == 0) goto L_0x0085
            android.view.ViewParent r11 = r4.getParent()
            android.view.View r11 = (android.view.View) r11
            android.support.transition.V r13 = r0.mo4765b(r11, r10)
            android.support.transition.V r14 = r0.mo4752a(r11, r10)
            android.support.transition.sa$b r15 = r0.m1992b(r13, r14)
            boolean r6 = r15.f1308a
            if (r6 != 0) goto L_0x006c
            android.view.View r6 = android.support.transition.C0346U.m1868a(r1, r4, r11)
            r8 = r6
            goto L_0x0085
        L_0x006c:
            android.view.ViewParent r6 = r11.getParent()
            if (r6 != 0) goto L_0x0085
            int r6 = r11.getId()
            r5 = -1
            if (r6 == r5) goto L_0x0085
            android.view.View r5 = r1.findViewById(r6)
            if (r5 == 0) goto L_0x0085
            boolean r5 = r0.f1194z
            if (r5 == 0) goto L_0x0085
            r5 = r4
            r8 = r5
        L_0x0085:
            r5 = r24
            r6 = 0
            if (r8 == 0) goto L_0x00df
            if (r2 == 0) goto L_0x00df
            java.util.Map<java.lang.String, java.lang.Object> r11 = r2.f1214a
            java.lang.String r13 = "android:visibility:screenLocation"
            java.lang.Object r11 = r11.get(r13)
            int[] r11 = (int[]) r11
            r13 = r11[r6]
            r14 = r11[r10]
            r15 = 2
            int[] r15 = new int[r15]
            r1.getLocationOnScreen(r15)
            r6 = r15[r6]
            int r6 = r13 - r6
            int r16 = r8.getLeft()
            int r6 = r6 - r16
            r8.offsetLeftAndRight(r6)
            r6 = r15[r10]
            int r6 = r14 - r6
            int r10 = r8.getTop()
            int r6 = r6 - r10
            r8.offsetTopAndBottom(r6)
            android.support.transition.Z r6 = android.support.transition.C0353aa.m1881a(r20)
            r6.mo4801a(r8)
            android.animation.Animator r10 = r0.mo4871b(r1, r8, r2, r3)
            if (r10 != 0) goto L_0x00ce
            r6.mo4802b(r8)
            r17 = r4
            r18 = r7
            goto L_0x00de
        L_0x00ce:
            r16 = r8
            r17 = r4
            android.support.transition.ra r4 = new android.support.transition.ra
            r18 = r7
            r7 = r16
            r4.<init>(r0, r6, r7)
            r10.addListener(r4)
        L_0x00de:
            return r10
        L_0x00df:
            r17 = r4
            r18 = r7
            if (r9 == 0) goto L_0x0105
            int r4 = r9.getVisibility()
            android.support.transition.C0375ka.m1932a(r9, r6)
            android.animation.Animator r6 = r0.mo4871b(r1, r9, r2, r3)
            if (r6 == 0) goto L_0x0101
            android.support.transition.sa$a r7 = new android.support.transition.sa$a
            r7.<init>(r9, r5, r10)
            r6.addListener(r7)
            android.support.transition.C0352a.m1879a(r6, r7)
            r0.mo4750a(r7)
            goto L_0x0104
        L_0x0101:
            android.support.transition.C0375ka.m1932a(r9, r4)
        L_0x0104:
            return r6
        L_0x0105:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.C0393sa.mo4877b(android.view.ViewGroup, android.support.transition.V, int, android.support.transition.V, int):android.animation.Animator");
    }

    /* renamed from: a */
    public boolean mo4761a(C0347V startValues, C0347V newValues) {
        boolean z = false;
        if (startValues == null && newValues == null) {
            return false;
        }
        if (!(startValues == null || newValues == null)) {
            String str = "android:visibility:visibility";
            if (newValues.f1214a.containsKey(str) != startValues.f1214a.containsKey(str)) {
                return false;
            }
        }
        C0395b changeInfo = m1992b(startValues, newValues);
        if (changeInfo.f1308a && (changeInfo.f1310c == 0 || changeInfo.f1311d == 0)) {
            z = true;
        }
        return z;
    }
}
