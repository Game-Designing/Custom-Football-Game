package com.smaato.soma.p261j;

import android.content.Intent;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.C12398ha;
import com.smaato.soma.ExpandedBannerActivity;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p252i.C12278d;
import com.smaato.soma.p239c.p253j.C12282a;
import java.util.Collection;

/* renamed from: com.smaato.soma.j.i */
/* compiled from: VASTAdActivity */
class C12474i extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12485t f38920a;

    C12474i(C12485t this$0) {
        this.f38920a = this$0;
    }

    public Void process() throws Exception {
        C12282a companionAd = this.f38920a.f38932d.getVastAd().mo39691a();
        if (companionAd == null) {
            return null;
        }
        WebView mCompanionAd = new WebView(this.f38920a);
        mCompanionAd.setVerticalScrollBarEnabled(false);
        mCompanionAd.setHorizontalScrollBarEnabled(false);
        mCompanionAd.getSettings().setJavaScriptEnabled(true);
        C12485t tVar = this.f38920a;
        mCompanionAd.loadDataWithBaseURL(null, tVar.m41011a(companionAd, (Collection<C12204a>) tVar.f38932d.getVastAd().mo39705e()), "text/html", "utf-8", null);
        mCompanionAd.setWebViewClient(new C12472g(this, this.f38920a, null));
        mCompanionAd.setOnTouchListener(new C12473h(this, companionAd));
        LayoutParams params = new LayoutParams(C12278d.m40415a().mo39670a(companionAd.mo39690g()), C12278d.m40415a().mo39670a(companionAd.mo39688e()));
        params.addRule(13, -1);
        this.f38920a.m41014a(mCompanionAd, companionAd);
        this.f38920a.f38933e.addView(mCompanionAd, params);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41006a(String url) {
        Intent browserIntent = new Intent(this.f38920a, ExpandedBannerActivity.class);
        browserIntent.putExtra("string_url", url);
        if (this.f38920a.f38932d != null) {
            long dispatcherCacheId = System.currentTimeMillis();
            C12447O.m40922a(Long.valueOf(dispatcherCacheId), this.f38920a.f38932d.getVideoAdDispatcher());
            browserIntent.putExtra("videoAdDispatcherCacheId", dispatcherCacheId);
        }
        this.f38920a.startActivity(browserIntent);
    }
}
