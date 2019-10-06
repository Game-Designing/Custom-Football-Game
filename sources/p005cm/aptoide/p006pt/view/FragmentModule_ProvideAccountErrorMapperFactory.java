package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountErrorMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideAccountErrorMapperFactory */
public final class FragmentModule_ProvideAccountErrorMapperFactory implements C13181b<AccountErrorMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7876176810881745165L, "cm/aptoide/pt/view/FragmentModule_ProvideAccountErrorMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideAccountErrorMapperFactory(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AccountErrorMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        $jacocoInit[1] = true;
        AccountErrorMapper provideAccountErrorMapper = fragmentModule.provideAccountErrorMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAccountErrorMapper, "Cannot return null from a non-@Nullable @Provides method");
        AccountErrorMapper accountErrorMapper = provideAccountErrorMapper;
        $jacocoInit[3] = true;
        return accountErrorMapper;
    }

    public static C13181b<AccountErrorMapper> create(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideAccountErrorMapperFactory fragmentModule_ProvideAccountErrorMapperFactory = new FragmentModule_ProvideAccountErrorMapperFactory(module2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvideAccountErrorMapperFactory;
    }

    public static AccountErrorMapper proxyProvideAccountErrorMapper(FragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AccountErrorMapper provideAccountErrorMapper = instance.provideAccountErrorMapper();
        $jacocoInit[5] = true;
        return provideAccountErrorMapper;
    }
}
