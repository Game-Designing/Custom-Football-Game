package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: d.k.a.m */
/* compiled from: FetchService */
class C13171m extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ long f40251a;

    /* renamed from: b */
    final /* synthetic */ C13177s f40252b;

    C13171m(C13177s this$0, long j) {
        this.f40252b = this$0;
        this.f40251a = j;
    }

    public void onReceive(Context context, Intent intent) {
        long a = C13167i.m43010a(intent);
        long j = this.f40251a;
        if (a == j) {
            this.f40252b.m43063e(j);
            this.f40252b.f40264d.mo5312a((BroadcastReceiver) this);
            this.f40252b.f40267g.remove(this);
            this.f40252b.f40269i = false;
            this.f40252b.m43084l();
        }
    }
}
