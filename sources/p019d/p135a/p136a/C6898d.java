package p019d.p135a.p136a;

import android.util.Log;
import org.json.JSONException;
import p019d.p135a.p136a.p137a.C6846b;
import p019d.p135a.p136a.p138b.C6875t;
import p019d.p135a.p136a.p139c.C6897j;

/* renamed from: d.a.a.d */
/* compiled from: PaymentBroadcastReceivers */
class C6898d implements C6846b {

    /* renamed from: a */
    final /* synthetic */ C6918j f12675a;

    C6898d(C6918j this$0) {
        this.f12675a = this$0;
    }

    /* renamed from: a */
    public void mo22279a(byte[] paymentSetupData) {
        try {
            this.f12675a.f12698c.mo22384a(new C6897j(paymentSetupData));
            this.f12675a.f12698c.mo22391f().mo22283a(C6875t.PAYMENT_DATA_PROVIDED);
        } catch (JSONException jsonException) {
            String str = "Provided payment data response is invalid";
            Log.e(C6918j.f12696a, str, jsonException);
            this.f12675a.f12698c.mo22387b((Throwable) new Exception(str, jsonException));
        }
    }
}
