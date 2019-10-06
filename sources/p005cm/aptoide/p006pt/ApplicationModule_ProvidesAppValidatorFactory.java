package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.download.AppValidationAnalytics;
import p005cm.aptoide.p006pt.download.AppValidator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppValidatorFactory */
public final class ApplicationModule_ProvidesAppValidatorFactory implements C13181b<AppValidator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppValidationAnalytics> appValidationAnalyticsProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3352323843357449175L, "cm/aptoide/pt/ApplicationModule_ProvidesAppValidatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppValidatorFactory(ApplicationModule module2, Provider<AppValidationAnalytics> appValidationAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appValidationAnalyticsProvider = appValidationAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public AppValidator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AppValidationAnalytics> provider = this.appValidationAnalyticsProvider;
        $jacocoInit[1] = true;
        AppValidator providesAppValidator = applicationModule.providesAppValidator((AppValidationAnalytics) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppValidator, "Cannot return null from a non-@Nullable @Provides method");
        AppValidator appValidator = providesAppValidator;
        $jacocoInit[3] = true;
        return appValidator;
    }

    public static C13181b<AppValidator> create(ApplicationModule module2, Provider<AppValidationAnalytics> appValidationAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppValidatorFactory applicationModule_ProvidesAppValidatorFactory = new ApplicationModule_ProvidesAppValidatorFactory(module2, appValidationAnalyticsProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAppValidatorFactory;
    }

    public static AppValidator proxyProvidesAppValidator(ApplicationModule instance, AppValidationAnalytics appValidationAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        AppValidator providesAppValidator = instance.providesAppValidator(appValidationAnalytics);
        $jacocoInit[5] = true;
        return providesAppValidator;
    }
}
