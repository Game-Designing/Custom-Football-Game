package p005cm.aptoide.p006pt.editorialList;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListViewModel */
class EditorialListViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<CurationCard> curationCards;
    private final Error error;
    private final boolean loading;
    private final int offset;
    private final int total;

    /* renamed from: cm.aptoide.pt.editorialList.EditorialListViewModel$Error */
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
        boolean[] probes = Offline.getProbes(-117717920209347257L, "cm/aptoide/pt/editorialList/EditorialListViewModel", 13);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListViewModel(Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.error = error2;
        this.loading = false;
        this.offset = 0;
        this.total = 0;
        $jacocoInit[0] = true;
        this.curationCards = Collections.emptyList();
        $jacocoInit[1] = true;
    }

    public EditorialListViewModel(boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = loading2;
        this.error = null;
        this.offset = 0;
        this.total = 0;
        $jacocoInit[2] = true;
        this.curationCards = Collections.emptyList();
        $jacocoInit[3] = true;
    }

    public EditorialListViewModel(List<CurationCard> curationCards2, int offset2, int total2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.curationCards = curationCards2;
        this.offset = offset2;
        this.total = total2;
        this.error = null;
        this.loading = false;
        $jacocoInit[4] = true;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        $jacocoInit[5] = true;
        return error2;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[6] = true;
        return z;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[7] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
        return z;
    }

    public List<CurationCard> getCurationCards() {
        boolean[] $jacocoInit = $jacocoInit();
        List<CurationCard> list = this.curationCards;
        $jacocoInit[10] = true;
        return list;
    }

    public int getOffset() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.offset;
        $jacocoInit[11] = true;
        return i;
    }

    public int getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.total;
        $jacocoInit[12] = true;
        return i;
    }
}
