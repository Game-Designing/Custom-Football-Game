package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecureCoderDecoder;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSecurePerefencesFactory */
public final class ApplicationModule_ProvidesSecurePerefencesFactory implements C13181b<SecurePreferences> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final ApplicationModule module;
    private final Provider<SecureCoderDecoder> secureCoderDecoderProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-389446251519510694L, "cm/aptoide/pt/ApplicationModule_ProvidesSecurePerefencesFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSecurePerefencesFactory(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<SecureCoderDecoder> secureCoderDecoderProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.secureCoderDecoderProvider = secureCoderDecoderProvider2;
        $jacocoInit[0] = true;
    }

    public SecurePreferences get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.defaultSharedPreferencesProvider;
        $jacocoInit[1] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider.get();
        SecureCoderDecoder secureCoderDecoder = (SecureCoderDecoder) this.secureCoderDecoderProvider.get();
        $jacocoInit[2] = true;
        SecurePreferences providesSecurePerefences = applicationModule.providesSecurePerefences(sharedPreferences, secureCoderDecoder);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesSecurePerefences, "Cannot return null from a non-@Nullable @Provides method");
        SecurePreferences securePreferences = providesSecurePerefences;
        $jacocoInit[4] = true;
        return securePreferences;
    }

    public static C13181b<SecurePreferences> create(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<SecureCoderDecoder> secureCoderDecoderProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSecurePerefencesFactory applicationModule_ProvidesSecurePerefencesFactory = new ApplicationModule_ProvidesSecurePerefencesFactory(module2, defaultSharedPreferencesProvider2, secureCoderDecoderProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesSecurePerefencesFactory;
    }

    public static SecurePreferences proxyProvidesSecurePerefences(ApplicationModule instance, SharedPreferences defaultSharedPreferences, SecureCoderDecoder secureCoderDecoder) {
        boolean[] $jacocoInit = $jacocoInit();
        SecurePreferences providesSecurePerefences = instance.providesSecurePerefences(defaultSharedPreferences, secureCoderDecoder);
        $jacocoInit[6] = true;
        return providesSecurePerefences;
    }
}
