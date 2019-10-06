package p005cm.aptoide.p006pt.networking;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p401g.C14959b;

/* renamed from: cm.aptoide.pt.networking.Pnp1AuthorizationInterceptor */
public class Pnp1AuthorizationInterceptor implements Interceptor {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACCESS_TOKEN_KEY = "access_token";
    private final AuthenticationPersistence authenticationPersistence;
    private long timeStamp = 0;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-281659756788682433L, "cm/aptoide/pt/networking/Pnp1AuthorizationInterceptor", 41);
        $jacocoData = probes;
        return probes;
    }

    public Pnp1AuthorizationInterceptor(AuthenticationPersistence authenticationPersistence2, TokenInvalidator tokenInvalidator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authenticationPersistence = authenticationPersistence2;
        this.tokenInvalidator = tokenInvalidator2;
        $jacocoInit[0] = true;
    }

    public Response intercept(Chain chain) throws IOException {
        boolean[] $jacocoInit = $jacocoInit();
        Request request = chain.request();
        $jacocoInit[1] = true;
        Single authentication = this.authenticationPersistence.getAuthentication();
        $jacocoInit[2] = true;
        C14959b a = authentication.mo3689a();
        $jacocoInit[3] = true;
        Authentication authentication2 = (Authentication) a.mo46175a();
        $jacocoInit[4] = true;
        String str = "access_token";
        if (!authentication2.isAuthenticated()) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            HttpUrl url = request.url();
            $jacocoInit[7] = true;
            Builder newBuilder = url.newBuilder();
            AuthenticationPersistence authenticationPersistence2 = this.authenticationPersistence;
            $jacocoInit[8] = true;
            Single authentication3 = authenticationPersistence2.getAuthentication();
            $jacocoInit[9] = true;
            C14959b a2 = authentication3.mo3689a();
            $jacocoInit[10] = true;
            Authentication authentication4 = (Authentication) a2.mo46175a();
            $jacocoInit[11] = true;
            String accessToken = authentication4.getAccessToken();
            $jacocoInit[12] = true;
            Builder addQueryParameter = newBuilder.addQueryParameter(str, accessToken);
            $jacocoInit[13] = true;
            HttpUrl url2 = addQueryParameter.build();
            $jacocoInit[14] = true;
            Request.Builder newBuilder2 = request.newBuilder();
            $jacocoInit[15] = true;
            Request.Builder url3 = newBuilder2.url(url2);
            $jacocoInit[16] = true;
            request = url3.build();
            $jacocoInit[17] = true;
        }
        Response response = chain.proceed(request);
        $jacocoInit[18] = true;
        if (response.code() != 401) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            invalidateToken();
            $jacocoInit[21] = true;
            HttpUrl url4 = request.url();
            $jacocoInit[22] = true;
            Builder newBuilder3 = url4.newBuilder();
            AuthenticationPersistence authenticationPersistence3 = this.authenticationPersistence;
            $jacocoInit[23] = true;
            Single authentication5 = authenticationPersistence3.getAuthentication();
            $jacocoInit[24] = true;
            C14959b a3 = authentication5.mo3689a();
            $jacocoInit[25] = true;
            Authentication authentication6 = (Authentication) a3.mo46175a();
            $jacocoInit[26] = true;
            String accessToken2 = authentication6.getAccessToken();
            $jacocoInit[27] = true;
            Builder queryParameter = newBuilder3.setQueryParameter(str, accessToken2);
            $jacocoInit[28] = true;
            HttpUrl url5 = queryParameter.build();
            $jacocoInit[29] = true;
            Request.Builder newBuilder4 = request.newBuilder();
            $jacocoInit[30] = true;
            Request.Builder url6 = newBuilder4.url(url5);
            $jacocoInit[31] = true;
            Request invalidatedRequest = url6.build();
            $jacocoInit[32] = true;
            response = chain.proceed(invalidatedRequest);
            $jacocoInit[33] = true;
        }
        $jacocoInit[34] = true;
        return response;
    }

    private synchronized void invalidateToken() {
        boolean[] $jacocoInit = $jacocoInit();
        if (System.currentTimeMillis() - this.timeStamp <= 5000) {
            $jacocoInit[35] = true;
        } else {
            $jacocoInit[36] = true;
            C0117M invalidateAccessToken = this.tokenInvalidator.invalidateAccessToken();
            $jacocoInit[37] = true;
            invalidateAccessToken.mo3589a();
            $jacocoInit[38] = true;
            this.timeStamp = System.currentTimeMillis();
            $jacocoInit[39] = true;
        }
        $jacocoInit[40] = true;
    }
}
