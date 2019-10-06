package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AndroidAccountProvider;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAuthenticationPersistenceFactory */
public final class ApplicationModule_ProvideAuthenticationPersistenceFactory implements C13181b<AuthenticationPersistence> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AndroidAccountProvider> androidAccountProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5156148750258872122L, "cm/aptoide/pt/ApplicationModule_ProvideAuthenticationPersistenceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAuthenticationPersistenceFactory(ApplicationModule module2, Provider<AndroidAccountProvider> androidAccountProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.androidAccountProvider = androidAccountProvider2;
        $jacocoInit[0] = true;
    }

    public AuthenticationPersistence get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AndroidAccountProvider> provider = this.androidAccountProvider;
        $jacocoInit[1] = true;
        AuthenticationPersistence provideAuthenticationPersistence = applicationModule.provideAuthenticationPersistence((AndroidAccountProvider) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAuthenticationPersistence, "Cannot return null from a non-@Nullable @Provides method");
        AuthenticationPersistence authenticationPersistence = provideAuthenticationPersistence;
        $jacocoInit[3] = true;
        return authenticationPersistence;
    }

    public static C13181b<AuthenticationPersistence> create(ApplicationModule module2, Provider<AndroidAccountProvider> androidAccountProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAuthenticationPersistenceFactory applicationModule_ProvideAuthenticationPersistenceFactory = new ApplicationModule_ProvideAuthenticationPersistenceFactory(module2, androidAccountProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAuthenticationPersistenceFactory;
    }

    public static AuthenticationPersistence proxyProvideAuthenticationPersistence(ApplicationModule instance, AndroidAccountProvider androidAccountProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthenticationPersistence provideAuthenticationPersistence = instance.provideAuthenticationPersistence(androidAccountProvider2);
        $jacocoInit[5] = true;
        return provideAuthenticationPersistence;
    }
}
