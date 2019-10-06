package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateService */
/* compiled from: AutoUpdateService.kt */
public final class AutoUpdateService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String autoUpdateStoreName;
    private boolean loading;
    private final String packageName;
    private final Service service;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6949506222020678048L, "cm/aptoide/pt/autoupdate/AutoUpdateService", 19);
        $jacocoData = probes;
        return probes;
    }

    public AutoUpdateService(Service service2, String packageName2, String autoUpdateStoreName2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(service2, "service");
        C14281f.m45916b(packageName2, "packageName");
        C14281f.m45916b(autoUpdateStoreName2, "autoUpdateStoreName");
        $jacocoInit[13] = true;
        this.service = service2;
        this.packageName = packageName2;
        this.autoUpdateStoreName = autoUpdateStoreName2;
        $jacocoInit[14] = true;
    }

    public static final /* synthetic */ AutoUpdateModel access$createErrorAutoUpdateModel(AutoUpdateService $this, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateModel createErrorAutoUpdateModel = $this.createErrorAutoUpdateModel(throwable);
        $jacocoInit[18] = true;
        return createErrorAutoUpdateModel;
    }

    public static final /* synthetic */ boolean access$getLoading$p(AutoUpdateService $this) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = $this.loading;
        $jacocoInit[15] = true;
        return z;
    }

    public static final /* synthetic */ String access$getPackageName$p(AutoUpdateService $this) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = $this.packageName;
        $jacocoInit[17] = true;
        return str;
    }

    public static final /* synthetic */ void access$setLoading$p(AutoUpdateService $this, boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        $this.loading = z;
        $jacocoInit[16] = true;
    }

    public final Single<AutoUpdateModel> loadAutoUpdateModel() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loading) {
            $jacocoInit[0] = true;
            Single<AutoUpdateModel> a = Single.m734a(new AutoUpdateModel(true));
            C14281f.m45913a((Object) a, "Single.just(AutoUpdateModel(loading = true))");
            $jacocoInit[1] = true;
            return a;
        }
        C0120S jsonResponse = this.service.getJsonResponse(this.autoUpdateStoreName);
        $jacocoInit[2] = true;
        C0120S b = jsonResponse.mo3635b((C0128a) new AutoUpdateService$loadAutoUpdateModel$1(this));
        $jacocoInit[3] = true;
        C0120S d = b.mo3652d((C0128a) new AutoUpdateService$loadAutoUpdateModel$2(this));
        $jacocoInit[4] = true;
        C0120S c = d.mo3644c((C0128a) new AutoUpdateService$loadAutoUpdateModel$3(this));
        $jacocoInit[5] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new AutoUpdateService$loadAutoUpdateModel$4<Object,Object>(this));
        $jacocoInit[6] = true;
        C0120S l = f.mo3674l(new AutoUpdateService$loadAutoUpdateModel$5(this));
        $jacocoInit[7] = true;
        Single<AutoUpdateModel> n = l.mo3678n();
        C14281f.m45913a((Object) n, "service.getJsonResponse(…it) }\n        .toSingle()");
        $jacocoInit[8] = true;
        return n;
    }

    private final AutoUpdateModel createErrorAutoUpdateModel(Throwable throwable) {
        AutoUpdateModel autoUpdateModel;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[9] = true;
        if (throwable instanceof NoNetworkConnectionException) {
            autoUpdateModel = new AutoUpdateModel(Status.ERROR_NETWORK);
            $jacocoInit[10] = true;
        } else {
            autoUpdateModel = new AutoUpdateModel(Status.ERROR_GENERIC);
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
        return autoUpdateModel;
    }
}
