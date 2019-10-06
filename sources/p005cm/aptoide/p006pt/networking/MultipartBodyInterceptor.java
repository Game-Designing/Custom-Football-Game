package p005cm.aptoide.p006pt.networking;

import okhttp3.RequestBody;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p026rx.Single;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.networking.MultipartBodyInterceptor */
public class MultipartBodyInterceptor implements BodyInterceptor<HashMapNotNull<String, RequestBody>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthenticationPersistence authenticationPersistence;
    private final IdsRepository idsRepository;
    private final RequestBodyFactory requestBodyFactory;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(743104461896627415L, "cm/aptoide/pt/networking/MultipartBodyInterceptor", 13);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single intercept(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single intercept = intercept((HashMapNotNull) obj);
        $jacocoInit[4] = true;
        return intercept;
    }

    public MultipartBodyInterceptor(IdsRepository idsRepository2, RequestBodyFactory requestBodyFactory2, AuthenticationPersistence authenticationPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository = idsRepository2;
        this.authenticationPersistence = authenticationPersistence2;
        this.requestBodyFactory = requestBodyFactory2;
        $jacocoInit[0] = true;
    }

    public Single<HashMapNotNull<String, RequestBody>> intercept(HashMapNotNull<String, RequestBody> body) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C4149g gVar = new C4149g(this, body);
        $jacocoInit[1] = true;
        Single a = authentication.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) gVar);
        $jacocoInit[2] = true;
        Single<HashMapNotNull<String, RequestBody>> b = a.mo3694b(Schedulers.computation());
        $jacocoInit[3] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo15224a(HashMapNotNull body, Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!authentication.isAuthenticated()) {
            $jacocoInit[5] = true;
        } else {
            RequestBodyFactory requestBodyFactory2 = this.requestBodyFactory;
            $jacocoInit[6] = true;
            RequestBody createBodyPartFromString = requestBodyFactory2.createBodyPartFromString(authentication.getAccessToken());
            $jacocoInit[7] = true;
            body.put("access_token", createBodyPartFromString);
            $jacocoInit[8] = true;
        }
        RequestBodyFactory requestBodyFactory3 = this.requestBodyFactory;
        IdsRepository idsRepository2 = this.idsRepository;
        $jacocoInit[9] = true;
        RequestBody createBodyPartFromString2 = requestBodyFactory3.createBodyPartFromString(idsRepository2.getUniqueIdentifier());
        $jacocoInit[10] = true;
        body.put("aptoide_uid", createBodyPartFromString2);
        $jacocoInit[11] = true;
        Single a = Single.m734a(body);
        $jacocoInit[12] = true;
        return a;
    }
}
