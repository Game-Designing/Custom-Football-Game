package p005cm.aptoide.p006pt.search.suggestions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0126V;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.search.suggestions.SearchSuggestionManager */
public class SearchSuggestionManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C0126V ioScheduler;
    private final SearchSuggestionService service;
    private final int timeout;
    private final TimeUnit timeoutTimeUnit;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6282515608477044425L, "cm/aptoide/pt/search/suggestions/SearchSuggestionManager", 8);
        $jacocoData = probes;
        return probes;
    }

    public SearchSuggestionManager(SearchSuggestionService service2, C0126V ioScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.ioScheduler = ioScheduler2;
        this.timeout = 10;
        this.timeoutTimeUnit = TimeUnit.SECONDS;
        $jacocoInit[0] = true;
    }

    public SearchSuggestionManager(SearchSuggestionService service2, int timeout2, TimeUnit timeoutTimeUnit2, C0126V ioScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.ioScheduler = ioScheduler2;
        this.timeout = timeout2;
        this.timeoutTimeUnit = timeoutTimeUnit2;
        $jacocoInit[1] = true;
    }

    public Single<List<String>> getSuggestionsForApp(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Single appSuggestionsForQuery = this.service.getAppSuggestionsForQuery(query);
        long j = (long) this.timeout;
        TimeUnit timeUnit = this.timeoutTimeUnit;
        $jacocoInit[2] = true;
        Single a = appSuggestionsForQuery.mo3682a(j, timeUnit);
        C0126V v = this.ioScheduler;
        $jacocoInit[3] = true;
        Single<List<String>> b = a.mo3694b(v);
        $jacocoInit[4] = true;
        return b;
    }

    public Single<List<String>> getSuggestionsForStore(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Single storeSuggestionsForQuery = this.service.getStoreSuggestionsForQuery(query);
        long j = (long) this.timeout;
        TimeUnit timeUnit = this.timeoutTimeUnit;
        $jacocoInit[5] = true;
        Single a = storeSuggestionsForQuery.mo3682a(j, timeUnit);
        C0126V v = this.ioScheduler;
        $jacocoInit[6] = true;
        Single<List<String>> b = a.mo3694b(v);
        $jacocoInit[7] = true;
        return b;
    }
}
