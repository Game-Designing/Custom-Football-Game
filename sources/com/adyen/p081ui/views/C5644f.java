package com.adyen.p081ui.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.adyen.p081ui.C5626c;
import com.adyen.p081ui.C5631d;
import com.adyen.p081ui.C5632e;
import com.adyen.p081ui.C5633f;
import com.adyen.p081ui.p084c.C5628b;
import com.adyen.p081ui.p084c.C5628b.C5629a;
import com.adyen.utils.CardType;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p142e.C6901a;
import p019d.p135a.p136a.p142e.C6912j;

/* renamed from: com.adyen.ui.views.f */
/* compiled from: CVCDialog */
public class C5644f extends Dialog {

    /* renamed from: a */
    private C6878a f9562a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C6889d f9563b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f9564c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C5645a f9565d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Activity f9566e;

    /* renamed from: com.adyen.ui.views.f$a */
    /* compiled from: CVCDialog */
    public interface C5645a {
        /* renamed from: a */
        void mo17727a();
    }

    public C5644f(Activity activity, C6878a amount, C6889d paymentMethod, C5645a cvcDialogListener) {
        super(activity, C5633f.dialogStyle);
        this.f9566e = activity;
        this.f9562a = amount;
        this.f9563b = paymentMethod;
        this.f9565d = cvcDialogListener;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(C5631d.cvc_dialog);
        setCanceledOnTouchOutside(false);
        TextView cvcHintTextView = (TextView) findViewById(C5626c.extended_cvc_hint_textview);
        String cardName = this.f9563b.mo22331e().replaceAll(" ", " ");
        cvcHintTextView.setText(getContext().getString(C5632e.cvc_extended_hint_with_last_digits, new Object[]{cardName}));
        CVCEditText cvcEditText = (CVCEditText) findViewById(C5626c.adyen_credit_card_cvc);
        Button cancelButton = (Button) findViewById(C5626c.button_cancel_cvc_verification);
        cancelButton.setOnClickListener(new C5639a(this));
        C5628b validator = new C5628b();
        Button checkoutButton = (Button) findViewById(C5626c.button_confirm_cvc_verification);
        String amountStr = C6901a.m14038a(this.f9562a, true, C6912j.m14059a((Context) this.f9566e));
        checkoutButton.setText(getContext().getString(C5632e.pay_with_amount, new Object[]{amountStr}));
        checkoutButton.setEnabled(false);
        validator.mo17783a((C5629a) new C5640b(this, checkoutButton));
        cvcEditText.setValidator(validator);
        checkoutButton.setOnClickListener(new C5641c(this, cvcEditText, checkoutButton, cancelButton));
        setOnShowListener(new C5642d(this, cvcEditText));
        setOnDismissListener(new C5643e(this));
        if (this.f9563b.mo22335h().equals(CardType.amex.toString())) {
            cvcEditText.setMaxLength(4);
        }
    }

    public void onBackPressed() {
        if (this.f9564c) {
            this.f9566e.finish();
        }
    }
}
