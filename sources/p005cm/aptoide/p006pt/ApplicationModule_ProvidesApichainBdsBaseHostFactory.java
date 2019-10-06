package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesApichainBdsBaseHostFactory */
public final class ApplicationModule_ProvidesApichainBdsBaseHostFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4262238394290105311L, "cm/aptoide/pt/ApplicationModule_ProvidesApichainBdsBaseHostFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesApichainBdsBaseHostFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.sharedPreferencesProvider;
        $jacocoInit[1] = true;
        String providesApichainBdsBaseHost = applicationModule.providesApichainBdsBaseHost((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesApichainBdsBaseHost, "Cannot return null from a non-@Nullable @Provides method");
        String str = providesApichainBdsBaseHost;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesApichainBdsBaseHostFactory applicationModule_ProvidesApichainBdsBaseHostFactory = new ApplicationModule_ProvidesApichainBdsBaseHostFactory(module2, sharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesApichainBdsBaseHostFactory;
    }

    public static String proxyProvidesApichainBdsBaseHost(ApplicationModule instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        String providesApichainBdsBaseHost = instance.providesApichainBdsBaseHost(sharedPreferences);
        $jacocoInit[5] = true;
        return providesApichainBdsBaseHost;
    }
}
