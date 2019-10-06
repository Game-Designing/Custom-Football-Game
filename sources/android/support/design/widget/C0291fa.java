package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.C0237b;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.design.widget.fa */
/* compiled from: ViewOffsetBehavior */
class C0291fa<V extends View> extends C0237b<V> {

    /* renamed from: a */
    private C0293ga f1092a;

    /* renamed from: b */
    private int f1093b = 0;

    /* renamed from: c */
    private int f1094c = 0;

    public C0291fa() {
    }

    public C0291fa(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* renamed from: a */
    public boolean mo4226a(CoordinatorLayout parent, V child, int layoutDirection) {
        mo4537b(parent, child, layoutDirection);
        if (this.f1092a == null) {
            this.f1092a = new C0293ga(child);
        }
        this.f1092a.mo4664c();
        int i = this.f1093b;
        if (i != 0) {
            this.f1092a.mo4663b(i);
            this.f1093b = 0;
        }
        int i2 = this.f1094c;
        if (i2 != 0) {
            this.f1092a.mo4661a(i2);
            this.f1094c = 0;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4537b(CoordinatorLayout parent, V child, int layoutDirection) {
        parent.mo4375c((View) child, layoutDirection);
    }

    /* renamed from: a */
    public boolean mo4221a(int offset) {
        C0293ga gaVar = this.f1092a;
        if (gaVar != null) {
            return gaVar.mo4663b(offset);
        }
        this.f1093b = offset;
        return false;
    }

    /* renamed from: b */
    public int mo4229b() {
        C0293ga gaVar = this.f1092a;
        if (gaVar != null) {
            return gaVar.mo4662b();
        }
        return 0;
    }
}
