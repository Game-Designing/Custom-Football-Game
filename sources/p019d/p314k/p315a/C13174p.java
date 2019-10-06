package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: d.k.a.p */
/* compiled from: FetchService */
class C13174p extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ long f40255a;

    /* renamed from: b */
    final /* synthetic */ C13177s f40256b;

    C13174p(C13177s this$0, long j) {
        this.f40256b = this$0;
        this.f40255a = j;
    }

    public void onReceive(Context context, Intent intent) {
        long a = C13167i.m43010a(intent);
        long j = this.f40255a;
        if (a == j) {
            this.f40256b.m43069g(j);
            this.f40256b.f40264d.mo5312a((BroadcastReceiver) this);
            this.f40256b.f40267g.remove(this);
            this.f40256b.f40269i = false;
            this.f40256b.m43084l();
        }
    }
}
