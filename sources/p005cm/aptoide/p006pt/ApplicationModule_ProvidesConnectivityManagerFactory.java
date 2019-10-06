package p005cm.aptoide.p006pt;

import android.net.ConnectivityManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesConnectivityManagerFactory */
public final class ApplicationModule_ProvidesConnectivityManagerFactory implements C13181b<ConnectivityManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7254353411894411212L, "cm/aptoide/pt/ApplicationModule_ProvidesConnectivityManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesConnectivityManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ConnectivityManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        ConnectivityManager providesConnectivityManager = applicationModule.providesConnectivityManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesConnectivityManager, "Cannot return null from a non-@Nullable @Provides method");
        ConnectivityManager connectivityManager = providesConnectivityManager;
        $jacocoInit[3] = true;
        return connectivityManager;
    }

    public static C13181b<ConnectivityManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesConnectivityManagerFactory applicationModule_ProvidesConnectivityManagerFactory = new ApplicationModule_ProvidesConnectivityManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesConnectivityManagerFactory;
    }

    public static ConnectivityManager proxyProvidesConnectivityManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ConnectivityManager providesConnectivityManager = instance.providesConnectivityManager();
        $jacocoInit[5] = true;
        return providesConnectivityManager;
    }
}
