package p005cm.aptoide.p006pt.install;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.ApplicationComponent;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p005cm.aptoide.p006pt.app.migration.AppcMigrationManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p005cm.aptoide.p006pt.util.ReferrerUtils;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import p026rx.p398d.C14906b;
import p026rx.p401g.C14959b;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.install.InstalledIntentService */
public class InstalledIntentService extends IntentService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = InstalledIntentService.class.getName();
    private MinimalAdMapper adMapper;
    private AdsRepository adsRepository;
    @Inject
    AppcMigrationManager appcMigrationManager;
    @Inject
    CampaignAnalytics campaignAnalytics;
    private Factory converterFactory;
    private OkHttpClient httpClient;
    @Inject
    InstallAnalytics installAnalytics;
    private InstallManager installManager;
    private PackageManager packageManager;
    private QManager qManager;
    private RootAvailabilityManager rootAvailabilityManager;
    private SharedPreferences sharedPreferences;
    private C0136c subscriptions;
    private UpdateRepository updatesRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3119039389403030083L, "cm/aptoide/pt/install/InstalledIntentService", Opcodes.IXOR);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[129] = true;
    }

    public InstalledIntentService() {
        boolean[] $jacocoInit = $jacocoInit();
        super("InstalledIntentService");
        $jacocoInit[0] = true;
    }

    public void onCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate();
        $jacocoInit[1] = true;
        ApplicationComponent applicationComponent = ((AptoideApplication) getApplicationContext()).getApplicationComponent();
        $jacocoInit[2] = true;
        applicationComponent.inject(this);
        $jacocoInit[3] = true;
        this.adMapper = new MinimalAdMapper();
        $jacocoInit[4] = true;
        this.sharedPreferences = ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[5] = true;
        this.qManager = ((AptoideApplication) getApplicationContext()).getQManager();
        $jacocoInit[6] = true;
        this.httpClient = ((AptoideApplication) getApplicationContext()).getDefaultClient();
        $jacocoInit[7] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[8] = true;
        SharedPreferences sharedPreferences2 = ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[9] = true;
        this.adsRepository = ((AptoideApplication) getApplicationContext()).getAdsRepository();
        $jacocoInit[10] = true;
        this.updatesRepository = RepositoryFactory.getUpdateRepository(this, sharedPreferences2);
        $jacocoInit[11] = true;
        this.subscriptions = new C0136c();
        $jacocoInit[12] = true;
        this.installManager = ((AptoideApplication) getApplicationContext()).getInstallManager();
        $jacocoInit[13] = true;
        this.rootAvailabilityManager = ((AptoideApplication) getApplicationContext()).getRootAvailabilityManager();
        $jacocoInit[14] = true;
        this.packageManager = getPackageManager();
        $jacocoInit[15] = true;
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        if (intent == null) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            String action = intent.getAction();
            $jacocoInit[18] = true;
            Uri data = intent.getData();
            $jacocoInit[19] = true;
            String packageName = data.getEncodedSchemeSpecificPart();
            $jacocoInit[20] = true;
            String str = "android.intent.action.PACKAGE_REPLACED";
            if (TextUtils.equals(action, str)) {
                $jacocoInit[21] = true;
            } else if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                $jacocoInit[22] = true;
            } else {
                $jacocoInit[23] = true;
                return;
            }
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -810471698) {
                if (hashCode != 525384130) {
                    if (hashCode != 1544582882) {
                        $jacocoInit[24] = true;
                    } else if (!action.equals("android.intent.action.PACKAGE_ADDED")) {
                        $jacocoInit[25] = true;
                    } else {
                        $jacocoInit[26] = true;
                        c = 0;
                    }
                } else if (!action.equals("android.intent.action.PACKAGE_REMOVED")) {
                    $jacocoInit[29] = true;
                } else {
                    $jacocoInit[30] = true;
                    c = 2;
                }
            } else if (!action.equals(str)) {
                $jacocoInit[27] = true;
            } else {
                $jacocoInit[28] = true;
                c = 1;
            }
            if (c == 0) {
                onPackageAdded(packageName);
                $jacocoInit[32] = true;
            } else if (c == 1) {
                onPackageReplaced(packageName);
                $jacocoInit[33] = true;
            } else if (c != 2) {
                $jacocoInit[31] = true;
            } else {
                onPackageRemoved(packageName);
                $jacocoInit[34] = true;
            }
        }
        $jacocoInit[35] = true;
    }

    /* access modifiers changed from: protected */
    public void onPackageAdded(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Package added: ");
        sb.append(packageName);
        String sb2 = sb.toString();
        $jacocoInit[36] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[37] = true;
        PackageInfo packageInfo = databaseOnPackageAdded(packageName);
        $jacocoInit[38] = true;
        checkAndBroadcastReferrer(packageName);
        $jacocoInit[39] = true;
        sendInstallEvent(packageName, packageInfo);
        $jacocoInit[40] = true;
        sendCampaignConversion(packageName, packageInfo);
        $jacocoInit[41] = true;
        this.appcMigrationManager.persistCandidate(packageName);
        $jacocoInit[42] = true;
    }

    /* access modifiers changed from: protected */
    public void onPackageReplaced(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Packaged replaced: ");
        sb.append(packageName);
        String sb2 = sb.toString();
        $jacocoInit[43] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[44] = true;
        PackageInfo packageInfo = databaseOnPackageReplaced(packageName);
        $jacocoInit[45] = true;
        sendInstallEvent(packageName, packageInfo);
        $jacocoInit[46] = true;
        sendCampaignConversion(packageName, packageInfo);
        $jacocoInit[47] = true;
    }

    /* access modifiers changed from: protected */
    public void onPackageRemoved(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Packaged removed: ");
        sb.append(packageName);
        String sb2 = sb.toString();
        $jacocoInit[48] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[49] = true;
        sendUninstallEvent(packageName);
        $jacocoInit[50] = true;
        databaseOnPackageRemoved(packageName);
        $jacocoInit[51] = true;
    }

    private PackageInfo databaseOnPackageAdded(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        PackageInfo packageInfo = SystemU.getPackageInfo(packageName, getPackageManager());
        $jacocoInit[52] = true;
        if (checkAndLogNullPackageInfo(packageInfo, packageName)) {
            $jacocoInit[53] = true;
            return packageInfo;
        }
        Installed installed = new Installed(packageInfo, this.packageManager);
        $jacocoInit[54] = true;
        C0117M onAppInstalled = this.installManager.onAppInstalled(installed);
        C3979Ca ca = C3979Ca.f7461a;
        C3983Ea ea = C3983Ea.f7465a;
        $jacocoInit[55] = true;
        onAppInstalled.mo3588a((C0128a) ca, (C0129b<? super Throwable>) ea);
        $jacocoInit[56] = true;
        return packageInfo;
    }

    /* renamed from: a */
    static /* synthetic */ void m8561a() {
        $jacocoInit()[128] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8565b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[126] = true;
        instance.log(throwable);
        $jacocoInit[127] = true;
    }

    private void checkAndBroadcastReferrer(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[57] = true;
        $jacocoInit[58] = true;
        StoredMinimalAdAccessor storedMinimalAdAccessor = (StoredMinimalAdAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) getApplicationContext().getApplicationContext()).getDatabase(), StoredMinimalAd.class);
        $jacocoInit[59] = true;
        C0120S s = storedMinimalAdAccessor.get(packageName);
        C3998La la = new C3998La(this, packageName, storedMinimalAdAccessor);
        $jacocoInit[60] = true;
        C0120S g = s.mo3663g((C0132p<? super T, ? extends C0117M>) la);
        C3977Ba ba = C3977Ba.f7459a;
        C3991Ia ia = C3991Ia.f7474a;
        $jacocoInit[61] = true;
        C0137ja unManagedSubscription = g.mo3626a((C0129b<? super T>) ba, (C0129b<Throwable>) ia);
        $jacocoInit[62] = true;
        this.subscriptions.mo3713a(unManagedSubscription);
        $jacocoInit[63] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15053a(String packageName, StoredMinimalAdAccessor storedMinimalAdAccessor, StoredMinimalAd storeMinimalAd) {
        boolean[] $jacocoInit = $jacocoInit();
        if (storeMinimalAd != null) {
            $jacocoInit[123] = true;
            C0117M knockCpi = knockCpi(packageName, storedMinimalAdAccessor, storeMinimalAd);
            $jacocoInit[124] = true;
            return knockCpi;
        }
        $jacocoInit[125] = true;
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m8562a(StoredMinimalAd __) {
        $jacocoInit()[122] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8564a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[120] = true;
        instance.log(err);
        $jacocoInit[121] = true;
    }

    private void sendInstallEvent(String packageName, PackageInfo packageInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        if (packageInfo != null) {
            InstallAnalytics installAnalytics2 = this.installAnalytics;
            int i = packageInfo.versionCode;
            RootAvailabilityManager rootAvailabilityManager2 = this.rootAvailabilityManager;
            $jacocoInit[64] = true;
            Single isRootAvailable = rootAvailabilityManager2.isRootAvailable();
            $jacocoInit[65] = true;
            C14959b a = isRootAvailable.mo3689a();
            $jacocoInit[66] = true;
            boolean booleanValue = ((Boolean) a.mo46175a()).booleanValue();
            boolean allowRootInstallation = ManagerPreferences.allowRootInstallation(this.sharedPreferences);
            $jacocoInit[67] = true;
            installAnalytics2.installCompleted(packageName, i, booleanValue, allowRootInstallation);
            $jacocoInit[68] = true;
            return;
        }
        reportPackageInfoNullEvent();
        $jacocoInit[69] = true;
    }

    private void sendUninstallEvent(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installAnalytics.uninstallCompleted(packageName);
        $jacocoInit[70] = true;
    }

    private void reportPackageInfoNullEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        NullPointerException nullPointerException = new NullPointerException("PackageInfo is null.");
        $jacocoInit[71] = true;
        instance.log(nullPointerException);
        $jacocoInit[72] = true;
    }

    private PackageInfo databaseOnPackageReplaced(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.updatesRepository.get(packageName);
        $jacocoInit[73] = true;
        C0120S d = s.mo3647d();
        C3989Ha ha = C3989Ha.f7472a;
        $jacocoInit[74] = true;
        C0120S a = d.mo3621a((C0129b<? super Throwable>) ha);
        C3981Da da = C3981Da.f7463a;
        $jacocoInit[75] = true;
        C0120S l = a.mo3674l(da);
        $jacocoInit[76] = true;
        C14906b k = l.mo3672k();
        $jacocoInit[77] = true;
        Update update = (Update) k.mo46110a();
        $jacocoInit[78] = true;
        PackageInfo packageInfo = SystemU.getPackageInfo(packageName, getPackageManager());
        $jacocoInit[79] = true;
        if (checkAndLogNullPackageInfo(packageInfo, packageName)) {
            $jacocoInit[80] = true;
            return packageInfo;
        }
        C0117M onUpdateConfirmed = this.installManager.onUpdateConfirmed(new Installed(packageInfo, this.packageManager));
        UpdateRepository updateRepository = this.updatesRepository;
        $jacocoInit[81] = true;
        C0117M a2 = onUpdateConfirmed.mo3580a(updateRepository.remove(update));
        C3987Ga ga = new C3987Ga(packageName);
        C3994Ja ja = C3994Ja.f7477a;
        $jacocoInit[82] = true;
        a2.mo3588a((C0128a) ga, (C0129b<? super Throwable>) ja);
        $jacocoInit[83] = true;
        return packageInfo;
    }

    /* renamed from: d */
    static /* synthetic */ void m8568d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[118] = true;
        instance.log(throwable);
        $jacocoInit[119] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Update m8569e(Throwable throwable) {
        $jacocoInit()[117] = true;
        return null;
    }

    /* renamed from: c */
    static /* synthetic */ void m8566c(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("databaseOnPackageReplaced: ");
        sb.append(packageName);
        String sb2 = sb.toString();
        $jacocoInit[115] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[116] = true;
    }

    /* renamed from: f */
    static /* synthetic */ void m8570f(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[113] = true;
        instance.log(throwable);
        $jacocoInit[114] = true;
    }

    private void databaseOnPackageRemoved(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M onAppRemoved = this.installManager.onAppRemoved(packageName);
        C3996Ka ka = new C3996Ka(this, packageName);
        $jacocoInit[84] = true;
        C0117M a = onAppRemoved.mo3580a(C0117M.m597c((C0128a) ka));
        C3985Fa fa = new C3985Fa(packageName);
        C4000Ma ma = C4000Ma.f7486a;
        $jacocoInit[85] = true;
        a.mo3588a((C0128a) fa, (C0129b<? super Throwable>) ma);
        $jacocoInit[86] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15055b(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updatesRepository.remove(packageName);
        $jacocoInit[112] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8563a(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("databaseOnPackageRemoved: ");
        sb.append(packageName);
        String sb2 = sb.toString();
        $jacocoInit[110] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[111] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8567c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[108] = true;
        instance.log(throwable);
        $jacocoInit[109] = true;
    }

    private boolean checkAndLogNullPackageInfo(PackageInfo packageInfo, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (packageInfo == null) {
            $jacocoInit[87] = true;
            CrashReport instance = CrashReport.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("PackageName null for package ");
            sb.append(packageName);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
            $jacocoInit[88] = true;
            instance.log(illegalArgumentException);
            $jacocoInit[89] = true;
            return true;
        }
        $jacocoInit[90] = true;
        return false;
    }

    private C0117M knockCpi(String packageName, StoredMinimalAdAccessor storedMinimalAdAccessor, StoredMinimalAd storeMinimalAd) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m584a((Callable<?>) new C4004Oa<Object>(this, packageName, storeMinimalAd, storedMinimalAdAccessor));
        $jacocoInit[91] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Object mo15052a(String packageName, StoredMinimalAd storeMinimalAd, StoredMinimalAdAccessor storedMinimalAdAccessor) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        String referrer = storeMinimalAd.getReferrer();
        $jacocoInit[103] = true;
        Context applicationContext = getApplicationContext();
        $jacocoInit[104] = true;
        ReferrerUtils.broadcastReferrer(packageName, referrer, applicationContext);
        $jacocoInit[105] = true;
        AdNetworkUtils.knockCpi(this.adMapper.map(storeMinimalAd));
        $jacocoInit[106] = true;
        storedMinimalAdAccessor.remove(storeMinimalAd);
        $jacocoInit[107] = true;
        return null;
    }

    private C0117M extractReferrer(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S adsFromSecondInstall = this.adsRepository.getAdsFromSecondInstall(packageName);
        $jacocoInit[92] = true;
        C0120S a = adsFromSecondInstall.mo3616a(C14522a.m46170a());
        C4002Na na = new C4002Na(this);
        $jacocoInit[93] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) na);
        $jacocoInit[94] = true;
        C0117M l = b.mo3673l();
        $jacocoInit[95] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15054a(MinimalAd minimalAd) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult = new SearchAdResult(minimalAd);
        AdsRepository adsRepository2 = this.adsRepository;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        QManager qManager2 = this.qManager;
        $jacocoInit[100] = true;
        Context applicationContext = getApplicationContext();
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        MinimalAdMapper minimalAdMapper = new MinimalAdMapper();
        $jacocoInit[101] = true;
        ReferrerUtils.extractReferrer(searchAdResult, 2, true, adsRepository2, okHttpClient, factory, qManager2, applicationContext, sharedPreferences2, minimalAdMapper);
        $jacocoInit[102] = true;
    }

    private void sendCampaignConversion(String packageName, PackageInfo packageInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        if (packageInfo != null) {
            $jacocoInit[96] = true;
            this.campaignAnalytics.convertCampaignEvent(packageName, packageInfo.versionCode);
            $jacocoInit[97] = true;
        } else {
            reportPackageInfoNullEvent();
            $jacocoInit[98] = true;
        }
        $jacocoInit[99] = true;
    }
}
