package android.support.p001v7.app;

import android.view.View;

/* renamed from: android.support.v7.app.f */
/* compiled from: AlertController */
class C0767f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f2317a;

    /* renamed from: b */
    final /* synthetic */ View f2318b;

    /* renamed from: c */
    final /* synthetic */ AlertController f2319c;

    C0767f(AlertController this$0, View view, View view2) {
        this.f2319c = this$0;
        this.f2317a = view;
        this.f2318b = view2;
    }

    public void run() {
        AlertController.m3366a(this.f2319c.f2082A, this.f2317a, this.f2318b);
    }
}
