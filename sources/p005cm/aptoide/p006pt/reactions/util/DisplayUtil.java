package p005cm.aptoide.p006pt.reactions.util;

import android.content.res.Resources;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: cm.aptoide.pt.reactions.util.DisplayUtil */
public class DisplayUtil {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6680022912570669842L, "cm/aptoide/pt/reactions/util/DisplayUtil", 3);
        $jacocoData = probes;
        return probes;
    }

    public DisplayUtil() {
        $jacocoInit()[0] = true;
    }

    public static int dpToPx(int dp) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources system = Resources.getSystem();
        $jacocoInit[1] = true;
        int i = (system.getDisplayMetrics().densityDpi / Opcodes.IF_ICMPNE) * dp;
        $jacocoInit[2] = true;
        return i;
    }
}
