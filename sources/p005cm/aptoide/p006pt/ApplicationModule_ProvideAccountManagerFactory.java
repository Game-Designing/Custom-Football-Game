package p005cm.aptoide.p006pt;

import android.accounts.AccountManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAccountManagerFactory */
public final class ApplicationModule_ProvideAccountManagerFactory implements C13181b<AccountManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3837978233246768564L, "cm/aptoide/pt/ApplicationModule_ProvideAccountManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAccountManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AccountManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AccountManager provideAccountManager = applicationModule.provideAccountManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAccountManager, "Cannot return null from a non-@Nullable @Provides method");
        AccountManager accountManager = provideAccountManager;
        $jacocoInit[3] = true;
        return accountManager;
    }

    public static C13181b<AccountManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAccountManagerFactory applicationModule_ProvideAccountManagerFactory = new ApplicationModule_ProvideAccountManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAccountManagerFactory;
    }

    public static AccountManager proxyProvideAccountManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountManager provideAccountManager = instance.provideAccountManager();
        $jacocoInit[5] = true;
        return provideAccountManager;
    }
}
