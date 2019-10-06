package p005cm.aptoide.p006pt.autoupdate;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateManager$requestPermissions$1 */
/* compiled from: AutoUpdateManager.kt */
final class AutoUpdateManager$requestPermissions$1<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ PermissionService $permissionService;
    final /* synthetic */ AutoUpdateManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7797578297923354441L, "cm/aptoide/pt/autoupdate/AutoUpdateManager$requestPermissions$1", 3);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateManager$requestPermissions$1(AutoUpdateManager autoUpdateManager, PermissionService permissionService) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateManager;
        this.$permissionService = permissionService;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((Void) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<Void> call(Void it) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> requestExternalStoragePermission = AutoUpdateManager.access$getPermissionManager$p(this.this$0).requestExternalStoragePermission(this.$permissionService);
        $jacocoInit[1] = true;
        return requestExternalStoragePermission;
    }
}
