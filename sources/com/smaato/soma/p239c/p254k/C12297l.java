package com.smaato.soma.p239c.p254k;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RadioGroup;
import com.smaato.soma.C12060La;
import com.smaato.soma.C12062Ma;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.k.l */
/* compiled from: CustomWebView */
class C12297l extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Context f38470a;

    /* renamed from: b */
    final /* synthetic */ C12301p f38471b;

    C12297l(C12301p this$0, Context context) {
        this.f38471b = this$0;
        this.f38470a = context;
    }

    public Void process() throws Exception {
        Builder alertBuilder = new Builder(this.f38470a);
        alertBuilder.setTitle(C12062Ma.report_ad_title_reason);
        RadioGroup rg = (RadioGroup) LayoutInflater.from(this.f38470a).inflate(C12060La.report_ad_radios, null);
        alertBuilder.setView(rg);
        alertBuilder.setPositiveButton(17039370, new C12296k(this, rg));
        alertBuilder.setNegativeButton(17039360, null);
        alertBuilder.show();
        return null;
    }
}
