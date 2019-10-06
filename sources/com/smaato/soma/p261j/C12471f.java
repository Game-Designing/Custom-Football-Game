package com.smaato.soma.p261j;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12330E;

/* renamed from: com.smaato.soma.j.f */
/* compiled from: VASTAdActivity */
class C12471f extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12485t f38916a;

    C12471f(C12485t this$0) {
        this.f38916a = this$0;
    }

    public Void process() throws Exception {
        C12485t tVar = this.f38916a;
        tVar.f38933e = new RelativeLayout(tVar);
        C12485t tVar2 = this.f38916a;
        tVar2.setContentView(tVar2.f38933e);
        try {
            this.f38916a.f38932d = C12437E.m40895a(Long.valueOf(this.f38916a.getIntent().getLongExtra("vastViewCacheId", 0)));
            if (this.f38916a.f38932d == null) {
                C12146d.m39965a(new C12147e("VASTAdActivity", "VASTView is null, closing activity", 1, C12143a.ERROR));
                this.f38916a.finish();
                return null;
            }
            C12330E.m40539a(this.f38916a.f38932d);
            this.f38916a.getWindow().getDecorView().setBackgroundColor(CtaButton.BACKGROUND_COLOR);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            this.f38916a.f38932d.setLayoutParams(layoutParams);
            this.f38916a.f38932d.setOnVideoFinishedPlaying(this.f38916a);
            this.f38916a.f38932d.start();
            this.f38916a.f38933e.addView(this.f38916a.f38932d, layoutParams);
            try {
                if (this.f38916a.f38932d != null && !this.f38916a.f38932d.mo39946l() && this.f38916a.f38932d.getVastAd().mo39699c() > ((long) this.f38916a.f38932d.getVideoSkipInterval())) {
                    this.f38916a.f38934f.postDelayed(new C12470e(this), (long) (this.f38916a.f38932d.getVideoSkipInterval() * 1000));
                }
            } catch (Exception e) {
            }
            return null;
        } catch (Throwable th) {
            LayoutParams layoutParams2 = new LayoutParams(-1, -1);
            layoutParams2.addRule(13, -1);
            this.f38916a.f38932d.setLayoutParams(layoutParams2);
            this.f38916a.f38933e.addView(this.f38916a.f38932d, layoutParams2);
        }
    }
}
