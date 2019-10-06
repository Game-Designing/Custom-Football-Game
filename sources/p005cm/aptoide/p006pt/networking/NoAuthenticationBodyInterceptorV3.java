package p005cm.aptoide.p006pt.networking;

import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p026rx.Single;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.networking.NoAuthenticationBodyInterceptorV3 */
public class NoAuthenticationBodyInterceptorV3 implements BodyInterceptor<BaseBody> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String aptoideMd5sum;
    private final String aptoidePackage;
    private final IdsRepository idsRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9190172110700049406L, "cm/aptoide/pt/networking/NoAuthenticationBodyInterceptorV3", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single intercept(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single intercept = intercept((BaseBody) obj);
        $jacocoInit[3] = true;
        return intercept;
    }

    public NoAuthenticationBodyInterceptorV3(IdsRepository idsRepository2, String aptoideMd5sum2, String aptoidePackage2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideMd5sum = aptoideMd5sum2;
        this.aptoidePackage = aptoidePackage2;
        this.idsRepository = idsRepository2;
        $jacocoInit[0] = true;
    }

    public Single<BaseBody> intercept(BaseBody body) {
        boolean[] $jacocoInit = $jacocoInit();
        Single b = Single.m742b((Callable<? extends T>) new C4150h<Object>(this, body));
        $jacocoInit[1] = true;
        Single<BaseBody> b2 = b.mo3694b(Schedulers.computation());
        $jacocoInit[2] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ BaseBody mo15226a(BaseBody body) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        body.setAptoideMd5sum(this.aptoideMd5sum);
        $jacocoInit[4] = true;
        body.setAptoidePackage(this.aptoidePackage);
        $jacocoInit[5] = true;
        body.setAptoideUid(this.idsRepository.getUniqueIdentifier());
        $jacocoInit[6] = true;
        return body;
    }
}
