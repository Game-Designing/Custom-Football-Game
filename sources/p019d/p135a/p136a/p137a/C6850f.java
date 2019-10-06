package p019d.p135a.p136a.p137a;

import java.util.Collection;
import java.util.List;
import p019d.p135a.p136a.C6919k;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.p140a.C6881c;

/* renamed from: d.a.a.a.f */
/* compiled from: PaymentRequestDetailsListener */
public interface C6850f {
    void onPaymentDetailsRequired(C6919k kVar, Collection<C6881c> collection, C6847c cVar);

    void onPaymentMethodSelectionRequired(C6919k kVar, List<C6889d> list, List<C6889d> list2, C6849e eVar);

    void onRedirectRequired(C6919k kVar, String str, C6854i iVar);
}
