package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.preferences.secure.SecureCoderDecoder;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideSecureCoderDecoderFactory */
public final class ApplicationModule_ProvideSecureCoderDecoderFactory implements C13181b<SecureCoderDecoder> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4008285511438580958L, "cm/aptoide/pt/ApplicationModule_ProvideSecureCoderDecoderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideSecureCoderDecoderFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public SecureCoderDecoder get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.sharedPreferencesProvider;
        $jacocoInit[1] = true;
        SecureCoderDecoder provideSecureCoderDecoder = applicationModule.provideSecureCoderDecoder((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideSecureCoderDecoder, "Cannot return null from a non-@Nullable @Provides method");
        SecureCoderDecoder secureCoderDecoder = provideSecureCoderDecoder;
        $jacocoInit[3] = true;
        return secureCoderDecoder;
    }

    public static C13181b<SecureCoderDecoder> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideSecureCoderDecoderFactory applicationModule_ProvideSecureCoderDecoderFactory = new ApplicationModule_ProvideSecureCoderDecoderFactory(module2, sharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideSecureCoderDecoderFactory;
    }

    public static SecureCoderDecoder proxyProvideSecureCoderDecoder(ApplicationModule instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        SecureCoderDecoder provideSecureCoderDecoder = instance.provideSecureCoderDecoder(sharedPreferences);
        $jacocoInit[5] = true;
        return provideSecureCoderDecoder;
    }
}
