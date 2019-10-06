package com.smaato.soma.p261j;

import com.smaato.soma.p239c.p252i.C12279e;
import java.util.Vector;

/* renamed from: com.smaato.soma.j.x */
/* compiled from: VASTView */
class C12489x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12435D f38945a;

    C12489x(C12435D this$0) {
        this.f38945a = this$0;
    }

    public void run() {
        long currentPosition = (long) (this.f38945a.getCurrentPosition() / 1000);
        long quartile = this.f38945a.f38824e / 4;
        if (currentPosition >= quartile && !this.f38945a.f38825f) {
            new C12279e().execute(new Vector[]{this.f38945a.f38820a.mo39692a("firstQuartile")});
            this.f38945a.f38825f = true;
            if (this.f38945a.mo39946l()) {
                this.f38945a.f38823d.mo39493h();
            }
        } else if (currentPosition >= 2 * quartile && !this.f38945a.f38826g) {
            new C12279e().execute(new Vector[]{this.f38945a.f38820a.mo39692a("midpoint")});
            this.f38945a.f38826g = true;
            if (this.f38945a.mo39946l()) {
                this.f38945a.f38823d.mo39496k();
            }
        } else if (currentPosition >= 3 * quartile && !this.f38945a.f38827h) {
            new C12279e().execute(new Vector[]{this.f38945a.f38820a.mo39692a("thirdQuartile")});
            this.f38945a.f38827h = true;
            if (this.f38945a.mo39946l()) {
                this.f38945a.f38823d.mo39497l();
            }
        }
        if (!this.f38945a.f38825f || !this.f38945a.f38826g || !this.f38945a.f38827h) {
            this.f38945a.f38821b.postDelayed(this, 1000);
        }
    }
}
