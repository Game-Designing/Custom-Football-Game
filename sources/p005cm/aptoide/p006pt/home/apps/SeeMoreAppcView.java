package p005cm.aptoide.p006pt.home.apps;

import java.util.List;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.apps.SeeMoreAppcView */
interface SeeMoreAppcView extends View {
    C0120S<App> cancelAppcUpgrade();

    void hidePullToRefresh();

    C0120S<App> pauseAppcUpgrade();

    C0120S<Void> refreshApps();

    void removeAppcCanceledAppDownload(App app);

    C0120S<App> resumeAppcUpgrade();

    C0120S<App> retryAppcUpgrade();

    void setAppcPausingDownloadState(App app);

    void setAppcStandbyState(App app);

    void showAppcUpgradesDownloadList(List<App> list);

    void showAppcUpgradesList(List<App> list);

    C0120S<Boolean> showRootWarning();

    C0120S<App> upgradeAppcApp();
}
