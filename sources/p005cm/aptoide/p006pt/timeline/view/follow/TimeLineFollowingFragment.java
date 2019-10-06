package p005cm.aptoide.p006pt.timeline.view.follow;

import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers.TimelineUser;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetFollowingRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.timeline.view.displayable.FollowUserDisplayable;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment.BundleKeys;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.BooleanAction;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.MessageWhiteBgDisplayable;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.timeline.view.follow.TimeLineFollowingFragment */
public class TimeLineFollowingFragment extends TimeLineFollowFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private Factory converterFactory;
    private OkHttpClient httpClient;
    private Long storeId;
    @Inject
    String theme;
    private TokenInvalidator tokenInvalidator;
    private Long userId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3905431883462542882L, "cm/aptoide/pt/timeline/view/follow/TimeLineFollowingFragment", 40);
        $jacocoData = probes;
        return probes;
    }

    public TimeLineFollowingFragment() {
        $jacocoInit()[0] = true;
    }

    public static TimeLineFollowFragment newInstanceUsingUserId(Long id, String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = buildBundle(storeTheme, title, storeContext);
        if (id == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            args.putLong(BundleKeys.USER_ID, id.longValue());
            $jacocoInit[3] = true;
        }
        TimeLineFollowingFragment fragment = new TimeLineFollowingFragment();
        $jacocoInit[4] = true;
        fragment.setArguments(args);
        $jacocoInit[5] = true;
        return fragment;
    }

    public static TimeLineFollowFragment newInstanceUsingUser(String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = buildBundle(storeTheme, title, storeContext);
        $jacocoInit[6] = true;
        TimeLineFollowingFragment fragment = new TimeLineFollowingFragment();
        $jacocoInit[7] = true;
        fragment.setArguments(args);
        $jacocoInit[8] = true;
        return fragment;
    }

    private static Bundle buildBundle(String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = TimeLineFollowFragment.buildBundle(storeContext);
        $jacocoInit[9] = true;
        args.putString(GridRecyclerSwipeWithToolbarFragment.TITLE_KEY, title);
        $jacocoInit[10] = true;
        args.putString("storeTheme", storeTheme);
        $jacocoInit[11] = true;
        return args;
    }

    public static TimeLineFollowFragment newInstanceUsingStoreId(Long id, String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = buildBundle(storeTheme, title, storeContext);
        if (id == null) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            args.putLong(BundleKeys.STORE_ID, id.longValue());
            $jacocoInit[14] = true;
        }
        TimeLineFollowingFragment fragment = new TimeLineFollowingFragment();
        $jacocoInit[15] = true;
        fragment.setArguments(args);
        $jacocoInit[16] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[17] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[18] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[19] = true;
        this.baseBodyInterceptor = application.getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[20] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[21] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[22] = true;
        this.tokenInvalidator = application.getTokenInvalidator();
        $jacocoInit[23] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[24] = true;
        String str = BundleKeys.USER_ID;
        if (!args.containsKey(str)) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            this.userId = Long.valueOf(args.getLong(str));
            $jacocoInit[27] = true;
        }
        String str2 = BundleKeys.STORE_ID;
        if (!args.containsKey(str2)) {
            $jacocoInit[28] = true;
        } else {
            $jacocoInit[29] = true;
            this.storeId = Long.valueOf(args.getLong(str2));
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
    }

    /* access modifiers changed from: protected */
    public C0044V7 buildRequest() {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> bodyInterceptor = this.baseBodyInterceptor;
        Long l = this.userId;
        Long l2 = this.storeId;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        $jacocoInit[32] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[33] = true;
        GetFollowingRequest of = GetFollowingRequest.m7465of(bodyInterceptor, l, l2, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
        $jacocoInit[34] = true;
        return of;
    }

    /* access modifiers changed from: protected */
    public Displayable createUserDisplayable(TimelineUser user) {
        boolean[] $jacocoInit = $jacocoInit();
        FollowUserDisplayable followUserDisplayable = new FollowUserDisplayable(user, false, this.theme);
        $jacocoInit[35] = true;
        return followUserDisplayable;
    }

    /* access modifiers changed from: protected */
    public BooleanAction<GetFollowers> getFirstResponseAction(List<Displayable> dispList) {
        boolean[] $jacocoInit = $jacocoInit();
        C5125l lVar = new C5125l(this, dispList);
        $jacocoInit[36] = true;
        return lVar;
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo16786a(List dispList, GetFollowers response) {
        boolean[] $jacocoInit = $jacocoInit();
        dispList.add(0, new MessageWhiteBgDisplayable(getHeaderMessage()));
        $jacocoInit[39] = true;
        return false;
    }

    public String getFooterMessage(int hidden) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getString(C1375R.string.private_following_message, Integer.valueOf(hidden));
        $jacocoInit[37] = true;
        return string;
    }

    public String getHeaderMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getString(C1375R.string.social_timeline_share_bar_following);
        $jacocoInit[38] = true;
        return string;
    }
}
