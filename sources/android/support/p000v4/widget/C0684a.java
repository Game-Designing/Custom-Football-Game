package android.support.p000v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.p000v4.view.C0646w;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.a */
/* compiled from: AutoScrollHelper */
public abstract class C0684a implements OnTouchListener {

    /* renamed from: a */
    private static final int f1981a = ViewConfiguration.getTapTimeout();

    /* renamed from: b */
    final C0685a f1982b = new C0685a();

    /* renamed from: c */
    private final Interpolator f1983c = new AccelerateInterpolator();

    /* renamed from: d */
    final View f1984d;

    /* renamed from: e */
    private Runnable f1985e;

    /* renamed from: f */
    private float[] f1986f = {0.0f, 0.0f};

    /* renamed from: g */
    private float[] f1987g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: h */
    private int f1988h;

    /* renamed from: i */
    private int f1989i;

    /* renamed from: j */
    private float[] f1990j = {0.0f, 0.0f};

    /* renamed from: k */
    private float[] f1991k = {0.0f, 0.0f};

    /* renamed from: l */
    private float[] f1992l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: m */
    private boolean f1993m;

    /* renamed from: n */
    boolean f1994n;

    /* renamed from: o */
    boolean f1995o;

    /* renamed from: p */
    boolean f1996p;

    /* renamed from: q */
    private boolean f1997q;

    /* renamed from: r */
    private boolean f1998r;

    /* renamed from: android.support.v4.widget.a$a */
    /* compiled from: AutoScrollHelper */
    private static class C0685a {

        /* renamed from: a */
        private int f1999a;

        /* renamed from: b */
        private int f2000b;

        /* renamed from: c */
        private float f2001c;

        /* renamed from: d */
        private float f2002d;

        /* renamed from: e */
        private long f2003e = Long.MIN_VALUE;

        /* renamed from: f */
        private long f2004f = 0;

        /* renamed from: g */
        private int f2005g = 0;

        /* renamed from: h */
        private int f2006h = 0;

        /* renamed from: i */
        private long f2007i = -1;

        /* renamed from: j */
        private float f2008j;

        /* renamed from: k */
        private int f2009k;

        C0685a() {
        }

        /* renamed from: b */
        public void mo5915b(int durationMillis) {
            this.f1999a = durationMillis;
        }

        /* renamed from: a */
        public void mo5913a(int durationMillis) {
            this.f2000b = durationMillis;
        }

        /* renamed from: h */
        public void mo5921h() {
            this.f2003e = AnimationUtils.currentAnimationTimeMillis();
            this.f2007i = -1;
            this.f2004f = this.f2003e;
            this.f2008j = 0.5f;
            this.f2005g = 0;
            this.f2006h = 0;
        }

        /* renamed from: g */
        public void mo5920g() {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            this.f2009k = C0684a.m3228a((int) (currentTime - this.f2003e), 0, this.f2000b);
            this.f2008j = m3248a(currentTime);
            this.f2007i = currentTime;
        }

        /* renamed from: f */
        public boolean mo5919f() {
            return this.f2007i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2007i + ((long) this.f2009k);
        }

        /* renamed from: a */
        private float m3248a(long currentTime) {
            if (currentTime < this.f2003e) {
                return 0.0f;
            }
            long j = this.f2007i;
            if (j < 0 || currentTime < j) {
                return C0684a.m3225a(((float) (currentTime - this.f2003e)) / ((float) this.f1999a), 0.0f, 1.0f) * 0.5f;
            }
            long elapsedSinceEnd = currentTime - j;
            float f = this.f2008j;
            return (1.0f - f) + (f * C0684a.m3225a(((float) elapsedSinceEnd) / ((float) this.f2009k), 0.0f, 1.0f));
        }

        /* renamed from: a */
        private float m3247a(float value) {
            return (-4.0f * value * value) + (4.0f * value);
        }

        /* renamed from: a */
        public void mo5911a() {
            if (this.f2004f != 0) {
                long currentTime = AnimationUtils.currentAnimationTimeMillis();
                float scale = m3247a(m3248a(currentTime));
                long elapsedSinceDelta = currentTime - this.f2004f;
                this.f2004f = currentTime;
                this.f2005g = (int) (((float) elapsedSinceDelta) * scale * this.f2001c);
                this.f2006h = (int) (((float) elapsedSinceDelta) * scale * this.f2002d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        /* renamed from: a */
        public void mo5912a(float x, float y) {
            this.f2001c = x;
            this.f2002d = y;
        }

        /* renamed from: d */
        public int mo5917d() {
            float f = this.f2001c;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: e */
        public int mo5918e() {
            float f = this.f2002d;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: b */
        public int mo5914b() {
            return this.f2005g;
        }

        /* renamed from: c */
        public int mo5916c() {
            return this.f2006h;
        }
    }

    /* renamed from: android.support.v4.widget.a$b */
    /* compiled from: AutoScrollHelper */
    private class C0686b implements Runnable {
        C0686b() {
        }

        public void run() {
            C0684a aVar = C0684a.this;
            if (aVar.f1996p) {
                if (aVar.f1994n) {
                    aVar.f1994n = false;
                    aVar.f1982b.mo5921h();
                }
                C0685a scroller = C0684a.this.f1982b;
                if (scroller.mo5919f() || !C0684a.this.mo5909i()) {
                    C0684a.this.f1996p = false;
                    return;
                }
                C0684a aVar2 = C0684a.this;
                if (aVar2.f1995o) {
                    aVar2.f1995o = false;
                    aVar2.mo5908h();
                }
                scroller.mo5911a();
                C0684a.this.mo5897a(scroller.mo5914b(), scroller.mo5916c());
                C0646w.m2958a(C0684a.this.f1984d, (Runnable) this);
            }
        }
    }

    /* renamed from: a */
    public abstract void mo5897a(int i, int i2);

    /* renamed from: a */
    public abstract boolean mo5898a(int i);

    /* renamed from: b */
    public abstract boolean mo5900b(int i);

    public C0684a(View target) {
        this.f1984d = target;
        float f = Resources.getSystem().getDisplayMetrics().density;
        int maxVelocity = (int) ((1575.0f * f) + 0.5f);
        int minVelocity = (int) ((f * 315.0f) + 0.5f);
        mo5899b((float) maxVelocity, (float) maxVelocity);
        mo5901c((float) minVelocity, (float) minVelocity);
        mo5904d(1);
        mo5895a(Float.MAX_VALUE, Float.MAX_VALUE);
        mo5903d(0.2f, 0.2f);
        mo5905e(1.0f, 1.0f);
        mo5902c(f1981a);
        mo5907f(500);
        mo5906e(500);
    }

    /* renamed from: a */
    public C0684a mo5896a(boolean enabled) {
        if (this.f1997q && !enabled) {
            m3230j();
        }
        this.f1997q = enabled;
        return this;
    }

    /* renamed from: b */
    public C0684a mo5899b(float horizontalMax, float verticalMax) {
        float[] fArr = this.f1992l;
        fArr[0] = horizontalMax / 1000.0f;
        fArr[1] = verticalMax / 1000.0f;
        return this;
    }

    /* renamed from: c */
    public C0684a mo5901c(float horizontalMin, float verticalMin) {
        float[] fArr = this.f1991k;
        fArr[0] = horizontalMin / 1000.0f;
        fArr[1] = verticalMin / 1000.0f;
        return this;
    }

    /* renamed from: e */
    public C0684a mo5905e(float horizontal, float vertical) {
        float[] fArr = this.f1990j;
        fArr[0] = horizontal / 1000.0f;
        fArr[1] = vertical / 1000.0f;
        return this;
    }

    /* renamed from: d */
    public C0684a mo5904d(int type) {
        this.f1988h = type;
        return this;
    }

    /* renamed from: d */
    public C0684a mo5903d(float horizontal, float vertical) {
        float[] fArr = this.f1986f;
        fArr[0] = horizontal;
        fArr[1] = vertical;
        return this;
    }

    /* renamed from: a */
    public C0684a mo5895a(float horizontalMax, float verticalMax) {
        float[] fArr = this.f1987g;
        fArr[0] = horizontalMax;
        fArr[1] = verticalMax;
        return this;
    }

    /* renamed from: c */
    public C0684a mo5902c(int delayMillis) {
        this.f1989i = delayMillis;
        return this;
    }

    /* renamed from: f */
    public C0684a mo5907f(int durationMillis) {
        this.f1982b.mo5915b(durationMillis);
        return this;
    }

    /* renamed from: e */
    public C0684a mo5906e(int durationMillis) {
        this.f1982b.mo5913a(durationMillis);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f1997q
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r3 = 3
            if (r0 == r3) goto L_0x0016
            goto L_0x005a
        L_0x0016:
            r7.m3230j()
            goto L_0x005a
        L_0x001a:
            r7.f1995o = r2
            r7.f1993m = r1
        L_0x001e:
            float r3 = r9.getX()
            int r4 = r8.getWidth()
            float r4 = (float) r4
            android.view.View r5 = r7.f1984d
            int r5 = r5.getWidth()
            float r5 = (float) r5
            float r3 = r7.m3227a(r1, r3, r4, r5)
            float r4 = r9.getY()
            int r5 = r8.getHeight()
            float r5 = (float) r5
            android.view.View r6 = r7.f1984d
            int r6 = r6.getHeight()
            float r6 = (float) r6
            float r4 = r7.m3227a(r2, r4, r5, r6)
            android.support.v4.widget.a$a r5 = r7.f1982b
            r5.mo5912a(r3, r4)
            boolean r5 = r7.f1996p
            if (r5 != 0) goto L_0x005a
            boolean r5 = r7.mo5909i()
            if (r5 == 0) goto L_0x005a
            r7.m3231k()
        L_0x005a:
            boolean r3 = r7.f1998r
            if (r3 == 0) goto L_0x0063
            boolean r3 = r7.f1996p
            if (r3 == 0) goto L_0x0063
            r1 = 1
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.C0684a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo5909i() {
        C0685a scroller = this.f1982b;
        int verticalDirection = scroller.mo5918e();
        int horizontalDirection = scroller.mo5917d();
        return (verticalDirection != 0 && mo5900b(verticalDirection)) || (horizontalDirection != 0 && mo5898a(horizontalDirection));
    }

    /* renamed from: k */
    private void m3231k() {
        if (this.f1985e == null) {
            this.f1985e = new C0686b();
        }
        this.f1996p = true;
        this.f1994n = true;
        if (!this.f1993m) {
            int i = this.f1989i;
            if (i > 0) {
                C0646w.m2959a(this.f1984d, this.f1985e, (long) i);
                this.f1993m = true;
            }
        }
        this.f1985e.run();
        this.f1993m = true;
    }

    /* renamed from: j */
    private void m3230j() {
        if (this.f1994n) {
            this.f1996p = false;
        } else {
            this.f1982b.mo5920g();
        }
    }

    /* renamed from: a */
    private float m3227a(int direction, float coordinate, float srcSize, float dstSize) {
        float value = m3226a(this.f1986f[direction], srcSize, this.f1987g[direction], coordinate);
        if (value == 0.0f) {
            return 0.0f;
        }
        float relativeVelocity = this.f1990j[direction];
        float minimumVelocity = this.f1991k[direction];
        float maximumVelocity = this.f1992l[direction];
        float targetVelocity = relativeVelocity * dstSize;
        if (value > 0.0f) {
            return m3225a(value * targetVelocity, minimumVelocity, maximumVelocity);
        }
        return -m3225a((-value) * targetVelocity, minimumVelocity, maximumVelocity);
    }

    /* renamed from: a */
    private float m3226a(float relativeValue, float size, float maxValue, float current) {
        float interpolated;
        float edgeSize = m3225a(relativeValue * size, 0.0f, maxValue);
        float value = m3229f(size - current, edgeSize) - m3229f(current, edgeSize);
        if (value < 0.0f) {
            interpolated = -this.f1983c.getInterpolation(-value);
        } else if (value <= 0.0f) {
            return 0.0f;
        } else {
            interpolated = this.f1983c.getInterpolation(value);
        }
        return m3225a(interpolated, -1.0f, 1.0f);
    }

    /* renamed from: f */
    private float m3229f(float current, float leading) {
        if (leading == 0.0f) {
            return 0.0f;
        }
        int i = this.f1988h;
        if (i == 0 || i == 1) {
            if (current < leading) {
                if (current >= 0.0f) {
                    return 1.0f - (current / leading);
                }
                if (!this.f1996p || this.f1988h != 1) {
                    return 0.0f;
                }
                return 1.0f;
            }
        } else if (i == 2 && current < 0.0f) {
            return current / (-leading);
        }
        return 0.0f;
    }

    /* renamed from: a */
    static int m3228a(int value, int min, int max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    /* renamed from: a */
    static float m3225a(float value, float min, float max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo5908h() {
        long eventTime = SystemClock.uptimeMillis();
        MotionEvent cancel = MotionEvent.obtain(eventTime, eventTime, 3, 0.0f, 0.0f, 0);
        this.f1984d.onTouchEvent(cancel);
        cancel.recycle();
    }
}
