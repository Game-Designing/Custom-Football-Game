package android.support.p001v7.app;

import android.content.Context;
import android.support.p001v7.app.AlertController.C0730a;
import android.support.p001v7.app.AlertController.RecycleListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/* renamed from: android.support.v7.app.i */
/* compiled from: AlertController */
class C0770i extends ArrayAdapter<CharSequence> {

    /* renamed from: a */
    final /* synthetic */ RecycleListView f2326a;

    /* renamed from: b */
    final /* synthetic */ C0730a f2327b;

    C0770i(C0730a this$0, Context x0, int x1, int x2, CharSequence[] x3, RecycleListView recycleListView) {
        this.f2327b = this$0;
        this.f2326a = recycleListView;
        super(x0, x1, x2, x3);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        boolean[] zArr = this.f2327b.f2134F;
        if (zArr != null && zArr[position]) {
            this.f2326a.setItemChecked(position, true);
        }
        return view;
    }
}
