package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: d.k.a.q */
/* compiled from: FetchService */
class C13175q extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ long f40257a;

    /* renamed from: b */
    final /* synthetic */ String f40258b;

    /* renamed from: c */
    final /* synthetic */ C13177s f40259c;

    C13175q(C13177s this$0, long j, String str) {
        this.f40259c = this$0;
        this.f40257a = j;
        this.f40258b = str;
    }

    public void onReceive(Context context, Intent intent) {
        long a = C13167i.m43010a(intent);
        long j = this.f40257a;
        if (a == j) {
            this.f40259c.m43044b(j, this.f40258b);
            this.f40259c.f40264d.mo5312a((BroadcastReceiver) this);
            this.f40259c.f40267g.remove(this);
            this.f40259c.f40269i = false;
            this.f40259c.m43084l();
        }
    }
}
