package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.search.suggestions.SearchSuggestionRemoteRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory */
public final class C1365xf5423e59 implements C13181b<SearchSuggestionRemoteRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6637067749749328709L, "cm/aptoide/pt/ApplicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public C1365xf5423e59(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.retrofitProvider = retrofitProvider2;
        $jacocoInit[0] = true;
    }

    public SearchSuggestionRemoteRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Retrofit> provider = this.retrofitProvider;
        $jacocoInit[1] = true;
        SearchSuggestionRemoteRepository providesSearchSuggestionRemoteRepository = applicationModule.providesSearchSuggestionRemoteRepository((Retrofit) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSearchSuggestionRemoteRepository, "Cannot return null from a non-@Nullable @Provides method");
        SearchSuggestionRemoteRepository searchSuggestionRemoteRepository = providesSearchSuggestionRemoteRepository;
        $jacocoInit[3] = true;
        return searchSuggestionRemoteRepository;
    }

    public static C13181b<SearchSuggestionRemoteRepository> create(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1365xf5423e59 applicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory = new C1365xf5423e59(module2, retrofitProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory;
    }

    public static SearchSuggestionRemoteRepository proxyProvidesSearchSuggestionRemoteRepository(ApplicationModule instance, Retrofit retrofit) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchSuggestionRemoteRepository providesSearchSuggestionRemoteRepository = instance.providesSearchSuggestionRemoteRepository(retrofit);
        $jacocoInit[5] = true;
        return providesSearchSuggestionRemoteRepository;
    }
}
