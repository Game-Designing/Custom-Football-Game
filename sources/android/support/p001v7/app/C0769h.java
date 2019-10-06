package android.support.p001v7.app;

import android.view.View;

/* renamed from: android.support.v7.app.h */
/* compiled from: AlertController */
class C0769h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f2323a;

    /* renamed from: b */
    final /* synthetic */ View f2324b;

    /* renamed from: c */
    final /* synthetic */ AlertController f2325c;

    C0769h(AlertController this$0, View view, View view2) {
        this.f2325c = this$0;
        this.f2323a = view;
        this.f2324b = view2;
    }

    public void run() {
        AlertController.m3366a(this.f2325c.f2107g, this.f2323a, this.f2324b);
    }
}
