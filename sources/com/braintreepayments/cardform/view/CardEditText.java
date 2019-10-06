package com.braintreepayments.cardform.view;

import android.content.Context;
import android.support.p000v4.widget.C0665C;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
import p019d.p151c.p152a.C7284g;
import p019d.p151c.p152a.C7287j;
import p019d.p151c.p152a.p153a.C7271a;

public class CardEditText extends C5900a implements TextWatcher {

    /* renamed from: f */
    private boolean f10277f = true;

    /* renamed from: g */
    private C7271a f10278g;

    /* renamed from: h */
    private C5899a f10279h;

    /* renamed from: com.braintreepayments.cardform.view.CardEditText$a */
    public interface C5899a {
        /* renamed from: a */
        void mo18433a(C7271a aVar);
    }

    public CardEditText(Context context) {
        super(context);
        m10743o();
    }

    public CardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10743o();
    }

    public CardEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m10743o();
    }

    /* renamed from: o */
    private void m10743o() {
        setInputType(2);
        setCardIcon(C7284g.bt_ic_unknown);
        addTextChangedListener(this);
        m10744p();
    }

    public C7271a getCardType() {
        return this.f10278g;
    }

    public void setOnCardTypeChangedListener(C5899a listener) {
        this.f10279h = listener;
    }

    public void afterTextChanged(Editable editable) {
        for (Object span : editable.getSpans(0, editable.length(), C5908i.class)) {
            editable.removeSpan(span);
        }
        m10744p();
        setCardIcon(this.f10278g.mo23490e());
        m10742a(editable, this.f10278g.mo23495s());
        if (this.f10278g.mo23491f() == getSelectionStart()) {
            mo18494l();
            if (mo18431k()) {
                mo18492i();
            }
        }
    }

    /* renamed from: k */
    public boolean mo18431k() {
        return mo18493j() || this.f10278g.mo23489c(getText().toString());
    }

    public String getErrorMessage() {
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(C7287j.bt_card_number_required);
        }
        return getContext().getString(C7287j.bt_card_number_invalid);
    }

    /* renamed from: p */
    private void m10744p() {
        C7271a type = C7271a.m15821a(getText().toString());
        if (this.f10278g != type) {
            this.f10278g = type;
            setFilters(new InputFilter[]{new LengthFilter(this.f10278g.mo23491f())});
            invalidate();
            C5899a aVar = this.f10279h;
            if (aVar != null) {
                aVar.mo18433a(this.f10278g);
            }
        }
    }

    /* renamed from: a */
    private void m10742a(Editable editable, int[] spaceIndices) {
        int length = editable.length();
        for (int index : spaceIndices) {
            if (index <= length) {
                editable.setSpan(new C5908i(), index - 1, index, 33);
            }
        }
    }

    private void setCardIcon(int icon) {
        if (!this.f10277f || getText().length() == 0) {
            C0665C.m3100a((TextView) this, 0, 0, 0, 0);
        } else {
            C0665C.m3100a((TextView) this, 0, 0, icon, 0);
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
}
