package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAccountTypeFactory */
public final class ApplicationModule_ProvideAccountTypeFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6325606016316873341L, "cm/aptoide/pt/ApplicationModule_ProvideAccountTypeFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAccountTypeFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String provideAccountType = applicationModule.provideAccountType();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAccountType, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideAccountType;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAccountTypeFactory applicationModule_ProvideAccountTypeFactory = new ApplicationModule_ProvideAccountTypeFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAccountTypeFactory;
    }

    public static String proxyProvideAccountType(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideAccountType = instance.provideAccountType();
        $jacocoInit[5] = true;
        return provideAccountType;
    }
}
