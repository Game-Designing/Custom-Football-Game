package android.support.p001v7.app;

import android.support.p001v7.app.AlertController.C0730a;
import android.support.p001v7.app.AlertController.RecycleListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: android.support.v7.app.l */
/* compiled from: AlertController */
class C0773l implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ RecycleListView f2335a;

    /* renamed from: b */
    final /* synthetic */ AlertController f2336b;

    /* renamed from: c */
    final /* synthetic */ C0730a f2337c;

    C0773l(C0730a this$0, RecycleListView recycleListView, AlertController alertController) {
        this.f2337c = this$0;
        this.f2335a = recycleListView;
        this.f2336b = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        boolean[] zArr = this.f2337c.f2134F;
        if (zArr != null) {
            zArr[position] = this.f2335a.isItemChecked(position);
        }
        this.f2337c.f2138J.onClick(this.f2336b.f2102b, position, this.f2335a.isItemChecked(position));
    }
}
