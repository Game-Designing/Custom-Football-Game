package p005cm.aptoide.p006pt.leak;

import android.app.Application;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.leak.LeakTool */
public class LeakTool {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1908275906539523295L, "cm/aptoide/pt/leak/LeakTool", 2);
        $jacocoData = probes;
        return probes;
    }

    public LeakTool() {
        $jacocoInit()[0] = true;
    }

    public void setup(Application application) {
        $jacocoInit()[1] = true;
    }
}
