package p005cm.aptoide.p006pt.app.view;

import android.util.Pair;
import android.view.MenuItem;
import java.util.List;
import p005cm.aptoide.p006pt.ads.MoPubInterstitialAdClickType;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.ReviewsViewModel;
import p005cm.aptoide.p006pt.app.view.donations.Donation;
import p005cm.aptoide.p006pt.app.view.screenshots.ScreenShotClickEvent;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppClickEvent;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundle;
import p005cm.aptoide.p006pt.appview.InstallAppView;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.app.DetailedAppRequestResult.Error;
import p005cm.aptoide.p006pt.view.app.FlagsVote.VoteType;
import p019d.p022i.p296a.p305c.C13045l;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.app.view.AppViewView */
public interface AppViewView extends InstallAppView {
    C0120S<MoPubInterstitialAdClickType> InterstitialAdClicked();

    C0120S<String> apkfyDialogPositiveClick();

    C0120S<WalletApp> cancelPromotionDownload();

    C0120S<Promotion> claimAppClick();

    C0120S<Void> clickDeveloperEmail();

    C0120S<Void> clickDeveloperPermissions();

    C0120S<Void> clickDeveloperPrivacy();

    C0120S<Void> clickDeveloperWebsite();

    C0120S<VoteType> clickFakeFlag();

    C0120S<Void> clickFollowStore();

    C0120S<Void> clickGenericRetry();

    C0120S<Void> clickGetAppcInfo();

    C0120S<VoteType> clickLicenseFlag();

    C0120S<Void> clickLoginSnack();

    C0120S<Void> clickNoNetworkRetry();

    C0120S<Void> clickOtherVersions();

    C0120S<Void> clickRateApp();

    C0120S<Void> clickRateAppLarge();

    C0120S<Void> clickRateAppLayout();

    C0120S<Void> clickReadAllReviews();

    C0120S<Void> clickReviewsLayout();

    C0120S<SimilarAppClickEvent> clickSimilarApp();

    C0120S<Void> clickStoreLayout();

    C0120S<MenuItem> clickToolbar();

    C0120S<Void> clickTopDonorsDonateButton();

    C0120S<Void> clickTrustedBadge();

    C0120S<VoteType> clickVirusFlag();

    C0120S<VoteType> clickWorkingFlag();

    C0120S<ReadMoreClickEvent> clickedReadMore();

    void defaultShare(String str, String str2);

    void disableFlags();

    C0120S<Promotion> dismissWalletPromotionClick();

    void dismissWalletPromotionView();

    void displayNotLoggedInSnack();

    void displayStoreFollowedSnack(String str);

    void enableFlags();

    void extractReferrer(SearchAdResult searchAdResult);

    String getLanguageFilter();

    C0120S<ScreenShotClickEvent> getScreenshotClickEvent();

    void handleError(Error error);

    void hideReviews();

    void hideSimilarApps();

    void incrementFlags(VoteType voteType);

    void initInterstitialAd();

    C0120S<Pair<Promotion, WalletApp>> installWalletButtonClick();

    C0120S<MoPubInterstitialAdClickType> interstitialAdLoaded();

    boolean isSimilarAppsVisible();

    void navigateToDeveloperEmail(AppViewViewModel appViewViewModel);

    void navigateToDeveloperPermissions(AppViewViewModel appViewViewModel);

    void navigateToDeveloperPrivacy(AppViewViewModel appViewViewModel);

    void navigateToDeveloperWebsite(AppViewViewModel appViewViewModel);

    C0120S<WalletApp> pausePromotionDownload();

    void populateReviews(ReviewsViewModel reviewsViewModel, AppViewViewModel appViewViewModel);

    void populateSimilar(List<SimilarAppsBundle> list);

    void recoverScrollViewState();

    C0120S<WalletApp> resumePromotionDownload();

    void scrollReviews(Integer num);

    C0120S<Integer> scrollReviewsResponse();

    C0120S<C13045l> scrollVisibleSimilarApps();

    void setFollowButton(boolean z);

    void setupAppcAppView();

    void showApkfyElement(String str);

    void showAppView(AppViewViewModel appViewViewModel);

    void showAppcWalletPromotionView(Promotion promotion, WalletApp walletApp, ClaimAction claimAction, DownloadModel downloadModel);

    void showBannerAd();

    void showConsentDialog();

    void showDonations(List<Donation> list);

    void showDownloadingSimilarApps(boolean z);

    void showFlagVoteSubmittedMessage();

    void showInterstitialAd();

    void showLoading();

    C0120S<Action> showOpenAndInstallApkFyDialog(String str, String str2, double d, float f, String str3, int i);

    C0120S<Action> showOpenAndInstallDialog(String str, String str2);

    C0120S<EResponse> showRateDialog(String str, String str2, String str3);

    void showShareOnTvDialog(long j);

    void showTrustedDialog(AppViewViewModel appViewViewModel);

    C0120S<Boolean> similarAppsVisibility();
}
