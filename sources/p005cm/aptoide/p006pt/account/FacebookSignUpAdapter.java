package p005cm.aptoide.p006pt.account;

import com.facebook.AccessToken;
import com.facebook.C6817z;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6546c;
import com.facebook.login.C6745C;
import com.facebook.login.C6748D;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.SignUpAdapter;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.account.FacebookSignUpAdapter */
public class FacebookSignUpAdapter implements SignUpAdapter<FacebookLoginResult> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String TYPE = "FACEBOOK";
    private final List<String> facebookRequiredPermissions;
    private final C6745C loginManager;
    private final LoginPreferences loginPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2379507695021204231L, "cm/aptoide/pt/account/FacebookSignUpAdapter", 46);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single signUp(Object obj, AccountService accountService) {
        boolean[] $jacocoInit = $jacocoInit();
        Single signUp = signUp((FacebookLoginResult) obj, accountService);
        $jacocoInit[20] = true;
        return signUp;
    }

    public FacebookSignUpAdapter(List<String> facebookRequiredPermissions2, C6745C loginManager2, LoginPreferences loginPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.facebookRequiredPermissions = facebookRequiredPermissions2;
        this.loginManager = loginManager2;
        this.loginPreferences = loginPreferences2;
        $jacocoInit[0] = true;
    }

    public Single<Account> signUp(FacebookLoginResult result, AccountService service) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isEnabled()) {
            $jacocoInit[1] = true;
            Single<Account> a = Single.m735a((Throwable) new IllegalStateException("Facebook sign up is not enabled"));
            $jacocoInit[2] = true;
            return a;
        } else if (result.getState() == 1) {
            $jacocoInit[3] = true;
            Single<Account> a2 = Single.m735a((Throwable) new FacebookSignUpException(2, "USER_CANCELLED"));
            $jacocoInit[4] = true;
            return a2;
        } else if (result.getState() == 99) {
            $jacocoInit[5] = true;
            Single<Account> a3 = Single.m736a((Callable<Single<T>>) new C1424W<Single<T>>(result));
            $jacocoInit[6] = true;
            return a3;
        } else {
            C6748D result2 = result.getResult();
            $jacocoInit[7] = true;
            AccessToken a4 = result2.mo20005a();
            $jacocoInit[8] = true;
            Set i = a4.mo19629i();
            List<String> list = this.facebookRequiredPermissions;
            $jacocoInit[9] = true;
            if (!i.containsAll(list)) {
                $jacocoInit[10] = true;
                Single<Account> a5 = Single.m735a((Throwable) new FacebookSignUpException(1, "MISSING_REQUIRED_PERMISSIONS"));
                $jacocoInit[11] = true;
                return a5;
            }
            C6748D result3 = result.getResult();
            $jacocoInit[12] = true;
            AccessToken a6 = result3.mo20005a();
            $jacocoInit[13] = true;
            Single facebookEmail = getFacebookEmail(a6);
            C1426Y y = new C1426Y(service, result);
            $jacocoInit[14] = true;
            Single<Account> a7 = facebookEmail.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) y);
            $jacocoInit[15] = true;
            return a7;
        }
    }

    /* renamed from: a */
    static /* synthetic */ Single m6217a(FacebookLoginResult result) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[42] = true;
        FacebookException error = result.getError();
        $jacocoInit[43] = true;
        FacebookSignUpException facebookSignUpException = new FacebookSignUpException(99, error.getMessage());
        $jacocoInit[44] = true;
        Single a = Single.m735a((Throwable) facebookSignUpException);
        $jacocoInit[45] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Single m6216a(AccountService service, FacebookLoginResult result, String email) {
        boolean[] $jacocoInit = $jacocoInit();
        C6748D result2 = result.getResult();
        $jacocoInit[38] = true;
        AccessToken a = result2.mo20005a();
        $jacocoInit[39] = true;
        String k = a.mo19631k();
        $jacocoInit[40] = true;
        Single createAccount = service.createAccount(email, k, null, TYPE);
        $jacocoInit[41] = true;
        return createAccount;
    }

    public C0117M logout() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1423V(this));
        $jacocoInit[16] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9620a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginManager.mo19993b();
        $jacocoInit[37] = true;
    }

    public boolean isEnabled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isFacebookLoginEnabled = this.loginPreferences.isFacebookLoginEnabled();
        $jacocoInit[17] = true;
        return isFacebookLoginEnabled;
    }

    private Single<String> getFacebookEmail(AccessToken accessToken) {
        boolean[] $jacocoInit = $jacocoInit();
        Single a = Single.m736a((Callable<Single<T>>) new C1425X<Single<T>>(accessToken));
        $jacocoInit[18] = true;
        Single<String> b = a.mo3694b(Schedulers.m776io());
        $jacocoInit[19] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Single m6218a(AccessToken accessToken) throws Exception {
        String str;
        String str2 = "email";
        boolean[] $jacocoInit = $jacocoInit();
        try {
            GraphRequest a = GraphRequest.m12873a(accessToken, (C6546c) null);
            $jacocoInit[21] = true;
            C6817z response = a.mo19680b();
            $jacocoInit[22] = true;
            JSONObject object = response.mo20228b();
            $jacocoInit[23] = true;
            if (response.mo20227a() != null) {
                $jacocoInit[24] = true;
            } else if (object == null) {
                $jacocoInit[25] = true;
            } else {
                try {
                    $jacocoInit[26] = true;
                    $jacocoInit[27] = true;
                    if (object.has(str2)) {
                        str = object.getString(str2);
                        $jacocoInit[28] = true;
                    } else {
                        str = object.getString("id");
                        $jacocoInit[29] = true;
                    }
                    Single a2 = Single.m734a(str);
                    $jacocoInit[30] = true;
                    return a2;
                } catch (JSONException e) {
                    $jacocoInit[31] = true;
                    Single a3 = Single.m735a((Throwable) new FacebookSignUpException(99, "Error parsing email"));
                    $jacocoInit[32] = true;
                    return a3;
                }
            }
            Single a4 = Single.m735a((Throwable) new FacebookSignUpException(99, "Unknown error(maybe network error when getting user data)"));
            $jacocoInit[33] = true;
            return a4;
        } catch (RuntimeException exception) {
            $jacocoInit[34] = true;
            FacebookSignUpException facebookSignUpException = new FacebookSignUpException(99, exception.getMessage());
            $jacocoInit[35] = true;
            Single a5 = Single.m735a((Throwable) facebookSignUpException);
            $jacocoInit[36] = true;
            return a5;
        }
    }
}
