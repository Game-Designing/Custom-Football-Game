package p005cm.aptoide.p006pt.comments;

import android.content.SharedPreferences;
import android.support.p001v7.widget.RecyclerView.C0981i;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.comments.view.CommentsAdapter;
import p005cm.aptoide.p006pt.comments.view.ConcreteItemCommentAdder;
import p005cm.aptoide.p006pt.comments.view.RateAndReviewCommentDisplayable;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListReviews;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.Comments;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListCommentsRequest;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.comments.ListFullReviewsSuccessRequestListener */
public class ListFullReviewsSuccessRequestListener implements SuccessRequestListener<ListReviews> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyBodyInterceptor;
    private final Factory converterFactory;
    private final RateAndReviewsFragment fragment;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5637552336032981683L, "cm/aptoide/pt/comments/ListFullReviewsSuccessRequestListener", 63);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((ListReviews) obj);
        $jacocoInit[50] = true;
    }

    public ListFullReviewsSuccessRequestListener(RateAndReviewsFragment fragment2, StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<BaseBody> baseBodyInterceptor, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragment = fragment2;
        this.httpClient = httpClient2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.bodyBodyInterceptor = baseBodyInterceptor;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public void call(ListReviews listFullReviews) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = listFullReviews.getDataList();
        $jacocoInit[1] = true;
        List<Review> reviews = dataList.getList();
        $jacocoInit[2] = true;
        List<Displayable> displayables = new LinkedList<>();
        $jacocoInit[3] = true;
        C0120S a = C0120S.m629a((Iterable<? extends T>) reviews);
        C2652d dVar = new C2652d(this);
        $jacocoInit[4] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dVar);
        $jacocoInit[5] = true;
        C0120S m = f.mo3675m();
        $jacocoInit[6] = true;
        C0120S a2 = m.mo3616a(C14522a.m46170a());
        RateAndReviewsFragment rateAndReviewsFragment = this.fragment;
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[7] = true;
        C0120S a3 = a2.mo3614a((C0121c<? super T, ? extends R>) rateAndReviewsFragment.bindUntilEvent(bVar));
        C2651c cVar = new C2651c(this, reviews, displayables);
        C2650b bVar2 = C2650b.f5812a;
        $jacocoInit[8] = true;
        a3.mo3626a((C0129b<? super T>) cVar, (C0129b<Throwable>) bVar2);
        $jacocoInit[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11564a(Review review) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[54] = true;
        Comments comments = review.getComments();
        $jacocoInit[55] = true;
        String view = comments.getView();
        long id = review.getId();
        RateAndReviewsFragment rateAndReviewsFragment = this.fragment;
        $jacocoInit[56] = true;
        StoreCredentials storeCredentials = StoreUtils.getStoreCredentials(rateAndReviewsFragment.getStoreName(), this.storeCredentialsProvider);
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyBodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[57] = true;
        ListCommentsRequest of = ListCommentsRequest.m7472of(view, id, 3, storeCredentials, true, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
        $jacocoInit[58] = true;
        C0120S observe = of.observe();
        $jacocoInit[59] = true;
        C0120S b = observe.mo3634b(Schedulers.m776io());
        C2649a aVar = new C2649a(review);
        $jacocoInit[60] = true;
        C0120S j = b.mo3669j(aVar);
        $jacocoInit[61] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Review m7314a(Review review, ListComments listComments) {
        boolean[] $jacocoInit = $jacocoInit();
        review.setCommentList(listComments);
        $jacocoInit[62] = true;
        return review;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11565a(List reviews, List displayables, List reviewList) {
        boolean[] $jacocoInit = $jacocoInit();
        addRateAndReviewDisplayables(reviews, displayables);
        $jacocoInit[53] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7315a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[51] = true;
        instance.log(err);
        $jacocoInit[52] = true;
    }

    private void addRateAndReviewDisplayables(List<Review> reviews, List<Displayable> displayables) {
        boolean[] $jacocoInit = $jacocoInit();
        int index = -1;
        int count = 0;
        $jacocoInit[10] = true;
        $jacocoInit[11] = true;
        for (Review review : reviews) {
            RateAndReviewsFragment rateAndReviewsFragment = this.fragment;
            $jacocoInit[12] = true;
            ReviewWithAppName reviewWithAppName = new ReviewWithAppName(rateAndReviewsFragment.getAppName(), review);
            ConcreteItemCommentAdder concreteItemCommentAdder = new ConcreteItemCommentAdder(count, this.fragment, review);
            $jacocoInit[13] = true;
            ListComments commentList = review.getCommentList();
            $jacocoInit[14] = true;
            RateAndReviewCommentDisplayable rateAndReviewCommentDisplayable = new RateAndReviewCommentDisplayable(reviewWithAppName, concreteItemCommentAdder, commentList.getTotal());
            $jacocoInit[15] = true;
            displayables.add(rateAndReviewCommentDisplayable);
            $jacocoInit[16] = true;
            if (review.getId() != this.fragment.getReviewId()) {
                $jacocoInit[17] = true;
            } else {
                index = count;
                $jacocoInit[18] = true;
            }
            if (review.getCommentList() == null) {
                $jacocoInit[19] = true;
            } else {
                $jacocoInit[20] = true;
                ListComments commentList2 = review.getCommentList();
                $jacocoInit[21] = true;
                if (commentList2.getDataList() == null) {
                    $jacocoInit[22] = true;
                } else {
                    $jacocoInit[23] = true;
                    ListComments commentList3 = review.getCommentList();
                    $jacocoInit[24] = true;
                    DataList dataList = commentList3.getDataList();
                    $jacocoInit[25] = true;
                    if (dataList.getLimit() == null) {
                        $jacocoInit[26] = true;
                    } else {
                        $jacocoInit[27] = true;
                        RateAndReviewsFragment rateAndReviewsFragment2 = this.fragment;
                        ListComments commentList4 = review.getCommentList();
                        $jacocoInit[28] = true;
                        DataList dataList2 = commentList4.getDataList();
                        $jacocoInit[29] = true;
                        List list = dataList2.getList();
                        $jacocoInit[30] = true;
                        rateAndReviewsFragment2.createDisplayableComments(list, displayables);
                        $jacocoInit[31] = true;
                        ListComments commentList5 = review.getCommentList();
                        $jacocoInit[32] = true;
                        DataList dataList3 = commentList5.getDataList();
                        $jacocoInit[33] = true;
                        List list2 = dataList3.getList();
                        $jacocoInit[34] = true;
                        if (list2.size() <= 2) {
                            $jacocoInit[35] = true;
                        } else {
                            $jacocoInit[36] = true;
                            displayables.add(this.fragment.createReadMoreDisplayable(count, review));
                            $jacocoInit[37] = true;
                        }
                    }
                }
            }
            count++;
            $jacocoInit[38] = true;
        }
        CommentsAdapter commentsAdapter = (CommentsAdapter) this.fragment.getAdapter();
        $jacocoInit[39] = true;
        if (commentsAdapter.getItemCount() != 0) {
            $jacocoInit[40] = true;
        } else {
            index = 0;
            $jacocoInit[41] = true;
        }
        this.fragment.checkAndRemoveProgressBarDisplayable();
        $jacocoInit[42] = true;
        this.fragment.addDisplayables(displayables);
        if (index < 0) {
            $jacocoInit[43] = true;
        } else {
            $jacocoInit[44] = true;
            C0981i layoutManager = this.fragment.getLayoutManager();
            RateAndReviewsFragment rateAndReviewsFragment3 = this.fragment;
            $jacocoInit[45] = true;
            CommentsAdapter commentsAdapter2 = (CommentsAdapter) rateAndReviewsFragment3.getAdapter();
            $jacocoInit[46] = true;
            int itemPosition = commentsAdapter2.getItemPosition(index);
            $jacocoInit[47] = true;
            layoutManager.scrollToPosition(itemPosition);
            $jacocoInit[48] = true;
        }
        $jacocoInit[49] = true;
    }
}
