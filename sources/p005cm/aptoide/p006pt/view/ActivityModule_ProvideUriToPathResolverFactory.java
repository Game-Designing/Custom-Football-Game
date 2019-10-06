package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideUriToPathResolverFactory */
public final class ActivityModule_ProvideUriToPathResolverFactory implements C13181b<UriToPathResolver> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7582560141213282028L, "cm/aptoide/pt/view/ActivityModule_ProvideUriToPathResolverFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideUriToPathResolverFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public UriToPathResolver get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        UriToPathResolver provideUriToPathResolver = activityModule.provideUriToPathResolver();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideUriToPathResolver, "Cannot return null from a non-@Nullable @Provides method");
        UriToPathResolver uriToPathResolver = provideUriToPathResolver;
        $jacocoInit[3] = true;
        return uriToPathResolver;
    }

    public static C13181b<UriToPathResolver> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideUriToPathResolverFactory activityModule_ProvideUriToPathResolverFactory = new ActivityModule_ProvideUriToPathResolverFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvideUriToPathResolverFactory;
    }

    public static UriToPathResolver proxyProvideUriToPathResolver(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        UriToPathResolver provideUriToPathResolver = instance.provideUriToPathResolver();
        $jacocoInit[5] = true;
        return provideUriToPathResolver;
    }
}
