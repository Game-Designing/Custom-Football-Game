package com.smaato.soma.p239c.p254k;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.smaato.soma.C12062Ma;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.k.i */
/* compiled from: CustomWebView */
class C12294i extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Context f38465a;

    /* renamed from: b */
    final /* synthetic */ C12301p f38466b;

    C12294i(C12301p this$0, Context context) {
        this.f38466b = this$0;
        this.f38465a = context;
    }

    public Void process() throws Exception {
        Builder alertBuilder = new Builder(this.f38465a);
        alertBuilder.setMessage(C12062Ma.report_ad_message);
        alertBuilder.setCancelable(true);
        alertBuilder.setPositiveButton(C12062Ma.yes, new C12293h(this));
        alertBuilder.setNegativeButton(C12062Ma.f37920no, null);
        alertBuilder.show();
        return null;
    }
}
