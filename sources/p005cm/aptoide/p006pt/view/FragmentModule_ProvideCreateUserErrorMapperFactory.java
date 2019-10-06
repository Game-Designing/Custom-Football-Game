package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountErrorMapper;
import p005cm.aptoide.p006pt.account.view.user.CreateUserErrorMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideCreateUserErrorMapperFactory */
public final class FragmentModule_ProvideCreateUserErrorMapperFactory implements C13181b<CreateUserErrorMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountErrorMapper> accountErrorMapperProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5508205745212125033L, "cm/aptoide/pt/view/FragmentModule_ProvideCreateUserErrorMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideCreateUserErrorMapperFactory(FragmentModule module2, Provider<AccountErrorMapper> accountErrorMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountErrorMapperProvider = accountErrorMapperProvider2;
        $jacocoInit[0] = true;
    }

    public CreateUserErrorMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AccountErrorMapper> provider = this.accountErrorMapperProvider;
        $jacocoInit[1] = true;
        CreateUserErrorMapper provideCreateUserErrorMapper = fragmentModule.provideCreateUserErrorMapper((AccountErrorMapper) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideCreateUserErrorMapper, "Cannot return null from a non-@Nullable @Provides method");
        CreateUserErrorMapper createUserErrorMapper = provideCreateUserErrorMapper;
        $jacocoInit[3] = true;
        return createUserErrorMapper;
    }

    public static C13181b<CreateUserErrorMapper> create(FragmentModule module2, Provider<AccountErrorMapper> accountErrorMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideCreateUserErrorMapperFactory fragmentModule_ProvideCreateUserErrorMapperFactory = new FragmentModule_ProvideCreateUserErrorMapperFactory(module2, accountErrorMapperProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvideCreateUserErrorMapperFactory;
    }

    public static CreateUserErrorMapper proxyProvideCreateUserErrorMapper(FragmentModule instance, AccountErrorMapper accountErrorMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        CreateUserErrorMapper provideCreateUserErrorMapper = instance.provideCreateUserErrorMapper(accountErrorMapper);
        $jacocoInit[5] = true;
        return provideCreateUserErrorMapper;
    }
}
