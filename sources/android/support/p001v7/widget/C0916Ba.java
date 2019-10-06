package android.support.p001v7.widget;

import android.graphics.Rect;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.view.View;

/* renamed from: android.support.v7.widget.Ba */
/* compiled from: OrientationHelper */
public abstract class C0916Ba {

    /* renamed from: a */
    protected final C0981i f2921a;

    /* renamed from: b */
    private int f2922b;

    /* renamed from: c */
    final Rect f2923c;

    /* renamed from: a */
    public abstract int mo6966a();

    /* renamed from: a */
    public abstract int mo6967a(View view);

    /* renamed from: a */
    public abstract void mo6968a(int i);

    /* renamed from: b */
    public abstract int mo6969b();

    /* renamed from: b */
    public abstract int mo6970b(View view);

    /* renamed from: c */
    public abstract int mo6971c();

    /* renamed from: c */
    public abstract int mo6972c(View view);

    /* renamed from: d */
    public abstract int mo6973d();

    /* renamed from: d */
    public abstract int mo6974d(View view);

    /* renamed from: e */
    public abstract int mo6975e();

    /* renamed from: e */
    public abstract int mo6976e(View view);

    /* renamed from: f */
    public abstract int mo6977f();

    /* renamed from: f */
    public abstract int mo6978f(View view);

    /* renamed from: g */
    public abstract int mo6979g();

    /* synthetic */ C0916Ba(C0981i x0, C1139za x1) {
        this(x0);
    }

    private C0916Ba(C0981i layoutManager) {
        this.f2922b = LinearLayoutManager.INVALID_OFFSET;
        this.f2923c = new Rect();
        this.f2921a = layoutManager;
    }

    /* renamed from: i */
    public void mo7143i() {
        this.f2922b = mo6979g();
    }

    /* renamed from: h */
    public int mo7142h() {
        if (Integer.MIN_VALUE == this.f2922b) {
            return 0;
        }
        return mo6979g() - this.f2922b;
    }

    /* renamed from: a */
    public static C0916Ba m4403a(C0981i layoutManager, int orientation) {
        if (orientation == 0) {
            return m4402a(layoutManager);
        }
        if (orientation == 1) {
            return m4404b(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    /* renamed from: a */
    public static C0916Ba m4402a(C0981i layoutManager) {
        return new C1139za(layoutManager);
    }

    /* renamed from: b */
    public static C0916Ba m4404b(C0981i layoutManager) {
        return new C0900Aa(layoutManager);
    }
}
