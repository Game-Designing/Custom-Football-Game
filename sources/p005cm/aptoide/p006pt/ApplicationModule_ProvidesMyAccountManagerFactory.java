package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesMyAccountManagerFactory */
public final class ApplicationModule_ProvidesMyAccountManagerFactory implements C13181b<MyAccountManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2206224413184221652L, "cm/aptoide/pt/ApplicationModule_ProvidesMyAccountManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesMyAccountManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public MyAccountManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        MyAccountManager providesMyAccountManager = applicationModule.providesMyAccountManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesMyAccountManager, "Cannot return null from a non-@Nullable @Provides method");
        MyAccountManager myAccountManager = providesMyAccountManager;
        $jacocoInit[3] = true;
        return myAccountManager;
    }

    public static C13181b<MyAccountManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesMyAccountManagerFactory applicationModule_ProvidesMyAccountManagerFactory = new ApplicationModule_ProvidesMyAccountManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesMyAccountManagerFactory;
    }

    public static MyAccountManager proxyProvidesMyAccountManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        MyAccountManager providesMyAccountManager = instance.providesMyAccountManager();
        $jacocoInit[5] = true;
        return providesMyAccountManager;
    }
}
