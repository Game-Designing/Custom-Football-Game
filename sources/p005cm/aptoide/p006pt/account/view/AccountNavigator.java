package p005cm.aptoide.p006pt.account.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.facebook.C6666i;
import com.facebook.C6742l;
import com.facebook.FacebookException;
import com.facebook.login.C6745C;
import com.facebook.login.C6748D;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.AccountOrigins;
import p005cm.aptoide.p006pt.account.FacebookLoginResult;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreViewModel;
import p005cm.aptoide.p006pt.account.view.user.ManageUserFragment;
import p005cm.aptoide.p006pt.account.view.user.ProfileStepTwoFragment;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.link.CustomTabsHelper;
import p005cm.aptoide.p006pt.navigator.ActivityNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment;
import p019d.p022i.p023b.C0100e;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.account.view.AccountNavigator */
public class AccountNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final ActivityNavigator activityNavigator;
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final C6666i callbackManager;
    private final GoogleApiClient client;
    private final C6745C facebookLoginManager;
    private final C0100e<FacebookLoginResult> facebookLoginSubject;
    private final FragmentNavigator fragmentNavigator;
    private final String recoverPasswordUrl;
    private final String theme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3745512662020980995L, "cm/aptoide/pt/account/view/AccountNavigator", 47);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ C0100e access$000(AccountNavigator x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<FacebookLoginResult> eVar = x0.facebookLoginSubject;
        $jacocoInit[46] = true;
        return eVar;
    }

    public AccountNavigator(BottomNavigationNavigator bottomNavigationNavigator2, FragmentNavigator fragmentNavigator2, AptoideAccountManager accountManager2, ActivityNavigator activityNavigator2, C6745C facebookLoginManager2, C6666i callbackManager2, GoogleApiClient client2, C0100e<FacebookLoginResult> facebookLoginSubject2, String recoverPasswordUrl2, AccountAnalytics accountAnalytics2, String theme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator = bottomNavigationNavigator2;
        this.fragmentNavigator = fragmentNavigator2;
        this.accountManager = accountManager2;
        this.activityNavigator = activityNavigator2;
        this.facebookLoginManager = facebookLoginManager2;
        this.callbackManager = callbackManager2;
        this.client = client2;
        this.facebookLoginSubject = facebookLoginSubject2;
        this.recoverPasswordUrl = recoverPasswordUrl2;
        this.accountAnalytics = accountAnalytics2;
        this.theme = theme2;
        $jacocoInit[0] = true;
    }

    public void navigateToRecoverPasswordView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityNavigator.navigateTo(Uri.parse(this.recoverPasswordUrl));
        $jacocoInit[1] = true;
    }

    public void navigateToAccountView(AccountOrigins accountOrigins) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.accountManager.isLoggedIn()) {
            $jacocoInit[2] = true;
            this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
            $jacocoInit[3] = true;
        } else {
            this.accountAnalytics.enterAccountScreen(accountOrigins);
            $jacocoInit[4] = true;
            this.fragmentNavigator.navigateTo(LoginSignUpFragment.newInstance(false, false, false, false), true);
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
    }

    public Single<ConnectionResult> navigateToGoogleSignUpForResult(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Single b = Single.m742b((Callable<? extends T>) new C1491e<Object>(this, requestCode));
        $jacocoInit[7] = true;
        Single<ConnectionResult> b2 = b.mo3694b(Schedulers.m776io());
        $jacocoInit[8] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ ConnectionResult mo9638a(int requestCode) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        ConnectionResult connectionResult = this.client.mo27375a();
        $jacocoInit[41] = true;
        if (!connectionResult.mo27281f()) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            this.activityNavigator.navigateForResult(Auth.f19287j.mo27188b(this.client), requestCode);
            $jacocoInit[44] = true;
        }
        $jacocoInit[45] = true;
        return connectionResult;
    }

    public C0120S<GoogleSignInResult> googleSignUpResults(int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S results = this.activityNavigator.results(requestCode);
        C1483a aVar = C1483a.f4405a;
        $jacocoInit[9] = true;
        C0120S j = results.mo3669j(aVar);
        C1485b bVar = new C1485b(this);
        $jacocoInit[10] = true;
        C0120S<GoogleSignInResult> b = j.mo3636b((C0129b<? super T>) bVar);
        $jacocoInit[11] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ GoogleSignInResult m6224b(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        GoogleSignInResult a = Auth.f19287j.mo27186a(result.getData());
        $jacocoInit[40] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9640a(GoogleSignInResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        this.client.mo27386d();
        $jacocoInit[39] = true;
    }

    public void navigateToFacebookSignUpForResult(Collection<String> permissions) {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookLoginManager.mo19990a(this.callbackManager, (C6742l<C6748D>) new C6742l<C6748D>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ AccountNavigator this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(3969221696442462166L, "cm/aptoide/pt/account/view/AccountNavigator$1", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                onSuccess((C6748D) obj);
                $jacocoInit[4] = true;
            }

            public void onSuccess(C6748D loginResult) {
                boolean[] $jacocoInit = $jacocoInit();
                AccountNavigator.access$000(this.this$0).call(new FacebookLoginResult(loginResult, 0, null));
                $jacocoInit[1] = true;
            }

            public void onCancel() {
                boolean[] $jacocoInit = $jacocoInit();
                AccountNavigator.access$000(this.this$0).call(new FacebookLoginResult(null, 1, null));
                $jacocoInit[2] = true;
            }

            public void onError(FacebookException error) {
                boolean[] $jacocoInit = $jacocoInit();
                AccountNavigator.access$000(this.this$0).call(new FacebookLoginResult(null, 99, error));
                $jacocoInit[3] = true;
            }
        });
        $jacocoInit[12] = true;
        this.facebookLoginManager.mo19994b(this.activityNavigator.getActivity(), permissions);
        $jacocoInit[13] = true;
    }

    public C0120S<FacebookLoginResult> facebookSignUpResults() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S results = this.activityNavigator.results();
        C1487c cVar = new C1487c(this);
        $jacocoInit[14] = true;
        C0120S d = results.mo3653d((C0132p<? super T, Boolean>) cVar);
        C0100e<FacebookLoginResult> eVar = this.facebookLoginSubject;
        C1489d dVar = C1489d.f4411a;
        $jacocoInit[15] = true;
        C0120S<FacebookLoginResult> a = C0120S.m641a(d, (C0120S<? extends T2>) eVar, (C14541q<? super T1, ? super T2, ? extends R>) dVar);
        $jacocoInit[16] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo9639a(Result result) {
        boolean[] $jacocoInit = $jacocoInit();
        C6666i iVar = this.callbackManager;
        int requestCode = result.getRequestCode();
        $jacocoInit[36] = true;
        int resultCode = result.getResultCode();
        Intent data = result.getData();
        $jacocoInit[37] = true;
        Boolean valueOf = Boolean.valueOf(iVar.onActivityResult(requestCode, resultCode, data));
        $jacocoInit[38] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ FacebookLoginResult m6223a(Result result, FacebookLoginResult loginResult) {
        $jacocoInit()[35] = true;
        return loginResult;
    }

    public void popViewWithResult(int requestCode, boolean success) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        if (success) {
            i = -1;
            $jacocoInit[17] = true;
        } else {
            i = 0;
            $jacocoInit[18] = true;
        }
        fragmentNavigator2.popWithResult(new Result(requestCode, i, null));
        $jacocoInit[19] = true;
    }

    public void navigateToHomeView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator.navigateToHome();
        $jacocoInit[20] = true;
    }

    public void popView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.popBackStack();
        $jacocoInit[21] = true;
    }

    public void navigateToCreateProfileView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateToCleaningBackStack(ManageUserFragment.newInstanceToCreate(), true);
        $jacocoInit[22] = true;
    }

    public void navigateToProfileStepTwoView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateToCleaningBackStack(ProfileStepTwoFragment.newInstance(), true);
        $jacocoInit[23] = true;
    }

    public void navigateToCreateStoreView() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        ManageStoreViewModel manageStoreViewModel = new ManageStoreViewModel();
        $jacocoInit[24] = true;
        ManageStoreFragment newInstance = ManageStoreFragment.newInstance(manageStoreViewModel, true);
        $jacocoInit[25] = true;
        fragmentNavigator2.navigateToCleaningBackStack(newInstance, true);
        $jacocoInit[26] = true;
    }

    public void navigateToTermsAndConditions() {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        ActivityNavigator activityNavigator2 = this.activityNavigator;
        $jacocoInit[27] = true;
        Activity activity = activityNavigator2.getActivity();
        $jacocoInit[28] = true;
        String string = activity.getString(C1375R.string.all_url_terms_conditions);
        Activity activity2 = this.activityNavigator.getActivity();
        String str = this.theme;
        $jacocoInit[29] = true;
        instance.openInChromeCustomTab(string, activity2, str);
        $jacocoInit[30] = true;
    }

    public void navigateToPrivacyPolicy() {
        boolean[] $jacocoInit = $jacocoInit();
        CustomTabsHelper instance = CustomTabsHelper.getInstance();
        ActivityNavigator activityNavigator2 = this.activityNavigator;
        $jacocoInit[31] = true;
        Activity activity = activityNavigator2.getActivity();
        $jacocoInit[32] = true;
        String string = activity.getString(C1375R.string.all_url_privacy_policy);
        Activity activity2 = this.activityNavigator.getActivity();
        String str = this.theme;
        $jacocoInit[33] = true;
        instance.openInChromeCustomTab(string, activity2, str);
        $jacocoInit[34] = true;
    }
}
