package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import p019d.p151c.p152a.C7287j;

public class CountryCodeEditText extends C5900a {
    public CountryCodeEditText(Context context) {
        super(context);
        m10759o();
    }

    public CountryCodeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10759o();
    }

    public CountryCodeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m10759o();
    }

    /* renamed from: o */
    private void m10759o() {
        setInputType(3);
        setFilters(new InputFilter[]{new LengthFilter(4)});
    }

    public String getCountryCode() {
        return getText().toString().replaceAll("[^\\d]", "");
    }

    /* renamed from: k */
    public boolean mo18431k() {
        return mo18493j() || getText().toString().length() > 0;
    }

    public String getErrorMessage() {
        return getContext().getString(C7287j.bt_country_code_required);
    }
}
