package android.support.p000v4.view;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.q */
/* compiled from: NestedScrollingParentHelper */
public class C0640q {

    /* renamed from: a */
    private final ViewGroup f1858a;

    /* renamed from: b */
    private int f1859b;

    public C0640q(ViewGroup viewGroup) {
        this.f1858a = viewGroup;
    }

    /* renamed from: a */
    public void mo5686a(View child, View target, int axes) {
        mo5687a(child, target, axes, 0);
    }

    /* renamed from: a */
    public void mo5687a(View child, View target, int axes, int type) {
        this.f1859b = axes;
    }

    /* renamed from: a */
    public int mo5683a() {
        return this.f1859b;
    }

    /* renamed from: a */
    public void mo5684a(View target) {
        mo5685a(target, 0);
    }

    /* renamed from: a */
    public void mo5685a(View target, int type) {
        this.f1859b = 0;
    }
}
