package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.ReviewsManager;
import p005cm.aptoide.p006pt.app.ReviewsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesReviewsManagerFactory */
public final class ApplicationModule_ProvidesReviewsManagerFactory implements C13181b<ReviewsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<ReviewsRepository> reviewsRepositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8658843144402553508L, "cm/aptoide/pt/ApplicationModule_ProvidesReviewsManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesReviewsManagerFactory(ApplicationModule module2, Provider<ReviewsRepository> reviewsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.reviewsRepositoryProvider = reviewsRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public ReviewsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ReviewsRepository> provider = this.reviewsRepositoryProvider;
        $jacocoInit[1] = true;
        ReviewsManager providesReviewsManager = applicationModule.providesReviewsManager((ReviewsRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesReviewsManager, "Cannot return null from a non-@Nullable @Provides method");
        ReviewsManager reviewsManager = providesReviewsManager;
        $jacocoInit[3] = true;
        return reviewsManager;
    }

    public static C13181b<ReviewsManager> create(ApplicationModule module2, Provider<ReviewsRepository> reviewsRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesReviewsManagerFactory applicationModule_ProvidesReviewsManagerFactory = new ApplicationModule_ProvidesReviewsManagerFactory(module2, reviewsRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesReviewsManagerFactory;
    }

    public static ReviewsManager proxyProvidesReviewsManager(ApplicationModule instance, ReviewsRepository reviewsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewsManager providesReviewsManager = instance.providesReviewsManager(reviewsRepository);
        $jacocoInit[5] = true;
        return providesReviewsManager;
    }
}
