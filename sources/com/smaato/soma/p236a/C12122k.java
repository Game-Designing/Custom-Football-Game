package com.smaato.soma.p236a;

import android.content.Intent;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.a.k */
/* compiled from: AbstractBannerPackage */
class C12122k extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12123l f38012a;

    C12122k(C12123l this$3) {
        this.f38012a = this$3;
    }

    public Void process() throws Exception {
        this.f38012a.f38013a.dismiss();
        Intent intent = null;
        if (this.f38012a.f38014b.mo39391b() != null) {
            intent = C12125n.this.mo39357h().getPackageManager().getLaunchIntentForPackage(this.f38012a.f38014b.mo39391b());
        } else if (this.f38012a.f38014b.mo39393c() != null) {
            intent = Intent.parseUri(this.f38012a.f38014b.mo39393c(), 1);
        }
        intent.addFlags(268435456);
        C12125n.this.mo39357h().getApplicationContext().startActivity(intent);
        return null;
    }
}
