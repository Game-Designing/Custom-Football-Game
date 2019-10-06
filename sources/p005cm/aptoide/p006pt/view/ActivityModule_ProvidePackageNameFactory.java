package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidePackageNameFactory */
public final class ActivityModule_ProvidePackageNameFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4820361087155092633L, "cm/aptoide/pt/view/ActivityModule_ProvidePackageNameFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidePackageNameFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        String providePackageName = activityModule.providePackageName();
        $jacocoInit[2] = true;
        C13182c.m43111a(providePackageName, "Cannot return null from a non-@Nullable @Provides method");
        String str = providePackageName;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidePackageNameFactory activityModule_ProvidePackageNameFactory = new ActivityModule_ProvidePackageNameFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvidePackageNameFactory;
    }

    public static String proxyProvidePackageName(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String providePackageName = instance.providePackageName();
        $jacocoInit[5] = true;
        return providePackageName;
    }
}
