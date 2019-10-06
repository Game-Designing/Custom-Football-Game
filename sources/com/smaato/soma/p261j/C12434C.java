package com.smaato.soma.p261j;

import android.content.Intent;
import com.smaato.soma.C12398ha;
import com.smaato.soma.ExpandedBannerActivity;
import com.smaato.soma.p239c.p252i.C12279e;
import java.util.Vector;

/* renamed from: com.smaato.soma.j.C */
/* compiled from: VASTView */
class C12434C extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12435D f38819a;

    C12434C(C12435D this$0) {
        this.f38819a = this$0;
    }

    public Void process() throws Exception {
        new C12279e().execute(new Vector[]{this.f38819a.f38820a.mo39708h()});
        Intent browserIntent = new Intent(this.f38819a.getContext(), ExpandedBannerActivity.class);
        browserIntent.putExtra("string_url", this.f38819a.f38820a.mo39707g().trim());
        long dispatcherCacheId = System.currentTimeMillis();
        C12447O.m40922a(Long.valueOf(dispatcherCacheId), this.f38819a.getVideoAdDispatcher());
        browserIntent.putExtra("videoAdDispatcherCacheId", dispatcherCacheId);
        this.f38819a.getContext().startActivity(browserIntent);
        this.f38819a.getVideoAdDispatcher().mo39485e();
        return null;
    }
}
