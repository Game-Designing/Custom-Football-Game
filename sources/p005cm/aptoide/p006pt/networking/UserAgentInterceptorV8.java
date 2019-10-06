package p005cm.aptoide.p006pt.networking;

import android.util.DisplayMetrics;
import okhttp3.Interceptor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.UserAgentInterceptorV8 */
public class UserAgentInterceptorV8 implements Interceptor {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String androidVersion;
    private final int apiLevel;
    private final String aptoideMd5;
    private final String aptoidePackage;
    private final int aptoideVersionCode;
    private final String architecture;
    private final AuthenticationPersistence authenticationPersistence;
    private final DisplayMetrics displayMetrics;
    private final IdsRepository idsRepository;
    private final String model;
    private final String productCode;
    private final String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2161016385053163766L, "cm/aptoide/pt/networking/UserAgentInterceptorV8", 33);
        $jacocoData = probes;
        return probes;
    }

    public UserAgentInterceptorV8(IdsRepository idsRepository2, String androidVersion2, int apiLevel2, String model2, String productCode2, String architecture2, DisplayMetrics displayMetrics2, String versionName2, String aptoidePackage2, String aptoideMd52, int aptoideVersionCode2, AuthenticationPersistence authenticationPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository = idsRepository2;
        this.androidVersion = androidVersion2;
        this.apiLevel = apiLevel2;
        this.model = model2;
        this.productCode = productCode2;
        this.architecture = architecture2;
        this.displayMetrics = displayMetrics2;
        this.versionName = versionName2;
        this.aptoidePackage = aptoidePackage2;
        this.aptoideMd5 = aptoideMd52;
        this.aptoideVersionCode = aptoideVersionCode2;
        this.authenticationPersistence = authenticationPersistence2;
        $jacocoInit[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0050 A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055 A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065 A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085 A[Catch:{ IOException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[Catch:{ IOException -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean[] r0 = $jacocoInit()
            okhttp3.Request r1 = r9.request()
            r2 = 1
            r3 = 0
            r0[r2] = r2     // Catch:{ Exception -> 0x0017 }
            java.lang.String r4 = r8.getDefaultUserAgent()     // Catch:{ Exception -> 0x0015 }
            r3 = r4
            r4 = 2
            r0[r4] = r2
            goto L_0x0028
        L_0x0015:
            r4 = move-exception
            goto L_0x0018
        L_0x0017:
            r4 = move-exception
        L_0x0018:
            r5 = 3
            r0[r5] = r2
            cm.aptoide.pt.crashreports.CrashReport r5 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r6 = 4
            r0[r6] = r2
            r5.log(r4)
            r5 = 5
            r0[r5] = r2     // Catch:{ IOException -> 0x00b6 }
        L_0x0028:
            cm.aptoide.pt.networking.AuthenticationPersistence r4 = r8.authenticationPersistence     // Catch:{ IOException -> 0x00b6 }
            rx.Single r4 = r4.getAuthentication()     // Catch:{ IOException -> 0x00b6 }
            r5 = 6
            r0[r5] = r2     // Catch:{ IOException -> 0x00b6 }
            rx.g.b r4 = r4.mo3689a()     // Catch:{ IOException -> 0x00b6 }
            r5 = 7
            r0[r5] = r2     // Catch:{ IOException -> 0x00b6 }
            java.lang.Object r4 = r4.mo46175a()     // Catch:{ IOException -> 0x00b6 }
            cm.aptoide.pt.networking.Authentication r4 = (p005cm.aptoide.p006pt.networking.Authentication) r4     // Catch:{ IOException -> 0x00b6 }
            r5 = 8
            r0[r5] = r2     // Catch:{ IOException -> 0x00b6 }
            okhttp3.Request$Builder r5 = r1.newBuilder()     // Catch:{ IOException -> 0x00b6 }
            r6 = 9
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
            boolean r6 = r4.isAuthenticated()     // Catch:{ IOException -> 0x00b6 }
            if (r6 == 0) goto L_0x0055
            r6 = 10
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
            goto L_0x005f
        L_0x0055:
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x00b6 }
            if (r6 != 0) goto L_0x00a9
            r6 = 11
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
        L_0x005f:
            boolean r6 = r4.isAuthenticated()     // Catch:{ IOException -> 0x00b6 }
            if (r6 != 0) goto L_0x006a
            r6 = 12
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
            goto L_0x007f
        L_0x006a:
            r6 = 13
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r6 = r4.getAccessToken()     // Catch:{ IOException -> 0x00b6 }
            r7 = 14
            r0[r7] = r2     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r7 = "AUTHORIZATION"
            r5.header(r7, r6)     // Catch:{ IOException -> 0x00b6 }
            r7 = 15
            r0[r7] = r2     // Catch:{ IOException -> 0x00b6 }
        L_0x007f:
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x00b6 }
            if (r6 == 0) goto L_0x008a
            r6 = 16
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
            goto L_0x0097
        L_0x008a:
            r6 = 17
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r6 = "User-Agent"
            r5.header(r6, r3)     // Catch:{ IOException -> 0x00b6 }
            r6 = 18
            r0[r6] = r2     // Catch:{ IOException -> 0x00b6 }
        L_0x0097:
            okhttp3.Request r6 = r5.build()     // Catch:{ IOException -> 0x00b6 }
            r7 = 19
            r0[r7] = r2     // Catch:{ IOException -> 0x00b6 }
            okhttp3.Response r7 = r9.proceed(r6)     // Catch:{ IOException -> 0x00b6 }
            r6 = r7
            r7 = 20
            r0[r7] = r2     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00b1
        L_0x00a9:
            okhttp3.Response r6 = r9.proceed(r1)     // Catch:{ IOException -> 0x00b6 }
            r7 = 21
            r0[r7] = r2     // Catch:{ IOException -> 0x00b6 }
        L_0x00b1:
            r7 = 22
            r0[r7] = r2
            return r6
        L_0x00b6:
            r4 = move-exception
            r5 = 23
            r0[r5] = r2
            cm.aptoide.pt.crashreports.CrashReport r5 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r6 = 24
            r0[r6] = r2
            r5.log(r4)
            r5 = 25
            r0[r5] = r2
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.networking.UserAgentInterceptorV8.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public String getDefaultUserAgent() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(this.displayMetrics.widthPixels);
        sb.append("x");
        sb.append(this.displayMetrics.heightPixels);
        String myscr = sb.toString();
        $jacocoInit[26] = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Aptoide/");
        sb2.append(this.versionName);
        sb2.append(" (Linux; Android ");
        sb2.append(this.androidVersion);
        String str = "; ";
        sb2.append(str);
        sb2.append(this.apiLevel);
        sb2.append(str);
        sb2.append(this.model);
        sb2.append(" Build/");
        sb2.append(this.productCode);
        sb2.append(str);
        sb2.append(this.architecture);
        sb2.append(str);
        sb2.append(this.aptoidePackage);
        sb2.append(str);
        sb2.append(this.aptoideVersionCode);
        sb2.append(str);
        sb2.append(this.aptoideMd5);
        sb2.append(str);
        sb2.append(myscr);
        sb2.append(str);
        StringBuilder sb3 = new StringBuilder(sb2.toString());
        $jacocoInit[27] = true;
        String uniqueIdentifier = this.idsRepository.getUniqueIdentifier();
        if (uniqueIdentifier == null) {
            $jacocoInit[28] = true;
        } else {
            $jacocoInit[29] = true;
            sb3.append(uniqueIdentifier);
            $jacocoInit[30] = true;
        }
        sb3.append(")");
        $jacocoInit[31] = true;
        String sb4 = sb3.toString();
        $jacocoInit[32] = true;
        return sb4;
    }
}
