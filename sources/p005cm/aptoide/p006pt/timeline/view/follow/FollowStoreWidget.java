package p005cm.aptoide.p006pt.timeline.view.follow;

import android.support.p000v4.app.C0486t;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.store.view.AddStoreDialog;
import p005cm.aptoide.p006pt.timeline.view.displayable.FollowStoreDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.timeline.view.follow.FollowStoreWidget */
public class FollowStoreWidget extends Widget<FollowStoreDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private View storeLayout;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7498898654426934070L, "cm/aptoide/pt/timeline/view/follow/FollowStoreWidget", 8);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((FollowStoreDisplayable) displayable, i);
        $jacocoInit[6] = true;
    }

    public FollowStoreWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeLayout = itemView.findViewById(C1375R.C1376id.store_tab_follow_store_layout);
        $jacocoInit[1] = true;
    }

    public void bindView(FollowStoreDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0486t fragmentManager = getContext().getSupportFragmentManager();
        $jacocoInit[2] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.storeLayout);
        C5114a aVar = new C5114a(fragmentManager);
        $jacocoInit[3] = true;
        C0137ja c = a.mo3646c((C0129b<? super T>) aVar);
        $jacocoInit[4] = true;
        cVar.mo3713a(c);
        $jacocoInit[5] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9422a(C0486t fragmentManager, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        new AddStoreDialog().show(fragmentManager, "addStoreDialog");
        $jacocoInit[7] = true;
    }
}
