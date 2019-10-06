package com.adyen.p081ui.p083b;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.C5632e;
import com.adyen.p081ui.activities.CheckoutActivity;
import com.adyen.p081ui.p084c.C5628b;
import com.adyen.p081ui.p084c.C5628b.C5629a;
import com.adyen.p081ui.views.CardHolderEditText;
import com.adyen.p081ui.views.CheckoutCheckBox;
import com.adyen.p081ui.views.IBANEditText;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p142e.C6901a;
import p019d.p135a.p136a.p142e.C6912j;

/* renamed from: com.adyen.ui.b.w */
/* compiled from: SepaDirectDebitFragment */
public class C5623w extends Fragment {

    /* renamed from: a */
    private C6878a f9517a;

    /* renamed from: b */
    private int f9518b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C5624a f9519c;

    /* renamed from: com.adyen.ui.b.w$a */
    /* compiled from: SepaDirectDebitFragment */
    public interface C5624a {
        /* renamed from: a */
        void mo17724a(String str, String str2);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.f9517a = (C6878a) args.get("amount");
        this.f9518b = args.getInt("theme");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.cloneInContext(new ContextThemeWrapper(getActivity(), this.f9518b)).inflate(C5631d.sepa_direct_debit_fragment, container, false);
        C5628b validator = new C5628b();
        IBANEditText ibanEditText = (IBANEditText) fragmentView.findViewById(C5626c.adyen_sepa_iban_edit_text);
        ibanEditText.setValidator(validator);
        ((CardHolderEditText) fragmentView.findViewById(C5626c.adyen_bank_account_holder_name)).setValidator(validator);
        CheckoutCheckBox consentCheckbox = (CheckoutCheckBox) fragmentView.findViewById(C5626c.consent_direct_debit_checkbox);
        validator.mo17781a((View) consentCheckbox);
        consentCheckbox.setOnCheckedChangeListener(new C5619s(this, validator, consentCheckbox));
        fragmentView.findViewById(C5626c.layout_click_area_consent_checkbox).setOnClickListener(new C5620t(this, consentCheckbox));
        Button confirmButton = (Button) fragmentView.findViewById(C5626c.collect_direct_debit_data);
        confirmButton.setOnClickListener(new C5621u(this, ibanEditText));
        validator.mo17783a((C5629a) new C5622v(this, confirmButton));
        TextView amountTextview = (TextView) fragmentView.findViewById(C5626c.amount_text_view);
        String valueString = C6901a.m14038a(this.f9517a, true, C6912j.m14059a((Context) getActivity()));
        amountTextview.setText(getString(C5632e.pay_with_amount, valueString));
        if (getActivity() instanceof CheckoutActivity) {
            ((CheckoutActivity) getActivity()).mo17713a(C5632e.title_sepa);
        }
        return fragmentView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17776a(C5624a listener) {
        this.f9519c = listener;
    }
}
