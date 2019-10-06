package p005cm.aptoide.p006pt.billing.view.payment;

import java.util.List;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.billing.view.payment.PaymentView */
public interface PaymentView extends View {
    C0120S<Void> buyEvent();

    C0120S<Void> cancelEvent();

    void hideBuyLoading();

    void hidePaymentLoading();

    void hidePurchaseLoading();

    C0120S<String> selectServiceEvent();

    void showBuyLoading();

    void showNetworkError();

    void showPaymentLoading();

    void showPayments(List<PaymentService> list, PaymentService paymentService);

    void showPaymentsNotFoundMessage();

    void showProduct(Product product);

    void showPurchaseLoading();

    void showUnknownError();
}
