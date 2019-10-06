package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountService;
import p005cm.aptoide.accountmanager.AdultContent;
import p005cm.aptoide.p006pt.preferences.LocalPersistenceAdultContent;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvideAdultContentFactory */
public final class FlavourApplicationModule_ProvideAdultContentFactory implements C13181b<AdultContent> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountService> accountServiceProvider;
    private final Provider<LocalPersistenceAdultContent> localAdultContentProvider;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-746200305916735468L, "cm/aptoide/pt/FlavourApplicationModule_ProvideAdultContentFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvideAdultContentFactory(FlavourApplicationModule module2, Provider<LocalPersistenceAdultContent> localAdultContentProvider2, Provider<AccountService> accountServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.localAdultContentProvider = localAdultContentProvider2;
        this.accountServiceProvider = accountServiceProvider2;
        $jacocoInit[0] = true;
    }

    public AdultContent get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<LocalPersistenceAdultContent> provider = this.localAdultContentProvider;
        $jacocoInit[1] = true;
        AdultContent provideAdultContent = flavourApplicationModule.provideAdultContent((LocalPersistenceAdultContent) provider.get(), (AccountService) this.accountServiceProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAdultContent, "Cannot return null from a non-@Nullable @Provides method");
        AdultContent adultContent = provideAdultContent;
        $jacocoInit[3] = true;
        return adultContent;
    }

    public static C13181b<AdultContent> create(FlavourApplicationModule module2, Provider<LocalPersistenceAdultContent> localAdultContentProvider2, Provider<AccountService> accountServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvideAdultContentFactory flavourApplicationModule_ProvideAdultContentFactory = new FlavourApplicationModule_ProvideAdultContentFactory(module2, localAdultContentProvider2, accountServiceProvider2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvideAdultContentFactory;
    }

    public static AdultContent proxyProvideAdultContent(FlavourApplicationModule instance, LocalPersistenceAdultContent localAdultContent, AccountService accountService) {
        boolean[] $jacocoInit = $jacocoInit();
        AdultContent provideAdultContent = instance.provideAdultContent(localAdultContent, accountService);
        $jacocoInit[5] = true;
        return provideAdultContent;
    }
}
