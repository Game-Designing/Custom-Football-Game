package p005cm.aptoide.p006pt.home.apps;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.App.Type;

/* renamed from: cm.aptoide.pt.home.apps.Header */
public class Header implements App {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Type type;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1824171904539629855L, "cm/aptoide/pt/home/apps/Header", 2);
        $jacocoData = probes;
        return probes;
    }

    public Header(Type type2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.type = type2;
        $jacocoInit[0] = true;
    }

    public Type getType() {
        boolean[] $jacocoInit = $jacocoInit();
        Type type2 = this.type;
        $jacocoInit[1] = true;
        return type2;
    }
}
