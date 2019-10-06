package android.support.design.widget;

import android.support.p000v4.view.C0646w;
import android.view.View;

/* renamed from: android.support.design.widget.ga */
/* compiled from: ViewOffsetHelper */
class C0293ga {

    /* renamed from: a */
    private final View f1097a;

    /* renamed from: b */
    private int f1098b;

    /* renamed from: c */
    private int f1099c;

    /* renamed from: d */
    private int f1100d;

    /* renamed from: e */
    private int f1101e;

    public C0293ga(View view) {
        this.f1097a = view;
    }

    /* renamed from: c */
    public void mo4664c() {
        this.f1098b = this.f1097a.getTop();
        this.f1099c = this.f1097a.getLeft();
        m1683d();
    }

    /* renamed from: d */
    private void m1683d() {
        View view = this.f1097a;
        C0646w.m2965b(view, this.f1100d - (view.getTop() - this.f1098b));
        View view2 = this.f1097a;
        C0646w.m2948a(view2, this.f1101e - (view2.getLeft() - this.f1099c));
    }

    /* renamed from: b */
    public boolean mo4663b(int offset) {
        if (this.f1100d == offset) {
            return false;
        }
        this.f1100d = offset;
        m1683d();
        return true;
    }

    /* renamed from: a */
    public boolean mo4661a(int offset) {
        if (this.f1101e == offset) {
            return false;
        }
        this.f1101e = offset;
        m1683d();
        return true;
    }

    /* renamed from: b */
    public int mo4662b() {
        return this.f1100d;
    }

    /* renamed from: a */
    public int mo4660a() {
        return this.f1098b;
    }
}
