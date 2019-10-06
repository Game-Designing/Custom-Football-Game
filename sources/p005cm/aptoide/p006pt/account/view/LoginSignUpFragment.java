package p005cm.aptoide.p006pt.account.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.C0231a;
import android.support.p001v7.widget.Toolbar;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.presenter.LoginSignUpView;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.fragment.BaseToolbarFragment;

/* renamed from: cm.aptoide.pt.account.view.LoginSignUpFragment */
public class LoginSignUpFragment extends BaseToolbarFragment implements LoginSignUpView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ACCOUNT_TYPE = "account_type";
    private static final String AUTH_TYPE = "auth_type";
    private static final String BOTTOM_SHEET_WITH_BOTTOM_BAR = "bottom_sheet_expanded";
    private static final String DISMISS_TO_NAVIGATE_TO_MAIN_VIEW = "dismiss_to_navigate_to_main_view";
    private static final String IS_NEW_ACCOUNT = "is_new_account";
    private static final String IS_WIZARD = "is_wizard";
    private static final String NAVIGATE_TO_HOME = "clean_back_stack";
    private BottomSheetBehavior<View> bottomSheetBehavior;
    private boolean dismissToNavigateToMainView;
    private boolean isWizard;
    private LoginBottomSheet loginBottomSheet;
    private View mainContent;
    private boolean navigateToHome;
    private int originalBottomPadding;
    private LoginSignUpPresenter presenter;
    private String toolbarTitle;
    private boolean withBottomBar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4239716942790993677L, "cm/aptoide/pt/account/view/LoginSignUpFragment", 68);
        $jacocoData = probes;
        return probes;
    }

    public LoginSignUpFragment() {
        $jacocoInit()[0] = true;
    }

    public static LoginSignUpFragment newInstance(boolean withBottomBar2, boolean dismissToNavigateToMainView2, boolean navigateToHome2, boolean isWizard2) {
        boolean[] $jacocoInit = $jacocoInit();
        LoginSignUpFragment newInstance = newInstance(withBottomBar2, dismissToNavigateToMainView2, navigateToHome2, "", "", true, isWizard2);
        $jacocoInit[1] = true;
        return newInstance;
    }

    public static LoginSignUpFragment newInstance(boolean withBottomBar2, boolean dismissToNavigateToMainView2, boolean navigateToHome2, String accountType, String authType, boolean isNewAccount, boolean isWizard2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[2] = true;
        args.putBoolean(BOTTOM_SHEET_WITH_BOTTOM_BAR, withBottomBar2);
        $jacocoInit[3] = true;
        args.putBoolean(DISMISS_TO_NAVIGATE_TO_MAIN_VIEW, dismissToNavigateToMainView2);
        $jacocoInit[4] = true;
        args.putBoolean(NAVIGATE_TO_HOME, navigateToHome2);
        $jacocoInit[5] = true;
        args.putString("account_type", accountType);
        $jacocoInit[6] = true;
        args.putString("auth_type", authType);
        $jacocoInit[7] = true;
        args.putBoolean(IS_NEW_ACCOUNT, isNewAccount);
        $jacocoInit[8] = true;
        args.putBoolean(IS_WIZARD, isWizard2);
        $jacocoInit[9] = true;
        LoginSignUpFragment fragment = new LoginSignUpFragment();
        $jacocoInit[10] = true;
        fragment.setArguments(args);
        $jacocoInit[11] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[12] = true;
        setHasOptionsMenu(true);
        $jacocoInit[13] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[14] = true;
        this.withBottomBar = args.getBoolean(BOTTOM_SHEET_WITH_BOTTOM_BAR);
        $jacocoInit[15] = true;
        this.dismissToNavigateToMainView = args.getBoolean(DISMISS_TO_NAVIGATE_TO_MAIN_VIEW);
        $jacocoInit[16] = true;
        this.navigateToHome = args.getBoolean(NAVIGATE_TO_HOME);
        $jacocoInit[17] = true;
        this.isWizard = args.getBoolean(IS_WIZARD);
        $jacocoInit[18] = true;
    }

    public void onAttach(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(context);
        if (context instanceof LoginBottomSheet) {
            this.loginBottomSheet = (LoginBottomSheet) context;
            $jacocoInit[21] = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Context should implement ");
        $jacocoInit[19] = true;
        sb.append(LoginBottomSheet.class.getSimpleName());
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[20] = true;
        throw illegalStateException;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.bottomSheetBehavior;
        if (bottomSheetBehavior2 == null) {
            $jacocoInit[22] = true;
        } else {
            $jacocoInit[23] = true;
            bottomSheetBehavior2.mo4272a((C0231a) null);
            this.bottomSheetBehavior = null;
            $jacocoInit[24] = true;
        }
        LoginSignUpPresenter loginSignUpPresenter = this.presenter;
        if (loginSignUpPresenter == null) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            unregisterClickHandler(loginSignUpPresenter);
            $jacocoInit[27] = true;
        }
        super.onDestroyView();
        $jacocoInit[28] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[29] = true;
        this.presenter = new LoginSignUpPresenter(this, getFragmentChildNavigator(C1375R.C1376id.login_signup_layout), this.dismissToNavigateToMainView, this.navigateToHome);
        $jacocoInit[30] = true;
        attachPresenter(this.presenter);
        $jacocoInit[31] = true;
        registerClickHandler(this.presenter);
        $jacocoInit[32] = true;
        this.bottomSheetBehavior.mo4272a((C0231a) this.presenter);
        $jacocoInit[33] = true;
    }

    /* access modifiers changed from: protected */
    public boolean hasToolbar() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.toolbarTitle != null) {
            $jacocoInit[34] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasToolbar = hasToolbar();
        $jacocoInit[37] = true;
        return hasToolbar;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((CharSequence) "");
        $jacocoInit[38] = true;
    }

    public void bindViews(View view) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        try {
            $jacocoInit[39] = true;
            this.bottomSheetBehavior = BottomSheetBehavior.m1373b(view.findViewById(C1375R.C1376id.login_signup_layout));
            $jacocoInit[40] = true;
        } catch (IllegalArgumentException e) {
            $jacocoInit[41] = true;
        }
        if (this.bottomSheetBehavior == null) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            this.mainContent = view.findViewById(C1375R.C1376id.main_content);
            $jacocoInit[44] = true;
            if (this.withBottomBar) {
                i = this.mainContent.getPaddingBottom();
                $jacocoInit[45] = true;
            } else {
                $jacocoInit[46] = true;
                i = 0;
            }
            this.originalBottomPadding = i;
            $jacocoInit[47] = true;
            this.toolbarTitle = getString(C1375R.string.my_account_title_my_account);
            $jacocoInit[48] = true;
            this.mainContent.setPadding(0, 0, 0, this.originalBottomPadding);
            $jacocoInit[49] = true;
            this.bottomSheetBehavior.mo4285c(4);
            $jacocoInit[50] = true;
        }
        $jacocoInit[51] = true;
    }

    public void collapseBottomSheet() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginBottomSheet.collapse();
        $jacocoInit[52] = true;
        this.mainContent.setPadding(0, 0, 0, this.originalBottomPadding);
        $jacocoInit[53] = true;
    }

    public void expandBottomSheet() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginBottomSheet.expand();
        $jacocoInit[54] = true;
        this.mainContent.setPadding(0, 0, 0, 0);
        $jacocoInit[55] = true;
    }

    public boolean bottomSheetIsExpanded() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.bottomSheetBehavior;
        if (bottomSheetBehavior2 == null) {
            $jacocoInit[56] = true;
        } else {
            $jacocoInit[57] = true;
            if (bottomSheetBehavior2.mo4284c() != 3) {
                $jacocoInit[58] = true;
            } else {
                $jacocoInit[59] = true;
                z = true;
                $jacocoInit[61] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[60] = true;
        $jacocoInit[61] = true;
        return z;
    }

    public void setBottomSheetState(int stateCollapsed) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomSheetBehavior.mo4285c(4);
        $jacocoInit[62] = true;
    }

    public int getContentViewId() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isWizard) {
            $jacocoInit[63] = true;
            return C1375R.layout.fragment_login_signup_wizard_layout;
        }
        $jacocoInit[64] = true;
        return C1375R.layout.fragment_login_sign_up;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[65] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[66] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[67] = true;
        return build;
    }
}
