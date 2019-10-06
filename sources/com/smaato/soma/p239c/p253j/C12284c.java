package com.smaato.soma.p239c.p253j;

import com.smaato.soma.C12398ha;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* renamed from: com.smaato.soma.c.j.c */
/* compiled from: VASTAd */
class C12284c extends C12398ha<Long> {

    /* renamed from: a */
    final /* synthetic */ C12285d f38441a;

    C12284c(C12285d this$0) {
        this.f38441a = this$0;
    }

    public Long process() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        StringBuilder sb = new StringBuilder();
        sb.append("1970-01-01 ");
        sb.append(this.f38441a.mo39696b());
        return Long.valueOf(sdf.parse(sb.toString()).getTime() / 1000);
    }
}
