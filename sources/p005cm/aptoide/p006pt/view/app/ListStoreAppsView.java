package p005cm.aptoide.p006pt.view.app;

import java.util.List;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.view.app.ListStoreAppsView */
public interface ListStoreAppsView extends View {
    void addApps(List<Application> list);

    C0120S<Application> getAppClick();

    C14963c<Void> getRefreshEvent();

    C0120S<Void> getRetryEvent();

    void hideLoading();

    void hideRefreshLoading();

    C0120S<Object> reachesBottom();

    void setApps(List<Application> list);

    void showGenericError();

    void showLoading();

    void showNetworkError();

    void showStartingLoading();
}
