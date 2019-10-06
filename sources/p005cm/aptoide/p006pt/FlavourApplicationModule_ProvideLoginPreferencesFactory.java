package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.LoginPreferences;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvideLoginPreferencesFactory */
public final class FlavourApplicationModule_ProvideLoginPreferencesFactory implements C13181b<LoginPreferences> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4712101203257806177L, "cm/aptoide/pt/FlavourApplicationModule_ProvideLoginPreferencesFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvideLoginPreferencesFactory(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public LoginPreferences get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        $jacocoInit[1] = true;
        LoginPreferences provideLoginPreferences = flavourApplicationModule.provideLoginPreferences();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideLoginPreferences, "Cannot return null from a non-@Nullable @Provides method");
        LoginPreferences loginPreferences = provideLoginPreferences;
        $jacocoInit[3] = true;
        return loginPreferences;
    }

    public static C13181b<LoginPreferences> create(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvideLoginPreferencesFactory flavourApplicationModule_ProvideLoginPreferencesFactory = new FlavourApplicationModule_ProvideLoginPreferencesFactory(module2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvideLoginPreferencesFactory;
    }

    public static LoginPreferences proxyProvideLoginPreferences(FlavourApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        LoginPreferences provideLoginPreferences = instance.provideLoginPreferences();
        $jacocoInit[5] = true;
        return provideLoginPreferences;
    }
}
