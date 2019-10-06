package p005cm.aptoide.p006pt.home;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;

/* renamed from: cm.aptoide.pt.home.DummyBundle */
class DummyBundle implements HomeBundle {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1611781110752580261L, "cm/aptoide/pt/home/DummyBundle", 6);
        $jacocoData = probes;
        return probes;
    }

    DummyBundle() {
        $jacocoInit()[0] = true;
    }

    public String getTitle() {
        $jacocoInit()[1] = true;
        return null;
    }

    public List<?> getContent() {
        $jacocoInit()[2] = true;
        return null;
    }

    public BundleType getType() {
        $jacocoInit()[3] = true;
        return null;
    }

    public Event getEvent() {
        $jacocoInit()[4] = true;
        return null;
    }

    public String getTag() {
        $jacocoInit()[5] = true;
        return null;
    }
}
