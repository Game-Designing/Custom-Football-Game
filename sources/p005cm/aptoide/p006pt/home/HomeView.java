package p005cm.aptoide.p006pt.home;

import p005cm.aptoide.p006pt.home.apps.BundleView;
import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.HomeView */
public interface HomeView extends BundleView {
    C0120S<HomeEvent> dismissBundleClicked();

    C0120S<EditorialHomeEvent> editorialCardClicked();

    void hideBundle(int i);

    C0120S<Void> imageClick();

    C0120S<HomeEvent> infoBundleKnowMoreClicked();

    C0120S<EditorialHomeEvent> reactionButtonLongPress();

    C0120S<ReactionsHomeEvent> reactionClicked();

    C0120S<EditorialHomeEvent> reactionsButtonClicked();

    void scrollToTop();

    void sendDeeplinkToWalletAppView(String str);

    void setAdsTest(boolean z);

    void setUserImage(String str);

    void showConsentDialog();

    void showGenericErrorToast();

    void showLogInDialog();

    void showNetworkErrorToast();

    void showReactionsPopup(String str, String str2, int i);

    C0120S<Void> snackLogInClick();

    C0120S<HomeEvent> walletOfferCardInstallWalletClick();
}
