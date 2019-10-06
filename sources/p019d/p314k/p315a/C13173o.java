package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: d.k.a.o */
/* compiled from: FetchService */
class C13173o extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C13177s f40254a;

    C13173o(C13177s this$0) {
        this.f40254a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.f40254a.m43069g(C13167i.m43010a(intent));
        }
        if (this.f40254a.f40268h.size() == 0) {
            this.f40254a.m43083k();
            this.f40254a.f40264d.mo5312a((BroadcastReceiver) this);
            this.f40254a.f40267g.remove(this);
            this.f40254a.f40269i = false;
            this.f40254a.m43084l();
        }
    }
}
