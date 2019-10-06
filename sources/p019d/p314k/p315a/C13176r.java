package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: d.k.a.r */
/* compiled from: FetchService */
class C13176r extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C13177s f40260a;

    C13176r(C13177s this$0) {
        this.f40260a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            long id = C13167i.m43010a(intent);
            if (this.f40260a.f40268h.containsKey(Long.valueOf(id))) {
                this.f40260a.f40268h.remove(Long.valueOf(id));
            }
            this.f40260a.m43084l();
        }
    }
}
