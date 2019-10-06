package p005cm.aptoide.p006pt.networking;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.NetworkOperatorManager;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p026rx.Single;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.networking.BodyInterceptorV3 */
public class BodyInterceptorV3 implements BodyInterceptor<BaseBody> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String RESPONSE_MODE_JSON = "json";
    private final int androidVersion;
    private final String aptoideMd5sum;
    private final String aptoidePackage;
    private final AuthenticationPersistence authenticationPersistence;
    private final IdsRepository idsRepository;
    private final NetworkOperatorManager operatorManager;
    private final QManager qManager;
    private final String responseMode;
    private final SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4663856418645748076L, "cm/aptoide/pt/networking/BodyInterceptorV3", 23);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single intercept(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single intercept = intercept((BaseBody) obj);
        $jacocoInit[4] = true;
        return intercept;
    }

    public BodyInterceptorV3(IdsRepository idsRepository2, String aptoideMd5sum2, String aptoidePackage2, QManager qManager2, SharedPreferences sharedPreferences2, String responseMode2, int androidVersion2, NetworkOperatorManager operatorManager2, AuthenticationPersistence authenticationPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository = idsRepository2;
        this.aptoideMd5sum = aptoideMd5sum2;
        this.aptoidePackage = aptoidePackage2;
        this.authenticationPersistence = authenticationPersistence2;
        this.qManager = qManager2;
        this.sharedPreferences = sharedPreferences2;
        this.responseMode = responseMode2;
        this.androidVersion = androidVersion2;
        this.operatorManager = operatorManager2;
        $jacocoInit[0] = true;
    }

    public Single<BaseBody> intercept(BaseBody body) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C4147e eVar = new C4147e(this, body);
        $jacocoInit[1] = true;
        Single d = authentication.mo3698d(eVar);
        $jacocoInit[2] = true;
        Single<BaseBody> b = d.mo3694b(Schedulers.computation());
        $jacocoInit[3] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ BaseBody mo15220a(BaseBody body, Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        body.setAndroidVersion(this.androidVersion);
        $jacocoInit[5] = true;
        body.setAptoideMd5sum(this.aptoideMd5sum);
        $jacocoInit[6] = true;
        body.setAptoidePackage(this.aptoidePackage);
        $jacocoInit[7] = true;
        body.setAptoideUid(this.idsRepository.getUniqueIdentifier());
        $jacocoInit[8] = true;
        body.setQ(this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)));
        $jacocoInit[9] = true;
        body.setResponseMode(this.responseMode);
        $jacocoInit[10] = true;
        if (!authentication.isAuthenticated()) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            body.setAccessToken(authentication.getAccessToken());
            $jacocoInit[13] = true;
        }
        String forceCountry = ToolboxManager.getForceCountry(this.sharedPreferences);
        $jacocoInit[14] = true;
        if (!TextUtils.isEmpty(forceCountry)) {
            $jacocoInit[15] = true;
            body.setSimCountryISOCode(forceCountry);
            $jacocoInit[16] = true;
        } else if (!this.operatorManager.isSimStateReady()) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            body.setMobileCountryCode(this.operatorManager.getMobileCountryCode());
            $jacocoInit[19] = true;
            body.setMobileNetworkCode(this.operatorManager.getMobileNetworkCode());
            $jacocoInit[20] = true;
            body.setSimCountryISOCode(this.operatorManager.getSimCountryISO());
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
        return body;
    }
}
