package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.settings.SupportEmailProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSupportEmailProviderFactory */
public final class ApplicationModule_ProvidesSupportEmailProviderFactory implements C13181b<SupportEmailProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<String> supportEmailProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3372402806207391530L, "cm/aptoide/pt/ApplicationModule_ProvidesSupportEmailProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSupportEmailProviderFactory(ApplicationModule module2, Provider<String> supportEmailProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.supportEmailProvider = supportEmailProvider2;
        $jacocoInit[0] = true;
    }

    public SupportEmailProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.supportEmailProvider;
        $jacocoInit[1] = true;
        SupportEmailProvider providesSupportEmailProvider = applicationModule.providesSupportEmailProvider((String) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSupportEmailProvider, "Cannot return null from a non-@Nullable @Provides method");
        SupportEmailProvider supportEmailProvider2 = providesSupportEmailProvider;
        $jacocoInit[3] = true;
        return supportEmailProvider2;
    }

    public static C13181b<SupportEmailProvider> create(ApplicationModule module2, Provider<String> supportEmailProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSupportEmailProviderFactory applicationModule_ProvidesSupportEmailProviderFactory = new ApplicationModule_ProvidesSupportEmailProviderFactory(module2, supportEmailProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesSupportEmailProviderFactory;
    }

    public static SupportEmailProvider proxyProvidesSupportEmailProvider(ApplicationModule instance, String supportEmail) {
        boolean[] $jacocoInit = $jacocoInit();
        SupportEmailProvider providesSupportEmailProvider = instance.providesSupportEmailProvider(supportEmail);
        $jacocoInit[5] = true;
        return providesSupportEmailProvider;
    }
}
