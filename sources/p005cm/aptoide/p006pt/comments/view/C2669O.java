package p005cm.aptoide.p006pt.comments.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;

/* renamed from: cm.aptoide.pt.comments.view.O */
/* compiled from: lambda */
public final /* synthetic */ class C2669O implements SuccessRequestListener {

    /* renamed from: a */
    private final /* synthetic */ RateAndReviewCommentWidget f5839a;

    /* renamed from: b */
    private final /* synthetic */ long f5840b;

    /* renamed from: c */
    private final /* synthetic */ boolean f5841c;

    public /* synthetic */ C2669O(RateAndReviewCommentWidget rateAndReviewCommentWidget, long j, boolean z) {
        this.f5839a = rateAndReviewCommentWidget;
        this.f5840b = j;
        this.f5841c = z;
    }

    public final void call(Object obj) {
        this.f5839a.mo11614a(this.f5840b, this.f5841c, (BaseV7Response) obj);
    }
}
