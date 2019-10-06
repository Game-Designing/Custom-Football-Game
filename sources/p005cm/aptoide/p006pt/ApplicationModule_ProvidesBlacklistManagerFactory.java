package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistUnitMapper;
import p005cm.aptoide.p006pt.blacklist.Blacklister;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBlacklistManagerFactory */
public final class ApplicationModule_ProvidesBlacklistManagerFactory implements C13181b<BlacklistManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BlacklistUnitMapper> blacklistUnitMapperProvider;
    private final Provider<Blacklister> blacklisterProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8765229962349459525L, "cm/aptoide/pt/ApplicationModule_ProvidesBlacklistManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBlacklistManagerFactory(ApplicationModule module2, Provider<Blacklister> blacklisterProvider2, Provider<BlacklistUnitMapper> blacklistUnitMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.blacklisterProvider = blacklisterProvider2;
        this.blacklistUnitMapperProvider = blacklistUnitMapperProvider2;
        $jacocoInit[0] = true;
    }

    public BlacklistManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Blacklister> provider = this.blacklisterProvider;
        $jacocoInit[1] = true;
        Blacklister blacklister = (Blacklister) provider.get();
        BlacklistUnitMapper blacklistUnitMapper = (BlacklistUnitMapper) this.blacklistUnitMapperProvider.get();
        $jacocoInit[2] = true;
        BlacklistManager providesBlacklistManager = applicationModule.providesBlacklistManager(blacklister, blacklistUnitMapper);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesBlacklistManager, "Cannot return null from a non-@Nullable @Provides method");
        BlacklistManager blacklistManager = providesBlacklistManager;
        $jacocoInit[4] = true;
        return blacklistManager;
    }

    public static C13181b<BlacklistManager> create(ApplicationModule module2, Provider<Blacklister> blacklisterProvider2, Provider<BlacklistUnitMapper> blacklistUnitMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBlacklistManagerFactory applicationModule_ProvidesBlacklistManagerFactory = new ApplicationModule_ProvidesBlacklistManagerFactory(module2, blacklisterProvider2, blacklistUnitMapperProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesBlacklistManagerFactory;
    }

    public static BlacklistManager proxyProvidesBlacklistManager(ApplicationModule instance, Blacklister blacklister, BlacklistUnitMapper blacklistUnitMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistManager providesBlacklistManager = instance.providesBlacklistManager(blacklister, blacklistUnitMapper);
        $jacocoInit[6] = true;
        return providesBlacklistManager;
    }
}
