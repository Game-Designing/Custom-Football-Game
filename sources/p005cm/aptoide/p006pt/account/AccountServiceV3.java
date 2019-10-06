package p005cm.aptoide.p006pt.account;

import android.content.SharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AccountException;
import p005cm.aptoide.accountmanager.AccountFactory;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.accountmanager.Store;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV3Exception;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.OAuth;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TermsAndConditionsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetMySubscribedStoresResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetUserInfo;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Stats;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.C2847V3;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.ChangeUserBirthdateRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.ChangeUserNewsletterSubscription;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.CreateUserRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GetTermsAndConditionsStatusRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.OAuth2AuthenticationRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.UpdateTermsAndConditionsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ChangeStoreSubscriptionResponse.StoreSubscriptionState;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetMySubscribedStoresRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetUserInfoRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SetUserMultipartRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SetUserRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SetUserSettings;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ChangeStoreSubscriptionRequest;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.p027b.C14542r;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.account.AccountServiceV3 */
public class AccountServiceV3 implements AccountService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountFactory accountFactory;
    private final AuthenticationPersistence authenticationPersistence;
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final BodyInterceptor<BaseBody> bodyInterceptorWebV7;
    private final Factory converterFactory;
    private final BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> defaultBodyInterceptorV3;
    private final String extraId;
    private final OkHttpClient httpClient;
    private final OkHttpClient longTimeoutHttpClient;
    private final BodyInterceptor<HashMapNotNull<String, RequestBody>> multipartBodyInterceptorV7;
    private final OAuthModeProvider oAuthModeProvider;
    private final ObjectMapper serializer;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;
    private final BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> v3NoAuthorizationBodyInterceptor;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(78293043369599754L, "cm/aptoide/pt/account/AccountServiceV3", Opcodes.IF_ICMPLT);
        $jacocoData = probes;
        return probes;
    }

    public AccountServiceV3(AccountFactory accountFactory2, OkHttpClient httpClient2, OkHttpClient longTimeoutHttpClient2, Factory converterFactory2, ObjectMapper serializer2, SharedPreferences sharedPreferences2, String extraId2, TokenInvalidator refreshTokenInvalidator, AuthenticationPersistence authenticationPersistence2, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> v3NoAuthorizationBodyInterceptor2, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> defaultBodyInterceptorV32, BodyInterceptor<HashMapNotNull<String, RequestBody>> multipartBodyInterceptorV72, BodyInterceptor<BaseBody> bodyInterceptorWebV72, BodyInterceptor<BaseBody> bodyInterceptorPoolV72, OAuthModeProvider oAuthModeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountFactory = accountFactory2;
        this.httpClient = httpClient2;
        this.longTimeoutHttpClient = longTimeoutHttpClient2;
        this.converterFactory = converterFactory2;
        this.serializer = serializer2;
        this.sharedPreferences = sharedPreferences2;
        this.extraId = extraId2;
        this.tokenInvalidator = refreshTokenInvalidator;
        this.authenticationPersistence = authenticationPersistence2;
        this.v3NoAuthorizationBodyInterceptor = v3NoAuthorizationBodyInterceptor2;
        this.defaultBodyInterceptorV3 = defaultBodyInterceptorV32;
        this.multipartBodyInterceptorV7 = multipartBodyInterceptorV72;
        this.bodyInterceptorWebV7 = bodyInterceptorWebV72;
        this.bodyInterceptorPoolV7 = bodyInterceptorPoolV72;
        this.oAuthModeProvider = oAuthModeProvider2;
        $jacocoInit[0] = true;
    }

    public Single<Account> getAccount(String email, String password) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Account> createAccount = createAccount(email.toLowerCase(), password, null, AptoideAccountManager.APTOIDE_SIGN_UP_TYPE);
        $jacocoInit[1] = true;
        return createAccount;
    }

    public Single<Account> createAccount(String email, String metadata, String name, String type) {
        String str = type;
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor = this.v3NoAuthorizationBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        String str2 = this.extraId;
        OAuthModeProvider oAuthModeProvider2 = this.oAuthModeProvider;
        $jacocoInit[2] = true;
        String authMode = oAuthModeProvider2.getAuthMode(str);
        $jacocoInit[3] = true;
        OAuth2AuthenticationRequest of = OAuth2AuthenticationRequest.m7452of(email, metadata, type, null, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, str2, authMode);
        $jacocoInit[4] = true;
        C0120S observe = of.observe();
        $jacocoInit[5] = true;
        Single n = observe.mo3678n();
        C1436f fVar = new C1436f(this, email, metadata, str);
        $jacocoInit[6] = true;
        Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) fVar);
        C1437g gVar = C1437g.f4359a;
        $jacocoInit[7] = true;
        Single<Account> e = a.mo3699e(gVar);
        $jacocoInit[8] = true;
        return e;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9584a(String email, String metadata, String type, OAuth oAuth) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!oAuth.hasErrors()) {
            AuthenticationPersistence authenticationPersistence2 = this.authenticationPersistence;
            $jacocoInit[156] = true;
            String refreshToken = oAuth.getRefreshToken();
            String accessToken = oAuth.getAccessToken();
            $jacocoInit[157] = true;
            C0117M createAuthentication = authenticationPersistence2.createAuthentication(email, metadata, refreshToken, accessToken, type);
            $jacocoInit[158] = true;
            Single a = createAuthentication.mo3587a(getAccount());
            $jacocoInit[159] = true;
            return a;
        }
        Single a2 = Single.m735a((Throwable) new AccountException(oAuth));
        $jacocoInit[160] = true;
        return a2;
    }

    /* renamed from: a */
    static /* synthetic */ Single m6178a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof AptoideWsV3Exception) {
            AptoideWsV3Exception exception = (AptoideWsV3Exception) throwable;
            $jacocoInit[153] = true;
            Single a = Single.m735a((Throwable) new AccountException(exception));
            $jacocoInit[154] = true;
            return a;
        }
        Single a2 = Single.m735a(throwable);
        $jacocoInit[155] = true;
        return a2;
    }

    public Single<Account> createAccount(String email, String password) {
        boolean[] $jacocoInit = $jacocoInit();
        CreateUserRequest of = CreateUserRequest.m7446of(email.toLowerCase(), password, this.v3NoAuthorizationBodyInterceptor, this.httpClient, this.tokenInvalidator, this.sharedPreferences, this.extraId);
        $jacocoInit[9] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[10] = true;
        Single n = observe.mo3678n();
        C1432c cVar = new C1432c(this, email, password);
        $jacocoInit[11] = true;
        Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) cVar);
        C1443m mVar = C1443m.f4365a;
        $jacocoInit[12] = true;
        Single<Account> e = a.mo3699e(mVar);
        $jacocoInit[13] = true;
        return e;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9583a(String email, String password, BaseV3Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.hasErrors()) {
            $jacocoInit[150] = true;
            Single a = Single.m735a((Throwable) new AccountException(response.getErrors()));
            $jacocoInit[151] = true;
            return a;
        }
        Single account = getAccount(email, password);
        $jacocoInit[152] = true;
        return account;
    }

    /* renamed from: b */
    static /* synthetic */ Single m6182b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof AptoideWsV3Exception) {
            AptoideWsV3Exception exception = (AptoideWsV3Exception) throwable;
            $jacocoInit[147] = true;
            Single a = Single.m735a((Throwable) new AccountException(exception));
            $jacocoInit[148] = true;
            return a;
        }
        Single a2 = Single.m735a(throwable);
        $jacocoInit[149] = true;
        return a2;
    }

    public C0117M changeBirthdate(String birthdate) {
        boolean[] $jacocoInit = $jacocoInit();
        ChangeUserBirthdateRequest of = ChangeUserBirthdateRequest.m7443of(birthdate, this.defaultBodyInterceptorV3, this.converterFactory, this.httpClient, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[14] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[15] = true;
        Single n = observe.mo3678n();
        C1440j jVar = C1440j.f4362a;
        $jacocoInit[16] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) jVar);
        $jacocoInit[17] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m6174a(BaseV3Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[144] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[145] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new Exception(C2847V3.getErrorMessage(response)));
        $jacocoInit[146] = true;
        return b2;
    }

    public C0117M updateTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        UpdateTermsAndConditionsRequest of = UpdateTermsAndConditionsRequest.m7454of(this.defaultBodyInterceptorV3, this.converterFactory, this.httpClient, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[18] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[19] = true;
        Single n = observe.mo3678n();
        C1446p pVar = C1446p.f4368a;
        $jacocoInit[20] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) pVar);
        $jacocoInit[21] = true;
        return b;
    }

    /* renamed from: c */
    static /* synthetic */ C0117M m6183c(BaseV3Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[141] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[142] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new Exception(C2847V3.getErrorMessage(response)));
        $jacocoInit[143] = true;
        return b2;
    }

    public C0117M changeSubscribeNewsletter(String isSubscribed) {
        boolean[] $jacocoInit = $jacocoInit();
        ChangeUserNewsletterSubscription of = ChangeUserNewsletterSubscription.m7444of(isSubscribed, this.defaultBodyInterceptorV3, this.converterFactory, this.httpClient, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[22] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[23] = true;
        Single n = observe.mo3678n();
        C1435e eVar = C1435e.f4354a;
        $jacocoInit[24] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) eVar);
        $jacocoInit[25] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ C0117M m6179b(BaseV3Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[138] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[139] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new Exception(C2847V3.getErrorMessage(response)));
        $jacocoInit[140] = true;
        return b2;
    }

    public Single<Account> getAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Account> a = Single.m739a(getServerAccount(), getSubscribedStores(), getTermsAndConditionsForAccount(), (C14542r<? super T1, ? super T2, ? super T3, ? extends R>) new C1451u<Object,Object,Object,Object>(this));
        $jacocoInit[26] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Account mo9580a(GetUserInfo response, List stores, TermsAndConditionsResponse terms) {
        boolean[] $jacocoInit = $jacocoInit();
        Account mapServerAccountToAccount = mapServerAccountToAccount(response, stores, terms);
        $jacocoInit[137] = true;
        return mapServerAccountToAccount;
    }

    public C0117M updateAccount(String nickname, String avatarPath) {
        boolean[] $jacocoInit = $jacocoInit();
        SetUserMultipartRequest of = SetUserMultipartRequest.m7486of(nickname, avatarPath, this.multipartBodyInterceptorV7, this.longTimeoutHttpClient, this.converterFactory, this.serializer, this.tokenInvalidator);
        $jacocoInit[27] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[28] = true;
        Single n = observe.mo3678n();
        C1442l lVar = C1442l.f4364a;
        $jacocoInit[29] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) lVar);
        $jacocoInit[30] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ C0117M m6180b(BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[134] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[135] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new Exception(C0044V7.getErrorMessage(response)));
        $jacocoInit[136] = true;
        return b2;
    }

    public C0117M updateAccount(String accessLevel) {
        boolean[] $jacocoInit = $jacocoInit();
        SetUserRequest of = SetUserRequest.m7487of(accessLevel, this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[31] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[32] = true;
        Single n = observe.mo3678n();
        C1430b bVar = C1430b.f4347a;
        $jacocoInit[33] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) bVar);
        $jacocoInit[34] = true;
        return b;
    }

    /* renamed from: c */
    static /* synthetic */ C0117M m6184c(BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[131] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[132] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new Exception(C0044V7.getErrorMessage(response)));
        $jacocoInit[133] = true;
        return b2;
    }

    public C0117M updateAccountUsername(String username) {
        boolean[] $jacocoInit = $jacocoInit();
        SetUserRequest ofWithName = SetUserRequest.ofWithName(username, this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[35] = true;
        C0120S observe = ofWithName.observe(true, false);
        $jacocoInit[36] = true;
        Single n = observe.mo3678n();
        C1449s sVar = C1449s.f4371a;
        $jacocoInit[37] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) sVar);
        $jacocoInit[38] = true;
        return b;
    }

    /* renamed from: d */
    static /* synthetic */ C0117M m6186d(BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[128] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[129] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new Exception(C0044V7.getErrorMessage(response)));
        $jacocoInit[130] = true;
        return b2;
    }

    public C0117M unsubscribeStore(String storeName, String storeUserName, String storePassword) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M changeSubscription = changeSubscription(storeName, storeUserName, storePassword, StoreSubscriptionState.UNSUBSCRIBED);
        $jacocoInit[39] = true;
        return changeSubscription;
    }

    public C0117M subscribeStore(String storeName, String storeUserName, String storePassword) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M changeSubscription = changeSubscription(storeName, storeUserName, storePassword, StoreSubscriptionState.SUBSCRIBED);
        $jacocoInit[40] = true;
        return changeSubscription;
    }

    public C0117M updateAccount(boolean adultContentEnabled) {
        boolean[] $jacocoInit = $jacocoInit();
        SetUserSettings of = SetUserSettings.m7488of(adultContentEnabled, this.httpClient, this.converterFactory, this.bodyInterceptorPoolV7, this.tokenInvalidator);
        $jacocoInit[41] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[42] = true;
        Single n = observe.mo3678n();
        C1434d dVar = C1434d.f4353a;
        $jacocoInit[43] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) dVar);
        $jacocoInit[44] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m6175a(BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[125] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[126] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new Exception(C0044V7.getErrorMessage(response)));
        $jacocoInit[127] = true;
        return b2;
    }

    public C0117M removeAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeAuthentication = this.authenticationPersistence.removeAuthentication();
        $jacocoInit[45] = true;
        return removeAuthentication;
    }

    private C0120S<Throwable> retryOnTicket(C0120S<? extends Throwable> observableError) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = observableError.mo3615a(C0120S.m626a(2, 4), (C14541q<? super T, ? super T2, ? extends R>) C1441k.f4363a);
        C1444n nVar = C1444n.f4366a;
        $jacocoInit[46] = true;
        C0120S<Throwable> f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nVar);
        $jacocoInit[47] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6176a(Throwable throwable, Integer count) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            AptoideWsV7Exception v7Exception = (AptoideWsV7Exception) throwable;
            $jacocoInit[111] = true;
            BaseV7Response baseResponse = v7Exception.getBaseResponse();
            $jacocoInit[112] = true;
            List<Error> errors = baseResponse.getErrors();
            $jacocoInit[113] = true;
            if (errors == null) {
                $jacocoInit[114] = true;
            } else if (errors.isEmpty()) {
                $jacocoInit[115] = true;
            } else {
                Error error = (Error) errors.get(0);
                $jacocoInit[116] = true;
                $jacocoInit[117] = true;
                if (!error.getCode().equalsIgnoreCase("user-1")) {
                    $jacocoInit[118] = true;
                } else {
                    $jacocoInit[119] = true;
                    C0120S j = C0120S.m655f((long) Math.pow(5.0d, (double) count.intValue()), TimeUnit.SECONDS).mo3669j(C1447q.f4369a);
                    $jacocoInit[120] = true;
                    return j;
                }
            }
            $jacocoInit[121] = true;
        } catch (ClassCastException | NullPointerException e) {
            $jacocoInit[122] = true;
        }
        C0120S a = C0120S.m631a(throwable);
        $jacocoInit[123] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Throwable m6172a(Long __) {
        $jacocoInit()[124] = true;
        return null;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m6181b(C0120S observable) {
        $jacocoInit()[110] = true;
        return observable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p005cm.aptoide.accountmanager.Account mapServerAccountToAccount(p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetUserInfo r20, java.util.List<p005cm.aptoide.accountmanager.Store> r21, p005cm.aptoide.p006pt.dataprovider.model.p008v3.TermsAndConditionsResponse r22) {
        /*
            r19 = this;
            r0 = r19
            boolean[] r1 = $jacocoInit()
            cm.aptoide.pt.dataprovider.model.v7.GetUserInfo$Nodes r2 = r20.getNodes()
            r3 = 1
            r4 = 48
            r1[r4] = r3
            cm.aptoide.pt.dataprovider.model.v7.GetUserMeta r2 = r2.getMeta()
            r4 = 49
            r1[r4] = r3
            cm.aptoide.pt.dataprovider.model.v7.GetUserMeta$Data r2 = r2.getData()
            r4 = 50
            r1[r4] = r3
            cm.aptoide.pt.dataprovider.model.v7.GetUserInfo$Nodes r4 = r20.getNodes()
            r5 = 51
            r1[r5] = r3
            cm.aptoide.pt.dataprovider.model.v7.GetUserSettings r4 = r4.getSettings()
            r5 = 52
            r1[r5] = r3
            cm.aptoide.pt.dataprovider.model.v7.GetUserSettings$Data r4 = r4.getData()
            r5 = 53
            r1[r5] = r3
            cm.aptoide.accountmanager.AccountFactory r6 = r0.accountFactory
            java.lang.String r7 = r2.getAccess()
            r5 = 54
            r1[r5] = r3
            long r8 = r2.getId()
            java.lang.String r9 = java.lang.String.valueOf(r8)
            cm.aptoide.pt.dataprovider.model.v7.GetUserMeta$Identity r5 = r2.getIdentity()
            r8 = 55
            r1[r8] = r3
            java.lang.String r10 = r5.getEmail()
            java.lang.String r11 = r2.getName()
            java.lang.String r12 = r2.getAvatar()
            cm.aptoide.pt.dataprovider.model.v7.store.Store r5 = r2.getStore()
            cm.aptoide.accountmanager.Store r13 = r0.mapToStore(r5)
            r5 = 56
            r1[r5] = r3
            boolean r14 = r4.isMature()
            cm.aptoide.pt.dataprovider.model.v7.GetUserSettings$Access r5 = r4.getAccess()
            r8 = 57
            r1[r8] = r3
            boolean r15 = r5.isConfirmed()
            boolean r5 = r22.isOk()
            r8 = 0
            if (r5 != 0) goto L_0x0085
            r5 = 58
            r1[r5] = r3
            goto L_0x008f
        L_0x0085:
            boolean r5 = r22.isPrivacy()
            if (r5 != 0) goto L_0x0096
            r5 = 59
            r1[r5] = r3
        L_0x008f:
            r5 = 61
            r1[r5] = r3
            r16 = 0
            goto L_0x009c
        L_0x0096:
            r5 = 60
            r1[r5] = r3
            r16 = 1
        L_0x009c:
            boolean r5 = r22.isOk()
            if (r5 != 0) goto L_0x00a7
            r5 = 62
            r1[r5] = r3
            goto L_0x00b1
        L_0x00a7:
            boolean r5 = r22.isTos()
            if (r5 != 0) goto L_0x00b8
            r5 = 63
            r1[r5] = r3
        L_0x00b1:
            r5 = 65
            r1[r5] = r3
            r17 = 0
            goto L_0x00be
        L_0x00b8:
            r5 = 64
            r1[r5] = r3
            r17 = 1
        L_0x00be:
            r5 = 66
            r1[r5] = r3
            boolean r5 = r22.isOk()
            if (r5 == 0) goto L_0x00d1
            java.util.Date r5 = r22.getBirthdate()
            r8 = 67
            r1[r8] = r3
            goto L_0x00dc
        L_0x00d1:
            java.util.Date r5 = new java.util.Date
            r8 = 1970(0x7b2, float:2.76E-42)
            r5.<init>(r8, r3, r3)
            r8 = 68
            r1[r8] = r3
        L_0x00dc:
            r18 = r5
            r8 = r21
            cm.aptoide.accountmanager.Account r5 = r6.createAccount(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r6 = 69
            r1[r6] = r3
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.AccountServiceV3.mapServerAccountToAccount(cm.aptoide.pt.dataprovider.model.v7.GetUserInfo, java.util.List, cm.aptoide.pt.dataprovider.model.v3.TermsAndConditionsResponse):cm.aptoide.accountmanager.Account");
    }

    private C0117M changeSubscription(String storeName, String storeUserName, String storePassword, StoreSubscriptionState subscription) {
        boolean[] $jacocoInit = $jacocoInit();
        ChangeStoreSubscriptionRequest of = ChangeStoreSubscriptionRequest.m7577of(storeName, subscription, storeUserName, storePassword, this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[70] = true;
        C0120S observe = of.observe();
        $jacocoInit[71] = true;
        Single n = observe.mo3678n();
        $jacocoInit[72] = true;
        C0117M b = n.mo3692b();
        $jacocoInit[73] = true;
        return b;
    }

    private Single<List<Store>> getSubscribedStores() {
        boolean[] $jacocoInit = $jacocoInit();
        GetMySubscribedStoresRequest getMySubscribedStoresRequest = new GetMySubscribedStoresRequest(this.bodyInterceptorPoolV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[74] = true;
        C0120S observe = getMySubscribedStoresRequest.observe();
        C1450t tVar = C1450t.f4372a;
        $jacocoInit[75] = true;
        C0120S j = observe.mo3669j(tVar);
        C1445o oVar = C1445o.f4367a;
        $jacocoInit[76] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) oVar);
        C1438h hVar = new C1438h(this);
        $jacocoInit[77] = true;
        C0120S j2 = h.mo3669j(hVar);
        $jacocoInit[78] = true;
        C0120S m = j2.mo3675m();
        $jacocoInit[79] = true;
        Single<List<Store>> n = m.mo3678n();
        $jacocoInit[80] = true;
        return n;
    }

    /* renamed from: a */
    static /* synthetic */ List m6173a(GetMySubscribedStoresResponse getUserRepoSubscription) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = getUserRepoSubscription.getDataList();
        $jacocoInit[108] = true;
        List list = dataList.getList();
        $jacocoInit[109] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m6171a(List list) {
        $jacocoInit()[107] = true;
        return list;
    }

    /* renamed from: a */
    public /* synthetic */ Store mo9581a(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        Store mapToStore = mapToStore(store);
        $jacocoInit[106] = true;
        return mapToStore;
    }

    private Store mapToStore(p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store store) {
        long j;
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (store == null) {
            $jacocoInit[81] = true;
            Store emptyStore = Store.emptyStore();
            $jacocoInit[82] = true;
            return emptyStore;
        }
        String str2 = p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.PUBLIC_ACCESS;
        $jacocoInit[83] = true;
        if (store.getStats() == null) {
            $jacocoInit[84] = true;
            j = 0;
        } else {
            Stats stats = store.getStats();
            $jacocoInit[85] = true;
            long downloads = stats.getDownloads();
            $jacocoInit[86] = true;
            j = downloads;
        }
        String avatar = store.getAvatar();
        long id = store.getId();
        String name = store.getName();
        $jacocoInit[87] = true;
        if (store.getAppearance() == null) {
            $jacocoInit[88] = true;
            str = "DEFAULT";
        } else {
            Appearance appearance = store.getAppearance();
            $jacocoInit[89] = true;
            String theme = appearance.getTheme();
            $jacocoInit[90] = true;
            str = theme;
        }
        Store store2 = new Store(j, avatar, id, name, str, null, null, p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.PUBLIC_ACCESS.equalsIgnoreCase(store.getAccess()));
        $jacocoInit[91] = true;
        return store2;
    }

    private Single<GetUserInfo> getServerAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        GetUserInfoRequest of = GetUserInfoRequest.m7467of(this.httpClient, this.converterFactory, this.bodyInterceptorWebV7, this.tokenInvalidator);
        $jacocoInit[92] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[93] = true;
        Single n = observe.mo3678n();
        C1448r rVar = C1448r.f4370a;
        $jacocoInit[94] = true;
        Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) rVar);
        C1439i iVar = new C1439i(this);
        $jacocoInit[95] = true;
        Single<GetUserInfo> g = a.mo3701g(iVar);
        $jacocoInit[96] = true;
        return g;
    }

    /* renamed from: a */
    static /* synthetic */ Single m6177a(GetUserInfo response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[103] = true;
            Single a = Single.m734a(response);
            $jacocoInit[104] = true;
            return a;
        }
        Single a2 = Single.m735a((Throwable) new Exception(C0044V7.getErrorMessage(response)));
        $jacocoInit[105] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo9582a(C0120S observableError) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = retryOnTicket(observableError).mo3636b((C0129b<? super T>) C1452v.f4374a);
        $jacocoInit[100] = true;
        return b;
    }

    /* renamed from: c */
    static /* synthetic */ void m6185c(Throwable __) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[101] = true;
        instance.mo2148w("AccountManagerService", "retryOnTicket() doOnNext()");
        $jacocoInit[102] = true;
    }

    private Single<TermsAndConditionsResponse> getTermsAndConditionsForAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        GetTermsAndConditionsStatusRequest of = GetTermsAndConditionsStatusRequest.m7449of(this.defaultBodyInterceptorV3, this.converterFactory, this.httpClient, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[97] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[98] = true;
        Single<TermsAndConditionsResponse> n = observe.mo3678n();
        $jacocoInit[99] = true;
        return n;
    }
}
