package com.adyen.p081ui.p083b;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.C5632e;
import com.adyen.p081ui.activities.CheckoutActivity;
import com.adyen.p081ui.p082a.C5577d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.p140a.C6881c;
import p019d.p135a.p136a.p139c.p140a.C6881c.C6882a;

/* renamed from: com.adyen.ui.b.l */
/* compiled from: IssuerSelectionFragment */
public class C5608l extends Fragment {

    /* renamed from: a */
    private static final String f9484a = C5608l.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C5609a f9485b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<C6882a> f9486c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private C6889d f9487d;

    /* renamed from: e */
    private int f9488e;

    /* renamed from: com.adyen.ui.b.l$a */
    /* compiled from: IssuerSelectionFragment */
    public interface C5609a {
        /* renamed from: a */
        void mo17723a(String str);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.f9487d = (C6889d) args.get("PaymentMethod");
        this.f9488e = args.getInt("theme");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(f9484a, "onCreateView()");
        View fragmentView = inflater.cloneInContext(new ContextThemeWrapper(getActivity(), this.f9488e)).inflate(C5631d.issuer_selection_fragment, container, false);
        Iterator it = this.f9487d.mo22327b().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C6881c inputDetail = (C6881c) it.next();
            if (inputDetail.mo22311d().equals("idealIssuer")) {
                this.f9486c = inputDetail.mo22310c();
                break;
            }
        }
        ListView listView = (ListView) fragmentView.findViewById(C5626c.issuer_methods_list);
        listView.setAdapter(new C5577d(getActivity(), this.f9486c));
        listView.setOnItemClickListener(new C5607k(this));
        if (getActivity() instanceof CheckoutActivity) {
            ((CheckoutActivity) getActivity()).mo17713a(C5632e.title_issuers);
        }
        return fragmentView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17760a(C5609a listener) {
        this.f9485b = listener;
    }
}
