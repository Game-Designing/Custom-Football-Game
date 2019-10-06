package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.app.view.AppCoinsInfoView */
public interface AppCoinsInfoView extends View {
    C0120S<Void> appCoinsWalletLinkClick();

    C0120S<Void> cardViewClick();

    C0120S<Void> installButtonClick();

    void openApp(String str);

    void setButtonText(boolean z);
}
