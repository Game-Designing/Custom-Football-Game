package p005cm.aptoide.p006pt;

import android.telephony.TelephonyManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesTelephonyManagerFactory */
public final class ApplicationModule_ProvidesTelephonyManagerFactory implements C13181b<TelephonyManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2466958393841468628L, "cm/aptoide/pt/ApplicationModule_ProvidesTelephonyManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesTelephonyManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public TelephonyManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        TelephonyManager providesTelephonyManager = applicationModule.providesTelephonyManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesTelephonyManager, "Cannot return null from a non-@Nullable @Provides method");
        TelephonyManager telephonyManager = providesTelephonyManager;
        $jacocoInit[3] = true;
        return telephonyManager;
    }

    public static C13181b<TelephonyManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesTelephonyManagerFactory applicationModule_ProvidesTelephonyManagerFactory = new ApplicationModule_ProvidesTelephonyManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesTelephonyManagerFactory;
    }

    public static TelephonyManager proxyProvidesTelephonyManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        TelephonyManager providesTelephonyManager = instance.providesTelephonyManager();
        $jacocoInit[5] = true;
        return providesTelephonyManager;
    }
}
