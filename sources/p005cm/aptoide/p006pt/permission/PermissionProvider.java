package p005cm.aptoide.p006pt.permission;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.permission.PermissionProvider */
public interface PermissionProvider {

    /* renamed from: cm.aptoide.pt.permission.PermissionProvider$Permission */
    public static class Permission {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final boolean granted;
        private final String name;
        private final int requestCode;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(3216001762075822040L, "cm/aptoide/pt/permission/PermissionProvider$Permission", 12);
            $jacocoData = probes;
            return probes;
        }

        public Permission(int requestCode2, String name2, boolean granted2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.requestCode = requestCode2;
            this.name = name2;
            this.granted = granted2;
            $jacocoInit[0] = true;
        }

        public int getRequestCode() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.requestCode;
            $jacocoInit[1] = true;
            return i;
        }

        public String getName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.name;
            $jacocoInit[2] = true;
            return str;
        }

        public boolean isGranted() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.granted;
            $jacocoInit[3] = true;
            return z;
        }

        public int hashCode() {
            boolean[] $jacocoInit = $jacocoInit();
            int result = this.requestCode;
            $jacocoInit[4] = true;
            int result2 = (result * 31) + this.name.hashCode();
            $jacocoInit[5] = true;
            return result2;
        }

        public boolean equals(Object o) {
            boolean[] $jacocoInit = $jacocoInit();
            if (this == o) {
                $jacocoInit[6] = true;
                return true;
            }
            if (o == null) {
                $jacocoInit[7] = true;
            } else if (getClass() != o.getClass()) {
                $jacocoInit[8] = true;
            } else {
                Permission that = (Permission) o;
                if (this.requestCode != that.requestCode) {
                    $jacocoInit[10] = true;
                    return false;
                }
                boolean equals = this.name.equals(that.name);
                $jacocoInit[11] = true;
                return equals;
            }
            $jacocoInit[9] = true;
            return false;
        }
    }

    C0120S<List<Permission>> permissionResults(int i);

    void providePermissions(String[] strArr, int i);
}
