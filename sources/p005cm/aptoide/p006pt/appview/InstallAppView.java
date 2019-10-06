package p005cm.aptoide.p006pt.appview;

import p005cm.aptoide.p006pt.app.DownloadAppViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.view.AppBoughClickEvent;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.appview.InstallAppView */
public interface InstallAppView extends View {
    C0120S<AppBoughClickEvent> appBought();

    C0120S<Void> cancelDownload();

    C0120S<Action> installAppClick();

    C0120S<Void> isAppViewReadyToDownload();

    void openApp(String str);

    C0120S<Void> pauseDownload();

    void readyToDownload();

    C0120S<Action> resumeDownload();

    C0120S<Boolean> showDowngradeMessage();

    void showDowngradingMessage();

    void showDownloadAppModel(DownloadAppViewModel downloadAppViewModel, boolean z);

    C0120S<Boolean> showRootInstallWarningPopup();
}
