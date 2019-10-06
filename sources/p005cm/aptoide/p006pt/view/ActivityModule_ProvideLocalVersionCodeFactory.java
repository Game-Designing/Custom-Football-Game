package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideLocalVersionCodeFactory */
public final class ActivityModule_ProvideLocalVersionCodeFactory implements C13181b<Integer> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;
    private final Provider<String> packageNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7715407678679873226L, "cm/aptoide/pt/view/ActivityModule_ProvideLocalVersionCodeFactory", 5);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideLocalVersionCodeFactory(ActivityModule module2, Provider<String> packageNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.packageNameProvider = packageNameProvider2;
        $jacocoInit[0] = true;
    }

    public Integer get() {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(this.module.provideLocalVersionCode((String) this.packageNameProvider.get()));
        $jacocoInit[1] = true;
        return valueOf;
    }

    public static C13181b<Integer> create(ActivityModule module2, Provider<String> packageNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideLocalVersionCodeFactory activityModule_ProvideLocalVersionCodeFactory = new ActivityModule_ProvideLocalVersionCodeFactory(module2, packageNameProvider2);
        $jacocoInit[2] = true;
        return activityModule_ProvideLocalVersionCodeFactory;
    }

    public static int proxyProvideLocalVersionCode(ActivityModule instance, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        int provideLocalVersionCode = instance.provideLocalVersionCode(packageName);
        $jacocoInit[3] = true;
        return provideLocalVersionCode;
    }
}
