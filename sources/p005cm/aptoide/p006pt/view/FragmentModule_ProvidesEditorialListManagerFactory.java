package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.editorialList.EditorialListManager;
import p005cm.aptoide.p006pt.editorialList.EditorialListRepository;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListManagerFactory */
public final class FragmentModule_ProvidesEditorialListManagerFactory implements C13181b<EditorialListManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<EditorialListRepository> editorialListRepositoryProvider;
    private final FragmentModule module;
    private final Provider<ReactionsManager> reactionsManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5298839344786329147L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialListManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialListManagerFactory(FragmentModule module2, Provider<EditorialListRepository> editorialListRepositoryProvider2, Provider<ReactionsManager> reactionsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.editorialListRepositoryProvider = editorialListRepositoryProvider2;
        this.reactionsManagerProvider = reactionsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialListManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<EditorialListRepository> provider = this.editorialListRepositoryProvider;
        $jacocoInit[1] = true;
        EditorialListRepository editorialListRepository = (EditorialListRepository) provider.get();
        ReactionsManager reactionsManager = (ReactionsManager) this.reactionsManagerProvider.get();
        $jacocoInit[2] = true;
        EditorialListManager providesEditorialListManager = fragmentModule.providesEditorialListManager(editorialListRepository, reactionsManager);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesEditorialListManager, "Cannot return null from a non-@Nullable @Provides method");
        EditorialListManager editorialListManager = providesEditorialListManager;
        $jacocoInit[4] = true;
        return editorialListManager;
    }

    public static C13181b<EditorialListManager> create(FragmentModule module2, Provider<EditorialListRepository> editorialListRepositoryProvider2, Provider<ReactionsManager> reactionsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialListManagerFactory fragmentModule_ProvidesEditorialListManagerFactory = new FragmentModule_ProvidesEditorialListManagerFactory(module2, editorialListRepositoryProvider2, reactionsManagerProvider2);
        $jacocoInit[5] = true;
        return fragmentModule_ProvidesEditorialListManagerFactory;
    }

    public static EditorialListManager proxyProvidesEditorialListManager(FragmentModule instance, EditorialListRepository editorialListRepository, ReactionsManager reactionsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListManager providesEditorialListManager = instance.providesEditorialListManager(editorialListRepository, reactionsManager);
        $jacocoInit[6] = true;
        return providesEditorialListManager;
    }
}
