package com.smaato.soma.p261j;

import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.j.r */
/* compiled from: VASTAdActivity */
class C12483r extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12485t f38929a;

    C12483r(C12485t this$0) {
        this.f38929a = this$0;
    }

    public Void process() {
        try {
            this.f38929a.f38932d.getVideoAdDispatcher().mo39483c();
            this.f38929a.f38932d.pause();
            this.f38929a.f38934f.removeCallbacksAndMessages(null);
            this.f38929a.f38935g.removeCallbacksAndMessages(null);
            this.f38929a.f38932d.setIsRewardedVideo(false);
            this.f38929a.f38932d.destroyDrawingCache();
            this.f38929a.f38932d.mo39943i();
            this.f38929a.f38936h = null;
            this.f38929a.finish();
        } catch (Exception e) {
        }
        return null;
    }
}
