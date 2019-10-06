package p005cm.aptoide.p006pt.timeline.view.follow;

import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.OnEndlessFinish;

/* renamed from: cm.aptoide.pt.timeline.view.follow.i */
/* compiled from: lambda */
public final /* synthetic */ class C5122i implements OnEndlessFinish {

    /* renamed from: a */
    private final /* synthetic */ TimeLineFollowFragment f8851a;

    /* renamed from: b */
    private final /* synthetic */ int[] f8852b;

    public /* synthetic */ C5122i(TimeLineFollowFragment timeLineFollowFragment, int[] iArr) {
        this.f8851a = timeLineFollowFragment;
        this.f8852b = iArr;
    }

    public final void onEndlessFinish(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener) {
        this.f8851a.mo16774a(this.f8852b, endlessRecyclerOnScrollListener);
    }
}
