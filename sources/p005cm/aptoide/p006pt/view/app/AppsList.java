package p005cm.aptoide.p006pt.view.app;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppsList */
public class AppsList {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Error error;
    private final List<Application> list;
    private final boolean loading;
    private final int offset;

    /* renamed from: cm.aptoide.pt.view.app.AppsList$Error */
    public enum Error {
        NETWORK,
        GENERIC;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8370815965165770984L, "cm/aptoide/pt/view/app/AppsList", 12);
        $jacocoData = probes;
        return probes;
    }

    public AppsList(Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.error = error2;
        this.loading = false;
        $jacocoInit[0] = true;
        this.list = Collections.emptyList();
        this.offset = -1;
        $jacocoInit[1] = true;
    }

    public AppsList(List<Application> list2, boolean loading2, int offset2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.list = list2;
        this.loading = loading2;
        this.offset = offset2;
        this.error = null;
        $jacocoInit[2] = true;
    }

    public AppsList(boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = loading2;
        $jacocoInit[3] = true;
        this.list = Collections.emptyList();
        this.error = null;
        this.offset = -1;
        $jacocoInit[4] = true;
    }

    public int getOffset() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.offset;
        $jacocoInit[5] = true;
        return i;
    }

    public List<Application> getList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Application> list2 = this.list;
        $jacocoInit[6] = true;
        return list2;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[7] = true;
        return z;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        $jacocoInit[8] = true;
        return error2;
    }

    public boolean hasErrors() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[9] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
        return z;
    }
}
