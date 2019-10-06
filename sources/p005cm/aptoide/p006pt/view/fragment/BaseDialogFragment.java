package p005cm.aptoide.p006pt.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.trello.rxlifecycle.p017b.p018a.C12549b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.FlavourFragmentModule;
import p005cm.aptoide.p006pt.view.ActivityComponent;
import p005cm.aptoide.p006pt.view.BaseActivity;
import p005cm.aptoide.p006pt.view.FragmentComponent;
import p005cm.aptoide.p006pt.view.FragmentModule;

/* renamed from: cm.aptoide.pt.view.fragment.BaseDialogFragment */
public class BaseDialogFragment extends C12549b {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private FragmentComponent fragmentComponent;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6175442063067819513L, "cm/aptoide/pt/view/fragment/BaseDialogFragment", 18);
        $jacocoData = probes;
        return probes;
    }

    public BaseDialogFragment() {
        $jacocoInit()[0] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[1] = true;
        Window window = getDialog().getWindow();
        $jacocoInit[2] = true;
        LayoutParams layoutParams = window.getAttributes();
        layoutParams.dimAmount = 0.6f;
        $jacocoInit[3] = true;
        Window window2 = getDialog().getWindow();
        $jacocoInit[4] = true;
        window2.setAttributes(layoutParams);
        $jacocoInit[5] = true;
        Window window3 = getDialog().getWindow();
        $jacocoInit[6] = true;
        window3.addFlags(2);
        $jacocoInit[7] = true;
    }

    public FragmentComponent getFragmentComponent(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.fragmentComponent != null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
            $jacocoInit[10] = true;
            ActivityComponent activityComponent = ((BaseActivity) getActivity()).getActivityComponent();
            $jacocoInit[11] = true;
            Bundle arguments = getArguments();
            $jacocoInit[12] = true;
            boolean isCreateStoreUserPrivacyEnabled = aptoideApplication.isCreateStoreUserPrivacyEnabled();
            $jacocoInit[13] = true;
            String packageName = getActivity().getApplicationContext().getPackageName();
            $jacocoInit[14] = true;
            this.fragmentComponent = activityComponent.plus(getFragmentModule(this, savedInstanceState, arguments, isCreateStoreUserPrivacyEnabled, packageName), new FlavourFragmentModule());
            $jacocoInit[15] = true;
        }
        FragmentComponent fragmentComponent2 = this.fragmentComponent;
        $jacocoInit[16] = true;
        return fragmentComponent2;
    }

    private FragmentModule getFragmentModule(BaseDialogFragment baseFragment, Bundle savedInstanceState, Bundle arguments, boolean createStoreUserPrivacyEnabled, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = new FragmentModule(baseFragment, savedInstanceState, arguments, createStoreUserPrivacyEnabled, packageName);
        $jacocoInit[17] = true;
        return fragmentModule;
    }
}
