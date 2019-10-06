package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.ReviewsRepository;
import p005cm.aptoide.p006pt.app.ReviewsService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesReviewsRepositoryFactory */
public final class ApplicationModule_ProvidesReviewsRepositoryFactory implements C13181b<ReviewsRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<ReviewsService> reviewsServiceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4565328427084066427L, "cm/aptoide/pt/ApplicationModule_ProvidesReviewsRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesReviewsRepositoryFactory(ApplicationModule module2, Provider<ReviewsService> reviewsServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.reviewsServiceProvider = reviewsServiceProvider2;
        $jacocoInit[0] = true;
    }

    public ReviewsRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ReviewsService> provider = this.reviewsServiceProvider;
        $jacocoInit[1] = true;
        ReviewsRepository providesReviewsRepository = applicationModule.providesReviewsRepository((ReviewsService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesReviewsRepository, "Cannot return null from a non-@Nullable @Provides method");
        ReviewsRepository reviewsRepository = providesReviewsRepository;
        $jacocoInit[3] = true;
        return reviewsRepository;
    }

    public static C13181b<ReviewsRepository> create(ApplicationModule module2, Provider<ReviewsService> reviewsServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesReviewsRepositoryFactory applicationModule_ProvidesReviewsRepositoryFactory = new ApplicationModule_ProvidesReviewsRepositoryFactory(module2, reviewsServiceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesReviewsRepositoryFactory;
    }

    public static ReviewsRepository proxyProvidesReviewsRepository(ApplicationModule instance, ReviewsService reviewsService) {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewsRepository providesReviewsRepository = instance.providesReviewsRepository(reviewsService);
        $jacocoInit[5] = true;
        return providesReviewsRepository;
    }
}
