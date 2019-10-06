package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.OAuthModeProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideOAuthModeProviderFactory */
public final class ApplicationModule_ProvideOAuthModeProviderFactory implements C13181b<OAuthModeProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6769406125701194321L, "cm/aptoide/pt/ApplicationModule_ProvideOAuthModeProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideOAuthModeProviderFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public OAuthModeProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        OAuthModeProvider provideOAuthModeProvider = applicationModule.provideOAuthModeProvider();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideOAuthModeProvider, "Cannot return null from a non-@Nullable @Provides method");
        OAuthModeProvider oAuthModeProvider = provideOAuthModeProvider;
        $jacocoInit[3] = true;
        return oAuthModeProvider;
    }

    public static C13181b<OAuthModeProvider> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideOAuthModeProviderFactory applicationModule_ProvideOAuthModeProviderFactory = new ApplicationModule_ProvideOAuthModeProviderFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideOAuthModeProviderFactory;
    }

    public static OAuthModeProvider proxyProvideOAuthModeProvider(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        OAuthModeProvider provideOAuthModeProvider = instance.provideOAuthModeProvider();
        $jacocoInit[5] = true;
        return provideOAuthModeProvider;
    }
}
