package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidePartnerIDFactory */
public final class FlavourApplicationModule_ProvidePartnerIDFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-141890266864078697L, "cm/aptoide/pt/FlavourApplicationModule_ProvidePartnerIDFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvidePartnerIDFactory(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        $jacocoInit[1] = true;
        String providePartnerID = flavourApplicationModule.providePartnerID();
        $jacocoInit[2] = true;
        C13182c.m43111a(providePartnerID, "Cannot return null from a non-@Nullable @Provides method");
        String str = providePartnerID;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvidePartnerIDFactory flavourApplicationModule_ProvidePartnerIDFactory = new FlavourApplicationModule_ProvidePartnerIDFactory(module2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvidePartnerIDFactory;
    }

    public static String proxyProvidePartnerID(FlavourApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String providePartnerID = instance.providePartnerID();
        $jacocoInit[5] = true;
        return providePartnerID;
    }
}
