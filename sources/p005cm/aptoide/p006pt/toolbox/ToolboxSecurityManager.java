package p005cm.aptoide.p006pt.toolbox;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.toolbox.ToolboxSecurityManager */
public class ToolboxSecurityManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final PackageManager packageManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6182853999579798836L, "cm/aptoide/pt/toolbox/ToolboxSecurityManager", 15);
        $jacocoData = probes;
        return probes;
    }

    public ToolboxSecurityManager(PackageManager packageManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageManager = packageManager2;
        $jacocoInit[0] = true;
    }

    public boolean checkSignature(int uid, String signature, String packageName) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String uidPackageName = getPackageName(uid);
        $jacocoInit[1] = true;
        if (!signature.equals(getSignature(uidPackageName))) {
            $jacocoInit[2] = true;
        } else if (!packageName.equals(uidPackageName)) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            z = true;
            $jacocoInit[6] = true;
            return z;
        }
        z = false;
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        return z;
    }

    private String getPackageName(int uid) {
        boolean[] $jacocoInit = $jacocoInit();
        String[] packagesForUid = this.packageManager.getPackagesForUid(uid);
        if (packagesForUid != null) {
            String str = packagesForUid[0];
            $jacocoInit[7] = true;
            return str;
        }
        $jacocoInit[8] = true;
        return null;
    }

    private String getSignature(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            PackageManager packageManager2 = this.packageManager;
            $jacocoInit[9] = true;
            Signature[] signatures = packageManager2.getPackageInfo(packageName, 64).signatures;
            if (signatures != null) {
                $jacocoInit[10] = true;
                String charsString = signatures[0].toCharsString();
                $jacocoInit[11] = true;
                return charsString;
            }
            $jacocoInit[12] = true;
            $jacocoInit[14] = true;
            return null;
        } catch (NameNotFoundException e) {
            $jacocoInit[13] = true;
        }
    }
}
