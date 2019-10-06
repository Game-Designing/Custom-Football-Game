package p005cm.aptoide.p006pt.home;

import p026rx.Single;

/* renamed from: cm.aptoide.pt.home.BundleDataSource */
public interface BundleDataSource {
    boolean hasMore(Integer num, String str);

    Single<HomeBundlesModel> loadFreshBundleForEvent(String str, String str2);

    Single<HomeBundlesModel> loadFreshHomeBundles(String str);

    Single<HomeBundlesModel> loadNextBundleForEvent(String str, int i, String str2, int i2);

    Single<HomeBundlesModel> loadNextHomeBundles(int i, int i2, String str);
}
