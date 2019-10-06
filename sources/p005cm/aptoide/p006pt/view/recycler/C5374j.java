package p005cm.aptoide.p006pt.view.recycler;

import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.view.recycler.j */
/* compiled from: lambda */
public final /* synthetic */ class C5374j implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ EndlessRecyclerOnScrollListener f9189a;

    public /* synthetic */ C5374j(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener) {
        this.f9189a = endlessRecyclerOnScrollListener;
    }

    public final void call(Object obj) {
        this.f9189a.handleLoadMoreErrorAfterWebRequest((Throwable) obj);
    }
}
