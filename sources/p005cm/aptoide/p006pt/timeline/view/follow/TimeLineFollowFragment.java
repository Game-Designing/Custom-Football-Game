package p005cm.aptoide.p006pt.timeline.view.follow;

import android.os.Bundle;
import android.support.p001v7.widget.RecyclerView.C0988n;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers.TimelineUser;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.BooleanAction;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.MessageWhiteBgDisplayable;

/* renamed from: cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment */
public abstract class TimeLineFollowFragment extends GridRecyclerSwipeWithToolbarFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private StoreContext storeContext;

    /* renamed from: cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment$BundleKeys */
    public class BundleKeys {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String CARD_UID = "CARDUID";
        public static final String NUMBER_LIKES = "NUMBER_LIKES";
        public static final String STORE_CONTEXT = "STORE_CONTEXT";
        public static final String STORE_ID = "STORE_ID";
        public static final String USER_ID = "user_id";
        final /* synthetic */ TimeLineFollowFragment this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(7589398592774829601L, "cm/aptoide/pt/timeline/view/follow/TimeLineFollowFragment$BundleKeys", 1);
            $jacocoData = probes;
            return probes;
        }

        public BundleKeys(TimeLineFollowFragment this$02) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = this$02;
            $jacocoInit[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3124974813147532428L, "cm/aptoide/pt/timeline/view/follow/TimeLineFollowFragment", 42);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract C0044V7 buildRequest();

    /* access modifiers changed from: protected */
    public abstract Displayable createUserDisplayable(TimelineUser timelineUser);

    /* access modifiers changed from: protected */
    public abstract BooleanAction<GetFollowers> getFirstResponseAction(List<Displayable> list);

    /* access modifiers changed from: protected */
    public abstract String getFooterMessage(int i);

    /* access modifiers changed from: protected */
    public abstract String getHeaderMessage();

    public TimeLineFollowFragment() {
        $jacocoInit()[0] = true;
    }

    protected static Bundle buildBundle(StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[1] = true;
        args.putSerializable(BundleKeys.STORE_CONTEXT, storeContext2);
        $jacocoInit[2] = true;
        return args;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[3] = true;
        setHasOptionsMenu(true);
        $jacocoInit[4] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[5] = true;
        return true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[6] = true;
        this.storeContext = (StoreContext) args.getSerializable(BundleKeys.STORE_CONTEXT);
        $jacocoInit[7] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[8] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[9] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[10] = true;
            getActivity().onBackPressed();
            $jacocoInit[11] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[12] = true;
        return onOptionsItemSelected;
    }

    public ScreenTagHistory getHistoryTracker() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[13] = true;
        String simpleName = cls.getSimpleName();
        StoreContext storeContext2 = this.storeContext;
        if (storeContext2 != null) {
            str = storeContext2.name();
            $jacocoInit[14] = true;
        } else {
            str = null;
            $jacocoInit[15] = true;
        }
        ScreenTagHistory build = Builder.build(simpleName, "", str);
        $jacocoInit[16] = true;
        return build;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.endlessRecyclerOnScrollListener.removeListeners();
        $jacocoInit[17] = true;
        super.onDestroyView();
        $jacocoInit[18] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean z;
        boolean z2 = refresh;
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        if (create) {
            $jacocoInit[19] = true;
        } else if (z2) {
            $jacocoInit[20] = true;
        } else {
            z = true;
            getRecyclerView().mo7530a((C0988n) this.endlessRecyclerOnScrollListener);
            $jacocoInit[30] = true;
            $jacocoInit[31] = z;
        }
        C0044V7 request = buildRequest();
        $jacocoInit[21] = true;
        LinkedList linkedList = new LinkedList();
        int[] iArr = {0};
        $jacocoInit[22] = true;
        int[] hidden = iArr;
        C5123j jVar = new C5123j(this, hidden, linkedList);
        $jacocoInit[23] = true;
        BooleanAction<GetFollowers> firstRequest = getFirstResponseAction(linkedList);
        $jacocoInit[24] = true;
        getRecyclerView().mo7557c();
        $jacocoInit[25] = true;
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2 = r5;
        C5123j jVar2 = jVar;
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener3 = new EndlessRecyclerOnScrollListener(getAdapter(), request, jVar, C5126m.f8860a, 6, true, firstRequest, null);
        this.endlessRecyclerOnScrollListener = endlessRecyclerOnScrollListener2;
        z = true;
        $jacocoInit[26] = true;
        this.endlessRecyclerOnScrollListener.addOnEndlessFinishListener(new C5122i(this, hidden));
        $jacocoInit[27] = true;
        getRecyclerView().mo7530a((C0988n) this.endlessRecyclerOnScrollListener);
        $jacocoInit[28] = true;
        this.endlessRecyclerOnScrollListener.onLoadMore(z2, z2);
        $jacocoInit[29] = true;
        $jacocoInit[31] = z;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16775a(int[] hidden, LinkedList dispList, GetFollowers followersList) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = hidden[0];
        DataList dataList = followersList.getDataList();
        $jacocoInit[33] = true;
        hidden[0] = i + dataList.getHidden();
        $jacocoInit[34] = true;
        DataList dataList2 = followersList.getDataList();
        $jacocoInit[35] = true;
        List<TimelineUser> list = dataList2.getList();
        $jacocoInit[36] = true;
        $jacocoInit[37] = true;
        for (TimelineUser user : list) {
            $jacocoInit[38] = true;
            dispList.add(createUserDisplayable(user));
            $jacocoInit[39] = true;
        }
        addDisplayables(dispList);
        $jacocoInit[40] = true;
        dispList.clear();
        $jacocoInit[41] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16774a(int[] hidden, EndlessRecyclerOnScrollListener __) {
        boolean[] $jacocoInit = $jacocoInit();
        addDisplayable(new MessageWhiteBgDisplayable(getFooterMessage(hidden[0])));
        $jacocoInit[32] = true;
    }
}
