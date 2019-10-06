package p005cm.aptoide.p006pt.networking;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p026rx.Single;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.networking.BodyInterceptorV7 */
public class BodyInterceptorV7 implements BodyInterceptor<BaseBody> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String aptoideMd5sum;
    private final String aptoidePackage;
    private final int aptoideVersionCode;
    private final AuthenticationPersistence authenticationPersistence;
    private final Cdn cdn;
    private final IdsRepository idsRepository;
    private final QManager qManager;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1622565438782518214L, "cm/aptoide/pt/networking/BodyInterceptorV7", 21);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single intercept(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single intercept = intercept((BaseBody) obj);
        $jacocoInit[4] = true;
        return intercept;
    }

    public BodyInterceptorV7(IdsRepository idsRepository2, AuthenticationPersistence authenticationPersistence2, String aptoideMd5sum2, String aptoidePackage2, QManager qManager2, Cdn cdn2, SharedPreferences sharedPreferences2, Resources resources2, int aptoideVersionCode2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository = idsRepository2;
        this.authenticationPersistence = authenticationPersistence2;
        this.aptoideMd5sum = aptoideMd5sum2;
        this.aptoidePackage = aptoidePackage2;
        this.qManager = qManager2;
        this.cdn = cdn2;
        this.aptoideVersionCode = aptoideVersionCode2;
        this.sharedPreferences = sharedPreferences2;
        this.resources = resources2;
        $jacocoInit[0] = true;
    }

    public Single<BaseBody> intercept(BaseBody body) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C4148f fVar = new C4148f(this, body);
        $jacocoInit[1] = true;
        Single d = authentication.mo3698d(fVar);
        $jacocoInit[2] = true;
        Single<BaseBody> b = d.mo3694b(Schedulers.computation());
        $jacocoInit[3] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ BaseBody mo15222a(BaseBody body, Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        if (authentication.isAuthenticated()) {
            $jacocoInit[5] = true;
            body.setAccessToken(authentication.getAccessToken());
            $jacocoInit[6] = true;
        } else {
            body.setAccessToken(null);
            $jacocoInit[7] = true;
        }
        body.setAptoideId(this.idsRepository.getUniqueIdentifier());
        $jacocoInit[8] = true;
        body.setAptoideVercode(this.aptoideVersionCode);
        $jacocoInit[9] = true;
        String name = this.cdn.name();
        $jacocoInit[10] = true;
        String lowerCase = name.toLowerCase();
        $jacocoInit[11] = true;
        body.setCdn(lowerCase);
        $jacocoInit[12] = true;
        body.setLang(SystemU.getCountryCode(this.resources));
        $jacocoInit[13] = true;
        body.setQ(this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)));
        $jacocoInit[14] = true;
        String forceCountry = ToolboxManager.getForceCountry(this.sharedPreferences);
        $jacocoInit[15] = true;
        if (TextUtils.isEmpty(forceCountry)) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            body.setCountry(forceCountry);
            $jacocoInit[18] = true;
        }
        body.setAptoideMd5sum(this.aptoideMd5sum);
        $jacocoInit[19] = true;
        body.setAptoidePackage(this.aptoidePackage);
        $jacocoInit[20] = true;
        return body;
    }
}
