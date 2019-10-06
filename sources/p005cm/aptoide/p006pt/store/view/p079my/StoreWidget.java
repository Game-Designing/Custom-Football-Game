package p005cm.aptoide.p006pt.store.view.p079my;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.text.ParcelableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.view.MetaStoresBaseWidget;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowersFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowingFragment;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.spannable.SpannableFactory;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.store.view.my.StoreWidget */
public class StoreWidget extends MetaStoresBaseWidget<StoreDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Button exploreButton;
    private TextView firstStat;
    private TextView secondStat;
    private StoreAnalytics storeAnalytics;
    private ImageView storeIcon;
    private TextView storeName;
    private TextView suggestionMessage;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1401660460309063098L, "cm/aptoide/pt/store/view/my/StoreWidget", 80);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((StoreDisplayable) displayable, i);
        $jacocoInit[60] = true;
    }

    public StoreWidget(View itemView) {
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
        this.storeIcon = (ImageView) itemView.findViewById(C1375R.C1376id.store_icon);
        $jacocoInit[4] = true;
        this.storeName = (TextView) itemView.findViewById(C1375R.C1376id.store_name);
        $jacocoInit[5] = true;
        this.suggestionMessage = (TextView) itemView.findViewById(C1375R.C1376id.create_store_text);
        $jacocoInit[6] = true;
        this.firstStat = (TextView) itemView.findViewById(C1375R.C1376id.first_stat);
        $jacocoInit[7] = true;
        this.secondStat = (TextView) itemView.findViewById(C1375R.C1376id.second_stat);
        $jacocoInit[8] = true;
        this.exploreButton = (Button) itemView.findViewById(C1375R.C1376id.explore_button);
        $jacocoInit[9] = true;
    }

    public void bindView(StoreDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p context = getContext();
        $jacocoInit[10] = true;
        Store store = displayable.getStore();
        $jacocoInit[11] = true;
        showStoreDescription(displayable, context);
        $jacocoInit[12] = true;
        this.exploreButton.setText(displayable.getExploreButtonText());
        $jacocoInit[13] = true;
        Appearance appearance = store.getAppearance();
        $jacocoInit[14] = true;
        String storeTheme = appearance.getTheme();
        $jacocoInit[15] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[16] = true;
        with.loadWithShadowCircleTransform(store.getAvatar(), this.storeIcon);
        $jacocoInit[17] = true;
        this.storeName.setText(store.getName());
        $jacocoInit[18] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.exploreButton);
        C5034D d = new C5034D(this, store, storeTheme);
        $jacocoInit[19] = true;
        C0137ja c = a.mo3646c((C0129b<? super T>) d);
        $jacocoInit[20] = true;
        cVar.mo3713a(c);
        $jacocoInit[21] = true;
        showStats(displayable);
        $jacocoInit[22] = true;
        if (!displayable.isStatsClickable()) {
            $jacocoInit[23] = true;
        } else {
            $jacocoInit[24] = true;
            C0136c cVar2 = this.compositeSubscription;
            C0120S a2 = C13034a.m42490a(this.firstStat);
            C5035E e = new C5035E(this, storeTheme, displayable);
            $jacocoInit[25] = true;
            C0137ja c2 = a2.mo3646c((C0129b<? super T>) e);
            $jacocoInit[26] = true;
            cVar2.mo3713a(c2);
            $jacocoInit[27] = true;
            C0136c cVar3 = this.compositeSubscription;
            C0120S a3 = C13034a.m42490a(this.secondStat);
            C5033C c3 = new C5033C(this, storeTheme, displayable);
            $jacocoInit[28] = true;
            C0137ja c4 = a3.mo3646c((C0129b<? super T>) c3);
            $jacocoInit[29] = true;
            cVar3.mo3713a(c4);
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16697a(Store store, String storeTheme, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[75] = true;
        Fragment newStoreFragment = fragmentProvider.newStoreFragment(store.getName(), storeTheme);
        $jacocoInit[76] = true;
        fragmentNavigator.navigateTo(newStoreFragment, true);
        $jacocoInit[77] = true;
        this.storeAnalytics.sendStoreTabInteractEvent("View Store", false);
        $jacocoInit[78] = true;
        this.storeAnalytics.sendStoreOpenEvent("View Own Store", store.getName(), false);
        $jacocoInit[79] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16698a(String storeTheme, StoreDisplayable displayable, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAnalytics.sendFollowersStoresInteractEvent();
        $jacocoInit[68] = true;
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        $jacocoInit[69] = true;
        Resources resources = getContext().getResources();
        Object[] objArr = {Long.valueOf(displayable.getFirstStatsNumber())};
        $jacocoInit[70] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.social_timeline_followers_fragment_title, resources, objArr);
        $jacocoInit[71] = true;
        StoreContext storeContext = displayable.getStoreContext();
        $jacocoInit[72] = true;
        TimeLineFollowFragment newInstanceUsingUser = TimeLineFollowersFragment.newInstanceUsingUser(storeTheme, formattedString, storeContext);
        $jacocoInit[73] = true;
        fragmentNavigator.navigateTo(newInstanceUsingUser, true);
        $jacocoInit[74] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16699b(String storeTheme, StoreDisplayable displayable, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAnalytics.sendFollowingStoresInteractEvent();
        $jacocoInit[61] = true;
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        $jacocoInit[62] = true;
        Resources resources = getContext().getResources();
        Object[] objArr = {Long.valueOf(displayable.getSecondStatsNumber())};
        $jacocoInit[63] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.social_timeline_following_fragment_title, resources, objArr);
        $jacocoInit[64] = true;
        StoreContext storeContext = displayable.getStoreContext();
        $jacocoInit[65] = true;
        TimeLineFollowFragment newInstanceUsingUser = TimeLineFollowingFragment.newInstanceUsingUser(storeTheme, formattedString, storeContext);
        $jacocoInit[66] = true;
        fragmentNavigator.navigateTo(newInstanceUsingUser, true);
        $jacocoInit[67] = true;
    }

    private void showStoreDescription(StoreDisplayable displayable, C0014p context) {
        boolean[] $jacocoInit = $jacocoInit();
        String message = displayable.getSuggestionMessage(context);
        $jacocoInit[32] = true;
        if (message.isEmpty()) {
            $jacocoInit[33] = true;
            this.suggestionMessage.setVisibility(8);
            $jacocoInit[34] = true;
        } else {
            this.suggestionMessage.setText(message);
            $jacocoInit[35] = true;
            this.suggestionMessage.setVisibility(0);
            $jacocoInit[36] = true;
        }
        $jacocoInit[37] = true;
    }

    private void showStats(StoreDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        SpannableFactory spannableFactory = new SpannableFactory();
        $jacocoInit[38] = true;
        $jacocoInit[39] = true;
        ParcelableSpan[] textStyle = {new StyleSpan(1), new ForegroundColorSpan(getTextColor())};
        $jacocoInit[40] = true;
        String string = getContext().getString(displayable.getFirstStatsLabel());
        $jacocoInit[41] = true;
        Object[] objArr = {String.valueOf(displayable.getFirstStatsNumber())};
        $jacocoInit[42] = true;
        String firstStatsText = String.format(string, objArr);
        TextView textView = this.firstStat;
        $jacocoInit[43] = true;
        String[] strArr = {String.valueOf(displayable.getFirstStatsNumber())};
        $jacocoInit[44] = true;
        textView.setText(spannableFactory.createMultiSpan(firstStatsText, textStyle, strArr));
        $jacocoInit[45] = true;
        String string2 = getContext().getString(displayable.getSecondStatsLabel());
        $jacocoInit[46] = true;
        Object[] objArr2 = {String.valueOf(displayable.getSecondStatsNumber())};
        $jacocoInit[47] = true;
        String secondStatsText = String.format(string2, objArr2);
        TextView textView2 = this.secondStat;
        $jacocoInit[48] = true;
        String[] strArr2 = {String.valueOf(displayable.getSecondStatsNumber())};
        $jacocoInit[49] = true;
        textView2.setText(spannableFactory.createMultiSpan(secondStatsText, textStyle, strArr2));
        $jacocoInit[50] = true;
    }

    private int getTextColor() {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p context = getContext();
        int i = VERSION.SDK_INT;
        String str = BuildConfig.APTOIDE_THEME;
        if (i >= 23) {
            $jacocoInit[51] = true;
            Resources resources = context.getResources();
            $jacocoInit[52] = true;
            StoreTheme storeTheme = StoreTheme.get(str);
            $jacocoInit[53] = true;
            int darkerColor = storeTheme.getDarkerColor();
            Theme theme = context.getTheme();
            $jacocoInit[54] = true;
            int color = resources.getColor(darkerColor, theme);
            $jacocoInit[55] = true;
            return color;
        }
        Resources resources2 = context.getResources();
        $jacocoInit[56] = true;
        StoreTheme storeTheme2 = StoreTheme.get(str);
        $jacocoInit[57] = true;
        int darkerColor2 = storeTheme2.getDarkerColor();
        $jacocoInit[58] = true;
        int color2 = resources2.getColor(darkerColor2);
        $jacocoInit[59] = true;
        return color2;
    }
}
