package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.editorialList.EditorialListRepository;
import p005cm.aptoide.p006pt.editorialList.EditorialListService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListRepositoryFactory */
public final class FragmentModule_ProvidesEditorialListRepositoryFactory implements C13181b<EditorialListRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<EditorialListService> editorialListServiceProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3084456046214966746L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialListRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialListRepositoryFactory(FragmentModule module2, Provider<EditorialListService> editorialListServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.editorialListServiceProvider = editorialListServiceProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialListRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<EditorialListService> provider = this.editorialListServiceProvider;
        $jacocoInit[1] = true;
        EditorialListRepository providesEditorialListRepository = fragmentModule.providesEditorialListRepository((EditorialListService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesEditorialListRepository, "Cannot return null from a non-@Nullable @Provides method");
        EditorialListRepository editorialListRepository = providesEditorialListRepository;
        $jacocoInit[3] = true;
        return editorialListRepository;
    }

    public static C13181b<EditorialListRepository> create(FragmentModule module2, Provider<EditorialListService> editorialListServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialListRepositoryFactory fragmentModule_ProvidesEditorialListRepositoryFactory = new FragmentModule_ProvidesEditorialListRepositoryFactory(module2, editorialListServiceProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesEditorialListRepositoryFactory;
    }

    public static EditorialListRepository proxyProvidesEditorialListRepository(FragmentModule instance, EditorialListService editorialListService) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListRepository providesEditorialListRepository = instance.providesEditorialListRepository(editorialListService);
        $jacocoInit[5] = true;
        return providesEditorialListRepository;
    }
}
