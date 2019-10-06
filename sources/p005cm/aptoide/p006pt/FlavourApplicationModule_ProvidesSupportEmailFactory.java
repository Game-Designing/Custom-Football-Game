package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesSupportEmailFactory */
public final class FlavourApplicationModule_ProvidesSupportEmailFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5957649148468089332L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesSupportEmailFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvidesSupportEmailFactory(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        $jacocoInit[1] = true;
        String providesSupportEmail = flavourApplicationModule.providesSupportEmail();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSupportEmail, "Cannot return null from a non-@Nullable @Provides method");
        String str = providesSupportEmail;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvidesSupportEmailFactory flavourApplicationModule_ProvidesSupportEmailFactory = new FlavourApplicationModule_ProvidesSupportEmailFactory(module2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvidesSupportEmailFactory;
    }

    public static String proxyProvidesSupportEmail(FlavourApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String providesSupportEmail = instance.providesSupportEmail();
        $jacocoInit[5] = true;
        return providesSupportEmail;
    }
}
