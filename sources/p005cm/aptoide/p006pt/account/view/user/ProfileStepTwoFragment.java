package p005cm.aptoide.p006pt.account.view.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.fragment.BaseToolbarFragment;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.account.view.user.ProfileStepTwoFragment */
public class ProfileStepTwoFragment extends BaseToolbarFragment implements ProfileStepTwoView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int LAYOUT = 2131427506;
    @Inject
    AccountAnalytics accountAnalytics;
    private AccountNavigator accountNavigator;
    private Button continueBtn;
    private TextView createProfileTitle;
    private boolean externalLogin;
    @Inject
    LoginSignupManager loginSignupManager;
    @Inject
    MarketResourceFormatter marketResourceFormatter;
    private Button privateProfileBtn;
    private ProgressDialog waitDialog;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(93718146108382276L, "cm/aptoide/pt/account/view/user/ProfileStepTwoFragment", 58);
        $jacocoData = probes;
        return probes;
    }

    public ProfileStepTwoFragment() {
        $jacocoInit()[0] = true;
    }

    public static ProfileStepTwoFragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        ProfileStepTwoFragment profileStepTwoFragment = new ProfileStepTwoFragment();
        $jacocoInit[1] = true;
        return profileStepTwoFragment;
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
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        $jacocoInit[7] = true;
        Context context = getContext();
        $jacocoInit[8] = true;
        String string = getContext().getString(C1375R.string.please_wait);
        $jacocoInit[9] = true;
        this.waitDialog = GenericDialogs.createGenericPleaseWaitDialog(context, string);
        $jacocoInit[10] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        if (args == null) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            this.externalLogin = args.getBoolean(ProfileStepOneFragment.IS_EXTERNAL_LOGIN, false);
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[15] = true;
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null) {
            $jacocoInit[16] = true;
        } else if (!progressDialog.isShowing()) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            this.waitDialog.dismiss();
            $jacocoInit[19] = true;
        }
        $jacocoInit[20] = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewStateRestored(savedInstanceState);
        $jacocoInit[21] = true;
        loadExtras(savedInstanceState);
        $jacocoInit[22] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[23] = true;
        outState.putBoolean(ProfileStepOneFragment.IS_EXTERNAL_LOGIN, this.externalLogin);
        $jacocoInit[24] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[25] = true;
        return C1375R.layout.fragment_profile_step_two;
    }

    public C0120S<Boolean> continueButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.continueBtn);
        C1586ca caVar = new C1586ca(this);
        $jacocoInit[26] = true;
        C0120S<Boolean> j = a.mo3669j(caVar);
        $jacocoInit[27] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo9962a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.externalLogin);
        $jacocoInit[57] = true;
        return valueOf;
    }

    public C0120S<Boolean> makePrivateProfileButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.privateProfileBtn);
        C1588da daVar = new C1588da(this);
        $jacocoInit[28] = true;
        C0120S<Boolean> j = a.mo3669j(daVar);
        $jacocoInit[29] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ Boolean mo9963b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.externalLogin);
        $jacocoInit[56] = true;
        return valueOf;
    }

    public void showWaitDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null) {
            $jacocoInit[30] = true;
        } else if (progressDialog.isShowing()) {
            $jacocoInit[31] = true;
        } else {
            $jacocoInit[32] = true;
            this.waitDialog.show();
            $jacocoInit[33] = true;
        }
        $jacocoInit[34] = true;
    }

    public void dismissWaitDialog() {
        boolean[] $jacocoInit = $jacocoInit();
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

    /* renamed from: b */
    public /* synthetic */ void mo9964b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.waitDialog.dismiss();
        $jacocoInit[55] = true;
    }

    public C0117M showGenericErrorMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1590ea(this));
        $jacocoInit[40] = true;
        C0117M a = c.mo3580a(ShowMessage.asLongObservableSnack((Fragment) this, (int) C1375R.string.unknown_error));
        $jacocoInit[41] = true;
        return a;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[42] = true;
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[43] = true;
        AptoideAccountManager accountManager = aptoideApplication.getAccountManager();
        $jacocoInit[44] = true;
        ProfileStepTwoPresenter profileStepTwoPresenter = new ProfileStepTwoPresenter(this, accountManager, CrashReport.getInstance(), this.accountNavigator, this.accountAnalytics, this.loginSignupManager);
        $jacocoInit[45] = true;
        attachPresenter(profileStepTwoPresenter);
        $jacocoInit[46] = true;
    }

    /* access modifiers changed from: protected */
    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupToolbarDetails(toolbar);
        $jacocoInit[47] = true;
        toolbar.setTitle((int) C1375R.string.create_profile_logged_in_activity_title);
        $jacocoInit[48] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[49] = true;
        this.continueBtn = (Button) view.findViewById(C1375R.C1376id.logged_in_continue);
        $jacocoInit[50] = true;
        this.privateProfileBtn = (Button) view.findViewById(C1375R.C1376id.logged_in_private_button);
        $jacocoInit[51] = true;
        this.createProfileTitle = (TextView) view.findViewById(C1375R.C1376id.create_profile_title);
        TextView textView = this.createProfileTitle;
        MarketResourceFormatter marketResourceFormatter2 = this.marketResourceFormatter;
        $jacocoInit[52] = true;
        String formatString = marketResourceFormatter2.formatString(getContext(), C1375R.string.create_profile_pub_pri, new String[0]);
        $jacocoInit[53] = true;
        textView.setText(formatString);
        $jacocoInit[54] = true;
    }
}
