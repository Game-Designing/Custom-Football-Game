package p005cm.aptoide.p006pt.timeline.view.follow;

import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.timeline.view.follow.h */
/* compiled from: lambda */
public final /* synthetic */ class C5121h implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ FollowUserWidget f8848a;

    /* renamed from: b */
    private final /* synthetic */ String f8849b;

    /* renamed from: c */
    private final /* synthetic */ StoreUtilsProxy f8850c;

    public /* synthetic */ C5121h(FollowUserWidget followUserWidget, String str, StoreUtilsProxy storeUtilsProxy) {
        this.f8848a = followUserWidget;
        this.f8849b = str;
        this.f8850c = storeUtilsProxy;
    }

    public final void call(Object obj) {
        this.f8848a.mo16772a(this.f8849b, this.f8850c, (Boolean) obj);
    }
}
