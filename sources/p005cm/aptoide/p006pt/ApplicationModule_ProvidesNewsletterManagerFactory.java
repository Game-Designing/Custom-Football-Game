package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.user.NewsletterManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesNewsletterManagerFactory */
public final class ApplicationModule_ProvidesNewsletterManagerFactory implements C13181b<NewsletterManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5674892651553542204L, "cm/aptoide/pt/ApplicationModule_ProvidesNewsletterManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesNewsletterManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public NewsletterManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        NewsletterManager providesNewsletterManager = applicationModule.providesNewsletterManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesNewsletterManager, "Cannot return null from a non-@Nullable @Provides method");
        NewsletterManager newsletterManager = providesNewsletterManager;
        $jacocoInit[3] = true;
        return newsletterManager;
    }

    public static C13181b<NewsletterManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesNewsletterManagerFactory applicationModule_ProvidesNewsletterManagerFactory = new ApplicationModule_ProvidesNewsletterManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesNewsletterManagerFactory;
    }

    public static NewsletterManager proxyProvidesNewsletterManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        NewsletterManager providesNewsletterManager = instance.providesNewsletterManager();
        $jacocoInit[5] = true;
        return providesNewsletterManager;
    }
}
