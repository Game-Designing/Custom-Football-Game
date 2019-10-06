package p005cm.aptoide.p006pt.store.view.ads;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.store.view.ads.GetAdsFragment */
public class GetAdsFragment extends StoreTabGridRecyclerFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AdsRepository adsRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9204890930832634048L, "cm/aptoide/pt/store/view/ads/GetAdsFragment", 14);
        $jacocoData = probes;
        return probes;
    }

    public GetAdsFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        GetAdsFragment getAdsFragment = new GetAdsFragment();
        $jacocoInit[1] = true;
        return getAdsFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        this.adsRepository = ((AptoideApplication) getContext().getApplicationContext()).getAdsRepository();
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public C0120S<List<Displayable>> buildDisplayables(boolean refresh, String url, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S adsFromHomepageMore = this.adsRepository.getAdsFromHomepageMore(refresh);
        C4981a aVar = new C4981a(this);
        $jacocoInit[4] = true;
        C0120S<List<Displayable>> j = adsFromHomepageMore.mo3669j(aVar);
        $jacocoInit[5] = true;
        return j;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.database.realm.MinimalAd>, for r9v0, types: [java.util.List, java.util.List<cm.aptoide.pt.database.realm.MinimalAd>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.util.List mo16626a(java.util.List<p005cm.aptoide.p006pt.database.realm.MinimalAd> r9) {
        /*
            r8 = this;
            boolean[] r0 = $jacocoInit()
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            r2 = 1
            r3 = 6
            r0[r3] = r2
            java.util.Iterator r3 = r9.iterator()
            r4 = 7
            r0[r4] = r2
        L_0x0014:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0035
            java.lang.Object r4 = r3.next()
            cm.aptoide.pt.database.realm.MinimalAd r4 = (p005cm.aptoide.p006pt.database.realm.MinimalAd) r4
            r5 = 8
            r0[r5] = r2
            cm.aptoide.pt.view.recycler.displayable.GridAdDisplayable r5 = new cm.aptoide.pt.view.recycler.displayable.GridAdDisplayable
            java.lang.String r6 = r8.tag
            cm.aptoide.analytics.implementation.navigation.NavigationTracker r7 = r8.navigationTracker
            r5.<init>(r4, r6, r7)
            r1.add(r5)
            r4 = 9
            r0[r4] = r2
            goto L_0x0014
        L_0x0035:
            cm.aptoide.pt.view.recycler.displayable.DisplayableGroup r3 = new cm.aptoide.pt.view.recycler.displayable.DisplayableGroup
            r4 = 10
            r0[r4] = r2
            android.content.Context r4 = r8.getContext()
            java.lang.String r5 = "window"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.view.WindowManager r4 = (android.view.WindowManager) r4
            r5 = 11
            r0[r5] = r2
            android.content.Context r5 = r8.getContext()
            android.content.res.Resources r5 = r5.getResources()
            r3.<init>(r1, r4, r5)
            r4 = 12
            r0[r4] = r2
            java.util.List r3 = java.util.Collections.singletonList(r3)
            r4 = 13
            r0[r4] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.store.view.ads.GetAdsFragment.mo16626a(java.util.List):java.util.List");
    }
}
