package com.smaato.soma.p261j;

import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.j.s */
/* compiled from: VASTAdActivity */
class C12484s extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12485t f38930a;

    C12484s(C12485t this$0) {
        this.f38930a = this$0;
    }

    public Void process() {
        try {
            if (this.f38930a.f38931c != null) {
                this.f38930a.f38931c.stopTracking();
            }
            this.f38930a.f38934f.removeCallbacksAndMessages(null);
            this.f38930a.f38935g.removeCallbacksAndMessages(null);
            this.f38930a.f38932d.setIsRewardedVideo(false);
            this.f38930a.f38932d.mo39943i();
            this.f38930a.f38932d.setOnVideoFinishedPlaying(null);
            this.f38930a.f38932d.destroyDrawingCache();
            this.f38930a.f38936h = null;
            this.f38930a.f38933e.removeAllViews();
            this.f38930a.f38933e.destroyDrawingCache();
            this.f38930a.f38933e = null;
            Runtime.getRuntime().gc();
        } catch (Exception e) {
        }
        return null;
    }
}
