package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: d.k.a.l */
/* compiled from: FetchService */
class C13170l extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ long f40249a;

    /* renamed from: b */
    final /* synthetic */ C13177s f40250b;

    C13170l(C13177s this$0, long j) {
        this.f40250b = this$0;
        this.f40249a = j;
    }

    public void onReceive(Context context, Intent intent) {
        long a = C13167i.m43010a(intent);
        long j = this.f40249a;
        if (a == j) {
            this.f40250b.m43053c(j);
            this.f40250b.f40264d.mo5312a((BroadcastReceiver) this);
            this.f40250b.f40267g.remove(this);
            this.f40250b.f40269i = false;
            this.f40250b.m43084l();
        }
    }
}
