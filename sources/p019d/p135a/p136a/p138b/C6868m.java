package p019d.p135a.p136a.p138b;

import android.util.Log;
import p019d.p135a.p136a.p137a.C6852h;

/* 'enum' access flag removed */
/* renamed from: d.a.a.b.m */
/* compiled from: PaymentRequestState */
class C6868m extends C6874s {
    C6868m(String str, int i) {
        super(str, i, null);
    }

    /* renamed from: a */
    public C6852h mo22283a(C6875t paymentTrigger) {
        int i = C6864i.f12572a[paymentTrigger.ordinal()];
        if (i == 2) {
            return C6874s.ABORTED;
        }
        if (i == 4) {
            return C6874s.f12582j;
        }
        if (i == 6) {
            return C6874s.WAITING_FOR_PAYMENT_METHOD_DETAILS;
        }
        if (i == 7) {
            return C6874s.PROCESSING_PAYMENT;
        }
        String str = C6852h.f12560a;
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        sb.append(" - Unknown trigger received: ");
        sb.append(paymentTrigger.toString());
        Log.d(str, sb.toString());
        return this;
    }
}
