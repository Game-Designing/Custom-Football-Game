package p005cm.aptoide.p006pt;

import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDecimalFormatFactory */
public final class ApplicationModule_ProvidesDecimalFormatFactory implements C13181b<DecimalFormat> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4250449833959729636L, "cm/aptoide/pt/ApplicationModule_ProvidesDecimalFormatFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDecimalFormatFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public DecimalFormat get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        DecimalFormat providesDecimalFormat = applicationModule.providesDecimalFormat();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesDecimalFormat, "Cannot return null from a non-@Nullable @Provides method");
        DecimalFormat decimalFormat = providesDecimalFormat;
        $jacocoInit[3] = true;
        return decimalFormat;
    }

    public static C13181b<DecimalFormat> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDecimalFormatFactory applicationModule_ProvidesDecimalFormatFactory = new ApplicationModule_ProvidesDecimalFormatFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesDecimalFormatFactory;
    }

    public static DecimalFormat proxyProvidesDecimalFormat(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        DecimalFormat providesDecimalFormat = instance.providesDecimalFormat();
        $jacocoInit[5] = true;
        return providesDecimalFormat;
    }
}
