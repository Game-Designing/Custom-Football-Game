package p005cm.aptoide.p006pt.home.apps;

import java.util.List;
import p005cm.aptoide.p006pt.home.AdHomeEvent;
import p005cm.aptoide.p006pt.home.AppHomeEvent;
import p005cm.aptoide.p006pt.home.HomeBundle;
import p005cm.aptoide.p006pt.home.HomeEvent;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.apps.BundleView */
public interface BundleView extends View {
    C0120S<AdHomeEvent> adClicked();

    C0120S<AppHomeEvent> appClicked();

    C0120S<HomeEvent> bundleScrolled();

    void hideLoading();

    void hideRefresh();

    void hideShowMore();

    C0120S<HomeEvent> moreClicked();

    C0120S<Object> reachesBottom();

    C0120S<Void> refreshes();

    C0120S<Void> retryClicked();

    void showBundles(List<HomeBundle> list);

    void showGenericError();

    void showLoadMore();

    void showLoading();

    void showMoreHomeBundles(List<HomeBundle> list);

    void showNetworkError();

    void updateEditorialCards();

    C0120S<HomeEvent> visibleBundles();
}
