package p005cm.aptoide.p006pt.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksTargets;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferences;

/* renamed from: cm.aptoide.pt.util.ApkFy */
public class ApkFy {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String TAG = "ApkFy";
    private final Context context;
    private final Intent intent;
    private final SharedPreferences securePreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-165829019574811236L, "cm/aptoide/pt/util/ApkFy", 34);
        $jacocoData = probes;
        return probes;
    }

    public ApkFy(Context context2, Intent intent2, SharedPreferences securePreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.intent = intent2;
        this.securePreferences = securePreferences2;
        $jacocoInit[0] = true;
    }

    public void run() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!SecurePreferences.shouldRunApkFy(this.securePreferences)) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            Long appId = extractAppId(this.context);
            if (appId == null) {
                $jacocoInit[3] = true;
            } else {
                $jacocoInit[4] = true;
                this.intent.putExtra(DeepLinksTargets.APP_VIEW_FRAGMENT, true);
                $jacocoInit[5] = true;
                this.intent.putExtra("appId", appId);
                $jacocoInit[6] = true;
                this.intent.putExtra(DeepLinksKeys.APK_FY, true);
                $jacocoInit[7] = true;
            }
            SecurePreferences.setApkFyRun(this.securePreferences);
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Long extractAppId(android.content.Context r13) {
        /*
            r12 = this;
            java.lang.String r0 = "downloadId"
            boolean[] r1 = $jacocoInit()
            r2 = 10
            r3 = 0
            r4 = 1
            r1[r2] = r4     // Catch:{ Exception -> 0x0089 }
            r2 = r3
            android.content.pm.PackageManager r5 = r13.getPackageManager()     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = "cm.aptoide.pt"
            r7 = 0
            r8 = 11
            r1[r8] = r4     // Catch:{ Exception -> 0x0087 }
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r7)     // Catch:{ Exception -> 0x0087 }
            android.content.pm.ApplicationInfo r5 = r5.applicationInfo     // Catch:{ Exception -> 0x0087 }
            java.lang.String r5 = r5.sourceDir     // Catch:{ Exception -> 0x0087 }
            r6 = 12
            r1[r6] = r4     // Catch:{ Exception -> 0x0087 }
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x0087 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0087 }
            r7 = 13
            r1[r7] = r4     // Catch:{ Exception -> 0x0087 }
            java.lang.String r7 = "META-INF/aob"
            java.util.zip.ZipEntry r7 = r6.getEntry(r7)     // Catch:{ Exception -> 0x0087 }
            if (r7 == 0) goto L_0x0082
            r8 = 14
            r1[r8] = r4     // Catch:{ Exception -> 0x0087 }
            java.io.InputStream r8 = r6.getInputStream(r7)     // Catch:{ Exception -> 0x0087 }
            r9 = 15
            r1[r9] = r4     // Catch:{ Exception -> 0x0087 }
            java.util.Properties r9 = new java.util.Properties     // Catch:{ Exception -> 0x0087 }
            r9.<init>()     // Catch:{ Exception -> 0x0087 }
            r10 = 16
            r1[r10] = r4     // Catch:{ Exception -> 0x0087 }
            r9.load(r8)     // Catch:{ Exception -> 0x0087 }
            r10 = 17
            r1[r10] = r4     // Catch:{ Exception -> 0x0087 }
            boolean r10 = r9.containsKey(r0)     // Catch:{ Exception -> 0x0087 }
            if (r10 != 0) goto L_0x005c
            r0 = 18
            r1[r0] = r4     // Catch:{ Exception -> 0x0087 }
            goto L_0x0069
        L_0x005c:
            r10 = 19
            r1[r10] = r4     // Catch:{ Exception -> 0x0087 }
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ Exception -> 0x0087 }
            r2 = r0
            r0 = 20
            r1[r0] = r4     // Catch:{ Exception -> 0x0087 }
        L_0x0069:
            if (r2 == 0) goto L_0x0078
            long r10 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.Long r0 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x0087 }
            r10 = 21
            r1[r10] = r4     // Catch:{ Exception -> 0x0087 }
            goto L_0x007d
        L_0x0078:
            r0 = 22
            r1[r0] = r4     // Catch:{ Exception -> 0x0087 }
            r0 = r3
        L_0x007d:
            r3 = 23
            r1[r3] = r4
            return r0
        L_0x0082:
            r0 = 24
            r1[r0] = r4
            goto L_0x00cb
        L_0x0087:
            r0 = move-exception
            goto L_0x008b
        L_0x0089:
            r0 = move-exception
            r2 = r3
        L_0x008b:
            if (r2 != 0) goto L_0x0092
            r5 = 25
            r1[r5] = r4
            goto L_0x00a7
        L_0x0092:
            r5 = 26
            r1[r5] = r4
            cm.aptoide.pt.crashreports.CrashReport r5 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r6 = 27
            r1[r6] = r4
            java.lang.String r6 = "APKFY_APP_ID"
            r5.log(r6, r2)
            r5 = 28
            r1[r5] = r4
        L_0x00a7:
            cm.aptoide.pt.logger.Logger r5 = p005cm.aptoide.p006pt.logger.Logger.getInstance()
            r6 = 29
            r1[r6] = r4
            java.lang.String r6 = r0.getMessage()
            java.lang.String r7 = "ApkFy"
            r5.mo2136d(r7, r6)
            r5 = 30
            r1[r5] = r4
            cm.aptoide.pt.crashreports.CrashReport r5 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r6 = 31
            r1[r6] = r4
            r5.log(r0)
            r5 = 32
            r1[r5] = r4
        L_0x00cb:
            r0 = 33
            r1[r0] = r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.util.ApkFy.extractAppId(android.content.Context):java.lang.Long");
    }
}
