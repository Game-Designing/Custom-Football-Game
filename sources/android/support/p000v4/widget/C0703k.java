package android.support.p000v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.k */
/* compiled from: CursorFilter */
class C0703k extends Filter {

    /* renamed from: a */
    C0704a f2058a;

    /* renamed from: android.support.v4.widget.k$a */
    /* compiled from: CursorFilter */
    interface C0704a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    C0703k(C0704a client) {
        this.f2058a = client;
    }

    public CharSequence convertResultToString(Object resultValue) {
        return this.f2058a.convertToString((Cursor) resultValue);
    }

    /* access modifiers changed from: protected */
    public FilterResults performFiltering(CharSequence constraint) {
        Cursor cursor = this.f2058a.runQueryOnBackgroundThread(constraint);
        FilterResults results = new FilterResults();
        if (cursor != null) {
            results.count = cursor.getCount();
            results.values = cursor;
        } else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence constraint, FilterResults results) {
        Cursor oldCursor = this.f2058a.getCursor();
        Object obj = results.values;
        if (obj != null && obj != oldCursor) {
            this.f2058a.changeCursor((Cursor) obj);
        }
    }
}
