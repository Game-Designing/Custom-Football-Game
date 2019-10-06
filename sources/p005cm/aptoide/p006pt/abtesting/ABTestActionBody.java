package p005cm.aptoide.p006pt.abtesting;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.abtesting.ABTestActionBody */
public class ABTestActionBody {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<Data> events = new ArrayList();

    /* renamed from: cm.aptoide.pt.abtesting.ABTestActionBody$Data */
    public static class Data {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String name;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(932561822285474853L, "cm/aptoide/pt/abtesting/ABTestActionBody$Data", 3);
            $jacocoData = probes;
            return probes;
        }

        Data(String assignment) {
            boolean[] $jacocoInit = $jacocoInit();
            this.name = assignment;
            $jacocoInit[0] = true;
        }

        public String getName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.name;
            $jacocoInit[1] = true;
            return str;
        }

        public void setName(String name2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.name = name2;
            $jacocoInit[2] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4292209405057716038L, "cm/aptoide/pt/abtesting/ABTestActionBody", 5);
        $jacocoData = probes;
        return probes;
    }

    public ABTestActionBody(String assignment) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.events.add(new Data(assignment));
        $jacocoInit[2] = true;
    }

    public List<Data> getEvents() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Data> list = this.events;
        $jacocoInit[3] = true;
        return list;
    }

    public void setEvents(List<Data> events2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.events = events2;
        $jacocoInit[4] = true;
    }
}
