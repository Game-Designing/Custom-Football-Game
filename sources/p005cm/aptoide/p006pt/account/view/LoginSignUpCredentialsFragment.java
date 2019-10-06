package p005cm.aptoide.p006pt.account.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C0307r.C0308a;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.C0266a;
import android.support.p000v4.widget.C0694g;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideCredentials;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.StartupClick;
import p005cm.aptoide.p006pt.account.AccountAnalytics.StartupClickOrigin;
import p005cm.aptoide.p006pt.orientation.ScreenOrientationManager;
import p005cm.aptoide.p006pt.presenter.LoginSignUpCredentialsView;
import p005cm.aptoide.p006pt.presenter.LoginSignupCredentialsFlavorPresenter;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment */
public class LoginSignUpCredentialsFragment extends GooglePlayServicesFragment implements LoginSignUpCredentialsView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String CLEAN_BACK_STACK = "clean_back_stack";
    private static final String DISMISS_TO_NAVIGATE_TO_MAIN_VIEW = "dismiss_to_navigate_to_main_view";
    private static final String PASSWORD_KEY = "password_key";
    private static final String USERNAME_KEY = "username_key";
    @Inject
    AccountAnalytics accountAnalytics;
    private EditText aptoideEmailEditText;
    private EditText aptoidePasswordEditText;
    private BottomSheetBehavior<View> bottomSheetBehavior;
    private Button buttonLogin;
    private Button buttonSignUp;
    private Drawable checkboxDrawable;
    private View credentialsEditTextsArea;
    private RxAlertDialog facebookEmailRequiredDialog;
    private View facebookLoginButton;
    private TextView forgotPasswordButton;
    private Button googleLoginButton;
    private Button hideShowAptoidePasswordButton;
    private boolean isPasswordVisible = false;
    private View loginArea;
    private Button loginSelectionButton;
    private View loginSignupSelectionArea;
    @Inject
    String marketName;
    @Inject
    ScreenOrientationManager orientationManager;
    private int originalHeight;
    @Inject
    LoginSignupCredentialsFlavorPresenter presenter;
    private C14963c<Void> privacyPolicySubject;
    private ProgressDialog progressDialog;
    private View rootView;
    private View separator;
    private View signUpArea;
    private Button signUpSelectionButton;
    private TextView termsAndConditions;
    private C14963c<Void> termsAndConditionsSubject;
    private CheckBox termsConditionCheckBox;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8594446621815696857L, "cm/aptoide/pt/account/view/LoginSignUpCredentialsFragment", 211);
        $jacocoData = probes;
        return probes;
    }

    public LoginSignUpCredentialsFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    static /* synthetic */ BottomSheetBehavior access$000(LoginSignUpCredentialsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomSheetBehavior<View> bottomSheetBehavior2 = x0.bottomSheetBehavior;
        $jacocoInit[208] = true;
        return bottomSheetBehavior2;
    }

    static /* synthetic */ C14963c access$100(LoginSignUpCredentialsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = x0.termsAndConditionsSubject;
        $jacocoInit[209] = true;
        return cVar;
    }

    static /* synthetic */ C14963c access$200(LoginSignUpCredentialsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = x0.privacyPolicySubject;
        $jacocoInit[210] = true;
        return cVar;
    }

    public static LoginSignUpCredentialsFragment newInstance(boolean dismissToNavigateToMainView, boolean cleanBackStack) {
        boolean[] $jacocoInit = $jacocoInit();
        LoginSignUpCredentialsFragment fragment = new LoginSignUpCredentialsFragment();
        $jacocoInit[1] = true;
        Bundle bundle = new Bundle();
        $jacocoInit[2] = true;
        bundle.putBoolean(DISMISS_TO_NAVIGATE_TO_MAIN_VIEW, dismissToNavigateToMainView);
        $jacocoInit[3] = true;
        bundle.putBoolean(CLEAN_BACK_STACK, cleanBackStack);
        $jacocoInit[4] = true;
        fragment.setArguments(bundle);
        $jacocoInit[5] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[6] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[7] = true;
        this.privacyPolicySubject = C14963c.m46753p();
        $jacocoInit[8] = true;
        this.termsAndConditionsSubject = C14963c.m46753p();
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

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.privacyPolicySubject = null;
        this.termsAndConditionsSubject = null;
        $jacocoInit[13] = true;
        super.onDestroy();
        $jacocoInit[14] = true;
    }

    public void hideKeyboard() {
        boolean[] $jacocoInit = $jacocoInit();
        super.hideKeyboard();
        $jacocoInit[15] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[16] = true;
        View inflate = inflater.inflate(C1375R.layout.fragment_login_sign_up_credentials, container, false);
        $jacocoInit[17] = true;
        return inflate;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            String str = "";
            this.aptoideEmailEditText.setText(savedInstanceState.getString(USERNAME_KEY, str));
            $jacocoInit[20] = true;
            this.aptoidePasswordEditText.setText(savedInstanceState.getString(PASSWORD_KEY, str));
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        if (outState == null) {
            $jacocoInit[23] = true;
        } else {
            EditText editText = this.aptoideEmailEditText;
            if (editText == null) {
                $jacocoInit[24] = true;
            } else if (this.aptoidePasswordEditText == null) {
                $jacocoInit[25] = true;
            } else {
                $jacocoInit[26] = true;
                Editable text = editText.getText();
                $jacocoInit[27] = true;
                String obj = text.toString();
                $jacocoInit[28] = true;
                outState.putString(USERNAME_KEY, obj);
                $jacocoInit[29] = true;
                Editable text2 = this.aptoidePasswordEditText.getText();
                $jacocoInit[30] = true;
                String obj2 = text2.toString();
                $jacocoInit[31] = true;
                outState.putString(PASSWORD_KEY, obj2);
                $jacocoInit[32] = true;
            }
        }
        $jacocoInit[33] = true;
    }

    public C0120S<Void> showAptoideLoginAreaClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.loginSelectionButton);
        $jacocoInit[34] = true;
        return a;
    }

    public C0120S<Boolean> showAptoideSignUpAreaClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.signUpSelectionButton);
        C1484aa aaVar = new C1484aa(this);
        $jacocoInit[35] = true;
        C0120S<Boolean> j = a.mo3669j(aaVar);
        $jacocoInit[36] = true;
        return j;
    }

    /* renamed from: g */
    public /* synthetic */ Boolean mo9721g(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.termsConditionCheckBox.isChecked());
        $jacocoInit[207] = true;
        return valueOf;
    }

    public C0120S<Void> googleSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.googleLoginButton);
        C1486ba baVar = new C1486ba(this);
        $jacocoInit[37] = true;
        C0120S<Void> b = a.mo3636b((C0129b<? super T>) baVar);
        $jacocoInit[38] = true;
        return b;
    }

    /* renamed from: f */
    public /* synthetic */ void mo9717f(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountAnalytics accountAnalytics2 = this.accountAnalytics;
        StartupClick startupClick = StartupClick.CONNECT_GOOGLE;
        $jacocoInit[204] = true;
        StartupClickOrigin startupClickOrigin = getStartupClickOrigin();
        $jacocoInit[205] = true;
        accountAnalytics2.clickIn(startupClick, startupClickOrigin);
        $jacocoInit[206] = true;
    }

    public C0120S<Void> showHidePasswordClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.hideShowAptoidePasswordButton);
        $jacocoInit[39] = true;
        return a;
    }

    public C0120S<Void> forgotPasswordClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.forgotPasswordButton);
        $jacocoInit[40] = true;
        return a;
    }

    public C0120S<Void> facebookSignUpWithRequiredPermissionsInEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S positiveClicks = this.facebookEmailRequiredDialog.positiveClicks();
        C1482Z z = C1482Z.f4404a;
        $jacocoInit[41] = true;
        C0120S<Void> j = positiveClicks.mo3669j(z);
        $jacocoInit[42] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Void m6270a(DialogInterface dialog) {
        $jacocoInit()[203] = true;
        return null;
    }

    public C0120S<Void> facebookSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.facebookLoginButton);
        C1488ca caVar = new C1488ca(this);
        $jacocoInit[43] = true;
        C0120S<Void> b = a.mo3636b((C0129b<? super T>) caVar);
        $jacocoInit[44] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ void mo9716e(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountAnalytics accountAnalytics2 = this.accountAnalytics;
        StartupClick startupClick = StartupClick.CONNECT_FACEBOOK;
        $jacocoInit[200] = true;
        StartupClickOrigin startupClickOrigin = getStartupClickOrigin();
        $jacocoInit[201] = true;
        accountAnalytics2.clickIn(startupClick, startupClickOrigin);
        $jacocoInit[202] = true;
    }

    public C0120S<AptoideCredentials> aptoideLoginEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.buttonLogin);
        C1479W w = new C1479W(this);
        $jacocoInit[45] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) w);
        C1480X x = new C1480X(this);
        $jacocoInit[46] = true;
        C0120S<AptoideCredentials> j = b.mo3669j(x);
        $jacocoInit[47] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9709a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountAnalytics accountAnalytics2 = this.accountAnalytics;
        StartupClick startupClick = StartupClick.LOGIN;
        $jacocoInit[197] = true;
        StartupClickOrigin startupClickOrigin = getStartupClickOrigin();
        $jacocoInit[198] = true;
        accountAnalytics2.clickIn(startupClick, startupClickOrigin);
        $jacocoInit[199] = true;
    }

    /* renamed from: b */
    public /* synthetic */ AptoideCredentials mo9712b(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideCredentials credentials = getCredentials();
        $jacocoInit[196] = true;
        return credentials;
    }

    public C0120S<AptoideCredentials> aptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.buttonSignUp);
        C1481Y y = new C1481Y(this);
        $jacocoInit[48] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) y);
        C1490da daVar = new C1490da(this);
        $jacocoInit[49] = true;
        C0120S<AptoideCredentials> j = b.mo3669j(daVar);
        $jacocoInit[50] = true;
        return j;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9713c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountAnalytics accountAnalytics2 = this.accountAnalytics;
        StartupClick startupClick = StartupClick.JOIN_APTOIDE;
        $jacocoInit[193] = true;
        StartupClickOrigin startupClickOrigin = getStartupClickOrigin();
        $jacocoInit[194] = true;
        accountAnalytics2.clickIn(startupClick, startupClickOrigin);
        $jacocoInit[195] = true;
    }

    /* renamed from: d */
    public /* synthetic */ AptoideCredentials mo9714d(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideCredentials credentials = getCredentials();
        $jacocoInit[192] = true;
        return credentials;
    }

    public C0120S<Void> termsAndConditionsClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.termsAndConditionsSubject;
        $jacocoInit[51] = true;
        return cVar;
    }

    public C0120S<Void> privacyPolicyClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.privacyPolicySubject;
        $jacocoInit[52] = true;
        return cVar;
    }

    public void showAptoideSignUpArea() {
        boolean[] $jacocoInit = $jacocoInit();
        setAptoideSignUpAreaVisible();
        $jacocoInit[53] = true;
        this.loginArea.setVisibility(8);
        $jacocoInit[54] = true;
        this.signUpArea.setVisibility(0);
        $jacocoInit[55] = true;
        this.separator.setVisibility(8);
        $jacocoInit[56] = true;
        this.termsConditionCheckBox.setVisibility(8);
        $jacocoInit[57] = true;
        this.termsAndConditions.setVisibility(8);
        $jacocoInit[58] = true;
    }

    public void showAptoideLoginArea() {
        boolean[] $jacocoInit = $jacocoInit();
        setAptoideLoginAreaVisible();
        $jacocoInit[59] = true;
        this.loginArea.setVisibility(0);
        $jacocoInit[60] = true;
        this.signUpArea.setVisibility(8);
        $jacocoInit[61] = true;
        this.separator.setVisibility(8);
        $jacocoInit[62] = true;
        this.termsConditionCheckBox.setVisibility(8);
        $jacocoInit[63] = true;
        this.termsAndConditions.setVisibility(8);
        $jacocoInit[64] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressDialog.show();
        $jacocoInit[65] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressDialog.dismiss();
        $jacocoInit[66] = true;
    }

    public void showError(String message) {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(this.rootView, (CharSequence) message, 0);
        $jacocoInit[67] = true;
        a.mo4690h();
        $jacocoInit[68] = true;
    }

    public void showTermsConditionError() {
        boolean[] $jacocoInit = $jacocoInit();
        View view = this.rootView;
        $jacocoInit[69] = true;
        Snackbar snackbar = Snackbar.m1624a(view, (CharSequence) getString(C1375R.string.signup_message_no_tandc_error), 4500);
        $jacocoInit[70] = true;
        if (getResources().getConfiguration().orientation != 1) {
            $jacocoInit[71] = true;
        } else {
            $jacocoInit[72] = true;
            snackbar.mo4678a((C0308a<B>) new C0266a(this) {
                private static transient /* synthetic */ boolean[] $jacocoData;
                final /* synthetic */ LoginSignUpCredentialsFragment this$0;

                private static /* synthetic */ boolean[] $jacocoInit() {
                    boolean[] zArr = $jacocoData;
                    if (zArr != null) {
                        return zArr;
                    }
                    boolean[] probes = Offline.getProbes(5092528956990344414L, "cm/aptoide/pt/account/view/LoginSignUpCredentialsFragment$1", 4);
                    $jacocoData = probes;
                    return probes;
                }

                {
                    boolean[] $jacocoInit = $jacocoInit();
                    this.this$0 = this$0;
                    $jacocoInit[0] = true;
                }

                public /* bridge */ /* synthetic */ void onShown(Object obj) {
                    boolean[] $jacocoInit = $jacocoInit();
                    onShown((Snackbar) obj);
                    $jacocoInit[3] = true;
                }

                public void onShown(Snackbar snackbar) {
                    boolean[] $jacocoInit = $jacocoInit();
                    float newHeight = this.this$0.getResources().getDisplayMetrics().density * 360.0f;
                    $jacocoInit[1] = true;
                    LoginSignUpCredentialsFragment.access$000(this.this$0).mo4280b((int) newHeight);
                    $jacocoInit[2] = true;
                }
            });
            $jacocoInit[73] = true;
        }
        snackbar.mo4690h();
        $jacocoInit[74] = true;
        ConstantState constantState = this.checkboxDrawable.getConstantState();
        $jacocoInit[75] = true;
        Drawable newDrawable = constantState.newDrawable();
        $jacocoInit[76] = true;
        Drawable replacementDrawable = newDrawable.mutate();
        $jacocoInit[77] = true;
        replacementDrawable.setColorFilter(getResources().getColor(C1375R.color.red), Mode.SRC_ATOP);
        $jacocoInit[78] = true;
        this.termsConditionCheckBox.setButtonDrawable(replacementDrawable);
        $jacocoInit[79] = true;
        this.termsConditionCheckBox.setOnCheckedChangeListener(new C1492ea(this));
        $jacocoInit[80] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9708a(CompoundButton buttonView, boolean isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        this.termsConditionCheckBox.setButtonDrawable(this.checkboxDrawable);
        $jacocoInit[191] = true;
    }

    public void showFacebookLogin() {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookLoginButton.setVisibility(0);
        $jacocoInit[81] = true;
    }

    public void showFacebookPermissionsRequiredError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.facebookEmailRequiredDialog.isShowing()) {
            $jacocoInit[82] = true;
        } else {
            $jacocoInit[83] = true;
            this.facebookEmailRequiredDialog.show();
            $jacocoInit[84] = true;
        }
        $jacocoInit[85] = true;
    }

    public void hideFacebookLogin() {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookLoginButton.setVisibility(8);
        $jacocoInit[86] = true;
    }

    public void showPassword() {
        boolean[] $jacocoInit = $jacocoInit();
        this.isPasswordVisible = true;
        $jacocoInit[87] = true;
        this.aptoidePasswordEditText.setTransformationMethod(null);
        $jacocoInit[88] = true;
        this.hideShowAptoidePasswordButton.setBackgroundResource(C1375R.drawable.ic_open_eye);
        $jacocoInit[89] = true;
    }

    public void hidePassword() {
        boolean[] $jacocoInit = $jacocoInit();
        this.isPasswordVisible = false;
        $jacocoInit[90] = true;
        this.aptoidePasswordEditText.setTransformationMethod(new PasswordTransformationMethod());
        $jacocoInit[91] = true;
        this.hideShowAptoidePasswordButton.setBackgroundResource(C1375R.drawable.ic_closed_eye);
        $jacocoInit[92] = true;
    }

    public void dismiss() {
        boolean[] $jacocoInit = $jacocoInit();
        getActivity().finish();
        $jacocoInit[93] = true;
    }

    public void showGoogleLogin() {
        boolean[] $jacocoInit = $jacocoInit();
        this.googleLoginButton.setVisibility(0);
        $jacocoInit[94] = true;
    }

    public void hideGoogleLogin() {
        boolean[] $jacocoInit = $jacocoInit();
        this.googleLoginButton.setVisibility(8);
        $jacocoInit[95] = true;
    }

    public boolean tryCloseLoginBottomSheet(boolean shouldShowTCandPP) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.credentialsEditTextsArea.getVisibility() == 0) {
            $jacocoInit[96] = true;
            this.bottomSheetBehavior.mo4280b(this.originalHeight);
            $jacocoInit[97] = true;
            this.credentialsEditTextsArea.setVisibility(8);
            $jacocoInit[98] = true;
            this.loginSignupSelectionArea.setVisibility(0);
            $jacocoInit[99] = true;
            this.loginArea.setVisibility(8);
            $jacocoInit[100] = true;
            this.signUpArea.setVisibility(8);
            $jacocoInit[101] = true;
            this.separator.setVisibility(0);
            if (!shouldShowTCandPP) {
                $jacocoInit[102] = true;
            } else {
                $jacocoInit[103] = true;
                this.termsConditionCheckBox.setVisibility(0);
                $jacocoInit[104] = true;
                this.termsAndConditions.setVisibility(0);
                $jacocoInit[105] = true;
            }
            $jacocoInit[106] = true;
            return true;
        }
        $jacocoInit[107] = true;
        return false;
    }

    public boolean isPasswordVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isPasswordVisible;
        $jacocoInit[108] = true;
        return z;
    }

    public Context getApplicationContext() {
        boolean[] $jacocoInit = $jacocoInit();
        Context applicationContext = getActivity().getApplicationContext();
        $jacocoInit[109] = true;
        return applicationContext;
    }

    public void lockScreenRotation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.lock();
        $jacocoInit[110] = true;
    }

    public void unlockScreenRotation() {
        boolean[] $jacocoInit = $jacocoInit();
        this.orientationManager.unlock();
        $jacocoInit[111] = true;
    }

    private AptoideCredentials getCredentials() {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.aptoideEmailEditText.getText();
        $jacocoInit[112] = true;
        String obj = text.toString();
        Editable text2 = this.aptoidePasswordEditText.getText();
        $jacocoInit[113] = true;
        AptoideCredentials aptoideCredentials = new AptoideCredentials(obj, text2.toString(), this.termsConditionCheckBox.isChecked());
        $jacocoInit[114] = true;
        return aptoideCredentials;
    }

    private StartupClickOrigin getStartupClickOrigin() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loginArea.getVisibility() == 0) {
            StartupClickOrigin startupClickOrigin = StartupClickOrigin.LOGIN_UP;
            $jacocoInit[115] = true;
            return startupClickOrigin;
        } else if (this.signUpArea.getVisibility() == 0) {
            StartupClickOrigin startupClickOrigin2 = StartupClickOrigin.JOIN_UP;
            $jacocoInit[116] = true;
            return startupClickOrigin2;
        } else {
            StartupClickOrigin startupClickOrigin3 = StartupClickOrigin.MAIN;
            $jacocoInit[117] = true;
            return startupClickOrigin3;
        }
    }

    private void setAptoideLoginAreaVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        this.credentialsEditTextsArea.setVisibility(0);
        $jacocoInit[118] = true;
        this.loginSignupSelectionArea.setVisibility(8);
        if (this.bottomSheetBehavior == null) {
            $jacocoInit[119] = true;
        } else {
            $jacocoInit[120] = true;
            float newHeight = getResources().getDisplayMetrics().density * 320.0f;
            $jacocoInit[121] = true;
            this.bottomSheetBehavior.mo4280b((int) newHeight);
            $jacocoInit[122] = true;
        }
        $jacocoInit[123] = true;
    }

    private void setAptoideSignUpAreaVisible() {
        boolean[] $jacocoInit = $jacocoInit();
        this.credentialsEditTextsArea.setVisibility(0);
        $jacocoInit[124] = true;
        this.loginSignupSelectionArea.setVisibility(8);
        if (this.bottomSheetBehavior == null) {
            $jacocoInit[125] = true;
        } else {
            $jacocoInit[126] = true;
            float newHeight = getResources().getDisplayMetrics().density * 280.0f;
            $jacocoInit[127] = true;
            this.bottomSheetBehavior.mo4280b((int) newHeight);
            $jacocoInit[128] = true;
        }
        $jacocoInit[129] = true;
    }

    public void setCobrandText() {
        boolean[] $jacocoInit = $jacocoInit();
        Button button = this.buttonSignUp;
        String string = getString(C1375R.string.join_company);
        $jacocoInit[130] = true;
        Object[] objArr = {getResources().getString(C1375R.string.app_name)};
        $jacocoInit[131] = true;
        button.setText(String.format(string, objArr));
        $jacocoInit[132] = true;
        Button button2 = this.signUpSelectionButton;
        String string2 = getString(C1375R.string.join_company);
        $jacocoInit[133] = true;
        Object[] objArr2 = {getResources().getString(C1375R.string.app_name)};
        $jacocoInit[134] = true;
        button2.setText(String.format(string2, objArr2));
        $jacocoInit[135] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[136] = true;
        this.rootView = getActivity().findViewById(16908290);
        $jacocoInit[137] = true;
        this.forgotPasswordButton = (TextView) view.findViewById(C1375R.C1376id.forgot_password);
        $jacocoInit[138] = true;
        this.googleLoginButton = (Button) view.findViewById(C1375R.C1376id.google_login_button);
        $jacocoInit[139] = true;
        this.buttonLogin = (Button) view.findViewById(C1375R.C1376id.button_login);
        $jacocoInit[140] = true;
        this.buttonSignUp = (Button) view.findViewById(C1375R.C1376id.button_sign_up);
        $jacocoInit[141] = true;
        this.aptoideEmailEditText = (EditText) view.findViewById(C1375R.C1376id.username);
        $jacocoInit[142] = true;
        this.aptoidePasswordEditText = (EditText) view.findViewById(C1375R.C1376id.password);
        $jacocoInit[143] = true;
        this.hideShowAptoidePasswordButton = (Button) view.findViewById(C1375R.C1376id.btn_show_hide_pass);
        $jacocoInit[144] = true;
        this.facebookLoginButton = view.findViewById(C1375R.C1376id.fb_login_button);
        $jacocoInit[145] = true;
        this.loginSignupSelectionArea = view.findViewById(C1375R.C1376id.login_signup_selection_layout);
        $jacocoInit[146] = true;
        this.credentialsEditTextsArea = view.findViewById(C1375R.C1376id.credentials_edit_texts);
        $jacocoInit[147] = true;
        this.signUpSelectionButton = (Button) view.findViewById(C1375R.C1376id.show_join_aptoide_area);
        $jacocoInit[148] = true;
        this.loginSelectionButton = (Button) view.findViewById(C1375R.C1376id.show_login_with_aptoide_area);
        $jacocoInit[149] = true;
        this.loginArea = view.findViewById(C1375R.C1376id.login_button_area);
        $jacocoInit[150] = true;
        this.signUpArea = view.findViewById(C1375R.C1376id.sign_up_button_area);
        $jacocoInit[151] = true;
        this.separator = view.findViewById(C1375R.C1376id.separator);
        $jacocoInit[152] = true;
        RxAlertDialog.Builder message = new RxAlertDialog.Builder(getContext()).setMessage(C1375R.string.facebook_email_permission_regected_message);
        $jacocoInit[153] = true;
        RxAlertDialog.Builder positiveButton = message.setPositiveButton(C1375R.string.facebook_grant_permission_button);
        $jacocoInit[154] = true;
        RxAlertDialog.Builder negativeButton = positiveButton.setNegativeButton(17039360);
        $jacocoInit[155] = true;
        this.facebookEmailRequiredDialog = negativeButton.build();
        $jacocoInit[156] = true;
        this.termsConditionCheckBox = (CheckBox) view.findViewById(C1375R.C1376id.tc_checkbox);
        $jacocoInit[157] = true;
        this.termsAndConditions = (TextView) view.findViewById(C1375R.C1376id.terms_and_conditions);
        $jacocoInit[158] = true;
        this.progressDialog = GenericDialogs.createGenericPleaseWaitDialog(getContext());
        try {
            $jacocoInit[159] = true;
            View rootView2 = view.getRootView();
            $jacocoInit[160] = true;
            View findViewById = rootView2.findViewById(C1375R.C1376id.login_signup_layout);
            $jacocoInit[161] = true;
            this.bottomSheetBehavior = BottomSheetBehavior.m1373b(findViewById);
            $jacocoInit[162] = true;
        } catch (IllegalArgumentException e) {
            $jacocoInit[163] = true;
        }
        this.originalHeight = this.bottomSheetBehavior.mo4279b();
        $jacocoInit[164] = true;
        attachPresenter(this.presenter);
        $jacocoInit[165] = true;
        registerClickHandler(this.presenter);
        $jacocoInit[166] = true;
    }

    public void hideTCandPP() {
        boolean[] $jacocoInit = $jacocoInit();
        this.termsConditionCheckBox.setVisibility(8);
        $jacocoInit[167] = true;
        this.termsAndConditions.setVisibility(8);
        $jacocoInit[168] = true;
    }

    public void showTCandPP() {
        boolean[] $jacocoInit = $jacocoInit();
        this.checkboxDrawable = C0694g.m3310a(this.termsConditionCheckBox);
        $jacocoInit[169] = true;
        this.termsConditionCheckBox.setVisibility(0);
        $jacocoInit[170] = true;
        ClickableSpan termsAndConditionsClickListener = new ClickableSpan(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ LoginSignUpCredentialsFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6023242486850982635L, "cm/aptoide/pt/account/view/LoginSignUpCredentialsFragment$2", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onClick(View view) {
                boolean[] $jacocoInit = $jacocoInit();
                if (LoginSignUpCredentialsFragment.access$100(this.this$0) == null) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    LoginSignUpCredentialsFragment.access$100(this.this$0).onNext(null);
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[171] = true;
        ClickableSpan privacyPolicyClickListener = new ClickableSpan(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ LoginSignUpCredentialsFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-4128092782029654261L, "cm/aptoide/pt/account/view/LoginSignUpCredentialsFragment$3", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onClick(View view) {
                boolean[] $jacocoInit = $jacocoInit();
                if (LoginSignUpCredentialsFragment.access$200(this.this$0) == null) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    LoginSignUpCredentialsFragment.access$200(this.this$0).onNext(null);
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[172] = true;
        String baseString = getString(C1375R.string.terms_and_conditions_privacy_sign_up_message);
        $jacocoInit[173] = true;
        String termsAndConditionsPlaceHolder = getString(C1375R.string.settings_terms_conditions);
        $jacocoInit[174] = true;
        String privacyPolicyPlaceHolder = getString(C1375R.string.settings_privacy_policy);
        Object[] objArr = {termsAndConditionsPlaceHolder, privacyPolicyPlaceHolder};
        $jacocoInit[175] = true;
        String privacyAndTerms = String.format(baseString, objArr);
        $jacocoInit[176] = true;
        SpannableString privacyAndTermsSpan = new SpannableString(privacyAndTerms);
        $jacocoInit[177] = true;
        int indexOf = privacyAndTerms.indexOf(termsAndConditionsPlaceHolder);
        $jacocoInit[178] = true;
        int indexOf2 = privacyAndTerms.indexOf(termsAndConditionsPlaceHolder);
        $jacocoInit[179] = true;
        int length = indexOf2 + termsAndConditionsPlaceHolder.length();
        $jacocoInit[180] = true;
        privacyAndTermsSpan.setSpan(termsAndConditionsClickListener, indexOf, length, 33);
        $jacocoInit[181] = true;
        int indexOf3 = privacyAndTerms.indexOf(privacyPolicyPlaceHolder);
        $jacocoInit[182] = true;
        int indexOf4 = privacyAndTerms.indexOf(privacyPolicyPlaceHolder) + privacyPolicyPlaceHolder.length();
        $jacocoInit[183] = true;
        privacyAndTermsSpan.setSpan(privacyPolicyClickListener, indexOf3, indexOf4, 33);
        $jacocoInit[184] = true;
        this.termsAndConditions.setText(privacyAndTermsSpan);
        $jacocoInit[185] = true;
        this.termsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
        $jacocoInit[186] = true;
        this.termsAndConditions.setVisibility(0);
        $jacocoInit[187] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        unregisterClickHandler(this.presenter);
        $jacocoInit[188] = true;
        unlockScreenRotation();
        this.termsAndConditions = null;
        this.credentialsEditTextsArea = null;
        this.termsConditionCheckBox = null;
        $jacocoInit[189] = true;
        super.onDestroyView();
        $jacocoInit[190] = true;
    }
}
