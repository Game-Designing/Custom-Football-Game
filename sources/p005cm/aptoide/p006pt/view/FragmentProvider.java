package p005cm.aptoide.p006pt.view;

import android.support.p000v4.app.Fragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.store.view.StoreFragment;

/* renamed from: cm.aptoide.pt.view.FragmentProvider */
public interface FragmentProvider {
    @Deprecated
    Fragment newAppViewFragment(long j, String str, String str2);

    @Deprecated
    Fragment newAppViewFragment(long j, String str, String str2, String str3, String str4);

    @Deprecated
    Fragment newAppViewFragment(long j, String str, String str2, String str3, String str4, String str5);

    @Deprecated
    Fragment newAppViewFragment(SearchAdResult searchAdResult, String str);

    @Deprecated
    Fragment newAppViewFragment(String str, OpenType openType);

    @Deprecated
    Fragment newDescriptionFragment(String str, String str2, String str3);

    @Deprecated
    Fragment newLatestReviewsFragment(long j, StoreContext storeContext);

    @Deprecated
    Fragment newRateAndReviewsFragment(long j, String str, String str2, String str3, long j2);

    @Deprecated
    Fragment newSettingsFragment();

    @Deprecated
    Fragment newStoreFragment(long j, String str, StoreFragment.OpenType openType);

    @Deprecated
    Fragment newStoreFragment(String str, String str2);

    @Deprecated
    Fragment newStoreFragment(String str, String str2, StoreFragment.OpenType openType);

    @Deprecated
    Fragment newStoreTabGridRecyclerFragment(Event event, String str, String str2, StoreContext storeContext, boolean z);

    @Deprecated
    Fragment newStoreTabGridRecyclerFragment(Event event, String str, String str2, String str3, StoreContext storeContext, boolean z);

    @Deprecated
    Fragment newSubscribedStoresFragment(Event event, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowersFragment(String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowersUsingStoreIdFragment(Long l, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowersUsingUserIdFragment(Long l, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowingFragmentUsingStoreId(Long l, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowingFragmentUsingUserId(Long l, String str, String str2, StoreContext storeContext);
}
