package android.support.p001v7.app;

import android.support.p001v7.app.AlertController.C0730a;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: android.support.v7.app.k */
/* compiled from: AlertController */
class C0772k implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertController f2333a;

    /* renamed from: b */
    final /* synthetic */ C0730a f2334b;

    C0772k(C0730a this$0, AlertController alertController) {
        this.f2334b = this$0;
        this.f2333a = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        this.f2334b.f2168x.onClick(this.f2333a.f2102b, position);
        if (!this.f2334b.f2136H) {
            this.f2333a.f2102b.dismiss();
        }
    }
}
