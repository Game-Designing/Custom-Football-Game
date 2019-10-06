package p005cm.aptoide.p006pt.promotions;

import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.promotions.PromotionsView */
public interface PromotionsView extends View {
    C0120S<PromotionViewApp> cancelDownload();

    C0120S<PromotionViewApp> claimAppClick();

    C0120S<PromotionViewApp> installButtonClick();

    void lockPromotionApps(boolean z);

    C0120S<PromotionViewApp> pauseDownload();

    C0120S<Void> promotionOverDialogClick();

    C0120S<PromotionViewApp> resumeDownload();

    C0120S<Void> retryClicked();

    void showAppCoinsAmount(int i);

    void showErrorView();

    void showLoading();

    void showPromotionApp(PromotionViewApp promotionViewApp, boolean z);

    void showPromotionFeatureGraphic(String str);

    void showPromotionOverDialog();

    void showPromotionTitle(String str);

    C0120S<Boolean> showRootInstallWarningPopup();

    void updateClaimStatus(String str);
}
