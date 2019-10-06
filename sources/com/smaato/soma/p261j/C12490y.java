package com.smaato.soma.p261j;

import android.media.MediaPlayer;
import com.moat.analytics.mobile.sma.MoatFactory;
import com.smaato.soma.C12066Oa;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p252i.C12279e;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.smaato.soma.j.y */
/* compiled from: VASTView */
class C12490y extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ MediaPlayer f38946a;

    /* renamed from: b */
    final /* synthetic */ C12435D f38947b;

    C12490y(C12435D this$0, MediaPlayer mediaPlayer) {
        this.f38947b = this$0;
        this.f38946a = mediaPlayer;
    }

    public Void process() throws Exception {
        this.f38947b.f38832m = false;
        Vector<String> imp = this.f38947b.f38820a.mo39706f();
        Vector<String> start = this.f38947b.f38820a.mo39692a("start");
        Vector<String> full = this.f38947b.f38820a.mo39692a("fullscreen");
        if (!this.f38947b.f38828i) {
            new C12279e().execute(new Vector[]{imp});
            this.f38947b.f38828i = true;
        }
        if (!this.f38947b.f38829j) {
            new C12279e().execute(new Vector[]{start});
            this.f38947b.f38829j = true;
        }
        if (!this.f38947b.f38830k) {
            new C12279e().execute(new Vector[]{full});
            this.f38947b.f38830k = true;
        }
        this.f38947b.f38823d.mo39495j();
        if (C12066Oa.m39873b()) {
            Map<String, String> moatParams = C12435D.m40866b((Collection<C12204a>) this.f38947b.getVastAd().mo39705e());
            if (moatParams != null && !moatParams.isEmpty()) {
                this.f38947b.f38836q = MoatFactory.create().createNativeVideoTracker("smaatonativevideo767348721735");
                this.f38947b.f38836q.trackVideoAd(moatParams, this.f38946a, this.f38947b);
            }
        }
        this.f38947b.m40886n();
        return null;
    }
}
