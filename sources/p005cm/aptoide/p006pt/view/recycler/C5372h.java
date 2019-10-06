package p005cm.aptoide.p006pt.view.recycler;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessResponse;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.view.recycler.h */
/* compiled from: lambda */
public final /* synthetic */ class C5372h implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ EndlessRecyclerOnScrollListener f9186a;

    /* renamed from: b */
    private final /* synthetic */ boolean f9187b;

    public /* synthetic */ C5372h(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener, boolean z) {
        this.f9186a = endlessRecyclerOnScrollListener;
        this.f9187b = z;
    }

    public final void call(Object obj) {
        this.f9186a.mo17279a(this.f9187b, (BaseV7EndlessResponse) obj);
    }
}
