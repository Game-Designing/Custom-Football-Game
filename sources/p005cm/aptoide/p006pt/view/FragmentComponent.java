package p005cm.aptoide.p006pt.view;

import p005cm.aptoide.p006pt.account.view.LoginSignUpCredentialsFragment;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment;
import p005cm.aptoide.p006pt.account.view.user.ManageUserFragment;
import p005cm.aptoide.p006pt.account.view.user.ProfileStepOneFragment;
import p005cm.aptoide.p006pt.account.view.user.ProfileStepTwoFragment;
import p005cm.aptoide.p006pt.app.view.AppCoinsInfoFragment;
import p005cm.aptoide.p006pt.app.view.AppViewFragment;
import p005cm.aptoide.p006pt.app.view.MoreBundleFragment;
import p005cm.aptoide.p006pt.billing.view.login.PaymentLoginFragment;
import p005cm.aptoide.p006pt.comments.view.CommentListFragment;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.editorialList.EditorialListFragment;
import p005cm.aptoide.p006pt.home.GetRewardAppCoinsAppsFragment;
import p005cm.aptoide.p006pt.home.HomeContainerFragment;
import p005cm.aptoide.p006pt.home.HomeFragment;
import p005cm.aptoide.p006pt.home.apps.AppsFragment;
import p005cm.aptoide.p006pt.home.apps.SeeMoreAppcFragment;
import p005cm.aptoide.p006pt.notification.view.InboxFragment;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionDialogFragment;
import p005cm.aptoide.p006pt.promotions.PromotionsFragment;
import p005cm.aptoide.p006pt.reviews.LatestReviewsFragment;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment;
import p005cm.aptoide.p006pt.search.view.SearchResultFragment;
import p005cm.aptoide.p006pt.store.view.FragmentTopStores;
import p005cm.aptoide.p006pt.store.view.ListStoresFragment;
import p005cm.aptoide.p006pt.store.view.StoreFragment;
import p005cm.aptoide.p006pt.store.view.StoreTabWidgetsGridRecyclerFragment;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresFragment;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresSubscribedFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowersFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowingFragment;
import p005cm.aptoide.p006pt.view.app.ListStoreAppsFragment;
import p005cm.aptoide.p006pt.view.fragment.DescriptionFragment;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment;
import p005cm.aptoide.p006pt.view.settings.SettingsFragment;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenFragment;
import p005cm.aptoide.p006pt.view.wizard.WizardFragment;
import p005cm.aptoide.p006pt.view.wizard.WizardFragmentProvider;
import p005cm.aptoide.p006pt.view.wizard.WizardPageTwoFragment;

@FragmentScope
/* renamed from: cm.aptoide.pt.view.FragmentComponent */
public interface FragmentComponent {
    void inject(LoginSignUpCredentialsFragment loginSignUpCredentialsFragment);

    void inject(ManageStoreFragment manageStoreFragment);

    void inject(ManageUserFragment manageUserFragment);

    void inject(ProfileStepOneFragment profileStepOneFragment);

    void inject(ProfileStepTwoFragment profileStepTwoFragment);

    void inject(AppCoinsInfoFragment appCoinsInfoFragment);

    void inject(AppViewFragment appViewFragment);

    void inject(MoreBundleFragment moreBundleFragment);

    void inject(PaymentLoginFragment paymentLoginFragment);

    void inject(CommentListFragment commentListFragment);

    void inject(EditorialFragment editorialFragment);

    void inject(EditorialListFragment editorialListFragment);

    void inject(GetRewardAppCoinsAppsFragment getRewardAppCoinsAppsFragment);

    void inject(HomeContainerFragment homeContainerFragment);

    void inject(HomeFragment homeFragment);

    void inject(AppsFragment appsFragment);

    void inject(SeeMoreAppcFragment seeMoreAppcFragment);

    void inject(InboxFragment inboxFragment);

    void inject(ClaimPromotionDialogFragment claimPromotionDialogFragment);

    void inject(PromotionsFragment promotionsFragment);

    void inject(LatestReviewsFragment latestReviewsFragment);

    void inject(RateAndReviewsFragment rateAndReviewsFragment);

    void inject(SearchResultFragment searchResultFragment);

    void inject(FragmentTopStores fragmentTopStores);

    void inject(ListStoresFragment listStoresFragment);

    void inject(StoreFragment storeFragment);

    void inject(StoreTabWidgetsGridRecyclerFragment storeTabWidgetsGridRecyclerFragment);

    void inject(MyStoresFragment myStoresFragment);

    void inject(MyStoresSubscribedFragment myStoresSubscribedFragment);

    void inject(TimeLineFollowersFragment timeLineFollowersFragment);

    void inject(TimeLineFollowingFragment timeLineFollowingFragment);

    void inject(ListStoreAppsFragment listStoreAppsFragment);

    void inject(DescriptionFragment descriptionFragment);

    void inject(GridRecyclerSwipeWithToolbarFragment gridRecyclerSwipeWithToolbarFragment);

    void inject(MyAccountFragment myAccountFragment);

    void inject(SettingsFragment settingsFragment);

    void inject(SplashScreenFragment splashScreenFragment);

    void inject(WizardFragment wizardFragment);

    void inject(WizardFragmentProvider wizardFragmentProvider);

    void inject(WizardPageTwoFragment wizardPageTwoFragment);
}
