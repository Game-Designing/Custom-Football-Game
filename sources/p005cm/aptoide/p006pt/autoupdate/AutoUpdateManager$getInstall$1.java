package p005cm.aptoide.p006pt.autoupdate;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.InstallManager;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateManager$getInstall$1 */
/* compiled from: AutoUpdateManager.kt */
final class AutoUpdateManager$getInstall$1<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ AutoUpdateManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3756425575624003985L, "cm/aptoide/pt/autoupdate/AutoUpdateManager$getInstall$1", 6);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateManager$getInstall$1(AutoUpdateManager autoUpdateManager) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateManager;
        $jacocoInit[5] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((AutoUpdateModel) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<Install> call(AutoUpdateModel it) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager access$getInstallManager$p = AutoUpdateManager.access$getInstallManager$p(this.this$0);
        String md5 = it.getMd5();
        $jacocoInit[1] = true;
        String packageName = it.getPackageName();
        int versionCode = it.getVersionCode();
        $jacocoInit[2] = true;
        C0120S install = access$getInstallManager$p.getInstall(md5, packageName, versionCode);
        $jacocoInit[3] = true;
        C0120S<Install> e = install.mo3658e((C0132p<? super T, Boolean>) C22791.INSTANCE);
        $jacocoInit[4] = true;
        return e;
    }
}
