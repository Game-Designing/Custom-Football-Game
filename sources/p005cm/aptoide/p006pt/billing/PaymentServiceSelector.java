package p005cm.aptoide.p006pt.billing;

import java.util.List;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.billing.PaymentServiceSelector */
public interface PaymentServiceSelector {
    C0120S<PaymentService> getSelectedService(List<PaymentService> list);

    C0117M selectService(PaymentService paymentService);
}
