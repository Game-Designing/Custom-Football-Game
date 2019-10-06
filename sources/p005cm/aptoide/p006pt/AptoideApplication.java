package p005cm.aptoide.p006pt;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.crashlytics.android.C0075a;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkConfiguration.Builder;
import com.mopub.common.logging.MoPubLog.LogLevel;
import com.mopub.mobileads.GooglePlayServicesAdapterConfiguration;
import com.mopub.nativeads.AppLovinBaseAdapterConfiguration;
import com.mopub.nativeads.InMobiBaseAdapterConfiguration;
import com.mopub.nativeads.InneractiveAdapterConfiguration;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.xmlpull.v1.XmlPullParserException;
import p002b.p003c.p004f.C0021a;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.account.MatureBodyInterceptorV7;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.AdsUserPropertyManager;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p005cm.aptoide.p006pt.billing.Billing;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.BillingPool;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingSerializer;
import p005cm.aptoide.p006pt.billing.payment.Adyen;
import p005cm.aptoide.p006pt.billing.purchase.PurchaseFactory;
import p005cm.aptoide.p006pt.billing.view.PaymentThrowableCodeMapper;
import p005cm.aptoide.p006pt.billing.view.PurchaseBundleMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p005cm.aptoide.p006pt.database.accessors.NotificationAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreMetaRequest;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p005cm.aptoide.p006pt.file.FileManager;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p005cm.aptoide.p006pt.leak.LeakTool;
import p005cm.aptoide.p006pt.link.AptoideInstallParser;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationCenter;
import p005cm.aptoide.p006pt.notification.NotificationInfo;
import p005cm.aptoide.p006pt.notification.NotificationPolicyFactory;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.NotificationSyncScheduler;
import p005cm.aptoide.p006pt.notification.NotificationsCleaner;
import p005cm.aptoide.p006pt.notification.SystemNotificationShower;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;
import p005cm.aptoide.p006pt.preferences.managed.ManagedKeys;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferencesImplementation;
import p005cm.aptoide.p006pt.presenter.View;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p005cm.aptoide.p006pt.sync.alarm.SyncStorage;
import p005cm.aptoide.p006pt.sync.p014rx.RxSyncScheduler;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p005cm.aptoide.p006pt.util.PreferencesXmlParser;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p005cm.aptoide.p006pt.utils.SecurityUtils;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p005cm.aptoide.p006pt.view.ActivityModule;
import p005cm.aptoide.p006pt.view.ActivityProvider;
import p005cm.aptoide.p006pt.view.BaseActivity;
import p005cm.aptoide.p006pt.view.BaseFragment;
import p005cm.aptoide.p006pt.view.FragmentModule;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.entry.EntryActivity;
import p005cm.aptoide.p006pt.view.entry.EntryPointChooser;
import p005cm.aptoide.p006pt.view.recycler.DisplayableWidgetMapping;
import p019d.p020e.p021a.C7294e.C0098a;
import p019d.p022i.p023b.C0099b;
import p019d.p022i.p023b.C0100e;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.AptoideApplication */
public abstract class AptoideApplication extends Application {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final String CACHE_FILE_NAME = "aptoide.wscache";
    private static final String TAG = AptoideApplication.class.getName();
    private static ActivityProvider activityProvider;
    private static boolean autoUpdateWasCalled = false;
    private static DisplayableWidgetMapping displayableWidgetMapping;
    private static FragmentProvider fragmentProvider;
    @Inject
    AptoideAccountManager accountManager;
    @Inject
    BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV7;
    private BodyInterceptor<BaseBody> accountSettingsBodyInterceptorWebV7;
    @Inject
    AdsRepository adsRepository;
    @Inject
    AdsUserPropertyManager adsUserPropertyManager;
    @Inject
    AdultContent adultContent;
    @Inject
    AdultContentAnalytics adultContentAnalytics;

    /* renamed from: adyen reason: collision with root package name */
    private Adyen f44397adyen;
    @Inject
    SyncScheduler alarmSyncScheduler;
    @Inject
    AnalyticsManager analyticsManager;
    private ApplicationComponent applicationComponent;
    @Inject
    AdsApplicationVersionCodeProvider applicationVersionCodeProvider;
    @Inject
    AptoideDownloadManager aptoideDownloadManager;
    private String aptoideMd5sum;
    @Inject
    AuthenticationPersistence authenticationPersistence;
    private BillingAnalytics billingAnalytics;
    private BillingPool billingPool;
    @Inject
    BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    @Inject
    BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3;
    @Inject
    BodyInterceptor<BaseBody> bodyInterceptorWebV7;
    @Inject
    CacheHelper cacheHelper;
    @Inject
    C0075a crashlytics;
    @Inject
    Database database;
    @Inject
    OkHttpClient defaultClient;
    @Inject
    List<String> defaultFollowedStores;
    private EntryPointChooser entryPointChooser;
    private FileManager fileManager;
    @Inject
    FirstLaunchAnalytics firstLaunchAnalytics;
    private Map<Integer, Result> fragmentResulMap;
    private C0099b<Map<Integer, Result>> fragmentResultRelay;
    @Inject
    L2Cache httpClientCache;
    @Inject
    IdsRepository idsRepository;
    private ExternalBillingSerializer inAppBillingSerialzer;
    @Inject
    InstallManager installManager;
    @Inject
    InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager;
    private LeakTool leakTool;
    @Inject
    NavigationTracker navigationTracker;
    @Inject
    NotificationAnalytics notificationAnalytics;
    private NotificationCenter notificationCenter;
    private NotificationProvider notificationProvider;
    private NotificationsCleaner notificationsCleaner;
    private C0100e<NotificationInfo> notificationsPublishRelay;
    @Inject
    PackageRepository packageRepository;
    private PaymentThrowableCodeMapper paymentThrowableCodeMapper;
    @Inject
    Preferences preferences;
    private PurchaseBundleMapper purchaseBundleMapper;
    private PurchaseFactory purchaseFactory;
    @Inject
    QManager qManager;
    @Inject
    RootAvailabilityManager rootAvailabilityManager;
    @Inject
    RootInstallationRetryHandler rootInstallationRetryHandler;
    @Inject
    SearchSuggestionManager searchSuggestionManager;
    @Inject
    SecurePreferences securePreferences;
    @Inject
    SettingsManager settingsManager;
    @Inject
    AptoideShortcutManager shortcutManager;
    @Inject
    SyncStorage syncStorage;
    @Inject
    TokenInvalidator tokenInvalidator;
    @Inject
    TrendingManager trendingManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4367931007680741713L, "cm/aptoide/pt/AptoideApplication", 373);
        $jacocoData = probes;
        return probes;
    }

    public abstract ActivityProvider createActivityProvider();

    public abstract FragmentProvider createFragmentProvider();

    public abstract String getAccountType();

    public abstract String getCachePath();

    public abstract String getExtraId();

    public abstract String getFeedbackEmail();

    public abstract NotificationSyncScheduler getNotificationSyncScheduler();

    public abstract String getPartnerId();

    /* access modifiers changed from: protected */
    public abstract SystemNotificationShower getSystemNotificationShower();

    public abstract boolean isCreateStoreUserPrivacyEnabled();

    public AptoideApplication() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[372] = true;
    }

    public static FragmentProvider getFragmentProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentProvider fragmentProvider2 = fragmentProvider;
        $jacocoInit[1] = true;
        return fragmentProvider2;
    }

    public static ActivityProvider getActivityProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityProvider activityProvider2 = activityProvider;
        $jacocoInit[2] = true;
        return activityProvider2;
    }

    public static DisplayableWidgetMapping getDisplayableWidgetMapping() {
        boolean[] $jacocoInit = $jacocoInit();
        DisplayableWidgetMapping displayableWidgetMapping2 = displayableWidgetMapping;
        $jacocoInit[3] = true;
        return displayableWidgetMapping2;
    }

    public static boolean isAutoUpdateWasCalled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = autoUpdateWasCalled;
        $jacocoInit[4] = true;
        return z;
    }

    public static void setAutoUpdateWasCalled(boolean autoUpdateWasCalled2) {
        boolean[] $jacocoInit = $jacocoInit();
        autoUpdateWasCalled = autoUpdateWasCalled2;
        $jacocoInit[5] = true;
    }

    public LeakTool getLeakTool() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.leakTool != null) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            this.leakTool = new LeakTool();
            $jacocoInit[8] = true;
        }
        LeakTool leakTool2 = this.leakTool;
        $jacocoInit[9] = true;
        return leakTool2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r14 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.ApplicationComponent r1 = r14.getApplicationComponent()
            r1.inject(r14)
            r1 = 1
            r2 = 10
            r0[r2] = r1
            cm.aptoide.pt.crashreports.CrashReport r2 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            cm.aptoide.pt.crashreports.CrashlyticsCrashLogger r3 = new cm.aptoide.pt.crashreports.CrashlyticsCrashLogger
            com.crashlytics.android.a r4 = r14.crashlytics
            r3.<init>(r4)
            r4 = 11
            r0[r4] = r1
            cm.aptoide.pt.crashreports.CrashReport r2 = r2.addLogger(r3)
            cm.aptoide.pt.crashreports.ConsoleLogger r3 = new cm.aptoide.pt.crashreports.ConsoleLogger
            r3.<init>()
            r4 = 12
            r0[r4] = r1
            r2.addLogger(r3)
            r2 = 13
            r0[r2] = r1
            android.content.SharedPreferences r2 = r14.getDefaultSharedPreferences()
            boolean r2 = p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.isDebug(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0043
            r2 = 14
            r0[r2] = r1
            goto L_0x004b
        L_0x0043:
            boolean r2 = p005cm.aptoide.p006pt.BuildConfig.DEBUG
            if (r2 == 0) goto L_0x0051
            r2 = 15
            r0[r2] = r1
        L_0x004b:
            r2 = 16
            r0[r2] = r1
            r2 = 1
            goto L_0x0056
        L_0x0051:
            r2 = 17
            r0[r2] = r1
            r2 = 0
        L_0x0056:
            p005cm.aptoide.p006pt.logger.Logger.setDBG(r2)
            r2 = 18
            r0[r2] = r1     // Catch:{ Exception -> 0x0065 }
            p005cm.aptoide.p006pt.preferences.PRNGFixes.apply()     // Catch:{ Exception -> 0x0065 }
            r2 = 19
            r0[r2] = r1
            goto L_0x0079
        L_0x0065:
            r2 = move-exception
            r4 = 20
            r0[r4] = r1
            cm.aptoide.pt.crashreports.CrashReport r4 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r5 = 21
            r0[r5] = r1
            r4.log(r2)
            r4 = 22
            r0[r4] = r1
        L_0x0079:
            super.onCreate()
            r2 = 23
            r0[r2] = r1
            r14.initializeMoPub()
            r2 = 24
            r0[r2] = r1
            long r4 = java.lang.System.currentTimeMillis()
            r2 = 25
            r0[r2] = r1
            cm.aptoide.pt.leak.LeakTool r2 = r14.getLeakTool()
            r2.setup(r14)
            r2 = 26
            r0[r2] = r1
            cm.aptoide.pt.view.FragmentProvider r2 = r14.createFragmentProvider()
            fragmentProvider = r2
            r2 = 27
            r0[r2] = r1
            cm.aptoide.pt.view.ActivityProvider r2 = r14.createActivityProvider()
            activityProvider = r2
            r2 = 28
            r0[r2] = r1
            cm.aptoide.pt.view.recycler.DisplayableWidgetMapping r2 = r14.createDisplayableWidgetMapping()
            displayableWidgetMapping = r2
            r2 = 29
            r0[r2] = r1
            rx.M r2 = r14.checkAppSecurity()
            rx.M r6 = r14.generateAptoideUuid()
            rx.M r2 = r2.mo3580a(r6)
            r6 = 30
            r0[r6] = r1
            rx.V r6 = p026rx.schedulers.Schedulers.computation()
            rx.M r2 = r2.mo3581a(r6)
            r6 = 31
            r0[r6] = r1
            cm.aptoide.accountmanager.AptoideAccountManager r6 = r14.getAccountManager()
            rx.M r6 = r14.prepareApp(r6)
            cm.aptoide.pt.D r7 = p005cm.aptoide.p006pt.C0036D.f34a
            rx.M r6 = r6.mo3585a(r7)
            rx.M r2 = r2.mo3580a(r6)
            r6 = 32
            r0[r6] = r1
            rx.M r6 = r14.discoverAndSaveInstalledApps()
            rx.M r2 = r2.mo3580a(r6)
            cm.aptoide.pt.s r6 = p005cm.aptoide.p006pt.C0066s.f77a
            cm.aptoide.pt.y r7 = p005cm.aptoide.p006pt.C0073y.f84a
            r8 = 33
            r0[r8] = r1
            r2.mo3588a(r6, r7)
            r2 = 34
            r0[r2] = r1
            rx.M r2 = r14.sendAppStartToAnalytics()
            cm.aptoide.pt.i r6 = new cm.aptoide.pt.i
            r6.<init>(r14)
            rx.M r2 = r2.mo3582a(r6)
            cm.aptoide.pt.z r6 = p005cm.aptoide.p006pt.C0074z.f85a
            cm.aptoide.pt.p r7 = p005cm.aptoide.p006pt.C0056p.f72a
            r8 = 35
            r0[r8] = r1
            r2.mo3588a(r6, r7)
            r2 = 36
            r0[r2] = r1
            java.lang.String r2 = "X89WPPSKWQB2FT6B8F3X"
            r14.initializeFlurry(r14, r2)
            r2 = 37
            r0[r2] = r1
            r14.clearFileCache()
            r2 = 38
            r0[r2] = r1
            cm.aptoide.pt.deprecated.SQLiteDatabaseHelper r2 = new cm.aptoide.pt.deprecated.SQLiteDatabaseHelper
            r2.<init>(r14)
            r6 = 39
            r0[r6] = r1
            android.database.sqlite.SQLiteDatabase r6 = r2.getWritableDatabase()
            r7 = 40
            r0[r7] = r1
            boolean r7 = r6.isOpen()
            if (r7 != 0) goto L_0x0149
            r7 = 41
            r0[r7] = r1
            goto L_0x0154
        L_0x0149:
            r7 = 42
            r0[r7] = r1
            r6.close()
            r7 = 43
            r0[r7] = r1
        L_0x0154:
            r14.startNotificationCenter()
            r7 = 44
            r0[r7] = r1
            r14.startNotificationCleaner()
            r7 = 45
            r0[r7] = r1
            cm.aptoide.pt.install.installer.RootInstallationRetryHandler r7 = r14.rootInstallationRetryHandler
            r7.start()
            r7 = 46
            r0[r7] = r1
            cm.aptoide.pt.AptoideApplicationAnalytics r7 = new cm.aptoide.pt.AptoideApplicationAnalytics
            r7.<init>()
            r8 = 47
            r0[r8] = r1
            java.lang.String r8 = r14.getPackageName()
            r7.setPackageDimension(r8)
            r8 = 48
            r0[r8] = r1
            java.lang.String r8 = r14.getVersionCode()
            r7.setVersionCodeDimension(r8)
            r8 = 49
            r0[r8] = r1
            cm.aptoide.accountmanager.AptoideAccountManager r8 = r14.accountManager
            rx.S r8 = r8.accountStatus()
            cm.aptoide.pt.c r9 = p005cm.aptoide.p006pt.C0041c.f38a
            r10 = 50
            r0[r10] = r1
            rx.S r8 = r8.mo3669j(r9)
            r9 = 51
            r0[r9] = r1
            rx.S r8 = r8.mo3628b()
            cm.aptoide.pt.k r9 = new cm.aptoide.pt.k
            r9.<init>(r7)
            r10 = 52
            r0[r10] = r1
            r8.mo3646c(r9)
            r8 = 53
            r0[r8] = r1
            long r8 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r4
            r10 = 54
            r0[r10] = r1
            cm.aptoide.pt.logger.Logger r10 = p005cm.aptoide.p006pt.logger.Logger.getInstance()
            java.lang.String r11 = TAG
            java.lang.Object[] r12 = new java.lang.Object[r1]
            r13 = 55
            r0[r13] = r1
            java.lang.Long r13 = java.lang.Long.valueOf(r8)
            r12[r3] = r13
            java.lang.String r3 = "onCreate took %d millis."
            java.lang.String r3 = java.lang.String.format(r3, r12)
            r10.mo2146v(r11, r3)
            r3 = 56
            r0[r3] = r1
            cm.aptoide.analytics.AnalyticsManager r3 = r14.analyticsManager
            r3.setup()
            r3 = 57
            r0[r3] = r1
            cm.aptoide.pt.InvalidRefreshTokenLogoutManager r3 = r14.invalidRefreshTokenLogoutManager
            r3.start()
            r3 = 58
            r0[r3] = r1
            cm.aptoide.pt.downloadmanager.AptoideDownloadManager r3 = r14.aptoideDownloadManager
            r3.start()
            r3 = 59
            r0[r3] = r1
            cm.aptoide.pt.ads.AdsUserPropertyManager r3 = r14.adsUserPropertyManager
            r3.start()
            r3 = 60
            r0[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.AptoideApplication.onCreate():void");
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m97c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[369] = true;
        instance.log(err);
        $jacocoInit[370] = true;
        Boolean valueOf = Boolean.valueOf(true);
        $jacocoInit[371] = true;
        return valueOf;
    }

    /* renamed from: d */
    static /* synthetic */ void m98d(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[366] = true;
        instance.log(error);
        $jacocoInit[367] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m100f() {
        $jacocoInit()[368] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo622g() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[361] = true;
        Context applicationContext = getApplicationContext();
        $jacocoInit[362] = true;
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences();
        $jacocoInit[363] = true;
        SharedPreferences instance = SecurePreferencesImplementation.getInstance(applicationContext, defaultSharedPreferences);
        $jacocoInit[364] = true;
        p005cm.aptoide.p006pt.preferences.secure.SecurePreferences.setFirstRun(false, instance);
        $jacocoInit[365] = true;
    }

    /* renamed from: e */
    static /* synthetic */ void m99e(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[358] = true;
        instance.log(throwable);
        $jacocoInit[359] = true;
    }

    /* renamed from: h */
    static /* synthetic */ void m102h() {
        $jacocoInit()[360] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m89a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(account.isLoggedIn());
        $jacocoInit[357] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ void m91a(AptoideApplicationAnalytics aptoideApplicationAnalytics, Boolean isLoggedIn) {
        boolean[] $jacocoInit = $jacocoInit();
        aptoideApplicationAnalytics.updateDimension(isLoggedIn.booleanValue());
        $jacocoInit[356] = true;
    }

    public void initializeMoPub() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = "d225547d92b743179d8a04b75bf7d116";
        Builder builder = new Builder(str);
        $jacocoInit[61] = true;
        String cls = AppLovinBaseAdapterConfiguration.class.toString();
        $jacocoInit[62] = true;
        Builder withAdditionalNetwork = builder.withAdditionalNetwork(cls);
        $jacocoInit[63] = true;
        String cls2 = AppLovinBaseAdapterConfiguration.class.toString();
        $jacocoInit[64] = true;
        Map mediatedNetworkConfigurationBaseMap = getMediatedNetworkConfigurationBaseMap(str);
        $jacocoInit[65] = true;
        Builder withMediatedNetworkConfiguration = withAdditionalNetwork.withMediatedNetworkConfiguration(cls2, mediatedNetworkConfigurationBaseMap);
        $jacocoInit[66] = true;
        String cls3 = InMobiBaseAdapterConfiguration.class.toString();
        $jacocoInit[67] = true;
        Map mediatedNetworkConfigurationBaseMap2 = getMediatedNetworkConfigurationBaseMap(str);
        $jacocoInit[68] = true;
        Builder withMediatedNetworkConfiguration2 = withMediatedNetworkConfiguration.withMediatedNetworkConfiguration(cls3, mediatedNetworkConfigurationBaseMap2);
        $jacocoInit[69] = true;
        String name = InneractiveAdapterConfiguration.class.getName();
        $jacocoInit[70] = true;
        Map mediatedNetworkConfigurationWithAppIdMap = getMediatedNetworkConfigurationWithAppIdMap(str, BuildConfig.MOPUB_FYBER_APPLICATION_ID);
        $jacocoInit[71] = true;
        Builder withMediatedNetworkConfiguration3 = withMediatedNetworkConfiguration2.withMediatedNetworkConfiguration(name, mediatedNetworkConfigurationWithAppIdMap);
        $jacocoInit[72] = true;
        String name2 = GooglePlayServicesAdapterConfiguration.class.getName();
        $jacocoInit[73] = true;
        Map adMobAdsPreferencesMap = getAdMobAdsPreferencesMap();
        $jacocoInit[74] = true;
        Builder withMediatedNetworkConfiguration4 = withMediatedNetworkConfiguration3.withMediatedNetworkConfiguration(name2, adMobAdsPreferencesMap);
        LogLevel logLevel = LogLevel.DEBUG;
        $jacocoInit[75] = true;
        Builder withLogLevel = withMediatedNetworkConfiguration4.withLogLevel(logLevel);
        $jacocoInit[76] = true;
        SdkConfiguration sdkConfiguration = withLogLevel.build();
        $jacocoInit[77] = true;
        MoPub.initializeSdk(this, sdkConfiguration, null);
        $jacocoInit[78] = true;
    }

    private Map<String, String> getMediatedNetworkConfigurationBaseMap(String mediatedNetworkPlacementId) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, String> mediationNetworkConfiguration = new HashMap<>();
        $jacocoInit[79] = true;
        mediationNetworkConfiguration.put("Placement_Id", mediatedNetworkPlacementId);
        $jacocoInit[80] = true;
        return mediationNetworkConfiguration;
    }

    private Map<String, String> getMediatedNetworkConfigurationWithAppIdMap(String mediatedNetworkPlacementId, String appId) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[81] = true;
        Map<String, String> mediationNetworkConfiguration = getMediatedNetworkConfigurationBaseMap(mediatedNetworkPlacementId);
        $jacocoInit[82] = true;
        mediationNetworkConfiguration.put(InneractiveMediationDefs.REMOTE_KEY_APP_ID, appId);
        $jacocoInit[83] = true;
        return mediationNetworkConfiguration;
    }

    private Map<String, String> getAdMobAdsPreferencesMap() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, String> result = new HashMap<>();
        $jacocoInit[84] = true;
        result.put("npa", "1");
        $jacocoInit[85] = true;
        return result;
    }

    public ApplicationComponent getApplicationComponent() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.applicationComponent != null) {
            $jacocoInit[86] = true;
        } else {
            $jacocoInit[87] = true;
            DaggerApplicationComponent.Builder builder = DaggerApplicationComponent.builder();
            $jacocoInit[88] = true;
            DaggerApplicationComponent.Builder applicationModule = builder.applicationModule(new ApplicationModule(this, getAptoideMd5sum()));
            FlavourApplicationModule flavourApplicationModule = new FlavourApplicationModule(this);
            $jacocoInit[89] = true;
            DaggerApplicationComponent.Builder flavourApplicationModule2 = applicationModule.flavourApplicationModule(flavourApplicationModule);
            $jacocoInit[90] = true;
            this.applicationComponent = flavourApplicationModule2.build();
            $jacocoInit[91] = true;
        }
        ApplicationComponent applicationComponent2 = this.applicationComponent;
        $jacocoInit[92] = true;
        return applicationComponent2;
    }

    public ActivityModule getActivityModule(BaseActivity activity, Intent intent, NotificationSyncScheduler notificationSyncScheduler, View view, boolean firstCreated, String fileProviderAuthority) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = new ActivityModule(activity, intent, notificationSyncScheduler, view, firstCreated, fileProviderAuthority);
        $jacocoInit[93] = true;
        return activityModule;
    }

    public FragmentModule getFragmentModule(BaseFragment baseFragment, Bundle savedInstanceState, Bundle arguments, boolean createStoreUserPrivacyEnabled, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = new FragmentModule(baseFragment, savedInstanceState, arguments, createStoreUserPrivacyEnabled, packageName);
        $jacocoInit[94] = true;
        return fragmentModule;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        boolean[] $jacocoInit = $jacocoInit();
        super.attachBaseContext(base);
        $jacocoInit[95] = true;
        C0021a.m36a((Context) this);
        $jacocoInit[96] = true;
    }

    public TokenInvalidator getTokenInvalidator() {
        boolean[] $jacocoInit = $jacocoInit();
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[97] = true;
        return tokenInvalidator2;
    }

    private void startNotificationCenter() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = getPreferences().getBoolean(ManagedKeys.CAMPAIGN_SOCIAL_NOTIFICATIONS_PREFERENCE_VIEW_KEY, true);
        $jacocoInit[98] = true;
        C0120S d = s.mo3647d();
        C0068u uVar = new C0068u(this);
        C0072x xVar = C0072x.f83a;
        $jacocoInit[99] = true;
        d.mo3626a((C0129b<? super T>) uVar, (C0129b<Throwable>) xVar);
        $jacocoInit[100] = true;
        getNotificationCenter().setup();
        $jacocoInit[101] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo611a(Boolean enabled) {
        boolean[] $jacocoInit = $jacocoInit();
        getNotificationSyncScheduler().setEnabled(enabled.booleanValue());
        $jacocoInit[355] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m101f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[353] = true;
        instance.log(throwable);
        $jacocoInit[354] = true;
    }

    private void startNotificationCleaner() {
        boolean[] $jacocoInit = $jacocoInit();
        getNotificationCleaner().setup();
        $jacocoInit[102] = true;
    }

    private NotificationsCleaner getNotificationCleaner() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.notificationsCleaner != null) {
            $jacocoInit[103] = true;
        } else {
            $jacocoInit[104] = true;
            NotificationAccessor notificationAccessor = (NotificationAccessor) AccessorFactory.getAccessorFor(this.database, Notification.class);
            $jacocoInit[105] = true;
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            AptoideAccountManager aptoideAccountManager = this.accountManager;
            $jacocoInit[106] = true;
            NotificationsCleaner notificationsCleaner2 = new NotificationsCleaner(notificationAccessor, instance, aptoideAccountManager, getNotificationProvider(), CrashReport.getInstance());
            this.notificationsCleaner = notificationsCleaner2;
            $jacocoInit[107] = true;
        }
        NotificationsCleaner notificationsCleaner3 = this.notificationsCleaner;
        $jacocoInit[108] = true;
        return notificationsCleaner3;
    }

    public C0100e<NotificationInfo> getNotificationsPublishRelay() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.notificationsPublishRelay != null) {
            $jacocoInit[109] = true;
        } else {
            $jacocoInit[110] = true;
            this.notificationsPublishRelay = C0100e.m565o();
            $jacocoInit[111] = true;
        }
        C0100e<NotificationInfo> eVar = this.notificationsPublishRelay;
        $jacocoInit[112] = true;
        return eVar;
    }

    public NotificationCenter getNotificationCenter() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.notificationCenter != null) {
            $jacocoInit[113] = true;
        } else {
            $jacocoInit[114] = true;
            NotificationProvider notificationProvider2 = getNotificationProvider();
            $jacocoInit[115] = true;
            this.notificationCenter = new NotificationCenter(notificationProvider2, getNotificationSyncScheduler(), new NotificationPolicyFactory(notificationProvider2), new NotificationAnalytics(new AptoideInstallParser(), this.analyticsManager, this.navigationTracker));
            $jacocoInit[116] = true;
        }
        NotificationCenter notificationCenter2 = this.notificationCenter;
        $jacocoInit[117] = true;
        return notificationCenter2;
    }

    public NotificationProvider getNotificationProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.notificationProvider != null) {
            $jacocoInit[118] = true;
        } else {
            $jacocoInit[119] = true;
            NotificationAccessor notificationAccessor = (NotificationAccessor) AccessorFactory.getAccessorFor(this.database, Notification.class);
            $jacocoInit[120] = true;
            this.notificationProvider = new NotificationProvider(notificationAccessor, Schedulers.m776io());
            $jacocoInit[121] = true;
        }
        NotificationProvider notificationProvider2 = this.notificationProvider;
        $jacocoInit[122] = true;
        return notificationProvider2;
    }

    public SharedPreferences getDefaultSharedPreferences() {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        $jacocoInit[123] = true;
        return defaultSharedPreferences;
    }

    public OkHttpClient getDefaultClient() {
        boolean[] $jacocoInit = $jacocoInit();
        OkHttpClient okHttpClient = this.defaultClient;
        $jacocoInit[124] = true;
        return okHttpClient;
    }

    public AptoideDownloadManager getDownloadManager() {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideDownloadManager aptoideDownloadManager2 = this.aptoideDownloadManager;
        $jacocoInit[125] = true;
        return aptoideDownloadManager2;
    }

    public InstallManager getInstallManager() {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        $jacocoInit[126] = true;
        return installManager2;
    }

    public QManager getQManager() {
        boolean[] $jacocoInit = $jacocoInit();
        QManager qManager2 = this.qManager;
        $jacocoInit[127] = true;
        return qManager2;
    }

    public EntryPointChooser getEntryPointChooser() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.entryPointChooser != null) {
            $jacocoInit[128] = true;
        } else {
            $jacocoInit[129] = true;
            this.entryPointChooser = new EntryPointChooser(new C0052l(this));
            $jacocoInit[130] = true;
        }
        EntryPointChooser entryPointChooser2 = this.entryPointChooser;
        $jacocoInit[131] = true;
        return entryPointChooser2;
    }

    /* renamed from: e */
    public /* synthetic */ boolean mo621e() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isSupportedExtensionsDefined = this.qManager.isSupportedExtensionsDefined();
        $jacocoInit[352] = true;
        return isSupportedExtensionsDefined;
    }

    public AptoideAccountManager getAccountManager() {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        $jacocoInit[132] = true;
        return aptoideAccountManager;
    }

    public AuthenticationPersistence getAuthenticationPersistence() {
        boolean[] $jacocoInit = $jacocoInit();
        AuthenticationPersistence authenticationPersistence2 = this.authenticationPersistence;
        $jacocoInit[133] = true;
        return authenticationPersistence2;
    }

    public Preferences getPreferences() {
        boolean[] $jacocoInit = $jacocoInit();
        Preferences preferences2 = this.preferences;
        $jacocoInit[134] = true;
        return preferences2;
    }

    public BillingAnalytics getBillingAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingAnalytics != null) {
            $jacocoInit[135] = true;
        } else {
            $jacocoInit[136] = true;
            this.billingAnalytics = new BillingAnalytics(getAptoidePackage(), this.analyticsManager, this.navigationTracker);
            $jacocoInit[137] = true;
        }
        BillingAnalytics billingAnalytics2 = this.billingAnalytics;
        $jacocoInit[138] = true;
        return billingAnalytics2;
    }

    public Billing getBilling(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        Billing billing = getBillingPool().get(merchantName);
        $jacocoInit[139] = true;
        return billing;
    }

    public BillingPool getBillingPool() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingPool != null) {
            $jacocoInit[140] = true;
            z = true;
        } else {
            $jacocoInit[141] = true;
            SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences();
            BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor = this.bodyInterceptorV3;
            OkHttpClient okHttpClient = this.defaultClient;
            AptoideAccountManager aptoideAccountManager = this.accountManager;
            Database database2 = this.database;
            $jacocoInit[142] = true;
            Resources resources = getResources();
            PackageRepository packageRepository2 = this.packageRepository;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            RxSyncScheduler rxSyncScheduler = r14;
            HashMap hashMap = new HashMap();
            $jacocoInit[143] = true;
            RxSyncScheduler rxSyncScheduler2 = new RxSyncScheduler(hashMap, CrashReport.getInstance());
            $jacocoInit[144] = true;
            ExternalBillingSerializer inAppBillingSerializer = getInAppBillingSerializer();
            BodyInterceptor<BaseBody> bodyInterceptor2 = this.bodyInterceptorPoolV7;
            BodyInterceptor<BaseBody> bodyInterceptor3 = this.accountSettingsBodyInterceptorPoolV7;
            HashMap hashMap2 = r3;
            HashMap hashMap3 = new HashMap();
            z = true;
            $jacocoInit[145] = true;
            Factory defaultConverter = WebService.getDefaultConverter();
            CrashReport instance = CrashReport.getInstance();
            Adyen adyen2 = getAdyen();
            $jacocoInit[146] = true;
            PurchaseFactory purchaseFactory2 = getPurchaseFactory();
            $jacocoInit[147] = true;
            BillingPool billingPool2 = new BillingPool(defaultSharedPreferences, bodyInterceptor, okHttpClient, aptoideAccountManager, database2, resources, packageRepository2, tokenInvalidator2, rxSyncScheduler, inAppBillingSerializer, bodyInterceptor2, bodyInterceptor3, hashMap2, defaultConverter, instance, adyen2, purchaseFactory2, 16, 16, getAuthenticationPersistence(), getPreferences());
            this.billingPool = billingPool2;
            $jacocoInit[148] = true;
        }
        BillingPool billingPool3 = this.billingPool;
        $jacocoInit[149] = z;
        return billingPool3;
    }

    public Adyen getAdyen() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.f44397adyen != null) {
            $jacocoInit[150] = true;
        } else {
            $jacocoInit[151] = true;
            this.f44397adyen = new Adyen(this, Charset.forName("UTF-8"), Schedulers.m776io(), C0100e.m565o());
            $jacocoInit[152] = true;
        }
        Adyen adyen2 = this.f44397adyen;
        $jacocoInit[153] = true;
        return adyen2;
    }

    public BillingIdManager getIdResolver(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        BillingIdManager idResolver = getBillingPool().getIdResolver(merchantName);
        $jacocoInit[154] = true;
        return idResolver;
    }

    public Database getDatabase() {
        boolean[] $jacocoInit = $jacocoInit();
        Database database2 = this.database;
        $jacocoInit[155] = true;
        return database2;
    }

    public PackageRepository getPackageRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        PackageRepository packageRepository2 = this.packageRepository;
        $jacocoInit[156] = true;
        return packageRepository2;
    }

    public PaymentThrowableCodeMapper getPaymentThrowableCodeMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.paymentThrowableCodeMapper != null) {
            $jacocoInit[157] = true;
        } else {
            $jacocoInit[158] = true;
            this.paymentThrowableCodeMapper = new PaymentThrowableCodeMapper();
            $jacocoInit[159] = true;
        }
        PaymentThrowableCodeMapper paymentThrowableCodeMapper2 = this.paymentThrowableCodeMapper;
        $jacocoInit[160] = true;
        return paymentThrowableCodeMapper2;
    }

    public PurchaseBundleMapper getPurchaseBundleMapper() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.purchaseBundleMapper != null) {
            $jacocoInit[161] = true;
        } else {
            $jacocoInit[162] = true;
            this.purchaseBundleMapper = new PurchaseBundleMapper(getPaymentThrowableCodeMapper(), getPurchaseFactory());
            $jacocoInit[163] = true;
        }
        PurchaseBundleMapper purchaseBundleMapper2 = this.purchaseBundleMapper;
        $jacocoInit[164] = true;
        return purchaseBundleMapper2;
    }

    public ExternalBillingSerializer getInAppBillingSerializer() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.inAppBillingSerialzer != null) {
            $jacocoInit[165] = true;
        } else {
            $jacocoInit[166] = true;
            this.inAppBillingSerialzer = new ExternalBillingSerializer();
            $jacocoInit[167] = true;
        }
        ExternalBillingSerializer externalBillingSerializer = this.inAppBillingSerialzer;
        $jacocoInit[168] = true;
        return externalBillingSerializer;
    }

    private void clearFileCache() {
        boolean[] $jacocoInit = $jacocoInit();
        Single purgeCache = getFileManager().purgeCache();
        C0045e eVar = C0045e.f60a;
        C0054n nVar = C0054n.f70a;
        $jacocoInit[169] = true;
        purgeCache.mo3690a((C0129b<? super T>) eVar, (C0129b<Throwable>) nVar);
        $jacocoInit[170] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m93a(Long cleanedSize) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("cleaned size: ");
        $jacocoInit[350] = true;
        sb.append(StringU.formatBytes(cleanedSize.longValue(), false));
        instance.mo2136d(str, sb.toString());
        $jacocoInit[351] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m94a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[348] = true;
        instance.log(err);
        $jacocoInit[349] = true;
    }

    public FileManager getFileManager() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.fileManager != null) {
            $jacocoInit[171] = true;
        } else {
            $jacocoInit[172] = true;
            CacheHelper cacheHelper2 = this.cacheHelper;
            FileUtils fileUtils = new FileUtils();
            $jacocoInit[173] = true;
            FileManager fileManager2 = new FileManager(cacheHelper2, fileUtils, new String[]{getApplicationContext().getCacheDir().getPath(), getCachePath()}, this.aptoideDownloadManager, this.httpClientCache);
            this.fileManager = fileManager2;
            $jacocoInit[174] = true;
        }
        FileManager fileManager3 = this.fileManager;
        $jacocoInit[175] = true;
        return fileManager3;
    }

    private void initializeFlurry(Context context, String flurryKey) {
        boolean[] $jacocoInit = $jacocoInit();
        C0098a aVar = new C0098a();
        aVar.mo3299a(false);
        $jacocoInit[176] = true;
        aVar.mo3300a(context, flurryKey);
        $jacocoInit[177] = true;
    }

    private C0117M sendAppStartToAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        FirstLaunchAnalytics firstLaunchAnalytics2 = this.firstLaunchAnalytics;
        $jacocoInit[178] = true;
        Context applicationContext = getApplicationContext();
        $jacocoInit[179] = true;
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences();
        $jacocoInit[180] = true;
        SharedPreferences instance = SecurePreferencesImplementation.getInstance(applicationContext, defaultSharedPreferences);
        $jacocoInit[181] = true;
        C0117M sendAppStart = firstLaunchAnalytics2.sendAppStart(this, instance);
        $jacocoInit[182] = true;
        return sendAppStart;
    }

    private C0117M checkAppSecurity() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C0032A(this));
        $jacocoInit[183] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo610a() {
        boolean[] $jacocoInit = $jacocoInit();
        if (SecurityUtils.checkAppSignature(this) == 0) {
            $jacocoInit[335] = true;
        } else {
            $jacocoInit[336] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            $jacocoInit[337] = true;
            instance.mo2148w(str, "app signature is not valid!");
            $jacocoInit[338] = true;
        }
        if (!SecurityUtils.checkEmulator()) {
            $jacocoInit[339] = true;
        } else {
            $jacocoInit[340] = true;
            Logger instance2 = Logger.getInstance();
            String str2 = TAG;
            $jacocoInit[341] = true;
            instance2.mo2148w(str2, "application is running on an emulator");
            $jacocoInit[342] = true;
        }
        if (!SecurityUtils.checkDebuggable(this)) {
            $jacocoInit[343] = true;
        } else {
            $jacocoInit[344] = true;
            Logger instance3 = Logger.getInstance();
            String str3 = TAG;
            $jacocoInit[345] = true;
            instance3.mo2148w(str3, "application has debug flag active");
            $jacocoInit[346] = true;
        }
        $jacocoInit[347] = true;
    }

    /* access modifiers changed from: protected */
    public DisplayableWidgetMapping createDisplayableWidgetMapping() {
        boolean[] $jacocoInit = $jacocoInit();
        DisplayableWidgetMapping instance = DisplayableWidgetMapping.getInstance();
        $jacocoInit[184] = true;
        return instance;
    }

    private C0117M generateAptoideUuid() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C0046f(this));
        $jacocoInit[185] = true;
        C0117M b = c.mo3593b(Schedulers.newThread());
        $jacocoInit[186] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ void mo620d() {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository.getUniqueIdentifier();
        $jacocoInit[334] = true;
    }

    private C0117M prepareApp(AptoideAccountManager accountManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S accountStatus = accountManager2.accountStatus();
        $jacocoInit[187] = true;
        C0120S d = accountStatus.mo3647d();
        $jacocoInit[188] = true;
        Single n = d.mo3678n();
        C0034B b = new C0034B(this, accountManager2);
        $jacocoInit[189] = true;
        C0117M b2 = n.mo3693b((C0132p<? super T, ? extends C0117M>) b);
        $jacocoInit[190] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo607a(AptoideAccountManager accountManager2, Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[325] = true;
        Context applicationContext = getApplicationContext();
        $jacocoInit[326] = true;
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences();
        $jacocoInit[327] = true;
        SharedPreferences instance = SecurePreferencesImplementation.getInstance(applicationContext, defaultSharedPreferences);
        $jacocoInit[328] = true;
        if (p005cm.aptoide.p006pt.preferences.secure.SecurePreferences.isFirstRun(instance)) {
            $jacocoInit[329] = true;
            setSharedPreferencesValues();
            $jacocoInit[330] = true;
            C0117M a = setupFirstRun().mo3580a(this.rootAvailabilityManager.updateRootAvailability());
            $jacocoInit[331] = true;
            C0117M a2 = a.mo3580a(C0117M.m594b(accountManager2.updateAccount(), createShortcut()));
            $jacocoInit[332] = true;
            return a2;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[333] = true;
        return b;
    }

    private void setSharedPreferencesValues() {
        boolean[] $jacocoInit = $jacocoInit();
        PreferencesXmlParser preferencesXmlParser = new PreferencesXmlParser();
        $jacocoInit[191] = true;
        XmlResourceParser parser = getResources().getXml(C1375R.xml.settings);
        try {
            $jacocoInit[192] = true;
            try {
                List<String[]> parsedPrefsList = preferencesXmlParser.parse(parser);
                $jacocoInit[193] = true;
                $jacocoInit[194] = true;
                for (String[] keyValue : parsedPrefsList) {
                    $jacocoInit[195] = true;
                    Editor edit = getDefaultSharedPreferences().edit();
                    String str = keyValue[0];
                    String str2 = keyValue[1];
                    $jacocoInit[196] = true;
                    Editor putBoolean = edit.putBoolean(str, Boolean.valueOf(str2).booleanValue());
                    $jacocoInit[197] = true;
                    putBoolean.apply();
                    $jacocoInit[198] = true;
                }
                $jacocoInit[199] = true;
            } catch (IOException | XmlPullParserException e) {
                e = e;
                $jacocoInit[200] = true;
                e.printStackTrace();
                $jacocoInit[201] = true;
                $jacocoInit[202] = true;
            }
        } catch (IOException | XmlPullParserException e2) {
            e = e2;
            $jacocoInit[200] = true;
            e.printStackTrace();
            $jacocoInit[201] = true;
            $jacocoInit[202] = true;
        }
        $jacocoInit[202] = true;
    }

    private C0117M setupFirstRun() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C0042d<Object>(this));
        $jacocoInit[203] = true;
        return a;
    }

    /* renamed from: i */
    public /* synthetic */ C0117M mo681i() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[314] = true;
        StoreCredentialsProviderImpl storeCredentials = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(this.database, Store.class));
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        BodyInterceptor<BaseBody> bodyInterceptor = this.accountSettingsBodyInterceptorPoolV7;
        $jacocoInit[315] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(this.database, Store.class);
        OkHttpClient okHttpClient = this.defaultClient;
        $jacocoInit[316] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[317] = true;
        StoreUtilsProxy storeUtilsProxy = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor, storeCredentials, storeAccessor, okHttpClient, defaultConverter, tokenInvalidator2, getDefaultSharedPreferences());
        $jacocoInit[318] = true;
        C0117M generateAptoideUuid = generateAptoideUuid();
        $jacocoInit[319] = true;
        C0117M a = setDefaultFollowedStores(storeCredentials, storeUtilsProxy).mo3580a(refreshUpdates());
        C0067t tVar = C0067t.f78a;
        $jacocoInit[320] = true;
        C0117M a2 = a.mo3583a((C0129b<? super Throwable>) tVar);
        $jacocoInit[321] = true;
        C0117M a3 = generateAptoideUuid.mo3580a(a2);
        $jacocoInit[322] = true;
        return a3;
    }

    /* renamed from: b */
    static /* synthetic */ void m96b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[323] = true;
        instance.log(err);
        $jacocoInit[324] = true;
    }

    private C0117M setDefaultFollowedStores(StoreCredentialsProviderImpl storeCredentials, StoreUtilsProxy proxy) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) this.defaultFollowedStores);
        C0064q qVar = new C0064q(this, storeCredentials, proxy);
        $jacocoInit[204] = true;
        C0120S g = a.mo3663g((C0132p<? super T, ? extends C0117M>) qVar);
        $jacocoInit[205] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[206] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo608a(StoreCredentialsProviderImpl storeCredentials, StoreUtilsProxy proxy, String followedStoreName) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[308] = true;
        StoreCredentials defaultStoreCredentials = storeCredentials.get(followedStoreName);
        BodyInterceptor<BaseBody> bodyInterceptor = this.accountSettingsBodyInterceptorPoolV7;
        OkHttpClient okHttpClient = this.defaultClient;
        $jacocoInit[309] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[310] = true;
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences();
        $jacocoInit[311] = true;
        GetStoreMetaRequest of = GetStoreMetaRequest.m264of(defaultStoreCredentials, bodyInterceptor, okHttpClient, defaultConverter, tokenInvalidator2, defaultSharedPreferences);
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        $jacocoInit[312] = true;
        C0117M addDefaultStore = proxy.addDefaultStore(of, aptoideAccountManager, defaultStoreCredentials);
        $jacocoInit[313] = true;
        return addDefaultStore;
    }

    public BodyInterceptor<BaseBody> getBodyInterceptorPoolV7() {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorPoolV7;
        $jacocoInit[207] = true;
        return bodyInterceptor;
    }

    public BodyInterceptor<BaseBody> getAccountSettingsBodyInterceptorPoolV7() {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> bodyInterceptor = this.accountSettingsBodyInterceptorPoolV7;
        $jacocoInit[208] = true;
        return bodyInterceptor;
    }

    public BodyInterceptor<BaseBody> getAccountSettingsBodyInterceptorWebV7() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.accountSettingsBodyInterceptorWebV7 != null) {
            $jacocoInit[209] = true;
        } else {
            $jacocoInit[210] = true;
            this.accountSettingsBodyInterceptorWebV7 = new MatureBodyInterceptorV7(this.bodyInterceptorWebV7, this.adultContent);
            $jacocoInit[211] = true;
        }
        BodyInterceptor<BaseBody> bodyInterceptor = this.accountSettingsBodyInterceptorWebV7;
        $jacocoInit[212] = true;
        return bodyInterceptor;
    }

    public BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> getBodyInterceptorV3() {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor = this.bodyInterceptorV3;
        $jacocoInit[213] = true;
        return bodyInterceptor;
    }

    /* JADX INFO: finally extract failed */
    public String getAptoideMd5sum() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.aptoideMd5sum != null) {
            $jacocoInit[214] = true;
        } else {
            synchronized (this) {
                try {
                    $jacocoInit[215] = true;
                    if (this.aptoideMd5sum != null) {
                        $jacocoInit[216] = true;
                    } else {
                        $jacocoInit[217] = true;
                        this.aptoideMd5sum = calculateMd5Sum();
                        $jacocoInit[218] = true;
                    }
                } catch (Throwable th) {
                    while (true) {
                        $jacocoInit[220] = true;
                        throw th;
                    }
                }
            }
            $jacocoInit[219] = true;
        }
        String str = this.aptoideMd5sum;
        $jacocoInit[221] = true;
        return str;
    }

    private String calculateMd5Sum() {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            $jacocoInit[222] = true;
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getAptoidePackage(), 0);
            $jacocoInit[223] = true;
            String computeMd5 = AlgorithmU.computeMd5(packageInfo);
            $jacocoInit[224] = true;
            return computeMd5;
        } catch (NameNotFoundException e) {
            $jacocoInit[225] = true;
            e.printStackTrace();
            $jacocoInit[226] = true;
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String getAptoidePackage() {
        $jacocoInit()[227] = true;
        return "cm.aptoide.pt";
    }

    public C0117M createShortcut() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C0053m<Object>(this));
        $jacocoInit[228] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo613b() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.shortcutManager.shouldCreateShortcut()) {
            $jacocoInit[304] = true;
        } else {
            $jacocoInit[305] = true;
            createAppShortcut();
            $jacocoInit[306] = true;
        }
        $jacocoInit[307] = true;
        return null;
    }

    private C0117M discoverAndSaveInstalledApps() {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledAccessor installedAccessor = (InstalledAccessor) AccessorFactory.getAccessorFor(this.database, Installed.class);
        $jacocoInit[229] = true;
        C0120S a = C0120S.m633a((Callable<? extends T>) new C0071w<Object>(this));
        C0048h hVar = C0048h.f64a;
        $jacocoInit[230] = true;
        C0120S h = a.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) hVar);
        C0035C c = new C0035C(this);
        $jacocoInit[231] = true;
        C0120S j = h.mo3669j(c);
        $jacocoInit[232] = true;
        C0120S m = j.mo3675m();
        C0069v vVar = new C0069v(this, installedAccessor);
        $jacocoInit[233] = true;
        C0120S f = m.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vVar);
        C0050j jVar = new C0050j(installedAccessor);
        $jacocoInit[234] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) jVar);
        $jacocoInit[235] = true;
        C0117M l = b.mo3673l();
        $jacocoInit[236] = true;
        return l;
    }

    /* renamed from: c */
    public /* synthetic */ List mo614c() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[298] = true;
        List<PackageInfo> installedApps = SystemU.getAllInstalledApps(getPackageManager());
        $jacocoInit[299] = true;
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Found ");
        $jacocoInit[300] = true;
        sb.append(installedApps.size());
        sb.append(" user installed apps.");
        instance.mo2146v(str, sb.toString());
        $jacocoInit[301] = true;
        Collections.sort(installedApps, C0065r.f76a);
        $jacocoInit[302] = true;
        return installedApps;
    }

    /* renamed from: a */
    static /* synthetic */ int m88a(PackageInfo lhs, PackageInfo rhs) {
        int i = (int) ((lhs.firstInstallTime - rhs.firstInstallTime) / 1000);
        $jacocoInit()[303] = true;
        return i;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m90a(List list) {
        $jacocoInit()[297] = true;
        return list;
    }

    /* renamed from: a */
    public /* synthetic */ Installed mo605a(PackageInfo packageInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        Installed installed = new Installed(packageInfo, getPackageManager());
        $jacocoInit[296] = true;
        return installed;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo609a(InstalledAccessor installedAccessor, List appsInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = installedAccessor.getAll();
        $jacocoInit[291] = true;
        C0120S d = all.mo3647d();
        C0047g gVar = new C0047g(this, appsInstalled);
        $jacocoInit[292] = true;
        C0120S j = d.mo3669j(gVar);
        $jacocoInit[293] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ List mo606a(List appsInstalled, List installedFromDatabase) {
        boolean[] $jacocoInit = $jacocoInit();
        List combineLists = combineLists(appsInstalled, installedFromDatabase, C0055o.f71a);
        $jacocoInit[294] = true;
        return combineLists;
    }

    /* renamed from: a */
    static /* synthetic */ void m92a(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        installed.setStatus(1);
        $jacocoInit[295] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m95b(InstalledAccessor installedAccessor, List list) {
        boolean[] $jacocoInit = $jacocoInit();
        installedAccessor.removeAll();
        $jacocoInit[289] = true;
        installedAccessor.insertAll(list);
        $jacocoInit[290] = true;
    }

    public <T> List<T> combineLists(List<T> list1, List<T> list2, C0129b<T> transformer) {
        boolean[] $jacocoInit = $jacocoInit();
        List<T> toReturn = new ArrayList<>(list1.size() + list2.size());
        $jacocoInit[237] = true;
        toReturn.addAll(list1);
        $jacocoInit[238] = true;
        $jacocoInit[239] = true;
        for (T item : list2) {
            $jacocoInit[240] = true;
            if (toReturn.contains(item)) {
                $jacocoInit[241] = true;
            } else {
                if (transformer == null) {
                    $jacocoInit[242] = true;
                } else {
                    $jacocoInit[243] = true;
                    transformer.call(item);
                    $jacocoInit[244] = true;
                }
                toReturn.add(item);
                $jacocoInit[245] = true;
            }
            $jacocoInit[246] = true;
        }
        $jacocoInit[247] = true;
        return toReturn;
    }

    private C0117M refreshUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        UpdateRepository updateRepository = RepositoryFactory.getUpdateRepository(this, getDefaultSharedPreferences());
        $jacocoInit[248] = true;
        C0117M sync = updateRepository.sync(true, false);
        $jacocoInit[249] = true;
        return sync;
    }

    private void createAppShortcut() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent shortcutIntent = new Intent(this, EntryActivity.class);
        $jacocoInit[250] = true;
        shortcutIntent.setAction("android.intent.action.MAIN");
        $jacocoInit[251] = true;
        Intent intent = new Intent();
        $jacocoInit[252] = true;
        intent.putExtra("android.intent.extra.shortcut.INTENT", shortcutIntent);
        $jacocoInit[253] = true;
        intent.putExtra("android.intent.extra.shortcut.NAME", getResources().getString(C1375R.string.app_name));
        $jacocoInit[254] = true;
        ShortcutIconResource fromContext = ShortcutIconResource.fromContext(getApplicationContext(), C1375R.mipmap.ic_launcher);
        $jacocoInit[255] = true;
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", fromContext);
        $jacocoInit[256] = true;
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        $jacocoInit[257] = true;
        getApplicationContext().sendBroadcast(intent);
        $jacocoInit[258] = true;
    }

    public RootAvailabilityManager getRootAvailabilityManager() {
        boolean[] $jacocoInit = $jacocoInit();
        RootAvailabilityManager rootAvailabilityManager2 = this.rootAvailabilityManager;
        $jacocoInit[259] = true;
        return rootAvailabilityManager2;
    }

    public AdsApplicationVersionCodeProvider getVersionCodeProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = this.applicationVersionCodeProvider;
        $jacocoInit[260] = true;
        return adsApplicationVersionCodeProvider;
    }

    public AdsRepository getAdsRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        AdsRepository adsRepository2 = this.adsRepository;
        $jacocoInit[261] = true;
        return adsRepository2;
    }

    public SyncStorage getSyncStorage() {
        boolean[] $jacocoInit = $jacocoInit();
        SyncStorage syncStorage2 = this.syncStorage;
        $jacocoInit[262] = true;
        return syncStorage2;
    }

    public C0099b<Map<Integer, Result>> getFragmentResultRelay() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.fragmentResultRelay != null) {
            $jacocoInit[263] = true;
        } else {
            $jacocoInit[264] = true;
            this.fragmentResultRelay = C0099b.m564o();
            $jacocoInit[265] = true;
        }
        C0099b<Map<Integer, Result>> bVar = this.fragmentResultRelay;
        $jacocoInit[266] = true;
        return bVar;
    }

    @SuppressLint({"UseSparseArrays"})
    public Map<Integer, Result> getFragmentResulMap() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.fragmentResulMap != null) {
            $jacocoInit[267] = true;
        } else {
            $jacocoInit[268] = true;
            this.fragmentResulMap = new HashMap();
            $jacocoInit[269] = true;
        }
        Map<Integer, Result> map = this.fragmentResulMap;
        $jacocoInit[270] = true;
        return map;
    }

    public NavigationTracker getNavigationTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[271] = true;
        return navigationTracker2;
    }

    public PurchaseFactory getPurchaseFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.purchaseFactory != null) {
            $jacocoInit[272] = true;
        } else {
            $jacocoInit[273] = true;
            this.purchaseFactory = new PurchaseFactory();
            $jacocoInit[274] = true;
        }
        PurchaseFactory purchaseFactory2 = this.purchaseFactory;
        $jacocoInit[275] = true;
        return purchaseFactory2;
    }

    public String getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        String version = "NaN";
        try {
            $jacocoInit[276] = true;
            try {
                PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                $jacocoInit[277] = true;
                version = String.valueOf(pInfo.versionCode);
                $jacocoInit[278] = true;
            } catch (NameNotFoundException e) {
                $jacocoInit[279] = true;
                $jacocoInit[280] = true;
                return version;
            }
        } catch (NameNotFoundException e2) {
            $jacocoInit[279] = true;
            $jacocoInit[280] = true;
            return version;
        }
        $jacocoInit[280] = true;
        return version;
    }

    public SyncScheduler getAlarmSyncScheduler() {
        boolean[] $jacocoInit = $jacocoInit();
        SyncScheduler syncScheduler = this.alarmSyncScheduler;
        $jacocoInit[281] = true;
        return syncScheduler;
    }

    public TrendingManager getTrendingManager() {
        boolean[] $jacocoInit = $jacocoInit();
        TrendingManager trendingManager2 = this.trendingManager;
        $jacocoInit[282] = true;
        return trendingManager2;
    }

    public NotificationAnalytics getNotificationAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationAnalytics notificationAnalytics2 = this.notificationAnalytics;
        $jacocoInit[283] = true;
        return notificationAnalytics2;
    }

    public IdsRepository getIdsRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[284] = true;
        return idsRepository2;
    }

    public SearchSuggestionManager getSearchSuggestionManager() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchSuggestionManager searchSuggestionManager2 = this.searchSuggestionManager;
        $jacocoInit[285] = true;
        return searchSuggestionManager2;
    }

    public AnalyticsManager getAnalyticsManager() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        $jacocoInit[286] = true;
        return analyticsManager2;
    }

    public AdultContentAnalytics getAdultContentAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        AdultContentAnalytics adultContentAnalytics2 = this.adultContentAnalytics;
        $jacocoInit[287] = true;
        return adultContentAnalytics2;
    }

    public SettingsManager getSettingsManager() {
        boolean[] $jacocoInit = $jacocoInit();
        SettingsManager settingsManager2 = this.settingsManager;
        $jacocoInit[288] = true;
        return settingsManager2;
    }
}
