package p005cm.aptoide.p006pt.comments.view;

import p005cm.aptoide.p006pt.comments.CommentAdder;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;

/* renamed from: cm.aptoide.pt.comments.view.J */
/* compiled from: lambda */
public final /* synthetic */ class C2664J implements SuccessRequestListener {

    /* renamed from: a */
    private final /* synthetic */ RateAndReviewCommentWidget f5832a;

    /* renamed from: b */
    private final /* synthetic */ CommentAdder f5833b;

    public /* synthetic */ C2664J(RateAndReviewCommentWidget rateAndReviewCommentWidget, CommentAdder commentAdder) {
        this.f5832a = rateAndReviewCommentWidget;
        this.f5833b = commentAdder;
    }

    public final void call(Object obj) {
        this.f5832a.mo11617a(this.f5833b, (ListComments) obj);
    }
}
