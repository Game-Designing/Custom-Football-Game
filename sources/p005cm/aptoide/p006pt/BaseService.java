package p005cm.aptoide.p006pt;

import android.app.Service;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.BaseService */
public abstract class BaseService extends Service {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8304603143598726272L, "cm/aptoide/pt/BaseService", 2);
        $jacocoData = probes;
        return probes;
    }

    public BaseService() {
        $jacocoInit()[0] = true;
    }

    public ApplicationComponent getApplicationComponent() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationComponent applicationComponent = ((AptoideApplication) getApplication()).getApplicationComponent();
        $jacocoInit[1] = true;
        return applicationComponent;
    }
}
