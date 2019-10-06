package p005cm.aptoide.p006pt.view.wizard;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.view.ViewPager.C0600i;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.LoginBottomSheet;
import p005cm.aptoide.p006pt.account.view.LoginBottomSheet.State;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.custom.AptoideViewPager;
import p005cm.aptoide.p006pt.view.fragment.UIComponentFragment;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.view.wizard.WizardFragment */
public class WizardFragment extends UIComponentFragment implements WizardView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int LAYOUT = 2131427512;
    private static final String PAGE_INDEX = "page_index";
    private View animatedColorView;
    private int currentPosition;
    private boolean isInPortraitMode;
    private boolean isUserLoggedIn;
    private LoginBottomSheet loginBottomSheet;
    private C0600i pageChangeListener;
    private RadioGroup radioGroup;
    private Runnable registerViewpagerCurrentItem;
    private View skipOrNextLayout;
    private View skipText;
    private Integer[] transitionColors;
    private AptoideViewPager viewPager;
    private WizardPagerAdapter viewPagerAdapter;
    private List<RadioButton> wizardButtons;
    @Inject
    WizardFragmentProvider wizardFragmentProvider;
    @Inject
    WizardPresenter wizardPresenter;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-151176487317608694L, "cm/aptoide/pt/view/wizard/WizardFragment", 111);
        $jacocoData = probes;
        return probes;
    }

    public WizardFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ NavigationTracker access$000(WizardFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker = x0.navigationTracker;
        $jacocoInit[110] = true;
        return navigationTracker;
    }

    public static WizardFragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        WizardFragment wizardFragment = new WizardFragment();
        $jacocoInit[1] = true;
        return wizardFragment;
    }

    public void onAttach(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(context);
        if (context instanceof LoginBottomSheet) {
            this.loginBottomSheet = (LoginBottomSheet) context;
            $jacocoInit[4] = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Context should implement ");
        $jacocoInit[2] = true;
        sb.append(LoginBottomSheet.class.getSimpleName());
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[3] = true;
        throw illegalStateException;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[5] = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewStateRestored(savedInstanceState);
        $jacocoInit[6] = true;
        loadExtras(savedInstanceState);
        $jacocoInit[7] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[8] = true;
        outState.putInt(PAGE_INDEX, this.viewPager.getCurrentItem());
        $jacocoInit[9] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[10] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[11] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[12] = true;
        return build;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[13] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[14] = true;
        Integer[] colorInt = this.wizardFragmentProvider.getTransitionColors();
        this.transitionColors = new Integer[colorInt.length];
        int i = 0;
        $jacocoInit[15] = true;
        while (i < colorInt.length) {
            $jacocoInit[16] = true;
            Integer[] numArr = this.transitionColors;
            Resources resources = getContext().getResources();
            Integer num = colorInt[i];
            $jacocoInit[17] = true;
            int color = resources.getColor(num.intValue());
            $jacocoInit[18] = true;
            numArr[i] = Integer.valueOf(color);
            i++;
            $jacocoInit[19] = true;
        }
        $jacocoInit[20] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[21] = true;
        attachPresenter(this.wizardPresenter);
        $jacocoInit[22] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        this.currentPosition = 0;
        if (args == null) {
            $jacocoInit[23] = true;
        } else {
            $jacocoInit[24] = true;
            this.currentPosition = args.getInt(PAGE_INDEX, 0);
            $jacocoInit[25] = true;
        }
        $jacocoInit[26] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S state = this.loginBottomSheet.state();
        $jacocoInit[27] = true;
        C0120S a = state.mo3616a(C14522a.m46170a());
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[28] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C5555b bVar2 = new C5555b(this);
        $jacocoInit[29] = true;
        a2.mo3646c((C0129b<? super T>) bVar2);
        $jacocoInit[30] = true;
        this.pageChangeListener = new C0600i(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ WizardFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(373144750867687681L, "cm/aptoide/pt/view/wizard/WizardFragment$1", 7);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onPageSelected(int position) {
                boolean[] $jacocoInit = $jacocoInit();
                if (position != 0) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    NavigationTracker access$000 = WizardFragment.access$000(this.this$0);
                    $jacocoInit[3] = true;
                    ScreenTagHistory build = Builder.build(WizardPageOneFragment.class.getSimpleName(), BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                    $jacocoInit[4] = true;
                    access$000.registerScreen(build);
                    $jacocoInit[5] = true;
                }
                $jacocoInit[6] = true;
            }
        };
        $jacocoInit[31] = true;
        this.viewPager.addOnPageChangeListener(this.wizardPresenter);
        $jacocoInit[32] = true;
        this.viewPager.addOnPageChangeListener(this.pageChangeListener);
        $jacocoInit[33] = true;
        this.registerViewpagerCurrentItem = new C5554a(this);
        $jacocoInit[34] = true;
        this.viewPager.post(this.registerViewpagerCurrentItem);
        $jacocoInit[35] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17566a(State state) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.isInPortraitMode) {
            $jacocoInit[102] = true;
        } else if (!State.EXPANDED.equals(state)) {
            $jacocoInit[103] = true;
        } else {
            $jacocoInit[104] = true;
            this.skipOrNextLayout.setVisibility(8);
            $jacocoInit[105] = true;
            $jacocoInit[109] = true;
        }
        if (!State.COLLAPSED.equals(state)) {
            $jacocoInit[106] = true;
        } else {
            $jacocoInit[107] = true;
            this.skipOrNextLayout.setVisibility(0);
            $jacocoInit[108] = true;
        }
        $jacocoInit[109] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17568b() {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideViewPager aptoideViewPager = this.viewPager;
        if (aptoideViewPager == null) {
            $jacocoInit[98] = true;
        } else {
            $jacocoInit[99] = true;
            this.pageChangeListener.onPageSelected(aptoideViewPager.getCurrentItem());
            $jacocoInit[100] = true;
        }
        $jacocoInit[101] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.viewPager.removeOnPageChangeListener(this.pageChangeListener);
        $jacocoInit[36] = true;
        this.viewPager.setAdapter(null);
        $jacocoInit[37] = true;
        this.viewPager.removeCallbacks(this.registerViewpagerCurrentItem);
        $jacocoInit[38] = true;
        this.viewPager.removeOnPageChangeListener(null);
        this.registerViewpagerCurrentItem = null;
        this.viewPager = null;
        this.skipOrNextLayout = null;
        this.wizardButtons = null;
        this.radioGroup = null;
        this.skipText = null;
        this.animatedColorView = null;
        $jacocoInit[39] = true;
        super.onDestroyView();
        $jacocoInit[40] = true;
    }

    public C0117M createWizardAdapter(boolean isLoggedIn) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isUserLoggedIn = isLoggedIn;
        $jacocoInit[41] = true;
        C0117M c = C0117M.m597c((C0128a) new C5556c(this, isLoggedIn));
        $jacocoInit[42] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17567a(boolean isLoggedIn) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[92] = true;
        this.viewPagerAdapter = new WizardPagerAdapter(getChildFragmentManager(), Boolean.valueOf(isLoggedIn), this.wizardFragmentProvider);
        $jacocoInit[93] = true;
        createRadioButtons();
        $jacocoInit[94] = true;
        this.viewPager.setAdapter(this.viewPagerAdapter);
        $jacocoInit[95] = true;
        this.viewPager.setCurrentItem(this.currentPosition);
        $jacocoInit[96] = true;
        handleSelectedPage(this.currentPosition);
        $jacocoInit[97] = true;
    }

    public C0120S<Void> skipWizardClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.skipText);
        $jacocoInit[43] = true;
        return a;
    }

    public void skipWizard() {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p activity = getActivity();
        $jacocoInit[44] = true;
        activity.onBackPressed();
        $jacocoInit[45] = true;
    }

    public void handleSelectedPage(int selectedPage) {
        boolean[] $jacocoInit = $jacocoInit();
        List<RadioButton> list = this.wizardButtons;
        if (list == null) {
            $jacocoInit[46] = true;
        } else if (selectedPage >= list.size()) {
            $jacocoInit[47] = true;
        } else {
            RadioButton radioButton = (RadioButton) this.wizardButtons.get(selectedPage);
            if (radioButton == null) {
                $jacocoInit[49] = true;
            } else {
                $jacocoInit[50] = true;
                radioButton.setChecked(true);
                $jacocoInit[51] = true;
            }
            $jacocoInit[52] = true;
            return;
        }
        $jacocoInit[48] = true;
    }

    public void handleColorTransitions(int position, float positionOffset, int positionOffsetPixels) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.animatedColorView == null) {
            $jacocoInit[53] = true;
        } else {
            $jacocoInit[54] = true;
            if (position >= this.viewPagerAdapter.getCount() - 1) {
                $jacocoInit[55] = true;
            } else if (position >= this.transitionColors.length - 1) {
                $jacocoInit[56] = true;
            } else {
                $jacocoInit[57] = true;
                ArgbEvaluator argbEvaluator = new ArgbEvaluator();
                Integer[] numArr = this.transitionColors;
                Integer num = numArr[position];
                Integer num2 = numArr[position + 1];
                $jacocoInit[58] = true;
                int argbEvaluation = ((Integer) argbEvaluator.evaluate(positionOffset, num, num2)).intValue();
                $jacocoInit[59] = true;
                this.animatedColorView.setBackgroundColor(argbEvaluation);
                $jacocoInit[60] = true;
            }
            if (this.viewPagerAdapter.isLoggedIn()) {
                $jacocoInit[61] = true;
                View view = this.animatedColorView;
                Integer[] numArr2 = this.transitionColors;
                view.setBackgroundColor(numArr2[numArr2.length - 2].intValue());
                $jacocoInit[62] = true;
            } else {
                View view2 = this.animatedColorView;
                Integer[] numArr3 = this.transitionColors;
                view2.setBackgroundColor(numArr3[numArr3.length - 1].intValue());
                $jacocoInit[63] = true;
            }
        }
        $jacocoInit[64] = true;
    }

    public int getCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int count = this.wizardFragmentProvider.getCount(Boolean.valueOf(this.isUserLoggedIn));
        $jacocoInit[65] = true;
        return count;
    }

    private void createRadioButtons() {
        boolean[] $jacocoInit = $jacocoInit();
        int buttonSize = ScreenU.getPixelsForDip(10, getResources());
        $jacocoInit[66] = true;
        MarginLayoutParams layoutParams = new LayoutParams(buttonSize, buttonSize);
        $jacocoInit[67] = true;
        int buttonMargin = ScreenU.getPixelsForDip(2, getResources());
        MarginLayoutParams marginLayoutParams = layoutParams;
        $jacocoInit[68] = true;
        marginLayoutParams.setMargins(buttonMargin, buttonMargin, buttonMargin, buttonMargin);
        $jacocoInit[69] = true;
        int pages = this.viewPagerAdapter.getCount();
        $jacocoInit[70] = true;
        this.wizardButtons = new ArrayList(pages);
        $jacocoInit[71] = true;
        Context context = getContext();
        int i = 0;
        $jacocoInit[72] = true;
        while (i < pages) {
            $jacocoInit[73] = true;
            RadioButton radioButton = new RadioButton(context);
            $jacocoInit[74] = true;
            radioButton.setLayoutParams(layoutParams);
            $jacocoInit[75] = true;
            radioButton.setButtonDrawable(17170445);
            $jacocoInit[76] = true;
            radioButton.setBackgroundResource(C1375R.drawable.wizard_custom_indicator);
            $jacocoInit[77] = true;
            radioButton.setClickable(false);
            $jacocoInit[78] = true;
            this.radioGroup.addView(radioButton);
            $jacocoInit[79] = true;
            this.wizardButtons.add(radioButton);
            i++;
            $jacocoInit[80] = true;
        }
        $jacocoInit[81] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[82] = true;
        return C1375R.layout.fragment_wizard;
    }

    public void bindViews(View view) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        this.viewPager = (AptoideViewPager) view.findViewById(C1375R.C1376id.view_pager);
        $jacocoInit[83] = true;
        this.skipOrNextLayout = view.findViewById(C1375R.C1376id.skip_next_layout);
        $jacocoInit[84] = true;
        this.radioGroup = (RadioGroup) view.findViewById(C1375R.C1376id.view_pager_radio_group);
        $jacocoInit[85] = true;
        this.skipText = view.findViewById(C1375R.C1376id.skip_text);
        $jacocoInit[86] = true;
        Resources resources = getActivity().getResources();
        $jacocoInit[87] = true;
        if (resources.getConfiguration().orientation == 1) {
            $jacocoInit[88] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[89] = true;
        }
        this.isInPortraitMode = z;
        $jacocoInit[90] = true;
        this.animatedColorView = view.findViewById(C1375R.C1376id.animated_color_view);
        $jacocoInit[91] = true;
    }
}
