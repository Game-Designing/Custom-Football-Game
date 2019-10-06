package com.adyen.p081ui.p082a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import p019d.p135a.p136a.p139c.p140a.C6881c.C6882a;

/* renamed from: com.adyen.ui.a.b */
/* compiled from: InstallmentOptionsAdapter */
public class C5574b extends ArrayAdapter<C6882a> {

    /* renamed from: a */
    private final Activity f9381a;

    /* renamed from: b */
    private final List<C6882a> f9382b;

    /* renamed from: com.adyen.ui.a.b$a */
    /* compiled from: InstallmentOptionsAdapter */
    private static class C5575a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public TextView f9383a;

        private C5575a() {
        }
    }

    public C5574b(Activity context, List<C6882a> installmentOptions) {
        super(context, 17367043, installmentOptions);
        this.f9381a = context;
        this.f9382b = installmentOptions;
    }

    public C6882a getItem(int position) {
        return (C6882a) this.f9382b.get(position);
    }

    public View getView(int position, View view, ViewGroup parent) {
        C5575a viewHolder;
        if (view == null) {
            viewHolder = new C5575a();
            view = ((LayoutInflater) this.f9381a.getSystemService("layout_inflater")).inflate(17367043, parent, false);
            viewHolder.f9383a = (TextView) view.findViewById(16908308);
            view.setTag(viewHolder);
        } else {
            viewHolder = (C5575a) view.getTag();
        }
        if (!(viewHolder == null || viewHolder.f9383a == null)) {
            viewHolder.f9383a.setText(((C6882a) this.f9382b.get(position)).mo22317c());
        }
        return view;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
