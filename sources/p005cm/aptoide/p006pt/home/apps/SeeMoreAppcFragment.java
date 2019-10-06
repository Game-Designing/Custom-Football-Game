package p005cm.aptoide.p006pt.home.apps;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p019d.p022i.p296a.p298b.p301b.p302a.C13016e;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.SeeMoreAppcFragment */
public class SeeMoreAppcFragment extends NavigationTrackFragment implements SeeMoreAppcView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C14963c<AppClick> appItemClicks;
    private AppcAppsAdapter appcAppsAdapter;
    private RecyclerView appcAppsRecyclerView;
    @Inject
    SeeMoreAppcPresenter seeMoreAppcPresenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8390814257148082169L, "cm/aptoide/pt/home/apps/SeeMoreAppcFragment", 88);
        $jacocoData = probes;
        return probes;
    }

    public SeeMoreAppcFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        SeeMoreAppcFragment seeMoreAppcFragment = new SeeMoreAppcFragment();
        $jacocoInit[1] = true;
        return seeMoreAppcFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
        this.appItemClicks = C14963c.m46753p();
        $jacocoInit[4] = true;
        setHasOptionsMenu(true);
        $jacocoInit[5] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[6] = true;
        this.appcAppsRecyclerView = (RecyclerView) view.findViewById(C1375R.C1376id.appc_apps_recycler_view);
        $jacocoInit[7] = true;
        this.appcAppsRecyclerView.setNestedScrollingEnabled(false);
        $jacocoInit[8] = true;
        this.appcAppsAdapter = new AppcAppsAdapter(new ArrayList(), this.appItemClicks);
        $jacocoInit[9] = true;
        this.appcAppsRecyclerView.setAdapter(this.appcAppsAdapter);
        RecyclerView recyclerView = this.appcAppsRecyclerView;
        $jacocoInit[10] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        $jacocoInit[11] = true;
        recyclerView.setLayoutManager(linearLayoutManager);
        $jacocoInit[12] = true;
        this.appcAppsRecyclerView.setItemAnimator(null);
        $jacocoInit[13] = true;
        this.swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(C1375R.C1376id.fragment_apps_swipe_container);
        $jacocoInit[14] = true;
        this.swipeRefreshLayout.setColorSchemeResources(C1375R.color.default_progress_bar_color, C1375R.color.default_color, C1375R.color.default_progress_bar_color, C1375R.color.default_color);
        $jacocoInit[15] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[16] = true;
        this.toolbar.setTitle((CharSequence) getString(C1375R.string.promo_update2appc_appcard_short));
        $jacocoInit[17] = true;
        C0019n appCompatActivity = (C0019n) getActivity();
        $jacocoInit[18] = true;
        appCompatActivity.setSupportActionBar(this.toolbar);
        $jacocoInit[19] = true;
        C0760a actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar == null) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            actionBar.mo6153d(true);
            $jacocoInit[22] = true;
        }
        attachPresenter(this.seeMoreAppcPresenter);
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[27] = true;
        View inflate = inflater.inflate(C1375R.layout.fragment_apps_see_more_appc, container, false);
        $jacocoInit[28] = true;
        return inflate;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        this.swipeRefreshLayout = null;
        this.appcAppsRecyclerView = null;
        this.appcAppsAdapter = null;
        $jacocoInit[29] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[30] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[31] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[32] = true;
            getActivity().onBackPressed();
            $jacocoInit[33] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[34] = true;
        return onOptionsItemSelected;
    }

    public void showAppcUpgradesList(List<App> list) {
        boolean[] $jacocoInit = $jacocoInit();
        if (list == null) {
            $jacocoInit[35] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            this.appcAppsAdapter.setAvailableUpgradesList(list);
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
    }

    public C0120S<Void> refreshApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13016e.m42477a(this.swipeRefreshLayout);
        $jacocoInit[40] = true;
        return a;
    }

    public void hidePullToRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[41] = true;
        } else {
            $jacocoInit[42] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[43] = true;
        }
        $jacocoInit[44] = true;
    }

    public C0120S<App> upgradeAppcApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3527Fd.f6908a);
        C3521Ed ed = C3521Ed.f6902a;
        $jacocoInit[45] = true;
        C0120S<App> j = d.mo3669j(ed);
        $jacocoInit[46] = true;
        return j;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m8450i(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_APP) {
            $jacocoInit[85] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[86] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[87] = true;
        return valueOf;
    }

    /* renamed from: j */
    static /* synthetic */ App m8451j(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[84] = true;
        return app;
    }

    public C0120S<App> resumeAppcUpgrade() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3533Gd.f6914a);
        C3575Nd nd = C3575Nd.f6958a;
        $jacocoInit[47] = true;
        C0120S<App> j = d.mo3669j(nd);
        $jacocoInit[48] = true;
        return j;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8446e(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_RESUME) {
            $jacocoInit[81] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[82] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[83] = true;
        return valueOf;
    }

    /* renamed from: f */
    static /* synthetic */ App m8447f(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[80] = true;
        return app;
    }

    public C0120S<App> retryAppcUpgrade() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3539Hd.f6921a);
        C3515Dd dd = C3515Dd.f6896a;
        $jacocoInit[49] = true;
        C0120S<App> j = d.mo3669j(dd);
        $jacocoInit[50] = true;
        return j;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m8448g(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_RETRY) {
            $jacocoInit[77] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[78] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[79] = true;
        return valueOf;
    }

    /* renamed from: h */
    static /* synthetic */ App m8449h(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[76] = true;
        return app;
    }

    public C0120S<App> cancelAppcUpgrade() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3545Id.f6927a);
        C3551Jd jd = C3551Jd.f6933a;
        $jacocoInit[51] = true;
        C0120S<App> j = d.mo3669j(jd);
        $jacocoInit[52] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8441a(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_CANCEL) {
            $jacocoInit[73] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[74] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[75] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ App m8443b(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[72] = true;
        return app;
    }

    public C0120S<App> pauseAppcUpgrade() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3557Kd.f6939a);
        C3563Ld ld = C3563Ld.f6946a;
        $jacocoInit[53] = true;
        C0120S<App> j = d.mo3669j(ld);
        $jacocoInit[54] = true;
        return j;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8444c(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_PAUSE) {
            $jacocoInit[69] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[70] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[71] = true;
        return valueOf;
    }

    /* renamed from: d */
    static /* synthetic */ App m8445d(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[68] = true;
        return app;
    }

    public C0120S<Boolean> showRootWarning() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[55] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.root_access_dialog, getResources(), new Object[0]);
        $jacocoInit[56] = true;
        C0120S createGenericYesNoCancelMessage = GenericDialogs.createGenericYesNoCancelMessage(context, "", formattedString);
        C3569Md md = C3569Md.f6952a;
        $jacocoInit[57] = true;
        C0120S<Boolean> j = createGenericYesNoCancelMessage.mo3669j(md);
        $jacocoInit[58] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8442a(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(response.equals(EResponse.YES));
        $jacocoInit[67] = true;
        return valueOf;
    }

    public void setAppcStandbyState(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcAppsAdapter.setAppStandby(app);
        $jacocoInit[59] = true;
    }

    public void removeAppcCanceledAppDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcAppsAdapter.removeCanceledAppDownload(app);
        $jacocoInit[60] = true;
    }

    public void setAppcPausingDownloadState(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcAppsAdapter.setAppOnPausing(app);
        $jacocoInit[61] = true;
    }

    public void showAppcUpgradesDownloadList(List<App> updatesDownloadList) {
        boolean[] $jacocoInit = $jacocoInit();
        if (updatesDownloadList == null) {
            $jacocoInit[62] = true;
        } else if (updatesDownloadList.isEmpty()) {
            $jacocoInit[63] = true;
        } else {
            $jacocoInit[64] = true;
            this.appcAppsAdapter.addApps(updatesDownloadList);
            $jacocoInit[65] = true;
        }
        $jacocoInit[66] = true;
    }
}
