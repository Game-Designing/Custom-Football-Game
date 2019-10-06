package p005cm.aptoide.p006pt.home.apps;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p005cm.aptoide.p006pt.view.p080rx.RxAlertDialog;
import p019d.p022i.p296a.p298b.p301b.p302a.C13016e;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.apps.AppsFragment */
public class AppsFragment extends NavigationTrackFragment implements AppsFragmentView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int APPC_UPDATES_LIMIT = 2;
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.APPS;
    private AppsAdapter adapter;
    private C14963c<AppClick> appItemClicks;
    private AppcAppsAdapter appcAppsAdapter;
    private View appcAppsLayout;
    private RecyclerView appcAppsRecyclerView;
    private Button appcSeeMoreButton;
    private C14963c<Void> appcUpgradesSectionLoaded;
    @Inject
    AppsPresenter appsPresenter;
    private List<App> blackListDownloads;
    private BottomNavigationActivity bottomNavigationActivity;
    private RxAlertDialog ignoreUpdateDialog;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private boolean showDownloads;
    private boolean showInstalled;
    private boolean showUpdates;
    private boolean showUpgrades;
    private SwipeRefreshLayout swipeRefreshLayout;
    private C14963c<Void> updateAll;
    private C14963c<Void> updatesSectionLoaded;
    private ImageView userAvatar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2248137838341294941L, "cm/aptoide/pt/home/apps/AppsFragment", 291);
        $jacocoData = probes;
        return probes;
    }

    public AppsFragment() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[290] = true;
    }

    public static AppsFragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        AppsFragment appsFragment = new AppsFragment();
        $jacocoInit[1] = true;
        return appsFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
        this.appItemClicks = C14963c.m46753p();
        $jacocoInit[4] = true;
        this.updateAll = C14963c.m46753p();
        $jacocoInit[5] = true;
        this.appcUpgradesSectionLoaded = C14963c.m46753p();
        $jacocoInit[6] = true;
        this.updatesSectionLoaded = C14963c.m46753p();
        $jacocoInit[7] = true;
        this.blackListDownloads = new ArrayList();
        $jacocoInit[8] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            bottomNavigationActivity2.requestFocus(BOTTOM_NAVIGATION_ITEM);
            $jacocoInit[11] = true;
        }
        this.recyclerView = (RecyclerView) view.findViewById(C1375R.C1376id.fragment_apps_recycler_view);
        $jacocoInit[12] = true;
        this.recyclerView.setNestedScrollingEnabled(false);
        $jacocoInit[13] = true;
        this.adapter = new AppsAdapter(new ArrayList(), new AppsCardViewHolderFactory(this.appItemClicks, this.updateAll));
        $jacocoInit[14] = true;
        this.appcAppsLayout = view.findViewById(C1375R.C1376id.appc_apps_layout);
        $jacocoInit[15] = true;
        this.appcAppsRecyclerView = (RecyclerView) view.findViewById(C1375R.C1376id.appc_apps_recycler_view);
        $jacocoInit[16] = true;
        this.appcAppsRecyclerView.setNestedScrollingEnabled(false);
        $jacocoInit[17] = true;
        this.appcSeeMoreButton = (Button) view.findViewById(C1375R.C1376id.appc_see_more_btn);
        $jacocoInit[18] = true;
        this.appcAppsAdapter = new AppcAppsAdapter(new ArrayList(), this.appItemClicks, 2);
        $jacocoInit[19] = true;
        this.swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(C1375R.C1376id.fragment_apps_swipe_container);
        $jacocoInit[20] = true;
        this.swipeRefreshLayout.setColorSchemeResources(C1375R.color.default_progress_bar_color, C1375R.color.default_color, C1375R.color.default_progress_bar_color, C1375R.color.default_color);
        $jacocoInit[21] = true;
        this.progressBar = (ProgressBar) view.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[22] = true;
        this.progressBar.setVisibility(0);
        $jacocoInit[23] = true;
        setupRecyclerView();
        $jacocoInit[24] = true;
        buildIgnoreUpdatesDialog();
        $jacocoInit[25] = true;
        this.userAvatar = (ImageView) view.findViewById(C1375R.C1376id.user_actionbar_icon);
        $jacocoInit[26] = true;
        attachPresenter(this.appsPresenter);
        $jacocoInit[27] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[28] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[29] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[30] = true;
        return build;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[31] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateAll = null;
        this.appItemClicks = null;
        this.blackListDownloads = null;
        $jacocoInit[34] = true;
        super.onDestroy();
        $jacocoInit[35] = true;
    }

    private void buildIgnoreUpdatesDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[36] = true;
        RxAlertDialog.Builder title = new RxAlertDialog.Builder(getContext()).setTitle(C1375R.string.apps_title_ignore_updates);
        $jacocoInit[37] = true;
        RxAlertDialog.Builder positiveButton = title.setPositiveButton(C1375R.string.apps_button_ignore_updates_yes);
        $jacocoInit[38] = true;
        RxAlertDialog.Builder negativeButton = positiveButton.setNegativeButton(C1375R.string.apps_button_ignore_updates_no);
        $jacocoInit[39] = true;
        this.ignoreUpdateDialog = negativeButton.build();
        $jacocoInit[40] = true;
    }

    private void setupRecyclerView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.recyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView2 = this.recyclerView;
        $jacocoInit[41] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        $jacocoInit[42] = true;
        recyclerView2.setLayoutManager(linearLayoutManager);
        $jacocoInit[43] = true;
        this.recyclerView.setItemAnimator(null);
        $jacocoInit[44] = true;
        this.appcAppsRecyclerView.setAdapter(this.appcAppsAdapter);
        RecyclerView recyclerView3 = this.appcAppsRecyclerView;
        $jacocoInit[45] = true;
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), 1, false);
        $jacocoInit[46] = true;
        recyclerView3.setLayoutManager(linearLayoutManager2);
        $jacocoInit[47] = true;
        this.appcAppsRecyclerView.setItemAnimator(null);
        $jacocoInit[48] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[49] = true;
        View inflate = inflater.inflate(C1375R.layout.fragment_apps, container, false);
        $jacocoInit[50] = true;
        return inflate;
    }

    public void showUpdatesList(List<App> list) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[51] = true;
        instance.mo2136d("Apps", "showing updates list");
        $jacocoInit[52] = true;
        if (list == null) {
            $jacocoInit[53] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[54] = true;
        } else {
            $jacocoInit[55] = true;
            this.adapter.setAvailableUpdatesList(list);
            $jacocoInit[56] = true;
        }
        this.showUpdates = true;
        $jacocoInit[57] = true;
        this.updatesSectionLoaded.onNext(null);
        $jacocoInit[58] = true;
        if (!shouldShowAppsList()) {
            $jacocoInit[59] = true;
        } else {
            $jacocoInit[60] = true;
            showAppsList();
            $jacocoInit[61] = true;
        }
        $jacocoInit[62] = true;
    }

    public void showInstalledApps(List<App> installedApps) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[63] = true;
        instance.mo2136d("Apps", "showing installed apps list");
        $jacocoInit[64] = true;
        if (installedApps == null) {
            $jacocoInit[65] = true;
        } else if (installedApps.isEmpty()) {
            $jacocoInit[66] = true;
        } else {
            $jacocoInit[67] = true;
            this.adapter.addInstalledAppsList(installedApps);
            $jacocoInit[68] = true;
        }
        this.showInstalled = true;
        $jacocoInit[69] = true;
        if (!shouldShowAppsList()) {
            $jacocoInit[70] = true;
        } else {
            $jacocoInit[71] = true;
            showAppsList();
            $jacocoInit[72] = true;
        }
        $jacocoInit[73] = true;
    }

    public void showDownloadsList(List<App> list) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[74] = true;
        instance.mo2136d("Apps", "showing downloads list");
        $jacocoInit[75] = true;
        list.removeAll(this.blackListDownloads);
        $jacocoInit[76] = true;
        if (list.isEmpty()) {
            $jacocoInit[77] = true;
        } else {
            $jacocoInit[78] = true;
            this.adapter.addDownloadAppsList(list);
            $jacocoInit[79] = true;
        }
        this.showDownloads = true;
        $jacocoInit[80] = true;
        if (!shouldShowAppsList()) {
            $jacocoInit[81] = true;
        } else {
            $jacocoInit[82] = true;
            showAppsList();
            $jacocoInit[83] = true;
        }
        $jacocoInit[84] = true;
    }

    public C0120S<App> retryDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3801w.f7213a);
        C3499B b = C3499B.f6877a;
        $jacocoInit[85] = true;
        C0120S<App> j = d.mo3669j(b);
        $jacocoInit[86] = true;
        return j;
    }

    /* renamed from: q */
    static /* synthetic */ Boolean m8227q(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.RETRY_DOWNLOAD) {
            $jacocoInit[287] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[288] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[289] = true;
        return valueOf;
    }

    /* renamed from: r */
    static /* synthetic */ App m8228r(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[286] = true;
        return app;
    }

    public C0120S<App> installApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3783t.f7195a);
        C3535H h = C3535H.f6916a;
        $jacocoInit[87] = true;
        C0120S<App> j = d.mo3669j(h);
        $jacocoInit[88] = true;
        return j;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m8217g(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.INSTALL_APP) {
            $jacocoInit[283] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[284] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[285] = true;
        return valueOf;
    }

    /* renamed from: h */
    static /* synthetic */ App m8218h(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[282] = true;
        return app;
    }

    public C0120S<App> cancelDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3795v.f7207a);
        C3777s sVar = C3777s.f7189a;
        $jacocoInit[89] = true;
        C0120S j = d.mo3669j(sVar);
        C3771r rVar = new C3771r(this);
        $jacocoInit[90] = true;
        C0120S<App> b = j.mo3636b((C0129b<? super T>) rVar);
        $jacocoInit[91] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8209a(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.CANCEL_DOWNLOAD) {
            $jacocoInit[279] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[280] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[281] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ App m8212b(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[278] = true;
        return app;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14611a(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.blackListDownloads.add(app);
        $jacocoInit[277] = true;
    }

    public C0120S<App> resumeDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3737m.f7145a);
        C3819z zVar = C3819z.f7233a;
        $jacocoInit[92] = true;
        C0120S<App> j = d.mo3669j(zVar);
        $jacocoInit[93] = true;
        return j;
    }

    /* renamed from: m */
    static /* synthetic */ Boolean m8223m(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.RESUME_DOWNLOAD) {
            $jacocoInit[274] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[275] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[276] = true;
        return valueOf;
    }

    /* renamed from: n */
    static /* synthetic */ App m8224n(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[273] = true;
        return app;
    }

    public C0120S<App> pauseDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3709i.f7115a);
        C3789u uVar = C3789u.f7201a;
        $jacocoInit[94] = true;
        C0120S<App> j = d.mo3669j(uVar);
        $jacocoInit[95] = true;
        return j;
    }

    /* renamed from: j */
    static /* synthetic */ Boolean m8220j(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.PAUSE_DOWNLOAD) {
            $jacocoInit[270] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[271] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[272] = true;
        return valueOf;
    }

    /* renamed from: i */
    static /* synthetic */ App m8219i(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[269] = true;
        return app;
    }

    public C0120S<AppClickEventWrapper> retryUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3758p.f7169a);
        C3730l lVar = C3730l.f7138a;
        $jacocoInit[96] = true;
        C0120S<AppClickEventWrapper> j = d.mo3669j(lVar);
        $jacocoInit[97] = true;
        return j;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m8229s(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.RETRY_UPDATE) {
            $jacocoInit[263] = true;
        } else {
            $jacocoInit[264] = true;
            if (appClick.getClickType() == ClickType.APPC_UPGRADE_RETRY) {
                $jacocoInit[265] = true;
            } else {
                z = false;
                $jacocoInit[267] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[268] = true;
                return valueOf;
            }
        }
        $jacocoInit[266] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[268] = true;
        return valueOf2;
    }

    /* renamed from: t */
    static /* synthetic */ AppClickEventWrapper m8230t(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[259] = true;
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_RETRY) {
            $jacocoInit[260] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[261] = true;
        }
        AppClickEventWrapper appClickEventWrapper = new AppClickEventWrapper(z, appClick.getApp());
        $jacocoInit[262] = true;
        return appClickEventWrapper;
    }

    /* renamed from: u */
    static /* synthetic */ Boolean m8231u(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.UPDATE_APP) {
            $jacocoInit[253] = true;
        } else {
            $jacocoInit[254] = true;
            if (appClick.getClickType() == ClickType.APPC_UPGRADE_APP) {
                $jacocoInit[255] = true;
            } else {
                z = false;
                $jacocoInit[257] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[258] = true;
                return valueOf;
            }
        }
        $jacocoInit[256] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[258] = true;
        return valueOf2;
    }

    public C0120S<AppClickEventWrapper> updateApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3511D.f6892a);
        C3813y yVar = C3813y.f7226a;
        $jacocoInit[98] = true;
        C0120S<AppClickEventWrapper> j = d.mo3669j(yVar);
        $jacocoInit[99] = true;
        return j;
    }

    /* renamed from: v */
    static /* synthetic */ AppClickEventWrapper m8232v(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[249] = true;
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_APP) {
            $jacocoInit[250] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[251] = true;
        }
        AppClickEventWrapper appClickEventWrapper = new AppClickEventWrapper(z, appClick.getApp());
        $jacocoInit[252] = true;
        return appClickEventWrapper;
    }

    public C0120S<AppClickEventWrapper> pauseUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3765q.f7177a);
        C3744n nVar = C3744n.f7153a;
        $jacocoInit[100] = true;
        C0120S<AppClickEventWrapper> j = d.mo3669j(nVar);
        $jacocoInit[101] = true;
        return j;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m8221k(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.PAUSE_UPDATE) {
            $jacocoInit[243] = true;
        } else {
            $jacocoInit[244] = true;
            if (appClick.getClickType() == ClickType.APPC_UPGRADE_PAUSE) {
                $jacocoInit[245] = true;
            } else {
                z = false;
                $jacocoInit[247] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[248] = true;
                return valueOf;
            }
        }
        $jacocoInit[246] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[248] = true;
        return valueOf2;
    }

    /* renamed from: l */
    static /* synthetic */ AppClickEventWrapper m8222l(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[239] = true;
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_PAUSE) {
            $jacocoInit[240] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[241] = true;
        }
        AppClickEventWrapper appClickEventWrapper = new AppClickEventWrapper(z, appClick.getApp());
        $jacocoInit[242] = true;
        return appClickEventWrapper;
    }

    public C0120S<AppClickEventWrapper> cancelUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3751o.f7161a);
        C3523F f = C3523F.f6904a;
        $jacocoInit[102] = true;
        C0120S<AppClickEventWrapper> j = d.mo3669j(f);
        $jacocoInit[103] = true;
        return j;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8213c(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.CANCEL_UPDATE) {
            $jacocoInit[233] = true;
        } else {
            $jacocoInit[234] = true;
            if (appClick.getClickType() == ClickType.APPC_UPGRADE_CANCEL) {
                $jacocoInit[235] = true;
            } else {
                z = false;
                $jacocoInit[237] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[238] = true;
                return valueOf;
            }
        }
        $jacocoInit[236] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[238] = true;
        return valueOf2;
    }

    /* renamed from: d */
    static /* synthetic */ AppClickEventWrapper m8214d(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[229] = true;
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_CANCEL) {
            $jacocoInit[230] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[231] = true;
        }
        AppClickEventWrapper appClickEventWrapper = new AppClickEventWrapper(z, appClick.getApp());
        $jacocoInit[232] = true;
        return appClickEventWrapper;
    }

    public C0120S<AppClickEventWrapper> resumeUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3517E.f6898a);
        C3490A a = C3490A.f6870a;
        $jacocoInit[104] = true;
        C0120S<AppClickEventWrapper> j = d.mo3669j(a);
        $jacocoInit[105] = true;
        return j;
    }

    /* renamed from: o */
    static /* synthetic */ Boolean m8225o(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.RESUME_UPDATE) {
            $jacocoInit[223] = true;
        } else {
            $jacocoInit[224] = true;
            if (appClick.getClickType() == ClickType.APPC_UPGRADE_RESUME) {
                $jacocoInit[225] = true;
            } else {
                z = false;
                $jacocoInit[227] = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[228] = true;
                return valueOf;
            }
        }
        $jacocoInit[226] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[228] = true;
        return valueOf2;
    }

    /* renamed from: p */
    static /* synthetic */ AppClickEventWrapper m8226p(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[219] = true;
        if (appClick.getClickType() == ClickType.APPC_UPGRADE_RESUME) {
            $jacocoInit[220] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[221] = true;
        }
        AppClickEventWrapper appClickEventWrapper = new AppClickEventWrapper(z, appClick.getApp());
        $jacocoInit[222] = true;
        return appClickEventWrapper;
    }

    public C0120S<Boolean> showRootWarning() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[106] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.root_access_dialog, getResources(), new Object[0]);
        $jacocoInit[107] = true;
        C0120S createGenericYesNoCancelMessage = GenericDialogs.createGenericYesNoCancelMessage(context, "", formattedString);
        C3702h hVar = C3702h.f7105a;
        $jacocoInit[108] = true;
        C0120S<Boolean> j = createGenericYesNoCancelMessage.mo3669j(hVar);
        $jacocoInit[109] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8210a(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(response.equals(EResponse.YES));
        $jacocoInit[218] = true;
        return valueOf;
    }

    public void showUpdatesDownloadList(List<App> updatesDownloadList) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[110] = true;
        instance.mo2136d("Apps", "showing updates observable list");
        $jacocoInit[111] = true;
        if (updatesDownloadList == null) {
            $jacocoInit[112] = true;
        } else if (updatesDownloadList.isEmpty()) {
            $jacocoInit[113] = true;
        } else {
            $jacocoInit[114] = true;
            this.adapter.addUpdateAppsList(updatesDownloadList);
            $jacocoInit[115] = true;
        }
        if (!shouldShowAppsList()) {
            $jacocoInit[116] = true;
        } else {
            $jacocoInit[117] = true;
            showAppsList();
            $jacocoInit[118] = true;
        }
        $jacocoInit[119] = true;
    }

    public void showAppcUpgradesDownloadList(List<App> updatesDownloadList) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[120] = true;
        instance.mo2136d("Apps", "showing appc upgrades observable list");
        $jacocoInit[121] = true;
        if (updatesDownloadList == null) {
            $jacocoInit[122] = true;
        } else if (updatesDownloadList.isEmpty()) {
            $jacocoInit[123] = true;
        } else {
            $jacocoInit[124] = true;
            this.appcAppsAdapter.addApps(updatesDownloadList);
            $jacocoInit[125] = true;
        }
        triggerAppcUpgradesVisibility(this.appcAppsAdapter.getTotalItemCount());
        $jacocoInit[126] = true;
    }

    public C0120S<Void> updateAll() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.updateAll;
        $jacocoInit[127] = true;
        return cVar;
    }

    public C0120S<App> updateLongClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3505C.f6884a);
        C3529G g = C3529G.f6910a;
        $jacocoInit[128] = true;
        C0120S<App> j = d.mo3669j(g);
        $jacocoInit[129] = true;
        return j;
    }

    /* renamed from: w */
    static /* synthetic */ Boolean m8233w(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.UPDATE_CARD_LONG_CLICK) {
            $jacocoInit[215] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[216] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[217] = true;
        return valueOf;
    }

    /* renamed from: x */
    static /* synthetic */ App m8234x(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[214] = true;
        return app;
    }

    public void showIgnoreUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        this.ignoreUpdateDialog.show();
        $jacocoInit[130] = true;
    }

    public C0120S<Void> ignoreUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S positiveClicks = this.ignoreUpdateDialog.positiveClicks();
        C3716j jVar = C3716j.f7123a;
        $jacocoInit[131] = true;
        C0120S<Void> j = positiveClicks.mo3669j(jVar);
        $jacocoInit[132] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Void m8211a(DialogInterface __) {
        $jacocoInit()[213] = true;
        return null;
    }

    public void showUnknownErrorMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1623a(getView(), (int) C1375R.string.unknown_error, -1);
        $jacocoInit[133] = true;
        a.mo4690h();
        $jacocoInit[134] = true;
    }

    public void removeExcludedUpdates(List<App> excludedUpdatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.removeUpdatesList(excludedUpdatesList);
        $jacocoInit[135] = true;
    }

    public C0120S<Void> moreAppcClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.appcSeeMoreButton);
        $jacocoInit[136] = true;
        return a;
    }

    public C0120S<App> cardClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.appItemClicks.mo3653d((C0132p<? super T, Boolean>) C3723k.f7131a);
        C3807x xVar = C3807x.f7219a;
        $jacocoInit[137] = true;
        C0120S<App> j = d.mo3669j(xVar);
        $jacocoInit[138] = true;
        return j;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8215e(AppClick appClick) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (appClick.getClickType() == ClickType.CARD_CLICK) {
            $jacocoInit[210] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[211] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[212] = true;
        return valueOf;
    }

    /* renamed from: f */
    static /* synthetic */ App m8216f(AppClick appClick) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = appClick.getApp();
        $jacocoInit[209] = true;
        return app;
    }

    public void setUserImage(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[139] = true;
        with.loadWithShadowCircleTransformWithPlaceholder(userAvatarUrl, imageView, C1375R.drawable.ic_account_circle);
        $jacocoInit[140] = true;
    }

    public void showAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.userAvatar.setVisibility(0);
        $jacocoInit[141] = true;
    }

    public C0120S<Void> imageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.userAvatar);
        $jacocoInit[142] = true;
        return a;
    }

    public void removeInstalledDownloads(List<App> installedDownloadsList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.removeInstalledDownloads(installedDownloadsList);
        $jacocoInit[143] = true;
    }

    public void scrollToTop() {
        boolean[] $jacocoInit = $jacocoInit();
        LinearLayoutManager layoutManager = (LinearLayoutManager) this.recyclerView.getLayoutManager();
        $jacocoInit[144] = true;
        if (layoutManager.findLastVisibleItemPosition() <= 10) {
            $jacocoInit[145] = true;
        } else {
            $jacocoInit[146] = true;
            this.recyclerView.mo7618i(10);
            $jacocoInit[147] = true;
        }
        this.recyclerView.mo7622j(0);
        $jacocoInit[148] = true;
    }

    public C0120S<Void> refreshApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13016e.m42477a(this.swipeRefreshLayout);
        $jacocoInit[149] = true;
        return a;
    }

    public void hidePullToRefresh() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.swipeRefreshLayout.mo5859b()) {
            $jacocoInit[150] = true;
        } else {
            $jacocoInit[151] = true;
            this.swipeRefreshLayout.setRefreshing(false);
            $jacocoInit[152] = true;
        }
        $jacocoInit[153] = true;
    }

    public void removeCanceledAppDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.removeCanceledAppDownload(app);
        $jacocoInit[154] = true;
    }

    public void removeAppcCanceledAppDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcAppsAdapter.removeCanceledAppDownload(app);
        $jacocoInit[155] = true;
        triggerAppcUpgradesVisibility(this.appcAppsAdapter.getTotalItemCount());
        $jacocoInit[156] = true;
    }

    public void setStandbyState(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.setAppStandby(app);
        $jacocoInit[157] = true;
    }

    public void setAppcStandbyState(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcAppsAdapter.setAppStandby(app);
        $jacocoInit[158] = true;
    }

    public void showIndeterminateAllUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[159] = true;
        instance.mo2136d("Apps", "show indeterminate all uploads");
        $jacocoInit[160] = true;
        this.adapter.setAllUpdatesIndeterminate();
        $jacocoInit[161] = true;
    }

    public void setDefaultUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[162] = true;
        with.loadUsingCircleTransform((int) C1375R.drawable.ic_account_circle, imageView);
        $jacocoInit[163] = true;
    }

    public void setPausingDownloadState(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.setAppOnPausing(app);
        $jacocoInit[164] = true;
    }

    public void setAppcPausingDownloadState(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcAppsAdapter.setAppOnPausing(app);
        $jacocoInit[165] = true;
    }

    public void showAppcUpgradesList(List<App> list) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[166] = true;
        instance.mo2136d("Apps", "showing appc upgrades list");
        $jacocoInit[167] = true;
        if (list == null) {
            $jacocoInit[168] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[169] = true;
        } else {
            $jacocoInit[170] = true;
            this.appcAppsAdapter.setAvailableUpgradesList(list);
            $jacocoInit[171] = true;
        }
        this.showUpgrades = true;
        $jacocoInit[172] = true;
        this.appcUpgradesSectionLoaded.onNext(null);
        $jacocoInit[173] = true;
        if (!shouldShowAppsList()) {
            $jacocoInit[174] = true;
        } else {
            $jacocoInit[175] = true;
            showAppsList();
            $jacocoInit[176] = true;
        }
        $jacocoInit[177] = true;
    }

    public void removeExcludedAppcUpgrades(List<App> excludedUpdatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcAppsAdapter.removeAppcUpgradesList(excludedUpdatesList);
        $jacocoInit[178] = true;
        triggerAppcUpgradesVisibility(this.appcAppsAdapter.getTotalItemCount());
        $jacocoInit[179] = true;
    }

    public C0120S<Void> onLoadAppcUpgradesSection() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.appcUpgradesSectionLoaded;
        $jacocoInit[180] = true;
        return cVar;
    }

    public C0120S<Void> onLoadUpdatesSection() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.updatesSectionLoaded;
        $jacocoInit[181] = true;
        return cVar;
    }

    private void showAppsList() {
        boolean[] $jacocoInit = $jacocoInit();
        this.recyclerView.mo7618i(0);
        $jacocoInit[182] = true;
        hideLoadingProgressBar();
        $jacocoInit[183] = true;
        triggerAppcUpgradesVisibility(this.appcAppsAdapter.getTotalItemCount());
        $jacocoInit[184] = true;
        this.recyclerView.setVisibility(0);
        $jacocoInit[185] = true;
        Logger instance = Logger.getInstance();
        $jacocoInit[186] = true;
        instance.mo2136d("Apps", "showing apps lists");
        $jacocoInit[187] = true;
    }

    private void triggerAppcUpgradesVisibility(int itemCount) {
        boolean[] $jacocoInit = $jacocoInit();
        if (itemCount > 0) {
            $jacocoInit[188] = true;
            this.appcAppsRecyclerView.mo7618i(0);
            $jacocoInit[189] = true;
            hideLoadingProgressBar();
            $jacocoInit[190] = true;
            this.appcAppsLayout.setVisibility(0);
            if (itemCount > 2) {
                $jacocoInit[191] = true;
                this.appcSeeMoreButton.setVisibility(0);
                $jacocoInit[192] = true;
            } else {
                this.appcSeeMoreButton.setVisibility(8);
                $jacocoInit[193] = true;
            }
        } else {
            this.appcAppsLayout.setVisibility(8);
            $jacocoInit[194] = true;
        }
        $jacocoInit[195] = true;
    }

    private boolean shouldShowAppsList() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.showDownloads) {
            $jacocoInit[196] = true;
        } else if (!this.showUpdates) {
            $jacocoInit[197] = true;
        } else if (!this.showInstalled) {
            $jacocoInit[198] = true;
        } else if (!this.showUpgrades) {
            $jacocoInit[199] = true;
        } else {
            RecyclerView recyclerView2 = this.recyclerView;
            $jacocoInit[200] = true;
            if (recyclerView2.getVisibility() == 0) {
                $jacocoInit[201] = true;
            } else {
                $jacocoInit[202] = true;
                z = true;
                $jacocoInit[204] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[203] = true;
        $jacocoInit[204] = true;
        return z;
    }

    private void hideLoadingProgressBar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.progressBar.setVisibility(8);
        $jacocoInit[205] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        this.progressBar = null;
        this.swipeRefreshLayout = null;
        this.ignoreUpdateDialog = null;
        this.recyclerView = null;
        this.adapter = null;
        this.userAvatar = null;
        this.appcAppsLayout = null;
        this.appcAppsRecyclerView = null;
        this.appcAppsAdapter = null;
        $jacocoInit[206] = true;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[207] = true;
        super.onDetach();
        $jacocoInit[208] = true;
    }
}
