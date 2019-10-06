package com.adyen.p081ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import com.adyen.p081ui.p084c.C5628b;
import java.util.ArrayList;

/* renamed from: com.adyen.ui.views.CVCEditText */
public class CVCEditText extends C5651l {

    /* renamed from: a */
    private int f9531a = 3;

    /* renamed from: b */
    private boolean f9532b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C5628b f9533c;

    /* renamed from: b */
    private void m9935b() {
        ArrayList<InputFilter> cvcFilters = new ArrayList<>();
        cvcFilters.add(new LengthFilter(3));
        cvcFilters.add(new C5646g(this));
        setFilters((InputFilter[]) cvcFilters.toArray(new InputFilter[cvcFilters.size()]));
        addTextChangedListener(new C5647h(this));
        setOnFocusChangeListener(new C5648i(this));
    }

    public CVCEditText(Context context) {
        super(context);
        m9935b();
    }

    public CVCEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9935b();
    }

    public CVCEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m9935b();
    }

    @TargetApi(21)
    public CVCEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m9935b();
    }

    public void setValidator(C5628b validator) {
        this.f9533c = validator;
        this.f9533c.mo17781a((View) this);
    }

    public String getCVC() {
        return getText().toString();
    }

    public void setMaxLength(int newMaxLength) {
        this.f9531a = newMaxLength;
        InputFilter[] inputFilters = getFilters();
        int i = 0;
        while (true) {
            if (i >= inputFilters.length) {
                break;
            } else if (inputFilters[i] instanceof LengthFilter) {
                inputFilters[i] = new LengthFilter(this.f9531a);
                break;
            } else {
                i++;
            }
        }
        setFilters(inputFilters);
        if (getText().toString().length() > this.f9531a) {
            setText(getText().toString().substring(0, this.f9531a));
        }
    }

    /* renamed from: a */
    public boolean mo17784a() {
        return getText().toString().length() == this.f9531a || this.f9532b;
    }

    public void setOptional(boolean optional) {
        this.f9532b = optional;
    }
}
