package com.smaato.soma.p239c.p254k;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.C12056Ja;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p239c.p252i.C12278d;

/* renamed from: com.smaato.soma.c.k.f */
/* compiled from: CustomWebView */
class C12291f extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12301p f38462a;

    C12291f(C12301p this$0) {
        this.f38462a = this$0;
    }

    public Void process() throws Exception {
        Context context = this.f38462a.getContext();
        int size = C12278d.m40415a().mo39670a(20);
        if (this.f38462a.f38482d == null) {
            this.f38462a.f38482d = new ImageView(context);
            this.f38462a.f38482d.setImageResource(C12056Ja.ic_report_ad_20dp);
        }
        RelativeLayout layout = new RelativeLayout(context);
        LayoutParams ll = new LayoutParams(size, size);
        ll.addRule(12);
        ll.addRule(11);
        layout.addView(this.f38462a.f38482d, ll);
        this.f38462a.f38482d.setOnClickListener(new C12290e(this));
        this.f38462a.addView(layout);
        this.f38462a.f38479a = true;
        return null;
    }
}
