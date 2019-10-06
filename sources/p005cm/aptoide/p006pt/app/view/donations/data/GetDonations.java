package p005cm.aptoide.p006pt.app.view.donations.data;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.donations.data.GetDonations */
public class GetDonations extends BaseResponse {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<Donor> items;
    private String next;

    /* renamed from: cm.aptoide.pt.app.view.donations.data.GetDonations$Donor */
    public static class Donor {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String appc;
        private String domain;
        private String owner;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2956864801538977075L, "cm/aptoide/pt/app/view/donations/data/GetDonations$Donor", 7);
            $jacocoData = probes;
            return probes;
        }

        public Donor() {
            $jacocoInit()[0] = true;
        }

        public String getDomain() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.domain;
            $jacocoInit[1] = true;
            return str;
        }

        public void setDomain(String domain2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.domain = domain2;
            $jacocoInit[2] = true;
        }

        public String getOwner() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.owner;
            $jacocoInit[3] = true;
            return str;
        }

        public void setOwner(String owner2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.owner = owner2;
            $jacocoInit[4] = true;
        }

        public String getAppc() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.appc;
            $jacocoInit[5] = true;
            return str;
        }

        public void setAppc(String appc2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.appc = appc2;
            $jacocoInit[6] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(692052845303266300L, "cm/aptoide/pt/app/view/donations/data/GetDonations", 5);
        $jacocoData = probes;
        return probes;
    }

    public GetDonations() {
        $jacocoInit()[0] = true;
    }

    public String getNext() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.next;
        $jacocoInit[1] = true;
        return str;
    }

    public void setNext(String next2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.next = next2;
        $jacocoInit[2] = true;
    }

    public List<Donor> getItems() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Donor> list = this.items;
        $jacocoInit[3] = true;
        return list;
    }

    public void setItems(List<Donor> items2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.items = items2;
        $jacocoInit[4] = true;
    }
}
