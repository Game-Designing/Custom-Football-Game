package com.adyen.p081ui.views;

import android.support.p000v4.content.C0510b;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.adyen.p081ui.C5572a;
import com.adyen.p081ui.p084c.C5628b;

/* renamed from: com.adyen.ui.views.i */
/* compiled from: CVCEditText */
class C5648i implements OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ CVCEditText f9569a;

    C5648i(CVCEditText this$0) {
        this.f9569a = this$0;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            CVCEditText cVCEditText = this.f9569a;
            cVCEditText.setTextColor(C0510b.m2564a(cVCEditText.getContext(), C5572a.black_text));
            if (this.f9569a.f9533c != null) {
                C5628b a = this.f9569a.f9533c;
                CVCEditText cVCEditText2 = this.f9569a;
                a.mo17782a(cVCEditText2, cVCEditText2.mo17784a());
            }
        } else if (!this.f9569a.mo17784a()) {
            CVCEditText cVCEditText3 = this.f9569a;
            cVCEditText3.setTextColor(C0510b.m2564a(cVCEditText3.getContext(), C5572a.red_invalid_input_highlight));
        }
    }
}
