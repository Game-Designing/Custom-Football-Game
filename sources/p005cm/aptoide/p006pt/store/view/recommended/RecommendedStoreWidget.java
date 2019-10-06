package p005cm.aptoide.p006pt.store.view.recommended;

import android.content.res.Resources;
import android.support.p000v4.app.C0014p;
import android.support.p001v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Stats;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.store.view.recommended.RecommendedStoreWidget */
public class RecommendedStoreWidget extends Widget<RecommendedStoreDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppCompatButton followButton;
    private TextView followingUsers;
    private TextView numberStoreApps;
    private StoreAnalytics storeAnalytics;
    private ImageView storeIcon;
    private TextView storeName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4258222569157967242L, "cm/aptoide/pt/store/view/recommended/RecommendedStoreWidget", 84);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((RecommendedStoreDisplayable) displayable, i);
        $jacocoInit[35] = true;
    }

    public RecommendedStoreWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        NavigationTracker navigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = ((AptoideApplication) getContext().getApplicationContext()).getAnalyticsManager();
        $jacocoInit[2] = true;
        this.storeAnalytics = new StoreAnalytics(analyticsManager, navigationTracker);
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeName = (TextView) itemView.findViewById(C1375R.C1376id.recommended_store_name);
        $jacocoInit[4] = true;
        this.followingUsers = (TextView) itemView.findViewById(C1375R.C1376id.recommended_store_users);
        $jacocoInit[5] = true;
        this.numberStoreApps = (TextView) itemView.findViewById(C1375R.C1376id.recommended_store_apps);
        $jacocoInit[6] = true;
        this.storeIcon = (ImageView) itemView.findViewById(C1375R.C1376id.store_avatar_row);
        $jacocoInit[7] = true;
        this.followButton = (AppCompatButton) itemView.findViewById(C1375R.C1376id.recommended_store_action);
        $jacocoInit[8] = true;
    }

    public void bindView(RecommendedStoreDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = (Store) displayable.getPojo();
        $jacocoInit[9] = true;
        this.storeName.setText(store.getName());
        $jacocoInit[10] = true;
        TextView textView = this.followingUsers;
        Stats stats = store.getStats();
        $jacocoInit[11] = true;
        int subscribers = stats.getSubscribers();
        $jacocoInit[12] = true;
        textView.setText(String.valueOf(subscribers));
        $jacocoInit[13] = true;
        TextView textView2 = this.numberStoreApps;
        Stats stats2 = store.getStats();
        $jacocoInit[14] = true;
        int apps = stats2.getApps();
        $jacocoInit[15] = true;
        textView2.setText(String.valueOf(apps));
        $jacocoInit[16] = true;
        C0014p context = getContext();
        $jacocoInit[17] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[18] = true;
        with.loadUsingCircleTransform(store.getAvatar(), this.storeIcon);
        $jacocoInit[19] = true;
        setFollowButtonListener(displayable);
        $jacocoInit[20] = true;
        setButtonText(displayable);
        $jacocoInit[21] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C5078g gVar = new C5078g(this, displayable, store);
        C5075d dVar = C5075d.f8766a;
        $jacocoInit[22] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) gVar, (C0129b<Throwable>) dVar);
        $jacocoInit[23] = true;
        cVar.mo3713a(a2);
        $jacocoInit[24] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16710a(RecommendedStoreDisplayable displayable, Store store, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        displayable.openStoreFragment(getFragmentNavigator());
        $jacocoInit[76] = true;
        String origin = displayable.getOrigin();
        $jacocoInit[77] = true;
        if (!origin.isEmpty()) {
            $jacocoInit[78] = true;
            this.storeAnalytics.sendStoreOpenEvent(displayable.getOrigin(), store.getName(), false);
            $jacocoInit[79] = true;
            this.storeAnalytics.sendStoreTabInteractEvent("More Recommended Stores", false);
            $jacocoInit[80] = true;
        } else {
            this.storeAnalytics.sendStoreOpenEvent("Recommended Stores", store.getName(), false);
            $jacocoInit[81] = true;
            this.storeAnalytics.sendStoreTabInteractEvent("Open a Recommended Store", false);
            $jacocoInit[82] = true;
        }
        $jacocoInit[83] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9405a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[74] = true;
        instance.log(throwable);
        $jacocoInit[75] = true;
    }

    private void setFollowButtonListener(RecommendedStoreDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.followButton);
        C5073b bVar = new C5073b(this, displayable);
        $jacocoInit[25] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) bVar);
        $jacocoInit[26] = true;
        C0120S a2 = f.mo3616a(C14522a.m46170a());
        C5072a aVar = new C5072a(this, displayable);
        C5074c cVar2 = new C5074c(this);
        $jacocoInit[27] = true;
        C0137ja a3 = a2.mo3626a((C0129b<? super T>) aVar, (C0129b<Throwable>) cVar2);
        $jacocoInit[28] = true;
        cVar.mo3713a(a3);
        $jacocoInit[29] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16709a(RecommendedStoreDisplayable displayable, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followButton.setEnabled(false);
        StoreAnalytics storeAnalytics2 = this.storeAnalytics;
        $jacocoInit[57] = true;
        Store store = (Store) displayable.getPojo();
        $jacocoInit[58] = true;
        Stats stats = store.getStats();
        $jacocoInit[59] = true;
        int apps = stats.getApps();
        Store store2 = (Store) displayable.getPojo();
        $jacocoInit[60] = true;
        Stats stats2 = store2.getStats();
        $jacocoInit[61] = true;
        int subscribers = stats2.getSubscribers();
        $jacocoInit[62] = true;
        storeAnalytics2.sendStoreTabInteractEvent("Follow a Recommended Store", apps, subscribers);
        $jacocoInit[63] = true;
        C0120S isFollowing = displayable.isFollowing();
        $jacocoInit[64] = true;
        C0120S d = isFollowing.mo3647d();
        $jacocoInit[65] = true;
        C0120S a = d.mo3616a(Schedulers.computation());
        C5077f fVar = new C5077f(this, displayable);
        $jacocoInit[66] = true;
        C0120S j = a.mo3669j(fVar);
        $jacocoInit[67] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo16708a(RecommendedStoreDisplayable displayable, Boolean isSubscribed) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (isSubscribed.booleanValue()) {
            $jacocoInit[68] = true;
            displayable.unsubscribeStore(getContext().getApplicationContext());
            $jacocoInit[69] = true;
        } else {
            displayable.subscribeStore();
            $jacocoInit[70] = true;
        }
        if (!isSubscribed.booleanValue()) {
            $jacocoInit[71] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[72] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[73] = true;
        return valueOf;
    }

    /* renamed from: c */
    public /* synthetic */ void mo16714c(RecommendedStoreDisplayable displayable, Boolean isSubscribing) {
        int message;
        boolean[] $jacocoInit = $jacocoInit();
        this.followButton.setEnabled(true);
        $jacocoInit[48] = true;
        if (isSubscribing.booleanValue()) {
            message = C1375R.string.store_followed;
            $jacocoInit[49] = true;
        } else {
            message = C1375R.string.unfollowing_store_message;
            $jacocoInit[50] = true;
        }
        View view = this.itemView;
        $jacocoInit[51] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[52] = true;
        Store store = (Store) displayable.getPojo();
        $jacocoInit[53] = true;
        Object[] objArr = {store.getName()};
        $jacocoInit[54] = true;
        String formattedString = StringU.getFormattedString(message, resources, objArr);
        $jacocoInit[55] = true;
        ShowMessage.asSnack(view, formattedString);
        $jacocoInit[56] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16712b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[45] = true;
        instance.log(throwable);
        $jacocoInit[46] = true;
        ShowMessage.asSnack(this.itemView, (int) C1375R.string.error_occured);
        $jacocoInit[47] = true;
    }

    private void setButtonText(RecommendedStoreDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followButton.setVisibility(8);
        $jacocoInit[30] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S isFollowing = displayable.isFollowing();
        $jacocoInit[31] = true;
        C0120S a = isFollowing.mo3616a(C14522a.m46170a());
        C5076e eVar = new C5076e(this, displayable);
        $jacocoInit[32] = true;
        C0137ja c = a.mo3646c((C0129b<? super T>) eVar);
        $jacocoInit[33] = true;
        cVar.mo3713a(c);
        $jacocoInit[34] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16711b(RecommendedStoreDisplayable displayable, Boolean isSubscribed) {
        int message;
        boolean[] $jacocoInit = $jacocoInit();
        if (isSubscribed.booleanValue()) {
            message = C1375R.string.followed;
            $jacocoInit[36] = true;
        } else {
            message = C1375R.string.follow;
            $jacocoInit[37] = true;
        }
        AppCompatButton appCompatButton = this.followButton;
        $jacocoInit[38] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[39] = true;
        Store store = (Store) displayable.getPojo();
        $jacocoInit[40] = true;
        Object[] objArr = {store.getName()};
        $jacocoInit[41] = true;
        String formattedString = StringU.getFormattedString(message, resources, objArr);
        $jacocoInit[42] = true;
        appCompatButton.setText(formattedString);
        $jacocoInit[43] = true;
        this.followButton.setVisibility(0);
        $jacocoInit[44] = true;
    }
}
