package p005cm.aptoide.p006pt.comments.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;

/* renamed from: cm.aptoide.pt.comments.view.L */
/* compiled from: lambda */
public final /* synthetic */ class C2666L implements ErrorRequestListener {

    /* renamed from: a */
    private final /* synthetic */ RateAndReviewCommentWidget f5835a;

    public /* synthetic */ C2666L(RateAndReviewCommentWidget rateAndReviewCommentWidget) {
        this.f5835a = rateAndReviewCommentWidget;
    }

    public final void onError(Throwable th) {
        this.f5835a.mo11622b(th);
    }
}
