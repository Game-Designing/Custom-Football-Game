package android.support.p000v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.s */
/* compiled from: ResourceCursorAdapter */
public abstract class C0721s extends C0700j {

    /* renamed from: a */
    private int f2070a;

    /* renamed from: b */
    private int f2071b;

    /* renamed from: c */
    private LayoutInflater f2072c;

    @Deprecated
    public C0721s(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.f2071b = layout;
        this.f2070a = layout;
        this.f2072c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return this.f2072c.inflate(this.f2070a, parent, false);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        return this.f2072c.inflate(this.f2071b, parent, false);
    }
}
