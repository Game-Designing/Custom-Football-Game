package p005cm.aptoide.p006pt.view;

import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.trello.rxlifecycle.p017b.p018a.C0094c;
import java.lang.reflect.Field;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.FlavourFragmentModule;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.view.BaseFragment */
public abstract class BaseFragment extends C0094c {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private BottomNavigationActivity bottomNavigationActivity;
    private FragmentComponent fragmentComponent;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7769740348126581318L, "cm/aptoide/pt/view/BaseFragment", 48);
        $jacocoData = probes;
        return probes;
    }

    public BaseFragment() {
        $jacocoInit()[0] = true;
    }

    private static long getRemovingParentAnimationDuration(Fragment fragment, long defValue) {
        long j;
        boolean[] $jacocoInit = $jacocoInit();
        try {
            Field animInfoField = Fragment.class.getDeclaredField("mAnimationInfo");
            $jacocoInit[1] = true;
            animInfoField.setAccessible(true);
            $jacocoInit[2] = true;
            Object animationInfo = animInfoField.get(fragment);
            $jacocoInit[3] = true;
            $jacocoInit[4] = true;
            Field nextAnimField = animationInfo.getClass().getDeclaredField("mNextAnim");
            $jacocoInit[5] = true;
            nextAnimField.setAccessible(true);
            $jacocoInit[6] = true;
            int nextAnimResource = nextAnimField.getInt(animationInfo);
            $jacocoInit[7] = true;
            Animation nextAnim = AnimationUtils.loadAnimation(fragment.getActivity(), nextAnimResource);
            $jacocoInit[8] = true;
            if (nextAnim == null) {
                $jacocoInit[9] = true;
                j = defValue;
            } else {
                j = nextAnim.getDuration();
                $jacocoInit[10] = true;
            }
            $jacocoInit[11] = true;
            return j;
        } catch (NotFoundException | IllegalAccessException | NoSuchFieldException ex) {
            $jacocoInit[12] = true;
            Logger instance = Logger.getInstance();
            $jacocoInit[13] = true;
            instance.mo2141e("BASE FRAGMENT", "Unable to load next animation from parent.", ex);
            $jacocoInit[14] = true;
            return defValue;
        }
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[15] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            bottomNavigationActivity2.toggleBottomNavigation();
            $jacocoInit[20] = true;
        }
        $jacocoInit[21] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentComponent = null;
        $jacocoInit[22] = true;
        super.onDestroy();
        $jacocoInit[23] = true;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[24] = true;
        super.onDetach();
        $jacocoInit[25] = true;
    }

    public FragmentComponent getFragmentComponent(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.fragmentComponent != null) {
            $jacocoInit[26] = true;
        } else {
            $jacocoInit[27] = true;
            AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
            $jacocoInit[28] = true;
            ActivityComponent activityComponent = ((BaseActivity) getActivity()).getActivityComponent();
            $jacocoInit[29] = true;
            Bundle arguments = getArguments();
            $jacocoInit[30] = true;
            boolean isCreateStoreUserPrivacyEnabled = aptoideApplication.isCreateStoreUserPrivacyEnabled();
            $jacocoInit[31] = true;
            String packageName = getActivity().getApplicationContext().getPackageName();
            $jacocoInit[32] = true;
            this.fragmentComponent = activityComponent.plus(aptoideApplication.getFragmentModule(this, savedInstanceState, arguments, isCreateStoreUserPrivacyEnabled, packageName), new FlavourFragmentModule());
            $jacocoInit[33] = true;
        }
        FragmentComponent fragmentComponent2 = this.fragmentComponent;
        $jacocoInit[34] = true;
        return fragmentComponent2;
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment removingParent = getRemovingParent(getParentFragment());
        if (enter) {
            $jacocoInit[35] = true;
        } else if (removingParent == null) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            Animation doNothingAnim = new AlphaAnimation(1.0f, 1.0f);
            $jacocoInit[38] = true;
            doNothingAnim.setDuration(getRemovingParentAnimationDuration(removingParent, 300));
            $jacocoInit[39] = true;
            return doNothingAnim;
        }
        Animation onCreateAnimation = super.onCreateAnimation(transit, enter, nextAnim);
        $jacocoInit[40] = true;
        return onCreateAnimation;
    }

    private Fragment getRemovingParent(Fragment fragment) {
        boolean[] $jacocoInit = $jacocoInit();
        if (fragment == null) {
            $jacocoInit[41] = true;
            return null;
        }
        Fragment parent = fragment.getParentFragment();
        $jacocoInit[42] = true;
        if (parent == null) {
            $jacocoInit[43] = true;
        } else if (!parent.isRemoving()) {
            $jacocoInit[44] = true;
        } else {
            Fragment removingParent = getRemovingParent(parent);
            $jacocoInit[45] = true;
            return removingParent;
        }
        if (fragment.isRemoving()) {
            $jacocoInit[46] = true;
            return fragment;
        }
        $jacocoInit[47] = true;
        return null;
    }
}
