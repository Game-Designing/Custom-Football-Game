package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideManageStoreErrorMapperFactory */
public final class FragmentModule_ProvideManageStoreErrorMapperFactory implements C13181b<ManageStoreErrorMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3197513969344326812L, "cm/aptoide/pt/view/FragmentModule_ProvideManageStoreErrorMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideManageStoreErrorMapperFactory(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ManageStoreErrorMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        $jacocoInit[1] = true;
        ManageStoreErrorMapper provideManageStoreErrorMapper = fragmentModule.provideManageStoreErrorMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideManageStoreErrorMapper, "Cannot return null from a non-@Nullable @Provides method");
        ManageStoreErrorMapper manageStoreErrorMapper = provideManageStoreErrorMapper;
        $jacocoInit[3] = true;
        return manageStoreErrorMapper;
    }

    public static C13181b<ManageStoreErrorMapper> create(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideManageStoreErrorMapperFactory fragmentModule_ProvideManageStoreErrorMapperFactory = new FragmentModule_ProvideManageStoreErrorMapperFactory(module2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvideManageStoreErrorMapperFactory;
    }

    public static ManageStoreErrorMapper proxyProvideManageStoreErrorMapper(FragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreErrorMapper provideManageStoreErrorMapper = instance.provideManageStoreErrorMapper();
        $jacocoInit[5] = true;
        return provideManageStoreErrorMapper;
    }
}
