package p005cm.aptoide.p006pt.search.suggestions;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.search.model.Suggestion;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.search.suggestions.TrendingManager */
public class TrendingManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int SUGGESTION_COUNT = 10;
    private static final int SUGGESTION_STORE_ID = 15;
    private final TrendingService trendingService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4160140714152635512L, "cm/aptoide/pt/search/suggestions/TrendingManager", 24);
        $jacocoData = probes;
        return probes;
    }

    public TrendingManager(TrendingService trendingService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.trendingService = trendingService2;
        $jacocoInit[0] = true;
    }

    public Single<List<Suggestion>> getTrendingListSuggestions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S trendingApps = this.trendingService.getTrendingApps(10, 15);
        C4673c cVar = C4673c.f8305a;
        $jacocoInit[1] = true;
        C0120S j = trendingApps.mo3669j(cVar);
        C4677g gVar = C4677g.f8309a;
        $jacocoInit[2] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) gVar);
        C4678h hVar = new C4678h(this);
        $jacocoInit[3] = true;
        C0120S j2 = h.mo3669j(hVar);
        $jacocoInit[4] = true;
        C0120S m = j2.mo3675m();
        $jacocoInit[5] = true;
        C0120S d = m.mo3647d();
        $jacocoInit[6] = true;
        Single<List<Suggestion>> n = d.mo3678n();
        $jacocoInit[7] = true;
        return n;
    }

    /* renamed from: b */
    static /* synthetic */ List m496b(ListApps response) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = response.getDataList();
        $jacocoInit[22] = true;
        List list = dataList.getList();
        $jacocoInit[23] = true;
        return list;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m495b(List list) {
        $jacocoInit()[21] = true;
        return list;
    }

    /* renamed from: b */
    public /* synthetic */ Suggestion mo2340b(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        Suggestion mapToSuggestion = mapToSuggestion(app);
        $jacocoInit[20] = true;
        return mapToSuggestion;
    }

    public Single<List<String>> getTrendingCursorSuggestions() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S trendingApps = this.trendingService.getTrendingApps(10, 15);
        C4676f fVar = C4676f.f8308a;
        $jacocoInit[8] = true;
        C0120S j = trendingApps.mo3669j(fVar);
        C4674d dVar = C4674d.f8306a;
        $jacocoInit[9] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) dVar);
        C4675e eVar = C4675e.f8307a;
        $jacocoInit[10] = true;
        C0120S j2 = h.mo3669j(eVar);
        $jacocoInit[11] = true;
        C0120S m = j2.mo3675m();
        $jacocoInit[12] = true;
        C0120S d = m.mo3647d();
        $jacocoInit[13] = true;
        Single<List<String>> n = d.mo3678n();
        $jacocoInit[14] = true;
        return n;
    }

    /* renamed from: a */
    static /* synthetic */ List m494a(ListApps response) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = response.getDataList();
        $jacocoInit[18] = true;
        List list = dataList.getList();
        $jacocoInit[19] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m492a(List list) {
        $jacocoInit()[17] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ String m493a(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        String name = app.getName();
        $jacocoInit[16] = true;
        return name;
    }

    private Suggestion mapToSuggestion(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        Suggestion suggestion = new Suggestion(app.getName(), app.getIcon());
        $jacocoInit[15] = true;
        return suggestion;
    }
}
