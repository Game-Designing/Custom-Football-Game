package com.adyen.p081ui.p082a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.p084c.C5630c;
import java.util.List;
import p019d.p135a.p136a.p139c.p140a.C6881c.C6882a;
import p019d.p135a.p136a.p142e.C6907g;

/* renamed from: com.adyen.ui.a.d */
/* compiled from: IssuerListAdapter */
public class C5577d extends ArrayAdapter<C6882a> {

    /* renamed from: a */
    private static final String f9386a = C5577d.class.getSimpleName();

    /* renamed from: b */
    private final Activity f9387b;

    /* renamed from: c */
    private final List<C6882a> f9388c;

    /* renamed from: com.adyen.ui.a.d$a */
    /* compiled from: IssuerListAdapter */
    private static class C5578a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public TextView f9389a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public ImageView f9390b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f9391c;

        private C5578a() {
        }

        /* synthetic */ C5578a(C5576c x0) {
            this();
        }
    }

    public C5577d(Activity context, List<C6882a> issuers) {
        super(context, C5631d.payment_method_list, issuers);
        Log.d(f9386a, "IssuerListAdapter()");
        this.f9387b = context;
        this.f9388c = issuers;
    }

    public C6882a getItem(int position) {
        return (C6882a) this.f9388c.get(position);
    }

    public View getView(int position, View view, ViewGroup parent) {
        C5578a viewHolder;
        if (view == null) {
            viewHolder = new C5578a(null);
            view = ((LayoutInflater) this.f9387b.getSystemService("layout_inflater")).inflate(C5631d.payment_method_list, parent, false);
            viewHolder.f9389a = (TextView) view.findViewById(C5626c.paymentMethodName);
            viewHolder.f9390b = (ImageView) view.findViewById(C5626c.paymentMethodLogo);
            view.setTag(viewHolder);
        } else {
            viewHolder = (C5578a) view.getTag();
        }
        if (!(viewHolder == null || viewHolder.f9389a == null || viewHolder.f9390b == null)) {
            viewHolder.f9389a.setText(((C6882a) this.f9388c.get(position)).mo22317c());
            String modifiedUrl = C5630c.m9930a((Context) this.f9387b, ((C6882a) this.f9388c.get(position)).mo22316b());
            viewHolder.f9391c = modifiedUrl;
            C6907g.m14048a(getContext(), new C5576c(this, viewHolder), modifiedUrl, null);
        }
        return view;
    }
}
