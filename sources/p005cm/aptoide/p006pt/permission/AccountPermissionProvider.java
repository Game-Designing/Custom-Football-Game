package p005cm.aptoide.p006pt.permission;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.permission.PermissionProvider.Permission;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.permission.AccountPermissionProvider */
public class AccountPermissionProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final PermissionProvider permissionProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(533974704549259602L, "cm/aptoide/pt/permission/AccountPermissionProvider", 4);
        $jacocoData = probes;
        return probes;
    }

    public AccountPermissionProvider(PermissionProvider permissionProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.permissionProvider = permissionProvider2;
        $jacocoInit[0] = true;
    }

    public void requestCameraPermission(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.permissionProvider.providePermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, requestCode);
        $jacocoInit[1] = true;
    }

    public void requestGalleryPermission(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.permissionProvider.providePermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, requestCode);
        $jacocoInit[2] = true;
    }

    public C0120S<List<Permission>> permissionResultCamera(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Permission>> permissionResults = this.permissionProvider.permissionResults(requestCode);
        $jacocoInit[3] = true;
        return permissionResults;
    }
}
