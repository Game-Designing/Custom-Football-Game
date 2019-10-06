package p005cm.aptoide.p006pt.home.apps;

import java.util.List;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.apps.AppsFragmentView */
public interface AppsFragmentView extends View {
    C0120S<App> cancelDownload();

    C0120S<AppClickEventWrapper> cancelUpdate();

    C0120S<App> cardClick();

    void hidePullToRefresh();

    C0120S<Void> ignoreUpdate();

    C0120S<Void> imageClick();

    C0120S<App> installApp();

    C0120S<Void> moreAppcClick();

    C0120S<Void> onLoadAppcUpgradesSection();

    C0120S<Void> onLoadUpdatesSection();

    C0120S<App> pauseDownload();

    C0120S<AppClickEventWrapper> pauseUpdate();

    C0120S<Void> refreshApps();

    void removeAppcCanceledAppDownload(App app);

    void removeCanceledAppDownload(App app);

    void removeExcludedAppcUpgrades(List<App> list);

    void removeExcludedUpdates(List<App> list);

    void removeInstalledDownloads(List<App> list);

    C0120S<App> resumeDownload();

    C0120S<AppClickEventWrapper> resumeUpdate();

    C0120S<App> retryDownload();

    C0120S<AppClickEventWrapper> retryUpdate();

    void scrollToTop();

    void setAppcPausingDownloadState(App app);

    void setAppcStandbyState(App app);

    void setDefaultUserImage();

    void setPausingDownloadState(App app);

    void setStandbyState(App app);

    void setUserImage(String str);

    void showAppcUpgradesDownloadList(List<App> list);

    void showAppcUpgradesList(List<App> list);

    void showAvatar();

    void showDownloadsList(List<App> list);

    void showIgnoreUpdate();

    void showIndeterminateAllUpdates();

    void showInstalledApps(List<App> list);

    C0120S<Boolean> showRootWarning();

    void showUnknownErrorMessage();

    void showUpdatesDownloadList(List<App> list);

    void showUpdatesList(List<App> list);

    C0120S<Void> updateAll();

    C0120S<AppClickEventWrapper> updateApp();

    C0120S<App> updateLongClick();
}
