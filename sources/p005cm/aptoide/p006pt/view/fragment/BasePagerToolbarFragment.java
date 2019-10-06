package p005cm.aptoide.p006pt.view.fragment;

import android.support.p000v4.view.C0642s;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.custom.AptoideViewPager;

/* renamed from: cm.aptoide.pt.view.fragment.BasePagerToolbarFragment */
public abstract class BasePagerToolbarFragment extends BaseLoaderToolbarFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected AptoideViewPager viewPager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3089806885759559964L, "cm/aptoide/pt/view/fragment/BasePagerToolbarFragment", 7);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract C0642s createPagerAdapter();

    public BasePagerToolbarFragment() {
        $jacocoInit()[0] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[1] = true;
        this.viewPager = (AptoideViewPager) view.findViewById(C1375R.C1376id.pager);
        $jacocoInit[2] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.viewPager.clearOnPageChangeListeners();
        this.viewPager = null;
        $jacocoInit[3] = true;
        super.onDestroyView();
        $jacocoInit[4] = true;
    }

    /* access modifiers changed from: protected */
    public void setupViewPager() {
        boolean[] $jacocoInit = $jacocoInit();
        C0642s pagerAdapter = createPagerAdapter();
        $jacocoInit[5] = true;
        this.viewPager.setAdapter(pagerAdapter);
        $jacocoInit[6] = true;
    }
}
