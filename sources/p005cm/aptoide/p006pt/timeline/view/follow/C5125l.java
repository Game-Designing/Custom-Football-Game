package p005cm.aptoide.p006pt.timeline.view.follow;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.BooleanAction;

/* renamed from: cm.aptoide.pt.timeline.view.follow.l */
/* compiled from: lambda */
public final /* synthetic */ class C5125l implements BooleanAction {

    /* renamed from: a */
    private final /* synthetic */ TimeLineFollowingFragment f8858a;

    /* renamed from: b */
    private final /* synthetic */ List f8859b;

    public /* synthetic */ C5125l(TimeLineFollowingFragment timeLineFollowingFragment, List list) {
        this.f8858a = timeLineFollowingFragment;
        this.f8859b = list;
    }

    public final boolean call(BaseV7Response baseV7Response) {
        return this.f8858a.mo16786a(this.f8859b, (GetFollowers) baseV7Response);
    }
}
