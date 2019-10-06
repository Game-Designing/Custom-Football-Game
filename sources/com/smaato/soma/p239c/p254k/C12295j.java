package com.smaato.soma.p239c.p254k;

import android.widget.RadioButton;
import com.smaato.soma.C12062Ma;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.k.j */
/* compiled from: CustomWebView */
class C12295j extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12296k f38467a;

    C12295j(C12296k this$2) {
        this.f38467a = this$2;
    }

    public Void process() throws Exception {
        String cause;
        int checkedId = this.f38467a.f38468a.getCheckedRadioButtonId();
        if (checkedId == -1) {
            cause = this.f38467a.f38469b.f38471b.getContext().getString(C12062Ma.report_ad_reason_not_specified);
        } else {
            cause = ((RadioButton) this.f38467a.f38468a.findViewById(checkedId)).getText().toString();
        }
        C12297l lVar = this.f38467a.f38469b;
        lVar.f38471b.mo39719a(lVar.f38470a, cause);
        return null;
    }
}
