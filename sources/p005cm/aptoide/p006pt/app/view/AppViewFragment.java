package p005cm.aptoide.p006pt.app.view;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0227b;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.C0486t;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.widget.ContentLoadingProgressBar;
import android.support.p000v4.widget.NestedScrollView;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.app.C0774m;
import android.support.p001v7.app.C0774m.C0775a;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;
import com.mopub.nativeads.MoPubRecyclerAdapter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.ads.MoPubBannerAdListener;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogView;
import p005cm.aptoide.p006pt.ads.MoPubInterstitialAdClickType;
import p005cm.aptoide.p006pt.ads.MoPubInterstitialAdListener;
import p005cm.aptoide.p006pt.app.AppBoughtReceiver;
import p005cm.aptoide.p006pt.app.AppCoinsAdvertisingModel;
import p005cm.aptoide.p006pt.app.AppReview;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadAppViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.app.ReviewsViewModel;
import p005cm.aptoide.p006pt.app.view.donations.Donation;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAdapter;
import p005cm.aptoide.p006pt.app.view.screenshots.ScreenShotClickEvent;
import p005cm.aptoide.p006pt.app.view.screenshots.ScreenshotsAdapter;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppClickEvent;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundle;
import p005cm.aptoide.p006pt.app.view.similar.SimilarAppsBundleAdapter;
import p005cm.aptoide.p006pt.billing.exception.BillingException;
import p005cm.aptoide.p006pt.billing.purchase.PaidAppPurchase;
import p005cm.aptoide.p006pt.billing.view.BillingActivity;
import p005cm.aptoide.p006pt.billing.view.PurchaseBundleMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Rank;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Stats;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.home.SnapToStartHelper;
import p005cm.aptoide.p006pt.install.view.remote.RemoteInstallDialog;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.permission.DialogPermissions;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.reviews.LanguageFilterHelper;
import p005cm.aptoide.p006pt.reviews.LanguageFilterHelper.LanguageFilter;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.util.AppUtils;
import p005cm.aptoide.p006pt.util.ReferrerUtils;
import p005cm.aptoide.p006pt.utils.AptoideUtils.HtmlU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ThreadU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p005cm.aptoide.p006pt.view.app.AppDeveloper;
import p005cm.aptoide.p006pt.view.app.AppFlags;
import p005cm.aptoide.p006pt.view.app.AppMedia;
import p005cm.aptoide.p006pt.view.app.AppRating;
import p005cm.aptoide.p006pt.view.app.DetailedAppRequestResult.Error;
import p005cm.aptoide.p006pt.view.app.FlagsVote;
import p005cm.aptoide.p006pt.view.app.FlagsVote.VoteType;
import p005cm.aptoide.p006pt.view.dialog.DialogBadgeV7;
import p005cm.aptoide.p006pt.view.dialog.DialogUtils;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p005cm.aptoide.p006pt.view.recycler.LinearLayoutManagerWithSmoothScroller;
import p019d.p022i.p296a.p298b.p301b.p302a.C13015d;
import p019d.p022i.p296a.p298b.p303c.p304a.C13026g;
import p019d.p022i.p296a.p305c.C13034a;
import p019d.p022i.p296a.p305c.C13045l;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14980ia;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p029i.C14978f;
import p026rx.p387a.p389b.C14522a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.app.view.AppViewFragment */
public class AppViewFragment extends NavigationTrackFragment implements AppViewView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int APPC_TRANSITION_MS = 1000;
    private static final String BADGE_DIALOG_TAG = "badgeDialog";
    private static final int CLAIM = 4;
    private static final int DOWNGRADE = 2;
    private static final int DOWNLOAD = 6;
    private static final int DOWNLOADING = 1;
    private static final int INSTALL = 3;
    private static final String KEY_SCROLL_Y = "y";
    private static final int PAY_APP_REQUEST_CODE = 12;
    private static final int UPDATE = 5;
    private Action action;
    private C0760a actionBar;
    private AdsRepository adsRepository;
    private C14963c<String> apkfyDialogConfirmSubject;
    private View apkfyElement;
    private C14963c<AppBoughClickEvent> appBought;
    private ImageView appIcon;
    private TextView appName;
    private AppViewAppcInfoViewHolder appcInfoView;
    private View appcMigrationWarningMessage;
    private TextView appcRewardValue;
    private View appcRewardView;
    private View appview;
    private TextView avgReviewScore;
    private RatingBar avgReviewScoreBar;
    private MoPubView bannerAd;
    private ImageView cancelDownload;
    private ImageView cancelWalletDownload;
    private View collapsingAppcBackground;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Inject
    MoPubConsentDialogView consentDialogView;
    private Factory converterFactory;
    private Button descriptionReadMore;
    private TextView descriptionText;
    @Inject
    DialogUtils dialogUtils;
    private DonationsAdapter donationsAdapter;
    private View donationsElement;
    private RecyclerView donationsList;
    private View donationsListEmptyState;
    private View donationsListLayout;
    private ProgressBar donationsProgress;
    private View downloadControlsLayout;
    private LinearLayout downloadInfoLayout;
    private ProgressBar downloadProgressBar;
    private TextView downloadProgressValue;
    private ProgressBar downloadWalletProgressBar;
    private TextView downloadWalletProgressValue;
    private TextView downloadsTop;
    private TextView emptyReviewTextView;
    private View emptyReviewsLayout;
    private C0137ja errorMessageSubscription;
    private View fakeAppLayout;
    private TextView fakeAppText;
    private View flagThisAppSection;
    private View flagsLayoutWrapper;
    private View genericErrorView;
    private View genericRetryButton;
    private C14963c<Void> genericRetryClick;
    private View goodAppLayoutWrapper;
    private OkHttpClient httpClient;
    private View infoEmail;
    private View infoPermissions;
    private View infoPrivacy;
    private View infoWebsite;
    private Button install;
    private C14963c<Action> installClickSubject;
    private TextView installStateText;
    private MoPubInterstitial interstitialAd;
    private C14963c<MoPubInterstitialAdClickType> interstitialClick;
    private TextView latestVersion;
    private TextView latestVersionTitle;
    private Button listDonateButton;
    private C14963c<Void> loginSnackClick;
    @Inject
    String marketName;
    private Menu menu;
    private TextView needsLicenceText;
    private View needsLicenseLayout;
    private View noNetworkErrorView;
    private View noNetworkRetryButton;
    private C14963c<Void> noNetworkRetryClick;
    @Inject
    DecimalFormat oneDecimalFormat;
    private TextView otherVersions;
    private ImageView pauseDownload;
    private ImageView pauseWalletDownload;
    @Inject
    AppViewPresenter presenter;
    private C14963c<PromotionEvent> promotionAppClick;
    private View promotionView;
    private PurchaseBundleMapper purchaseBundleMapper;
    private QManager qManager;
    private Button rateAppButton;
    private Button rateAppButtonLarge;
    private TextView ratingInfo;
    private View ratingLayout;
    private C14963c<ReadMoreClickEvent> readMoreClick;
    private C14963c<Void> ready;
    private ImageView resumeDownload;
    private ImageView resumeWalletDownload;
    private TextView reviewUsers;
    private TopReviewsAdapter reviewsAdapter;
    private C14963c<Integer> reviewsAutoScroll;
    private View reviewsLayout;
    private RecyclerView reviewsView;
    private TextView rewardAppLatestVersion;
    private C14963c<ScreenShotClickEvent> screenShotClick;
    private RecyclerView screenshots;
    private ScreenshotsAdapter screenshotsAdapter;
    private NestedScrollView scrollView;
    private int scrollViewY;
    private Button showAllReviewsButton;
    private C14963c<SimilarAppClickEvent> similarAppClick;
    private C14963c<Boolean> similarAppsVisibilitySubject;
    private View similarBottomPlaceholder;
    private View similarDownloadPlaceholder;
    private SimilarAppsBundleAdapter similarListAdapter;
    private RecyclerView similarListRecyclerView;
    private TextView sizeInfo;
    private TextView storeDownloads;
    private Button storeFollow;
    private TextView storeFollowers;
    private ImageView storeIcon;
    private View storeLayout;
    private TextView storeName;
    @Inject
    String theme;
    private Toolbar toolbar;
    private View topReviewsLayout;
    private ContentLoadingProgressBar topReviewsProgress;
    private ImageView trustedBadge;
    private View trustedLayout;
    private TextView trustedText;
    private View versionsLayout;
    private ProgressBar viewProgress;
    private View virusLayout;
    private TextView virusText;
    private View walletDownloadControlsLayout;
    private View walletPromotionButtonsLayout;
    private Button walletPromotionCancelButton;
    private Button walletPromotionClaimButton;
    private View walletPromotionClaimLayout;
    private Button walletPromotionDownloadButton;
    private View walletPromotionDownloadLayout;
    private ImageView walletPromotionIcon;
    private Button walletPromotionInstallDisableButton;
    private View walletPromotionInstallDisableLayout;
    private TextView walletPromotionMessage;
    private TextView walletPromotionTitle;
    private View workingWellLayout;
    private TextView workingWellText;

    /* renamed from: cm.aptoide.pt.app.view.AppViewFragment$2 */
    static /* synthetic */ class C17602 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState = new int[DownloadState.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank = new int[Rank.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error = new int[Error.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType = new int[VoteType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(2886370315460857377L, "cm/aptoide/pt/app/view/AppViewFragment$2", 54);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    $jacocoInit[12] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.OPEN.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.PAY.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.MIGRATE.ordinal()] = 6;
            $jacocoInit[11] = true;
            try {
                $jacocoInit[13] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.TRUSTED.ordinal()] = 1;
                $jacocoInit[14] = true;
            } catch (NoSuchFieldError e7) {
                try {
                    $jacocoInit[15] = true;
                } catch (NoSuchFieldError e8) {
                    try {
                        $jacocoInit[17] = true;
                    } catch (NoSuchFieldError e9) {
                        try {
                            $jacocoInit[19] = true;
                        } catch (NoSuchFieldError e10) {
                            $jacocoInit[21] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.WARNING.ordinal()] = 2;
            $jacocoInit[16] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.CRITICAL.ordinal()] = 3;
            $jacocoInit[18] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.UNKNOWN.ordinal()] = 4;
            $jacocoInit[20] = true;
            try {
                $jacocoInit[22] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ACTIVE.ordinal()] = 1;
                $jacocoInit[23] = true;
            } catch (NoSuchFieldError e11) {
                try {
                    $jacocoInit[24] = true;
                } catch (NoSuchFieldError e12) {
                    try {
                        $jacocoInit[26] = true;
                    } catch (NoSuchFieldError e13) {
                        try {
                            $jacocoInit[28] = true;
                        } catch (NoSuchFieldError e14) {
                            try {
                                $jacocoInit[30] = true;
                            } catch (NoSuchFieldError e15) {
                                try {
                                    $jacocoInit[32] = true;
                                } catch (NoSuchFieldError e16) {
                                    try {
                                        $jacocoInit[34] = true;
                                    } catch (NoSuchFieldError e17) {
                                        $jacocoInit[36] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.INDETERMINATE.ordinal()] = 2;
            $jacocoInit[25] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.PAUSE.ordinal()] = 3;
            $jacocoInit[27] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.COMPLETE.ordinal()] = 4;
            $jacocoInit[29] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ERROR.ordinal()] = 5;
            $jacocoInit[31] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.NOT_ENOUGH_STORAGE_ERROR.ordinal()] = 6;
            $jacocoInit[33] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.INSTALLING.ordinal()] = 7;
            $jacocoInit[35] = true;
            try {
                $jacocoInit[37] = true;
                $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[VoteType.GOOD.ordinal()] = 1;
                $jacocoInit[38] = true;
            } catch (NoSuchFieldError e18) {
                try {
                    $jacocoInit[39] = true;
                } catch (NoSuchFieldError e19) {
                    try {
                        $jacocoInit[41] = true;
                    } catch (NoSuchFieldError e20) {
                        try {
                            $jacocoInit[43] = true;
                        } catch (NoSuchFieldError e21) {
                            try {
                                $jacocoInit[45] = true;
                            } catch (NoSuchFieldError e22) {
                                $jacocoInit[47] = true;
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[VoteType.LICENSE.ordinal()] = 2;
            $jacocoInit[40] = true;
            $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[VoteType.FAKE.ordinal()] = 3;
            $jacocoInit[42] = true;
            $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[VoteType.VIRUS.ordinal()] = 4;
            $jacocoInit[44] = true;
            $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[VoteType.FREEZE.ordinal()] = 5;
            $jacocoInit[46] = true;
            try {
                $jacocoInit[48] = true;
                $SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error[Error.NETWORK.ordinal()] = 1;
                $jacocoInit[49] = true;
            } catch (NoSuchFieldError e23) {
                try {
                    $jacocoInit[50] = true;
                } catch (NoSuchFieldError e24) {
                    $jacocoInit[52] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error[Error.GENERIC.ordinal()] = 2;
            $jacocoInit[51] = true;
            $jacocoInit[53] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.AppViewFragment$BundleKeys */
    public enum BundleKeys {
        APP_ID,
        STORE_NAME,
        STORE_THEME,
        MINIMAL_AD,
        PACKAGE_NAME,
        SHOULD_INSTALL,
        MD5,
        UNAME,
        DOWNLOAD_CONVERSION_URL,
        APPC,
        EDITORS_CHOICE_POSITION,
        ORIGIN_TAG;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.app.view.AppViewFragment$OpenType */
    public enum OpenType {
        OPEN_ONLY,
        OPEN_AND_INSTALL,
        OPEN_WITH_INSTALL_POPUP,
        APK_FY_INSTALL_POPUP;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[6] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7085729322379684783L, "cm/aptoide/pt/app/view/AppViewFragment", 1003);
        $jacocoData = probes;
        return probes;
    }

    public AppViewFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ C14963c access$000(AppViewFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AppBoughClickEvent> cVar = x0.appBought;
        $jacocoInit[1002] = true;
        return cVar;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[2] = true;
        this.screenShotClick = C14963c.m46753p();
        $jacocoInit[3] = true;
        this.readMoreClick = C14963c.m46753p();
        $jacocoInit[4] = true;
        this.loginSnackClick = C14963c.m46753p();
        $jacocoInit[5] = true;
        this.similarAppClick = C14963c.m46753p();
        $jacocoInit[6] = true;
        this.ready = C14963c.m46753p();
        $jacocoInit[7] = true;
        this.reviewsAutoScroll = C14963c.m46753p();
        $jacocoInit[8] = true;
        this.noNetworkRetryClick = C14963c.m46753p();
        $jacocoInit[9] = true;
        this.genericRetryClick = C14963c.m46753p();
        $jacocoInit[10] = true;
        this.apkfyDialogConfirmSubject = C14963c.m46753p();
        $jacocoInit[11] = true;
        this.similarAppsVisibilitySubject = C14963c.m46753p();
        $jacocoInit[12] = true;
        this.appBought = C14963c.m46753p();
        $jacocoInit[13] = true;
        this.installClickSubject = C14963c.m46753p();
        $jacocoInit[14] = true;
        this.interstitialClick = C14963c.m46753p();
        $jacocoInit[15] = true;
        this.promotionAppClick = C14963c.m46753p();
        $jacocoInit[16] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[17] = true;
        this.qManager = application.getQManager();
        $jacocoInit[18] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[19] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[20] = true;
        this.purchaseBundleMapper = application.getPurchaseBundleMapper();
        $jacocoInit[21] = true;
        this.adsRepository = application.getAdsRepository();
        $jacocoInit[22] = true;
        setHasOptionsMenu(true);
        $jacocoInit[23] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[24] = true;
        this.scrollView = (NestedScrollView) view.findViewById(C1375R.C1376id.scroll_view_app);
        $jacocoInit[25] = true;
        this.noNetworkErrorView = view.findViewById(C1375R.C1376id.no_network_connection);
        $jacocoInit[26] = true;
        this.genericErrorView = view.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[27] = true;
        this.genericRetryButton = this.genericErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[28] = true;
        this.noNetworkRetryButton = this.noNetworkErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[29] = true;
        this.reviewsLayout = view.findViewById(C1375R.C1376id.reviews_layout);
        $jacocoInit[30] = true;
        this.downloadControlsLayout = view.findViewById(C1375R.C1376id.install_controls_layout);
        $jacocoInit[31] = true;
        this.noNetworkRetryButton.setOnClickListener(new C2061e(this));
        $jacocoInit[32] = true;
        this.genericRetryButton.setOnClickListener(new C1972Y(this));
        $jacocoInit[33] = true;
        this.appIcon = (ImageView) view.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[34] = true;
        this.trustedBadge = (ImageView) view.findViewById(C1375R.C1376id.trusted_badge);
        $jacocoInit[35] = true;
        this.appName = (TextView) view.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[36] = true;
        this.trustedLayout = view.findViewById(C1375R.C1376id.trusted_layout);
        $jacocoInit[37] = true;
        this.trustedText = (TextView) view.findViewById(C1375R.C1376id.trusted_text);
        $jacocoInit[38] = true;
        this.downloadsTop = (TextView) view.findViewById(C1375R.C1376id.header_downloads);
        $jacocoInit[39] = true;
        this.sizeInfo = (TextView) view.findViewById(C1375R.C1376id.header_size);
        $jacocoInit[40] = true;
        this.ratingInfo = (TextView) view.findViewById(C1375R.C1376id.header_rating);
        $jacocoInit[41] = true;
        this.appcRewardView = view.findViewById(C1375R.C1376id.appc_layout);
        $jacocoInit[42] = true;
        this.appcMigrationWarningMessage = view.findViewById(C1375R.C1376id.migration_warning);
        $jacocoInit[43] = true;
        this.appcRewardValue = (TextView) view.findViewById(C1375R.C1376id.appcoins_reward_message);
        $jacocoInit[44] = true;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1375R.C1376id.iap_appc_label);
        View view2 = this.appcRewardView;
        TextView textView = this.appcRewardValue;
        $jacocoInit[45] = true;
        this.appcInfoView = new AppViewAppcInfoViewHolder(linearLayout, view2, textView, (TextView) view2.findViewById(C1375R.C1376id.appc_billing_text_secondary));
        $jacocoInit[46] = true;
        this.versionsLayout = view.findViewById(C1375R.C1376id.versions_layout);
        $jacocoInit[47] = true;
        this.latestVersionTitle = (TextView) view.findViewById(C1375R.C1376id.latest_version_title);
        $jacocoInit[48] = true;
        this.latestVersion = (TextView) this.versionsLayout.findViewById(C1375R.C1376id.latest_version);
        $jacocoInit[49] = true;
        this.rewardAppLatestVersion = (TextView) view.findViewById(C1375R.C1376id.appview_reward_app_versions_element);
        $jacocoInit[50] = true;
        this.otherVersions = (TextView) view.findViewById(C1375R.C1376id.other_versions);
        $jacocoInit[51] = true;
        this.screenshots = (RecyclerView) view.findViewById(C1375R.C1376id.screenshots_list);
        RecyclerView recyclerView = this.screenshots;
        $jacocoInit[52] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        $jacocoInit[53] = true;
        recyclerView.setLayoutManager(linearLayoutManager);
        $jacocoInit[54] = true;
        this.screenshots.setNestedScrollingEnabled(false);
        $jacocoInit[55] = true;
        this.descriptionText = (TextView) view.findViewById(C1375R.C1376id.description_text);
        $jacocoInit[56] = true;
        this.descriptionReadMore = (Button) view.findViewById(C1375R.C1376id.description_see_more);
        $jacocoInit[57] = true;
        this.topReviewsProgress = (ContentLoadingProgressBar) view.findViewById(C1375R.C1376id.top_comments_progress);
        $jacocoInit[58] = true;
        this.ratingLayout = view.findViewById(C1375R.C1376id.rating_layout);
        $jacocoInit[59] = true;
        this.emptyReviewsLayout = view.findViewById(C1375R.C1376id.empty_reviews_layout);
        $jacocoInit[60] = true;
        this.topReviewsLayout = view.findViewById(C1375R.C1376id.comments_layout);
        $jacocoInit[61] = true;
        this.rateAppButtonLarge = (Button) view.findViewById(C1375R.C1376id.rate_this_button2);
        $jacocoInit[62] = true;
        this.emptyReviewTextView = (TextView) view.findViewById(C1375R.C1376id.empty_review_text);
        $jacocoInit[63] = true;
        this.reviewUsers = (TextView) view.findViewById(C1375R.C1376id.users_voted);
        $jacocoInit[64] = true;
        this.avgReviewScore = (TextView) view.findViewById(C1375R.C1376id.rating_value);
        $jacocoInit[65] = true;
        this.avgReviewScoreBar = (RatingBar) view.findViewById(C1375R.C1376id.rating_bar);
        $jacocoInit[66] = true;
        this.reviewsView = (RecyclerView) view.findViewById(C1375R.C1376id.top_comments_list);
        $jacocoInit[67] = true;
        this.rateAppButton = (Button) view.findViewById(C1375R.C1376id.rate_this_button);
        $jacocoInit[68] = true;
        this.showAllReviewsButton = (Button) view.findViewById(C1375R.C1376id.read_all_button);
        $jacocoInit[69] = true;
        this.apkfyElement = view.findViewById(C1375R.C1376id.apkfy_element);
        $jacocoInit[70] = true;
        this.flagThisAppSection = view.findViewById(C1375R.C1376id.flag_this_app_section);
        $jacocoInit[71] = true;
        this.goodAppLayoutWrapper = view.findViewById(C1375R.C1376id.good_app_layout);
        $jacocoInit[72] = true;
        this.flagsLayoutWrapper = view.findViewById(C1375R.C1376id.rating_flags_layout);
        $jacocoInit[73] = true;
        this.workingWellLayout = view.findViewById(C1375R.C1376id.working_well_layout);
        $jacocoInit[74] = true;
        this.needsLicenseLayout = view.findViewById(C1375R.C1376id.needs_licence_layout);
        $jacocoInit[75] = true;
        this.fakeAppLayout = view.findViewById(C1375R.C1376id.fake_app_layout);
        $jacocoInit[76] = true;
        this.virusLayout = view.findViewById(C1375R.C1376id.virus_layout);
        $jacocoInit[77] = true;
        this.donationsElement = view.findViewById(C1375R.C1376id.donations_element);
        $jacocoInit[78] = true;
        this.donationsList = (RecyclerView) view.findViewById(C1375R.C1376id.donations_list);
        $jacocoInit[79] = true;
        this.donationsListEmptyState = view.findViewById(C1375R.C1376id.donations_list_empty_state);
        $jacocoInit[80] = true;
        this.donationsProgress = (ProgressBar) view.findViewById(C1375R.C1376id.donations_progress);
        $jacocoInit[81] = true;
        this.donationsListLayout = view.findViewById(C1375R.C1376id.donations_list_layout);
        $jacocoInit[82] = true;
        this.listDonateButton = (Button) view.findViewById(C1375R.C1376id.donate_button);
        $jacocoInit[83] = true;
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        $jacocoInit[84] = true;
        this.donationsList.setLayoutManager(linearLayoutManager2);
        $jacocoInit[85] = true;
        this.workingWellText = (TextView) view.findViewById(C1375R.C1376id.working_well_count);
        $jacocoInit[86] = true;
        this.needsLicenceText = (TextView) view.findViewById(C1375R.C1376id.needs_licence_count);
        $jacocoInit[87] = true;
        this.fakeAppText = (TextView) view.findViewById(C1375R.C1376id.fake_app_count);
        $jacocoInit[88] = true;
        this.virusText = (TextView) view.findViewById(C1375R.C1376id.virus_count);
        $jacocoInit[89] = true;
        this.storeLayout = view.findViewById(C1375R.C1376id.store_uploaded_layout);
        $jacocoInit[90] = true;
        this.storeIcon = (ImageView) view.findViewById(C1375R.C1376id.store_icon);
        $jacocoInit[91] = true;
        this.storeName = (TextView) view.findViewById(C1375R.C1376id.store_name);
        $jacocoInit[92] = true;
        this.storeFollowers = (TextView) view.findViewById(C1375R.C1376id.user_count);
        $jacocoInit[93] = true;
        this.storeDownloads = (TextView) view.findViewById(C1375R.C1376id.download_count);
        $jacocoInit[94] = true;
        this.storeFollow = (Button) view.findViewById(C1375R.C1376id.follow_button);
        $jacocoInit[95] = true;
        this.similarListRecyclerView = (RecyclerView) view.findViewById(C1375R.C1376id.similar_list);
        $jacocoInit[96] = true;
        this.similarDownloadPlaceholder = view.findViewById(C1375R.C1376id.similar_download_placeholder);
        $jacocoInit[97] = true;
        this.similarBottomPlaceholder = view.findViewById(C1375R.C1376id.similar_bottom_placeholder);
        $jacocoInit[98] = true;
        this.infoWebsite = view.findViewById(C1375R.C1376id.website_label);
        $jacocoInit[99] = true;
        this.infoEmail = view.findViewById(C1375R.C1376id.email_label);
        $jacocoInit[100] = true;
        this.infoPrivacy = view.findViewById(C1375R.C1376id.privacy_policy_label);
        $jacocoInit[101] = true;
        this.infoPermissions = view.findViewById(C1375R.C1376id.permissions_label);
        $jacocoInit[102] = true;
        this.viewProgress = (ProgressBar) view.findViewById(C1375R.C1376id.appview_progress);
        $jacocoInit[103] = true;
        this.appview = view.findViewById(C1375R.C1376id.appview_full);
        $jacocoInit[104] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[105] = true;
        this.collapsingAppcBackground = view.findViewById(C1375R.C1376id.collapsing_appc_coins_background);
        $jacocoInit[106] = true;
        this.install = (Button) view.findViewById(C1375R.C1376id.appview_install_button);
        $jacocoInit[107] = true;
        this.downloadInfoLayout = (LinearLayout) view.findViewById(C1375R.C1376id.appview_transfer_info);
        $jacocoInit[108] = true;
        this.downloadProgressBar = (ProgressBar) view.findViewById(C1375R.C1376id.appview_download_progress_bar);
        $jacocoInit[109] = true;
        this.downloadProgressValue = (TextView) view.findViewById(C1375R.C1376id.appview_download_progress_number);
        $jacocoInit[110] = true;
        this.cancelDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_cancel_button);
        $jacocoInit[111] = true;
        this.resumeDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_resume_download);
        $jacocoInit[112] = true;
        this.pauseDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_pause_download);
        $jacocoInit[113] = true;
        this.installStateText = (TextView) view.findViewById(C1375R.C1376id.appview_download_download_state);
        $jacocoInit[114] = true;
        this.promotionView = view.findViewById(C1375R.C1376id.wallet_install_promotion);
        $jacocoInit[115] = true;
        this.walletPromotionTitle = (TextView) this.promotionView.findViewById(C1375R.C1376id.wallet_title);
        $jacocoInit[116] = true;
        this.walletPromotionMessage = (TextView) this.promotionView.findViewById(C1375R.C1376id.wallet_message);
        $jacocoInit[117] = true;
        this.walletPromotionButtonsLayout = this.promotionView.findViewById(C1375R.C1376id.buttons_layout);
        $jacocoInit[118] = true;
        this.walletPromotionCancelButton = (Button) this.promotionView.findViewById(C1375R.C1376id.cancel_button);
        $jacocoInit[119] = true;
        this.walletPromotionDownloadButton = (Button) this.promotionView.findViewById(C1375R.C1376id.download_button);
        $jacocoInit[120] = true;
        this.walletPromotionDownloadLayout = view.findViewById(C1375R.C1376id.wallet_download_info);
        View view3 = this.walletPromotionDownloadLayout;
        $jacocoInit[121] = true;
        this.downloadWalletProgressBar = (ProgressBar) view3.findViewById(C1375R.C1376id.wallet_download_progress_bar);
        View view4 = this.walletPromotionDownloadLayout;
        $jacocoInit[122] = true;
        this.downloadWalletProgressValue = (TextView) view4.findViewById(C1375R.C1376id.wallet_download_progress_number);
        View view5 = this.walletPromotionDownloadLayout;
        $jacocoInit[123] = true;
        this.cancelWalletDownload = (ImageView) view5.findViewById(C1375R.C1376id.wallet_download_cancel_button);
        View view6 = this.walletPromotionDownloadLayout;
        $jacocoInit[124] = true;
        this.pauseWalletDownload = (ImageView) view6.findViewById(C1375R.C1376id.wallet_download_pause_download);
        View view7 = this.walletPromotionDownloadLayout;
        $jacocoInit[125] = true;
        this.resumeWalletDownload = (ImageView) view7.findViewById(C1375R.C1376id.wallet_download_resume_download);
        $jacocoInit[126] = true;
        this.walletPromotionClaimLayout = view.findViewById(C1375R.C1376id.wallet_claim_appc_layout);
        $jacocoInit[127] = true;
        this.walletPromotionIcon = (ImageView) view.findViewById(C1375R.C1376id.wallet_icon);
        $jacocoInit[128] = true;
        this.walletPromotionClaimButton = (Button) view.findViewById(C1375R.C1376id.wallet_claim_appc_button);
        $jacocoInit[129] = true;
        this.walletDownloadControlsLayout = view.findViewById(C1375R.C1376id.wallet_install_controls_layout);
        $jacocoInit[130] = true;
        this.walletPromotionInstallDisableLayout = view.findViewById(C1375R.C1376id.wallet_install_disabled_layout);
        $jacocoInit[131] = true;
        this.walletPromotionInstallDisableButton = (Button) view.findViewById(C1375R.C1376id.wallet_install_disabled_button);
        $jacocoInit[132] = true;
        this.donationsAdapter = new DonationsAdapter(new ArrayList());
        $jacocoInit[133] = true;
        this.donationsList.setAdapter(this.donationsAdapter);
        $jacocoInit[134] = true;
        this.screenshotsAdapter = new ScreenshotsAdapter(new ArrayList(), new ArrayList(), this.screenShotClick);
        $jacocoInit[135] = true;
        this.screenshots.setAdapter(this.screenshotsAdapter);
        $jacocoInit[136] = true;
        LinearLayoutManagerWithSmoothScroller layoutManager = new LinearLayoutManagerWithSmoothScroller(getContext(), 0, false);
        $jacocoInit[137] = true;
        LinearLayoutManager similarBundlesLayout = new LinearLayoutManager(getContext(), 1, false);
        $jacocoInit[138] = true;
        this.similarListRecyclerView.setLayoutManager(similarBundlesLayout);
        $jacocoInit[139] = true;
        this.similarListRecyclerView.setNestedScrollingEnabled(false);
        $jacocoInit[140] = true;
        setSimilarAppsAdapters();
        $jacocoInit[141] = true;
        this.reviewsView.setLayoutManager(layoutManager);
        $jacocoInit[142] = true;
        this.reviewsView.setNestedScrollingEnabled(false);
        $jacocoInit[143] = true;
        SnapToStartHelper snapToStartHelper = new SnapToStartHelper();
        $jacocoInit[144] = true;
        SnapToStartHelper snapToStartHelper2 = new SnapToStartHelper();
        $jacocoInit[145] = true;
        snapToStartHelper.attachToRecyclerView(this.reviewsView);
        $jacocoInit[146] = true;
        snapToStartHelper2.attachToRecyclerView(this.screenshots);
        $jacocoInit[147] = true;
        setupToolbar();
        $jacocoInit[148] = true;
        ((AppBarLayout) view.findViewById(C1375R.C1376id.app_bar_layout)).mo4186a((C0227b) new C1762B(this, view));
        if (savedInstanceState == null) {
            $jacocoInit[149] = true;
        } else {
            $jacocoInit[150] = true;
            this.scrollViewY = savedInstanceState.getInt("y", 0);
            $jacocoInit[151] = true;
        }
        $jacocoInit[152] = true;
        this.collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(C1375R.C1376id.collapsing_toolbar_layout);
        CollapsingToolbarLayout collapsingToolbarLayout2 = this.collapsingToolbarLayout;
        $jacocoInit[153] = true;
        int color = getResources().getColor(17170445);
        $jacocoInit[154] = true;
        collapsingToolbarLayout2.setExpandedTitleColor(color);
        $jacocoInit[155] = true;
        this.bannerAd = (MoPubView) view.findViewById(C1375R.C1376id.mopub_banner);
        $jacocoInit[156] = true;
        attachPresenter(this.presenter);
        $jacocoInit[157] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10417b(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.noNetworkRetryClick.onNext(null);
        $jacocoInit[1001] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10420c(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericRetryClick.onNext(null);
        $jacocoInit[1000] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10408a(View view, AppBarLayout appBarLayout, int verticalOffset) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[992] = true;
        float percentage = ((float) Math.abs(verticalOffset)) / ((float) appBarLayout.getTotalScrollRange());
        $jacocoInit[993] = true;
        View findViewById = view.findViewById(C1375R.C1376id.app_icon);
        float f = 1.0f - (percentage * 1.2f);
        $jacocoInit[994] = true;
        findViewById.setAlpha(f);
        $jacocoInit[995] = true;
        View findViewById2 = view.findViewById(C1375R.C1376id.app_name);
        float f2 = 1.0f - (1.2f * percentage);
        $jacocoInit[996] = true;
        findViewById2.setAlpha(f2);
        $jacocoInit[997] = true;
        ((ToolbarArcBackground) view.findViewById(C1375R.C1376id.toolbar_background_arc)).setScale(percentage);
        $jacocoInit[998] = true;
        this.collapsingAppcBackground.setAlpha(1.0f - percentage);
        $jacocoInit[999] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[158] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[159] = true;
        String string = getArguments().getString(BundleKeys.ORIGIN_TAG.name(), "");
        String name = StoreContext.meta.name();
        $jacocoInit[160] = true;
        ScreenTagHistory build = Builder.build("AppViewFragment", string, name);
        $jacocoInit[161] = true;
        return build;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[162] = true;
        C0137ja jaVar = this.errorMessageSubscription;
        if (jaVar == null) {
            $jacocoInit[163] = true;
        } else if (jaVar.isUnsubscribed()) {
            $jacocoInit[164] = true;
        } else {
            $jacocoInit[165] = true;
            this.errorMessageSubscription.unsubscribe();
            $jacocoInit[166] = true;
        }
        this.screenShotClick = null;
        this.readMoreClick = null;
        this.loginSnackClick = null;
        this.similarAppClick = null;
        this.ready = null;
        this.reviewsAutoScroll = null;
        this.noNetworkRetryClick = null;
        this.genericRetryClick = null;
        this.dialogUtils = null;
        this.presenter = null;
        this.similarAppsVisibilitySubject = null;
        this.interstitialClick = null;
        $jacocoInit[167] = true;
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu2, inflater);
        this.menu = menu2;
        $jacocoInit[168] = true;
        inflater.inflate(C1375R.C1377menu.fragment_appview, menu2);
        $jacocoInit[169] = true;
        showHideOptionsMenu(true);
        $jacocoInit[170] = true;
    }

    private void destroyAdapter(MoPubRecyclerAdapter adapter) {
        boolean[] $jacocoInit = $jacocoInit();
        if (adapter == null) {
            $jacocoInit[171] = true;
        } else {
            $jacocoInit[172] = true;
            adapter.destroy();
            $jacocoInit[173] = true;
        }
        $jacocoInit[174] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        $jacocoInit[175] = true;
        this.scrollViewY = this.scrollView.getScrollY();
        this.noNetworkErrorView = null;
        this.genericErrorView = null;
        this.genericRetryButton = null;
        this.noNetworkRetryButton = null;
        this.appIcon = null;
        this.trustedBadge = null;
        this.appName = null;
        this.trustedLayout = null;
        this.trustedText = null;
        this.downloadsTop = null;
        this.sizeInfo = null;
        this.ratingInfo = null;
        this.appcRewardView = null;
        this.appcRewardValue = null;
        this.latestVersion = null;
        this.otherVersions = null;
        this.screenshots = null;
        this.descriptionText = null;
        this.reviewsAdapter = null;
        this.descriptionReadMore = null;
        this.topReviewsProgress = null;
        this.ratingLayout = null;
        this.emptyReviewsLayout = null;
        this.topReviewsLayout = null;
        this.rateAppButtonLarge = null;
        this.emptyReviewTextView = null;
        this.reviewUsers = null;
        this.avgReviewScore = null;
        this.avgReviewScoreBar = null;
        this.reviewsView = null;
        this.rateAppButton = null;
        this.showAllReviewsButton = null;
        this.goodAppLayoutWrapper = null;
        this.flagsLayoutWrapper = null;
        this.workingWellLayout = null;
        this.needsLicenseLayout = null;
        this.fakeAppLayout = null;
        this.virusLayout = null;
        this.workingWellText = null;
        this.needsLicenceText = null;
        this.fakeAppText = null;
        this.virusText = null;
        this.storeLayout = null;
        this.storeIcon = null;
        this.storeName = null;
        this.storeFollowers = null;
        this.storeDownloads = null;
        this.storeFollow = null;
        this.infoWebsite = null;
        this.infoEmail = null;
        this.infoPrivacy = null;
        this.infoPermissions = null;
        this.viewProgress = null;
        this.appview = null;
        this.screenshotsAdapter = null;
        this.menu = null;
        this.toolbar = null;
        this.actionBar = null;
        this.scrollView = null;
        this.collapsingToolbarLayout = null;
        this.donationsAdapter = null;
        this.donationsElement = null;
        this.donationsList = null;
        this.interstitialAd = null;
        MoPubView moPubView = this.bannerAd;
        if (moPubView == null) {
            $jacocoInit[176] = true;
        } else {
            $jacocoInit[177] = true;
            moPubView.destroy();
            this.bannerAd = null;
            $jacocoInit[178] = true;
        }
        $jacocoInit[179] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.viewProgress.setVisibility(0);
        $jacocoInit[180] = true;
        this.appview.setVisibility(8);
        $jacocoInit[181] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[182] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[183] = true;
    }

    public void showAppView(AppViewViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        this.collapsingToolbarLayout.setTitle(model.getAppName());
        $jacocoInit[184] = true;
        this.appName.setText(model.getAppName());
        $jacocoInit[185] = true;
        ImageLoader with = ImageLoader.with(getContext());
        $jacocoInit[186] = true;
        with.load(model.getIcon(), this.appIcon);
        TextView textView = this.downloadsTop;
        $jacocoInit[187] = true;
        String str = "%s";
        String format = String.format(str, new Object[]{StringU.withSuffix((long) model.getPackageDownloads())});
        $jacocoInit[188] = true;
        textView.setText(format);
        $jacocoInit[189] = true;
        this.sizeInfo.setText(StringU.formatBytes(model.getSize(), false));
        $jacocoInit[190] = true;
        AppRating rating = model.getRating();
        $jacocoInit[191] = true;
        if (rating.getAverage() == 0.0f) {
            $jacocoInit[192] = true;
            this.ratingInfo.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[193] = true;
        } else {
            TextView textView2 = this.ratingInfo;
            DecimalFormat decimalFormat = this.oneDecimalFormat;
            AppRating rating2 = model.getRating();
            $jacocoInit[194] = true;
            double average = (double) rating2.getAverage();
            $jacocoInit[195] = true;
            textView2.setText(decimalFormat.format(average));
            $jacocoInit[196] = true;
        }
        if (getArguments().getFloat(BundleKeys.APPC.name(), -1.0f) != -1.0f) {
            $jacocoInit[197] = true;
            this.versionsLayout.setVisibility(8);
            $jacocoInit[198] = true;
            this.rewardAppLatestVersion.setVisibility(0);
            $jacocoInit[199] = true;
            String versionName = model.getVersionName();
            $jacocoInit[200] = true;
            String message = String.format(getResources().getString(C1375R.string.appview_latest_version_with_value), new Object[]{versionName});
            $jacocoInit[201] = true;
            SpannableString spannable = new SpannableString(message);
            $jacocoInit[202] = true;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(C1375R.color.grey_medium));
            $jacocoInit[203] = true;
            int indexOf = message.indexOf(versionName);
            int indexOf2 = message.indexOf(versionName) + versionName.length();
            $jacocoInit[204] = true;
            spannable.setSpan(foregroundColorSpan, indexOf, indexOf2, 33);
            $jacocoInit[205] = true;
            this.rewardAppLatestVersion.setText(spannable);
            $jacocoInit[206] = true;
        } else {
            this.latestVersion.setText(model.getVersionName());
            $jacocoInit[207] = true;
            if (model.isLatestTrustedVersion()) {
                $jacocoInit[208] = true;
            } else {
                $jacocoInit[209] = true;
                this.latestVersionTitle.setText(getString(C1375R.string.appview_version_text));
                $jacocoInit[210] = true;
                this.otherVersions.setText(getString(C1375R.string.newer_version_available));
                $jacocoInit[211] = true;
            }
        }
        TextView textView3 = this.storeName;
        Store store = model.getStore();
        $jacocoInit[212] = true;
        String name = store.getName();
        $jacocoInit[213] = true;
        textView3.setText(name);
        $jacocoInit[214] = true;
        ImageLoader with2 = ImageLoader.with(getContext());
        $jacocoInit[215] = true;
        Store store2 = model.getStore();
        $jacocoInit[216] = true;
        String avatar = store2.getAvatar();
        ImageView imageView = this.storeIcon;
        $jacocoInit[217] = true;
        with2.loadWithShadowCircleTransform(avatar, imageView);
        $jacocoInit[218] = true;
        TextView textView4 = this.storeDownloads;
        Store store3 = model.getStore();
        $jacocoInit[219] = true;
        Stats stats = store3.getStats();
        $jacocoInit[220] = true;
        long downloads = stats.getDownloads();
        $jacocoInit[221] = true;
        textView4.setText(String.format(str, new Object[]{StringU.withSuffix(downloads)}));
        $jacocoInit[222] = true;
        TextView textView5 = this.storeFollowers;
        Store store4 = model.getStore();
        $jacocoInit[223] = true;
        Stats stats2 = store4.getStats();
        $jacocoInit[224] = true;
        long subscribers = (long) stats2.getSubscribers();
        $jacocoInit[225] = true;
        textView5.setText(String.format(str, new Object[]{StringU.withSuffix(subscribers)}));
        $jacocoInit[226] = true;
        if (model.isStoreFollowed()) {
            $jacocoInit[227] = true;
            this.storeFollow.setText(C1375R.string.followed);
            $jacocoInit[228] = true;
        } else {
            this.storeFollow.setText(C1375R.string.follow);
            $jacocoInit[229] = true;
        }
        if (!model.hasDonations()) {
            $jacocoInit[230] = true;
        } else {
            $jacocoInit[231] = true;
            this.donationsElement.setVisibility(0);
            $jacocoInit[232] = true;
            this.donationsListLayout.setVisibility(0);
            $jacocoInit[233] = true;
        }
        AppMedia media = model.getMedia();
        $jacocoInit[234] = true;
        if (media.getScreenshots() == null) {
            $jacocoInit[235] = true;
        } else {
            AppMedia media2 = model.getMedia();
            $jacocoInit[236] = true;
            List screenshots2 = media2.getScreenshots();
            $jacocoInit[237] = true;
            if (!screenshots2.isEmpty()) {
                $jacocoInit[238] = true;
                ScreenshotsAdapter screenshotsAdapter2 = this.screenshotsAdapter;
                AppMedia media3 = model.getMedia();
                $jacocoInit[246] = true;
                List screenshots3 = media3.getScreenshots();
                $jacocoInit[247] = true;
                screenshotsAdapter2.updateScreenshots(screenshots3);
                $jacocoInit[248] = true;
                ScreenshotsAdapter screenshotsAdapter3 = this.screenshotsAdapter;
                AppMedia media4 = model.getMedia();
                $jacocoInit[249] = true;
                List videos = media4.getVideos();
                $jacocoInit[250] = true;
                screenshotsAdapter3.updateVideos(videos);
                $jacocoInit[251] = true;
                setTrustedBadge(model.getMalware());
                $jacocoInit[253] = true;
                AppMedia media5 = model.getMedia();
                $jacocoInit[254] = true;
                String description = media5.getDescription();
                $jacocoInit[255] = true;
                setDescription(description);
                $jacocoInit[256] = true;
                setAppFlags(model.isGoodApp(), model.getAppFlags());
                $jacocoInit[257] = true;
                setReadMoreClickListener(model.getAppName(), model.getMedia(), model.getStore());
                $jacocoInit[258] = true;
                setDeveloperDetails(model.getDeveloper());
                $jacocoInit[259] = true;
                showAppViewLayout();
                $jacocoInit[260] = true;
                this.downloadInfoLayout.setVisibility(8);
                $jacocoInit[261] = true;
                this.install.setVisibility(0);
                $jacocoInit[262] = true;
                this.install.setOnClickListener(new C2188r(this));
                $jacocoInit[263] = true;
            }
            $jacocoInit[239] = true;
        }
        AppMedia media6 = model.getMedia();
        $jacocoInit[240] = true;
        if (media6.getVideos() == null) {
            $jacocoInit[241] = true;
        } else {
            AppMedia media7 = model.getMedia();
            $jacocoInit[242] = true;
            List videos2 = media7.getVideos();
            $jacocoInit[243] = true;
            if (videos2.isEmpty()) {
                $jacocoInit[244] = true;
            } else {
                $jacocoInit[245] = true;
                ScreenshotsAdapter screenshotsAdapter22 = this.screenshotsAdapter;
                AppMedia media32 = model.getMedia();
                $jacocoInit[246] = true;
                List screenshots32 = media32.getScreenshots();
                $jacocoInit[247] = true;
                screenshotsAdapter22.updateScreenshots(screenshots32);
                $jacocoInit[248] = true;
                ScreenshotsAdapter screenshotsAdapter32 = this.screenshotsAdapter;
                AppMedia media42 = model.getMedia();
                $jacocoInit[249] = true;
                List videos3 = media42.getVideos();
                $jacocoInit[250] = true;
                screenshotsAdapter32.updateVideos(videos3);
                $jacocoInit[251] = true;
                setTrustedBadge(model.getMalware());
                $jacocoInit[253] = true;
                AppMedia media52 = model.getMedia();
                $jacocoInit[254] = true;
                String description2 = media52.getDescription();
                $jacocoInit[255] = true;
                setDescription(description2);
                $jacocoInit[256] = true;
                setAppFlags(model.isGoodApp(), model.getAppFlags());
                $jacocoInit[257] = true;
                setReadMoreClickListener(model.getAppName(), model.getMedia(), model.getStore());
                $jacocoInit[258] = true;
                setDeveloperDetails(model.getDeveloper());
                $jacocoInit[259] = true;
                showAppViewLayout();
                $jacocoInit[260] = true;
                this.downloadInfoLayout.setVisibility(8);
                $jacocoInit[261] = true;
                this.install.setVisibility(0);
                $jacocoInit[262] = true;
                this.install.setOnClickListener(new C2188r(this));
                $jacocoInit[263] = true;
            }
        }
        this.screenshots.setVisibility(8);
        $jacocoInit[252] = true;
        setTrustedBadge(model.getMalware());
        $jacocoInit[253] = true;
        AppMedia media522 = model.getMedia();
        $jacocoInit[254] = true;
        String description22 = media522.getDescription();
        $jacocoInit[255] = true;
        setDescription(description22);
        $jacocoInit[256] = true;
        setAppFlags(model.isGoodApp(), model.getAppFlags());
        $jacocoInit[257] = true;
        setReadMoreClickListener(model.getAppName(), model.getMedia(), model.getStore());
        $jacocoInit[258] = true;
        setDeveloperDetails(model.getDeveloper());
        $jacocoInit[259] = true;
        showAppViewLayout();
        $jacocoInit[260] = true;
        this.downloadInfoLayout.setVisibility(8);
        $jacocoInit[261] = true;
        this.install.setVisibility(0);
        $jacocoInit[262] = true;
        this.install.setOnClickListener(new C2188r(this));
        $jacocoInit[263] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo10451d(View click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installClickSubject.onNext(this.action);
        $jacocoInit[991] = true;
    }

    public void handleError(Error error) {
        boolean[] $jacocoInit = $jacocoInit();
        this.viewProgress.setVisibility(8);
        $jacocoInit[264] = true;
        int i = C17602.$SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error[error.ordinal()];
        if (i == 1) {
            this.noNetworkErrorView.setVisibility(0);
            $jacocoInit[266] = true;
        } else if (i != 2) {
            $jacocoInit[265] = true;
        } else {
            this.genericErrorView.setVisibility(0);
            $jacocoInit[267] = true;
        }
        $jacocoInit[268] = true;
    }

    public C0120S<ScreenShotClickEvent> getScreenshotClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<ScreenShotClickEvent> cVar = this.screenShotClick;
        $jacocoInit[269] = true;
        return cVar;
    }

    public C0120S<ReadMoreClickEvent> clickedReadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<ReadMoreClickEvent> cVar = this.readMoreClick;
        $jacocoInit[270] = true;
        return cVar;
    }

    public void populateReviews(ReviewsViewModel reviewsModel, AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppReview> reviews = reviewsModel.getReviewsList();
        $jacocoInit[271] = true;
        if (reviews == null) {
            $jacocoInit[272] = true;
        } else if (reviews.isEmpty()) {
            $jacocoInit[273] = true;
        } else {
            $jacocoInit[274] = true;
            AppRating rating = app.getRating();
            $jacocoInit[275] = true;
            int total = rating.getTotal();
            AppRating rating2 = app.getRating();
            $jacocoInit[276] = true;
            float average = rating2.getAverage();
            $jacocoInit[277] = true;
            showReviews(true, total, average);
            $jacocoInit[278] = true;
            this.reviewsAdapter = new TopReviewsAdapter((AppReview[]) reviews.toArray(new AppReview[reviews.size()]));
            $jacocoInit[279] = true;
            this.reviewsView.setAdapter(this.reviewsAdapter);
            $jacocoInit[285] = true;
            this.reviewsAutoScroll.onNext(Integer.valueOf(this.reviewsAdapter.getItemCount()));
            $jacocoInit[286] = true;
        }
        AppRating rating3 = app.getRating();
        $jacocoInit[280] = true;
        int total2 = rating3.getTotal();
        AppRating rating4 = app.getRating();
        $jacocoInit[281] = true;
        float average2 = rating4.getAverage();
        $jacocoInit[282] = true;
        showReviews(false, total2, average2);
        $jacocoInit[283] = true;
        this.reviewsAdapter = new TopReviewsAdapter();
        $jacocoInit[284] = true;
        this.reviewsView.setAdapter(this.reviewsAdapter);
        $jacocoInit[285] = true;
        this.reviewsAutoScroll.onNext(Integer.valueOf(this.reviewsAdapter.getItemCount()));
        $jacocoInit[286] = true;
    }

    public void populateSimilar(List<SimilarAppsBundle> similarApps) {
        boolean[] $jacocoInit = $jacocoInit();
        this.similarListAdapter.add(similarApps);
        $jacocoInit[287] = true;
        manageSimilarAppsVisibility(true, false);
        $jacocoInit[288] = true;
    }

    public C0120S<VoteType> clickWorkingFlag() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.workingWellLayout);
        C2266z zVar = C2266z.f5340a;
        $jacocoInit[289] = true;
        C0120S<VoteType> f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zVar);
        $jacocoInit[290] = true;
        return f;
    }

    /* renamed from: d */
    static /* synthetic */ C0120S m6495d(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(VoteType.GOOD);
        $jacocoInit[990] = true;
        return c;
    }

    public C0120S<VoteType> clickLicenseFlag() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.needsLicenseLayout);
        C2091h hVar = C2091h.f5146a;
        $jacocoInit[291] = true;
        C0120S<VoteType> f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hVar);
        $jacocoInit[292] = true;
        return f;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m6488b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(VoteType.LICENSE);
        $jacocoInit[989] = true;
        return c;
    }

    public C0120S<VoteType> clickFakeFlag() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.fakeAppLayout);
        C1901Q q = C1901Q.f4915a;
        $jacocoInit[293] = true;
        C0120S<VoteType> f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) q);
        $jacocoInit[294] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6483a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(VoteType.FAKE);
        $jacocoInit[988] = true;
        return c;
    }

    public C0120S<VoteType> clickVirusFlag() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.virusLayout);
        C1816H h = C1816H.f4814a;
        $jacocoInit[295] = true;
        C0120S<VoteType> f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) h);
        $jacocoInit[296] = true;
        return f;
    }

    /* renamed from: c */
    static /* synthetic */ C0120S m6493c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(VoteType.VIRUS);
        $jacocoInit[987] = true;
        return c;
    }

    public C0120S<Void> clickGetAppcInfo() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.appcRewardView);
        $jacocoInit[297] = true;
        return a;
    }

    public void displayNotLoggedInSnack() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1623a(getView(), (int) C1375R.string.you_need_to_be_logged_in, -1);
        C1780D d = new C1780D(this);
        $jacocoInit[298] = true;
        a.mo4552a((int) C1375R.string.login, (OnClickListener) d);
        $jacocoInit[299] = true;
        a.mo4690h();
        $jacocoInit[300] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10407a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginSnackClick.onNext(null);
        $jacocoInit[986] = true;
    }

    public void displayStoreFollowedSnack(String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        String messageToDisplay = String.format(getString(C1375R.string.store_followed), new Object[]{storeName2});
        $jacocoInit[301] = true;
        Toast makeText = Toast.makeText(getContext(), messageToDisplay, 0);
        $jacocoInit[302] = true;
        makeText.show();
        $jacocoInit[303] = true;
    }

    public C0120S<C13045l> scrollVisibleSimilarApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13015d.m42476a(this.scrollView);
        C1936U u = new C1936U(this);
        $jacocoInit[304] = true;
        C0120S<C13045l> d = a.mo3653d((C0132p<? super T, Boolean>) u);
        $jacocoInit[305] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo10406a(C13045l __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(isSimilarAppsVisible());
        $jacocoInit[985] = true;
        return valueOf;
    }

    public C0120S<Boolean> similarAppsVisibility() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Boolean> cVar = this.similarAppsVisibilitySubject;
        $jacocoInit[306] = true;
        return cVar;
    }

    public boolean isSimilarAppsVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        Rect scrollBounds = new Rect();
        $jacocoInit[307] = true;
        this.scrollView.getHitRect(scrollBounds);
        $jacocoInit[308] = true;
        boolean localVisibleRect = this.similarListRecyclerView.getLocalVisibleRect(scrollBounds);
        $jacocoInit[309] = true;
        return localVisibleRect;
    }

    public C0120S<Void> clickDeveloperWebsite() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.infoWebsite);
        $jacocoInit[310] = true;
        return a;
    }

    public C0120S<Void> clickDeveloperEmail() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.infoEmail);
        $jacocoInit[311] = true;
        return a;
    }

    public C0120S<Void> clickDeveloperPrivacy() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.infoPrivacy);
        $jacocoInit[312] = true;
        return a;
    }

    public C0120S<Void> clickDeveloperPermissions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.infoPermissions);
        $jacocoInit[313] = true;
        return a;
    }

    public C0120S<Void> clickStoreLayout() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.storeLayout);
        $jacocoInit[314] = true;
        return a;
    }

    public C0120S<Void> clickFollowStore() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.storeFollow);
        $jacocoInit[315] = true;
        return a;
    }

    public C0120S<Void> clickOtherVersions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.otherVersions);
        $jacocoInit[316] = true;
        return a;
    }

    public C0120S<Void> clickTrustedBadge() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.trustedLayout);
        $jacocoInit[317] = true;
        return a;
    }

    public C0120S<Void> clickRateApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.rateAppButton);
        $jacocoInit[318] = true;
        return a;
    }

    public C0120S<Void> clickRateAppLarge() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.rateAppButtonLarge);
        $jacocoInit[319] = true;
        return a;
    }

    public C0120S<Void> clickRateAppLayout() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.ratingLayout);
        $jacocoInit[320] = true;
        return a;
    }

    public C0120S<Void> clickReviewsLayout() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.topReviewsLayout);
        $jacocoInit[321] = true;
        return a;
    }

    public C0120S<Void> clickReadAllReviews() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.showAllReviewsButton);
        $jacocoInit[322] = true;
        return a;
    }

    public C0120S<Void> clickLoginSnack() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.loginSnackClick;
        $jacocoInit[323] = true;
        return cVar;
    }

    public C0120S<SimilarAppClickEvent> clickSimilarApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<SimilarAppClickEvent> cVar = this.similarAppClick;
        $jacocoInit[324] = true;
        return cVar;
    }

    public C0120S<MenuItem> clickToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<MenuItem> a = C13026g.m42484a(this.toolbar);
        $jacocoInit[325] = true;
        return a;
    }

    public C0120S<Void> clickNoNetworkRetry() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.noNetworkRetryClick;
        $jacocoInit[326] = true;
        return cVar;
    }

    public C0120S<Void> clickGenericRetry() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.genericRetryClick;
        $jacocoInit[327] = true;
        return cVar;
    }

    public C0120S<Void> clickTopDonorsDonateButton() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.listDonateButton);
        $jacocoInit[328] = true;
        return a;
    }

    public C0120S<String> apkfyDialogPositiveClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.apkfyDialogConfirmSubject;
        $jacocoInit[329] = true;
        return cVar;
    }

    public C0120S<Integer> scrollReviewsResponse() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Integer> cVar = this.reviewsAutoScroll;
        $jacocoInit[330] = true;
        return cVar;
    }

    public void navigateToDeveloperWebsite(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        AppDeveloper developer = app.getDeveloper();
        $jacocoInit[331] = true;
        String website = developer.getWebsite();
        $jacocoInit[332] = true;
        Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(website));
        $jacocoInit[333] = true;
        getContext().startActivity(browserIntent);
        $jacocoInit[334] = true;
    }

    public void navigateToDeveloperEmail(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent("android.intent.action.VIEW");
        $jacocoInit[335] = true;
        StringBuilder sb = new StringBuilder();
        sb.append("mailto:");
        AppDeveloper developer = app.getDeveloper();
        $jacocoInit[336] = true;
        sb.append(developer.getEmail());
        sb.append("?subject=Feedback&body=");
        String sb2 = sb.toString();
        $jacocoInit[337] = true;
        Uri data = Uri.parse(sb2);
        $jacocoInit[338] = true;
        intent.setData(data);
        $jacocoInit[339] = true;
        getContext().startActivity(intent);
        $jacocoInit[340] = true;
    }

    public void navigateToDeveloperPrivacy(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        AppDeveloper developer = app.getDeveloper();
        $jacocoInit[341] = true;
        String privacy = developer.getPrivacy();
        $jacocoInit[342] = true;
        Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(privacy));
        $jacocoInit[343] = true;
        getContext().startActivity(browserIntent);
        $jacocoInit[344] = true;
    }

    public void navigateToDeveloperPermissions(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[345] = true;
        String appName2 = app.getAppName();
        String versionName = app.getVersionName();
        String icon = app.getIcon();
        $jacocoInit[346] = true;
        String formatBytes = StringU.formatBytes(AppUtils.sumFileSizes(app.getFileSize(), app.getObb()), false);
        $jacocoInit[347] = true;
        List usedPermissions = app.getUsedPermissions();
        $jacocoInit[348] = true;
        DialogPermissions dialogPermissions = DialogPermissions.newInstance(appName2, versionName, icon, formatBytes, usedPermissions);
        $jacocoInit[349] = true;
        dialogPermissions.show(getActivity().getSupportFragmentManager(), "");
        $jacocoInit[350] = true;
    }

    public void setFollowButton(boolean isFollowing) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isFollowing) {
            $jacocoInit[351] = true;
        } else {
            this.storeFollow.setText(C1375R.string.followed);
            $jacocoInit[352] = true;
        }
        $jacocoInit[353] = true;
    }

    public void showTrustedDialog(AppViewViewModel app) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.marketName;
        Malware malware = app.getMalware();
        String appName2 = app.getAppName();
        Malware malware2 = app.getMalware();
        $jacocoInit[354] = true;
        Rank rank = malware2.getRank();
        $jacocoInit[355] = true;
        DialogBadgeV7 newInstance = DialogBadgeV7.newInstance(str, malware, appName2, rank);
        $jacocoInit[356] = true;
        newInstance.show(getFragmentManager(), BADGE_DIALOG_TAG);
        $jacocoInit[357] = true;
    }

    public String getLanguageFilter() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[358] = true;
        LanguageFilter currentLanguageFirst = new LanguageFilterHelper(getContext().getResources()).getCurrentLanguageFirst();
        $jacocoInit[359] = true;
        List<String> countryCodes = currentLanguageFirst.getCountryCodes();
        $jacocoInit[360] = true;
        String str = (String) countryCodes.get(0);
        $jacocoInit[361] = true;
        return str;
    }

    public C0120S<EResponse> showRateDialog(String appName2, String packageName, String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<EResponse> showRateDialog = this.dialogUtils.showRateDialog(getActivity(), appName2, packageName, storeName2);
        $jacocoInit[362] = true;
        return showRateDialog;
    }

    public void disableFlags() {
        boolean[] $jacocoInit = $jacocoInit();
        this.workingWellLayout.setClickable(false);
        $jacocoInit[363] = true;
        this.needsLicenseLayout.setClickable(false);
        $jacocoInit[364] = true;
        this.fakeAppLayout.setClickable(false);
        $jacocoInit[365] = true;
        this.virusLayout.setClickable(false);
        $jacocoInit[366] = true;
    }

    public void enableFlags() {
        boolean[] $jacocoInit = $jacocoInit();
        this.workingWellLayout.setClickable(true);
        $jacocoInit[367] = true;
        this.needsLicenseLayout.setClickable(true);
        $jacocoInit[368] = true;
        this.fakeAppLayout.setClickable(true);
        $jacocoInit[369] = true;
        this.virusLayout.setClickable(true);
        $jacocoInit[370] = true;
    }

    public void incrementFlags(VoteType type) {
        boolean[] $jacocoInit = $jacocoInit();
        disableFlags();
        $jacocoInit[371] = true;
        int i = C17602.$SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[type.ordinal()];
        if (i == 1) {
            TextView textView = this.workingWellText;
            NumberFormat integerInstance = NumberFormat.getIntegerInstance();
            TextView textView2 = this.workingWellText;
            $jacocoInit[372] = true;
            CharSequence text = textView2.getText();
            $jacocoInit[373] = true;
            BigDecimal bigDecimal = new BigDecimal(text.toString());
            $jacocoInit[374] = true;
            String format = integerInstance.format(Double.parseDouble(String.valueOf(bigDecimal)) + 1.0d);
            $jacocoInit[375] = true;
            textView.setText(format);
            $jacocoInit[376] = true;
            this.workingWellLayout.setSelected(true);
            $jacocoInit[377] = true;
            this.workingWellLayout.setPressed(false);
            $jacocoInit[378] = true;
        } else if (i == 2) {
            TextView textView3 = this.needsLicenceText;
            NumberFormat integerInstance2 = NumberFormat.getIntegerInstance();
            TextView textView4 = this.needsLicenceText;
            $jacocoInit[379] = true;
            CharSequence text2 = textView4.getText();
            $jacocoInit[380] = true;
            BigDecimal bigDecimal2 = new BigDecimal(text2.toString());
            $jacocoInit[381] = true;
            String format2 = integerInstance2.format(Double.parseDouble(String.valueOf(bigDecimal2)) + 1.0d);
            $jacocoInit[382] = true;
            textView3.setText(format2);
            $jacocoInit[383] = true;
            this.needsLicenceText.setSelected(true);
            $jacocoInit[384] = true;
            this.needsLicenceText.setPressed(false);
            $jacocoInit[385] = true;
        } else if (i == 3) {
            TextView textView5 = this.fakeAppText;
            NumberFormat integerInstance3 = NumberFormat.getIntegerInstance();
            TextView textView6 = this.fakeAppText;
            $jacocoInit[386] = true;
            CharSequence text3 = textView6.getText();
            $jacocoInit[387] = true;
            BigDecimal bigDecimal3 = new BigDecimal(text3.toString());
            $jacocoInit[388] = true;
            String format3 = integerInstance3.format(Double.parseDouble(String.valueOf(bigDecimal3)) + 1.0d);
            $jacocoInit[389] = true;
            textView5.setText(format3);
            $jacocoInit[390] = true;
            this.fakeAppLayout.setSelected(true);
            $jacocoInit[391] = true;
            this.fakeAppLayout.setPressed(false);
            $jacocoInit[392] = true;
        } else if (i == 4) {
            TextView textView7 = this.virusText;
            NumberFormat integerInstance4 = NumberFormat.getIntegerInstance();
            TextView textView8 = this.virusText;
            $jacocoInit[393] = true;
            CharSequence text4 = textView8.getText();
            $jacocoInit[394] = true;
            BigDecimal bigDecimal4 = new BigDecimal(text4.toString());
            $jacocoInit[395] = true;
            String format4 = integerInstance4.format(Double.parseDouble(String.valueOf(bigDecimal4)) + 1.0d);
            $jacocoInit[396] = true;
            textView7.setText(format4);
            $jacocoInit[397] = true;
            this.virusLayout.setSelected(true);
            $jacocoInit[398] = true;
            this.virusLayout.setPressed(false);
            $jacocoInit[399] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to find Type ");
            sb.append(type.name());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
            $jacocoInit[400] = true;
            throw illegalArgumentException;
        }
        $jacocoInit[401] = true;
    }

    public void showFlagVoteSubmittedMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Toast makeText = Toast.makeText(getContext(), C1375R.string.vote_submitted, 0);
        $jacocoInit[402] = true;
        makeText.show();
        $jacocoInit[403] = true;
    }

    public void showShareOnTvDialog(long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[404] = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        $jacocoInit[405] = true;
        String connectionType = SystemU.getConnectionType(connectivityManager);
        $jacocoInit[406] = true;
        if (connectionType.equals("mobile")) {
            $jacocoInit[407] = true;
            Context context = getContext();
            $jacocoInit[408] = true;
            String string = getContext().getString(C1375R.string.remote_install_menu_title);
            $jacocoInit[409] = true;
            String string2 = getContext().getString(C1375R.string.install_on_tv_mobile_error);
            $jacocoInit[410] = true;
            C0120S createGenericOkMessage = GenericDialogs.createGenericOkMessage(context, string, string2);
            C1789E e = C1789E.f4783a;
            C1954W w = C1954W.f4978a;
            $jacocoInit[411] = true;
            createGenericOkMessage.mo3626a((C0129b<? super T>) e, (C0129b<Throwable>) w);
            $jacocoInit[412] = true;
        } else {
            C0478k newFragment = RemoteInstallDialog.newInstance(appId);
            $jacocoInit[413] = true;
            C0486t supportFragmentManager = getActivity().getSupportFragmentManager();
            $jacocoInit[414] = true;
            String simpleName = RemoteInstallDialog.class.getSimpleName();
            $jacocoInit[415] = true;
            newFragment.show(supportFragmentManager, simpleName);
            $jacocoInit[416] = true;
        }
        $jacocoInit[417] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6490b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[982] = true;
        instance.log(err);
        $jacocoInit[983] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m6502h(EResponse __) {
        $jacocoInit()[984] = true;
    }

    public void defaultShare(String appName2, String wUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (wUrl == null) {
            $jacocoInit[418] = true;
        } else {
            $jacocoInit[419] = true;
            Intent sharingIntent = new Intent("android.intent.action.SEND");
            $jacocoInit[420] = true;
            sharingIntent.setType("text/plain");
            $jacocoInit[421] = true;
            StringBuilder sb = new StringBuilder();
            $jacocoInit[422] = true;
            sb.append(getActivity().getString(C1375R.string.install));
            sb.append(" \"");
            sb.append(appName2);
            sb.append("\"");
            String sb2 = sb.toString();
            $jacocoInit[423] = true;
            sharingIntent.putExtra("android.intent.extra.SUBJECT", sb2);
            $jacocoInit[424] = true;
            sharingIntent.putExtra("android.intent.extra.TEXT", wUrl);
            $jacocoInit[425] = true;
            C0014p activity = getActivity();
            $jacocoInit[426] = true;
            Intent createChooser = Intent.createChooser(sharingIntent, getActivity().getString(C1375R.string.share));
            $jacocoInit[427] = true;
            activity.startActivity(createChooser);
            $jacocoInit[428] = true;
        }
        $jacocoInit[429] = true;
    }

    public void scrollReviews(Integer position) {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView = this.reviewsView;
        if (recyclerView == null) {
            $jacocoInit[430] = true;
        } else {
            recyclerView.mo7622j(position.intValue());
            $jacocoInit[431] = true;
        }
        $jacocoInit[432] = true;
    }

    public void hideReviews() {
        boolean[] $jacocoInit = $jacocoInit();
        this.reviewsLayout.setVisibility(8);
        $jacocoInit[433] = true;
    }

    public void hideSimilarApps() {
        boolean[] $jacocoInit = $jacocoInit();
        this.similarListRecyclerView.setVisibility(8);
        $jacocoInit[434] = true;
    }

    public void extractReferrer(SearchAdResult searchAdResult) {
        boolean[] $jacocoInit = $jacocoInit();
        ThreadU.runOnUiThread(new C1963X(this, searchAdResult));
        $jacocoInit[435] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10410a(SearchAdResult searchAdResult) {
        boolean[] $jacocoInit = $jacocoInit();
        AdsRepository adsRepository2 = this.adsRepository;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        $jacocoInit[978] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[979] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        MinimalAdMapper minimalAdMapper = new MinimalAdMapper();
        $jacocoInit[980] = true;
        ReferrerUtils.extractReferrer(searchAdResult, 2, false, adsRepository2, okHttpClient, factory, qManager2, applicationContext, defaultSharedPreferences, minimalAdMapper);
        $jacocoInit[981] = true;
    }

    public void recoverScrollViewState() {
        boolean[] $jacocoInit = $jacocoInit();
        this.scrollView.post(new C2170p(this));
        $jacocoInit[436] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10416b() {
        boolean[] $jacocoInit = $jacocoInit();
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            $jacocoInit[975] = true;
        } else {
            nestedScrollView.scrollTo(0, this.scrollViewY);
            $jacocoInit[976] = true;
        }
        $jacocoInit[977] = true;
    }

    public C0120S<Action> showOpenAndInstallDialog(String title, String appName2) {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[437] = true;
        String string = getContext().getString(C1375R.string.installapp_alrt, new Object[]{appName2});
        $jacocoInit[438] = true;
        C0120S createGenericOkCancelMessage = GenericDialogs.createGenericOkCancelMessage(context, title, string);
        C2220u uVar = C2220u.f5290a;
        $jacocoInit[439] = true;
        C0120S d = createGenericOkCancelMessage.mo3653d((C0132p<? super T, Boolean>) uVar);
        C1798F f = new C1798F(this);
        $jacocoInit[440] = true;
        C0120S<Action> j = d.mo3669j(f);
        $jacocoInit[441] = true;
        return j;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m6497e(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(response.equals(EResponse.YES));
        $jacocoInit[974] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ Action mo10463f(EResponse __) {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = this.action;
        $jacocoInit[973] = true;
        return action2;
    }

    public C0120S<Action> showOpenAndInstallApkFyDialog(String title, String appName2, double appc, float rating, String icon, int downloads) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = createCustomDialogForApkfy(appName2, appc, rating, icon, downloads).mo3653d((C0132p<? super T, Boolean>) C1771C.f4763a);
        C1927T t = new C1927T(this);
        $jacocoInit[442] = true;
        C0120S<Action> j = d.mo3669j(t);
        $jacocoInit[443] = true;
        return j;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6492c(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(response.equals(EResponse.YES));
        $jacocoInit[972] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ Action mo10450d(EResponse __) {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = this.action;
        $jacocoInit[971] = true;
        return action2;
    }

    public void showApkfyElement(String appName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.apkfyElement.setVisibility(0);
        $jacocoInit[444] = true;
        String message = getString(C1375R.string.appview_message_apkfy_1);
        $jacocoInit[445] = true;
        TextView textView = (TextView) this.apkfyElement.findViewById(C1375R.C1376id.apkfy_message_1);
        Object[] objArr = {appName2};
        $jacocoInit[446] = true;
        String format = String.format(message, objArr);
        $jacocoInit[447] = true;
        textView.setText(format);
        $jacocoInit[448] = true;
        TextView textView2 = (TextView) this.apkfyElement.findViewById(C1375R.C1376id.apkfy_title);
        $jacocoInit[449] = true;
        String string = getResources().getString(C1375R.string.appview_title_apkfy);
        $jacocoInit[450] = true;
        textView2.setText(string);
        $jacocoInit[451] = true;
    }

    public void showDonations(List<Donation> donations) {
        boolean[] $jacocoInit = $jacocoInit();
        this.donationsProgress.setVisibility(8);
        $jacocoInit[452] = true;
        if (donations == null) {
            $jacocoInit[453] = true;
        } else if (donations.isEmpty()) {
            $jacocoInit[454] = true;
        } else {
            $jacocoInit[455] = true;
            this.donationsAdapter.setDonations(donations);
            $jacocoInit[456] = true;
            this.donationsList.setVisibility(0);
            $jacocoInit[457] = true;
            $jacocoInit[459] = true;
        }
        this.donationsListEmptyState.setVisibility(0);
        $jacocoInit[458] = true;
        $jacocoInit[459] = true;
    }

    public void initInterstitialAd() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[460] = true;
        this.interstitialAd = new MoPubInterstitial(getActivity(), BuildConfig.MOPUB_VIDEO_APPVIEW_PLACEMENT_ID);
        $jacocoInit[461] = true;
        this.interstitialAd.setInterstitialAdListener(new MoPubInterstitialAdListener(this.interstitialClick));
        $jacocoInit[462] = true;
        this.interstitialAd.load();
        $jacocoInit[463] = true;
    }

    public C0120S<MoPubInterstitialAdClickType> InterstitialAdClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<MoPubInterstitialAdClickType> d = this.interstitialClick.mo3653d((C0132p<? super T, Boolean>) C1981Z.f5013a);
        $jacocoInit[464] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6480a(MoPubInterstitialAdClickType clickType) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (clickType == MoPubInterstitialAdClickType.INTERSTITIAL_CLICKED) {
            $jacocoInit[968] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[969] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[970] = true;
        return valueOf;
    }

    public C0120S<MoPubInterstitialAdClickType> interstitialAdLoaded() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<MoPubInterstitialAdClickType> d = this.interstitialClick.mo3653d((C0132p<? super T, Boolean>) C2197s.f5265a);
        $jacocoInit[465] = true;
        return d;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m6487b(MoPubInterstitialAdClickType clickType) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (clickType == MoPubInterstitialAdClickType.INTERSTITIAL_LOADED) {
            $jacocoInit[965] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[966] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[967] = true;
        return valueOf;
    }

    public void showInterstitialAd() {
        boolean[] $jacocoInit = $jacocoInit();
        this.interstitialAd.show();
        $jacocoInit[466] = true;
    }

    public void showBannerAd() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bannerAd.setBannerAdListener(new MoPubBannerAdListener());
        $jacocoInit[467] = true;
        this.bannerAd.setAdUnitId("d225547d92b743179d8a04b75bf7d116");
        $jacocoInit[468] = true;
        this.bannerAd.setVisibility(0);
        $jacocoInit[469] = true;
        this.bannerAd.loadAd();
        $jacocoInit[470] = true;
    }

    public void setupAppcAppView() {
        boolean[] $jacocoInit = $jacocoInit();
        TransitionDrawable transition = (TransitionDrawable) C0510b.m2572c(getContext(), C1375R.drawable.appc_gradient_transition);
        $jacocoInit[471] = true;
        this.collapsingToolbarLayout.setBackgroundDrawable(transition);
        $jacocoInit[472] = true;
        transition.startTransition(1000);
        $jacocoInit[473] = true;
        AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
        $jacocoInit[474] = true;
        animation1.setDuration(1000);
        $jacocoInit[475] = true;
        this.collapsingAppcBackground.setAlpha(1.0f);
        $jacocoInit[476] = true;
        this.collapsingAppcBackground.setVisibility(0);
        $jacocoInit[477] = true;
        this.collapsingAppcBackground.startAnimation(animation1);
        $jacocoInit[478] = true;
        Button button = this.install;
        Resources resources = getContext().getResources();
        $jacocoInit[479] = true;
        Drawable drawable = resources.getDrawable(C1375R.drawable.appc_gradient_rounded);
        $jacocoInit[480] = true;
        button.setBackgroundDrawable(drawable);
        ProgressBar progressBar = this.downloadProgressBar;
        $jacocoInit[481] = true;
        Drawable c = C0510b.m2572c(getContext(), C1375R.drawable.appc_progress);
        $jacocoInit[482] = true;
        progressBar.setProgressDrawable(c);
        $jacocoInit[483] = true;
        this.flagThisAppSection.setVisibility(8);
        $jacocoInit[484] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo10468h(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.DISMISS));
        $jacocoInit[964] = true;
    }

    public void showAppcWalletPromotionView(Promotion promotion, WalletApp walletApp, ClaimAction action2, DownloadModel appDownloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletPromotionCancelButton.setOnClickListener(new C1999aa(this, promotion, walletApp));
        $jacocoInit[485] = true;
        if (walletApp.isInstalled()) {
            $jacocoInit[486] = true;
            Action action3 = appDownloadModel.getAction();
            Action action4 = Action.OPEN;
            $jacocoInit[487] = true;
            if (!action3.equals(action4)) {
                $jacocoInit[488] = true;
                setupInstallDependencyApp(promotion, appDownloadModel);
                $jacocoInit[489] = true;
            } else {
                setupClaimWalletPromotion(promotion, walletApp);
                $jacocoInit[490] = true;
            }
        } else {
            DownloadModel downloadModel = walletApp.getDownloadModel();
            $jacocoInit[491] = true;
            if (downloadModel.isDownloading()) {
                $jacocoInit[492] = true;
                setupActiveWalletPromotion(promotion, walletApp, appDownloadModel);
                $jacocoInit[493] = true;
            } else {
                setupInactiveWalletPromotion(promotion, walletApp, appDownloadModel);
                $jacocoInit[494] = true;
            }
        }
        this.promotionView.setVisibility(0);
        $jacocoInit[495] = true;
    }

    public C0120S<Promotion> dismissWalletPromotionClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C1918S.f4932a);
        C1825I i = C1825I.f4824a;
        $jacocoInit[496] = true;
        C0120S<Promotion> j = d.mo3669j(i);
        $jacocoInit[497] = true;
        return j;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m6496e(PromotionEvent promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.DISMISS) {
            $jacocoInit[961] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[962] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[963] = true;
        return valueOf;
    }

    /* renamed from: f */
    static /* synthetic */ Promotion m6498f(PromotionEvent promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        Promotion promotion = promotionAppClick2.getPromotion();
        $jacocoInit[960] = true;
        return promotion;
    }

    public void dismissWalletPromotionView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionView.setVisibility(8);
        $jacocoInit[498] = true;
    }

    public C0120S<Pair<Promotion, WalletApp>> installWalletButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C2151n.f5215a);
        C2257y yVar = C2257y.f5331a;
        $jacocoInit[499] = true;
        C0120S<Pair<Promotion, WalletApp>> j = d.mo3669j(yVar);
        $jacocoInit[500] = true;
        return j;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m6499g(PromotionEvent promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.UPDATE) {
            $jacocoInit[950] = true;
        } else {
            $jacocoInit[951] = true;
            if (promotionAppClick2.getClickType() == ClickType.INSTALL_APP) {
                $jacocoInit[952] = true;
            } else {
                $jacocoInit[953] = true;
                if (promotionAppClick2.getClickType() == ClickType.DOWNLOAD) {
                    $jacocoInit[954] = true;
                } else {
                    $jacocoInit[955] = true;
                    if (promotionAppClick2.getClickType() == ClickType.DOWNGRADE) {
                        $jacocoInit[956] = true;
                    } else {
                        z = false;
                        $jacocoInit[958] = true;
                        Boolean valueOf = Boolean.valueOf(z);
                        $jacocoInit[959] = true;
                        return valueOf;
                    }
                }
            }
        }
        $jacocoInit[957] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[959] = true;
        return valueOf2;
    }

    /* renamed from: h */
    static /* synthetic */ Pair m6501h(PromotionEvent promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        Promotion promotion = promotionAppClick2.getPromotion();
        $jacocoInit[947] = true;
        WalletApp wallet = promotionAppClick2.getWallet();
        $jacocoInit[948] = true;
        Pair create = Pair.create(promotion, wallet);
        $jacocoInit[949] = true;
        return create;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m6503i(PromotionEvent promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.PAUSE_DOWNLOAD) {
            $jacocoInit[944] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[945] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[946] = true;
        return valueOf;
    }

    public C0120S<WalletApp> pausePromotionDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C2111j.f5172a);
        C2141m mVar = C2141m.f5204a;
        $jacocoInit[501] = true;
        C0120S<WalletApp> j = d.mo3669j(mVar);
        $jacocoInit[502] = true;
        return j;
    }

    /* renamed from: j */
    static /* synthetic */ WalletApp m6504j(PromotionEvent promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp wallet = promotionAppClick2.getWallet();
        $jacocoInit[943] = true;
        return wallet;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6481a(PromotionEvent promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.CANCEL_DOWNLOAD) {
            $jacocoInit[940] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[941] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[942] = true;
        return valueOf;
    }

    public C0120S<WalletApp> cancelPromotionDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C1945V.f4969a);
        C2121k kVar = C2121k.f5184a;
        $jacocoInit[503] = true;
        C0120S<WalletApp> j = d.mo3669j(kVar);
        $jacocoInit[504] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ WalletApp m6486b(PromotionEvent promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp wallet = promotionAppClick2.getWallet();
        $jacocoInit[939] = true;
        return wallet;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m6505k(PromotionEvent promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.RESUME_DOWNLOAD) {
            $jacocoInit[936] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[937] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[938] = true;
        return valueOf;
    }

    public C0120S<WalletApp> resumePromotionDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C2211t.f5281a);
        C1852L l = C1852L.f4859a;
        $jacocoInit[505] = true;
        C0120S<WalletApp> j = d.mo3669j(l);
        $jacocoInit[506] = true;
        return j;
    }

    /* renamed from: l */
    static /* synthetic */ WalletApp m6506l(PromotionEvent promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp wallet = promotionAppClick2.getWallet();
        $jacocoInit[935] = true;
        return wallet;
    }

    public C0120S<Promotion> claimAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C2179q.f5246a);
        C2248x xVar = C2248x.f5321a;
        $jacocoInit[507] = true;
        C0120S<Promotion> j = d.mo3669j(xVar);
        $jacocoInit[508] = true;
        return j;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6491c(PromotionEvent promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.CLAIM) {
            $jacocoInit[932] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[933] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[934] = true;
        return valueOf;
    }

    /* renamed from: d */
    static /* synthetic */ Promotion m6494d(PromotionEvent promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        Promotion promotion = promotionAppClick2.getPromotion();
        $jacocoInit[931] = true;
        return promotion;
    }

    public void showDownloadingSimilarApps(boolean hasSimilarApps) {
        boolean[] $jacocoInit = $jacocoInit();
        manageSimilarAppsVisibility(hasSimilarApps, true);
        $jacocoInit[509] = true;
    }

    public void showConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.consentDialogView.showConsentDialog();
        $jacocoInit[510] = true;
    }

    private void setupInstallDependencyApp(Promotion promotion, DownloadModel appDownloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        int stringId = C1375R.string.wallet_promotion_wallet_installed_message;
        $jacocoInit[511] = true;
        if (appDownloadModel.getAction() == Action.MIGRATE) {
            $jacocoInit[512] = true;
        } else {
            $jacocoInit[513] = true;
            if (appDownloadModel.getAction() != Action.UPDATE) {
                $jacocoInit[514] = true;
                setupWalletPromotionText(promotion, stringId);
                Button button = this.walletPromotionInstallDisableButton;
                $jacocoInit[517] = true;
                String string = getString(C1375R.string.wallet_promotion_button_install_disabled);
                $jacocoInit[518] = true;
                Object[] objArr = {String.valueOf(promotion.getAppc())};
                $jacocoInit[519] = true;
                String format = String.format(string, objArr);
                $jacocoInit[520] = true;
                button.setText(format);
                $jacocoInit[521] = true;
                this.walletPromotionInstallDisableLayout.setVisibility(0);
                $jacocoInit[522] = true;
                this.walletPromotionDownloadLayout.setVisibility(8);
                $jacocoInit[523] = true;
                this.walletPromotionButtonsLayout.setVisibility(8);
                $jacocoInit[524] = true;
                this.walletPromotionClaimLayout.setVisibility(8);
                $jacocoInit[525] = true;
                this.walletPromotionIcon.setImageResource(C1375R.drawable.ic_promotion_coins);
                $jacocoInit[526] = true;
            }
            $jacocoInit[515] = true;
        }
        stringId = C1375R.string.wallet_promotion_wallet_installed_update_message;
        $jacocoInit[516] = true;
        setupWalletPromotionText(promotion, stringId);
        Button button2 = this.walletPromotionInstallDisableButton;
        $jacocoInit[517] = true;
        String string2 = getString(C1375R.string.wallet_promotion_button_install_disabled);
        $jacocoInit[518] = true;
        Object[] objArr2 = {String.valueOf(promotion.getAppc())};
        $jacocoInit[519] = true;
        String format2 = String.format(string2, objArr2);
        $jacocoInit[520] = true;
        button2.setText(format2);
        $jacocoInit[521] = true;
        this.walletPromotionInstallDisableLayout.setVisibility(0);
        $jacocoInit[522] = true;
        this.walletPromotionDownloadLayout.setVisibility(8);
        $jacocoInit[523] = true;
        this.walletPromotionButtonsLayout.setVisibility(8);
        $jacocoInit[524] = true;
        this.walletPromotionClaimLayout.setVisibility(8);
        $jacocoInit[525] = true;
        this.walletPromotionIcon.setImageResource(C1375R.drawable.ic_promotion_coins);
        $jacocoInit[526] = true;
    }

    private void setupClaimWalletPromotion(Promotion promotion, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        setupWalletPromotionText(promotion, C1375R.string.wallet_promotion_wallet_claim_message);
        Button button = this.walletPromotionClaimButton;
        $jacocoInit[527] = true;
        String string = getString(C1375R.string.wallet_promotion_button_claim);
        $jacocoInit[528] = true;
        Object[] objArr = {String.valueOf(promotion.getAppc())};
        $jacocoInit[529] = true;
        String format = String.format(string, objArr);
        $jacocoInit[530] = true;
        button.setText(format);
        $jacocoInit[531] = true;
        this.walletPromotionDownloadLayout.setVisibility(8);
        $jacocoInit[532] = true;
        this.walletPromotionInstallDisableLayout.setVisibility(8);
        $jacocoInit[533] = true;
        this.walletPromotionButtonsLayout.setVisibility(8);
        $jacocoInit[534] = true;
        this.walletPromotionClaimLayout.setVisibility(0);
        $jacocoInit[535] = true;
        this.walletPromotionClaimButton.setOnClickListener(new C1750A(this, promotion, walletApp));
        $jacocoInit[536] = true;
        this.walletPromotionIcon.setVisibility(0);
        $jacocoInit[537] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo10464f(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.CLAIM));
        $jacocoInit[930] = true;
    }

    private void setupWalletPromotionText(Promotion promotion, int walletMessageStringId) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.walletPromotionTitle;
        String string = getString(C1375R.string.wallet_promotion_title);
        $jacocoInit[538] = true;
        Object[] objArr = {String.valueOf(promotion.getAppc())};
        $jacocoInit[539] = true;
        textView.setText(String.format(string, objArr));
        TextView textView2 = this.walletPromotionMessage;
        $jacocoInit[540] = true;
        String format = String.format(getString(walletMessageStringId), new Object[]{String.valueOf(promotion.getAppc())});
        $jacocoInit[541] = true;
        textView2.setText(format);
        $jacocoInit[542] = true;
    }

    private int getPromotionMessage(DownloadModel appDownloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        int messageStringId = C1375R.string.wallet_promotion_wallet_notinstalled_message;
        $jacocoInit[543] = true;
        Action action2 = appDownloadModel.getAction();
        Action action3 = Action.MIGRATE;
        $jacocoInit[544] = true;
        if (action2.equals(action3)) {
            $jacocoInit[545] = true;
        } else {
            Action action4 = appDownloadModel.getAction();
            Action action5 = Action.UPDATE;
            $jacocoInit[546] = true;
            if (!action4.equals(action5)) {
                $jacocoInit[547] = true;
                $jacocoInit[550] = true;
                return messageStringId;
            }
            $jacocoInit[548] = true;
        }
        messageStringId = C1375R.string.wallet_promotion_wallet_installed_update_message;
        $jacocoInit[549] = true;
        $jacocoInit[550] = true;
        return messageStringId;
    }

    private void setupInactiveWalletPromotion(Promotion promotion, WalletApp walletApp, DownloadModel appDownloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        setupWalletPromotionText(promotion, getPromotionMessage(appDownloadModel));
        $jacocoInit[551] = true;
        this.walletPromotionDownloadLayout.setVisibility(8);
        $jacocoInit[552] = true;
        this.walletPromotionInstallDisableLayout.setVisibility(8);
        $jacocoInit[553] = true;
        this.walletPromotionClaimLayout.setVisibility(8);
        $jacocoInit[554] = true;
        this.walletPromotionButtonsLayout.setVisibility(0);
        $jacocoInit[555] = true;
        this.walletPromotionIcon.setVisibility(0);
        $jacocoInit[556] = true;
        this.walletPromotionDownloadButton.setOnClickListener(new C1843K(this, promotion, walletApp));
        $jacocoInit[557] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo10465g(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.INSTALL_APP));
        $jacocoInit[929] = true;
    }

    private void setupActiveWalletPromotion(Promotion promotion, WalletApp walletApp, DownloadModel appDownloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        setupWalletPromotionText(promotion, getPromotionMessage(appDownloadModel));
        $jacocoInit[558] = true;
        this.walletPromotionDownloadLayout.setVisibility(0);
        $jacocoInit[559] = true;
        this.walletPromotionButtonsLayout.setVisibility(8);
        $jacocoInit[560] = true;
        this.walletPromotionIcon.setVisibility(0);
        $jacocoInit[561] = true;
        DownloadModel downloadModel = walletApp.getDownloadModel();
        $jacocoInit[562] = true;
        DownloadState downloadState = downloadModel.getDownloadState();
        $jacocoInit[563] = true;
        LayoutParams pauseShowing = new LayoutParams(-1, -1, 4.0f);
        $jacocoInit[564] = true;
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2.0f);
        $jacocoInit[565] = true;
        LayoutParams pauseHidden = layoutParams;
        String str = "%";
        switch (C17602.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()]) {
            case 1:
                this.downloadWalletProgressBar.setIndeterminate(false);
                $jacocoInit[567] = true;
                ProgressBar progressBar = this.downloadWalletProgressBar;
                DownloadModel downloadModel2 = walletApp.getDownloadModel();
                $jacocoInit[568] = true;
                int progress = downloadModel2.getProgress();
                $jacocoInit[569] = true;
                progressBar.setProgress(progress);
                $jacocoInit[570] = true;
                TextView textView = this.downloadWalletProgressValue;
                StringBuilder sb = new StringBuilder();
                DownloadModel downloadModel3 = walletApp.getDownloadModel();
                $jacocoInit[571] = true;
                int progress2 = downloadModel3.getProgress();
                $jacocoInit[572] = true;
                sb.append(String.valueOf(progress2));
                sb.append(str);
                textView.setText(sb.toString());
                $jacocoInit[573] = true;
                this.pauseWalletDownload.setVisibility(0);
                $jacocoInit[574] = true;
                this.pauseWalletDownload.setOnClickListener(new C1807G(this, promotion, walletApp));
                $jacocoInit[575] = true;
                this.cancelWalletDownload.setVisibility(8);
                $jacocoInit[576] = true;
                this.resumeWalletDownload.setVisibility(8);
                $jacocoInit[577] = true;
                this.walletDownloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[578] = true;
                break;
            case 2:
                this.downloadWalletProgressBar.setIndeterminate(true);
                $jacocoInit[579] = true;
                this.pauseWalletDownload.setVisibility(0);
                $jacocoInit[580] = true;
                this.pauseWalletDownload.setOnClickListener(new C1862M(this, promotion, walletApp));
                $jacocoInit[581] = true;
                this.cancelWalletDownload.setVisibility(8);
                $jacocoInit[582] = true;
                this.resumeWalletDownload.setVisibility(8);
                $jacocoInit[583] = true;
                this.walletDownloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[584] = true;
                break;
            case 3:
                this.downloadWalletProgressBar.setIndeterminate(false);
                $jacocoInit[585] = true;
                ProgressBar progressBar2 = this.downloadWalletProgressBar;
                DownloadModel downloadModel4 = walletApp.getDownloadModel();
                $jacocoInit[586] = true;
                int progress3 = downloadModel4.getProgress();
                $jacocoInit[587] = true;
                progressBar2.setProgress(progress3);
                $jacocoInit[588] = true;
                TextView textView2 = this.downloadWalletProgressValue;
                StringBuilder sb2 = new StringBuilder();
                DownloadModel downloadModel5 = walletApp.getDownloadModel();
                $jacocoInit[589] = true;
                int progress4 = downloadModel5.getProgress();
                $jacocoInit[590] = true;
                sb2.append(String.valueOf(progress4));
                sb2.append(str);
                textView2.setText(sb2.toString());
                $jacocoInit[591] = true;
                this.pauseWalletDownload.setVisibility(8);
                $jacocoInit[592] = true;
                this.cancelWalletDownload.setVisibility(0);
                $jacocoInit[593] = true;
                this.cancelWalletDownload.setOnClickListener(new C1892P(this, promotion, walletApp));
                $jacocoInit[594] = true;
                this.resumeWalletDownload.setVisibility(0);
                $jacocoInit[595] = true;
                this.resumeWalletDownload.setOnClickListener(new C1834J(this, promotion, walletApp));
                $jacocoInit[596] = true;
                this.walletDownloadControlsLayout.setLayoutParams(pauseHidden);
                $jacocoInit[597] = true;
                break;
            case 4:
                this.downloadWalletProgressBar.setIndeterminate(true);
                $jacocoInit[598] = true;
                this.pauseWalletDownload.setVisibility(0);
                $jacocoInit[599] = true;
                this.pauseWalletDownload.setOnClickListener(new C2071f(this, promotion, walletApp));
                $jacocoInit[600] = true;
                this.cancelWalletDownload.setVisibility(8);
                $jacocoInit[601] = true;
                this.resumeWalletDownload.setVisibility(8);
                $jacocoInit[602] = true;
                this.walletDownloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[603] = true;
                break;
            case 5:
                showErrorDialog("", getContext().getString(C1375R.string.error_occured));
                $jacocoInit[604] = true;
                break;
            case 6:
                String string = getContext().getString(C1375R.string.out_of_space_dialog_title);
                $jacocoInit[605] = true;
                String string2 = getContext().getString(C1375R.string.out_of_space_dialog_message);
                $jacocoInit[606] = true;
                showErrorDialog(string, string2);
                $jacocoInit[607] = true;
                break;
            default:
                $jacocoInit[566] = true;
                break;
        }
        $jacocoInit[608] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10409a(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[928] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10418b(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[927] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10421c(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.CANCEL_DOWNLOAD));
        $jacocoInit[926] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo10452d(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.RESUME_DOWNLOAD));
        $jacocoInit[925] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo10460e(Promotion promotion, WalletApp walletApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[924] = true;
    }

    private void setSimilarAppsAdapters() {
        boolean[] $jacocoInit = $jacocoInit();
        this.similarListAdapter = new SimilarAppsBundleAdapter(new ArrayList(), this.oneDecimalFormat, this.similarAppClick);
        $jacocoInit[609] = true;
        this.similarListRecyclerView.setAdapter(this.similarListAdapter);
        $jacocoInit[610] = true;
    }

    private void manageSimilarAppsVisibility(boolean hasSimilarApps, boolean isDownloading) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasSimilarApps) {
            $jacocoInit[611] = true;
            hideSimilarApps();
            $jacocoInit[612] = true;
        } else {
            this.similarListRecyclerView.setVisibility(0);
            $jacocoInit[613] = true;
            LinearLayout similarParentView = (LinearLayout) this.similarListRecyclerView.getParent();
            if (isDownloading) {
                $jacocoInit[614] = true;
                similarParentView.removeView(this.similarListRecyclerView);
                $jacocoInit[615] = true;
                LinearLayout parentLayout = (LinearLayout) this.similarDownloadPlaceholder.getParent();
                $jacocoInit[616] = true;
                int downloadIndex = parentLayout.indexOfChild(this.similarDownloadPlaceholder);
                $jacocoInit[617] = true;
                parentLayout.addView(this.similarListRecyclerView, downloadIndex);
                $jacocoInit[618] = true;
                this.similarAppsVisibilitySubject.onNext(Boolean.valueOf(true));
                $jacocoInit[619] = true;
            } else {
                similarParentView.removeView(this.similarListRecyclerView);
                $jacocoInit[620] = true;
                LinearLayout parentLayout2 = (LinearLayout) this.similarBottomPlaceholder.getParent();
                $jacocoInit[621] = true;
                int downloadIndex2 = parentLayout2.indexOfChild(this.similarBottomPlaceholder);
                $jacocoInit[622] = true;
                parentLayout2.addView(this.similarListRecyclerView, downloadIndex2);
                $jacocoInit[623] = true;
            }
        }
        $jacocoInit[624] = true;
    }

    private void showAppViewLayout() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appview.setVisibility(0);
        $jacocoInit[625] = true;
        this.viewProgress.setVisibility(8);
        $jacocoInit[626] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[627] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[628] = true;
    }

    private void setTrustedBadge(Malware malware) {
        Rank rank;
        int badgeMessageId;
        int badgeResId;
        boolean[] $jacocoInit = $jacocoInit();
        if (malware.getRank() == null) {
            rank = Rank.UNKNOWN;
            $jacocoInit[629] = true;
        } else {
            rank = malware.getRank();
            $jacocoInit[630] = true;
        }
        $jacocoInit[631] = true;
        int i = C17602.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[rank.ordinal()];
        if (i == 1) {
            badgeResId = C1375R.drawable.ic_badge_trusted;
            badgeMessageId = C1375R.string.appview_header_trusted_text;
            $jacocoInit[632] = true;
        } else if (i == 2) {
            badgeResId = C1375R.drawable.ic_badge_warning;
            badgeMessageId = C1375R.string.warning;
            $jacocoInit[633] = true;
        } else if (i != 3) {
            badgeResId = C1375R.drawable.ic_badge_unknown;
            badgeMessageId = C1375R.string.unknown;
            $jacocoInit[635] = true;
        } else {
            badgeResId = C1375R.drawable.ic_badge_critical;
            badgeMessageId = C1375R.string.critical;
            $jacocoInit[634] = true;
        }
        Drawable icon = C0510b.m2572c(getContext(), badgeResId);
        $jacocoInit[636] = true;
        this.trustedBadge.setImageDrawable(icon);
        $jacocoInit[637] = true;
        this.trustedText.setText(badgeMessageId);
        $jacocoInit[638] = true;
    }

    private void setDescription(String description) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!TextUtils.isEmpty(description)) {
            $jacocoInit[639] = true;
            this.descriptionText.setText(HtmlU.parse(description));
            $jacocoInit[640] = true;
        } else {
            this.descriptionText.setText(C1375R.string.description_not_available);
            $jacocoInit[641] = true;
            this.descriptionReadMore.setVisibility(8);
            $jacocoInit[642] = true;
        }
        $jacocoInit[643] = true;
    }

    private void setReadMoreClickListener(String appName2, AppMedia media, Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        this.descriptionReadMore.setOnClickListener(new C1872N(this, appName2, media, store));
        $jacocoInit[644] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10412a(String appName2, AppMedia media, Store store, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<ReadMoreClickEvent> cVar = this.readMoreClick;
        $jacocoInit[920] = true;
        String description = media.getDescription();
        Appearance appearance = store.getAppearance();
        $jacocoInit[921] = true;
        ReadMoreClickEvent readMoreClickEvent = new ReadMoreClickEvent(appName2, description, appearance.getTheme());
        $jacocoInit[922] = true;
        cVar.onNext(readMoreClickEvent);
        $jacocoInit[923] = true;
    }

    private void setAppFlags(boolean isGoodFile, AppFlags appFlags) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isGoodFile) {
            $jacocoInit[645] = true;
            this.goodAppLayoutWrapper.setVisibility(0);
            $jacocoInit[646] = true;
            this.flagsLayoutWrapper.setVisibility(8);
            $jacocoInit[647] = true;
        } else {
            this.goodAppLayoutWrapper.setVisibility(8);
            $jacocoInit[648] = true;
            this.flagsLayoutWrapper.setVisibility(0);
            $jacocoInit[649] = true;
            setFlagValues(appFlags);
            $jacocoInit[650] = true;
        }
        $jacocoInit[651] = true;
    }

    private void setFlagValues(AppFlags appFlags) {
        boolean[] $jacocoInit = $jacocoInit();
        if (appFlags == null) {
            try {
                $jacocoInit[652] = true;
            } catch (NullPointerException ex) {
                $jacocoInit[662] = true;
                CrashReport instance = CrashReport.getInstance();
                $jacocoInit[663] = true;
                instance.log(ex);
                $jacocoInit[664] = true;
            }
        } else if (appFlags.getVotes() == null) {
            $jacocoInit[653] = true;
        } else {
            List votes = appFlags.getVotes();
            $jacocoInit[654] = true;
            if (votes.isEmpty()) {
                $jacocoInit[655] = true;
            } else {
                $jacocoInit[656] = true;
                $jacocoInit[657] = true;
                for (FlagsVote vote : appFlags.getVotes()) {
                    $jacocoInit[659] = true;
                    applyCount(vote.getVoteType(), vote.getCount());
                    $jacocoInit[660] = true;
                }
                $jacocoInit[658] = true;
            }
        }
        $jacocoInit[661] = true;
        $jacocoInit[665] = true;
    }

    private void applyCount(VoteType type, int count) {
        boolean[] $jacocoInit = $jacocoInit();
        String countAsString = Integer.toString(count);
        $jacocoInit[666] = true;
        int i = C17602.$SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[type.ordinal()];
        if (i == 1) {
            TextView textView = this.workingWellText;
            NumberFormat integerInstance = NumberFormat.getIntegerInstance();
            $jacocoInit[667] = true;
            String format = integerInstance.format(Double.parseDouble(countAsString));
            $jacocoInit[668] = true;
            textView.setText(format);
            $jacocoInit[669] = true;
        } else if (i == 2) {
            TextView textView2 = this.needsLicenceText;
            NumberFormat integerInstance2 = NumberFormat.getIntegerInstance();
            $jacocoInit[676] = true;
            String format2 = integerInstance2.format(Double.parseDouble(countAsString));
            $jacocoInit[677] = true;
            textView2.setText(format2);
            $jacocoInit[678] = true;
        } else if (i == 3) {
            TextView textView3 = this.fakeAppText;
            NumberFormat integerInstance3 = NumberFormat.getIntegerInstance();
            $jacocoInit[673] = true;
            String format3 = integerInstance3.format(Double.parseDouble(countAsString));
            $jacocoInit[674] = true;
            textView3.setText(format3);
            $jacocoInit[675] = true;
        } else if (i == 4) {
            TextView textView4 = this.virusText;
            NumberFormat integerInstance4 = NumberFormat.getIntegerInstance();
            $jacocoInit[670] = true;
            String format4 = integerInstance4.format(Double.parseDouble(countAsString));
            $jacocoInit[671] = true;
            textView4.setText(format4);
            $jacocoInit[672] = true;
        } else if (i == 5) {
            $jacocoInit[679] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to find Type ");
            sb.append(type.name());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
            $jacocoInit[680] = true;
            throw illegalArgumentException;
        }
        $jacocoInit[681] = true;
    }

    private void setDeveloperDetails(AppDeveloper developer) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!TextUtils.isEmpty(developer.getWebsite())) {
            $jacocoInit[682] = true;
            this.infoWebsite.setVisibility(0);
            $jacocoInit[683] = true;
        } else {
            this.infoWebsite.setVisibility(8);
            $jacocoInit[684] = true;
        }
        if (!TextUtils.isEmpty(developer.getEmail())) {
            $jacocoInit[685] = true;
            this.infoEmail.setVisibility(0);
            $jacocoInit[686] = true;
        } else {
            this.infoEmail.setVisibility(8);
            $jacocoInit[687] = true;
        }
        if (!TextUtils.isEmpty(developer.getPrivacy())) {
            $jacocoInit[688] = true;
            this.infoPrivacy.setVisibility(0);
            $jacocoInit[689] = true;
        } else {
            this.infoPrivacy.setVisibility(8);
            $jacocoInit[690] = true;
        }
        $jacocoInit[691] = true;
    }

    private void showReviews(boolean hasReviews, int gRating, float avgRating) {
        boolean[] $jacocoInit = $jacocoInit();
        this.topReviewsProgress.setVisibility(8);
        $jacocoInit[692] = true;
        this.reviewUsers.setText(StringU.withSuffix((long) gRating));
        if (avgRating == 0.0f) {
            $jacocoInit[693] = true;
            this.avgReviewScore.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[694] = true;
        } else {
            this.avgReviewScore.setText(String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(avgRating)}));
            $jacocoInit[695] = true;
        }
        this.avgReviewScoreBar.setRating(avgRating);
        if (hasReviews) {
            $jacocoInit[696] = true;
            this.ratingLayout.setVisibility(0);
            $jacocoInit[697] = true;
            this.emptyReviewsLayout.setVisibility(8);
            $jacocoInit[698] = true;
            this.topReviewsLayout.setVisibility(0);
            $jacocoInit[699] = true;
            this.rateAppButtonLarge.setVisibility(8);
            $jacocoInit[700] = true;
            this.rateAppButton.setVisibility(0);
            $jacocoInit[701] = true;
        } else {
            this.ratingLayout.setVisibility(0);
            $jacocoInit[702] = true;
            this.emptyReviewsLayout.setVisibility(0);
            $jacocoInit[703] = true;
            this.topReviewsLayout.setVisibility(8);
            $jacocoInit[704] = true;
            this.rateAppButtonLarge.setVisibility(0);
            $jacocoInit[705] = true;
            this.rateAppButton.setVisibility(8);
            if (gRating != 0) {
                $jacocoInit[706] = true;
            } else {
                $jacocoInit[707] = true;
                this.emptyReviewTextView.setText(C1375R.string.appview_rate_this_app);
                $jacocoInit[708] = true;
            }
        }
        $jacocoInit[709] = true;
    }

    private void showHideOptionsMenu(boolean visible) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[710] = true;
        while (i < this.menu.size()) {
            $jacocoInit[711] = true;
            MenuItem item = this.menu.getItem(i);
            $jacocoInit[712] = true;
            showHideOptionsMenu(item, visible);
            i++;
            $jacocoInit[713] = true;
        }
        $jacocoInit[714] = true;
    }

    /* access modifiers changed from: protected */
    public void showHideOptionsMenu(MenuItem item, boolean visible) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item == null) {
            $jacocoInit[715] = true;
        } else {
            $jacocoInit[716] = true;
            item.setVisible(visible);
            $jacocoInit[717] = true;
        }
        $jacocoInit[718] = true;
    }

    public void setupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar.setTitle((CharSequence) "");
        $jacocoInit[719] = true;
        C0019n activity = (C0019n) getActivity();
        $jacocoInit[720] = true;
        activity.setSupportActionBar(this.toolbar);
        $jacocoInit[721] = true;
        this.actionBar = activity.getSupportActionBar();
        C0760a aVar = this.actionBar;
        if (aVar == null) {
            $jacocoInit[722] = true;
        } else {
            $jacocoInit[723] = true;
            aVar.mo6153d(true);
            $jacocoInit[724] = true;
            this.actionBar.mo6147a(this.toolbar.getTitle());
            $jacocoInit[725] = true;
        }
        $jacocoInit[726] = true;
    }

    private SpannableString formatAppCoinsRewardMessage(String rewardValue) {
        SpannableString spannable;
        String tryAppMessage;
        boolean[] $jacocoInit = $jacocoInit();
        String reward = "AppCoins Credits";
        $jacocoInit[727] = true;
        if (!rewardValue.equals("-1.0")) {
            $jacocoInit[728] = true;
            tryAppMessage = getResources().getString(C1375R.string.appc_message_appview_appcoins_reward_with_value, new Object[]{rewardValue, reward});
            $jacocoInit[729] = true;
            spannable = new SpannableString(tryAppMessage);
            $jacocoInit[730] = true;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(C1375R.color.default_orange_gradient_end));
            $jacocoInit[731] = true;
            int indexOf = tryAppMessage.indexOf(rewardValue);
            $jacocoInit[732] = true;
            int indexOf2 = tryAppMessage.indexOf(rewardValue) + rewardValue.length();
            $jacocoInit[733] = true;
            spannable.setSpan(foregroundColorSpan, indexOf, indexOf2, 33);
            $jacocoInit[734] = true;
        } else {
            $jacocoInit[735] = true;
            tryAppMessage = getResources().getString(C1375R.string.appc_message_appview_appcoins_reward, new Object[]{reward});
            $jacocoInit[736] = true;
            spannable = new SpannableString(tryAppMessage);
            $jacocoInit[737] = true;
        }
        $jacocoInit[738] = true;
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(getResources().getColor(C1375R.color.default_orange_gradient_end));
        $jacocoInit[739] = true;
        int indexOf3 = tryAppMessage.indexOf(reward);
        int indexOf4 = tryAppMessage.indexOf(reward) + reward.length();
        $jacocoInit[740] = true;
        spannable.setSpan(foregroundColorSpan2, indexOf3, indexOf4, 33);
        $jacocoInit[741] = true;
        return spannable;
    }

    public C0120S<Action> installAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Action> cVar = this.installClickSubject;
        $jacocoInit[742] = true;
        return cVar;
    }

    public C0120S<Boolean> showRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[743] = true;
        String string = getResources().getString(C1375R.string.root_access_dialog);
        $jacocoInit[744] = true;
        C0120S createGenericYesNoCancelMessage = GenericDialogs.createGenericYesNoCancelMessage(context, null, string);
        C2131l lVar = C2131l.f5194a;
        $jacocoInit[745] = true;
        C0120S<Boolean> j = createGenericYesNoCancelMessage.mo3669j(lVar);
        $jacocoInit[746] = true;
        return j;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m6500g(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(response.equals(EResponse.YES));
        $jacocoInit[919] = true;
        return valueOf;
    }

    public void showDownloadAppModel(DownloadAppViewModel model, boolean hasDonations) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = model.getDownloadModel();
        $jacocoInit[747] = true;
        AppCoinsViewModel appCoinsViewModel = model.getAppCoinsViewModel();
        $jacocoInit[748] = true;
        this.action = downloadModel.getAction();
        $jacocoInit[749] = true;
        if (downloadModel.getAction() != Action.PAY) {
            $jacocoInit[750] = true;
        } else {
            $jacocoInit[751] = true;
            registerPaymentResult();
            $jacocoInit[752] = true;
        }
        if (downloadModel.isDownloadingOrInstalling()) {
            $jacocoInit[753] = true;
            this.appcInfoView.hideInfo();
            $jacocoInit[754] = true;
            this.downloadInfoLayout.setVisibility(0);
            $jacocoInit[755] = true;
            this.install.setVisibility(8);
            $jacocoInit[756] = true;
            setDownloadState(downloadModel.getProgress(), downloadModel.getDownloadState());
            $jacocoInit[757] = true;
        } else {
            if (!this.action.equals(Action.MIGRATE)) {
                $jacocoInit[758] = true;
                AppViewAppcInfoViewHolder appViewAppcInfoViewHolder = this.appcInfoView;
                AppCoinsAdvertisingModel advertisingModel = appCoinsViewModel.getAdvertisingModel();
                $jacocoInit[759] = true;
                boolean hasAdvertising = advertisingModel.getHasAdvertising();
                boolean hasBilling = appCoinsViewModel.hasBilling();
                $jacocoInit[760] = true;
                AppCoinsAdvertisingModel advertisingModel2 = appCoinsViewModel.getAdvertisingModel();
                $jacocoInit[761] = true;
                String reward = advertisingModel2.getReward();
                $jacocoInit[762] = true;
                SpannableString formatAppCoinsRewardMessage = formatAppCoinsRewardMessage(reward);
                $jacocoInit[763] = true;
                appViewAppcInfoViewHolder.showInfo(hasAdvertising, hasBilling, formatAppCoinsRewardMessage);
                $jacocoInit[764] = true;
            } else {
                this.appcRewardView.setVisibility(8);
                $jacocoInit[765] = true;
                this.appcMigrationWarningMessage.setVisibility(0);
                $jacocoInit[766] = true;
            }
            this.downloadInfoLayout.setVisibility(8);
            $jacocoInit[767] = true;
            this.install.setVisibility(0);
            $jacocoInit[768] = true;
            setButtonText(downloadModel);
            $jacocoInit[769] = true;
            if (!downloadModel.hasError()) {
                $jacocoInit[770] = true;
            } else {
                $jacocoInit[771] = true;
                handleDownloadError(downloadModel.getDownloadState());
                $jacocoInit[772] = true;
            }
        }
        $jacocoInit[773] = true;
    }

    public void openApp(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        SystemU.openApp(packageName, getContext().getPackageManager(), getContext());
        $jacocoInit[774] = true;
    }

    public C0120S<Boolean> showDowngradeMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[775] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[776] = true;
        String string = resources.getString(C1375R.string.downgrade_warning_dialog);
        $jacocoInit[777] = true;
        C0120S createGenericContinueCancelMessage = GenericDialogs.createGenericContinueCancelMessage(context, null, string);
        C2161o oVar = C2161o.f5226a;
        $jacocoInit[778] = true;
        C0120S<Boolean> j = createGenericContinueCancelMessage.mo3669j(oVar);
        $jacocoInit[779] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6482a(EResponse eResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(eResponse.equals(EResponse.YES));
        $jacocoInit[918] = true;
        return valueOf;
    }

    public void showDowngradingMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1623a(getView(), (int) C1375R.string.downgrading_msg, -1);
        $jacocoInit[780] = true;
        a.mo4690h();
        $jacocoInit[781] = true;
    }

    public C0120S<Void> pauseDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.pauseDownload);
        $jacocoInit[782] = true;
        return a;
    }

    public C0120S<Action> resumeDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.resumeDownload);
        C2238w wVar = new C2238w(this);
        $jacocoInit[783] = true;
        C0120S<Action> j = a.mo3669j(wVar);
        $jacocoInit[784] = true;
        return j;
    }

    /* renamed from: e */
    public /* synthetic */ Action mo10459e(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = this.action;
        $jacocoInit[917] = true;
        return action2;
    }

    public C0120S<Void> cancelDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.cancelDownload);
        $jacocoInit[785] = true;
        return a;
    }

    public C0120S<Void> isAppViewReadyToDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.ready;
        $jacocoInit[786] = true;
        return cVar;
    }

    public void readyToDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        this.ready.onNext(null);
        $jacocoInit[787] = true;
    }

    public C0120S<AppBoughClickEvent> appBought() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AppBoughClickEvent> cVar = this.appBought;
        $jacocoInit[788] = true;
        return cVar;
    }

    private void handleDownloadError(DownloadState downloadState) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C17602.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()];
        if (i == 5) {
            showErrorDialog("", getContext().getString(C1375R.string.error_occured));
            $jacocoInit[789] = true;
        } else if (i == 6) {
            String string = getContext().getString(C1375R.string.out_of_space_dialog_title);
            $jacocoInit[790] = true;
            String string2 = getContext().getString(C1375R.string.out_of_space_dialog_message);
            $jacocoInit[791] = true;
            showErrorDialog(string, string2);
            $jacocoInit[792] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Download State ");
            sb.append(downloadState);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[793] = true;
            throw illegalStateException;
        }
        $jacocoInit[794] = true;
    }

    private void registerPaymentResult() {
        boolean[] $jacocoInit = $jacocoInit();
        AppBoughtReceiver appBoughtReceiver = new AppBoughtReceiver(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ AppViewFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-2788567543673630823L, "cm/aptoide/pt/app/view/AppViewFragment$1", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void appBought(long appId, String path) {
                boolean[] $jacocoInit = $jacocoInit();
                AppViewFragment.access$000(this.this$0).onNext(new AppBoughClickEvent(path, appId));
                $jacocoInit[1] = true;
            }
        };
        $jacocoInit[795] = true;
        getContext().registerReceiver(appBoughtReceiver, new IntentFilter(AppBoughtReceiver.APP_BOUGHT));
        $jacocoInit[796] = true;
    }

    private void setDownloadState(int progress, DownloadState downloadState) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutParams pauseShowing = new LayoutParams(-1, -1, 4.0f);
        $jacocoInit[797] = true;
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2.0f);
        $jacocoInit[798] = true;
        LayoutParams pauseHidden = layoutParams;
        String str = "%";
        switch (C17602.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()]) {
            case 1:
                this.downloadProgressBar.setIndeterminate(false);
                $jacocoInit[800] = true;
                this.downloadProgressBar.setProgress(progress);
                $jacocoInit[801] = true;
                TextView textView = this.downloadProgressValue;
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(progress));
                sb.append(str);
                textView.setText(sb.toString());
                $jacocoInit[802] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[803] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[804] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[805] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[806] = true;
                this.installStateText.setText(getString(C1375R.string.appview_short_downloading));
                $jacocoInit[807] = true;
                break;
            case 2:
                this.downloadProgressBar.setIndeterminate(true);
                $jacocoInit[808] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[809] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[810] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[811] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[812] = true;
                this.installStateText.setText(getString(C1375R.string.appview_short_downloading));
                $jacocoInit[813] = true;
                break;
            case 3:
                this.downloadProgressBar.setIndeterminate(false);
                $jacocoInit[814] = true;
                this.downloadProgressBar.setProgress(progress);
                $jacocoInit[815] = true;
                TextView textView2 = this.downloadProgressValue;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.valueOf(progress));
                sb2.append(str);
                textView2.setText(sb2.toString());
                $jacocoInit[816] = true;
                this.pauseDownload.setVisibility(8);
                $jacocoInit[817] = true;
                this.cancelDownload.setVisibility(0);
                $jacocoInit[818] = true;
                this.resumeDownload.setVisibility(0);
                $jacocoInit[819] = true;
                this.downloadControlsLayout.setLayoutParams(pauseHidden);
                $jacocoInit[820] = true;
                this.installStateText.setText(getString(C1375R.string.appview_short_downloading));
                $jacocoInit[821] = true;
                break;
            case 4:
                this.downloadProgressBar.setIndeterminate(true);
                $jacocoInit[822] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[823] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[824] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[825] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[826] = true;
                this.installStateText.setText(getString(C1375R.string.appview_short_downloading));
                $jacocoInit[827] = true;
                break;
            case 5:
                showErrorDialog("", getContext().getString(C1375R.string.error_occured));
                $jacocoInit[834] = true;
                break;
            case 6:
                String string = getContext().getString(C1375R.string.out_of_space_dialog_title);
                $jacocoInit[835] = true;
                String string2 = getContext().getString(C1375R.string.out_of_space_dialog_message);
                $jacocoInit[836] = true;
                showErrorDialog(string, string2);
                $jacocoInit[837] = true;
                break;
            case 7:
                this.downloadProgressBar.setIndeterminate(true);
                $jacocoInit[828] = true;
                this.pauseDownload.setVisibility(8);
                $jacocoInit[829] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[830] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[831] = true;
                this.downloadControlsLayout.setLayoutParams(pauseHidden);
                $jacocoInit[832] = true;
                this.installStateText.setText(getString(C1375R.string.appview_short_installing));
                $jacocoInit[833] = true;
                break;
            default:
                $jacocoInit[799] = true;
                break;
        }
        $jacocoInit[838] = true;
    }

    private void showErrorDialog(String title, String message) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S createGenericOkMessage = GenericDialogs.createGenericOkMessage(getContext(), title, message);
        $jacocoInit[839] = true;
        C0120S b = createGenericOkMessage.mo3634b(C14522a.m46170a());
        C2101i iVar = C2101i.f5160a;
        C2229v vVar = C2229v.f5302a;
        $jacocoInit[840] = true;
        this.errorMessageSubscription = b.mo3626a((C0129b<? super T>) iVar, (C0129b<Throwable>) vVar);
        $jacocoInit[841] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6484a(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        new OnErrorNotImplementedException(error);
        $jacocoInit[915] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6489b(EResponse eResponse) {
        $jacocoInit()[916] = true;
    }

    private void setButtonText(DownloadModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = model.getAction();
        $jacocoInit[842] = true;
        switch (C17602.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[action2.ordinal()]) {
            case 1:
                this.install.setText(getResources().getString(C1375R.string.appview_button_update));
                $jacocoInit[844] = true;
                break;
            case 2:
                this.install.setText(getResources().getString(C1375R.string.appview_button_install));
                $jacocoInit[845] = true;
                break;
            case 3:
                this.install.setText(getResources().getString(C1375R.string.appview_button_open));
                $jacocoInit[846] = true;
                break;
            case 4:
                this.install.setText(getResources().getString(C1375R.string.appview_button_downgrade));
                $jacocoInit[847] = true;
                break;
            case 5:
                Button button = this.install;
                $jacocoInit[848] = true;
                $jacocoInit[849] = true;
                Pay pay = model.getPay();
                $jacocoInit[850] = true;
                Pay pay2 = model.getPay();
                $jacocoInit[851] = true;
                double price = pay2.getPrice();
                $jacocoInit[852] = true;
                Object[] objArr = {getContext().getString(C1375R.string.appview_button_buy), pay.getSymbol(), Double.valueOf(price)};
                $jacocoInit[853] = true;
                String format = String.format("%s (%s %s)", objArr);
                $jacocoInit[854] = true;
                button.setText(format);
                $jacocoInit[855] = true;
                break;
            case 6:
                this.install.setText(getResources().getString(C1375R.string.promo_update2appc_appview_update_button));
                $jacocoInit[856] = true;
                break;
            default:
                $jacocoInit[843] = true;
                break;
        }
        $jacocoInit[857] = true;
    }

    public void buyApp(long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[858] = true;
        Intent intent = BillingActivity.getIntent(getActivity(), appId, "cm.aptoide.pt");
        $jacocoInit[859] = true;
        startActivityForResult(intent, 12);
        $jacocoInit[860] = true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Bundle data;
        boolean[] $jacocoInit = $jacocoInit();
        if (requestCode == 12) {
            try {
                $jacocoInit[861] = true;
                if (intent != null) {
                    data = intent.getExtras();
                    $jacocoInit[862] = true;
                } else {
                    data = null;
                    $jacocoInit[863] = true;
                }
                PurchaseBundleMapper purchaseBundleMapper2 = this.purchaseBundleMapper;
                $jacocoInit[864] = true;
                PaidAppPurchase purchase = (PaidAppPurchase) purchaseBundleMapper2.map(resultCode, data);
                $jacocoInit[865] = true;
                C0014p fragmentActivity = getActivity();
                $jacocoInit[866] = true;
                Intent installApp = new Intent(AppBoughtReceiver.APP_BOUGHT);
                $jacocoInit[867] = true;
                installApp.putExtra("appId", purchase.getProductId());
                $jacocoInit[868] = true;
                installApp.putExtra(AppBoughtReceiver.APP_PATH, purchase.getApkPath());
                $jacocoInit[869] = true;
                fragmentActivity.sendBroadcast(installApp);
                $jacocoInit[870] = true;
            } catch (Throwable throwable) {
                if (throwable instanceof BillingException) {
                    $jacocoInit[871] = true;
                    Snackbar.m1623a(getView(), (int) C1375R.string.user_cancelled, -1);
                    $jacocoInit[872] = true;
                } else {
                    Snackbar.m1623a(getView(), (int) C1375R.string.unknown_error, -1);
                    $jacocoInit[873] = true;
                }
                $jacocoInit[874] = true;
            }
        } else {
            super.onActivityResult(requestCode, resultCode, intent);
            $jacocoInit[875] = true;
        }
        $jacocoInit[876] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[877] = true;
        View inflate = inflater.inflate(C1375R.layout.fragment_app_view, container, false);
        $jacocoInit[878] = true;
        return inflate;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            $jacocoInit[879] = true;
        } else {
            $jacocoInit[880] = true;
            outState.putInt("y", nestedScrollView.getScrollY());
            $jacocoInit[881] = true;
        }
        $jacocoInit[882] = true;
    }

    private C0120S<EResponse> createCustomDialogForApkfy(String appName2, double appc, float rating, String icon, int downloads) {
        boolean[] $jacocoInit = $jacocoInit();
        C2028d dVar = new C2028d(this, appName2, rating, appc, downloads, icon);
        C0120S<EResponse> a = C0120S.m634a((C0122a<T>) dVar);
        $jacocoInit[883] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10411a(String appName2, float rating, double appc, int downloads, String icon, C14980ia subscriber) {
        String str = appName2;
        double d = appc;
        C14980ia iaVar = subscriber;
        boolean[] $jacocoInit = $jacocoInit();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        $jacocoInit[884] = true;
        View dialogLayout = inflater.inflate(C1375R.layout.apkfy_new_dialog, null);
        $jacocoInit[885] = true;
        C0775a aVar = new C0775a(getContext());
        aVar.mo6235b(dialogLayout);
        $jacocoInit[886] = true;
        C0774m dialog = aVar.mo6231a();
        $jacocoInit[887] = true;
        ((TextView) dialogLayout.findViewById(C1375R.C1376id.app_name)).setText(str);
        $jacocoInit[888] = true;
        TextView textView = (TextView) dialogLayout.findViewById(C1375R.C1376id.app_rating);
        DecimalFormat decimalFormat = this.oneDecimalFormat;
        double d2 = (double) rating;
        $jacocoInit[889] = true;
        String format = decimalFormat.format(d2);
        $jacocoInit[890] = true;
        textView.setText(format);
        if (d > 0.0d) {
            $jacocoInit[891] = true;
            TextView textView2 = (TextView) dialogLayout.findViewById(C1375R.C1376id.appc_value);
            DecimalFormat decimalFormat2 = new DecimalFormat("0.00");
            $jacocoInit[892] = true;
            String format2 = decimalFormat2.format(d);
            $jacocoInit[893] = true;
            textView2.setText(format2);
            $jacocoInit[894] = true;
        } else {
            View findViewById = dialogLayout.findViewById(C1375R.C1376id.appc_layout);
            $jacocoInit[895] = true;
            findViewById.setVisibility(8);
            $jacocoInit[896] = true;
        }
        TextView textView3 = (TextView) dialogLayout.findViewById(C1375R.C1376id.app_downloads);
        long j = (long) downloads;
        $jacocoInit[897] = true;
        $jacocoInit[898] = true;
        Object[] objArr = {StringU.withSuffix(j), getResources().getString(C1375R.string.downloads)};
        $jacocoInit[899] = true;
        String format3 = String.format("%s %s", objArr);
        $jacocoInit[900] = true;
        textView3.setText(format3);
        $jacocoInit[901] = true;
        ImageLoader with = ImageLoader.with(getContext());
        $jacocoInit[902] = true;
        with.load(icon, (ImageView) dialogLayout.findViewById(C1375R.C1376id.app_icon));
        $jacocoInit[903] = true;
        View findViewById2 = dialogLayout.findViewById(C1375R.C1376id.positive_button);
        C2081g gVar = new C2081g(this, iaVar, str);
        $jacocoInit[904] = true;
        findViewById2.setOnClickListener(gVar);
        $jacocoInit[905] = true;
        View findViewById3 = dialogLayout.findViewById(C1375R.C1376id.negative_button);
        C1881O o = new C1881O(iaVar);
        $jacocoInit[906] = true;
        findViewById3.setOnClickListener(o);
        $jacocoInit[907] = true;
        dialog.getClass();
        iaVar.add(C14978f.m46781a(new C2090gi(dialog)));
        $jacocoInit[908] = true;
        dialog.show();
        $jacocoInit[909] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10413a(C14980ia subscriber, String appName2, View listener) {
        boolean[] $jacocoInit = $jacocoInit();
        subscriber.onNext(EResponse.YES);
        $jacocoInit[912] = true;
        subscriber.onCompleted();
        $jacocoInit[913] = true;
        this.apkfyDialogConfirmSubject.onNext(appName2);
        $jacocoInit[914] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6485a(C14980ia subscriber, View listener) {
        boolean[] $jacocoInit = $jacocoInit();
        subscriber.onNext(EResponse.CANCEL);
        $jacocoInit[910] = true;
        subscriber.onCompleted();
        $jacocoInit[911] = true;
    }
}
