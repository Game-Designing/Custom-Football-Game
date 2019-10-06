package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideHomePromotionsIdFactory */
public final class ApplicationModule_ProvideHomePromotionsIdFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4783606586038640123L, "cm/aptoide/pt/ApplicationModule_ProvideHomePromotionsIdFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideHomePromotionsIdFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String provideHomePromotionsId = applicationModule.provideHomePromotionsId();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideHomePromotionsId, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideHomePromotionsId;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideHomePromotionsIdFactory applicationModule_ProvideHomePromotionsIdFactory = new ApplicationModule_ProvideHomePromotionsIdFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideHomePromotionsIdFactory;
    }

    public static String proxyProvideHomePromotionsId(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideHomePromotionsId = instance.provideHomePromotionsId();
        $jacocoInit[5] = true;
        return provideHomePromotionsId;
    }
}
