package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.M */
/* compiled from: WindowInsetsCompat */
public class C0592M {

    /* renamed from: a */
    private final Object f1809a;

    private C0592M(Object insets) {
        this.f1809a = insets;
    }

    /* renamed from: c */
    public int mo5487c() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1809a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* renamed from: e */
    public int mo5489e() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1809a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* renamed from: d */
    public int mo5488d() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1809a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* renamed from: b */
    public int mo5486b() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1809a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    /* renamed from: f */
    public boolean mo5491f() {
        if (VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1809a).isConsumed();
        }
        return false;
    }

    /* renamed from: a */
    public C0592M mo5484a() {
        if (VERSION.SDK_INT >= 20) {
            return new C0592M(((WindowInsets) this.f1809a).consumeSystemWindowInsets());
        }
        return null;
    }

    /* renamed from: a */
    public C0592M mo5485a(int left, int top, int right, int bottom) {
        if (VERSION.SDK_INT >= 20) {
            return new C0592M(((WindowInsets) this.f1809a).replaceSystemWindowInsets(left, top, right, bottom));
        }
        return null;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C0592M other = (C0592M) o;
        Object obj = this.f1809a;
        if (obj != null) {
            z = obj.equals(other.f1809a);
        } else if (other.f1809a != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Object obj = this.f1809a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: a */
    static C0592M m2792a(Object insets) {
        if (insets == null) {
            return null;
        }
        return new C0592M(insets);
    }

    /* renamed from: a */
    static Object m2793a(C0592M insets) {
        if (insets == null) {
            return null;
        }
        return insets.f1809a;
    }
}
