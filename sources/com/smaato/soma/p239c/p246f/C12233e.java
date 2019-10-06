package com.smaato.soma.p239c.p246f;

import com.smaato.soma.C12408ia;
import com.smaato.soma.p256e.C12357u.C12358a;

/* renamed from: com.smaato.soma.c.f.e */
/* compiled from: AdDownloader */
class C12233e implements C12358a {

    /* renamed from: a */
    final /* synthetic */ C12239k f38320a;

    C12233e(C12239k this$0) {
        this.f38320a = this$0;
    }

    /* renamed from: a */
    public void mo39589a(C12408ia errorCode) {
        if (errorCode != null) {
            C12239k kVar = this.f38320a;
            StringBuilder sb = new StringBuilder();
            sb.append("onNativeAdFailed with ErrorCode");
            sb.append(errorCode);
            kVar.m40253a("AdDowndloader_Med", sb.toString());
        }
        this.f38320a.mo39606c();
    }
}
