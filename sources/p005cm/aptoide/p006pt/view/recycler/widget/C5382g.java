package p005cm.aptoide.p006pt.view.recycler.widget;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.FullReview;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.reviews.RowReviewDisplayable;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.view.recycler.widget.g */
/* compiled from: lambda */
public final /* synthetic */ class C5382g implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ RowReviewDisplayable f9200a;

    /* renamed from: b */
    private final /* synthetic */ FragmentNavigator f9201b;

    /* renamed from: c */
    private final /* synthetic */ App f9202c;

    /* renamed from: d */
    private final /* synthetic */ FullReview f9203d;

    public /* synthetic */ C5382g(RowReviewDisplayable rowReviewDisplayable, FragmentNavigator fragmentNavigator, App app, FullReview fullReview) {
        this.f9200a = rowReviewDisplayable;
        this.f9201b = fragmentNavigator;
        this.f9202c = app;
        this.f9203d = fullReview;
    }

    public final void call(Object obj) {
        RowReviewWidget.m9642a(this.f9200a, this.f9201b, this.f9202c, this.f9203d, (Void) obj);
    }
}
