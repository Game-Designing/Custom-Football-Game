package p005cm.aptoide.p006pt.billing.view.card;

import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.presenter.View;
import p019d.p135a.p136a.p139c.C6878a;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.p140a.C6884d;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.billing.view.card.CreditCardAuthorizationView */
public interface CreditCardAuthorizationView extends View {
    C0120S<Void> cancelEvent();

    C0120S<C6884d> creditCardDetailsEvent();

    C0120S<Void> errorDismisses();

    void hideLoading();

    void showCreditCardView(C6889d dVar, C6878a aVar, boolean z, boolean z2, String str, String str2);

    void showCvcView(C6878a aVar, C6889d dVar);

    void showLoading();

    void showNetworkError();

    void showProduct(Product product);
}
