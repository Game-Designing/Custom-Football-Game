package p005cm.aptoide.p006pt.view.wizard;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;
import p005cm.aptoide.p006pt.view.BackButtonFragment;

/* renamed from: cm.aptoide.pt.view.wizard.WizardPageTwoFragment */
public class WizardPageTwoFragment extends BackButtonFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ClickHandler clickHandler;
    @Inject
    MarketResourceFormatter marketResourceFormatter;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(87289852666186381L, "cm/aptoide/pt/view/wizard/WizardPageTwoFragment", 19);
        $jacocoData = probes;
        return probes;
    }

    public WizardPageTwoFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        WizardPageTwoFragment wizardPageTwoFragment = new WizardPageTwoFragment();
        $jacocoInit[1] = true;
        return wizardPageTwoFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[4] = true;
        this.clickHandler = new ClickHandler(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ WizardPageTwoFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-4258955219814917998L, "cm/aptoide/pt/view/wizard/WizardPageTwoFragment$1", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean handle() {
                $jacocoInit()[1] = true;
                return false;
            }
        };
        $jacocoInit[5] = true;
        registerClickHandler(this.clickHandler);
        $jacocoInit[6] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[7] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[8] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[9] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View view = inflater.inflate(C1375R.layout.fragment_wizard_model_page, container, false);
        $jacocoInit[10] = true;
        setText(view);
        $jacocoInit[11] = true;
        return view;
    }

    private void setText(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        ((TextView) view.findViewById(C1375R.C1376id.title)).setText(C1375R.string.wizard_title_viewpager_two);
        $jacocoInit[12] = true;
        TextView textView = (TextView) view.findViewById(C1375R.C1376id.description);
        MarketResourceFormatter marketResourceFormatter2 = this.marketResourceFormatter;
        $jacocoInit[13] = true;
        String formatString = marketResourceFormatter2.formatString(getContext(), C1375R.string.wizard_sub_title_viewpager_two, new String[0]);
        $jacocoInit[14] = true;
        textView.setText(formatString);
        $jacocoInit[15] = true;
        ((ImageView) view.findViewById(16908294)).setImageResource(C1375R.drawable.wizard_2);
        $jacocoInit[16] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        unregisterClickHandler(this.clickHandler);
        $jacocoInit[17] = true;
        super.onDestroyView();
        $jacocoInit[18] = true;
    }
}
