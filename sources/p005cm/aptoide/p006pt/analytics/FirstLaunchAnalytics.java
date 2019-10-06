package p005cm.aptoide.p006pt.analytics;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.C6787r;
import com.facebook.C6817z;
import com.facebook.GraphRequest.C6545b;
import com.facebook.p127a.C6638q;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafetyNetApi.HarmfulAppsResponse;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferences;
import p019d.p020e.p021a.C7294e;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.analytics.FirstLaunchAnalytics */
public class FirstLaunchAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String CATEGORY = "category";
    private static final String CONTEXT = "APPLICATION";
    private static final String ENTRY_POINT = "Entry Point";
    public static final String FIRST_LAUNCH = "Aptoide_First_Launch";
    public static final String FIRST_LAUNCH_BI = "FIRST_LAUNCH";
    private static final String FLAGGED = "flagged";
    private static final String GMS = "GMS";
    private static final String HAS_HGMS = "Has GMS";
    private static final String IS_ACTIVE = "is_active";
    private static final String NO_GMS = "No GMS";
    public static final String PLAY_PROTECT_EVENT = "Google_Play_Protect";
    private static final String TAG = FirstLaunchAnalytics.class.getSimpleName();
    private static final String UNKNOWN = "unknown";
    private static final String UTM_CAMPAIGN = "UTM Campaign";
    private static final String UTM_CONTENT = "UTM Content";
    private static final String UTM_MEDIUM = "UTM Medium";
    private static final String UTM_SOURCE = "UTM Source";
    private final AnalyticsManager analyticsManager;
    private String entryPoint;
    private final AnalyticsLogger logger;
    private final String packageName;
    private SafetyNetClient safetyNetClient;
    private String utmCampaign;
    private String utmContent;
    private String utmMedium;
    private String utmSource;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5091435828743898893L, "cm/aptoide/pt/analytics/FirstLaunchAnalytics", Opcodes.F2D);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[140] = true;
    }

    public FirstLaunchAnalytics(AnalyticsManager analyticsManager2, AnalyticsLogger logger2, SafetyNetClient safetyNetClient2, String packageName2) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = UNKNOWN;
        this.utmSource = str;
        this.utmMedium = str;
        this.utmCampaign = str;
        this.utmContent = str;
        this.entryPoint = str;
        this.analyticsManager = analyticsManager2;
        this.logger = logger2;
        this.safetyNetClient = safetyNetClient2;
        this.packageName = packageName2;
        $jacocoInit[0] = true;
    }

    private void sendFirstLaunchEvent(String utmSource2, String utmMedium2, String utmCampaign2, String utmContent2, String entryPoint2) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        $jacocoInit[1] = true;
        Map createFacebookFirstLaunchDataMap = createFacebookFirstLaunchDataMap(utmSource2, utmMedium2, utmCampaign2, utmContent2, entryPoint2);
        Action action = Action.OPEN;
        $jacocoInit[2] = true;
        String str = CONTEXT;
        analyticsManager2.logEvent(createFacebookFirstLaunchDataMap, FIRST_LAUNCH, action, str);
        AnalyticsManager analyticsManager3 = this.analyticsManager;
        $jacocoInit[3] = true;
        Map createFacebookFirstLaunchDataMap2 = createFacebookFirstLaunchDataMap(utmSource2, utmMedium2, utmCampaign2, utmContent2, entryPoint2);
        Action action2 = Action.OPEN;
        $jacocoInit[4] = true;
        analyticsManager3.logEvent(createFacebookFirstLaunchDataMap2, FIRST_LAUNCH_BI, action2, str);
        $jacocoInit[5] = true;
    }

    private void sendPlayProtectEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Task h = this.safetyNetClient.mo33126h();
        C1690f fVar = new C1690f(this);
        $jacocoInit[6] = true;
        h.mo33173a((OnCompleteListener<TResult>) fVar);
        $jacocoInit[7] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo801a(Task task) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        boolean isActive = false;
        boolean isFlagged = false;
        String category = null;
        $jacocoInit[125] = true;
        if (!task.mo33179d()) {
            $jacocoInit[126] = true;
        } else {
            isActive = true;
            isFlagged = false;
            $jacocoInit[127] = true;
            HarmfulAppsResponse result = (HarmfulAppsResponse) task.mo33177b();
            $jacocoInit[128] = true;
            category = getCategoryFlaggedByPlayProtect(result.mo33125c());
            if (category == null) {
                $jacocoInit[129] = true;
            } else {
                isFlagged = true;
                $jacocoInit[130] = true;
            }
        }
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[131] = true;
        String str2 = "true";
        String str3 = AdultContentAnalytics.UNLOCK;
        if (isActive) {
            $jacocoInit[132] = true;
            str = str2;
        } else {
            $jacocoInit[133] = true;
            str = str3;
        }
        data.put(IS_ACTIVE, str);
        $jacocoInit[134] = true;
        if (isFlagged) {
            $jacocoInit[135] = true;
        } else {
            $jacocoInit[136] = true;
            str2 = str3;
        }
        data.put(FLAGGED, str2);
        $jacocoInit[137] = true;
        data.put(CATEGORY, category);
        $jacocoInit[138] = true;
        this.analyticsManager.logEvent(data, PLAY_PROTECT_EVENT, Action.OPEN, CONTEXT);
        $jacocoInit[139] = true;
    }

    private String getCategoryFlaggedByPlayProtect(List<HarmfulAppsData> list) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[8] = true;
        for (HarmfulAppsData app : list) {
            $jacocoInit[9] = true;
            if (app.f30555a.equals(this.packageName)) {
                $jacocoInit[10] = true;
                String playProtectCategoryName = getPlayProtectCategoryName(app.f30557c);
                $jacocoInit[11] = true;
                return playProtectCategoryName;
            }
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
        return null;
    }

    private String getPlayProtectCategoryName(int apkCategory) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (apkCategory) {
            case 1:
                $jacocoInit[25] = true;
                return "RANSOMWARE";
            case 2:
                $jacocoInit[23] = true;
                return "PHISHING";
            case 3:
                $jacocoInit[31] = true;
                return "TROJAN";
            case 4:
                $jacocoInit[32] = true;
                return "UNCOMMON";
            case 5:
                $jacocoInit[18] = true;
                return "FRAUDWARE";
            case 6:
                $jacocoInit[29] = true;
                return "TOLL_FRAUD";
            case 7:
                $jacocoInit[33] = true;
                return "WAP_FRAUD";
            case 8:
                $jacocoInit[15] = true;
                return "CALL_FRAUD";
            case 9:
                $jacocoInit[14] = true;
                return "BACKDOOR";
            case 10:
                $jacocoInit[27] = true;
                return "SPYWARE";
            case 11:
                $jacocoInit[19] = true;
                return "GENERIC_MALWARE";
            case 12:
                $jacocoInit[20] = true;
                return "HARMFUL_SITE";
            case 13:
                $jacocoInit[34] = true;
                return "WINDOWS_MALWARE";
            case 14:
                $jacocoInit[21] = true;
                return "HOSTILE_DOWNLOADER";
            case 15:
                $jacocoInit[22] = true;
                return "NON_ANDROID_THREAT";
            case 16:
                $jacocoInit[26] = true;
                return "ROOTING";
            case 17:
                $jacocoInit[24] = true;
                return "PRIVILEGE_ESCALATION";
            case 18:
                $jacocoInit[30] = true;
                return "TRACKING";
            case 19:
                $jacocoInit[28] = true;
                return "SPAM";
            case 20:
                $jacocoInit[17] = true;
                return "DENIAL_OF_SERVICE";
            case 21:
                $jacocoInit[16] = true;
                return "DATA_COLLECTION";
            default:
                $jacocoInit[35] = true;
                return "UNKNOWN_CATEGORY";
        }
    }

    private Map<String, Object> createFacebookFirstLaunchDataMap(String utmSource2, String utmMedium2, String utmCampaign2, String utmContent2, String entryPoint2) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[36] = true;
        data.put(UTM_SOURCE, utmSource2);
        $jacocoInit[37] = true;
        data.put(UTM_MEDIUM, utmMedium2);
        $jacocoInit[38] = true;
        data.put(UTM_CAMPAIGN, utmCampaign2);
        $jacocoInit[39] = true;
        data.put(UTM_CONTENT, utmContent2);
        $jacocoInit[40] = true;
        data.put(ENTRY_POINT, entryPoint2);
        $jacocoInit[41] = true;
        return data;
    }

    public C0117M sendAppStart(Application application, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        C6787r.m13813c(application);
        $jacocoInit[42] = true;
        C6638q.m13214a(application);
        $jacocoInit[43] = true;
        C6638q.m13220b((Context) application);
        $jacocoInit[44] = true;
        C0120S a = C0120S.m633a((Callable<? extends T>) new C1687c<Object>(application));
        C1689e eVar = new C1689e(this);
        $jacocoInit[45] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) eVar);
        C1688d dVar = new C1688d(this, application);
        $jacocoInit[46] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) dVar);
        C1678a aVar = new C1678a(sharedPreferences);
        $jacocoInit[47] = true;
        C0120S d = b2.mo3653d((C0132p<? super T, Boolean>) aVar);
        C1692h hVar = new C1692h(this);
        $jacocoInit[48] = true;
        C0120S b3 = d.mo3636b((C0129b<? super T>) hVar);
        $jacocoInit[49] = true;
        C0117M l = b3.mo3673l();
        $jacocoInit[50] = true;
        C0117M b4 = l.mo3593b(Schedulers.m776io());
        $jacocoInit[51] = true;
        return b4;
    }

    /* renamed from: a */
    static /* synthetic */ Object m145a(Application application) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository = ((AptoideApplication) application).getIdsRepository();
        $jacocoInit[122] = true;
        String uniqueIdentifier = idsRepository.getUniqueIdentifier();
        $jacocoInit[123] = true;
        C6638q.m13223c(uniqueIdentifier);
        $jacocoInit[124] = true;
        return null;
    }

    /* renamed from: a */
    public /* synthetic */ void mo802a(Object __) {
        boolean[] $jacocoInit = $jacocoInit();
        sendPlayProtectEvent();
        $jacocoInit[121] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo799a(Application application, Object __) {
        boolean[] $jacocoInit = $jacocoInit();
        setupDimensions(application);
        $jacocoInit[120] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m144a(SharedPreferences sharedPreferences, Object firstRun) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(SecurePreferences.isFirstRun(sharedPreferences));
        $jacocoInit[119] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo804b(Object __) {
        boolean[] $jacocoInit = $jacocoInit();
        sendFirstLaunchEvent(this.utmSource, this.utmMedium, this.utmCampaign, this.utmContent, this.entryPoint);
        $jacocoInit[118] = true;
    }

    private void setupDimensions(Application application) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!checkForUTMFileInMetaINF(application)) {
            $jacocoInit[52] = true;
            setUTMDimensionsToUnknown();
            $jacocoInit[53] = true;
        } else {
            setUserProperties(this.utmSource, this.utmMedium, this.utmCampaign, this.utmContent, this.entryPoint);
            $jacocoInit[54] = true;
        }
        $jacocoInit[55] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkForUTMFileInMetaINF(android.app.Application r10) {
        /*
            r9 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 56
            r2 = 0
            r3 = 1
            r4 = 0
            r0[r1] = r3     // Catch:{ IOException -> 0x00f2, NameNotFoundException -> 0x00dc, NullPointerException -> 0x00aa }
            r1 = r4
            android.content.Context r4 = r10.getApplicationContext()     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r5 = 57
            r0[r5] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r5 = 58
            r0[r5] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            android.content.Context r5 = r10.getApplicationContext()     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r6 = 59
            r0[r6] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r6 = 60
            r0[r6] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r2)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            android.content.pm.ApplicationInfo r4 = r4.applicationInfo     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.lang.String r4 = r4.sourceDir     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r5 = 61
            r0[r5] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r1 = r5
            java.lang.String r5 = "META-INF/utm"
            r6 = 62
            r0[r6] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.util.zip.ZipEntry r5 = r1.getEntry(r5)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.io.InputStream r5 = r1.getInputStream(r5)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r6 = 63
            r0[r6] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            cm.aptoide.pt.analytics.UTMTrackingFileParser r6 = new cm.aptoide.pt.analytics.UTMTrackingFileParser     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r7 = 64
            r0[r7] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r1.close()     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r7 = 65
            r0[r7] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.lang.String r7 = "utm_source"
            java.lang.String r7 = r6.valueExtracter(r7)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r9.utmSource = r7     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r7 = 66
            r0[r7] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.lang.String r7 = "utm_medium"
            java.lang.String r7 = r6.valueExtracter(r7)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r9.utmMedium = r7     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r7 = 67
            r0[r7] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.lang.String r7 = "utm_campaign"
            java.lang.String r7 = r6.valueExtracter(r7)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r9.utmCampaign = r7     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r7 = 68
            r0[r7] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.lang.String r7 = "utm_content"
            java.lang.String r7 = r6.valueExtracter(r7)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r9.utmContent = r7     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r7 = 69
            r0[r7] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            java.lang.String r7 = "entry_point"
            java.lang.String r7 = r6.valueExtracter(r7)     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r9.entryPoint = r7     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r7 = 70
            r0[r7] = r3     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r5.close()     // Catch:{ IOException -> 0x00a8, NameNotFoundException -> 0x00a6, NullPointerException -> 0x00a4 }
            r2 = 71
            r0[r2] = r3
            goto L_0x00d7
        L_0x00a4:
            r4 = move-exception
            goto L_0x00ae
        L_0x00a6:
            r4 = move-exception
            goto L_0x00e0
        L_0x00a8:
            r4 = move-exception
            goto L_0x00f6
        L_0x00aa:
            r1 = move-exception
            r8 = r4
            r4 = r1
            r1 = r8
        L_0x00ae:
            if (r1 == 0) goto L_0x00ca
            r5 = 76
            r0[r5] = r3     // Catch:{ IOException -> 0x00bd }
            r1.close()     // Catch:{ IOException -> 0x00bd }
            r5 = 79
            r0[r5] = r3
            return r2
        L_0x00bd:
            r5 = move-exception
            r6 = 77
            r0[r6] = r3
            r5.printStackTrace()
            r6 = 78
            r0[r6] = r3
            return r2
        L_0x00ca:
            cm.aptoide.analytics.AnalyticsLogger r2 = r9.logger
            java.lang.String r5 = TAG
            java.lang.String r6 = "No utm file."
            r2.logDebug(r5, r6)
            r2 = 80
            r0[r2] = r3
        L_0x00d7:
            r2 = 81
            r0[r2] = r3
            return r3
        L_0x00dc:
            r1 = move-exception
            r8 = r4
            r4 = r1
            r1 = r8
        L_0x00e0:
            r5 = 74
            r0[r5] = r3
            cm.aptoide.analytics.AnalyticsLogger r5 = r9.logger
            java.lang.String r6 = TAG
            java.lang.String r7 = "No package name utm file."
            r5.logDebug(r6, r7)
            r5 = 75
            r0[r5] = r3
            return r2
        L_0x00f2:
            r1 = move-exception
            r8 = r4
            r4 = r1
            r1 = r8
        L_0x00f6:
            r5 = 72
            r0[r5] = r3
            cm.aptoide.analytics.AnalyticsLogger r5 = r9.logger
            java.lang.String r6 = TAG
            java.lang.String r7 = "problem parsing utm/no utm file"
            r5.logDebug(r6, r7)
            r5 = 73
            r0[r5] = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics.checkForUTMFileInMetaINF(android.app.Application):boolean");
    }

    public void setGmsPresent(boolean isPlayServicesAvailable) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (isPlayServicesAvailable) {
            $jacocoInit[82] = true;
            str = HAS_HGMS;
        } else {
            $jacocoInit[83] = true;
            str = NO_GMS;
        }
        setUserProperties(GMS, str);
        $jacocoInit[84] = true;
    }

    private void setUserProperties(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle parameters = new Bundle();
        $jacocoInit[85] = true;
        parameters.putString(key, value);
        $jacocoInit[86] = true;
        C6638q.m13217a(parameters, (C6545b) new C1686b(this));
        $jacocoInit[87] = true;
        C7294e.m15866a(key, value);
        $jacocoInit[88] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo800a(C6817z response) {
        boolean[] $jacocoInit = $jacocoInit();
        this.logger.logDebug("Facebook Analytics: ", response.toString());
        $jacocoInit[117] = true;
    }

    private void setUserPropertiesWithBundle(Bundle data) {
        boolean[] $jacocoInit = $jacocoInit();
        C6638q.m13217a(data, (C6545b) new C1691g(this));
        $jacocoInit[89] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo803b(C6817z response) {
        boolean[] $jacocoInit = $jacocoInit();
        this.logger.logDebug("Facebook Analytics: ", response.toString());
        $jacocoInit[116] = true;
    }

    private void setUserProperties(String utmSource2, String utmMedium2, String utmCampaign2, String utmContent2, String entryPoint2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[90] = true;
        Bundle createUserPropertiesBundle = createUserPropertiesBundle(utmSource2, utmMedium2, utmCampaign2, utmContent2, entryPoint2);
        $jacocoInit[91] = true;
        setUserPropertiesWithBundle(createUserPropertiesBundle);
        $jacocoInit[92] = true;
        C7294e.m15866a(UTM_SOURCE, utmSource2);
        $jacocoInit[93] = true;
        C7294e.m15866a(UTM_MEDIUM, utmMedium2);
        $jacocoInit[94] = true;
        C7294e.m15866a(UTM_CAMPAIGN, utmCampaign2);
        $jacocoInit[95] = true;
        C7294e.m15866a(UTM_CONTENT, utmContent2);
        $jacocoInit[96] = true;
        C7294e.m15866a(ENTRY_POINT, entryPoint2);
        $jacocoInit[97] = true;
    }

    private Bundle createUserPropertiesBundle(String utmSource2, String utmMedium2, String utmCampaign2, String utmContent2, String entryPoint2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle data = new Bundle();
        $jacocoInit[98] = true;
        data.putString(UTM_SOURCE, utmSource2);
        $jacocoInit[99] = true;
        data.putString(UTM_MEDIUM, utmMedium2);
        $jacocoInit[100] = true;
        data.putString(UTM_CAMPAIGN, utmCampaign2);
        $jacocoInit[101] = true;
        data.putString(UTM_CONTENT, utmContent2);
        $jacocoInit[102] = true;
        data.putString(ENTRY_POINT, entryPoint2);
        $jacocoInit[103] = true;
        return data;
    }

    private void setUTMDimensionsToUnknown() {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle data = new Bundle();
        $jacocoInit[104] = true;
        String str = UTM_SOURCE;
        String str2 = UNKNOWN;
        data.putString(str, str2);
        $jacocoInit[105] = true;
        String str3 = UTM_MEDIUM;
        data.putString(str3, str2);
        $jacocoInit[106] = true;
        String str4 = UTM_CAMPAIGN;
        data.putString(str4, str2);
        $jacocoInit[107] = true;
        String str5 = UTM_CONTENT;
        data.putString(str5, str2);
        $jacocoInit[108] = true;
        String str6 = ENTRY_POINT;
        data.putString(str6, str2);
        $jacocoInit[109] = true;
        setUserPropertiesWithBundle(data);
        $jacocoInit[110] = true;
        C7294e.m15866a(str, str2);
        $jacocoInit[111] = true;
        C7294e.m15866a(str3, str2);
        $jacocoInit[112] = true;
        C7294e.m15866a(str4, str2);
        $jacocoInit[113] = true;
        C7294e.m15866a(str5, str2);
        $jacocoInit[114] = true;
        C7294e.m15866a(str6, str2);
        $jacocoInit[115] = true;
    }
}
