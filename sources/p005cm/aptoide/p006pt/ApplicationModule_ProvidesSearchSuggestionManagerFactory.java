package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionManager;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionRemoteRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSearchSuggestionManagerFactory */
public final class ApplicationModule_ProvidesSearchSuggestionManagerFactory implements C13181b<SearchSuggestionManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SearchSuggestionRemoteRepository> remoteRepositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7961883023481603723L, "cm/aptoide/pt/ApplicationModule_ProvidesSearchSuggestionManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSearchSuggestionManagerFactory(ApplicationModule module2, Provider<SearchSuggestionRemoteRepository> remoteRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.remoteRepositoryProvider = remoteRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public SearchSuggestionManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SearchSuggestionRemoteRepository> provider = this.remoteRepositoryProvider;
        $jacocoInit[1] = true;
        SearchSuggestionManager providesSearchSuggestionManager = applicationModule.providesSearchSuggestionManager((SearchSuggestionRemoteRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSearchSuggestionManager, "Cannot return null from a non-@Nullable @Provides method");
        SearchSuggestionManager searchSuggestionManager = providesSearchSuggestionManager;
        $jacocoInit[3] = true;
        return searchSuggestionManager;
    }

    public static C13181b<SearchSuggestionManager> create(ApplicationModule module2, Provider<SearchSuggestionRemoteRepository> remoteRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSearchSuggestionManagerFactory applicationModule_ProvidesSearchSuggestionManagerFactory = new ApplicationModule_ProvidesSearchSuggestionManagerFactory(module2, remoteRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesSearchSuggestionManagerFactory;
    }

    public static SearchSuggestionManager proxyProvidesSearchSuggestionManager(ApplicationModule instance, SearchSuggestionRemoteRepository remoteRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchSuggestionManager providesSearchSuggestionManager = instance.providesSearchSuggestionManager(remoteRepository);
        $jacocoInit[5] = true;
        return providesSearchSuggestionManager;
    }
}
