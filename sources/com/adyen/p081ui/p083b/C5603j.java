package com.adyen.p081ui.p083b;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.adyen.p081ui.C5591b;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.C5632e;
import com.adyen.p081ui.activities.CheckoutActivity;
import com.adyen.p081ui.views.GiroPayEditText;
import com.adyen.ui.fragments.GiropayFragment.GiroPayIssuer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002b.p003c.p062h.p064b.p065a.C1282b;
import p019d.p135a.p136a.p138b.C6856a;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p142e.C6901a;
import p019d.p135a.p136a.p142e.C6912j;

/* renamed from: com.adyen.ui.b.j */
/* compiled from: GiropayFragment */
public final class C5603j extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C5604a f9466a;

    /* renamed from: b */
    private ListView f9467b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f9468c;

    /* renamed from: d */
    private GiroPayEditText f9469d;

    /* renamed from: e */
    private Button f9470e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f9471f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C5606c f9472g = null;

    /* renamed from: h */
    private C6878a f9473h;

    /* renamed from: i */
    private TextWatcher f9474i = new C5601h(this);

    /* renamed from: com.adyen.ui.b.j$a */
    /* compiled from: GiropayFragment */
    private final class C5604a extends BaseAdapter {

        /* renamed from: a */
        private String f9475a;

        /* renamed from: b */
        private ArrayList<C5605b> f9476b;

        /* renamed from: c */
        private ArrayList<C5605b> f9477c;

        /* renamed from: d */
        private LayoutInflater f9478d;

        /* synthetic */ C5604a(C5603j x0, Context x1, C5600g x2) {
            this(x1);
        }

        private C5604a(Context context) {
            this.f9475a = "";
            this.f9476b = new ArrayList<>();
            this.f9477c = new ArrayList<>();
            this.f9478d = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public int getCount() {
            return this.f9477c.size();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public int m9884b() {
            return this.f9476b.size();
        }

        public Object getItem(int position) {
            return this.f9477c.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = this.f9478d.inflate(C5631d.giropay_list_item, parent, false);
            C5605b current = (C5605b) this.f9477c.get(position);
            String bankName = current.m9886a();
            TextView nameTextView = (TextView) view.findViewById(C5626c.name_giropay_issuer);
            int startIndex = bankName.toLowerCase().indexOf(this.f9475a.toLowerCase());
            if (startIndex != -1) {
                int endIndex = this.f9475a.length() + startIndex;
                SpannableStringBuilder ssb = new SpannableStringBuilder(bankName);
                ssb.setSpan(new StyleSpan(1), startIndex, endIndex, 33);
                nameTextView.setText(ssb);
            } else {
                nameTextView.setText(bankName);
            }
            nameTextView.setOnClickListener(new C5602i(this, current));
            return view;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m9883a(JSONArray issuersJson, String searchStr) throws JSONException {
            m9878a();
            for (int i = 0; i < issuersJson.length(); i++) {
                this.f9476b.add(new C5605b(issuersJson.getJSONObject(i), null));
            }
            m9882a(searchStr);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m9878a() {
            this.f9476b.clear();
            this.f9477c.clear();
            this.f9475a = "";
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m9882a(String newSearchStr) {
            ArrayList<C5605b> arrayList;
            if (this.f9477c.isEmpty() || this.f9475a.length() > newSearchStr.length()) {
                arrayList = this.f9476b;
            } else {
                arrayList = this.f9477c;
            }
            ArrayList<GiroPayIssuer> results = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C5605b issuer = (C5605b) it.next();
                if (issuer.m9886a().contains(newSearchStr)) {
                    results.add(issuer);
                }
            }
            this.f9475a = newSearchStr;
            this.f9477c = results;
        }
    }

    /* renamed from: com.adyen.ui.b.j$b */
    /* compiled from: GiropayFragment */
    private static final class C5605b {

        /* renamed from: a */
        private String f9480a;

        /* synthetic */ C5605b(JSONObject x0, C5600g x1) throws JSONException {
            this(x0);
        }

        private C5605b(JSONObject jsonObject) throws JSONException {
            this.f9480a = jsonObject.getString("bankName");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m9886a() {
            return this.f9480a;
        }
    }

    /* renamed from: com.adyen.ui.b.j$c */
    /* compiled from: GiropayFragment */
    private final class C5606c extends AsyncTask<Void, Void, String> {

        /* renamed from: a */
        private String f9481a;

        /* synthetic */ C5606c(C5603j x0, String x1, C5600g x2) {
            this(x1);
        }

        private C5606c(String searchString) {
            this.f9481a = "";
            this.f9481a = searchString;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (C5603j.this.f9466a.m9884b() == 0) {
                C5603j.this.f9468c.setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... params) {
            try {
                C6856a aVar = new C6856a();
                StringBuilder sb = new StringBuilder();
                sb.append("https://live.adyen.com/hpp/getGiroPayBankList.shtml?searchStr=");
                sb.append(this.f9481a.substring(0, 3));
                return new String(aVar.mo22287a(sb.toString(), null), Charset.forName("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String response) {
            if (C5603j.this.f9468c.getVisibility() == 0) {
                C5603j.this.f9468c.setVisibility(8);
            }
            try {
                C5603j.this.f9466a.m9883a(new JSONArray(response), this.f9481a.substring(0, 3));
                C5603j.this.f9466a.m9882a(this.f9481a);
                C5603j.this.f9466a.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            if (C5603j.this.f9468c.getVisibility() == 0) {
                C5603j.this.f9468c.setVisibility(8);
            }
        }
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.f9473h = (C6878a) args.get("amount");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(C5631d.giropay_fragment, container, false);
        getActivity().getWindow().setSoftInputMode(32);
        this.f9466a = new C5604a(this, getActivity(), null);
        this.f9467b = (ListView) fragmentView.findViewById(C5626c.giropay_list_view);
        this.f9467b.setAdapter(this.f9466a);
        this.f9469d = (GiroPayEditText) fragmentView.findViewById(C5626c.adyen_giropay_lookup_edit_text);
        this.f9469d.addTextChangedListener(this.f9474i);
        TextView amountTextView = (TextView) fragmentView.findViewById(C5626c.amount_text_view);
        String amountLocalized = C6901a.m14038a(this.f9473h, true, C6912j.m14059a((Context) getActivity()));
        amountTextView.setText(getString(C5632e.pay_with_amount, amountLocalized));
        this.f9468c = fragmentView.findViewById(C5626c.loading_icon_view);
        this.f9470e = (Button) fragmentView.findViewById(C5626c.pay_giropay_button);
        this.f9471f = fragmentView.findViewById(C5626c.giropay_example_layout);
        if (getActivity() instanceof CheckoutActivity) {
            ((CheckoutActivity) getActivity()).mo17713a(C5632e.title_giropay);
        }
        return fragmentView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.f9469d.requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.f9469d, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9871a(C5605b bank) {
        this.f9469d.removeTextChangedListener(this.f9474i);
        this.f9469d.setText(bank.m9886a());
        this.f9469d.setTextSize(2, 12.0f);
        this.f9469d.setSingleLine(false);
        this.f9469d.clearFocus();
        this.f9469d.setEnabled(false);
        this.f9469d.mo17808a(C1282b.m6000b(getContext(), C5591b.clear_icon), new C5600g(this));
        this.f9466a.m9878a();
        this.f9466a.notifyDataSetChanged();
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f9469d.getWindowToken(), 2);
        this.f9470e.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9873b() {
        this.f9469d.setEnabled(true);
        this.f9469d.setText("");
        this.f9469d.setTextSize(2, 18.0f);
        this.f9469d.setSingleLine(true);
        this.f9469d.addTextChangedListener(this.f9474i);
        this.f9469d.requestFocus();
        this.f9469d.setCompoundDrawables(null, null, null, null);
        this.f9470e.setEnabled(false);
        this.f9471f.setVisibility(0);
    }
}
