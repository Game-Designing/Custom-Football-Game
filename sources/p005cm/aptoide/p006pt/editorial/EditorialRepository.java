package p005cm.aptoide.p006pt.editorial;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.editorial.EditorialRepository */
public class EditorialRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private EditorialViewModel cachedEditorialViewModel;
    private final EditorialService editorialService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3032132686427734742L, "cm/aptoide/pt/editorial/EditorialRepository", 9);
        $jacocoData = probes;
        return probes;
    }

    public EditorialRepository(EditorialService editorialService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialService = editorialService2;
        $jacocoInit[0] = true;
    }

    public Single<EditorialViewModel> loadEditorialViewModel(String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialViewModel editorialViewModel = this.cachedEditorialViewModel;
        if (editorialViewModel != null) {
            $jacocoInit[1] = true;
            Single<EditorialViewModel> a = Single.m734a(editorialViewModel);
            $jacocoInit[2] = true;
            return a;
        }
        Single loadEditorialViewModel = this.editorialService.loadEditorialViewModel(cardId);
        C3166gc gcVar = new C3166gc(this);
        $jacocoInit[3] = true;
        Single<EditorialViewModel> d = loadEditorialViewModel.mo3698d(gcVar);
        $jacocoInit[4] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ EditorialViewModel mo13976a(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editorialViewModel.hasError()) {
            $jacocoInit[5] = true;
        } else if (editorialViewModel.isLoading()) {
            $jacocoInit[6] = true;
        } else {
            this.cachedEditorialViewModel = editorialViewModel;
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return editorialViewModel;
    }
}
