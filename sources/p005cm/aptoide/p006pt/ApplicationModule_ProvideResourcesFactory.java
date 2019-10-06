package p005cm.aptoide.p006pt;

import android.content.res.Resources;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideResourcesFactory */
public final class ApplicationModule_ProvideResourcesFactory implements C13181b<Resources> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6955968410827127999L, "cm/aptoide/pt/ApplicationModule_ProvideResourcesFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideResourcesFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Resources get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Resources provideResources = applicationModule.provideResources();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideResources, "Cannot return null from a non-@Nullable @Provides method");
        Resources resources = provideResources;
        $jacocoInit[3] = true;
        return resources;
    }

    public static C13181b<Resources> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideResourcesFactory applicationModule_ProvideResourcesFactory = new ApplicationModule_ProvideResourcesFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideResourcesFactory;
    }

    public static Resources proxyProvideResources(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources provideResources = instance.provideResources();
        $jacocoInit[5] = true;
        return provideResources;
    }
}
