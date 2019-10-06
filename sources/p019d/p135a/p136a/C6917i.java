package p019d.p135a.p136a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.p000v4.content.C0515e;
import android.util.Log;
import p019d.p135a.p136a.p139c.p140a.C6881c;
import p019d.p135a.p136a.p139c.p140a.C6881c.C6883b;
import p019d.p135a.p136a.p139c.p140a.C6884d;

/* renamed from: d.a.a.i */
/* compiled from: PaymentBroadcastReceivers */
class C6917i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6918j f12695a;

    C6917i(C6918j this$0) {
        this.f12695a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        String androidPayToken = intent.getStringExtra("androidpay.token");
        String errorMessage = intent.getStringExtra("androidpay.error");
        if (errorMessage != null) {
            String a = C6918j.f12696a;
            StringBuilder sb = new StringBuilder();
            sb.append("androidPayInfoListener failed: ");
            sb.append(errorMessage);
            Log.e(a, sb.toString());
            this.f12695a.f12698c.mo22387b(new Throwable(errorMessage));
        } else {
            C6884d paymentDetails = new C6884d(this.f12695a.f12698c.mo22390e().mo22327b());
            if (androidPayToken != null) {
                for (C6881c inputDetail : paymentDetails.mo22319a()) {
                    if (inputDetail.mo22312e() == C6883b.AndroidPayToken) {
                        inputDetail.mo22307a(androidPayToken);
                    }
                }
            }
            this.f12695a.f12701f.mo22280a(paymentDetails);
        }
        C0515e.m2597a(context).mo5312a((BroadcastReceiver) this);
    }
}
