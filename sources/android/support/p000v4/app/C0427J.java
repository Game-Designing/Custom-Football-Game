package android.support.p000v4.app;

import android.graphics.Rect;
import android.view.View;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: android.support.v4.app.J */
/* compiled from: FragmentTransition */
class C0427J implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Fragment f1431a;

    /* renamed from: b */
    final /* synthetic */ Fragment f1432b;

    /* renamed from: c */
    final /* synthetic */ boolean f1433c;

    /* renamed from: d */
    final /* synthetic */ C1253b f1434d;

    /* renamed from: e */
    final /* synthetic */ View f1435e;

    /* renamed from: f */
    final /* synthetic */ C0441V f1436f;

    /* renamed from: g */
    final /* synthetic */ Rect f1437g;

    C0427J(Fragment fragment, Fragment fragment2, boolean z, C1253b bVar, View view, C0441V v, Rect rect) {
        this.f1431a = fragment;
        this.f1432b = fragment2;
        this.f1433c = z;
        this.f1434d = bVar;
        this.f1435e = view;
        this.f1436f = v;
        this.f1437g = rect;
    }

    public void run() {
        C0429L.m2215b(this.f1431a, this.f1432b, this.f1433c, this.f1434d, false);
        View view = this.f1435e;
        if (view != null) {
            this.f1436f.mo5085a(view, this.f1437g);
        }
    }
}
