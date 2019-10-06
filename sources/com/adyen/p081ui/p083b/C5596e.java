package com.adyen.p081ui.p083b;

import adyen.com.adyencse.encrypter.exception.EncrypterException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.adyen.cardscan.PaymentCardScanner;
import com.adyen.cardscan.PaymentCardScanner.Listener;
import com.adyen.cardscan.PaymentCardScannerFactory;
import com.adyen.cardscan.PaymentCardScannerFactory.Loader;
import com.adyen.core.models.PaymentMethod;
import com.adyen.core.models.paymentdetails.InputDetail;
import com.adyen.core.models.paymentdetails.InputDetail.Item;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.C5632e;
import com.adyen.p081ui.activities.CheckoutActivity;
import com.adyen.p081ui.p082a.C5574b;
import com.adyen.p081ui.p083b.C5598f.C5599a;
import com.adyen.p081ui.p084c.C5628b;
import com.adyen.p081ui.p084c.C5628b.C5629a;
import com.adyen.p081ui.views.CVCEditText;
import com.adyen.p081ui.views.CardHolderEditText;
import com.adyen.p081ui.views.CheckoutCheckBox;
import com.adyen.p081ui.views.CreditCardEditText;
import com.adyen.p081ui.views.CreditCardEditText.C5635a;
import com.adyen.p081ui.views.ExpiryDateEditText;
import com.adyen.ui.fragments.CreditCardFragmentBuilder.CvcFieldStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.p140a.C6879a;
import p019d.p135a.p136a.p139c.p140a.C6881c;
import p019d.p135a.p136a.p142e.C6901a;
import p019d.p135a.p136a.p142e.C6912j;
import p030a.p031a.p032a.p033a.C0138a;

/* renamed from: com.adyen.ui.b.e */
/* compiled from: CreditCardFragment */
public class C5596e extends Fragment implements C5635a, Listener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9428a = C5596e.class.getSimpleName();

    /* renamed from: b */
    private static final String f9429b = C5611n.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C5597a f9430c;

    /* renamed from: d */
    private boolean f9431d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f9432e;

    /* renamed from: f */
    private C6878a f9433f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f9434g;

    /* renamed from: h */
    private C6889d f9435h;

    /* renamed from: i */
    private String f9436i;

    /* renamed from: j */
    private String f9437j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CreditCardEditText f9438k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ImageButton f9439l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ExpiryDateEditText f9440m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CVCEditText f9441n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public CardHolderEditText f9442o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CheckoutCheckBox f9443p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Spinner f9444q;

    /* renamed from: r */
    private LinearLayout f9445r;

    /* renamed from: s */
    private C5599a f9446s = C5599a.REQUIRED;

    /* renamed from: t */
    private int f9447t;

    /* renamed from: u */
    private List<PaymentCardScanner> f9448u;

    /* renamed from: com.adyen.ui.b.e$a */
    /* compiled from: CreditCardFragment */
    public interface C5597a {
        /* renamed from: a */
        void mo17722a(C6879a aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17733a(C5597a creditCardInfoListener) {
        this.f9430c = creditCardInfoListener;
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.f9431d = args.getBoolean("oneClick");
        this.f9433f = (C6878a) args.get("amount");
        this.f9435h = (C6889d) args.get("PaymentMethod");
        this.f9434g = args.getString("shopper_reference");
        this.f9436i = args.getString("public_key");
        this.f9437j = args.getString("generation_time");
        this.f9446s = C5599a.valueOf(args.getString("cvc_field_status"));
        for (C6881c inputDetail : this.f9435h.mo22327b()) {
            if (inputDetail.mo22311d().equals("cardHolderName")) {
                this.f9432e = true;
            }
        }
        this.f9447t = args.getInt("theme");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (PaymentCardScanner paymentCardScanner : this.f9448u) {
            paymentCardScanner.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f9448u = new ArrayList();
        if (getArguments().getBoolean("payment_card_scan_enabled")) {
            PaymentCardScannerFactory factory = Loader.getPaymentCardScannerFactory(getContext());
            if (factory != null) {
                this.f9448u.addAll(factory.getPaymentCardScanners(getActivity()));
            }
            for (PaymentCardScanner paymentCardScanner : this.f9448u) {
                paymentCardScanner.setListener(this);
            }
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == this.f9439l) {
            int size = this.f9448u.size();
            if (size == 1) {
                ((PaymentCardScanner) this.f9448u.get(0)).startScan();
            } else if (size > 1) {
                for (int itemId = 0; itemId < size; itemId++) {
                    menu.add(0, itemId, 0, ((PaymentCardScanner) this.f9448u.get(itemId)).getDisplayDescription());
                }
            }
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        int index = item.getItemId();
        if (index < 0 || index >= this.f9448u.size()) {
            return super.onContextItemSelected(item);
        }
        ((PaymentCardScanner) this.f9448u.get(index)).startScan();
        return true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.cloneInContext(new ContextThemeWrapper(getActivity(), this.f9447t)).inflate(C5631d.credit_card_fragment, container, false);
        this.f9438k = (CreditCardEditText) fragmentView.findViewById(C5626c.adyen_credit_card_no);
        this.f9439l = (ImageButton) fragmentView.findViewById(C5626c.scan_card_button);
        this.f9439l.setOnClickListener(new C5592a(this));
        if (this.f9448u.size() == 1) {
            this.f9439l.setImageDrawable(((PaymentCardScanner) this.f9448u.get(0)).getDisplayIcon());
        }
        registerForContextMenu(this.f9439l);
        this.f9439l.setVisibility(this.f9448u.isEmpty() ? 8 : 0);
        this.f9440m = (ExpiryDateEditText) fragmentView.findViewById(C5626c.adyen_credit_card_exp_date);
        this.f9441n = (CVCEditText) fragmentView.findViewById(C5626c.adyen_credit_card_cvc);
        this.f9445r = (LinearLayout) fragmentView.findViewById(C5626c.adyen_cvc_layout);
        this.f9442o = (CardHolderEditText) fragmentView.findViewById(C5626c.credit_card_holder_name);
        if (this.f9432e) {
            ((LinearLayout) fragmentView.findViewById(C5626c.card_holder_name_layout)).setVisibility(0);
        }
        Collection<InputDetail> inputDetails = this.f9435h.mo22327b();
        Iterator it = inputDetails.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C6881c inputDetail = (C6881c) it.next();
            if ("installments".equals(inputDetail.mo22311d())) {
                fragmentView.findViewById(C5626c.card_installments_area).setVisibility(0);
                List<Item> installmentOptions = inputDetail.mo22310c();
                this.f9444q = (Spinner) fragmentView.findViewById(C5626c.installments_spinner);
                this.f9444q.setAdapter(new C5574b(getActivity(), installmentOptions));
                break;
            }
        }
        Button collectDataButton = (Button) fragmentView.findViewById(C5626c.collectCreditCardData);
        TextView checkoutTextView = (TextView) fragmentView.findViewById(C5626c.amount_text_view);
        checkoutTextView.setText(getString(C5632e.pay_with_amount, C6901a.m14038a(this.f9433f, true, C6912j.m14059a((Context) getActivity()))));
        C5628b validator = new C5628b();
        validator.mo17783a((C5629a) new C5593b(this, collectDataButton));
        this.f9438k.setValidator(validator);
        this.f9438k.setCVCEditText(this.f9441n);
        this.f9438k.setLogoUrl(this.f9435h.mo22329c());
        this.f9438k.mo17792a();
        this.f9438k.setAllowedCardTypes(m9844c());
        this.f9440m.setValidator(validator);
        if (this.f9446s == C5599a.NOCVC) {
            this.f9441n.setOptional(true);
            this.f9445r.setVisibility(8);
        } else {
            this.f9445r.setVisibility(0);
            this.f9438k.mo17793a((C5635a) this);
            this.f9441n.setValidator(validator);
        }
        if (this.f9432e) {
            this.f9442o.setValidator(validator);
        }
        this.f9443p = (CheckoutCheckBox) fragmentView.findViewById(C5626c.save_card_checkbox);
        if (!C6912j.m14060a(this.f9434g)) {
            fragmentView.findViewById(C5626c.layout_save_card).setVisibility(0);
            fragmentView.findViewById(C5626c.layout_click_area_save_card).setOnClickListener(new C5594c(this));
        } else {
            fragmentView.findViewById(C5626c.layout_save_card).setVisibility(8);
        }
        collectDataButton.setOnClickListener(new C5595d(this, inputDetails, checkoutTextView, fragmentView));
        if (getActivity() instanceof CheckoutActivity) {
            ((CheckoutActivity) getActivity()).mo17713a(C5632e.title_card_details);
        }
        return fragmentView;
    }

    /* renamed from: c */
    private Map<String, C5599a> m9844c() {
        Map<String, CvcFieldStatus> allowedCardTypes = new HashMap<>();
        List<PaymentMethod> memberPaymentMethods = this.f9435h.mo22330d();
        String str = "true";
        if (memberPaymentMethods != null) {
            Iterator it = memberPaymentMethods.iterator();
            while (it.hasNext()) {
                C6889d memberPaymentMethod = (C6889d) it.next();
                if (memberPaymentMethod.mo22327b() != null && str.equals(memberPaymentMethod.mo22326a().mo22341b())) {
                    allowedCardTypes.put(memberPaymentMethod.mo22335h(), C5599a.NOCVC);
                } else if (memberPaymentMethod.mo22326a() == null || !str.equals(memberPaymentMethod.mo22326a().mo22340a())) {
                    allowedCardTypes.put(memberPaymentMethod.mo22335h(), C5599a.REQUIRED);
                } else {
                    allowedCardTypes.put(memberPaymentMethod.mo22335h(), C5599a.OPTIONAL);
                }
            }
        } else if (str.equals(this.f9435h.mo22326a().mo22341b())) {
            allowedCardTypes.put(this.f9435h.mo22335h(), C5599a.NOCVC);
        } else if (str.equals(this.f9435h.mo22326a().mo22340a())) {
            allowedCardTypes.put(this.f9435h.mo22335h(), C5599a.OPTIONAL);
        } else {
            allowedCardTypes.put(this.f9435h.mo22335h(), C5599a.REQUIRED);
        }
        return allowedCardTypes;
    }

    public void onResume() {
        super.onResume();
        for (PaymentCardScanner paymentCardScanner : this.f9448u) {
            paymentCardScanner.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        for (PaymentCardScanner paymentCardScanner : this.f9448u) {
            paymentCardScanner.onPause();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m9846d() {
        if (!m9848e()) {
            return null;
        }
        String str = "";
        if (TextUtils.isEmpty(this.f9436i)) {
            Log.e(f9428a, "Public key is not available; credit card payment cannot be handled.");
            return str;
        }
        JSONObject sensitiveData = new JSONObject();
        try {
            String str2 = "holderName";
            if (this.f9432e) {
                sensitiveData.put(str2, this.f9442o.getText());
            } else {
                sensitiveData.put(str2, "Checkout Shopper Placeholder");
            }
            sensitiveData.put("number", this.f9438k.getCCNumber());
            sensitiveData.put("expiryMonth", this.f9440m.getMonth());
            sensitiveData.put("expiryYear", this.f9440m.getFullYear());
            sensitiveData.put("generationtime", this.f9437j);
            sensitiveData.put("cvc", this.f9441n.getCVC());
            return new C0138a(this.f9436i).mo3720a(sensitiveData.toString());
        } catch (JSONException e) {
            Log.e(f9428a, "JSON Exception occurred while generating token.", e);
            return str;
        } catch (EncrypterException e2) {
            Log.e(f9428a, "EncrypterException occurred while generating token.", e2);
            return str;
        }
    }

    /* renamed from: e */
    private boolean m9848e() {
        if (this.f9438k == null || this.f9440m == null || this.f9441n == null || this.f9442o == null || this.f9443p == null) {
            return false;
        }
        return true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        CreditCardEditText creditCardNoView = (CreditCardEditText) view.findViewById(C5626c.adyen_credit_card_no);
        creditCardNoView.requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(creditCardNoView, 1);
    }

    /* renamed from: a */
    public void mo17734a(C5599a cvcFieldStatus) {
        this.f9446s = cvcFieldStatus;
        if (cvcFieldStatus == C5599a.NOCVC) {
            this.f9445r.setVisibility(8);
            return;
        }
        this.f9445r.setVisibility(0);
        if (cvcFieldStatus == C5599a.OPTIONAL) {
            this.f9441n.setOptional(true);
        } else {
            this.f9441n.setOptional(false);
        }
    }
}
