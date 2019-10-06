package p005cm.aptoide.p006pt.networking;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountException;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV3Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.OAuth;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.OAuth2AuthenticationRequest;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.p028h.C14963c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.networking.RefreshTokenInvalidator */
public class RefreshTokenInvalidator implements TokenInvalidator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int MAX_REFRESH_TOKEN_RETRIES = 3;
    private final AuthenticationPersistence authenticationPersistence;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final String extraId;
    private final OkHttpClient httpClient;
    private final C14963c<Void> logoutSubject;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7081940545375257991L, "cm/aptoide/pt/networking/RefreshTokenInvalidator", 21);
        $jacocoData = probes;
        return probes;
    }

    public RefreshTokenInvalidator(BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient httpClient2, Factory converterFactory2, SharedPreferences sharedPreferences2, String extraId2, TokenInvalidator tokenInvalidator2, AuthenticationPersistence authenticationPersistence2, C14963c<Void> logoutSubject2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptor = bodyInterceptor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.sharedPreferences = sharedPreferences2;
        this.extraId = extraId2;
        this.tokenInvalidator = tokenInvalidator2;
        this.authenticationPersistence = authenticationPersistence2;
        this.logoutSubject = logoutSubject2;
        $jacocoInit[0] = true;
    }

    public C14963c<Void> getLogoutSubject() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.logoutSubject;
        $jacocoInit[1] = true;
        return cVar;
    }

    public C0117M invalidateAccessToken() {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C4154k kVar = new C4154k(this);
        $jacocoInit[2] = true;
        C0117M b = authentication.mo3693b((C0132p<? super T, ? extends C0117M>) kVar);
        C4151i iVar = new C4151i(this);
        $jacocoInit[3] = true;
        C0117M c = b.mo3601c((C0132p<? super C0120S<? extends Throwable>, ? extends C0120S<?>>) iVar);
        $jacocoInit[4] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15229a(Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        OAuth2AuthenticationRequest of = OAuth2AuthenticationRequest.m7451of(authentication.getRefreshToken(), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.extraId);
        $jacocoInit[14] = true;
        C0120S observe = of.observe();
        $jacocoInit[15] = true;
        Single n = observe.mo3678n();
        C4155l lVar = new C4155l(this);
        $jacocoInit[16] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) lVar);
        $jacocoInit[17] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15228a(OAuth oAuth) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!oAuth.hasErrors()) {
            $jacocoInit[18] = true;
            C0117M updateAuthentication = this.authenticationPersistence.updateAuthentication(oAuth.getAccessToken());
            $jacocoInit[19] = true;
            return updateAuthentication;
        }
        C0117M b = C0117M.m591b((Throwable) new AccountException(oAuth));
        $jacocoInit[20] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15231a(C0120S errObservable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = errObservable.mo3615a(C0120S.m626a(1, 3), (C14541q<? super T, ? super T2, ? extends R>) new C4153j<Object,Object,Object>(this));
        $jacocoInit[5] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15230a(Throwable throwable, Integer i) {
        boolean[] $jacocoInit = $jacocoInit();
        if (i.intValue() < 3) {
            if (!(throwable instanceof AptoideWsV3Exception)) {
                $jacocoInit[6] = true;
            } else {
                $jacocoInit[7] = true;
                return null;
            }
        } else if (!(throwable instanceof AptoideWsV3Exception)) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            this.logoutSubject.onNext(null);
            $jacocoInit[10] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[11] = true;
            return b;
        }
        this.logoutSubject.onNext(null);
        $jacocoInit[12] = true;
        C0117M b2 = C0117M.m591b(throwable);
        $jacocoInit[13] = true;
        return b2;
    }
}
