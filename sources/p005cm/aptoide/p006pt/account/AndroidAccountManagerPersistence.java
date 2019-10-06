package p005cm.aptoide.p006pt.account;

import android.accounts.AccountManager;
import java.util.Date;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.Account.Access;
import p005cm.aptoide.accountmanager.AccountFactory;
import p005cm.aptoide.accountmanager.AccountPersistence;
import p005cm.aptoide.accountmanager.Store;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.networking.Authentication;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p026rx.C0117M;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.AndroidAccountManagerPersistence */
public class AndroidAccountManagerPersistence implements AccountPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACCOUNT_ACCESS_CONFIRMED = "access_confirmed";
    public static final String ACCOUNT_ACCESS_LEVEL = "access";
    public static final String ACCOUNT_ADULT_CONTENT_ENABLED = "aptoide_account_manager_mature_switch";
    public static final String ACCOUNT_AVATAR_URL = "useravatar";
    private static final String ACCOUNT_BIRTH_DATE = "account_birth_date";
    public static final String ACCOUNT_ID = "userId";
    public static final String ACCOUNT_NICKNAME = "username";
    private static final String ACCOUNT_PRIVACY_POLICY = "account_privacy_policy";
    public static final String ACCOUNT_STORE_AVATAR_URL = "storeAvatar";
    private static final String ACCOUNT_STORE_DOWNLOAD_COUNT = "account_store_download_count";
    private static final String ACCOUNT_STORE_ID = "account_store_id";
    public static final String ACCOUNT_STORE_NAME = "userRepo";
    private static final String ACCOUNT_STORE_PASSWORD = "account_store_password";
    private static final String ACCOUNT_STORE_THEME = "account_store_theme";
    private static final String ACCOUNT_STORE_USERNAME = "account_store_username";
    private static final String ACCOUNT_TERMS_AND_CONDITIONS = "account_terms_and_conditions";
    private Account accountCache;
    private final AndroidAccountDataMigration accountDataMigration;
    private final AccountFactory accountFactory;
    private final AccountManager androidAccountManager;
    private final AndroidAccountProvider androidAccountProvider;
    private final AuthenticationPersistence authenticationPersistence;
    private final C0126V scheduler;
    private final DatabaseStoreDataPersist storePersist;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3692032425754422702L, "cm/aptoide/pt/account/AndroidAccountManagerPersistence", 97);
        $jacocoData = probes;
        return probes;
    }

    public AndroidAccountManagerPersistence(AccountManager androidAccountManager2, DatabaseStoreDataPersist storePersist2, AccountFactory accountFactory2, AndroidAccountDataMigration accountDataMigration2, AndroidAccountProvider androidAccountProvider2, AuthenticationPersistence authenticationPersistence2, C0126V scheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.androidAccountManager = androidAccountManager2;
        this.storePersist = storePersist2;
        this.accountFactory = accountFactory2;
        this.accountDataMigration = accountDataMigration2;
        this.androidAccountProvider = androidAccountProvider2;
        this.authenticationPersistence = authenticationPersistence2;
        this.scheduler = scheduler2;
        $jacocoInit[0] = true;
    }

    public C0117M saveAccount(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        Single androidAccount = this.androidAccountProvider.getAndroidAccount();
        C1414L l = new C1414L(this, account);
        $jacocoInit[1] = true;
        C0117M b = androidAccount.mo3693b((C0132p<? super T, ? extends C0117M>) l);
        C0126V v = this.scheduler;
        $jacocoInit[2] = true;
        C0117M b2 = b.mo3593b(v);
        $jacocoInit[3] = true;
        return b2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9596a(Account account, android.accounts.Account androidAccount) {
        boolean[] $jacocoInit = $jacocoInit();
        this.androidAccountManager.setUserData(androidAccount, ACCOUNT_ID, account.getId());
        AccountManager accountManager = this.androidAccountManager;
        $jacocoInit[53] = true;
        String nickname = account.getNickname();
        $jacocoInit[54] = true;
        accountManager.setUserData(androidAccount, "username", nickname);
        AccountManager accountManager2 = this.androidAccountManager;
        $jacocoInit[55] = true;
        String avatar = account.getAvatar();
        $jacocoInit[56] = true;
        accountManager2.setUserData(androidAccount, ACCOUNT_AVATAR_URL, avatar);
        AccountManager accountManager3 = this.androidAccountManager;
        $jacocoInit[57] = true;
        String valueOf = String.valueOf(account.isAdultContentEnabled());
        $jacocoInit[58] = true;
        accountManager3.setUserData(androidAccount, ACCOUNT_ADULT_CONTENT_ENABLED, valueOf);
        AccountManager accountManager4 = this.androidAccountManager;
        $jacocoInit[59] = true;
        Access access = account.getAccess();
        $jacocoInit[60] = true;
        String name = access.name();
        $jacocoInit[61] = true;
        accountManager4.setUserData(androidAccount, ACCOUNT_ACCESS_LEVEL, name);
        AccountManager accountManager5 = this.androidAccountManager;
        $jacocoInit[62] = true;
        String valueOf2 = String.valueOf(account.isAccessConfirmed());
        $jacocoInit[63] = true;
        accountManager5.setUserData(androidAccount, ACCOUNT_ACCESS_CONFIRMED, valueOf2);
        $jacocoInit[64] = true;
        AccountManager accountManager6 = this.androidAccountManager;
        Store store = account.getStore();
        $jacocoInit[65] = true;
        String name2 = store.getName();
        $jacocoInit[66] = true;
        accountManager6.setUserData(androidAccount, ACCOUNT_STORE_NAME, name2);
        AccountManager accountManager7 = this.androidAccountManager;
        $jacocoInit[67] = true;
        Store store2 = account.getStore();
        $jacocoInit[68] = true;
        String avatar2 = store2.getAvatar();
        $jacocoInit[69] = true;
        accountManager7.setUserData(androidAccount, ACCOUNT_STORE_AVATAR_URL, avatar2);
        AccountManager accountManager8 = this.androidAccountManager;
        $jacocoInit[70] = true;
        Store store3 = account.getStore();
        $jacocoInit[71] = true;
        long downloadCount = store3.getDownloadCount();
        $jacocoInit[72] = true;
        String valueOf3 = String.valueOf(downloadCount);
        $jacocoInit[73] = true;
        accountManager8.setUserData(androidAccount, ACCOUNT_STORE_DOWNLOAD_COUNT, valueOf3);
        AccountManager accountManager9 = this.androidAccountManager;
        $jacocoInit[74] = true;
        Store store4 = account.getStore();
        $jacocoInit[75] = true;
        long id = store4.getId();
        $jacocoInit[76] = true;
        accountManager9.setUserData(androidAccount, ACCOUNT_STORE_ID, String.valueOf(id));
        $jacocoInit[77] = true;
        AccountManager accountManager10 = this.androidAccountManager;
        Store store5 = account.getStore();
        $jacocoInit[78] = true;
        String theme = store5.getTheme();
        $jacocoInit[79] = true;
        accountManager10.setUserData(androidAccount, ACCOUNT_STORE_THEME, theme);
        AccountManager accountManager11 = this.androidAccountManager;
        $jacocoInit[80] = true;
        Store store6 = account.getStore();
        $jacocoInit[81] = true;
        String username = store6.getUsername();
        $jacocoInit[82] = true;
        accountManager11.setUserData(androidAccount, ACCOUNT_STORE_USERNAME, username);
        AccountManager accountManager12 = this.androidAccountManager;
        $jacocoInit[83] = true;
        Store store7 = account.getStore();
        $jacocoInit[84] = true;
        String password = store7.getPassword();
        $jacocoInit[85] = true;
        accountManager12.setUserData(androidAccount, ACCOUNT_STORE_PASSWORD, password);
        AccountManager accountManager13 = this.androidAccountManager;
        $jacocoInit[86] = true;
        String valueOf4 = String.valueOf(account.acceptedTermsAndConditions());
        $jacocoInit[87] = true;
        accountManager13.setUserData(androidAccount, ACCOUNT_TERMS_AND_CONDITIONS, valueOf4);
        AccountManager accountManager14 = this.androidAccountManager;
        $jacocoInit[88] = true;
        String valueOf5 = String.valueOf(account.acceptedPrivacyPolicy());
        $jacocoInit[89] = true;
        accountManager14.setUserData(androidAccount, ACCOUNT_PRIVACY_POLICY, valueOf5);
        AccountManager accountManager15 = this.androidAccountManager;
        $jacocoInit[90] = true;
        Date birthDate = account.getBirthDate();
        $jacocoInit[91] = true;
        String localeString = birthDate.toLocaleString();
        $jacocoInit[92] = true;
        accountManager15.setUserData(androidAccount, ACCOUNT_BIRTH_DATE, localeString);
        $jacocoInit[93] = true;
        C0117M persist = this.storePersist.persist(account.getSubscribedStores());
        C1415M m = new C1415M(this, account);
        $jacocoInit[94] = true;
        C0117M a = persist.mo3582a((C0128a) m);
        $jacocoInit[95] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9601a(Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountCache = account;
        $jacocoInit[96] = true;
    }

    public Single<Account> getAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        Account account = this.accountCache;
        if (account != null) {
            $jacocoInit[4] = true;
            Single<Account> a = Single.m734a(account);
            $jacocoInit[5] = true;
            return a;
        }
        C0117M migrate = this.accountDataMigration.migrate();
        AndroidAccountProvider androidAccountProvider2 = this.androidAccountProvider;
        $jacocoInit[6] = true;
        Single androidAccount = androidAccountProvider2.getAndroidAccount();
        C1409G g = new C1409G(this);
        $jacocoInit[7] = true;
        Single a2 = androidAccount.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) g);
        $jacocoInit[8] = true;
        Single<Account> a3 = migrate.mo3587a(a2);
        $jacocoInit[9] = true;
        return a3;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9597a(android.accounts.Account androidAccount) {
        boolean terms;
        boolean privacy;
        Date date;
        boolean[] $jacocoInit = $jacocoInit();
        AccountManager accountManager = this.androidAccountManager;
        $jacocoInit[21] = true;
        String access = accountManager.getUserData(androidAccount, ACCOUNT_ACCESS_LEVEL);
        AccountManager accountManager2 = this.androidAccountManager;
        $jacocoInit[22] = true;
        String str = ACCOUNT_TERMS_AND_CONDITIONS;
        if (accountManager2.getUserData(androidAccount, str) != null) {
            AccountManager accountManager3 = this.androidAccountManager;
            $jacocoInit[23] = true;
            boolean booleanValue = Boolean.valueOf(accountManager3.getUserData(androidAccount, str)).booleanValue();
            $jacocoInit[24] = true;
            terms = booleanValue;
        } else {
            $jacocoInit[25] = true;
            terms = false;
        }
        AccountManager accountManager4 = this.androidAccountManager;
        $jacocoInit[26] = true;
        String str2 = ACCOUNT_PRIVACY_POLICY;
        if (accountManager4.getUserData(androidAccount, str2) != null) {
            AccountManager accountManager5 = this.androidAccountManager;
            $jacocoInit[27] = true;
            String userData = accountManager5.getUserData(androidAccount, str2);
            $jacocoInit[28] = true;
            boolean booleanValue2 = Boolean.valueOf(userData).booleanValue();
            $jacocoInit[29] = true;
            privacy = booleanValue2;
        } else {
            $jacocoInit[30] = true;
            privacy = false;
        }
        AccountManager accountManager6 = this.androidAccountManager;
        $jacocoInit[31] = true;
        String str3 = ACCOUNT_BIRTH_DATE;
        if (accountManager6.getUserData(androidAccount, str3) != null) {
            AccountManager accountManager7 = this.androidAccountManager;
            $jacocoInit[32] = true;
            date = new Date(accountManager7.getUserData(androidAccount, str3));
            $jacocoInit[33] = true;
        } else {
            date = new Date(1970, 1, 1);
            $jacocoInit[34] = true;
        }
        Date birthdate = date;
        $jacocoInit[35] = true;
        Single single = this.storePersist.get();
        C1410H h = C1410H.f4313a;
        $jacocoInit[36] = true;
        Single a = single.mo3687a((C0129b<Throwable>) h);
        C1411I i = new C1411I(this, access, androidAccount, privacy, terms, birthdate);
        $jacocoInit[37] = true;
        Single a2 = a.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) i);
        $jacocoInit[38] = true;
        return a2;
    }

    /* renamed from: a */
    static /* synthetic */ void m6202a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[51] = true;
        instance.log(err);
        $jacocoInit[52] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9598a(String access, android.accounts.Account androidAccount, boolean privacy, boolean terms, Date birthdate, List stores) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C1413K k = new C1413K(this, access, stores, androidAccount, privacy, terms, birthdate);
        $jacocoInit[39] = true;
        Single a = authentication.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) k);
        $jacocoInit[40] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9599a(String access, List stores, android.accounts.Account androidAccount, boolean privacy, boolean terms, Date birthdate, Authentication authentication) {
        android.accounts.Account account = androidAccount;
        boolean[] $jacocoInit = $jacocoInit();
        if (authentication.isAuthenticated()) {
            AccountFactory accountFactory2 = this.accountFactory;
            AccountManager accountManager = this.androidAccountManager;
            $jacocoInit[41] = true;
            String userData = accountManager.getUserData(account, ACCOUNT_ID);
            String str = account.name;
            AccountManager accountManager2 = this.androidAccountManager;
            $jacocoInit[42] = true;
            String userData2 = accountManager2.getUserData(account, "username");
            AccountManager accountManager3 = this.androidAccountManager;
            $jacocoInit[43] = true;
            String userData3 = accountManager3.getUserData(account, ACCOUNT_AVATAR_URL);
            $jacocoInit[44] = true;
            Store createStore = createStore(account);
            AccountManager accountManager4 = this.androidAccountManager;
            $jacocoInit[45] = true;
            boolean booleanValue = Boolean.valueOf(accountManager4.getUserData(account, ACCOUNT_ADULT_CONTENT_ENABLED)).booleanValue();
            AccountManager accountManager5 = this.androidAccountManager;
            $jacocoInit[46] = true;
            String userData4 = accountManager5.getUserData(account, ACCOUNT_ACCESS_CONFIRMED);
            $jacocoInit[47] = true;
            boolean booleanValue2 = Boolean.valueOf(userData4).booleanValue();
            $jacocoInit[48] = true;
            Single a = Single.m734a(accountFactory2.createAccount(access, stores, userData, str, userData2, userData3, createStore, booleanValue, booleanValue2, privacy, terms, birthdate));
            $jacocoInit[49] = true;
            return a;
        }
        Single a2 = Single.m735a((Throwable) new IllegalStateException("Account not authenticated"));
        $jacocoInit[50] = true;
        return a2;
    }

    public C0117M removeAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeAndroidAccount = this.androidAccountProvider.removeAndroidAccount();
        C1412J j = new C1412J(this);
        $jacocoInit[10] = true;
        C0117M a = removeAndroidAccount.mo3582a((C0128a) j);
        $jacocoInit[11] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9600a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountCache = null;
        $jacocoInit[20] = true;
    }

    private Store createStore(android.accounts.Account account) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountManager accountManager = this.androidAccountManager;
        $jacocoInit[12] = true;
        long longValue = Long.valueOf(accountManager.getUserData(account, ACCOUNT_STORE_DOWNLOAD_COUNT)).longValue();
        AccountManager accountManager2 = this.androidAccountManager;
        $jacocoInit[13] = true;
        String userData = accountManager2.getUserData(account, ACCOUNT_STORE_AVATAR_URL);
        AccountManager accountManager3 = this.androidAccountManager;
        $jacocoInit[14] = true;
        long longValue2 = Long.valueOf(accountManager3.getUserData(account, ACCOUNT_STORE_ID)).longValue();
        AccountManager accountManager4 = this.androidAccountManager;
        $jacocoInit[15] = true;
        String userData2 = accountManager4.getUserData(account, ACCOUNT_STORE_NAME);
        AccountManager accountManager5 = this.androidAccountManager;
        $jacocoInit[16] = true;
        String userData3 = accountManager5.getUserData(account, ACCOUNT_STORE_THEME);
        AccountManager accountManager6 = this.androidAccountManager;
        $jacocoInit[17] = true;
        String userData4 = accountManager6.getUserData(account, ACCOUNT_STORE_USERNAME);
        AccountManager accountManager7 = this.androidAccountManager;
        $jacocoInit[18] = true;
        Store store = new Store(longValue, userData, longValue2, userData2, userData3, userData4, accountManager7.getUserData(account, ACCOUNT_STORE_PASSWORD), true);
        $jacocoInit[19] = true;
        return store;
    }
}
