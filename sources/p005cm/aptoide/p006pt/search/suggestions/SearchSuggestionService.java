package p005cm.aptoide.p006pt.search.suggestions;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.search.suggestions.SearchSuggestionService */
public class SearchSuggestionService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final SearchSuggestionRemoteRepository repository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7775810127583106143L, "cm/aptoide/pt/search/suggestions/SearchSuggestionService", 7);
        $jacocoData = probes;
        return probes;
    }

    public SearchSuggestionService(SearchSuggestionRemoteRepository repository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.repository = repository2;
        $jacocoInit[0] = true;
    }

    public Single<List<String>> getAppSuggestionsForQuery(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Single suggestionForApp = this.repository.getSuggestionForApp(query);
        C4671a aVar = C4671a.f8303a;
        $jacocoInit[1] = true;
        Single<List<String>> d = suggestionForApp.mo3698d(aVar);
        $jacocoInit[2] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ List m9017a(Suggestions model) {
        boolean[] $jacocoInit = $jacocoInit();
        List data = model.getData();
        $jacocoInit[6] = true;
        return data;
    }

    public Single<List<String>> getStoreSuggestionsForQuery(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Single suggestionForStore = this.repository.getSuggestionForStore(query);
        C4672b bVar = C4672b.f8304a;
        $jacocoInit[3] = true;
        Single<List<String>> d = suggestionForStore.mo3698d(bVar);
        $jacocoInit[4] = true;
        return d;
    }

    /* renamed from: b */
    static /* synthetic */ List m9018b(Suggestions model) {
        boolean[] $jacocoInit = $jacocoInit();
        List data = model.getData();
        $jacocoInit[5] = true;
        return data;
    }
}
