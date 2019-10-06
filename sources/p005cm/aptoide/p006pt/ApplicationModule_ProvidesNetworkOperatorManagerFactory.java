package p005cm.aptoide.p006pt;

import android.telephony.TelephonyManager;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.NetworkOperatorManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesNetworkOperatorManagerFactory */
public final class ApplicationModule_ProvidesNetworkOperatorManagerFactory implements C13181b<NetworkOperatorManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<TelephonyManager> telephonyManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4796938031009617845L, "cm/aptoide/pt/ApplicationModule_ProvidesNetworkOperatorManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesNetworkOperatorManagerFactory(ApplicationModule module2, Provider<TelephonyManager> telephonyManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.telephonyManagerProvider = telephonyManagerProvider2;
        $jacocoInit[0] = true;
    }

    public NetworkOperatorManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<TelephonyManager> provider = this.telephonyManagerProvider;
        $jacocoInit[1] = true;
        NetworkOperatorManager providesNetworkOperatorManager = applicationModule.providesNetworkOperatorManager((TelephonyManager) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesNetworkOperatorManager, "Cannot return null from a non-@Nullable @Provides method");
        NetworkOperatorManager networkOperatorManager = providesNetworkOperatorManager;
        $jacocoInit[3] = true;
        return networkOperatorManager;
    }

    public static C13181b<NetworkOperatorManager> create(ApplicationModule module2, Provider<TelephonyManager> telephonyManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesNetworkOperatorManagerFactory applicationModule_ProvidesNetworkOperatorManagerFactory = new ApplicationModule_ProvidesNetworkOperatorManagerFactory(module2, telephonyManagerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesNetworkOperatorManagerFactory;
    }

    public static NetworkOperatorManager proxyProvidesNetworkOperatorManager(ApplicationModule instance, TelephonyManager telephonyManager) {
        boolean[] $jacocoInit = $jacocoInit();
        NetworkOperatorManager providesNetworkOperatorManager = instance.providesNetworkOperatorManager(telephonyManager);
        $jacocoInit[5] = true;
        return providesNetworkOperatorManager;
    }
}
