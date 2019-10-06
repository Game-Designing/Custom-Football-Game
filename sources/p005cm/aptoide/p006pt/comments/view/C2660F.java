package p005cm.aptoide.p006pt.comments.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;

/* renamed from: cm.aptoide.pt.comments.view.F */
/* compiled from: lambda */
public final /* synthetic */ class C2660F implements ErrorRequestListener {

    /* renamed from: a */
    private final /* synthetic */ RateAndReviewCommentWidget f5822a;

    public /* synthetic */ C2660F(RateAndReviewCommentWidget rateAndReviewCommentWidget) {
        this.f5822a = rateAndReviewCommentWidget;
    }

    public final void onError(Throwable th) {
        this.f5822a.mo11624c(th);
    }
}
