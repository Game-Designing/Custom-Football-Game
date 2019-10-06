package p005cm.aptoide.p006pt.download;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.Constants;
import p005cm.aptoide.p006pt.install.InstallAnalytics;

/* renamed from: cm.aptoide.pt.download.DownloadMirrorEventInterceptor */
public class DownloadMirrorEventInterceptor implements Interceptor {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final DownloadAnalytics downloadAnalytics;
    private final InstallAnalytics installAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1198366109698146253L, "cm/aptoide/pt/download/DownloadMirrorEventInterceptor", 20);
        $jacocoData = probes;
        return probes;
    }

    public DownloadMirrorEventInterceptor(DownloadAnalytics downloadAnalytics2, InstallAnalytics installAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAnalytics = downloadAnalytics2;
        this.installAnalytics = installAnalytics2;
        $jacocoInit[0] = true;
    }

    public Response intercept(Chain chain) throws IOException {
        boolean[] $jacocoInit = $jacocoInit();
        Request request = chain.request();
        $jacocoInit[1] = true;
        String str = Constants.VERSION_CODE;
        String versionCode = request.header(str);
        $jacocoInit[2] = true;
        String str2 = Constants.PACKAGE;
        String packageName = request.header(str2);
        $jacocoInit[3] = true;
        String str3 = Constants.FILE_TYPE;
        int fileType = Integer.parseInt(request.header(str3));
        $jacocoInit[4] = true;
        Builder newBuilder = request.newBuilder();
        $jacocoInit[5] = true;
        Builder removeHeader = newBuilder.removeHeader(str);
        $jacocoInit[6] = true;
        Builder removeHeader2 = removeHeader.removeHeader(str2);
        $jacocoInit[7] = true;
        Builder removeHeader3 = removeHeader2.removeHeader(str3);
        $jacocoInit[8] = true;
        Request build = removeHeader3.build();
        $jacocoInit[9] = true;
        Response response = chain.proceed(build);
        if (response == null) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            Headers allHeaders = response.headers();
            if (allHeaders == null) {
                $jacocoInit[12] = true;
            } else {
                $jacocoInit[13] = true;
                String mirror = allHeaders.get("X-Mirror");
                $jacocoInit[14] = true;
                HttpUrl url = request.url();
                $jacocoInit[15] = true;
                String url2 = url.toString();
                $jacocoInit[16] = true;
                String url3 = url2;
                this.downloadAnalytics.updateDownloadEvent(versionCode, packageName, fileType, mirror, url2);
                $jacocoInit[17] = true;
                this.installAnalytics.updateInstallEvents(Integer.valueOf(versionCode).intValue(), packageName, fileType, url3);
                $jacocoInit[18] = true;
            }
        }
        $jacocoInit[19] = true;
        return response;
    }
}
