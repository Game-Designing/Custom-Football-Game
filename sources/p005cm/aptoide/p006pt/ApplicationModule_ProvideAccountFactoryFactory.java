package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountFactory;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAccountFactoryFactory */
public final class ApplicationModule_ProvideAccountFactoryFactory implements C13181b<AccountFactory> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1645216586268254253L, "cm/aptoide/pt/ApplicationModule_ProvideAccountFactoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAccountFactoryFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AccountFactory get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AccountFactory provideAccountFactory = applicationModule.provideAccountFactory();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAccountFactory, "Cannot return null from a non-@Nullable @Provides method");
        AccountFactory accountFactory = provideAccountFactory;
        $jacocoInit[3] = true;
        return accountFactory;
    }

    public static C13181b<AccountFactory> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAccountFactoryFactory applicationModule_ProvideAccountFactoryFactory = new ApplicationModule_ProvideAccountFactoryFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAccountFactoryFactory;
    }

    public static AccountFactory proxyProvideAccountFactory(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountFactory provideAccountFactory = instance.provideAccountFactory();
        $jacocoInit[5] = true;
        return provideAccountFactory;
    }
}
