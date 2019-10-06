package p005cm.aptoide.p006pt.view.splashscreen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.LoginBottomSheet;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.view.fragment.UIComponentFragment;

/* renamed from: cm.aptoide.pt.view.splashscreen.SplashScreenFragment */
public class SplashScreenFragment extends UIComponentFragment implements SplashScreenView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int LAYOUT = 2131427510;
    private AptoideBottomNavigator bottomNavigator;
    @Inject
    SplashScreenPresenter presenter;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7739602113315355488L, "cm/aptoide/pt/view/splashscreen/SplashScreenFragment", 18);
        $jacocoData = probes;
        return probes;
    }

    public SplashScreenFragment() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[2] = true;
        attachPresenter(this.presenter);
        $jacocoInit[3] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigator.hideBottomNavigation();
        $jacocoInit[4] = true;
    }

    public void onAttach(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(context);
        if (context instanceof AptoideBottomNavigator) {
            this.bottomNavigator = (AptoideBottomNavigator) context;
            Window window = getActivity().getWindow();
            $jacocoInit[7] = true;
            window.addFlags(512);
            $jacocoInit[8] = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Context should implement ");
        $jacocoInit[5] = true;
        sb.append(LoginBottomSheet.class.getSimpleName());
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[6] = true;
        throw illegalStateException;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        $jacocoInit[9] = true;
        Window window = getActivity().getWindow();
        $jacocoInit[10] = true;
        window.clearFlags(512);
        $jacocoInit[11] = true;
        this.bottomNavigator.toggleBottomNavigation();
        $jacocoInit[12] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[13] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[14] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[15] = true;
        return build;
    }

    public int getContentViewId() {
        $jacocoInit()[16] = true;
        return C1375R.layout.fragment_splashscreen;
    }

    public void bindViews(View view) {
        $jacocoInit()[17] = true;
    }
}
