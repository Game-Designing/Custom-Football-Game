package p005cm.aptoide.p006pt.editorialList;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListRepository */
public class EditorialListRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private EditorialListViewModel cachedEditorialListViewModel;
    private final EditorialListService editorialListService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2459392632229162369L, "cm/aptoide/pt/editorialList/EditorialListRepository", 36);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListRepository(EditorialListService editorialListService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialListService = editorialListService2;
        $jacocoInit[0] = true;
    }

    public Single<EditorialListViewModel> loadEditorialListViewModel(boolean invalidateCache) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListViewModel editorialListViewModel = this.cachedEditorialListViewModel;
        if (editorialListViewModel == null) {
            $jacocoInit[1] = true;
        } else if (invalidateCache) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            Single<EditorialListViewModel> a = Single.m734a(cloneList(editorialListViewModel));
            $jacocoInit[4] = true;
            return a;
        }
        Single<EditorialListViewModel> loadNewEditorialListViewModel = loadNewEditorialListViewModel(0, false, invalidateCache);
        $jacocoInit[5] = true;
        return loadNewEditorialListViewModel;
    }

    private Single<EditorialListViewModel> loadNewEditorialListViewModel(int offset, boolean loadMore, boolean invalidateCache) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadEditorialListViewModel = this.editorialListService.loadEditorialListViewModel(offset, invalidateCache);
        C3250Ha ha = new C3250Ha(this, loadMore);
        $jacocoInit[6] = true;
        Single<EditorialListViewModel> d = loadEditorialListViewModel.mo3698d(ha);
        $jacocoInit[7] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ EditorialListViewModel mo14153a(boolean loadMore, EditorialListViewModel editorialListViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialListViewModel.hasError()) {
            $jacocoInit[31] = true;
        } else if (editorialListViewModel.isLoading()) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            updateCache(editorialListViewModel, loadMore);
            $jacocoInit[34] = true;
        }
        EditorialListViewModel cloneList = cloneList(editorialListViewModel);
        $jacocoInit[35] = true;
        return cloneList;
    }

    public boolean hasMore() {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListViewModel editorialListViewModel = this.cachedEditorialListViewModel;
        boolean z = false;
        if (editorialListViewModel != null) {
            $jacocoInit[8] = true;
            if (editorialListViewModel.getOffset() < this.cachedEditorialListViewModel.getTotal()) {
                $jacocoInit[9] = true;
                z = true;
            } else {
                $jacocoInit[10] = true;
            }
            $jacocoInit[11] = true;
            return z;
        }
        $jacocoInit[12] = true;
        return false;
    }

    public Single<EditorialListViewModel> loadMoreCurationCards() {
        boolean[] $jacocoInit = $jacocoInit();
        int offset = 0;
        EditorialListViewModel editorialListViewModel = this.cachedEditorialListViewModel;
        if (editorialListViewModel == null) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            offset = editorialListViewModel.getOffset();
            $jacocoInit[15] = true;
        }
        Single<EditorialListViewModel> loadNewEditorialListViewModel = loadNewEditorialListViewModel(offset, true, false);
        $jacocoInit[16] = true;
        return loadNewEditorialListViewModel;
    }

    private void updateCache(EditorialListViewModel editorialListViewModel, boolean loadMore) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!loadMore) {
            this.cachedEditorialListViewModel = editorialListViewModel;
            $jacocoInit[17] = true;
        } else {
            List<CurationCard> curationCards = this.cachedEditorialListViewModel.getCurationCards();
            $jacocoInit[18] = true;
            curationCards.addAll(editorialListViewModel.getCurationCards());
            $jacocoInit[19] = true;
            int offset = editorialListViewModel.getOffset();
            $jacocoInit[20] = true;
            this.cachedEditorialListViewModel = new EditorialListViewModel(curationCards, offset, editorialListViewModel.getTotal());
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
    }

    public void updateCache(EditorialListViewModel editorialListViewModel, List<CurationCard> curationCards) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[23] = true;
        int offset = editorialListViewModel.getOffset();
        $jacocoInit[24] = true;
        this.cachedEditorialListViewModel = new EditorialListViewModel(curationCards, offset, editorialListViewModel.getTotal());
        $jacocoInit[25] = true;
    }

    private EditorialListViewModel cloneList(EditorialListViewModel editorialListViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialListViewModel.hasError()) {
            $jacocoInit[26] = true;
        } else if (editorialListViewModel.isLoading()) {
            $jacocoInit[27] = true;
        } else {
            ArrayList arrayList = new ArrayList(editorialListViewModel.getCurationCards());
            $jacocoInit[29] = true;
            EditorialListViewModel editorialListViewModel2 = new EditorialListViewModel(arrayList, editorialListViewModel.getOffset(), editorialListViewModel.getTotal());
            $jacocoInit[30] = true;
            return editorialListViewModel2;
        }
        $jacocoInit[28] = true;
        return editorialListViewModel;
    }
}
