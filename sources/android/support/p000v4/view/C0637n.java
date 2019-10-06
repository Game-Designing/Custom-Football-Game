package android.support.p000v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.n */
/* compiled from: NestedScrollingChildHelper */
public class C0637n {

    /* renamed from: a */
    private ViewParent f1853a;

    /* renamed from: b */
    private ViewParent f1854b;

    /* renamed from: c */
    private final View f1855c;

    /* renamed from: d */
    private boolean f1856d;

    /* renamed from: e */
    private int[] f1857e;

    public C0637n(View view) {
        this.f1855c = view;
    }

    /* renamed from: a */
    public void mo5669a(boolean enabled) {
        if (this.f1856d) {
            C0646w.m2992z(this.f1855c);
        }
        this.f1856d = enabled;
    }

    /* renamed from: b */
    public boolean mo5679b() {
        return this.f1856d;
    }

    /* renamed from: a */
    public boolean mo5670a() {
        return mo5673a(0);
    }

    /* renamed from: a */
    public boolean mo5673a(int type) {
        return m2917d(type) != null;
    }

    /* renamed from: b */
    public boolean mo5680b(int axes) {
        return mo5674a(axes, 0);
    }

    /* renamed from: a */
    public boolean mo5674a(int axes, int type) {
        if (mo5673a(type)) {
            return true;
        }
        if (mo5679b()) {
            View child = this.f1855c;
            for (ViewParent p = this.f1855c.getParent(); p != null; p = p.getParent()) {
                if (C0581F.m2765b(p, child, this.f1855c, axes, type)) {
                    m2916a(type, p);
                    C0581F.m2762a(p, child, this.f1855c, axes, type);
                    return true;
                }
                if (p instanceof View) {
                    child = (View) p;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void mo5681c() {
        mo5682c(0);
    }

    /* renamed from: c */
    public void mo5682c(int type) {
        ViewParent parent = m2917d(type);
        if (parent != null) {
            C0581F.m2759a(parent, this.f1855c, type);
            m2916a(type, (ViewParent) null);
        }
    }

    /* renamed from: a */
    public boolean mo5675a(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return mo5676a(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, 0);
    }

    /* renamed from: a */
    public boolean mo5676a(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        int startY;
        int startX;
        int[] iArr = offsetInWindow;
        if (mo5679b()) {
            ViewParent parent = m2917d(type);
            if (parent == null) {
                return false;
            }
            if (dxConsumed != 0 || dyConsumed != 0 || dxUnconsumed != 0 || dyUnconsumed != 0) {
                if (iArr != null) {
                    this.f1855c.getLocationInWindow(iArr);
                    startX = iArr[0];
                    startY = iArr[1];
                } else {
                    startX = 0;
                    startY = 0;
                }
                C0581F.m2760a(parent, this.f1855c, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
                if (iArr != null) {
                    this.f1855c.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - startX;
                    iArr[1] = iArr[1] - startY;
                }
                return true;
            } else if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        } else {
            int i = type;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5677a(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return mo5678a(dx, dy, consumed, offsetInWindow, 0);
    }

    /* renamed from: a */
    public boolean mo5678a(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        int startY;
        int startX;
        int[] consumed2;
        int[] iArr = offsetInWindow;
        if (mo5679b()) {
            ViewParent parent = m2917d(type);
            if (parent == null) {
                return false;
            }
            boolean z = true;
            if (dx != 0 || dy != 0) {
                if (iArr != null) {
                    this.f1855c.getLocationInWindow(iArr);
                    startX = iArr[0];
                    startY = iArr[1];
                } else {
                    startX = 0;
                    startY = 0;
                }
                if (consumed == null) {
                    if (this.f1857e == null) {
                        this.f1857e = new int[2];
                    }
                    consumed2 = this.f1857e;
                } else {
                    consumed2 = consumed;
                }
                consumed2[0] = 0;
                consumed2[1] = 0;
                C0581F.m2761a(parent, this.f1855c, dx, dy, consumed2, type);
                if (iArr != null) {
                    this.f1855c.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - startX;
                    iArr[1] = iArr[1] - startY;
                }
                if (consumed2[0] == 0 && consumed2[1] == 0) {
                    z = false;
                }
                return z;
            } else if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        } else {
            int i = type;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5672a(float velocityX, float velocityY, boolean consumed) {
        if (mo5679b()) {
            ViewParent parent = m2917d(0);
            if (parent != null) {
                return C0581F.m2764a(parent, this.f1855c, velocityX, velocityY, consumed);
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5671a(float velocityX, float velocityY) {
        if (mo5679b()) {
            ViewParent parent = m2917d(0);
            if (parent != null) {
                return C0581F.m2763a(parent, this.f1855c, velocityX, velocityY);
            }
        }
        return false;
    }

    /* renamed from: d */
    private ViewParent m2917d(int type) {
        if (type == 0) {
            return this.f1853a;
        }
        if (type != 1) {
            return null;
        }
        return this.f1854b;
    }

    /* renamed from: a */
    private void m2916a(int type, ViewParent p) {
        if (type == 0) {
            this.f1853a = p;
        } else if (type == 1) {
            this.f1854b = p;
        }
    }
}
