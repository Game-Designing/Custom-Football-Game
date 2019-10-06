package com.smaato.soma.p239c.p246f;

import android.app.Activity;
import android.app.Application;
import com.smaato.soma.C12066Oa;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.f.b */
/* compiled from: AdDownloader */
class C12213b extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12216c f38279a;

    C12213b(C12216c this$1) {
        this.f38279a = this$1;
    }

    public Void process() throws Exception {
        if (this.f38279a.f38286b.f38349r instanceof Activity) {
            C12066Oa.m39872a(((Activity) this.f38279a.f38286b.f38349r).getApplication(), this.f38279a.f38285a);
        } else {
            C12066Oa.m39872a((Application) this.f38279a.f38286b.f38349r.getApplicationContext(), this.f38279a.f38285a);
        }
        return null;
    }
}
