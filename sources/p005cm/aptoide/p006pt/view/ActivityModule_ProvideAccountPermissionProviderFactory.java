package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.permission.AccountPermissionProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideAccountPermissionProviderFactory */
public final class ActivityModule_ProvideAccountPermissionProviderFactory implements C13181b<AccountPermissionProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6163100116673359128L, "cm/aptoide/pt/view/ActivityModule_ProvideAccountPermissionProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideAccountPermissionProviderFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AccountPermissionProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        AccountPermissionProvider provideAccountPermissionProvider = activityModule.provideAccountPermissionProvider();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAccountPermissionProvider, "Cannot return null from a non-@Nullable @Provides method");
        AccountPermissionProvider accountPermissionProvider = provideAccountPermissionProvider;
        $jacocoInit[3] = true;
        return accountPermissionProvider;
    }

    public static C13181b<AccountPermissionProvider> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideAccountPermissionProviderFactory activityModule_ProvideAccountPermissionProviderFactory = new ActivityModule_ProvideAccountPermissionProviderFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvideAccountPermissionProviderFactory;
    }

    public static AccountPermissionProvider proxyProvideAccountPermissionProvider(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountPermissionProvider provideAccountPermissionProvider = instance.provideAccountPermissionProvider();
        $jacocoInit[5] = true;
        return provideAccountPermissionProvider;
    }
}
