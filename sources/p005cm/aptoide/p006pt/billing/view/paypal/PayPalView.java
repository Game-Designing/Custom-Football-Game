package p005cm.aptoide.p006pt.billing.view.paypal;

import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.billing.view.paypal.PayPalView */
public interface PayPalView extends View {
    C0120S<Void> errorDismisses();

    void hideLoading();

    void showLoading();

    void showNetworkError();
}
