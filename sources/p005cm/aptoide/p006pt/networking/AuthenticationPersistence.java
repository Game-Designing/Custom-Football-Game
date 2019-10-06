package p005cm.aptoide.p006pt.networking;

import android.accounts.Account;
import android.accounts.AccountManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AndroidAccountProvider;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.networking.AuthenticationPersistence */
public class AuthenticationPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACCOUNT_ACCESS_TOKEN = "access_token";
    public static final String ACCOUNT_REFRESH_TOKEN = "refresh_token";
    public static final String ACCOUNT_TYPE = "aptoide_account_manager_login_mode";
    private final AccountManager androidAccountManager;
    private final AndroidAccountProvider androidAccountProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5344572213481794371L, "cm/aptoide/pt/networking/AuthenticationPersistence", 22);
        $jacocoData = probes;
        return probes;
    }

    public AuthenticationPersistence(AndroidAccountProvider androidAccountProvider2, AccountManager androidAccountManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.androidAccountProvider = androidAccountProvider2;
        this.androidAccountManager = androidAccountManager2;
        $jacocoInit[0] = true;
    }

    public C0117M removeAuthentication() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeAndroidAccount = this.androidAccountProvider.removeAndroidAccount();
        $jacocoInit[1] = true;
        return removeAndroidAccount;
    }

    public Single<Authentication> getAuthentication() {
        boolean[] $jacocoInit = $jacocoInit();
        Single androidAccount = this.androidAccountProvider.getAndroidAccount();
        C4146d dVar = new C4146d(this);
        $jacocoInit[2] = true;
        Single d = androidAccount.mo3698d(dVar);
        C4143a aVar = C4143a.f7681a;
        $jacocoInit[3] = true;
        Single<Authentication> f = d.mo3700f(aVar);
        $jacocoInit[4] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ Authentication mo2172a(Account androidAccount) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = androidAccount.name;
        AccountManager accountManager = this.androidAccountManager;
        $jacocoInit[17] = true;
        String userData = accountManager.getUserData(androidAccount, ACCOUNT_REFRESH_TOKEN);
        AccountManager accountManager2 = this.androidAccountManager;
        $jacocoInit[18] = true;
        String userData2 = accountManager2.getUserData(androidAccount, "access_token");
        AccountManager accountManager3 = this.androidAccountManager;
        $jacocoInit[19] = true;
        String password = accountManager3.getPassword(androidAccount);
        AccountManager accountManager4 = this.androidAccountManager;
        $jacocoInit[20] = true;
        Authentication authentication = new Authentication(str, userData, userData2, password, accountManager4.getUserData(androidAccount, ACCOUNT_TYPE));
        $jacocoInit[21] = true;
        return authentication;
    }

    /* renamed from: a */
    static /* synthetic */ Authentication m403a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Authentication authentication = new Authentication("", "", "", "", "");
        $jacocoInit[16] = true;
        return authentication;
    }

    public C0117M updateAuthentication(String accessToken) {
        boolean[] $jacocoInit = $jacocoInit();
        Single androidAccount = this.androidAccountProvider.getAndroidAccount();
        C4145c cVar = new C4145c(this, accessToken);
        $jacocoInit[5] = true;
        Single b = androidAccount.mo3695b((C0129b<? super T>) cVar);
        $jacocoInit[6] = true;
        C0117M b2 = b.mo3692b();
        $jacocoInit[7] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2173a(String accessToken, Account androidAccount) {
        boolean[] $jacocoInit = $jacocoInit();
        this.androidAccountManager.setUserData(androidAccount, "access_token", accessToken);
        $jacocoInit[15] = true;
    }

    public C0117M createAuthentication(String email, String password, String refreshToken, String accessToken, String type) {
        boolean[] $jacocoInit = $jacocoInit();
        Single createAndroidAccount = this.androidAccountProvider.createAndroidAccount(email);
        C4144b bVar = new C4144b(this, refreshToken, accessToken, password, type);
        $jacocoInit[8] = true;
        Single b = createAndroidAccount.mo3695b((C0129b<? super T>) bVar);
        $jacocoInit[9] = true;
        C0117M b2 = b.mo3692b();
        $jacocoInit[10] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2174a(String refreshToken, String accessToken, String password, String type, Account androidAccount) {
        boolean[] $jacocoInit = $jacocoInit();
        this.androidAccountManager.setUserData(androidAccount, ACCOUNT_REFRESH_TOKEN, refreshToken);
        $jacocoInit[11] = true;
        this.androidAccountManager.setUserData(androidAccount, "access_token", accessToken);
        $jacocoInit[12] = true;
        this.androidAccountManager.setPassword(androidAccount, password);
        $jacocoInit[13] = true;
        this.androidAccountManager.setUserData(androidAccount, ACCOUNT_TYPE, type);
        $jacocoInit[14] = true;
    }
}
