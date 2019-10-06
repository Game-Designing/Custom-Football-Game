package p005cm.aptoide.p006pt;

import android.content.ContentResolver;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideContentResolverFactory */
public final class ApplicationModule_ProvideContentResolverFactory implements C13181b<ContentResolver> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4527390675078477092L, "cm/aptoide/pt/ApplicationModule_ProvideContentResolverFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideContentResolverFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public ContentResolver get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        ContentResolver provideContentResolver = applicationModule.provideContentResolver();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideContentResolver, "Cannot return null from a non-@Nullable @Provides method");
        ContentResolver contentResolver = provideContentResolver;
        $jacocoInit[3] = true;
        return contentResolver;
    }

    public static C13181b<ContentResolver> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideContentResolverFactory applicationModule_ProvideContentResolverFactory = new ApplicationModule_ProvideContentResolverFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideContentResolverFactory;
    }

    public static ContentResolver proxyProvideContentResolver(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        ContentResolver provideContentResolver = instance.provideContentResolver();
        $jacocoInit[5] = true;
        return provideContentResolver;
    }
}
