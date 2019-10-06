package p005cm.aptoide.p006pt.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.RegisterAdRefererRequest;
import p005cm.aptoide.p006pt.dataprovider.util.referrer.SimpleTimedFuture;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ThreadU;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.util.ReferrerUtils */
public class ReferrerUtils extends p005cm.aptoide.p006pt.dataprovider.util.referrer.ReferrerUtils {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = ReferrerUtils.class.getSimpleName();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6455940696027715051L, "cm/aptoide/pt/util/ReferrerUtils", 58);
        $jacocoData = probes;
        return probes;
    }

    public ReferrerUtils() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ String access$000(String x0) {
        boolean[] $jacocoInit = $jacocoInit();
        String referrer = getReferrer(x0);
        $jacocoInit[54] = true;
        return referrer;
    }

    static /* synthetic */ ScheduledExecutorService access$100() {
        boolean[] $jacocoInit = $jacocoInit();
        ScheduledExecutorService scheduledExecutorService = p005cm.aptoide.p006pt.dataprovider.util.referrer.ReferrerUtils.executorService;
        $jacocoInit[55] = true;
        return scheduledExecutorService;
    }

    static /* synthetic */ List access$200(String x0) {
        boolean[] $jacocoInit = $jacocoInit();
        List clearExcludedNetworks = clearExcludedNetworks(x0);
        $jacocoInit[56] = true;
        return clearExcludedNetworks;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[57] = true;
    }

    public static void extractReferrer(SearchAdResult searchAdResult, int retries, boolean broadcastReferrer, AdsRepository adsRepository, OkHttpClient httpClient, Factory converterFactory, QManager qManager, Context context, SharedPreferences sharedPreferences, MinimalAdMapper adMapper) {
        boolean z;
        Context context2 = context;
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = searchAdResult.getPackageName();
        $jacocoInit[1] = true;
        long networkId = searchAdResult.getNetworkId();
        $jacocoInit[2] = true;
        String clickUrl = searchAdResult.getClickUrl();
        String str = "ExtractReferrer";
        if (clickUrl == null) {
            $jacocoInit[3] = true;
            Logger instance = Logger.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("No click_url for packageName ");
            sb.append(packageName);
            String sb2 = sb.toString();
            $jacocoInit[4] = true;
            instance.mo2136d(str, sb2);
            $jacocoInit[5] = true;
        } else if (ThreadU.isUiThread()) {
            $jacocoInit[6] = true;
            try {
                Logger instance2 = Logger.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Called for: ");
                sb3.append(clickUrl);
                sb3.append(" with packageName ");
                sb3.append(packageName);
                String sb4 = sb3.toString();
                $jacocoInit[9] = true;
                instance2.mo2136d(str, sb4);
                String[] internalClickUrl = {clickUrl};
                $jacocoInit[10] = true;
                SimpleTimedFuture simpleTimedFuture = new SimpleTimedFuture();
                $jacocoInit[11] = true;
                WindowManager windowManager = (WindowManager) context2.getSystemService("window");
                $jacocoInit[12] = true;
                WindowManager windowManager2 = windowManager;
                LayoutParams layoutParams = new LayoutParams(-2, -2, 2006, 16, -3);
                LayoutParams params = layoutParams;
                params.gravity = 51;
                params.x = 0;
                params.y = 0;
                params.width = 0;
                params.height = 0;
                $jacocoInit[13] = true;
                LinearLayout linearLayout = new LinearLayout(context2);
                $jacocoInit[14] = true;
                LinearLayout view = linearLayout;
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                $jacocoInit[15] = true;
                ThreadU.runOnIoThread(new C5167f(context2, internalClickUrl, clickUrl, simpleTimedFuture));
                $jacocoInit[16] = true;
                simpleTimedFuture.get();
                $jacocoInit[17] = true;
                WebView webView = new WebView(context2);
                $jacocoInit[18] = true;
                WebView wv = webView;
                wv.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                $jacocoInit[19] = true;
                view.addView(wv);
                $jacocoInit[20] = true;
                WebSettings settings = wv.getSettings();
                $jacocoInit[21] = true;
                settings.setJavaScriptEnabled(true);
                $jacocoInit[22] = true;
                r1 = r1;
                final boolean z2 = broadcastReferrer;
                final String str2 = packageName;
                final Context context3 = context;
                C51581 r15 = r1;
                final MinimalAdMapper minimalAdMapper = adMapper;
                String[] internalClickUrl2 = internalClickUrl;
                WebView wv2 = wv;
                final SearchAdResult searchAdResult2 = searchAdResult;
                LinearLayout view2 = view;
                final OkHttpClient okHttpClient = httpClient;
                LayoutParams params2 = params;
                final Factory factory = converterFactory;
                WindowManager windowManager3 = windowManager2;
                final QManager qManager2 = qManager;
                SimpleTimedFuture simpleTimedFuture2 = simpleTimedFuture;
                final int i = retries;
                final SharedPreferences sharedPreferences2 = sharedPreferences;
                String str3 = clickUrl;
                z = true;
                final long j = networkId;
                String str4 = packageName;
                final AdsRepository adsRepository2 = adsRepository;
                try {
                    C51581 r1 = new WebViewClient() {
                        private static transient /* synthetic */ boolean[] $jacocoData;
                        Future<Void> future;

                        private static /* synthetic */ boolean[] $jacocoInit() {
                            boolean[] zArr = $jacocoData;
                            if (zArr != null) {
                                return zArr;
                            }
                            boolean[] probes = Offline.getProbes(-3089208724028339392L, "cm/aptoide/pt/util/ReferrerUtils$1", 69);
                            $jacocoData = probes;
                            return probes;
                        }

                        {
                            boolean[] $jacocoInit = $jacocoInit();
                            $jacocoInit[0] = true;
                        }

                        public boolean shouldOverrideUrlLoading(WebView view, String clickUrl) {
                            boolean[] $jacocoInit = $jacocoInit();
                            Logger instance = Logger.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ClickUrl redirect: ");
                            sb.append(clickUrl);
                            String sb2 = sb.toString();
                            $jacocoInit[1] = true;
                            String str = "ExtractReferrer";
                            instance.mo2136d(str, sb2);
                            $jacocoInit[2] = true;
                            if (clickUrl.startsWith("market://")) {
                                $jacocoInit[3] = true;
                            } else {
                                $jacocoInit[4] = true;
                                if (clickUrl.startsWith("https://play.google.com")) {
                                    $jacocoInit[5] = true;
                                } else {
                                    $jacocoInit[6] = true;
                                    if (!clickUrl.startsWith("http://play.google.com")) {
                                        $jacocoInit[7] = true;
                                        $jacocoInit[24] = true;
                                        return false;
                                    }
                                    $jacocoInit[8] = true;
                                }
                            }
                            Logger instance2 = Logger.getInstance();
                            $jacocoInit[9] = true;
                            instance2.mo2136d(str, "Clickurl landed on market");
                            $jacocoInit[10] = true;
                            String referrer = ReferrerUtils.access$000(clickUrl);
                            $jacocoInit[11] = true;
                            if (TextUtils.isEmpty(referrer)) {
                                $jacocoInit[12] = true;
                            } else {
                                $jacocoInit[13] = true;
                                Logger instance3 = Logger.getInstance();
                                $jacocoInit[14] = true;
                                instance3.mo2136d(str, "Referrer successfully extracted");
                                if (z2) {
                                    $jacocoInit[15] = true;
                                    ReferrerUtils.broadcastReferrer(str2, referrer, context3);
                                    $jacocoInit[16] = true;
                                } else {
                                    Context context = context3;
                                    $jacocoInit[17] = true;
                                    Context applicationContext = context.getApplicationContext();
                                    $jacocoInit[18] = true;
                                    $jacocoInit[19] = true;
                                    StoredMinimalAdAccessor storedMinimalAdAccessor = (StoredMinimalAdAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), StoredMinimalAd.class);
                                    $jacocoInit[20] = true;
                                    storedMinimalAdAccessor.insert(minimalAdMapper.map(searchAdResult2, referrer));
                                    $jacocoInit[21] = true;
                                }
                                this.future.cancel(false);
                                $jacocoInit[22] = true;
                                postponeReferrerExtraction(searchAdResult2, 0, true, okHttpClient, factory, qManager2);
                                $jacocoInit[23] = true;
                            }
                            $jacocoInit[24] = true;
                            return false;
                        }

                        public void onPageStarted(WebView view, String url, Bitmap favicon) {
                            boolean[] $jacocoInit = $jacocoInit();
                            super.onPageStarted(view, url, favicon);
                            $jacocoInit[25] = true;
                            Logger instance = Logger.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Openened clickUrl: ");
                            sb.append(url);
                            String sb2 = sb.toString();
                            $jacocoInit[26] = true;
                            instance.mo2136d("ExtractReferrer", sb2);
                            if (this.future != null) {
                                $jacocoInit[27] = true;
                            } else {
                                $jacocoInit[28] = true;
                                this.future = postponeReferrerExtraction(searchAdResult2, 5, i, okHttpClient, factory, qManager2);
                                $jacocoInit[29] = true;
                            }
                            $jacocoInit[30] = true;
                        }

                        private ScheduledFuture<Void> postponeReferrerExtraction(SearchAdResult searchAdResult, int delay, int retries, OkHttpClient httpClient, Factory converterFactory, QManager qManager) {
                            boolean[] $jacocoInit = $jacocoInit();
                            SharedPreferences sharedPreferences = sharedPreferences2;
                            $jacocoInit[31] = true;
                            String filters = qManager.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences));
                            $jacocoInit[32] = true;
                            ScheduledFuture<Void> postponeReferrerExtraction = postponeReferrerExtraction(searchAdResult, delay, false, retries, httpClient, converterFactory, filters, qManager);
                            $jacocoInit[33] = true;
                            return postponeReferrerExtraction;
                        }

                        private ScheduledFuture<Void> postponeReferrerExtraction(SearchAdResult searchAdResult, int delta, boolean success, OkHttpClient httpClient, Factory converterFactory, QManager qManager) {
                            boolean[] $jacocoInit = $jacocoInit();
                            SharedPreferences sharedPreferences = sharedPreferences2;
                            $jacocoInit[34] = true;
                            String filters = qManager.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences));
                            $jacocoInit[35] = true;
                            ScheduledFuture<Void> postponeReferrerExtraction = postponeReferrerExtraction(searchAdResult, delta, success, 0, httpClient, converterFactory, filters, qManager);
                            $jacocoInit[36] = true;
                            return postponeReferrerExtraction;
                        }

                        private ScheduledFuture<Void> postponeReferrerExtraction(SearchAdResult searchAdResult, int delay, boolean success, int retries, OkHttpClient httpClient, Factory converterFactory, String q, QManager qManager) {
                            int i = delay;
                            boolean[] $jacocoInit = $jacocoInit();
                            Logger instance = Logger.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Referrer postponed ");
                            sb.append(i);
                            sb.append(" seconds.");
                            String sb2 = sb.toString();
                            $jacocoInit[37] = true;
                            instance.mo2136d("ExtractReferrer", sb2);
                            $jacocoInit[38] = true;
                            SharedPreferences sharedPreferences = sharedPreferences2;
                            String str = str2;
                            long j = j;
                            AdsRepository adsRepository = adsRepository2;
                            boolean z = z2;
                            C5162a aVar = r6;
                            boolean z2 = z;
                            AdsRepository adsRepository2 = adsRepository;
                            C5162a aVar2 = new C5162a(success, searchAdResult, httpClient, converterFactory, qManager, sharedPreferences, retries, str, j, adsRepository2, z2, context3);
                            $jacocoInit[39] = true;
                            ScheduledFuture<Void> schedule = ReferrerUtils.access$100().schedule(aVar, (long) i, TimeUnit.SECONDS);
                            $jacocoInit[40] = true;
                            return schedule;
                        }

                        /* renamed from: a */
                        static /* synthetic */ Void m9445a(boolean success, SearchAdResult searchAdResult, OkHttpClient httpClient, Factory converterFactory, QManager qManager, SharedPreferences sharedPreferences, int retries, String packageName, long networkId, AdsRepository adsRepository, boolean broadcastReferrer, Context context) throws Exception {
                            boolean z = success;
                            int i = retries;
                            String str = packageName;
                            boolean[] $jacocoInit = $jacocoInit();
                            Logger instance = Logger.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Sending RegisterAdRefererRequest with value ");
                            sb.append(z);
                            String sb2 = sb.toString();
                            $jacocoInit[41] = true;
                            String str2 = "ExtractReferrer";
                            instance.mo2136d(str2, sb2);
                            $jacocoInit[42] = true;
                            long adId = searchAdResult.getAdId();
                            long appId = searchAdResult.getAppId();
                            $jacocoInit[43] = true;
                            String clickUrl = searchAdResult.getClickUrl();
                            $jacocoInit[44] = true;
                            String filters = qManager.getFilters(ManagerPreferences.getHWSpecsFilter(sharedPreferences));
                            $jacocoInit[45] = true;
                            String str3 = filters;
                            String str4 = str2;
                            RegisterAdRefererRequest of = RegisterAdRefererRequest.m7441of(adId, appId, clickUrl, success, httpClient, converterFactory, str3, sharedPreferences);
                            $jacocoInit[46] = true;
                            of.execute();
                            $jacocoInit[47] = true;
                            Logger instance2 = Logger.getInstance();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Retries left: ");
                            sb3.append(i);
                            String sb4 = sb3.toString();
                            $jacocoInit[48] = true;
                            instance2.mo2136d(str4, sb4);
                            if (!z) {
                                $jacocoInit[49] = true;
                                p005cm.aptoide.p006pt.dataprovider.util.referrer.ReferrerUtils.excludedNetworks.add(str, networkId);
                                try {
                                    $jacocoInit[50] = true;
                                    if (i > 0) {
                                        $jacocoInit[51] = true;
                                        C0120S adsFromSecondTry = adsRepository.getAdsFromSecondTry(str);
                                        $jacocoInit[52] = true;
                                        C0120S a = adsFromSecondTry.mo3616a(C14522a.m46170a());
                                        C5164c cVar = C5164c.f8912a;
                                        $jacocoInit[53] = true;
                                        C0120S l = a.mo3674l(cVar);
                                        C5165d dVar = new C5165d(searchAdResult);
                                        $jacocoInit[54] = true;
                                        C0120S d = l.mo3653d((C0132p<? super T, Boolean>) dVar);
                                        C5166e eVar = r1;
                                        C5166e eVar2 = new C5166e(retries, broadcastReferrer, adsRepository, httpClient, converterFactory, qManager, context, sharedPreferences);
                                        C5163b bVar = new C5163b(str);
                                        $jacocoInit[55] = true;
                                        d.mo3626a((C0129b<? super T>) eVar, (C0129b<Throwable>) bVar);
                                        $jacocoInit[56] = true;
                                    } else {
                                        ReferrerUtils.access$200(packageName);
                                        $jacocoInit[57] = true;
                                    }
                                    $jacocoInit[58] = true;
                                } catch (Exception e) {
                                    $jacocoInit[59] = true;
                                    e.printStackTrace();
                                    $jacocoInit[60] = true;
                                }
                            } else {
                                ReferrerUtils.access$200(packageName);
                                $jacocoInit[61] = true;
                            }
                            $jacocoInit[62] = true;
                            return null;
                        }

                        /* renamed from: a */
                        static /* synthetic */ MinimalAd m9443a(Throwable throwable) {
                            $jacocoInit()[68] = true;
                            return null;
                        }

                        /* renamed from: a */
                        static /* synthetic */ Boolean m9444a(SearchAdResult searchAdResult, MinimalAd minimalAd1) {
                            boolean z;
                            boolean[] $jacocoInit = $jacocoInit();
                            if (searchAdResult != null) {
                                $jacocoInit[65] = true;
                                z = true;
                            } else {
                                z = false;
                                $jacocoInit[66] = true;
                            }
                            Boolean valueOf = Boolean.valueOf(z);
                            $jacocoInit[67] = true;
                            return valueOf;
                        }

                        /* renamed from: a */
                        static /* synthetic */ void m9446a(int retries, boolean broadcastReferrer, AdsRepository adsRepository, OkHttpClient httpClient, Factory converterFactory, QManager qManager, Context context, SharedPreferences sharedPreferences, MinimalAd minimalAd1) {
                            boolean[] $jacocoInit = $jacocoInit();
                            ReferrerUtils.extractReferrer(new SearchAdResult(minimalAd1), retries - 1, broadcastReferrer, adsRepository, httpClient, converterFactory, qManager, context, sharedPreferences, new MinimalAdMapper());
                            $jacocoInit[64] = true;
                        }

                        /* renamed from: a */
                        static /* synthetic */ void m9447a(String packageName, Throwable throwable) {
                            boolean[] $jacocoInit = $jacocoInit();
                            ReferrerUtils.access$200(packageName);
                            $jacocoInit[63] = true;
                        }
                    };
                    wv2.setWebViewClient(r15);
                    $jacocoInit[23] = true;
                    wv2.loadUrl(internalClickUrl2[0]);
                    $jacocoInit[24] = true;
                    windowManager3.addView(view2, params2);
                    $jacocoInit[25] = true;
                } catch (Exception e) {
                    e = e;
                    $jacocoInit[26] = z;
                    CrashReport instance3 = CrashReport.getInstance();
                    $jacocoInit[27] = z;
                    instance3.log(e);
                    $jacocoInit[28] = z;
                    $jacocoInit[29] = z;
                }
            } catch (Exception e2) {
                e = e2;
                String str5 = clickUrl;
                String str6 = packageName;
                z = true;
                $jacocoInit[26] = z;
                CrashReport instance32 = CrashReport.getInstance();
                $jacocoInit[27] = z;
                instance32.log(e);
                $jacocoInit[28] = z;
                $jacocoInit[29] = z;
            }
            $jacocoInit[29] = z;
        } else {
            String str7 = packageName;
            $jacocoInit[7] = true;
            RuntimeException runtimeException = new RuntimeException("ExtractReferrer must be run on UI thread!");
            $jacocoInit[8] = true;
            throw runtimeException;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m9442a(Context context, String[] internalClickUrl, String clickUrl, SimpleTimedFuture clickUrlFuture) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[46] = true;
        IdsRepository idsRepository = ((AptoideApplication) context.getApplicationContext()).getIdsRepository();
        $jacocoInit[47] = true;
        String androidId = idsRepository.getAndroidId();
        $jacocoInit[48] = true;
        String uniqueIdentifier = idsRepository.getUniqueIdentifier();
        String advertisingId = idsRepository.getAdvertisingId();
        $jacocoInit[49] = true;
        internalClickUrl[0] = AdNetworkUtils.parseMacros(clickUrl, androidId, uniqueIdentifier, advertisingId);
        $jacocoInit[50] = true;
        clickUrlFuture.set(internalClickUrl[0]);
        $jacocoInit[51] = true;
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Parsed clickUrl: ");
        sb.append(internalClickUrl[0]);
        String sb2 = sb.toString();
        $jacocoInit[52] = true;
        instance.mo2136d("ExtractReferrer", sb2);
        $jacocoInit[53] = true;
    }

    private static List<Long> clearExcludedNetworks(String packageName) {
        List<Long> list = (List) p005cm.aptoide.p006pt.dataprovider.util.referrer.ReferrerUtils.excludedNetworks.remove(packageName);
        $jacocoInit()[30] = true;
        return list;
    }

    private static String getReferrer(String uriAsString) {
        boolean[] $jacocoInit = $jacocoInit();
        Uri uri = Uri.parse(uriAsString);
        $jacocoInit[31] = true;
        String referrer = uri.getQueryParameter(StoredMinimalAd.REFERRER);
        $jacocoInit[32] = true;
        if (!TextUtils.isEmpty(referrer)) {
            $jacocoInit[33] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Found referrer: ");
            sb.append(referrer);
            String sb2 = sb.toString();
            $jacocoInit[34] = true;
            instance.mo2146v(str, sb2);
            $jacocoInit[35] = true;
        } else {
            Logger instance2 = Logger.getInstance();
            String str2 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Didn't find any referrer: ");
            sb3.append(uriAsString);
            String sb4 = sb3.toString();
            $jacocoInit[36] = true;
            instance2.mo2146v(str2, sb4);
            $jacocoInit[37] = true;
        }
        $jacocoInit[38] = true;
        return referrer;
    }

    public static void broadcastReferrer(String packageName, String referrer, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent i = new Intent("com.android.vending.INSTALL_REFERRER");
        $jacocoInit[39] = true;
        i.setPackage(packageName);
        $jacocoInit[40] = true;
        i.setFlags(32);
        $jacocoInit[41] = true;
        i.putExtra(StoredMinimalAd.REFERRER, referrer);
        $jacocoInit[42] = true;
        context.sendBroadcast(i);
        $jacocoInit[43] = true;
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Sent broadcast to ");
        sb.append(packageName);
        sb.append(" with referrer ");
        sb.append(referrer);
        String sb2 = sb.toString();
        $jacocoInit[44] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[45] = true;
    }
}
