package p005cm.aptoide.p006pt.download;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.networking.Authentication;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p026rx.Single;
import p026rx.p401g.C14959b;

/* renamed from: cm.aptoide.pt.download.PaidAppsDownloadInterceptor */
public class PaidAppsDownloadInterceptor implements Interceptor {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthenticationPersistence authenticationPersistence;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5746212820356822440L, "cm/aptoide/pt/download/PaidAppsDownloadInterceptor", 17);
        $jacocoData = probes;
        return probes;
    }

    public PaidAppsDownloadInterceptor(AuthenticationPersistence authenticationPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authenticationPersistence = authenticationPersistence2;
        $jacocoInit[0] = true;
    }

    public Response intercept(Chain chain) throws IOException {
        boolean[] $jacocoInit = $jacocoInit();
        Request request = chain.request();
        $jacocoInit[1] = true;
        HttpUrl url = request.url();
        $jacocoInit[2] = true;
        String host = url.host();
        $jacocoInit[3] = true;
        if (!host.contains(BuildConfig.APTOIDE_WEB_SERVICES_HOST)) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            Single authentication = this.authenticationPersistence.getAuthentication();
            $jacocoInit[6] = true;
            C14959b a = authentication.mo3689a();
            $jacocoInit[7] = true;
            Authentication account = (Authentication) a.mo46175a();
            $jacocoInit[8] = true;
            if (!account.isAuthenticated()) {
                $jacocoInit[9] = true;
            } else {
                $jacocoInit[10] = true;
                Builder newBuilder = request.newBuilder();
                $jacocoInit[11] = true;
                MediaType parse = MediaType.parse("application/json");
                StringBuilder sb = new StringBuilder();
                sb.append("{\"access_token\" : \"");
                $jacocoInit[12] = true;
                sb.append(account.getAccessToken());
                sb.append("\"}");
                String sb2 = sb.toString();
                $jacocoInit[13] = true;
                Builder post = newBuilder.post(RequestBody.create(parse, sb2));
                $jacocoInit[14] = true;
                request = post.build();
                $jacocoInit[15] = true;
            }
        }
        Response proceed = chain.proceed(request);
        $jacocoInit[16] = true;
        return proceed;
    }
}
