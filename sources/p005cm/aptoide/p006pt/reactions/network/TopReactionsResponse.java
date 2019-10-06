package p005cm.aptoide.p006pt.reactions.network;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.reactions.network.TopReactionsResponse */
public class TopReactionsResponse {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: my */
    private C4615My f8254my;
    private List<ReactionTypeResponse> top;
    private int total;

    /* renamed from: cm.aptoide.pt.reactions.network.TopReactionsResponse$My */
    public static class C4615My {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String type;
        private String uid;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6287580575214471623L, "cm/aptoide/pt/reactions/network/TopReactionsResponse$My", 5);
            $jacocoData = probes;
            return probes;
        }

        public C4615My() {
            $jacocoInit()[0] = true;
        }

        public String getType() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.type;
            $jacocoInit[1] = true;
            return str;
        }

        public void setType(String type2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = type2;
            $jacocoInit[2] = true;
        }

        public String getUid() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.uid;
            $jacocoInit[3] = true;
            return str;
        }

        public void setUid(String uid2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.uid = uid2;
            $jacocoInit[4] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.reactions.network.TopReactionsResponse$ReactionTypeResponse */
    public static class ReactionTypeResponse {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private int total;
        private String type;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3503619860054307226L, "cm/aptoide/pt/reactions/network/TopReactionsResponse$ReactionTypeResponse", 5);
            $jacocoData = probes;
            return probes;
        }

        public ReactionTypeResponse() {
            $jacocoInit()[0] = true;
        }

        public int getTotal() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.total;
            $jacocoInit[1] = true;
            return i;
        }

        public void setTotal(int total2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.total = total2;
            $jacocoInit[2] = true;
        }

        public String getType() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.type;
            $jacocoInit[3] = true;
            return str;
        }

        public void setType(String type2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.type = type2;
            $jacocoInit[4] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4291681113564417580L, "cm/aptoide/pt/reactions/network/TopReactionsResponse", 7);
        $jacocoData = probes;
        return probes;
    }

    public TopReactionsResponse() {
        $jacocoInit()[0] = true;
    }

    public int getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.total;
        $jacocoInit[1] = true;
        return i;
    }

    public void setTotal(int total2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.total = total2;
        $jacocoInit[2] = true;
    }

    public C4615My getMy() {
        boolean[] $jacocoInit = $jacocoInit();
        C4615My my = this.f8254my;
        $jacocoInit[3] = true;
        return my;
    }

    public void setMy(C4615My my) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f8254my = my;
        $jacocoInit[4] = true;
    }

    public List<ReactionTypeResponse> getTop() {
        boolean[] $jacocoInit = $jacocoInit();
        List<ReactionTypeResponse> list = this.top;
        $jacocoInit[5] = true;
        return list;
    }

    public void setTop(List<ReactionTypeResponse> top2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.top = top2;
        $jacocoInit[6] = true;
    }
}
