package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: d.k.a.n */
/* compiled from: FetchService */
class C13172n extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C13177s f40253a;

    C13172n(C13177s this$0) {
        this.f40253a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.f40253a.m43063e(C13167i.m43010a(intent));
        }
        if (this.f40253a.f40268h.size() == 0) {
            this.f40253a.m43077i();
            this.f40253a.f40264d.mo5312a((BroadcastReceiver) this);
            this.f40253a.f40267g.remove(this);
            this.f40253a.f40269i = false;
            this.f40253a.m43084l();
        }
    }
}
