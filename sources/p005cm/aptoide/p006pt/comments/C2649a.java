package p005cm.aptoide.p006pt.comments;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.comments.a */
/* compiled from: lambda */
public final /* synthetic */ class C2649a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Review f5811a;

    public /* synthetic */ C2649a(Review review) {
        this.f5811a = review;
    }

    public final Object call(Object obj) {
        Review review = this.f5811a;
        ListFullReviewsSuccessRequestListener.m7314a(review, (ListComments) obj);
        return review;
    }
}
