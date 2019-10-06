package p005cm.aptoide.p006pt.billing.view.login;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.trello.rxlifecycle.p263a.C12543b;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideCredentials;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.GooglePlayServicesFragment;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p019d.p022i.p023b.C0100e;
import p019d.p022i.p296a.p305c.C13034a;
import p019d.p022i.p296a.p306d.C13050e;
import p019d.p022i.p296a.p306d.C13055j;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.billing.view.login.PaymentLoginFragment */
public class PaymentLoginFragment extends GooglePlayServicesFragment implements PaymentLoginView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String EXTRA_FACEBOOK_DIALOG_VISIBLE = "cm.aptoide.pt.billing.view.login.extra.FACEBOOK_DIALOG_VISIBLE";
    private static final String EXTRA_LOGIN_VISIBLE = "cm.aptoide.pt.billing.view.login.extra.LOGIN_VISIBLE ";
    private static final String EXTRA_PASSWORD_VISIBLE = "cm.aptoide.pt.billing.view.login.extra.PASSWORD_VISIBLE";
    private static final String EXTRA_PROGRESS_VISIBLE = "cm.aptoide.pt.billing.view.login.extra.PROGRESS_VISIBLE";
    private static final String EXTRA_USERNAME_PASSWORD_CONTAINER_VISIBLE = "cm.aptoide.pt.billing.view.login.extra.USERNAME_PASSWORD_CONTAINER_VISIBLE";
    private Button aptoideJoinToggle;
    private Button aptoideLoginButton;
    private View aptoideLoginContainer;
    private View aptoideLoginSignUpButtonContainer;
    private View aptoideLoginSignUpSeparator;
    private Button aptoideLoginToggle;
    private Button aptoideSignUpButton;
    private View aptoideSignUpContainer;
    private C0100e<Void> backButtonRelay;
    private Button facebookButton;
    private RxAlertDialog facebookEmailRequiredDialog;
    private boolean facebookEmailRequiredDialogVisible;
    private Button googleButton;
    private ClickHandler handler;
    private C14963c<Void> hidePasswordContainerSubject;
    private boolean loginVisible;
    @Inject
    String marketName;
    private EditText passwordEditText;
    private C0100e<Void> passwordKeyboardGoRelay;
    private Button passwordShowHideToggle;
    private boolean passwordVisible;
    @Inject
    PaymentLoginFlavorPresenter presenter;
    private C14963c<Void> privacyPolicySubject;
    private ProgressDialog progressDialog;
    private boolean progressVisible;
    private View recoverPasswordButton;
    private View rootView;
    private TextView termsAndConditions;
    private C14963c<Void> termsAndConditionsSubject;
    private CheckBox termsConditionCheckBox;
    private C0100e<Void> upNavigationRelay;
    private EditText usernameEditText;
    private View usernamePasswordContainer;
    private boolean usernamePasswordContainerVisible;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7629068143482392520L, "cm/aptoide/pt/billing/view/login/PaymentLoginFragment", 208);
        $jacocoData = probes;
        return probes;
    }

    public PaymentLoginFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ C14963c access$000(PaymentLoginFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = x0.termsAndConditionsSubject;
        $jacocoInit[206] = true;
        return cVar;
    }

    static /* synthetic */ C14963c access$100(PaymentLoginFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = x0.privacyPolicySubject;
        $jacocoInit[207] = true;
        return cVar;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        PaymentLoginFragment paymentLoginFragment = new PaymentLoginFragment();
        $jacocoInit[1] = true;
        return paymentLoginFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
        this.backButtonRelay = C0100e.m565o();
        $jacocoInit[4] = true;
        this.upNavigationRelay = C0100e.m565o();
        $jacocoInit[5] = true;
        this.passwordKeyboardGoRelay = C0100e.m565o();
        $jacocoInit[6] = true;
        this.privacyPolicySubject = C14963c.m46753p();
        $jacocoInit[7] = true;
        this.termsAndConditionsSubject = C14963c.m46753p();
        $jacocoInit[8] = true;
        this.hidePasswordContainerSubject = C14963c.m46753p();
        $jacocoInit[9] = true;
        setHasOptionsMenu(true);
        $jacocoInit[10] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[11] = true;
        C0120S dismisses = this.facebookEmailRequiredDialog.dismisses();
        C2466E e = new C2466E(this);
        $jacocoInit[12] = true;
        C0120S b = dismisses.mo3636b((C0129b<? super T>) e);
        C12543b bVar = C12543b.PAUSE;
        $jacocoInit[13] = true;
        C0120S a = b.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        $jacocoInit[14] = true;
        a.mo3670j();
        $jacocoInit[15] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11357b(DialogInterface __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookEmailRequiredDialogVisible = false;
        $jacocoInit[205] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[16] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[17] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[18] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_payment_login, container, false);
        $jacocoInit[19] = true;
        return inflate;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        outState.putBoolean(EXTRA_USERNAME_PASSWORD_CONTAINER_VISIBLE, this.usernamePasswordContainerVisible);
        $jacocoInit[20] = true;
        outState.putBoolean(EXTRA_LOGIN_VISIBLE, this.loginVisible);
        $jacocoInit[21] = true;
        outState.putBoolean(EXTRA_PASSWORD_VISIBLE, this.passwordVisible);
        $jacocoInit[22] = true;
        outState.putBoolean(EXTRA_FACEBOOK_DIALOG_VISIBLE, this.facebookEmailRequiredDialogVisible);
        $jacocoInit[23] = true;
        outState.putBoolean(EXTRA_PROGRESS_VISIBLE, this.progressVisible);
        $jacocoInit[24] = true;
        super.onSaveInstanceState(outState);
        $jacocoInit[25] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[26] = true;
        this.rootView = getActivity().findViewById(16908290);
        $jacocoInit[27] = true;
        Toolbar toolbar = (Toolbar) view.findViewById(C1375R.C1376id.fragment_payment_login_toolbar);
        $jacocoInit[28] = true;
        ((C0019n) getContext()).setSupportActionBar(toolbar);
        $jacocoInit[29] = true;
        C0760a supportActionBar = ((C0019n) getContext()).getSupportActionBar();
        $jacocoInit[30] = true;
        supportActionBar.mo6153d(true);
        $jacocoInit[31] = true;
        this.aptoideLoginSignUpSeparator = view.findViewById(C1375R.C1376id.fragment_payment_login_aptoide_buttons_separator_container);
        $jacocoInit[32] = true;
        this.aptoideLoginSignUpButtonContainer = view.findViewById(C1375R.C1376id.fragment_payment_login_aptoide_buttons_container);
        $jacocoInit[33] = true;
        this.aptoideSignUpContainer = view.findViewById(C1375R.C1376id.fragment_payment_sign_up_container);
        $jacocoInit[34] = true;
        this.aptoideLoginContainer = view.findViewById(C1375R.C1376id.fragment_payment_login_container);
        $jacocoInit[35] = true;
        this.aptoideJoinToggle = (Button) view.findViewById(C1375R.C1376id.fragment_payment_login_join_button);
        $jacocoInit[36] = true;
        this.aptoideLoginToggle = (Button) view.findViewById(C1375R.C1376id.fragment_payment_login_small_button);
        $jacocoInit[37] = true;
        this.recoverPasswordButton = view.findViewById(C1375R.C1376id.fragment_payment_login_recover_password_button);
        $jacocoInit[38] = true;
        this.aptoideLoginButton = (Button) view.findViewById(C1375R.C1376id.fragment_payment_login_large_login_button);
        $jacocoInit[39] = true;
        this.aptoideSignUpButton = (Button) view.findViewById(C1375R.C1376id.fragment_payment_login_sign_up_button);
        $jacocoInit[40] = true;
        this.usernameEditText = (EditText) view.findViewById(C1375R.C1376id.fragment_payment_login_username);
        $jacocoInit[41] = true;
        this.passwordEditText = (EditText) view.findViewById(C1375R.C1376id.fragment_payment_login_password);
        $jacocoInit[42] = true;
        this.passwordShowHideToggle = (Button) view.findViewById(C1375R.C1376id.fragment_payment_login_show_hide_pasword_button);
        $jacocoInit[43] = true;
        this.usernamePasswordContainer = view.findViewById(C1375R.C1376id.fragment_payment_login_username_password_container);
        $jacocoInit[44] = true;
        this.facebookButton = (Button) view.findViewById(C1375R.C1376id.fragment_payment_login_facebook_button);
        $jacocoInit[45] = true;
        this.googleButton = (Button) view.findViewById(C1375R.C1376id.fragment_payment_login_google_button);
        $jacocoInit[46] = true;
        this.progressDialog = new ProgressDialog(getContext());
        $jacocoInit[47] = true;
        this.progressDialog.setMessage(getString(C1375R.string.please_wait));
        $jacocoInit[48] = true;
        this.progressDialog.setCancelable(false);
        $jacocoInit[49] = true;
        this.termsConditionCheckBox = (CheckBox) view.findViewById(C1375R.C1376id.tc_checkbox);
        $jacocoInit[50] = true;
        this.termsAndConditions = (TextView) view.findViewById(C1375R.C1376id.terms_and_conditions);
        $jacocoInit[51] = true;
        RxAlertDialog.Builder message = new RxAlertDialog.Builder(getContext()).setMessage(C1375R.string.facebook_email_permission_regected_message);
        $jacocoInit[52] = true;
        RxAlertDialog.Builder positiveButton = message.setPositiveButton(C1375R.string.facebook_grant_permission_button);
        $jacocoInit[53] = true;
        RxAlertDialog.Builder negativeButton = positiveButton.setNegativeButton(17039360);
        $jacocoInit[54] = true;
        this.facebookEmailRequiredDialog = negativeButton.build();
        $jacocoInit[55] = true;
        C0120S a = C13034a.m42490a(this.aptoideLoginToggle);
        C2480L l = new C2480L(this);
        $jacocoInit[56] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) l);
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[57] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        $jacocoInit[58] = true;
        a2.mo3670j();
        $jacocoInit[59] = true;
        C0120S a3 = C13034a.m42490a(this.passwordShowHideToggle);
        C2474I i = new C2474I(this);
        $jacocoInit[60] = true;
        C0120S b2 = a3.mo3636b((C0129b<? super T>) i);
        C12543b bVar2 = C12543b.DESTROY_VIEW;
        $jacocoInit[61] = true;
        C0120S a4 = b2.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar2));
        $jacocoInit[62] = true;
        a4.mo3670j();
        $jacocoInit[63] = true;
        C0120S b3 = C13050e.m42504b(this.passwordEditText);
        C2492S s = C2492S.f5653a;
        $jacocoInit[64] = true;
        C0120S d = b3.mo3653d((C0132p<? super T, Boolean>) s);
        C2478K k = new C2478K(this);
        $jacocoInit[65] = true;
        C0120S b4 = d.mo3636b((C0129b<? super T>) k);
        C12543b bVar3 = C12543b.DESTROY_VIEW;
        $jacocoInit[66] = true;
        C0120S a5 = b4.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar3));
        $jacocoInit[67] = true;
        a5.mo3670j();
        $jacocoInit[68] = true;
        this.handler = new C2486O(this);
        $jacocoInit[69] = true;
        registerClickHandler(this.handler);
        if (savedInstanceState == null) {
            $jacocoInit[70] = true;
        } else {
            $jacocoInit[71] = true;
            if (!savedInstanceState.getBoolean(EXTRA_FACEBOOK_DIALOG_VISIBLE)) {
                $jacocoInit[72] = true;
            } else {
                $jacocoInit[73] = true;
                showFacebookPermissionsRequiredError();
                $jacocoInit[74] = true;
            }
            if (!savedInstanceState.getBoolean(EXTRA_PROGRESS_VISIBLE)) {
                $jacocoInit[75] = true;
            } else {
                $jacocoInit[76] = true;
                showLoading();
                $jacocoInit[77] = true;
            }
            if (savedInstanceState.getBoolean(EXTRA_USERNAME_PASSWORD_CONTAINER_VISIBLE)) {
                $jacocoInit[78] = true;
                showUsernamePasswordContainer(savedInstanceState.getBoolean(EXTRA_LOGIN_VISIBLE), true);
                $jacocoInit[79] = true;
            } else {
                this.hidePasswordContainerSubject.onNext(null);
                $jacocoInit[80] = true;
            }
            togglePasswordVisibility(savedInstanceState.getBoolean(EXTRA_PASSWORD_VISIBLE));
            $jacocoInit[81] = true;
        }
        attachPresenter(this.presenter);
        $jacocoInit[82] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo11370h(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        showUsernamePasswordContainer(true, true);
        $jacocoInit[204] = true;
    }

    /* renamed from: i */
    public /* synthetic */ void mo11375i(Void __) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.passwordVisible) {
            $jacocoInit[201] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[202] = true;
        }
        togglePasswordVisibility(z);
        $jacocoInit[203] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7156a(C13055j event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event.mo41948b() == 2) {
            $jacocoInit[198] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[199] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[200] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11358b(C13055j __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.passwordKeyboardGoRelay.call(null);
        $jacocoInit[197] = true;
    }

    /* renamed from: b */
    public /* synthetic */ boolean mo11360b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.backButtonRelay.call(null);
        $jacocoInit[196] = true;
        return true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        unregisterClickHandler(this.handler);
        $jacocoInit[83] = true;
        this.facebookEmailRequiredDialog.dismiss();
        this.facebookEmailRequiredDialog = null;
        this.facebookButton = null;
        this.googleButton = null;
        $jacocoInit[84] = true;
        this.progressDialog.dismiss();
        this.progressDialog = null;
        this.rootView = null;
        this.aptoideLoginSignUpSeparator = null;
        this.aptoideLoginSignUpButtonContainer = null;
        this.aptoideSignUpContainer = null;
        this.aptoideLoginContainer = null;
        this.aptoideJoinToggle = null;
        this.aptoideLoginToggle = null;
        this.usernamePasswordContainer = null;
        this.recoverPasswordButton = null;
        this.aptoideLoginButton = null;
        this.aptoideSignUpButton = null;
        this.usernameEditText = null;
        this.passwordEditText = null;
        this.passwordShowHideToggle = null;
        this.termsAndConditions = null;
        $jacocoInit[85] = true;
        super.onDestroyView();
        $jacocoInit[86] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.privacyPolicySubject = null;
        this.termsAndConditionsSubject = null;
        $jacocoInit[87] = true;
        super.onDestroy();
        $jacocoInit[88] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[89] = true;
            this.upNavigationRelay.call(null);
            $jacocoInit[90] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[91] = true;
        return onOptionsItemSelected;
    }

    public C0120S<Void> backButtonEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> d = this.backButtonRelay.mo3653d((C0132p<? super T, Boolean>) new C2484N<Object,Boolean>(this));
        $jacocoInit[92] = true;
        return d;
    }

    /* renamed from: g */
    public /* synthetic */ Boolean mo11367g(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.usernamePasswordContainer.getVisibility() == 0) {
            $jacocoInit[192] = true;
            this.hidePasswordContainerSubject.onNext(null);
            $jacocoInit[193] = true;
            Boolean valueOf = Boolean.valueOf(false);
            $jacocoInit[194] = true;
            return valueOf;
        }
        Boolean valueOf2 = Boolean.valueOf(true);
        $jacocoInit[195] = true;
        return valueOf2;
    }

    public C0120S<Void> upNavigationEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<Void> eVar = this.upNavigationRelay;
        $jacocoInit[93] = true;
        return eVar;
    }

    public C0120S<Void> facebookSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.facebookButton);
        $jacocoInit[94] = true;
        return a;
    }

    public C0120S<Void> googleSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.googleButton);
        $jacocoInit[95] = true;
        return a;
    }

    public C0120S<Void> recoverPasswordEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.recoverPasswordButton);
        $jacocoInit[96] = true;
        return a;
    }

    public C0120S<Void> termsAndConditionsClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.termsAndConditionsSubject;
        $jacocoInit[97] = true;
        return cVar;
    }

    public C0120S<Void> privacyPolicyClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.privacyPolicySubject;
        $jacocoInit[98] = true;
        return cVar;
    }

    public C0120S<AptoideCredentials> aptoideLoginEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.aptoideLoginButton);
        C0100e<Void> eVar = this.passwordKeyboardGoRelay;
        C2476J j = new C2476J(this);
        $jacocoInit[99] = true;
        C0120S d = eVar.mo3653d((C0132p<? super T, Boolean>) j);
        $jacocoInit[100] = true;
        C0120S b = C0120S.m649b(a, d);
        C2464D d2 = new C2464D(this);
        $jacocoInit[101] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) d2);
        C2470G g = new C2470G(this);
        $jacocoInit[102] = true;
        C0120S<AptoideCredentials> j2 = b2.mo3669j(g);
        $jacocoInit[103] = true;
        return j2;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo11354a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.loginVisible);
        $jacocoInit[191] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo11359b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        hideKeyboard();
        $jacocoInit[190] = true;
    }

    /* renamed from: c */
    public /* synthetic */ AptoideCredentials mo11362c(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.usernameEditText.getText();
        $jacocoInit[187] = true;
        String obj = text.toString();
        Editable text2 = this.passwordEditText.getText();
        $jacocoInit[188] = true;
        AptoideCredentials aptoideCredentials = new AptoideCredentials(obj, text2.toString(), this.termsConditionCheckBox.isChecked());
        $jacocoInit[189] = true;
        return aptoideCredentials;
    }

    public C0120S<Boolean> showAptoideSignUpAreaClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.aptoideJoinToggle);
        C2468F f = new C2468F(this);
        $jacocoInit[104] = true;
        C0120S<Boolean> j = a.mo3669j(f);
        $jacocoInit[105] = true;
        return j;
    }

    /* renamed from: j */
    public /* synthetic */ Boolean mo11376j(Void event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.termsConditionCheckBox.isChecked());
        $jacocoInit[186] = true;
        return valueOf;
    }

    public C0120S<AptoideCredentials> aptoideSignUpEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.aptoideSignUpButton);
        C0100e<Void> eVar = this.passwordKeyboardGoRelay;
        C2472H h = new C2472H(this);
        $jacocoInit[106] = true;
        C0120S d = eVar.mo3653d((C0132p<? super T, Boolean>) h);
        $jacocoInit[107] = true;
        C0120S b = C0120S.m649b(a, d);
        C2482M m = new C2482M(this);
        $jacocoInit[108] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) m);
        C2488P p = new C2488P(this);
        $jacocoInit[109] = true;
        C0120S<AptoideCredentials> j = b2.mo3669j(p);
        $jacocoInit[110] = true;
        return j;
    }

    /* renamed from: d */
    public /* synthetic */ Boolean mo11363d(Void __) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.loginVisible) {
            $jacocoInit[183] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[184] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[185] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ void mo11364e(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        hideKeyboard();
        $jacocoInit[182] = true;
    }

    /* renamed from: f */
    public /* synthetic */ AptoideCredentials mo11365f(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Editable text = this.usernameEditText.getText();
        $jacocoInit[179] = true;
        String obj = text.toString();
        Editable text2 = this.passwordEditText.getText();
        $jacocoInit[180] = true;
        AptoideCredentials aptoideCredentials = new AptoideCredentials(obj, text2.toString(), this.termsConditionCheckBox.isChecked());
        $jacocoInit[181] = true;
        return aptoideCredentials;
    }

    public C0120S<Void> grantFacebookRequiredPermissionsEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S positiveClicks = this.facebookEmailRequiredDialog.positiveClicks();
        C2491Q q = C2491Q.f5652a;
        $jacocoInit[111] = true;
        C0120S<Void> j = positiveClicks.mo3669j(q);
        $jacocoInit[112] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Void m7157a(DialogInterface dialogInterface) {
        $jacocoInit()[178] = true;
        return null;
    }

    public C0120S<Void> hidePasswordContainerEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.hidePasswordContainerSubject;
        $jacocoInit[113] = true;
        return cVar;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressVisible = true;
        $jacocoInit[114] = true;
        this.progressDialog.show();
        $jacocoInit[115] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressVisible = false;
        $jacocoInit[116] = true;
        this.progressDialog.dismiss();
        $jacocoInit[117] = true;
    }

    public void showError(String message) {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(this.rootView, (CharSequence) message, 0);
        $jacocoInit[118] = true;
        a.mo4690h();
        $jacocoInit[119] = true;
    }

    public void showTermsConditionError() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(this.rootView, (CharSequence) getString(C1375R.string.signup_message_no_tandc_error), -1);
        $jacocoInit[120] = true;
        a.mo4690h();
        $jacocoInit[121] = true;
    }

    public void showFacebookPermissionsRequiredError() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.facebookEmailRequiredDialog.isShowing()) {
            $jacocoInit[122] = true;
        } else {
            this.facebookEmailRequiredDialogVisible = true;
            $jacocoInit[123] = true;
            this.facebookEmailRequiredDialog.show();
            $jacocoInit[124] = true;
        }
        $jacocoInit[125] = true;
    }

    public void setCobrandText() {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideJoinToggle.setText(String.format(getString(C1375R.string.join_company), new Object[]{this.marketName}));
        $jacocoInit[126] = true;
    }

    public void hideTCandPP() {
        boolean[] $jacocoInit = $jacocoInit();
        this.termsConditionCheckBox.setVisibility(8);
        $jacocoInit[127] = true;
        this.termsAndConditions.setVisibility(8);
        $jacocoInit[128] = true;
    }

    public void showTCandPP() {
        boolean[] $jacocoInit = $jacocoInit();
        this.termsConditionCheckBox.setVisibility(0);
        $jacocoInit[129] = true;
        this.termsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
        $jacocoInit[130] = true;
        ClickableSpan termsAndConditionsClickListener = new ClickableSpan(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ PaymentLoginFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(8344446232250318486L, "cm/aptoide/pt/billing/view/login/PaymentLoginFragment$1", 5);
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
                if (PaymentLoginFragment.access$000(this.this$0) == null) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    PaymentLoginFragment.access$000(this.this$0).onNext(null);
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[131] = true;
        ClickableSpan privacyPolicyClickListener = new ClickableSpan(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ PaymentLoginFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4045015541237411574L, "cm/aptoide/pt/billing/view/login/PaymentLoginFragment$2", 5);
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
                if (PaymentLoginFragment.access$100(this.this$0) == null) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    PaymentLoginFragment.access$100(this.this$0).onNext(null);
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[132] = true;
        String baseString = getString(C1375R.string.terms_and_conditions_privacy_sign_up_message);
        $jacocoInit[133] = true;
        String termsAndConditionsPlaceHolder = getString(C1375R.string.settings_terms_conditions);
        $jacocoInit[134] = true;
        String privacyPolicyPlaceHolder = getString(C1375R.string.settings_privacy_policy);
        Object[] objArr = {termsAndConditionsPlaceHolder, privacyPolicyPlaceHolder};
        $jacocoInit[135] = true;
        String privacyAndTerms = String.format(baseString, objArr);
        $jacocoInit[136] = true;
        SpannableString privacyAndTermsSpan = new SpannableString(privacyAndTerms);
        $jacocoInit[137] = true;
        int indexOf = privacyAndTerms.indexOf(termsAndConditionsPlaceHolder);
        $jacocoInit[138] = true;
        int indexOf2 = privacyAndTerms.indexOf(termsAndConditionsPlaceHolder);
        $jacocoInit[139] = true;
        int length = indexOf2 + termsAndConditionsPlaceHolder.length();
        $jacocoInit[140] = true;
        privacyAndTermsSpan.setSpan(termsAndConditionsClickListener, indexOf, length, 33);
        $jacocoInit[141] = true;
        int indexOf3 = privacyAndTerms.indexOf(privacyPolicyPlaceHolder);
        $jacocoInit[142] = true;
        int indexOf4 = privacyAndTerms.indexOf(privacyPolicyPlaceHolder) + privacyPolicyPlaceHolder.length();
        $jacocoInit[143] = true;
        privacyAndTermsSpan.setSpan(privacyPolicyClickListener, indexOf3, indexOf4, 33);
        $jacocoInit[144] = true;
        this.termsAndConditions.setText(privacyAndTermsSpan);
        $jacocoInit[145] = true;
        this.termsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
        $jacocoInit[146] = true;
        this.termsAndConditions.setVisibility(0);
        $jacocoInit[147] = true;
    }

    public void showUsernamePasswordContainer(boolean showLogin, boolean shouldShowTCandPP) {
        boolean[] $jacocoInit = $jacocoInit();
        this.usernamePasswordContainer.setVisibility(0);
        this.usernamePasswordContainerVisible = true;
        if (showLogin) {
            this.loginVisible = true;
            $jacocoInit[148] = true;
            this.aptoideLoginContainer.setVisibility(0);
            $jacocoInit[149] = true;
            this.aptoideSignUpContainer.setVisibility(8);
            $jacocoInit[150] = true;
            this.termsConditionCheckBox.setVisibility(8);
            $jacocoInit[151] = true;
            this.termsAndConditions.setVisibility(8);
            $jacocoInit[152] = true;
        } else {
            this.loginVisible = false;
            $jacocoInit[153] = true;
            this.aptoideLoginContainer.setVisibility(8);
            $jacocoInit[154] = true;
            this.aptoideSignUpContainer.setVisibility(0);
            $jacocoInit[155] = true;
            this.termsConditionCheckBox.setVisibility(8);
            $jacocoInit[156] = true;
            this.termsAndConditions.setVisibility(8);
            if (!shouldShowTCandPP) {
                $jacocoInit[157] = true;
            } else {
                $jacocoInit[158] = true;
                this.termsConditionCheckBox.setVisibility(0);
                $jacocoInit[159] = true;
                this.termsAndConditions.setVisibility(0);
                $jacocoInit[160] = true;
            }
        }
        this.aptoideLoginSignUpSeparator.setVisibility(8);
        $jacocoInit[161] = true;
        this.aptoideLoginSignUpButtonContainer.setVisibility(8);
        $jacocoInit[162] = true;
    }

    public void hideUsernamePasswordContainer(boolean shouldShowGDPR) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideLoginSignUpSeparator.setVisibility(0);
        $jacocoInit[163] = true;
        this.aptoideLoginSignUpButtonContainer.setVisibility(0);
        $jacocoInit[164] = true;
        this.usernamePasswordContainer.setVisibility(8);
        $jacocoInit[165] = true;
        this.aptoideLoginContainer.setVisibility(8);
        $jacocoInit[166] = true;
        this.aptoideSignUpContainer.setVisibility(8);
        if (!shouldShowGDPR) {
            $jacocoInit[167] = true;
        } else {
            $jacocoInit[168] = true;
            this.termsConditionCheckBox.setVisibility(0);
            $jacocoInit[169] = true;
            this.termsAndConditions.setVisibility(0);
            $jacocoInit[170] = true;
        }
        this.usernamePasswordContainerVisible = false;
        $jacocoInit[171] = true;
    }

    private void togglePasswordVisibility(boolean showPassword) {
        boolean[] $jacocoInit = $jacocoInit();
        if (showPassword) {
            $jacocoInit[172] = true;
            this.passwordEditText.setTransformationMethod(null);
            $jacocoInit[173] = true;
            this.passwordShowHideToggle.setBackgroundResource(C1375R.drawable.ic_open_eye);
            this.passwordVisible = true;
            $jacocoInit[174] = true;
        } else {
            this.passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
            $jacocoInit[175] = true;
            this.passwordShowHideToggle.setBackgroundResource(C1375R.drawable.ic_closed_eye);
            this.passwordVisible = false;
            $jacocoInit[176] = true;
        }
        $jacocoInit[177] = true;
    }
}
