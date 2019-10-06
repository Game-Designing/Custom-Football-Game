package p005cm.aptoide.p006pt.util;

import android.content.Context;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.util.MarketResourceFormatter */
public class MarketResourceFormatter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String marketName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7527482850304610284L, "cm/aptoide/pt/util/MarketResourceFormatter", 2);
        $jacocoData = probes;
        return probes;
    }

    public MarketResourceFormatter(String marketName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketName = marketName2;
        $jacocoInit[0] = true;
    }

    public String formatString(Context context, int id, String... optParamaters) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = context.getString(id);
        $jacocoInit[1] = true;
        return string;
    }
}
