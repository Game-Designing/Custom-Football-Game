package com.braintreepayments.cardform.view;

import android.content.Context;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import p019d.p151c.p152a.C7287j;

public class MobileNumberEditText extends C5900a {
    public MobileNumberEditText(Context context) {
        super(context);
        m10767o();
    }

    public MobileNumberEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10767o();
    }

    public MobileNumberEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m10767o();
    }

    /* renamed from: o */
    private void m10767o() {
        if (!isInEditMode()) {
            setInputType(3);
            setFilters(new InputFilter[]{new LengthFilter(14)});
            addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        }
    }

    public String getMobileNumber() {
        return PhoneNumberUtils.stripSeparators(getText().toString());
    }

    /* renamed from: k */
    public boolean mo18431k() {
        return mo18493j() || getText().toString().length() >= 8;
    }

    public String getErrorMessage() {
        return getContext().getString(C7287j.bt_mobile_number_required);
    }
}
