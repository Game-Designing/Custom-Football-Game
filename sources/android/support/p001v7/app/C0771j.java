package android.support.p001v7.app;

import android.content.Context;
import android.database.Cursor;
import android.support.p001v7.app.AlertController.C0730a;
import android.support.p001v7.app.AlertController.RecycleListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;

/* renamed from: android.support.v7.app.j */
/* compiled from: AlertController */
class C0771j extends CursorAdapter {

    /* renamed from: a */
    private final int f2328a;

    /* renamed from: b */
    private final int f2329b;

    /* renamed from: c */
    final /* synthetic */ RecycleListView f2330c;

    /* renamed from: d */
    final /* synthetic */ AlertController f2331d;

    /* renamed from: e */
    final /* synthetic */ C0730a f2332e;

    C0771j(C0730a this$0, Context x0, Cursor x1, boolean x2, RecycleListView recycleListView, AlertController alertController) {
        this.f2332e = this$0;
        this.f2330c = recycleListView;
        this.f2331d = alertController;
        super(x0, x1, x2);
        Cursor cursor = getCursor();
        this.f2328a = cursor.getColumnIndexOrThrow(this.f2332e.f2140L);
        this.f2329b = cursor.getColumnIndexOrThrow(this.f2332e.f2141M);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f2328a));
        RecycleListView recycleListView = this.f2330c;
        int position = cursor.getPosition();
        boolean z = true;
        if (cursor.getInt(this.f2329b) != 1) {
            z = false;
        }
        recycleListView.setItemChecked(position, z);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return this.f2332e.f2146b.inflate(this.f2331d.f2094M, parent, false);
    }
}
