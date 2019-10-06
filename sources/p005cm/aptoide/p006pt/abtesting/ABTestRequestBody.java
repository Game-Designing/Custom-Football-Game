package p005cm.aptoide.p006pt.abtesting;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.abtesting.ABTestRequestBody */
public class ABTestRequestBody {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<Data> events = new ArrayList();

    /* renamed from: cm.aptoide.pt.abtesting.ABTestRequestBody$Data */
    public static class Data {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String name;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6614359361699940674L, "cm/aptoide/pt/abtesting/ABTestRequestBody$Data", 2);
            $jacocoData = probes;
            return probes;
        }

        Data(String action) {
            boolean[] $jacocoInit = $jacocoInit();
            this.name = action;
            $jacocoInit[0] = true;
        }

        public String getName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.name;
            $jacocoInit[1] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8372021169716634969L, "cm/aptoide/pt/abtesting/ABTestRequestBody", 4);
        $jacocoData = probes;
        return probes;
    }

    public ABTestRequestBody(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.events.add(new Data(action));
        $jacocoInit[2] = true;
    }

    public List<Data> getEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Data> list = this.events;
        $jacocoInit[3] = true;
        return list;
    }
}
