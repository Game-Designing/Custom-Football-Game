package p019d.p135a.p136a.p138b;

import android.util.Log;
import p019d.p135a.p136a.p137a.C6852h;

/* 'enum' access flag removed */
/* renamed from: d.a.a.b.p */
/* compiled from: PaymentRequestState */
class C6871p extends C6874s {
    C6871p(String str, int i) {
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
        if (i == 12) {
            return C6874s.PROCESSED;
        }
        switch (i) {
            case 6:
                return C6874s.WAITING_FOR_PAYMENT_METHOD_DETAILS;
            case 7:
                return C6874s.PROCESSING_PAYMENT;
            case 8:
                return C6874s.PROCESSING_PAYMENT;
            case 9:
                return C6874s.WAITING_FOR_PAYMENT_METHOD_SELECTION;
            default:
                String str = C6852h.f12560a;
                StringBuilder sb = new StringBuilder();
                sb.append(toString());
                sb.append(" - Unknown trigger received: ");
                sb.append(paymentTrigger.toString());
                Log.d(str, sb.toString());
                return this;
        }
    }
}
