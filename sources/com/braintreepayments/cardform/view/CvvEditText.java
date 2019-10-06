package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import p019d.p151c.p152a.C7287j;
import p019d.p151c.p152a.p153a.C7271a;

public class CvvEditText extends C5900a implements TextWatcher {

    /* renamed from: f */
    private C7271a f10302f;

    public CvvEditText(Context context) {
        super(context);
        m10761o();
    }

    public CvvEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10761o();
    }

    public CvvEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m10761o();
    }

    /* renamed from: o */
    private void m10761o() {
        setInputType(2);
        setFilters(new InputFilter[]{new LengthFilter(3)});
        addTextChangedListener(this);
    }

    public void setCardType(C7271a cardType) {
        this.f10302f = cardType;
        setFilters(new InputFilter[]{new LengthFilter(cardType.mo23493i())});
        setContentDescription(getContext().getString(cardType.mo23494j()));
        setFieldHint(cardType.mo23494j());
        invalidate();
    }

    public void afterTextChanged(Editable editable) {
        C7271a aVar = this.f10302f;
        if (aVar != null && aVar.mo23493i() == editable.length() && getSelectionStart() == editable.length()) {
            mo18494l();
            if (mo18431k()) {
                mo18492i();
            }
        }
    }

    /* renamed from: k */
    public boolean mo18431k() {
        return mo18493j() || getText().toString().length() == getSecurityCodeLength();
    }

    public String getErrorMessage() {
        String securityCodeName;
        if (this.f10302f == null) {
            securityCodeName = getContext().getString(C7287j.bt_cvv);
        } else {
            securityCodeName = getContext().getString(this.f10302f.mo23494j());
        }
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(C7287j.bt_cvv_required, new Object[]{securityCodeName});
        }
        return getContext().getString(C7287j.bt_cvv_invalid, new Object[]{securityCodeName});
    }

    private int getSecurityCodeLength() {
        C7271a aVar = this.f10302f;
        if (aVar == null) {
            return 3;
        }
        return aVar.mo23493i();
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
}
