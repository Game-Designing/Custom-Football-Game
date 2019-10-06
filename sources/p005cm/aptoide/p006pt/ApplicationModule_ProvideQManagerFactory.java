package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideQManagerFactory */
public final class ApplicationModule_ProvideQManagerFactory implements C13181b<QManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Resources> resourcesProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<WindowManager> windowManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1519551160909004472L, "cm/aptoide/pt/ApplicationModule_ProvideQManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideQManagerFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<WindowManager> windowManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.resourcesProvider = resourcesProvider2;
        this.windowManagerProvider = windowManagerProvider2;
        $jacocoInit[0] = true;
    }

    public QManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.sharedPreferencesProvider;
        $jacocoInit[1] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider.get();
        Resources resources = (Resources) this.resourcesProvider.get();
        WindowManager windowManager = (WindowManager) this.windowManagerProvider.get();
        $jacocoInit[2] = true;
        QManager provideQManager = applicationModule.provideQManager(sharedPreferences, resources, windowManager);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideQManager, "Cannot return null from a non-@Nullable @Provides method");
        QManager qManager = provideQManager;
        $jacocoInit[4] = true;
        return qManager;
    }

    public static C13181b<QManager> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<WindowManager> windowManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideQManagerFactory applicationModule_ProvideQManagerFactory = new ApplicationModule_ProvideQManagerFactory(module2, sharedPreferencesProvider2, resourcesProvider2, windowManagerProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideQManagerFactory;
    }

    public static QManager proxyProvideQManager(ApplicationModule instance, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        boolean[] $jacocoInit = $jacocoInit();
        QManager provideQManager = instance.provideQManager(sharedPreferences, resources, windowManager);
        $jacocoInit[6] = true;
        return provideQManager;
    }
}
