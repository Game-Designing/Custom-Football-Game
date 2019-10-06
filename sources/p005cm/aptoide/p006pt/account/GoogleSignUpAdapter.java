package p005cm.aptoide.p006pt.account;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.SignUpAdapter;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0131o;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.account.GoogleSignUpAdapter */
public class GoogleSignUpAdapter implements SignUpAdapter<GoogleSignInResult> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String TYPE = "GOOGLE";
    private final GoogleApiClient client;
    private final LoginPreferences preferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8637231189846395932L, "cm/aptoide/pt/account/GoogleSignUpAdapter", 26);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ Single signUp(Object obj, AccountService accountService) {
        boolean[] $jacocoInit = $jacocoInit();
        Single signUp = signUp((GoogleSignInResult) obj, accountService);
        $jacocoInit[20] = true;
        return signUp;
    }

    public GoogleSignUpAdapter(GoogleApiClient client2, LoginPreferences preferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.preferences = preferences2;
        this.client = client2;
        $jacocoInit[0] = true;
    }

    public Single<Account> signUp(GoogleSignInResult result, AccountService service) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isEnabled()) {
            $jacocoInit[1] = true;
            Single<Account> a = Single.m735a((Throwable) new IllegalStateException("Google sign up is not enabled"));
            $jacocoInit[2] = true;
            return a;
        }
        GoogleSignInAccount account = result.mo27209a();
        $jacocoInit[3] = true;
        if (!result.mo27210c()) {
            $jacocoInit[4] = true;
        } else if (account == null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            String d = account.mo27173d();
            String v = account.mo27182v();
            $jacocoInit[7] = true;
            String c = account.mo27172c();
            $jacocoInit[8] = true;
            Single<Account> createAccount = service.createAccount(d, v, c, TYPE);
            $jacocoInit[9] = true;
            return createAccount;
        }
        $jacocoInit[10] = true;
        Status status = result.getStatus();
        $jacocoInit[11] = true;
        int a2 = status.mo27417a();
        $jacocoInit[12] = true;
        String a3 = GoogleSignInStatusCodes.m20978a(a2);
        $jacocoInit[13] = true;
        Status status2 = result.getStatus();
        $jacocoInit[14] = true;
        GoogleSignUpException googleSignUpException = new GoogleSignUpException(a3, status2.mo27417a());
        $jacocoInit[15] = true;
        Single<Account> a4 = Single.m735a((Throwable) googleSignUpException);
        $jacocoInit[16] = true;
        return a4;
    }

    public C0117M logout() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C1427Z<Object>(this));
        $jacocoInit[17] = true;
        C0117M b = a.mo3593b(Schedulers.m776io());
        $jacocoInit[18] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9624a() {
        boolean[] $jacocoInit = $jacocoInit();
        ConnectionResult a = this.client.mo27375a();
        $jacocoInit[21] = true;
        if (a.mo27281f()) {
            $jacocoInit[22] = true;
            Auth.f19287j.mo27189c(this.client);
            $jacocoInit[23] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[24] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new IllegalStateException("Could not connect to Google Play Services to sign out."));
        $jacocoInit[25] = true;
        return b2;
    }

    public boolean isEnabled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isGoogleLoginEnabled = this.preferences.isGoogleLoginEnabled();
        $jacocoInit[19] = true;
        return isGoogleLoginEnabled;
    }
}
