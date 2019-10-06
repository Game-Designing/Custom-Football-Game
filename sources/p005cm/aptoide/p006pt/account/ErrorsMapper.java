package p005cm.aptoide.p006pt.account;

import android.content.res.Resources;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.account.ErrorsMapper */
public class ErrorsMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6953855941759373395L, "cm/aptoide/pt/account/ErrorsMapper", 4);
        $jacocoData = probes;
        return probes;
    }

    public ErrorsMapper() {
        $jacocoInit()[0] = true;
    }

    public int getWebServiceErrorMessageFromCode(String errorCode, String packageName, Resources resources) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        int error = resources.getIdentifier(String.format("ws_error_%1s", new Object[]{errorCode.replace("-", "_")}), "string", packageName);
        if (error == 0) {
            i = C1375R.string.unknown_error;
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            i = error;
        }
        $jacocoInit[3] = true;
        return i;
    }
}
