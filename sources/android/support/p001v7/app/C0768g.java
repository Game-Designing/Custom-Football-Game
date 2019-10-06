package android.support.p001v7.app;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* renamed from: android.support.v7.app.g */
/* compiled from: AlertController */
class C0768g implements OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ View f2320a;

    /* renamed from: b */
    final /* synthetic */ View f2321b;

    /* renamed from: c */
    final /* synthetic */ AlertController f2322c;

    C0768g(AlertController this$0, View view, View view2) {
        this.f2322c = this$0;
        this.f2320a = view;
        this.f2321b = view2;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    public void onScroll(AbsListView v, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        AlertController.m3366a(v, this.f2320a, this.f2321b);
    }
}
