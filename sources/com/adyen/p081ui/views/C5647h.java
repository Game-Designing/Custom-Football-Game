package com.adyen.p081ui.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.adyen.p081ui.p084c.C5628b;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.adyen.ui.views.h */
/* compiled from: CVCEditText */
class C5647h implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CVCEditText f9568a;

    C5647h(CVCEditText this$0) {
        this.f9568a = this$0;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        if (this.f9568a.f9533c != null) {
            C5628b a = this.f9568a.f9533c;
            CVCEditText cVCEditText = this.f9568a;
            a.mo17782a(cVCEditText, cVCEditText.mo17784a());
        }
        if (this.f9568a.mo17784a()) {
            View next = this.f9568a.focusSearch(Opcodes.IXOR);
            if (next != null) {
                next.requestFocus();
            }
        }
    }
}
