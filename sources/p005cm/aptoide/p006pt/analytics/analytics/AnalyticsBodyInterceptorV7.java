package p005cm.aptoide.p006pt.analytics.analytics;

import android.content.SharedPreferences;
import android.content.res.Resources;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.network.AnalyticsBaseBody;
import p005cm.aptoide.analytics.implementation.network.AnalyticsBodyInterceptor;
import p005cm.aptoide.p006pt.networking.Authentication;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p026rx.Single;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.analytics.analytics.AnalyticsBodyInterceptorV7 */
public class AnalyticsBodyInterceptorV7 implements AnalyticsBodyInterceptor<AnalyticsBaseBody> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String aptoideMd5sum;
    private final String aptoidePackage;
    private final int aptoideVersionCode;
    private final AuthenticationPersistence authenticationPersistence;
    private final IdsRepository idsRepository;
    private final QManager qManager;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2206129123573560379L, "cm/aptoide/pt/analytics/analytics/AnalyticsBodyInterceptorV7", 14);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single intercept(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single intercept = intercept((AnalyticsBaseBody) obj);
        $jacocoInit[4] = true;
        return intercept;
    }

    public AnalyticsBodyInterceptorV7(IdsRepository idsRepository2, AuthenticationPersistence authenticationPersistence2, String aptoideMd5sum2, String aptoidePackage2, Resources resources2, int aptoideVersionCode2, QManager qManager2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository = idsRepository2;
        this.authenticationPersistence = authenticationPersistence2;
        this.aptoideMd5sum = aptoideMd5sum2;
        this.aptoidePackage = aptoidePackage2;
        this.resources = resources2;
        this.aptoideVersionCode = aptoideVersionCode2;
        this.qManager = qManager2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public Single<AnalyticsBaseBody> intercept(AnalyticsBaseBody body) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C1680a aVar = new C1680a(this, body);
        $jacocoInit[1] = true;
        Single d = authentication.mo3698d(aVar);
        $jacocoInit[2] = true;
        Single<AnalyticsBaseBody> b = d.mo3694b(Schedulers.computation());
        $jacocoInit[3] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ AnalyticsBaseBody mo10062a(AnalyticsBaseBody body, Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!authentication.isAuthenticated()) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            body.setAccessToken(authentication.getAccessToken());
            $jacocoInit[7] = true;
        }
        body.setAptoideUid(this.idsRepository.getUniqueIdentifier());
        $jacocoInit[8] = true;
        body.setAptoideVercode(this.aptoideVersionCode);
        $jacocoInit[9] = true;
        body.setLang(SystemU.getCountryCode(this.resources));
        $jacocoInit[10] = true;
        body.setQ(this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)));
        $jacocoInit[11] = true;
        body.setAptoideMd5sum(this.aptoideMd5sum);
        $jacocoInit[12] = true;
        body.setAptoidePackage(this.aptoidePackage);
        $jacocoInit[13] = true;
        return body;
    }
}
