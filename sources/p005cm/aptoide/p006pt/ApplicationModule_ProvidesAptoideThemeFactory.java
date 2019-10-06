package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAptoideThemeFactory */
public final class ApplicationModule_ProvidesAptoideThemeFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2686983155062728285L, "cm/aptoide/pt/ApplicationModule_ProvidesAptoideThemeFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAptoideThemeFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        String providesAptoideTheme = applicationModule.providesAptoideTheme();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAptoideTheme, "Cannot return null from a non-@Nullable @Provides method");
        String str = providesAptoideTheme;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAptoideThemeFactory applicationModule_ProvidesAptoideThemeFactory = new ApplicationModule_ProvidesAptoideThemeFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAptoideThemeFactory;
    }

    public static String proxyProvidesAptoideTheme(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        String providesAptoideTheme = instance.providesAptoideTheme();
        $jacocoInit[5] = true;
        return providesAptoideTheme;
    }
}
