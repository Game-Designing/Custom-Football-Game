package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory */
public final class C1361xe98d65dc implements C13181b<BodyInterceptor<BaseBody>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AdultContent> adultContentProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6409523113500804401L, "cm/aptoide/pt/ApplicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory", 8);
        $jacocoData = probes;
        return probes;
    }

    public C1361xe98d65dc(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2, Provider<AdultContent> adultContentProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bodyInterceptorProvider = bodyInterceptorProvider2;
        this.adultContentProvider = adultContentProvider2;
        $jacocoInit[0] = true;
    }

    public BodyInterceptor<BaseBody> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<BodyInterceptor<BaseBody>> provider = this.bodyInterceptorProvider;
        $jacocoInit[1] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        AdultContent adultContent = (AdultContent) this.adultContentProvider.get();
        $jacocoInit[2] = true;
        BodyInterceptor<BaseBody> provideAccountSettingsBodyInterceptorPoolV7 = applicationModule.provideAccountSettingsBodyInterceptorPoolV7(bodyInterceptor, adultContent);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideAccountSettingsBodyInterceptorPoolV7, "Cannot return null from a non-@Nullable @Provides method");
        BodyInterceptor<BaseBody> bodyInterceptor2 = provideAccountSettingsBodyInterceptorPoolV7;
        $jacocoInit[4] = true;
        return bodyInterceptor2;
    }

    public static C13181b<BodyInterceptor<BaseBody>> create(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorProvider2, Provider<AdultContent> adultContentProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1361xe98d65dc applicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory = new C1361xe98d65dc(module2, bodyInterceptorProvider2, adultContentProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideAccountSettingsBodyInterceptorPoolV7Factory;
    }

    public static BodyInterceptor<BaseBody> proxyProvideAccountSettingsBodyInterceptorPoolV7(ApplicationModule instance, BodyInterceptor<BaseBody> bodyInterceptor, AdultContent adultContent) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> provideAccountSettingsBodyInterceptorPoolV7 = instance.provideAccountSettingsBodyInterceptorPoolV7(bodyInterceptor, adultContent);
        $jacocoInit[6] = true;
        return provideAccountSettingsBodyInterceptorPoolV7;
    }
}
