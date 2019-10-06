package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import p019d.p151c.p152a.C7287j;

public class PostalCodeEditText extends C5900a {
    public PostalCodeEditText(Context context) {
        super(context);
        m10769o();
    }

    public PostalCodeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10769o();
    }

    public PostalCodeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m10769o();
    }

    /* renamed from: o */
    private void m10769o() {
        setInputType(112);
        setFilters(new InputFilter[]{new LengthFilter(16)});
    }

    /* renamed from: k */
    public boolean mo18431k() {
        return mo18493j() || getText().toString().length() > 0;
    }

    public String getErrorMessage() {
        return getContext().getString(C7287j.bt_postal_code_required);
    }
}
