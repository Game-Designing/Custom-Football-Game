package p005cm.aptoide.p006pt.billing.networking;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationFactory;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetAuthorizationRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetAuthorizationRequest.ResponseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.UpdateAuthorizationRequest;
import p005cm.aptoide.p006pt.networking.Authentication;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.billing.networking.AuthorizationServiceV7 */
public class AuthorizationServiceV7 implements AuthorizationService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthenticationPersistence authenticationPersistence;
    private final AuthorizationFactory authorizationFactory;
    private final AuthorizationMapperV7 authorizationMapper;
    private final BillingIdManager billingIdManager;
    private final BodyInterceptor<BaseBody> bodyInterceptorV7;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6563023188943793552L, "cm/aptoide/pt/billing/networking/AuthorizationServiceV7", 44);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizationServiceV7(AuthorizationMapperV7 authorizationMapper2, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, BodyInterceptor<BaseBody> bodyInterceptorV72, BillingIdManager billingIdManager2, AuthorizationFactory authorizationFactory2, AuthenticationPersistence authenticationPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authorizationMapper = authorizationMapper2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.bodyInterceptorV7 = bodyInterceptorV72;
        this.billingIdManager = billingIdManager2;
        this.authorizationFactory = authorizationFactory2;
        this.authenticationPersistence = authenticationPersistence2;
        $jacocoInit[0] = true;
    }

    public Single<Authorization> getAuthorization(String transactionId, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C2312e eVar = new C2312e(this, transactionId, customerId);
        $jacocoInit[1] = true;
        C0120S c = authentication.mo3697c(eVar);
        $jacocoInit[2] = true;
        Single n = c.mo3678n();
        C2313f fVar = new C2313f(this, transactionId, customerId);
        $jacocoInit[3] = true;
        Single<Authorization> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) fVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11152a(String transactionId, String customerId, Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[39] = true;
        String str = transactionId;
        long resolveTransactionId = billingIdManager2.resolveTransactionId(transactionId);
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorV7;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[40] = true;
        String accessToken = authentication.getAccessToken();
        $jacocoInit[41] = true;
        GetAuthorizationRequest of = GetAuthorizationRequest.m7538of(resolveTransactionId, sharedPreferences2, okHttpClient, factory, bodyInterceptor, tokenInvalidator2, accessToken, customerId);
        $jacocoInit[42] = true;
        C0120S observe = of.observe();
        $jacocoInit[43] = true;
        return observe;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11154a(String transactionId, String customerId, Response response) {
        String str = transactionId;
        boolean[] $jacocoInit = $jacocoInit();
        okhttp3.Response raw = response.raw();
        $jacocoInit[16] = true;
        if (raw.networkResponse() == null) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            okhttp3.Response raw2 = response.raw();
            $jacocoInit[19] = true;
            okhttp3.Response networkResponse = raw2.networkResponse();
            $jacocoInit[20] = true;
            if (networkResponse.code() != 304) {
                $jacocoInit[21] = true;
            } else {
                $jacocoInit[22] = true;
                StringBuilder sb = new StringBuilder();
                sb.append("Stale authorization for transaction ");
                sb.append(str);
                Single a = Single.m735a((Throwable) new IllegalStateException(sb.toString()));
                $jacocoInit[23] = true;
                return a;
            }
        }
        if (response.isSuccessful()) {
            $jacocoInit[24] = true;
            if (response.body() == null) {
                $jacocoInit[25] = true;
            } else {
                ResponseBody responseBody = (ResponseBody) response.body();
                $jacocoInit[26] = true;
                if (!responseBody.isOk()) {
                    $jacocoInit[27] = true;
                } else {
                    $jacocoInit[28] = true;
                    AuthorizationMapperV7 authorizationMapperV7 = this.authorizationMapper;
                    ResponseBody responseBody2 = (ResponseBody) response.body();
                    $jacocoInit[29] = true;
                    ResponseBody.Authorization data = responseBody2.getData();
                    $jacocoInit[30] = true;
                    Single a2 = Single.m734a(authorizationMapperV7.map(data, str));
                    $jacocoInit[31] = true;
                    return a2;
                }
            }
            Single a3 = Single.m735a((Throwable) new IllegalStateException(C0044V7.getErrorMessage((BaseV7Response) response.body())));
            $jacocoInit[32] = true;
            return a3;
        } else if (response.code() == 404) {
            AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
            BillingIdManager billingIdManager2 = this.billingIdManager;
            $jacocoInit[33] = true;
            Authorization create = authorizationFactory2.create(billingIdManager2.generateAuthorizationId(), customerId, null, Status.NEW, null, null, null, null, null, transactionId, null);
            $jacocoInit[34] = true;
            Single a4 = Single.m734a(create);
            $jacocoInit[35] = true;
            return a4;
        } else {
            AuthorizationFactory authorizationFactory3 = this.authorizationFactory;
            BillingIdManager billingIdManager3 = this.billingIdManager;
            $jacocoInit[36] = true;
            Authorization create2 = authorizationFactory3.create(billingIdManager3.generateAuthorizationId(), customerId, null, Status.FAILED, null, null, null, null, null, transactionId, null);
            $jacocoInit[37] = true;
            Single a5 = Single.m734a(create2);
            $jacocoInit[38] = true;
            return a5;
        }
    }

    public Single<Authorization> updateAuthorization(String customerId, String transactionId, String metadata) {
        boolean[] $jacocoInit = $jacocoInit();
        UpdateAuthorizationRequest of = UpdateAuthorizationRequest.m7546of(this.billingIdManager.resolveTransactionId(transactionId), metadata, this.sharedPreferences, this.httpClient, this.converterFactory, this.bodyInterceptorV7, this.tokenInvalidator);
        $jacocoInit[5] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[6] = true;
        Single n = observe.mo3678n();
        C2314g gVar = new C2314g(this, transactionId, customerId);
        $jacocoInit[7] = true;
        Single<Authorization> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) gVar);
        $jacocoInit[8] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11153a(String transactionId, String customerId, UpdateAuthorizationRequest.ResponseBody response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[9] = true;
        } else if (!response.isOk()) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            Single a = Single.m734a(this.authorizationMapper.map(response.getData(), transactionId));
            $jacocoInit[12] = true;
            return a;
        }
        AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[13] = true;
        Authorization create = authorizationFactory2.create(billingIdManager2.generateAuthorizationId(), customerId, null, Status.FAILED, null, null, null, null, null, transactionId, null);
        $jacocoInit[14] = true;
        Single a2 = Single.m734a(create);
        $jacocoInit[15] = true;
        return a2;
    }
}
