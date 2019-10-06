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
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetFollowersRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.timeline.view.displayable.FollowUserDisplayable;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment.BundleKeys;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener.BooleanAction;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.MessageWhiteBgDisplayable;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.timeline.view.follow.TimeLineFollowersFragment */
public class TimeLineFollowersFragment extends TimeLineFollowFragment {
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
        boolean[] probes = Offline.getProbes(-5144928153054565870L, "cm/aptoide/pt/timeline/view/follow/TimeLineFollowersFragment", 39);
        $jacocoData = probes;
        return probes;
    }

    public TimeLineFollowersFragment() {
        $jacocoInit()[0] = true;
    }

    public static TimeLineFollowFragment newInstanceUsingUser(Long id, String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = getBundle(storeTheme, title, storeContext);
        $jacocoInit[1] = true;
        args.putLong(BundleKeys.USER_ID, id.longValue());
        $jacocoInit[2] = true;
        TimeLineFollowersFragment fragment = new TimeLineFollowersFragment();
        $jacocoInit[3] = true;
        fragment.setArguments(args);
        $jacocoInit[4] = true;
        return fragment;
    }

    private static Bundle getBundle(String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = new Bundle();
        $jacocoInit[5] = true;
        TimeLineFollowFragment.buildBundle(storeContext);
        $jacocoInit[6] = true;
        args.putString(GridRecyclerSwipeWithToolbarFragment.TITLE_KEY, title);
        $jacocoInit[7] = true;
        args.putString("storeTheme", storeTheme);
        $jacocoInit[8] = true;
        return args;
    }

    public static TimeLineFollowFragment newInstanceUsingUser(String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = getBundle(storeTheme, title, storeContext);
        $jacocoInit[9] = true;
        TimeLineFollowersFragment fragment = new TimeLineFollowersFragment();
        $jacocoInit[10] = true;
        fragment.setArguments(args);
        $jacocoInit[11] = true;
        return fragment;
    }

    public static TimeLineFollowFragment newInstanceUsingStore(Long id, String storeTheme, String title, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle args = getBundle(storeTheme, title, storeContext);
        $jacocoInit[12] = true;
        args.putLong(BundleKeys.STORE_ID, id.longValue());
        $jacocoInit[13] = true;
        TimeLineFollowersFragment fragment = new TimeLineFollowersFragment();
        $jacocoInit[14] = true;
        fragment.setArguments(args);
        $jacocoInit[15] = true;
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[16] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[17] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[18] = true;
        this.baseBodyInterceptor = application.getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[19] = true;
        this.httpClient = application.getDefaultClient();
        $jacocoInit[20] = true;
        this.converterFactory = WebService.getDefaultConverter();
        $jacocoInit[21] = true;
        this.tokenInvalidator = application.getTokenInvalidator();
        $jacocoInit[22] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[23] = true;
        String str = BundleKeys.USER_ID;
        if (!args.containsKey(str)) {
            $jacocoInit[24] = true;
        } else {
            $jacocoInit[25] = true;
            this.userId = Long.valueOf(args.getLong(str));
            $jacocoInit[26] = true;
        }
        String str2 = BundleKeys.STORE_ID;
        if (!args.containsKey(str2)) {
            $jacocoInit[27] = true;
        } else {
            $jacocoInit[28] = true;
            this.storeId = Long.valueOf(args.getLong(str2));
            $jacocoInit[29] = true;
        }
        $jacocoInit[30] = true;
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
        $jacocoInit[31] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[32] = true;
        GetFollowersRequest of = GetFollowersRequest.m7464of(bodyInterceptor, l, l2, okHttpClient, factory, tokenInvalidator2, defaultSharedPreferences);
        $jacocoInit[33] = true;
        return of;
    }

    /* access modifiers changed from: protected */
    public Displayable createUserDisplayable(TimelineUser user) {
        boolean[] $jacocoInit = $jacocoInit();
        FollowUserDisplayable followUserDisplayable = new FollowUserDisplayable(user, false, this.theme);
        $jacocoInit[34] = true;
        return followUserDisplayable;
    }

    /* access modifiers changed from: protected */
    public BooleanAction<GetFollowers> getFirstResponseAction(List<Displayable> dispList) {
        boolean[] $jacocoInit = $jacocoInit();
        C5124k kVar = new C5124k(this, dispList);
        $jacocoInit[35] = true;
        return kVar;
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo16783a(List dispList, GetFollowers response) {
        boolean[] $jacocoInit = $jacocoInit();
        dispList.add(0, new MessageWhiteBgDisplayable(getHeaderMessage()));
        $jacocoInit[38] = true;
        return false;
    }

    public String getFooterMessage(int hidden) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getString(C1375R.string.private_followers_message, Integer.valueOf(hidden));
        $jacocoInit[36] = true;
        return string;
    }

    public String getHeaderMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getString(C1375R.string.social_timeline_share_bar_followers);
        $jacocoInit[37] = true;
        return string;
    }
}
