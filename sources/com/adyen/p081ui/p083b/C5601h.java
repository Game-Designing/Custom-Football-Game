package com.adyen.p081ui.p083b;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.adyen.ui.b.h */
/* compiled from: GiropayFragment */
class C5601h implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ C5603j f9463a;

    C5601h(C5603j this$0) {
        this.f9463a = this$0;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        String str = s.toString();
        if (str.length() >= 3) {
            this.f9463a.f9471f.setVisibility(8);
            if (this.f9463a.f9466a.m9884b() == 0) {
                if (this.f9463a.f9472g != null) {
                    this.f9463a.f9472g.cancel(true);
                }
                C5603j jVar = this.f9463a;
                jVar.f9472g = new C5606c(jVar, str, null);
                this.f9463a.f9472g.execute(new Void[0]);
                return;
            }
            this.f9463a.f9466a.m9882a(str);
            this.f9463a.f9466a.notifyDataSetChanged();
            return;
        }
        this.f9463a.f9471f.setVisibility(0);
        this.f9463a.f9468c.setVisibility(8);
        if (this.f9463a.f9472g != null) {
            this.f9463a.f9472g.cancel(true);
        }
        this.f9463a.f9466a.m9878a();
        this.f9463a.f9466a.notifyDataSetChanged();
    }
}
