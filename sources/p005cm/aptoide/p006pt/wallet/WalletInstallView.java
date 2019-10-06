package p005cm.aptoide.p006pt.wallet;

import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallView */
/* compiled from: WalletInstallView.kt */
public interface WalletInstallView extends View {
    C0120S<Void> cancelDownloadButtonClicked();

    C0120S<Void> closeButtonClicked();

    void dismissDialog();

    void showDownloadState(DownloadModel downloadModel);

    void showIndeterminateDownload();

    void showInstallationSuccessView();

    C0120S<Boolean> showRootInstallWarningPopup();

    void showSdkErrorView();

    void showWalletInstallationView(String str, WalletApp walletApp);

    void showWalletInstalledAlreadyView();
}
