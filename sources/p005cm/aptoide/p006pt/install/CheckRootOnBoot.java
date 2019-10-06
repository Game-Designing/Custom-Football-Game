package p005cm.aptoide.p006pt.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p026rx.C0117M;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.install.CheckRootOnBoot */
public class CheckRootOnBoot extends BroadcastReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String HTC_BOOT_COMPLETED = "android.intent.action.QUICKBOOT_POWERON";
    private CrashReport crashReport;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4232464843239016205L, "cm/aptoide/pt/install/CheckRootOnBoot", 17);
        $jacocoData = probes;
        return probes;
    }

    public CheckRootOnBoot() {
        $jacocoInit()[0] = true;
    }

    public void onReceive(Context context, Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport = CrashReport.getInstance();
        $jacocoInit[1] = true;
        if (intent == null) {
            $jacocoInit[2] = true;
        } else {
            String action = intent.getAction();
            $jacocoInit[3] = true;
            if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                $jacocoInit[4] = true;
            } else {
                String action2 = intent.getAction();
                $jacocoInit[5] = true;
                if (action2.equals("android.intent.action.REBOOT")) {
                    $jacocoInit[6] = true;
                } else {
                    String action3 = intent.getAction();
                    $jacocoInit[7] = true;
                    if (!action3.equals(HTC_BOOT_COMPLETED)) {
                        $jacocoInit[8] = true;
                    } else {
                        $jacocoInit[9] = true;
                    }
                }
            }
            RootAvailabilityManager rootAvailabilityManager = ((AptoideApplication) context.getApplicationContext()).getRootAvailabilityManager();
            $jacocoInit[10] = true;
            C0117M updateRootAvailability = rootAvailabilityManager.updateRootAvailability();
            $jacocoInit[11] = true;
            C0117M b = updateRootAvailability.mo3593b(Schedulers.computation());
            C4030b bVar = C4030b.f7529a;
            C4027a aVar = new C4027a(this);
            $jacocoInit[12] = true;
            b.mo3588a((C0128a) bVar, (C0129b<? super Throwable>) aVar);
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8533a() {
        $jacocoInit()[16] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14974a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[15] = true;
    }
}
