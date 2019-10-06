package android.support.p000v4.widget;

import android.content.Context;
import android.support.p000v4.view.C0646w;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.H */
/* compiled from: ViewDragHelper */
public class C0677H {

    /* renamed from: a */
    private static final Interpolator f1886a = new C0675F();

    /* renamed from: b */
    private int f1887b;

    /* renamed from: c */
    private int f1888c;

    /* renamed from: d */
    private int f1889d = -1;

    /* renamed from: e */
    private float[] f1890e;

    /* renamed from: f */
    private float[] f1891f;

    /* renamed from: g */
    private float[] f1892g;

    /* renamed from: h */
    private float[] f1893h;

    /* renamed from: i */
    private int[] f1894i;

    /* renamed from: j */
    private int[] f1895j;

    /* renamed from: k */
    private int[] f1896k;

    /* renamed from: l */
    private int f1897l;

    /* renamed from: m */
    private VelocityTracker f1898m;

    /* renamed from: n */
    private float f1899n;

    /* renamed from: o */
    private float f1900o;

    /* renamed from: p */
    private int f1901p;

    /* renamed from: q */
    private int f1902q;

    /* renamed from: r */
    private OverScroller f1903r;

    /* renamed from: s */
    private final C0678a f1904s;

    /* renamed from: t */
    private View f1905t;

    /* renamed from: u */
    private boolean f1906u;

    /* renamed from: v */
    private final ViewGroup f1907v;

    /* renamed from: w */
    private final Runnable f1908w = new C0676G(this);

    /* renamed from: android.support.v4.widget.H$a */
    /* compiled from: ViewDragHelper */
    public static abstract class C0678a {
        /* renamed from: a */
        public abstract int mo4632a(View view, int i, int i2);

        /* renamed from: a */
        public abstract void mo4633a(View view, float f, float f2);

        /* renamed from: a */
        public abstract void mo4635a(View view, int i, int i2, int i3, int i4);

        /* renamed from: b */
        public abstract int mo4636b(View view, int i, int i2);

        /* renamed from: b */
        public abstract boolean mo4637b(View view, int i);

        /* renamed from: c */
        public abstract void mo4638c(int i);

        /* renamed from: a */
        public void mo4634a(View capturedChild, int activePointerId) {
        }

        /* renamed from: b */
        public void mo5789b(int edgeFlags, int pointerId) {
        }

        /* renamed from: b */
        public boolean mo5790b(int edgeFlags) {
            return false;
        }

        /* renamed from: a */
        public void mo5788a(int edgeFlags, int pointerId) {
        }

        /* renamed from: a */
        public int mo5787a(int index) {
            return index;
        }

        /* renamed from: a */
        public int mo4631a(View child) {
            return 0;
        }

        /* renamed from: b */
        public int mo4704b(View child) {
            return 0;
        }
    }

    /* renamed from: a */
    public static C0677H m3120a(ViewGroup forParent, C0678a cb) {
        return new C0677H(forParent.getContext(), forParent, cb);
    }

    /* renamed from: a */
    public static C0677H m3119a(ViewGroup forParent, float sensitivity, C0678a cb) {
        C0677H helper = m3120a(forParent, cb);
        helper.f1888c = (int) (((float) helper.f1888c) * (1.0f / sensitivity));
        return helper;
    }

    private C0677H(Context context, ViewGroup forParent, C0678a cb) {
        if (forParent == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cb != null) {
            this.f1907v = forParent;
            this.f1904s = cb;
            ViewConfiguration vc = ViewConfiguration.get(context);
            this.f1901p = (int) ((20.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
            this.f1888c = vc.getScaledTouchSlop();
            this.f1899n = (float) vc.getScaledMaximumFlingVelocity();
            this.f1900o = (float) vc.getScaledMinimumFlingVelocity();
            this.f1903r = new OverScroller(context, f1886a);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: a */
    public void mo5776a(View childView, int activePointerId) {
        if (childView.getParent() == this.f1907v) {
            this.f1905t = childView;
            this.f1889d = activePointerId;
            this.f1904s.mo4634a(childView, activePointerId);
            mo5781b(1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        sb.append(this.f1907v);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public int mo5780b() {
        return this.f1888c;
    }

    /* renamed from: a */
    public void mo5774a() {
        this.f1889d = -1;
        m3129c();
        VelocityTracker velocityTracker = this.f1898m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1898m = null;
        }
    }

    /* renamed from: b */
    public boolean mo5785b(View child, int finalLeft, int finalTop) {
        this.f1905t = child;
        this.f1889d = -1;
        boolean continueSliding = m3128b(finalLeft, finalTop, 0, 0);
        if (!continueSliding && this.f1887b == 0 && this.f1905t != null) {
            this.f1905t = null;
        }
        return continueSliding;
    }

    /* renamed from: c */
    public boolean mo5786c(int finalLeft, int finalTop) {
        if (this.f1906u) {
            return m3128b(finalLeft, finalTop, (int) this.f1898m.getXVelocity(this.f1889d), (int) this.f1898m.getYVelocity(this.f1889d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: b */
    private boolean m3128b(int finalLeft, int finalTop, int xvel, int yvel) {
        int startLeft = this.f1905t.getLeft();
        int startTop = this.f1905t.getTop();
        int dx = finalLeft - startLeft;
        int dy = finalTop - startTop;
        if (dx == 0 && dy == 0) {
            this.f1903r.abortAnimation();
            mo5781b(0);
            return false;
        }
        this.f1903r.startScroll(startLeft, startTop, dx, dy, m3118a(this.f1905t, dx, dy, xvel, yvel));
        mo5781b(2);
        return true;
    }

    /* renamed from: a */
    private int m3118a(View child, int dx, int dy, int xvel, int yvel) {
        float f;
        float f2;
        float f3;
        float f4;
        View view = child;
        int xvel2 = m3117a(xvel, (int) this.f1900o, (int) this.f1899n);
        int yvel2 = m3117a(yvel, (int) this.f1900o, (int) this.f1899n);
        int absDx = Math.abs(dx);
        int absDy = Math.abs(dy);
        int absXVel = Math.abs(xvel2);
        int absYVel = Math.abs(yvel2);
        int addedVel = absXVel + absYVel;
        int addedDistance = absDx + absDy;
        if (xvel2 != 0) {
            f2 = (float) absXVel;
            f = (float) addedVel;
        } else {
            f2 = (float) absDx;
            f = (float) addedDistance;
        }
        float xweight = f2 / f;
        if (yvel2 != 0) {
            f4 = (float) absYVel;
            f3 = (float) addedVel;
        } else {
            f4 = (float) absDy;
            f3 = (float) addedDistance;
        }
        float yweight = f4 / f3;
        return (int) ((((float) m3126b(dx, xvel2, this.f1904s.mo4631a(view))) * xweight) + (((float) m3126b(dy, yvel2, this.f1904s.mo4704b(view))) * yweight));
    }

    /* renamed from: b */
    private int m3126b(int delta, int velocity, int motionRange) {
        int duration;
        if (delta == 0) {
            return 0;
        }
        int width = this.f1907v.getWidth();
        int halfWidth = width / 2;
        float distance = ((float) halfWidth) + (((float) halfWidth) * m3115a(Math.min(1.0f, ((float) Math.abs(delta)) / ((float) width))));
        int velocity2 = Math.abs(velocity);
        if (velocity2 > 0) {
            duration = Math.round(Math.abs(distance / ((float) velocity2)) * 1000.0f) * 4;
        } else {
            duration = (int) ((1.0f + (((float) Math.abs(delta)) / ((float) motionRange))) * 256.0f);
        }
        return Math.min(duration, 600);
    }

    /* renamed from: a */
    private int m3117a(int value, int absMin, int absMax) {
        int absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0;
        }
        if (absValue <= absMax) {
            return value;
        }
        return value > 0 ? absMax : -absMax;
    }

    /* renamed from: a */
    private float m3116a(float value, float absMin, float absMax) {
        float absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0.0f;
        }
        if (absValue <= absMax) {
            return value;
        }
        return value > 0.0f ? absMax : -absMax;
    }

    /* renamed from: a */
    private float m3115a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* renamed from: a */
    public boolean mo5779a(boolean deferCallbacks) {
        if (this.f1887b == 2) {
            boolean keepGoing = this.f1903r.computeScrollOffset();
            int x = this.f1903r.getCurrX();
            int y = this.f1903r.getCurrY();
            int dx = x - this.f1905t.getLeft();
            int dy = y - this.f1905t.getTop();
            if (dx != 0) {
                C0646w.m2948a(this.f1905t, dx);
            }
            if (dy != 0) {
                C0646w.m2965b(this.f1905t, dy);
            }
            if (!(dx == 0 && dy == 0)) {
                this.f1904s.mo4635a(this.f1905t, x, y, dx, dy);
            }
            if (keepGoing && x == this.f1903r.getFinalX() && y == this.f1903r.getFinalY()) {
                this.f1903r.abortAnimation();
                keepGoing = false;
            }
            if (!keepGoing) {
                if (deferCallbacks) {
                    this.f1907v.post(this.f1908w);
                } else {
                    mo5781b(0);
                }
            }
        }
        if (this.f1887b == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m3121a(float xvel, float yvel) {
        this.f1906u = true;
        this.f1904s.mo4633a(this.f1905t, xvel, yvel);
        this.f1906u = false;
        if (this.f1887b == 1) {
            mo5781b(0);
        }
    }

    /* renamed from: c */
    private void m3129c() {
        float[] fArr = this.f1890e;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f1891f, 0.0f);
            Arrays.fill(this.f1892g, 0.0f);
            Arrays.fill(this.f1893h, 0.0f);
            Arrays.fill(this.f1894i, 0);
            Arrays.fill(this.f1895j, 0);
            Arrays.fill(this.f1896k, 0);
            this.f1897l = 0;
        }
    }

    /* renamed from: c */
    private void m3130c(int pointerId) {
        if (this.f1890e != null && mo5777a(pointerId)) {
            this.f1890e[pointerId] = 0.0f;
            this.f1891f[pointerId] = 0.0f;
            this.f1892g[pointerId] = 0.0f;
            this.f1893h[pointerId] = 0.0f;
            this.f1894i[pointerId] = 0;
            this.f1895j[pointerId] = 0;
            this.f1896k[pointerId] = 0;
            this.f1897l &= (1 << pointerId) ^ -1;
        }
    }

    /* renamed from: d */
    private void m3134d(int pointerId) {
        float[] fArr = this.f1890e;
        if (fArr == null || fArr.length <= pointerId) {
            float[] imx = new float[(pointerId + 1)];
            float[] imy = new float[(pointerId + 1)];
            float[] lmx = new float[(pointerId + 1)];
            float[] lmy = new float[(pointerId + 1)];
            int[] iit = new int[(pointerId + 1)];
            int[] edip = new int[(pointerId + 1)];
            int[] edl = new int[(pointerId + 1)];
            float[] fArr2 = this.f1890e;
            if (fArr2 != null) {
                System.arraycopy(fArr2, 0, imx, 0, fArr2.length);
                float[] fArr3 = this.f1891f;
                System.arraycopy(fArr3, 0, imy, 0, fArr3.length);
                float[] fArr4 = this.f1892g;
                System.arraycopy(fArr4, 0, lmx, 0, fArr4.length);
                float[] fArr5 = this.f1893h;
                System.arraycopy(fArr5, 0, lmy, 0, fArr5.length);
                int[] iArr = this.f1894i;
                System.arraycopy(iArr, 0, iit, 0, iArr.length);
                int[] iArr2 = this.f1895j;
                System.arraycopy(iArr2, 0, edip, 0, iArr2.length);
                int[] iArr3 = this.f1896k;
                System.arraycopy(iArr3, 0, edl, 0, iArr3.length);
            }
            this.f1890e = imx;
            this.f1891f = imy;
            this.f1892g = lmx;
            this.f1893h = lmy;
            this.f1894i = iit;
            this.f1895j = edip;
            this.f1896k = edl;
        }
    }

    /* renamed from: b */
    private void m3127b(float x, float y, int pointerId) {
        m3134d(pointerId);
        float[] fArr = this.f1890e;
        this.f1892g[pointerId] = x;
        fArr[pointerId] = x;
        float[] fArr2 = this.f1891f;
        this.f1893h[pointerId] = y;
        fArr2[pointerId] = y;
        this.f1894i[pointerId] = m3132d((int) x, (int) y);
        this.f1897l |= 1 << pointerId;
    }

    /* renamed from: c */
    private void m3131c(MotionEvent ev) {
        int pointerCount = ev.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = ev.getPointerId(i);
            if (m3135e(pointerId)) {
                float x = ev.getX(i);
                float y = ev.getY(i);
                this.f1892g[pointerId] = x;
                this.f1893h[pointerId] = y;
            }
        }
    }

    /* renamed from: a */
    public boolean mo5777a(int pointerId) {
        return (this.f1897l & (1 << pointerId)) != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5781b(int state) {
        this.f1907v.removeCallbacks(this.f1908w);
        if (this.f1887b != state) {
            this.f1887b = state;
            this.f1904s.mo4638c(state);
            if (this.f1887b == 0) {
                this.f1905t = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo5784b(View toCapture, int pointerId) {
        if (toCapture == this.f1905t && this.f1889d == pointerId) {
            return true;
        }
        if (toCapture == null || !this.f1904s.mo4637b(toCapture, pointerId)) {
            return false;
        }
        this.f1889d = pointerId;
        mo5776a(toCapture, pointerId);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0110, code lost:
        if (r2 != r15) goto L_0x011f;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo5783b(android.view.MotionEvent r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            int r2 = r22.getActionMasked()
            int r3 = r22.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r21.mo5774a()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f1898m
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f1898m = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f1898m
            r4.addMovement(r1)
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0156
            if (r2 == r6) goto L_0x014d
            if (r2 == r5) goto L_0x008d
            r7 = 3
            if (r2 == r7) goto L_0x0087
            r7 = 5
            if (r2 == r7) goto L_0x0046
            r5 = 6
            if (r2 == r5) goto L_0x0038
            r16 = r2
            r17 = r3
            r4 = 0
            goto L_0x018b
        L_0x0038:
            int r5 = r1.getPointerId(r3)
            r0.m3130c(r5)
            r16 = r2
            r17 = r3
            r4 = 0
            goto L_0x018b
        L_0x0046:
            int r7 = r1.getPointerId(r3)
            float r8 = r1.getX(r3)
            float r9 = r1.getY(r3)
            r0.m3127b(r8, r9, r7)
            int r10 = r0.f1887b
            if (r10 != 0) goto L_0x006a
            int[] r5 = r0.f1894i
            r5 = r5[r7]
            int r10 = r0.f1902q
            r11 = r5 & r10
            if (r11 == 0) goto L_0x0080
            android.support.v4.widget.H$a r11 = r0.f1904s
            r10 = r10 & r5
            r11.mo5789b(r10, r7)
            goto L_0x0080
        L_0x006a:
            if (r10 != r5) goto L_0x0080
            int r5 = (int) r8
            int r10 = (int) r9
            android.view.View r5 = r0.mo5773a(r5, r10)
            android.view.View r10 = r0.f1905t
            if (r5 != r10) goto L_0x0079
            r0.mo5784b(r5, r7)
        L_0x0079:
            r16 = r2
            r17 = r3
            r4 = 0
            goto L_0x018b
        L_0x0080:
            r16 = r2
            r17 = r3
            r4 = 0
            goto L_0x018b
        L_0x0087:
            r16 = r2
            r17 = r3
            goto L_0x0151
        L_0x008d:
            float[] r5 = r0.f1890e
            if (r5 == 0) goto L_0x0147
            float[] r5 = r0.f1891f
            if (r5 != 0) goto L_0x009c
            r16 = r2
            r17 = r3
            r4 = 0
            goto L_0x018b
        L_0x009c:
            int r5 = r22.getPointerCount()
            r7 = 0
        L_0x00a1:
            if (r7 >= r5) goto L_0x013c
            int r8 = r1.getPointerId(r7)
            boolean r9 = r0.m3135e(r8)
            if (r9 != 0) goto L_0x00b5
            r16 = r2
            r17 = r3
            r19 = r5
            goto L_0x0131
        L_0x00b5:
            float r9 = r1.getX(r7)
            float r10 = r1.getY(r7)
            float[] r11 = r0.f1890e
            r11 = r11[r8]
            float r11 = r9 - r11
            float[] r12 = r0.f1891f
            r12 = r12[r8]
            float r12 = r10 - r12
            int r13 = (int) r9
            int r14 = (int) r10
            android.view.View r13 = r0.mo5773a(r13, r14)
            if (r13 == 0) goto L_0x00d9
            boolean r14 = r0.m3125a(r13, r11, r12)
            if (r14 == 0) goto L_0x00d9
            r14 = 1
            goto L_0x00da
        L_0x00d9:
            r14 = 0
        L_0x00da:
            if (r14 == 0) goto L_0x0119
            int r15 = r13.getLeft()
            int r4 = (int) r11
            int r4 = r4 + r15
            android.support.v4.widget.H$a r6 = r0.f1904s
            r16 = r2
            int r2 = (int) r11
            int r2 = r6.mo4632a(r13, r4, r2)
            int r6 = r13.getTop()
            r17 = r3
            int r3 = (int) r12
            int r3 = r3 + r6
            r18 = r4
            android.support.v4.widget.H$a r4 = r0.f1904s
            r19 = r5
            int r5 = (int) r12
            int r4 = r4.mo4636b(r13, r3, r5)
            android.support.v4.widget.H$a r5 = r0.f1904s
            int r5 = r5.mo4631a(r13)
            r20 = r3
            android.support.v4.widget.H$a r3 = r0.f1904s
            int r3 = r3.mo4704b(r13)
            if (r5 == 0) goto L_0x0112
            if (r5 <= 0) goto L_0x011f
            if (r2 != r15) goto L_0x011f
        L_0x0112:
            if (r3 == 0) goto L_0x0142
            if (r3 <= 0) goto L_0x011f
            if (r4 != r6) goto L_0x011f
            goto L_0x0142
        L_0x0119:
            r16 = r2
            r17 = r3
            r19 = r5
        L_0x011f:
            r0.m3122a(r11, r12, r8)
            int r2 = r0.f1887b
            r3 = 1
            if (r2 != r3) goto L_0x0128
            goto L_0x0142
        L_0x0128:
            if (r14 == 0) goto L_0x0131
            boolean r2 = r0.mo5784b(r13, r8)
            if (r2 == 0) goto L_0x0131
            goto L_0x0142
        L_0x0131:
            int r7 = r7 + 1
            r2 = r16
            r3 = r17
            r5 = r19
            r6 = 1
            goto L_0x00a1
        L_0x013c:
            r16 = r2
            r17 = r3
            r19 = r5
        L_0x0142:
            r21.m3131c(r22)
            r4 = 0
            goto L_0x018b
        L_0x0147:
            r16 = r2
            r17 = r3
            r4 = 0
            goto L_0x018b
        L_0x014d:
            r16 = r2
            r17 = r3
        L_0x0151:
            r21.mo5774a()
            r4 = 0
            goto L_0x018b
        L_0x0156:
            r16 = r2
            r17 = r3
            float r2 = r22.getX()
            float r3 = r22.getY()
            r4 = 0
            int r6 = r1.getPointerId(r4)
            r0.m3127b(r2, r3, r6)
            int r7 = (int) r2
            int r8 = (int) r3
            android.view.View r7 = r0.mo5773a(r7, r8)
            android.view.View r8 = r0.f1905t
            if (r7 != r8) goto L_0x017b
            int r8 = r0.f1887b
            if (r8 != r5) goto L_0x017b
            r0.mo5784b(r7, r6)
        L_0x017b:
            int[] r5 = r0.f1894i
            r5 = r5[r6]
            int r8 = r0.f1902q
            r9 = r5 & r8
            if (r9 == 0) goto L_0x018b
            android.support.v4.widget.H$a r9 = r0.f1904s
            r8 = r8 & r5
            r9.mo5789b(r8, r6)
        L_0x018b:
            int r2 = r0.f1887b
            r3 = 1
            if (r2 != r3) goto L_0x0191
            goto L_0x0192
        L_0x0191:
            r3 = 0
        L_0x0192:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.C0677H.mo5783b(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    public void mo5775a(MotionEvent ev) {
        int action = ev.getActionMasked();
        int actionIndex = ev.getActionIndex();
        if (action == 0) {
            mo5774a();
        }
        if (this.f1898m == null) {
            this.f1898m = VelocityTracker.obtain();
        }
        this.f1898m.addMovement(ev);
        if (action == 0) {
            float x = ev.getX();
            float y = ev.getY();
            int pointerId = ev.getPointerId(0);
            View toCapture = mo5773a((int) x, (int) y);
            m3127b(x, y, pointerId);
            mo5784b(toCapture, pointerId);
            int edgesTouched = this.f1894i[pointerId];
            int i = this.f1902q;
            if ((edgesTouched & i) != 0) {
                this.f1904s.mo5789b(i & edgesTouched, pointerId);
            }
        } else if (action == 1) {
            if (this.f1887b == 1) {
                m3133d();
            }
            mo5774a();
        } else if (action != 2) {
            if (action == 3) {
                if (this.f1887b == 1) {
                    m3121a(0.0f, 0.0f);
                }
                mo5774a();
            } else if (action == 5) {
                int pointerId2 = ev.getPointerId(actionIndex);
                float x2 = ev.getX(actionIndex);
                float y2 = ev.getY(actionIndex);
                m3127b(x2, y2, pointerId2);
                if (this.f1887b == 0) {
                    mo5784b(mo5773a((int) x2, (int) y2), pointerId2);
                    int edgesTouched2 = this.f1894i[pointerId2];
                    int i2 = this.f1902q;
                    if ((edgesTouched2 & i2) != 0) {
                        this.f1904s.mo5789b(i2 & edgesTouched2, pointerId2);
                    }
                } else if (mo5782b((int) x2, (int) y2)) {
                    mo5784b(this.f1905t, pointerId2);
                }
            } else if (action == 6) {
                int pointerId3 = ev.getPointerId(actionIndex);
                if (this.f1887b == 1 && pointerId3 == this.f1889d) {
                    int newActivePointer = -1;
                    int pointerCount = ev.getPointerCount();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= pointerCount) {
                            break;
                        }
                        int id = ev.getPointerId(i3);
                        if (id != this.f1889d) {
                            View a = mo5773a((int) ev.getX(i3), (int) ev.getY(i3));
                            View view = this.f1905t;
                            if (a == view && mo5784b(view, id)) {
                                newActivePointer = this.f1889d;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (newActivePointer == -1) {
                        m3133d();
                    }
                }
                m3130c(pointerId3);
            }
        } else if (this.f1887b != 1) {
            int pointerCount2 = ev.getPointerCount();
            for (int i4 = 0; i4 < pointerCount2; i4++) {
                int pointerId4 = ev.getPointerId(i4);
                if (m3135e(pointerId4)) {
                    float x3 = ev.getX(i4);
                    float y3 = ev.getY(i4);
                    float dx = x3 - this.f1890e[pointerId4];
                    float dy = y3 - this.f1891f[pointerId4];
                    m3122a(dx, dy, pointerId4);
                    if (this.f1887b != 1) {
                        View toCapture2 = mo5773a((int) x3, (int) y3);
                        if (m3125a(toCapture2, dx, dy) && mo5784b(toCapture2, pointerId4)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            m3131c(ev);
        } else if (m3135e(this.f1889d)) {
            int index = ev.findPointerIndex(this.f1889d);
            float x4 = ev.getX(index);
            float y4 = ev.getY(index);
            float[] fArr = this.f1892g;
            int i5 = this.f1889d;
            int idx = (int) (x4 - fArr[i5]);
            int idy = (int) (y4 - this.f1893h[i5]);
            m3123a(this.f1905t.getLeft() + idx, this.f1905t.getTop() + idy, idx, idy);
            m3131c(ev);
        }
    }

    /* renamed from: a */
    private void m3122a(float dx, float dy, int pointerId) {
        int dragsStarted = 0;
        if (m3124a(dx, dy, pointerId, 1)) {
            dragsStarted = 0 | 1;
        }
        if (m3124a(dy, dx, pointerId, 4)) {
            dragsStarted |= 4;
        }
        if (m3124a(dx, dy, pointerId, 2)) {
            dragsStarted |= 2;
        }
        if (m3124a(dy, dx, pointerId, 8)) {
            dragsStarted |= 8;
        }
        if (dragsStarted != 0) {
            int[] iArr = this.f1895j;
            iArr[pointerId] = iArr[pointerId] | dragsStarted;
            this.f1904s.mo5788a(dragsStarted, pointerId);
        }
    }

    /* renamed from: a */
    private boolean m3124a(float delta, float odelta, int pointerId, int edge) {
        float absDelta = Math.abs(delta);
        float absODelta = Math.abs(odelta);
        boolean z = false;
        if (!((this.f1894i[pointerId] & edge) != edge || (this.f1902q & edge) == 0 || (this.f1896k[pointerId] & edge) == edge || (this.f1895j[pointerId] & edge) == edge)) {
            int i = this.f1888c;
            if (absDelta > ((float) i) || absODelta > ((float) i)) {
                if (absDelta >= 0.5f * absODelta || !this.f1904s.mo5790b(edge)) {
                    if ((this.f1895j[pointerId] & edge) == 0 && absDelta > ((float) this.f1888c)) {
                        z = true;
                    }
                    return z;
                }
                int[] iArr = this.f1896k;
                iArr[pointerId] = iArr[pointerId] | edge;
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m3125a(View child, float dx, float dy) {
        boolean z = false;
        if (child == null) {
            return false;
        }
        boolean checkHorizontal = this.f1904s.mo4631a(child) > 0;
        boolean checkVertical = this.f1904s.mo4704b(child) > 0;
        if (checkHorizontal && checkVertical) {
            float f = (dx * dx) + (dy * dy);
            int i = this.f1888c;
            if (f > ((float) (i * i))) {
                z = true;
            }
            return z;
        } else if (checkHorizontal) {
            if (Math.abs(dx) > ((float) this.f1888c)) {
                z = true;
            }
            return z;
        } else if (!checkVertical) {
            return false;
        } else {
            if (Math.abs(dy) > ((float) this.f1888c)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: d */
    private void m3133d() {
        this.f1898m.computeCurrentVelocity(1000, this.f1899n);
        m3121a(m3116a(this.f1898m.getXVelocity(this.f1889d), this.f1900o, this.f1899n), m3116a(this.f1898m.getYVelocity(this.f1889d), this.f1900o, this.f1899n));
    }

    /* renamed from: a */
    private void m3123a(int left, int top, int dx, int dy) {
        int i = dx;
        int i2 = dy;
        int clampedX = left;
        int clampedY = top;
        int oldLeft = this.f1905t.getLeft();
        int oldTop = this.f1905t.getTop();
        if (i != 0) {
            clampedX = this.f1904s.mo4632a(this.f1905t, left, i);
            C0646w.m2948a(this.f1905t, clampedX - oldLeft);
        } else {
            int i3 = left;
        }
        if (i2 != 0) {
            clampedY = this.f1904s.mo4636b(this.f1905t, top, i2);
            C0646w.m2965b(this.f1905t, clampedY - oldTop);
        } else {
            int i4 = top;
        }
        if (i != 0 || i2 != 0) {
            this.f1904s.mo4635a(this.f1905t, clampedX, clampedY, clampedX - oldLeft, clampedY - oldTop);
        }
    }

    /* renamed from: b */
    public boolean mo5782b(int x, int y) {
        return mo5778a(this.f1905t, x, y);
    }

    /* renamed from: a */
    public boolean mo5778a(View view, int x, int y) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (x >= view.getLeft() && x < view.getRight() && y >= view.getTop() && y < view.getBottom()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public View mo5773a(int x, int y) {
        for (int i = this.f1907v.getChildCount() - 1; i >= 0; i--) {
            ViewGroup viewGroup = this.f1907v;
            this.f1904s.mo5787a(i);
            View child = viewGroup.getChildAt(i);
            if (x >= child.getLeft() && x < child.getRight() && y >= child.getTop() && y < child.getBottom()) {
                return child;
            }
        }
        return null;
    }

    /* renamed from: d */
    private int m3132d(int x, int y) {
        int result = 0;
        if (x < this.f1907v.getLeft() + this.f1901p) {
            result = 0 | 1;
        }
        if (y < this.f1907v.getTop() + this.f1901p) {
            result |= 4;
        }
        if (x > this.f1907v.getRight() - this.f1901p) {
            result |= 2;
        }
        if (y > this.f1907v.getBottom() - this.f1901p) {
            return result | 8;
        }
        return result;
    }

    /* renamed from: e */
    private boolean m3135e(int pointerId) {
        if (mo5777a(pointerId)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Ignoring pointerId=");
        sb.append(pointerId);
        sb.append(" because ACTION_DOWN was not received ");
        sb.append("for this pointer before ACTION_MOVE. It likely happened because ");
        sb.append(" ViewDragHelper did not receive all the events in the event stream.");
        Log.e("ViewDragHelper", sb.toString());
        return false;
    }
}
