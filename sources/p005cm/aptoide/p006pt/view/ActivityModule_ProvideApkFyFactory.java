package p005cm.aptoide.p006pt.view;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.util.ApkFy;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideApkFyFactory */
public final class ActivityModule_ProvideApkFyFactory implements C13181b<ApkFy> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;
    private final Provider<SharedPreferences> securePreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1867071187107032708L, "cm/aptoide/pt/view/ActivityModule_ProvideApkFyFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideApkFyFactory(ActivityModule module2, Provider<SharedPreferences> securePreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.securePreferencesProvider = securePreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public ApkFy get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<SharedPreferences> provider = this.securePreferencesProvider;
        $jacocoInit[1] = true;
        ApkFy provideApkFy = activityModule.provideApkFy((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideApkFy, "Cannot return null from a non-@Nullable @Provides method");
        ApkFy apkFy = provideApkFy;
        $jacocoInit[3] = true;
        return apkFy;
    }

    public static C13181b<ApkFy> create(ActivityModule module2, Provider<SharedPreferences> securePreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideApkFyFactory activityModule_ProvideApkFyFactory = new ActivityModule_ProvideApkFyFactory(module2, securePreferencesProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvideApkFyFactory;
    }

    public static ApkFy proxyProvideApkFy(ActivityModule instance, SharedPreferences securePreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        ApkFy provideApkFy = instance.provideApkFy(securePreferences);
        $jacocoInit[5] = true;
        return provideApkFy;
    }
}
