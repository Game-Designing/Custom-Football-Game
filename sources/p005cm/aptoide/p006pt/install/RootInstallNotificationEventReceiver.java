package p005cm.aptoide.p006pt.install;

import android.content.BroadcastReceiver;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;

/* renamed from: cm.aptoide.pt.install.RootInstallNotificationEventReceiver */
public class RootInstallNotificationEventReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ROOT_INSTALL_DISMISS_ACTION = "cm.aptoide.pt.ROOT_INSTALL_DISMISS_ACTION";
    public static final String ROOT_INSTALL_RETRY_ACTION = "cm.aptoide.pt.ROOT_INSTALL_RETRY_ACTION";
    private static final String TAG = RootInstallNotificationEventReceiver.class.getSimpleName();
    private CrashReport crashReport;
    private InstallManager installManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6428941815294034137L, "cm/aptoide/pt/install/RootInstallNotificationEventReceiver", 23);
        $jacocoData = probes;
        return probes;
    }

    public RootInstallNotificationEventReceiver() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[22] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            android.content.Context r1 = r7.getApplicationContext()
            cm.aptoide.pt.AptoideApplication r1 = (p005cm.aptoide.p006pt.AptoideApplication) r1
            cm.aptoide.pt.install.InstallManager r1 = r1.getInstallManager()
            r6.installManager = r1
            r1 = 1
            r0[r1] = r1
            cm.aptoide.pt.crashreports.CrashReport r2 = p005cm.aptoide.p006pt.crashreports.CrashReport.getInstance()
            r6.crashReport = r2
            r2 = 2
            r0[r2] = r1
            if (r8 != 0) goto L_0x0023
            r2 = 3
            r0[r2] = r1
            goto L_0x00ab
        L_0x0023:
            java.lang.String r2 = r8.getAction()
            if (r2 != 0) goto L_0x002e
            r2 = 4
            r0[r2] = r1
            goto L_0x00ab
        L_0x002e:
            r2 = 5
            r0[r2] = r1
            java.lang.String r2 = r8.getAction()
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 47707700(0x2d7f634, float:3.1732724E-37)
            if (r4 == r5) goto L_0x005a
            r5 = 294214294(0x11895a96, float:2.1670617E-28)
            if (r4 == r5) goto L_0x0048
            r2 = 6
            r0[r2] = r1
            goto L_0x0066
        L_0x0048:
            java.lang.String r4 = "cm.aptoide.pt.ROOT_INSTALL_RETRY_ACTION"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0054
            r2 = 7
            r0[r2] = r1
            goto L_0x0066
        L_0x0054:
            r2 = 0
            r3 = 8
            r0[r3] = r1
            goto L_0x006d
        L_0x005a:
            java.lang.String r4 = "cm.aptoide.pt.ROOT_INSTALL_DISMISS_ACTION"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0068
            r2 = 9
            r0[r2] = r1
        L_0x0066:
            r2 = -1
            goto L_0x006d
        L_0x0068:
            r2 = 10
            r0[r2] = r1
            r2 = 1
        L_0x006d:
            if (r2 == 0) goto L_0x007b
            if (r2 == r1) goto L_0x0076
            r2 = 11
            r0[r2] = r1
            goto L_0x00ab
        L_0x0076:
            r2 = 12
            r0[r2] = r1
            goto L_0x0093
        L_0x007b:
            cm.aptoide.pt.install.InstallManager r2 = r6.installManager
            rx.M r2 = r2.retryTimedOutInstallations()
            cm.aptoide.pt.install.ib r3 = p005cm.aptoide.p006pt.install.C4053ib.f7559a
            cm.aptoide.pt.install.hb r4 = new cm.aptoide.pt.install.hb
            r4.<init>(r6)
            r5 = 13
            r0[r5] = r1
            r2.mo3588a(r3, r4)
            r2 = 14
            r0[r2] = r1
        L_0x0093:
            cm.aptoide.pt.install.InstallManager r2 = r6.installManager
            rx.M r2 = r2.cleanTimedOutInstalls()
            cm.aptoide.pt.install.gb r3 = p005cm.aptoide.p006pt.install.C4047gb.f7552a
            cm.aptoide.pt.install.fb r4 = new cm.aptoide.pt.install.fb
            r4.<init>(r6)
            r5 = 15
            r0[r5] = r1
            r2.mo3588a(r3, r4)
            r2 = 16
            r0[r2] = r1
        L_0x00ab:
            r2 = 17
            r0[r2] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.install.RootInstallNotificationEventReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m8576a() {
        $jacocoInit()[21] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15085a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[20] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8577b() {
        $jacocoInit()[19] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15086b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[18] = true;
    }
}
