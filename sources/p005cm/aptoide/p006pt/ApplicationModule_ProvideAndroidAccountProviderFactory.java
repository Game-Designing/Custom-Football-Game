package p005cm.aptoide.p006pt;

import android.accounts.AccountManager;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AndroidAccountProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAndroidAccountProviderFactory */
public final class ApplicationModule_ProvideAndroidAccountProviderFactory implements C13181b<AndroidAccountProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountManager> accountManagerProvider;
    private final Provider<String> accountTypeProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4531179556301214412L, "cm/aptoide/pt/ApplicationModule_ProvideAndroidAccountProviderFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAndroidAccountProviderFactory(ApplicationModule module2, Provider<AccountManager> accountManagerProvider2, Provider<String> accountTypeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountManagerProvider = accountManagerProvider2;
        this.accountTypeProvider = accountTypeProvider2;
        $jacocoInit[0] = true;
    }

    public AndroidAccountProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AccountManager> provider = this.accountManagerProvider;
        $jacocoInit[1] = true;
        AccountManager accountManager = (AccountManager) provider.get();
        String str = (String) this.accountTypeProvider.get();
        $jacocoInit[2] = true;
        AndroidAccountProvider provideAndroidAccountProvider = applicationModule.provideAndroidAccountProvider(accountManager, str);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideAndroidAccountProvider, "Cannot return null from a non-@Nullable @Provides method");
        AndroidAccountProvider androidAccountProvider = provideAndroidAccountProvider;
        $jacocoInit[4] = true;
        return androidAccountProvider;
    }

    public static C13181b<AndroidAccountProvider> create(ApplicationModule module2, Provider<AccountManager> accountManagerProvider2, Provider<String> accountTypeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAndroidAccountProviderFactory applicationModule_ProvideAndroidAccountProviderFactory = new ApplicationModule_ProvideAndroidAccountProviderFactory(module2, accountManagerProvider2, accountTypeProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideAndroidAccountProviderFactory;
    }

    public static AndroidAccountProvider proxyProvideAndroidAccountProvider(ApplicationModule instance, AccountManager accountManager, String accountType) {
        boolean[] $jacocoInit = $jacocoInit();
        AndroidAccountProvider provideAndroidAccountProvider = instance.provideAndroidAccountProvider(accountManager, accountType);
        $jacocoInit[6] = true;
        return provideAndroidAccountProvider;
    }
}
