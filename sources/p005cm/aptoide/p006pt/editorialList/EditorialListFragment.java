package p005cm.aptoide.p006pt.editorialList;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0975f;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p005cm.aptoide.p006pt.editorial.EditorialFragment;
import p005cm.aptoide.p006pt.home.EditorialBundleViewHolder;
import p005cm.aptoide.p006pt.home.EditorialHomeEvent;
import p005cm.aptoide.p006pt.home.HomeEvent;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p019d.p022i.p296a.p298b.p301b.p302a.C13016e;
import p019d.p022i.p296a.p298b.p303c.p304a.C13020a;
import p019d.p022i.p296a.p298b.p303c.p304a.C13024e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListFragment */
public class EditorialListFragment extends NavigationTrackFragment implements EditorialListView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.CURATION;
    private static final String TAG = EditorialFragment.class.getName();
    private static final int VISIBLE_THRESHOLD = 1;
    private EditorialListAdapter adapter;
    private BottomNavigationActivity bottomNavigationActivity;
    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    private RecyclerView editorialList;
    private View genericErrorView;
    private ScrollControlLinearLayoutManager layoutManager;
    private View noNetworkErrorView;
    private View noNetworkRetryButton;
    @Inject
    public EditorialListPresenter presenter;
    private ProgressBar progressBar;
    private View retryButton;
    private C14963c<Void> snackListener;
    private SwipeRefreshLayout swipeRefreshLayout;
    private C14963c<HomeEvent> uiEventsListener;
    private ImageView userAvatar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4562652702978069544L, "cm/aptoide/pt/editorialList/EditorialListFragment", Opcodes.IFNE);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListFragment() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[153] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[2] = true;
        this.uiEventsListener = C14963c.m46753p();
        $jacocoInit[3] = true;
        this.snackListener = C14963c.m46753p();
        $jacocoInit[4] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            bottomNavigationActivity2.requestFocus(BOTTOM_NAVIGATION_ITEM);
            $jacocoInit[7] = true;
        }
        this.userAvatar = (ImageView) view.findViewById(C1375R.C1376id.user_actionbar_icon);
        $jacocoInit[8] = true;
        this.layoutManager = new ScrollControlLinearLayoutManager(getContext());
        $jacocoInit[9] = true;
        this.adapter = new EditorialListAdapter(new ArrayList(), new ProgressCard(), this.uiEventsListener, this.captionBackgroundPainter);
        $jacocoInit[10] = true;
        this.editorialList = (RecyclerView) view.findViewById(C1375R.C1376id.editorial_list);
        $jacocoInit[11] = true;
        this.editorialList.setLayoutManager(this.layoutManager);
        $jacocoInit[12] = true;
        this.editorialList.setAdapter(this.adapter);
        $jacocoInit[13] = true;
        C0975f itemAnimator = this.editorialList.getItemAnimator();
        $jacocoInit[14] = true;
        itemAnimator.mo7722a(0);
        $jacocoInit[15] = true;
        this.swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(C1375R.C1376id.refresh_layout);
        $jacocoInit[16] = true;
        this.swipeRefreshLayout.setColorSchemeResources(C1375R.color.default_progress_bar_color, C1375R.color.default_color, C1375R.color.default_progress_bar_color, C1375R.color.default_color);
        $jacocoInit[17] = true;
        this.genericErrorView = view.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[18] = true;
        this.noNetworkErrorView = view.findViewById(C1375R.C1376id.no_network_connection);
        $jacocoInit[19] = true;
        this.retryButton = this.genericErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[20] = true;
        this.noNetworkRetryButton = this.noNetworkErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[21] = true;
        this.progressBar = (ProgressBar) view.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[22] = true;
        attachPresenter(this.presenter);
        $jacocoInit[23] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[24] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[25] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[26] = true;
        return build;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[27] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.uiEventsListener = null;
        this.snackListener = null;
        $jacocoInit[30] = true;
        super.onDestroy();
        $jacocoInit[31] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[32] = true;
        View inflate = inflater.inflate(C1375R.layout.fragment_editorial_list, container, false);
        $jacocoInit[33] = true;
        return inflate;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7838a(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.EDITORIAL;
        $jacocoInit[150] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[151] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[152] = true;
        return valueOf;
    }

    public C0120S<EditorialHomeEvent> editorialCardClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[34] = true;
        C0120S<EditorialHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3284e.f6661a).mo3611a(EditorialHomeEvent.class);
        $jacocoInit[35] = true;
        return a;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m7844e(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.REACT_SINGLE_PRESS;
        $jacocoInit[147] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[148] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[149] = true;
        return valueOf;
    }

    public C0120S<EditorialHomeEvent> reactionsButtonClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[36] = true;
        C0120S<EditorialHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3302n.f6681a).mo3611a(EditorialHomeEvent.class);
        $jacocoInit[37] = true;
        return a;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericErrorView.setVisibility(8);
        $jacocoInit[38] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[39] = true;
        this.progressBar.setVisibility(0);
        $jacocoInit[40] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericErrorView.setVisibility(8);
        $jacocoInit[41] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[42] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[43] = true;
        this.swipeRefreshLayout.setVisibility(0);
        $jacocoInit[44] = true;
    }

    public void showGenericError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.genericErrorView.setVisibility(0);
        $jacocoInit[45] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[46] = true;
        this.editorialList.setVisibility(8);
        $jacocoInit[47] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[48] = true;
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[51] = true;
        }
        $jacocoInit[52] = true;
    }

    public void showNetworkError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.noNetworkErrorView.setVisibility(0);
        $jacocoInit[53] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[54] = true;
        this.editorialList.setVisibility(8);
        $jacocoInit[55] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[56] = true;
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[59] = true;
        }
        $jacocoInit[60] = true;
    }

    public C0120S<Void> retryClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> b = C0120S.m649b(C13034a.m42490a(this.retryButton), C13034a.m42490a(this.noNetworkRetryButton));
        $jacocoInit[61] = true;
        return b;
    }

    public C0120S<Void> refreshes() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13016e.m42477a(this.swipeRefreshLayout);
        $jacocoInit[62] = true;
        return a;
    }

    public void hideRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        this.swipeRefreshLayout.setRefreshing(false);
        $jacocoInit[63] = true;
    }

    public C0120S<Void> imageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.userAvatar);
        $jacocoInit[64] = true;
        return a;
    }

    public void showAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.userAvatar.setVisibility(0);
        $jacocoInit[65] = true;
    }

    public void setDefaultUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[66] = true;
        with.loadUsingCircleTransform((int) C1375R.drawable.ic_account_circle, imageView);
        $jacocoInit[67] = true;
    }

    public void setUserImage(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[68] = true;
        with.loadWithShadowCircleTransformWithPlaceholder(userAvatarUrl, imageView, C1375R.drawable.ic_account_circle);
        $jacocoInit[69] = true;
    }

    public C0120S<Object> reachesBottom() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(this.editorialList);
        C3294j jVar = new C3294j(this);
        $jacocoInit[70] = true;
        C0120S j = a.mo3669j(jVar);
        $jacocoInit[71] = true;
        C0120S b = j.mo3628b();
        C3280c cVar = C3280c.f6657a;
        $jacocoInit[72] = true;
        $jacocoInit[73] = true;
        C0120S<Object> a2 = b.mo3653d((C0132p<? super T, Boolean>) cVar).mo3611a(Object.class);
        $jacocoInit[74] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14054a(C13020a scroll) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(isEndReached());
        $jacocoInit[146] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7839a(Boolean isEnd) {
        $jacocoInit()[145] = true;
        return isEnd;
    }

    public void populateView(List<CurationCard> curationCards) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialList.setVisibility(0);
        $jacocoInit[75] = true;
        this.adapter.add(curationCards);
        $jacocoInit[76] = true;
    }

    public C0120S<EditorialListEvent> visibleCards() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13024e.m42482a(this.editorialList);
        $jacocoInit[77] = true;
        C0120S b = a.mo3634b(C14522a.m46170a());
        C3298l lVar = new C3298l(this);
        $jacocoInit[78] = true;
        C0120S j = b.mo3669j(lVar);
        C3290h hVar = C3290h.f6668a;
        $jacocoInit[79] = true;
        C0120S d = j.mo3653d((C0132p<? super T, Boolean>) hVar);
        $jacocoInit[80] = true;
        C0120S b2 = d.mo3628b();
        C3288g gVar = new C3288g(this);
        $jacocoInit[81] = true;
        C0120S<EditorialListEvent> j2 = b2.mo3669j(gVar);
        $jacocoInit[82] = true;
        return j2;
    }

    /* renamed from: b */
    public /* synthetic */ Integer mo14057b(C13020a recyclerViewScrollEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(this.layoutManager.findFirstVisibleItemPosition());
        $jacocoInit[144] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7840a(Integer position) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (position.intValue() != -1) {
            $jacocoInit[141] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[142] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[143] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ EditorialListEvent mo14056b(Integer visibleItem) {
        boolean[] $jacocoInit = $jacocoInit();
        CurationCard card = this.adapter.getCard(visibleItem.intValue());
        $jacocoInit[139] = true;
        EditorialListEvent editorialListEvent = new EditorialListEvent(card.getId(), visibleItem.intValue());
        $jacocoInit[140] = true;
        return editorialListEvent;
    }

    public void showLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListAdapter editorialListAdapter = this.adapter;
        if (editorialListAdapter == null) {
            $jacocoInit[83] = true;
        } else {
            $jacocoInit[84] = true;
            editorialListAdapter.addLoadMore();
            $jacocoInit[85] = true;
        }
        $jacocoInit[86] = true;
    }

    public void hideLoadMore() {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListAdapter editorialListAdapter = this.adapter;
        if (editorialListAdapter == null) {
            $jacocoInit[87] = true;
        } else {
            $jacocoInit[88] = true;
            editorialListAdapter.removeLoadMore();
            $jacocoInit[89] = true;
        }
        $jacocoInit[90] = true;
    }

    public void update(List<CurationCard> curationCards) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialList.setVisibility(0);
        EditorialListAdapter editorialListAdapter = this.adapter;
        if (editorialListAdapter == null) {
            $jacocoInit[91] = true;
        } else {
            $jacocoInit[92] = true;
            editorialListAdapter.update(curationCards);
            $jacocoInit[93] = true;
        }
        $jacocoInit[94] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m7843d(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.REACTION;
        $jacocoInit[136] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[137] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[138] = true;
        return valueOf;
    }

    public C0120S<ReactionsHomeEvent> reactionClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[95] = true;
        C0120S<ReactionsHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3286f.f6664a).mo3611a(ReactionsHomeEvent.class);
        $jacocoInit[96] = true;
        return a;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7842c(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.REACT_LONG_PRESS;
        $jacocoInit[133] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[134] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[135] = true;
        return valueOf;
    }

    public C0120S<EditorialHomeEvent> reactionButtonLongPress() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[97] = true;
        C0120S a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3282d.f6659a).mo3611a(EditorialHomeEvent.class);
        C3300m mVar = new C3300m(this);
        $jacocoInit[98] = true;
        C0120S<EditorialHomeEvent> j = a.mo3669j(mVar);
        $jacocoInit[99] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ EditorialHomeEvent mo14053a(EditorialHomeEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        setScrollEnabled(Boolean.valueOf(false));
        $jacocoInit[132] = true;
        return event;
    }

    public void showReactionsPopup(String cardId, String groupId, int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[100] = true;
        EditorialBundleViewHolder editorialBundleViewHolder = getViewHolderForAdapterPosition(bundlePosition);
        if (editorialBundleViewHolder == null) {
            $jacocoInit[101] = true;
        } else {
            $jacocoInit[102] = true;
            editorialBundleViewHolder.showReactions(cardId, groupId, bundlePosition);
            $jacocoInit[103] = true;
        }
        $jacocoInit[104] = true;
    }

    public void showLogInDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        ShowMessage.asSnack((Activity) getActivity(), (int) C1375R.string.editorial_reactions_login_short, (int) C1375R.string.login, (OnClickListener) new C3296k(this), -1);
        $jacocoInit[105] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14055a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.snackListener.onNext(null);
        $jacocoInit[131] = true;
    }

    public C0120S<Void> snackLogInClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.snackListener;
        $jacocoInit[106] = true;
        return cVar;
    }

    public void showGenericErrorToast() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(getView(), (CharSequence) getString(C1375R.string.error_occured), 0);
        $jacocoInit[107] = true;
        a.mo4690h();
        $jacocoInit[108] = true;
    }

    public void updateEditorialCard(CurationCard curationCard) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.updateEditorialCard(curationCard);
        $jacocoInit[109] = true;
    }

    public void showNetworkErrorToast() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(getView(), (CharSequence) getString(C1375R.string.connection_error), 0);
        $jacocoInit[110] = true;
        a.mo4690h();
        $jacocoInit[111] = true;
    }

    public void setScrollEnabled(Boolean flag) {
        boolean[] $jacocoInit = $jacocoInit();
        this.layoutManager.setScrollEnabled(flag.booleanValue());
        $jacocoInit[112] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7841b(HomeEvent homeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = homeEvent.getType();
        Type type2 = Type.POPUP_DISMISS;
        $jacocoInit[128] = true;
        boolean equals = type.equals(type2);
        $jacocoInit[129] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[130] = true;
        return valueOf;
    }

    public C0120S<EditorialHomeEvent> onPopupDismiss() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[113] = true;
        C0120S<EditorialHomeEvent> a = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3292i.f6670a).mo3611a(EditorialHomeEvent.class);
        $jacocoInit[114] = true;
        return a;
    }

    private boolean isEndReached() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 1) {
            $jacocoInit[115] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[116] = true;
        }
        $jacocoInit[117] = true;
        return z;
    }

    private EditorialBundleViewHolder getViewHolderForAdapterPosition(int placeHolderPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        if (placeHolderPosition != -1) {
            RecyclerView recyclerView = this.editorialList;
            $jacocoInit[118] = true;
            EditorialBundleViewHolder placeHolderViewHolder = (EditorialBundleViewHolder) recyclerView.mo7544b(placeHolderPosition);
            if (placeHolderViewHolder != null) {
                $jacocoInit[119] = true;
            } else {
                $jacocoInit[120] = true;
                Log.e(TAG, "Unable to find editorialBundleViewHolder");
                $jacocoInit[121] = true;
            }
            $jacocoInit[122] = true;
            return placeHolderViewHolder;
        }
        $jacocoInit[123] = true;
        return null;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[124] = true;
        super.onDetach();
        $jacocoInit[125] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialList = null;
        this.adapter = null;
        this.layoutManager = null;
        this.genericErrorView = null;
        this.noNetworkErrorView = null;
        this.progressBar = null;
        this.noNetworkRetryButton = null;
        this.retryButton = null;
        this.userAvatar = null;
        this.swipeRefreshLayout = null;
        $jacocoInit[126] = true;
        super.onDestroyView();
        $jacocoInit[127] = true;
    }
}
