package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.Interceptor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.AndroidAccountProvider;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideUserAgentInterceptorFactory */
public final class ApplicationModule_ProvideUserAgentInterceptorFactory implements C13181b<Interceptor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AndroidAccountProvider> androidAccountProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<String> partnerIdProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6939092929414620789L, "cm/aptoide/pt/ApplicationModule_ProvideUserAgentInterceptorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideUserAgentInterceptorFactory(ApplicationModule module2, Provider<AndroidAccountProvider> androidAccountProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<String> partnerIdProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.androidAccountProvider = androidAccountProvider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.partnerIdProvider = partnerIdProvider2;
        $jacocoInit[0] = true;
    }

    public Interceptor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AndroidAccountProvider> provider = this.androidAccountProvider;
        $jacocoInit[1] = true;
        AndroidAccountProvider androidAccountProvider2 = (AndroidAccountProvider) provider.get();
        IdsRepository idsRepository = (IdsRepository) this.idsRepositoryProvider.get();
        String str = (String) this.partnerIdProvider.get();
        $jacocoInit[2] = true;
        Interceptor provideUserAgentInterceptor = applicationModule.provideUserAgentInterceptor(androidAccountProvider2, idsRepository, str);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideUserAgentInterceptor, "Cannot return null from a non-@Nullable @Provides method");
        Interceptor interceptor = provideUserAgentInterceptor;
        $jacocoInit[4] = true;
        return interceptor;
    }

    public static C13181b<Interceptor> create(ApplicationModule module2, Provider<AndroidAccountProvider> androidAccountProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<String> partnerIdProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideUserAgentInterceptorFactory applicationModule_ProvideUserAgentInterceptorFactory = new ApplicationModule_ProvideUserAgentInterceptorFactory(module2, androidAccountProvider2, idsRepositoryProvider2, partnerIdProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideUserAgentInterceptorFactory;
    }

    public static Interceptor proxyProvideUserAgentInterceptor(ApplicationModule instance, AndroidAccountProvider androidAccountProvider2, IdsRepository idsRepository, String partnerId) {
        boolean[] $jacocoInit = $jacocoInit();
        Interceptor provideUserAgentInterceptor = instance.provideUserAgentInterceptor(androidAccountProvider2, idsRepository, partnerId);
        $jacocoInit[6] = true;
        return provideUserAgentInterceptor;
    }
}
