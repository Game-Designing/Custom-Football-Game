package p005cm.aptoide.accountmanager;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.accountmanager.Account.Access;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p019d.p022i.p023b.C0100e;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.accountmanager.AptoideAccountManager */
public class AptoideAccountManager {
    public static final String APTOIDE_SIGN_UP_TYPE = "APTOIDE";
    private final AccountPersistence accountPersistence;
    private final C0100e<Account> accountRelay;
    private final AccountService accountService;
    private final SignUpAdapterRegistry adapterRegistry;
    private final AdultContent adultContent;
    private final CredentialsValidator credentialsValidator;
    private final StoreManager storeManager;

    /* renamed from: cm.aptoide.accountmanager.AptoideAccountManager$Builder */
    public static class Builder {
        private AccountPersistence accountPersistence;
        private C0100e<Account> accountRelay;
        private AccountService accountService;
        private final Map<String, SignUpAdapter> adapters = new HashMap();
        private AdultContent adultContent;
        private CredentialsValidator credentialsValidator;
        private StoreManager storeManager;

        public Builder setCredentialsValidator(CredentialsValidator credentialsValidator2) {
            this.credentialsValidator = credentialsValidator2;
            return this;
        }

        public Builder setAccountService(AccountService accountService2) {
            this.accountService = accountService2;
            return this;
        }

        public Builder setAdultService(AdultContent adultContent2) {
            this.adultContent = adultContent2;
            return this;
        }

        public Builder setAccountRelay(C0100e<Account> accountRelay2) {
            this.accountRelay = accountRelay2;
            return this;
        }

        public Builder setAccountPersistence(AccountPersistence accountPersistence2) {
            this.accountPersistence = accountPersistence2;
            return this;
        }

        public Builder registerSignUpAdapter(String type, SignUpAdapter signUpAdapter) {
            this.adapters.put(type, signUpAdapter);
            return this;
        }

        public Builder setStoreManager(StoreManager storeManager2) {
            this.storeManager = storeManager2;
            return this;
        }

        public AptoideAccountManager build() {
            if (this.accountPersistence == null) {
                throw new IllegalArgumentException("AccountDataPersist is mandatory.");
            } else if (this.accountService == null) {
                throw new IllegalArgumentException("AccountManagerService is mandatory.");
            } else if (this.storeManager != null) {
                if (this.credentialsValidator == null) {
                    this.credentialsValidator = new CredentialsValidator();
                }
                if (this.accountRelay == null) {
                    this.accountRelay = C0100e.m565o();
                }
                SignUpAdapterRegistry adapterRegistry = new SignUpAdapterRegistry(this.adapters, this.accountService);
                adapterRegistry.register(AptoideAccountManager.APTOIDE_SIGN_UP_TYPE, new AptoideSignUpAdapter(this.credentialsValidator));
                AptoideAccountManager aptoideAccountManager = new AptoideAccountManager(this.credentialsValidator, this.accountPersistence, this.accountService, this.accountRelay, adapterRegistry, this.storeManager, this.adultContent);
                return aptoideAccountManager;
            } else {
                throw new IllegalArgumentException("StoreManager is mandatory.");
            }
        }
    }

    private AptoideAccountManager(CredentialsValidator credentialsValidator2, AccountPersistence accountPersistence2, AccountService accountService2, C0100e<Account> accountRelay2, SignUpAdapterRegistry adapterRegistry2, StoreManager storeManager2, AdultContent adultContent2) {
        this.credentialsValidator = credentialsValidator2;
        this.accountPersistence = accountPersistence2;
        this.accountService = accountService2;
        this.accountRelay = accountRelay2;
        this.adapterRegistry = adapterRegistry2;
        this.storeManager = storeManager2;
        this.adultContent = adultContent2;
    }

    public C0120S<Account> accountStatus() {
        return C0120S.m649b((C0120S<? extends T>) this.accountRelay, this.accountPersistence.getAccount().mo3700f(new C1322e(this)).mo3696c());
    }

    /* renamed from: a */
    public /* synthetic */ Account mo295a(Throwable throwable) {
        return createLocalAccount();
    }

    private Single<Account> singleAccountStatus() {
        return accountStatus().mo3647d().mo3678n();
    }

    private Account createLocalAccount() {
        return new LocalAccount(Store.emptyStore());
    }

    @Deprecated
    public boolean isLoggedIn() {
        Account account = getAccount();
        return account != null && account.isLoggedIn();
    }

    /* renamed from: b */
    static /* synthetic */ Account m69b(Throwable throwable) {
        return null;
    }

    @Deprecated
    public Account getAccount() {
        return (Account) singleAccountStatus().mo3700f(C1328k.f4220a).mo3689a().mo46175a();
    }

    public C0117M logout() {
        return this.adapterRegistry.logoutAll().mo3580a(singleAccountStatus().mo3693b((C0132p<? super T, ? extends C0117M>) new C1333p<Object,Object>(this)).mo3580a(this.accountPersistence.removeAccount()).mo3582a((C0128a) new C1320c(this)));
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo308d(Account account) {
        return this.accountService.removeAccount();
    }

    /* renamed from: a */
    public /* synthetic */ void mo301a() {
        this.accountRelay.call(createLocalAccount());
    }

    public C0117M login(AptoideCredentials credentials) {
        return this.credentialsValidator.validate(credentials, false).mo3587a(this.accountService.getAccount(credentials.getEmail(), credentials.getPassword())).mo3693b((C0132p<? super T, ? extends C0117M>) new C1334q<Object,Object>(this));
    }

    public <T> C0117M signUp(String type, T data) {
        return this.adapterRegistry.signUp(type, data).mo3693b((C0132p<? super T, ? extends C0117M>) new C1331n<Object,Object>(this));
    }

    public boolean isSignUpEnabled(String type) {
        return this.adapterRegistry.isEnabled(type);
    }

    private C0117M syncAccount() {
        return this.accountService.getAccount().mo3693b((C0132p<? super T, ? extends C0117M>) new C1326i<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: saveAccount */
    public C0117M mo315g(Account account) {
        return this.accountPersistence.saveAccount(account).mo3582a((C0128a) new C1324g(this, account));
    }

    /* renamed from: e */
    public /* synthetic */ void mo310e(Account account) {
        this.accountRelay.call(account);
    }

    public void unsubscribeStore(String storeName, String storeUserName, String storePassword) {
        this.accountService.unsubscribeStore(storeName, storeUserName, storePassword).mo3588a((C0128a) C1335r.f4229a, (C0129b<? super Throwable>) C1330m.f4223a);
    }

    /* renamed from: b */
    static /* synthetic */ void m70b() {
    }

    public C0117M subscribeStore(String storeName, String storeUserName, String storePassword) {
        return this.accountService.subscribeStore(storeName, storeUserName, storePassword);
    }

    @Deprecated
    public boolean isAccountMature() {
        Account account = getAccount();
        return account != null && account.isAdultContentEnabled();
    }

    @Deprecated
    public boolean isAccountAccessConfirmed() {
        Account account = getAccount();
        return account != null && account.isAccessConfirmed();
    }

    public C0117M updateAccount(boolean adultContentEnabled) {
        return singleAccountStatus().mo3693b((C0132p<? super T, ? extends C0117M>) new C1332o<Object,Object>(this, adultContentEnabled));
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo300a(boolean adultContentEnabled, Account account) {
        return this.accountService.updateAccount(adultContentEnabled);
    }

    public C0117M updateAccount(String username) {
        if (TextUtils.isEmpty(username)) {
            return C0117M.m591b((Throwable) new AccountValidationException(5));
        }
        return singleAccountStatus().mo3693b((C0132p<? super T, ? extends C0117M>) new C1329l<Object,Object>(this, username));
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo298a(String username, Account account) {
        return this.accountService.updateAccountUsername(username).mo3580a(syncAccount());
    }

    public C0117M updateAccount(Access access) {
        return singleAccountStatus().mo3693b((C0132p<? super T, ? extends C0117M>) new C1319b<Object,Object>(this, access));
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo296a(Access access, Account account) {
        return this.accountService.updateAccount(access.name()).mo3580a(syncAccount());
    }

    public C0117M updateAccount(String username, String avatarPath) {
        return singleAccountStatus().mo3693b((C0132p<? super T, ? extends C0117M>) new C1323f<Object,Object>(this, username, avatarPath));
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo299a(String username, String avatarPath, Account account) {
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(avatarPath)) {
            return C0117M.m591b((Throwable) new AccountValidationException(6));
        }
        if (TextUtils.isEmpty(username)) {
            return C0117M.m591b((Throwable) new AccountValidationException(5));
        }
        return this.accountService.updateAccount(username, TextUtils.isEmpty(avatarPath) ? "" : avatarPath).mo3580a(syncAccount());
    }

    public C0117M changeBirthdayDate(String birthdate) {
        return this.accountService.changeBirthdate(birthdate).mo3580a(syncAccount());
    }

    public C0117M updateTermsAndConditions() {
        return this.accountService.updateTermsAndConditions().mo3586a(accountStatus()).mo3663g((C0132p<? super T, ? extends C0117M>) new C1321d<Object,Object>(this)).mo3673l();
    }

    /* renamed from: i */
    public /* synthetic */ C0117M mo318i(Account account) {
        AccountPersistence accountPersistence2 = this.accountPersistence;
        AptoideAccount aptoideAccount = new AptoideAccount(account.getId(), account.getEmail(), account.getNickname(), account.getAvatar(), account.getStore(), account.isAdultContentEnabled(), account.getAccess(), account.isAccessConfirmed(), account.getSubscribedStores(), true, true, account.getBirthDate());
        return accountPersistence2.saveAccount(aptoideAccount);
    }

    public C0117M changeSubscribeNewsletter(boolean isSubscribed) {
        if (isSubscribed) {
            return this.accountService.changeSubscribeNewsletter("1");
        }
        return this.accountService.changeSubscribeNewsletter(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
    }

    public C0120S<Boolean> pinRequired() {
        return this.adultContent.pinRequired();
    }

    public C0117M requirePin(int pin) {
        return this.adultContent.requirePin(pin);
    }

    public C0117M removePin(int pin) {
        return this.adultContent.removePin(pin);
    }

    public C0117M enable() {
        return accountStatus().mo3647d().mo3663g((C0132p<? super T, ? extends C0117M>) new C1318a<Object,Object>(this)).mo3673l();
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo303b(Account account) {
        return this.adultContent.enable(account.isLoggedIn());
    }

    public C0117M disable() {
        return accountStatus().mo3647d().mo3663g((C0132p<? super T, ? extends C0117M>) new C1325h<Object,Object>(this)).mo3673l();
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo297a(Account account) {
        return this.adultContent.disable(account.isLoggedIn());
    }

    public C0120S<Boolean> enabled() {
        return this.adultContent.enabled();
    }

    public C0117M enable(int pin) {
        return this.adultContent.enable(pin);
    }

    /* renamed from: h */
    public /* synthetic */ C0117M mo317h(Account account) {
        return syncAccount();
    }

    @Deprecated
    public C0117M updateAccount() {
        return singleAccountStatus().mo3693b((C0132p<? super T, ? extends C0117M>) new C1327j<Object,Object>(this));
    }

    public C0117M createOrUpdate(String storeName, String storeDescription, String storeImagePath, boolean hasNewAvatar, String storeThemeName, boolean storeExists, List<SocialLink> storeLinksList, List<SocialChannelType> storeDeleteLinksList) {
        return this.storeManager.createOrUpdate(storeName, storeDescription, storeImagePath, hasNewAvatar, storeThemeName, storeExists, storeLinksList, storeDeleteLinksList).mo3580a(syncAccount());
    }
}
