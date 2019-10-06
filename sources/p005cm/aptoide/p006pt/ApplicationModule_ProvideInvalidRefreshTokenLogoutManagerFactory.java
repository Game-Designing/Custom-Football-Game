package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory */
public final class ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory implements C13181b<InvalidRefreshTokenLogoutManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final ApplicationModule module;
    private final Provider<TokenInvalidator> refreshTokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1874599970067780234L, "cm/aptoide/pt/ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory(ApplicationModule module2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<TokenInvalidator> refreshTokenInvalidatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.aptoideAccountManagerProvider = aptoideAccountManagerProvider2;
        this.refreshTokenInvalidatorProvider = refreshTokenInvalidatorProvider2;
        $jacocoInit[0] = true;
    }

    public InvalidRefreshTokenLogoutManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AptoideAccountManager> provider = this.aptoideAccountManagerProvider;
        $jacocoInit[1] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider.get();
        TokenInvalidator tokenInvalidator = (TokenInvalidator) this.refreshTokenInvalidatorProvider.get();
        $jacocoInit[2] = true;
        InvalidRefreshTokenLogoutManager provideInvalidRefreshTokenLogoutManager = applicationModule.provideInvalidRefreshTokenLogoutManager(aptoideAccountManager, tokenInvalidator);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideInvalidRefreshTokenLogoutManager, "Cannot return null from a non-@Nullable @Provides method");
        InvalidRefreshTokenLogoutManager invalidRefreshTokenLogoutManager = provideInvalidRefreshTokenLogoutManager;
        $jacocoInit[4] = true;
        return invalidRefreshTokenLogoutManager;
    }

    public static C13181b<InvalidRefreshTokenLogoutManager> create(ApplicationModule module2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<TokenInvalidator> refreshTokenInvalidatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory applicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory = new ApplicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory(module2, aptoideAccountManagerProvider2, refreshTokenInvalidatorProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideInvalidRefreshTokenLogoutManagerFactory;
    }

    public static InvalidRefreshTokenLogoutManager proxyProvideInvalidRefreshTokenLogoutManager(ApplicationModule instance, AptoideAccountManager aptoideAccountManager, TokenInvalidator refreshTokenInvalidator) {
        boolean[] $jacocoInit = $jacocoInit();
        InvalidRefreshTokenLogoutManager provideInvalidRefreshTokenLogoutManager = instance.provideInvalidRefreshTokenLogoutManager(aptoideAccountManager, refreshTokenInvalidator);
        $jacocoInit[6] = true;
        return provideInvalidRefreshTokenLogoutManager;
    }
}
