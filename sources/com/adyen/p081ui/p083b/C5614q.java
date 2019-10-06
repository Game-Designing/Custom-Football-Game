package com.adyen.p081ui.p083b;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.C5632e;
import com.adyen.p081ui.activities.CheckoutActivity;
import com.adyen.p081ui.p082a.C5580f;
import java.util.ArrayList;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: com.adyen.ui.b.q */
/* compiled from: PaymentMethodSelectionFragment */
public class C5614q extends Fragment {

    /* renamed from: a */
    private static final String f9496a = C5614q.class.getSimpleName();

    /* renamed from: b */
    private C5617c f9497b;

    /* renamed from: c */
    private ArrayList<C6889d> f9498c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<C6889d> f9499d = new ArrayList<>();

    /* renamed from: e */
    private View f9500e;

    /* renamed from: f */
    private int f9501f;

    /* renamed from: com.adyen.ui.b.q$a */
    /* compiled from: PaymentMethodSelectionFragment */
    public class C5615a implements OnItemClickListener {
        public C5615a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            C5614q.this.m9898a(position, false);
        }
    }

    /* renamed from: com.adyen.ui.b.q$b */
    /* compiled from: PaymentMethodSelectionFragment */
    public class C5616b implements OnItemClickListener {
        public C5616b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            C5614q.this.m9898a(position, true);
        }
    }

    /* renamed from: com.adyen.ui.b.q$c */
    /* compiled from: PaymentMethodSelectionFragment */
    public interface C5617c {
        /* renamed from: a */
        void mo17721a(C6889d dVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17766a(C5617c listener) {
        this.f9497b = listener;
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.f9501f = args.getInt("theme");
        this.f9498c = (ArrayList) args.getSerializable("filteredPaymentMethods");
        String str = "preferredPaymentMethods";
        if (args.getSerializable(str) != null) {
            this.f9499d = (ArrayList) args.getSerializable(str);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(f9496a, "onCreateView()");
        View fragmentView = inflater.cloneInContext(new ContextThemeWrapper(getActivity(), this.f9501f)).inflate(C5631d.payment_method_selection_fragment, container, false);
        ListView listView = (ListView) fragmentView.findViewById(16908298);
        listView.setAdapter(new C5580f(getActivity(), this.f9498c));
        ListView preferredListView = (ListView) fragmentView.findViewById(C5626c.preferred_payment_methods_list);
        preferredListView.setAdapter(new C5580f(getActivity(), this.f9499d));
        listView.setOnItemClickListener(new C5615a());
        preferredListView.setOnItemClickListener(new C5616b());
        listView.getViewTreeObserver().addOnGlobalLayoutListener(new C5612o(this, listView));
        preferredListView.getViewTreeObserver().addOnGlobalLayoutListener(new C5613p(this, preferredListView));
        this.f9500e = fragmentView.findViewById(C5626c.preferred_payment_methods_layout);
        if (this.f9499d.isEmpty()) {
            this.f9500e.setVisibility(8);
        } else {
            this.f9500e.setVisibility(0);
        }
        if (getActivity() instanceof CheckoutActivity) {
            ((CheckoutActivity) getActivity()).mo17713a(C5632e.title_payment_methods);
        }
        return fragmentView;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9899a(ListView listView, boolean isBottomList) {
        int count = listView.getAdapter().getCount();
        View oneChild = listView.getChildAt(0);
        if (oneChild != null) {
            int itemsHeight = oneChild.getHeight();
            LayoutParams params = (LayoutParams) listView.getLayoutParams();
            params.height = isBottomList ? (itemsHeight * count) + (itemsHeight / 2) : itemsHeight * count;
            listView.setLayoutParams(params);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9898a(int item, boolean isPreferredPaymentMethod) {
        this.f9497b.mo17721a((C6889d) (isPreferredPaymentMethod ? this.f9499d : this.f9498c).get(item));
    }
}
