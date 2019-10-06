package p019d.p135a.p136a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: d.a.a.g */
/* compiled from: PaymentBroadcastReceivers */
class C6915g extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6918j f12693a;

    C6915g(C6918j this$0) {
        this.f12693a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        C6889d paymentMethod = (C6889d) intent.getSerializableExtra("PaymentMethod");
        String a = C6918j.f12696a;
        StringBuilder sb = new StringBuilder();
        sb.append("Payment Method Selected: ");
        sb.append(paymentMethod.mo22331e());
        Log.d(a, sb.toString());
        this.f12693a.f12699d.mo22282a(paymentMethod);
    }
}
