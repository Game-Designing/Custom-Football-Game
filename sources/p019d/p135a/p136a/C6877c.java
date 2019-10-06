package p019d.p135a.p136a;

import p019d.p135a.p136a.p137a.C6849e;
import p019d.p135a.p136a.p138b.C6875t;
import p019d.p135a.p136a.p139c.C6889d;

/* renamed from: d.a.a.c */
/* compiled from: PaymentBroadcastReceivers */
class C6877c implements C6849e {

    /* renamed from: a */
    final /* synthetic */ C6918j f12598a;

    C6877c(C6918j this$0) {
        this.f12598a = this$0;
    }

    /* renamed from: a */
    public void mo22282a(C6889d selectedPaymentMethod) {
        this.f12598a.f12698c.mo22383a(selectedPaymentMethod);
        if (selectedPaymentMethod.mo22327b() == null || selectedPaymentMethod.mo22327b().isEmpty()) {
            this.f12598a.f12698c.mo22391f().mo22283a(C6875t.PAYMENT_DETAILS_NOT_REQUIRED);
        } else {
            this.f12598a.f12698c.mo22391f().mo22283a(C6875t.PAYMENT_DETAILS_REQUIRED);
        }
    }
}
