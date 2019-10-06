package p005cm.aptoide.p006pt.analytics.view;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import java.util.Locale;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.crashreports.CrashlyticsCrashLogger;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.permission.PermissionProviderActivity;

/* renamed from: cm.aptoide.pt.analytics.view.AnalyticsActivity */
public abstract class AnalyticsActivity extends PermissionProviderActivity {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean _resumed = false;
    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    FirstLaunchAnalytics firstLaunchAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7200328119475963089L, "cm/aptoide/pt/analytics/view/AnalyticsActivity", 21);
        $jacocoData = probes;
        return probes;
    }

    public AnalyticsActivity() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public boolean is_resumed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this._resumed;
        $jacocoInit[1] = true;
        return z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getActivityComponent().inject(this);
        if (VERSION.SDK_INT < 24) {
            $jacocoInit[3] = true;
            $jacocoInit[4] = true;
            CrashlyticsCrashLogger crashlyticsCrashLogger = (CrashlyticsCrashLogger) CrashReport.getInstance().getLogger(CrashlyticsCrashLogger.class);
            $jacocoInit[5] = true;
            String language = getResources().getConfiguration().locale.getLanguage();
            $jacocoInit[6] = true;
            crashlyticsCrashLogger.setLanguage(language);
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            CrashlyticsCrashLogger crashlyticsCrashLogger2 = (CrashlyticsCrashLogger) CrashReport.getInstance().getLogger(CrashlyticsCrashLogger.class);
            Configuration configuration = getResources().getConfiguration();
            $jacocoInit[9] = true;
            LocaleList locales = configuration.getLocales();
            $jacocoInit[10] = true;
            Locale locale = locales.get(0);
            $jacocoInit[11] = true;
            String language2 = locale.getLanguage();
            $jacocoInit[12] = true;
            crashlyticsCrashLogger2.setLanguage(language2);
            $jacocoInit[13] = true;
        }
        this.firstLaunchAnalytics.setGmsPresent(AdNetworkUtils.isGooglePlayServicesAvailable(this));
        $jacocoInit[14] = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onStart();
        $jacocoInit[15] = true;
        this.analyticsManager.startSession();
        $jacocoInit[16] = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        this._resumed = true;
        $jacocoInit[17] = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onPause();
        this._resumed = false;
        $jacocoInit[18] = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onStop();
        $jacocoInit[19] = true;
        this.analyticsManager.endSession();
        $jacocoInit[20] = true;
    }
}
