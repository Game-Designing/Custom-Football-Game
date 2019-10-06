package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideBottomNavigationMapperFactory */
public final class ActivityModule_ProvideBottomNavigationMapperFactory implements C13181b<BottomNavigationMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-478107994152374466L, "cm/aptoide/pt/view/ActivityModule_ProvideBottomNavigationMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideBottomNavigationMapperFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public BottomNavigationMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        BottomNavigationMapper provideBottomNavigationMapper = activityModule.provideBottomNavigationMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideBottomNavigationMapper, "Cannot return null from a non-@Nullable @Provides method");
        BottomNavigationMapper bottomNavigationMapper = provideBottomNavigationMapper;
        $jacocoInit[3] = true;
        return bottomNavigationMapper;
    }

    public static C13181b<BottomNavigationMapper> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideBottomNavigationMapperFactory activityModule_ProvideBottomNavigationMapperFactory = new ActivityModule_ProvideBottomNavigationMapperFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvideBottomNavigationMapperFactory;
    }

    public static BottomNavigationMapper proxyProvideBottomNavigationMapper(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationMapper provideBottomNavigationMapper = instance.provideBottomNavigationMapper();
        $jacocoInit[5] = true;
        return provideBottomNavigationMapper;
    }
}
