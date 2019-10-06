package p005cm.aptoide.p006pt;

import okhttp3.Interceptor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideRetrofitLogInterceptorFactory */
public final class ApplicationModule_ProvideRetrofitLogInterceptorFactory implements C13181b<Interceptor> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-715656290703746992L, "cm/aptoide/pt/ApplicationModule_ProvideRetrofitLogInterceptorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideRetrofitLogInterceptorFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Interceptor get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Interceptor provideRetrofitLogInterceptor = applicationModule.provideRetrofitLogInterceptor();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideRetrofitLogInterceptor, "Cannot return null from a non-@Nullable @Provides method");
        Interceptor interceptor = provideRetrofitLogInterceptor;
        $jacocoInit[3] = true;
        return interceptor;
    }

    public static C13181b<Interceptor> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideRetrofitLogInterceptorFactory applicationModule_ProvideRetrofitLogInterceptorFactory = new ApplicationModule_ProvideRetrofitLogInterceptorFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideRetrofitLogInterceptorFactory;
    }

    public static Interceptor proxyProvideRetrofitLogInterceptor(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Interceptor provideRetrofitLogInterceptor = instance.provideRetrofitLogInterceptor();
        $jacocoInit[5] = true;
        return provideRetrofitLogInterceptor;
    }
}
