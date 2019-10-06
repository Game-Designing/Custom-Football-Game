package com.smaato.soma.p236a;

import android.webkit.WebView;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p260i.C12402c;

/* renamed from: com.smaato.soma.a.u */
/* compiled from: BannerAnimator */
class C12134u extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ WebView f38048a;

    /* renamed from: b */
    final /* synthetic */ C12369fa f38049b;

    /* renamed from: c */
    final /* synthetic */ C12125n f38050c;

    /* renamed from: d */
    final /* synthetic */ C12137x f38051d;

    C12134u(C12137x this$0, WebView webView, C12369fa faVar, C12125n nVar) {
        this.f38051d = this$0;
        this.f38048a = webView;
        this.f38049b = faVar;
        this.f38050c = nVar;
    }

    public Void process() throws Exception {
        if (this.f38051d.mo39380c()) {
            this.f38051d.f38060e = new C12402c(this.f38048a.getContext());
            this.f38051d.f38060e.setOnClickListener(new C12133t(this));
        }
        return null;
    }
}
