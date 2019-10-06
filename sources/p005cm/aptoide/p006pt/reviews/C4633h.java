package p005cm.aptoide.p006pt.reviews;

import p005cm.aptoide.p006pt.reviews.LanguageFilterHelper.LanguageFilter;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.OnEndlessFinish;

/* renamed from: cm.aptoide.pt.reviews.h */
/* compiled from: lambda */
public final /* synthetic */ class C4633h implements OnEndlessFinish {

    /* renamed from: a */
    private final /* synthetic */ RateAndReviewsFragment f8273a;

    /* renamed from: b */
    private final /* synthetic */ LanguageFilter f8274b;

    public /* synthetic */ C4633h(RateAndReviewsFragment rateAndReviewsFragment, LanguageFilter languageFilter) {
        this.f8273a = rateAndReviewsFragment;
        this.f8274b = languageFilter;
    }

    public final void onEndlessFinish(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener) {
        this.f8273a.mo15973a(this.f8274b, endlessRecyclerOnScrollListener);
    }
}
