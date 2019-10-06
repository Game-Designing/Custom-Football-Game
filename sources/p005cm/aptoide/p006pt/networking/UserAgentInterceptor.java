package p005cm.aptoide.p006pt.networking;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import okhttp3.Interceptor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.UserAgentInterceptor */
public class UserAgentInterceptor implements Interceptor {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final DisplayMetrics displayMetrics;
    private final IdsRepository idsRepository;
    private final String oemid;
    private final String terminalInfo;
    private final String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2047978577248031306L, "cm/aptoide/pt/networking/UserAgentInterceptor", 27);
        $jacocoData = probes;
        return probes;
    }

    public UserAgentInterceptor(IdsRepository idsRepository2, String oemid2, DisplayMetrics displayMetrics2, String terminalInfo2, String versionName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idsRepository = idsRepository2;
        this.oemid = oemid2;
        this.displayMetrics = displayMetrics2;
        this.terminalInfo = terminalInfo2;
        this.versionName = versionName2;
        $jacocoInit[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[Catch:{ IOException -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ IOException -> 0x0061 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean[] r0 = $jacocoInit()
            okhttp3.Request r1 = r8.request()
            r2 = 1
            r3 = 0
            r0[r2] = r2     // Catch:{ Exception -> 0x0017 }
            java.lang.String r4 = r7.getDefaultUserAgent()     // Catch:{ Exception -> 0x0015 }
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
            r0[r5] = r2     // Catch:{ IOException -> 0x0061 }
        L_0x0028:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0061 }
            if (r4 != 0) goto L_0x0054
            r4 = 6
            r0[r4] = r2     // Catch:{ IOException -> 0x0061 }
            okhttp3.Request$Builder r4 = r1.newBuilder()     // Catch:{ IOException -> 0x0061 }
            java.lang.String r5 = "User-Agent"
            r6 = 7
            r0[r6] = r2     // Catch:{ IOException -> 0x0061 }
            okhttp3.Request$Builder r4 = r4.header(r5, r3)     // Catch:{ IOException -> 0x0061 }
            r5 = 8
            r0[r5] = r2     // Catch:{ IOException -> 0x0061 }
            okhttp3.Request r4 = r4.build()     // Catch:{ IOException -> 0x0061 }
            r5 = 9
            r0[r5] = r2     // Catch:{ IOException -> 0x0061 }
            okhttp3.Response r5 = r8.proceed(r4)     // Catch:{ IOException -> 0x0061 }
            r4 = r5
            r5 = 10
            r0[r5] = r2     // Catch:{ IOException -> 0x0061 }
            goto L_0x005c
        L_0x0054:
            okhttp3.Response r4 = r8.proceed(r1)     // Catch:{ IOException -> 0x0061 }
            r5 = 11
            r0[r5] = r2     // Catch:{ IOException -> 0x0061 }
        L_0x005c:
            r5 = 12
            r0[r5] = r2
            return r4
        L_0x0061:
            r4 = move-exception
            r5 = 13
            r0[r5] = r2
            cm.aptoide.pt.crashreports.CrashReport r5 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r6 = 14
            r0[r6] = r2
            r5.log(r4)
            r5 = 15
            r0[r5] = r2
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.networking.UserAgentInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private String getDefaultUserAgent() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(this.displayMetrics.widthPixels);
        sb.append("x");
        sb.append(this.displayMetrics.heightPixels);
        String screen = sb.toString();
        $jacocoInit[16] = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.versionName);
        String str = ";";
        sb2.append(str);
        sb2.append(this.terminalInfo);
        sb2.append(str);
        sb2.append(screen);
        sb2.append(";id:");
        StringBuilder sb3 = new StringBuilder(sb2.toString());
        $jacocoInit[17] = true;
        String uniqueIdentifier = this.idsRepository.getUniqueIdentifier();
        if (uniqueIdentifier == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            sb3.append(uniqueIdentifier);
            $jacocoInit[20] = true;
        }
        sb3.append(str);
        $jacocoInit[21] = true;
        sb3.append(str);
        $jacocoInit[22] = true;
        if (TextUtils.isEmpty(this.oemid)) {
            $jacocoInit[23] = true;
        } else {
            $jacocoInit[24] = true;
            sb3.append(this.oemid);
            $jacocoInit[25] = true;
        }
        String sb4 = sb3.toString();
        $jacocoInit[26] = true;
        return sb4;
    }
}
