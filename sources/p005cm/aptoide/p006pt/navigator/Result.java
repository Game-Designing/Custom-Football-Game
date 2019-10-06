package p005cm.aptoide.p006pt.navigator;

import android.content.Intent;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.navigator.Result */
public class Result {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Intent data;
    private final int requestCode;
    private final int resultCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4520184104886274499L, "cm/aptoide/pt/navigator/Result", 4);
        $jacocoData = probes;
        return probes;
    }

    public Result(int requestCode2, int resultCode2, Intent data2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.requestCode = requestCode2;
        this.resultCode = resultCode2;
        this.data = data2;
        $jacocoInit[0] = true;
    }

    public int getRequestCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.requestCode;
        $jacocoInit[1] = true;
        return i;
    }

    public int getResultCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.resultCode;
        $jacocoInit[2] = true;
        return i;
    }

    public Intent getData() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = this.data;
        $jacocoInit[3] = true;
        return intent;
    }
}
