package p019d.p273h.p276c;

import java.util.TimerTask;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;

/* renamed from: d.h.c.oa */
/* compiled from: RewardedVideoSmash */
class C12936oa extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C12938pa f39825a;

    C12936oa(C12938pa this$0) {
        this.f39825a = this$0;
    }

    public void run() {
        cancel();
        if (this.f39825a.f39832w != null) {
            C12802d dVar = this.f39825a.f39367r;
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append("Timeout for ");
            sb.append(this.f39825a.mo41398o());
            dVar.mo41427b(aVar, sb.toString(), 0);
            this.f39825a.mo41388a(C12792a.NOT_AVAILABLE);
            this.f39825a.f39832w.mo41647a(false, this.f39825a);
        }
    }
}
