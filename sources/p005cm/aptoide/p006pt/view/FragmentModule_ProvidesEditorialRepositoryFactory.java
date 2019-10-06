package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.editorial.EditorialRepository;
import p005cm.aptoide.p006pt.editorial.EditorialService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialRepositoryFactory */
public final class FragmentModule_ProvidesEditorialRepositoryFactory implements C13181b<EditorialRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<EditorialService> editorialServiceProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6484709918067743L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialRepositoryFactory(FragmentModule module2, Provider<EditorialService> editorialServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.editorialServiceProvider = editorialServiceProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<EditorialService> provider = this.editorialServiceProvider;
        $jacocoInit[1] = true;
        EditorialRepository providesEditorialRepository = fragmentModule.providesEditorialRepository((EditorialService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesEditorialRepository, "Cannot return null from a non-@Nullable @Provides method");
        EditorialRepository editorialRepository = providesEditorialRepository;
        $jacocoInit[3] = true;
        return editorialRepository;
    }

    public static C13181b<EditorialRepository> create(FragmentModule module2, Provider<EditorialService> editorialServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialRepositoryFactory fragmentModule_ProvidesEditorialRepositoryFactory = new FragmentModule_ProvidesEditorialRepositoryFactory(module2, editorialServiceProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesEditorialRepositoryFactory;
    }

    public static EditorialRepository proxyProvidesEditorialRepository(FragmentModule instance, EditorialService editorialService) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialRepository providesEditorialRepository = instance.providesEditorialRepository(editorialService);
        $jacocoInit[5] = true;
        return providesEditorialRepository;
    }
}
