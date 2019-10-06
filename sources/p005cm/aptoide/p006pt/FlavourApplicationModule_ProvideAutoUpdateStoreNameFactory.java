package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvideAutoUpdateStoreNameFactory */
public final class FlavourApplicationModule_ProvideAutoUpdateStoreNameFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5201743679883152025L, "cm/aptoide/pt/FlavourApplicationModule_ProvideAutoUpdateStoreNameFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvideAutoUpdateStoreNameFactory(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        $jacocoInit[1] = true;
        String provideAutoUpdateStoreName = flavourApplicationModule.provideAutoUpdateStoreName();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAutoUpdateStoreName, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideAutoUpdateStoreName;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvideAutoUpdateStoreNameFactory flavourApplicationModule_ProvideAutoUpdateStoreNameFactory = new FlavourApplicationModule_ProvideAutoUpdateStoreNameFactory(module2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvideAutoUpdateStoreNameFactory;
    }

    public static String proxyProvideAutoUpdateStoreName(FlavourApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideAutoUpdateStoreName = instance.provideAutoUpdateStoreName();
        $jacocoInit[5] = true;
        return provideAutoUpdateStoreName;
    }
}
