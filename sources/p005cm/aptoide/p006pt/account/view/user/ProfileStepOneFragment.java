package p005cm.aptoide.p006pt.account.view.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.LoginSignupManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.fragment.BaseToolbarFragment;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.user.ProfileStepOneFragment */
public class ProfileStepOneFragment extends BaseToolbarFragment implements ProfileStepOneView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String IS_EXTERNAL_LOGIN = "facebook_google";
    private static final int LAYOUT = 2131427505;
    @Inject
    AccountAnalytics accountAnalytics;
    @Inject
    AccountNavigator accountNavigator;
    private Button continueBtn;
    private boolean externalLogin;
    @Inject
    LoginSignupManager loginSignupManager;
    private Button moreInfoBtn;
    @Inject
    ScreenOrientationManager orientationManager;
    private ProgressDialog waitDialog;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-152989135742085367L, "cm/aptoide/pt/account/view/user/ProfileStepOneFragment", 51);
        $jacocoData = probes;
        return probes;
    }

    public ProfileStepOneFragment() {
        $jacocoInit()[0] = true;
    }

    public static ProfileStepOneFragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        ProfileStepOneFragment profileStepOneFragment = new ProfileStepOneFragment();
        $jacocoInit[1] = true;
        return profileStepOneFragment;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[2] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[3] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[4] = true;
        return build;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[5] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[6] = true;
        Context context = getContext();
        $jacocoInit[7] = true;
        String string = getContext().getString(C1375R.string.please_wait);
        $jacocoInit[8] = true;
        this.waitDialog = GenericDialogs.createGenericPleaseWaitDialog(context, string);
        $jacocoInit[9] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        if (args == null) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            this.externalLogin = args.getBoolean(IS_EXTERNAL_LOGIN, false);
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[14] = true;
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null) {
            $jacocoInit[15] = true;
        } else if (!progressDialog.isShowing()) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            this.waitDialog.dismiss();
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewStateRestored(savedInstanceState);
        $jacocoInit[20] = true;
        loadExtras(savedInstanceState);
        $jacocoInit[21] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[22] = true;
        outState.putBoolean(IS_EXTERNAL_LOGIN, this.externalLogin);
        $jacocoInit[23] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[24] = true;
        return C1375R.layout.fragment_profile_step_one;
    }

    public C0120S<Boolean> continueButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.continueBtn);
        C1564J j = new C1564J(this);
        $jacocoInit[25] = true;
        C0120S<Boolean> j2 = a.mo3669j(j);
        $jacocoInit[26] = true;
        return j2;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo9942a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.externalLogin);
        $jacocoInit[50] = true;
        return valueOf;
    }

    public C0120S<Void> moreInfoButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.moreInfoBtn);
        $jacocoInit[27] = true;
        return a;
    }

    public void showWaitDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.lock();
        $jacocoInit[28] = true;
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null) {
            $jacocoInit[29] = true;
        } else if (progressDialog.isShowing()) {
            $jacocoInit[30] = true;
        } else {
            $jacocoInit[31] = true;
            this.waitDialog.show();
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
    }

    public void dismissWaitDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.unlock();
        $jacocoInit[34] = true;
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null) {
            $jacocoInit[35] = true;
        } else if (!progressDialog.isShowing()) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            this.waitDialog.dismiss();
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
    }

    public C0117M showGenericErrorMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M asLongObservableSnack = ShowMessage.asLongObservableSnack((Fragment) this, (int) C1375R.string.unknown_error);
        $jacocoInit[40] = true;
        return asLongObservableSnack;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[41] = true;
        AptoideApplication aptoideApplication = (AptoideApplication) getActivity().getApplicationContext();
        $jacocoInit[42] = true;
        AptoideAccountManager accountManager = aptoideApplication.getAccountManager();
        $jacocoInit[43] = true;
        ProfileStepOnePresenter profileStepOnePresenter = new ProfileStepOnePresenter(this, CrashReport.getInstance(), accountManager, this.accountNavigator, this.accountAnalytics, this.loginSignupManager);
        attachPresenter(profileStepOnePresenter);
        $jacocoInit[44] = true;
    }

    /* access modifiers changed from: protected */
    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupToolbarDetails(toolbar);
        $jacocoInit[45] = true;
        toolbar.setTitle((int) C1375R.string.create_profile_logged_in_activity_title);
        $jacocoInit[46] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[47] = true;
        this.continueBtn = (Button) view.findViewById(C1375R.C1376id.logged_in_continue);
        $jacocoInit[48] = true;
        this.moreInfoBtn = (Button) view.findViewById(C1375R.C1376id.logged_in_more_info_button);
        $jacocoInit[49] = true;
    }
}
