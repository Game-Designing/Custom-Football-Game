package com.smaato.soma.p261j;

import android.content.Context;
import android.webkit.WebView;
import com.smaato.soma.p236a.C12093D;
import com.smaato.soma.p236a.C12125n;

/* renamed from: com.smaato.soma.j.g */
/* compiled from: VASTAdActivity */
class C12472g extends C12093D {

    /* renamed from: d */
    final /* synthetic */ C12474i f38917d;

    C12472g(C12474i this$1, Context context, C12125n banner) {
        this.f38917d = this$1;
        super(context, banner);
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (!super.shouldOverrideUrlLoading(view, url)) {
            this.f38917d.m41006a(url);
            this.f38917d.f38920a.m41023h();
        }
        return true;
    }
}
