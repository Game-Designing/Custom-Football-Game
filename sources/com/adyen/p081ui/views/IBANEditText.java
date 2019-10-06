package com.adyen.p081ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.adyen.p081ui.p084c.C5628b;
import java.util.ArrayList;

/* renamed from: com.adyen.ui.views.IBANEditText */
public class IBANEditText extends EditText {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C5628b f9551a;

    public IBANEditText(Context context) {
        super(context);
        m9961a();
    }

    public IBANEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9961a();
    }

    public IBANEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m9961a();
    }

    @TargetApi(21)
    public IBANEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m9961a();
    }

    public void setValidator(C5628b validator) {
        this.f9551a = validator;
        this.f9551a.mo17781a((View) this);
    }

    /* renamed from: a */
    private void m9961a() {
        ArrayList<InputFilter> inputFilters = new ArrayList<>();
        inputFilters.add(new LengthFilter(36));
        inputFilters.add(new AllCaps());
        inputFilters.add(new C5660r(this));
        setFilters((InputFilter[]) inputFilters.toArray(new InputFilter[inputFilters.size()]));
        addTextChangedListener(new C5661s(this));
    }

    public String getIbanNumber() {
        return getText().toString().replaceAll(" ", "");
    }
}
