package p005cm.aptoide.p006pt;

import com.crashlytics.android.C0075a;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p024io.fabric.sdk.android.C13920f;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideCrashlyticsFactory */
public final class ApplicationModule_ProvideCrashlyticsFactory implements C13181b<C0075a> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<C13920f> fabricProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5114330903862734395L, "cm/aptoide/pt/ApplicationModule_ProvideCrashlyticsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideCrashlyticsFactory(ApplicationModule module2, Provider<C13920f> fabricProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fabricProvider = fabricProvider2;
        $jacocoInit[0] = true;
    }

    public C0075a get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<C13920f> provider = this.fabricProvider;
        $jacocoInit[1] = true;
        C0075a provideCrashlytics = applicationModule.provideCrashlytics((C13920f) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideCrashlytics, "Cannot return null from a non-@Nullable @Provides method");
        C0075a aVar = provideCrashlytics;
        $jacocoInit[3] = true;
        return aVar;
    }

    public static C13181b<C0075a> create(ApplicationModule module2, Provider<C13920f> fabricProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideCrashlyticsFactory applicationModule_ProvideCrashlyticsFactory = new ApplicationModule_ProvideCrashlyticsFactory(module2, fabricProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideCrashlyticsFactory;
    }

    public static C0075a proxyProvideCrashlytics(ApplicationModule instance, C13920f fabric) {
        boolean[] $jacocoInit = $jacocoInit();
        C0075a provideCrashlytics = instance.provideCrashlytics(fabric);
        $jacocoInit[5] = true;
        return provideCrashlytics;
    }
}
