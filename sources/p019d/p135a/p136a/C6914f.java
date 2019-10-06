package p019d.p135a.p136a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: d.a.a.f */
/* compiled from: PaymentBroadcastReceivers */
class C6914f extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6918j f12692a;

    C6914f(C6918j this$0) {
        this.f12692a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        Log.d(C6918j.f12696a, "Payment Request Cancelled");
        this.f12692a.f12697b.mo22374a();
    }
}
