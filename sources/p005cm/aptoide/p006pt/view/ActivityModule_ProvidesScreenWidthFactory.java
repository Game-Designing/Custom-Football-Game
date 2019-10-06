package p005cm.aptoide.p006pt.view;

import android.content.res.Resources;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesScreenWidthFactory */
public final class ActivityModule_ProvidesScreenWidthFactory implements C13181b<Float> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;
    private final Provider<Resources> resourcesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1636053555591735172L, "cm/aptoide/pt/view/ActivityModule_ProvidesScreenWidthFactory", 5);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesScreenWidthFactory(ActivityModule module2, Provider<Resources> resourcesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.resourcesProvider = resourcesProvider2;
        $jacocoInit[0] = true;
    }

    public Float get() {
        boolean[] $jacocoInit = $jacocoInit();
        Float valueOf = Float.valueOf(this.module.providesScreenWidth((Resources) this.resourcesProvider.get()));
        $jacocoInit[1] = true;
        return valueOf;
    }

    public static C13181b<Float> create(ActivityModule module2, Provider<Resources> resourcesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesScreenWidthFactory activityModule_ProvidesScreenWidthFactory = new ActivityModule_ProvidesScreenWidthFactory(module2, resourcesProvider2);
        $jacocoInit[2] = true;
        return activityModule_ProvidesScreenWidthFactory;
    }

    public static float proxyProvidesScreenWidth(ActivityModule instance, Resources resources) {
        boolean[] $jacocoInit = $jacocoInit();
        float providesScreenWidth = instance.providesScreenWidth(resources);
        $jacocoInit[3] = true;
        return providesScreenWidth;
    }
}
