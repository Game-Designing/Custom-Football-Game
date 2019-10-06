package p005cm.aptoide.p006pt.timeline.view.follow;

import java.util.LinkedList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.timeline.view.follow.j */
/* compiled from: lambda */
public final /* synthetic */ class C5123j implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ TimeLineFollowFragment f8853a;

    /* renamed from: b */
    private final /* synthetic */ int[] f8854b;

    /* renamed from: c */
    private final /* synthetic */ LinkedList f8855c;

    public /* synthetic */ C5123j(TimeLineFollowFragment timeLineFollowFragment, int[] iArr, LinkedList linkedList) {
        this.f8853a = timeLineFollowFragment;
        this.f8854b = iArr;
        this.f8855c = linkedList;
    }

    public final void call(Object obj) {
        this.f8853a.mo16775a(this.f8854b, this.f8855c, (GetFollowers) obj);
    }
}
