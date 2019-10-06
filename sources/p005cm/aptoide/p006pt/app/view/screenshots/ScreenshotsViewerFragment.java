package p005cm.aptoide.p006pt.app.view.screenshots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.custom.AptoideViewPager;
import p005cm.aptoide.p006pt.view.fragment.UIComponentFragment;

/* renamed from: cm.aptoide.pt.app.view.screenshots.ScreenshotsViewerFragment */
public class ScreenshotsViewerFragment extends UIComponentFragment implements NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private View btnCloseViewer;
    private int currentItem;
    private AptoideViewPager screenshots;
    private ArrayList<String> uris;

    /* renamed from: cm.aptoide.pt.app.view.screenshots.ScreenshotsViewerFragment$BundleArgs */
    private enum BundleArgs {
        POSITION,
        URIs;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7302214330538618902L, "cm/aptoide/pt/app/view/screenshots/ScreenshotsViewerFragment", 38);
        $jacocoData = probes;
        return probes;
    }

    public ScreenshotsViewerFragment() {
        $jacocoInit()[0] = true;
    }

    public static ScreenshotsViewerFragment newInstance(ArrayList<String> uris2, int currentItem2) {
        boolean[] $jacocoInit = $jacocoInit();
        ScreenshotsViewerFragment fragment = new ScreenshotsViewerFragment();
        $jacocoInit[1] = true;
        Bundle bundle = new Bundle();
        $jacocoInit[2] = true;
        bundle.putStringArrayList(BundleArgs.URIs.name(), uris2);
        $jacocoInit[3] = true;
        bundle.putInt(BundleArgs.POSITION.name(), currentItem2);
        $jacocoInit[4] = true;
        fragment.setArguments(bundle);
        $jacocoInit[5] = true;
        return fragment;
    }

    public void loadExtras(Bundle extras) {
        boolean[] $jacocoInit = $jacocoInit();
        if (extras == null) {
            $jacocoInit[6] = true;
            Intent intent = getActivity().getIntent();
            BundleArgs bundleArgs = BundleArgs.POSITION;
            $jacocoInit[7] = true;
            this.currentItem = intent.getIntExtra(bundleArgs.name(), 0);
            $jacocoInit[8] = true;
        } else {
            this.currentItem = extras.getInt(BundleArgs.POSITION.name(), 0);
            $jacocoInit[9] = true;
        }
        if (extras == null) {
            $jacocoInit[10] = true;
            Intent intent2 = getActivity().getIntent();
            BundleArgs bundleArgs2 = BundleArgs.URIs;
            $jacocoInit[11] = true;
            this.uris = intent2.getStringArrayListExtra(bundleArgs2.name());
            $jacocoInit[12] = true;
        } else {
            this.uris = extras.getStringArrayList(BundleArgs.URIs.name());
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenshots.setTrackingEnabled(false);
        $jacocoInit[15] = true;
        ArrayList<String> arrayList = this.uris;
        if (arrayList == null) {
            $jacocoInit[16] = true;
        } else if (arrayList.size() <= 0) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            this.screenshots.setAdapter(new ViewPagerAdapterScreenshots(this.uris));
            $jacocoInit[19] = true;
            this.screenshots.setCurrentItem(this.currentItem);
            $jacocoInit[20] = true;
        }
        this.btnCloseViewer.setOnClickListener(new C2203c(this));
        $jacocoInit[21] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11008a(View v) {
        boolean[] $jacocoInit = $jacocoInit();
        getActivity().onBackPressed();
        $jacocoInit[37] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[22] = true;
        hideSystemUI();
        $jacocoInit[23] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[24] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[25] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[26] = true;
        return build;
    }

    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onPause();
        $jacocoInit[27] = true;
        showSystemUI();
        $jacocoInit[28] = true;
    }

    private void showSystemUI() {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenshots.setSystemUiVisibility(1792);
        $jacocoInit[29] = true;
    }

    private void hideSystemUI() {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenshots.setSystemUiVisibility(3846);
        $jacocoInit[30] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[31] = true;
        return C1375R.layout.fragment_screenshots_viewer;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.screenshots = (AptoideViewPager) view.findViewById(C1375R.C1376id.screen_shots_pager);
        $jacocoInit[32] = true;
        this.btnCloseViewer = view.findViewById(C1375R.C1376id.btn_close_screenshots_window);
        $jacocoInit[33] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[34] = true;
        outState.putInt(BundleArgs.POSITION.name(), this.currentItem);
        $jacocoInit[35] = true;
        outState.putStringArrayList(BundleArgs.URIs.name(), this.uris);
        $jacocoInit[36] = true;
    }
}
