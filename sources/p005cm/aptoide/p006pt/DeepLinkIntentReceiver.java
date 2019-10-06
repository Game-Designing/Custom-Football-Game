package p005cm.aptoide.p006pt;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ShortcutManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppRequest;
import p005cm.aptoide.p006pt.link.AptoideInstall;
import p005cm.aptoide.p006pt.link.AptoideInstallParser;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment.BundleKeys;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.ActivityProvider;
import p005cm.aptoide.p006pt.view.ActivityView;
import p005cm.aptoide.p006pt.wallet.WalletInstallActivity;
import p026rx.C0120S;
import p026rx.p398d.C14906b;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.DeepLinkIntentReceiver */
public class DeepLinkIntentReceiver extends ActivityView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String AUTHORITY = "cm.aptoide.pt";
    public static final int DEEPLINK_ID = 1;
    public static final String DEEP_LINK = "deeplink";
    public static final String FROM_SHORTCUT = "from_shortcut";
    public static final String SCHEDULE_DOWNLOADS = "schedule_downloads";
    public static final int SCHEDULE_DOWNLOADS_ID = 2;
    private static final String TAG = DeepLinkIntentReceiver.class.getSimpleName();
    private static final UriMatcher sURIMatcher = new UriMatcher(-1);
    private String TMP_MYAPP_FILE;
    private MinimalAdMapper adMapper;
    private AnalyticsManager analyticsManager;
    private HashMap<String, String> app;
    private DeepLinkAnalytics deepLinkAnalytics;
    private NavigationTracker navigationTracker;
    private ArrayList<String> server;
    private boolean shortcutNavigation;
    private Class startClass;

    /* renamed from: cm.aptoide.pt.DeepLinkIntentReceiver$DeepLinksKeys */
    public static class DeepLinksKeys {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String ACTION = "action";
        public static final String APK_FY = "APK_FY";
        public static final String APP_ID_KEY = "appId";
        public static final String APP_MD5_KEY = "md5";
        public static final String CARD_ID = "cardId";
        public static final String LAYOUT = "layout";
        public static final String NAME = "name";
        public static final String OPEN_MODE = "openMode";
        public static final String PACKAGE_NAME_KEY = "packageName";
        public static final String SHOW_AUTO_INSTALL_POPUP = "show_auto_install_popup";
        public static final String STORENAME_KEY = "storeName";
        public static final String STORE_THEME = "storetheme";
        public static final String TITLE = "title";
        public static final String TYPE = "type";
        public static final String UNAME = "uname";
        public static final String URI = "uri";
        public static final String WALLET_PACKAGE_NAME_KEY = "wallet_package_name";

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6643013037043103883L, "cm/aptoide/pt/DeepLinkIntentReceiver$DeepLinksKeys", 1);
            $jacocoData = probes;
            return probes;
        }

        public DeepLinksKeys() {
            $jacocoInit()[0] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.DeepLinkIntentReceiver$DeepLinksTargets */
    public static class DeepLinksTargets {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String APPC_INFO_VIEW = "appc_info_view";
        public static final String APP_VIEW_FRAGMENT = "appViewFragment";
        public static final String EDITORIAL_DEEPLINK = "editorial";
        public static final String FROM_AD = "fromAd";
        public static final String FROM_DOWNLOAD_NOTIFICATION = "fromDownloadNotification";
        public static final String GENERIC_DEEPLINK = "generic_deeplink";
        public static final String HOME_DEEPLINK = "home_tab";
        public static final String MY_STORE_DEEPLINK = "my_store";
        public static final String NEW_REPO = "newrepo";
        public static final String NEW_UPDATES = "new_updates";
        public static final String PICK_APP_DEEPLINK = "pick_app_deeplink";
        public static final String PROMOTIONS_DEEPLINK = "promotions";
        public static final String SEARCH_FRAGMENT = "searchFragment";
        public static final String TIMELINE_DEEPLINK = "apps_timeline";
        public static final String USER_DEEPLINK = "open_user_profile";

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8180005461369310458L, "cm/aptoide/pt/DeepLinkIntentReceiver$DeepLinksTargets", 1);
            $jacocoData = probes;
            return probes;
        }

        public DeepLinksTargets() {
            $jacocoInit()[0] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.DeepLinkIntentReceiver$MyAppDownloader */
    class MyAppDownloader extends AsyncTask<String, Void, Void> {
        private static transient /* synthetic */ boolean[] $jacocoData;

        /* renamed from: pd */
        ProgressDialog f4257pd;
        final /* synthetic */ DeepLinkIntentReceiver this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(548321290439589356L, "cm/aptoide/pt/DeepLinkIntentReceiver$MyAppDownloader", 24);
            $jacocoData = probes;
            return probes;
        }

        MyAppDownloader(DeepLinkIntentReceiver this$02) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = this$02;
            $jacocoInit[0] = true;
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            boolean[] $jacocoInit = $jacocoInit();
            Void doInBackground = doInBackground((String[]) objArr);
            $jacocoInit[23] = true;
            return doInBackground;
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            boolean[] $jacocoInit = $jacocoInit();
            onPostExecute((Void) obj);
            $jacocoInit[22] = true;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                DeepLinkIntentReceiver.access$000(this.this$0, params[0]);
                $jacocoInit[1] = true;
                DeepLinkIntentReceiver.access$200(this.this$0, DeepLinkIntentReceiver.access$100(this.this$0));
                $jacocoInit[2] = true;
            } catch (Exception e) {
                $jacocoInit[3] = true;
                CrashReport instance = CrashReport.getInstance();
                $jacocoInit[4] = true;
                instance.log(e);
                $jacocoInit[5] = true;
            }
            $jacocoInit[6] = true;
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            boolean[] $jacocoInit = $jacocoInit();
            super.onPreExecute();
            $jacocoInit[7] = true;
            this.f4257pd = new ProgressDialog(this.this$0);
            $jacocoInit[8] = true;
            this.f4257pd.show();
            $jacocoInit[9] = true;
            this.f4257pd.setCancelable(false);
            $jacocoInit[10] = true;
            this.f4257pd.setMessage(this.this$0.getString(C1375R.string.please_wait));
            $jacocoInit[11] = true;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void aVoid) {
            boolean[] $jacocoInit = $jacocoInit();
            super.onPostExecute(aVoid);
            $jacocoInit[12] = true;
            if (!this.f4257pd.isShowing()) {
                $jacocoInit[13] = true;
            } else if (this.this$0.isFinishing()) {
                $jacocoInit[14] = true;
            } else {
                $jacocoInit[15] = true;
                this.f4257pd.dismiss();
                $jacocoInit[16] = true;
            }
            if (DeepLinkIntentReceiver.access$300(this.this$0) == null) {
                $jacocoInit[17] = true;
            } else if (DeepLinkIntentReceiver.access$300(this.this$0).isEmpty()) {
                $jacocoInit[18] = true;
            } else {
                $jacocoInit[19] = true;
                $jacocoInit[21] = true;
            }
            DeepLinkIntentReceiver.access$400(this.this$0);
            $jacocoInit[20] = true;
            $jacocoInit[21] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7742945324960133389L, "cm/aptoide/pt/DeepLinkIntentReceiver", 412);
        $jacocoData = probes;
        return probes;
    }

    public DeepLinkIntentReceiver() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        ActivityProvider activityProvider = AptoideApplication.getActivityProvider();
        $jacocoInit[1] = true;
        this.startClass = activityProvider.getMainActivityFragmentClass();
        $jacocoInit[2] = true;
    }

    static /* synthetic */ void access$000(DeepLinkIntentReceiver x0, String x1) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        x0.downloadMyAppFile(x1);
        $jacocoInit[403] = true;
    }

    static /* synthetic */ String access$100(DeepLinkIntentReceiver x0) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = x0.TMP_MYAPP_FILE;
        $jacocoInit[404] = true;
        return str;
    }

    static /* synthetic */ void access$200(DeepLinkIntentReceiver x0, String x1) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        x0.parseXmlMyapp(x1);
        $jacocoInit[405] = true;
    }

    static /* synthetic */ HashMap access$300(DeepLinkIntentReceiver x0) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, String> hashMap = x0.app;
        $jacocoInit[406] = true;
        return hashMap;
    }

    static /* synthetic */ void access$400(DeepLinkIntentReceiver x0) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.proceed();
        $jacocoInit[407] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[408] = true;
        $jacocoInit[409] = true;
        String str = "cm.aptoide.pt";
        sURIMatcher.addURI(str, DEEP_LINK, 1);
        $jacocoInit[410] = true;
        sURIMatcher.addURI(str, SCHEDULE_DOWNLOADS, 2);
        $jacocoInit[411] = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
            r9 = this;
            boolean[] r0 = $jacocoInit()
            super.onCreate(r10)
            r1 = 1
            r2 = 3
            r0[r2] = r1
            android.content.Context r2 = r9.getApplicationContext()
            cm.aptoide.pt.AptoideApplication r2 = (p005cm.aptoide.p006pt.AptoideApplication) r2
            r3 = 4
            r0[r3] = r1
            cm.aptoide.analytics.AnalyticsManager r3 = r2.getAnalyticsManager()
            r9.analyticsManager = r3
            r3 = 5
            r0[r3] = r1
            cm.aptoide.analytics.implementation.navigation.NavigationTracker r3 = r2.getNavigationTracker()
            r9.navigationTracker = r3
            r3 = 6
            r0[r3] = r1
            cm.aptoide.pt.DeepLinkAnalytics r3 = new cm.aptoide.pt.DeepLinkAnalytics
            cm.aptoide.analytics.AnalyticsManager r4 = r9.analyticsManager
            cm.aptoide.analytics.implementation.navigation.NavigationTracker r5 = r9.navigationTracker
            r3.<init>(r4, r5)
            r9.deepLinkAnalytics = r3
            r3 = 7
            r0[r3] = r1
            cm.aptoide.pt.ads.MinimalAdMapper r3 = new cm.aptoide.pt.ads.MinimalAdMapper
            r3.<init>()
            r9.adMapper = r3
            r3 = 8
            r0[r3] = r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r4 = r9.getCacheDir()
            r3.append(r4)
            java.lang.String r4 = "/myapp.myapp"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r9.TMP_MYAPP_FILE = r3
            r3 = 9
            r0[r3] = r1
            android.content.Intent r3 = r9.getIntent()
            java.lang.String r3 = r3.getDataString()
            r4 = 10
            r0[r4] = r1
            cm.aptoide.pt.DeepLinkAnalytics r4 = r9.deepLinkAnalytics
            r4.website(r3)
            r4 = 0
            r9.shortcutNavigation = r4
            r4 = 11
            r0[r4] = r1
            cm.aptoide.pt.logger.Logger r4 = p005cm.aptoide.p006pt.logger.Logger.getInstance()
            java.lang.String r5 = TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "uri: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            r7 = 12
            r0[r7] = r1
            r4.mo2146v(r5, r6)
            r4 = 13
            r0[r4] = r1
            r9.dealWithShortcuts()
            r4 = 14
            r5 = 0
            r0[r4] = r1     // Catch:{ Exception -> 0x00ac }
            r4 = r5
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00a7 }
            r4 = r5
            r5 = 15
            r0[r5] = r1
            goto L_0x00c1
        L_0x00a7:
            r5 = move-exception
            r8 = r5
            r5 = r4
            r4 = r8
            goto L_0x00ad
        L_0x00ac:
            r4 = move-exception
        L_0x00ad:
            r6 = 16
            r0[r6] = r1
            cm.aptoide.pt.crashreports.CrashReport r6 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r7 = 17
            r0[r7] = r1
            r6.log(r4)
            r6 = 18
            r0[r6] = r1
            r4 = r5
        L_0x00c1:
            r5 = 0
            r6 = 19
            r0[r6] = r1
            if (r4 != 0) goto L_0x00ce
            r6 = 20
            r0[r6] = r1
            goto L_0x029f
        L_0x00ce:
            java.lang.String r6 = r4.getHost()
            if (r6 != 0) goto L_0x00da
            r6 = 21
            r0[r6] = r1
            goto L_0x029f
        L_0x00da:
            r6 = 22
            r0[r6] = r1
            java.lang.String r6 = r4.getHost()
            r7 = 23
            r0[r7] = r1
            java.lang.String r7 = "webservices.aptoide.com"
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x00fc
            r6 = 24
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithWebservicesAptoide(r3)
            r6 = 25
            r0[r6] = r1
            goto L_0x029f
        L_0x00fc:
            java.lang.String r6 = r4.getHost()
            r7 = 26
            r0[r7] = r1
            java.lang.String r7 = "imgs.aptoide.com"
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x011a
            r6 = 27
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithImagesApoide(r3)
            r6 = 28
            r0[r6] = r1
            goto L_0x029f
        L_0x011a:
            java.lang.String r6 = r4.getHost()
            r7 = 29
            r0[r7] = r1
            java.lang.String r7 = "aptoide.com"
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0138
            r6 = 30
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithAptoideWebsite(r4)
            r6 = 31
            r0[r6] = r1
            goto L_0x029f
        L_0x0138:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "aptoiderepo"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0152
            r6 = 32
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithAptoideRepo(r3)
            r6 = 33
            r0[r6] = r1
            goto L_0x029f
        L_0x0152:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "aptoidexml"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x016c
            r6 = 34
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithAptoideXml(r3)
            r6 = 35
            r0[r6] = r1
            goto L_0x029f
        L_0x016c:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "aptoidesearch"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x018e
            r6 = 36
            r0[r6] = r1
            java.lang.String r6 = "aptoidesearch://"
            java.lang.String[] r6 = r3.split(r6)
            r6 = r6[r1]
            android.content.Intent r5 = r9.startFromPackageName(r6)
            r6 = 37
            r0[r6] = r1
            goto L_0x029f
        L_0x018e:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "market"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x01a8
            r6 = 38
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithMarketSchema(r3, r4)
            r6 = 39
            r0[r6] = r1
            goto L_0x029f
        L_0x01a8:
            java.lang.String r6 = r4.getHost()
            r7 = 40
            r0[r7] = r1
            java.lang.String r7 = "market.android.com"
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x01cc
            r6 = 41
            r0[r6] = r1
            java.lang.String r6 = "id"
            java.lang.String r6 = r4.getQueryParameter(r6)
            android.content.Intent r5 = r9.startFromPackageName(r6)
            r6 = 42
            r0[r6] = r1
            goto L_0x029f
        L_0x01cc:
            java.lang.String r6 = r4.getHost()
            r7 = 43
            r0[r7] = r1
            java.lang.String r7 = "play.google.com"
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x01e1
            r6 = 44
            r0[r6] = r1
            goto L_0x01f5
        L_0x01e1:
            java.lang.String r6 = r4.getPath()
            r7 = 45
            r0[r7] = r1
            java.lang.String r7 = "store/apps/details"
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x0293
            r6 = 46
            r0[r6] = r1
        L_0x01f5:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "aptword"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x020f
            r6 = 49
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithAptword(r3)
            r6 = 50
            r0[r6] = r1
            goto L_0x029f
        L_0x020f:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "file"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0228
            r6 = 51
            r0[r6] = r1
            r9.downloadMyApp()
            r6 = 52
            r0[r6] = r1
            goto L_0x029f
        L_0x0228:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "aptoideinstall"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x024b
            r6 = 53
            r0[r6] = r1
            java.lang.String r6 = "aptoideinstall://"
            int r6 = r6.length()
            java.lang.String r6 = r3.substring(r6)
            android.content.Intent r5 = r9.parseAptoideInstallUri(r6)
            r6 = 54
            r0[r6] = r1
            goto L_0x029f
        L_0x024b:
            java.lang.String r6 = r4.getHost()
            r7 = 55
            r0[r7] = r1
            java.lang.String r7 = "cm.aptoide.pt"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0260
            r6 = 56
            r0[r6] = r1
            goto L_0x029f
        L_0x0260:
            java.lang.String r6 = r4.getPath()
            r7 = 57
            r0[r7] = r1
            java.lang.String r7 = "/deeplink"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0275
            r6 = 58
            r0[r6] = r1
            goto L_0x029f
        L_0x0275:
            java.lang.String r6 = r4.getScheme()
            java.lang.String r7 = "aptoide"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 != 0) goto L_0x0286
            r6 = 59
            r0[r6] = r1
            goto L_0x029f
        L_0x0286:
            r6 = 60
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithAptoideSchema(r4)
            r6 = 61
            r0[r6] = r1
            goto L_0x029f
        L_0x0293:
            r6 = 47
            r0[r6] = r1
            android.content.Intent r5 = r9.dealWithGoogleHost(r4)
            r6 = 48
            r0[r6] = r1
        L_0x029f:
            if (r5 != 0) goto L_0x02a6
            r6 = 62
            r0[r6] = r1
            goto L_0x02b1
        L_0x02a6:
            r6 = 63
            r0[r6] = r1
            r9.startActivity(r5)
            r6 = 64
            r0[r6] = r1
        L_0x02b1:
            cm.aptoide.pt.DeepLinkAnalytics r6 = r9.deepLinkAnalytics
            r6.sendWebsite()
            r6 = 65
            r0[r6] = r1
            r9.finish()
            r6 = 66
            r0[r6] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.DeepLinkIntentReceiver.onCreate(android.os.Bundle):void");
    }

    private Intent dealWithAptoideSchema(Uri u) {
        boolean[] $jacocoInit = $jacocoInit();
        String query = "name";
        if ("getHome".equals(u.getQueryParameter(query))) {
            $jacocoInit[67] = true;
            String id = u.getQueryParameter(BundleKeys.USER_ID);
            if (id != null) {
                $jacocoInit[68] = true;
                Intent openUserScreen = openUserScreen(Long.valueOf(id));
                $jacocoInit[69] = true;
                return openUserScreen;
            }
            $jacocoInit[70] = true;
        } else {
            if ("getUserTimeline".equals(u.getQueryParameter(query))) {
                $jacocoInit[71] = true;
                Intent startFromAppsTimeline = startFromAppsTimeline(u.getQueryParameter("cardId"));
                $jacocoInit[72] = true;
                return startFromAppsTimeline;
            }
            if ("search".equals(u.getQueryParameter(query))) {
                String query2 = "";
                $jacocoInit[73] = true;
                Set queryParameterNames = u.getQueryParameterNames();
                $jacocoInit[74] = true;
                String str = "keyword";
                if (!queryParameterNames.contains(str)) {
                    $jacocoInit[75] = true;
                } else {
                    $jacocoInit[76] = true;
                    query2 = u.getQueryParameter(str);
                    $jacocoInit[77] = true;
                }
                Intent startFromSearch = startFromSearch(query2);
                $jacocoInit[78] = true;
                return startFromSearch;
            }
            if ("myStore".equals(u.getQueryParameter(query))) {
                $jacocoInit[79] = true;
                Intent startFromMyStore = startFromMyStore();
                $jacocoInit[80] = true;
                return startFromMyStore;
            }
            if ("pickApp".equals(u.getQueryParameter(query))) {
                $jacocoInit[81] = true;
                Intent startFromPickApp = startFromPickApp();
                $jacocoInit[82] = true;
                return startFromPickApp;
            }
            if (DeepLinksTargets.PROMOTIONS_DEEPLINK.equals(u.getQueryParameter(query))) {
                $jacocoInit[83] = true;
                Intent startFromPromotions = startFromPromotions();
                $jacocoInit[84] = true;
                return startFromPromotions;
            }
            if (!"CURATION_1".equals(u.getQueryParameter(query))) {
                $jacocoInit[85] = true;
            } else {
                $jacocoInit[86] = true;
                String str2 = "id";
                if (u.getQueryParameter(str2) == null) {
                    $jacocoInit[87] = true;
                } else {
                    $jacocoInit[88] = true;
                    Intent startFromEditorialCard = startFromEditorialCard(u.getQueryParameter(str2));
                    $jacocoInit[89] = true;
                    return startFromEditorialCard;
                }
            }
            if (DeepLinksTargets.APPC_INFO_VIEW.equals(u.getQueryParameter(query))) {
                $jacocoInit[90] = true;
                Intent startAppcInfoView = startAppcInfoView();
                $jacocoInit[91] = true;
                return startAppcInfoView;
            } else if (sURIMatcher.match(u) != 1) {
                $jacocoInit[92] = true;
            } else {
                $jacocoInit[93] = true;
                Intent startGenericDeepLink = startGenericDeepLink(u);
                $jacocoInit[94] = true;
                return startGenericDeepLink;
            }
        }
        $jacocoInit[95] = true;
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent dealWithAptword(java.lang.String r10) {
        /*
            r9 = this;
            boolean[] r0 = $jacocoInit()
            java.lang.String r1 = "aptword://"
            int r1 = r1.length()
            java.lang.String r1 = r10.substring(r1)
            r2 = 1
            r3 = 96
            r0[r3] = r2
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            r4 = 0
            if (r3 == 0) goto L_0x001f
            r3 = 97
            r0[r3] = r2
            goto L_0x008f
        L_0x001f:
            r3 = 98
            r0[r3] = r2
            java.lang.String r3 = "\\*"
            java.lang.String r5 = "_"
            java.lang.String r3 = r1.replaceAll(r3, r5)
            r5 = 99
            r0[r5] = r2
            java.lang.String r5 = "\\+"
            java.lang.String r6 = "/"
            java.lang.String r1 = r3.replaceAll(r5, r6)
            r3 = 100
            r0[r3] = r2
            java.lang.String r3 = new java.lang.String
            byte[] r5 = r1.getBytes()
            r6 = 0
            byte[] r5 = android.util.Base64.decode(r5, r6)
            r3.<init>(r5)
            r5 = 101(0x65, float:1.42E-43)
            r0[r5] = r2
            cm.aptoide.pt.logger.Logger r5 = p005cm.aptoide.p006pt.logger.Logger.getInstance()
            r6 = 102(0x66, float:1.43E-43)
            r0[r6] = r2
            java.lang.String r6 = "AptoideAptWord"
            r5.mo2136d(r6, r3)
            r5 = 103(0x67, float:1.44E-43)
            r0[r5] = r2     // Catch:{ IOException -> 0x0074 }
            r5 = r4
            com.fasterxml.jackson.databind.ObjectMapper r6 = new com.fasterxml.jackson.databind.ObjectMapper     // Catch:{ IOException -> 0x0072 }
            r6.<init>()     // Catch:{ IOException -> 0x0072 }
            java.lang.Class<cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Ad> r7 = p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad.class
            java.lang.Object r6 = r6.readValue(r3, r7)     // Catch:{ IOException -> 0x0072 }
            cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse$Ad r6 = (p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad) r6     // Catch:{ IOException -> 0x0072 }
            r5 = r6
            r6 = 104(0x68, float:1.46E-43)
            r0[r6] = r2
            goto L_0x0089
        L_0x0072:
            r6 = move-exception
            goto L_0x0076
        L_0x0074:
            r6 = move-exception
            r5 = r4
        L_0x0076:
            r7 = 105(0x69, float:1.47E-43)
            r0[r7] = r2
            cm.aptoide.pt.crashreports.CrashReport r7 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r8 = 106(0x6a, float:1.49E-43)
            r0[r8] = r2
            r7.log(r6)
            r7 = 107(0x6b, float:1.5E-43)
            r0[r7] = r2
        L_0x0089:
            if (r5 != 0) goto L_0x0094
            r6 = 108(0x6c, float:1.51E-43)
            r0[r6] = r2
        L_0x008f:
            r3 = 112(0x70, float:1.57E-43)
            r0[r3] = r2
            return r4
        L_0x0094:
            r4 = 109(0x6d, float:1.53E-43)
            r0[r4] = r2
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class r6 = r9.startClass
            r4.<init>(r9, r6)
            r6 = 110(0x6e, float:1.54E-43)
            r0[r6] = r2
            cm.aptoide.pt.ads.MinimalAdMapper r6 = r9.adMapper
            cm.aptoide.pt.database.realm.MinimalAd r6 = r6.map(r5)
            java.lang.String r7 = "fromAd"
            r4.putExtra(r7, r6)
            r6 = 111(0x6f, float:1.56E-43)
            r0[r6] = r2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.DeepLinkIntentReceiver.dealWithAptword(java.lang.String):android.content.Intent");
    }

    private Intent dealWithGoogleHost(Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        String param = uri.getQueryParameter("id");
        $jacocoInit[113] = true;
        if (param.contains("pname:")) {
            $jacocoInit[114] = true;
            param = param.substring(6);
            $jacocoInit[115] = true;
        } else if (!param.contains("pub:")) {
            $jacocoInit[116] = true;
        } else {
            $jacocoInit[117] = true;
            param = param.substring(4);
            $jacocoInit[118] = true;
        }
        Intent startFromPackageName = startFromPackageName(param);
        $jacocoInit[119] = true;
        return startFromPackageName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent dealWithMarketSchema(java.lang.String r8, android.net.Uri r9) {
        /*
            r7 = this;
            boolean[] r0 = $jacocoInit()
            java.lang.String r1 = ""
            r2 = 1
            r3 = 120(0x78, float:1.68E-43)
            r0[r3] = r2
            java.lang.String r3 = r9.getHost()
            java.lang.String r4 = "details"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0027
            r3 = 121(0x79, float:1.7E-43)
            r0[r3] = r2
            java.lang.String r3 = "id"
            java.lang.String r1 = r9.getQueryParameter(r3)
            r3 = 122(0x7a, float:1.71E-43)
            r0[r3] = r2
            goto L_0x00ad
        L_0x0027:
            java.lang.String r3 = r9.getHost()
            java.lang.String r4 = "search"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0042
            r3 = 123(0x7b, float:1.72E-43)
            r0[r3] = r2
            java.lang.String r3 = "q"
            java.lang.String r1 = r9.getQueryParameter(r3)
            r3 = 124(0x7c, float:1.74E-43)
            r0[r3] = r2
            goto L_0x00ad
        L_0x0042:
            java.lang.String r3 = "&"
            java.lang.String[] r3 = r8.split(r3)
            r4 = 0
            r3 = r3[r4]
            r4 = 125(0x7d, float:1.75E-43)
            r0[r4] = r2
            java.lang.String r4 = "="
            java.lang.String[] r5 = r3.split(r4)
            r6 = 126(0x7e, float:1.77E-43)
            r0[r6] = r2
            if (r5 != 0) goto L_0x0060
            r4 = 127(0x7f, float:1.78E-43)
            r0[r4] = r2
            goto L_0x0067
        L_0x0060:
            int r6 = r5.length
            if (r6 > r2) goto L_0x006e
            r4 = 128(0x80, float:1.794E-43)
            r0[r4] = r2
        L_0x0067:
            r4 = 130(0x82, float:1.82E-43)
            r0[r4] = r2
            java.lang.String r4 = ""
            goto L_0x0078
        L_0x006e:
            java.lang.String[] r4 = r3.split(r4)
            r4 = r4[r2]
            r6 = 129(0x81, float:1.81E-43)
            r0[r6] = r2
        L_0x0078:
            r1 = r4
            r4 = 131(0x83, float:1.84E-43)
            r0[r4] = r2
            java.lang.String r4 = "pname:"
            boolean r4 = r1.contains(r4)
            if (r4 == 0) goto L_0x0093
            r4 = 132(0x84, float:1.85E-43)
            r0[r4] = r2
            r4 = 6
            java.lang.String r1 = r1.substring(r4)
            r4 = 133(0x85, float:1.86E-43)
            r0[r4] = r2
            goto L_0x00ad
        L_0x0093:
            java.lang.String r4 = "pub:"
            boolean r4 = r1.contains(r4)
            if (r4 != 0) goto L_0x00a0
            r4 = 134(0x86, float:1.88E-43)
            r0[r4] = r2
            goto L_0x00ad
        L_0x00a0:
            r4 = 135(0x87, float:1.89E-43)
            r0[r4] = r2
            r4 = 4
            java.lang.String r1 = r1.substring(r4)
            r4 = 136(0x88, float:1.9E-43)
            r0[r4] = r2
        L_0x00ad:
            java.lang.String r3 = "utm_source"
            java.lang.String r3 = r9.getQueryParameter(r3)
            r4 = 137(0x89, float:1.92E-43)
            r0[r4] = r2
            java.lang.String r4 = "app_source"
            java.lang.String r4 = r9.getQueryParameter(r4)
            if (r3 != 0) goto L_0x00c4
            r5 = 138(0x8a, float:1.93E-43)
            r0[r5] = r2
            goto L_0x00fd
        L_0x00c4:
            r5 = 139(0x8b, float:1.95E-43)
            r0[r5] = r2
            boolean r5 = r7.isFromAppCoins(r3)
            if (r5 != 0) goto L_0x00d3
            r5 = 140(0x8c, float:1.96E-43)
            r0[r5] = r2
            goto L_0x00fd
        L_0x00d3:
            r5 = 141(0x8d, float:1.98E-43)
            r0[r5] = r2
            java.lang.String r5 = "com.appcoins.wallet"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x00e4
            r5 = 142(0x8e, float:1.99E-43)
            r0[r5] = r2
            goto L_0x00fd
        L_0x00e4:
            r5 = 143(0x8f, float:2.0E-43)
            r0[r5] = r2
            cm.aptoide.pt.DeepLinkAnalytics r5 = r7.deepLinkAnalytics
            r5.sendWalletDeepLinkEvent(r3)
            r5 = 144(0x90, float:2.02E-43)
            r0[r5] = r2
            java.lang.String r5 = "appcoinssdk"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0106
            r5 = 145(0x91, float:2.03E-43)
            r0[r5] = r2
        L_0x00fd:
            android.content.Intent r5 = r7.startFromPackageName(r1)
            r6 = 148(0x94, float:2.07E-43)
            r0[r6] = r2
            return r5
        L_0x0106:
            r5 = 146(0x92, float:2.05E-43)
            r0[r5] = r2
            android.content.Intent r5 = r7.startWalletInstallIntent(r1, r3, r4)
            r6 = 147(0x93, float:2.06E-43)
            r0[r6] = r2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.DeepLinkIntentReceiver.dealWithMarketSchema(java.lang.String, android.net.Uri):android.content.Intent");
    }

    private boolean isFromAppCoins(String utmSourceParameter) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (utmSourceParameter.equals("myappcoins")) {
            $jacocoInit[149] = true;
        } else if (utmSourceParameter.equals("appcoinssdk")) {
            $jacocoInit[150] = true;
        } else {
            z = false;
            $jacocoInit[152] = true;
            $jacocoInit[153] = true;
            return z;
        }
        $jacocoInit[151] = true;
        z = true;
        $jacocoInit[153] = true;
        return z;
    }

    private Intent dealWithAptoideXml(String uri) {
        boolean[] $jacocoInit = $jacocoInit();
        String repo = uri.substring(13);
        $jacocoInit[154] = true;
        parseXmlString(repo);
        $jacocoInit[155] = true;
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[156] = true;
        intent.putExtra(DeepLinksTargets.NEW_REPO, StoreUtils.split(repo));
        $jacocoInit[157] = true;
        return intent;
    }

    private Intent dealWithAptoideRepo(String uri) {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<String> repo = new ArrayList<>();
        $jacocoInit[158] = true;
        repo.add(uri.substring(14));
        $jacocoInit[159] = true;
        Intent startWithRepo = startWithRepo(StoreUtils.split((List<String>) repo));
        $jacocoInit[160] = true;
        return startWithRepo;
    }

    private Intent dealWithAptoideWebsite(Uri u) {
        boolean[] $jacocoInit = $jacocoInit();
        if (u.getPath() == null) {
            $jacocoInit[161] = true;
        } else {
            String path = u.getPath();
            $jacocoInit[162] = true;
            if (!path.contains("thank-you")) {
                $jacocoInit[163] = true;
            } else {
                $jacocoInit[164] = true;
                this.deepLinkAnalytics.websiteFromThankYouWebPage();
                $jacocoInit[165] = true;
                String appId = u.getQueryParameter(BundleCons.APP_ID);
                $jacocoInit[166] = true;
                Logger instance = Logger.getInstance();
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("aptoide thank you: app id: ");
                sb.append(appId);
                String sb2 = sb.toString();
                $jacocoInit[167] = true;
                instance.mo2146v(str, sb2);
                $jacocoInit[168] = true;
                if (TextUtils.isEmpty(appId)) {
                    $jacocoInit[169] = true;
                    return null;
                }
                Intent parseAptoideInstallUri = parseAptoideInstallUri(appId);
                $jacocoInit[170] = true;
                return parseAptoideInstallUri;
            }
        }
        String str2 = "store";
        if (u.getPath() == null) {
            $jacocoInit[171] = true;
        } else {
            String path2 = u.getPath();
            $jacocoInit[172] = true;
            if (!path2.contains("group")) {
                $jacocoInit[173] = true;
            } else {
                $jacocoInit[174] = true;
                this.deepLinkAnalytics.websiteFromBundlesWebPage();
                $jacocoInit[175] = true;
                List<String> path3 = u.getPathSegments();
                String bundleId = "";
                String storeName = "apps";
                $jacocoInit[176] = true;
                String path4 = u.getPath();
                $jacocoInit[177] = true;
                if (path4.contains(str2)) {
                    $jacocoInit[178] = true;
                    if (path3 == null) {
                        $jacocoInit[179] = true;
                    } else if (path3.size() < 4) {
                        $jacocoInit[180] = true;
                    } else {
                        $jacocoInit[181] = true;
                        bundleId = (String) path3.get(3);
                        $jacocoInit[182] = true;
                        storeName = (String) path3.get(1);
                        $jacocoInit[183] = true;
                    }
                } else {
                    bundleId = u.getLastPathSegment();
                    $jacocoInit[184] = true;
                }
                Logger instance2 = Logger.getInstance();
                String str3 = TAG;
                StringBuilder sb3 = new StringBuilder();
                String str4 = "aptoide web site: bundle: ";
                sb3.append(str4);
                sb3.append(bundleId);
                String sb4 = sb3.toString();
                $jacocoInit[185] = true;
                instance2.mo2146v(str3, sb4);
                $jacocoInit[186] = true;
                if (!TextUtils.isEmpty(bundleId)) {
                    try {
                        $jacocoInit[187] = true;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("aptoide://cm.aptoide.pt/deeplink?name=listApps&layout=GRID&type=API&title=bundle&action=");
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("https://ws75.aptoide.com/api/7/listApps/store_name=");
                        sb6.append(storeName);
                        sb6.append("/group_name=");
                        sb6.append(bundleId);
                        sb6.append("/limit=30/sort=downloads7d");
                        $jacocoInit[188] = true;
                        sb5.append(URLEncoder.encode(sb6.toString(), "utf-8"));
                        sb5.append("&storetheme=default");
                        String sb7 = sb5.toString();
                        $jacocoInit[189] = true;
                        Uri uri = Uri.parse(sb7);
                        $jacocoInit[190] = true;
                        Logger instance3 = Logger.getInstance();
                        String str5 = TAG;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(str4);
                        $jacocoInit[191] = true;
                        sb8.append(uri.toString());
                        instance3.mo2146v(str5, sb8.toString());
                        $jacocoInit[192] = true;
                        Intent dealWithAptoideSchema = dealWithAptoideSchema(uri);
                        $jacocoInit[193] = true;
                        return dealWithAptoideSchema;
                    } catch (Exception e) {
                        $jacocoInit[194] = true;
                        Logger instance4 = Logger.getInstance();
                        String str6 = TAG;
                        $jacocoInit[195] = true;
                        instance4.mo2141e(str6, "dealWithAptoideWebsite: ", e);
                        $jacocoInit[196] = true;
                        return null;
                    }
                } else {
                    $jacocoInit[197] = true;
                    $jacocoInit[223] = true;
                    return null;
                }
            }
        }
        if (u.getPath() == null) {
            $jacocoInit[198] = true;
        } else {
            String path5 = u.getPath();
            $jacocoInit[199] = true;
            if (!path5.contains(str2)) {
                $jacocoInit[200] = true;
            } else {
                $jacocoInit[201] = true;
                this.deepLinkAnalytics.websiteFromStoreWebPage();
                $jacocoInit[202] = true;
                Logger instance5 = Logger.getInstance();
                String str7 = TAG;
                StringBuilder sb9 = new StringBuilder();
                sb9.append("aptoide web site: store: ");
                $jacocoInit[203] = true;
                sb9.append(u.getLastPathSegment());
                instance5.mo2146v(str7, sb9.toString());
                $jacocoInit[204] = true;
                ArrayList<String> list = new ArrayList<>();
                $jacocoInit[205] = true;
                list.add(u.getLastPathSegment());
                $jacocoInit[206] = true;
                Intent startWithRepo = startWithRepo(list);
                $jacocoInit[207] = true;
                return startWithRepo;
            }
        }
        String host = u.getHost();
        $jacocoInit[208] = true;
        String[] appName = host.split("\\.");
        if (appName == null) {
            $jacocoInit[209] = true;
        } else if (appName.length != 4) {
            $jacocoInit[210] = true;
        } else {
            $jacocoInit[211] = true;
            this.deepLinkAnalytics.websiteFromAppViewWebPage();
            $jacocoInit[212] = true;
            Logger instance6 = Logger.getInstance();
            String str8 = TAG;
            StringBuilder sb10 = new StringBuilder();
            sb10.append("aptoide web site: app view: ");
            sb10.append(appName[0]);
            String sb11 = sb10.toString();
            $jacocoInit[213] = true;
            instance6.mo2146v(str8, sb11);
            $jacocoInit[214] = true;
            Intent startAppView = startAppView(appName[0]);
            $jacocoInit[215] = true;
            return startAppView;
        }
        if (appName == null) {
            $jacocoInit[216] = true;
        } else if (appName.length != 3) {
            $jacocoInit[217] = true;
        } else {
            $jacocoInit[218] = true;
            this.deepLinkAnalytics.websiteFromHomeWebPage();
            $jacocoInit[219] = true;
            Logger instance7 = Logger.getInstance();
            String str9 = TAG;
            StringBuilder sb12 = new StringBuilder();
            sb12.append("aptoide web site: home: ");
            sb12.append(appName[0]);
            String sb13 = sb12.toString();
            $jacocoInit[220] = true;
            instance7.mo2146v(str9, sb13);
            $jacocoInit[221] = true;
            Intent startFromHome = startFromHome();
            $jacocoInit[222] = true;
            return startFromHome;
        }
        $jacocoInit[223] = true;
        return null;
    }

    private Intent dealWithImagesApoide(String uri) {
        boolean[] $jacocoInit = $jacocoInit();
        String[] strings = uri.split("-");
        $jacocoInit[224] = true;
        long id = Long.parseLong(strings[strings.length - 1].split("\\.myapp")[0]);
        $jacocoInit[225] = true;
        Intent startFromAppView = startFromAppView(id, null, false);
        $jacocoInit[226] = true;
        return startFromAppView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent dealWithWebservicesAptoide(java.lang.String r10) {
        /*
            r9 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 227(0xe3, float:3.18E-43)
            r2 = 0
            r3 = 1
            r0[r1] = r3     // Catch:{ UnsupportedEncodingException -> 0x001b }
            r1 = r2
            java.net.URI r4 = java.net.URI.create(r10)     // Catch:{ UnsupportedEncodingException -> 0x0019 }
            java.util.Map r4 = p005cm.aptoide.p006pt.utils.AptoideUtils.StringU.splitQuery(r4)     // Catch:{ UnsupportedEncodingException -> 0x0019 }
            r1 = r4
            r4 = 228(0xe4, float:3.2E-43)
            r0[r4] = r3
            goto L_0x0030
        L_0x0019:
            r4 = move-exception
            goto L_0x001d
        L_0x001b:
            r4 = move-exception
            r1 = r2
        L_0x001d:
            r5 = 229(0xe5, float:3.21E-43)
            r0[r5] = r3
            cm.aptoide.pt.crashreports.CrashReport r5 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r6 = 230(0xe6, float:3.22E-43)
            r0[r6] = r3
            r5.log(r4)
            r5 = 231(0xe7, float:3.24E-43)
            r0[r5] = r3
        L_0x0030:
            if (r1 != 0) goto L_0x0038
            r4 = 232(0xe8, float:3.25E-43)
            r0[r4] = r3
            goto L_0x00e0
        L_0x0038:
            r4 = 0
            r5 = 233(0xe9, float:3.27E-43)
            r0[r5] = r3
            java.util.Set r5 = r1.entrySet()
            java.util.Iterator r5 = r5.iterator()
            r6 = 234(0xea, float:3.28E-43)
            r0[r6] = r3
        L_0x0049:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0084
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            r7 = 235(0xeb, float:3.3E-43)
            r0[r7] = r3
            java.lang.Object r7 = r6.getKey()
            java.lang.String r7 = (java.lang.String) r7
            r8 = 236(0xec, float:3.31E-43)
            r0[r8] = r3
            java.lang.String r8 = "uid"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0070
            r7 = 237(0xed, float:3.32E-43)
            r0[r7] = r3
            goto L_0x007f
        L_0x0070:
            r7 = 238(0xee, float:3.34E-43)
            r0[r7] = r3
            java.lang.Object r7 = r6.getValue()
            r4 = r7
            java.lang.String r4 = (java.lang.String) r4
            r7 = 239(0xef, float:3.35E-43)
            r0[r7] = r3
        L_0x007f:
            r6 = 240(0xf0, float:3.36E-43)
            r0[r6] = r3
            goto L_0x0049
        L_0x0084:
            if (r4 != 0) goto L_0x008b
            r5 = 241(0xf1, float:3.38E-43)
            r0[r5] = r3
            goto L_0x00e0
        L_0x008b:
            r5 = 242(0xf2, float:3.39E-43)
            r0[r5] = r3     // Catch:{ NumberFormatException -> 0x00a0 }
            long r5 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x00a0 }
            r7 = 243(0xf3, float:3.4E-43)
            r0[r7] = r3     // Catch:{ NumberFormatException -> 0x00a0 }
            android.content.Intent r2 = r9.startFromAppView(r5, r2, r3)     // Catch:{ NumberFormatException -> 0x00a0 }
            r7 = 244(0xf4, float:3.42E-43)
            r0[r7] = r3
            return r2
        L_0x00a0:
            r5 = move-exception
            r6 = 245(0xf5, float:3.43E-43)
            r0[r6] = r3
            cm.aptoide.pt.crashreports.CrashReport r6 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r7 = 246(0xf6, float:3.45E-43)
            r0[r7] = r3
            r6.log(r5)
            r6 = 247(0xf7, float:3.46E-43)
            r0[r6] = r3
            cm.aptoide.pt.crashreports.CrashReport r6 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r7 = 248(0xf8, float:3.48E-43)
            r0[r7] = r3
            r6.log(r5)
            r6 = 249(0xf9, float:3.49E-43)
            r0[r6] = r3
            android.content.Context r6 = r9.getApplicationContext()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r8 = 2131690427(0x7f0f03bb, float:1.9009897E38)
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            p005cm.aptoide.p006pt.utils.design.ShowMessage.asToast(r6, r7)
            r6 = 250(0xfa, float:3.5E-43)
            r0[r6] = r3
        L_0x00e0:
            r4 = 251(0xfb, float:3.52E-43)
            r0[r4] = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.DeepLinkIntentReceiver.dealWithWebservicesAptoide(java.lang.String):android.content.Intent");
    }

    private void dealWithShortcuts() {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT < 25) {
            $jacocoInit[252] = true;
        } else {
            $jacocoInit[253] = true;
            ShortcutManager shortcutManager = (ShortcutManager) getApplicationContext().getSystemService(ShortcutManager.class);
            $jacocoInit[254] = true;
            Intent fromShortcut = getIntent();
            if (fromShortcut == null) {
                $jacocoInit[255] = true;
            } else {
                $jacocoInit[256] = true;
                String str = "search";
                if (fromShortcut.hasExtra(str)) {
                    $jacocoInit[257] = true;
                    if (!fromShortcut.getBooleanExtra(str, false)) {
                        $jacocoInit[258] = true;
                    } else {
                        this.shortcutNavigation = true;
                        if (shortcutManager == null) {
                            $jacocoInit[259] = true;
                        } else {
                            $jacocoInit[260] = true;
                            shortcutManager.reportShortcutUsed(str);
                            $jacocoInit[261] = true;
                        }
                    }
                } else {
                    String str2 = "timeline";
                    if (!fromShortcut.hasExtra(str2)) {
                        $jacocoInit[262] = true;
                    } else {
                        $jacocoInit[263] = true;
                        if (!fromShortcut.getBooleanExtra(str2, false)) {
                            $jacocoInit[264] = true;
                        } else {
                            this.shortcutNavigation = true;
                            if (shortcutManager == null) {
                                $jacocoInit[265] = true;
                            } else {
                                $jacocoInit[266] = true;
                                shortcutManager.reportShortcutUsed(str2);
                                $jacocoInit[267] = true;
                            }
                        }
                    }
                }
            }
        }
        $jacocoInit[268] = true;
    }

    private Intent openUserScreen(Long userId) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[269] = true;
        intent.putExtra(DeepLinksTargets.USER_DEEPLINK, userId);
        $jacocoInit[270] = true;
        return intent;
    }

    public Intent startWithRepo(ArrayList<String> repo) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[271] = true;
        intent.putExtra(DeepLinksTargets.NEW_REPO, repo);
        $jacocoInit[272] = true;
        this.deepLinkAnalytics.newRepo();
        $jacocoInit[273] = true;
        return intent;
    }

    private void parseXmlString(String file) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            $jacocoInit[274] = true;
            SAXParser sp = spf.newSAXParser();
            $jacocoInit[275] = true;
            XMLReader xr = sp.getXMLReader();
            $jacocoInit[276] = true;
            XmlAppHandler handler = new XmlAppHandler();
            $jacocoInit[277] = true;
            xr.setContentHandler(handler);
            $jacocoInit[278] = true;
            InputSource is = new InputSource();
            $jacocoInit[279] = true;
            is.setCharacterStream(new StringReader(file));
            $jacocoInit[280] = true;
            xr.parse(is);
            $jacocoInit[281] = true;
            this.server = handler.getServers();
            $jacocoInit[282] = true;
            this.app = handler.getApp();
            $jacocoInit[283] = true;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            $jacocoInit[284] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[285] = true;
            instance.log(e);
            $jacocoInit[286] = true;
        }
        $jacocoInit[287] = true;
    }

    public Intent startWalletInstallIntent(String packageName, String utmSourceParameter, String appPackageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, WalletInstallActivity.class);
        $jacocoInit[288] = true;
        intent.putExtra(DeepLinksKeys.WALLET_PACKAGE_NAME_KEY, packageName);
        $jacocoInit[289] = true;
        intent.putExtra("packageName", appPackageName);
        $jacocoInit[290] = true;
        intent.setFlags(268435456);
        $jacocoInit[291] = true;
        return intent;
    }

    public Intent startFromPackageName(String packageName) {
        Intent intent;
        boolean[] $jacocoInit = $jacocoInit();
        GetApp app2 = null;
        if (packageName == null) {
            $jacocoInit[292] = true;
        } else {
            try {
                $jacocoInit[293] = true;
                $jacocoInit[294] = true;
                BodyInterceptor accountSettingsBodyInterceptorPoolV7 = ((AptoideApplication) getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
                $jacocoInit[295] = true;
                OkHttpClient defaultClient = ((AptoideApplication) getApplicationContext()).getDefaultClient();
                $jacocoInit[296] = true;
                Factory defaultConverter = WebService.getDefaultConverter();
                $jacocoInit[297] = true;
                TokenInvalidator tokenInvalidator = ((AptoideApplication) getApplicationContext()).getTokenInvalidator();
                $jacocoInit[298] = true;
                SharedPreferences defaultSharedPreferences = ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
                $jacocoInit[299] = true;
                GetAppRequest of = GetAppRequest.m7462of(packageName, accountSettingsBodyInterceptorPoolV7, defaultClient, defaultConverter, tokenInvalidator, defaultSharedPreferences);
                $jacocoInit[300] = true;
                C0120S observe = of.observe();
                $jacocoInit[301] = true;
                C14906b k = observe.mo3672k();
                $jacocoInit[302] = true;
                app2 = (GetApp) k.mo46110a();
                $jacocoInit[303] = true;
            } catch (NoNetworkConnectionException e) {
                $jacocoInit[304] = true;
                Intent intent2 = startFromHome();
                $jacocoInit[305] = true;
                return intent2;
            } catch (AptoideWsV7Exception e2) {
                $jacocoInit[306] = true;
                Intent intent3 = startFromSearch(packageName);
                $jacocoInit[307] = true;
                return intent3;
            }
        }
        if (app2 == null) {
            $jacocoInit[308] = true;
        } else if (!app2.isOk()) {
            $jacocoInit[309] = true;
        } else {
            $jacocoInit[310] = true;
            intent = startFromAppView(packageName);
            $jacocoInit[311] = true;
            $jacocoInit[313] = true;
            return intent;
        }
        intent = startFromSearch(packageName);
        $jacocoInit[312] = true;
        $jacocoInit[313] = true;
        return intent;
    }

    public Intent startAppView(String uname) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[314] = true;
        intent.putExtra(DeepLinksTargets.APP_VIEW_FRAGMENT, true);
        $jacocoInit[315] = true;
        intent.putExtra(DeepLinksKeys.UNAME, uname);
        $jacocoInit[316] = true;
        return intent;
    }

    public Intent startFromAppView(long id, String packageName, boolean showPopup) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[317] = true;
        intent.putExtra(DeepLinksTargets.APP_VIEW_FRAGMENT, true);
        $jacocoInit[318] = true;
        intent.putExtra("appId", id);
        $jacocoInit[319] = true;
        intent.putExtra("packageName", packageName);
        $jacocoInit[320] = true;
        intent.putExtra(DeepLinksKeys.SHOW_AUTO_INSTALL_POPUP, showPopup);
        $jacocoInit[321] = true;
        return intent;
    }

    public Intent startFromAppsTimeline(String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[322] = true;
        intent.putExtra(DeepLinksTargets.TIMELINE_DEEPLINK, true);
        $jacocoInit[323] = true;
        intent.putExtra("cardId", cardId);
        $jacocoInit[324] = true;
        boolean z = this.shortcutNavigation;
        if (!z) {
            $jacocoInit[325] = true;
        } else {
            intent.putExtra(FROM_SHORTCUT, z);
            $jacocoInit[326] = true;
        }
        $jacocoInit[327] = true;
        return intent;
    }

    public Intent startFromHome() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[328] = true;
        intent.putExtra(DeepLinksTargets.HOME_DEEPLINK, true);
        $jacocoInit[329] = true;
        return intent;
    }

    private void downloadMyApp() {
        boolean[] $jacocoInit = $jacocoInit();
        new MyAppDownloader(this).execute(new String[]{getIntent().getDataString()});
        $jacocoInit[330] = true;
    }

    private Intent parseAptoideInstallUri(String host) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideInstallParser parser = new AptoideInstallParser();
        $jacocoInit[331] = true;
        AptoideInstall aptoideInstall = parser.parse(host);
        $jacocoInit[332] = true;
        if (aptoideInstall.getAppId() > 0) {
            $jacocoInit[333] = true;
            Intent startFromAppView = startFromAppView(aptoideInstall.getAppId(), aptoideInstall.getPackageName(), false);
            $jacocoInit[334] = true;
            return startFromAppView;
        }
        String storeName = aptoideInstall.getStoreName();
        String packageName = aptoideInstall.getPackageName();
        $jacocoInit[335] = true;
        boolean shouldShowPopup = aptoideInstall.shouldShowPopup();
        $jacocoInit[336] = true;
        Intent startFromAppview = startFromAppview(storeName, packageName, shouldShowPopup);
        $jacocoInit[337] = true;
        return startFromAppview;
    }

    private Intent startGenericDeepLink(Uri parse) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[338] = true;
        intent.putExtra(DeepLinksTargets.GENERIC_DEEPLINK, true);
        $jacocoInit[339] = true;
        intent.putExtra(DeepLinksKeys.URI, parse);
        $jacocoInit[340] = true;
        return intent;
    }

    private Intent startAppcInfoView() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[341] = true;
        intent.putExtra(DeepLinksTargets.APPC_INFO_VIEW, true);
        $jacocoInit[342] = true;
        return intent;
    }

    public Intent startFromAppView(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[343] = true;
        intent.putExtra(DeepLinksTargets.APP_VIEW_FRAGMENT, true);
        $jacocoInit[344] = true;
        intent.putExtra("packageName", packageName);
        $jacocoInit[345] = true;
        return intent;
    }

    public Intent startFromSearch(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[346] = true;
        intent.putExtra(DeepLinksTargets.SEARCH_FRAGMENT, true);
        $jacocoInit[347] = true;
        intent.putExtra("query", query);
        $jacocoInit[348] = true;
        intent.putExtra(FROM_SHORTCUT, this.shortcutNavigation);
        $jacocoInit[349] = true;
        return intent;
    }

    private Intent startFromAppview(String repo, String packageName, boolean showPopup) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[350] = true;
        intent.putExtra(DeepLinksTargets.APP_VIEW_FRAGMENT, true);
        $jacocoInit[351] = true;
        intent.putExtra("packageName", packageName);
        $jacocoInit[352] = true;
        intent.putExtra("storeName", repo);
        $jacocoInit[353] = true;
        intent.putExtra(DeepLinksKeys.SHOW_AUTO_INSTALL_POPUP, showPopup);
        $jacocoInit[354] = true;
        return intent;
    }

    private Intent startFromMyStore() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[355] = true;
        intent.putExtra(DeepLinksTargets.MY_STORE_DEEPLINK, true);
        $jacocoInit[356] = true;
        return intent;
    }

    private Intent startFromPickApp() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[357] = true;
        intent.putExtra(DeepLinksTargets.PICK_APP_DEEPLINK, true);
        $jacocoInit[358] = true;
        return intent;
    }

    private Intent startFromPromotions() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[359] = true;
        intent.putExtra(DeepLinksTargets.PROMOTIONS_DEEPLINK, true);
        $jacocoInit[360] = true;
        return intent;
    }

    private Intent startFromEditorialCard(String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, this.startClass);
        $jacocoInit[361] = true;
        intent.putExtra(DeepLinksTargets.EDITORIAL_DEEPLINK, true);
        $jacocoInit[362] = true;
        intent.putExtra("cardId", cardId);
        $jacocoInit[363] = true;
        return intent;
    }

    private void downloadMyAppFile(String myappUri) throws Exception {
        URLConnection connection;
        boolean[] $jacocoInit = $jacocoInit();
        try {
            URL url = new URL(myappUri);
            $jacocoInit[364] = true;
            if (!myappUri.startsWith("file://")) {
                $jacocoInit[365] = true;
                connection = url.openConnection();
                $jacocoInit[366] = true;
                connection.setReadTimeout(5000);
                $jacocoInit[367] = true;
                connection.setConnectTimeout(5000);
                $jacocoInit[368] = true;
            } else {
                connection = url.openConnection();
                $jacocoInit[369] = true;
            }
            BufferedInputStream getit = new BufferedInputStream(connection.getInputStream(), Opcodes.ACC_ABSTRACT);
            $jacocoInit[370] = true;
            File file_teste = new File(this.TMP_MYAPP_FILE);
            $jacocoInit[371] = true;
            if (!file_teste.exists()) {
                $jacocoInit[372] = true;
            } else {
                $jacocoInit[373] = true;
                file_teste.delete();
                $jacocoInit[374] = true;
            }
            FileOutputStream saveit = new FileOutputStream(this.TMP_MYAPP_FILE);
            $jacocoInit[375] = true;
            BufferedOutputStream bout = new BufferedOutputStream(saveit, Opcodes.ACC_ABSTRACT);
            byte[] data = new byte[Opcodes.ACC_ABSTRACT];
            $jacocoInit[376] = true;
            int readed = getit.read(data, 0, Opcodes.ACC_ABSTRACT);
            $jacocoInit[377] = true;
            while (readed != -1) {
                $jacocoInit[378] = true;
                bout.write(data, 0, readed);
                $jacocoInit[379] = true;
                readed = getit.read(data, 0, Opcodes.ACC_ABSTRACT);
                $jacocoInit[380] = true;
            }
            bout.close();
            $jacocoInit[381] = true;
            getit.close();
            $jacocoInit[382] = true;
            saveit.close();
            $jacocoInit[383] = true;
        } catch (Exception e) {
            $jacocoInit[384] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[385] = true;
            instance.log(e);
            $jacocoInit[386] = true;
        }
        $jacocoInit[387] = true;
    }

    private void parseXmlMyapp(String file) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            $jacocoInit[388] = true;
            SAXParser sp = spf.newSAXParser();
            $jacocoInit[389] = true;
            XmlAppHandler handler = new XmlAppHandler();
            $jacocoInit[390] = true;
            sp.parse(new File(file), handler);
            $jacocoInit[391] = true;
            this.server = handler.getServers();
            $jacocoInit[392] = true;
            this.app = handler.getApp();
            $jacocoInit[393] = true;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            $jacocoInit[394] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[395] = true;
            instance.log(e);
            $jacocoInit[396] = true;
        }
        $jacocoInit[397] = true;
    }

    private void proceed() {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<String> arrayList = this.server;
        if (arrayList != null) {
            $jacocoInit[398] = true;
            startWithRepo(StoreUtils.split((List<String>) arrayList));
            $jacocoInit[399] = true;
        } else {
            ShowMessage.asToast((Context) this, getString(C1375R.string.error_occured));
            $jacocoInit[400] = true;
            finish();
            $jacocoInit[401] = true;
        }
        $jacocoInit[402] = true;
    }
}
