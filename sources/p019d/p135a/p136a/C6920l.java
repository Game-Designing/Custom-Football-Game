package p019d.p135a.p136a;

import java.util.Collections;
import java.util.List;
import p019d.p135a.p136a.p138b.C6875t;
import p019d.p135a.p136a.p139c.C6889d;
import p320f.p321a.p326c.C13204f;

/* renamed from: d.a.a.l */
/* compiled from: PaymentStateHandler */
class C6920l implements C13204f<List<C6889d>> {

    /* renamed from: a */
    final /* synthetic */ C6924p f12709a;

    C6920l(C6924p this$0) {
        this.f12709a = this$0;
    }

    /* renamed from: a */
    public void accept(List<C6889d> filteredPaymentMethods) {
        filteredPaymentMethods.removeAll(Collections.singleton(null));
        this.f12709a.f12725m.clear();
        this.f12709a.f12725m.addAll(filteredPaymentMethods);
        this.f12709a.f12727o.mo22283a(C6875t.PAYMENT_METHODS_AVAILABLE);
    }
}
