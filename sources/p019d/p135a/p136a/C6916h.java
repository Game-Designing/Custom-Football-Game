package p019d.p135a.p136a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p019d.p135a.p136a.p139c.p140a.C6884d;

/* renamed from: d.a.a.h */
/* compiled from: PaymentBroadcastReceivers */
class C6916h extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6918j f12694a;

    C6916h(C6918j this$0) {
        this.f12694a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        String str = "PaymentDetails";
        if (intent.hasExtra(str) && (intent.getSerializableExtra(str) instanceof C6884d)) {
            this.f12694a.f12701f.mo22280a((C6884d) intent.getSerializableExtra(str));
        }
    }
}
