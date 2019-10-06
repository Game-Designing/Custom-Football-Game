package p005cm.aptoide.p006pt;

import com.crashlytics.android.p124a.C6378b;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p024io.fabric.sdk.android.C13920f;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAnswersFactory */
public final class ApplicationModule_ProvideAnswersFactory implements C13181b<C6378b> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<C13920f> fabricProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4289737064394078810L, "cm/aptoide/pt/ApplicationModule_ProvideAnswersFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAnswersFactory(ApplicationModule module2, Provider<C13920f> fabricProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fabricProvider = fabricProvider2;
        $jacocoInit[0] = true;
    }

    public C6378b get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<C13920f> provider = this.fabricProvider;
        $jacocoInit[1] = true;
        C6378b provideAnswers = applicationModule.provideAnswers((C13920f) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAnswers, "Cannot return null from a non-@Nullable @Provides method");
        C6378b bVar = provideAnswers;
        $jacocoInit[3] = true;
        return bVar;
    }

    public static C13181b<C6378b> create(ApplicationModule module2, Provider<C13920f> fabricProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAnswersFactory applicationModule_ProvideAnswersFactory = new ApplicationModule_ProvideAnswersFactory(module2, fabricProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAnswersFactory;
    }

    public static C6378b proxyProvideAnswers(ApplicationModule instance, C13920f fabric) {
        boolean[] $jacocoInit = $jacocoInit();
        C6378b provideAnswers = instance.provideAnswers(fabric);
        $jacocoInit[5] = true;
        return provideAnswers;
    }
}
