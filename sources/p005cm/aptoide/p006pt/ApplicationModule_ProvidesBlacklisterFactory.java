package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.blacklist.BlacklistPersistence;
import p005cm.aptoide.p006pt.blacklist.Blacklister;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBlacklisterFactory */
public final class ApplicationModule_ProvidesBlacklisterFactory implements C13181b<Blacklister> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BlacklistPersistence> blacklistPersistenceProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6191353858906811492L, "cm/aptoide/pt/ApplicationModule_ProvidesBlacklisterFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBlacklisterFactory(ApplicationModule module2, Provider<BlacklistPersistence> blacklistPersistenceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.blacklistPersistenceProvider = blacklistPersistenceProvider2;
        $jacocoInit[0] = true;
    }

    public Blacklister get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<BlacklistPersistence> provider = this.blacklistPersistenceProvider;
        $jacocoInit[1] = true;
        Blacklister providesBlacklister = applicationModule.providesBlacklister((BlacklistPersistence) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBlacklister, "Cannot return null from a non-@Nullable @Provides method");
        Blacklister blacklister = providesBlacklister;
        $jacocoInit[3] = true;
        return blacklister;
    }

    public static C13181b<Blacklister> create(ApplicationModule module2, Provider<BlacklistPersistence> blacklistPersistenceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBlacklisterFactory applicationModule_ProvidesBlacklisterFactory = new ApplicationModule_ProvidesBlacklisterFactory(module2, blacklistPersistenceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesBlacklisterFactory;
    }

    public static Blacklister proxyProvidesBlacklister(ApplicationModule instance, BlacklistPersistence blacklistPersistence) {
        boolean[] $jacocoInit = $jacocoInit();
        Blacklister providesBlacklister = instance.providesBlacklister(blacklistPersistence);
        $jacocoInit[5] = true;
        return providesBlacklister;
    }
}
