package p005cm.aptoide.p006pt.view;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.editorialList.EditorialListService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialServiceFactory */
public final class FragmentModule_ProvidesEditorialServiceFactory implements C13181b<EditorialListService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final FragmentModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1856052754601460521L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialServiceFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialServiceFactory(FragmentModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialListService get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<BodyInterceptor<BaseBody>> provider = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[1] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        Provider<OkHttpClient> provider2 = this.okHttpClientProvider;
        $jacocoInit[2] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider2.get();
        Provider<TokenInvalidator> provider3 = this.tokenInvalidatorProvider;
        $jacocoInit[3] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider3.get();
        Provider<SharedPreferences> provider4 = this.sharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        $jacocoInit[5] = true;
        EditorialListService providesEditorialService = fragmentModule.providesEditorialService(bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesEditorialService, "Cannot return null from a non-@Nullable @Provides method");
        EditorialListService editorialListService = providesEditorialService;
        $jacocoInit[7] = true;
        return editorialListService;
    }

    public static C13181b<EditorialListService> create(FragmentModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialServiceFactory fragmentModule_ProvidesEditorialServiceFactory = new FragmentModule_ProvidesEditorialServiceFactory(module2, bodyInterceptorPoolV7Provider2, okHttpClientProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2);
        $jacocoInit[8] = true;
        return fragmentModule_ProvidesEditorialServiceFactory;
    }

    public static EditorialListService proxyProvidesEditorialService(FragmentModule instance, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListService providesEditorialService = instance.providesEditorialService(bodyInterceptorPoolV7, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[9] = true;
        return providesEditorialService;
    }
}
