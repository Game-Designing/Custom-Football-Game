package com.adyen.p081ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.adyen.p081ui.p084c.C5628b;

/* renamed from: com.adyen.ui.views.CardHolderEditText */
public class CardHolderEditText extends C5651l {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C5628b f9534a;

    public CardHolderEditText(Context context) {
        super(context);
        m9938a();
    }

    public CardHolderEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9938a();
    }

    public CardHolderEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m9938a();
    }

    @TargetApi(21)
    public CardHolderEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m9938a();
    }

    /* renamed from: a */
    private void m9938a() {
        addTextChangedListener(new C5649j(this));
    }

    public void setValidator(C5628b validator) {
        this.f9534a = validator;
        this.f9534a.mo17781a((View) this);
    }
}
