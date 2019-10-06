package p005cm.aptoide.p006pt.timeline.view.follow;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.BooleanAction;

/* renamed from: cm.aptoide.pt.timeline.view.follow.k */
/* compiled from: lambda */
public final /* synthetic */ class C5124k implements BooleanAction {

    /* renamed from: a */
    private final /* synthetic */ TimeLineFollowersFragment f8856a;

    /* renamed from: b */
    private final /* synthetic */ List f8857b;

    public /* synthetic */ C5124k(TimeLineFollowersFragment timeLineFollowersFragment, List list) {
        this.f8856a = timeLineFollowersFragment;
        this.f8857b = list;
    }

    public final boolean call(BaseV7Response baseV7Response) {
        return this.f8856a.mo16783a(this.f8857b, (GetFollowers) baseV7Response);
    }
}
