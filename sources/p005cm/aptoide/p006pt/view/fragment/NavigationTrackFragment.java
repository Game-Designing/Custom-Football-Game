package p005cm.aptoide.p006pt.view.fragment;

import android.os.Bundle;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.PageViewsAnalytics;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.AptoideApplication;

/* renamed from: cm.aptoide.pt.view.fragment.NavigationTrackFragment */
public abstract class NavigationTrackFragment extends FragmentView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String SHOULD_REGISTER_VIEW = "should_register_view";
    private AnalyticsManager analyticsManager;
    protected NavigationTracker navigationTracker;
    protected PageViewsAnalytics pageViewsAnalytics;
    protected boolean shouldRegister = true;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8500110276188706667L, "cm/aptoide/pt/view/fragment/NavigationTrackFragment", 25);
        $jacocoData = probes;
        return probes;
    }

    public NavigationTrackFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        if (this.navigationTracker != null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            this.navigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
            $jacocoInit[3] = true;
        }
        if (this.analyticsManager != null) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            this.analyticsManager = ((AptoideApplication) getContext().getApplicationContext()).getAnalyticsManager();
            $jacocoInit[6] = true;
        }
        this.pageViewsAnalytics = new PageViewsAnalytics(this.analyticsManager);
        $jacocoInit[7] = true;
        getFragmentExtras();
        $jacocoInit[8] = true;
    }

    private void getFragmentExtras() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getArguments() == null) {
            $jacocoInit[9] = true;
        } else {
            Bundle arguments = getArguments();
            String str = SHOULD_REGISTER_VIEW;
            if (!arguments.containsKey(str)) {
                $jacocoInit[10] = true;
            } else {
                $jacocoInit[11] = true;
                this.shouldRegister = getArguments().getBoolean(str);
                $jacocoInit[12] = true;
            }
        }
        $jacocoInit[13] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[14] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[15] = true;
        ScreenTagHistory historyTracker = getHistoryTracker();
        if (!this.shouldRegister) {
            $jacocoInit[16] = true;
        } else if (historyTracker != null) {
            this.navigationTracker.registerScreen(historyTracker);
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[17] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("If ");
            $jacocoInit[18] = true;
            Class cls = getClass();
            $jacocoInit[19] = true;
            sb.append(cls.getSimpleName());
            sb.append(" should be logged to screen history, it has to return a value on method NavigationTrackFragment#getHistoryTracker");
            RuntimeException runtimeException = new RuntimeException(sb.toString());
            $jacocoInit[20] = true;
            throw runtimeException;
        }
        $jacocoInit[22] = true;
    }

    /* access modifiers changed from: protected */
    public void setRegisterFragment(boolean shouldRegister2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.shouldRegister = shouldRegister2;
        $jacocoInit[23] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        $jacocoInit()[24] = true;
        return null;
    }
}
