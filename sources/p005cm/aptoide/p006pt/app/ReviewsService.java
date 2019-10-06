package p005cm.aptoide.p006pt.app;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.ReviewRequestResult.Error;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListReviews;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.Comments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.User;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListReviewsRequest;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.app.ReviewsService */
public class ReviewsService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private boolean loading;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2351108775931956727L, "cm/aptoide/pt/app/ReviewsService", 43);
        $jacocoData = probes;
        return probes;
    }

    public ReviewsService(StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.bodyInterceptor = bodyInterceptor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public Single<ReviewRequestResult> loadReviews(String storeName, String packageName, int maxReviews, String languagesFilterSort) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.loading) {
            $jacocoInit[1] = true;
            Single<ReviewRequestResult> a = Single.m734a(new ReviewRequestResult(true));
            $jacocoInit[2] = true;
            return a;
        }
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[3] = true;
        StoreCredentials storeCredentials = storeCredentialsProvider2.get(storeName);
        $jacocoInit[4] = true;
        ListReviewsRequest ofTopReviews = ListReviewsRequest.ofTopReviews(storeName, packageName, maxReviews, storeCredentials, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, languagesFilterSort);
        $jacocoInit[5] = true;
        C0120S observe = ofTopReviews.observe();
        C1725ca caVar = new C1725ca(this);
        $jacocoInit[6] = true;
        C0120S b = observe.mo3635b((C0128a) caVar);
        C1729ea eaVar = new C1729ea(this);
        $jacocoInit[7] = true;
        C0120S d = b.mo3652d((C0128a) eaVar);
        C1723ba baVar = new C1723ba(this);
        $jacocoInit[8] = true;
        C0120S c = d.mo3644c((C0128a) baVar);
        C1731fa faVar = new C1731fa(this);
        $jacocoInit[9] = true;
        C0120S f = c.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) faVar);
        $jacocoInit[10] = true;
        Single n = f.mo3678n();
        C1727da daVar = new C1727da(this);
        $jacocoInit[11] = true;
        Single<ReviewRequestResult> f2 = n.mo3700f(daVar);
        $jacocoInit[12] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10358a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = true;
        $jacocoInit[42] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo10359b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = false;
        $jacocoInit[41] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo10360c() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = false;
        $jacocoInit[40] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo10357a(ListReviews listReviews) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S mapListReviews = mapListReviews(listReviews);
        $jacocoInit[39] = true;
        return mapListReviews;
    }

    /* renamed from: a */
    public /* synthetic */ ReviewRequestResult mo10356a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewRequestResult createReviewRequestResultError = createReviewRequestResultError(throwable);
        $jacocoInit[38] = true;
        return createReviewRequestResultError;
    }

    private ReviewRequestResult createReviewRequestResultError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[13] = true;
            ReviewRequestResult reviewRequestResult = new ReviewRequestResult(Error.NETWORK);
            $jacocoInit[14] = true;
            return reviewRequestResult;
        }
        ReviewRequestResult reviewRequestResult2 = new ReviewRequestResult(Error.GENERIC);
        $jacocoInit[15] = true;
        return reviewRequestResult2;
    }

    private C0120S<ReviewRequestResult> mapListReviews(ListReviews listReviews) {
        boolean[] $jacocoInit = $jacocoInit();
        if (listReviews.isOk()) {
            $jacocoInit[16] = true;
            DataList dataList = listReviews.getDataList();
            $jacocoInit[17] = true;
            List list = dataList.getList();
            $jacocoInit[18] = true;
            C0120S<ReviewRequestResult> c = C0120S.m652c(new ReviewRequestResult(map(list)));
            $jacocoInit[19] = true;
            return c;
        }
        C0120S<ReviewRequestResult> a = C0120S.m631a((Throwable) new IllegalStateException("Could not obtain request from server."));
        $jacocoInit[20] = true;
        return a;
    }

    private List<AppReview> map(List<Review> reviews) {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppReview> appReviews = new ArrayList<>();
        if (reviews == null) {
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            $jacocoInit[23] = true;
            for (Review review : reviews) {
                $jacocoInit[25] = true;
                Stats stats = review.getStats();
                $jacocoInit[26] = true;
                User user = review.getUser();
                $jacocoInit[27] = true;
                long comments = stats.getComments();
                long likes = stats.getLikes();
                long points = stats.getPoints();
                $jacocoInit[28] = true;
                ReviewStats reviewStats = new ReviewStats(comments, likes, points, stats.getRating());
                $jacocoInit[29] = true;
                ReviewStats reviewStats2 = reviewStats;
                Comments comments2 = review.getComments();
                $jacocoInit[30] = true;
                String view = comments2.getView();
                Comments comments3 = review.getComments();
                $jacocoInit[31] = true;
                ReviewComment reviewComment = new ReviewComment(view, comments3.getTotal());
                $jacocoInit[32] = true;
                ReviewUser reviewUser = new ReviewUser(user.getId(), user.getAvatar(), user.getName());
                $jacocoInit[33] = true;
                long id = review.getId();
                String title = review.getTitle();
                String body = review.getBody();
                Date added = review.getAdded();
                $jacocoInit[34] = true;
                AppReview appReview = r7;
                AppReview appReview2 = new AppReview(id, title, body, added, review.getModified(), reviewStats2, reviewComment, reviewUser);
                $jacocoInit[35] = true;
                appReviews.add(appReview);
                $jacocoInit[36] = true;
            }
            $jacocoInit[24] = true;
        }
        $jacocoInit[37] = true;
        return appReviews;
    }
}
