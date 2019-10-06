package p005cm.aptoide.p006pt.account;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p026rx.C0120S;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.account.MatureBodyInterceptorV7 */
public class MatureBodyInterceptorV7 implements BodyInterceptor<BaseBody> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdultContent adultContent;
    private final BodyInterceptor<BaseBody> bodyInterceptorV7;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5110049180023373030L, "cm/aptoide/pt/account/MatureBodyInterceptorV7", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single intercept(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single intercept = intercept((BaseBody) obj);
        $jacocoInit[5] = true;
        return intercept;
    }

    public MatureBodyInterceptorV7(BodyInterceptor<BaseBody> bodyInterceptorV72, AdultContent adultContent2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptorV7 = bodyInterceptorV72;
        this.adultContent = adultContent2;
        $jacocoInit[0] = true;
    }

    public Single<BaseBody> intercept(BaseBody body) {
        boolean[] $jacocoInit = $jacocoInit();
        Single intercept = this.bodyInterceptorV7.intercept(body);
        C0120S enabled = this.adultContent.enabled();
        $jacocoInit[1] = true;
        C0120S d = enabled.mo3647d();
        $jacocoInit[2] = true;
        Single n = d.mo3678n();
        C1429aa aaVar = C1429aa.f4346a;
        $jacocoInit[3] = true;
        Single<BaseBody> a = Single.m740a(intercept, n, aaVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ BaseBody m123a(BaseBody bodyV7, Boolean adultContentEnabled) {
        boolean[] $jacocoInit = $jacocoInit();
        bodyV7.setMature(adultContentEnabled.booleanValue());
        $jacocoInit[6] = true;
        return bodyV7;
    }
}
